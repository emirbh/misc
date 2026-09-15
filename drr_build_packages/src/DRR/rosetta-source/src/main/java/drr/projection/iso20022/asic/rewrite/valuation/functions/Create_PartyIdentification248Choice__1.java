package drr.projection.iso20022.asic.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import iso20022.auth030.asic.LegalPersonIdentification1__1;
import iso20022.auth030.asic.PartyIdentification248Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_PartyIdentification248Choice__1.Create_PartyIdentification248Choice__1Default.class)
public abstract class Create_PartyIdentification248Choice__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__1 create_OrganisationIdentification15Choice__1;

	/**
	* @param lei 
	* @return id 
	*/
	public PartyIdentification248Choice__1 evaluate(String lei) {
		PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder idBuilder = doEvaluate(lei);
		
		final PartyIdentification248Choice__1 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(PartyIdentification248Choice__1.class, id);
		}
		
		return id;
	}

	protected abstract PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder doEvaluate(String lei);

	public static class Create_PartyIdentification248Choice__1Default extends Create_PartyIdentification248Choice__1 {
		@Override
		protected PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder doEvaluate(String lei) {
			PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder id = PartyIdentification248Choice__1.builder();
			return assignOutput(id, lei);
		}
		
		protected PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder assignOutput(PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder id, String lei) {
			id = toBuilder(PartyIdentification248Choice__1.builder()
				.setLgl(LegalPersonIdentification1__1.builder()
					.setId(create_OrganisationIdentification15Choice__1.evaluate(lei))
					.build())
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
