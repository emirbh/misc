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
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.validation.LoanContractTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanContractValidator;
import fpml.consolidated.loan.validation.datarule.LoanContractChoice;
import fpml.consolidated.loan.validation.exists.LoanContractOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanContract.class)
public class LoanContractMeta implements RosettaMetaData<LoanContract> {

	@Override
	public List<Validator<? super LoanContract>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ContractIdentifier>create(ContractIdentifierChoice.class),
			factory.<LoanContract>create(LoanContractChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanContract, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanContract> validator(ValidatorFactory factory) {
		return factory.<LoanContract>create(LoanContractValidator.class);
	}

	@Override
	public Validator<? super LoanContract> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanContract>create(LoanContractTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanContract> validator() {
		return new LoanContractValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanContract> typeFormatValidator() {
		return new LoanContractTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContract, Set<String>> onlyExistsValidator() {
		return new LoanContractOnlyExistsValidator();
	}
}
