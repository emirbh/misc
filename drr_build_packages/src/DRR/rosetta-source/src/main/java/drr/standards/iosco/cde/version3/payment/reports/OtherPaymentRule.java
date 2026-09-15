package drr.standards.iosco.cde.version3.payment.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.TradeStateForEvent;
import drr.base.trade.payment.OtherPayment;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.standards.iosco.cde.version3.payment.functions.ExtractOtherPaymentPayer;
import drr.standards.iosco.cde.version3.payment.functions.ExtractOtherPaymentReceiver;
import drr.standards.iosco.cde.version3.payment.functions.IsOtherPayment;
import drr.standards.iso.PaymentType4Code;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OtherPaymentRule.OtherPaymentRuleDefault.class)
public abstract class OtherPaymentRule implements ReportFunction<TransactionReportInstructionBase, List<? extends OtherPayment>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractOtherPaymentPayer extractOtherPaymentPayer;
	@Inject protected ExtractOtherPaymentReceiver extractOtherPaymentReceiver;
	@Inject protected IsOtherPayment isOtherPayment;
	@Inject protected OtherPaymentAmountRule otherPaymentAmountRule;
	@Inject protected OtherPaymentCurrencyRule otherPaymentCurrencyRule;
	@Inject protected OtherPaymentDateRule otherPaymentDateRule;
	@Inject protected OtherPaymentPayerFormatRule otherPaymentPayerFormatRule;
	@Inject protected OtherPaymentReceiverFormatRule otherPaymentReceiverFormatRule;
	@Inject protected OtherPaymentTypeRule otherPaymentTypeRule;
	@Inject protected TradeStateForEvent tradeStateForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends OtherPayment> evaluate(TransactionReportInstructionBase input) {
		List<OtherPayment.OtherPaymentBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends OtherPayment> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(OtherPayment::build).collect(Collectors.toList());
			objectValidator.validate(OtherPayment.class, output);
		}
		
		return output;
	}

	protected abstract List<OtherPayment.OtherPaymentBuilder> doEvaluate(TransactionReportInstructionBase input);

	public static class OtherPaymentRuleDefault extends OtherPaymentRule {
		@Override
		protected List<OtherPayment.OtherPaymentBuilder> doEvaluate(TransactionReportInstructionBase input) {
			List<OtherPayment.OtherPaymentBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<OtherPayment.OtherPaymentBuilder> assignOutput(List<OtherPayment.OtherPaymentBuilder> output, TransactionReportInstructionBase input) {
			output = toBuilder(MapperS.of(input)
				.mapSingleToList(transactionReportInstruction -> {
					final MapperS<TradeState> thenArg0 = MapperS.of(tradeStateForEvent.evaluate(input));
					final MapperC<TransferState> thenArg1 = thenArg0
						.mapSingleToList(item -> item.<TransferState>mapC("getTransferHistory", tradeState -> tradeState.getTransferHistory()));
					final MapperC<TransferState> thenArg2 = thenArg1
						.filterItemNullSafe(item -> isOtherPayment.evaluate(item.get()));
					return thenArg2
						.mapItem(item -> {
							final String ifThenElseResult0;
							if (areEqual(item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
								ifThenElseResult0 = extractOtherPaymentPayer.evaluate(item.get(), transactionReportInstruction.get());
							} else {
								final FieldWithMetaString fieldWithMetaString0 = item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier())
									.first().get();
								ifThenElseResult0 = fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue();
							}
							PartyIdentifierFormatEnum ifThenElseResult1 = null;
							if (areEqual(item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference()).<Party>map("Type coercion", referenceWithMetaParty2 -> referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
								ifThenElseResult1 = otherPaymentPayerFormatRule.evaluate(item.get());
							}
							final String ifThenElseResult2;
							if (areEqual(item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getReceiverPartyReference()).<Party>map("Type coercion", referenceWithMetaParty3 -> referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
								ifThenElseResult2 = extractOtherPaymentReceiver.evaluate(item.get(), transactionReportInstruction.get());
							} else {
								final FieldWithMetaString fieldWithMetaString1 = item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getReceiverPartyReference()).<Party>map("Type coercion", referenceWithMetaParty4 -> referenceWithMetaParty4 == null ? null : referenceWithMetaParty4.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier())
									.first().get();
								ifThenElseResult2 = fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue();
							}
							PartyIdentifierFormatEnum ifThenElseResult3 = null;
							if (areEqual(item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getReceiverPartyReference()).<Party>map("Type coercion", referenceWithMetaParty5 -> referenceWithMetaParty5 == null ? null : referenceWithMetaParty5.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
								ifThenElseResult3 = otherPaymentReceiverFormatRule.evaluate(item.get());
							}
							return MapperS.of(OtherPayment.builder()
								.setPaymentType(MapperS.of(otherPaymentTypeRule.evaluate(item.get())).checkedMap("to-enum", e -> PaymentType4Code.valueOf(e.name()), IllegalArgumentException.class).get())
								.setAmount(otherPaymentAmountRule.evaluate(item.get()))
								.setCurrency(otherPaymentCurrencyRule.evaluate(item.get()))
								.setDate(otherPaymentDateRule.evaluate(item.get()))
								.setPayer(ifThenElseResult0)
								.setPayerFormat(ifThenElseResult1)
								.setReceiver(ifThenElseResult2)
								.setReceiverFormat(ifThenElseResult3)
								.build());
						});
				}).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
