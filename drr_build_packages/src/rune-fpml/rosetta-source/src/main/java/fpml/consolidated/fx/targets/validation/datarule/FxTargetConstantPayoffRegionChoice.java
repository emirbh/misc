package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetConstantPayoffRegion;
import fpml.consolidated.fx.targets.FxTargetRegionLowerBound;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTargetConstantPayoffRegionChoice")
@ImplementedBy(FxTargetConstantPayoffRegionChoice.Default.class)
public interface FxTargetConstantPayoffRegionChoice extends Validator<FxTargetConstantPayoffRegion> {
	
	String NAME = "FxTargetConstantPayoffRegionChoice";
	String DEFINITION = "lowerBound exists or upperBound exists";
	
	class Default implements FxTargetConstantPayoffRegionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetConstantPayoffRegion fxTargetConstantPayoffRegion) {
			ComparisonResult result = executeDataRule(fxTargetConstantPayoffRegion);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetConstantPayoffRegion", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetConstantPayoffRegion", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTargetConstantPayoffRegion fxTargetConstantPayoffRegion) {
			try {
				return exists(MapperS.of(fxTargetConstantPayoffRegion).<FxTargetRegionLowerBound>map("getLowerBound", _fxTargetConstantPayoffRegion -> _fxTargetConstantPayoffRegion.getLowerBound())).orNullSafe(exists(MapperS.of(fxTargetConstantPayoffRegion).<FxTargetRegionUpperBound>map("getUpperBound", _fxTargetConstantPayoffRegion -> _fxTargetConstantPayoffRegion.getUpperBound())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetConstantPayoffRegionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetConstantPayoffRegion fxTargetConstantPayoffRegion) {
			return Collections.emptyList();
		}
	}
}
