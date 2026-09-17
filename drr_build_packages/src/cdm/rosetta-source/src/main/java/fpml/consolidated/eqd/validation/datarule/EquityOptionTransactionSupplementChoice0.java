package fpml.consolidated.eqd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EquityOptionTransactionSupplementChoice0")
@ImplementedBy(EquityOptionTransactionSupplementChoice0.Default.class)
public interface EquityOptionTransactionSupplementChoice0 extends Validator<EquityOptionTransactionSupplement> {
	
	String NAME = "EquityOptionTransactionSupplementChoice0";
	String DEFINITION = "optional choice multipleExchangeIndexAnnexFallback, componentSecurityIndexAnnexFallback";
	
	class Default implements EquityOptionTransactionSupplementChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityOptionTransactionSupplement equityOptionTransactionSupplement) {
			ComparisonResult result = executeDataRule(equityOptionTransactionSupplement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityOptionTransactionSupplement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityOptionTransactionSupplement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityOptionTransactionSupplement equityOptionTransactionSupplement) {
			try {
				return choice(MapperS.of(equityOptionTransactionSupplement), Arrays.asList("multipleExchangeIndexAnnexFallback", "componentSecurityIndexAnnexFallback"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityOptionTransactionSupplementChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityOptionTransactionSupplement equityOptionTransactionSupplement) {
			return Collections.emptyList();
		}
	}
}
