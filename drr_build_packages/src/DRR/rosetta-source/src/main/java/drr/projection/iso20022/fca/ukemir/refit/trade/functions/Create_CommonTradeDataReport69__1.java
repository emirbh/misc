package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.CommonTradeDataReport69__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport69__1.Create_CommonTradeDataReport69__1Default.class)
public abstract class Create_CommonTradeDataReport69__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractType14__1 create_ContractType14__1;
	@Inject protected Create_TradeTransaction49__1 create_TradeTransaction49__1;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport69__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport69__1 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport69__1.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class Create_CommonTradeDataReport69__1Default extends Create_CommonTradeDataReport69__1 {
		@Override
		protected CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder cmonTradData = CommonTradeDataReport69__1.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder assignOutput(CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder cmonTradData, FCAUKEMIRTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__1.builder()
				.setCtrctData(create_ContractType14__1.evaluate(drrReport))
				.setTxData(create_TradeTransaction49__1.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
