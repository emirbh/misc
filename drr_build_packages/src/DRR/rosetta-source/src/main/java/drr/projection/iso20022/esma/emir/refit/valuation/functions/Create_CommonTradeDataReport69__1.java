package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.CommonTradeDataReport69__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport69__1.Create_CommonTradeDataReport69__1Default.class)
public abstract class Create_CommonTradeDataReport69__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeTransaction49__1 create_TradeTransaction49__1;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport69__1 evaluate(ESMAValuationReport drrReport) {
		CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport69__1 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport69__1.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder doEvaluate(ESMAValuationReport drrReport);

	public static class Create_CommonTradeDataReport69__1Default extends Create_CommonTradeDataReport69__1 {
		@Override
		protected CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder doEvaluate(ESMAValuationReport drrReport) {
			CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder cmonTradData = CommonTradeDataReport69__1.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder assignOutput(CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder cmonTradData, ESMAValuationReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__1.builder()
				.setTxData(create_TradeTransaction49__1.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
