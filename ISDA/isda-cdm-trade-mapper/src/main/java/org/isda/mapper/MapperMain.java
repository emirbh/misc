package org.isda.mapper;

import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.regnosys.drr.DrrRuntimeModule;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapper;
import com.rosetta.model.lib.RosettaModelObject;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.TransactionReportInstruction;
import org.isda.mapper.fpml.FpmlPreprocessor;
import org.isda.mapper.fpml.FpmlSwapTradeReader;
import org.isda.mapper.fpml.IdentityPreprocessor;
import org.isda.mapper.fpml.XsltPreprocessor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

/**
 * Full 7-phase pipeline. Input modes:
 *
 *   java MapperMain                                      — JSON files from data/input/
 *   java MapperMain --csv trades.csv                     — stream rows from CSV
 *   java MapperMain --fpml data/input/fpml/              — FpML XML files from directory
 *   java MapperMain --fpml dir/ --preprocessor citiml    — proprietary XML via XSLT preprocessor
 */
public class MapperMain {

    private static final String INPUT_DIR = "data/input";
    private static final String OUTPUT_BASE = "data/output";

    public static void main(String[] args) throws Exception {
        System.out.println("Initialising DRR Guice injector...");
        Injector injector = Guice.createInjector(new DrrRuntimeModule());
        ReportInstructionMapper instructionMapper = new ReportInstructionMapper(injector);
        ReportGenerator reportGenerator = new ReportGenerator(injector);
        ProjectionMapper projectionMapper = new ProjectionMapper(injector);

        createDirs();

        String mode = args.length >= 1 ? args[0] : "--json";

        switch (mode) {
            case "--csv":
                requireArg(args, 1, "--csv requires a file path");
                runCsv(args[1], instructionMapper, reportGenerator, projectionMapper);
                break;

            case "--fpml":
                requireArg(args, 1, "--fpml requires a directory path");
                FpmlPreprocessor preprocessor = resolvePreprocessor(args);
                runFpml(args[1], preprocessor, instructionMapper, reportGenerator, projectionMapper);
                break;

            case "--json":
            default:
                runJsonDir(instructionMapper, reportGenerator, projectionMapper);
                break;
        }
    }

    private static void requireArg(String[] args, int index, String message) {
        if (args.length <= index) {
            System.err.println(message);
            System.exit(1);
        }
    }

    /**
     * Resolves the preprocessor from --preprocessor name.
     * Looks for an XSLT file at config/{name}-to-fpml.xslt.
     */
    private static FpmlPreprocessor resolvePreprocessor(String[] args) {
        String name = getFlag(args, "--preprocessor");
        if (name == null) {
            return new IdentityPreprocessor();
        }

        Path xsltPath = Path.of("config", name + "-to-fpml.xslt");
        if (!Files.exists(xsltPath)) {
            System.err.println("XSLT not found: " + xsltPath);
            System.err.println("Create " + xsltPath + " with the transform rules for " + name);
            System.exit(1);
        }

        System.out.println("Using preprocessor: " + name + " (" + xsltPath + ")");
        return new XsltPreprocessor(name, xsltPath);
    }

    private static String getFlag(String[] args, String flag) {
        for (int i = 0; i < args.length - 1; i++) {
            if (flag.equals(args[i])) {
                return args[i + 1];
            }
        }
        return null;
    }

    // --- Input modes ---

    private static void runJsonDir(ReportInstructionMapper instructionMapper,
                                   ReportGenerator reportGenerator,
                                   ProjectionMapper projectionMapper) throws IOException {
        File inputDir = new File(INPUT_DIR);
        File[] inputFiles = inputDir.listFiles((dir, name) -> name.endsWith(".json"));
        if (inputFiles == null || inputFiles.length == 0) {
            System.out.println("No input files found in " + INPUT_DIR);
            return;
        }

        int success = 0, failed = 0;

        for (File inputFile : inputFiles) {
            String baseName = inputFile.getName().replace(".json", "");
            SwapTrade trade = SwapTradeReader.readFromFile(inputFile.getAbsolutePath());
            Result r = processTrade(baseName, trade, instructionMapper, reportGenerator, projectionMapper);
            if (r == Result.OK) success++;
            else failed++;
        }

        printSummary(success, failed);
    }

    private static void runCsv(String csvPath,
                               ReportInstructionMapper instructionMapper,
                               ReportGenerator reportGenerator,
                               ProjectionMapper projectionMapper) throws IOException {
        System.out.println("Reading CSV: " + csvPath);
        long startTime = System.currentTimeMillis();
        int success = 0, failed = 0;

        try (CsvSwapTradeReader csv = new CsvSwapTradeReader(Path.of(csvPath))) {
            for (SwapTrade trade : csv) {
                String baseName = trade.getTradeId() + "_v" + trade.getTradeVersion();
                Result r = processTrade(baseName, trade, instructionMapper, reportGenerator, projectionMapper);
                if (r == Result.OK) success++;
                else failed++;

                int total = success + failed;
                if (total % 1000 == 0) {
                    long elapsed = System.currentTimeMillis() - startTime;
                    System.out.printf("  ... %,d rows processed (%,d ms, %.0f rows/sec)%n",
                            total, elapsed, total * 1000.0 / elapsed);
                }
            }
        }

        long elapsed = System.currentTimeMillis() - startTime;
        printSummary(success, failed);
        System.out.printf("Elapsed: %,d ms%n", elapsed);
    }

