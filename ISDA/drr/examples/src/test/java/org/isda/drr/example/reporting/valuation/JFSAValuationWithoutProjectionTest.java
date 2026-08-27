package org.isda.drr.example.reporting.valuation;

import drr.regulation.jfsa.rewrite.valuation.JFSAValuationReport;
import drr.regulation.jfsa.rewrite.valuation.reports.JFSAValuationReportFunction;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class to demonstrate JFSA valuation reporting without projection.
 * The test validates the transformation of a `ValuationReportInstruction` to a `JFSAValuationReport`,
 * followed by validation.
 */
final class JFSAValuationWithoutProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(JFSAValuationWithoutProjectionTest.class);

    // Function to generate a JFSAValuationReport from a ValuationReportInstruction.
    @Inject
    JFSAValuationReportFunction reportFunc;


    /**
     * Demonstrates JFSA valuation reporting without projection.
     * The test performs the following steps:
     * - Loads a `ValuationReportInstruction` from JSON.
     * - Generates an `JFSAValuationReport` and validates it.
     *
     * @throws IOException If there is an error during file reading or writing.
     */
    @Test
    void JfsaValuationWithoutProjectionExampleTest() throws IOException {
        // Load a ValuationReportInstruction from the input test data.
        ValuationReportInstruction valuationReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                ValuationReportInstruction.class,
                "regulatory-reporting/input/valuation/Valuation-ex01.json"
        );
        assertNotNull(valuationReportInstruction, "No reportable event was found");

        // Generate the JFSA valuation report.
        JFSAValuationReport report = runReport(valuationReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results.
        ValidationReport validationReport = validator.runProcessStep(JFSAValuationReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);

    }

    /**
     * Generates a JFSA valuation report from a `ReportableValuation`.
     *
     * @param valuationReportInstruction The valuation report instruction input.
     * @return The generated JFSAValuationReport.
     * @throws IOException If there is an error during processing.
     */
    JFSAValuationReport runReport(ValuationReportInstruction valuationReportInstruction) throws IOException {

        // Generate the JFSA valuation report.
        final JFSAValuationReport report = reportFunc.evaluate(valuationReportInstruction);

        // Print the generated report in JSON format for debugging.
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }
}

