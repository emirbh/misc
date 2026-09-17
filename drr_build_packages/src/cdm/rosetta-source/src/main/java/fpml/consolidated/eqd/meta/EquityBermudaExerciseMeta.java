package fpml.consolidated.eqd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityBermudaExercise;
import fpml.consolidated.eqd.validation.EquityBermudaExerciseTypeFormatValidator;
import fpml.consolidated.eqd.validation.EquityBermudaExerciseValidator;
import fpml.consolidated.eqd.validation.datarule.EquityBermudaExerciseChoice;
import fpml.consolidated.eqd.validation.exists.EquityBermudaExerciseOnlyExistsValidator;
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
@RosettaMeta(model=EquityBermudaExercise.class)
public class EquityBermudaExerciseMeta implements RosettaMetaData<EquityBermudaExercise> {

	@Override
	public List<Validator<? super EquityBermudaExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SharedAmericanExercise>create(SharedAmericanExerciseChoice.class),
			factory.<EquityBermudaExercise>create(EquityBermudaExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityBermudaExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityBermudaExercise> validator(ValidatorFactory factory) {
		return factory.<EquityBermudaExercise>create(EquityBermudaExerciseValidator.class);
	}

	@Override
	public Validator<? super EquityBermudaExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityBermudaExercise>create(EquityBermudaExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityBermudaExercise> validator() {
		return new EquityBermudaExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityBermudaExercise> typeFormatValidator() {
		return new EquityBermudaExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityBermudaExercise, Set<String>> onlyExistsValidator() {
		return new EquityBermudaExerciseOnlyExistsValidator();
	}
}
