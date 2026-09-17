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
import fpml.consolidated.shared.ObservationFrequency;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxScheduleChoice8")
@ImplementedBy(FxScheduleChoice8.Default.class)
public interface FxScheduleChoice8 extends Validator<FxSchedule> {
	
	String NAME = "FxScheduleChoice8";
	String DEFINITION = "if dayType exists then startDate exists and observationFrequency is absent or endDate exists and observationFrequency is absent or businessCentersReference exists or businessCenters exists or dateOffset exists";
	
	class Default implements FxScheduleChoice8 {
	
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
				if (exists(MapperS.of(fxSchedule).<DayTypeEnum>map("getDayType", _fxSchedule -> _fxSchedule.getDayType())).getOrDefault(false)) {
					return exists(MapperS.of(fxSchedule).<ZonedDateTime>map("getStartDate", _fxSchedule -> _fxSchedule.getStartDate())).andNullSafe(notExists(MapperS.of(fxSchedule).<ObservationFrequency>map("getObservationFrequency", _fxSchedule -> _fxSchedule.getObservationFrequency()))).orNullSafe(exists(MapperS.of(fxSchedule).<ZonedDateTime>map("getEndDate", _fxSchedule -> _fxSchedule.getEndDate())).andNullSafe(notExists(MapperS.of(fxSchedule).<ObservationFrequency>map("getObservationFrequency", _fxSchedule -> _fxSchedule.getObservationFrequency())))).orNullSafe(exists(MapperS.of(fxSchedule).<BusinessCentersReference>map("getBusinessCentersReference", _fxSchedule -> _fxSchedule.getBusinessCentersReference()))).orNullSafe(exists(MapperS.of(fxSchedule).<BusinessCenters>map("getBusinessCenters", _fxSchedule -> _fxSchedule.getBusinessCenters()))).orNullSafe(exists(MapperS.of(fxSchedule).<FxDateOffset>map("getDateOffset", _fxSchedule -> _fxSchedule.getDateOffset())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxScheduleChoice8 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSchedule fxSchedule) {
			return Collections.emptyList();
		}
	}
}
