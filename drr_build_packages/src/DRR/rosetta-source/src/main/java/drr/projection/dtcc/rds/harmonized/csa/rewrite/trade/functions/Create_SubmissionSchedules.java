package drr.projection.dtcc.rds.harmonized.csa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import iso20022.dtcc.rds.harmonized.CdePriceSchedule;
import iso20022.dtcc.rds.harmonized.CdeSchedule1;
import iso20022.dtcc.rds.harmonized.CdeSchedule2;
import iso20022.dtcc.rds.harmonized.CdeStrikePriceSchedule;
import iso20022.dtcc.rds.harmonized.Schedules;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_SubmissionSchedules.Create_SubmissionSchedulesDefault.class)
public abstract class Create_SubmissionSchedules implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return schedules 
	*/
	public Schedules evaluate(CSATransactionReport drrReport) {
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

	protected abstract Schedules.SchedulesBuilder doEvaluate(CSATransactionReport drrReport);

	public static class Create_SubmissionSchedulesDefault extends Create_SubmissionSchedules {
		@Override
		protected Schedules.SchedulesBuilder doEvaluate(CSATransactionReport drrReport) {
			Schedules.SchedulesBuilder schedules = Schedules.builder();
			return assignOutput(schedules, drrReport);
		}
		
		protected Schedules.SchedulesBuilder assignOutput(Schedules.SchedulesBuilder schedules, CSATransactionReport drrReport) {
			final MapperC<NotionalPeriod> thenArg0 = MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", cSALeg -> cSALeg.getNotionalAmountSchedule());
			schedules
				.addCdeNotionalSchedule1(thenArg0
					.mapItem(item -> MapperS.of(CdeSchedule1.builder()
						.setCdeEffectiveDateOfTheNotionalAmountLeg1(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
						.setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
						.setCdeEndDateOfTheNotionalAmountLeg1(null)
						.build())).getMulti());
			
			final MapperC<NotionalPeriod> thenArg1 = MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", cSALeg -> cSALeg.getNotionalAmountSchedule());
			schedules
				.addCdeNotionalSchedule2(thenArg1
					.mapItem(item -> MapperS.of(CdeSchedule2.builder()
						.setCdeEffectiveDateOfTheNotionalAmountLeg2(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
						.setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
						.setCdeEndDateOfTheNotionalAmountLeg2(null)
						.build())).getMulti());
			
			final MapperC<PricePeriod> thenArg2 = MapperS.of(drrReport).<PricePeriod>mapC("getPriceSchedule", cSATransactionReport -> cSATransactionReport.getPriceSchedule());
			schedules
				.addCdePriceSchedule(thenArg2
					.mapItem(item -> {
						final BigDecimal ifThenElseResult;
						if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary())).getOrDefault(false)) {
							ifThenElseResult = item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get();
						} else if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal())).getOrDefault(false)) {
							ifThenElseResult = item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get();
						} else {
							ifThenElseResult = null;
						}
						return MapperS.of(CdePriceSchedule.builder()
							.setCdeUnadjustedEffectiveDateOfPrice(item.<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).get())
							.setCdeUnadjustedEndDateOfPrice(item.<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).get())
							.setCdePrice(ifThenElseResult)
							.build());
					}).getMulti());
			
			final MapperC<PricePeriod> thenArg3 = MapperS.of(drrReport).<PricePeriod>mapC("getStrikePriceSchedule", cSATransactionReport -> cSATransactionReport.getStrikePriceSchedule());
			schedules
				.addCdeStrikePriceSchedule(thenArg3
					.mapItem(item -> {
						final BigDecimal ifThenElseResult;
						if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary())).getOrDefault(false)) {
							ifThenElseResult = item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get();
						} else if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal())).getOrDefault(false)) {
							ifThenElseResult = item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get();
						} else {
							ifThenElseResult = null;
						}
						return MapperS.of(CdeStrikePriceSchedule.builder()
							.setCdeUnadjustedEffectiveDateOfStrikePrice(item.<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).get())
							.setCdeUnadjustedEndDateOfStrikePrice(item.<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).get())
							.setCdeStrikePrice(ifThenElseResult)
							.build());
					}).getMulti());
			
			return Optional.ofNullable(schedules)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
