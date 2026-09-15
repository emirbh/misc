package drr.standards.iosco.cde.version1.party.reports;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaNaturalPersonRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.base.util.party.functions.PartyLei;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2IdentifierTypeRule.Counterparty2IdentifierTypeRuleDefault.class)
public abstract class Counterparty2IdentifierTypeRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyLei partyLei;
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstructionBase input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstructionBase input);

	public static class Counterparty2IdentifierTypeRuleDefault extends Counterparty2IdentifierTypeRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstructionBase input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportInstruction -> {
					final MapperC<ReferenceWithMetaParty> thenArg0 = MapperS.of(input)
						.mapSingleToList(item -> {
							if (exists(MapperS.of(tradeForEvent.evaluate(reportInstruction.get())).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference())).getOrDefault(false)) {
								return MapperS.of(tradeForEvent.evaluate(reportInstruction.get())).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference());
							}
							if (exists(MapperS.of(positionForEvent.evaluate(reportInstruction.get())).<TradableProduct>map("getPositionBase", counterpartyPosition -> counterpartyPosition.getPositionBase()).<Counterparty>mapC("getCounterparty", tradableProduct -> tradableProduct.getCounterparty()).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference())).getOrDefault(false)) {
								return MapperS.of(positionForEvent.evaluate(reportInstruction.get())).<TradableProduct>map("getPositionBase", counterpartyPosition -> counterpartyPosition.getPositionBase()).<Counterparty>mapC("getCounterparty", tradableProduct -> tradableProduct.getCounterparty()).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference());
							}
							return MapperC.<ReferenceWithMetaParty>ofNull();
						});
					final MapperC<ReferenceWithMetaParty> thenArg1 = thenArg0
						.filterItemNullSafe(item -> areEqual(item.<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstructionBase -> transactionReportInstructionBase.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
					final MapperS<ReferenceWithMetaParty> thenArg2 = MapperS.of(thenArg1.get());
					return thenArg2
						.mapSingleToItem(item -> {
							if (areEqual(item.<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()).<NaturalPersonRole>mapC("getPersonRole", party -> party.getPersonRole()).<FieldWithMetaNaturalPersonRoleEnum>mapC("getRole", naturalPersonRole -> naturalPersonRole.getRole()).<NaturalPersonRoleEnum>map("Type coercion", fieldWithMetaNaturalPersonRoleEnum -> fieldWithMetaNaturalPersonRoleEnum.getValue()), MapperS.of(NaturalPersonRoleEnum.BUYER), CardinalityOperator.Any).orNullSafe(areEqual(item.<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()).<NaturalPersonRole>mapC("getPersonRole", party -> party.getPersonRole()).<FieldWithMetaNaturalPersonRoleEnum>mapC("getRole", naturalPersonRole -> naturalPersonRole.getRole()).<NaturalPersonRoleEnum>map("Type coercion", fieldWithMetaNaturalPersonRoleEnum -> fieldWithMetaNaturalPersonRoleEnum.getValue()), MapperS.of(NaturalPersonRoleEnum.SELLER), CardinalityOperator.Any)).orNullSafe(notEqual(item.<Party>map("Type coercion", referenceWithMetaParty2 -> referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.All)).getOrDefault(false)) {
								return MapperS.of(false);
							}
							if (exists(MapperS.of(partyLei.evaluate(item.<Party>map("Type coercion", referenceWithMetaParty3 -> referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti()))).getOrDefault(false)) {
								return MapperS.of(true);
							}
							return MapperS.<Boolean>ofNull();
						});
				}).get();
			
			return output;
		}
	}
}
