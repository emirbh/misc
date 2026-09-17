package cdm.product.common.settlement.validation.datarule;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.Money;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PrincipalPayment;
import cdm.product.common.settlement.PrincipalPaymentSchedule;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("PayoutBaseFinalPrincipalAmountExists")
@ImplementedBy(PayoutBaseFinalPrincipalAmountExists.Default.class)
public interface PayoutBaseFinalPrincipalAmountExists extends Validator<PayoutBase> {
	
	String NAME = "PayoutBaseFinalPrincipalAmountExists";
	String DEFINITION = "if principalPayment -> principalPaymentSchedule -> finalPrincipalPayment exists and priceQuantity -> quantitySchedule exists and priceQuantity -> reset is absent then principalPayment -> principalPaymentSchedule -> finalPrincipalPayment -> principalAmount exists or principalPayment -> principalPaymentSchedule -> finalPrincipalPayment -> presentValuePrincipalAmount exists";
	
	class Default implements PayoutBaseFinalPrincipalAmountExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PayoutBase payoutBase) {
			ComparisonResult result = executeDataRule(payoutBase);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PayoutBase", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PayoutBase", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PayoutBase payoutBase) {
			try {
				if (exists(MapperS.of(payoutBase).<PrincipalPayments>map("getPrincipalPayment", _payoutBase -> _payoutBase.getPrincipalPayment()).<PrincipalPaymentSchedule>map("getPrincipalPaymentSchedule", principalPayments -> principalPayments.getPrincipalPaymentSchedule()).<PrincipalPayment>map("getFinalPrincipalPayment", principalPaymentSchedule -> principalPaymentSchedule.getFinalPrincipalPayment())).andNullSafe(exists(MapperS.of(payoutBase).<ResolvablePriceQuantity>map("getPriceQuantity", _payoutBase -> _payoutBase.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()))).andNullSafe(notExists(MapperS.of(payoutBase).<ResolvablePriceQuantity>map("getPriceQuantity", _payoutBase -> _payoutBase.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).getOrDefault(false)) {
					return exists(MapperS.of(payoutBase).<PrincipalPayments>map("getPrincipalPayment", _payoutBase -> _payoutBase.getPrincipalPayment()).<PrincipalPaymentSchedule>map("getPrincipalPaymentSchedule", principalPayments -> principalPayments.getPrincipalPaymentSchedule()).<PrincipalPayment>map("getFinalPrincipalPayment", principalPaymentSchedule -> principalPaymentSchedule.getFinalPrincipalPayment()).<Money>map("getPrincipalAmount", principalPayment -> principalPayment.getPrincipalAmount())).orNullSafe(exists(MapperS.of(payoutBase).<PrincipalPayments>map("getPrincipalPayment", _payoutBase -> _payoutBase.getPrincipalPayment()).<PrincipalPaymentSchedule>map("getPrincipalPaymentSchedule", principalPayments -> principalPayments.getPrincipalPaymentSchedule()).<PrincipalPayment>map("getFinalPrincipalPayment", principalPaymentSchedule -> principalPaymentSchedule.getFinalPrincipalPayment()).<Money>map("getPresentValuePrincipalAmount", principalPayment -> principalPayment.getPresentValuePrincipalAmount())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PayoutBaseFinalPrincipalAmountExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PayoutBase payoutBase) {
			return Collections.emptyList();
		}
	}
}
