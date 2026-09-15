package drr.projection.iso20022.mas.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import iso20022.auth030.mas.OrganisationIdentification15Choice__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_OrganisationIdentification15Choice__2.Create_OrganisationIdentification15Choice__2Default.class)
public abstract class Create_OrganisationIdentification15Choice__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param lei 
	* @return id 
	*/
	public OrganisationIdentification15Choice__2 evaluate(String lei) {
		OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder idBuilder = doEvaluate(lei);
		
		final OrganisationIdentification15Choice__2 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__2.class, id);
		}
		
		return id;
	}

	protected abstract OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder doEvaluate(String lei);

	public static class Create_OrganisationIdentification15Choice__2Default extends Create_OrganisationIdentification15Choice__2 {
		@Override
		protected OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder doEvaluate(String lei) {
			OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder id = OrganisationIdentification15Choice__2.builder();
			return assignOutput(id, lei);
		}
		
		protected OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder assignOutput(OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder id, String lei) {
			id = toBuilder(OrganisationIdentification15Choice__2.builder()
				.setLei(lei)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
