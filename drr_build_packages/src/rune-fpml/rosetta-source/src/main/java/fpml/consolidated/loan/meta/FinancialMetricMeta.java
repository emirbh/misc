package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FinancialMetric;
import fpml.consolidated.loan.validation.FinancialMetricTypeFormatValidator;
import fpml.consolidated.loan.validation.FinancialMetricValidator;
import fpml.consolidated.loan.validation.exists.FinancialMetricOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FinancialMetric.class)
public class FinancialMetricMeta implements RosettaMetaData<FinancialMetric> {

	@Override
	public List<Validator<? super FinancialMetric>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FinancialMetric, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FinancialMetric> validator(ValidatorFactory factory) {
		return factory.<FinancialMetric>create(FinancialMetricValidator.class);
	}

	@Override
	public Validator<? super FinancialMetric> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FinancialMetric>create(FinancialMetricTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FinancialMetric> validator() {
		return new FinancialMetricValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FinancialMetric> typeFormatValidator() {
		return new FinancialMetricTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinancialMetric, Set<String>> onlyExistsValidator() {
		return new FinancialMetricOnlyExistsValidator();
	}
}
