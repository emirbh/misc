package drr.projection.iso20022.hkma.rewrite.valuation.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import iso20022.auth030.hkma.tr.GenericIdentification175__3;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__4;
import iso20022.auth030.hkma.tr.OrganisationIdentification38__3;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_OrganisationIdentification15Choice__4.Create_OrganisationIdentification15Choice__4Default.class)
public abstract class Create_OrganisationIdentification15Choice__4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param lei 
	* @return id 
	*/
	public OrganisationIdentification15Choice__4 evaluate(String lei) {
		OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder idBuilder = doEvaluate(lei);
		
		final OrganisationIdentification15Choice__4 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__4.class, id);
		}
		
		return id;
	}

	protected abstract OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder doEvaluate(String lei);

	public static class Create_OrganisationIdentification15Choice__4Default extends Create_OrganisationIdentification15Choice__4 {
		@Override
		protected OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder doEvaluate(String lei) {
			OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder id = OrganisationIdentification15Choice__4.builder();
			return assignOutput(id, lei);
		}
		
		protected OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder assignOutput(OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder id, String lei) {
			id = toBuilder(OrganisationIdentification15Choice__4.builder()
				.setLei(lei)
				.setOthr(OrganisationIdentification38__3.builder()
					.setId(GenericIdentification175__3.builder()
						.setId(null)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
