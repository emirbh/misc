package fpml.consolidated.eqd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityEuropeanExercise;
import fpml.consolidated.eqd.validation.EquityEuropeanExerciseTypeFormatValidator;
import fpml.consolidated.eqd.validation.EquityEuropeanExerciseValidator;
import fpml.consolidated.eqd.validation.datarule.EquityEuropeanExerciseChoice;
import fpml.consolidated.eqd.validation.exists.EquityEuropeanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityEuropeanExercise.class)
public class EquityEuropeanExerciseMeta implements RosettaMetaData<EquityEuropeanExercise> {

	@Override
	public List<Validator<? super EquityEuropeanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EquityEuropeanExercise>create(EquityEuropeanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityEuropeanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityEuropeanExercise> validator(ValidatorFactory factory) {
		return factory.<EquityEuropeanExercise>create(EquityEuropeanExerciseValidator.class);
	}

	@Override
	public Validator<? super EquityEuropeanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityEuropeanExercise>create(EquityEuropeanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityEuropeanExercise> validator() {
		return new EquityEuropeanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityEuropeanExercise> typeFormatValidator() {
		return new EquityEuropeanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityEuropeanExercise, Set<String>> onlyExistsValidator() {
		return new EquityEuropeanExerciseOnlyExistsValidator();
	}
}
