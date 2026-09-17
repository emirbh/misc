package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("AdjustableDateAdjustableDateChoice")
@ImplementedBy(AdjustableDateAdjustableDateChoice.Default.class)
public interface AdjustableDateAdjustableDateChoice extends Validator<AdjustableDate> {
	
	String NAME = "AdjustableDateAdjustableDateChoice";
	String DEFINITION = "optional choice dateAdjustments, dateAdjustmentsReference";
	
	class Default implements AdjustableDateAdjustableDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDate adjustableDate) {
			ComparisonResult result = executeDataRule(adjustableDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableDate adjustableDate) {
			try {
				return choice(MapperS.of(adjustableDate), Arrays.asList("dateAdjustments", "dateAdjustmentsReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableDateAdjustableDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDate adjustableDate) {
			return Collections.emptyList();
		}
	}
}
