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

@ImplementedBy(DTCC_ExecutionVenueIDRule.DTCC_ExecutionVenueIDRuleDefault.class)
public abstract class DTCC_ExecutionVenueIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class DTCC_ExecutionVenueIDRuleDefault extends DTCC_ExecutionVenueIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
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
			final MapperC<FieldWithMetaString> thenArg6 = thenArg5
				.mapItem(item -> item.<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier()));
			final FieldWithMetaString fieldWithMetaString = thenArg6
				.first().get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
