package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import iso20022.auth030.fca.TradeTransaction49__5;
import iso20022.auth030.fca.UniqueTransactionIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction49__5.Create_TradeTransaction49__5Default.class)
public abstract class Create_TradeTransaction49__5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt5 getDerivEvt5;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction49__5 evaluate(FCAValuationReport drrReport) {
		TradeTransaction49__5.TradeTransaction49__5Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction49__5 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction49__5.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction49__5.TradeTransaction49__5Builder doEvaluate(FCAValuationReport drrReport);

	public static class Create_TradeTransaction49__5Default extends Create_TradeTransaction49__5 {
		@Override
		protected TradeTransaction49__5.TradeTransaction49__5Builder doEvaluate(FCAValuationReport drrReport) {
			TradeTransaction49__5.TradeTransaction49__5Builder txData = TradeTransaction49__5.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction49__5.TradeTransaction49__5Builder assignOutput(TradeTransaction49__5.TradeTransaction49__5Builder txData, FCAValuationReport drrReport) {
			txData = toBuilder(TradeTransaction49__5.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", fCAValuationReport -> fCAValuationReport.getUniqueTransactionIdentifier()).get())
					.build())
				.setDerivEvt(getDerivEvt5.evaluate(drrReport))
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
