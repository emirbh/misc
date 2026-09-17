package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcFxRevaluation;
import fpml.consolidated.loan.validation.LcFxRevaluationTypeFormatValidator;
import fpml.consolidated.loan.validation.LcFxRevaluationValidator;
import fpml.consolidated.loan.validation.exists.LcFxRevaluationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcFxRevaluation.class)
public class LcFxRevaluationMeta implements RosettaMetaData<LcFxRevaluation> {

	@Override
	public List<Validator<? super LcFxRevaluation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcFxRevaluation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcFxRevaluation> validator(ValidatorFactory factory) {
		return factory.<LcFxRevaluation>create(LcFxRevaluationValidator.class);
	}

	@Override
	public Validator<? super LcFxRevaluation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcFxRevaluation>create(LcFxRevaluationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcFxRevaluation> validator() {
		return new LcFxRevaluationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcFxRevaluation> typeFormatValidator() {
		return new LcFxRevaluationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcFxRevaluation, Set<String>> onlyExistsValidator() {
		return new LcFxRevaluationOnlyExistsValidator();
	}
}
