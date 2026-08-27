package org.isda.drr.example.reporting.valuation;

import com.google.common.io.Resources;
import jakarta.inject.Inject;
import com.regnosys.drr.examples.util.ResourcesUtils;
import com.regnosys.rosetta.common.validation.ValidationReport;
import drr.projection.iso20022.hkma.rewrite.valuation.dtcc.functions.Project_HKMADtccValuationReportToIso20022;
import drr.projection.iso20022.hkma.rewrite.valuation.tr.functions.Project_HKMATrValuationReportToIso20022;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import drr.regulation.hkma.rewrite.valuation.reports.HKMAValuationReportFunction;
import iso20022.Auth030HkmaDtccModelConfig;
import iso20022.Auth030HkmaTrModelConfig;
import org.isda.drr.example.AbstractReportingTest;
import org.isda.drr.example.util.ReportingTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class to demonstrate HKMA valuation reporting with ISO-20022 projection.
 * The test validates the transformation of a `ValuationReportInstruction` to an `HKMAValuationReport`,
 * followed by validation and ISO-20022 projection.
 */
final class HKMAValuationWithISOProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(HKMAValuationWithISOProjectionTest.class);

    // Function to generate an HKMAValuationReport from a ValuationReportInstruction.
    @Inject
    HKMAValuationReportFunction reportFunc;

    // Function to project an HKMA Dtcc valuation report to ISO20022 format
    @Inject
    Project_HKMADtccValuationReportToIso20022 hkmaDtccValuationReportToIso20022;

    // Function to project an HKMA Tr valuation report to ISO20022 format
    @Inject
    Project_HKMATrValuationReportToIso20022 hkmaTrValuationReportToIso20022;

    /**
     * Demonstrates HKMA valuation reporting with Dtcc ISO-20022 projection.
     * The test projects the report to Dtcc ISO-20022 format.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void HKMADtccValuationWithISOProjectionExampleTest() throws IOException {
        //Get a validated HKMA valuation report
        HKMAValuationReport report = HKMAValuationReport();

        // Project the report to Dtcc ISO-20022 format
        dtccISOProjection(report);
    }

    /**
     * Demonstrates HKMA valuation reporting with Tr ISO-20022 projection.
     * The test projects the report to Tr ISO-20022 format.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void HKMATrValuationWithISOProjectionExampleTest() throws IOException {
        //Get a validated HKMA valuation report
        HKMAValuationReport report = HKMAValuationReport();

        // Project the report to Tr ISO-20022 format
        hktrISOProjection(report);
    }

    /**
     * Generates an HKMA valuation report from a ValuationReportInstruction and validates it
     * The test performs the following steps:
     * - Loads a `ValuationReportInstruction` from JSON.
     * - Generates a `HKMAValuationReport`.
     * - Validates the `HKMAValuationReport`
     *
     * @return The generated HKMAValuationReport after validation.
     * @throws IOException If there is an error during file reading or processing.
     */
    private HKMAValuationReport HKMAValuationReport() throws IOException {
        // Load a ValuationReportInstruction from the input test data.
        ValuationReportInstruction valuationReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                ValuationReportInstruction.class,
                "regulatory-reporting/input/valuation/Valuation-ex01.json"
        );
        assertNotNull(valuationReportInstruction, "No reportable event was found");

        // Generate the HKMA valuation report.
        HKMAValuationReport report = runReport(valuationReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results.
        ValidationReport validationReport = validator.runProcessStep(HKMAValuationReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

        return report;
    }

    /**
     * Generates an HKMA valuation report from a `ReportableValuation`.
     *
     * @param valuationReportInstruction The valuation report instruction input.
     * @return The generated HKMAValuationReport.
     * @throws IOException If there is an error during processing.
     */
    HKMAValuationReport runReport(ValuationReportInstruction valuationReportInstruction) throws IOException {

        // Generate the HKMA valuation report.
        final HKMAValuationReport report = reportFunc.evaluate(valuationReportInstruction);

        // Print the generated report in JSON format for debugging.
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }

    /**
     * Projects an `HKMAValuationReport` to Dtcc ISO-20022 format.
     *
     * @param report The HKMA valuation report to project.
     * @throws IOException If there is an error during the projection process.
     */
    void dtccISOProjection(HKMAValuationReport report) throws IOException {
        // Project the HKMA valuation report to an ISO-20022 document
        iso20022.auth030.hkma.dtcc.Document iso20022Document = hkmaDtccValuationReportToIso20022.evaluate(report);

        // Load the ISO-20022 configuration path
        URL iso20022Auth030XmlConfig = Resources.getResource(Auth030HkmaDtccModelConfig.XML_CONFIG_PATH);

        // Print the ISO-20022 document using the provided configuration
        ReportingTestUtils.logXMLProjection(iso20022Document, iso20022Auth030XmlConfig);
    }

    /**
     * Projects an `HKMAValuationReport` to Tr ISO-20022 format.
     *
     * @param report The HKMA valuation report to project.
     * @throws IOException If there is an error during the projection process.
     */
    void hktrISOProjection(HKMAValuationReport report) throws IOException {
        // Project the HKMA valuation report to an ISO-20022 document
        iso20022.auth030.hkma.tr.Document iso20022Document = hkmaTrValuationReportToIso20022.evaluate(report);

        // Load the ISO-20022 configuration path
        URL iso20022Auth030XmlConfig = Resources.getResource(Auth030HkmaTrModelConfig.XML_CONFIG_PATH);

        // Print the ISO-20022 document using the provided configuration
        ReportingTestUtils.logXMLProjection(iso20022Document, iso20022Auth030XmlConfig);
    }
}

