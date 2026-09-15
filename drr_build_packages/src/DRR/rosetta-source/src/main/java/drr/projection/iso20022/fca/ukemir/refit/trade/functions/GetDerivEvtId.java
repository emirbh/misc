package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.string.functions.SubString;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.EventIdentifier1Choice__1;
import iso20022.auth030.fca.PostTradeRiskReductionIdentifier1__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvtId.GetDerivEvtIdDefault.class)
public abstract class GetDerivEvtId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return id 
	*/
	public EventIdentifier1Choice__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder idBuilder = doEvaluate(drrReport);
		
		final EventIdentifier1Choice__1 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(EventIdentifier1Choice__1.class, id);
		}
		
		return id;
	}

	protected abstract EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetDerivEvtIdDefault extends GetDerivEvtId {
		@Override
		protected EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder id = EventIdentifier1Choice__1.builder();
			return assignOutput(id, drrReport);
		}
		
		protected EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder assignOutput(EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder id, FCAUKEMIRTransactionReport drrReport) {
			id = toBuilder(EventIdentifier1Choice__1.builder()
				.setPstTradRskRdctnIdr(PostTradeRiskReductionIdentifier1__1.builder()
					.setStrr(subString.evaluate(MapperS.of(drrReport).<String>map("getPtrrId", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPtrrId()).get(), 1, 20))
					.setId(subString.evaluate(MapperS.of(drrReport).<String>map("getPtrrId", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPtrrId()).get(), 21, 32))
					.build())
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
