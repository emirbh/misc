package cdm.legaldocumentation.transaction.meta;

import cdm.legaldocumentation.transaction.ExtraordinaryEvents;
import cdm.legaldocumentation.transaction.validation.ExtraordinaryEventsTypeFormatValidator;
import cdm.legaldocumentation.transaction.validation.ExtraordinaryEventsValidator;
import cdm.legaldocumentation.transaction.validation.datarule.ExtraordinaryEventsExtraordinaryEventsChoice;
import cdm.legaldocumentation.transaction.validation.exists.ExtraordinaryEventsOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=ExtraordinaryEvents.class)
public class ExtraordinaryEventsMeta implements RosettaMetaData<ExtraordinaryEvents> {

	@Override
	public List<Validator<? super ExtraordinaryEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExtraordinaryEvents>create(ExtraordinaryEventsExtraordinaryEventsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExtraordinaryEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExtraordinaryEvents> validator(ValidatorFactory factory) {
		return factory.<ExtraordinaryEvents>create(ExtraordinaryEventsValidator.class);
	}

	@Override
	public Validator<? super ExtraordinaryEvents> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExtraordinaryEvents>create(ExtraordinaryEventsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExtraordinaryEvents> validator() {
		return new ExtraordinaryEventsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExtraordinaryEvents> typeFormatValidator() {
		return new ExtraordinaryEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExtraordinaryEvents, Set<String>> onlyExistsValidator() {
		return new ExtraordinaryEventsOnlyExistsValidator();
	}
}
