package fpml.consolidated.riskdef.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.PricingParameterDerivative;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PricingParameterDerivativeChoice")
@ImplementedBy(PricingParameterDerivativeChoice.Default.class)
public interface PricingParameterDerivativeChoice extends Validator<PricingParameterDerivative> {
	
	String NAME = "PricingParameterDerivativeChoice";
	String DEFINITION = "optional choice parameterReference, assetReference, termPointReference, pricingStructureReference, inputDateReference";
	
	class Default implements PricingParameterDerivativeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingParameterDerivative pricingParameterDerivative) {
			ComparisonResult result = executeDataRule(pricingParameterDerivative);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingParameterDerivative", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingParameterDerivative", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PricingParameterDerivative pricingParameterDerivative) {
			try {
				return choice(MapperS.of(pricingParameterDerivative), Arrays.asList("parameterReference", "assetReference", "termPointReference", "pricingStructureReference", "inputDateReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PricingParameterDerivativeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingParameterDerivative pricingParameterDerivative) {
			return Collections.emptyList();
		}
	}
}
