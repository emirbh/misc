package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AmericanExercise;
import fpml.consolidated.shared.validation.AmericanExerciseTypeFormatValidator;
import fpml.consolidated.shared.validation.AmericanExerciseValidator;
import fpml.consolidated.shared.validation.exists.AmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AmericanExercise.class)
public class AmericanExerciseMeta implements RosettaMetaData<AmericanExercise> {

	@Override
	public List<Validator<? super AmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmericanExercise> validator(ValidatorFactory factory) {
		return factory.<AmericanExercise>create(AmericanExerciseValidator.class);
	}

	@Override
	public Validator<? super AmericanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmericanExercise>create(AmericanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmericanExercise> validator() {
		return new AmericanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AmericanExercise> typeFormatValidator() {
		return new AmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmericanExercise, Set<String>> onlyExistsValidator() {
		return new AmericanExerciseOnlyExistsValidator();
	}
}
