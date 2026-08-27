package org.isda.drr.example.reporting.valuation;

import com.google.common.io.Resources;
import drr.projection.iso20022.fca.ukemir.refit.valuation.functions.Project_FcaUkEmirValuationReportToIso20022;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import drr.regulation.fca.ukemir.refit.valuation.reports.FCAUKEMIRValuationReportFunction;
import iso20022.Auth030FcaModelConfig;
import iso20022.auth030.fca.Document;
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
 * Test class to demonstrate FCA UK EMIR valuation reporting with ISO-20022 projection.
 * The test validates the transformation of a `ValuationReportInstruction` to an `FCAValuationReport`,
 * followed by validation and ISO-20022 projection.
 */
final class UKEMIRValuationWithISOProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(UKEMIRValuationWithISOProjectionTest.class);

    // Function to project an FCA UK EMIR valuation report to ISO-20022 format
    @Inject
    Project_FcaUkEmirValuationReportToIso20022 fcaUkEmirValuationReportToIso20022;

    // Function to generate an FCAUKEMIRValuationReport from a ValuationReportInstruction.
    @Inject
    FCAUKEMIRValuationReportFunction reportFunc;

    /**
     * Demonstrates FCA UK EMIR valuation reporting with ISO-20022 projection.
     * The test performs the following steps:
     * - Loads a `ValuationReportInstruction` from JSON.
     * - Generates an `FCAValuationReport` and validates it.
     * - Projects the report to ISO-20022 format.
     *
     * @throws IOException If there is an error during file reading or writing.
     */
    @Test
    void FcaUkEmirValuationWithISOProjectionExampleTest() throws IOException {
        // Load a ValuationReportInstruction from the input test data.
        ValuationReportInstruction valuationReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                ValuationReportInstruction.class,
                "regulatory-reporting/input/valuation/Valuation-ex01.json"
        );
        assertNotNull(valuationReportInstruction, "No reportable event was found");

        // Generate the FCA EMIR valuation report.
        FCAValuationReport report = runReport(valuationReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results.
        ValidationReport validationReport = validator.runProcessStep(FCAValuationReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

        // Project the report to ISO-20022 format
        ISOProjection(report);
    }

    /**
     * Generates an FCA UK EMIR valuation report from a `ReportableValuation`.
     *
     * @param valuationReportInstruction The valuation report instruction input.
     * @return The generated FCAValuationReport.
     * @throws IOException If there is an error during processing.
     */
    FCAValuationReport runReport(ValuationReportInstruction valuationReportInstruction) throws IOException {

        // Generate the FCA valuation report.
        final FCAValuationReport report = reportFunc.evaluate(valuationReportInstruction);

        // Print the generated report in JSON format for debugging.
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }

    /**
     * Projects a `FCAValuationReport` to ISO-20022 format.
     *
     * @param report The FCA valuation report to project.
     * @throws IOException If there is an error during the projection process.
     */
    void ISOProjection(FCAValuationReport report) throws IOException {
        // Project the FCA UK EMIR valuation report to an ISO-20022 document
        Document iso20022Document = fcaUkEmirValuationReportToIso20022.evaluate(report);

        // Load the ISO-20022 configuration path
        URL iso20022Auth030XmlConfig = Resources.getResource(Auth030FcaModelConfig.XML_CONFIG_PATH);

        // Print the ISO-20022 document using the provided configuration
        ReportingTestUtils.logXMLProjection(iso20022Document, iso20022Auth030XmlConfig);
    }
}


