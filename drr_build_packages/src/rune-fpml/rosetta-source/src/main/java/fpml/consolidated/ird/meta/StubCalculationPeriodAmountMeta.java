package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.StubCalculationPeriodAmount;
import fpml.consolidated.ird.validation.StubCalculationPeriodAmountTypeFormatValidator;
import fpml.consolidated.ird.validation.StubCalculationPeriodAmountValidator;
import fpml.consolidated.ird.validation.exists.StubCalculationPeriodAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StubCalculationPeriodAmount.class)
public class StubCalculationPeriodAmountMeta implements RosettaMetaData<StubCalculationPeriodAmount> {

	@Override
	public List<Validator<? super StubCalculationPeriodAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StubCalculationPeriodAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StubCalculationPeriodAmount> validator(ValidatorFactory factory) {
		return factory.<StubCalculationPeriodAmount>create(StubCalculationPeriodAmountValidator.class);
	}

	@Override
	public Validator<? super StubCalculationPeriodAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StubCalculationPeriodAmount>create(StubCalculationPeriodAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StubCalculationPeriodAmount> validator() {
		return new StubCalculationPeriodAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StubCalculationPeriodAmount> typeFormatValidator() {
		return new StubCalculationPeriodAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubCalculationPeriodAmount, Set<String>> onlyExistsValidator() {
		return new StubCalculationPeriodAmountOnlyExistsValidator();
	}
}
