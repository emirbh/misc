package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.CommonTradeDataReport71__7;
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
	public CommonTradeDataReport71__7 evaluate(HKMATransactionReport drrReport) {
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

	protected abstract CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_CommonTradeDataReport71__7Default extends Create_CommonTradeDataReport71__7 {
		@Override
		protected CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder doEvaluate(HKMATransactionReport drrReport) {
			CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder cmonTradData = CommonTradeDataReport71__7.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder assignOutput(CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder cmonTradData, HKMATransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport71__7.builder()
				.setCtrctData(create_ContractType15__2.evaluate(drrReport))
				.setTxData(create_TradeTransaction50__7.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
