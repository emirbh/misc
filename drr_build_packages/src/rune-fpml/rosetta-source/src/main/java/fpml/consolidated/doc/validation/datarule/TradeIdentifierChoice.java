package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeIdentifierChoice")
@ImplementedBy(TradeIdentifierChoice.Default.class)
public interface TradeIdentifierChoice extends Validator<TradeIdentifier> {
	
	String NAME = "TradeIdentifierChoice";
	String DEFINITION = "if issuer exists or tradeId exists then issuer exists and tradeId exists and partyReference is absent and accountReference is absent and tradeIdentifierChoice is absent else if partyReference exists then issuer is absent and tradeId is absent else issuer is absent and tradeId is absent and partyReference is absent and accountReference is absent and tradeIdentifierChoice is absent";
	
	class Default implements TradeIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeIdentifier tradeIdentifier) {
			ComparisonResult result = executeDataRule(tradeIdentifier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeIdentifier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeIdentifier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeIdentifier tradeIdentifier) {
			try {
				if (exists(MapperS.of(tradeIdentifier).<IssuerId>map("getIssuer", _tradeIdentifier -> _tradeIdentifier.getIssuer())).orNullSafe(exists(MapperS.of(tradeIdentifier).<TradeId>map("getTradeId", _tradeIdentifier -> _tradeIdentifier.getTradeId()))).getOrDefault(false)) {
					return exists(MapperS.of(tradeIdentifier).<IssuerId>map("getIssuer", _tradeIdentifier -> _tradeIdentifier.getIssuer())).andNullSafe(exists(MapperS.of(tradeIdentifier).<TradeId>map("getTradeId", _tradeIdentifier -> _tradeIdentifier.getTradeId()))).andNullSafe(notExists(MapperS.of(tradeIdentifier).<PartyReference>map("getPartyReference", _tradeIdentifier -> _tradeIdentifier.getPartyReference()))).andNullSafe(notExists(MapperS.of(tradeIdentifier).<AccountReference>map("getAccountReference", _tradeIdentifier -> _tradeIdentifier.getAccountReference()))).andNullSafe(notExists(MapperS.of(tradeIdentifier).<fpml.consolidated.doc.TradeIdentifierChoice>mapC("getTradeIdentifierChoice", _tradeIdentifier -> _tradeIdentifier.getTradeIdentifierChoice())));
				}
				if (exists(MapperS.of(tradeIdentifier).<PartyReference>map("getPartyReference", _tradeIdentifier -> _tradeIdentifier.getPartyReference())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeIdentifier).<IssuerId>map("getIssuer", _tradeIdentifier -> _tradeIdentifier.getIssuer())).andNullSafe(notExists(MapperS.of(tradeIdentifier).<TradeId>map("getTradeId", _tradeIdentifier -> _tradeIdentifier.getTradeId())));
				}
				return notExists(MapperS.of(tradeIdentifier).<IssuerId>map("getIssuer", _tradeIdentifier -> _tradeIdentifier.getIssuer())).andNullSafe(notExists(MapperS.of(tradeIdentifier).<TradeId>map("getTradeId", _tradeIdentifier -> _tradeIdentifier.getTradeId()))).andNullSafe(notExists(MapperS.of(tradeIdentifier).<PartyReference>map("getPartyReference", _tradeIdentifier -> _tradeIdentifier.getPartyReference()))).andNullSafe(notExists(MapperS.of(tradeIdentifier).<AccountReference>map("getAccountReference", _tradeIdentifier -> _tradeIdentifier.getAccountReference()))).andNullSafe(notExists(MapperS.of(tradeIdentifier).<fpml.consolidated.doc.TradeIdentifierChoice>mapC("getTradeIdentifierChoice", _tradeIdentifier -> _tradeIdentifier.getTradeIdentifierChoice())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeIdentifier tradeIdentifier) {
			return Collections.emptyList();
		}
	}
}
