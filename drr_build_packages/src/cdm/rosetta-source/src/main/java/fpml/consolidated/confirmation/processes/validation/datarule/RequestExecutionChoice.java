package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.RequestExecution;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RequestExecutionChoice")
@ImplementedBy(RequestExecutionChoice.Default.class)
public interface RequestExecutionChoice extends Validator<RequestExecution> {
	
	String NAME = "RequestExecutionChoice";
	String DEFINITION = "if tradePackage exists then originatingEvent is absent and trade is absent and additionalEvent is absent and optionExercise is absent else if trade exists then tradePackage is absent and additionalEvent is absent and optionExercise is absent else if additionalEvent exists then tradePackage is absent and trade is absent and originatingEvent is absent and optionExercise is absent else if optionExercise exists then tradePackage is absent and trade is absent and additionalEvent is absent and originatingEvent is absent else False";
	
	class Default implements RequestExecutionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestExecution requestExecution) {
			ComparisonResult result = executeDataRule(requestExecution);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestExecution", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestExecution", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RequestExecution requestExecution) {
			try {
				if (exists(MapperS.of(requestExecution).<TradePackage>map("getTradePackage", _requestExecution -> _requestExecution.getTradePackage())).getOrDefault(false)) {
					return notExists(MapperS.of(requestExecution).<OriginatingEvent>map("getOriginatingEvent", _requestExecution -> _requestExecution.getOriginatingEvent())).andNullSafe(notExists(MapperS.of(requestExecution).<Trade>map("getTrade", _requestExecution -> _requestExecution.getTrade()))).andNullSafe(notExists(MapperS.of(requestExecution).<AdditionalEvent>map("getAdditionalEvent", _requestExecution -> _requestExecution.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestExecution).<OptionExercise>map("getOptionExercise", _requestExecution -> _requestExecution.getOptionExercise())));
				}
				if (exists(MapperS.of(requestExecution).<Trade>map("getTrade", _requestExecution -> _requestExecution.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(requestExecution).<TradePackage>map("getTradePackage", _requestExecution -> _requestExecution.getTradePackage())).andNullSafe(notExists(MapperS.of(requestExecution).<AdditionalEvent>map("getAdditionalEvent", _requestExecution -> _requestExecution.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestExecution).<OptionExercise>map("getOptionExercise", _requestExecution -> _requestExecution.getOptionExercise())));
				}
				if (exists(MapperS.of(requestExecution).<AdditionalEvent>map("getAdditionalEvent", _requestExecution -> _requestExecution.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(requestExecution).<TradePackage>map("getTradePackage", _requestExecution -> _requestExecution.getTradePackage())).andNullSafe(notExists(MapperS.of(requestExecution).<Trade>map("getTrade", _requestExecution -> _requestExecution.getTrade()))).andNullSafe(notExists(MapperS.of(requestExecution).<OriginatingEvent>map("getOriginatingEvent", _requestExecution -> _requestExecution.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestExecution).<OptionExercise>map("getOptionExercise", _requestExecution -> _requestExecution.getOptionExercise())));
				}
				if (exists(MapperS.of(requestExecution).<OptionExercise>map("getOptionExercise", _requestExecution -> _requestExecution.getOptionExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(requestExecution).<TradePackage>map("getTradePackage", _requestExecution -> _requestExecution.getTradePackage())).andNullSafe(notExists(MapperS.of(requestExecution).<Trade>map("getTrade", _requestExecution -> _requestExecution.getTrade()))).andNullSafe(notExists(MapperS.of(requestExecution).<AdditionalEvent>map("getAdditionalEvent", _requestExecution -> _requestExecution.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestExecution).<OriginatingEvent>map("getOriginatingEvent", _requestExecution -> _requestExecution.getOriginatingEvent())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestExecutionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestExecution requestExecution) {
			return Collections.emptyList();
		}
	}
}
