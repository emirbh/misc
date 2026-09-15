package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxFixingSchedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxFixingScheduleChoice3")
@ImplementedBy(FxFixingScheduleChoice3.Default.class)
public interface FxFixingScheduleChoice3 extends Validator<FxFixingSchedule> {
	
	String NAME = "FxFixingScheduleChoice3";
	String DEFINITION = "optional choice observationFrequency, businessCenters";
	
	class Default implements FxFixingScheduleChoice3 {
	
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
				return choice(MapperS.of(fxFixingSchedule), Arrays.asList("observationFrequency", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingScheduleChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingSchedule fxFixingSchedule) {
			return Collections.emptyList();
		}
	}
}
