package drr.regulation.common.functions;

import cdm.base.datetime.DayOfWeekEnum;
import cdm.base.math.Quantity;
import cdm.product.asset.BankHolidayTreatmentEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import drr.regulation.common.CommodityTimeUnitEnum;
import drr.regulation.common.ReportableDelivery;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_DeliveryBlock.Create_DeliveryBlockDefault.class)
public abstract class Create_DeliveryBlock implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDaysOfTheWeek getDaysOfTheWeek;
	@Inject protected GetDeliveryCapacityAmount getDeliveryCapacityAmount;
	@Inject protected GetDeliveryCapacityUnit getDeliveryCapacityUnit;
	@Inject protected GetDurationCodeFromCommodityTimeUnit getDurationCodeFromCommodityTimeUnit;

	/**
	* @param deliveryStartTime 
	* @param deliveryEndTime 
	* @param deliveryStartDate 
	* @param deliveryEndDate 
	* @param bankHolidaysTreatment 
	* @param duration 
	* @param daysOfTheWeek 
	* @param deliveryCapacity 
	* @param priceTimeIntervalQuantity 
	* @param currencyOfThePriceTimeIntervalQuantity 
	* @return deliveryBlock 
	*/
	public ReportableDelivery evaluate(LocalTime deliveryStartTime, LocalTime deliveryEndTime, Date deliveryStartDate, Date deliveryEndDate, BankHolidayTreatmentEnum bankHolidaysTreatment, CommodityTimeUnitEnum duration, List<DayOfWeekEnum> daysOfTheWeek, Quantity deliveryCapacity, BigDecimal priceTimeIntervalQuantity, String currencyOfThePriceTimeIntervalQuantity) {
		ReportableDelivery.ReportableDeliveryBuilder deliveryBlockBuilder = doEvaluate(deliveryStartTime, deliveryEndTime, deliveryStartDate, deliveryEndDate, bankHolidaysTreatment, duration, daysOfTheWeek, deliveryCapacity, priceTimeIntervalQuantity, currencyOfThePriceTimeIntervalQuantity);
		
		final ReportableDelivery deliveryBlock;
		if (deliveryBlockBuilder == null) {
			deliveryBlock = null;
		} else {
			deliveryBlock = deliveryBlockBuilder.build();
			objectValidator.validate(ReportableDelivery.class, deliveryBlock);
		}
		
		return deliveryBlock;
	}

	protected abstract ReportableDelivery.ReportableDeliveryBuilder doEvaluate(LocalTime deliveryStartTime, LocalTime deliveryEndTime, Date deliveryStartDate, Date deliveryEndDate, BankHolidayTreatmentEnum bankHolidaysTreatment, CommodityTimeUnitEnum duration, List<DayOfWeekEnum> daysOfTheWeek, Quantity deliveryCapacity, BigDecimal priceTimeIntervalQuantity, String currencyOfThePriceTimeIntervalQuantity);

	public static class Create_DeliveryBlockDefault extends Create_DeliveryBlock {
		@Override
		protected ReportableDelivery.ReportableDeliveryBuilder doEvaluate(LocalTime deliveryStartTime, LocalTime deliveryEndTime, Date deliveryStartDate, Date deliveryEndDate, BankHolidayTreatmentEnum bankHolidaysTreatment, CommodityTimeUnitEnum duration, List<DayOfWeekEnum> daysOfTheWeek, Quantity deliveryCapacity, BigDecimal priceTimeIntervalQuantity, String currencyOfThePriceTimeIntervalQuantity) {
			if (daysOfTheWeek == null) {
				daysOfTheWeek = Collections.emptyList();
			}
			ReportableDelivery.ReportableDeliveryBuilder deliveryBlock = ReportableDelivery.builder();
			return assignOutput(deliveryBlock, deliveryStartTime, deliveryEndTime, deliveryStartDate, deliveryEndDate, bankHolidaysTreatment, duration, daysOfTheWeek, deliveryCapacity, priceTimeIntervalQuantity, currencyOfThePriceTimeIntervalQuantity);
		}
		
		protected ReportableDelivery.ReportableDeliveryBuilder assignOutput(ReportableDelivery.ReportableDeliveryBuilder deliveryBlock, LocalTime deliveryStartTime, LocalTime deliveryEndTime, Date deliveryStartDate, Date deliveryEndDate, BankHolidayTreatmentEnum bankHolidaysTreatment, CommodityTimeUnitEnum duration, List<DayOfWeekEnum> daysOfTheWeek, Quantity deliveryCapacity, BigDecimal priceTimeIntervalQuantity, String currencyOfThePriceTimeIntervalQuantity) {
			deliveryBlock = toBuilder(ReportableDelivery.builder()
				.setDeliveryStartTime(deliveryStartTime)
				.setDeliveryEndTime(deliveryEndTime)
				.setDeliveryStartDate(deliveryStartDate)
				.setDeliveryEndDate(deliveryEndDate)
				.setDuration(getDurationCodeFromCommodityTimeUnit.evaluate(duration))
				.setDaysOfTheWeek(getDaysOfTheWeek.evaluate(daysOfTheWeek, bankHolidaysTreatment))
				.setDeliveryCapacity(getDeliveryCapacityAmount.evaluate(deliveryCapacity))
				.setQuantityUnit(getDeliveryCapacityUnit.evaluate(deliveryCapacity))
				.setPriceTimeIntervalQuantity(priceTimeIntervalQuantity)
				.setCurrencyOfThePriceTimeIntervalQuantity(currencyOfThePriceTimeIntervalQuantity)
				.build());
			
			return Optional.ofNullable(deliveryBlock)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
