package cdm.product.common.schedule.validation.datarule;

import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("PaymentDatesFpML_ird_35_cd_31")
@ImplementedBy(PaymentDatesFpML_ird_35_cd_31.Default.class)
public interface PaymentDatesFpML_ird_35_cd_31 extends Validator<PaymentDates> {
	
	String NAME = "PaymentDatesFpML_ird_35_cd_31";
	String DEFINITION = "if firstPaymentDate exists and lastRegularPaymentDate exists then firstPaymentDate < lastRegularPaymentDate";
	
	class Default implements PaymentDatesFpML_ird_35_cd_31 {
	
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
				if (exists(MapperS.of(paymentDates).<Date>map("getFirstPaymentDate", _paymentDates -> _paymentDates.getFirstPaymentDate())).andNullSafe(exists(MapperS.of(paymentDates).<Date>map("getLastRegularPaymentDate", _paymentDates -> _paymentDates.getLastRegularPaymentDate()))).getOrDefault(false)) {
					return lessThan(MapperS.of(paymentDates).<Date>map("getFirstPaymentDate", _paymentDates -> _paymentDates.getFirstPaymentDate()), MapperS.of(paymentDates).<Date>map("getLastRegularPaymentDate", _paymentDates -> _paymentDates.getLastRegularPaymentDate()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PaymentDatesFpML_ird_35_cd_31 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDates paymentDates) {
			return Collections.emptyList();
		}
	}
}
