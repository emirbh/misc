package cdm.product.asset.validation.datarule;

import cdm.product.asset.InterestRatePayout;
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
@RosettaDataRule("InterestRatePayoutInterestRatePayoutChoice")
@ImplementedBy(InterestRatePayoutInterestRatePayoutChoice.Default.class)
public interface InterestRatePayoutInterestRatePayoutChoice extends Validator<InterestRatePayout> {
	
	String NAME = "InterestRatePayoutInterestRatePayoutChoice";
	String DEFINITION = "optional choice paymentDates, paymentDate";
	
	class Default implements InterestRatePayoutInterestRatePayoutChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRatePayout interestRatePayout) {
			ComparisonResult result = executeDataRule(interestRatePayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRatePayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRatePayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InterestRatePayout interestRatePayout) {
			try {
				return choice(MapperS.of(interestRatePayout), Arrays.asList("paymentDates", "paymentDate"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestRatePayoutInterestRatePayoutChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRatePayout interestRatePayout) {
			return Collections.emptyList();
		}
	}
}
