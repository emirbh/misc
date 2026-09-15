package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualLeverage;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxAccrualLeverageChoice1")
@ImplementedBy(FxAccrualLeverageChoice1.Default.class)
public interface FxAccrualLeverageChoice1 extends Validator<FxAccrualLeverage> {
	
	String NAME = "FxAccrualLeverageChoice1";
	String DEFINITION = "if ratio exists then notionalAmount is absent and counterCurrencyAmount is absent else if notionalAmount exists then ratio is absent else False";
	
	class Default implements FxAccrualLeverageChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLeverage fxAccrualLeverage) {
			ComparisonResult result = executeDataRule(fxAccrualLeverage);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualLeverage", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualLeverage", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAccrualLeverage fxAccrualLeverage) {
			try {
				if (exists(MapperS.of(fxAccrualLeverage).<Schedule>map("getRatio", _fxAccrualLeverage -> _fxAccrualLeverage.getRatio())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualLeverage).<NonNegativeAmountSchedule>map("getNotionalAmount", _fxAccrualLeverage -> _fxAccrualLeverage.getNotionalAmount())).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<FxCounterCurrencyAmount>map("getCounterCurrencyAmount", _fxAccrualLeverage -> _fxAccrualLeverage.getCounterCurrencyAmount())));
				}
				if (exists(MapperS.of(fxAccrualLeverage).<NonNegativeAmountSchedule>map("getNotionalAmount", _fxAccrualLeverage -> _fxAccrualLeverage.getNotionalAmount())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualLeverage).<Schedule>map("getRatio", _fxAccrualLeverage -> _fxAccrualLeverage.getRatio()));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualLeverageChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLeverage fxAccrualLeverage) {
			return Collections.emptyList();
		}
	}
}
