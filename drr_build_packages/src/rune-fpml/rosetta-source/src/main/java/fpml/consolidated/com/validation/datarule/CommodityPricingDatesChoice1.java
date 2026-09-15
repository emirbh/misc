package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.com.CommodityFrequencyType;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.Lag;
import fpml.consolidated.com.SettlementPeriods;
import fpml.consolidated.com.SettlementPeriodsReference;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.CalendarSourceEnum;
import fpml.consolidated.fpmlenum.CommodityDayTypeEnum;
import fpml.consolidated.fpmlenum.DayOfWeekEnum;
import fpml.consolidated.shared.AdjustableDates;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityPricingDatesChoice1")
@ImplementedBy(CommodityPricingDatesChoice1.Default.class)
public interface CommodityPricingDatesChoice1 extends Validator<CommodityPricingDates> {
	
	String NAME = "CommodityPricingDatesChoice1";
	String DEFINITION = "if settlementPeriods exists then dayType is absent and dayDistribution is absent and dayCount is absent and dayOfWeek is absent and dayNumber is absent and businessDayConvention is absent and businessCalendar is absent and calendarSource is absent and settlementPeriodsReference is absent and pricingDates is absent else if settlementPeriodsReference exists then dayType is absent and dayDistribution is absent and dayCount is absent and dayOfWeek is absent and dayNumber is absent and businessDayConvention is absent and businessCalendar is absent and calendarSource is absent and pricingDates is absent else if pricingDates exists then lag is absent and dayType is absent and dayDistribution is absent and dayCount is absent and dayOfWeek is absent and dayNumber is absent and businessDayConvention is absent and businessCalendar is absent and calendarSource is absent else dayOfWeek is absent and dayNumber is absent or dayDistribution is absent and dayCount is absent";
	
	class Default implements CommodityPricingDatesChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPricingDates commodityPricingDates) {
			ComparisonResult result = executeDataRule(commodityPricingDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPricingDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPricingDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityPricingDates commodityPricingDates) {
			try {
				if (exists(MapperS.of(commodityPricingDates).<SettlementPeriods>mapC("getSettlementPeriods", _commodityPricingDates -> _commodityPricingDates.getSettlementPeriods())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityPricingDates).<CommodityDayTypeEnum>map("getDayType", _commodityPricingDates -> _commodityPricingDates.getDayType())).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CommodityFrequencyType>map("getDayDistribution", _commodityPricingDates -> _commodityPricingDates.getDayDistribution()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<Integer>map("getDayCount", _commodityPricingDates -> _commodityPricingDates.getDayCount()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<DayOfWeekEnum>mapC("getDayOfWeek", _commodityPricingDates -> _commodityPricingDates.getDayOfWeek()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<Integer>map("getDayNumber", _commodityPricingDates -> _commodityPricingDates.getDayNumber()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<BusinessDayConventionEnum>map("getBusinessDayConvention", _commodityPricingDates -> _commodityPricingDates.getBusinessDayConvention()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CommodityBusinessCalendar>map("getBusinessCalendar", _commodityPricingDates -> _commodityPricingDates.getBusinessCalendar()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CalendarSourceEnum>map("getCalendarSource", _commodityPricingDates -> _commodityPricingDates.getCalendarSource()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<SettlementPeriodsReference>mapC("getSettlementPeriodsReference", _commodityPricingDates -> _commodityPricingDates.getSettlementPeriodsReference()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<AdjustableDates>mapC("getPricingDates", _commodityPricingDates -> _commodityPricingDates.getPricingDates())));
				}
				if (exists(MapperS.of(commodityPricingDates).<SettlementPeriodsReference>mapC("getSettlementPeriodsReference", _commodityPricingDates -> _commodityPricingDates.getSettlementPeriodsReference())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityPricingDates).<CommodityDayTypeEnum>map("getDayType", _commodityPricingDates -> _commodityPricingDates.getDayType())).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CommodityFrequencyType>map("getDayDistribution", _commodityPricingDates -> _commodityPricingDates.getDayDistribution()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<Integer>map("getDayCount", _commodityPricingDates -> _commodityPricingDates.getDayCount()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<DayOfWeekEnum>mapC("getDayOfWeek", _commodityPricingDates -> _commodityPricingDates.getDayOfWeek()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<Integer>map("getDayNumber", _commodityPricingDates -> _commodityPricingDates.getDayNumber()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<BusinessDayConventionEnum>map("getBusinessDayConvention", _commodityPricingDates -> _commodityPricingDates.getBusinessDayConvention()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CommodityBusinessCalendar>map("getBusinessCalendar", _commodityPricingDates -> _commodityPricingDates.getBusinessCalendar()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CalendarSourceEnum>map("getCalendarSource", _commodityPricingDates -> _commodityPricingDates.getCalendarSource()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<AdjustableDates>mapC("getPricingDates", _commodityPricingDates -> _commodityPricingDates.getPricingDates())));
				}
				if (exists(MapperS.of(commodityPricingDates).<AdjustableDates>mapC("getPricingDates", _commodityPricingDates -> _commodityPricingDates.getPricingDates())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityPricingDates).<Lag>map("getLag", _commodityPricingDates -> _commodityPricingDates.getLag())).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CommodityDayTypeEnum>map("getDayType", _commodityPricingDates -> _commodityPricingDates.getDayType()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CommodityFrequencyType>map("getDayDistribution", _commodityPricingDates -> _commodityPricingDates.getDayDistribution()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<Integer>map("getDayCount", _commodityPricingDates -> _commodityPricingDates.getDayCount()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<DayOfWeekEnum>mapC("getDayOfWeek", _commodityPricingDates -> _commodityPricingDates.getDayOfWeek()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<Integer>map("getDayNumber", _commodityPricingDates -> _commodityPricingDates.getDayNumber()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<BusinessDayConventionEnum>map("getBusinessDayConvention", _commodityPricingDates -> _commodityPricingDates.getBusinessDayConvention()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CommodityBusinessCalendar>map("getBusinessCalendar", _commodityPricingDates -> _commodityPricingDates.getBusinessCalendar()))).andNullSafe(notExists(MapperS.of(commodityPricingDates).<CalendarSourceEnum>map("getCalendarSource", _commodityPricingDates -> _commodityPricingDates.getCalendarSource())));
				}
				return notExists(MapperS.of(commodityPricingDates).<DayOfWeekEnum>mapC("getDayOfWeek", _commodityPricingDates -> _commodityPricingDates.getDayOfWeek())).andNullSafe(notExists(MapperS.of(commodityPricingDates).<Integer>map("getDayNumber", _commodityPricingDates -> _commodityPricingDates.getDayNumber()))).orNullSafe(notExists(MapperS.of(commodityPricingDates).<CommodityFrequencyType>map("getDayDistribution", _commodityPricingDates -> _commodityPricingDates.getDayDistribution())).andNullSafe(notExists(MapperS.of(commodityPricingDates).<Integer>map("getDayCount", _commodityPricingDates -> _commodityPricingDates.getDayCount()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPricingDatesChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPricingDates commodityPricingDates) {
			return Collections.emptyList();
		}
	}
}
