package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.validation.OptionExerciseTypeFormatValidator;
import fpml.consolidated.business.events.validation.OptionExerciseValidator;
import fpml.consolidated.business.events.validation.datarule.OptionExerciseChoice0;
import fpml.consolidated.business.events.validation.datarule.OptionExerciseChoice1;
import fpml.consolidated.business.events.validation.datarule.OptionExerciseChoice2;
import fpml.consolidated.business.events.validation.datarule.OptionExerciseChoice3;
import fpml.consolidated.business.events.validation.exists.OptionExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionExercise.class)
public class OptionExerciseMeta implements RosettaMetaData<OptionExercise> {

	@Override
	public List<Validator<? super OptionExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OptionExercise>create(OptionExerciseChoice0.class),
			factory.<OptionExercise>create(OptionExerciseChoice1.class),
			factory.<OptionExercise>create(OptionExerciseChoice2.class),
			factory.<OptionExercise>create(OptionExerciseChoice3.class)
		);
	}
	
	@Override
	public List<Function<? super OptionExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionExercise> validator(ValidatorFactory factory) {
		return factory.<OptionExercise>create(OptionExerciseValidator.class);
	}

	@Override
	public Validator<? super OptionExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionExercise>create(OptionExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionExercise> validator() {
		return new OptionExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionExercise> typeFormatValidator() {
		return new OptionExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExercise, Set<String>> onlyExistsValidator() {
		return new OptionExerciseOnlyExistsValidator();
	}
}
