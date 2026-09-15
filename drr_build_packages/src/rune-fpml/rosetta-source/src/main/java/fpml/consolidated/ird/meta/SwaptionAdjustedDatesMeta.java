package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.SwaptionAdjustedDates;
import fpml.consolidated.ird.validation.SwaptionAdjustedDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.SwaptionAdjustedDatesValidator;
import fpml.consolidated.ird.validation.exists.SwaptionAdjustedDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SwaptionAdjustedDates.class)
public class SwaptionAdjustedDatesMeta implements RosettaMetaData<SwaptionAdjustedDates> {

	@Override
	public List<Validator<? super SwaptionAdjustedDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SwaptionAdjustedDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SwaptionAdjustedDates> validator(ValidatorFactory factory) {
		return factory.<SwaptionAdjustedDates>create(SwaptionAdjustedDatesValidator.class);
	}

	@Override
	public Validator<? super SwaptionAdjustedDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SwaptionAdjustedDates>create(SwaptionAdjustedDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SwaptionAdjustedDates> validator() {
		return new SwaptionAdjustedDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SwaptionAdjustedDates> typeFormatValidator() {
		return new SwaptionAdjustedDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SwaptionAdjustedDates, Set<String>> onlyExistsValidator() {
		return new SwaptionAdjustedDatesOnlyExistsValidator();
	}
}
