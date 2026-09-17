package fpml.consolidated.variance.swaps.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("VarianceSwapTransactionSupplementChoice")
@ImplementedBy(VarianceSwapTransactionSupplementChoice.Default.class)
public interface VarianceSwapTransactionSupplementChoice extends Validator<VarianceSwapTransactionSupplement> {
	
	String NAME = "VarianceSwapTransactionSupplementChoice";
	String DEFINITION = "optional choice multipleExchangeIndexAnnexFallback, componentSecurityIndexAnnexFallback";
	
	class Default implements VarianceSwapTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceSwapTransactionSupplement varianceSwapTransactionSupplement) {
			ComparisonResult result = executeDataRule(varianceSwapTransactionSupplement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceSwapTransactionSupplement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceSwapTransactionSupplement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(VarianceSwapTransactionSupplement varianceSwapTransactionSupplement) {
			try {
				return choice(MapperS.of(varianceSwapTransactionSupplement), Arrays.asList("multipleExchangeIndexAnnexFallback", "componentSecurityIndexAnnexFallback"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VarianceSwapTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceSwapTransactionSupplement varianceSwapTransactionSupplement) {
			return Collections.emptyList();
		}
	}
}
