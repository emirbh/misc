package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableDate2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AdjustableDate2Choice")
@ImplementedBy(AdjustableDate2Choice.Default.class)
public interface AdjustableDate2Choice extends Validator<AdjustableDate2> {
	
	String NAME = "AdjustableDate2Choice";
	String DEFINITION = "optional choice dateAdjustments, dateAdjustmentsReference";
	
	class Default implements AdjustableDate2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDate2 adjustableDate2) {
			ComparisonResult result = executeDataRule(adjustableDate2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDate2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDate2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableDate2 adjustableDate2) {
			try {
				return choice(MapperS.of(adjustableDate2), Arrays.asList("dateAdjustments", "dateAdjustmentsReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableDate2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDate2 adjustableDate2) {
			return Collections.emptyList();
		}
	}
}
