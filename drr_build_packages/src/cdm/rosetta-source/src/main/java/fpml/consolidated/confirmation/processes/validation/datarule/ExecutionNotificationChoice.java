package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.OptionEvent;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.OptionExpiry;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.ExecutionNotification;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ExecutionNotificationChoice")
@ImplementedBy(ExecutionNotificationChoice.Default.class)
public interface ExecutionNotificationChoice extends Validator<ExecutionNotification> {
	
	String NAME = "ExecutionNotificationChoice";
	String DEFINITION = "if tradePackage exists then originatingEvent is absent and trade is absent and amendment is absent and optionExercise is absent and optionExpiry is absent and optionEvent is absent and additionalEvent is absent else if trade exists then tradePackage is absent and amendment is absent and optionExercise is absent and optionExpiry is absent and optionEvent is absent and additionalEvent is absent else if amendment exists then tradePackage is absent and trade is absent and originatingEvent is absent and optionExercise is absent and optionExpiry is absent and optionEvent is absent and additionalEvent is absent else if optionExercise exists then tradePackage is absent and trade is absent and amendment is absent and optionExpiry is absent and optionEvent is absent and originatingEvent is absent and additionalEvent is absent else if optionExpiry exists then tradePackage is absent and trade is absent and amendment is absent and optionExercise is absent and optionEvent is absent and originatingEvent is absent and additionalEvent is absent else if optionEvent exists then tradePackage is absent and trade is absent and amendment is absent and optionExercise is absent and optionExpiry is absent and originatingEvent is absent and additionalEvent is absent else if additionalEvent exists then tradePackage is absent and trade is absent and amendment is absent and optionExercise is absent and optionExpiry is absent and optionEvent is absent and originatingEvent is absent else False";
	
