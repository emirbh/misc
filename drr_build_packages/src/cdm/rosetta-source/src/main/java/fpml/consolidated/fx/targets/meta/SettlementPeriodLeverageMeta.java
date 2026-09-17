package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.SettlementPeriodLeverage;
import fpml.consolidated.fx.targets.validation.SettlementPeriodLeverageTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.SettlementPeriodLeverageValidator;
import fpml.consolidated.fx.targets.validation.datarule.SettlementPeriodLeverageChoice;
import fpml.consolidated.fx.targets.validation.exists.SettlementPeriodLeverageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPeriodLeverage.class)
public class SettlementPeriodLeverageMeta implements RosettaMetaData<SettlementPeriodLeverage> {

	@Override
	public List<Validator<? super SettlementPeriodLeverage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SettlementPeriodLeverage>create(SettlementPeriodLeverageChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodLeverage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPeriodLeverage> validator(ValidatorFactory factory) {
		return factory.<SettlementPeriodLeverage>create(SettlementPeriodLeverageValidator.class);
	}

	@Override
	public Validator<? super SettlementPeriodLeverage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPeriodLeverage>create(SettlementPeriodLeverageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodLeverage> validator() {
		return new SettlementPeriodLeverageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodLeverage> typeFormatValidator() {
		return new SettlementPeriodLeverageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodLeverage, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodLeverageOnlyExistsValidator();
	}
}
