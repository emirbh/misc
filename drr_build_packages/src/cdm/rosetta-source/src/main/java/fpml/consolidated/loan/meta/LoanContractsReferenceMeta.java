package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanContractsReference;
import fpml.consolidated.loan.validation.LoanContractsReferenceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanContractsReferenceValidator;
import fpml.consolidated.loan.validation.exists.LoanContractsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanContractsReference.class)
public class LoanContractsReferenceMeta implements RosettaMetaData<LoanContractsReference> {

	@Override
	public List<Validator<? super LoanContractsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanContractsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanContractsReference> validator(ValidatorFactory factory) {
		return factory.<LoanContractsReference>create(LoanContractsReferenceValidator.class);
	}

	@Override
	public Validator<? super LoanContractsReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanContractsReference>create(LoanContractsReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractsReference> validator() {
		return new LoanContractsReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractsReference> typeFormatValidator() {
		return new LoanContractsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractsReference, Set<String>> onlyExistsValidator() {
		return new LoanContractsReferenceOnlyExistsValidator();
	}
}
