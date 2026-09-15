package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualLinearPayoffRegion;
import fpml.consolidated.fx.accruals.FxAverageStrike;
import fpml.consolidated.fx.accruals.FxForwardStrikePrice;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxAccrualLinearPayoffRegionChoice")
@ImplementedBy(FxAccrualLinearPayoffRegionChoice.Default.class)
public interface FxAccrualLinearPayoffRegionChoice extends Validator<FxAccrualLinearPayoffRegion> {
	
	String NAME = "FxAccrualLinearPayoffRegionChoice";
	String DEFINITION = "if strike exists then averageStrike is absent else if averageStrike exists then strike is absent and counterCurrencyAmount is absent else False";
	
	class Default implements FxAccrualLinearPayoffRegionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLinearPayoffRegion fxAccrualLinearPayoffRegion) {
			ComparisonResult result = executeDataRule(fxAccrualLinearPayoffRegion);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualLinearPayoffRegion", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualLinearPayoffRegion", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAccrualLinearPayoffRegion fxAccrualLinearPayoffRegion) {
			try {
				if (exists(MapperS.of(fxAccrualLinearPayoffRegion).<FxForwardStrikePrice>map("getStrike", _fxAccrualLinearPayoffRegion -> _fxAccrualLinearPayoffRegion.getStrike())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualLinearPayoffRegion).<FxAverageStrike>map("getAverageStrike", _fxAccrualLinearPayoffRegion -> _fxAccrualLinearPayoffRegion.getAverageStrike()));
				}
				if (exists(MapperS.of(fxAccrualLinearPayoffRegion).<FxAverageStrike>map("getAverageStrike", _fxAccrualLinearPayoffRegion -> _fxAccrualLinearPayoffRegion.getAverageStrike())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualLinearPayoffRegion).<FxForwardStrikePrice>map("getStrike", _fxAccrualLinearPayoffRegion -> _fxAccrualLinearPayoffRegion.getStrike())).andNullSafe(notExists(MapperS.of(fxAccrualLinearPayoffRegion).<NonNegativeAmountSchedule>map("getCounterCurrencyAmount", _fxAccrualLinearPayoffRegion -> _fxAccrualLinearPayoffRegion.getCounterCurrencyAmount())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualLinearPayoffRegionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLinearPayoffRegion fxAccrualLinearPayoffRegion) {
			return Collections.emptyList();
		}
	}
}
