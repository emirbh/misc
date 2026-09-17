package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationMetric;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationMetricOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationMetric.class)
public class LoanCovenantObligationMetricMeta implements RosettaMetaData<LoanCovenantObligationMetric> {

	@Override
	public List<Validator<? super LoanCovenantObligationMetric>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationMetric, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationMetric> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetric>create(LoanCovenantObligationMetricValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationMetric> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetric>create(LoanCovenantObligationMetricTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetric> validator() {
		return new LoanCovenantObligationMetricValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetric> typeFormatValidator() {
		return new LoanCovenantObligationMetricTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationMetric, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationMetricOnlyExistsValidator();
	}
}
