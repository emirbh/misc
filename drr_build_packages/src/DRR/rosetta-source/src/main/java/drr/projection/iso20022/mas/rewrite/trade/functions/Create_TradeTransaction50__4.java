package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.GenericIdentification175__1;
import iso20022.auth030.mas.TradeTransaction50__4;
import iso20022.auth030.mas.UniqueTransactionIdentifier2Choice__1;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction50__4.Create_TradeTransaction50__4Default.class)
public abstract class Create_TradeTransaction50__4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt1 getDerivEvt1;
	@Inject protected GetExctnTmStmp getExctnTmStmp;
	@Inject protected GetOthrPmt getOthrPmt;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__4 evaluate(MASTransactionReport drrReport) {
		TradeTransaction50__4.TradeTransaction50__4Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction50__4 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction50__4.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction50__4.TradeTransaction50__4Builder doEvaluate(MASTransactionReport drrReport);

	public static class Create_TradeTransaction50__4Default extends Create_TradeTransaction50__4 {
		@Override
		protected TradeTransaction50__4.TradeTransaction50__4Builder doEvaluate(MASTransactionReport drrReport) {
			TradeTransaction50__4.TradeTransaction50__4Builder txData = TradeTransaction50__4.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__4.TradeTransaction50__4Builder assignOutput(TradeTransaction50__4.TradeTransaction50__4Builder txData, MASTransactionReport drrReport) {
			txData = toBuilder(TradeTransaction50__4.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(getTxId.evaluate(drrReport))
					.setPrtry(GenericIdentification175__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", mASTransactionReport -> mASTransactionReport.getUniqueTransactionIdentifierProprietary()).get())
						.build())
					.build())
				.setExctnTmStmp(getExctnTmStmp.evaluate(drrReport))
				.setDerivEvt(getDerivEvt1.evaluate(drrReport))
				.setOthrPmt(new ArrayList(getOthrPmt.evaluate(drrReport)))
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
