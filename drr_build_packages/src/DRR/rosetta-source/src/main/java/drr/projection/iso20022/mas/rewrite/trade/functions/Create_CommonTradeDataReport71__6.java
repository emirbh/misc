package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.CommonTradeDataReport71__6;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport71__6.Create_CommonTradeDataReport71__6Default.class)
public abstract class Create_CommonTradeDataReport71__6 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractType15__2 create_ContractType15__2;
	@Inject protected Create_TradeTransaction50__6 create_TradeTransaction50__6;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport71__6 evaluate(MASTransactionReport drrReport) {
		CommonTradeDataReport71__6.CommonTradeDataReport71__6Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport71__6 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport71__6.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport71__6.CommonTradeDataReport71__6Builder doEvaluate(MASTransactionReport drrReport);

	public static class Create_CommonTradeDataReport71__6Default extends Create_CommonTradeDataReport71__6 {
		@Override
		protected CommonTradeDataReport71__6.CommonTradeDataReport71__6Builder doEvaluate(MASTransactionReport drrReport) {
			CommonTradeDataReport71__6.CommonTradeDataReport71__6Builder cmonTradData = CommonTradeDataReport71__6.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport71__6.CommonTradeDataReport71__6Builder assignOutput(CommonTradeDataReport71__6.CommonTradeDataReport71__6Builder cmonTradData, MASTransactionReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport71__6.builder()
				.setCtrctData(create_ContractType15__2.evaluate(drrReport))
				.setTxData(create_TradeTransaction50__6.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
