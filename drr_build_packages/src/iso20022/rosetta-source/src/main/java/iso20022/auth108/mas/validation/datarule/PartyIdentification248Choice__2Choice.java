package iso20022.auth108.mas.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.mas.PartyIdentification248Choice__2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PartyIdentification248Choice__2Choice")
@ImplementedBy(PartyIdentification248Choice__2Choice.Default.class)
public interface PartyIdentification248Choice__2Choice extends Validator<PartyIdentification248Choice__2> {
	
	String NAME = "PartyIdentification248Choice__2Choice";
	String DEFINITION = "one-of";
	
	class Default implements PartyIdentification248Choice__2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice__2 partyIdentification248Choice__2) {
			ComparisonResult result = executeDataRule(partyIdentification248Choice__2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyIdentification248Choice__2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyIdentification248Choice__2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PartyIdentification248Choice__2 partyIdentification248Choice__2) {
			try {
				return choice(MapperS.of(partyIdentification248Choice__2), Arrays.asList("lgl", "ntrl"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyIdentification248Choice__2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice__2 partyIdentification248Choice__2) {
			return Collections.emptyList();
		}
	}
}
