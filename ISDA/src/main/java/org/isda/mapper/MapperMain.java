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

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

/**
 * Full 7-phase pipeline:
 *   1. Read internal swap trade JSON        → SwapTrade
 *   2. Map to CDM TradeState                → TradeState
 *   3. Wrap in WorkflowStep                 → WorkflowStep
 *   4. Create ReportableEvent               → ReportableEvent
 *   5. Create TransactionReportInstruction   → TransactionReportInstruction
 *   6. Generate regime reports              → Map<regime, report>
 *   7. Project to submission XML/JSON       → files on disk
 */
public class MapperMain {

    private static final String INPUT_DIR = "data/input";
    private static final String OUTPUT_BASE = "data/output";

    public static void main(String[] args) throws IOException {
        File inputDir = new File(INPUT_DIR);
        File[] inputFiles = inputDir.listFiles((dir, name) -> name.endsWith(".json"));
        if (inputFiles == null || inputFiles.length == 0) {
            System.out.println("No input files found in " + INPUT_DIR);
            return;
        }

        System.out.println("Initialising DRR Guice injector...");
        Injector injector = Guice.createInjector(new DrrRuntimeModule());
        ReportInstructionMapper instructionMapper = new ReportInstructionMapper(injector);
        ReportGenerator reportGenerator = new ReportGenerator(injector);
        ProjectionMapper projectionMapper = new ProjectionMapper(injector);

        createDirs();

        int success = 0;
        int failed = 0;

        for (File inputFile : inputFiles) {
            String baseName = inputFile.getName().replace(".json", "");
            System.out.println("\n========== " + baseName + " ==========");

            try {
                // Phase 1 — read input
                SwapTrade trade = SwapTradeReader.readFromFile(inputFile.getAbsolutePath());
                System.out.println("  [1] Input read: " + trade.getProductType()
                        + " " + trade.getActionType() + "/" + trade.getEventType());

                // Phase 2 — CDM TradeState
                TradeState tradeState = TradeStateMapper.map(trade);
                writeJson(tradeState, OUTPUT_BASE + "/tradestate", baseName + "_TradeState.json");
                System.out.println("  [2] TradeState mapped");

                // Phase 3 — WorkflowStep
                WorkflowStep workflowStep = WorkflowStepMapper.map(trade, tradeState);
                writeJson(workflowStep, OUTPUT_BASE + "/workflowstep", baseName + "_WorkflowStep.json");
                System.out.println("  [3] WorkflowStep created");

                // Phase 4 — ReportableEvent
                ReportableEvent reportableEvent = ReportableEventMapper.map(trade, workflowStep, tradeState);
                writeJson(reportableEvent, OUTPUT_BASE + "/reportableevent", baseName + "_ReportableEvent.json");
                System.out.println("  [4] ReportableEvent created");

                // Phase 5 — TransactionReportInstruction
                TransactionReportInstruction instruction = instructionMapper.map(reportableEvent);
                writeJson(instruction, OUTPUT_BASE + "/instruction", baseName + "_TransactionReportInstruction.json");
                System.out.println("  [5] TransactionReportInstruction created");

                // Phase 6 — regime reports
                Map<String, RosettaModelObject> reports = reportGenerator.generateAll(instruction);
                for (Map.Entry<String, RosettaModelObject> entry : reports.entrySet()) {
                    String fileName = baseName + "_" + entry.getKey() + "_Report.json";
                    writeJson(entry.getValue(), OUTPUT_BASE + "/reports", fileName);
                }
                System.out.println("  [6] Reports generated: " + reports.keySet());

                // Phase 7 — projection to submission format
                Map<String, String> projections = projectionMapper.projectAll(reports);
                for (Map.Entry<String, String> entry : projections.entrySet()) {
                    String ext = isXml(entry.getValue()) ? ".xml" : ".json";
                    String fileName = baseName + "_" + entry.getKey() + "_Projection" + ext;
                    writeString(entry.getValue(), OUTPUT_BASE + "/projections", fileName);
                }
                System.out.println("  [7] Projections created: " + projections.keySet());

                success++;

            } catch (Exception e) {
                System.err.println("  FAILED: " + e.getMessage());
                e.printStackTrace(System.err);
                failed++;
            }
        }

        System.out.println("\n===== SUMMARY =====");
        System.out.println("Processed: " + (success + failed));
        System.out.println("Succeeded: " + success);
        System.out.println("Failed:    " + failed);
    }

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
        System.out.println("    → " + path);
    }

    private static boolean isXml(String content) {
        return content != null && content.trim().startsWith("<");
    }
}
