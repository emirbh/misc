package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradingEventSummary;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradingEventSummaryChoice")
@ImplementedBy(TradingEventSummaryChoice.Default.class)
public interface TradingEventSummaryChoice extends Validator<TradingEventSummary> {
	
	String NAME = "TradingEventSummaryChoice";
	String DEFINITION = "optional choice changeInNotional, changeInNumberOfOptions, changeInQuantity";
	
	class Default implements TradingEventSummaryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradingEventSummary tradingEventSummary) {
			ComparisonResult result = executeDataRule(tradingEventSummary);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingEventSummary", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingEventSummary", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradingEventSummary tradingEventSummary) {
			try {
				return choice(MapperS.of(tradingEventSummary), Arrays.asList("changeInNotional", "changeInNumberOfOptions", "changeInQuantity"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradingEventSummaryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradingEventSummary tradingEventSummary) {
			return Collections.emptyList();
		}
	}
}
