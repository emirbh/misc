package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CalculationAmount;
import fpml.consolidated.cd.validation.CalculationAmountTypeFormatValidator;
import fpml.consolidated.cd.validation.CalculationAmountValidator;
import fpml.consolidated.cd.validation.exists.CalculationAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationAmount.class)
public class CalculationAmountMeta implements RosettaMetaData<CalculationAmount> {

	@Override
	public List<Validator<? super CalculationAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationAmount> validator(ValidatorFactory factory) {
		return factory.<CalculationAmount>create(CalculationAmountValidator.class);
	}

	@Override
	public Validator<? super CalculationAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationAmount>create(CalculationAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAmount> validator() {
		return new CalculationAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAmount> typeFormatValidator() {
		return new CalculationAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAmount, Set<String>> onlyExistsValidator() {
		return new CalculationAmountOnlyExistsValidator();
	}
}
