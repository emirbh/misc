package cdm.product.common.schedule.validation.datarule;

import cdm.product.common.schedule.PaymentCalculationPeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PaymentCalculationPeriodFpML_ird_34")
@ImplementedBy(PaymentCalculationPeriodFpML_ird_34.Default.class)
public interface PaymentCalculationPeriodFpML_ird_34 extends Validator<PaymentCalculationPeriod> {
	
	String NAME = "PaymentCalculationPeriodFpML_ird_34";
	String DEFINITION = "unadjustedPaymentDate exists or adjustedPaymentDate exists";
	
	class Default implements PaymentCalculationPeriodFpML_ird_34 {
	
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
				return exists(MapperS.of(paymentCalculationPeriod).<Date>map("getUnadjustedPaymentDate", _paymentCalculationPeriod -> _paymentCalculationPeriod.getUnadjustedPaymentDate())).orNullSafe(exists(MapperS.of(paymentCalculationPeriod).<Date>map("getAdjustedPaymentDate", _paymentCalculationPeriod -> _paymentCalculationPeriod.getAdjustedPaymentDate())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PaymentCalculationPeriodFpML_ird_34 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentCalculationPeriod paymentCalculationPeriod) {
			return Collections.emptyList();
		}
	}
}
