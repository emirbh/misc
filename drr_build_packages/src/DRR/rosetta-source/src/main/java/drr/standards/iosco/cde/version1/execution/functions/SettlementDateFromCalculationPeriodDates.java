package drr.standards.iosco.cde.version1.execution.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.common.schedule.CalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.util.datetime.functions.AdjustableDateResolution;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(SettlementDateFromCalculationPeriodDates.SettlementDateFromCalculationPeriodDatesDefault.class)
public abstract class SettlementDateFromCalculationPeriodDates implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;

	/**
	* @param calculationPeriodDates 
	* @return date 
	*/
	public List<Date> evaluate(CalculationPeriodDates calculationPeriodDates) {
		List<Date> date = doEvaluate(calculationPeriodDates);
		
		return date;
	}

	protected abstract List<Date> doEvaluate(CalculationPeriodDates calculationPeriodDates);

	public static class SettlementDateFromCalculationPeriodDatesDefault extends SettlementDateFromCalculationPeriodDates {
		@Override
		protected List<Date> doEvaluate(CalculationPeriodDates calculationPeriodDates) {
			List<Date> date = new ArrayList<>();
			return assignOutput(date, calculationPeriodDates);
		}
		
		protected List<Date> assignOutput(List<Date> date, CalculationPeriodDates calculationPeriodDates) {
			date.addAll(MapperS.of(calculationPeriodDates).<AdjustableOrRelativeDate>map("getTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())
				.mapSingleToItem(item -> MapperS.of(adjustableDateResolution.evaluate(item.get()))).getMulti());
			
			return date;
		}
	}
}
