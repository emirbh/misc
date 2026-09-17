package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationReference;
import fpml.consolidated.loan.validation.LoanCovenantObligationReferenceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationReferenceValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationReference.class)
public class LoanCovenantObligationReferenceMeta implements RosettaMetaData<LoanCovenantObligationReference> {

	@Override
	public List<Validator<? super LoanCovenantObligationReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationReference> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationReference>create(LoanCovenantObligationReferenceValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationReference>create(LoanCovenantObligationReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationReference> validator() {
		return new LoanCovenantObligationReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationReference> typeFormatValidator() {
		return new LoanCovenantObligationReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationReference, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationReferenceOnlyExistsValidator();
	}
}
