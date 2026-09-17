package cdm.ingest.fpml.confirmation.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.ReferenceWithMetaDate;
import fpml.consolidated.shared.DateReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateReference.MapDateReferenceDefault.class)
public abstract class MapDateReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDateReference 
	* @return dateReference 
	*/
	public ReferenceWithMetaDate evaluate(DateReference fpmlDateReference) {
		ReferenceWithMetaDate.ReferenceWithMetaDateBuilder dateReferenceBuilder = doEvaluate(fpmlDateReference);
		
		final ReferenceWithMetaDate dateReference;
		if (dateReferenceBuilder == null) {
			dateReference = null;
		} else {
			dateReference = dateReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaDate.class, dateReference);
		}
		
		return dateReference;
	}

	protected abstract ReferenceWithMetaDate.ReferenceWithMetaDateBuilder doEvaluate(DateReference fpmlDateReference);

	public static class MapDateReferenceDefault extends MapDateReference {
		@Override
		protected ReferenceWithMetaDate.ReferenceWithMetaDateBuilder doEvaluate(DateReference fpmlDateReference) {
			ReferenceWithMetaDate.ReferenceWithMetaDateBuilder dateReference = ReferenceWithMetaDate.builder();
			return assignOutput(dateReference, fpmlDateReference);
		}
		
		protected ReferenceWithMetaDate.ReferenceWithMetaDateBuilder assignOutput(ReferenceWithMetaDate.ReferenceWithMetaDateBuilder dateReference, DateReference fpmlDateReference) {
			dateReference = toBuilder(ReferenceWithMetaDate.builder().setValue(null).setExternalReference(MapperS.of(fpmlDateReference).<String>map("getHref", _dateReference -> _dateReference.getHref()).get()).build());
			
			return Optional.ofNullable(dateReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
