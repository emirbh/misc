package drr.regulation.csa.rewrite.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
import drr.regulation.csa.rewrite.valuation.validation.CSAValuationReportTypeFormatValidator;
import drr.regulation.csa.rewrite.valuation.validation.CSAValuationReportValidator;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportCSA_VR_0098_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportCSA_VR_0103_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportCSA_VR_0108_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_0002_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_0003_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_0016_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_0093_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_0094_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_0108_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_DTCC_01;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_DTCC_02;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_DTCC_03;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_DTCC_04;
import drr.regulation.csa.rewrite.valuation.validation.datarule.CSAValuationReportDTCC_CSA_VR_DTCC_05;
import drr.regulation.csa.rewrite.valuation.validation.exists.CSAValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CSAValuationReport.class)
public class CSAValuationReportMeta implements RosettaMetaData<CSAValuationReport> {

	@Override
	public List<Validator<? super CSAValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_0002_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_0003_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_0016_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_0093_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_0094_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportCSA_VR_0098_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportCSA_VR_0103_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportCSA_VR_0108_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_0108_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_DTCC_01.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_DTCC_02.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_DTCC_03.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_DTCC_04.class),
			factory.<CSAValuationReport>create(CSAValuationReportDTCC_CSA_VR_DTCC_05.class)
		);
	}
	
	@Override
	public List<Function<? super CSAValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSAValuationReport> validator(ValidatorFactory factory) {
		return factory.<CSAValuationReport>create(CSAValuationReportValidator.class);
	}

	@Override
	public Validator<? super CSAValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSAValuationReport>create(CSAValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSAValuationReport> validator() {
		return new CSAValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSAValuationReport> typeFormatValidator() {
		return new CSAValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSAValuationReport, Set<String>> onlyExistsValidator() {
		return new CSAValuationReportOnlyExistsValidator();
	}
}
