package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import iso20022.auth030.fca.TradeTransaction49__1;
import iso20022.auth030.fca.UniqueTransactionIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction49__1.Create_TradeTransaction49__1Default.class)
public abstract class Create_TradeTransaction49__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt1 getDerivEvt1;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction49__1 evaluate(FCAValuationReport drrReport) {
		TradeTransaction49__1.TradeTransaction49__1Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction49__1 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction49__1.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction49__1.TradeTransaction49__1Builder doEvaluate(FCAValuationReport drrReport);

	public static class Create_TradeTransaction49__1Default extends Create_TradeTransaction49__1 {
		@Override
		protected TradeTransaction49__1.TradeTransaction49__1Builder doEvaluate(FCAValuationReport drrReport) {
			TradeTransaction49__1.TradeTransaction49__1Builder txData = TradeTransaction49__1.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction49__1.TradeTransaction49__1Builder assignOutput(TradeTransaction49__1.TradeTransaction49__1Builder txData, FCAValuationReport drrReport) {
			txData = toBuilder(TradeTransaction49__1.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", fCAValuationReport -> fCAValuationReport.getUniqueTransactionIdentifier()).get())
					.build())
				.setDerivEvt(getDerivEvt1.evaluate(drrReport))
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
