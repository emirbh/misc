package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.OptionExerciseAmounts;
import fpml.consolidated.business.events.validation.OptionExerciseAmountsTypeFormatValidator;
import fpml.consolidated.business.events.validation.OptionExerciseAmountsValidator;
import fpml.consolidated.business.events.validation.datarule.OptionExerciseAmountsChoice;
import fpml.consolidated.business.events.validation.exists.OptionExerciseAmountsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionExerciseAmounts.class)
public class OptionExerciseAmountsMeta implements RosettaMetaData<OptionExerciseAmounts> {

	@Override
	public List<Validator<? super OptionExerciseAmounts>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OptionExerciseAmounts>create(OptionExerciseAmountsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmounts, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionExerciseAmounts> validator(ValidatorFactory factory) {
		return factory.<OptionExerciseAmounts>create(OptionExerciseAmountsValidator.class);
	}

	@Override
	public Validator<? super OptionExerciseAmounts> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionExerciseAmounts>create(OptionExerciseAmountsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionExerciseAmounts> validator() {
		return new OptionExerciseAmountsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionExerciseAmounts> typeFormatValidator() {
		return new OptionExerciseAmountsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmounts, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountsOnlyExistsValidator();
	}
}
