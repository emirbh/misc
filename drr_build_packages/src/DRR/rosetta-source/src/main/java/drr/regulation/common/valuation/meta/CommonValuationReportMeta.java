package drr.regulation.common.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.valuation.CommonValuationReport;
import drr.regulation.common.valuation.validation.CommonValuationReportTypeFormatValidator;
import drr.regulation.common.valuation.validation.CommonValuationReportValidator;
import drr.regulation.common.valuation.validation.exists.CommonValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CommonValuationReport.class)
public class CommonValuationReportMeta implements RosettaMetaData<CommonValuationReport> {

	@Override
	public List<Validator<? super CommonValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonValuationReport> validator(ValidatorFactory factory) {
		return factory.<CommonValuationReport>create(CommonValuationReportValidator.class);
	}

	@Override
	public Validator<? super CommonValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonValuationReport>create(CommonValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonValuationReport> validator() {
		return new CommonValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonValuationReport> typeFormatValidator() {
		return new CommonValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonValuationReport, Set<String>> onlyExistsValidator() {
		return new CommonValuationReportOnlyExistsValidator();
	}
}
