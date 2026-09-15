package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BermudaExercise;
import fpml.consolidated.shared.validation.BermudaExerciseTypeFormatValidator;
import fpml.consolidated.shared.validation.BermudaExerciseValidator;
import fpml.consolidated.shared.validation.exists.BermudaExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BermudaExercise.class)
public class BermudaExerciseMeta implements RosettaMetaData<BermudaExercise> {

	@Override
	public List<Validator<? super BermudaExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BermudaExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BermudaExercise> validator(ValidatorFactory factory) {
		return factory.<BermudaExercise>create(BermudaExerciseValidator.class);
	}

	@Override
	public Validator<? super BermudaExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BermudaExercise>create(BermudaExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BermudaExercise> validator() {
		return new BermudaExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BermudaExercise> typeFormatValidator() {
		return new BermudaExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BermudaExercise, Set<String>> onlyExistsValidator() {
		return new BermudaExerciseOnlyExistsValidator();
	}
}
