package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.CommonTradeDataReport69__1;
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
	public CommonTradeDataReport69__1 evaluate(ESMAEMIRTransactionReport drrReport) {
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

	protected abstract CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class Create_CommonTradeDataReport69__1Default extends Create_CommonTradeDataReport69__1 {
		@Override
		protected CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder cmonTradData = CommonTradeDataReport69__1.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder assignOutput(CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder cmonTradData, ESMAEMIRTransactionReport drrReport) {
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
