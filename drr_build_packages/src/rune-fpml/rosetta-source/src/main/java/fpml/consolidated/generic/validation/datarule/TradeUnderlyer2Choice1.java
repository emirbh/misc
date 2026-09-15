package fpml.consolidated.generic.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeUnderlyer2Choice1")
@ImplementedBy(TradeUnderlyer2Choice1.Default.class)
public interface TradeUnderlyer2Choice1 extends Validator<TradeUnderlyer2> {
	
	String NAME = "TradeUnderlyer2Choice1";
	String DEFINITION = "if payerPartyReference exists then buyerPartyReference is absent and buyerAccountReference is absent and sellerPartyReference is absent and sellerAccountReference is absent else if buyerPartyReference exists then payerPartyReference is absent and payerAccountReference is absent and receiverPartyReference is absent and receiverAccountReference is absent else payerPartyReference is absent and buyerPartyReference is absent and payerAccountReference is absent and receiverPartyReference is absent and receiverAccountReference is absent and buyerAccountReference is absent and sellerPartyReference is absent and sellerAccountReference is absent";
	
	class Default implements TradeUnderlyer2Choice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeUnderlyer2 tradeUnderlyer2) {
			ComparisonResult result = executeDataRule(tradeUnderlyer2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeUnderlyer2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeUnderlyer2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeUnderlyer2 tradeUnderlyer2) {
			try {
				if (exists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getPayerPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getPayerPartyReference())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getBuyerPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getBuyerPartyReference())).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<AccountReference>map("getBuyerAccountReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getBuyerAccountReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getSellerPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getSellerPartyReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<AccountReference>map("getSellerAccountReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getSellerAccountReference())));
				}
				if (exists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getBuyerPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getBuyerPartyReference())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getPayerPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getPayerPartyReference())).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<AccountReference>map("getPayerAccountReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getPayerAccountReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getReceiverPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getReceiverPartyReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<AccountReference>map("getReceiverAccountReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getReceiverAccountReference())));
				}
				return notExists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getPayerPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getPayerPartyReference())).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getBuyerPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getBuyerPartyReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<AccountReference>map("getPayerAccountReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getPayerAccountReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getReceiverPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getReceiverPartyReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<AccountReference>map("getReceiverAccountReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getReceiverAccountReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<AccountReference>map("getBuyerAccountReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getBuyerAccountReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<PartyReference>map("getSellerPartyReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getSellerPartyReference()))).andNullSafe(notExists(MapperS.of(tradeUnderlyer2).<AccountReference>map("getSellerAccountReference", _tradeUnderlyer2 -> _tradeUnderlyer2.getSellerAccountReference())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeUnderlyer2Choice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeUnderlyer2 tradeUnderlyer2) {
			return Collections.emptyList();
		}
	}
}
