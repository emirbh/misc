package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.PaymentCalculationPeriod;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PaymentCalculationPeriodChoice")
@ImplementedBy(PaymentCalculationPeriodChoice.Default.class)
public interface PaymentCalculationPeriodChoice extends Validator<PaymentCalculationPeriod> {
	
	String NAME = "PaymentCalculationPeriodChoice";
	String DEFINITION = "optional choice calculationPeriod, fixedPaymentAmount";
	
	class Default implements PaymentCalculationPeriodChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentCalculationPeriod paymentCalculationPeriod) {
			ComparisonResult result = executeDataRule(paymentCalculationPeriod);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentCalculationPeriod", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentCalculationPeriod", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PaymentCalculationPeriod paymentCalculationPeriod) {
			try {
				return choice(MapperS.of(paymentCalculationPeriod), Arrays.asList("calculationPeriod", "fixedPaymentAmount"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PaymentCalculationPeriodChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentCalculationPeriod paymentCalculationPeriod) {
			return Collections.emptyList();
		}
	}
}
