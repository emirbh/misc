package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualRegion;
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
@RosettaDataRule("FxAccrualRegionChoice1")
@ImplementedBy(FxAccrualRegionChoice1.Default.class)
public interface FxAccrualRegionChoice1 extends Validator<FxAccrualRegion> {
	
	String NAME = "FxAccrualRegionChoice1";
	String DEFINITION = "if notionalAmount exists then accrualFactor is absent else notionalAmount is absent and counterCurrencyAmount is absent";
	
	class Default implements FxAccrualRegionChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegion fxAccrualRegion) {
			ComparisonResult result = executeDataRule(fxAccrualRegion);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegion", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegion", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAccrualRegion fxAccrualRegion) {
			try {
				if (exists(MapperS.of(fxAccrualRegion).<NonNegativeAmountSchedule>map("getNotionalAmount", _fxAccrualRegion -> _fxAccrualRegion.getNotionalAmount())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualRegion).<Schedule>map("getAccrualFactor", _fxAccrualRegion -> _fxAccrualRegion.getAccrualFactor()));
				}
				return notExists(MapperS.of(fxAccrualRegion).<NonNegativeAmountSchedule>map("getNotionalAmount", _fxAccrualRegion -> _fxAccrualRegion.getNotionalAmount())).andNullSafe(notExists(MapperS.of(fxAccrualRegion).<FxCounterCurrencyAmount>map("getCounterCurrencyAmount", _fxAccrualRegion -> _fxAccrualRegion.getCounterCurrencyAmount())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualRegionChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegion fxAccrualRegion) {
			return Collections.emptyList();
		}
	}
}
