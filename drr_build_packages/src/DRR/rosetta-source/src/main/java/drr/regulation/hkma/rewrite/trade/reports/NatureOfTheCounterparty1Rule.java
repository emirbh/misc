package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.HKMAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractNatureOfCounterparty;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import javax.inject.Inject;


@ImplementedBy(NatureOfTheCounterparty1Rule.NatureOfTheCounterparty1RuleDefault.class)
public abstract class NatureOfTheCounterparty1Rule implements ReportFunction<TransactionReportInstruction, NatureOfCounterpartyEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractNatureOfCounterparty extractNatureOfCounterparty;
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public NatureOfCounterpartyEnum evaluate(TransactionReportInstruction input) {
		NatureOfCounterpartyEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract NatureOfCounterpartyEnum doEvaluate(TransactionReportInstruction input);

	public static class NatureOfTheCounterparty1RuleDefault extends NatureOfTheCounterparty1Rule {
		@Override
		protected NatureOfCounterpartyEnum doEvaluate(TransactionReportInstruction input) {
			NatureOfCounterpartyEnum output = null;
			return assignOutput(output, input);
		}
		
		protected NatureOfCounterpartyEnum assignOutput(NatureOfCounterpartyEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			final ReferenceWithMetaParty referenceWithMetaParty = thenArg.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			output = MapperS.of(extractNatureOfCounterparty.evaluate(MapperS.of(extractRegimeInformation.evaluate(thenArg.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), RegimeNameEnum.HKMA, SupervisoryBodyEnum.HKMA)).<HKMAPartyInformation>map("getHkmaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getHkmaPartyInformation()).<NatureOfPartyEnum>map("getNatureOfParty", hKMAPartyInformation -> hKMAPartyInformation.getNatureOfParty()).get())).get();
			
			return output;
		}
	}
}
