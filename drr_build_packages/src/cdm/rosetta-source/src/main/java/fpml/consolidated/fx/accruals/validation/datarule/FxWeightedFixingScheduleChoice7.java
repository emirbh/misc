package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.accruals.FxFixingObservation;
import fpml.consolidated.fx.accruals.FxWeightedFixingSchedule;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.ObservationFrequency;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxWeightedFixingScheduleChoice7")
@ImplementedBy(FxWeightedFixingScheduleChoice7.Default.class)
public interface FxWeightedFixingScheduleChoice7 extends Validator<FxWeightedFixingSchedule> {
	
	String NAME = "FxWeightedFixingScheduleChoice7";
	String DEFINITION = "if dayType exists then startDate exists and fixing is absent and observationFrequency is absent or endDate exists and fixing is absent and observationFrequency is absent or startDate exists and numberOfFixings is absent and observationFrequency is absent or endDate exists and numberOfFixings is absent and observationFrequency is absent or businessCentersReference exists or businessCenters exists";
	
	class Default implements FxWeightedFixingScheduleChoice7 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			ComparisonResult result = executeDataRule(fxWeightedFixingSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxWeightedFixingSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxWeightedFixingSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			try {
				if (exists(MapperS.of(fxWeightedFixingSchedule).<DayTypeEnum>map("getDayType", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getDayType())).getOrDefault(false)) {
					return exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getStartDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getStartDate())).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<FxFixingObservation>mapC("getFixing", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getFixing()))).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getObservationFrequency()))).orNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getEndDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getEndDate())).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<FxFixingObservation>mapC("getFixing", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getFixing()))).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getObservationFrequency())))).orNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getStartDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getStartDate())).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<Integer>map("getNumberOfFixings", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getNumberOfFixings()))).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getObservationFrequency())))).orNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getEndDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getEndDate())).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<Integer>map("getNumberOfFixings", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getNumberOfFixings()))).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getObservationFrequency())))).orNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<BusinessCentersReference>map("getBusinessCentersReference", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getBusinessCentersReference()))).orNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<BusinessCenters>map("getBusinessCenters", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getBusinessCenters())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxWeightedFixingScheduleChoice7 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			return Collections.emptyList();
		}
	}
}
