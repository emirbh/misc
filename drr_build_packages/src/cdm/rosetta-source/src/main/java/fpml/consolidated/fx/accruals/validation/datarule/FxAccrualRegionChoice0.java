package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualRegion;
import fpml.consolidated.fx.accruals.FxAccrualRegionLowerBound;
import fpml.consolidated.fx.accruals.FxAccrualRegionUpperBound;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxAccrualRegionChoice0")
@ImplementedBy(FxAccrualRegionChoice0.Default.class)
public interface FxAccrualRegionChoice0 extends Validator<FxAccrualRegion> {
	
	String NAME = "FxAccrualRegionChoice0";
	String DEFINITION = "lowerBound exists or upperBound exists";
	
	class Default implements FxAccrualRegionChoice0 {
	
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
				return exists(MapperS.of(fxAccrualRegion).<FxAccrualRegionLowerBound>map("getLowerBound", _fxAccrualRegion -> _fxAccrualRegion.getLowerBound())).orNullSafe(exists(MapperS.of(fxAccrualRegion).<FxAccrualRegionUpperBound>map("getUpperBound", _fxAccrualRegion -> _fxAccrualRegion.getUpperBound())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualRegionChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegion fxAccrualRegion) {
			return Collections.emptyList();
		}
	}
}
