package org.isda.drr.example.reporting.collateralmargin;

import jakarta.inject.Inject;
import com.regnosys.drr.examples.util.ResourcesUtils;
import com.regnosys.rosetta.common.validation.ValidationReport;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.csa.rewrite.margin.CSAMarginReport;
import drr.regulation.csa.rewrite.margin.reports.CSAMarginReportFunction;
import org.isda.drr.example.AbstractReportingTest;
import org.isda.drr.example.util.ReportingTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class to demonstrate CSA collateral reporting without projection.
 * This class validates the transformation of a `CollateralReportInstruction` to a `CSAMarginReport`,
 * followed by validation.
 */
final class CSACollateralWithoutProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(CSACollateralWithoutProjectionTest.class);

    // Function to generate a CSA Margin Report from a CollateralReportInstruction
    @Inject
    CSAMarginReportFunction reportFunc;

    /**
     * Demonstrates CSA collateral reporting without projection.
     * The test performs the following steps:
     * - Loads a `CollateralReportInstruction` from JSON.
     * - Generates a `CSAMarginReport` and validates it.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void CSACollateralWithoutProjectionExampleTest() throws IOException {
        // Load a CollateralReportInstruction from the input test data
        CollateralReportInstruction collateralReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                CollateralReportInstruction.class,
                "regulatory-reporting/input/collateral/Collateral-ex01.json"
        );
        assertNotNull(collateralReportInstruction, "No reportable collateral was found");

        // Generate the CSA margin report
        CSAMarginReport report = runReport(collateralReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results
        ValidationReport validationReport = validator.runProcessStep(CSAMarginReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);
    }

    /**
     * Generates a CSA margin report from a `ReportableCollateral`.
     *
     * @param collateralReportInstruction The collateral report instruction input.
     * @return The generated CSAMarginReport.
     * @throws IOException If there is an error during processing.
     */
    CSAMarginReport runReport(CollateralReportInstruction collateralReportInstruction) throws IOException {
        // Generate the CSA margin report
        final CSAMarginReport report = reportFunc.evaluate(collateralReportInstruction);

        // Print the generated report in JSON format for debugging
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }
}
