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
import fpml.consolidated.fx.accruals.FxAccrualRegionLowerBound;
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
@RosettaDataRule("FxAccrualRegionLowerBoundChoice")
@ImplementedBy(FxAccrualRegionLowerBoundChoice.Default.class)
public interface FxAccrualRegionLowerBoundChoice extends Validator<FxAccrualRegionLowerBound> {
	
	String NAME = "FxAccrualRegionLowerBoundChoice";
	String DEFINITION = "if level exists then strikeReference is absent and averageStrikeReference is absent and triggerReference is absent else if strikeReference exists then level is absent and quoteBasis is absent and averageStrikeReference is absent and triggerReference is absent else if averageStrikeReference exists then level is absent and strikeReference is absent and quoteBasis is absent and triggerReference is absent else if triggerReference exists then level is absent and strikeReference is absent and averageStrikeReference is absent and quoteBasis is absent else False";
	
	class Default implements FxAccrualRegionLowerBoundChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionLowerBound fxAccrualRegionLowerBound) {
			ComparisonResult result = executeDataRule(fxAccrualRegionLowerBound);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegionLowerBound", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegionLowerBound", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAccrualRegionLowerBound fxAccrualRegionLowerBound) {
			try {
				if (exists(MapperS.of(fxAccrualRegionLowerBound).<FxLevel>map("getLevel", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getLevel())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getStrikeReference())).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getAverageStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getTriggerReference())));
				}
				if (exists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getStrikeReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualRegionLowerBound).<FxLevel>map("getLevel", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getLevel())).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<QuoteBasisEnum>map("getQuoteBasis", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getQuoteBasis()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getAverageStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getTriggerReference())));
				}
				if (exists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getAverageStrikeReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualRegionLowerBound).<FxLevel>map("getLevel", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getLevel())).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<QuoteBasisEnum>map("getQuoteBasis", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getQuoteBasis()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getTriggerReference())));
				}
				if (exists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getTriggerReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualRegionLowerBound).<FxLevel>map("getLevel", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getLevel())).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getAverageStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionLowerBound).<QuoteBasisEnum>map("getQuoteBasis", _fxAccrualRegionLowerBound -> _fxAccrualRegionLowerBound.getQuoteBasis())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualRegionLowerBoundChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionLowerBound fxAccrualRegionLowerBound) {
			return Collections.emptyList();
		}
	}
}
