package fpml.consolidated.cd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.Obligations;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ObligationsChoice")
@ImplementedBy(ObligationsChoice.Default.class)
public interface ObligationsChoice extends Validator<Obligations> {
	
	String NAME = "ObligationsChoice";
	String DEFINITION = "optional choice fullFaithAndCreditObLiability, generalFundObligationLiability, revenueObligationLiability";
	
	class Default implements ObligationsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Obligations obligations) {
			ComparisonResult result = executeDataRule(obligations);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Obligations", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Obligations", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Obligations obligations) {
			try {
				return choice(MapperS.of(obligations), Arrays.asList("fullFaithAndCreditObLiability", "generalFundObligationLiability", "revenueObligationLiability"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ObligationsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Obligations obligations) {
			return Collections.emptyList();
		}
	}
}
