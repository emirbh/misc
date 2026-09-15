package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Address;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.StreetAddress;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAddress.MapAddressDefault.class)
public abstract class MapAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlAddress 
	* @return cdmAddress 
	*/
	public Address evaluate(fpml.consolidated.shared.Address fpmlAddress) {
		Address.AddressBuilder cdmAddressBuilder = doEvaluate(fpmlAddress);
		
		final Address cdmAddress;
		if (cdmAddressBuilder == null) {
			cdmAddress = null;
		} else {
			cdmAddress = cdmAddressBuilder.build();
			objectValidator.validate(Address.class, cdmAddress);
		}
		
		return cdmAddress;
	}

	protected abstract Address.AddressBuilder doEvaluate(fpml.consolidated.shared.Address fpmlAddress);

	public static class MapAddressDefault extends MapAddress {
		@Override
		protected Address.AddressBuilder doEvaluate(fpml.consolidated.shared.Address fpmlAddress) {
			Address.AddressBuilder cdmAddress = Address.builder();
			return assignOutput(cdmAddress, fpmlAddress);
		}
		
		protected Address.AddressBuilder assignOutput(Address.AddressBuilder cdmAddress, fpml.consolidated.shared.Address fpmlAddress) {
			cdmAddress = toBuilder(Address.builder()
				.setStreet(MapperS.of(fpmlAddress).<StreetAddress>map("getStreetAddress", address -> address.getStreetAddress()).<String>mapC("getStreetLine", streetAddress -> streetAddress.getStreetLine()).getMulti())
				.setCity(MapperS.of(fpmlAddress).<String>map("getCity", address -> address.getCity()).get())
				.setState(MapperS.of(fpmlAddress).<String>map("getState", address -> address.getState()).get())
				.setCountry(mapStringWithScheme.evaluate(MapperS.of(fpmlAddress).<CountryCode>map("getCountry", address -> address.getCountry()).<String>map("getValue", countryCode -> countryCode.getValue()).get(), MapperS.of(fpmlAddress).<CountryCode>map("getCountry", address -> address.getCountry()).<String>map("getCountryScheme", countryCode -> countryCode.getCountryScheme()).get()))
				.setPostalCode(MapperS.of(fpmlAddress).<String>map("getPostalCode", address -> address.getPostalCode()).get())
				.build());
			
			return Optional.ofNullable(cdmAddress)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
