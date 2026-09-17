package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ExerciseEvent;
import fpml.consolidated.ird.validation.ExerciseEventTypeFormatValidator;
import fpml.consolidated.ird.validation.ExerciseEventValidator;
import fpml.consolidated.ird.validation.exists.ExerciseEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExerciseEvent.class)
public class ExerciseEventMeta implements RosettaMetaData<ExerciseEvent> {

	@Override
	public List<Validator<? super ExerciseEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExerciseEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExerciseEvent> validator(ValidatorFactory factory) {
		return factory.<ExerciseEvent>create(ExerciseEventValidator.class);
	}

	@Override
	public Validator<? super ExerciseEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExerciseEvent>create(ExerciseEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseEvent> validator() {
		return new ExerciseEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseEvent> typeFormatValidator() {
		return new ExerciseEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseEvent, Set<String>> onlyExistsValidator() {
		return new ExerciseEventOnlyExistsValidator();
	}
}
