package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ResetDates;
import fpml.consolidated.ird.validation.ResetDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.ResetDatesValidator;
import fpml.consolidated.ird.validation.exists.ResetDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResetDates.class)
public class ResetDatesMeta implements RosettaMetaData<ResetDates> {

	@Override
	public List<Validator<? super ResetDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResetDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResetDates> validator(ValidatorFactory factory) {
		return factory.<ResetDates>create(ResetDatesValidator.class);
	}

	@Override
	public Validator<? super ResetDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResetDates>create(ResetDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResetDates> validator() {
		return new ResetDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResetDates> typeFormatValidator() {
		return new ResetDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResetDates, Set<String>> onlyExistsValidator() {
		return new ResetDatesOnlyExistsValidator();
	}
}
