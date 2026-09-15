package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PartyInformation;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.ExtractPartyFromRelatedPartyByRole;
import drr.base.util.party.functions.PartyLei;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_TradeParty1ExecutionAgentIDTypeRule.DTCC_TradeParty1ExecutionAgentIDTypeRuleDefault.class)
public abstract class DTCC_TradeParty1ExecutionAgentIDTypeRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;
	@Inject protected PartyLei partyLei;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierTypeEnum evaluate(TransactionReportInstruction input) {
		PartyIdentifierTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class DTCC_TradeParty1ExecutionAgentIDTypeRuleDefault extends DTCC_TradeParty1ExecutionAgentIDTypeRule {
		@Override
		protected PartyIdentifierTypeEnum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierTypeEnum assignOutput(PartyIdentifierTypeEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportableEvent -> {
					final MapperC<PartyInformation> thenArg0 = reportableEvent.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation());
					final MapperC<PartyInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", partyInformation -> partyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportableEvent.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
					final MapperS<PartyInformation> thenArg2 = MapperS.of(distinctIgnoringPrecision(thenArg1).get());
					final MapperS<Party> thenArg3 = thenArg2
						.mapSingleToItem(item -> MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(item.<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.EXECUTION_AGENT)));
					return thenArg3
						.mapSingleToItem(item -> {
							if (exists(MapperS.of(partyLei.evaluate(item.<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti()))).getOrDefault(false)) {
								return MapperS.of(PartyIdentifierTypeEnum.LEI);
							}
							return MapperS.<PartyIdentifierTypeEnum>ofNull();
						});
				}).get();
			
			return output;
		}
	}
}
