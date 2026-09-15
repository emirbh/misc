package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodPayoff;
import fpml.consolidated.fx.accruals.validation.FxAccrualSettlementPeriodPayoffTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualSettlementPeriodPayoffValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualSettlementPeriodPayoffChoice;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualSettlementPeriodPayoffOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualSettlementPeriodPayoff.class)
public class FxAccrualSettlementPeriodPayoffMeta implements RosettaMetaData<FxAccrualSettlementPeriodPayoff> {

	@Override
	public List<Validator<? super FxAccrualSettlementPeriodPayoff>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualSettlementPeriodPayoff>create(FxAccrualSettlementPeriodPayoffChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualSettlementPeriodPayoff, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualSettlementPeriodPayoff> validator(ValidatorFactory factory) {
		return factory.<FxAccrualSettlementPeriodPayoff>create(FxAccrualSettlementPeriodPayoffValidator.class);
	}

	@Override
	public Validator<? super FxAccrualSettlementPeriodPayoff> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualSettlementPeriodPayoff>create(FxAccrualSettlementPeriodPayoffTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualSettlementPeriodPayoff> validator() {
		return new FxAccrualSettlementPeriodPayoffValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualSettlementPeriodPayoff> typeFormatValidator() {
		return new FxAccrualSettlementPeriodPayoffTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualSettlementPeriodPayoff, Set<String>> onlyExistsValidator() {
		return new FxAccrualSettlementPeriodPayoffOnlyExistsValidator();
	}
}
