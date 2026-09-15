package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.AveragingSchedule;
import fpml.consolidated.option.shared.validation.AveragingScheduleTypeFormatValidator;
import fpml.consolidated.option.shared.validation.AveragingScheduleValidator;
import fpml.consolidated.option.shared.validation.exists.AveragingScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AveragingSchedule.class)
public class AveragingScheduleMeta implements RosettaMetaData<AveragingSchedule> {

	@Override
	public List<Validator<? super AveragingSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AveragingSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AveragingSchedule> validator(ValidatorFactory factory) {
		return factory.<AveragingSchedule>create(AveragingScheduleValidator.class);
	}

	@Override
	public Validator<? super AveragingSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AveragingSchedule>create(AveragingScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AveragingSchedule> validator() {
		return new AveragingScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AveragingSchedule> typeFormatValidator() {
		return new AveragingScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AveragingSchedule, Set<String>> onlyExistsValidator() {
		return new AveragingScheduleOnlyExistsValidator();
	}
}
