package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.CommonTradeDataReport69__3;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport69__3.Create_CommonTradeDataReport69__3Default.class)
public abstract class Create_CommonTradeDataReport69__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractType14__1 create_ContractType14__1;
	@Inject protected Create_TradeTransaction49__3 create_TradeTransaction49__3;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport69__3 evaluate(ESMAEMIRTransactionReport drrReport) {
		CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport69__3 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport69__3.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class Create_CommonTradeDataReport69__3Default extends Create_CommonTradeDataReport69__3 {
		@Override
		protected CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder cmonTradData = CommonTradeDataReport69__3.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder assignOutput(CommonTradeDataReport69__3.CommonTradeDataReport69__3Builder cmonTradData, ESMAEMIRTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__3.builder()
				.setCtrctData(create_ContractType14__1.evaluate(drrReport))
				.setTxData(create_TradeTransaction49__3.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
