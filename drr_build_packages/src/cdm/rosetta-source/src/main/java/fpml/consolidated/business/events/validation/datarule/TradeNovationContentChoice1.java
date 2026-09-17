package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeNovationContent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeNovationContentChoice1")
@ImplementedBy(TradeNovationContentChoice1.Default.class)
public interface TradeNovationContentChoice1 extends Validator<TradeNovationContent> {
	
	String NAME = "TradeNovationContentChoice1";
	String DEFINITION = "optional choice novatedAmount, novatedNumberOfOptions, novatedNumberOfUnits, novationAmount";
	
	class Default implements TradeNovationContentChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNovationContent tradeNovationContent) {
			ComparisonResult result = executeDataRule(tradeNovationContent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNovationContent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNovationContent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeNovationContent tradeNovationContent) {
			try {
				return choice(MapperS.of(tradeNovationContent), Arrays.asList("novatedAmount", "novatedNumberOfOptions", "novatedNumberOfUnits", "novationAmount"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeNovationContentChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNovationContent tradeNovationContent) {
			return Collections.emptyList();
		}
	}
}
