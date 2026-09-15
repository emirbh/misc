package drr.base.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.PayoutLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("PayoutLegOneOf0")
@ImplementedBy(PayoutLegOneOf0.Default.class)
public interface PayoutLegOneOf0 extends Validator<PayoutLeg> {
	
	String NAME = "PayoutLegOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements PayoutLegOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PayoutLeg payoutLeg) {
			ComparisonResult result = executeDataRule(payoutLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PayoutLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PayoutLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PayoutLeg payoutLeg) {
			try {
				return choice(MapperS.of(payoutLeg), Arrays.asList("creditDefaultPayout", "optionPayout", "settlementPayout", "performancePayout", "interestRatePayout", "cashflow", "fixedPricePayout", "commodityPayout"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PayoutLegOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PayoutLeg payoutLeg) {
			return Collections.emptyList();
		}
	}
}
