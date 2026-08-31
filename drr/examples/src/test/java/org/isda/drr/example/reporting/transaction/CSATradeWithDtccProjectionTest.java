package org.isda.drr.example.reporting.transaction;

import com.google.common.io.Resources;
import jakarta.inject.Inject;
import com.regnosys.drr.examples.util.ResourcesUtils;
import com.regnosys.rosetta.common.validation.ValidationReport;
import drr.projection.dtcc.rds.harmonized.csa.rewrite.trade.functions.Project_CSATradeReportToDtccRdsHarmonized;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.regulation.csa.rewrite.trade.reports.CSATradeReportFunction;
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
 * Test class to demonstrate CSA transaction reporting with Dtcc projection.
 * This class validates the transformation of a `TransactionReportInstruction` to a `CSATransactionReport`,
 * followed by validation and Dtcc projection.
 */
final class CSATradeWithDtccProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(CSATradeWithDtccProjectionTest.class);

    // Function to generate a CSA Transaction Report
    @Inject
    CSATradeReportFunction reportFunc;

    // Function to project a CSA transaction report to Dtcc Rds Harmonized format
    @Inject
    Project_CSATradeReportToDtccRdsHarmonized csaTradeReportToDtccRdsHarmonized;

    /**
     * Demonstrates CSA transaction reporting with Dtcc Rds projection.
     * The test performs the following steps:
     * - Loads a `TransactionReportInstruction` from JSON.
     * - Generates a `CSATransactionReport` and validates it.
     * - Projects the report to Dtcc Rds format.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void CSATradeWithDtccRdsProjectionExampleReportTest() throws IOException {
        // Load a TransactionReportInstruction from the input test data
        TransactionReportInstruction transactionReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                TransactionReportInstruction.class,
                "regulatory-reporting/input/rates/IR-IRS-Fixed-Float-ex01.json"
        );
        assertNotNull(transactionReportInstruction, "No reportable event was found");

        // Generate the CSA transaction report
        CSATransactionReport report = runReport(transactionReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results
        ValidationReport validationReport = validator.runProcessStep(CSATransactionReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

        dtccRdsHarmonizedProjection(report);
    }

    /**
     * Generates a CSA Tansaction report from a `ReportableEvent`.
     *
     * @param transactionReportInstruction The transaction report instruction event input.
     * @return The generated CSATransactionReport.
     * @throws IOException If there is an error during processing.
     */
    CSATransactionReport runReport(TransactionReportInstruction transactionReportInstruction) throws IOException {
        // Generate the CSA transaction report
        final CSATransactionReport report = reportFunc.evaluate(transactionReportInstruction);

        // Print the generated report in JSON format for debugging
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }

    /**
     * Projects a `CSATransactionReport` to Dtcc Rds Harmonized format.
     *
     * @param report The CSA transaction report to project.
     * @throws IOException If there is an error during the projection process.
     */
    void dtccRdsHarmonizedProjection(CSATransactionReport report) throws IOException {
        // Project the CSA transaction report to a Dtcc Rds document
        iso20022.dtcc.rds.harmonized.Document dtccRdsHarmonizedDocument = csaTradeReportToDtccRdsHarmonized.evaluate(report);

        // Load the Dtcc Rds configuration path
        URL dtccRdsHarmonizedXmlConfig = Resources.getResource(DtccRdsHarmonizedModelConfig.XML_CONFIG_PATH);

        // Print the Dtcc Rds document using the provided configuration
        ReportingTestUtils.logXMLProjection(dtccRdsHarmonizedDocument, dtccRdsHarmonizedXmlConfig);
    }
}
