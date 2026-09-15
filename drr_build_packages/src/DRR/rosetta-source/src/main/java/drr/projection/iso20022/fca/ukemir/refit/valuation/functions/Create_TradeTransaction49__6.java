package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import iso20022.auth030.fca.TradeTransaction49__6;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction49__6.Create_TradeTransaction49__6Default.class)
public abstract class Create_TradeTransaction49__6 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt5 getDerivEvt5;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction49__6 evaluate(FCAValuationReport drrReport) {
		TradeTransaction49__6.TradeTransaction49__6Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction49__6 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction49__6.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction49__6.TradeTransaction49__6Builder doEvaluate(FCAValuationReport drrReport);

	public static class Create_TradeTransaction49__6Default extends Create_TradeTransaction49__6 {
		@Override
		protected TradeTransaction49__6.TradeTransaction49__6Builder doEvaluate(FCAValuationReport drrReport) {
			TradeTransaction49__6.TradeTransaction49__6Builder txData = TradeTransaction49__6.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction49__6.TradeTransaction49__6Builder assignOutput(TradeTransaction49__6.TradeTransaction49__6Builder txData, FCAValuationReport drrReport) {
			txData = toBuilder(TradeTransaction49__6.builder()
				.setTxId(getTxId.evaluate(drrReport))
				.setDerivEvt(getDerivEvt5.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
