package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FinancialMetricType;
import fpml.consolidated.loan.validation.FinancialMetricTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.FinancialMetricTypeValidator;
import fpml.consolidated.loan.validation.exists.FinancialMetricTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FinancialMetricType.class)
public class FinancialMetricTypeMeta implements RosettaMetaData<FinancialMetricType> {

	@Override
	public List<Validator<? super FinancialMetricType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FinancialMetricType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FinancialMetricType> validator(ValidatorFactory factory) {
		return factory.<FinancialMetricType>create(FinancialMetricTypeValidator.class);
	}

	@Override
	public Validator<? super FinancialMetricType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FinancialMetricType>create(FinancialMetricTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FinancialMetricType> validator() {
		return new FinancialMetricTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FinancialMetricType> typeFormatValidator() {
		return new FinancialMetricTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinancialMetricType, Set<String>> onlyExistsValidator() {
		return new FinancialMetricTypeOnlyExistsValidator();
	}
}
