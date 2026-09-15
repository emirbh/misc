package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessDayAdjustments;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustedRelativeDateOffset.MapAdjustedRelativeDateOffsetDefault.class)
public abstract class MapAdjustedRelativeDateOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapRelativeDateOffsetToAdjustedRelativeDateOffset mapRelativeDateOffsetToAdjustedRelativeDateOffset;

	/**
	* @param fpmlRelativeDate 
	* @return adjustedRelativeDateOffset 
	*/
	public AdjustedRelativeDateOffset evaluate(fpml.consolidated.shared.AdjustedRelativeDateOffset fpmlRelativeDate) {
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffsetBuilder = doEvaluate(fpmlRelativeDate);
		
		final AdjustedRelativeDateOffset adjustedRelativeDateOffset;
		if (adjustedRelativeDateOffsetBuilder == null) {
			adjustedRelativeDateOffset = null;
		} else {
			adjustedRelativeDateOffset = adjustedRelativeDateOffsetBuilder.build();
			objectValidator.validate(AdjustedRelativeDateOffset.class, adjustedRelativeDateOffset);
		}
		
		return adjustedRelativeDateOffset;
	}

	protected abstract AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder doEvaluate(fpml.consolidated.shared.AdjustedRelativeDateOffset fpmlRelativeDate);

	public static class MapAdjustedRelativeDateOffsetDefault extends MapAdjustedRelativeDateOffset {
		@Override
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder doEvaluate(fpml.consolidated.shared.AdjustedRelativeDateOffset fpmlRelativeDate) {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffset = AdjustedRelativeDateOffset.builder();
			return assignOutput(adjustedRelativeDateOffset, fpmlRelativeDate);
		}
		
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder assignOutput(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffset, fpml.consolidated.shared.AdjustedRelativeDateOffset fpmlRelativeDate) {
			adjustedRelativeDateOffset = toBuilder(mapRelativeDateOffsetToAdjustedRelativeDateOffset.evaluate(fpmlRelativeDate), () -> AdjustedRelativeDateOffset.builder());
			
			adjustedRelativeDateOffset
				.setRelativeDateAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlRelativeDate).<BusinessDayAdjustments>map("getRelativeDateAdjustments", _adjustedRelativeDateOffset -> _adjustedRelativeDateOffset.getRelativeDateAdjustments()).get()));
			
			return Optional.ofNullable(adjustedRelativeDateOffset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
