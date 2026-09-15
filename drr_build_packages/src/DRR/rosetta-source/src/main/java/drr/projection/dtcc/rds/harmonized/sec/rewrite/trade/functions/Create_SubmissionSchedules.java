package drr.projection.dtcc.rds.harmonized.sec.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import iso20022.dtcc.rds.harmonized.CdeSchedule1;
import iso20022.dtcc.rds.harmonized.CdeSchedule2;
import iso20022.dtcc.rds.harmonized.Schedules;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionSchedules.Create_SubmissionSchedulesDefault.class)
public abstract class Create_SubmissionSchedules implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return schedules 
	*/
	public Schedules evaluate(SECTransactionReport drrReport) {
		Schedules.SchedulesBuilder schedulesBuilder = doEvaluate(drrReport);
		
		final Schedules schedules;
		if (schedulesBuilder == null) {
			schedules = null;
		} else {
			schedules = schedulesBuilder.build();
			objectValidator.validate(Schedules.class, schedules);
		}
		
		return schedules;
	}

	protected abstract Schedules.SchedulesBuilder doEvaluate(SECTransactionReport drrReport);

	public static class Create_SubmissionSchedulesDefault extends Create_SubmissionSchedules {
		@Override
		protected Schedules.SchedulesBuilder doEvaluate(SECTransactionReport drrReport) {
			Schedules.SchedulesBuilder schedules = Schedules.builder();
			return assignOutput(schedules, drrReport);
		}
		
		protected Schedules.SchedulesBuilder assignOutput(Schedules.SchedulesBuilder schedules, SECTransactionReport drrReport) {
			final MapperC<NotionalPeriod> thenArg0 = MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", sECLeg -> sECLeg.getNotionalAmountSchedule());
			schedules
				.addCdeNotionalSchedule1(thenArg0
					.mapItem(item -> MapperS.of(CdeSchedule1.builder()
						.setCdeEffectiveDateOfTheNotionalAmountLeg1(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
						.setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
						.setCdeEndDateOfTheNotionalAmountLeg1(null)
						.build())).getMulti());
			
			final MapperC<NotionalPeriod> thenArg1 = MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", sECLeg -> sECLeg.getNotionalAmountSchedule());
			schedules
				.addCdeNotionalSchedule2(thenArg1
					.mapItem(item -> MapperS.of(CdeSchedule2.builder()
						.setCdeEffectiveDateOfTheNotionalAmountLeg2(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
						.setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
						.setCdeEndDateOfTheNotionalAmountLeg2(null)
						.build())).getMulti());
			
			return Optional.ofNullable(schedules)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
