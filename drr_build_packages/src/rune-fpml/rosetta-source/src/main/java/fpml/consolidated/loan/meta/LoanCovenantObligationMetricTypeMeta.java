package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationMetricType;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricTypeValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationMetricTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationMetricType.class)
public class LoanCovenantObligationMetricTypeMeta implements RosettaMetaData<LoanCovenantObligationMetricType> {

	@Override
	public List<Validator<? super LoanCovenantObligationMetricType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationMetricType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationMetricType> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetricType>create(LoanCovenantObligationMetricTypeValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationMetricType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetricType>create(LoanCovenantObligationMetricTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetricType> validator() {
		return new LoanCovenantObligationMetricTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetricType> typeFormatValidator() {
		return new LoanCovenantObligationMetricTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationMetricType, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationMetricTypeOnlyExistsValidator();
	}
}
