package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.AdditionalRepresentations;
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
@RosettaDataRule("AdditionalRepresentationsOneOf0")
@ImplementedBy(AdditionalRepresentationsOneOf0.Default.class)
public interface AdditionalRepresentationsOneOf0 extends Validator<AdditionalRepresentations> {
	
	String NAME = "AdditionalRepresentationsOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements AdditionalRepresentationsOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalRepresentations additionalRepresentations) {
			ComparisonResult result = executeDataRule(additionalRepresentations);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalRepresentations", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalRepresentations", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdditionalRepresentations additionalRepresentations) {
			try {
				return choice(MapperS.of(additionalRepresentations), Arrays.asList("additionalRepresentation", "regulatoryComplianceRepresentation"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdditionalRepresentationsOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalRepresentations additionalRepresentations) {
			return Collections.emptyList();
		}
	}
}
