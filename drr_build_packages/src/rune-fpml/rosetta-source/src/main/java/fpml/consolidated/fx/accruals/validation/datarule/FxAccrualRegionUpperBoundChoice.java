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
import fpml.consolidated.fx.accruals.FxAccrualRegionUpperBound;
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
@RosettaDataRule("FxAccrualRegionUpperBoundChoice")
@ImplementedBy(FxAccrualRegionUpperBoundChoice.Default.class)
public interface FxAccrualRegionUpperBoundChoice extends Validator<FxAccrualRegionUpperBound> {
	
	String NAME = "FxAccrualRegionUpperBoundChoice";
	String DEFINITION = "if level exists then strikeReference is absent and averageStrikeReference is absent and triggerReference is absent else if strikeReference exists then level is absent and quoteBasis is absent and averageStrikeReference is absent and triggerReference is absent else if averageStrikeReference exists then level is absent and strikeReference is absent and quoteBasis is absent and triggerReference is absent else if triggerReference exists then level is absent and strikeReference is absent and averageStrikeReference is absent and quoteBasis is absent else False";
	
	class Default implements FxAccrualRegionUpperBoundChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionUpperBound fxAccrualRegionUpperBound) {
			ComparisonResult result = executeDataRule(fxAccrualRegionUpperBound);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegionUpperBound", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegionUpperBound", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAccrualRegionUpperBound fxAccrualRegionUpperBound) {
			try {
				if (exists(MapperS.of(fxAccrualRegionUpperBound).<FxLevel>map("getLevel", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getLevel())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getStrikeReference())).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getAverageStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getTriggerReference())));
				}
				if (exists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getStrikeReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualRegionUpperBound).<FxLevel>map("getLevel", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getLevel())).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<QuoteBasisEnum>map("getQuoteBasis", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getQuoteBasis()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getAverageStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getTriggerReference())));
				}
				if (exists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getAverageStrikeReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualRegionUpperBound).<FxLevel>map("getLevel", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getLevel())).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<QuoteBasisEnum>map("getQuoteBasis", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getQuoteBasis()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getTriggerReference())));
				}
				if (exists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualTriggerReference>map("getTriggerReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getTriggerReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualRegionUpperBound).<FxLevel>map("getLevel", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getLevel())).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualStrikeReference>map("getStrikeReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<FxAccrualAverageStrikeReference>map("getAverageStrikeReference", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getAverageStrikeReference()))).andNullSafe(notExists(MapperS.of(fxAccrualRegionUpperBound).<QuoteBasisEnum>map("getQuoteBasis", _fxAccrualRegionUpperBound -> _fxAccrualRegionUpperBound.getQuoteBasis())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualRegionUpperBoundChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionUpperBound fxAccrualRegionUpperBound) {
			return Collections.emptyList();
		}
	}
}
