package fpml.consolidated.cd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.CashSettlementTerms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CashSettlementTermsChoice")
@ImplementedBy(CashSettlementTermsChoice.Default.class)
public interface CashSettlementTermsChoice extends Validator<CashSettlementTerms> {
	
	String NAME = "CashSettlementTermsChoice";
	String DEFINITION = "optional choice cashSettlementAmount, recoveryFactor";
	
	class Default implements CashSettlementTermsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlementTerms cashSettlementTerms) {
			ComparisonResult result = executeDataRule(cashSettlementTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlementTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlementTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CashSettlementTerms cashSettlementTerms) {
			try {
				return choice(MapperS.of(cashSettlementTerms), Arrays.asList("cashSettlementAmount", "recoveryFactor"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CashSettlementTermsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlementTerms cashSettlementTerms) {
			return Collections.emptyList();
		}
	}
}
