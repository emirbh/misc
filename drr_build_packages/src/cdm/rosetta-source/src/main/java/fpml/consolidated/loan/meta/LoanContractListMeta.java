package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanContractList;
import fpml.consolidated.loan.validation.LoanContractListTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanContractListValidator;
import fpml.consolidated.loan.validation.exists.LoanContractListOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanContractList.class)
public class LoanContractListMeta implements RosettaMetaData<LoanContractList> {

	@Override
	public List<Validator<? super LoanContractList>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanContractList, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanContractList> validator(ValidatorFactory factory) {
		return factory.<LoanContractList>create(LoanContractListValidator.class);
	}

	@Override
	public Validator<? super LoanContractList> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanContractList>create(LoanContractListTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractList> validator() {
		return new LoanContractListValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractList> typeFormatValidator() {
		return new LoanContractListTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractList, Set<String>> onlyExistsValidator() {
		return new LoanContractListOnlyExistsValidator();
	}
}
