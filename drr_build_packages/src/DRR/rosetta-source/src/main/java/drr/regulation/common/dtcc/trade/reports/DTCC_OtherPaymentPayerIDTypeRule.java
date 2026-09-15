package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.TradeStateForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.PartyIdentifierType;
import drr.standards.iosco.cde.version3.payment.functions.IsOtherPayment;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_OtherPaymentPayerIDTypeRule.DTCC_OtherPaymentPayerIDTypeRuleDefault.class)
public abstract class DTCC_OtherPaymentPayerIDTypeRule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsOtherPayment isOtherPayment;
	@Inject protected PartyIdentifierType partyIdentifierType;
	@Inject protected TradeStateForEvent tradeStateForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<String> evaluate(TransactionReportInstruction input) {
		List<String> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<String> doEvaluate(TransactionReportInstruction input);

	public static class DTCC_OtherPaymentPayerIDTypeRuleDefault extends DTCC_OtherPaymentPayerIDTypeRule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperC<TransferState> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> MapperS.of(tradeStateForEvent.evaluate(item.get())).<TransferState>mapC("getTransferHistory", tradeState -> tradeState.getTransferHistory()));
			final MapperC<TransferState> thenArg1 = thenArg0
				.filterItemNullSafe(item -> isOtherPayment.evaluate(item.get()));
			final MapperC<ReferenceWithMetaParty> thenArg2 = thenArg1
				.mapItem(item -> {
					if (areEqual(item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
						return item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference());
					}
					return MapperS.<ReferenceWithMetaParty>ofNull();
				});
			final MapperListOfLists<String> thenArg3 = thenArg2
				.mapItemToList(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.get();
					return MapperC.<String>of(partyIdentifierType.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
				});
			output = thenArg3
				.flattenList().getMulti();
			
			return output;
		}
	}
}
