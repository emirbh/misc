package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriod;
import fpml.consolidated.fx.accruals.validation.FxAccrualSettlementPeriodTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualSettlementPeriodValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualSettlementPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualSettlementPeriod.class)
public class FxAccrualSettlementPeriodMeta implements RosettaMetaData<FxAccrualSettlementPeriod> {

	@Override
	public List<Validator<? super FxAccrualSettlementPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualSettlementPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualSettlementPeriod> validator(ValidatorFactory factory) {
		return factory.<FxAccrualSettlementPeriod>create(FxAccrualSettlementPeriodValidator.class);
	}

	@Override
	public Validator<? super FxAccrualSettlementPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualSettlementPeriod>create(FxAccrualSettlementPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualSettlementPeriod> validator() {
		return new FxAccrualSettlementPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualSettlementPeriod> typeFormatValidator() {
		return new FxAccrualSettlementPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualSettlementPeriod, Set<String>> onlyExistsValidator() {
		return new FxAccrualSettlementPeriodOnlyExistsValidator();
	}
}
