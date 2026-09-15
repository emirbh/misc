package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxAsianFeature;
import fpml.consolidated.fx.FxBarrierFeature;
import fpml.consolidated.fx.FxOptionFeatures;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxOptionFeaturesChoice")
@ImplementedBy(FxOptionFeaturesChoice.Default.class)
public interface FxOptionFeaturesChoice extends Validator<FxOptionFeatures> {
	
	String NAME = "FxOptionFeaturesChoice";
	String DEFINITION = "asian exists or barrier exists";
	
	class Default implements FxOptionFeaturesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOptionFeatures fxOptionFeatures) {
			ComparisonResult result = executeDataRule(fxOptionFeatures);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxOptionFeatures", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxOptionFeatures", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxOptionFeatures fxOptionFeatures) {
			try {
				return exists(MapperS.of(fxOptionFeatures).<FxAsianFeature>map("getAsian", _fxOptionFeatures -> _fxOptionFeatures.getAsian())).orNullSafe(exists(MapperS.of(fxOptionFeatures).<FxBarrierFeature>mapC("getBarrier", _fxOptionFeatures -> _fxOptionFeatures.getBarrier())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxOptionFeaturesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOptionFeatures fxOptionFeatures) {
			return Collections.emptyList();
		}
	}
}
