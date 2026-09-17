package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxBarrierFeature;
import fpml.consolidated.fx.FxBusinessCenterDateTime;
import fpml.consolidated.shared.BusinessCenterTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxBarrierFeatureChoice")
@ImplementedBy(FxBarrierFeatureChoice.Default.class)
public interface FxBarrierFeatureChoice extends Validator<FxBarrierFeature> {
	
	String NAME = "FxBarrierFeatureChoice";
	String DEFINITION = "observationStartDate is absent and observationStartTime is absent and observationEndDate is absent and observationEndTime is absent or observationPoint is absent";
	
	class Default implements FxBarrierFeatureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxBarrierFeature fxBarrierFeature) {
			ComparisonResult result = executeDataRule(fxBarrierFeature);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxBarrierFeature", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxBarrierFeature", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxBarrierFeature fxBarrierFeature) {
			try {
				return notExists(MapperS.of(fxBarrierFeature).<ZonedDateTime>map("getObservationStartDate", _fxBarrierFeature -> _fxBarrierFeature.getObservationStartDate())).andNullSafe(notExists(MapperS.of(fxBarrierFeature).<BusinessCenterTime>map("getObservationStartTime", _fxBarrierFeature -> _fxBarrierFeature.getObservationStartTime()))).andNullSafe(notExists(MapperS.of(fxBarrierFeature).<ZonedDateTime>map("getObservationEndDate", _fxBarrierFeature -> _fxBarrierFeature.getObservationEndDate()))).andNullSafe(notExists(MapperS.of(fxBarrierFeature).<BusinessCenterTime>map("getObservationEndTime", _fxBarrierFeature -> _fxBarrierFeature.getObservationEndTime()))).orNullSafe(notExists(MapperS.of(fxBarrierFeature).<FxBusinessCenterDateTime>mapC("getObservationPoint", _fxBarrierFeature -> _fxBarrierFeature.getObservationPoint())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxBarrierFeatureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxBarrierFeature fxBarrierFeature) {
			return Collections.emptyList();
		}
	}
}
