package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.TradeIdentifierChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeIdentifierChoiceChoice")
@ImplementedBy(TradeIdentifierChoiceChoice.Default.class)
public interface TradeIdentifierChoiceChoice extends Validator<TradeIdentifierChoice> {
	
	String NAME = "TradeIdentifierChoiceChoice";
	String DEFINITION = "optional choice tradeId, versionedTradeId";
	
	class Default implements TradeIdentifierChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeIdentifierChoice tradeIdentifierChoice) {
			ComparisonResult result = executeDataRule(tradeIdentifierChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeIdentifierChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeIdentifierChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeIdentifierChoice tradeIdentifierChoice) {
			try {
				return choice(MapperS.of(tradeIdentifierChoice), Arrays.asList("tradeId", "versionedTradeId"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeIdentifierChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeIdentifierChoice tradeIdentifierChoice) {
			return Collections.emptyList();
		}
	}
}
