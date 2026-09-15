package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.PaymentDates;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PaymentDatesChoice")
@ImplementedBy(PaymentDatesChoice.Default.class)
public interface PaymentDatesChoice extends Validator<PaymentDates> {
	
	String NAME = "PaymentDatesChoice";
	String DEFINITION = "optional choice calculationPeriodDatesReference, resetDatesReference, valuationDatesReference";
	
	class Default implements PaymentDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDates paymentDates) {
			ComparisonResult result = executeDataRule(paymentDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PaymentDates paymentDates) {
			try {
				return choice(MapperS.of(paymentDates), Arrays.asList("calculationPeriodDatesReference", "resetDatesReference", "valuationDatesReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PaymentDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDates paymentDates) {
			return Collections.emptyList();
		}
	}
}
