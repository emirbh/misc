package fpml.consolidated.clearing.processes.validation.datarule;

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
import fpml.consolidated.clearing.processes.RequestClearingEligibility;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RequestClearingEligibilityChoice")
@ImplementedBy(RequestClearingEligibilityChoice.Default.class)
public interface RequestClearingEligibilityChoice extends Validator<RequestClearingEligibility> {
	
	String NAME = "RequestClearingEligibilityChoice";
	String DEFINITION = "if tradePackage exists then originatingEvent is absent and trade is absent and additionalEvent is absent and deClear is absent else if trade exists then tradePackage is absent and additionalEvent is absent and deClear is absent else if additionalEvent exists then tradePackage is absent and trade is absent and originatingEvent is absent and deClear is absent else if deClear exists then tradePackage is absent and trade is absent and additionalEvent is absent and originatingEvent is absent else False";
	
	class Default implements RequestClearingEligibilityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestClearingEligibility requestClearingEligibility) {
			ComparisonResult result = executeDataRule(requestClearingEligibility);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearingEligibility", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearingEligibility", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RequestClearingEligibility requestClearingEligibility) {
			try {
				if (exists(MapperS.of(requestClearingEligibility).<TradePackage>map("getTradePackage", _requestClearingEligibility -> _requestClearingEligibility.getTradePackage())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearingEligibility).<OriginatingEvent>map("getOriginatingEvent", _requestClearingEligibility -> _requestClearingEligibility.getOriginatingEvent())).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<Trade>map("getTrade", _requestClearingEligibility -> _requestClearingEligibility.getTrade()))).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<AdditionalEvent>map("getAdditionalEvent", _requestClearingEligibility -> _requestClearingEligibility.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<DeClear>map("getDeClear", _requestClearingEligibility -> _requestClearingEligibility.getDeClear())));
				}
				if (exists(MapperS.of(requestClearingEligibility).<Trade>map("getTrade", _requestClearingEligibility -> _requestClearingEligibility.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearingEligibility).<TradePackage>map("getTradePackage", _requestClearingEligibility -> _requestClearingEligibility.getTradePackage())).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<AdditionalEvent>map("getAdditionalEvent", _requestClearingEligibility -> _requestClearingEligibility.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<DeClear>map("getDeClear", _requestClearingEligibility -> _requestClearingEligibility.getDeClear())));
				}
				if (exists(MapperS.of(requestClearingEligibility).<AdditionalEvent>map("getAdditionalEvent", _requestClearingEligibility -> _requestClearingEligibility.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearingEligibility).<TradePackage>map("getTradePackage", _requestClearingEligibility -> _requestClearingEligibility.getTradePackage())).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<Trade>map("getTrade", _requestClearingEligibility -> _requestClearingEligibility.getTrade()))).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<OriginatingEvent>map("getOriginatingEvent", _requestClearingEligibility -> _requestClearingEligibility.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<DeClear>map("getDeClear", _requestClearingEligibility -> _requestClearingEligibility.getDeClear())));
				}
				if (exists(MapperS.of(requestClearingEligibility).<DeClear>map("getDeClear", _requestClearingEligibility -> _requestClearingEligibility.getDeClear())).getOrDefault(false)) {
					return notExists(MapperS.of(requestClearingEligibility).<TradePackage>map("getTradePackage", _requestClearingEligibility -> _requestClearingEligibility.getTradePackage())).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<Trade>map("getTrade", _requestClearingEligibility -> _requestClearingEligibility.getTrade()))).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<AdditionalEvent>map("getAdditionalEvent", _requestClearingEligibility -> _requestClearingEligibility.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestClearingEligibility).<OriginatingEvent>map("getOriginatingEvent", _requestClearingEligibility -> _requestClearingEligibility.getOriginatingEvent())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestClearingEligibilityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestClearingEligibility requestClearingEligibility) {
			return Collections.emptyList();
		}
	}
}
