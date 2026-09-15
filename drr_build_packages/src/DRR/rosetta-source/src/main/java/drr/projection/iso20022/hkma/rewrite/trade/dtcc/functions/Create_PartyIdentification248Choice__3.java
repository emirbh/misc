package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import iso20022.auth030.hkma.dtcc.LegalPersonIdentification1__3;
import iso20022.auth030.hkma.dtcc.PartyIdentification248Choice__3;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_PartyIdentification248Choice__3.Create_PartyIdentification248Choice__3Default.class)
public abstract class Create_PartyIdentification248Choice__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__3 create_OrganisationIdentification15Choice__3;

	/**
	* @param idFormat 
	* @param idFromReport 
	* @param schemeName 
	* @return id 
	*/
	public PartyIdentification248Choice__3 evaluate(PartyIdentifierFormat2Enum idFormat, String idFromReport, HKTRPartyScheme schemeName) {
		PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder idBuilder = doEvaluate(idFormat, idFromReport, schemeName);
		
		final PartyIdentification248Choice__3 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(PartyIdentification248Choice__3.class, id);
		}
		
		return id;
	}

	protected abstract PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder doEvaluate(PartyIdentifierFormat2Enum idFormat, String idFromReport, HKTRPartyScheme schemeName);

	public static class Create_PartyIdentification248Choice__3Default extends Create_PartyIdentification248Choice__3 {
		@Override
		protected PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder doEvaluate(PartyIdentifierFormat2Enum idFormat, String idFromReport, HKTRPartyScheme schemeName) {
			PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder id = PartyIdentification248Choice__3.builder();
			return assignOutput(id, idFormat, idFromReport, schemeName);
		}
		
		protected PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder assignOutput(PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder id, PartyIdentifierFormat2Enum idFormat, String idFromReport, HKTRPartyScheme schemeName) {
			id = toBuilder(PartyIdentification248Choice__3.builder()
				.setLgl(LegalPersonIdentification1__3.builder()
					.setId(create_OrganisationIdentification15Choice__3.evaluate(idFormat, idFromReport, schemeName))
					.build())
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
