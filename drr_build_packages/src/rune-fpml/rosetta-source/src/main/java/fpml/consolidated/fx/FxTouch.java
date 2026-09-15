package fpml.consolidated.fx;

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
import fpml.consolidated.fpmlenum.TouchConditionEnum;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.fx.meta.FxTouchMeta;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Describes an american or discrete touch or no-touch trigger applied to an FX binary or digital option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes an american or discrete touch or no-touch trigger applied to an FX binary or digital option.
 *
 */
@RosettaDataType(value="FxTouch", builder=FxTouch.FxTouchBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTouch", model="fpml", builder=FxTouch.FxTouchBuilderImpl.class, version="2.1.1")
public interface FxTouch extends RosettaModelObject {

	FxTouchMeta metaData = new FxTouchMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This specifies whether the applied trigger is a touch or no touch type.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This specifies whether the applied trigger is a touch or no touch type.
	 *
	 */
	TouchConditionEnum getTouchCondition();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This specifies whether the trigger direction is "AtOrAbove" or "AtOrBelow; that is, that a barrier event occurs if the spot rate is at or above the trigger rate, or at or below the trigger rate during the period of observation of an american trigger, or at the times of observation of a discrete trigger. DEPRECATE: Values "Above" and "Below" are deprecated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This specifies whether the trigger direction is "AtOrAbove" or "AtOrBelow; that is, that a barrier event occurs if the spot rate is at or above the trigger rate, or at or below the trigger rate during the period of observation of an american trigger, or at the times of observation of a discrete trigger. DEPRECATE: Values "Above" and "Below" are deprecated.
	 *
	 */
	TriggerConditionEnum getDirection();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The market rate is observed relative to the trigger rate, and if it is found to be on the predefined side of (above or below) the trigger rate, a barrier event is deemed to have occurred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The market rate is observed relative to the trigger rate, and if it is found to be on the predefined side of (above or below) the trigger rate, a barrier event is deemed to have occurred.
	 *
	 */
	BigDecimal getTriggerRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the market rate needs to move "up" or "down" to trigger a barrier event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the market rate needs to move "up" or "down" to trigger a barrier event.
	 *
	 */
	BigDecimal getSpotRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 *
	 */
	List<? extends InformationSource> getInformationSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the observation period for an american trigger starts. If the start date is not present, then the date and time of the start of the period is deemed to be the date and time the transaction was entered into.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the observation period for an american trigger starts. If the start date is not present, then the date and time of the start of the period is deemed to be the date and time the transaction was entered into.
	 *
	 */
	ZonedDateTime getObservationStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time on the start date at which the observation period for an american trigger starts. If the time is not present and the start date is equivalent to the transaction date, the time is deemed to be the time the transaction was entered into. If the time is not present and the start date is other than the transaction date, then the time is deemed to be the same as the expiration time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time on the start date at which the observation period for an american trigger starts. If the time is not present and the start date is equivalent to the transaction date, the time is deemed to be the time the transaction was entered into. If the time is not present and the start date is other than the transaction date, then the time is deemed to be the same as the expiration time.
	 *
	 */
	BusinessCenterTime getObservationStartTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the observation period for an american trigger ends. If the end date is not present, then the date and time of the end of the period is deemed to be the date and time of expiration.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the observation period for an american trigger ends. If the end date is not present, then the date and time of the end of the period is deemed to be the date and time of expiration.
	 *
	 */
	ZonedDateTime getObservationEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time on the end date at which the observation period for an american trigger ends. If the time is not present, then the time is deemed to be the same as the expiration time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time on the end date at which the observation period for an american trigger ends. If the time is not present, then the time is deemed to be the same as the expiration time.
	 *
	 */
	BusinessCenterTime getObservationEndTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The dates and times at which rate observations are made to determine whether a barrier event has occurred for a discrete trigger. If the time is not present then the time is deemed to be the same as the expiration time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The dates and times at which rate observations are made to determine whether a barrier event has occurred for a discrete trigger. If the time is not present then the time is deemed to be the same as the expiration time.
	 *
	 */
	List<? extends FxBusinessCenterDateTime> getObservationPoint();

	/*********************** Build Methods  ***********************/
	FxTouch build();
	
	FxTouch.FxTouchBuilder toBuilder();
	
	static FxTouch.FxTouchBuilder builder() {
		return new FxTouch.FxTouchBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTouch> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTouch> getType() {
		return FxTouch.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("touchCondition"), TouchConditionEnum.class, getTouchCondition(), this);
		processor.processBasic(path.newSubPath("direction"), TriggerConditionEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
		processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.class, getObservationStartTime());
		processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
		processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.class, getObservationEndTime());
		processRosetta(path.newSubPath("observationPoint"), processor, FxBusinessCenterDateTime.class, getObservationPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTouchBuilder extends FxTouch, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource(int index);
		@Override
		List<? extends InformationSource.InformationSourceBuilder> getInformationSource();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationStartTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationStartTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationEndTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationEndTime();
		FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder getOrCreateObservationPoint(int index);
		@Override
		List<? extends FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> getObservationPoint();
		FxTouch.FxTouchBuilder setTouchCondition(TouchConditionEnum touchCondition);
		FxTouch.FxTouchBuilder setDirection(TriggerConditionEnum direction);
		FxTouch.FxTouchBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxTouch.FxTouchBuilder setTriggerRate(BigDecimal triggerRate);
		FxTouch.FxTouchBuilder setSpotRate(BigDecimal spotRate);
		FxTouch.FxTouchBuilder addInformationSource(InformationSource informationSource);
		FxTouch.FxTouchBuilder addInformationSource(InformationSource informationSource, int idx);
		FxTouch.FxTouchBuilder addInformationSource(List<? extends InformationSource> informationSource);
		FxTouch.FxTouchBuilder setInformationSource(List<? extends InformationSource> informationSource);
		FxTouch.FxTouchBuilder setObservationStartDate(ZonedDateTime observationStartDate);
		FxTouch.FxTouchBuilder setObservationStartTime(BusinessCenterTime observationStartTime);
		FxTouch.FxTouchBuilder setObservationEndDate(ZonedDateTime observationEndDate);
		FxTouch.FxTouchBuilder setObservationEndTime(BusinessCenterTime observationEndTime);
		FxTouch.FxTouchBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint);
		FxTouch.FxTouchBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint, int idx);
		FxTouch.FxTouchBuilder addObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoint);
		FxTouch.FxTouchBuilder setObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoint);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("touchCondition"), TouchConditionEnum.class, getTouchCondition(), this);
			processor.processBasic(path.newSubPath("direction"), TriggerConditionEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
			processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationStartTime());
			processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
			processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationEndTime());
			processRosetta(path.newSubPath("observationPoint"), processor, FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder.class, getObservationPoint());
		}
		

		FxTouch.FxTouchBuilder prune();
	}

	/*********************** Immutable Implementation of FxTouch  ***********************/
	class FxTouchImpl implements FxTouch {
		private final TouchConditionEnum touchCondition;
		private final TriggerConditionEnum direction;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal triggerRate;
		private final BigDecimal spotRate;
		private final List<? extends InformationSource> informationSource;
		private final ZonedDateTime observationStartDate;
		private final BusinessCenterTime observationStartTime;
		private final ZonedDateTime observationEndDate;
		private final BusinessCenterTime observationEndTime;
		private final List<? extends FxBusinessCenterDateTime> observationPoint;
		
		protected FxTouchImpl(FxTouch.FxTouchBuilder builder) {
			this.touchCondition = builder.getTouchCondition();
			this.direction = builder.getDirection();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.triggerRate = builder.getTriggerRate();
			this.spotRate = builder.getSpotRate();
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.observationStartDate = builder.getObservationStartDate();
			this.observationStartTime = ofNullable(builder.getObservationStartTime()).map(f->f.build()).orElse(null);
			this.observationEndDate = builder.getObservationEndDate();
			this.observationEndTime = ofNullable(builder.getObservationEndTime()).map(f->f.build()).orElse(null);
			this.observationPoint = ofNullable(builder.getObservationPoint()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("touchCondition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("touchCondition")
		public TouchConditionEnum getTouchCondition() {
			return touchCondition;
		}
		
		@Override
		@RosettaAttribute("direction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction")
		public TriggerConditionEnum getDirection() {
			return direction;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("informationSource")
		public List<? extends InformationSource> getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationStartDate")
		public ZonedDateTime getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("observationStartTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationStartTime")
		public BusinessCenterTime getObservationStartTime() {
			return observationStartTime;
		}
		
		@Override
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationEndDate")
		public ZonedDateTime getObservationEndDate() {
			return observationEndDate;
		}
		
		@Override
		@RosettaAttribute("observationEndTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationEndTime")
		public BusinessCenterTime getObservationEndTime() {
			return observationEndTime;
		}
		
		@Override
		@RosettaAttribute("observationPoint")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observationPoint")
		public List<? extends FxBusinessCenterDateTime> getObservationPoint() {
			return observationPoint;
		}
		
		@Override
		public FxTouch build() {
			return this;
		}
		
		@Override
		public FxTouch.FxTouchBuilder toBuilder() {
			FxTouch.FxTouchBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTouch.FxTouchBuilder builder) {
			ofNullable(getTouchCondition()).ifPresent(builder::setTouchCondition);
			ofNullable(getDirection()).ifPresent(builder::setDirection);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getObservationStartDate()).ifPresent(builder::setObservationStartDate);
			ofNullable(getObservationStartTime()).ifPresent(builder::setObservationStartTime);
			ofNullable(getObservationEndDate()).ifPresent(builder::setObservationEndDate);
			ofNullable(getObservationEndTime()).ifPresent(builder::setObservationEndTime);
			ofNullable(getObservationPoint()).ifPresent(builder::setObservationPoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTouch _that = getType().cast(o);
		
			if (!Objects.equals(touchCondition, _that.getTouchCondition())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(observationEndTime, _that.getObservationEndTime())) return false;
			if (!ListEquals.listEquals(observationPoint, _that.getObservationPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (touchCondition != null ? touchCondition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (observationEndTime != null ? observationEndTime.hashCode() : 0);
			_result = 31 * _result + (observationPoint != null ? observationPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTouch {" +
				"touchCondition=" + this.touchCondition + ", " +
				"direction=" + this.direction + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"spotRate=" + this.spotRate + ", " +
				"informationSource=" + this.informationSource + ", " +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime + ", " +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime + ", " +
				"observationPoint=" + this.observationPoint +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTouch  ***********************/
	class FxTouchBuilderImpl implements FxTouch.FxTouchBuilder {
	
		protected TouchConditionEnum touchCondition;
		protected TriggerConditionEnum direction;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal triggerRate;
		protected BigDecimal spotRate;
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		protected ZonedDateTime observationStartDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationStartTime;
		protected ZonedDateTime observationEndDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationEndTime;
		protected List<FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> observationPoint = new ArrayList<>();
		
		@Override
		@RosettaAttribute("touchCondition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("touchCondition")
		public TouchConditionEnum getTouchCondition() {
			return touchCondition;
		}
		
		@Override
		@RosettaAttribute("direction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction")
		public TriggerConditionEnum getDirection() {
			return direction;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("informationSource")
		public List<? extends InformationSource.InformationSourceBuilder> getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource(int index) {
			if (informationSource==null) {
				this.informationSource = new ArrayList<>();
			}
			return getIndex(informationSource, index, () -> {
						InformationSource.InformationSourceBuilder newInformationSource = InformationSource.builder();
						return newInformationSource;
					});
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationStartDate")
		public ZonedDateTime getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("observationStartTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationStartTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getObservationStartTime() {
			return observationStartTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationStartTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (observationStartTime!=null) {
				result = observationStartTime;
			}
			else {
				result = observationStartTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationEndDate")
		public ZonedDateTime getObservationEndDate() {
			return observationEndDate;
		}
		
		@Override
		@RosettaAttribute("observationEndTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationEndTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getObservationEndTime() {
			return observationEndTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationEndTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (observationEndTime!=null) {
				result = observationEndTime;
			}
			else {
				result = observationEndTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationPoint")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observationPoint")
		public List<? extends FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> getObservationPoint() {
			return observationPoint;
		}
		
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder getOrCreateObservationPoint(int index) {
			if (observationPoint==null) {
				this.observationPoint = new ArrayList<>();
			}
			return getIndex(observationPoint, index, () -> {
						FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder newObservationPoint = FxBusinessCenterDateTime.builder();
						return newObservationPoint;
					});
		}
		
		@RosettaAttribute("touchCondition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("touchCondition")
		@Override
		public FxTouch.FxTouchBuilder setTouchCondition(TouchConditionEnum _touchCondition) {
			this.touchCondition = _touchCondition == null ? null : _touchCondition;
			return this;
		}
		
		@RosettaAttribute("direction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction")
		@Override
		public FxTouch.FxTouchBuilder setDirection(TriggerConditionEnum _direction) {
			this.direction = _direction == null ? null : _direction;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxTouch.FxTouchBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerRate")
		@Override
		public FxTouch.FxTouchBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public FxTouch.FxTouchBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public FxTouch.FxTouchBuilder addInformationSource(InformationSource _informationSource) {
			if (_informationSource != null) {
				this.informationSource.add(_informationSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTouch.FxTouchBuilder addInformationSource(InformationSource _informationSource, int idx) {
			getIndex(this.informationSource, idx, () -> _informationSource.toBuilder());
			return this;
		}
		
		@Override
		public FxTouch.FxTouchBuilder addInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources != null) {
				for (final InformationSource toAdd : informationSources) {
					this.informationSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public FxTouch.FxTouchBuilder setInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources == null) {
				this.informationSource = new ArrayList<>();
			} else {
				this.informationSource = informationSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartDate")
		@Override
		public FxTouch.FxTouchBuilder setObservationStartDate(ZonedDateTime _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate;
			return this;
		}
		
		@RosettaAttribute("observationStartTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartTime")
		@Override
		public FxTouch.FxTouchBuilder setObservationStartTime(BusinessCenterTime _observationStartTime) {
			this.observationStartTime = _observationStartTime == null ? null : _observationStartTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndDate")
		@Override
		public FxTouch.FxTouchBuilder setObservationEndDate(ZonedDateTime _observationEndDate) {
			this.observationEndDate = _observationEndDate == null ? null : _observationEndDate;
			return this;
		}
		
		@RosettaAttribute("observationEndTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndTime")
		@Override
		public FxTouch.FxTouchBuilder setObservationEndTime(BusinessCenterTime _observationEndTime) {
			this.observationEndTime = _observationEndTime == null ? null : _observationEndTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationPoint")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observationPoint")
		@Override
		public FxTouch.FxTouchBuilder addObservationPoint(FxBusinessCenterDateTime _observationPoint) {
			if (_observationPoint != null) {
				this.observationPoint.add(_observationPoint.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTouch.FxTouchBuilder addObservationPoint(FxBusinessCenterDateTime _observationPoint, int idx) {
			getIndex(this.observationPoint, idx, () -> _observationPoint.toBuilder());
			return this;
		}
		
		@Override
		public FxTouch.FxTouchBuilder addObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoints) {
			if (observationPoints != null) {
				for (final FxBusinessCenterDateTime toAdd : observationPoints) {
					this.observationPoint.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("observationPoint")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("observationPoint")
		@Override
		public FxTouch.FxTouchBuilder setObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoints) {
			if (observationPoints == null) {
				this.observationPoint = new ArrayList<>();
			} else {
				this.observationPoint = observationPoints.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxTouch build() {
			return new FxTouch.FxTouchImpl(this);
		}
		
		@Override
		public FxTouch.FxTouchBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTouch.FxTouchBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (observationStartTime!=null && !observationStartTime.prune().hasData()) observationStartTime = null;
			if (observationEndTime!=null && !observationEndTime.prune().hasData()) observationEndTime = null;
			observationPoint = observationPoint.stream().filter(b->b!=null).<FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTouchCondition()!=null) return true;
			if (getDirection()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getTriggerRate()!=null) return true;
			if (getSpotRate()!=null) return true;
			if (getInformationSource()!=null && getInformationSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getObservationStartDate()!=null) return true;
			if (getObservationStartTime()!=null && getObservationStartTime().hasData()) return true;
			if (getObservationEndDate()!=null) return true;
			if (getObservationEndTime()!=null && getObservationEndTime().hasData()) return true;
			if (getObservationPoint()!=null && getObservationPoint().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTouch.FxTouchBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTouch.FxTouchBuilder o = (FxTouch.FxTouchBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			merger.mergeRosetta(getObservationStartTime(), o.getObservationStartTime(), this::setObservationStartTime);
			merger.mergeRosetta(getObservationEndTime(), o.getObservationEndTime(), this::setObservationEndTime);
			merger.mergeRosetta(getObservationPoint(), o.getObservationPoint(), this::getOrCreateObservationPoint);
			
			merger.mergeBasic(getTouchCondition(), o.getTouchCondition(), this::setTouchCondition);
			merger.mergeBasic(getDirection(), o.getDirection(), this::setDirection);
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			merger.mergeBasic(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			merger.mergeBasic(getObservationEndDate(), o.getObservationEndDate(), this::setObservationEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTouch _that = getType().cast(o);
		
			if (!Objects.equals(touchCondition, _that.getTouchCondition())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(observationEndTime, _that.getObservationEndTime())) return false;
			if (!ListEquals.listEquals(observationPoint, _that.getObservationPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (touchCondition != null ? touchCondition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (observationEndTime != null ? observationEndTime.hashCode() : 0);
			_result = 31 * _result + (observationPoint != null ? observationPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTouchBuilder {" +
				"touchCondition=" + this.touchCondition + ", " +
				"direction=" + this.direction + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"spotRate=" + this.spotRate + ", " +
				"informationSource=" + this.informationSource + ", " +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime + ", " +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime + ", " +
				"observationPoint=" + this.observationPoint +
			'}';
		}
	}
}
