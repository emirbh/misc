package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetAccumulationRegion;
import fpml.consolidated.fx.targets.FxTargetRegionLowerBound;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTargetAccumulationRegionChoice")
@ImplementedBy(FxTargetAccumulationRegionChoice.Default.class)
public interface FxTargetAccumulationRegionChoice extends Validator<FxTargetAccumulationRegion> {
	
	String NAME = "FxTargetAccumulationRegionChoice";
	String DEFINITION = "lowerBound exists or upperBound exists";
	
	class Default implements FxTargetAccumulationRegionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetAccumulationRegion fxTargetAccumulationRegion) {
			ComparisonResult result = executeDataRule(fxTargetAccumulationRegion);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetAccumulationRegion", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetAccumulationRegion", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTargetAccumulationRegion fxTargetAccumulationRegion) {
			try {
				return exists(MapperS.of(fxTargetAccumulationRegion).<FxTargetRegionLowerBound>map("getLowerBound", _fxTargetAccumulationRegion -> _fxTargetAccumulationRegion.getLowerBound())).orNullSafe(exists(MapperS.of(fxTargetAccumulationRegion).<FxTargetRegionUpperBound>map("getUpperBound", _fxTargetAccumulationRegion -> _fxTargetAccumulationRegion.getUpperBound())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetAccumulationRegionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetAccumulationRegion fxTargetAccumulationRegion) {
			return Collections.emptyList();
		}
	}
}
