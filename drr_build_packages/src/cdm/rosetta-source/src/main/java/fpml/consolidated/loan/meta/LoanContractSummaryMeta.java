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
import fpml.consolidated.loan.LoanContractSummary;
import fpml.consolidated.loan.validation.LoanContractSummaryTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanContractSummaryValidator;
import fpml.consolidated.loan.validation.exists.LoanContractSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanContractSummary.class)
public class LoanContractSummaryMeta implements RosettaMetaData<LoanContractSummary> {

	@Override
	public List<Validator<? super LoanContractSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ContractIdentifier>create(ContractIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanContractSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanContractSummary> validator(ValidatorFactory factory) {
		return factory.<LoanContractSummary>create(LoanContractSummaryValidator.class);
	}

	@Override
	public Validator<? super LoanContractSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanContractSummary>create(LoanContractSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractSummary> validator() {
		return new LoanContractSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractSummary> typeFormatValidator() {
		return new LoanContractSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractSummary, Set<String>> onlyExistsValidator() {
		return new LoanContractSummaryOnlyExistsValidator();
	}
}
