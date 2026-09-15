package drr.regulation.csa.rewrite.trade.reports;

import cdm.base.staticdata.party.NaturalPerson;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PersonIdentifier;
import cdm.base.staticdata.party.PersonIdentifierTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaPersonIdentifier;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.Counterparty2IdentifierEnum;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2IdentifierSourceRule.Counterparty2IdentifierSourceRuleDefault.class)
public abstract class Counterparty2IdentifierSourceRule implements ReportFunction<TransactionReportInstruction, Counterparty2IdentifierEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.party.reports.Counterparty2IdentifierSourceRule counterparty2IdentifierSourceRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Counterparty2IdentifierEnum evaluate(TransactionReportInstruction input) {
		Counterparty2IdentifierEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract Counterparty2IdentifierEnum doEvaluate(TransactionReportInstruction input);

	public static class Counterparty2IdentifierSourceRuleDefault extends Counterparty2IdentifierSourceRule {
		@Override
		protected Counterparty2IdentifierEnum doEvaluate(TransactionReportInstruction input) {
			Counterparty2IdentifierEnum output = null;
			return assignOutput(output, input);
		}
		
		protected Counterparty2IdentifierEnum assignOutput(Counterparty2IdentifierEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()).<NaturalPerson>mapC("getPerson", party -> party.getPerson())).andNullSafe(areEqual(item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()).<NaturalPerson>mapC("getPerson", party -> party.getPerson()).<FieldWithMetaPersonIdentifier>mapC("getPersonId", naturalPerson -> naturalPerson.getPersonId()).<PersonIdentifier>map("Type coercion", fieldWithMetaPersonIdentifier -> fieldWithMetaPersonIdentifier.getValue()).<PersonIdentifierTypeEnum>map("getIdentifierType", personIdentifier -> personIdentifier.getIdentifierType()), MapperS.of(PersonIdentifierTypeEnum.PLID), CardinalityOperator.Any)).getOrDefault(false)) {
						return MapperS.of(Counterparty2IdentifierEnum.PLID);
					}
					if (areEqual(item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty2 -> referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
						return MapperS.of(Counterparty2IdentifierEnum.LEID);
					}
					return MapperS.of(counterparty2IdentifierSourceRule.evaluate(item.get()));
				}).get();
			
			return output;
		}
	}
}
