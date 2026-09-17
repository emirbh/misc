package cdm.product.asset.validation.datarule;

import cdm.product.asset.BasketReferenceInformation;
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
@RosettaDataRule("BasketReferenceInformationBasketReferenceInformationChoice")
@ImplementedBy(BasketReferenceInformationBasketReferenceInformationChoice.Default.class)
public interface BasketReferenceInformationBasketReferenceInformationChoice extends Validator<BasketReferenceInformation> {
	
	String NAME = "BasketReferenceInformationBasketReferenceInformationChoice";
	String DEFINITION = "required choice nthToDefault, tranche";
	
	class Default implements BasketReferenceInformationBasketReferenceInformationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketReferenceInformation basketReferenceInformation) {
			ComparisonResult result = executeDataRule(basketReferenceInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketReferenceInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketReferenceInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BasketReferenceInformation basketReferenceInformation) {
			try {
				return choice(MapperS.of(basketReferenceInformation), Arrays.asList("nthToDefault", "tranche"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BasketReferenceInformationBasketReferenceInformationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketReferenceInformation basketReferenceInformation) {
			return Collections.emptyList();
		}
	}
}
