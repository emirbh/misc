package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.SecurityIdentification46__1;
import iso20022.auth030.jfsa.UniqueProductIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetPdctId.GetPdctIdDefault.class)
public abstract class GetPdctId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return pdctId 
	*/
	public SecurityIdentification46__1 evaluate(JFSATransactionReport drrReport) {
		SecurityIdentification46__1.SecurityIdentification46__1Builder pdctIdBuilder = doEvaluate(drrReport);
		
		final SecurityIdentification46__1 pdctId;
		if (pdctIdBuilder == null) {
			pdctId = null;
		} else {
			pdctId = pdctIdBuilder.build();
			objectValidator.validate(SecurityIdentification46__1.class, pdctId);
		}
		
		return pdctId;
	}

	protected abstract SecurityIdentification46__1.SecurityIdentification46__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetPdctIdDefault extends GetPdctId {
		@Override
		protected SecurityIdentification46__1.SecurityIdentification46__1Builder doEvaluate(JFSATransactionReport drrReport) {
			SecurityIdentification46__1.SecurityIdentification46__1Builder pdctId = SecurityIdentification46__1.builder();
			return assignOutput(pdctId, drrReport);
		}
		
		protected SecurityIdentification46__1.SecurityIdentification46__1Builder assignOutput(SecurityIdentification46__1.SecurityIdentification46__1Builder pdctId, JFSATransactionReport drrReport) {
			pdctId = toBuilder(SecurityIdentification46__1.builder()
				.setUnqPdctIdr(UniqueProductIdentifier2Choice__1.builder()
					.setId(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", jFSATransactionReport -> jFSATransactionReport.getUniqueProductIdentifier()).get())
					.build())
				.build());
			
			return Optional.ofNullable(pdctId)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
