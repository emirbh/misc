package org.isda.drr.example.reporting.transaction;

import drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions.Project_CftcPart45TradeReportToDtccRdsHarmonized;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.regulation.cftc.rewrite.trade.reports.CFTCPart45ReportFunction;
import org.isda.drr.example.AbstractReportingTest;
import com.google.common.io.Resources;
import iso20022.DtccRdsHarmonizedModelConfig;
import jakarta.inject.Inject;
import com.regnosys.drr.examples.util.ResourcesUtils;
import com.regnosys.rosetta.common.validation.ValidationReport;
import drr.regulation.common.TransactionReportInstruction;
import org.isda.drr.example.util.ReportingTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class to demonstrate CFTC Part 45 transaction reporting with dtcc rds projection.
 * This class validates the transformation of a `TransactionReportInstruction` to a `CFTCPart45TransactionReport`,
 * followed by validation of the generated report.
 */
final class CFTCPart45WithDtccProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(CFTCPart45WithDtccProjectionTest.class);

    // Function to generate a CFTC Part 45 Transaction Report
    @Inject
    CFTCPart45ReportFunction reportFunc;

    // Function to project an CFTC Part 45 Trade Report to Dtcc Rds Harmonized format
    @Inject
    Project_CftcPart45TradeReportToDtccRdsHarmonized cftcPart45TradeReportToDtccRdsHarmonized;

    /**
     * Demonstrates CFTC Part 45 transaction reporting with dtcc rds projection.
     * The test performs the following steps:
     * - Loads a `TransactionReportInstruction` from JSON.
     * - Generates a `CFTCPart45TransactionReport` and validates it.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void CFTCPart45WithDtccRdsProjectionExampleReportTest() throws IOException {
        // Load a TransactionReportInstruction from the input test data
        TransactionReportInstruction transactionReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                TransactionReportInstruction.class,
                "regulatory-reporting/input/rates/IR-IRS-Fixed-Float-ex01.json"
        );
        assertNotNull(transactionReportInstruction, "No reportable event was found");

        // Generate the CFTC Part 45 transaction report
        CFTCPart45TransactionReport report = runReport(transactionReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results
        ValidationReport validationReport = validator.runProcessStep(CFTCPart45TransactionReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

        dtccRdsHarmonizedProjection(report);
    }

    /**
     * Generates a CFTC Part 45 transaction report from a `ReportableEvent`.
     *
     * @param transactionReportInstruction The transaction report instruction input.
     * @return The generated CFTCPart45TransactionReport.
     * @throws IOException If there is an error during processing.
     */
    CFTCPart45TransactionReport runReport(TransactionReportInstruction transactionReportInstruction) throws IOException {
        // Generate the CFTC Part 45 transaction report
        final CFTCPart45TransactionReport report = reportFunc.evaluate(transactionReportInstruction);

        // Print the generated report in JSON format for debugging
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }

    /**
     * Projects a CFTC Part 45 TransactionReport to Dtcc Rds Harmonized format.
     *
     * @param report The CFTC Part 45 transaction report to project.
     * @throws IOException If there is an error during the projection process.
     */
    void dtccRdsHarmonizedProjection(CFTCPart45TransactionReport report) throws IOException {
        // Project the CFTC transaction report to a Dtcc Rds document
        iso20022.dtcc.rds.harmonized.Document dtccRdsHarmonizedDocument = cftcPart45TradeReportToDtccRdsHarmonized.evaluate(report);

        // Load the Dtcc Rds configuration path
        URL dtccRdsHarmonizedXmlConfig = Resources.getResource(DtccRdsHarmonizedModelConfig.XML_CONFIG_PATH);

        // Print the Dtcc Rds document using the provided configuration
        ReportingTestUtils.logXMLProjection(dtccRdsHarmonizedDocument, dtccRdsHarmonizedXmlConfig);
    }
}
