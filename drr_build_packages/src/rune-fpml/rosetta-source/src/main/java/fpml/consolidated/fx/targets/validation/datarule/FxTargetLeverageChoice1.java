package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.fx.targets.FxTargetLeverage;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTargetLeverageChoice1")
@ImplementedBy(FxTargetLeverageChoice1.Default.class)
public interface FxTargetLeverageChoice1 extends Validator<FxTargetLeverage> {
	
	String NAME = "FxTargetLeverageChoice1";
	String DEFINITION = "if ratio exists then notionalAmount is absent and counterCurrencyAmount is absent else if notionalAmount exists then ratio is absent else False";
	
	class Default implements FxTargetLeverageChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLeverage fxTargetLeverage) {
			ComparisonResult result = executeDataRule(fxTargetLeverage);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetLeverage", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetLeverage", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTargetLeverage fxTargetLeverage) {
			try {
				if (exists(MapperS.of(fxTargetLeverage).<Schedule>map("getRatio", _fxTargetLeverage -> _fxTargetLeverage.getRatio())).getOrDefault(false)) {
					return notExists(MapperS.of(fxTargetLeverage).<NonNegativeAmountSchedule>map("getNotionalAmount", _fxTargetLeverage -> _fxTargetLeverage.getNotionalAmount())).andNullSafe(notExists(MapperS.of(fxTargetLeverage).<FxCounterCurrencyAmount>mapC("getCounterCurrencyAmount", _fxTargetLeverage -> _fxTargetLeverage.getCounterCurrencyAmount())));
				}
				if (exists(MapperS.of(fxTargetLeverage).<NonNegativeAmountSchedule>map("getNotionalAmount", _fxTargetLeverage -> _fxTargetLeverage.getNotionalAmount())).getOrDefault(false)) {
					return notExists(MapperS.of(fxTargetLeverage).<Schedule>map("getRatio", _fxTargetLeverage -> _fxTargetLeverage.getRatio()));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetLeverageChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLeverage fxTargetLeverage) {
			return Collections.emptyList();
		}
	}
}
