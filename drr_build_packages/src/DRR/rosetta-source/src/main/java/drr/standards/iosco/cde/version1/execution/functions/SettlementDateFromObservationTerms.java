package drr.standards.iosco.cde.version1.execution.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.PeriodicDates;
import cdm.product.common.schedule.ObservationDates;
import cdm.product.common.schedule.ObservationTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.util.datetime.functions.AdjustableDateResolution;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(SettlementDateFromObservationTerms.SettlementDateFromObservationTermsDefault.class)
public abstract class SettlementDateFromObservationTerms implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;

	/**
	* @param observationTerms 
	* @return date 
	*/
	public List<Date> evaluate(ObservationTerms observationTerms) {
		List<Date> date = doEvaluate(observationTerms);
		
		return date;
	}

	protected abstract List<Date> doEvaluate(ObservationTerms observationTerms);

	public static class SettlementDateFromObservationTermsDefault extends SettlementDateFromObservationTerms {
		@Override
		protected List<Date> doEvaluate(ObservationTerms observationTerms) {
			List<Date> date = new ArrayList<>();
			return assignOutput(date, observationTerms);
		}
		
		protected List<Date> assignOutput(List<Date> date, ObservationTerms observationTerms) {
			date.addAll(MapperS.of(observationTerms).<ObservationDates>map("getObservationDates", _observationTerms -> _observationTerms.getObservationDates()).<PeriodicDates>map("getPeriodicSchedule", observationDates -> observationDates.getPeriodicSchedule()).<AdjustableOrRelativeDate>map("getEndDate", periodicDates -> periodicDates.getEndDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())
				.mapSingleToItem(item -> MapperS.of(adjustableDateResolution.evaluate(item.get()))).getMulti());
			
			return date;
		}
	}
}
