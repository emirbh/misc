package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.targets.FxDateOffset;
import fpml.consolidated.fx.targets.FxSchedule;
import fpml.consolidated.shared.ObservationFrequency;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxScheduleChoice5")
@ImplementedBy(FxScheduleChoice5.Default.class)
public interface FxScheduleChoice5 extends Validator<FxSchedule> {
	
	String NAME = "FxScheduleChoice5";
	String DEFINITION = "dateOffset is absent or startDate is absent and endDate is absent and observationFrequency is absent and dayType is absent";
	
	class Default implements FxScheduleChoice5 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSchedule fxSchedule) {
			ComparisonResult result = executeDataRule(fxSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxSchedule fxSchedule) {
			try {
				return notExists(MapperS.of(fxSchedule).<FxDateOffset>map("getDateOffset", _fxSchedule -> _fxSchedule.getDateOffset())).orNullSafe(notExists(MapperS.of(fxSchedule).<ZonedDateTime>map("getStartDate", _fxSchedule -> _fxSchedule.getStartDate())).andNullSafe(notExists(MapperS.of(fxSchedule).<ZonedDateTime>map("getEndDate", _fxSchedule -> _fxSchedule.getEndDate()))).andNullSafe(notExists(MapperS.of(fxSchedule).<ObservationFrequency>map("getObservationFrequency", _fxSchedule -> _fxSchedule.getObservationFrequency()))).andNullSafe(notExists(MapperS.of(fxSchedule).<DayTypeEnum>map("getDayType", _fxSchedule -> _fxSchedule.getDayType()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxScheduleChoice5 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSchedule fxSchedule) {
			return Collections.emptyList();
		}
	}
}
