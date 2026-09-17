package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Address;
import cdm.base.staticdata.party.ContactInformation;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.CountryCode;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCountryToContactInformation.MapCountryToContactInformationDefault.class)
public abstract class MapCountryToContactInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlCountry 
	* @return cdmContactInformation 
	*/
	public ContactInformation evaluate(CountryCode fpmlCountry) {
		ContactInformation.ContactInformationBuilder cdmContactInformationBuilder = doEvaluate(fpmlCountry);
		
		final ContactInformation cdmContactInformation;
		if (cdmContactInformationBuilder == null) {
			cdmContactInformation = null;
		} else {
			cdmContactInformation = cdmContactInformationBuilder.build();
			objectValidator.validate(ContactInformation.class, cdmContactInformation);
		}
		
		return cdmContactInformation;
	}

	protected abstract ContactInformation.ContactInformationBuilder doEvaluate(CountryCode fpmlCountry);

	public static class MapCountryToContactInformationDefault extends MapCountryToContactInformation {
		@Override
		protected ContactInformation.ContactInformationBuilder doEvaluate(CountryCode fpmlCountry) {
			ContactInformation.ContactInformationBuilder cdmContactInformation = ContactInformation.builder();
			return assignOutput(cdmContactInformation, fpmlCountry);
		}
		
		protected ContactInformation.ContactInformationBuilder assignOutput(ContactInformation.ContactInformationBuilder cdmContactInformation, CountryCode fpmlCountry) {
			final Address address = Address.builder()
				.setCountry(mapStringWithScheme.evaluate(MapperS.of(fpmlCountry).<String>map("getValue", countryCode -> countryCode.getValue()).get(), MapperS.of(fpmlCountry).<String>map("getCountryScheme", countryCode -> countryCode.getCountryScheme()).get()))
				.setStreet(Collections.<String>emptyList())
				.build();
			cdmContactInformation = toBuilder(ContactInformation.builder()
				.setAddress((address == null ? Collections.<Address>emptyList() : Collections.singletonList(address)))
				.build());
			
			return Optional.ofNullable(cdmContactInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
