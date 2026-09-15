package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationMetricCalculationDetails;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricCalculationDetailsTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricCalculationDetailsValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationMetricCalculationDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationMetricCalculationDetails.class)
public class LoanCovenantObligationMetricCalculationDetailsMeta implements RosettaMetaData<LoanCovenantObligationMetricCalculationDetails> {

	@Override
	public List<Validator<? super LoanCovenantObligationMetricCalculationDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationMetricCalculationDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationMetricCalculationDetails> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetricCalculationDetails>create(LoanCovenantObligationMetricCalculationDetailsValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationMetricCalculationDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetricCalculationDetails>create(LoanCovenantObligationMetricCalculationDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetricCalculationDetails> validator() {
		return new LoanCovenantObligationMetricCalculationDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetricCalculationDetails> typeFormatValidator() {
		return new LoanCovenantObligationMetricCalculationDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationMetricCalculationDetails, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationMetricCalculationDetailsOnlyExistsValidator();
	}
}
