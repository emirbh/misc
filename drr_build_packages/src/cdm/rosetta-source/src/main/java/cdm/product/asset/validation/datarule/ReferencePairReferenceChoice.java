package cdm.product.asset.validation.datarule;

import cdm.product.asset.ReferencePair;
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
@RosettaDataRule("ReferencePairReferenceChoice")
@ImplementedBy(ReferencePairReferenceChoice.Default.class)
public interface ReferencePairReferenceChoice extends Validator<ReferencePair> {
	
	String NAME = "ReferencePairReferenceChoice";
	String DEFINITION = "required choice referenceObligation, noReferenceObligation";
	
	class Default implements ReferencePairReferenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePair referencePair) {
			ComparisonResult result = executeDataRule(referencePair);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferencePair", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferencePair", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReferencePair referencePair) {
			try {
				return choice(MapperS.of(referencePair), Arrays.asList("referenceObligation", "noReferenceObligation"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReferencePairReferenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePair referencePair) {
			return Collections.emptyList();
		}
	}
}
