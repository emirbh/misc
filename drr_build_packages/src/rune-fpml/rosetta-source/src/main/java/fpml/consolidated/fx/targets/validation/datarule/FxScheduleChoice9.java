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
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.ObservationFrequency;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxScheduleChoice9")
@ImplementedBy(FxScheduleChoice9.Default.class)
public interface FxScheduleChoice9 extends Validator<FxSchedule> {
	
	String NAME = "FxScheduleChoice9";
	String DEFINITION = "if dateAdjustments is absent and dayType is absent then startDate exists and observationFrequency exists or adjustedDate exists and observationFrequency is absent and startDate is absent and endDate is absent or observationFrequency exists and endDate exists or businessCentersReference exists or businessCenters exists or dateOffset exists";
	
	class Default implements FxScheduleChoice9 {
	
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
				if (notExists(MapperS.of(fxSchedule).<BusinessDayAdjustments>map("getDateAdjustments", _fxSchedule -> _fxSchedule.getDateAdjustments())).andNullSafe(notExists(MapperS.of(fxSchedule).<DayTypeEnum>map("getDayType", _fxSchedule -> _fxSchedule.getDayType()))).getOrDefault(false)) {
					return exists(MapperS.of(fxSchedule).<ZonedDateTime>map("getStartDate", _fxSchedule -> _fxSchedule.getStartDate())).andNullSafe(exists(MapperS.of(fxSchedule).<ObservationFrequency>map("getObservationFrequency", _fxSchedule -> _fxSchedule.getObservationFrequency()))).orNullSafe(exists(MapperS.of(fxSchedule).<ZonedDateTime>mapC("getAdjustedDate", _fxSchedule -> _fxSchedule.getAdjustedDate())).andNullSafe(notExists(MapperS.of(fxSchedule).<ObservationFrequency>map("getObservationFrequency", _fxSchedule -> _fxSchedule.getObservationFrequency()))).andNullSafe(notExists(MapperS.of(fxSchedule).<ZonedDateTime>map("getStartDate", _fxSchedule -> _fxSchedule.getStartDate()))).andNullSafe(notExists(MapperS.of(fxSchedule).<ZonedDateTime>map("getEndDate", _fxSchedule -> _fxSchedule.getEndDate())))).orNullSafe(exists(MapperS.of(fxSchedule).<ObservationFrequency>map("getObservationFrequency", _fxSchedule -> _fxSchedule.getObservationFrequency())).andNullSafe(exists(MapperS.of(fxSchedule).<ZonedDateTime>map("getEndDate", _fxSchedule -> _fxSchedule.getEndDate())))).orNullSafe(exists(MapperS.of(fxSchedule).<BusinessCentersReference>map("getBusinessCentersReference", _fxSchedule -> _fxSchedule.getBusinessCentersReference()))).orNullSafe(exists(MapperS.of(fxSchedule).<BusinessCenters>map("getBusinessCenters", _fxSchedule -> _fxSchedule.getBusinessCenters()))).orNullSafe(exists(MapperS.of(fxSchedule).<FxDateOffset>map("getDateOffset", _fxSchedule -> _fxSchedule.getDateOffset())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxScheduleChoice9 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSchedule fxSchedule) {
			return Collections.emptyList();
		}
	}
}
