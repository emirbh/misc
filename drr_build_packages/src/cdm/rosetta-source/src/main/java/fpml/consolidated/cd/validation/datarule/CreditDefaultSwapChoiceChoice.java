package fpml.consolidated.cd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.CreditDefaultSwapChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CreditDefaultSwapChoiceChoice")
@ImplementedBy(CreditDefaultSwapChoiceChoice.Default.class)
public interface CreditDefaultSwapChoiceChoice extends Validator<CreditDefaultSwapChoice> {
	
	String NAME = "CreditDefaultSwapChoiceChoice";
	String DEFINITION = "optional choice cashSettlementTerms, physicalSettlementTerms";
	
	class Default implements CreditDefaultSwapChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwapChoice creditDefaultSwapChoice) {
			ComparisonResult result = executeDataRule(creditDefaultSwapChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditDefaultSwapChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditDefaultSwapChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditDefaultSwapChoice creditDefaultSwapChoice) {
			try {
				return choice(MapperS.of(creditDefaultSwapChoice), Arrays.asList("cashSettlementTerms", "physicalSettlementTerms"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditDefaultSwapChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwapChoice creditDefaultSwapChoice) {
			return Collections.emptyList();
		}
	}
}
