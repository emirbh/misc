package fpml.consolidated.com;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.com.meta.CommodityValuationDatesMeta;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.CalendarSourceEnum;
import fpml.consolidated.fpmlenum.CommodityDayTypeEnum;
import fpml.consolidated.fpmlenum.DayOfWeekEnum;
import fpml.consolidated.shared.AdjustableDates;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The dates on which prices are observed for the underlyer.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The dates on which prices are observed for the underlyer.
 *
 */
@RosettaDataType(value="CommodityValuationDates", builder=CommodityValuationDates.CommodityValuationDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityValuationDates", model="fpml", builder=CommodityValuationDates.CommodityValuationDatesBuilderImpl.class, version="2.1.1")
public interface CommodityValuationDates extends RosettaModelObject {

	CommodityValuationDatesMeta metaData = new CommodityValuationDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsReference getCalculationPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 */
	CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsDatesReference getCalculationPeriodsDatesReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
	 *
	 */
	Lag getLag();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of day on which pricing occurs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of day on which pricing occurs.
	 *
	 */
	CommodityDayTypeEnum getDayType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method by which the pricing days are distributed across the pricing period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method by which the pricing days are distributed across the pricing period.
	 *
	 */
	CommodityFrequencyType getDayDistribution();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of days over which pricing should take place.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of days over which pricing should take place.
	 *
	 */
	Integer getDayCount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day(s) of the week on which pricing will take place during the pricing period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day(s) of the week on which pricing will take place during the pricing period.
	 *
	 */
	List<DayOfWeekEnum> getDayOfWeek();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The occurrence of the dayOfWeek within the pricing period on which pricing will take place, e.g. the 3rd Friday within each Calculation Period. If omitted, every dayOfWeek will be a pricing day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The occurrence of the dayOfWeek within the pricing period on which pricing will take place, e.g. the 3rd Friday within each Calculation Period. If omitted, every dayOfWeek will be a pricing day.
	 *
	 */
	Integer getDayNumber();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 *
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies a commodity business day calendar from which the pricing dates will be determined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies a commodity business day calendar from which the pricing dates will be determined.
	 *
	 */
	CommodityBusinessCalendar getBusinessCalendar();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if “Future” is chosen, the pricing will roll to the next futures contract on expiration, if “ListedOption” is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if “Future” is chosen, the pricing will roll to the next futures contract on expiration, if “ListedOption” is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
	 *
	 */
	CalendarSourceEnum getCalendarSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a set of Settlement Periods associated with an Electricity Transaction for delivery on an Applicable Day or for a series of Applicable Days.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a set of Settlement Periods associated with an Electricity Transaction for delivery on an Applicable Day or for a series of Applicable Days.
	 *
	 */
	List<? extends SettlementPeriods> getSettlementPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows a set of Settlement Periods to reference one already defined elsewhere in the trade structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows a set of Settlement Periods to reference one already defined elsewhere in the trade structure.
	 *
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A list of adjustable dates on which the trade will price. Each date will price for the Calculation Period within which it falls.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of adjustable dates on which the trade will price. Each date will price for the Calculation Period within which it falls.
	 *
	 */
	List<? extends AdjustableDates> getValuationDates();

	/*********************** Build Methods  ***********************/
	CommodityValuationDates build();
	
	CommodityValuationDates.CommodityValuationDatesBuilder toBuilder();
	
	static CommodityValuationDates.CommodityValuationDatesBuilder builder() {
		return new CommodityValuationDates.CommodityValuationDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityValuationDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityValuationDates> getType() {
		return CommodityValuationDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
		processRosetta(path.newSubPath("lag"), processor, Lag.class, getLag());
		processor.processBasic(path.newSubPath("dayType"), CommodityDayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("dayDistribution"), processor, CommodityFrequencyType.class, getDayDistribution());
		processor.processBasic(path.newSubPath("dayCount"), Integer.class, getDayCount(), this);
		processor.processBasic(path.newSubPath("dayOfWeek"), DayOfWeekEnum.class, getDayOfWeek(), this);
		processor.processBasic(path.newSubPath("dayNumber"), Integer.class, getDayNumber(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCalendar"), processor, CommodityBusinessCalendar.class, getBusinessCalendar());
		processor.processBasic(path.newSubPath("calendarSource"), CalendarSourceEnum.class, getCalendarSource(), this);
		processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.class, getSettlementPeriods());
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
		processRosetta(path.newSubPath("valuationDates"), processor, AdjustableDates.class, getValuationDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityValuationDatesBuilder extends CommodityValuationDates, RosettaModelObjectBuilder {
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		Lag.LagBuilder getOrCreateLag();
		@Override
		Lag.LagBuilder getLag();
		CommodityFrequencyType.CommodityFrequencyTypeBuilder getOrCreateDayDistribution();
		@Override
		CommodityFrequencyType.CommodityFrequencyTypeBuilder getDayDistribution();
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateBusinessCalendar();
		@Override
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getBusinessCalendar();
		SettlementPeriods.SettlementPeriodsBuilder getOrCreateSettlementPeriods(int index);
		@Override
		List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods();
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int index);
		@Override
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		AdjustableDates.AdjustableDatesBuilder getOrCreateValuationDates(int index);
		@Override
		List<? extends AdjustableDates.AdjustableDatesBuilder> getValuationDates();
		CommodityValuationDates.CommodityValuationDatesBuilder setId(String id);
		CommodityValuationDates.CommodityValuationDatesBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		CommodityValuationDates.CommodityValuationDatesBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		CommodityValuationDates.CommodityValuationDatesBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);
		CommodityValuationDates.CommodityValuationDatesBuilder setLag(Lag lag);
		CommodityValuationDates.CommodityValuationDatesBuilder setDayType(CommodityDayTypeEnum dayType);
		CommodityValuationDates.CommodityValuationDatesBuilder setDayDistribution(CommodityFrequencyType dayDistribution);
		CommodityValuationDates.CommodityValuationDatesBuilder setDayCount(Integer dayCount);
		CommodityValuationDates.CommodityValuationDatesBuilder addDayOfWeek(DayOfWeekEnum dayOfWeek);
		CommodityValuationDates.CommodityValuationDatesBuilder addDayOfWeek(DayOfWeekEnum dayOfWeek, int idx);
		CommodityValuationDates.CommodityValuationDatesBuilder addDayOfWeek(List<DayOfWeekEnum> dayOfWeek);
		CommodityValuationDates.CommodityValuationDatesBuilder setDayOfWeek(List<DayOfWeekEnum> dayOfWeek);
		CommodityValuationDates.CommodityValuationDatesBuilder setDayNumber(Integer dayNumber);
		CommodityValuationDates.CommodityValuationDatesBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		CommodityValuationDates.CommodityValuationDatesBuilder setBusinessCalendar(CommodityBusinessCalendar businessCalendar);
		CommodityValuationDates.CommodityValuationDatesBuilder setCalendarSource(CalendarSourceEnum calendarSource);
		CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriods(SettlementPeriods settlementPeriods);
		CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriods(SettlementPeriods settlementPeriods, int idx);
		CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods);
		CommodityValuationDates.CommodityValuationDatesBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods);
		CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference);
		CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int idx);
		CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);
		CommodityValuationDates.CommodityValuationDatesBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);
		CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(AdjustableDates valuationDates);
		CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(AdjustableDates valuationDates, int idx);
		CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(List<? extends AdjustableDates> valuationDates);
		CommodityValuationDates.CommodityValuationDatesBuilder setValuationDates(List<? extends AdjustableDates> valuationDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
			processRosetta(path.newSubPath("lag"), processor, Lag.LagBuilder.class, getLag());
			processor.processBasic(path.newSubPath("dayType"), CommodityDayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("dayDistribution"), processor, CommodityFrequencyType.CommodityFrequencyTypeBuilder.class, getDayDistribution());
			processor.processBasic(path.newSubPath("dayCount"), Integer.class, getDayCount(), this);
			processor.processBasic(path.newSubPath("dayOfWeek"), DayOfWeekEnum.class, getDayOfWeek(), this);
			processor.processBasic(path.newSubPath("dayNumber"), Integer.class, getDayNumber(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCalendar"), processor, CommodityBusinessCalendar.CommodityBusinessCalendarBuilder.class, getBusinessCalendar());
			processor.processBasic(path.newSubPath("calendarSource"), CalendarSourceEnum.class, getCalendarSource(), this);
			processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.SettlementPeriodsBuilder.class, getSettlementPeriods());
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
			processRosetta(path.newSubPath("valuationDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getValuationDates());
		}
		

		CommodityValuationDates.CommodityValuationDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityValuationDates  ***********************/
	class CommodityValuationDatesImpl implements CommodityValuationDates {
		private final String id;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		private final Lag lag;
		private final CommodityDayTypeEnum dayType;
		private final CommodityFrequencyType dayDistribution;
		private final Integer dayCount;
		private final List<DayOfWeekEnum> dayOfWeek;
		private final Integer dayNumber;
		private final BusinessDayConventionEnum businessDayConvention;
		private final CommodityBusinessCalendar businessCalendar;
		private final CalendarSourceEnum calendarSource;
		private final List<? extends SettlementPeriods> settlementPeriods;
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		private final List<? extends AdjustableDates> valuationDates;
		
		protected CommodityValuationDatesImpl(CommodityValuationDates.CommodityValuationDatesBuilder builder) {
			this.id = builder.getId();
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
			this.lag = ofNullable(builder.getLag()).map(f->f.build()).orElse(null);
			this.dayType = builder.getDayType();
			this.dayDistribution = ofNullable(builder.getDayDistribution()).map(f->f.build()).orElse(null);
			this.dayCount = builder.getDayCount();
			this.dayOfWeek = ofNullable(builder.getDayOfWeek()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.dayNumber = builder.getDayNumber();
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.businessCalendar = ofNullable(builder.getBusinessCalendar()).map(f->f.build()).orElse(null);
			this.calendarSource = builder.getCalendarSource();
			this.settlementPeriods = ofNullable(builder.getSettlementPeriods()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		@RosettaAttribute("lag")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lag")
		public Lag getLag() {
			return lag;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayType")
		public CommodityDayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("dayDistribution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayDistribution")
		public CommodityFrequencyType getDayDistribution() {
			return dayDistribution;
		}
		
		@Override
		@RosettaAttribute("dayCount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCount")
		public Integer getDayCount() {
			return dayCount;
		}
		
		@Override
		@RosettaAttribute("dayOfWeek")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dayOfWeek")
		public List<DayOfWeekEnum> getDayOfWeek() {
			return dayOfWeek;
		}
		
		@Override
		@RosettaAttribute("dayNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayNumber")
		public Integer getDayNumber() {
			return dayNumber;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCalendar")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCalendar")
		public CommodityBusinessCalendar getBusinessCalendar() {
			return businessCalendar;
		}
		
		@Override
		@RosettaAttribute("calendarSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calendarSource")
		public CalendarSourceEnum getCalendarSource() {
			return calendarSource;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriods")
		public List<? extends SettlementPeriods> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationDates")
		public List<? extends AdjustableDates> getValuationDates() {
			return valuationDates;
		}
		
		@Override
		public CommodityValuationDates build() {
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder toBuilder() {
			CommodityValuationDates.CommodityValuationDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityValuationDates.CommodityValuationDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
			ofNullable(getLag()).ifPresent(builder::setLag);
			ofNullable(getDayType()).ifPresent(builder::setDayType);
			ofNullable(getDayDistribution()).ifPresent(builder::setDayDistribution);
			ofNullable(getDayCount()).ifPresent(builder::setDayCount);
			ofNullable(getDayOfWeek()).ifPresent(builder::setDayOfWeek);
			ofNullable(getDayNumber()).ifPresent(builder::setDayNumber);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getBusinessCalendar()).ifPresent(builder::setBusinessCalendar);
			ofNullable(getCalendarSource()).ifPresent(builder::setCalendarSource);
			ofNullable(getSettlementPeriods()).ifPresent(builder::setSettlementPeriods);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityValuationDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(dayDistribution, _that.getDayDistribution())) return false;
			if (!Objects.equals(dayCount, _that.getDayCount())) return false;
			if (!ListEquals.listEquals(dayOfWeek, _that.getDayOfWeek())) return false;
			if (!Objects.equals(dayNumber, _that.getDayNumber())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCalendar, _that.getBusinessCalendar())) return false;
			if (!Objects.equals(calendarSource, _that.getCalendarSource())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			if (!ListEquals.listEquals(valuationDates, _that.getValuationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayDistribution != null ? dayDistribution.hashCode() : 0);
			_result = 31 * _result + (dayCount != null ? dayCount.hashCode() : 0);
			_result = 31 * _result + (dayOfWeek != null ? dayOfWeek.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dayNumber != null ? dayNumber.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCalendar != null ? businessCalendar.hashCode() : 0);
			_result = 31 * _result + (calendarSource != null ? calendarSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityValuationDates {" +
				"id=" + this.id + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference + ", " +
				"lag=" + this.lag + ", " +
				"dayType=" + this.dayType + ", " +
				"dayDistribution=" + this.dayDistribution + ", " +
				"dayCount=" + this.dayCount + ", " +
				"dayOfWeek=" + this.dayOfWeek + ", " +
				"dayNumber=" + this.dayNumber + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCalendar=" + this.businessCalendar + ", " +
				"calendarSource=" + this.calendarSource + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference + ", " +
				"valuationDates=" + this.valuationDates +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityValuationDates  ***********************/
	class CommodityValuationDatesBuilderImpl implements CommodityValuationDates.CommodityValuationDatesBuilder {
	
		protected String id;
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		protected Lag.LagBuilder lag;
		protected CommodityDayTypeEnum dayType;
		protected CommodityFrequencyType.CommodityFrequencyTypeBuilder dayDistribution;
		protected Integer dayCount;
		protected List<DayOfWeekEnum> dayOfWeek = new ArrayList<>();
		protected Integer dayNumber;
		protected BusinessDayConventionEnum businessDayConvention;
		protected CommodityBusinessCalendar.CommodityBusinessCalendarBuilder businessCalendar;
		protected CalendarSourceEnum calendarSource;
		protected List<SettlementPeriods.SettlementPeriodsBuilder> settlementPeriods = new ArrayList<>();
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
		protected List<AdjustableDates.AdjustableDatesBuilder> valuationDates = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (calculationPeriodsReference!=null) {
				result = calculationPeriodsReference;
			}
			else {
				result = calculationPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder result;
			if (calculationPeriodsScheduleReference!=null) {
				result = calculationPeriodsScheduleReference;
			}
			else {
				result = calculationPeriodsScheduleReference = CalculationPeriodsScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference() {
			CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder result;
			if (calculationPeriodsDatesReference!=null) {
				result = calculationPeriodsDatesReference;
			}
			else {
				result = calculationPeriodsDatesReference = CalculationPeriodsDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lag")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lag")
		public Lag.LagBuilder getLag() {
			return lag;
		}
		
		@Override
		public Lag.LagBuilder getOrCreateLag() {
			Lag.LagBuilder result;
			if (lag!=null) {
				result = lag;
			}
			else {
				result = lag = Lag.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayType")
		public CommodityDayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("dayDistribution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayDistribution")
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder getDayDistribution() {
			return dayDistribution;
		}
		
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder getOrCreateDayDistribution() {
			CommodityFrequencyType.CommodityFrequencyTypeBuilder result;
			if (dayDistribution!=null) {
				result = dayDistribution;
			}
			else {
				result = dayDistribution = CommodityFrequencyType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCount")
		public Integer getDayCount() {
			return dayCount;
		}
		
		@Override
		@RosettaAttribute("dayOfWeek")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dayOfWeek")
		public List<DayOfWeekEnum> getDayOfWeek() {
			return dayOfWeek;
		}
		
		@Override
		@RosettaAttribute("dayNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayNumber")
		public Integer getDayNumber() {
			return dayNumber;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCalendar")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCalendar")
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getBusinessCalendar() {
			return businessCalendar;
		}
		
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateBusinessCalendar() {
			CommodityBusinessCalendar.CommodityBusinessCalendarBuilder result;
			if (businessCalendar!=null) {
				result = businessCalendar;
			}
			else {
				result = businessCalendar = CommodityBusinessCalendar.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calendarSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calendarSource")
		public CalendarSourceEnum getCalendarSource() {
			return calendarSource;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriods")
		public List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder getOrCreateSettlementPeriods(int index) {
			if (settlementPeriods==null) {
				this.settlementPeriods = new ArrayList<>();
			}
			return getIndex(settlementPeriods, index, () -> {
						SettlementPeriods.SettlementPeriodsBuilder newSettlementPeriods = SettlementPeriods.builder();
						return newSettlementPeriods;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int index) {
			if (settlementPeriodsReference==null) {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			return getIndex(settlementPeriodsReference, index, () -> {
						SettlementPeriodsReference.SettlementPeriodsReferenceBuilder newSettlementPeriodsReference = SettlementPeriodsReference.builder();
						return newSettlementPeriodsReference;
					});
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationDates")
		public List<? extends AdjustableDates.AdjustableDatesBuilder> getValuationDates() {
			return valuationDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateValuationDates(int index) {
			if (valuationDates==null) {
				this.valuationDates = new ArrayList<>();
			}
			return getIndex(valuationDates, index, () -> {
						AdjustableDates.AdjustableDatesBuilder newValuationDates = AdjustableDates.builder();
						return newValuationDates;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lag")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lag")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setLag(Lag _lag) {
			this.lag = _lag == null ? null : _lag.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayType")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setDayType(CommodityDayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("dayDistribution")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayDistribution")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setDayDistribution(CommodityFrequencyType _dayDistribution) {
			this.dayDistribution = _dayDistribution == null ? null : _dayDistribution.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCount")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setDayCount(Integer _dayCount) {
			this.dayCount = _dayCount == null ? null : _dayCount;
			return this;
		}
		
		@RosettaAttribute("dayOfWeek")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dayOfWeek")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addDayOfWeek(DayOfWeekEnum _dayOfWeek) {
			if (_dayOfWeek != null) {
				this.dayOfWeek.add(_dayOfWeek);
			}
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addDayOfWeek(DayOfWeekEnum _dayOfWeek, int idx) {
			getIndex(this.dayOfWeek, idx, () -> _dayOfWeek);
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addDayOfWeek(List<DayOfWeekEnum> dayOfWeeks) {
			if (dayOfWeeks != null) {
				for (final DayOfWeekEnum toAdd : dayOfWeeks) {
					this.dayOfWeek.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("dayOfWeek")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dayOfWeek")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setDayOfWeek(List<DayOfWeekEnum> dayOfWeeks) {
			if (dayOfWeeks == null) {
				this.dayOfWeek = new ArrayList<>();
			} else {
				this.dayOfWeek = dayOfWeeks.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dayNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayNumber")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setDayNumber(Integer _dayNumber) {
			this.dayNumber = _dayNumber == null ? null : _dayNumber;
			return this;
		}
		
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessDayConvention")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setBusinessDayConvention(BusinessDayConventionEnum _businessDayConvention) {
			this.businessDayConvention = _businessDayConvention == null ? null : _businessDayConvention;
			return this;
		}
		
		@RosettaAttribute("businessCalendar")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCalendar")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setBusinessCalendar(CommodityBusinessCalendar _businessCalendar) {
			this.businessCalendar = _businessCalendar == null ? null : _businessCalendar.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calendarSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calendarSource")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setCalendarSource(CalendarSourceEnum _calendarSource) {
			this.calendarSource = _calendarSource == null ? null : _calendarSource;
			return this;
		}
		
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriods")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriods(SettlementPeriods _settlementPeriods) {
			if (_settlementPeriods != null) {
				this.settlementPeriods.add(_settlementPeriods.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriods(SettlementPeriods _settlementPeriods, int idx) {
			getIndex(this.settlementPeriods, idx, () -> _settlementPeriods.toBuilder());
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
			if (settlementPeriodss != null) {
				for (final SettlementPeriods toAdd : settlementPeriodss) {
					this.settlementPeriods.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriods")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
			if (settlementPeriodss == null) {
				this.settlementPeriods = new ArrayList<>();
			} else {
				this.settlementPeriods = settlementPeriodss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference) {
			if (_settlementPeriodsReference != null) {
				this.settlementPeriodsReference.add(_settlementPeriodsReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference, int idx) {
			getIndex(this.settlementPeriodsReference, idx, () -> _settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (final SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences == null) {
				this.settlementPeriodsReference = new ArrayList<>();
			} else {
				this.settlementPeriodsReference = settlementPeriodsReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("valuationDates")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(AdjustableDates _valuationDates) {
			if (_valuationDates != null) {
				this.valuationDates.add(_valuationDates.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(AdjustableDates _valuationDates, int idx) {
			getIndex(this.valuationDates, idx, () -> _valuationDates.toBuilder());
			return this;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder addValuationDates(List<? extends AdjustableDates> valuationDatess) {
			if (valuationDatess != null) {
				for (final AdjustableDates toAdd : valuationDatess) {
					this.valuationDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("valuationDates")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder setValuationDates(List<? extends AdjustableDates> valuationDatess) {
			if (valuationDatess == null) {
				this.valuationDates = new ArrayList<>();
			} else {
				this.valuationDates = valuationDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityValuationDates build() {
			return new CommodityValuationDates.CommodityValuationDatesImpl(this);
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder prune() {
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			if (lag!=null && !lag.prune().hasData()) lag = null;
			if (dayDistribution!=null && !dayDistribution.prune().hasData()) dayDistribution = null;
			if (businessCalendar!=null && !businessCalendar.prune().hasData()) businessCalendar = null;
			settlementPeriods = settlementPeriods.stream().filter(b->b!=null).<SettlementPeriods.SettlementPeriodsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			valuationDates = valuationDates.stream().filter(b->b!=null).<AdjustableDates.AdjustableDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			if (getLag()!=null && getLag().hasData()) return true;
			if (getDayType()!=null) return true;
			if (getDayDistribution()!=null && getDayDistribution().hasData()) return true;
			if (getDayCount()!=null) return true;
			if (getDayOfWeek()!=null && !getDayOfWeek().isEmpty()) return true;
			if (getDayNumber()!=null) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getBusinessCalendar()!=null && getBusinessCalendar().hasData()) return true;
			if (getCalendarSource()!=null) return true;
			if (getSettlementPeriods()!=null && getSettlementPeriods().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getValuationDates()!=null && getValuationDates().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityValuationDates.CommodityValuationDatesBuilder o = (CommodityValuationDates.CommodityValuationDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			merger.mergeRosetta(getLag(), o.getLag(), this::setLag);
			merger.mergeRosetta(getDayDistribution(), o.getDayDistribution(), this::setDayDistribution);
			merger.mergeRosetta(getBusinessCalendar(), o.getBusinessCalendar(), this::setBusinessCalendar);
			merger.mergeRosetta(getSettlementPeriods(), o.getSettlementPeriods(), this::getOrCreateSettlementPeriods);
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::getOrCreateValuationDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			merger.mergeBasic(getDayCount(), o.getDayCount(), this::setDayCount);
			merger.mergeBasic(getDayOfWeek(), o.getDayOfWeek(), (Consumer<DayOfWeekEnum>) this::addDayOfWeek);
			merger.mergeBasic(getDayNumber(), o.getDayNumber(), this::setDayNumber);
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			merger.mergeBasic(getCalendarSource(), o.getCalendarSource(), this::setCalendarSource);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityValuationDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(dayDistribution, _that.getDayDistribution())) return false;
			if (!Objects.equals(dayCount, _that.getDayCount())) return false;
			if (!ListEquals.listEquals(dayOfWeek, _that.getDayOfWeek())) return false;
			if (!Objects.equals(dayNumber, _that.getDayNumber())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCalendar, _that.getBusinessCalendar())) return false;
			if (!Objects.equals(calendarSource, _that.getCalendarSource())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			if (!ListEquals.listEquals(valuationDates, _that.getValuationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayDistribution != null ? dayDistribution.hashCode() : 0);
			_result = 31 * _result + (dayCount != null ? dayCount.hashCode() : 0);
			_result = 31 * _result + (dayOfWeek != null ? dayOfWeek.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dayNumber != null ? dayNumber.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCalendar != null ? businessCalendar.hashCode() : 0);
			_result = 31 * _result + (calendarSource != null ? calendarSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityValuationDatesBuilder {" +
				"id=" + this.id + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference + ", " +
				"lag=" + this.lag + ", " +
				"dayType=" + this.dayType + ", " +
				"dayDistribution=" + this.dayDistribution + ", " +
				"dayCount=" + this.dayCount + ", " +
				"dayOfWeek=" + this.dayOfWeek + ", " +
				"dayNumber=" + this.dayNumber + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCalendar=" + this.businessCalendar + ", " +
				"calendarSource=" + this.calendarSource + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference + ", " +
				"valuationDates=" + this.valuationDates +
			'}';
		}
	}
}
