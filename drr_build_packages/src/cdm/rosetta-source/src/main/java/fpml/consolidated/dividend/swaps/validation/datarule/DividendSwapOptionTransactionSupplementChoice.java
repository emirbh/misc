package fpml.consolidated.dividend.swaps.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DividendSwapOptionTransactionSupplementChoice")
@ImplementedBy(DividendSwapOptionTransactionSupplementChoice.Default.class)
public interface DividendSwapOptionTransactionSupplementChoice extends Validator<DividendSwapOptionTransactionSupplement> {
	
	String NAME = "DividendSwapOptionTransactionSupplementChoice";
	String DEFINITION = "optional choice optionEntitlement, multiplier";
	
	class Default implements DividendSwapOptionTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendSwapOptionTransactionSupplement dividendSwapOptionTransactionSupplement) {
			ComparisonResult result = executeDataRule(dividendSwapOptionTransactionSupplement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendSwapOptionTransactionSupplement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendSwapOptionTransactionSupplement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendSwapOptionTransactionSupplement dividendSwapOptionTransactionSupplement) {
			try {
				return choice(MapperS.of(dividendSwapOptionTransactionSupplement), Arrays.asList("optionEntitlement", "multiplier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendSwapOptionTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendSwapOptionTransactionSupplement dividendSwapOptionTransactionSupplement) {
			return Collections.emptyList();
		}
	}
}
