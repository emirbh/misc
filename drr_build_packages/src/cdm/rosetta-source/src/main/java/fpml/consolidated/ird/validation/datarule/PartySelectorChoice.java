package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.PartySelector;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PartySelectorChoice")
@ImplementedBy(PartySelectorChoice.Default.class)
public interface PartySelectorChoice extends Validator<PartySelector> {
	
	String NAME = "PartySelectorChoice";
	String DEFINITION = "one-of";
	
	class Default implements PartySelectorChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartySelector partySelector) {
			ComparisonResult result = executeDataRule(partySelector);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartySelector", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartySelector", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PartySelector partySelector) {
			try {
				return choice(MapperS.of(partySelector), Arrays.asList("partyReference", "partyDetermination"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartySelectorChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartySelector partySelector) {
			return Collections.emptyList();
		}
	}
}
