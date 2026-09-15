package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import iso20022.auth030.fca.TradeTransaction49__7;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction49__7.Create_TradeTransaction49__7Default.class)
public abstract class Create_TradeTransaction49__7 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt3 getDerivEvt3;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction49__7 evaluate(FCAValuationReport drrReport) {
		TradeTransaction49__7.TradeTransaction49__7Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction49__7 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction49__7.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction49__7.TradeTransaction49__7Builder doEvaluate(FCAValuationReport drrReport);

	public static class Create_TradeTransaction49__7Default extends Create_TradeTransaction49__7 {
		@Override
		protected TradeTransaction49__7.TradeTransaction49__7Builder doEvaluate(FCAValuationReport drrReport) {
			TradeTransaction49__7.TradeTransaction49__7Builder txData = TradeTransaction49__7.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction49__7.TradeTransaction49__7Builder assignOutput(TradeTransaction49__7.TradeTransaction49__7Builder txData, FCAValuationReport drrReport) {
			txData = toBuilder(TradeTransaction49__7.builder()
				.setTxId(getTxId.evaluate(drrReport))
				.setDerivEvt(getDerivEvt3.evaluate(drrReport))
				.setCollPrtflCd(null)
				.setNtnlAmt(null)
				.setDlvryTp(null)
				.setExctnTmStmp(null)
				.setFctvDt(null)
				.setMstrAgrmt(null)
				.setTradClr(null)
				.setPltfmIdr(null)
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
