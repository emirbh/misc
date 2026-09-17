package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.fx.targets.validation.FxCounterCurrencyAmountTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxCounterCurrencyAmountValidator;
import fpml.consolidated.fx.targets.validation.exists.FxCounterCurrencyAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxCounterCurrencyAmount.class)
public class FxCounterCurrencyAmountMeta implements RosettaMetaData<FxCounterCurrencyAmount> {

	@Override
	public List<Validator<? super FxCounterCurrencyAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxCounterCurrencyAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxCounterCurrencyAmount> validator(ValidatorFactory factory) {
		return factory.<FxCounterCurrencyAmount>create(FxCounterCurrencyAmountValidator.class);
	}

	@Override
	public Validator<? super FxCounterCurrencyAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxCounterCurrencyAmount>create(FxCounterCurrencyAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxCounterCurrencyAmount> validator() {
		return new FxCounterCurrencyAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxCounterCurrencyAmount> typeFormatValidator() {
		return new FxCounterCurrencyAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCounterCurrencyAmount, Set<String>> onlyExistsValidator() {
		return new FxCounterCurrencyAmountOnlyExistsValidator();
	}
}
