package drr.regulation.fca.ukemir.refit.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.FCAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractNatureOfCounterparty;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import javax.inject.Inject;


@ImplementedBy(NatureOfCounterparty1Rule.NatureOfCounterparty1RuleDefault.class)
public abstract class NatureOfCounterparty1Rule implements ReportFunction<TransactionReportInstruction, NatureOfCounterpartyEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractNatureOfCounterparty extractNatureOfCounterparty;
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableAction isAllowableAction;

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

	public static class NatureOfCounterparty1RuleDefault extends NatureOfCounterparty1Rule {
		@Override
		protected NatureOfCounterpartyEnum doEvaluate(TransactionReportInstruction input) {
			NatureOfCounterpartyEnum output = null;
			return assignOutput(output, input);
		}
		
		protected NatureOfCounterpartyEnum assignOutput(NatureOfCounterpartyEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(extractNatureOfCounterparty.evaluate(MapperS.of(extractRegimeInformation.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), RegimeNameEnum.UKEMIR, SupervisoryBodyEnum.FCA)).<FCAPartyInformation>map("getFcaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getFcaPartyInformation()).<NatureOfPartyEnum>map("getNatureOfParty", fCAPartyInformation -> fCAPartyInformation.getNatureOfParty()).get()));
				}).get();
			
			return output;
		}
	}
}
