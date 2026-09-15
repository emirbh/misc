package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.TradeTransaction49__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction49__2.Create_TradeTransaction49__2Default.class)
public abstract class Create_TradeTransaction49__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt2 getDerivEvt2;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction49__2 evaluate(ESMAValuationReport drrReport) {
		TradeTransaction49__2.TradeTransaction49__2Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction49__2 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction49__2.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction49__2.TradeTransaction49__2Builder doEvaluate(ESMAValuationReport drrReport);

	public static class Create_TradeTransaction49__2Default extends Create_TradeTransaction49__2 {
		@Override
		protected TradeTransaction49__2.TradeTransaction49__2Builder doEvaluate(ESMAValuationReport drrReport) {
			TradeTransaction49__2.TradeTransaction49__2Builder txData = TradeTransaction49__2.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction49__2.TradeTransaction49__2Builder assignOutput(TradeTransaction49__2.TradeTransaction49__2Builder txData, ESMAValuationReport drrReport) {
			txData = toBuilder(TradeTransaction49__2.builder()
				.setTxId(getTxId.evaluate(drrReport))
				.setDerivEvt(getDerivEvt2.evaluate(drrReport))
				.setCollPrtflCd(null)
				.setNtnlAmt(null)
				.setDlvryTp(null)
				.setExctnTmStmp(null)
				.setFctvDt(null)
				.setMstrAgrmt(null)
				.setTradClr(null)
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
