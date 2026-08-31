package org.isda.drr.example.reporting.valuation;

import com.google.common.io.Resources;
import com.regnosys.drr.examples.util.ResourcesUtils;
import com.regnosys.rosetta.common.validation.ValidationReport;
import drr.projection.dtcc.rds.harmonized.cftc.rewrite.valuation.functions.Project_CFTCValuationReportToDtccRdsHarmonized;
import drr.regulation.cftc.rewrite.valuation.CFTCValuationReport;
import drr.regulation.cftc.rewrite.valuation.reports.CFTCValuationReportFunction;
import drr.regulation.common.ValuationReportInstruction;
import iso20022.DtccRdsHarmonizedModelConfig;
import jakarta.inject.Inject;
import org.isda.drr.example.AbstractReportingTest;
import org.isda.drr.example.util.ReportingTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class to demonstrate CFTC valuation reporting with Dtcc projection.
 * The test validates the transformation of a `ValuationReportInstruction` to an `CFTCValuationReport`,
 * followed by validation and Dtcc projection.
 */
final class CFTCValuationWithDtccProjectionTest extends AbstractReportingTest {
    private static final Logger logger = LoggerFactory.getLogger(CFTCValuationWithDtccProjectionTest.class);

    // Function to generate a CFTCValuationReport from a ValuationReportInstruction.
    @Inject
    CFTCValuationReportFunction reportFunc;

    // Function to project a CFTC valuation report to Dtcc Rds Harmonized format
    @Inject
    Project_CFTCValuationReportToDtccRdsHarmonized cftcValuationReportToDtccRdsHarmonized;

    /**
     * Demonstrates CFTC valuation reporting with Dtcc Rds projection.
     * The test performs the following steps:
     * - Loads a `ValuationReportInstruction` from JSON.
     * - Generates a `CFTCValuationReport` and validates it.
     * - Projects the report to Dtcc Rds format.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void CFTCValuationWithDtccRdsProjectionExampleReportTest() throws IOException {
        // Load a ValuationReportInstruction from the input test data.
        ValuationReportInstruction valuationReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                ValuationReportInstruction.class,
                "regulatory-reporting/input/valuation/Valuation-ex01.json"
        );
        assertNotNull(valuationReportInstruction, "No reportable event was found");

        // Generate the CFTC valuation report
        CFTCValuationReport report = runReport(valuationReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results
        ValidationReport validationReport = validator.runProcessStep(CFTCValuationReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

        dtccRdsHarmonizedProjection(report);
    }

    /**
     * Generates a CFTC valuation report from a `ReportableValuation`.
     *
     * @param valuationReportInstruction The valuation report instruction input.
     * @return The generated CFTCValuationReport.
     * @throws IOException If there is an error during processing.
     */
    CFTCValuationReport runReport(ValuationReportInstruction valuationReportInstruction) throws IOException {

        // Generate the CFTC valuation report.
        final CFTCValuationReport report = reportFunc.evaluate(valuationReportInstruction);

        // Print the generated report in JSON format for debugging.
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }

    /**
     * Projects a `CFTCValuationReport` to Dtcc Rds Harmonized format.
     *
     * @param report The CFTC valuation report to project.
     * @throws IOException If there is an error during the projection process.
     */
    void dtccRdsHarmonizedProjection(CFTCValuationReport report) throws IOException {
        // Project the CFTC valuation report to a Dtcc Rds document
        iso20022.dtcc.rds.harmonized.Document dtccRdsHarmonizedDocument = cftcValuationReportToDtccRdsHarmonized.evaluate(report);

        // Load the Dtcc Rds configuration path
        URL dtccRdsHarmonizedXmlConfig = Resources.getResource(DtccRdsHarmonizedModelConfig.XML_CONFIG_PATH);

        // Print the Dtcc Rds document using the provided configuration
        ReportingTestUtils.logXMLProjection(dtccRdsHarmonizedDocument, dtccRdsHarmonizedXmlConfig);
    }
}
