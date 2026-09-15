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
import fpml.consolidated.confirmation.processes.RequestClearing;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RequestClearingChoice")
@ImplementedBy(RequestClearingChoice.Default.class)
public interface RequestClearingChoice extends Validator<RequestClearing> {
	
	String NAME = "RequestClearingChoice";
	String DEFINITION = "if tradePackage exists then originatingEvent is absent and trade is absent and additionalEvent is absent and deClear is absent else if trade exists then tradePackage is absent and additionalEvent is absent and deClear is absent else if additionalEvent exists then tradePackage is absent and trade is absent and originatingEvent is absent and deClear is absent else if deClear exists then tradePackage is absent and trade is absent and additionalEvent is absent and originatingEvent is absent else False";
	
	class Default implements RequestClearingChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestClearing requestClearing) {
			ComparisonResult result = executeDataRule(requestClearing);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearing", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearing", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RequestClearing requestClearing) {
			try {
				if (exists(MapperS.of(requestClearing).<TradePackage>map("getTradePackage", _requestClearing -> _requestClearing.getTradePackage())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearing).<OriginatingEvent>map("getOriginatingEvent", _requestClearing -> _requestClearing.getOriginatingEvent())).andNullSafe(notExists(MapperS.of(requestClearing).<Trade>map("getTrade", _requestClearing -> _requestClearing.getTrade()))).andNullSafe(notExists(MapperS.of(requestClearing).<AdditionalEvent>map("getAdditionalEvent", _requestClearing -> _requestClearing.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestClearing).<DeClear>map("getDeClear", _requestClearing -> _requestClearing.getDeClear())));
				}
				if (exists(MapperS.of(requestClearing).<Trade>map("getTrade", _requestClearing -> _requestClearing.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearing).<TradePackage>map("getTradePackage", _requestClearing -> _requestClearing.getTradePackage())).andNullSafe(notExists(MapperS.of(requestClearing).<AdditionalEvent>map("getAdditionalEvent", _requestClearing -> _requestClearing.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestClearing).<DeClear>map("getDeClear", _requestClearing -> _requestClearing.getDeClear())));
				}
				if (exists(MapperS.of(requestClearing).<AdditionalEvent>map("getAdditionalEvent", _requestClearing -> _requestClearing.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearing).<TradePackage>map("getTradePackage", _requestClearing -> _requestClearing.getTradePackage())).andNullSafe(notExists(MapperS.of(requestClearing).<Trade>map("getTrade", _requestClearing -> _requestClearing.getTrade()))).andNullSafe(notExists(MapperS.of(requestClearing).<OriginatingEvent>map("getOriginatingEvent", _requestClearing -> _requestClearing.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestClearing).<DeClear>map("getDeClear", _requestClearing -> _requestClearing.getDeClear())));
				}
				if (exists(MapperS.of(requestClearing).<DeClear>map("getDeClear", _requestClearing -> _requestClearing.getDeClear())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearing).<TradePackage>map("getTradePackage", _requestClearing -> _requestClearing.getTradePackage())).andNullSafe(notExists(MapperS.of(requestClearing).<Trade>map("getTrade", _requestClearing -> _requestClearing.getTrade()))).andNullSafe(notExists(MapperS.of(requestClearing).<AdditionalEvent>map("getAdditionalEvent", _requestClearing -> _requestClearing.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestClearing).<OriginatingEvent>map("getOriginatingEvent", _requestClearing -> _requestClearing.getOriginatingEvent())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestClearingChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestClearing requestClearing) {
			return Collections.emptyList();
		}
	}
}
