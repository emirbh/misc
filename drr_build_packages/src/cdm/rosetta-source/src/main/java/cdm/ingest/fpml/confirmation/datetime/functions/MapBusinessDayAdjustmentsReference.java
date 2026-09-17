package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.metafields.ReferenceWithMetaBusinessDayAdjustments;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessDayAdjustmentsReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessDayAdjustmentsReference.MapBusinessDayAdjustmentsReferenceDefault.class)
public abstract class MapBusinessDayAdjustmentsReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlBusinessDateAdjustments 
	* @return businessDayAdjustments 
	*/
	public ReferenceWithMetaBusinessDayAdjustments evaluate(BusinessDayAdjustmentsReference fpmlBusinessDateAdjustments) {
		ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder businessDayAdjustmentsBuilder = doEvaluate(fpmlBusinessDateAdjustments);
		
		final ReferenceWithMetaBusinessDayAdjustments businessDayAdjustments;
		if (businessDayAdjustmentsBuilder == null) {
			businessDayAdjustments = null;
		} else {
			businessDayAdjustments = businessDayAdjustmentsBuilder.build();
			objectValidator.validate(ReferenceWithMetaBusinessDayAdjustments.class, businessDayAdjustments);
		}
		
		return businessDayAdjustments;
	}

	protected abstract ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder doEvaluate(BusinessDayAdjustmentsReference fpmlBusinessDateAdjustments);

	public static class MapBusinessDayAdjustmentsReferenceDefault extends MapBusinessDayAdjustmentsReference {
		@Override
		protected ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder doEvaluate(BusinessDayAdjustmentsReference fpmlBusinessDateAdjustments) {
			ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder businessDayAdjustments = ReferenceWithMetaBusinessDayAdjustments.builder();
			return assignOutput(businessDayAdjustments, fpmlBusinessDateAdjustments);
		}
		
		protected ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder assignOutput(ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder businessDayAdjustments, BusinessDayAdjustmentsReference fpmlBusinessDateAdjustments) {
			businessDayAdjustments = toBuilder(ReferenceWithMetaBusinessDayAdjustments.builder().setValue(null).setExternalReference(MapperS.of(fpmlBusinessDateAdjustments).<String>map("getHref", businessDayAdjustmentsReference -> businessDayAdjustmentsReference.getHref()).get()).build());
			
			return Optional.ofNullable(businessDayAdjustments)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
