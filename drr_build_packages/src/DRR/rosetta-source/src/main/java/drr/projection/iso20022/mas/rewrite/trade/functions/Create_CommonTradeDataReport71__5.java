package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.CommonTradeDataReport71__5;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport71__5.Create_CommonTradeDataReport71__5Default.class)
public abstract class Create_CommonTradeDataReport71__5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeTransaction50__5 create_TradeTransaction50__5;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport71__5 evaluate(MASTransactionReport drrReport) {
		CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport71__5 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport71__5.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder doEvaluate(MASTransactionReport drrReport);

	public static class Create_CommonTradeDataReport71__5Default extends Create_CommonTradeDataReport71__5 {
		@Override
		protected CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder doEvaluate(MASTransactionReport drrReport) {
			CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder cmonTradData = CommonTradeDataReport71__5.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder assignOutput(CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder cmonTradData, MASTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport71__5.builder()
				.setTxData(create_TradeTransaction50__5.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
