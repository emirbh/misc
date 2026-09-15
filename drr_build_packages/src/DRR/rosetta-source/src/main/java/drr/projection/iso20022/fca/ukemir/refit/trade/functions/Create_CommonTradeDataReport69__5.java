package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.CommonTradeDataReport69__5;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport69__5.Create_CommonTradeDataReport69__5Default.class)
public abstract class Create_CommonTradeDataReport69__5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractType14__1 create_ContractType14__1;
	@Inject protected Create_TradeTransaction49__5 create_TradeTransaction49__5;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport69__5 evaluate(FCAUKEMIRTransactionReport drrReport) {
		CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport69__5 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport69__5.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class Create_CommonTradeDataReport69__5Default extends Create_CommonTradeDataReport69__5 {
		@Override
		protected CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder cmonTradData = CommonTradeDataReport69__5.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder assignOutput(CommonTradeDataReport69__5.CommonTradeDataReport69__5Builder cmonTradData, FCAUKEMIRTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__5.builder()
				.setCtrctData(create_ContractType14__1.evaluate(drrReport))
				.setTxData(create_TradeTransaction49__5.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
