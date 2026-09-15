package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxSchedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxScheduleChoice3")
@ImplementedBy(FxScheduleChoice3.Default.class)
public interface FxScheduleChoice3 extends Validator<FxSchedule> {
	
	String NAME = "FxScheduleChoice3";
	String DEFINITION = "optional choice observationFrequency, businessCenters";
	
	class Default implements FxScheduleChoice3 {
	
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
				return choice(MapperS.of(fxSchedule), Arrays.asList("observationFrequency", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxScheduleChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSchedule fxSchedule) {
			return Collections.emptyList();
		}
	}
}
