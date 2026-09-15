package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.validation.ExerciseNoticeTypeFormatValidator;
import fpml.consolidated.shared.validation.ExerciseNoticeValidator;
import fpml.consolidated.shared.validation.exists.ExerciseNoticeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExerciseNotice.class)
public class ExerciseNoticeMeta implements RosettaMetaData<ExerciseNotice> {

	@Override
	public List<Validator<? super ExerciseNotice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExerciseNotice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExerciseNotice> validator(ValidatorFactory factory) {
		return factory.<ExerciseNotice>create(ExerciseNoticeValidator.class);
	}

	@Override
	public Validator<? super ExerciseNotice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExerciseNotice>create(ExerciseNoticeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseNotice> validator() {
		return new ExerciseNoticeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseNotice> typeFormatValidator() {
		return new ExerciseNoticeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseNotice, Set<String>> onlyExistsValidator() {
		return new ExerciseNoticeOnlyExistsValidator();
	}
}
