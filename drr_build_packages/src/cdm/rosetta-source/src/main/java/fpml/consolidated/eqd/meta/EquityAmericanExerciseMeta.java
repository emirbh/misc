package fpml.consolidated.eqd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityAmericanExercise;
import fpml.consolidated.eqd.validation.EquityAmericanExerciseTypeFormatValidator;
import fpml.consolidated.eqd.validation.EquityAmericanExerciseValidator;
import fpml.consolidated.eqd.validation.datarule.EquityAmericanExerciseChoice;
import fpml.consolidated.eqd.validation.exists.EquityAmericanExerciseOnlyExistsValidator;
import fpml.consolidated.shared.SharedAmericanExercise;
import fpml.consolidated.shared.validation.datarule.SharedAmericanExerciseChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityAmericanExercise.class)
public class EquityAmericanExerciseMeta implements RosettaMetaData<EquityAmericanExercise> {

	@Override
	public List<Validator<? super EquityAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SharedAmericanExercise>create(SharedAmericanExerciseChoice.class),
			factory.<EquityAmericanExercise>create(EquityAmericanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityAmericanExercise> validator(ValidatorFactory factory) {
		return factory.<EquityAmericanExercise>create(EquityAmericanExerciseValidator.class);
	}

	@Override
	public Validator<? super EquityAmericanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityAmericanExercise>create(EquityAmericanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityAmericanExercise> validator() {
		return new EquityAmericanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityAmericanExercise> typeFormatValidator() {
		return new EquityAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityAmericanExercise, Set<String>> onlyExistsValidator() {
		return new EquityAmericanExerciseOnlyExistsValidator();
	}
}
