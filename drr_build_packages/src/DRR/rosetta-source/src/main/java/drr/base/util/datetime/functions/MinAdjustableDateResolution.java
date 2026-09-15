package drr.base.util.datetime.functions;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(MinAdjustableDateResolution.MinAdjustableDateResolutionDefault.class)
public abstract class MinAdjustableDateResolution implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;

	/**
	* @param adjustableDates 
	* @return date 
	*/
	public Date evaluate(List<? extends AdjustableDate> adjustableDates) {
		Date date = doEvaluate(adjustableDates);
		
		return date;
	}

	protected abstract Date doEvaluate(List<? extends AdjustableDate> adjustableDates);

	public static class MinAdjustableDateResolutionDefault extends MinAdjustableDateResolution {
		@Override
		protected Date doEvaluate(List<? extends AdjustableDate> adjustableDates) {
			if (adjustableDates == null) {
				adjustableDates = Collections.emptyList();
			}
			Date date = null;
			return assignOutput(date, adjustableDates);
		}
		
		protected Date assignOutput(Date date, List<? extends AdjustableDate> adjustableDates) {
			final MapperC<Date> thenArg = MapperC.<AdjustableDate>of(adjustableDates)
				.mapItem(item -> MapperS.of(adjustableDateResolution.evaluate(item.get())));
			date = thenArg
				.min().get();
			
			return date;
		}
	}
}
