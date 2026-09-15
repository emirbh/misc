package drr.regulation.asic.rewrite.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import drr.regulation.asic.rewrite.valuation.validation.ASICValuationReportTypeFormatValidator;
import drr.regulation.asic.rewrite.valuation.validation.ASICValuationReportValidator;
import drr.regulation.asic.rewrite.valuation.validation.datarule.ASICValuationReportDTCC_ASIC_BR_1006_01;
import drr.regulation.asic.rewrite.valuation.validation.datarule.ASICValuationReportDTCC_ASIC_BR_1007_01;
import drr.regulation.asic.rewrite.valuation.validation.datarule.ASICValuationReportDTCC_ASIC_BR_1013_01;
import drr.regulation.asic.rewrite.valuation.validation.datarule.ASICValuationReportDTCC_ASIC_BR_1013a_01;
import drr.regulation.asic.rewrite.valuation.validation.datarule.ASICValuationReportDTCC_ASIC_BR_1103_02;
import drr.regulation.asic.rewrite.valuation.validation.datarule.ASICValuationReportDTCC_ASIC_BR_2008_01;
import drr.regulation.asic.rewrite.valuation.validation.datarule.ASICValuationReportDTCC_ASIC_BR_2010_01;
import drr.regulation.asic.rewrite.valuation.validation.exists.ASICValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ASICValuationReport.class)
public class ASICValuationReportMeta implements RosettaMetaData<ASICValuationReport> {

	@Override
	public List<Validator<? super ASICValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ASICValuationReport>create(ASICValuationReportDTCC_ASIC_BR_1006_01.class),
			factory.<ASICValuationReport>create(ASICValuationReportDTCC_ASIC_BR_1007_01.class),
			factory.<ASICValuationReport>create(ASICValuationReportDTCC_ASIC_BR_1013_01.class),
			factory.<ASICValuationReport>create(ASICValuationReportDTCC_ASIC_BR_1103_02.class),
			factory.<ASICValuationReport>create(ASICValuationReportDTCC_ASIC_BR_2008_01.class),
			factory.<ASICValuationReport>create(ASICValuationReportDTCC_ASIC_BR_2010_01.class),
			factory.<ASICValuationReport>create(ASICValuationReportDTCC_ASIC_BR_1013a_01.class)
		);
	}
	
	@Override
	public List<Function<? super ASICValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ASICValuationReport> validator(ValidatorFactory factory) {
		return factory.<ASICValuationReport>create(ASICValuationReportValidator.class);
	}

	@Override
	public Validator<? super ASICValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ASICValuationReport>create(ASICValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ASICValuationReport> validator() {
		return new ASICValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ASICValuationReport> typeFormatValidator() {
		return new ASICValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ASICValuationReport, Set<String>> onlyExistsValidator() {
		return new ASICValuationReportOnlyExistsValidator();
	}
}
