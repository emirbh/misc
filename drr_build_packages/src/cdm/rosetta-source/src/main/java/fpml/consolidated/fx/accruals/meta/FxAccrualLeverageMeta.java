package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualLeverage;
import fpml.consolidated.fx.accruals.validation.FxAccrualLeverageTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualLeverageValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualLeverageChoice0;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualLeverageChoice1;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualLeverageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualLeverage.class)
public class FxAccrualLeverageMeta implements RosettaMetaData<FxAccrualLeverage> {

	@Override
	public List<Validator<? super FxAccrualLeverage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualLeverage>create(FxAccrualLeverageChoice0.class),
			factory.<FxAccrualLeverage>create(FxAccrualLeverageChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualLeverage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualLeverage> validator(ValidatorFactory factory) {
		return factory.<FxAccrualLeverage>create(FxAccrualLeverageValidator.class);
	}

	@Override
	public Validator<? super FxAccrualLeverage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualLeverage>create(FxAccrualLeverageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualLeverage> validator() {
		return new FxAccrualLeverageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualLeverage> typeFormatValidator() {
		return new FxAccrualLeverageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualLeverage, Set<String>> onlyExistsValidator() {
		return new FxAccrualLeverageOnlyExistsValidator();
	}
}
