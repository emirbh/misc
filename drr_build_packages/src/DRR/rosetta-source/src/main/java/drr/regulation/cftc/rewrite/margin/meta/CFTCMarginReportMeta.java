package drr.regulation.cftc.rewrite.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.cftc.rewrite.margin.CFTCMarginReport;
import drr.regulation.cftc.rewrite.margin.validation.CFTCMarginReportTypeFormatValidator;
import drr.regulation.cftc.rewrite.margin.validation.CFTCMarginReportValidator;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0026_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0102_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0103_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0118_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0119_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0120_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0121_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0122_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0123_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0125_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0126_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0127_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportCFTC_VR_0128_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0013_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0014_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0016_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0115_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0116_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0116_02;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0116_03;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0124_01;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0124_02;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_0124_03;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_DTCC_04;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_DTCC_06;
import drr.regulation.cftc.rewrite.margin.validation.datarule.CFTCMarginReportDTCC_CFTC_VR_DTCC_08;
import drr.regulation.cftc.rewrite.margin.validation.exists.CFTCMarginReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CFTCMarginReport.class)
public class CFTCMarginReportMeta implements RosettaMetaData<CFTCMarginReport> {

	@Override
	public List<Validator<? super CFTCMarginReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0013_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0014_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0016_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0026_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0102_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0103_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0115_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0116_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0116_02.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0116_03.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0118_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0119_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0120_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0121_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0122_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0123_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0124_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0124_02.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_0124_03.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0125_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0126_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0127_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportCFTC_VR_0128_01.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_DTCC_04.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_DTCC_06.class),
			factory.<CFTCMarginReport>create(CFTCMarginReportDTCC_CFTC_VR_DTCC_08.class)
		);
	}
	
	@Override
	public List<Function<? super CFTCMarginReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CFTCMarginReport> validator(ValidatorFactory factory) {
		return factory.<CFTCMarginReport>create(CFTCMarginReportValidator.class);
	}

	@Override
	public Validator<? super CFTCMarginReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CFTCMarginReport>create(CFTCMarginReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CFTCMarginReport> validator() {
		return new CFTCMarginReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CFTCMarginReport> typeFormatValidator() {
		return new CFTCMarginReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CFTCMarginReport, Set<String>> onlyExistsValidator() {
		return new CFTCMarginReportOnlyExistsValidator();
	}
}
