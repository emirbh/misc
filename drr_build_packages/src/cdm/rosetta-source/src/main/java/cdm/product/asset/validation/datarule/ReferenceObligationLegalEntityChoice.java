package cdm.product.asset.validation.datarule;

import cdm.product.asset.ReferenceObligation;
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
@RosettaDataRule("ReferenceObligationLegalEntityChoice")
@ImplementedBy(ReferenceObligationLegalEntityChoice.Default.class)
public interface ReferenceObligationLegalEntityChoice extends Validator<ReferenceObligation> {
	
	String NAME = "ReferenceObligationLegalEntityChoice";
	String DEFINITION = "optional choice primaryObligor, primaryObligorReference";
	
	class Default implements ReferenceObligationLegalEntityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceObligation referenceObligation) {
			ComparisonResult result = executeDataRule(referenceObligation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceObligation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceObligation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReferenceObligation referenceObligation) {
			try {
				return choice(MapperS.of(referenceObligation), Arrays.asList("primaryObligor", "primaryObligorReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReferenceObligationLegalEntityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceObligation referenceObligation) {
			return Collections.emptyList();
		}
	}
}
