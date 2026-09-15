package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PartyTradeInformation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PartyTradeInformationChoice0")
@ImplementedBy(PartyTradeInformationChoice0.Default.class)
public interface PartyTradeInformationChoice0 extends Validator<PartyTradeInformation> {
	
	String NAME = "PartyTradeInformationChoice0";
	String DEFINITION = "optional choice largeSizeTrade, blockTradeIndicator";
	
	class Default implements PartyTradeInformationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeInformation partyTradeInformation) {
			ComparisonResult result = executeDataRule(partyTradeInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PartyTradeInformation partyTradeInformation) {
			try {
				return choice(MapperS.of(partyTradeInformation), Arrays.asList("largeSizeTrade", "blockTradeIndicator"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyTradeInformationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeInformation partyTradeInformation) {
			return Collections.emptyList();
		}
	}
}
