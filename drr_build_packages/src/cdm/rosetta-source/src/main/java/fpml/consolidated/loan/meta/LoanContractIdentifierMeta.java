package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ContractIdentifier;
import fpml.consolidated.doc.validation.datarule.ContractIdentifierChoice;
import fpml.consolidated.loan.LoanContractIdentifier;
import fpml.consolidated.loan.validation.LoanContractIdentifierTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanContractIdentifierValidator;
import fpml.consolidated.loan.validation.exists.LoanContractIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanContractIdentifier.class)
public class LoanContractIdentifierMeta implements RosettaMetaData<LoanContractIdentifier> {

	@Override
	public List<Validator<? super LoanContractIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ContractIdentifier>create(ContractIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanContractIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanContractIdentifier> validator(ValidatorFactory factory) {
		return factory.<LoanContractIdentifier>create(LoanContractIdentifierValidator.class);
	}

	@Override
	public Validator<? super LoanContractIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanContractIdentifier>create(LoanContractIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractIdentifier> validator() {
		return new LoanContractIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractIdentifier> typeFormatValidator() {
		return new LoanContractIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractIdentifier, Set<String>> onlyExistsValidator() {
		return new LoanContractIdentifierOnlyExistsValidator();
	}
}
