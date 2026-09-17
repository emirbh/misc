package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationReference;
import fpml.consolidated.loan.validation.LoanAllocationReferenceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationReferenceValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationReference.class)
public class LoanAllocationReferenceMeta implements RosettaMetaData<LoanAllocationReference> {

	@Override
	public List<Validator<? super LoanAllocationReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationReference> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationReference>create(LoanAllocationReferenceValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationReference>create(LoanAllocationReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationReference> validator() {
		return new LoanAllocationReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationReference> typeFormatValidator() {
		return new LoanAllocationReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationReference, Set<String>> onlyExistsValidator() {
		return new LoanAllocationReferenceOnlyExistsValidator();
	}
}
