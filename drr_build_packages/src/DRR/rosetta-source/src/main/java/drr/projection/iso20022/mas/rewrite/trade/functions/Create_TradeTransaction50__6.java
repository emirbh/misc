package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.GenericIdentification175__1;
import iso20022.auth030.mas.TradeTransaction50__6;
import iso20022.auth030.mas.UniqueTransactionIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction50__6.Create_TradeTransaction50__6Default.class)
public abstract class Create_TradeTransaction50__6 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt3 getDerivEvt3;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__6 evaluate(MASTransactionReport drrReport) {
		TradeTransaction50__6.TradeTransaction50__6Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction50__6 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction50__6.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction50__6.TradeTransaction50__6Builder doEvaluate(MASTransactionReport drrReport);

	public static class Create_TradeTransaction50__6Default extends Create_TradeTransaction50__6 {
		@Override
		protected TradeTransaction50__6.TradeTransaction50__6Builder doEvaluate(MASTransactionReport drrReport) {
			TradeTransaction50__6.TradeTransaction50__6Builder txData = TradeTransaction50__6.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__6.TradeTransaction50__6Builder assignOutput(TradeTransaction50__6.TradeTransaction50__6Builder txData, MASTransactionReport drrReport) {
			txData = toBuilder(TradeTransaction50__6.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(getTxId.evaluate(drrReport))
					.setPrtry(GenericIdentification175__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", mASTransactionReport -> mASTransactionReport.getUniqueTransactionIdentifierProprietary()).get())
						.build())
					.build())
				.setDerivEvt(getDerivEvt3.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
