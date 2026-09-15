package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PartyInformation;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_ExecutionVenueIDTypeRule.DTCC_ExecutionVenueIDTypeRuleDefault.class)
public abstract class DTCC_ExecutionVenueIDTypeRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeForEvent tradeForEvent;

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

	public static class DTCC_ExecutionVenueIDTypeRuleDefault extends DTCC_ExecutionVenueIDTypeRule {
		@Override
		protected PartyIdentifierTypeEnum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierTypeEnum assignOutput(PartyIdentifierTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> areEqual(MapperS.of(tradeForEvent.evaluate(item.get())).<ExecutionDetails>map("getExecutionDetails", trade -> trade.getExecutionDetails()).<ExecutionTypeEnum>map("getExecutionType", executionDetails -> executionDetails.getExecutionType()), MapperS.of(ExecutionTypeEnum.ELECTRONIC), CardinalityOperator.All).get());
			final MapperC<RelatedParty> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()));
			final MapperC<RelatedParty> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<PartyRoleEnum>map("getRole", relatedParty -> relatedParty.getRole()), MapperS.of(PartyRoleEnum.EXECUTION_FACILITY), CardinalityOperator.All).get());
			final MapperListOfLists<PartyIdentifier> thenArg3 = thenArg2
				.mapItemToList(item -> item.<ReferenceWithMetaParty>map("getPartyReference", relatedParty -> relatedParty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()));
			final MapperC<PartyIdentifier> thenArg4 = thenArg3
				.flattenList();
			final MapperC<PartyIdentifier> thenArg5 = thenArg4
				.filterItemNullSafe(item -> areEqual(item.<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.All).get());
			final MapperS<PartyIdentifier> thenArg6 = thenArg5
				.first();
			output = thenArg6
				.mapSingleToItem(item -> {
					if (exists(item.<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier())).getOrDefault(false)) {
						return MapperS.of(PartyIdentifierTypeEnum.LEI);
					}
					return MapperS.<PartyIdentifierTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
