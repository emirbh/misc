package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PartyTradeIdentifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PartyTradeIdentifierChoice")
@ImplementedBy(PartyTradeIdentifierChoice.Default.class)
public interface PartyTradeIdentifierChoice extends Validator<PartyTradeIdentifier> {
	
	String NAME = "PartyTradeIdentifierChoice";
	String DEFINITION = "optional choice allocationTradeId, resultingTradeId";
	
	class Default implements PartyTradeIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeIdentifier partyTradeIdentifier) {
			ComparisonResult result = executeDataRule(partyTradeIdentifier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeIdentifier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeIdentifier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PartyTradeIdentifier partyTradeIdentifier) {
			try {
				return choice(MapperS.of(partyTradeIdentifier), Arrays.asList("allocationTradeId", "resultingTradeId"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyTradeIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeIdentifier partyTradeIdentifier) {
			return Collections.emptyList();
		}
	}
}
