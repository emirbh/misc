package drr.regulation.asic.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.ASICPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SmallScaleBuySideEntityIndicatorRule.SmallScaleBuySideEntityIndicatorRuleDefault.class)
public abstract class SmallScaleBuySideEntityIndicatorRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;

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

	public static class SmallScaleBuySideEntityIndicatorRuleDefault extends SmallScaleBuySideEntityIndicatorRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final MapperS<ASICPartyInformation> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(extractRegimeInformation.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), RegimeNameEnum.ASIC, SupervisoryBodyEnum.ASIC)).<ASICPartyInformation>map("getAsicPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getAsicPartyInformation());
				});
			output = thenArg1
				.mapSingleToItem(item -> {
					if (areEqual(item.<Boolean>map("getSmallScaleBuySideIndicator", aSICPartyInformation -> aSICPartyInformation.getSmallScaleBuySideIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("SSBS");
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
