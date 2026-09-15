package drr.standards.iosco.cde.version1.party.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PartyInformation;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.ReportingSide;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.util.party.functions.ExtractPartyFromRelatedPartyByRole;
import drr.base.util.party.functions.PartyLei;
import drr.base.util.party.functions.PartyLeiAndPersonByRoles;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Beneficiary2IdentifierTypeIndicatorRule.Beneficiary2IdentifierTypeIndicatorRuleDefault.class)
public abstract class Beneficiary2IdentifierTypeIndicatorRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;
	@Inject protected PartyLei partyLei;
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;

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

	public static class Beneficiary2IdentifierTypeIndicatorRuleDefault extends Beneficiary2IdentifierTypeIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstructionBase input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportInstruction -> {
					final MapperC<PartyInformation> thenArg0 = MapperS.of(input)
						.mapSingleToList(item -> item.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformationBase -> reportableInformationBase.getGlobalPartyInformation()));
					final MapperC<PartyInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> exists(MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(item.<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.BENEFICIARY))).get());
					final MapperC<Party> thenArg2 = thenArg1
						.mapItem(item -> {
							if (areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", partyInformation -> partyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstructionBase -> transactionReportInstructionBase.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).getOrDefault(false)) {
								return MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(item.<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.BENEFICIARY));
							}
							return MapperS.<Party>ofNull();
						});
					final MapperS<Party> thenArg3 = MapperS.of(thenArg2.get());
					return thenArg3
						.mapSingleToItem(item -> {
							final ReferenceWithMetaParty referenceWithMetaParty = reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstructionBase -> transactionReportInstructionBase.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
							if (exists(MapperS.of(partyLei.evaluate(item.<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti()))).andNullSafe(areEqual(MapperS.of(partyLeiAndPersonByRoles.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()))), MapperS.of(partyLei.evaluate(item.<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti())), CardinalityOperator.All)).getOrDefault(false)) {
								return MapperS.of(true);
							}
							return MapperS.of(false);
						});
				}).get();
			
			return output;
		}
	}
}
