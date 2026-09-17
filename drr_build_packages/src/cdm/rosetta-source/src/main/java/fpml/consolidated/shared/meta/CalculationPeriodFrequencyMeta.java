package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CalculationPeriodFrequency;
import fpml.consolidated.shared.validation.CalculationPeriodFrequencyTypeFormatValidator;
import fpml.consolidated.shared.validation.CalculationPeriodFrequencyValidator;
import fpml.consolidated.shared.validation.exists.CalculationPeriodFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationPeriodFrequency.class)
public class CalculationPeriodFrequencyMeta implements RosettaMetaData<CalculationPeriodFrequency> {

	@Override
	public List<Validator<? super CalculationPeriodFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriodFrequency> validator(ValidatorFactory factory) {
		return factory.<CalculationPeriodFrequency>create(CalculationPeriodFrequencyValidator.class);
	}

	@Override
	public Validator<? super CalculationPeriodFrequency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationPeriodFrequency>create(CalculationPeriodFrequencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodFrequency> validator() {
		return new CalculationPeriodFrequencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodFrequency> typeFormatValidator() {
		return new CalculationPeriodFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodFrequency, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodFrequencyOnlyExistsValidator();
	}
}
