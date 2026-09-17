package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.FxLinkedNotionalSchedule;
import fpml.consolidated.ird.validation.FxLinkedNotionalScheduleTypeFormatValidator;
import fpml.consolidated.ird.validation.FxLinkedNotionalScheduleValidator;
import fpml.consolidated.ird.validation.exists.FxLinkedNotionalScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxLinkedNotionalSchedule.class)
public class FxLinkedNotionalScheduleMeta implements RosettaMetaData<FxLinkedNotionalSchedule> {

	@Override
	public List<Validator<? super FxLinkedNotionalSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxLinkedNotionalSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxLinkedNotionalSchedule> validator(ValidatorFactory factory) {
		return factory.<FxLinkedNotionalSchedule>create(FxLinkedNotionalScheduleValidator.class);
	}

	@Override
	public Validator<? super FxLinkedNotionalSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxLinkedNotionalSchedule>create(FxLinkedNotionalScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxLinkedNotionalSchedule> validator() {
		return new FxLinkedNotionalScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxLinkedNotionalSchedule> typeFormatValidator() {
		return new FxLinkedNotionalScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxLinkedNotionalSchedule, Set<String>> onlyExistsValidator() {
		return new FxLinkedNotionalScheduleOnlyExistsValidator();
	}
}
