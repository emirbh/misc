package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationMetricAdjustment;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricAdjustmentTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricAdjustmentValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationMetricAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationMetricAdjustment.class)
public class LoanCovenantObligationMetricAdjustmentMeta implements RosettaMetaData<LoanCovenantObligationMetricAdjustment> {

	@Override
	public List<Validator<? super LoanCovenantObligationMetricAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationMetricAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationMetricAdjustment> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetricAdjustment>create(LoanCovenantObligationMetricAdjustmentValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationMetricAdjustment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetricAdjustment>create(LoanCovenantObligationMetricAdjustmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetricAdjustment> validator() {
		return new LoanCovenantObligationMetricAdjustmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetricAdjustment> typeFormatValidator() {
		return new LoanCovenantObligationMetricAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationMetricAdjustment, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationMetricAdjustmentOnlyExistsValidator();
	}
}
