package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApplicableTransactions;
import fpml.consolidated.loan.validation.ApplicableTransactionsTypeFormatValidator;
import fpml.consolidated.loan.validation.ApplicableTransactionsValidator;
import fpml.consolidated.loan.validation.datarule.ApplicableTransactionsChoice;
import fpml.consolidated.loan.validation.exists.ApplicableTransactionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApplicableTransactions.class)
public class ApplicableTransactionsMeta implements RosettaMetaData<ApplicableTransactions> {

	@Override
	public List<Validator<? super ApplicableTransactions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ApplicableTransactions>create(ApplicableTransactionsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApplicableTransactions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApplicableTransactions> validator(ValidatorFactory factory) {
		return factory.<ApplicableTransactions>create(ApplicableTransactionsValidator.class);
	}

	@Override
	public Validator<? super ApplicableTransactions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApplicableTransactions>create(ApplicableTransactionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableTransactions> validator() {
		return new ApplicableTransactionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableTransactions> typeFormatValidator() {
		return new ApplicableTransactionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableTransactions, Set<String>> onlyExistsValidator() {
		return new ApplicableTransactionsOnlyExistsValidator();
	}
}
