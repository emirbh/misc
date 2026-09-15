package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PersonReference;
import fpml.consolidated.shared.PersonRole;
import fpml.consolidated.shared.RelatedPerson;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRelatedPersonToNaturalPersonRole.MapRelatedPersonToNaturalPersonRoleDefault.class)
public abstract class MapRelatedPersonToNaturalPersonRole implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNaturalPersonRoleReference mapNaturalPersonRoleReference;

	/**
	* @param fpmlRelatedPerson 
	* @return naturalPersonRole 
	*/
	public NaturalPersonRole evaluate(RelatedPerson fpmlRelatedPerson) {
		NaturalPersonRole.NaturalPersonRoleBuilder naturalPersonRoleBuilder = doEvaluate(fpmlRelatedPerson);
		
		final NaturalPersonRole naturalPersonRole;
		if (naturalPersonRoleBuilder == null) {
			naturalPersonRole = null;
		} else {
			naturalPersonRole = naturalPersonRoleBuilder.build();
			objectValidator.validate(NaturalPersonRole.class, naturalPersonRole);
		}
		
		return naturalPersonRole;
	}

	protected abstract NaturalPersonRole.NaturalPersonRoleBuilder doEvaluate(RelatedPerson fpmlRelatedPerson);

	public static class MapRelatedPersonToNaturalPersonRoleDefault extends MapRelatedPersonToNaturalPersonRole {
		@Override
		protected NaturalPersonRole.NaturalPersonRoleBuilder doEvaluate(RelatedPerson fpmlRelatedPerson) {
			NaturalPersonRole.NaturalPersonRoleBuilder naturalPersonRole = NaturalPersonRole.builder();
			return assignOutput(naturalPersonRole, fpmlRelatedPerson);
		}
		
		protected NaturalPersonRole.NaturalPersonRoleBuilder assignOutput(NaturalPersonRole.NaturalPersonRoleBuilder naturalPersonRole, RelatedPerson fpmlRelatedPerson) {
			naturalPersonRole = toBuilder(NaturalPersonRole.builder()
				.setPersonReference(mapNaturalPersonRoleReference.evaluate(MapperS.of(fpmlRelatedPerson).<PersonReference>map("getPersonReference", relatedPerson -> relatedPerson.getPersonReference()).<String>map("getHref", personReference -> personReference.getHref()).get()))
				.setRoleValue(MapperC.<NaturalPersonRoleEnum>of(MapperS.of(fpmlRelatedPerson).<PersonRole>map("getRole", relatedPerson -> relatedPerson.getRole()).<String>map("getValue", personRole -> personRole.getValue()).checkedMap("to-enum", NaturalPersonRoleEnum::fromDisplayName, IllegalArgumentException.class)).getMulti())
				.build());
			
			return Optional.ofNullable(naturalPersonRole)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
