package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.EventIdentifier1Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvtId.GetDerivEvtIdDefault.class)
public abstract class GetDerivEvtId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return id 
	*/
	public EventIdentifier1Choice__1 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetDerivEvtIdDefault extends GetDerivEvtId {
		@Override
		protected EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder doEvaluate(ASICTransactionReport drrReport) {
			EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder id = EventIdentifier1Choice__1.builder();
			return assignOutput(id, drrReport);
		}
		
		protected EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder assignOutput(EventIdentifier1Choice__1.EventIdentifier1Choice__1Builder id, ASICTransactionReport drrReport) {
			id = toBuilder(EventIdentifier1Choice__1.builder()
				.setEvtIdr(MapperS.of(drrReport).<String>map("getEventIdentifier", aSICTransactionReport -> aSICTransactionReport.getEventIdentifier()).get())
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
