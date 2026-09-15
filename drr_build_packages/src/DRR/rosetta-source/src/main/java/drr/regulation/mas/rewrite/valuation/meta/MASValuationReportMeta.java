package drr.regulation.mas.rewrite.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.mas.rewrite.valuation.MASValuationReport;
import drr.regulation.mas.rewrite.valuation.validation.MASValuationReportTypeFormatValidator;
import drr.regulation.mas.rewrite.valuation.validation.MASValuationReportValidator;
import drr.regulation.mas.rewrite.valuation.validation.datarule.MASValuationReportDTCC_MAS_BR_0001_01;
import drr.regulation.mas.rewrite.valuation.validation.datarule.MASValuationReportDTCC_MAS_BR_0001a_01;
import drr.regulation.mas.rewrite.valuation.validation.datarule.MASValuationReportDTCC_MAS_BR_0002_01;
import drr.regulation.mas.rewrite.valuation.validation.datarule.MASValuationReportDTCC_MAS_BR_0002a_01;
import drr.regulation.mas.rewrite.valuation.validation.datarule.MASValuationReportDTCC_MAS_BR_0050_03;
import drr.regulation.mas.rewrite.valuation.validation.datarule.MASValuationReportDTCC_MAS_BR_0054_01;
import drr.regulation.mas.rewrite.valuation.validation.exists.MASValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=MASValuationReport.class)
public class MASValuationReportMeta implements RosettaMetaData<MASValuationReport> {

	@Override
	public List<Validator<? super MASValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MASValuationReport>create(MASValuationReportDTCC_MAS_BR_0001_01.class),
			factory.<MASValuationReport>create(MASValuationReportDTCC_MAS_BR_0002_01.class),
			factory.<MASValuationReport>create(MASValuationReportDTCC_MAS_BR_0050_03.class),
			factory.<MASValuationReport>create(MASValuationReportDTCC_MAS_BR_0054_01.class),
			factory.<MASValuationReport>create(MASValuationReportDTCC_MAS_BR_0001a_01.class),
			factory.<MASValuationReport>create(MASValuationReportDTCC_MAS_BR_0002a_01.class)
		);
	}
	
	@Override
	public List<Function<? super MASValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MASValuationReport> validator(ValidatorFactory factory) {
		return factory.<MASValuationReport>create(MASValuationReportValidator.class);
	}

	@Override
	public Validator<? super MASValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MASValuationReport>create(MASValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MASValuationReport> validator() {
		return new MASValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MASValuationReport> typeFormatValidator() {
		return new MASValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MASValuationReport, Set<String>> onlyExistsValidator() {
		return new MASValuationReportOnlyExistsValidator();
	}
}
