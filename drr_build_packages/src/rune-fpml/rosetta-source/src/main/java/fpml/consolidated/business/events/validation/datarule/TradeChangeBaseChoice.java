package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeChangeBase;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeChangeBaseChoice")
@ImplementedBy(TradeChangeBaseChoice.Default.class)
public interface TradeChangeBaseChoice extends Validator<TradeChangeBase> {
	
	String NAME = "TradeChangeBaseChoice";
	String DEFINITION = "optional choice tradeIdentifier, originalTrade";
	
	class Default implements TradeChangeBaseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeBase tradeChangeBase) {
			ComparisonResult result = executeDataRule(tradeChangeBase);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeChangeBase", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeChangeBase", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeChangeBase tradeChangeBase) {
			try {
				return choice(MapperS.of(tradeChangeBase), Arrays.asList("tradeIdentifier", "originalTrade"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeChangeBaseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeBase tradeChangeBase) {
			return Collections.emptyList();
		}
	}
}
