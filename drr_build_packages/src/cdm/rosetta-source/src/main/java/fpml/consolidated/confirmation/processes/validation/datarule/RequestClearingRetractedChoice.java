package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.DeClear;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.RequestClearingRetracted;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RequestClearingRetractedChoice")
@ImplementedBy(RequestClearingRetractedChoice.Default.class)
public interface RequestClearingRetractedChoice extends Validator<RequestClearingRetracted> {
	
	String NAME = "RequestClearingRetractedChoice";
	String DEFINITION = "if trade exists then tradePackage is absent and additionalEvent is absent and deClear is absent else if additionalEvent exists then trade is absent and tradePackage is absent and originatingEvent is absent and deClear is absent else if deClear exists then trade is absent and additionalEvent is absent and tradePackage is absent and originatingEvent is absent else trade is absent and additionalEvent is absent and deClear is absent and originatingEvent is absent";
	
	class Default implements RequestClearingRetractedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestClearingRetracted requestClearingRetracted) {
			ComparisonResult result = executeDataRule(requestClearingRetracted);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearingRetracted", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearingRetracted", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RequestClearingRetracted requestClearingRetracted) {
			try {
				if (exists(MapperS.of(requestClearingRetracted).<Trade>map("getTrade", _requestClearingRetracted -> _requestClearingRetracted.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearingRetracted).<TradePackage>map("getTradePackage", _requestClearingRetracted -> _requestClearingRetracted.getTradePackage())).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<AdditionalEvent>map("getAdditionalEvent", _requestClearingRetracted -> _requestClearingRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<DeClear>map("getDeClear", _requestClearingRetracted -> _requestClearingRetracted.getDeClear())));
				}
				if (exists(MapperS.of(requestClearingRetracted).<AdditionalEvent>map("getAdditionalEvent", _requestClearingRetracted -> _requestClearingRetracted.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearingRetracted).<Trade>map("getTrade", _requestClearingRetracted -> _requestClearingRetracted.getTrade())).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<TradePackage>map("getTradePackage", _requestClearingRetracted -> _requestClearingRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<OriginatingEvent>map("getOriginatingEvent", _requestClearingRetracted -> _requestClearingRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<DeClear>map("getDeClear", _requestClearingRetracted -> _requestClearingRetracted.getDeClear())));
				}
				if (exists(MapperS.of(requestClearingRetracted).<DeClear>map("getDeClear", _requestClearingRetracted -> _requestClearingRetracted.getDeClear())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearingRetracted).<Trade>map("getTrade", _requestClearingRetracted -> _requestClearingRetracted.getTrade())).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<AdditionalEvent>map("getAdditionalEvent", _requestClearingRetracted -> _requestClearingRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<TradePackage>map("getTradePackage", _requestClearingRetracted -> _requestClearingRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<OriginatingEvent>map("getOriginatingEvent", _requestClearingRetracted -> _requestClearingRetracted.getOriginatingEvent())));
				}
				return notExists(MapperS.of(requestClearingRetracted).<Trade>map("getTrade", _requestClearingRetracted -> _requestClearingRetracted.getTrade())).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<AdditionalEvent>map("getAdditionalEvent", _requestClearingRetracted -> _requestClearingRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<DeClear>map("getDeClear", _requestClearingRetracted -> _requestClearingRetracted.getDeClear()))).andNullSafe(notExists(MapperS.of(requestClearingRetracted).<OriginatingEvent>map("getOriginatingEvent", _requestClearingRetracted -> _requestClearingRetracted.getOriginatingEvent())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestClearingRetractedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestClearingRetracted requestClearingRetracted) {
			return Collections.emptyList();
		}
	}
}
