package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AutomaticExercise;
import fpml.consolidated.shared.validation.AutomaticExerciseTypeFormatValidator;
import fpml.consolidated.shared.validation.AutomaticExerciseValidator;
import fpml.consolidated.shared.validation.exists.AutomaticExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AutomaticExercise.class)
public class AutomaticExerciseMeta implements RosettaMetaData<AutomaticExercise> {

	@Override
	public List<Validator<? super AutomaticExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AutomaticExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AutomaticExercise> validator(ValidatorFactory factory) {
		return factory.<AutomaticExercise>create(AutomaticExerciseValidator.class);
	}

	@Override
	public Validator<? super AutomaticExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AutomaticExercise>create(AutomaticExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AutomaticExercise> validator() {
		return new AutomaticExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AutomaticExercise> typeFormatValidator() {
		return new AutomaticExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AutomaticExercise, Set<String>> onlyExistsValidator() {
		return new AutomaticExerciseOnlyExistsValidator();
	}
}
