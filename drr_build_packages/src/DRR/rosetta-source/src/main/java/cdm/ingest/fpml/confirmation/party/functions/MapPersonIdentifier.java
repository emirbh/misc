package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.PersonIdentifier;
import cdm.base.staticdata.party.metafields.FieldWithMetaPersonIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.PersonId;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPersonIdentifier.MapPersonIdentifierDefault.class)
public abstract class MapPersonIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlPersonId 
	* @param fpmlCountryCode 
	* @return cdmPersonIdentifier 
	*/
	public FieldWithMetaPersonIdentifier evaluate(PersonId fpmlPersonId, CountryCode fpmlCountryCode) {
		FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder cdmPersonIdentifierBuilder = doEvaluate(fpmlPersonId, fpmlCountryCode);
		
		final FieldWithMetaPersonIdentifier cdmPersonIdentifier;
		if (cdmPersonIdentifierBuilder == null) {
			cdmPersonIdentifier = null;
		} else {
			cdmPersonIdentifier = cdmPersonIdentifierBuilder.build();
			objectValidator.validate(FieldWithMetaPersonIdentifier.class, cdmPersonIdentifier);
		}
		
		return cdmPersonIdentifier;
	}

	protected abstract FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder doEvaluate(PersonId fpmlPersonId, CountryCode fpmlCountryCode);

	public static class MapPersonIdentifierDefault extends MapPersonIdentifier {
		@Override
		protected FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder doEvaluate(PersonId fpmlPersonId, CountryCode fpmlCountryCode) {
			FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder cdmPersonIdentifier = FieldWithMetaPersonIdentifier.builder();
			return assignOutput(cdmPersonIdentifier, fpmlPersonId, fpmlCountryCode);
		}
		
		protected FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder assignOutput(FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder cdmPersonIdentifier, PersonId fpmlPersonId, CountryCode fpmlCountryCode) {
			final PersonIdentifier personIdentifier = PersonIdentifier.builder()
				.setIdentifier(mapStringWithScheme.evaluate(MapperS.of(fpmlPersonId).<String>map("getValue", personId -> personId.getValue()).get(), MapperS.of(fpmlPersonId).<String>map("getPersonIdScheme", personId -> personId.getPersonIdScheme()).get()))
				.setCountry(mapStringWithScheme.evaluate(MapperS.of(fpmlCountryCode).<String>map("getValue", countryCode -> countryCode.getValue()).get(), MapperS.of(fpmlCountryCode).<String>map("getCountryScheme", countryCode -> countryCode.getCountryScheme()).get()))
				.build();
			if (personIdentifier == null) {
				cdmPersonIdentifier = toBuilder(FieldWithMetaPersonIdentifier.builder().build());
			} else {
				cdmPersonIdentifier = toBuilder(FieldWithMetaPersonIdentifier.builder().setValue(personIdentifier).build());
			}
			
			return Optional.ofNullable(cdmPersonIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
