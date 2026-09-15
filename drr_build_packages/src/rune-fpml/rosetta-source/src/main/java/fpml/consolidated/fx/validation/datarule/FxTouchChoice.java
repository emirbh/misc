package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxBusinessCenterDateTime;
import fpml.consolidated.fx.FxTouch;
import fpml.consolidated.shared.BusinessCenterTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTouchChoice")
@ImplementedBy(FxTouchChoice.Default.class)
public interface FxTouchChoice extends Validator<FxTouch> {
	
	String NAME = "FxTouchChoice";
	String DEFINITION = "observationStartDate is absent and observationStartTime is absent and observationEndDate is absent and observationEndTime is absent or observationPoint is absent";
	
	class Default implements FxTouchChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTouch fxTouch) {
			ComparisonResult result = executeDataRule(fxTouch);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTouch", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTouch", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTouch fxTouch) {
			try {
				return notExists(MapperS.of(fxTouch).<ZonedDateTime>map("getObservationStartDate", _fxTouch -> _fxTouch.getObservationStartDate())).andNullSafe(notExists(MapperS.of(fxTouch).<BusinessCenterTime>map("getObservationStartTime", _fxTouch -> _fxTouch.getObservationStartTime()))).andNullSafe(notExists(MapperS.of(fxTouch).<ZonedDateTime>map("getObservationEndDate", _fxTouch -> _fxTouch.getObservationEndDate()))).andNullSafe(notExists(MapperS.of(fxTouch).<BusinessCenterTime>map("getObservationEndTime", _fxTouch -> _fxTouch.getObservationEndTime()))).orNullSafe(notExists(MapperS.of(fxTouch).<FxBusinessCenterDateTime>mapC("getObservationPoint", _fxTouch -> _fxTouch.getObservationPoint())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTouchChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTouch fxTouch) {
			return Collections.emptyList();
		}
	}
}
