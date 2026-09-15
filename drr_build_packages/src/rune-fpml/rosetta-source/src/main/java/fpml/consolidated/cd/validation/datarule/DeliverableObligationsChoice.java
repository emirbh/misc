package fpml.consolidated.cd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.DeliverableObligations;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DeliverableObligationsChoice")
@ImplementedBy(DeliverableObligationsChoice.Default.class)
public interface DeliverableObligationsChoice extends Validator<DeliverableObligations> {
	
	String NAME = "DeliverableObligationsChoice";
	String DEFINITION = "optional choice fullFaithAndCreditObLiability, generalFundObligationLiability, revenueObligationLiability";
	
	class Default implements DeliverableObligationsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliverableObligations deliverableObligations) {
			ComparisonResult result = executeDataRule(deliverableObligations);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliverableObligations", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliverableObligations", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DeliverableObligations deliverableObligations) {
			try {
				return choice(MapperS.of(deliverableObligations), Arrays.asList("fullFaithAndCreditObLiability", "generalFundObligationLiability", "revenueObligationLiability"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DeliverableObligationsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliverableObligations deliverableObligations) {
			return Collections.emptyList();
		}
	}
}
