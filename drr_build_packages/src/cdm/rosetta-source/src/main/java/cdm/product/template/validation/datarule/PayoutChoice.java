package cdm.product.template.validation.datarule;

import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PayoutChoice")
@ImplementedBy(PayoutChoice.Default.class)
public interface PayoutChoice extends Validator<Payout> {
	
	String NAME = "PayoutChoice";
	String DEFINITION = "";
	
	class Default implements PayoutChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Payout payout) {
			ComparisonResult result = executeDataRule(payout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Payout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Payout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Payout payout) {
			try {
				return choice(MapperS.of(payout), Arrays.asList("AssetPayout", "CommodityPayout", "CreditDefaultPayout", "FixedPricePayout", "InterestRatePayout", "OptionPayout", "PerformancePayout", "SettlementPayout"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PayoutChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Payout payout) {
			return Collections.emptyList();
		}
	}
}
