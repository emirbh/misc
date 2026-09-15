package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.accruals.FxAccrualAverageStrikeReference;
import fpml.consolidated.fx.accruals.FxAccrualLeverage;
import fpml.consolidated.fx.accruals.FxAccrualStrikeReference;
import fpml.consolidated.fx.accruals.FxAccrualTriggerReference;
import fpml.consolidated.fx.targets.FxLevel;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxAccrualLeverageChoice0")
@ImplementedBy(FxAccrualLeverageChoice0.Default.class)
public interface FxAccrualLeverageChoice0 extends Validator<FxAccrualLeverage> {
	
	String NAME = "FxAccrualLeverageChoice0";
	String DEFINITION = "if level exists then strikeReference is absent and averageStrikeReference is absent and triggerReference is absent else if strikeReference exists then level is absent and quoteBasis is absent and averageStrikeReference is absent and triggerReference is absent else if averageStrikeReference exists then level is absent and strikeReference is absent and quoteBasis is absent and triggerReference is absent else if triggerReference exists then level is absent and strikeReference is absent and averageStrikeReference is absent and quoteBasis is absent else False";
	
	class Default implements FxAccrualLeverageChoice0 {
	
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
				if (exists(MapperS.of(fxAccrualLeverage).<FxLevel>map("getLevel", _fxAccrualLeverage -> _fxAccrualLeverage.getLevel())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualLeverage).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualLeverage -> _fxAccrualLeverage.getStrikeReference())).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualLeverage -> _fxAccrualLeverage.getAverageStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualLeverage -> _fxAccrualLeverage.getTriggerReference())));
				}
				if (exists(MapperS.of(fxAccrualLeverage).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualLeverage -> _fxAccrualLeverage.getStrikeReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualLeverage).<FxLevel>map("getLevel", _fxAccrualLeverage -> _fxAccrualLeverage.getLevel())).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<QuoteBasisEnum>map("getQuoteBasis", _fxAccrualLeverage -> _fxAccrualLeverage.getQuoteBasis()))).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualLeverage -> _fxAccrualLeverage.getAverageStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualLeverage -> _fxAccrualLeverage.getTriggerReference())));
				}
				if (exists(MapperS.of(fxAccrualLeverage).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualLeverage -> _fxAccrualLeverage.getAverageStrikeReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualLeverage).<FxLevel>map("getLevel", _fxAccrualLeverage -> _fxAccrualLeverage.getLevel())).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualLeverage -> _fxAccrualLeverage.getStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<QuoteBasisEnum>map("getQuoteBasis", _fxAccrualLeverage -> _fxAccrualLeverage.getQuoteBasis()))).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualLeverage -> _fxAccrualLeverage.getTriggerReference())));
				}
				if (exists(MapperS.of(fxAccrualLeverage).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualLeverage -> _fxAccrualLeverage.getTriggerReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualLeverage).<FxLevel>map("getLevel", _fxAccrualLeverage -> _fxAccrualLeverage.getLevel())).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualLeverage -> _fxAccrualLeverage.getStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualLeverage -> _fxAccrualLeverage.getAverageStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualLeverage).<QuoteBasisEnum>map("getQuoteBasis", _fxAccrualLeverage -> _fxAccrualLeverage.getQuoteBasis())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualLeverageChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLeverage fxAccrualLeverage) {
			return Collections.emptyList();
		}
	}
}
