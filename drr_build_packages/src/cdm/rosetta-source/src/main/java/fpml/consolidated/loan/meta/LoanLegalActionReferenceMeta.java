package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionReference;
import fpml.consolidated.loan.validation.LoanLegalActionReferenceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionReferenceValidator;
import fpml.consolidated.loan.validation.exists.LoanLegalActionReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionReference.class)
public class LoanLegalActionReferenceMeta implements RosettaMetaData<LoanLegalActionReference> {

	@Override
	public List<Validator<? super LoanLegalActionReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionReference> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionReference>create(LoanLegalActionReferenceValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionReference>create(LoanLegalActionReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionReference> validator() {
		return new LoanLegalActionReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionReference> typeFormatValidator() {
		return new LoanLegalActionReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionReference, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionReferenceOnlyExistsValidator();
	}
}
