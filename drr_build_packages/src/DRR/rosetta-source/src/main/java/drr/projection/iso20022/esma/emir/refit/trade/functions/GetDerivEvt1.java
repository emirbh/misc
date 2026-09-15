package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.DerivativeEvent6__1;
import iso20022.auth030.esma.EventIdentifier1Choice__1;
import iso20022.auth030.esma.PostTradeRiskReductionIdentifier1__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvt1.GetDerivEvt1Default.class)
public abstract class GetDerivEvt1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvtTmStmp getDerivEvtTmStmp;
	@Inject protected GetDerivEvtTp getDerivEvtTp;

	/**
	* @param drrReport 
	* @return derivEvt 
	*/
	public DerivativeEvent6__1 evaluate(ESMAEMIRTransactionReport drrReport) {
		DerivativeEvent6__1.DerivativeEvent6__1Builder derivEvtBuilder = doEvaluate(drrReport);
		
		final DerivativeEvent6__1 derivEvt;
		if (derivEvtBuilder == null) {
			derivEvt = null;
		} else {
			derivEvt = derivEvtBuilder.build();
			objectValidator.validate(DerivativeEvent6__1.class, derivEvt);
		}
		
		return derivEvt;
	}

	protected abstract DerivativeEvent6__1.DerivativeEvent6__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetDerivEvt1Default extends GetDerivEvt1 {
		@Override
		protected DerivativeEvent6__1.DerivativeEvent6__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			DerivativeEvent6__1.DerivativeEvent6__1Builder derivEvt = DerivativeEvent6__1.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__1.DerivativeEvent6__1Builder assignOutput(DerivativeEvent6__1.DerivativeEvent6__1Builder derivEvt, ESMAEMIRTransactionReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__1.builder()
				.setId(EventIdentifier1Choice__1.builder()
					.setPstTradRskRdctnIdr(PostTradeRiskReductionIdentifier1__1.builder()
						.setId(null)
						.setStrr(MapperS.of(drrReport).<String>map("getPtrrId", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPtrrId()).get())
						.build())
					.build())
				.setTp(getDerivEvtTp.evaluate(drrReport))
				.setTmStmp(getDerivEvtTmStmp.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
