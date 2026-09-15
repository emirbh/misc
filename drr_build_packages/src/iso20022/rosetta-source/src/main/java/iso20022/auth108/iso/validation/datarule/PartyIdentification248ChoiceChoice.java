package iso20022.auth108.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.PartyIdentification248Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PartyIdentification248ChoiceChoice")
@ImplementedBy(PartyIdentification248ChoiceChoice.Default.class)
public interface PartyIdentification248ChoiceChoice extends Validator<PartyIdentification248Choice> {
	
	String NAME = "PartyIdentification248ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements PartyIdentification248ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice partyIdentification248Choice) {
			ComparisonResult result = executeDataRule(partyIdentification248Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyIdentification248Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyIdentification248Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PartyIdentification248Choice partyIdentification248Choice) {
			try {
				return choice(MapperS.of(partyIdentification248Choice), Arrays.asList("lgl", "ntrl"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyIdentification248ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice partyIdentification248Choice) {
			return Collections.emptyList();
		}
	}
}
