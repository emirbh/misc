package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.CommonTradeDataReport71__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport71__2.Create_CommonTradeDataReport71__2Default.class)
public abstract class Create_CommonTradeDataReport71__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractType15__1 create_ContractType15__1;
	@Inject protected Create_TradeTransaction50__2 create_TradeTransaction50__2;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport71__2 evaluate(ASICTransactionReport drrReport) {
		CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport71__2 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport71__2.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder doEvaluate(ASICTransactionReport drrReport);

	public static class Create_CommonTradeDataReport71__2Default extends Create_CommonTradeDataReport71__2 {
		@Override
		protected CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder doEvaluate(ASICTransactionReport drrReport) {
			CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder cmonTradData = CommonTradeDataReport71__2.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder assignOutput(CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder cmonTradData, ASICTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport71__2.builder()
				.setCtrctData(create_ContractType15__1.evaluate(drrReport))
				.setTxData(create_TradeTransaction50__2.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
