package drr.regulation.hkma.rewrite.margin.reports;

import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaNaturalPersonRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.CollateralReportInstruction;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2IdentifierFormatRule.Counterparty2IdentifierFormatRuleDefault.class)
public abstract class Counterparty2IdentifierFormatRule implements ReportFunction<CollateralReportInstruction, PartyIdentifierFormat2Enum> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierFormat2Enum evaluate(CollateralReportInstruction input) {
		PartyIdentifierFormat2Enum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierFormat2Enum doEvaluate(CollateralReportInstruction input);

	public static class Counterparty2IdentifierFormatRuleDefault extends Counterparty2IdentifierFormatRule {
		@Override
		protected PartyIdentifierFormat2Enum doEvaluate(CollateralReportInstruction input) {
			PartyIdentifierFormat2Enum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierFormat2Enum assignOutput(PartyIdentifierFormat2Enum output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportInstruction -> {
					final MapperS<ReferenceWithMetaParty> thenArg = MapperS.of(input)
						.mapSingleToItem(item -> item.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()));
					return thenArg
						.mapSingleToItem(item -> {
							if (areEqual(item.<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()).<NaturalPersonRole>mapC("getPersonRole", party -> party.getPersonRole()).<FieldWithMetaNaturalPersonRoleEnum>mapC("getRole", naturalPersonRole -> naturalPersonRole.getRole()).<NaturalPersonRoleEnum>map("Type coercion", fieldWithMetaNaturalPersonRoleEnum -> fieldWithMetaNaturalPersonRoleEnum.getValue()), MapperS.of(MapperC.<NaturalPersonRoleEnum>of(MapperS.of(NaturalPersonRoleEnum.BUYER), MapperS.of(NaturalPersonRoleEnum.SELLER)).get()), CardinalityOperator.Any).getOrDefault(false)) {
								return MapperS.of(PartyIdentifierFormat2Enum.NATURAL_PERSON);
							}
							if (areEqual(item.<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
								return MapperS.of(PartyIdentifierFormat2Enum.LEI);
							}
							if (areEqual(item.<Party>map("Type coercion", referenceWithMetaParty2 -> referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.BIC), CardinalityOperator.Any).getOrDefault(false)) {
								return MapperS.of(PartyIdentifierFormat2Enum.SWIFTBIC);
							}
							return MapperS.of(PartyIdentifierFormat2Enum.OTHER);
						});
				}).get();
			
			return output;
		}
	}
}
