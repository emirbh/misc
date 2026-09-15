package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaNaturalPerson;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNaturalPersonRoleReference.MapNaturalPersonRoleReferenceDefault.class)
public abstract class MapNaturalPersonRoleReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param href 
	* @return personReference 
	*/
	public ReferenceWithMetaNaturalPerson evaluate(String href) {
		ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder personReferenceBuilder = doEvaluate(href);
		
		final ReferenceWithMetaNaturalPerson personReference;
		if (personReferenceBuilder == null) {
			personReference = null;
		} else {
			personReference = personReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaNaturalPerson.class, personReference);
		}
		
		return personReference;
	}

	protected abstract ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder doEvaluate(String href);

	public static class MapNaturalPersonRoleReferenceDefault extends MapNaturalPersonRoleReference {
		@Override
		protected ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder doEvaluate(String href) {
			ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder personReference = ReferenceWithMetaNaturalPerson.builder();
			return assignOutput(personReference, href);
		}
		
		protected ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder assignOutput(ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder personReference, String href) {
			if (exists(MapperS.of(href)).getOrDefault(false)) {
				personReference = toBuilder(ReferenceWithMetaNaturalPerson.builder().setValue(null).setExternalReference(href).build());
			} else {
				personReference = toBuilder(ReferenceWithMetaNaturalPerson.builder().build());
			}
			
			return Optional.ofNullable(personReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
