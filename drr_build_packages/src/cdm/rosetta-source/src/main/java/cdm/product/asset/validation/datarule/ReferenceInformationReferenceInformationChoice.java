package cdm.product.asset.validation.datarule;

import cdm.product.asset.ReferenceInformation;
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
@RosettaDataRule("ReferenceInformationReferenceInformationChoice")
@ImplementedBy(ReferenceInformationReferenceInformationChoice.Default.class)
public interface ReferenceInformationReferenceInformationChoice extends Validator<ReferenceInformation> {
	
	String NAME = "ReferenceInformationReferenceInformationChoice";
	String DEFINITION = "required choice referenceObligation, noReferenceObligation , unknownReferenceObligation";
	
	class Default implements ReferenceInformationReferenceInformationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceInformation referenceInformation) {
			ComparisonResult result = executeDataRule(referenceInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReferenceInformation referenceInformation) {
			try {
				return choice(MapperS.of(referenceInformation), Arrays.asList("referenceObligation", "noReferenceObligation", "unknownReferenceObligation"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReferenceInformationReferenceInformationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceInformation referenceInformation) {
			return Collections.emptyList();
		}
	}
}
