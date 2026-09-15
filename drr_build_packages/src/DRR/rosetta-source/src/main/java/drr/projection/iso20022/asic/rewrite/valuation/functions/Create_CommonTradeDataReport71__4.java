package drr.projection.iso20022.asic.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import iso20022.auth030.asic.CommonTradeDataReport71__4;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CommonTradeDataReport71__4.Create_CommonTradeDataReport71__4Default.class)
public abstract class Create_CommonTradeDataReport71__4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeTransaction50__4 create_TradeTransaction50__4;

	/**
	* @param drrReport 
	* @return cmonTradData 
	*/
	public CommonTradeDataReport71__4 evaluate(ASICValuationReport drrReport) {
		CommonTradeDataReport71__4.CommonTradeDataReport71__4Builder cmonTradDataBuilder = doEvaluate(drrReport);
		
		final CommonTradeDataReport71__4 cmonTradData;
		if (cmonTradDataBuilder == null) {
			cmonTradData = null;
		} else {
			cmonTradData = cmonTradDataBuilder.build();
			objectValidator.validate(CommonTradeDataReport71__4.class, cmonTradData);
		}
		
		return cmonTradData;
	}

	protected abstract CommonTradeDataReport71__4.CommonTradeDataReport71__4Builder doEvaluate(ASICValuationReport drrReport);

	public static class Create_CommonTradeDataReport71__4Default extends Create_CommonTradeDataReport71__4 {
		@Override
		protected CommonTradeDataReport71__4.CommonTradeDataReport71__4Builder doEvaluate(ASICValuationReport drrReport) {
			CommonTradeDataReport71__4.CommonTradeDataReport71__4Builder cmonTradData = CommonTradeDataReport71__4.builder();
			return assignOutput(cmonTradData, drrReport);
		}
		
		protected CommonTradeDataReport71__4.CommonTradeDataReport71__4Builder assignOutput(CommonTradeDataReport71__4.CommonTradeDataReport71__4Builder cmonTradData, ASICValuationReport drrReport) {
			cmonTradData = toBuilder(CommonTradeDataReport71__4.builder()
				.setTxData(create_TradeTransaction50__4.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(cmonTradData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
