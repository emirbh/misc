package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.PricingDates;
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
@RosettaDataRule("PricingDatesOneOf0")
@ImplementedBy(PricingDatesOneOf0.Default.class)
public interface PricingDatesOneOf0 extends Validator<PricingDates> {
	
	String NAME = "PricingDatesOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements PricingDatesOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingDates pricingDates) {
			ComparisonResult result = executeDataRule(pricingDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PricingDates pricingDates) {
			try {
				return choice(MapperS.of(pricingDates), Arrays.asList("specifiedDates", "parametricDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PricingDatesOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingDates pricingDates) {
			return Collections.emptyList();
		}
	}
}
