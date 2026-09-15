package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.HKMAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.functions.ExtractPartySector;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(SectorOfTheCounterparty1Rule.SectorOfTheCounterparty1RuleDefault.class)
public abstract class SectorOfTheCounterparty1Rule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartySector extractPartySector;
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;

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

	public static class SectorOfTheCounterparty1RuleDefault extends SectorOfTheCounterparty1Rule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			final ReferenceWithMetaParty referenceWithMetaParty0 = thenArg.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			final ReferenceWithMetaParty referenceWithMetaParty1 = thenArg.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			output = MapperC.<String>of(extractPartySector.evaluate(MapperS.of(extractRegimeInformation.evaluate(thenArg.get(), (referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), RegimeNameEnum.HKMA, SupervisoryBodyEnum.HKMA)).<HKMAPartyInformation>map("getHkmaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getHkmaPartyInformation()).<NatureOfPartyEnum>map("getNatureOfParty", hKMAPartyInformation -> hKMAPartyInformation.getNatureOfParty()).get(), MapperS.of(extractRegimeInformation.evaluate(thenArg.get(), (referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), RegimeNameEnum.HKMA, SupervisoryBodyEnum.HKMA)).<HKMAPartyInformation>map("getHkmaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getHkmaPartyInformation()).<CorporateSector>map("getCorporateSector", hKMAPartyInformation -> hKMAPartyInformation.getCorporateSector()).getMulti())).getMulti();
			
			return output;
		}
	}
}
