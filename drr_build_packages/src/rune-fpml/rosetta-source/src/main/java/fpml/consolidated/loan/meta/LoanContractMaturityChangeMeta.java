package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanContractMaturityChange;
import fpml.consolidated.loan.validation.LoanContractMaturityChangeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanContractMaturityChangeValidator;
import fpml.consolidated.loan.validation.exists.LoanContractMaturityChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanContractMaturityChange.class)
public class LoanContractMaturityChangeMeta implements RosettaMetaData<LoanContractMaturityChange> {

	@Override
	public List<Validator<? super LoanContractMaturityChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanContractMaturityChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanContractMaturityChange> validator(ValidatorFactory factory) {
		return factory.<LoanContractMaturityChange>create(LoanContractMaturityChangeValidator.class);
	}

	@Override
	public Validator<? super LoanContractMaturityChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanContractMaturityChange>create(LoanContractMaturityChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractMaturityChange> validator() {
		return new LoanContractMaturityChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractMaturityChange> typeFormatValidator() {
		return new LoanContractMaturityChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractMaturityChange, Set<String>> onlyExistsValidator() {
		return new LoanContractMaturityChangeOnlyExistsValidator();
	}
}
