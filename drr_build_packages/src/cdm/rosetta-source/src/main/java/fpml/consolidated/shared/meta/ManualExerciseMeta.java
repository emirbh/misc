package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ManualExercise;
import fpml.consolidated.shared.validation.ManualExerciseTypeFormatValidator;
import fpml.consolidated.shared.validation.ManualExerciseValidator;
import fpml.consolidated.shared.validation.exists.ManualExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ManualExercise.class)
public class ManualExerciseMeta implements RosettaMetaData<ManualExercise> {

	@Override
	public List<Validator<? super ManualExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ManualExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ManualExercise> validator(ValidatorFactory factory) {
		return factory.<ManualExercise>create(ManualExerciseValidator.class);
	}

	@Override
	public Validator<? super ManualExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ManualExercise>create(ManualExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ManualExercise> validator() {
		return new ManualExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ManualExercise> typeFormatValidator() {
		return new ManualExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ManualExercise, Set<String>> onlyExistsValidator() {
		return new ManualExerciseOnlyExistsValidator();
	}
}
