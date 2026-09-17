package cdm.product.asset.validation.datarule;

import cdm.product.asset.CreditDefaultPayout;
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
@RosettaDataRule("CreditDefaultPayoutQuantity")
@ImplementedBy(CreditDefaultPayoutQuantity.Default.class)
public interface CreditDefaultPayoutQuantity extends Validator<CreditDefaultPayout> {
	
	String NAME = "CreditDefaultPayoutQuantity";
	String DEFINITION = "priceQuantity exists";
	
	class Default implements CreditDefaultPayoutQuantity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultPayout creditDefaultPayout) {
			ComparisonResult result = executeDataRule(creditDefaultPayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditDefaultPayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditDefaultPayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditDefaultPayout creditDefaultPayout) {
			try {
				return exists(MapperS.of(creditDefaultPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _creditDefaultPayout -> _creditDefaultPayout.getPriceQuantity()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditDefaultPayoutQuantity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultPayout creditDefaultPayout) {
			return Collections.emptyList();
		}
	}
}
