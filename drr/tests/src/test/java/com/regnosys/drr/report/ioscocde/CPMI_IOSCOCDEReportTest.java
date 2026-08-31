package com.regnosys.drr.report.ioscocde;

import com.regnosys.drr.report.ReportTestRuntimeModule;
import com.regnosys.rosetta.common.transform.TestPackModel;
import com.regnosys.testing.transform.TransformTestExtension;
import drr.standards.iosco.cde.version3.reports.CPMI_IOSCOCDEReportFunction;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.regnosys.rosetta.common.transform.TestPackUtils.REPORT_CONFIG_PATH;

public class CPMI_IOSCOCDEReportTest {

    @RegisterExtension
    static TransformTestExtension<CPMI_IOSCOCDEReportFunction> testExtension =
            new TransformTestExtension<>(
                    new ReportTestRuntimeModule(),
                    REPORT_CONFIG_PATH,
                    CPMI_IOSCOCDEReportFunction.class);

    @ParameterizedTest(name = "{0}")
    @MethodSource("inputFiles")
    void runReport(
            String testName,
            String testPackId,
            TestPackModel.SampleModel sampleModel) {
        testExtension.runTransformAndAssert(testPackId, sampleModel);
    }

    @SuppressWarnings("unused")//used by the junit parameterized test
    private static Stream<Arguments> inputFiles() {
        return testExtension.getArguments();
    }
}
