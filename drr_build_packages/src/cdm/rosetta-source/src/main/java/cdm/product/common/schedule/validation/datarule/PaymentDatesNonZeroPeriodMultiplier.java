package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.Offset;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PaymentDatesNonZeroPeriodMultiplier")
@ImplementedBy(PaymentDatesNonZeroPeriodMultiplier.Default.class)
public interface PaymentDatesNonZeroPeriodMultiplier extends Validator<PaymentDates> {
	
	String NAME = "PaymentDatesNonZeroPeriodMultiplier";
	String DEFINITION = "if paymentDaysOffset exists then paymentDaysOffset -> periodMultiplier <> 0";
	
	class Default implements PaymentDatesNonZeroPeriodMultiplier {
	
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
				if (exists(MapperS.of(paymentDates).<Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset())).getOrDefault(false)) {
					return notEqual(MapperS.of(paymentDates).<Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset()).<Integer>map("getPeriodMultiplier", offset -> offset.getPeriodMultiplier()), MapperS.of(0), CardinalityOperator.Any);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PaymentDatesNonZeroPeriodMultiplier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDates paymentDates) {
			return Collections.emptyList();
		}
	}
}
