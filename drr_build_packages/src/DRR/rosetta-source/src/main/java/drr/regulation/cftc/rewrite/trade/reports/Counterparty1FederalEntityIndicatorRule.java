package drr.regulation.cftc.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.CFTCFederalEntityClassificationEnum;
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty1FederalEntityIndicatorRule.Counterparty1FederalEntityIndicatorRuleDefault.class)
public abstract class Counterparty1FederalEntityIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

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

	public static class Counterparty1FederalEntityIndicatorRuleDefault extends Counterparty1FederalEntityIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			final MapperS<JurisdictionPartyInformation> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(extractRegimeInformation.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), RegimeNameEnum.DODD_FRANK_ACT, SupervisoryBodyEnum.CFTC));
				});
			final MapperS<Boolean> ifThenElseResult;
			if (exists(thenArg1.<CFTCPartyInformation>map("getCftcPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCftcPartyInformation()).<CFTCFederalEntityClassificationEnum>map("getFederalEntity", cFTCPartyInformation -> cFTCPartyInformation.getFederalEntity())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(true);
			} else {
				ifThenElseResult = MapperS.of(false);
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
