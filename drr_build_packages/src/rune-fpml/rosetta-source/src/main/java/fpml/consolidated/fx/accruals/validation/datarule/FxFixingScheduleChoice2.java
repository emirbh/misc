package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.accruals.FxFixingSchedule;
import fpml.consolidated.shared.BusinessCentersReference;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxFixingScheduleChoice2")
@ImplementedBy(FxFixingScheduleChoice2.Default.class)
public interface FxFixingScheduleChoice2 extends Validator<FxFixingSchedule> {
	
	String NAME = "FxFixingScheduleChoice2";
	String DEFINITION = "if businessCentersReference exists then dayType exists and (startDate exists or endDate exists) and optional choice fixingDate, numberOfFixings";
	
	class Default implements FxFixingScheduleChoice2 {
	
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
				if (exists(MapperS.of(fxFixingSchedule).<BusinessCentersReference>map("getBusinessCentersReference", _fxFixingSchedule -> _fxFixingSchedule.getBusinessCentersReference())).getOrDefault(false)) {
					return exists(MapperS.of(fxFixingSchedule).<DayTypeEnum>map("getDayType", _fxFixingSchedule -> _fxFixingSchedule.getDayType())).andNullSafe(exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getStartDate", _fxFixingSchedule -> _fxFixingSchedule.getStartDate())).orNullSafe(exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getEndDate", _fxFixingSchedule -> _fxFixingSchedule.getEndDate())))).andNullSafe(choice(MapperS.of(fxFixingSchedule), Arrays.asList("fixingDate", "numberOfFixings"), ChoiceRuleValidationMethod.OPTIONAL));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingScheduleChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingSchedule fxFixingSchedule) {
			return Collections.emptyList();
		}
	}
}
