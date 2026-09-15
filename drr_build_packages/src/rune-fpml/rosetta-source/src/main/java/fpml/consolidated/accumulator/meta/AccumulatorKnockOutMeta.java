package fpml.consolidated.accumulator.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.accumulator.AccumulatorKnockOut;
import fpml.consolidated.accumulator.validation.AccumulatorKnockOutTypeFormatValidator;
import fpml.consolidated.accumulator.validation.AccumulatorKnockOutValidator;
import fpml.consolidated.accumulator.validation.datarule.AccumulatorKnockOutChoice;
import fpml.consolidated.accumulator.validation.exists.AccumulatorKnockOutOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccumulatorKnockOut.class)
public class AccumulatorKnockOutMeta implements RosettaMetaData<AccumulatorKnockOut> {

	@Override
	public List<Validator<? super AccumulatorKnockOut>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AccumulatorKnockOut>create(AccumulatorKnockOutChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AccumulatorKnockOut, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccumulatorKnockOut> validator(ValidatorFactory factory) {
		return factory.<AccumulatorKnockOut>create(AccumulatorKnockOutValidator.class);
	}

	@Override
	public Validator<? super AccumulatorKnockOut> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccumulatorKnockOut>create(AccumulatorKnockOutTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccumulatorKnockOut> validator() {
		return new AccumulatorKnockOutValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccumulatorKnockOut> typeFormatValidator() {
		return new AccumulatorKnockOutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccumulatorKnockOut, Set<String>> onlyExistsValidator() {
		return new AccumulatorKnockOutOnlyExistsValidator();
	}
}
