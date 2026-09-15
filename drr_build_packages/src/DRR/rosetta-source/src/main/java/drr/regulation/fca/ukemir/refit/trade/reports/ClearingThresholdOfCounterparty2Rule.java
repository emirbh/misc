package drr.regulation.fca.ukemir.refit.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.FCAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingThresholdOfCounterparty2Rule.ClearingThresholdOfCounterparty2RuleDefault.class)
public abstract class ClearingThresholdOfCounterparty2Rule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class ClearingThresholdOfCounterparty2RuleDefault extends ClearingThresholdOfCounterparty2Rule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<FCAPartyInformation> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).get();
					return MapperS.of(extractRegimeInformation.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), RegimeNameEnum.UKEMIR, SupervisoryBodyEnum.FCA)).<FCAPartyInformation>map("getFcaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getFcaPartyInformation());
				});
			final MapperS<FCAPartyInformation> thenArg2 = thenArg1
				.filterSingleNullSafe(item -> areEqual(MapperC.<NatureOfPartyEnum>of(MapperS.of(NatureOfPartyEnum.FINANCIAL), MapperS.of(NatureOfPartyEnum.NON_FINANCIAL)), item.<NatureOfPartyEnum>map("getNatureOfParty", fCAPartyInformation -> fCAPartyInformation.getNatureOfParty()), CardinalityOperator.Any).get());
			output = thenArg2
				.mapSingleToItem(item -> item.<Boolean>map("getExceedsClearingThreshold", fCAPartyInformation -> fCAPartyInformation.getExceedsClearingThreshold())).get();
			
			return output;
		}
	}
}
