package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessCentersReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessCenterReference.MapBusinessCenterReferenceDefault.class)
public abstract class MapBusinessCenterReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlBusinessCentersReference 
	* @return businessCentersReference 
	*/
	public ReferenceWithMetaBusinessCenters evaluate(BusinessCentersReference fpmlBusinessCentersReference) {
		ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder businessCentersReferenceBuilder = doEvaluate(fpmlBusinessCentersReference);
		
		final ReferenceWithMetaBusinessCenters businessCentersReference;
		if (businessCentersReferenceBuilder == null) {
			businessCentersReference = null;
		} else {
			businessCentersReference = businessCentersReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaBusinessCenters.class, businessCentersReference);
		}
		
		return businessCentersReference;
	}

	protected abstract ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder doEvaluate(BusinessCentersReference fpmlBusinessCentersReference);

	public static class MapBusinessCenterReferenceDefault extends MapBusinessCenterReference {
		@Override
		protected ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder doEvaluate(BusinessCentersReference fpmlBusinessCentersReference) {
			ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder businessCentersReference = ReferenceWithMetaBusinessCenters.builder();
			return assignOutput(businessCentersReference, fpmlBusinessCentersReference);
		}
		
		protected ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder assignOutput(ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder businessCentersReference, BusinessCentersReference fpmlBusinessCentersReference) {
			businessCentersReference = toBuilder(ReferenceWithMetaBusinessCenters.builder().setValue(null).setExternalReference(MapperS.of(fpmlBusinessCentersReference).<String>map("getHref", _businessCentersReference -> _businessCentersReference.getHref()).get()).build());
			
			return Optional.ofNullable(businessCentersReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
