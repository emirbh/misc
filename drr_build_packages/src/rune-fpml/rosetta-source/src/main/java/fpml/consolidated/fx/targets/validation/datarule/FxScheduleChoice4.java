package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.targets.FxSchedule;
import fpml.consolidated.shared.BusinessCenters;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxScheduleChoice4")
@ImplementedBy(FxScheduleChoice4.Default.class)
public interface FxScheduleChoice4 extends Validator<FxSchedule> {
	
	String NAME = "FxScheduleChoice4";
	String DEFINITION = "if businessCenters exists then dayType exists and (startDate exists or endDate exists)";
	
	class Default implements FxScheduleChoice4 {
	
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
				if (exists(MapperS.of(fxSchedule).<BusinessCenters>map("getBusinessCenters", _fxSchedule -> _fxSchedule.getBusinessCenters())).getOrDefault(false)) {
					return exists(MapperS.of(fxSchedule).<DayTypeEnum>map("getDayType", _fxSchedule -> _fxSchedule.getDayType())).andNullSafe(exists(MapperS.of(fxSchedule).<ZonedDateTime>map("getStartDate", _fxSchedule -> _fxSchedule.getStartDate())).orNullSafe(exists(MapperS.of(fxSchedule).<ZonedDateTime>map("getEndDate", _fxSchedule -> _fxSchedule.getEndDate()))));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxScheduleChoice4 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSchedule fxSchedule) {
			return Collections.emptyList();
		}
	}
}
