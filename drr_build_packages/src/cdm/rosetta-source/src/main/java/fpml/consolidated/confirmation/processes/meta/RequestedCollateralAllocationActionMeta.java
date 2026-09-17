package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestedCollateralAllocationAction;
import fpml.consolidated.confirmation.processes.validation.RequestedCollateralAllocationActionTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestedCollateralAllocationActionValidator;
import fpml.consolidated.confirmation.processes.validation.exists.RequestedCollateralAllocationActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestedCollateralAllocationAction.class)
public class RequestedCollateralAllocationActionMeta implements RosettaMetaData<RequestedCollateralAllocationAction> {

	@Override
	public List<Validator<? super RequestedCollateralAllocationAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestedCollateralAllocationAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestedCollateralAllocationAction> validator(ValidatorFactory factory) {
		return factory.<RequestedCollateralAllocationAction>create(RequestedCollateralAllocationActionValidator.class);
	}

	@Override
	public Validator<? super RequestedCollateralAllocationAction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestedCollateralAllocationAction>create(RequestedCollateralAllocationActionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestedCollateralAllocationAction> validator() {
		return new RequestedCollateralAllocationActionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestedCollateralAllocationAction> typeFormatValidator() {
		return new RequestedCollateralAllocationActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestedCollateralAllocationAction, Set<String>> onlyExistsValidator() {
		return new RequestedCollateralAllocationActionOnlyExistsValidator();
	}
}
