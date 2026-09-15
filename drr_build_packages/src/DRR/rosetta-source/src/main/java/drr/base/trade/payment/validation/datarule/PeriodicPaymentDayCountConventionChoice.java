package drr.base.trade.payment.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.PeriodicPayment;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("PeriodicPaymentDayCountConventionChoice")
@ImplementedBy(PeriodicPaymentDayCountConventionChoice.Default.class)
public interface PeriodicPaymentDayCountConventionChoice extends Validator<PeriodicPayment> {
	
	String NAME = "PeriodicPaymentDayCountConventionChoice";
	String DEFINITION = "optional choice fixedRateDayCountConvention, floatingRateDayCountConvention";
	
	class Default implements PeriodicPaymentDayCountConventionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodicPayment periodicPayment) {
			ComparisonResult result = executeDataRule(periodicPayment);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PeriodicPayment", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PeriodicPayment", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PeriodicPayment periodicPayment) {
			try {
				return choice(MapperS.of(periodicPayment), Arrays.asList("fixedRateDayCountConvention", "floatingRateDayCountConvention"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PeriodicPaymentDayCountConventionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodicPayment periodicPayment) {
			return Collections.emptyList();
		}
	}
}
