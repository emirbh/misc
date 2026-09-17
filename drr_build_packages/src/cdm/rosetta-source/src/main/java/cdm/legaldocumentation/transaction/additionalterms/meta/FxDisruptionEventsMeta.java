package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.FxDisruptionEvents;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxDisruptionEventsTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxDisruptionEventsValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.FxDisruptionEventsOnlyExistsValidator;
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
@RosettaMeta(model=FxDisruptionEvents.class)
public class FxDisruptionEventsMeta implements RosettaMetaData<FxDisruptionEvents> {

	@Override
	public List<Validator<? super FxDisruptionEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruptionEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDisruptionEvents> validator(ValidatorFactory factory) {
		return factory.<FxDisruptionEvents>create(FxDisruptionEventsValidator.class);
	}

	@Override
	public Validator<? super FxDisruptionEvents> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDisruptionEvents>create(FxDisruptionEventsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionEvents> validator() {
		return new FxDisruptionEventsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionEvents> typeFormatValidator() {
		return new FxDisruptionEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruptionEvents, Set<String>> onlyExistsValidator() {
		return new FxDisruptionEventsOnlyExistsValidator();
	}
}
