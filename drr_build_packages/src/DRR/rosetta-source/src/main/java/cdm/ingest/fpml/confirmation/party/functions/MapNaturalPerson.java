package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.NaturalPerson;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.Address;
import fpml.consolidated.shared.ContactInformation;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.Person;
import fpml.consolidated.shared.PersonId;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNaturalPerson.MapNaturalPersonDefault.class)
public abstract class MapNaturalPerson implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContactInformation mapContactInformation;
	@Inject protected MapPersonIdentifier mapPersonIdentifier;

	/**
	* @param fpmlPerson 
	* @return cdmNaturalPerson 
	*/
	public NaturalPerson evaluate(Person fpmlPerson) {
		NaturalPerson.NaturalPersonBuilder cdmNaturalPersonBuilder = doEvaluate(fpmlPerson);
		
		final NaturalPerson cdmNaturalPerson;
		if (cdmNaturalPersonBuilder == null) {
			cdmNaturalPerson = null;
		} else {
			cdmNaturalPerson = cdmNaturalPersonBuilder.build();
			objectValidator.validate(NaturalPerson.class, cdmNaturalPerson);
		}
		
		return cdmNaturalPerson;
	}

	protected abstract NaturalPerson.NaturalPersonBuilder doEvaluate(Person fpmlPerson);

	public static class MapNaturalPersonDefault extends MapNaturalPerson {
		@Override
		protected NaturalPerson.NaturalPersonBuilder doEvaluate(Person fpmlPerson) {
			NaturalPerson.NaturalPersonBuilder cdmNaturalPerson = NaturalPerson.builder();
			return assignOutput(cdmNaturalPerson, fpmlPerson);
		}
		
		protected NaturalPerson.NaturalPersonBuilder assignOutput(NaturalPerson.NaturalPersonBuilder cdmNaturalPerson, Person fpmlPerson) {
			final NaturalPerson.NaturalPersonBuilder withMetaArgument = NaturalPerson.builder()
				.setPersonId(MapperS.of(fpmlPerson).<PersonId>mapC("getPersonId", person -> person.getPersonId())
					.mapItem(item -> MapperS.of(mapPersonIdentifier.evaluate(item.get(), MapperS.of(fpmlPerson).<ContactInformation>map("getContactInfo", person -> person.getContactInfo()).<Address>map("getAddress", contactInformation -> contactInformation.getAddress()).<CountryCode>map("getCountry", address -> address.getCountry()).get()))).getMulti())
				.setHonorific(MapperS.of(fpmlPerson).<String>map("getHonorific", person -> person.getHonorific()).get())
				.setFirstName(MapperS.of(fpmlPerson).<String>map("getFirstName", person -> person.getFirstName()).get())
				.setMiddleName(MapperS.of(fpmlPerson).<String>mapC("getMiddleName", person -> person.getMiddleName()).getMulti())
				.setInitial(MapperS.of(fpmlPerson).<String>mapC("getInitial", person -> person.getInitial()).getMulti())
				.setSurname(MapperS.of(fpmlPerson).<String>map("getSurname", person -> person.getSurname()).get())
				.setSuffix(MapperS.of(fpmlPerson).<String>map("getSuffix", person -> person.getSuffix()).get())
				.setDateOfBirth(MapperS.of(fpmlPerson).<ZonedDateTime>map("getDateOfBirth", person -> person.getDateOfBirth()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setContactInformation(mapContactInformation.evaluate(MapperS.of(fpmlPerson).<CountryCode>map("getCountry", person -> person.getCountry()).get(), MapperS.of(fpmlPerson).<ContactInformation>map("getContactInfo", person -> person.getContactInfo()).get()))
				.build() == null ? null : NaturalPerson.builder()
				.setPersonId(MapperS.of(fpmlPerson).<PersonId>mapC("getPersonId", person -> person.getPersonId())
					.mapItem(item -> MapperS.of(mapPersonIdentifier.evaluate(item.get(), MapperS.of(fpmlPerson).<ContactInformation>map("getContactInfo", person -> person.getContactInfo()).<Address>map("getAddress", contactInformation -> contactInformation.getAddress()).<CountryCode>map("getCountry", address -> address.getCountry()).get()))).getMulti())
				.setHonorific(MapperS.of(fpmlPerson).<String>map("getHonorific", person -> person.getHonorific()).get())
				.setFirstName(MapperS.of(fpmlPerson).<String>map("getFirstName", person -> person.getFirstName()).get())
				.setMiddleName(MapperS.of(fpmlPerson).<String>mapC("getMiddleName", person -> person.getMiddleName()).getMulti())
				.setInitial(MapperS.of(fpmlPerson).<String>mapC("getInitial", person -> person.getInitial()).getMulti())
				.setSurname(MapperS.of(fpmlPerson).<String>map("getSurname", person -> person.getSurname()).get())
				.setSuffix(MapperS.of(fpmlPerson).<String>map("getSuffix", person -> person.getSuffix()).get())
				.setDateOfBirth(MapperS.of(fpmlPerson).<ZonedDateTime>map("getDateOfBirth", person -> person.getDateOfBirth()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setContactInformation(mapContactInformation.evaluate(MapperS.of(fpmlPerson).<CountryCode>map("getCountry", person -> person.getCountry()).get(), MapperS.of(fpmlPerson).<ContactInformation>map("getContactInfo", person -> person.getContactInfo()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlPerson).<String>map("getId", person -> person.getId()).get());
			cdmNaturalPerson = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(cdmNaturalPerson)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
