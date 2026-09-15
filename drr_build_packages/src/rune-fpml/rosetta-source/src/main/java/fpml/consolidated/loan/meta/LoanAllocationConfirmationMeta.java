package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationConfirmation;
import fpml.consolidated.loan.validation.LoanAllocationConfirmationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationConfirmationValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationConfirmationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationConfirmation.class)
public class LoanAllocationConfirmationMeta implements RosettaMetaData<LoanAllocationConfirmation> {

	@Override
	public List<Validator<? super LoanAllocationConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationConfirmation> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationConfirmation>create(LoanAllocationConfirmationValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationConfirmation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationConfirmation>create(LoanAllocationConfirmationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationConfirmation> validator() {
		return new LoanAllocationConfirmationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationConfirmation> typeFormatValidator() {
		return new LoanAllocationConfirmationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationConfirmation, Set<String>> onlyExistsValidator() {
		return new LoanAllocationConfirmationOnlyExistsValidator();
	}
}
