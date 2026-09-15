package drr.standards.iosco.cde.version1.datetime.reports;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.DateRange;
import cdm.base.datetime.PeriodicDates;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.ObservationDates;
import cdm.product.common.schedule.ObservationTerms;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SchedulePeriod;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommodityFixedPriceForward;
import drr.base.qualification.product.functions.IsCommodityFloatingPriceForward;
import drr.base.qualification.product.functions.IsCommodityOption;
import drr.base.qualification.product.functions.IsCommoditySwap;
import drr.base.qualification.product.functions.IsCommoditySwaption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.util.datetime.functions.AdjustableDateResolution;
import drr.base.util.datetime.functions.AdjustableDatesResolution;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExpirationDateRule.ExpirationDateRuleDefault.class)
public abstract class ExpirationDateRule implements ReportFunction<NonTransferableProduct, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;
	@Inject protected AdjustableDatesResolution adjustableDatesResolution;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommodityFixedPriceForward isCommodityFixedPriceForward;
	@Inject protected IsCommodityFloatingPriceForward isCommodityFloatingPriceForward;
	@Inject protected IsCommodityOption isCommodityOption;
	@Inject protected IsCommoditySwap isCommoditySwap;
	@Inject protected IsCommoditySwaption isCommoditySwaption;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(NonTransferableProduct input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(NonTransferableProduct input);

	public static class ExpirationDateRuleDefault extends ExpirationDateRule {
		@Override
		protected Date doEvaluate(NonTransferableProduct input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, NonTransferableProduct input) {
			output = MapperS.of(input)
				.mapSingleToItem(product -> {
					final MapperS<EconomicTerms> thenArg0 = MapperS.of(economicTermsForProduct.evaluate(product.get()));
					final MapperS<Date> ifThenElseResult;
					if (exists(thenArg0.<AdjustableOrRelativeDate>map("getTerminationDate", economicTerms -> economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())).getOrDefault(false)) {
						ifThenElseResult = MapperS.of(adjustableDateResolution.evaluate(thenArg0.<AdjustableOrRelativeDate>map("getTerminationDate", economicTerms -> economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get()));
					} else if (exists(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", calculationPeriodDates -> calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())).getOrDefault(false)) {
						final MapperC<Date> thenArg1 = thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", calculationPeriodDates -> calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())
							.mapItem(item -> MapperS.of(adjustableDateResolution.evaluate(item.get())));
						ifThenElseResult = thenArg1
							.max();
					} else if (areEqual(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.EUROPEAN), CardinalityOperator.All).andNullSafe(exists(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<AdjustableOrRelativeDate>mapC("getExpirationDate", exerciseTerms -> exerciseTerms.getExpirationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()))).getOrDefault(false)) {
						final MapperC<Date> thenArg2 = thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<AdjustableOrRelativeDate>mapC("getExpirationDate", exerciseTerms -> exerciseTerms.getExpirationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())
							.mapItem(item -> MapperS.of(adjustableDateResolution.evaluate(item.get())));
						ifThenElseResult = thenArg2
							.max();
					} else if (areEqual(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.AMERICAN), CardinalityOperator.All).andNullSafe(exists(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<AdjustableOrRelativeDate>mapC("getExpirationDate", exerciseTerms -> exerciseTerms.getExpirationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()))).getOrDefault(false)) {
						final MapperC<Date> thenArg3 = thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<AdjustableOrRelativeDate>mapC("getExpirationDate", exerciseTerms -> exerciseTerms.getExpirationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())
							.mapItem(item -> MapperS.of(adjustableDateResolution.evaluate(item.get())));
						ifThenElseResult = thenArg3
							.max();
					} else if (areEqual(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.All).andNullSafe(exists(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<AdjustableOrRelativeDates>map("getExerciseDates", exerciseTerms -> exerciseTerms.getExerciseDates()).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates()))).getOrDefault(false)) {
						final MapperListOfLists<Date> thenArg4 = thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<AdjustableOrRelativeDates>map("getExerciseDates", exerciseTerms -> exerciseTerms.getExerciseDates()).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates())
							.mapItemToList(item -> MapperC.<Date>of(adjustableDatesResolution.evaluate(item.get())));
						final MapperC<Date> thenArg5 = thenArg4
							.flattenList();
						ifThenElseResult = thenArg5
							.max();
					} else if (exists(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<Date>map("getValueDate", settlementDate -> settlementDate.getValueDate())).getOrDefault(false)) {
						ifThenElseResult = thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<Date>map("getValueDate", settlementDate -> settlementDate.getValueDate())
							.max();
					} else if (exists(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<Date>map("getValueDate", settlementDate -> settlementDate.getValueDate())).getOrDefault(false)) {
						ifThenElseResult = thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<Date>map("getValueDate", settlementDate -> settlementDate.getValueDate())
							.max();
					} else if (exists(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ObservationTerms>map("getObservationTerms", performancePayout -> performancePayout.getObservationTerms()).<ObservationDates>map("getObservationDates", observationTerms -> observationTerms.getObservationDates()).<PeriodicDates>map("getPeriodicSchedule", observationDates -> observationDates.getPeriodicSchedule()).<AdjustableOrRelativeDate>map("getEndDate", periodicDates -> periodicDates.getEndDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())).getOrDefault(false)) {
						final MapperC<Date> thenArg6 = thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ObservationTerms>map("getObservationTerms", performancePayout -> performancePayout.getObservationTerms()).<ObservationDates>map("getObservationDates", observationTerms -> observationTerms.getObservationDates()).<PeriodicDates>map("getPeriodicSchedule", observationDates -> observationDates.getPeriodicSchedule()).<AdjustableOrRelativeDate>map("getEndDate", periodicDates -> periodicDates.getEndDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())
							.mapItem(item -> MapperS.of(adjustableDateResolution.evaluate(item.get())));
						ifThenElseResult = thenArg6
							.max();
					} else if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwap.evaluate(product.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommodityFloatingPriceForward.evaluate(product.get())))).getOrDefault(false)) {
						ifThenElseResult = thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<DateRange>map("getFixingPeriod", schedulePeriod -> schedulePeriod.getFixingPeriod()).<Date>map("getEndDate", dateRange -> dateRange.getEndDate())
							.max();
					} else {
						final Boolean _boolean = isCommodityFixedPriceForward.evaluate(product.get());
						if ((_boolean == null ? false : _boolean)) {
							ifThenElseResult = thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).<CalculationSchedule>map("getSchedule", fixedPricePayout -> fixedPricePayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<DateRange>map("getFixingPeriod", schedulePeriod -> schedulePeriod.getFixingPeriod()).<Date>map("getEndDate", dateRange -> dateRange.getEndDate())
								.max();
						} else if (ComparisonResult.ofNullSafe(MapperS.of(isCommodityOption.evaluate(product.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwaption.evaluate(product.get())))).getOrDefault(false)) {
							ifThenElseResult = MapperS.of(thenArg0.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<CalculationSchedule>map("getSchedule", optionPayout -> optionPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<DateRange>map("getFixingPeriod", schedulePeriod -> schedulePeriod.getFixingPeriod()).<Date>map("getEndDate", dateRange -> dateRange.getEndDate())
								.max();
						} else {
							ifThenElseResult = MapperS.<Date>ofNull();
						}
					}
					return ifThenElseResult;
				}).get();
			
			return output;
		}
	}
}
