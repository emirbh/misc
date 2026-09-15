package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.CommonTradeDataReport69__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport69__2.Create_CommonTradeDataReport69__2Default.class)
public abstract class Create_CommonTradeDataReport69__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeTransaction49__2 create_TradeTransaction49__2;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport69__2 evaluate(ESMAValuationReport drrReport) {
		CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport69__2 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport69__2.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder doEvaluate(ESMAValuationReport drrReport);

	public static class Create_CommonTradeDataReport69__2Default extends Create_CommonTradeDataReport69__2 {
		@Override
		protected CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder doEvaluate(ESMAValuationReport drrReport) {
			CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder cmonTradData = CommonTradeDataReport69__2.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder assignOutput(CommonTradeDataReport69__2.CommonTradeDataReport69__2Builder cmonTradData, ESMAValuationReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__2.builder()
				.setTxData(create_TradeTransaction49__2.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
