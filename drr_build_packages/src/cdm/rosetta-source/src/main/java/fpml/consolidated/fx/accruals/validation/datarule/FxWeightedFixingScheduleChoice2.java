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
import fpml.consolidated.fx.accruals.FxWeightedFixingSchedule;
import fpml.consolidated.shared.BusinessCentersReference;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxWeightedFixingScheduleChoice2")
@ImplementedBy(FxWeightedFixingScheduleChoice2.Default.class)
public interface FxWeightedFixingScheduleChoice2 extends Validator<FxWeightedFixingSchedule> {
	
	String NAME = "FxWeightedFixingScheduleChoice2";
	String DEFINITION = "if businessCentersReference exists then dayType exists and (startDate exists or endDate exists) and optional choice fixing, numberOfFixings";
	
	class Default implements FxWeightedFixingScheduleChoice2 {
	
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
				if (exists(MapperS.of(fxWeightedFixingSchedule).<BusinessCentersReference>map("getBusinessCentersReference", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getBusinessCentersReference())).getOrDefault(false)) {
					return exists(MapperS.of(fxWeightedFixingSchedule).<DayTypeEnum>map("getDayType", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getDayType())).andNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getStartDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getStartDate())).orNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getEndDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getEndDate())))).andNullSafe(choice(MapperS.of(fxWeightedFixingSchedule), Arrays.asList("fixing", "numberOfFixings"), ChoiceRuleValidationMethod.OPTIONAL));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxWeightedFixingScheduleChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			return Collections.emptyList();
		}
	}
}
