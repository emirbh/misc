package drr.regulation.csa.rewrite.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.csa.rewrite.margin.CSAMarginReport;
import drr.regulation.csa.rewrite.margin.validation.CSAMarginReportTypeFormatValidator;
import drr.regulation.csa.rewrite.margin.validation.CSAMarginReportValidator;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0016_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0081_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0082_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0083_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0084_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0085_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0086_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0087_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0088_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0089_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0090_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0091_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0092_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportCSA_VR_0098_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0002_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0003_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0079_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0089_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0092_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0093_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0093_02;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0093_03;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0094_01;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0094_02;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_0094_03;
import drr.regulation.csa.rewrite.margin.validation.datarule.CSAMarginReportDTCC_CSA_VR_DTCC_01;
import drr.regulation.csa.rewrite.margin.validation.exists.CSAMarginReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CSAMarginReport.class)
public class CSAMarginReportMeta implements RosettaMetaData<CSAMarginReport> {

	@Override
	public List<Validator<? super CSAMarginReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0002_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0003_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0016_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0079_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0081_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0082_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0083_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0084_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0085_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0086_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0087_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0088_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0089_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0089_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0090_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0091_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0092_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0092_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0093_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0093_02.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0093_03.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0094_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0094_02.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_0094_03.class),
			factory.<CSAMarginReport>create(CSAMarginReportCSA_VR_0098_01.class),
			factory.<CSAMarginReport>create(CSAMarginReportDTCC_CSA_VR_DTCC_01.class)
		);
	}
	
	@Override
	public List<Function<? super CSAMarginReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSAMarginReport> validator(ValidatorFactory factory) {
		return factory.<CSAMarginReport>create(CSAMarginReportValidator.class);
	}

	@Override
	public Validator<? super CSAMarginReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSAMarginReport>create(CSAMarginReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSAMarginReport> validator() {
		return new CSAMarginReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSAMarginReport> typeFormatValidator() {
		return new CSAMarginReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSAMarginReport, Set<String>> onlyExistsValidator() {
		return new CSAMarginReportOnlyExistsValidator();
	}
}
