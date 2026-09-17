package cdm.product.asset.meta;

import cdm.product.asset.FutureValueAmount;
import cdm.product.asset.validation.FutureValueAmountTypeFormatValidator;
import cdm.product.asset.validation.FutureValueAmountValidator;
import cdm.product.asset.validation.datarule.FutureValueAmountPositiveCalculationPeriodNumberOfDays;
import cdm.product.asset.validation.exists.FutureValueAmountOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=FutureValueAmount.class)
public class FutureValueAmountMeta implements RosettaMetaData<FutureValueAmount> {

	@Override
	public List<Validator<? super FutureValueAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FutureValueAmount>create(FutureValueAmountPositiveCalculationPeriodNumberOfDays.class)
		);
	}
	
	@Override
	public List<Function<? super FutureValueAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FutureValueAmount> validator(ValidatorFactory factory) {
		return factory.<FutureValueAmount>create(FutureValueAmountValidator.class);
	}

	@Override
	public Validator<? super FutureValueAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FutureValueAmount>create(FutureValueAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FutureValueAmount> validator() {
		return new FutureValueAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FutureValueAmount> typeFormatValidator() {
		return new FutureValueAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FutureValueAmount, Set<String>> onlyExistsValidator() {
		return new FutureValueAmountOnlyExistsValidator();
	}
}
