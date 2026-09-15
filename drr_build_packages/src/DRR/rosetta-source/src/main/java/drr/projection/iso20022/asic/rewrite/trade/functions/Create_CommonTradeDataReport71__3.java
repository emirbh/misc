package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.CommonTradeDataReport71__3;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport71__3.Create_CommonTradeDataReport71__3Default.class)
public abstract class Create_CommonTradeDataReport71__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractType15__1 create_ContractType15__1;
	@Inject protected Create_TradeTransaction50__3 create_TradeTransaction50__3;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport71__3 evaluate(ASICTransactionReport drrReport) {
		CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport71__3 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport71__3.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder doEvaluate(ASICTransactionReport drrReport);

	public static class Create_CommonTradeDataReport71__3Default extends Create_CommonTradeDataReport71__3 {
		@Override
		protected CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder doEvaluate(ASICTransactionReport drrReport) {
			CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder cmonTradData = CommonTradeDataReport71__3.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder assignOutput(CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder cmonTradData, ASICTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport71__3.builder()
				.setCtrctData(create_ContractType15__1.evaluate(drrReport))
				.setTxData(create_TradeTransaction50__3.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
