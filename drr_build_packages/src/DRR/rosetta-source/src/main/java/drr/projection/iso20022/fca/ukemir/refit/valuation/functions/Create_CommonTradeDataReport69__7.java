package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import iso20022.auth030.fca.CommonTradeDataReport69__7;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport69__7.Create_CommonTradeDataReport69__7Default.class)
public abstract class Create_CommonTradeDataReport69__7 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeTransaction49__7 create_TradeTransaction49__7;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport69__7 evaluate(FCAValuationReport drrReport) {
		CommonTradeDataReport69__7.CommonTradeDataReport69__7Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport69__7 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport69__7.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport69__7.CommonTradeDataReport69__7Builder doEvaluate(FCAValuationReport drrReport);

	public static class Create_CommonTradeDataReport69__7Default extends Create_CommonTradeDataReport69__7 {
		@Override
		protected CommonTradeDataReport69__7.CommonTradeDataReport69__7Builder doEvaluate(FCAValuationReport drrReport) {
			CommonTradeDataReport69__7.CommonTradeDataReport69__7Builder cmonTradData = CommonTradeDataReport69__7.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__7.CommonTradeDataReport69__7Builder assignOutput(CommonTradeDataReport69__7.CommonTradeDataReport69__7Builder cmonTradData, FCAValuationReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__7.builder()
				.setTxData(create_TradeTransaction49__7.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
