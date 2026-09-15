package drr.standards.iosco.cde.version1.execution.functions;

import cdm.base.datetime.DateRange;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.SchedulePeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.List;


@ImplementedBy(SettlementDateFromSchedule.SettlementDateFromScheduleDefault.class)
public abstract class SettlementDateFromSchedule implements RosettaFunction {

	/**
	* @param schedule 
	* @return date 
	*/
	public List<Date> evaluate(CalculationSchedule schedule) {
		List<Date> date = doEvaluate(schedule);
		
		return date;
	}

	protected abstract List<Date> doEvaluate(CalculationSchedule schedule);

	public static class SettlementDateFromScheduleDefault extends SettlementDateFromSchedule {
		@Override
		protected List<Date> doEvaluate(CalculationSchedule schedule) {
			List<Date> date = new ArrayList<>();
			return assignOutput(date, schedule);
		}
		
		protected List<Date> assignOutput(List<Date> date, CalculationSchedule schedule) {
			date.addAll(MapperS.of(schedule).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod())
				.mapItem(item -> item.<Date>map("getPaymentDate", schedulePeriod -> schedulePeriod.getPaymentDate())).getMulti());
			
			date.addAll(MapperS.of(schedule).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod())
				.mapItem(item -> item.<DateRange>map("getFixingPeriod", schedulePeriod -> schedulePeriod.getFixingPeriod()).<Date>map("getEndDate", dateRange -> dateRange.getEndDate())).getMulti());
			
			return date;
		}
	}
}
