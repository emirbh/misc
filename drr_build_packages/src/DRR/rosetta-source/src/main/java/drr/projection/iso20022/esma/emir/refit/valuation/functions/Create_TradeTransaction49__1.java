package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.TradeTransaction49__1;
import iso20022.auth030.esma.UniqueTransactionIdentifier2Choice__1;
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
	public TradeTransaction49__1 evaluate(ESMAValuationReport drrReport) {
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

	protected abstract TradeTransaction49__1.TradeTransaction49__1Builder doEvaluate(ESMAValuationReport drrReport);

	public static class Create_TradeTransaction49__1Default extends Create_TradeTransaction49__1 {
		@Override
		protected TradeTransaction49__1.TradeTransaction49__1Builder doEvaluate(ESMAValuationReport drrReport) {
			TradeTransaction49__1.TradeTransaction49__1Builder txData = TradeTransaction49__1.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction49__1.TradeTransaction49__1Builder assignOutput(TradeTransaction49__1.TradeTransaction49__1Builder txData, ESMAValuationReport drrReport) {
			txData = toBuilder(TradeTransaction49__1.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", eSMAValuationReport -> eSMAValuationReport.getUniqueTransactionIdentifier()).get())
					.build())
				.setDerivEvt(getDerivEvt1.evaluate(drrReport))
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
