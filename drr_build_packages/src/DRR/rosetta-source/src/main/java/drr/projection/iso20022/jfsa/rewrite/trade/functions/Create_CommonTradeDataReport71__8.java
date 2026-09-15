package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.CommonTradeDataReport71__8;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport71__8.Create_CommonTradeDataReport71__8Default.class)
public abstract class Create_CommonTradeDataReport71__8 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractType15__1 create_ContractType15__1;
	@Inject protected Create_TradeTransaction50__8 create_TradeTransaction50__8;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport71__8 evaluate(JFSATransactionReport drrReport) {
		CommonTradeDataReport71__8.CommonTradeDataReport71__8Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport71__8 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport71__8.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport71__8.CommonTradeDataReport71__8Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_CommonTradeDataReport71__8Default extends Create_CommonTradeDataReport71__8 {
		@Override
		protected CommonTradeDataReport71__8.CommonTradeDataReport71__8Builder doEvaluate(JFSATransactionReport drrReport) {
			CommonTradeDataReport71__8.CommonTradeDataReport71__8Builder cmonTradData = CommonTradeDataReport71__8.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport71__8.CommonTradeDataReport71__8Builder assignOutput(CommonTradeDataReport71__8.CommonTradeDataReport71__8Builder cmonTradData, JFSATransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport71__8.builder()
				.setCtrctData(create_ContractType15__1.evaluate(drrReport))
				.setTxData(create_TradeTransaction50__8.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
