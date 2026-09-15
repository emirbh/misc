package iso20022.auth108.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.FinancialPartyClassification2Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FinancialPartyClassification2ChoiceChoice")
@ImplementedBy(FinancialPartyClassification2ChoiceChoice.Default.class)
public interface FinancialPartyClassification2ChoiceChoice extends Validator<FinancialPartyClassification2Choice> {
	
	String NAME = "FinancialPartyClassification2ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements FinancialPartyClassification2ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinancialPartyClassification2Choice financialPartyClassification2Choice) {
			ComparisonResult result = executeDataRule(financialPartyClassification2Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FinancialPartyClassification2Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FinancialPartyClassification2Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FinancialPartyClassification2Choice financialPartyClassification2Choice) {
			try {
				return choice(MapperS.of(financialPartyClassification2Choice), Arrays.asList("cd", "prtry"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FinancialPartyClassification2ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinancialPartyClassification2Choice financialPartyClassification2Choice) {
			return Collections.emptyList();
		}
	}
}
