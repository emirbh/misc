package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.validation.datarule.TradeIdentifierChoice;
import fpml.consolidated.loan.LoanTradeSummary;
import fpml.consolidated.loan.validation.LoanTradeSummaryTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeSummaryValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeSummary.class)
public class LoanTradeSummaryMeta implements RosettaMetaData<LoanTradeSummary> {

	@Override
	public List<Validator<? super LoanTradeSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeIdentifier>create(TradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTradeSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeSummary> validator(ValidatorFactory factory) {
		return factory.<LoanTradeSummary>create(LoanTradeSummaryValidator.class);
	}

	@Override
	public Validator<? super LoanTradeSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeSummary>create(LoanTradeSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeSummary> validator() {
		return new LoanTradeSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeSummary> typeFormatValidator() {
		return new LoanTradeSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeSummary, Set<String>> onlyExistsValidator() {
		return new LoanTradeSummaryOnlyExistsValidator();
	}
}
