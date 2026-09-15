package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.CommonTradeDataReport69__6;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport69__6.Create_CommonTradeDataReport69__6Default.class)
public abstract class Create_CommonTradeDataReport69__6 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeTransaction49__6 create_TradeTransaction49__6;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport69__6 evaluate(FCAUKEMIRTransactionReport drrReport) {
		CommonTradeDataReport69__6.CommonTradeDataReport69__6Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport69__6 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport69__6.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport69__6.CommonTradeDataReport69__6Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class Create_CommonTradeDataReport69__6Default extends Create_CommonTradeDataReport69__6 {
		@Override
		protected CommonTradeDataReport69__6.CommonTradeDataReport69__6Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			CommonTradeDataReport69__6.CommonTradeDataReport69__6Builder cmonTradData = CommonTradeDataReport69__6.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__6.CommonTradeDataReport69__6Builder assignOutput(CommonTradeDataReport69__6.CommonTradeDataReport69__6Builder cmonTradData, FCAUKEMIRTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__6.builder()
				.setTxData(create_TradeTransaction49__6.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
