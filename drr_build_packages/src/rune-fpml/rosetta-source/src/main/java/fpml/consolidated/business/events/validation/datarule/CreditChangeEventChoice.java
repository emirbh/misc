package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CreditChangeEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CreditChangeEventChoice")
@ImplementedBy(CreditChangeEventChoice.Default.class)
public interface CreditChangeEventChoice extends Validator<CreditChangeEvent> {
	
	String NAME = "CreditChangeEventChoice";
	String DEFINITION = "optional choice indexReferenceInformation, excludedReferenceEntity";
	
	class Default implements CreditChangeEventChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditChangeEvent creditChangeEvent) {
			ComparisonResult result = executeDataRule(creditChangeEvent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditChangeEvent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditChangeEvent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditChangeEvent creditChangeEvent) {
			try {
				return choice(MapperS.of(creditChangeEvent), Arrays.asList("indexReferenceInformation", "excludedReferenceEntity"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditChangeEventChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditChangeEvent creditChangeEvent) {
			return Collections.emptyList();
		}
	}
}
