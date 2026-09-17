package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxFixingScheduleSimple;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxFixingScheduleSimpleChoice")
@ImplementedBy(FxFixingScheduleSimpleChoice.Default.class)
public interface FxFixingScheduleSimpleChoice extends Validator<FxFixingScheduleSimple> {
	
	String NAME = "FxFixingScheduleSimpleChoice";
	String DEFINITION = "optional choice businessCentersReference, businessCenters";
	
	class Default implements FxFixingScheduleSimpleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingScheduleSimple fxFixingScheduleSimple) {
			ComparisonResult result = executeDataRule(fxFixingScheduleSimple);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingScheduleSimple", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingScheduleSimple", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxFixingScheduleSimple fxFixingScheduleSimple) {
			try {
				return choice(MapperS.of(fxFixingScheduleSimple), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingScheduleSimpleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingScheduleSimple fxFixingScheduleSimple) {
			return Collections.emptyList();
		}
	}
}
