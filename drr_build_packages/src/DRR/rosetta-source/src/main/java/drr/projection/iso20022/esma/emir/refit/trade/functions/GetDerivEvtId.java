package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.EventIdentifier1Choice__2;
import iso20022.auth030.esma.PostTradeRiskReductionIdentifier1__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvtId.GetDerivEvtIdDefault.class)
public abstract class GetDerivEvtId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return id 
	*/
	public EventIdentifier1Choice__2 evaluate(ESMAEMIRTransactionReport drrReport) {
		EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder idBuilder = doEvaluate(drrReport);
		
		final EventIdentifier1Choice__2 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(EventIdentifier1Choice__2.class, id);
		}
		
		return id;
	}

	protected abstract EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetDerivEvtIdDefault extends GetDerivEvtId {
		@Override
		protected EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder id = EventIdentifier1Choice__2.builder();
			return assignOutput(id, drrReport);
		}
		
		protected EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder assignOutput(EventIdentifier1Choice__2.EventIdentifier1Choice__2Builder id, ESMAEMIRTransactionReport drrReport) {
			id = toBuilder(EventIdentifier1Choice__2.builder()
				.setPstTradRskRdctnIdr(PostTradeRiskReductionIdentifier1__2.builder()
					.setId(null)
					.setStrr(MapperS.of(drrReport).<String>map("getPtrrId", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPtrrId()).get())
					.build())
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
