package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MultipleExercise;
import fpml.consolidated.shared.validation.MultipleExerciseTypeFormatValidator;
import fpml.consolidated.shared.validation.MultipleExerciseValidator;
import fpml.consolidated.shared.validation.datarule.MultipleExerciseChoice0;
import fpml.consolidated.shared.validation.datarule.MultipleExerciseChoice1;
import fpml.consolidated.shared.validation.exists.MultipleExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MultipleExercise.class)
public class MultipleExerciseMeta implements RosettaMetaData<MultipleExercise> {

	@Override
	public List<Validator<? super MultipleExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MultipleExercise>create(MultipleExerciseChoice0.class),
			factory.<MultipleExercise>create(MultipleExerciseChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super MultipleExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MultipleExercise> validator(ValidatorFactory factory) {
		return factory.<MultipleExercise>create(MultipleExerciseValidator.class);
	}

	@Override
	public Validator<? super MultipleExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MultipleExercise>create(MultipleExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MultipleExercise> validator() {
		return new MultipleExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MultipleExercise> typeFormatValidator() {
		return new MultipleExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MultipleExercise, Set<String>> onlyExistsValidator() {
		return new MultipleExerciseOnlyExistsValidator();
	}
}
