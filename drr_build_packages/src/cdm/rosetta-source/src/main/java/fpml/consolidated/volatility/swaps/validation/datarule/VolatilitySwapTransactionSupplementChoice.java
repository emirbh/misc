package fpml.consolidated.volatility.swaps.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("VolatilitySwapTransactionSupplementChoice")
@ImplementedBy(VolatilitySwapTransactionSupplementChoice.Default.class)
public interface VolatilitySwapTransactionSupplementChoice extends Validator<VolatilitySwapTransactionSupplement> {
	
	String NAME = "VolatilitySwapTransactionSupplementChoice";
	String DEFINITION = "optional choice multipleExchangeIndexAnnexFallback, componentSecurityIndexAnnexFallback";
	
	class Default implements VolatilitySwapTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilitySwapTransactionSupplement volatilitySwapTransactionSupplement) {
			ComparisonResult result = executeDataRule(volatilitySwapTransactionSupplement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VolatilitySwapTransactionSupplement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "VolatilitySwapTransactionSupplement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(VolatilitySwapTransactionSupplement volatilitySwapTransactionSupplement) {
			try {
				return choice(MapperS.of(volatilitySwapTransactionSupplement), Arrays.asList("multipleExchangeIndexAnnexFallback", "componentSecurityIndexAnnexFallback"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VolatilitySwapTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilitySwapTransactionSupplement volatilitySwapTransactionSupplement) {
			return Collections.emptyList();
		}
	}
}
