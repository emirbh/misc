package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeChangeContent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeChangeContentChoice")
@ImplementedBy(TradeChangeContentChoice.Default.class)
public interface TradeChangeContentChoice extends Validator<TradeChangeContent> {
	
	String NAME = "TradeChangeContentChoice";
	String DEFINITION = "optional choice oldTradeIdentifier, oldTrade";
	
	class Default implements TradeChangeContentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeContent tradeChangeContent) {
			ComparisonResult result = executeDataRule(tradeChangeContent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeChangeContent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeChangeContent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeChangeContent tradeChangeContent) {
			try {
				return choice(MapperS.of(tradeChangeContent), Arrays.asList("oldTradeIdentifier", "oldTrade"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeChangeContentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeContent tradeChangeContent) {
			return Collections.emptyList();
		}
	}
}
