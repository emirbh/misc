package drr.projection.iso20022.hkma.rewrite.valuation.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_OrganisationIdentification15Choice__1.Create_OrganisationIdentification15Choice__1Default.class)
public abstract class Create_OrganisationIdentification15Choice__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param lei 
	* @return id 
	*/
	public OrganisationIdentification15Choice__1 evaluate(String lei) {
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder idBuilder = doEvaluate(lei);
		
		final OrganisationIdentification15Choice__1 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__1.class, id);
		}
		
		return id;
	}

	protected abstract OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder doEvaluate(String lei);

	public static class Create_OrganisationIdentification15Choice__1Default extends Create_OrganisationIdentification15Choice__1 {
		@Override
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder doEvaluate(String lei) {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder id = OrganisationIdentification15Choice__1.builder();
			return assignOutput(id, lei);
		}
		
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder assignOutput(OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder id, String lei) {
			id = toBuilder(OrganisationIdentification15Choice__1.builder()
				.setLei(lei)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
