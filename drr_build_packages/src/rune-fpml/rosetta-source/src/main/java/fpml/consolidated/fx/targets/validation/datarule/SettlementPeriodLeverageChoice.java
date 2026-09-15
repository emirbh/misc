package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.SettlementPeriodLeverage;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SettlementPeriodLeverageChoice")
@ImplementedBy(SettlementPeriodLeverageChoice.Default.class)
public interface SettlementPeriodLeverageChoice extends Validator<SettlementPeriodLeverage> {
	
	String NAME = "SettlementPeriodLeverageChoice";
	String DEFINITION = "ratio is absent or notionalAmount is absent and counterCurrencyAmount is absent";
	
	class Default implements SettlementPeriodLeverageChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodLeverage settlementPeriodLeverage) {
			ComparisonResult result = executeDataRule(settlementPeriodLeverage);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodLeverage", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodLeverage", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementPeriodLeverage settlementPeriodLeverage) {
			try {
				return notExists(MapperS.of(settlementPeriodLeverage).<BigDecimal>map("getRatio", _settlementPeriodLeverage -> _settlementPeriodLeverage.getRatio())).orNullSafe(notExists(MapperS.of(settlementPeriodLeverage).<BigDecimal>map("getNotionalAmount", _settlementPeriodLeverage -> _settlementPeriodLeverage.getNotionalAmount())).andNullSafe(notExists(MapperS.of(settlementPeriodLeverage).<BigDecimal>map("getCounterCurrencyAmount", _settlementPeriodLeverage -> _settlementPeriodLeverage.getCounterCurrencyAmount()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPeriodLeverageChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodLeverage settlementPeriodLeverage) {
			return Collections.emptyList();
		}
	}
}
