package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableOrRelativeDate.MapAdjustableOrRelativeDateDefault.class)
public abstract class MapAdjustableOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapRelativeDateOffsetToAdjustedRelativeDateOffset mapRelativeDateOffsetToAdjustedRelativeDateOffset;

	/**
	* @param fpmlAdjustableOrRelativeDate 
	* @return adjustableOrRelativeDate 
	*/
	public AdjustableOrRelativeDate evaluate(fpml.consolidated.shared.AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate) {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDateBuilder = doEvaluate(fpmlAdjustableOrRelativeDate);
		
		final AdjustableOrRelativeDate adjustableOrRelativeDate;
		if (adjustableOrRelativeDateBuilder == null) {
			adjustableOrRelativeDate = null;
		} else {
			adjustableOrRelativeDate = adjustableOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		}
		
		return adjustableOrRelativeDate;
	}

	protected abstract AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(fpml.consolidated.shared.AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate);

	public static class MapAdjustableOrRelativeDateDefault extends MapAdjustableOrRelativeDate {
		@Override
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(fpml.consolidated.shared.AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate = AdjustableOrRelativeDate.builder();
			return assignOutput(adjustableOrRelativeDate, fpmlAdjustableOrRelativeDate);
		}
		
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder assignOutput(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate, fpml.consolidated.shared.AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate) {
			adjustableOrRelativeDate = toBuilder(AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapAdjustableDate.evaluate(MapperS.of(fpmlAdjustableOrRelativeDate).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).get()))
				.setRelativeDate(mapRelativeDateOffsetToAdjustedRelativeDateOffset.evaluate(MapperS.of(fpmlAdjustableOrRelativeDate).<RelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).get()))
				.build(), () -> AdjustableOrRelativeDate.builder());
			
			adjustableOrRelativeDate
				.getOrCreateMeta().setExternalKey(MapperS.of(fpmlAdjustableOrRelativeDate).<String>map("getId", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getId()).get());
			
			return Optional.ofNullable(adjustableOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
