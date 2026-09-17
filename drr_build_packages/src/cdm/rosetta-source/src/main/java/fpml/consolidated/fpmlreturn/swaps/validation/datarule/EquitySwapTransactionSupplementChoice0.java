package fpml.consolidated.fpmlreturn.swaps.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EquitySwapTransactionSupplementChoice0")
@ImplementedBy(EquitySwapTransactionSupplementChoice0.Default.class)
public interface EquitySwapTransactionSupplementChoice0 extends Validator<EquitySwapTransactionSupplement> {
	
	String NAME = "EquitySwapTransactionSupplementChoice0";
	String DEFINITION = "optional choice multipleExchangeIndexAnnexFallback, componentSecurityIndexAnnexFallback";
	
	class Default implements EquitySwapTransactionSupplementChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquitySwapTransactionSupplement equitySwapTransactionSupplement) {
			ComparisonResult result = executeDataRule(equitySwapTransactionSupplement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquitySwapTransactionSupplement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquitySwapTransactionSupplement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquitySwapTransactionSupplement equitySwapTransactionSupplement) {
			try {
				return choice(MapperS.of(equitySwapTransactionSupplement), Arrays.asList("multipleExchangeIndexAnnexFallback", "componentSecurityIndexAnnexFallback"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquitySwapTransactionSupplementChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquitySwapTransactionSupplement equitySwapTransactionSupplement) {
			return Collections.emptyList();
		}
	}
}
