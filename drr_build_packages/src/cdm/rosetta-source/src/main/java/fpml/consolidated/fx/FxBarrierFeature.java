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
import fpml.consolidated.fpmlenum.FxBarrierDirectionEnum;
import fpml.consolidated.fpmlenum.FxBarrierTypeEnum;
import fpml.consolidated.fx.meta.FxBarrierFeatureMeta;
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
 * Provision Describes the properties of an FX barrier.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes the properties of an FX barrier.
 *
 */
@RosettaDataType(value="FxBarrierFeature", builder=FxBarrierFeature.FxBarrierFeatureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxBarrierFeature", model="fpml", builder=FxBarrierFeature.FxBarrierFeatureBuilderImpl.class, version="2.1.1")
public interface FxBarrierFeature extends RosettaModelObject {

	FxBarrierFeatureMeta metaData = new FxBarrierFeatureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This specifies whether the option becomes effective ("knock-in") or is annulled ("knock-out") when the respective barrier event occurs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This specifies whether the option becomes effective ("knock-in") or is annulled ("knock-out") when the respective barrier event occurs.
	 *
	 */
	FxBarrierTypeEnum getBarrierType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This specifies whether the barrier direction is "Up" or "Down"; that is, that a barrier event occurs if the spot rate is at or above the trigger rate, or at or below the trigger rate during the period of observation of an american barrier, or at the times of observation of a discrete or european barrier.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This specifies whether the barrier direction is "Up" or "Down"; that is, that a barrier event occurs if the spot rate is at or above the trigger rate, or at or below the trigger rate during the period of observation of an american barrier, or at the times of observation of a discrete or european barrier.
	 *
	 */
	FxBarrierDirectionEnum getDirection();
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
	 * Provision The market rate is observed relative to the trigger rate, and if it is found to be on the predefined side of (above or below) the trigger rate, a trigger event is deemed to have occurred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The market rate is observed relative to the trigger rate, and if it is found to be on the predefined side of (above or below) the trigger rate, a trigger event is deemed to have occurred.
	 *
	 */
	BigDecimal getTriggerRate();
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
	 * Provision The date on which the observation period for an american barrier starts. If the start date is not present, then the date and time of the start of the period is deemed to be the date and time the transaction was entered into.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the observation period for an american barrier starts. If the start date is not present, then the date and time of the start of the period is deemed to be the date and time the transaction was entered into.
	 *
	 */
	ZonedDateTime getObservationStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time on the start date at which the observation period for an american barrier starts. If the time is not present and the start date is equivalent to the transaction date, the time is deemed to be the time the transaction was entered into. If the time is not present and the start date is other than the transaction date, then the time is deemed to be the same as the expiration time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time on the start date at which the observation period for an american barrier starts. If the time is not present and the start date is equivalent to the transaction date, the time is deemed to be the time the transaction was entered into. If the time is not present and the start date is other than the transaction date, then the time is deemed to be the same as the expiration time.
	 *
	 */
	BusinessCenterTime getObservationStartTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the observation period for an american barrier ends. If the end date is not present, then the date and time of the end of the period is deemed to be the date and time of expiration.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the observation period for an american barrier ends. If the end date is not present, then the date and time of the end of the period is deemed to be the date and time of expiration.
	 *
	 */
	ZonedDateTime getObservationEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time on the end date at which the observation period for an american barrier ends. If the time is not present, then the time is deemed to be the same as the expiration time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time on the end date at which the observation period for an american barrier ends. If the time is not present, then the time is deemed to be the same as the expiration time.
	 *
	 */
	BusinessCenterTime getObservationEndTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The dates and times at which rate observations are made to determine whether a barrier event has occurred for a discrete or european barrier. If the time is not present then the time is deemed to be the same as the expiration time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The dates and times at which rate observations are made to determine whether a barrier event has occurred for a discrete or european barrier. If the time is not present then the time is deemed to be the same as the expiration time.
	 *
	 */
	List<? extends FxBusinessCenterDateTime> getObservationPoint();

	/*********************** Build Methods  ***********************/
	FxBarrierFeature build();
	
	FxBarrierFeature.FxBarrierFeatureBuilder toBuilder();
	
	static FxBarrierFeature.FxBarrierFeatureBuilder builder() {
		return new FxBarrierFeature.FxBarrierFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxBarrierFeature> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxBarrierFeature> getType() {
		return FxBarrierFeature.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeEnum.class, getBarrierType(), this);
		processor.processBasic(path.newSubPath("direction"), FxBarrierDirectionEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
		processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.class, getObservationStartTime());
		processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
		processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.class, getObservationEndTime());
		processRosetta(path.newSubPath("observationPoint"), processor, FxBusinessCenterDateTime.class, getObservationPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxBarrierFeatureBuilder extends FxBarrierFeature, RosettaModelObjectBuilder {
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
		FxBarrierFeature.FxBarrierFeatureBuilder setBarrierType(FxBarrierTypeEnum barrierType);
		FxBarrierFeature.FxBarrierFeatureBuilder setDirection(FxBarrierDirectionEnum direction);
		FxBarrierFeature.FxBarrierFeatureBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxBarrierFeature.FxBarrierFeatureBuilder setTriggerRate(BigDecimal triggerRate);
		FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(InformationSource informationSource);
		FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(InformationSource informationSource, int idx);
		FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(List<? extends InformationSource> informationSource);
		FxBarrierFeature.FxBarrierFeatureBuilder setInformationSource(List<? extends InformationSource> informationSource);
		FxBarrierFeature.FxBarrierFeatureBuilder setObservationStartDate(ZonedDateTime observationStartDate);
		FxBarrierFeature.FxBarrierFeatureBuilder setObservationStartTime(BusinessCenterTime observationStartTime);
		FxBarrierFeature.FxBarrierFeatureBuilder setObservationEndDate(ZonedDateTime observationEndDate);
		FxBarrierFeature.FxBarrierFeatureBuilder setObservationEndTime(BusinessCenterTime observationEndTime);
		FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint);
		FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint, int idx);
		FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoint);
		FxBarrierFeature.FxBarrierFeatureBuilder setObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoint);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeEnum.class, getBarrierType(), this);
			processor.processBasic(path.newSubPath("direction"), FxBarrierDirectionEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
			processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationStartTime());
			processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
			processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationEndTime());
			processRosetta(path.newSubPath("observationPoint"), processor, FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder.class, getObservationPoint());
		}
		

		FxBarrierFeature.FxBarrierFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of FxBarrierFeature  ***********************/
	class FxBarrierFeatureImpl implements FxBarrierFeature {
		private final FxBarrierTypeEnum barrierType;
		private final FxBarrierDirectionEnum direction;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal triggerRate;
		private final List<? extends InformationSource> informationSource;
		private final ZonedDateTime observationStartDate;
		private final BusinessCenterTime observationStartTime;
		private final ZonedDateTime observationEndDate;
		private final BusinessCenterTime observationEndTime;
		private final List<? extends FxBusinessCenterDateTime> observationPoint;
		
		protected FxBarrierFeatureImpl(FxBarrierFeature.FxBarrierFeatureBuilder builder) {
			this.barrierType = builder.getBarrierType();
			this.direction = builder.getDirection();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.triggerRate = builder.getTriggerRate();
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.observationStartDate = builder.getObservationStartDate();
			this.observationStartTime = ofNullable(builder.getObservationStartTime()).map(f->f.build()).orElse(null);
			this.observationEndDate = builder.getObservationEndDate();
			this.observationEndTime = ofNullable(builder.getObservationEndTime()).map(f->f.build()).orElse(null);
			this.observationPoint = ofNullable(builder.getObservationPoint()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("barrierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierType")
		public FxBarrierTypeEnum getBarrierType() {
			return barrierType;
		}
		
		@Override
		@RosettaAttribute("direction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction")
		public FxBarrierDirectionEnum getDirection() {
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
		public FxBarrierFeature build() {
			return this;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder toBuilder() {
			FxBarrierFeature.FxBarrierFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxBarrierFeature.FxBarrierFeatureBuilder builder) {
			ofNullable(getBarrierType()).ifPresent(builder::setBarrierType);
			ofNullable(getDirection()).ifPresent(builder::setDirection);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
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
		
			FxBarrierFeature _that = getType().cast(o);
		
			if (!Objects.equals(barrierType, _that.getBarrierType())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
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
			_result = 31 * _result + (barrierType != null ? barrierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
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
			return "FxBarrierFeature {" +
				"barrierType=" + this.barrierType + ", " +
				"direction=" + this.direction + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"informationSource=" + this.informationSource + ", " +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime + ", " +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime + ", " +
				"observationPoint=" + this.observationPoint +
			'}';
		}
	}

	/*********************** Builder Implementation of FxBarrierFeature  ***********************/
	class FxBarrierFeatureBuilderImpl implements FxBarrierFeature.FxBarrierFeatureBuilder {
	
		protected FxBarrierTypeEnum barrierType;
		protected FxBarrierDirectionEnum direction;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal triggerRate;
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		protected ZonedDateTime observationStartDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationStartTime;
		protected ZonedDateTime observationEndDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationEndTime;
		protected List<FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> observationPoint = new ArrayList<>();
		
		@Override
		@RosettaAttribute("barrierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierType")
		public FxBarrierTypeEnum getBarrierType() {
			return barrierType;
		}
		
		@Override
		@RosettaAttribute("direction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction")
		public FxBarrierDirectionEnum getDirection() {
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
		
		@RosettaAttribute("barrierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrierType")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder setBarrierType(FxBarrierTypeEnum _barrierType) {
			this.barrierType = _barrierType == null ? null : _barrierType;
			return this;
		}
		
		@RosettaAttribute("direction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder setDirection(FxBarrierDirectionEnum _direction) {
			this.direction = _direction == null ? null : _direction;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerRate")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(InformationSource _informationSource) {
			if (_informationSource != null) {
				this.informationSource.add(_informationSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(InformationSource _informationSource, int idx) {
			getIndex(this.informationSource, idx, () -> _informationSource.toBuilder());
			return this;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(List<? extends InformationSource> informationSources) {
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
		public FxBarrierFeature.FxBarrierFeatureBuilder setInformationSource(List<? extends InformationSource> informationSources) {
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
		public FxBarrierFeature.FxBarrierFeatureBuilder setObservationStartDate(ZonedDateTime _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate;
			return this;
		}
		
		@RosettaAttribute("observationStartTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartTime")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder setObservationStartTime(BusinessCenterTime _observationStartTime) {
			this.observationStartTime = _observationStartTime == null ? null : _observationStartTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndDate")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder setObservationEndDate(ZonedDateTime _observationEndDate) {
			this.observationEndDate = _observationEndDate == null ? null : _observationEndDate;
			return this;
		}
		
		@RosettaAttribute("observationEndTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndTime")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder setObservationEndTime(BusinessCenterTime _observationEndTime) {
			this.observationEndTime = _observationEndTime == null ? null : _observationEndTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationPoint")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observationPoint")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(FxBusinessCenterDateTime _observationPoint) {
			if (_observationPoint != null) {
				this.observationPoint.add(_observationPoint.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(FxBusinessCenterDateTime _observationPoint, int idx) {
			getIndex(this.observationPoint, idx, () -> _observationPoint.toBuilder());
			return this;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoints) {
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
		public FxBarrierFeature.FxBarrierFeatureBuilder setObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoints) {
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
		public FxBarrierFeature build() {
			return new FxBarrierFeature.FxBarrierFeatureImpl(this);
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (observationStartTime!=null && !observationStartTime.prune().hasData()) observationStartTime = null;
			if (observationEndTime!=null && !observationEndTime.prune().hasData()) observationEndTime = null;
			observationPoint = observationPoint.stream().filter(b->b!=null).<FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBarrierType()!=null) return true;
			if (getDirection()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getTriggerRate()!=null) return true;
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
		public FxBarrierFeature.FxBarrierFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxBarrierFeature.FxBarrierFeatureBuilder o = (FxBarrierFeature.FxBarrierFeatureBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			merger.mergeRosetta(getObservationStartTime(), o.getObservationStartTime(), this::setObservationStartTime);
			merger.mergeRosetta(getObservationEndTime(), o.getObservationEndTime(), this::setObservationEndTime);
			merger.mergeRosetta(getObservationPoint(), o.getObservationPoint(), this::getOrCreateObservationPoint);
			
			merger.mergeBasic(getBarrierType(), o.getBarrierType(), this::setBarrierType);
			merger.mergeBasic(getDirection(), o.getDirection(), this::setDirection);
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			merger.mergeBasic(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			merger.mergeBasic(getObservationEndDate(), o.getObservationEndDate(), this::setObservationEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBarrierFeature _that = getType().cast(o);
		
			if (!Objects.equals(barrierType, _that.getBarrierType())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
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
			_result = 31 * _result + (barrierType != null ? barrierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
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
			return "FxBarrierFeatureBuilder {" +
				"barrierType=" + this.barrierType + ", " +
				"direction=" + this.direction + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
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
