package fpml.consolidated.riskdef.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.PricingDataPointCoordinateChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PricingDataPointCoordinateChoiceChoice")
@ImplementedBy(PricingDataPointCoordinateChoiceChoice.Default.class)
public interface PricingDataPointCoordinateChoiceChoice extends Validator<PricingDataPointCoordinateChoice> {
	
	String NAME = "PricingDataPointCoordinateChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements PricingDataPointCoordinateChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingDataPointCoordinateChoice pricingDataPointCoordinateChoice) {
			ComparisonResult result = executeDataRule(pricingDataPointCoordinateChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingDataPointCoordinateChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingDataPointCoordinateChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PricingDataPointCoordinateChoice pricingDataPointCoordinateChoice) {
			try {
				return choice(MapperS.of(pricingDataPointCoordinateChoice), Arrays.asList("term", "expiration", "strike", "generic"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PricingDataPointCoordinateChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingDataPointCoordinateChoice pricingDataPointCoordinateChoice) {
			return Collections.emptyList();
		}
	}
}
