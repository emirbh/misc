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
import fpml.consolidated.clearing.processes.ClearingEligibility;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ClearingEligibilityChoice")
@ImplementedBy(ClearingEligibilityChoice.Default.class)
public interface ClearingEligibilityChoice extends Validator<ClearingEligibility> {
	
	String NAME = "ClearingEligibilityChoice";
	String DEFINITION = "if trade exists then tradePackage is absent and additionalEvent is absent and deClear is absent and partyTradeIdentifier is absent else if additionalEvent exists then trade is absent and tradePackage is absent and originatingEvent is absent and deClear is absent and partyTradeIdentifier is absent else if deClear exists then trade is absent and additionalEvent is absent and tradePackage is absent and originatingEvent is absent and partyTradeIdentifier is absent else if partyTradeIdentifier exists then trade is absent and additionalEvent is absent and deClear is absent and tradePackage is absent and originatingEvent is absent else trade is absent and additionalEvent is absent and deClear is absent and partyTradeIdentifier is absent and originatingEvent is absent";
	
	class Default implements ClearingEligibilityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingEligibility clearingEligibility) {
			ComparisonResult result = executeDataRule(clearingEligibility);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingEligibility", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingEligibility", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ClearingEligibility clearingEligibility) {
			try {
				if (exists(MapperS.of(clearingEligibility).<Trade>map("getTrade", _clearingEligibility -> _clearingEligibility.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingEligibility).<TradePackage>map("getTradePackage", _clearingEligibility -> _clearingEligibility.getTradePackage())).andNullSafe(notExists(MapperS.of(clearingEligibility).<AdditionalEvent>map("getAdditionalEvent", _clearingEligibility -> _clearingEligibility.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<DeClear>map("getDeClear", _clearingEligibility -> _clearingEligibility.getDeClear()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<PartyTradeIdentifier>map("getPartyTradeIdentifier", _clearingEligibility -> _clearingEligibility.getPartyTradeIdentifier())));
				}
				if (exists(MapperS.of(clearingEligibility).<AdditionalEvent>map("getAdditionalEvent", _clearingEligibility -> _clearingEligibility.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingEligibility).<Trade>map("getTrade", _clearingEligibility -> _clearingEligibility.getTrade())).andNullSafe(notExists(MapperS.of(clearingEligibility).<TradePackage>map("getTradePackage", _clearingEligibility -> _clearingEligibility.getTradePackage()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<OriginatingEvent>map("getOriginatingEvent", _clearingEligibility -> _clearingEligibility.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<DeClear>map("getDeClear", _clearingEligibility -> _clearingEligibility.getDeClear()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<PartyTradeIdentifier>map("getPartyTradeIdentifier", _clearingEligibility -> _clearingEligibility.getPartyTradeIdentifier())));
				}
				if (exists(MapperS.of(clearingEligibility).<DeClear>map("getDeClear", _clearingEligibility -> _clearingEligibility.getDeClear())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingEligibility).<Trade>map("getTrade", _clearingEligibility -> _clearingEligibility.getTrade())).andNullSafe(notExists(MapperS.of(clearingEligibility).<AdditionalEvent>map("getAdditionalEvent", _clearingEligibility -> _clearingEligibility.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<TradePackage>map("getTradePackage", _clearingEligibility -> _clearingEligibility.getTradePackage()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<OriginatingEvent>map("getOriginatingEvent", _clearingEligibility -> _clearingEligibility.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<PartyTradeIdentifier>map("getPartyTradeIdentifier", _clearingEligibility -> _clearingEligibility.getPartyTradeIdentifier())));
				}
				if (exists(MapperS.of(clearingEligibility).<PartyTradeIdentifier>map("getPartyTradeIdentifier", _clearingEligibility -> _clearingEligibility.getPartyTradeIdentifier())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingEligibility).<Trade>map("getTrade", _clearingEligibility -> _clearingEligibility.getTrade())).andNullSafe(notExists(MapperS.of(clearingEligibility).<AdditionalEvent>map("getAdditionalEvent", _clearingEligibility -> _clearingEligibility.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<DeClear>map("getDeClear", _clearingEligibility -> _clearingEligibility.getDeClear()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<TradePackage>map("getTradePackage", _clearingEligibility -> _clearingEligibility.getTradePackage()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<OriginatingEvent>map("getOriginatingEvent", _clearingEligibility -> _clearingEligibility.getOriginatingEvent())));
				}
				return notExists(MapperS.of(clearingEligibility).<Trade>map("getTrade", _clearingEligibility -> _clearingEligibility.getTrade())).andNullSafe(notExists(MapperS.of(clearingEligibility).<AdditionalEvent>map("getAdditionalEvent", _clearingEligibility -> _clearingEligibility.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<DeClear>map("getDeClear", _clearingEligibility -> _clearingEligibility.getDeClear()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<PartyTradeIdentifier>map("getPartyTradeIdentifier", _clearingEligibility -> _clearingEligibility.getPartyTradeIdentifier()))).andNullSafe(notExists(MapperS.of(clearingEligibility).<OriginatingEvent>map("getOriginatingEvent", _clearingEligibility -> _clearingEligibility.getOriginatingEvent())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ClearingEligibilityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingEligibility clearingEligibility) {
			return Collections.emptyList();
		}
	}
}
