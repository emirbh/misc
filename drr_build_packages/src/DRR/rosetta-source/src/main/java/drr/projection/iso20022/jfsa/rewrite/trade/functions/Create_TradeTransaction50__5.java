package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.TradeTransaction50__5;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction50__5.Create_TradeTransaction50__5Default.class)
public abstract class Create_TradeTransaction50__5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__5 evaluate(JFSATransactionReport drrReport) {
		TradeTransaction50__5.TradeTransaction50__5Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction50__5 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction50__5.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction50__5.TradeTransaction50__5Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_TradeTransaction50__5Default extends Create_TradeTransaction50__5 {
		@Override
		protected TradeTransaction50__5.TradeTransaction50__5Builder doEvaluate(JFSATransactionReport drrReport) {
			TradeTransaction50__5.TradeTransaction50__5Builder txData = TradeTransaction50__5.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__5.TradeTransaction50__5Builder assignOutput(TradeTransaction50__5.TradeTransaction50__5Builder txData, JFSATransactionReport drrReport) {
			txData = toBuilder(TradeTransaction50__5.builder()
				.setTxId(getTxId.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
