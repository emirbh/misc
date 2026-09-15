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
import fpml.consolidated.confirmation.processes.RequestExecutionRetracted;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RequestExecutionRetractedChoice")
@ImplementedBy(RequestExecutionRetractedChoice.Default.class)
public interface RequestExecutionRetractedChoice extends Validator<RequestExecutionRetracted> {
	
	String NAME = "RequestExecutionRetractedChoice";
	String DEFINITION = "if trade exists then tradePackage is absent and additionalEvent is absent and optionExercise is absent else if additionalEvent exists then trade is absent and tradePackage is absent and originatingEvent is absent and optionExercise is absent else if optionExercise exists then trade is absent and additionalEvent is absent and tradePackage is absent and originatingEvent is absent else trade is absent and additionalEvent is absent and optionExercise is absent and originatingEvent is absent";
	
	class Default implements RequestExecutionRetractedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestExecutionRetracted requestExecutionRetracted) {
			ComparisonResult result = executeDataRule(requestExecutionRetracted);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestExecutionRetracted", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestExecutionRetracted", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RequestExecutionRetracted requestExecutionRetracted) {
			try {
				if (exists(MapperS.of(requestExecutionRetracted).<Trade>map("getTrade", _requestExecutionRetracted -> _requestExecutionRetracted.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(requestExecutionRetracted).<TradePackage>map("getTradePackage", _requestExecutionRetracted -> _requestExecutionRetracted.getTradePackage())).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<AdditionalEvent>map("getAdditionalEvent", _requestExecutionRetracted -> _requestExecutionRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<OptionExercise>map("getOptionExercise", _requestExecutionRetracted -> _requestExecutionRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(requestExecutionRetracted).<AdditionalEvent>map("getAdditionalEvent", _requestExecutionRetracted -> _requestExecutionRetracted.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(requestExecutionRetracted).<Trade>map("getTrade", _requestExecutionRetracted -> _requestExecutionRetracted.getTrade())).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<TradePackage>map("getTradePackage", _requestExecutionRetracted -> _requestExecutionRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<OriginatingEvent>map("getOriginatingEvent", _requestExecutionRetracted -> _requestExecutionRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<OptionExercise>map("getOptionExercise", _requestExecutionRetracted -> _requestExecutionRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(requestExecutionRetracted).<OptionExercise>map("getOptionExercise", _requestExecutionRetracted -> _requestExecutionRetracted.getOptionExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(requestExecutionRetracted).<Trade>map("getTrade", _requestExecutionRetracted -> _requestExecutionRetracted.getTrade())).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<AdditionalEvent>map("getAdditionalEvent", _requestExecutionRetracted -> _requestExecutionRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<TradePackage>map("getTradePackage", _requestExecutionRetracted -> _requestExecutionRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<OriginatingEvent>map("getOriginatingEvent", _requestExecutionRetracted -> _requestExecutionRetracted.getOriginatingEvent())));
				}
				return notExists(MapperS.of(requestExecutionRetracted).<Trade>map("getTrade", _requestExecutionRetracted -> _requestExecutionRetracted.getTrade())).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<AdditionalEvent>map("getAdditionalEvent", _requestExecutionRetracted -> _requestExecutionRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<OptionExercise>map("getOptionExercise", _requestExecutionRetracted -> _requestExecutionRetracted.getOptionExercise()))).andNullSafe(notExists(MapperS.of(requestExecutionRetracted).<OriginatingEvent>map("getOriginatingEvent", _requestExecutionRetracted -> _requestExecutionRetracted.getOriginatingEvent())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestExecutionRetractedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestExecutionRetracted requestExecutionRetracted) {
			return Collections.emptyList();
		}
	}
}
