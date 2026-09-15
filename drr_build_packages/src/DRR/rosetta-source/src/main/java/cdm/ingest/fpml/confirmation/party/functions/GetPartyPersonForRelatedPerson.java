package cdm.ingest.fpml.confirmation.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.Person;
import fpml.consolidated.shared.PersonReference;
import fpml.consolidated.shared.RelatedPerson;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetPartyPersonForRelatedPerson.GetPartyPersonForRelatedPersonDefault.class)
public abstract class GetPartyPersonForRelatedPerson implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlParty 
	* @param fpmlRelatedPerson 
	* @return fpmlPerson 
	*/
	public Person evaluate(Party fpmlParty, RelatedPerson fpmlRelatedPerson) {
		Person.PersonBuilder fpmlPersonBuilder = doEvaluate(fpmlParty, fpmlRelatedPerson);
		
		final Person fpmlPerson;
		if (fpmlPersonBuilder == null) {
			fpmlPerson = null;
		} else {
			fpmlPerson = fpmlPersonBuilder.build();
			objectValidator.validate(Person.class, fpmlPerson);
		}
		
		return fpmlPerson;
	}

	protected abstract Person.PersonBuilder doEvaluate(Party fpmlParty, RelatedPerson fpmlRelatedPerson);

	public static class GetPartyPersonForRelatedPersonDefault extends GetPartyPersonForRelatedPerson {
		@Override
		protected Person.PersonBuilder doEvaluate(Party fpmlParty, RelatedPerson fpmlRelatedPerson) {
			Person.PersonBuilder fpmlPerson = Person.builder();
			return assignOutput(fpmlPerson, fpmlParty, fpmlRelatedPerson);
		}
		
		protected Person.PersonBuilder assignOutput(Person.PersonBuilder fpmlPerson, Party fpmlParty, RelatedPerson fpmlRelatedPerson) {
			final MapperC<Person> thenArg = MapperS.of(fpmlParty).<Person>mapC("getPerson", party -> party.getPerson())
				.filterItemNullSafe(item -> areEqual(item.<String>map("getId", person -> person.getId()), MapperS.of(fpmlRelatedPerson).<PersonReference>map("getPersonReference", relatedPerson -> relatedPerson.getPersonReference()).<String>map("getHref", personReference -> personReference.getHref()), CardinalityOperator.All).get());
			fpmlPerson = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(fpmlPerson)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
