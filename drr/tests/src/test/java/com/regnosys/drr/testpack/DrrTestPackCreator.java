package com.regnosys.drr.testpack;

import com.google.common.base.Stopwatch;
import com.google.inject.AbstractModule;
import drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions.Project_CftcPart43TradeReportToDtccRdsHarmonized;
import drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions.Project_CftcPart45TradeReportToDtccRdsHarmonized;
import drr.projection.dtcc.rds.harmonized.cftc.rewrite.valuation.functions.Project_CFTCValuationReportToDtccRdsHarmonized;
import drr.projection.iso20022.esma.emir.refit.valuation.functions.Project_EsmaEmirValuationReportToIso20022;
import drr.projection.iso20022.fca.ukemir.refit.valuation.functions.Project_FcaUkEmirValuationReportToIso20022;
import drr.projection.iso20022.jfsa.rewrite.valuation.functions.Project_JFSARewriteValuationReportToIso20022;
import drr.regulation.cftc.rewrite.margin.reports.CFTCMarginReportFunction;
import drr.regulation.cftc.rewrite.valuation.reports.CFTCValuationReportFunction;
import drr.regulation.jfsa.rewrite.valuation.reports.JFSAValuationReportFunction;
import drr.regulation.esma.emir.refit.valuation.reports.ESMAEMIRValuationReportFunction;
import drr.regulation.fca.ukemir.refit.valuation.reports.FCAUKEMIRValuationReportFunction;
import drr.regulation.sec.rewrite.trade.reports.SECTradeReportFunction;
import drr.standards.iosco.cde.version3.reports.CPMI_IOSCOCDEReportFunction;
import jakarta.inject.Inject;
import com.google.inject.Injector;
import com.regnosys.drr.report.ReportTestRuntimeModule;
import com.regnosys.rosetta.common.reports.RegReportPaths;
import com.regnosys.rosetta.common.transform.TransformType;
import com.regnosys.testing.pipeline.PipelineConfigWriter;
import com.regnosys.testing.pipeline.PipelineTreeConfig;
import com.regnosys.testing.reports.ObjectMapperGenerator;

import drr.projection.dtcc.rds.harmonized.csa.rewrite.trade.functions.Project_CSATradeReportToDtccRdsHarmonized;
import drr.projection.dtcc.rds.harmonized.csa.rewrite.trade.functions.Project_CsaPpdReportToDtccRdsHarmonized;
import drr.projection.dtcc.rds.harmonized.csa.rewrite.valuation.functions.Project_CSAValuationReportToDtccRdsHarmonized;
import drr.projection.iso20022.asic.rewrite.margin.functions.Project_ASICMarginReportToIso20022;
import drr.projection.iso20022.asic.rewrite.trade.functions.Project_ASICTradeReportToIso20022;
import drr.projection.iso20022.asic.rewrite.valuation.functions.Project_ASICValuationReportToIso20022;
import drr.projection.iso20022.esma.emir.refit.margin.functions.Project_EsmaEmirMarginReportToIso20022;
import drr.projection.iso20022.esma.emir.refit.trade.functions.Project_EsmaEmirTradeReportToIso20022;
import drr.projection.iso20022.fca.ukemir.refit.margin.functions.Project_FcaUkEmirMarginReportToIso20022;
import drr.projection.iso20022.fca.ukemir.refit.trade.functions.Project_FcaUkEmirTradeReportToIso20022;
import drr.projection.iso20022.hkma.rewrite.margin.dtcc.functions.Project_HKMADtccMarginReportToIso20022;
import drr.projection.iso20022.hkma.rewrite.margin.tr.functions.Project_HKMATrMarginReportToIso20022;
import drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions.Project_HKMADtccTradeReportToIso20022;
import drr.projection.iso20022.hkma.rewrite.trade.tr.functions.Project_HKMATrTradeReportToIso20022;
import drr.projection.iso20022.hkma.rewrite.valuation.dtcc.functions.Project_HKMADtccValuationReportToIso20022;
import drr.projection.iso20022.hkma.rewrite.valuation.tr.functions.Project_HKMATrValuationReportToIso20022;
import drr.projection.iso20022.jfsa.rewrite.margin.functions.Project_JFSARewriteMarginReportToIso20022;
import drr.projection.iso20022.jfsa.rewrite.trade.functions.Project_JFSARewriteTradeReportToIso20022;
import drr.projection.iso20022.mas.rewrite.margin.functions.Project_MASMarginReportToIso20022;
import drr.projection.iso20022.mas.rewrite.trade.functions.Project_MASTradeReportToIso20022;
import drr.projection.iso20022.mas.rewrite.valuation.functions.Project_MASValuationReportToIso20022;
import drr.regulation.asic.rewrite.margin.reports.ASICMarginReportFunction;
import drr.regulation.asic.rewrite.trade.reports.ASICTradeReportFunction;
import drr.regulation.asic.rewrite.valuation.reports.ASICValuationReportFunction;
import drr.regulation.cftc.rewrite.trade.reports.CFTCPart43ReportFunction;
import drr.regulation.cftc.rewrite.trade.reports.CFTCPart45ReportFunction;
import drr.regulation.csa.rewrite.margin.reports.CSAMarginReportFunction;
import drr.regulation.csa.rewrite.trade.reports.CSAPPDReportFunction;
import drr.regulation.csa.rewrite.trade.reports.CSATradeReportFunction;
import drr.regulation.csa.rewrite.valuation.reports.CSAValuationReportFunction;
import drr.regulation.esma.emir.refit.margin.reports.ESMAEMIRMarginReportFunction;
import drr.regulation.esma.emir.refit.trade.reports.ESMAEMIRTradeReportFunction;
import drr.regulation.fca.ukemir.refit.margin.reports.FCAUKEMIRMarginReportFunction;
import drr.regulation.fca.ukemir.refit.trade.reports.FCAUKEMIRTradeReportFunction;
import drr.regulation.hkma.rewrite.margin.reports.HKMAMarginReportFunction;
import drr.regulation.hkma.rewrite.trade.reports.HKMATradeReportFunction;
import drr.regulation.hkma.rewrite.valuation.reports.HKMAValuationReportFunction;
import drr.regulation.jfsa.rewrite.margin.reports.JFSAMarginReportFunction;
import drr.regulation.jfsa.rewrite.trade.reports.JFSATradeReportFunction;
import drr.regulation.mas.rewrite.margin.reports.MASMarginReportFunction;
import drr.regulation.mas.rewrite.trade.reports.MASTradeReportFunction;
import drr.regulation.mas.rewrite.valuation.reports.MASValuationReportFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Predicate;

