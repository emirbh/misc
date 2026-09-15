package drr.regulation.common.margin.collateral.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version2.collateral.functions.InitialMarginPostedByReportingCounterpartyCurrency;
import javax.inject.Inject;


@ImplementedBy(InitialMarginPostedByCounterparty1CurrencyRule.InitialMarginPostedByCounterparty1CurrencyRuleDefault.class)
public abstract class InitialMarginPostedByCounterparty1CurrencyRule implements ReportFunction<CollateralReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected InitialMarginPostedByReportingCounterpartyCurrency initialMarginPostedByReportingCounterpartyCurrency;

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

	public static class InitialMarginPostedByCounterparty1CurrencyRuleDefault extends InitialMarginPostedByCounterparty1CurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(CollateralReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(initialMarginPostedByReportingCounterpartyCurrency.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
				}).get();
			
			return output;
		}
	}
}