	class Default implements ExecutionNotificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionNotification executionNotification) {
			ComparisonResult result = executeDataRule(executionNotification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionNotification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionNotification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExecutionNotification executionNotification) {
			try {
				if (exists(MapperS.of(executionNotification).<TradePackage>map("getTradePackage", _executionNotification -> _executionNotification.getTradePackage())).getOrDefault(false)) {
					return notExists(MapperS.of(executionNotification).<OriginatingEvent>map("getOriginatingEvent", _executionNotification -> _executionNotification.getOriginatingEvent())).andNullSafe(notExists(MapperS.of(executionNotification).<Trade>map("getTrade", _executionNotification -> _executionNotification.getTrade()))).andNullSafe(notExists(MapperS.of(executionNotification).<TradeAmendmentContent>map("getAmendment", _executionNotification -> _executionNotification.getAmendment()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExercise>map("getOptionExercise", _executionNotification -> _executionNotification.getOptionExercise()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExpiry>mapC("getOptionExpiry", _executionNotification -> _executionNotification.getOptionExpiry()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionEvent>map("getOptionEvent", _executionNotification -> _executionNotification.getOptionEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<AdditionalEvent>map("getAdditionalEvent", _executionNotification -> _executionNotification.getAdditionalEvent())));
				}
				if (exists(MapperS.of(executionNotification).<Trade>map("getTrade", _executionNotification -> _executionNotification.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(executionNotification).<TradePackage>map("getTradePackage", _executionNotification -> _executionNotification.getTradePackage())).andNullSafe(notExists(MapperS.of(executionNotification).<TradeAmendmentContent>map("getAmendment", _executionNotification -> _executionNotification.getAmendment()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExercise>map("getOptionExercise", _executionNotification -> _executionNotification.getOptionExercise()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExpiry>mapC("getOptionExpiry", _executionNotification -> _executionNotification.getOptionExpiry()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionEvent>map("getOptionEvent", _executionNotification -> _executionNotification.getOptionEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<AdditionalEvent>map("getAdditionalEvent", _executionNotification -> _executionNotification.getAdditionalEvent())));
				}
				if (exists(MapperS.of(executionNotification).<TradeAmendmentContent>map("getAmendment", _executionNotification -> _executionNotification.getAmendment())).getOrDefault(false)) {
					return notExists(MapperS.of(executionNotification).<TradePackage>map("getTradePackage", _executionNotification -> _executionNotification.getTradePackage())).andNullSafe(notExists(MapperS.of(executionNotification).<Trade>map("getTrade", _executionNotification -> _executionNotification.getTrade()))).andNullSafe(notExists(MapperS.of(executionNotification).<OriginatingEvent>map("getOriginatingEvent", _executionNotification -> _executionNotification.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExercise>map("getOptionExercise", _executionNotification -> _executionNotification.getOptionExercise()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExpiry>mapC("getOptionExpiry", _executionNotification -> _executionNotification.getOptionExpiry()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionEvent>map("getOptionEvent", _executionNotification -> _executionNotification.getOptionEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<AdditionalEvent>map("getAdditionalEvent", _executionNotification -> _executionNotification.getAdditionalEvent())));
				}
				if (exists(MapperS.of(executionNotification).<OptionExercise>map("getOptionExercise", _executionNotification -> _executionNotification.getOptionExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(executionNotification).<TradePackage>map("getTradePackage", _executionNotification -> _executionNotification.getTradePackage())).andNullSafe(notExists(MapperS.of(executionNotification).<Trade>map("getTrade", _executionNotification -> _executionNotification.getTrade()))).andNullSafe(notExists(MapperS.of(executionNotification).<TradeAmendmentContent>map("getAmendment", _executionNotification -> _executionNotification.getAmendment()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExpiry>mapC("getOptionExpiry", _executionNotification -> _executionNotification.getOptionExpiry()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionEvent>map("getOptionEvent", _executionNotification -> _executionNotification.getOptionEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<OriginatingEvent>map("getOriginatingEvent", _executionNotification -> _executionNotification.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<AdditionalEvent>map("getAdditionalEvent", _executionNotification -> _executionNotification.getAdditionalEvent())));
				}
				if (exists(MapperS.of(executionNotification).<OptionExpiry>mapC("getOptionExpiry", _executionNotification -> _executionNotification.getOptionExpiry())).getOrDefault(false)) {
					return notExists(MapperS.of(executionNotification).<TradePackage>map("getTradePackage", _executionNotification -> _executionNotification.getTradePackage())).andNullSafe(notExists(MapperS.of(executionNotification).<Trade>map("getTrade", _executionNotification -> _executionNotification.getTrade()))).andNullSafe(notExists(MapperS.of(executionNotification).<TradeAmendmentContent>map("getAmendment", _executionNotification -> _executionNotification.getAmendment()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExercise>map("getOptionExercise", _executionNotification -> _executionNotification.getOptionExercise()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionEvent>map("getOptionEvent", _executionNotification -> _executionNotification.getOptionEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<OriginatingEvent>map("getOriginatingEvent", _executionNotification -> _executionNotification.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<AdditionalEvent>map("getAdditionalEvent", _executionNotification -> _executionNotification.getAdditionalEvent())));
				}
				if (exists(MapperS.of(executionNotification).<OptionEvent>map("getOptionEvent", _executionNotification -> _executionNotification.getOptionEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(executionNotification).<TradePackage>map("getTradePackage", _executionNotification -> _executionNotification.getTradePackage())).andNullSafe(notExists(MapperS.of(executionNotification).<Trade>map("getTrade", _executionNotification -> _executionNotification.getTrade()))).andNullSafe(notExists(MapperS.of(executionNotification).<TradeAmendmentContent>map("getAmendment", _executionNotification -> _executionNotification.getAmendment()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExercise>map("getOptionExercise", _executionNotification -> _executionNotification.getOptionExercise()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExpiry>mapC("getOptionExpiry", _executionNotification -> _executionNotification.getOptionExpiry()))).andNullSafe(notExists(MapperS.of(executionNotification).<OriginatingEvent>map("getOriginatingEvent", _executionNotification -> _executionNotification.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<AdditionalEvent>map("getAdditionalEvent", _executionNotification -> _executionNotification.getAdditionalEvent())));
				}
				if (exists(MapperS.of(executionNotification).<AdditionalEvent>map("getAdditionalEvent", _executionNotification -> _executionNotification.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(executionNotification).<TradePackage>map("getTradePackage", _executionNotification -> _executionNotification.getTradePackage())).andNullSafe(notExists(MapperS.of(executionNotification).<Trade>map("getTrade", _executionNotification -> _executionNotification.getTrade()))).andNullSafe(notExists(MapperS.of(executionNotification).<TradeAmendmentContent>map("getAmendment", _executionNotification -> _executionNotification.getAmendment()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExercise>map("getOptionExercise", _executionNotification -> _executionNotification.getOptionExercise()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionExpiry>mapC("getOptionExpiry", _executionNotification -> _executionNotification.getOptionExpiry()))).andNullSafe(notExists(MapperS.of(executionNotification).<OptionEvent>map("getOptionEvent", _executionNotification -> _executionNotification.getOptionEvent()))).andNullSafe(notExists(MapperS.of(executionNotification).<OriginatingEvent>map("getOriginatingEvent", _executionNotification -> _executionNotification.getOriginatingEvent())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExecutionNotificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionNotification executionNotification) {
			return Collections.emptyList();
		}
	}
}
