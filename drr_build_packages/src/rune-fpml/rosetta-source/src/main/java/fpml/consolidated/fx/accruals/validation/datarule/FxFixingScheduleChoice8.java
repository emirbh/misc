package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.accruals.FxFixingSchedule;
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
@RosettaDataRule("FxFixingScheduleChoice8")
@ImplementedBy(FxFixingScheduleChoice8.Default.class)
public interface FxFixingScheduleChoice8 extends Validator<FxFixingSchedule> {
	
	String NAME = "FxFixingScheduleChoice8";
	String DEFINITION = "if dateAdjustments is absent and dayType is absent then startDate exists and observationFrequency exists and numberOfFixings is absent or observationFrequency exists and endDate exists and fixingDate is absent or observationFrequency exists and startDate exists and fixingDate is absent or endDate exists and observationFrequency exists and numberOfFixings is absent or numberOfFixings is absent and startDate is absent and endDate is absent and observationFrequency is absent or businessCentersReference exists or businessCenters exists";
	
	class Default implements FxFixingScheduleChoice8 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingSchedule fxFixingSchedule) {
			ComparisonResult result = executeDataRule(fxFixingSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxFixingSchedule fxFixingSchedule) {
			try {
				if (notExists(MapperS.of(fxFixingSchedule).<BusinessDayAdjustments>map("getDateAdjustments", _fxFixingSchedule -> _fxFixingSchedule.getDateAdjustments())).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<DayTypeEnum>map("getDayType", _fxFixingSchedule -> _fxFixingSchedule.getDayType()))).getOrDefault(false)) {
					return exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getStartDate", _fxFixingSchedule -> _fxFixingSchedule.getStartDate())).andNullSafe(exists(MapperS.of(fxFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxFixingSchedule -> _fxFixingSchedule.getObservationFrequency()))).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<Integer>map("getNumberOfFixings", _fxFixingSchedule -> _fxFixingSchedule.getNumberOfFixings()))).orNullSafe(exists(MapperS.of(fxFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxFixingSchedule -> _fxFixingSchedule.getObservationFrequency())).andNullSafe(exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getEndDate", _fxFixingSchedule -> _fxFixingSchedule.getEndDate()))).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<ZonedDateTime>mapC("getFixingDate", _fxFixingSchedule -> _fxFixingSchedule.getFixingDate())))).orNullSafe(exists(MapperS.of(fxFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxFixingSchedule -> _fxFixingSchedule.getObservationFrequency())).andNullSafe(exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getStartDate", _fxFixingSchedule -> _fxFixingSchedule.getStartDate()))).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<ZonedDateTime>mapC("getFixingDate", _fxFixingSchedule -> _fxFixingSchedule.getFixingDate())))).orNullSafe(exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getEndDate", _fxFixingSchedule -> _fxFixingSchedule.getEndDate())).andNullSafe(exists(MapperS.of(fxFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxFixingSchedule -> _fxFixingSchedule.getObservationFrequency()))).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<Integer>map("getNumberOfFixings", _fxFixingSchedule -> _fxFixingSchedule.getNumberOfFixings())))).orNullSafe(notExists(MapperS.of(fxFixingSchedule).<Integer>map("getNumberOfFixings", _fxFixingSchedule -> _fxFixingSchedule.getNumberOfFixings())).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getStartDate", _fxFixingSchedule -> _fxFixingSchedule.getStartDate()))).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getEndDate", _fxFixingSchedule -> _fxFixingSchedule.getEndDate()))).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxFixingSchedule -> _fxFixingSchedule.getObservationFrequency())))).orNullSafe(exists(MapperS.of(fxFixingSchedule).<BusinessCentersReference>map("getBusinessCentersReference", _fxFixingSchedule -> _fxFixingSchedule.getBusinessCentersReference()))).orNullSafe(exists(MapperS.of(fxFixingSchedule).<BusinessCenters>map("getBusinessCenters", _fxFixingSchedule -> _fxFixingSchedule.getBusinessCenters())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingScheduleChoice8 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingSchedule fxFixingSchedule) {
			return Collections.emptyList();
		}
	}
}
