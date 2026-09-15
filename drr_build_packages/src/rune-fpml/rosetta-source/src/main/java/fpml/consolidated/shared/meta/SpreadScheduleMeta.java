package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SpreadSchedule;
import fpml.consolidated.shared.validation.SpreadScheduleTypeFormatValidator;
import fpml.consolidated.shared.validation.SpreadScheduleValidator;
import fpml.consolidated.shared.validation.exists.SpreadScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SpreadSchedule.class)
public class SpreadScheduleMeta implements RosettaMetaData<SpreadSchedule> {

	@Override
	public List<Validator<? super SpreadSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpreadSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpreadSchedule> validator(ValidatorFactory factory) {
		return factory.<SpreadSchedule>create(SpreadScheduleValidator.class);
	}

	@Override
	public Validator<? super SpreadSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SpreadSchedule>create(SpreadScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SpreadSchedule> validator() {
		return new SpreadScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SpreadSchedule> typeFormatValidator() {
		return new SpreadScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpreadSchedule, Set<String>> onlyExistsValidator() {
		return new SpreadScheduleOnlyExistsValidator();
	}
}
