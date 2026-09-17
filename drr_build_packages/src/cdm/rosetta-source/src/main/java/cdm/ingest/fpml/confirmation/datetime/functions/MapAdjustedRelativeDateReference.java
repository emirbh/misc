package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.metafields.ReferenceWithMetaAdjustableOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.DateReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustedRelativeDateReference.MapAdjustedRelativeDateReferenceDefault.class)
public abstract class MapAdjustedRelativeDateReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDateReference 
	* @return adjustableOrRelativeDate 
	*/
	public ReferenceWithMetaAdjustableOrRelativeDate evaluate(DateReference fpmlDateReference) {
		ReferenceWithMetaAdjustableOrRelativeDate.ReferenceWithMetaAdjustableOrRelativeDateBuilder adjustableOrRelativeDateBuilder = doEvaluate(fpmlDateReference);
		
		final ReferenceWithMetaAdjustableOrRelativeDate adjustableOrRelativeDate;
		if (adjustableOrRelativeDateBuilder == null) {
			adjustableOrRelativeDate = null;
		} else {
			adjustableOrRelativeDate = adjustableOrRelativeDateBuilder.build();
			objectValidator.validate(ReferenceWithMetaAdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		}
		
		return adjustableOrRelativeDate;
	}

	protected abstract ReferenceWithMetaAdjustableOrRelativeDate.ReferenceWithMetaAdjustableOrRelativeDateBuilder doEvaluate(DateReference fpmlDateReference);

	public static class MapAdjustedRelativeDateReferenceDefault extends MapAdjustedRelativeDateReference {
		@Override
		protected ReferenceWithMetaAdjustableOrRelativeDate.ReferenceWithMetaAdjustableOrRelativeDateBuilder doEvaluate(DateReference fpmlDateReference) {
			ReferenceWithMetaAdjustableOrRelativeDate.ReferenceWithMetaAdjustableOrRelativeDateBuilder adjustableOrRelativeDate = ReferenceWithMetaAdjustableOrRelativeDate.builder();
			return assignOutput(adjustableOrRelativeDate, fpmlDateReference);
		}
		
		protected ReferenceWithMetaAdjustableOrRelativeDate.ReferenceWithMetaAdjustableOrRelativeDateBuilder assignOutput(ReferenceWithMetaAdjustableOrRelativeDate.ReferenceWithMetaAdjustableOrRelativeDateBuilder adjustableOrRelativeDate, DateReference fpmlDateReference) {
			adjustableOrRelativeDate = toBuilder(ReferenceWithMetaAdjustableOrRelativeDate.builder().setValue(null).setExternalReference(MapperS.of(fpmlDateReference).<String>map("getHref", dateReference -> dateReference.getHref()).get()).build());
			
			return Optional.ofNullable(adjustableOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
