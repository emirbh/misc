package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.RightsEvents;
import cdm.legaldocumentation.csa.validation.RightsEventsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.RightsEventsValidator;
import cdm.legaldocumentation.csa.validation.exists.RightsEventsOnlyExistsValidator;
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
@RosettaMeta(model=RightsEvents.class)
public class RightsEventsMeta implements RosettaMetaData<RightsEvents> {

	@Override
	public List<Validator<? super RightsEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RightsEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RightsEvents> validator(ValidatorFactory factory) {
		return factory.<RightsEvents>create(RightsEventsValidator.class);
	}

	@Override
	public Validator<? super RightsEvents> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RightsEvents>create(RightsEventsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RightsEvents> validator() {
		return new RightsEventsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RightsEvents> typeFormatValidator() {
		return new RightsEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RightsEvents, Set<String>> onlyExistsValidator() {
		return new RightsEventsOnlyExistsValidator();
	}
}
