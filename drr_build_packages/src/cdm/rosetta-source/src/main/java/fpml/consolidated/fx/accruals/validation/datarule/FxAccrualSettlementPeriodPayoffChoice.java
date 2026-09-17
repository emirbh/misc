package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodPayoff;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxAccrualSettlementPeriodPayoffChoice")
@ImplementedBy(FxAccrualSettlementPeriodPayoffChoice.Default.class)
public interface FxAccrualSettlementPeriodPayoffChoice extends Validator<FxAccrualSettlementPeriodPayoff> {
	
	String NAME = "FxAccrualSettlementPeriodPayoffChoice";
	String DEFINITION = "if strike exists then averageStrikeFixingDates is absent else strike is absent and counterCurrencyAmount is absent";
	
	class Default implements FxAccrualSettlementPeriodPayoffChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriodPayoff fxAccrualSettlementPeriodPayoff) {
			ComparisonResult result = executeDataRule(fxAccrualSettlementPeriodPayoff);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualSettlementPeriodPayoff", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualSettlementPeriodPayoff", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAccrualSettlementPeriodPayoff fxAccrualSettlementPeriodPayoff) {
			try {
				if (exists(MapperS.of(fxAccrualSettlementPeriodPayoff).<BigDecimal>map("getStrike", _fxAccrualSettlementPeriodPayoff -> _fxAccrualSettlementPeriodPayoff.getStrike())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualSettlementPeriodPayoff).<SettlementPeriodFixingDates>map("getAverageStrikeFixingDates", _fxAccrualSettlementPeriodPayoff -> _fxAccrualSettlementPeriodPayoff.getAverageStrikeFixingDates()));
				}
				return notExists(MapperS.of(fxAccrualSettlementPeriodPayoff).<BigDecimal>map("getStrike", _fxAccrualSettlementPeriodPayoff -> _fxAccrualSettlementPeriodPayoff.getStrike())).andNullSafe(notExists(MapperS.of(fxAccrualSettlementPeriodPayoff).<BigDecimal>map("getCounterCurrencyAmount", _fxAccrualSettlementPeriodPayoff -> _fxAccrualSettlementPeriodPayoff.getCounterCurrencyAmount())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualSettlementPeriodPayoffChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriodPayoff fxAccrualSettlementPeriodPayoff) {
			return Collections.emptyList();
		}
	}
}
