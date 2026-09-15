package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableDateOrRelativeDateSequenceToAdjustableOrAdjustedRelativeDate.MapAdjustableDateOrRelativeDateSequenceToAdjustableOrAdjustedRelativeDateDefault.class)
public abstract class MapAdjustableDateOrRelativeDateSequenceToAdjustableOrAdjustedRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapRelativeDateSequenceToAdjustedRelativeDateOffset mapRelativeDateSequenceToAdjustedRelativeDateOffset;

	/**
	* @param fpmlAdjustableDate 
	* @param fpmlRelativeDateSequence 
	* @param fpmlId 
	* @return adjustableOrRelativeDate 
	*/
	public AdjustableOrRelativeDate evaluate(AdjustableDate fpmlAdjustableDate, RelativeDateSequence fpmlRelativeDateSequence, String fpmlId) {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDateBuilder = doEvaluate(fpmlAdjustableDate, fpmlRelativeDateSequence, fpmlId);
		
		final AdjustableOrRelativeDate adjustableOrRelativeDate;
		if (adjustableOrRelativeDateBuilder == null) {
			adjustableOrRelativeDate = null;
		} else {
			adjustableOrRelativeDate = adjustableOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		}
		
		return adjustableOrRelativeDate;
	}

	protected abstract AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(AdjustableDate fpmlAdjustableDate, RelativeDateSequence fpmlRelativeDateSequence, String fpmlId);

	public static class MapAdjustableDateOrRelativeDateSequenceToAdjustableOrAdjustedRelativeDateDefault extends MapAdjustableDateOrRelativeDateSequenceToAdjustableOrAdjustedRelativeDate {
		@Override
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(AdjustableDate fpmlAdjustableDate, RelativeDateSequence fpmlRelativeDateSequence, String fpmlId) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate = AdjustableOrRelativeDate.builder();
			return assignOutput(adjustableOrRelativeDate, fpmlAdjustableDate, fpmlRelativeDateSequence, fpmlId);
		}
		
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder assignOutput(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate, AdjustableDate fpmlAdjustableDate, RelativeDateSequence fpmlRelativeDateSequence, String fpmlId) {
			final AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder withMetaArgument = AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapAdjustableDate.evaluate(fpmlAdjustableDate))
				.setRelativeDate(mapRelativeDateSequenceToAdjustedRelativeDateOffset.evaluate(fpmlRelativeDateSequence))
				.build() == null ? null : AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapAdjustableDate.evaluate(fpmlAdjustableDate))
				.setRelativeDate(mapRelativeDateSequenceToAdjustedRelativeDateOffset.evaluate(fpmlRelativeDateSequence))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(fpmlId);
			adjustableOrRelativeDate = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(adjustableOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
