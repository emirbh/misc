package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CoveredTransactions;
import cdm.legaldocumentation.csa.validation.CoveredTransactionsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CoveredTransactionsValidator;
import cdm.legaldocumentation.csa.validation.exists.CoveredTransactionsOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=CoveredTransactions.class)
public class CoveredTransactionsMeta implements RosettaMetaData<CoveredTransactions> {

	@Override
	public List<Validator<? super CoveredTransactions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoveredTransactions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoveredTransactions> validator(ValidatorFactory factory) {
		return factory.<CoveredTransactions>create(CoveredTransactionsValidator.class);
	}

	@Override
	public Validator<? super CoveredTransactions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoveredTransactions>create(CoveredTransactionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoveredTransactions> validator() {
		return new CoveredTransactionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoveredTransactions> typeFormatValidator() {
		return new CoveredTransactionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoveredTransactions, Set<String>> onlyExistsValidator() {
		return new CoveredTransactionsOnlyExistsValidator();
	}
}
