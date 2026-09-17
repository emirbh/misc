package fpml.consolidated.valuation.fpmlreporting.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.valuation.fpmlreporting.TradeValuationItem;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeValuationItemChoice")
@ImplementedBy(TradeValuationItemChoice.Default.class)
public interface TradeValuationItemChoice extends Validator<TradeValuationItem> {
	
	String NAME = "TradeValuationItemChoice";
	String DEFINITION = "if partyTradeIdentifier exists then trade is absent else partyTradeIdentifier is absent and relatedParty is absent";
	
	class Default implements TradeValuationItemChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeValuationItem tradeValuationItem) {
			ComparisonResult result = executeDataRule(tradeValuationItem);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeValuationItem", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeValuationItem", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeValuationItem tradeValuationItem) {
			try {
				if (exists(MapperS.of(tradeValuationItem).<PartyTradeIdentifier>mapC("getPartyTradeIdentifier", _tradeValuationItem -> _tradeValuationItem.getPartyTradeIdentifier())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeValuationItem).<Trade>map("getTrade", _tradeValuationItem -> _tradeValuationItem.getTrade()));
				}
				return notExists(MapperS.of(tradeValuationItem).<PartyTradeIdentifier>mapC("getPartyTradeIdentifier", _tradeValuationItem -> _tradeValuationItem.getPartyTradeIdentifier())).andNullSafe(notExists(MapperS.of(tradeValuationItem).<RelatedParty>mapC("getRelatedParty", _tradeValuationItem -> _tradeValuationItem.getRelatedParty())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeValuationItemChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeValuationItem tradeValuationItem) {
			return Collections.emptyList();
		}
	}
}
