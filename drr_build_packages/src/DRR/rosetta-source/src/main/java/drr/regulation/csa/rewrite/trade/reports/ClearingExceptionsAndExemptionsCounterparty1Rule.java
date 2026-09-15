package drr.regulation.csa.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.ClearingExceptionsAndExemptionsCounterparty;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(ClearingExceptionsAndExemptionsCounterparty1Rule.ClearingExceptionsAndExemptionsCounterparty1RuleDefault.class)
public abstract class ClearingExceptionsAndExemptionsCounterparty1Rule implements ReportFunction<TransactionReportInstruction, List<ClearingExceptionsAndExemptionsEnum>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ClearingExceptionsAndExemptionsCounterparty clearingExceptionsAndExemptionsCounterparty;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<ClearingExceptionsAndExemptionsEnum> evaluate(TransactionReportInstruction input) {
		List<ClearingExceptionsAndExemptionsEnum> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<ClearingExceptionsAndExemptionsEnum> doEvaluate(TransactionReportInstruction input);

	public static class ClearingExceptionsAndExemptionsCounterparty1RuleDefault extends ClearingExceptionsAndExemptionsCounterparty1Rule {
		@Override
		protected List<ClearingExceptionsAndExemptionsEnum> doEvaluate(TransactionReportInstruction input) {
			List<ClearingExceptionsAndExemptionsEnum> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<ClearingExceptionsAndExemptionsEnum> assignOutput(List<ClearingExceptionsAndExemptionsEnum> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToList(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperC.<ClearingExceptionsAndExemptionsEnum>of(clearingExceptionsAndExemptionsCounterparty.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
				}).getMulti();
			
			return output;
		}
	}
}
