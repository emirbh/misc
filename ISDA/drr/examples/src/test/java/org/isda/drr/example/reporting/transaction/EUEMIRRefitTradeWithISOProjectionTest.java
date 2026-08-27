package org.isda.drr.example.reporting.transaction;

import com.google.common.io.Resources;
import jakarta.inject.Inject;
import com.regnosys.drr.examples.util.ResourcesUtils;
import com.regnosys.rosetta.common.validation.ValidationReport;
import drr.projection.iso20022.esma.emir.refit.trade.functions.Project_EsmaEmirTradeReportToIso20022;
import drr.regulation.common.*;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.regulation.esma.emir.refit.trade.reports.ESMAEMIRTradeReportFunction;
import iso20022.Auth030EsmaModelConfig;
import iso20022.auth030.esma.Document;
import org.isda.drr.example.AbstractReportingTest;
import org.isda.drr.example.util.ReportingTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class to demonstrate ESMA EMIR transaction reporting with ISO-20022 projection.
 * This class validates the transformation of a `TransactionReportInstruction` to a `ESMATransactionReport`,
 * followed by validation and ISO-20022 projection.
 */
final class EUEMIRRefitTradeWithISOProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(EUEMIRRefitTradeWithISOProjectionTest.class);

    // Function to generate an EMIR refit Trade Report from a TransactionReportInstruction
    @Inject
    ESMAEMIRTradeReportFunction reportFunc;

    // Function to project an EMIR refit Trade Report to ISO-20022 format
    @Inject
    Project_EsmaEmirTradeReportToIso20022 emirTradeReportToIso20022;


    /**
     * Demonstrates EMIR REFIT trade reporting with ISO-20022 projection.
     * The test performs the following steps:
     * - Loads a `TransactionReportInstruction` from JSON.
     * - Generates an `ESMAEMIRTransactionReport` and validates it.
     * - Projects the report to ISO-20022 format.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void EmirRefitTradeWithISOProjectionExampleTest() throws IOException {
        // Load a TransactionReportInstruction from the input test data
        TransactionReportInstruction transactionReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                TransactionReportInstruction.class,
                "regulatory-reporting/input/rates/IR-IRS-Fixed-Float-ex01.json"
        );
        assertNotNull(transactionReportInstruction, "No reportable event was found");

        // Generate the EMIR refit transaction report
        ESMAEMIRTransactionReport report = runReport(transactionReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results
        ValidationReport validationReport = validator.runProcessStep(ESMAEMIRTransactionReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

        // Project the report to ISO-20022 format
        ISOProjection(report);
    }

    /**
     * Demonstrates EMIR REFIT ETD reporting with ISO-20022 projection.
     * The test performs the following steps:
     * - Loads a `ReportableEvent` from JSON.
     * - Generates an `ESMAEMIRTransactionReport` and validates it.
     * - Projects the report to ISO-20022 format.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void EmirRefitETDWithISOprojectionExampleTest() throws IOException {
        // Load a ReportableEvent from the input test data
        TransactionReportInstruction transactionReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                TransactionReportInstruction.class,
                "result-json-files/fpml-5-13/record-keeping/products/etd/mockup-etd.json"
        );
        assertNotNull(transactionReportInstruction, "No reportable event was found");

        // Generate the EMIR refit transaction report
        ESMAEMIRTransactionReport report = runReport(transactionReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results
        ValidationReport validationReport = validator.runProcessStep(ESMAEMIRTransactionReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

        // Project the report to ISO-20022 format
        ISOProjection(report);
    }

    /**
     * Generates an EMIR refit transaction report from a `ReportableEvent`.
     *
     * @param transactionReportInstruction The transaction report instruction input.
     * @return The generated ESMAEMIRTransactionReport.
     * @throws IOException If there is an error during processing.
     */
    private ESMAEMIRTransactionReport runReport(TransactionReportInstruction transactionReportInstruction) throws IOException {

        // Generate the EMIR refit transaction report
        final ESMAEMIRTransactionReport report = reportFunc.evaluate(transactionReportInstruction);

        // Print the generated report in JSON format for debugging
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }

    /**
     * Projects an `ESMAEMIRTransactionReport` to ISO-20022 format.
     *
     * @param report The EMIR refit transaction report to project.
     * @throws IOException If there is an error during the projection process.
     */
    void ISOProjection(ESMAEMIRTransactionReport report) throws IOException {
        // Project the EMIR refit transaction report to an ISO-20022 document
        Document iso20022Document = emirTradeReportToIso20022.evaluate(report);

        // Load the ISO-20022 configuration path
        URL iso20022Auth030XmlConfig = Resources.getResource(Auth030EsmaModelConfig.XML_CONFIG_PATH);

        // Print the ISO-20022 document using the provided configuration
        ReportingTestUtils.logXMLProjection(iso20022Document, iso20022Auth030XmlConfig);
    }
}
