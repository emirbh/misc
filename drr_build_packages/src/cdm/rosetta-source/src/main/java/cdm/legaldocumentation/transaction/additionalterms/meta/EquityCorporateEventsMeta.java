package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.EquityCorporateEvents;
import cdm.legaldocumentation.transaction.additionalterms.validation.EquityCorporateEventsTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.EquityCorporateEventsValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.EquityCorporateEventsOnlyExistsValidator;
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
@RosettaMeta(model=EquityCorporateEvents.class)
public class EquityCorporateEventsMeta implements RosettaMetaData<EquityCorporateEvents> {

	@Override
	public List<Validator<? super EquityCorporateEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityCorporateEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityCorporateEvents> validator(ValidatorFactory factory) {
		return factory.<EquityCorporateEvents>create(EquityCorporateEventsValidator.class);
	}

	@Override
	public Validator<? super EquityCorporateEvents> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityCorporateEvents>create(EquityCorporateEventsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityCorporateEvents> validator() {
		return new EquityCorporateEventsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityCorporateEvents> typeFormatValidator() {
		return new EquityCorporateEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityCorporateEvents, Set<String>> onlyExistsValidator() {
		return new EquityCorporateEventsOnlyExistsValidator();
	}
}
