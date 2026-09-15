package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.TradeTransaction49__4;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction49__4.Create_TradeTransaction49__4Default.class)
public abstract class Create_TradeTransaction49__4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt4 getDerivEvt4;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction49__4 evaluate(ESMAValuationReport drrReport) {
		TradeTransaction49__4.TradeTransaction49__4Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction49__4 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction49__4.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction49__4.TradeTransaction49__4Builder doEvaluate(ESMAValuationReport drrReport);

	public static class Create_TradeTransaction49__4Default extends Create_TradeTransaction49__4 {
		@Override
		protected TradeTransaction49__4.TradeTransaction49__4Builder doEvaluate(ESMAValuationReport drrReport) {
			TradeTransaction49__4.TradeTransaction49__4Builder txData = TradeTransaction49__4.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction49__4.TradeTransaction49__4Builder assignOutput(TradeTransaction49__4.TradeTransaction49__4Builder txData, ESMAValuationReport drrReport) {
			txData = toBuilder(TradeTransaction49__4.builder()
				.setTxId(getTxId.evaluate(drrReport))
				.setDerivEvt(getDerivEvt4.evaluate(drrReport))
				.setEarlyTermntnDt(null)
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
