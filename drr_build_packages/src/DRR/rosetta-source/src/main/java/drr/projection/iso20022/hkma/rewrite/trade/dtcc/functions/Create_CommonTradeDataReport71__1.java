package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.CommonTradeDataReport71__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport71__1.Create_CommonTradeDataReport71__1Default.class)
public abstract class Create_CommonTradeDataReport71__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractType15__1 create_ContractType15__1;
	@Inject protected Create_TradeTransaction50__1 create_TradeTransaction50__1;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport71__1 evaluate(HKMATransactionReport drrReport) {
		CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport71__1 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport71__1.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_CommonTradeDataReport71__1Default extends Create_CommonTradeDataReport71__1 {
		@Override
		protected CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder doEvaluate(HKMATransactionReport drrReport) {
			CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder cmonTradData = CommonTradeDataReport71__1.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder assignOutput(CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder cmonTradData, HKMATransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport71__1.builder()
				.setCtrctData(create_ContractType15__1.evaluate(drrReport))
				.setTxData(create_TradeTransaction50__1.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
