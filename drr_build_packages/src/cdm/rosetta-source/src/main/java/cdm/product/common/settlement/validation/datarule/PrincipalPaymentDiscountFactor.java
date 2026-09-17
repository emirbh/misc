package cdm.product.common.settlement.validation.datarule;

import cdm.observable.asset.Money;
import cdm.product.common.settlement.PrincipalPayment;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PrincipalPaymentDiscountFactor")
@ImplementedBy(PrincipalPaymentDiscountFactor.Default.class)
public interface PrincipalPaymentDiscountFactor extends Validator<PrincipalPayment> {
	
	String NAME = "PrincipalPaymentDiscountFactor";
	String DEFINITION = "if presentValuePrincipalAmount exists then discountFactor exists";
	
	class Default implements PrincipalPaymentDiscountFactor {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalPayment principalPayment) {
			ComparisonResult result = executeDataRule(principalPayment);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PrincipalPayment", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PrincipalPayment", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PrincipalPayment principalPayment) {
			try {
				if (exists(MapperS.of(principalPayment).<Money>map("getPresentValuePrincipalAmount", _principalPayment -> _principalPayment.getPresentValuePrincipalAmount())).getOrDefault(false)) {
					return exists(MapperS.of(principalPayment).<BigDecimal>map("getDiscountFactor", _principalPayment -> _principalPayment.getDiscountFactor()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PrincipalPaymentDiscountFactor {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalPayment principalPayment) {
			return Collections.emptyList();
		}
	}
}
