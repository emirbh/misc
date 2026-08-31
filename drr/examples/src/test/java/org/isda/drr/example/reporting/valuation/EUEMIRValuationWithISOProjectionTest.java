package org.isda.drr.example.reporting.valuation;

import com.google.common.io.Resources;
import drr.projection.iso20022.esma.emir.refit.valuation.functions.Project_EsmaEmirValuationReportToIso20022;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import drr.regulation.esma.emir.refit.valuation.reports.ESMAEMIRValuationReportFunction;
import iso20022.Auth030EsmaModelConfig;
import iso20022.auth030.esma.Document;
import jakarta.inject.Inject;
import com.regnosys.drr.examples.util.ResourcesUtils;
import com.regnosys.rosetta.common.validation.ValidationReport;
import drr.regulation.common.ValuationReportInstruction;
import org.isda.drr.example.AbstractReportingTest;
import org.isda.drr.example.util.ReportingTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class to demonstrate ESMA EMIR valuation reporting with ISO-20022 projection.
 * The test validates the transformation of a `ValuationReportInstruction` to an `ESMAValuationReport`,
 * followed by validation and ISO-20022 projection.
 */
final class EUEMIRValuationWithISOProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(EUEMIRValuationWithISOProjectionTest.class);

    // Function to project a ESMA EMIR valuation report to ISO-20022 format
    @Inject
    Project_EsmaEmirValuationReportToIso20022 esmaEmirValuationReportToIso20022;

    // Function to generate an ESMAEMIRValuationReport from a ValuationReportInstruction.
    @Inject
    ESMAEMIRValuationReportFunction reportFunc;

    /**
     * Demonstrates ESMA EMIR valuation reporting with ISO-20022 projection.
     * The test performs the following steps:
     * - Loads a `ValuationReportInstruction` from JSON.
     * - Generates an `ESMAEMIRValuationReport` and validates it.
     * - Projects the report to ISO-20022 format.
     *
     * @throws IOException If there is an error during file reading or writing.
     */
    @Test
    void EsmaEmirValuationWithISOProjectionExampleTest() throws IOException {
        // Load a ValuationReportInstruction from the input test data.
        ValuationReportInstruction valuationReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                ValuationReportInstruction.class,
                "regulatory-reporting/input/valuation/Valuation-ex01.json"
        );
        assertNotNull(valuationReportInstruction, "No reportable event was found");

        // Generate the ESMA EMIR valuation report.
        ESMAValuationReport report = runReport(valuationReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results.
        ValidationReport validationReport = validator.runProcessStep(ESMAValuationReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

        // Project the report to ISO-20022 format
        ISOProjection(report);
    }

    /**
     * Generates an ESMA EMIR valuation report from a `ReportableValuation`.
     *
     * @param valuationReportInstruction The valuation report instruction input.
     * @return The generated ESMAValuationReport.
     * @throws IOException If there is an error during processing.
     */
    ESMAValuationReport runReport(ValuationReportInstruction valuationReportInstruction) throws IOException {

        // Generate the ESMA valuation report.
        final ESMAValuationReport report = reportFunc.evaluate(valuationReportInstruction);

        // Print the generated report in JSON format for debugging.
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }

    /**
     * Projects a `ESMAValuationReport` to ISO-20022 format.
     *
     * @param report The ESMA valuation report to project.
     * @throws IOException If there is an error during the projection process.
     */
    void ISOProjection(ESMAValuationReport report) throws IOException {
        // Project the ESMA valuation report to an ISO-20022 document
        Document iso20022Document = esmaEmirValuationReportToIso20022.evaluate(report);

        // Load the ISO-20022 configuration path
        URL iso20022Auth030XmlConfig = Resources.getResource(Auth030EsmaModelConfig.XML_CONFIG_PATH);

        // Print the ISO-20022 document using the provided configuration
        ReportingTestUtils.logXMLProjection(iso20022Document, iso20022Auth030XmlConfig);
    }
}

