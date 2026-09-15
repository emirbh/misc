package drr.regulation.common.valuation.party.reports;

import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaNaturalPersonRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.PartyLei;
import drr.regulation.common.ValuationReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2IdentifierTypeRule.Counterparty2IdentifierTypeRuleDefault.class)
public abstract class Counterparty2IdentifierTypeRule implements ReportFunction<ValuationReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyLei partyLei;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(ValuationReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(ValuationReportInstruction input);

	public static class Counterparty2IdentifierTypeRuleDefault extends Counterparty2IdentifierTypeRule {
		@Override
		protected Boolean doEvaluate(ValuationReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, ValuationReportInstruction input) {
			final MapperS<ReferenceWithMetaParty> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> item.<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(item.<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()).<NaturalPersonRole>mapC("getPersonRole", party -> party.getPersonRole()).<FieldWithMetaNaturalPersonRoleEnum>mapC("getRole", naturalPersonRole -> naturalPersonRole.getRole()).<NaturalPersonRoleEnum>map("Type coercion", fieldWithMetaNaturalPersonRoleEnum -> fieldWithMetaNaturalPersonRoleEnum.getValue()), MapperS.of(NaturalPersonRoleEnum.BUYER), CardinalityOperator.Any).orNullSafe(areEqual(item.<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()).<NaturalPersonRole>mapC("getPersonRole", party -> party.getPersonRole()).<FieldWithMetaNaturalPersonRoleEnum>mapC("getRole", naturalPersonRole -> naturalPersonRole.getRole()).<NaturalPersonRoleEnum>map("Type coercion", fieldWithMetaNaturalPersonRoleEnum -> fieldWithMetaNaturalPersonRoleEnum.getValue()), MapperS.of(NaturalPersonRoleEnum.SELLER), CardinalityOperator.Any)).orNullSafe(notEqual(item.<Party>map("Type coercion", referenceWithMetaParty2 -> referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(false);
					}
					if (exists(MapperS.of(partyLei.evaluate(item.<Party>map("Type coercion", referenceWithMetaParty3 -> referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti()))).getOrDefault(false)) {
						return MapperS.of(true);
					}
					return MapperS.<Boolean>ofNull();
				}).get();
			
			return output;
		}
	}
}
