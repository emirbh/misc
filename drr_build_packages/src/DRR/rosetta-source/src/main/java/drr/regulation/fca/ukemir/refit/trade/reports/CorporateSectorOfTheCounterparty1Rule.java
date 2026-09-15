package drr.regulation.fca.ukemir.refit.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.FCAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.functions.ExtractPartySector;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(CorporateSectorOfTheCounterparty1Rule.CorporateSectorOfTheCounterparty1RuleDefault.class)
public abstract class CorporateSectorOfTheCounterparty1Rule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartySector extractPartySector;
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<String> evaluate(TransactionReportInstruction input) {
		List<String> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<String> doEvaluate(TransactionReportInstruction input);

	public static class CorporateSectorOfTheCounterparty1RuleDefault extends CorporateSectorOfTheCounterparty1Rule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final ReferenceWithMetaParty referenceWithMetaParty0 = thenArg.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			final ReferenceWithMetaParty referenceWithMetaParty1 = thenArg.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			output = MapperC.<String>of(extractPartySector.evaluate(MapperS.of(extractRegimeInformation.evaluate(thenArg.get(), (referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), RegimeNameEnum.UKEMIR, SupervisoryBodyEnum.FCA)).<FCAPartyInformation>map("getFcaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getFcaPartyInformation()).<NatureOfPartyEnum>map("getNatureOfParty", fCAPartyInformation -> fCAPartyInformation.getNatureOfParty()).get(), MapperS.of(extractRegimeInformation.evaluate(thenArg.get(), (referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), RegimeNameEnum.UKEMIR, SupervisoryBodyEnum.FCA)).<FCAPartyInformation>map("getFcaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getFcaPartyInformation()).<CorporateSector>map("getCorporateSector", fCAPartyInformation -> fCAPartyInformation.getCorporateSector()).getMulti())).getMulti();
			
			return output;
		}
	}
}
