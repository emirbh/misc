package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaNaturalPersonRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.Extract_CentralCounterparty;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CentralCounterpartyIdentifierFormatRule.CentralCounterpartyIdentifierFormatRuleDefault.class)
public abstract class CentralCounterpartyIdentifierFormatRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierFormat2Enum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Extract_CentralCounterparty extract_CentralCounterparty;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierFormat2Enum evaluate(TransactionReportInstruction input) {
		PartyIdentifierFormat2Enum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierFormat2Enum doEvaluate(TransactionReportInstruction input);

	public static class CentralCounterpartyIdentifierFormatRuleDefault extends CentralCounterpartyIdentifierFormatRule {
		@Override
		protected PartyIdentifierFormat2Enum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierFormat2Enum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierFormat2Enum assignOutput(PartyIdentifierFormat2Enum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportInstruction -> {
					final MapperS<Party> thenArg = MapperS.of(input)
						.mapSingleToItem(item -> MapperS.of(extract_CentralCounterparty.evaluate(item.get())));
					return thenArg
						.mapSingleToItem(item -> {
							if (areEqual(item.<NaturalPersonRole>mapC("getPersonRole", party -> party.getPersonRole()).<FieldWithMetaNaturalPersonRoleEnum>mapC("getRole", naturalPersonRole -> naturalPersonRole.getRole()).<NaturalPersonRoleEnum>map("Type coercion", fieldWithMetaNaturalPersonRoleEnum -> fieldWithMetaNaturalPersonRoleEnum.getValue()), MapperS.of(MapperC.<NaturalPersonRoleEnum>of(MapperS.of(NaturalPersonRoleEnum.BUYER), MapperS.of(NaturalPersonRoleEnum.SELLER)).get()), CardinalityOperator.Any).getOrDefault(false)) {
								return MapperS.of(PartyIdentifierFormat2Enum.NATURAL_PERSON);
							}
							if (areEqual(item.<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.Any).getOrDefault(false)) {
								return MapperS.of(PartyIdentifierFormat2Enum.LEI);
							}
							if (areEqual(item.<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.BIC), CardinalityOperator.Any).getOrDefault(false)) {
								return MapperS.of(PartyIdentifierFormat2Enum.SWIFTBIC);
							}
							return MapperS.of(PartyIdentifierFormat2Enum.OTHER);
						});
				}).get();
			
			return output;
		}
	}
}
