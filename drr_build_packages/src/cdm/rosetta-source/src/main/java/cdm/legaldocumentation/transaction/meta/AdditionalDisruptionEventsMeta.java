package cdm.legaldocumentation.transaction.meta;

import cdm.legaldocumentation.transaction.AdditionalDisruptionEvents;
import cdm.legaldocumentation.transaction.validation.AdditionalDisruptionEventsTypeFormatValidator;
import cdm.legaldocumentation.transaction.validation.AdditionalDisruptionEventsValidator;
import cdm.legaldocumentation.transaction.validation.datarule.AdditionalDisruptionEventsDisruptionEventsDeterminingParty;
import cdm.legaldocumentation.transaction.validation.datarule.AdditionalDisruptionEventsInitialStockLoanRate;
import cdm.legaldocumentation.transaction.validation.datarule.AdditionalDisruptionEventsMaximumStockLoanRate;
import cdm.legaldocumentation.transaction.validation.exists.AdditionalDisruptionEventsOnlyExistsValidator;
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
@RosettaMeta(model=AdditionalDisruptionEvents.class)
public class AdditionalDisruptionEventsMeta implements RosettaMetaData<AdditionalDisruptionEvents> {

	@Override
	public List<Validator<? super AdditionalDisruptionEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdditionalDisruptionEvents>create(AdditionalDisruptionEventsMaximumStockLoanRate.class),
			factory.<AdditionalDisruptionEvents>create(AdditionalDisruptionEventsInitialStockLoanRate.class),
			factory.<AdditionalDisruptionEvents>create(AdditionalDisruptionEventsDisruptionEventsDeterminingParty.class)
		);
	}
	
	@Override
	public List<Function<? super AdditionalDisruptionEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalDisruptionEvents> validator(ValidatorFactory factory) {
		return factory.<AdditionalDisruptionEvents>create(AdditionalDisruptionEventsValidator.class);
	}

	@Override
	public Validator<? super AdditionalDisruptionEvents> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalDisruptionEvents>create(AdditionalDisruptionEventsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalDisruptionEvents> validator() {
		return new AdditionalDisruptionEventsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalDisruptionEvents> typeFormatValidator() {
		return new AdditionalDisruptionEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalDisruptionEvents, Set<String>> onlyExistsValidator() {
		return new AdditionalDisruptionEventsOnlyExistsValidator();
	}
}
