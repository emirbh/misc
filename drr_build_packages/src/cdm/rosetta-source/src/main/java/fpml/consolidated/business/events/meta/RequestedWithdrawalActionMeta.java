package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.RequestedWithdrawalAction;
import fpml.consolidated.business.events.validation.RequestedWithdrawalActionTypeFormatValidator;
import fpml.consolidated.business.events.validation.RequestedWithdrawalActionValidator;
import fpml.consolidated.business.events.validation.exists.RequestedWithdrawalActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestedWithdrawalAction.class)
public class RequestedWithdrawalActionMeta implements RosettaMetaData<RequestedWithdrawalAction> {

	@Override
	public List<Validator<? super RequestedWithdrawalAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestedWithdrawalAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestedWithdrawalAction> validator(ValidatorFactory factory) {
		return factory.<RequestedWithdrawalAction>create(RequestedWithdrawalActionValidator.class);
	}

	@Override
	public Validator<? super RequestedWithdrawalAction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestedWithdrawalAction>create(RequestedWithdrawalActionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestedWithdrawalAction> validator() {
		return new RequestedWithdrawalActionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestedWithdrawalAction> typeFormatValidator() {
		return new RequestedWithdrawalActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestedWithdrawalAction, Set<String>> onlyExistsValidator() {
		return new RequestedWithdrawalActionOnlyExistsValidator();
	}
}
