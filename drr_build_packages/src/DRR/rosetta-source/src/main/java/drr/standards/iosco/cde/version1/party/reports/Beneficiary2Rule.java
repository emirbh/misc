package drr.standards.iosco.cde.version1.party.reports;

import cdm.base.staticdata.party.Party;
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
import drr.base.util.party.functions.PartyLeiAndPersonByRoles;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Beneficiary2Rule.Beneficiary2RuleDefault.class)
public abstract class Beneficiary2Rule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;

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

	public static class Beneficiary2RuleDefault extends Beneficiary2Rule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportInstruction -> {
					final MapperC<PartyInformation> thenArg0 = MapperS.of(input)
						.mapSingleToList(item -> item.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformationBase -> reportableInformationBase.getGlobalPartyInformation()));
					final MapperC<PartyInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", partyInformation -> partyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstructionBase -> transactionReportInstructionBase.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
					final MapperC<Party> thenArg2 = thenArg1
						.mapItem(item -> MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(item.<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.BENEFICIARY)));
					final MapperC<String> thenArg3 = thenArg2
						.mapItem(item -> {
							final ReferenceWithMetaParty referenceWithMetaParty = reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstructionBase -> transactionReportInstructionBase.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
							return MapperS.of(partyLeiAndPersonByRoles.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
						});
					return MapperS.of(thenArg3.get());
				}).get();
			
			return output;
		}
	}
}
