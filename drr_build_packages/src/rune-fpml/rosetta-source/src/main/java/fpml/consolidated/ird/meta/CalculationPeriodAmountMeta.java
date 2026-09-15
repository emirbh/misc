package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.ird.validation.CalculationPeriodAmountTypeFormatValidator;
import fpml.consolidated.ird.validation.CalculationPeriodAmountValidator;
import fpml.consolidated.ird.validation.datarule.CalculationPeriodAmountChoice;
import fpml.consolidated.ird.validation.exists.CalculationPeriodAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationPeriodAmount.class)
public class CalculationPeriodAmountMeta implements RosettaMetaData<CalculationPeriodAmount> {

	@Override
	public List<Validator<? super CalculationPeriodAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationPeriodAmount>create(CalculationPeriodAmountChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriodAmount> validator(ValidatorFactory factory) {
		return factory.<CalculationPeriodAmount>create(CalculationPeriodAmountValidator.class);
	}

	@Override
	public Validator<? super CalculationPeriodAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationPeriodAmount>create(CalculationPeriodAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodAmount> validator() {
		return new CalculationPeriodAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodAmount> typeFormatValidator() {
		return new CalculationPeriodAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodAmount, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodAmountOnlyExistsValidator();
	}
}
