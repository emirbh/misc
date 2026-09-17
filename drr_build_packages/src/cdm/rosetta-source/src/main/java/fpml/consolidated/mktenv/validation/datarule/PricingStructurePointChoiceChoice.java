package fpml.consolidated.mktenv.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.PricingStructurePointChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PricingStructurePointChoiceChoice")
@ImplementedBy(PricingStructurePointChoiceChoice.Default.class)
public interface PricingStructurePointChoiceChoice extends Validator<PricingStructurePointChoice> {
	
	String NAME = "PricingStructurePointChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements PricingStructurePointChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructurePointChoice pricingStructurePointChoice) {
			ComparisonResult result = executeDataRule(pricingStructurePointChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingStructurePointChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingStructurePointChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PricingStructurePointChoice pricingStructurePointChoice) {
			try {
				return choice(MapperS.of(pricingStructurePointChoice), Arrays.asList("coordinate", "coordinateReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PricingStructurePointChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructurePointChoice pricingStructurePointChoice) {
			return Collections.emptyList();
		}
	}
}
