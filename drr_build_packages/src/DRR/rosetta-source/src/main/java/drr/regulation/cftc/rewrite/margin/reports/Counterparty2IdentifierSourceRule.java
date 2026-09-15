package drr.regulation.cftc.rewrite.margin.reports;

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
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2IdentifierSourceRule.Counterparty2IdentifierSourceRuleDefault.class)
public abstract class Counterparty2IdentifierSourceRule implements ReportFunction<CollateralReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstruction input);

	public static class Counterparty2IdentifierSourceRuleDefault extends Counterparty2IdentifierSourceRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			final MapperS<ReferenceWithMetaParty> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> item.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (exists(item.<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()).<NaturalPerson>mapC("getPerson", party -> party.getPerson())).andNullSafe(areEqual(MapperC.<PersonIdentifierTypeEnum>of(MapperS.of(PersonIdentifierTypeEnum.NPID), MapperS.of(PersonIdentifierTypeEnum.PLID)), item.<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()).<NaturalPerson>mapC("getPerson", party -> party.getPerson()).<FieldWithMetaPersonIdentifier>mapC("getPersonId", naturalPerson -> naturalPerson.getPersonId()).<PersonIdentifier>map("Type coercion", fieldWithMetaPersonIdentifier -> fieldWithMetaPersonIdentifier.getValue()).<PersonIdentifierTypeEnum>map("getIdentifierType", personIdentifier -> personIdentifier.getIdentifierType())
						.first(), CardinalityOperator.Any)).getOrDefault(false)) {
						final MapperC<PersonIdentifierTypeEnum> thenArg0 = item.<Party>map("Type coercion", referenceWithMetaParty2 -> referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue()).<NaturalPerson>mapC("getPerson", party -> party.getPerson()).<FieldWithMetaPersonIdentifier>mapC("getPersonId", naturalPerson -> naturalPerson.getPersonId()).<PersonIdentifier>map("Type coercion", fieldWithMetaPersonIdentifier -> fieldWithMetaPersonIdentifier.getValue()).<PersonIdentifierTypeEnum>map("getIdentifierType", personIdentifier -> personIdentifier.getIdentifierType());
						final MapperC<PersonIdentifierTypeEnum> thenArg1 = thenArg0
							.filterItemNullSafe(_item -> areEqual(MapperC.<PersonIdentifierTypeEnum>of(MapperS.of(PersonIdentifierTypeEnum.NPID), MapperS.of(PersonIdentifierTypeEnum.PLID)), _item, CardinalityOperator.Any).get());
						final MapperS<PersonIdentifierTypeEnum> thenArg2 = thenArg1
							.first();
						return thenArg2
							.mapSingleToItem(_item -> _item.map("to-string", PersonIdentifierTypeEnum::toDisplayString));
					}
					if (areEqual(item.<Party>map("Type coercion", referenceWithMetaParty3 -> referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
						return MapperS.of("LEID");
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
