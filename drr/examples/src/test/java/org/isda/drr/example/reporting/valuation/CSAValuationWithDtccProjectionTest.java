package org.isda.drr.example.reporting.valuation;

import com.google.common.io.Resources;
import jakarta.inject.Inject;
import com.regnosys.drr.examples.util.ResourcesUtils;
import com.regnosys.rosetta.common.validation.ValidationReport;
import drr.projection.dtcc.rds.harmonized.csa.rewrite.valuation.functions.Project_CSAValuationReportToDtccRdsHarmonized;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
import drr.regulation.csa.rewrite.valuation.reports.CSAValuationReportFunction;
import iso20022.DtccRdsHarmonizedModelConfig;
import org.isda.drr.example.AbstractReportingTest;
import org.isda.drr.example.util.ReportingTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class to demonstrate CSA valuation reporting with Dtcc projection.
 * The test validates the transformation of a `ValuationReportInstruction` to an `CSAValuationReport`,
 * followed by validation and Dtcc projection.
 */
final class CSAValuationWithDtccProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(CSAValuationWithDtccProjectionTest.class);

    // Function to generate a CSAValuationReport from a ValuationReportInstruction.
    @Inject
    CSAValuationReportFunction reportFunc;

    // Function to project a CSA valuation report to Dtcc Rds Harmonized format
    @Inject
    Project_CSAValuationReportToDtccRdsHarmonized csaValuationReportToDtccRdsHarmonized;

    /**
     * Demonstrates CSA valuation reporting with Dtcc Rds projection.
     * The test performs the following steps:
     * - Loads a `ValuationReportInstruction` from JSON.
     * - Generates a `CSAValuationReport` and validates it.
     * - Projects the report to Dtcc Rds format.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void CSATradeWithDtccRdsProjectionExampleReportTest() throws IOException {
        // Load a ValuationReportInstruction from the input test data.
        ValuationReportInstruction valuationReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                ValuationReportInstruction.class,
                "regulatory-reporting/input/valuation/Valuation-ex01.json"
        );
        assertNotNull(valuationReportInstruction, "No reportable event was found");

        // Generate the CSA valuation report
        CSAValuationReport report = runReport(valuationReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results
        ValidationReport validationReport = validator.runProcessStep(CSAValuationReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

        dtccRdsHarmonizedProjection(report);
    }

    /**
     * Generates a CSA valuation report from a `ReportableValuation`.
     *
     * @param valuationReportInstruction The valuation report instruction input.
     * @return The generated CSAValuationReport.
     * @throws IOException If there is an error during processing.
     */
    CSAValuationReport runReport(ValuationReportInstruction valuationReportInstruction) throws IOException {

        // Generate the CSA valuation report.
        final CSAValuationReport report = reportFunc.evaluate(valuationReportInstruction);

        // Print the generated report in JSON format for debugging.
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }

    /**
     * Projects a `CSAValuationReport` to Dtcc Rds Harmonized format.
     *
     * @param report The CSA valuation report to project.
     * @throws IOException If there is an error during the projection process.
     */
    void dtccRdsHarmonizedProjection(CSAValuationReport report) throws IOException {
        // Project the CSA valuation report to a Dtcc Rds document
        iso20022.dtcc.rds.harmonized.Document dtccRdsHarmonizedDocument = csaValuationReportToDtccRdsHarmonized.evaluate(report);

        // Load the Dtcc Rds configuration path
        URL dtccRdsHarmonizedXmlConfig = Resources.getResource(DtccRdsHarmonizedModelConfig.XML_CONFIG_PATH);

        // Print the Dtcc Rds document using the provided configuration
        ReportingTestUtils.logXMLProjection(dtccRdsHarmonizedDocument, dtccRdsHarmonizedXmlConfig);
    }
}
