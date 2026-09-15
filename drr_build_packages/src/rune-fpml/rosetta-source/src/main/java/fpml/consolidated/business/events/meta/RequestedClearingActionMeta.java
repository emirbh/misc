package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.RequestedClearingAction;
import fpml.consolidated.business.events.validation.RequestedClearingActionTypeFormatValidator;
import fpml.consolidated.business.events.validation.RequestedClearingActionValidator;
import fpml.consolidated.business.events.validation.exists.RequestedClearingActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestedClearingAction.class)
public class RequestedClearingActionMeta implements RosettaMetaData<RequestedClearingAction> {

	@Override
	public List<Validator<? super RequestedClearingAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestedClearingAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestedClearingAction> validator(ValidatorFactory factory) {
		return factory.<RequestedClearingAction>create(RequestedClearingActionValidator.class);
	}

	@Override
	public Validator<? super RequestedClearingAction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestedClearingAction>create(RequestedClearingActionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestedClearingAction> validator() {
		return new RequestedClearingActionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestedClearingAction> typeFormatValidator() {
		return new RequestedClearingActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestedClearingAction, Set<String>> onlyExistsValidator() {
		return new RequestedClearingActionOnlyExistsValidator();
	}
}
