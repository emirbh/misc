package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.CommonTradeDataReport69__4;
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
	public CommonTradeDataReport69__4 evaluate(ESMAEMIRTransactionReport drrReport) {
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

	protected abstract CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class Create_CommonTradeDataReport69__4Default extends Create_CommonTradeDataReport69__4 {
		@Override
		protected CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder cmonTradData = CommonTradeDataReport69__4.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder assignOutput(CommonTradeDataReport69__4.CommonTradeDataReport69__4Builder cmonTradData, ESMAEMIRTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport69__4.builder()
				.setTxData(create_TradeTransaction49__4.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
