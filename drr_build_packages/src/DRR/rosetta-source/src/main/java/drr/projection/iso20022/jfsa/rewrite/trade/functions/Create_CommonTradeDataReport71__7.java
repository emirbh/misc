package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.CommonTradeDataReport71__7;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport71__7.Create_CommonTradeDataReport71__7Default.class)
public abstract class Create_CommonTradeDataReport71__7 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractType15__2 create_ContractType15__2;
	@Inject protected Create_TradeTransaction50__7 create_TradeTransaction50__7;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport71__7 evaluate(JFSATransactionReport drrReport) {
		CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport71__7 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport71__7.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_CommonTradeDataReport71__7Default extends Create_CommonTradeDataReport71__7 {
		@Override
		protected CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder doEvaluate(JFSATransactionReport drrReport) {
			CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder cmonTradData = CommonTradeDataReport71__7.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder assignOutput(CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder cmonTradData, JFSATransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport71__7.builder()
				.setTxData(create_TradeTransaction50__7.evaluate(drrReport))
				.setCtrctData(create_ContractType15__2.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
