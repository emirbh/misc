package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.validation.NonNegativeAmountScheduleTypeFormatValidator;
import fpml.consolidated.shared.validation.NonNegativeAmountScheduleValidator;
import fpml.consolidated.shared.validation.exists.NonNegativeAmountScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonNegativeAmountSchedule.class)
public class NonNegativeAmountScheduleMeta implements RosettaMetaData<NonNegativeAmountSchedule> {

	@Override
	public List<Validator<? super NonNegativeAmountSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativeAmountSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonNegativeAmountSchedule> validator(ValidatorFactory factory) {
		return factory.<NonNegativeAmountSchedule>create(NonNegativeAmountScheduleValidator.class);
	}

	@Override
	public Validator<? super NonNegativeAmountSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonNegativeAmountSchedule>create(NonNegativeAmountScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeAmountSchedule> validator() {
		return new NonNegativeAmountScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeAmountSchedule> typeFormatValidator() {
		return new NonNegativeAmountScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeAmountSchedule, Set<String>> onlyExistsValidator() {
		return new NonNegativeAmountScheduleOnlyExistsValidator();
	}
}
