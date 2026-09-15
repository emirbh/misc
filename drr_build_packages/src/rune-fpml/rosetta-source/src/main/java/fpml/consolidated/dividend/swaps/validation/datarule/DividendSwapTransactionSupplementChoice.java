package fpml.consolidated.dividend.swaps.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DividendSwapTransactionSupplementChoice")
@ImplementedBy(DividendSwapTransactionSupplementChoice.Default.class)
public interface DividendSwapTransactionSupplementChoice extends Validator<DividendSwapTransactionSupplement> {
	
	String NAME = "DividendSwapTransactionSupplementChoice";
	String DEFINITION = "optional choice multipleExchangeIndexAnnexFallback, componentSecurityIndexAnnexFallback";
	
	class Default implements DividendSwapTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendSwapTransactionSupplement dividendSwapTransactionSupplement) {
			ComparisonResult result = executeDataRule(dividendSwapTransactionSupplement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendSwapTransactionSupplement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendSwapTransactionSupplement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendSwapTransactionSupplement dividendSwapTransactionSupplement) {
			try {
				return choice(MapperS.of(dividendSwapTransactionSupplement), Arrays.asList("multipleExchangeIndexAnnexFallback", "componentSecurityIndexAnnexFallback"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendSwapTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendSwapTransactionSupplement dividendSwapTransactionSupplement) {
			return Collections.emptyList();
		}
	}
}
