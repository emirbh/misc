package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.FieldWithMetaNaturalPersonRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.standards.iosco.cde.version3.payment.functions.IsOtherPayment;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OtherPaymentReceiverFormatRule.OtherPaymentReceiverFormatRuleDefault.class)
public abstract class OtherPaymentReceiverFormatRule implements ReportFunction<TransferState, PartyIdentifierFormatEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsOtherPayment isOtherPayment;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierFormatEnum evaluate(TransferState input) {
		PartyIdentifierFormatEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierFormatEnum doEvaluate(TransferState input);

	public static class OtherPaymentReceiverFormatRuleDefault extends OtherPaymentReceiverFormatRule {
		@Override
		protected PartyIdentifierFormatEnum doEvaluate(TransferState input) {
			PartyIdentifierFormatEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierFormatEnum assignOutput(PartyIdentifierFormatEnum output, TransferState input) {
			final MapperS<TransferState> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isOtherPayment.evaluate(item.get()));
			final MapperS<ReferenceWithMetaParty> thenArg1 = thenArg0
				.mapSingleToItem(item -> item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getReceiverPartyReference()));
			output = thenArg1
				.mapSingleToItem(item -> {
					if (areEqual(item.<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()).<NaturalPersonRole>mapC("getPersonRole", party -> party.getPersonRole()).<FieldWithMetaNaturalPersonRoleEnum>mapC("getRole", naturalPersonRole -> naturalPersonRole.getRole()).<NaturalPersonRoleEnum>map("Type coercion", fieldWithMetaNaturalPersonRoleEnum -> fieldWithMetaNaturalPersonRoleEnum.getValue()), MapperS.of(MapperC.<NaturalPersonRoleEnum>of(MapperS.of(NaturalPersonRoleEnum.BUYER), MapperS.of(NaturalPersonRoleEnum.SELLER)).get()), CardinalityOperator.Any).getOrDefault(false)) {
						return MapperS.of(PartyIdentifierFormatEnum.NATURAL_PERSON);
					}
					if (areEqual(item.<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
						return MapperS.of(PartyIdentifierFormatEnum.LEI);
					}
					if (areEqual(item.<Party>map("Type coercion", referenceWithMetaParty2 -> referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.BIC), CardinalityOperator.Any).getOrDefault(false)) {
						return MapperS.of(PartyIdentifierFormatEnum.SWIFTBIC);
					}
					return MapperS.of(PartyIdentifierFormatEnum.OTHER);
				}).get();
			
			return output;
		}
	}
}
