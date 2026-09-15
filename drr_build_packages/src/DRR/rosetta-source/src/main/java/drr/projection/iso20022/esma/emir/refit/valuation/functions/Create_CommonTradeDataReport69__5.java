package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.CommonTradeDataReport69__5;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport69__5.Create_CommonTradeDataReport69__5Default.class)
public abstract class Create_CommonTradeDataReport69__5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeTransaction49__5 create_TradeTransaction49__5;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport69__5 evaluate(ESMAValuationReport drrReport) {
		CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport69__5 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport69__5.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder doEvaluate(ESMAValuationReport drrReport);

	public static class Create_CommonTradeDataReport69__5Default extends Create_CommonTradeDataReport69__5 {
		@Override
		protected CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder doEvaluate(ESMAValuationReport drrReport) {
			CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder cmonTradData = CommonTradeDataReport69__5.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder assignOutput(CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder cmonTradData, ESMAValuationReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__5.builder()
				.setTxData(create_TradeTransaction49__5.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
