package drr.standards.iosco.cde.version1.execution.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PartyInformation;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.TransactionReportInstructionBase;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PlatformIdentifierRule.PlatformIdentifierRuleDefault.class)
public abstract class PlatformIdentifierRule implements ReportFunction<TransactionReportInstructionBase, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class PlatformIdentifierRuleDefault extends PlatformIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final MapperC<RelatedParty> thenArg0 = MapperS.of(input).<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformationBase -> reportableInformationBase.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty())
				.filterItemNullSafe(item -> areEqual(item.<PartyRoleEnum>map("getRole", relatedParty -> relatedParty.getRole()), MapperS.of(PartyRoleEnum.EXECUTION_FACILITY), CardinalityOperator.All).get());
			final MapperListOfLists<PartyIdentifier> thenArg1 = thenArg0
				.mapItemToList(item -> item.<ReferenceWithMetaParty>map("getPartyReference", relatedParty -> relatedParty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()));
			final MapperC<PartyIdentifier> thenArg2 = thenArg1
				.flattenList();
			final MapperC<PartyIdentifier> thenArg3 = thenArg2
				.filterItemNullSafe(item -> areEqual(item.<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.MIC), CardinalityOperator.All).get());
			final MapperC<FieldWithMetaString> thenArg4 = thenArg3
				.mapItem(item -> item.<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier()));
			final FieldWithMetaString fieldWithMetaString = thenArg4
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
