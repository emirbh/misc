package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.datetime.PeriodicDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapRelativeDateOffsetToAdjustedRelativeDateOffset;
import cdm.product.common.schedule.ObservationDates;
import cdm.product.common.schedule.ObservationTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapAdjustableOrRelativeDateToObservationTerms.MapAdjustableOrRelativeDateToObservationTermsDefault.class)
public abstract class MapAdjustableOrRelativeDateToObservationTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapRelativeDateOffsetToAdjustedRelativeDateOffset mapRelativeDateOffsetToAdjustedRelativeDateOffset;

	/**
	* @param fpmlAdjustableOrRelativeDate 
	* @return obserrvationTerms 
	*/
	public ObservationTerms evaluate(AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate) {
		ObservationTerms.ObservationTermsBuilder obserrvationTermsBuilder = doEvaluate(fpmlAdjustableOrRelativeDate);
		
		final ObservationTerms obserrvationTerms;
		if (obserrvationTermsBuilder == null) {
			obserrvationTerms = null;
		} else {
			obserrvationTerms = obserrvationTermsBuilder.build();
			objectValidator.validate(ObservationTerms.class, obserrvationTerms);
		}
		
		return obserrvationTerms;
	}

	protected abstract ObservationTerms.ObservationTermsBuilder doEvaluate(AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate);

	public static class MapAdjustableOrRelativeDateToObservationTermsDefault extends MapAdjustableOrRelativeDateToObservationTerms {
		@Override
		protected ObservationTerms.ObservationTermsBuilder doEvaluate(AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate) {
			ObservationTerms.ObservationTermsBuilder obserrvationTerms = ObservationTerms.builder();
			return assignOutput(obserrvationTerms, fpmlAdjustableOrRelativeDate);
		}
		
		protected ObservationTerms.ObservationTermsBuilder assignOutput(ObservationTerms.ObservationTermsBuilder obserrvationTerms, AdjustableOrRelativeDate fpmlAdjustableOrRelativeDate) {
			if (exists(MapperS.of(fpmlAdjustableOrRelativeDate)).getOrDefault(false)) {
				obserrvationTerms = toBuilder(ObservationTerms.builder()
					.setObservationDates(ObservationDates.builder()
						.setPeriodicSchedule(PeriodicDates.builder()
							.setStartDate(cdm.base.datetime.AdjustableOrRelativeDate.builder()
								.setAdjustableDate(mapAdjustableDate.evaluate(MapperS.of(fpmlAdjustableOrRelativeDate).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get()))
								.setRelativeDate(mapRelativeDateOffsetToAdjustedRelativeDateOffset.evaluate(MapperS.of(fpmlAdjustableOrRelativeDate).<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
								.build())
							.build())
						.build())
					.build());
			} else {
				obserrvationTerms = null;
			}
			
			return Optional.ofNullable(obserrvationTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
