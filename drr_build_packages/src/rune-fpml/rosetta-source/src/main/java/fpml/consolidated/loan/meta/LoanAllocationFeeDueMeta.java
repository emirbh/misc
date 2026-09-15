package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationFeeDue;
import fpml.consolidated.loan.validation.LoanAllocationFeeDueTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationFeeDueValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationFeeDueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationFeeDue.class)
public class LoanAllocationFeeDueMeta implements RosettaMetaData<LoanAllocationFeeDue> {

	@Override
	public List<Validator<? super LoanAllocationFeeDue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationFeeDue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationFeeDue> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationFeeDue>create(LoanAllocationFeeDueValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationFeeDue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationFeeDue>create(LoanAllocationFeeDueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationFeeDue> validator() {
		return new LoanAllocationFeeDueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationFeeDue> typeFormatValidator() {
		return new LoanAllocationFeeDueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationFeeDue, Set<String>> onlyExistsValidator() {
		return new LoanAllocationFeeDueOnlyExistsValidator();
	}
}
