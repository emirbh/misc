package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ActionApproval;
import fpml.consolidated.loan.validation.ActionApprovalTypeFormatValidator;
import fpml.consolidated.loan.validation.ActionApprovalValidator;
import fpml.consolidated.loan.validation.exists.ActionApprovalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ActionApproval.class)
public class ActionApprovalMeta implements RosettaMetaData<ActionApproval> {

	@Override
	public List<Validator<? super ActionApproval>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActionApproval, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ActionApproval> validator(ValidatorFactory factory) {
		return factory.<ActionApproval>create(ActionApprovalValidator.class);
	}

	@Override
	public Validator<? super ActionApproval> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ActionApproval>create(ActionApprovalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ActionApproval> validator() {
		return new ActionApprovalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ActionApproval> typeFormatValidator() {
		return new ActionApprovalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActionApproval, Set<String>> onlyExistsValidator() {
		return new ActionApprovalOnlyExistsValidator();
	}
}
