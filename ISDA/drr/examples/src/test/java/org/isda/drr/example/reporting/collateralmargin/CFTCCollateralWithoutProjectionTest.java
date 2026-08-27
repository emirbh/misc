package org.isda.drr.example.reporting.collateralmargin;

import com.regnosys.drr.examples.util.ResourcesUtils;
import com.regnosys.rosetta.common.validation.ValidationReport;
import drr.regulation.cftc.rewrite.margin.CFTCMarginReport;
import drr.regulation.cftc.rewrite.margin.reports.CFTCMarginReportFunction;
import drr.regulation.common.CollateralReportInstruction;
import jakarta.inject.Inject;
import org.isda.drr.example.AbstractReportingTest;
import org.isda.drr.example.util.ReportingTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class to demonstrate CFTC collateral reporting without projection.
 * This class validates the transformation of a `CollateralReportInstruction` to a `CFTCMarginReport`,
 * followed by validation.
 */
final class CFTCCollateralWithoutProjectionTest extends AbstractReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(CFTCCollateralWithoutProjectionTest.class);

    // Function to generate a CFTC Margin Report from a CollateralReportInstruction
    @Inject
    CFTCMarginReportFunction reportFunc;

    /**
     * Demonstrates CFTC collateral reporting without projection.
     * The test performs the following steps:
     * - Loads a `CollateralReportInstruction` from JSON.
     * - Generates a `CFTCMarginReport` and validates it.
     *
     * @throws IOException If there is an error during file reading or processing.
     */
    @Test
    void CFTCCollateralWithoutProjectionExampleTest() throws IOException {
        // Load a CollateralReportInstruction from the input test data
        CollateralReportInstruction collateralReportInstruction = ResourcesUtils.getObjectAndResolveReferences(
                CollateralReportInstruction.class,
                "regulatory-reporting/input/collateral/Collateral-ex01.json"
        );
        assertNotNull(collateralReportInstruction, "No reportable collateral was found");

        // Generate the CFTC margin report
        CFTCMarginReport report = runReport(collateralReportInstruction);
        assertNotNull(report, "The report is null");

        // Validate the report and print validation results
        ValidationReport validationReport = validator.runProcessStep(CFTCMarginReport.class, report.toBuilder());
        ReportingTestUtils.printValidation(validationReport);
    }

    /**
     * Generates a CFTC margin report from a `ReportableCollateral`.
     *
     * @param collateralReportInstruction The collateral report instruction input.
     * @return The generated CFTCMarginReport.
     * @throws IOException If there is an error during processing.
     */
    CFTCMarginReport runReport(CollateralReportInstruction collateralReportInstruction) throws IOException {

        // Generate the CFTC margin report
        final CFTCMarginReport report = reportFunc.evaluate(collateralReportInstruction);

        // Print the generated report in JSON format for debugging
        logger.debug(objectWriter.writeValueAsString(report));

        return report;
    }
}