    private static void runFpml(String fpmlDir,
                                FpmlPreprocessor preprocessor,
                                ReportInstructionMapper instructionMapper,
                                ReportGenerator reportGenerator,
                                ProjectionMapper projectionMapper) throws Exception {
        System.out.println("Reading FpML from: " + fpmlDir
                + " (preprocessor: " + preprocessor.name() + ")");

        FpmlSwapTradeReader reader = new FpmlSwapTradeReader(preprocessor);
        List<SwapTrade> trades = reader.readDirectory(Path.of(fpmlDir));

        if (trades.isEmpty()) {
            System.out.println("No FpML files found in " + fpmlDir);
            return;
        }

        int success = 0, failed = 0;

        for (SwapTrade trade : trades) {
            String baseName = trade.getTradeId() != null
                    ? trade.getTradeId() + "_v" + trade.getTradeVersion()
                    : "fpml_" + (success + failed + 1);
            Result r = processTrade(baseName, trade, instructionMapper, reportGenerator, projectionMapper);
            if (r == Result.OK) success++;
            else failed++;
        }

        printSummary(success, failed);
    }

    // --- Shared pipeline ---

    private static Result processTrade(String baseName, SwapTrade trade,
                                       ReportInstructionMapper instructionMapper,
                                       ReportGenerator reportGenerator,
                                       ProjectionMapper projectionMapper) {
        System.out.println("\n========== " + baseName + " ==========");
        try {
            System.out.println("  [1] Input: " + trade.getProductType()
                    + " " + trade.getActionType() + "/" + trade.getEventType());

            TradeState tradeState = TradeStateMapper.map(trade);
            writeJson(tradeState, OUTPUT_BASE + "/tradestate", baseName + "_TradeState.json");
            System.out.println("  [2] TradeState mapped");

            WorkflowStep workflowStep = WorkflowStepMapper.map(trade, tradeState);
            writeJson(workflowStep, OUTPUT_BASE + "/workflowstep", baseName + "_WorkflowStep.json");
            System.out.println("  [3] WorkflowStep created");

            ReportableEvent reportableEvent = ReportableEventMapper.map(trade, workflowStep, tradeState);
            writeJson(reportableEvent, OUTPUT_BASE + "/reportableevent", baseName + "_ReportableEvent.json");
            System.out.println("  [4] ReportableEvent created");

            TransactionReportInstruction instruction = instructionMapper.map(reportableEvent);
            writeJson(instruction, OUTPUT_BASE + "/instruction", baseName + "_TransactionReportInstruction.json");
            System.out.println("  [5] TransactionReportInstruction created");

            Map<String, RosettaModelObject> reports = reportGenerator.generateAll(instruction);
            for (Map.Entry<String, RosettaModelObject> entry : reports.entrySet()) {
                writeJson(entry.getValue(), OUTPUT_BASE + "/reports",
                        baseName + "_" + entry.getKey() + "_Report.json");
            }
            System.out.println("  [6] Reports generated: " + reports.keySet());

            Map<String, String> projections = projectionMapper.projectAll(reports);
            for (Map.Entry<String, String> entry : projections.entrySet()) {
                String ext = isXml(entry.getValue()) ? ".xml" : ".json";
                writeString(entry.getValue(), OUTPUT_BASE + "/projections",
                        baseName + "_" + entry.getKey() + "_Projection" + ext);
            }
            System.out.println("  [7] Projections created: " + projections.keySet());

            return Result.OK;

        } catch (Exception e) {
            System.err.println("  FAILED: " + e.getMessage());
            e.printStackTrace(System.err);
            return Result.FAILED;
        }
    }

    private enum Result { OK, FAILED }

    private static void createDirs() {
        new File(OUTPUT_BASE + "/tradestate").mkdirs();
        new File(OUTPUT_BASE + "/workflowstep").mkdirs();
        new File(OUTPUT_BASE + "/reportableevent").mkdirs();
        new File(OUTPUT_BASE + "/instruction").mkdirs();
        new File(OUTPUT_BASE + "/reports").mkdirs();
        new File(OUTPUT_BASE + "/projections").mkdirs();
    }

    private static void writeJson(RosettaModelObject obj, String dir, String fileName) throws IOException {
        String json = RosettaObjectMapper.getNewRosettaObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(obj);
        writeString(json, dir, fileName);
    }

    private static void writeString(String content, String dir, String fileName) throws IOException {
        Path path = Path.of(dir, fileName);
        Files.writeString(path, content, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private static boolean isXml(String content) {
        return content != null && content.trim().startsWith("<");
    }

    private static void printSummary(int success, int failed) {
        System.out.println("\n===== SUMMARY =====");
        System.out.println("Processed: " + (success + failed));
        System.out.println("Succeeded: " + success);
        System.out.println("Failed:    " + failed);
    }
}
