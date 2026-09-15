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
import fpml.consolidated.com.meta.CommodityFxMeta;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.CommodityDayTypeEnum;
import fpml.consolidated.fpmlenum.DayOfWeekEnum;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
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
 * Provision A type defining the FX observations to be used to convert the observed Commodity Reference Price to the Settlement Currency. The rate source must be specified. Additionally, a time for the spot price to be observed on that source may be specified, or else an averaging schedule for trades priced using an average FX rate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the FX observations to be used to convert the observed Commodity Reference Price to the Settlement Currency. The rate source must be specified. Additionally, a time for the spot price to be observed on that source may be specified, or else an averaging schedule for trades priced using an average FX rate.
 *
 */
@RosettaDataType(value="CommodityFx", builder=CommodityFx.CommodityFxBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityFx", model="fpml", builder=CommodityFx.CommodityFxBuilderImpl.class, version="2.1.1")
public interface CommodityFx extends RosettaModelObject {

	CommodityFxMeta metaData = new CommodityFxMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 */
	InformationSource getPrimaryRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 */
	InformationSource getSecondaryRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A type to identify how the FX rate will be applied. This is intended to differentiate between the various methods for applying FX to the floating price such as a daily calculation, or averaging the FX and applying the average at the end of each CalculationPeriod.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A type to identify how the FX rate will be applied. This is intended to differentiate between the various methods for applying FX to the floating price such as a daily calculation, or averaging the FX and applying the average at the end of each CalculationPeriod.
	 *
	 */
	CommodityFxType getFxType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parties may specify a Method of Averaging when averaging of the FX rate is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parties may specify a Method of Averaging when averaging of the FX rate is applicable.
	 *
	 */
	AveragingMethodEnum getAveragingMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time at which the spot currency exchange rate will be observed. It is specified as a time in a specific business center, e.g. 11:00am London time.
	 *
	 */
	BusinessCenterTime getFixingTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of the fx observation dates for a given Calculation Period.
	 *
	 */
	List<? extends AdjustableDates> getFxObservationDates();
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision Allows a lag to reference one already defined elsewhere in the trade.
	 *
	 */
	LagReference getLagReference();
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsDatesReference getCalculationPeriodsDatesReference();

	/*********************** Build Methods  ***********************/
	CommodityFx build();
	
	CommodityFx.CommodityFxBuilder toBuilder();
	
	static CommodityFx.CommodityFxBuilder builder() {
		return new CommodityFx.CommodityFxBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFx> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityFx> getType() {
		return CommodityFx.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.class, getSecondaryRateSource());
		processRosetta(path.newSubPath("fxType"), processor, CommodityFxType.class, getFxType());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
		processRosetta(path.newSubPath("fxObservationDates"), processor, AdjustableDates.class, getFxObservationDates());
		processor.processBasic(path.newSubPath("dayType"), CommodityDayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("dayDistribution"), processor, CommodityFrequencyType.class, getDayDistribution());
		processor.processBasic(path.newSubPath("dayCount"), Integer.class, getDayCount(), this);
		processor.processBasic(path.newSubPath("dayOfWeek"), DayOfWeekEnum.class, getDayOfWeek(), this);
		processor.processBasic(path.newSubPath("dayNumber"), Integer.class, getDayNumber(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("lag"), processor, Lag.class, getLag());
		processRosetta(path.newSubPath("lagReference"), processor, LagReference.class, getLagReference());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFxBuilder extends CommodityFx, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource();
		@Override
		InformationSource.InformationSourceBuilder getPrimaryRateSource();
		InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource();
		@Override
		InformationSource.InformationSourceBuilder getSecondaryRateSource();
		CommodityFxType.CommodityFxTypeBuilder getOrCreateFxType();
		@Override
		CommodityFxType.CommodityFxTypeBuilder getFxType();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		AdjustableDates.AdjustableDatesBuilder getOrCreateFxObservationDates(int index);
		@Override
		List<? extends AdjustableDates.AdjustableDatesBuilder> getFxObservationDates();
		CommodityFrequencyType.CommodityFrequencyTypeBuilder getOrCreateDayDistribution();
		@Override
		CommodityFrequencyType.CommodityFrequencyTypeBuilder getDayDistribution();
		Lag.LagBuilder getOrCreateLag();
		@Override
		Lag.LagBuilder getLag();
		LagReference.LagReferenceBuilder getOrCreateLagReference();
		@Override
		LagReference.LagReferenceBuilder getLagReference();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		CommodityFx.CommodityFxBuilder setPrimaryRateSource(InformationSource primaryRateSource);
		CommodityFx.CommodityFxBuilder setSecondaryRateSource(InformationSource secondaryRateSource);
		CommodityFx.CommodityFxBuilder setFxType(CommodityFxType fxType);
		CommodityFx.CommodityFxBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityFx.CommodityFxBuilder setFixingTime(BusinessCenterTime fixingTime);
		CommodityFx.CommodityFxBuilder addFxObservationDates(AdjustableDates fxObservationDates);
		CommodityFx.CommodityFxBuilder addFxObservationDates(AdjustableDates fxObservationDates, int idx);
		CommodityFx.CommodityFxBuilder addFxObservationDates(List<? extends AdjustableDates> fxObservationDates);
		CommodityFx.CommodityFxBuilder setFxObservationDates(List<? extends AdjustableDates> fxObservationDates);
		CommodityFx.CommodityFxBuilder setDayType(CommodityDayTypeEnum dayType);
		CommodityFx.CommodityFxBuilder setDayDistribution(CommodityFrequencyType dayDistribution);
		CommodityFx.CommodityFxBuilder setDayCount(Integer dayCount);
		CommodityFx.CommodityFxBuilder addDayOfWeek(DayOfWeekEnum dayOfWeek);
		CommodityFx.CommodityFxBuilder addDayOfWeek(DayOfWeekEnum dayOfWeek, int idx);
		CommodityFx.CommodityFxBuilder addDayOfWeek(List<DayOfWeekEnum> dayOfWeek);
		CommodityFx.CommodityFxBuilder setDayOfWeek(List<DayOfWeekEnum> dayOfWeek);
		CommodityFx.CommodityFxBuilder setDayNumber(Integer dayNumber);
		CommodityFx.CommodityFxBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		CommodityFx.CommodityFxBuilder setLag(Lag lag);
		CommodityFx.CommodityFxBuilder setLagReference(LagReference lagReference);
		CommodityFx.CommodityFxBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		CommodityFx.CommodityFxBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		CommodityFx.CommodityFxBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getSecondaryRateSource());
			processRosetta(path.newSubPath("fxType"), processor, CommodityFxType.CommodityFxTypeBuilder.class, getFxType());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
			processRosetta(path.newSubPath("fxObservationDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getFxObservationDates());
			processor.processBasic(path.newSubPath("dayType"), CommodityDayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("dayDistribution"), processor, CommodityFrequencyType.CommodityFrequencyTypeBuilder.class, getDayDistribution());
			processor.processBasic(path.newSubPath("dayCount"), Integer.class, getDayCount(), this);
			processor.processBasic(path.newSubPath("dayOfWeek"), DayOfWeekEnum.class, getDayOfWeek(), this);
			processor.processBasic(path.newSubPath("dayNumber"), Integer.class, getDayNumber(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("lag"), processor, Lag.LagBuilder.class, getLag());
			processRosetta(path.newSubPath("lagReference"), processor, LagReference.LagReferenceBuilder.class, getLagReference());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
		}
		

		CommodityFx.CommodityFxBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFx  ***********************/
	class CommodityFxImpl implements CommodityFx {
		private final InformationSource primaryRateSource;
		private final InformationSource secondaryRateSource;
		private final CommodityFxType fxType;
		private final AveragingMethodEnum averagingMethod;
		private final BusinessCenterTime fixingTime;
		private final List<? extends AdjustableDates> fxObservationDates;
		private final CommodityDayTypeEnum dayType;
		private final CommodityFrequencyType dayDistribution;
		private final Integer dayCount;
		private final List<DayOfWeekEnum> dayOfWeek;
		private final Integer dayNumber;
		private final BusinessDayConventionEnum businessDayConvention;
		private final Lag lag;
		private final LagReference lagReference;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		
		protected CommodityFxImpl(CommodityFx.CommodityFxBuilder builder) {
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).map(f->f.build()).orElse(null);
			this.fxType = ofNullable(builder.getFxType()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.fxObservationDates = ofNullable(builder.getFxObservationDates()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dayType = builder.getDayType();
			this.dayDistribution = ofNullable(builder.getDayDistribution()).map(f->f.build()).orElse(null);
			this.dayCount = builder.getDayCount();
			this.dayOfWeek = ofNullable(builder.getDayOfWeek()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.dayNumber = builder.getDayNumber();
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.lag = ofNullable(builder.getLag()).map(f->f.build()).orElse(null);
			this.lagReference = ofNullable(builder.getLagReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryRateSource")
		public InformationSource getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryRateSource")
		public InformationSource getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		@RosettaAttribute("fxType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxType")
		public CommodityFxType getFxType() {
			return fxType;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		@RosettaAttribute("fxObservationDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxObservationDates")
		public List<? extends AdjustableDates> getFxObservationDates() {
			return fxObservationDates;
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
		@RosettaAttribute("lag")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lag")
		public Lag getLag() {
			return lag;
		}
		
		@Override
		@RosettaAttribute("lagReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lagReference")
		public LagReference getLagReference() {
			return lagReference;
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
		public CommodityFx build() {
			return this;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder toBuilder() {
			CommodityFx.CommodityFxBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFx.CommodityFxBuilder builder) {
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
			ofNullable(getFxType()).ifPresent(builder::setFxType);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getFxObservationDates()).ifPresent(builder::setFxObservationDates);
			ofNullable(getDayType()).ifPresent(builder::setDayType);
			ofNullable(getDayDistribution()).ifPresent(builder::setDayDistribution);
			ofNullable(getDayCount()).ifPresent(builder::setDayCount);
			ofNullable(getDayOfWeek()).ifPresent(builder::setDayOfWeek);
			ofNullable(getDayNumber()).ifPresent(builder::setDayNumber);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getLag()).ifPresent(builder::setLag);
			ofNullable(getLagReference()).ifPresent(builder::setLagReference);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFx _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fxType, _that.getFxType())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!ListEquals.listEquals(fxObservationDates, _that.getFxObservationDates())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(dayDistribution, _that.getDayDistribution())) return false;
			if (!Objects.equals(dayCount, _that.getDayCount())) return false;
			if (!ListEquals.listEquals(dayOfWeek, _that.getDayOfWeek())) return false;
			if (!Objects.equals(dayNumber, _that.getDayNumber())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(lagReference, _that.getLagReference())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fxType != null ? fxType.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (fxObservationDates != null ? fxObservationDates.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayDistribution != null ? dayDistribution.hashCode() : 0);
			_result = 31 * _result + (dayCount != null ? dayCount.hashCode() : 0);
			_result = 31 * _result + (dayOfWeek != null ? dayOfWeek.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dayNumber != null ? dayNumber.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (lagReference != null ? lagReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFx {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fxType=" + this.fxType + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"fxObservationDates=" + this.fxObservationDates + ", " +
				"dayType=" + this.dayType + ", " +
				"dayDistribution=" + this.dayDistribution + ", " +
				"dayCount=" + this.dayCount + ", " +
				"dayOfWeek=" + this.dayOfWeek + ", " +
				"dayNumber=" + this.dayNumber + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"lag=" + this.lag + ", " +
				"lagReference=" + this.lagReference + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFx  ***********************/
	class CommodityFxBuilderImpl implements CommodityFx.CommodityFxBuilder {
	
		protected InformationSource.InformationSourceBuilder primaryRateSource;
		protected InformationSource.InformationSourceBuilder secondaryRateSource;
		protected CommodityFxType.CommodityFxTypeBuilder fxType;
		protected AveragingMethodEnum averagingMethod;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		protected List<AdjustableDates.AdjustableDatesBuilder> fxObservationDates = new ArrayList<>();
		protected CommodityDayTypeEnum dayType;
		protected CommodityFrequencyType.CommodityFrequencyTypeBuilder dayDistribution;
		protected Integer dayCount;
		protected List<DayOfWeekEnum> dayOfWeek = new ArrayList<>();
		protected Integer dayNumber;
		protected BusinessDayConventionEnum businessDayConvention;
		protected Lag.LagBuilder lag;
		protected LagReference.LagReferenceBuilder lagReference;
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		
		@Override
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryRateSource")
		public InformationSource.InformationSourceBuilder getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (primaryRateSource!=null) {
				result = primaryRateSource;
			}
			else {
				result = primaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryRateSource")
		public InformationSource.InformationSourceBuilder getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (secondaryRateSource!=null) {
				result = secondaryRateSource;
			}
			else {
				result = secondaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxType")
		public CommodityFxType.CommodityFxTypeBuilder getFxType() {
			return fxType;
		}
		
		@Override
		public CommodityFxType.CommodityFxTypeBuilder getOrCreateFxType() {
			CommodityFxType.CommodityFxTypeBuilder result;
			if (fxType!=null) {
				result = fxType;
			}
			else {
				result = fxType = CommodityFxType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxObservationDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxObservationDates")
		public List<? extends AdjustableDates.AdjustableDatesBuilder> getFxObservationDates() {
			return fxObservationDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateFxObservationDates(int index) {
			if (fxObservationDates==null) {
				this.fxObservationDates = new ArrayList<>();
			}
			return getIndex(fxObservationDates, index, () -> {
						AdjustableDates.AdjustableDatesBuilder newFxObservationDates = AdjustableDates.builder();
						return newFxObservationDates;
					});
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
		@RosettaAttribute("lagReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lagReference")
		public LagReference.LagReferenceBuilder getLagReference() {
			return lagReference;
		}
		
		@Override
		public LagReference.LagReferenceBuilder getOrCreateLagReference() {
			LagReference.LagReferenceBuilder result;
			if (lagReference!=null) {
				result = lagReference;
			}
			else {
				result = lagReference = LagReference.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryRateSource")
		@Override
		public CommodityFx.CommodityFxBuilder setPrimaryRateSource(InformationSource _primaryRateSource) {
			this.primaryRateSource = _primaryRateSource == null ? null : _primaryRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryRateSource")
		@Override
		public CommodityFx.CommodityFxBuilder setSecondaryRateSource(InformationSource _secondaryRateSource) {
			this.secondaryRateSource = _secondaryRateSource == null ? null : _secondaryRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxType")
		@Override
		public CommodityFx.CommodityFxBuilder setFxType(CommodityFxType _fxType) {
			this.fxType = _fxType == null ? null : _fxType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public CommodityFx.CommodityFxBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingTime")
		@Override
		public CommodityFx.CommodityFxBuilder setFixingTime(BusinessCenterTime _fixingTime) {
			this.fixingTime = _fixingTime == null ? null : _fixingTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxObservationDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fxObservationDates")
		@Override
		public CommodityFx.CommodityFxBuilder addFxObservationDates(AdjustableDates _fxObservationDates) {
			if (_fxObservationDates != null) {
				this.fxObservationDates.add(_fxObservationDates.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder addFxObservationDates(AdjustableDates _fxObservationDates, int idx) {
			getIndex(this.fxObservationDates, idx, () -> _fxObservationDates.toBuilder());
			return this;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder addFxObservationDates(List<? extends AdjustableDates> fxObservationDatess) {
			if (fxObservationDatess != null) {
				for (final AdjustableDates toAdd : fxObservationDatess) {
					this.fxObservationDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fxObservationDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fxObservationDates")
		@Override
		public CommodityFx.CommodityFxBuilder setFxObservationDates(List<? extends AdjustableDates> fxObservationDatess) {
			if (fxObservationDatess == null) {
				this.fxObservationDates = new ArrayList<>();
			} else {
				this.fxObservationDates = fxObservationDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayType")
		@Override
		public CommodityFx.CommodityFxBuilder setDayType(CommodityDayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("dayDistribution")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayDistribution")
		@Override
		public CommodityFx.CommodityFxBuilder setDayDistribution(CommodityFrequencyType _dayDistribution) {
			this.dayDistribution = _dayDistribution == null ? null : _dayDistribution.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCount")
		@Override
		public CommodityFx.CommodityFxBuilder setDayCount(Integer _dayCount) {
			this.dayCount = _dayCount == null ? null : _dayCount;
			return this;
		}
		
		@RosettaAttribute("dayOfWeek")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dayOfWeek")
		@Override
		public CommodityFx.CommodityFxBuilder addDayOfWeek(DayOfWeekEnum _dayOfWeek) {
			if (_dayOfWeek != null) {
				this.dayOfWeek.add(_dayOfWeek);
			}
			return this;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder addDayOfWeek(DayOfWeekEnum _dayOfWeek, int idx) {
			getIndex(this.dayOfWeek, idx, () -> _dayOfWeek);
			return this;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder addDayOfWeek(List<DayOfWeekEnum> dayOfWeeks) {
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
		public CommodityFx.CommodityFxBuilder setDayOfWeek(List<DayOfWeekEnum> dayOfWeeks) {
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
		public CommodityFx.CommodityFxBuilder setDayNumber(Integer _dayNumber) {
			this.dayNumber = _dayNumber == null ? null : _dayNumber;
			return this;
		}
		
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessDayConvention")
		@Override
		public CommodityFx.CommodityFxBuilder setBusinessDayConvention(BusinessDayConventionEnum _businessDayConvention) {
			this.businessDayConvention = _businessDayConvention == null ? null : _businessDayConvention;
			return this;
		}
		
		@RosettaAttribute("lag")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lag")
		@Override
		public CommodityFx.CommodityFxBuilder setLag(Lag _lag) {
			this.lag = _lag == null ? null : _lag.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lagReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lagReference")
		@Override
		public CommodityFx.CommodityFxBuilder setLagReference(LagReference _lagReference) {
			this.lagReference = _lagReference == null ? null : _lagReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public CommodityFx.CommodityFxBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public CommodityFx.CommodityFxBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public CommodityFx.CommodityFxBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFx build() {
			return new CommodityFx.CommodityFxImpl(this);
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFx.CommodityFxBuilder prune() {
			if (primaryRateSource!=null && !primaryRateSource.prune().hasData()) primaryRateSource = null;
			if (secondaryRateSource!=null && !secondaryRateSource.prune().hasData()) secondaryRateSource = null;
			if (fxType!=null && !fxType.prune().hasData()) fxType = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			fxObservationDates = fxObservationDates.stream().filter(b->b!=null).<AdjustableDates.AdjustableDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (dayDistribution!=null && !dayDistribution.prune().hasData()) dayDistribution = null;
			if (lag!=null && !lag.prune().hasData()) lag = null;
			if (lagReference!=null && !lagReference.prune().hasData()) lagReference = null;
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryRateSource()!=null && getPrimaryRateSource().hasData()) return true;
			if (getSecondaryRateSource()!=null && getSecondaryRateSource().hasData()) return true;
			if (getFxType()!=null && getFxType().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getFxObservationDates()!=null && getFxObservationDates().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDayType()!=null) return true;
			if (getDayDistribution()!=null && getDayDistribution().hasData()) return true;
			if (getDayCount()!=null) return true;
			if (getDayOfWeek()!=null && !getDayOfWeek().isEmpty()) return true;
			if (getDayNumber()!=null) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getLag()!=null && getLag().hasData()) return true;
			if (getLagReference()!=null && getLagReference().hasData()) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFx.CommodityFxBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFx.CommodityFxBuilder o = (CommodityFx.CommodityFxBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::setSecondaryRateSource);
			merger.mergeRosetta(getFxType(), o.getFxType(), this::setFxType);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getFxObservationDates(), o.getFxObservationDates(), this::getOrCreateFxObservationDates);
			merger.mergeRosetta(getDayDistribution(), o.getDayDistribution(), this::setDayDistribution);
			merger.mergeRosetta(getLag(), o.getLag(), this::setLag);
			merger.mergeRosetta(getLagReference(), o.getLagReference(), this::setLagReference);
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			merger.mergeBasic(getDayCount(), o.getDayCount(), this::setDayCount);
			merger.mergeBasic(getDayOfWeek(), o.getDayOfWeek(), (Consumer<DayOfWeekEnum>) this::addDayOfWeek);
			merger.mergeBasic(getDayNumber(), o.getDayNumber(), this::setDayNumber);
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFx _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fxType, _that.getFxType())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!ListEquals.listEquals(fxObservationDates, _that.getFxObservationDates())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(dayDistribution, _that.getDayDistribution())) return false;
			if (!Objects.equals(dayCount, _that.getDayCount())) return false;
			if (!ListEquals.listEquals(dayOfWeek, _that.getDayOfWeek())) return false;
			if (!Objects.equals(dayNumber, _that.getDayNumber())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(lagReference, _that.getLagReference())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fxType != null ? fxType.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (fxObservationDates != null ? fxObservationDates.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayDistribution != null ? dayDistribution.hashCode() : 0);
			_result = 31 * _result + (dayCount != null ? dayCount.hashCode() : 0);
			_result = 31 * _result + (dayOfWeek != null ? dayOfWeek.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dayNumber != null ? dayNumber.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (lagReference != null ? lagReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fxType=" + this.fxType + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"fxObservationDates=" + this.fxObservationDates + ", " +
				"dayType=" + this.dayType + ", " +
				"dayDistribution=" + this.dayDistribution + ", " +
				"dayCount=" + this.dayCount + ", " +
				"dayOfWeek=" + this.dayOfWeek + ", " +
				"dayNumber=" + this.dayNumber + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"lag=" + this.lag + ", " +
				"lagReference=" + this.lagReference + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}
}
