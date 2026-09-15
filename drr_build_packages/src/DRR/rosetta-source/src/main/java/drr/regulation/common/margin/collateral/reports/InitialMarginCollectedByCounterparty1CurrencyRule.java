package drr.regulation.common.margin.collateral.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version2.collateral.functions.InitialMarginCollectedByReportingCounterpartyCurrency;
import javax.inject.Inject;


@ImplementedBy(InitialMarginCollectedByCounterparty1CurrencyRule.InitialMarginCollectedByCounterparty1CurrencyRuleDefault.class)
public abstract class InitialMarginCollectedByCounterparty1CurrencyRule implements ReportFunction<CollateralReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected InitialMarginCollectedByReportingCounterpartyCurrency initialMarginCollectedByReportingCounterpartyCurrency;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(CollateralReportInstruction input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(CollateralReportInstruction input);

	public static class InitialMarginCollectedByCounterparty1CurrencyRuleDefault extends InitialMarginCollectedByCounterparty1CurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(CollateralReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, CollateralReportInstruction input) {
			final ReferenceWithMetaParty referenceWithMetaParty = MapperS.of(input).<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			output = initialMarginCollectedByReportingCounterpartyCurrency.evaluate(input, (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()));
			
			return output;
		}
	}
}
