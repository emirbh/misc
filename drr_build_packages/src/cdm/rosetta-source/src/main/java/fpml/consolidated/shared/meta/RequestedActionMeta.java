package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RequestedAction;
import fpml.consolidated.shared.validation.RequestedActionTypeFormatValidator;
import fpml.consolidated.shared.validation.RequestedActionValidator;
import fpml.consolidated.shared.validation.exists.RequestedActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestedAction.class)
public class RequestedActionMeta implements RosettaMetaData<RequestedAction> {

	@Override
	public List<Validator<? super RequestedAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestedAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestedAction> validator(ValidatorFactory factory) {
		return factory.<RequestedAction>create(RequestedActionValidator.class);
	}

	@Override
	public Validator<? super RequestedAction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestedAction>create(RequestedActionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestedAction> validator() {
		return new RequestedActionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestedAction> typeFormatValidator() {
		return new RequestedActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestedAction, Set<String>> onlyExistsValidator() {
		return new RequestedActionOnlyExistsValidator();
	}
}
