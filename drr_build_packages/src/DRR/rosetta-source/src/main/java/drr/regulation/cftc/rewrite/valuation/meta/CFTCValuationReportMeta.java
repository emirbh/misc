package drr.regulation.cftc.rewrite.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.cftc.rewrite.valuation.CFTCValuationReport;
import drr.regulation.cftc.rewrite.valuation.validation.CFTCValuationReportTypeFormatValidator;
import drr.regulation.cftc.rewrite.valuation.validation.CFTCValuationReportValidator;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportCFTC_VR_0026_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportCFTC_VR_0102_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportCFTC_VR_0103_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportCFTC_VR_0109_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportCFTC_VR_0112_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_0014_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_0015_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_0103_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_0116_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_0124_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_DTCC_01;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_DTCC_02;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_DTCC_03;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_DTCC_04;
import drr.regulation.cftc.rewrite.valuation.validation.datarule.CFTCValuationReportDTCC_CFTC_VR_DTCC_05;
import drr.regulation.cftc.rewrite.valuation.validation.exists.CFTCValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CFTCValuationReport.class)
public class CFTCValuationReportMeta implements RosettaMetaData<CFTCValuationReport> {

	@Override
	public List<Validator<? super CFTCValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_0014_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_0015_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportCFTC_VR_0026_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportCFTC_VR_0102_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportCFTC_VR_0103_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_0103_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportCFTC_VR_0109_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportCFTC_VR_0112_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_0116_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_0124_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_DTCC_01.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_DTCC_02.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_DTCC_03.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_DTCC_04.class),
			factory.<CFTCValuationReport>create(CFTCValuationReportDTCC_CFTC_VR_DTCC_05.class)
		);
	}
	
	@Override
	public List<Function<? super CFTCValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CFTCValuationReport> validator(ValidatorFactory factory) {
		return factory.<CFTCValuationReport>create(CFTCValuationReportValidator.class);
	}

	@Override
	public Validator<? super CFTCValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CFTCValuationReport>create(CFTCValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CFTCValuationReport> validator() {
		return new CFTCValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CFTCValuationReport> typeFormatValidator() {
		return new CFTCValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CFTCValuationReport, Set<String>> onlyExistsValidator() {
		return new CFTCValuationReportOnlyExistsValidator();
	}
}
