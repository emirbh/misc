package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.EuropeanExercise;
import fpml.consolidated.shared.validation.EuropeanExerciseTypeFormatValidator;
import fpml.consolidated.shared.validation.EuropeanExerciseValidator;
import fpml.consolidated.shared.validation.exists.EuropeanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EuropeanExercise.class)
public class EuropeanExerciseMeta implements RosettaMetaData<EuropeanExercise> {

	@Override
	public List<Validator<? super EuropeanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EuropeanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EuropeanExercise> validator(ValidatorFactory factory) {
		return factory.<EuropeanExercise>create(EuropeanExerciseValidator.class);
	}

	@Override
	public Validator<? super EuropeanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EuropeanExercise>create(EuropeanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EuropeanExercise> validator() {
		return new EuropeanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EuropeanExercise> typeFormatValidator() {
		return new EuropeanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EuropeanExercise, Set<String>> onlyExistsValidator() {
		return new EuropeanExerciseOnlyExistsValidator();
	}
}
