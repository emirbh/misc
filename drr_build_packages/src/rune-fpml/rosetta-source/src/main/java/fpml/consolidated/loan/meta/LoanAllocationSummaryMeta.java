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
import fpml.consolidated.loan.LoanAllocationSummary;
import fpml.consolidated.loan.validation.LoanAllocationSummaryTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationSummaryValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationSummary.class)
public class LoanAllocationSummaryMeta implements RosettaMetaData<LoanAllocationSummary> {

	@Override
	public List<Validator<? super LoanAllocationSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeIdentifier>create(TradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationSummary> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationSummary>create(LoanAllocationSummaryValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationSummary>create(LoanAllocationSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSummary> validator() {
		return new LoanAllocationSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSummary> typeFormatValidator() {
		return new LoanAllocationSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSummary, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSummaryOnlyExistsValidator();
	}
}
