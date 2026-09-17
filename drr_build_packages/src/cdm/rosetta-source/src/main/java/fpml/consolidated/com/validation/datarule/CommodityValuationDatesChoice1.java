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
import fpml.consolidated.com.CommodityValuationDates;
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
@RosettaDataRule("CommodityValuationDatesChoice1")
@ImplementedBy(CommodityValuationDatesChoice1.Default.class)
public interface CommodityValuationDatesChoice1 extends Validator<CommodityValuationDates> {
	
	String NAME = "CommodityValuationDatesChoice1";
	String DEFINITION = "if settlementPeriods exists then dayType is absent and dayDistribution is absent and dayCount is absent and dayOfWeek is absent and dayNumber is absent and businessDayConvention is absent and businessCalendar is absent and calendarSource is absent and settlementPeriodsReference is absent and valuationDates is absent else if settlementPeriodsReference exists then dayType is absent and dayDistribution is absent and dayCount is absent and dayOfWeek is absent and dayNumber is absent and businessDayConvention is absent and businessCalendar is absent and calendarSource is absent and valuationDates is absent else if valuationDates exists then lag is absent and dayType is absent and dayDistribution is absent and dayCount is absent and dayOfWeek is absent and dayNumber is absent and businessDayConvention is absent and businessCalendar is absent and calendarSource is absent else dayOfWeek is absent and dayNumber is absent or dayDistribution is absent and dayCount is absent";
	
	class Default implements CommodityValuationDatesChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityValuationDates commodityValuationDates) {
			ComparisonResult result = executeDataRule(commodityValuationDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityValuationDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityValuationDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityValuationDates commodityValuationDates) {
			try {
				if (exists(MapperS.of(commodityValuationDates).<SettlementPeriods>mapC("getSettlementPeriods", _commodityValuationDates -> _commodityValuationDates.getSettlementPeriods())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityValuationDates).<CommodityDayTypeEnum>map("getDayType", _commodityValuationDates -> _commodityValuationDates.getDayType())).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CommodityFrequencyType>map("getDayDistribution", _commodityValuationDates -> _commodityValuationDates.getDayDistribution()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<Integer>map("getDayCount", _commodityValuationDates -> _commodityValuationDates.getDayCount()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<DayOfWeekEnum>mapC("getDayOfWeek", _commodityValuationDates -> _commodityValuationDates.getDayOfWeek()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<Integer>map("getDayNumber", _commodityValuationDates -> _commodityValuationDates.getDayNumber()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<BusinessDayConventionEnum>map("getBusinessDayConvention", _commodityValuationDates -> _commodityValuationDates.getBusinessDayConvention()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CommodityBusinessCalendar>map("getBusinessCalendar", _commodityValuationDates -> _commodityValuationDates.getBusinessCalendar()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CalendarSourceEnum>map("getCalendarSource", _commodityValuationDates -> _commodityValuationDates.getCalendarSource()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<SettlementPeriodsReference>mapC("getSettlementPeriodsReference", _commodityValuationDates -> _commodityValuationDates.getSettlementPeriodsReference()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<AdjustableDates>mapC("getValuationDates", _commodityValuationDates -> _commodityValuationDates.getValuationDates())));
				}
				if (exists(MapperS.of(commodityValuationDates).<SettlementPeriodsReference>mapC("getSettlementPeriodsReference", _commodityValuationDates -> _commodityValuationDates.getSettlementPeriodsReference())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityValuationDates).<CommodityDayTypeEnum>map("getDayType", _commodityValuationDates -> _commodityValuationDates.getDayType())).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CommodityFrequencyType>map("getDayDistribution", _commodityValuationDates -> _commodityValuationDates.getDayDistribution()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<Integer>map("getDayCount", _commodityValuationDates -> _commodityValuationDates.getDayCount()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<DayOfWeekEnum>mapC("getDayOfWeek", _commodityValuationDates -> _commodityValuationDates.getDayOfWeek()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<Integer>map("getDayNumber", _commodityValuationDates -> _commodityValuationDates.getDayNumber()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<BusinessDayConventionEnum>map("getBusinessDayConvention", _commodityValuationDates -> _commodityValuationDates.getBusinessDayConvention()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CommodityBusinessCalendar>map("getBusinessCalendar", _commodityValuationDates -> _commodityValuationDates.getBusinessCalendar()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CalendarSourceEnum>map("getCalendarSource", _commodityValuationDates -> _commodityValuationDates.getCalendarSource()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<AdjustableDates>mapC("getValuationDates", _commodityValuationDates -> _commodityValuationDates.getValuationDates())));
				}
				if (exists(MapperS.of(commodityValuationDates).<AdjustableDates>mapC("getValuationDates", _commodityValuationDates -> _commodityValuationDates.getValuationDates())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityValuationDates).<Lag>map("getLag", _commodityValuationDates -> _commodityValuationDates.getLag())).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CommodityDayTypeEnum>map("getDayType", _commodityValuationDates -> _commodityValuationDates.getDayType()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CommodityFrequencyType>map("getDayDistribution", _commodityValuationDates -> _commodityValuationDates.getDayDistribution()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<Integer>map("getDayCount", _commodityValuationDates -> _commodityValuationDates.getDayCount()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<DayOfWeekEnum>mapC("getDayOfWeek", _commodityValuationDates -> _commodityValuationDates.getDayOfWeek()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<Integer>map("getDayNumber", _commodityValuationDates -> _commodityValuationDates.getDayNumber()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<BusinessDayConventionEnum>map("getBusinessDayConvention", _commodityValuationDates -> _commodityValuationDates.getBusinessDayConvention()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CommodityBusinessCalendar>map("getBusinessCalendar", _commodityValuationDates -> _commodityValuationDates.getBusinessCalendar()))).andNullSafe(notExists(MapperS.of(commodityValuationDates).<CalendarSourceEnum>map("getCalendarSource", _commodityValuationDates -> _commodityValuationDates.getCalendarSource())));
				}
				return notExists(MapperS.of(commodityValuationDates).<DayOfWeekEnum>mapC("getDayOfWeek", _commodityValuationDates -> _commodityValuationDates.getDayOfWeek())).andNullSafe(notExists(MapperS.of(commodityValuationDates).<Integer>map("getDayNumber", _commodityValuationDates -> _commodityValuationDates.getDayNumber()))).orNullSafe(notExists(MapperS.of(commodityValuationDates).<CommodityFrequencyType>map("getDayDistribution", _commodityValuationDates -> _commodityValuationDates.getDayDistribution())).andNullSafe(notExists(MapperS.of(commodityValuationDates).<Integer>map("getDayCount", _commodityValuationDates -> _commodityValuationDates.getDayCount()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityValuationDatesChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityValuationDates commodityValuationDates) {
			return Collections.emptyList();
		}
	}
}
