package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractFacilityChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AbstractFacilityChoiceChoice")
@ImplementedBy(AbstractFacilityChoiceChoice.Default.class)
public interface AbstractFacilityChoiceChoice extends Validator<AbstractFacilityChoice> {
	
	String NAME = "AbstractFacilityChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AbstractFacilityChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractFacilityChoice abstractFacilityChoice) {
			ComparisonResult result = executeDataRule(abstractFacilityChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AbstractFacilityChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AbstractFacilityChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AbstractFacilityChoice abstractFacilityChoice) {
			try {
				return choice(MapperS.of(abstractFacilityChoice), Arrays.asList("fixedRateOption", "floatingRateOption", "legacyFloatingRateOption", "lcOption"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AbstractFacilityChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractFacilityChoice abstractFacilityChoice) {
			return Collections.emptyList();
		}
	}
}
