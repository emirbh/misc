package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableValuation;
import drr.regulation.common.validation.ReportableValuationTypeFormatValidator;
import drr.regulation.common.validation.ReportableValuationValidator;
import drr.regulation.common.validation.exists.ReportableValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableValuation.class)
public class ReportableValuationMeta implements RosettaMetaData<ReportableValuation> {

	@Override
	public List<Validator<? super ReportableValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportableValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableValuation> validator(ValidatorFactory factory) {
		return factory.<ReportableValuation>create(ReportableValuationValidator.class);
	}

	@Override
	public Validator<? super ReportableValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableValuation>create(ReportableValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableValuation> validator() {
		return new ReportableValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableValuation> typeFormatValidator() {
		return new ReportableValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableValuation, Set<String>> onlyExistsValidator() {
		return new ReportableValuationOnlyExistsValidator();
	}
}
