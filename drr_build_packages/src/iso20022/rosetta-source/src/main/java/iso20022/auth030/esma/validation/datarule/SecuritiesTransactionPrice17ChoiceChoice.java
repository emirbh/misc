package iso20022.auth030.esma.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("SecuritiesTransactionPrice17ChoiceChoice")
@ImplementedBy(SecuritiesTransactionPrice17ChoiceChoice.Default.class)
public interface SecuritiesTransactionPrice17ChoiceChoice extends Validator<SecuritiesTransactionPrice17Choice> {
	
	String NAME = "SecuritiesTransactionPrice17ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements SecuritiesTransactionPrice17ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuritiesTransactionPrice17Choice securitiesTransactionPrice17Choice) {
			ComparisonResult result = executeDataRule(securitiesTransactionPrice17Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SecuritiesTransactionPrice17Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecuritiesTransactionPrice17Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SecuritiesTransactionPrice17Choice securitiesTransactionPrice17Choice) {
			try {
				return choice(MapperS.of(securitiesTransactionPrice17Choice), Arrays.asList("mntryVal", "unit", "pctg", "yld", "dcml", "pdgPric", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecuritiesTransactionPrice17ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuritiesTransactionPrice17Choice securitiesTransactionPrice17Choice) {
			return Collections.emptyList();
		}
	}
}