import static com.regnosys.testing.TestingExpectationUtil.TEST_WRITE_BASE_PATH;
import static com.regnosys.testing.pipeline.PipelineFilter.startsWith;
import static iso20022.Iso20022ModelConfig.TYPE_TO_SCHEMA_MAP;
import static iso20022.Iso20022ModelConfig.TYPE_TO_XML_CONFIG_MAP;

public class DrrTestPackCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DrrTestPackCreator.class);

    private static final Predicate<String> TRADE_COMMON_TEST_PACKS = startsWith("credit", "custom-scenarios", "equity", "events", "fx");
    @Inject
    private PipelineConfigWriter pipelineConfigWriter;
    @Inject
    private ReportSampleItemHandler itemHandler;

    public static void main(String[] args) {
        try {
            DrrTestPackCreator testPackConfigCreator = new DrrTestPackCreator();

            setupInjector(testPackConfigCreator);

            testPackConfigCreator.run();
            System.exit(0);
        } catch (Exception e) {
            LOGGER.error("Error executing {}.main()", DrrTestPackCreator.class.getName(), e);
            System.exit(1);
        }
    }

    private static void setupInjector(DrrTestPackCreator drrTestPackCreator) {
        Injector injector = new ReportTestRuntimeModule.InjectorProvider().getInjector();
        Injector childInjector = injector.createChildInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(ReportSampleItemHandler.class).toInstance(new ReportSampleItemHandler(ObjectMapperGenerator.createWriterMapper(true)));
            }
        });
        childInjector.injectMembers(drrTestPackCreator);
    }

    private void run() throws IOException {
        Stopwatch t = Stopwatch.createStarted();

        // Enrich ingest samples, and copy into reporting input folder
        copyAndEnrichSamples();

        generatePipelines();

        LOGGER.info("DRR pipeline / test pack update took {}", t);
    }

    private void copyAndEnrichSamples() {
        if (TEST_WRITE_BASE_PATH.isEmpty()) {
            LOGGER.error("TEST_WRITE_BASE_PATH not set");
            return;
        }
        Path writePath = TEST_WRITE_BASE_PATH.get();
        RegReportPaths paths = RegReportPaths.getDefault();

        LOGGER.info("Copy and process ingested test packs");
        itemHandler.copyFiles(writePath.resolve(paths.getInputRelativePath()), TestPackCreatorConfig.INSTANCE.getReportSampleConfigs());
    }

    private void generatePipelines() throws IOException {
        pipelineConfigWriter.writePipelinesAndTestPacks(createESMATradeTreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("delegated-reporting", "etd", "commodity", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createASICTradeTreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("commodity", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createMASTradeTreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("commodity", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createCFTCPart43TreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("cftc-event-scenarios", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createCFTCPart45TreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("cftc-event-scenarios", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createCSATradeTreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("commodity", "cftc-event-scenarios", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createCSAPPDTreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("commodity", "cftc-event-scenarios", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createCDETradeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("delegated-reporting", "etd", "commodity", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createSECTradeTreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("commodity", "rates"))));

        pipelineConfigWriter.writePipelinesAndTestPacks(createESMAValuationTreeConfig(startsWith("valuation")));
        pipelineConfigWriter.writePipelinesAndTestPacks(createFCAValuationTreeConfig(startsWith("valuation")));
        pipelineConfigWriter.writePipelinesAndTestPacks(createCFTCValuationTreeConfig(startsWith("valuation")));
        pipelineConfigWriter.writePipelinesAndTestPacks(createASICValuationTreeConfig(startsWith("valuation")));
        pipelineConfigWriter.writePipelinesAndTestPacks(createMASValuationTreeConfig(startsWith("valuation")));
        pipelineConfigWriter.writePipelinesAndTestPacks(createCFSAValuationTreeConfig(startsWith("valuation")));
        pipelineConfigWriter.writePipelinesAndTestPacks(createHKMAValuationTreeConfig(startsWith("valuation")));
        pipelineConfigWriter.writePipelinesAndTestPacks(createJFSAValuationTreeConfig(startsWith("valuation")));
        pipelineConfigWriter.writePipelinesAndTestPacks(createCollateralTreeConfig(startsWith("collateral")));

        pipelineConfigWriter.writePipelinesAndTestPacks(createFCATreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createJFSATreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("commodity", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createHKMADtccTradeTreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("commodity", "rates"))));
        pipelineConfigWriter.writePipelinesAndTestPacks(createHKMATrTradeTreeConfig(TRADE_COMMON_TEST_PACKS.or(startsWith("commodity", "rates"))));

    }

    private PipelineTreeConfig createESMATradeTreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig esmaTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, ESMAEMIRTradeReportFunction.class)
                .add(ESMAEMIRTradeReportFunction.class, TransformType.PROJECTION, Project_EsmaEmirTradeReportToIso20022.class);

        return addXMLAndSchemaMap(esmaTreeConfig);
    }

    private PipelineTreeConfig createHKMADtccTradeTreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig hkmaTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, HKMATradeReportFunction.class)
                .add(HKMATradeReportFunction.class, TransformType.PROJECTION, Project_HKMADtccTradeReportToIso20022.class);

        return addXMLAndSchemaMap(hkmaTreeConfig);
    }

    private PipelineTreeConfig createHKMATrTradeTreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig hkmaTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, HKMATradeReportFunction.class)
                .add(HKMATradeReportFunction.class, TransformType.PROJECTION, Project_HKMATrTradeReportToIso20022.class);

        return addXMLAndSchemaMap(hkmaTreeConfig);
    }

    private PipelineTreeConfig createASICTradeTreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig asicTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, ASICTradeReportFunction.class)
                .add(ASICTradeReportFunction.class, TransformType.PROJECTION, Project_ASICTradeReportToIso20022.class);

        return addXMLAndSchemaMap(asicTreeConfig);
    }

    public PipelineTreeConfig createMASTradeTreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig masTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, MASTradeReportFunction.class)
                .add(MASTradeReportFunction.class, TransformType.PROJECTION, Project_MASTradeReportToIso20022.class);

        return addXMLAndSchemaMap(masTreeConfig);
    }

    private PipelineTreeConfig createCFTCPart43TreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig cftcPart43TreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, CFTCPart43ReportFunction.class)
                .add(CFTCPart43ReportFunction.class, TransformType.PROJECTION, Project_CftcPart43TradeReportToDtccRdsHarmonized.class);

        return addXMLAndSchemaMap(cftcPart43TreeConfig);
    }

    private PipelineTreeConfig createCFTCPart45TreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig cftcPart45TreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, CFTCPart45ReportFunction.class)
                .add(CFTCPart45ReportFunction.class, TransformType.PROJECTION, Project_CftcPart45TradeReportToDtccRdsHarmonized.class);

        return addXMLAndSchemaMap(cftcPart45TreeConfig);
    }

    public PipelineTreeConfig createCSATradeTreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig csaTradeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, CSATradeReportFunction.class)
                .add(CSATradeReportFunction.class, TransformType.PROJECTION, Project_CSATradeReportToDtccRdsHarmonized.class);

        return addXMLAndSchemaMap(csaTradeConfig);
    }

    public PipelineTreeConfig createCSAPPDTreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig csaPpdConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, CSAPPDReportFunction.class)
                .add(CSAPPDReportFunction.class, TransformType.PROJECTION, Project_CsaPpdReportToDtccRdsHarmonized.class);


        return addXMLAndSchemaMap(csaPpdConfig);
    }

    public PipelineTreeConfig createJFSATreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig jfsaTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, JFSATradeReportFunction.class)
                .add(JFSATradeReportFunction.class, TransformType.PROJECTION, Project_JFSARewriteTradeReportToIso20022.class);

        return addXMLAndSchemaMap(jfsaTreeConfig);
    }

    public PipelineTreeConfig createFCATreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        final PipelineTreeConfig fcaTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)

                .starting(TransformType.REPORT, FCAUKEMIRTradeReportFunction.class)
                .add(FCAUKEMIRTradeReportFunction.class, TransformType.PROJECTION, Project_FcaUkEmirTradeReportToIso20022.class);

        return addXMLAndSchemaMap(fcaTreeConfig);
    }

    private PipelineTreeConfig createESMAValuationTreeConfig(Predicate<String> testPackIdInclusionFilter) {
        final PipelineTreeConfig esmaValuationConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackIdInclusionFilter)
                .starting(TransformType.REPORT, ESMAEMIRValuationReportFunction.class)
                .add(ESMAEMIRValuationReportFunction.class, TransformType.PROJECTION, Project_EsmaEmirValuationReportToIso20022.class);
        return addXMLAndSchemaMap(esmaValuationConfig);

    }

    private PipelineTreeConfig createFCAValuationTreeConfig(Predicate<String> testPackIdInclusionFilter) {
        final PipelineTreeConfig fcaValuationTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackIdInclusionFilter)
                .starting(TransformType.REPORT, FCAUKEMIRValuationReportFunction.class)
                .add(FCAUKEMIRValuationReportFunction.class, TransformType.PROJECTION, Project_FcaUkEmirValuationReportToIso20022.class);
        return addXMLAndSchemaMap(fcaValuationTreeConfig);
    }

    private PipelineTreeConfig createASICValuationTreeConfig(Predicate<String> testPackIdInclusionFilter) {
        final PipelineTreeConfig asicMasCfsaTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackIdInclusionFilter)

                .starting(TransformType.REPORT, ASICValuationReportFunction.class)
                .add(ASICValuationReportFunction.class, TransformType.PROJECTION, Project_ASICValuationReportToIso20022.class);

        return addXMLAndSchemaMap(asicMasCfsaTreeConfig);
    }

    public PipelineTreeConfig createMASValuationTreeConfig(Predicate<String> testPackIdInclusionFilter) {
        final PipelineTreeConfig asicMasCfsaTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackIdInclusionFilter)

                .starting(TransformType.REPORT, MASValuationReportFunction.class)
                .add(MASValuationReportFunction.class, TransformType.PROJECTION, Project_MASValuationReportToIso20022.class);

        return addXMLAndSchemaMap(asicMasCfsaTreeConfig);
    }

    private PipelineTreeConfig createCFTCValuationTreeConfig(Predicate<String> testPackIdInclusionFilter) {
        final PipelineTreeConfig cftcTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackIdInclusionFilter)

                .starting(TransformType.REPORT, CFTCValuationReportFunction.class)
                .add(CFTCValuationReportFunction.class, TransformType.PROJECTION, Project_CFTCValuationReportToDtccRdsHarmonized.class);

        return addXMLAndSchemaMap(cftcTreeConfig);
    }

    public PipelineTreeConfig createCFSAValuationTreeConfig(Predicate<String> testPackIdInclusionFilter) {
        final PipelineTreeConfig asicMasCfsaTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackIdInclusionFilter)

                .starting(TransformType.REPORT, CSAValuationReportFunction.class)
                .add(CSAValuationReportFunction.class, TransformType.PROJECTION, Project_CSAValuationReportToDtccRdsHarmonized.class);

        return addXMLAndSchemaMap(asicMasCfsaTreeConfig);
    }

    public PipelineTreeConfig createHKMAValuationTreeConfig(Predicate<String> testPackIdInclusionFilter) {
        final PipelineTreeConfig hkmaValuationTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackIdInclusionFilter)

                .starting(TransformType.REPORT, HKMAValuationReportFunction.class)
                .add(HKMAValuationReportFunction.class, TransformType.PROJECTION, Project_HKMATrValuationReportToIso20022.class)
                .add(HKMAValuationReportFunction.class, TransformType.PROJECTION, Project_HKMADtccValuationReportToIso20022.class);

        return addXMLAndSchemaMap(hkmaValuationTreeConfig);
    }

    private PipelineTreeConfig createJFSAValuationTreeConfig(Predicate<String> testPackIdInclusionFilter) {
        final PipelineTreeConfig jfsaValuationTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackIdInclusionFilter)

                .starting(TransformType.REPORT, JFSAValuationReportFunction.class)
                .add(JFSAValuationReportFunction.class, TransformType.PROJECTION, Project_JFSARewriteValuationReportToIso20022.class);

        return addXMLAndSchemaMap(jfsaValuationTreeConfig);
    }

    private PipelineTreeConfig createCollateralTreeConfig(Predicate<String> testPackIdInclusionFilter) {
        final PipelineTreeConfig collateralTreeConfig = new PipelineTreeConfig()
                .withTestPackIdFilter(testPackIdInclusionFilter)

                .starting(TransformType.REPORT, CFTCMarginReportFunction.class)

                .starting(TransformType.REPORT, ASICMarginReportFunction.class)
                .add(ASICMarginReportFunction.class, TransformType.PROJECTION, Project_ASICMarginReportToIso20022.class)

                .starting(TransformType.REPORT, CSAMarginReportFunction.class)

                .starting(TransformType.REPORT, HKMAMarginReportFunction.class)

                .starting(TransformType.REPORT, ESMAEMIRMarginReportFunction.class)
                .add(ESMAEMIRMarginReportFunction.class, TransformType.PROJECTION, Project_EsmaEmirMarginReportToIso20022.class)

                .starting(TransformType.REPORT, FCAUKEMIRMarginReportFunction.class)
                .add(FCAUKEMIRMarginReportFunction.class, TransformType.PROJECTION, Project_FcaUkEmirMarginReportToIso20022.class)

                .starting(TransformType.REPORT, JFSAMarginReportFunction.class)
                .add(JFSAMarginReportFunction.class, TransformType.PROJECTION, Project_JFSARewriteMarginReportToIso20022.class)

                .starting(TransformType.REPORT, MASMarginReportFunction.class)
                .add(MASMarginReportFunction.class, TransformType.PROJECTION, Project_MASMarginReportToIso20022.class)

                .starting(TransformType.REPORT, HKMAMarginReportFunction.class)
                .add(HKMAMarginReportFunction.class, TransformType.PROJECTION, Project_HKMADtccMarginReportToIso20022.class)
                .add(HKMAMarginReportFunction.class, TransformType.PROJECTION, Project_HKMATrMarginReportToIso20022.class);

        return addXMLAndSchemaMap(collateralTreeConfig);
    }

    private PipelineTreeConfig createCDETradeConfig(Predicate<String> testPackSampleInclusionFilter) {
        return new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)
                .starting(TransformType.REPORT, CPMI_IOSCOCDEReportFunction.class);
    }

    private PipelineTreeConfig createSECTradeTreeConfig(Predicate<String> testPackSampleInclusionFilter) {
        return  new PipelineTreeConfig()
                .withTestPackIdFilter(testPackSampleInclusionFilter)
                .starting(TransformType.REPORT, SECTradeReportFunction.class);
    }

    private PipelineTreeConfig addXMLAndSchemaMap(PipelineTreeConfig pipelineTreeConfig) {
        return pipelineTreeConfig
                .withXmlConfigMap(TYPE_TO_XML_CONFIG_MAP)
                .withXmlSchemaMap(TYPE_TO_SCHEMA_MAP);
    }
}
