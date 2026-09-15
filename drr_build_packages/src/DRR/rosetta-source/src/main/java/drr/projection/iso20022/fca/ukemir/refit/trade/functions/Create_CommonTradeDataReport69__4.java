package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.CommonTradeDataReport69__4;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport69__4.Create_CommonTradeDataReport69__4Default.class)
public abstract class Create_CommonTradeDataReport69__4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeTransaction49__4 create_TradeTransaction49__4;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport69__4 evaluate(FCAUKEMIRTransactionReport drrReport) {
		CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport69__4 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport69__4.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class Create_CommonTradeDataReport69__4Default extends Create_CommonTradeDataReport69__4 {
		@Override
		protected CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder cmonTradData = CommonTradeDataReport69__4.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder assignOutput(CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder cmonTradData, FCAUKEMIRTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__4.builder()
				.setTxData(create_TradeTransaction49__4.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
