package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractApproval;
import fpml.consolidated.loan.validation.AbstractApprovalTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractApprovalValidator;
import fpml.consolidated.loan.validation.exists.AbstractApprovalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractApproval.class)
public class AbstractApprovalMeta implements RosettaMetaData<AbstractApproval> {

	@Override
	public List<Validator<? super AbstractApproval>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractApproval, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractApproval> validator(ValidatorFactory factory) {
		return factory.<AbstractApproval>create(AbstractApprovalValidator.class);
	}

	@Override
	public Validator<? super AbstractApproval> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractApproval>create(AbstractApprovalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractApproval> validator() {
		return new AbstractApprovalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractApproval> typeFormatValidator() {
		return new AbstractApprovalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractApproval, Set<String>> onlyExistsValidator() {
		return new AbstractApprovalOnlyExistsValidator();
	}
}
