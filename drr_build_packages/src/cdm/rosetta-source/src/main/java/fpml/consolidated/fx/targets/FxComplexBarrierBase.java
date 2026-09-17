package fpml.consolidated.fx.targets;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fpmlenum.FxBarrierScopeEnum;
import fpml.consolidated.fpmlenum.FxBarrierStyleEnum;
import fpml.consolidated.fpmlenum.FxBarrierTypeSimpleEnum;
import fpml.consolidated.fx.targets.meta.FxComplexBarrierBaseMeta;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Schedule;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="FxComplexBarrierBase", builder=FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxComplexBarrierBase", model="fpml", builder=FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl.class, version="2.1.1")
public interface FxComplexBarrierBase extends RosettaModelObject {

	FxComplexBarrierBaseMeta metaData = new FxComplexBarrierBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Attribute to be able to point to the
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Attribute to be able to point to the
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the outcome (action) in the event that the barrier is triggered i.e. whether the product becomes active (Knockin) or is extinguished (Knockout).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the outcome (action) in the event that the barrier is triggered i.e. whether the product becomes active (Knockin) or is extinguished (Knockout).
	 *
	 */
	FxBarrierTypeSimpleEnum getBarrierType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The barrier observation style: continuous (American) or discrete (European).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The barrier observation style: continuous (American) or discrete (European).
	 *
	 */
	FxBarrierStyleEnum getStyle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The scope of the barrier (PerExpiry|Global). Specifies whether the barrier has effect for the current expiry period (in the case of a multi-phase product), or for the product as a whole.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The scope of the barrier (PerExpiry|Global). Specifies whether the barrier has effect for the current expiry period (in the case of a multi-phase product), or for the product as a whole.
	 *
	 */
	FxBarrierScopeEnum getScope();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the condition when the barrier applies: AtOrAbove, AtOrBelow, Above, Below.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the condition when the barrier applies: AtOrAbove, AtOrBelow, Above, Below.
	 *
	 */
	ConditionEnum getCondition();
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
	Schedule getTriggerRate();
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

	/*********************** Build Methods  ***********************/
	FxComplexBarrierBase build();
	
	FxComplexBarrierBase.FxComplexBarrierBaseBuilder toBuilder();
	
	static FxComplexBarrierBase.FxComplexBarrierBaseBuilder builder() {
		return new FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxComplexBarrierBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxComplexBarrierBase> getType() {
		return FxComplexBarrierBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeSimpleEnum.class, getBarrierType(), this);
		processor.processBasic(path.newSubPath("style"), FxBarrierStyleEnum.class, getStyle(), this);
		processor.processBasic(path.newSubPath("scope"), FxBarrierScopeEnum.class, getScope(), this);
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("triggerRate"), processor, Schedule.class, getTriggerRate());
		processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
		processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.class, getObservationStartTime());
		processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
		processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.class, getObservationEndTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxComplexBarrierBaseBuilder extends FxComplexBarrierBase, RosettaModelObjectBuilder {
		Schedule.ScheduleBuilder getOrCreateTriggerRate();
		@Override
		Schedule.ScheduleBuilder getTriggerRate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationStartTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationStartTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationEndTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationEndTime();
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setId(String id);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setBarrierType(FxBarrierTypeSimpleEnum barrierType);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setStyle(FxBarrierStyleEnum style);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setScope(FxBarrierScopeEnum scope);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setCondition(ConditionEnum condition);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setTriggerRate(Schedule triggerRate);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setObservationStartDate(ZonedDateTime observationStartDate);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setObservationStartTime(BusinessCenterTime observationStartTime);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setObservationEndDate(ZonedDateTime observationEndDate);
		FxComplexBarrierBase.FxComplexBarrierBaseBuilder setObservationEndTime(BusinessCenterTime observationEndTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeSimpleEnum.class, getBarrierType(), this);
			processor.processBasic(path.newSubPath("style"), FxBarrierStyleEnum.class, getStyle(), this);
			processor.processBasic(path.newSubPath("scope"), FxBarrierScopeEnum.class, getScope(), this);
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("triggerRate"), processor, Schedule.ScheduleBuilder.class, getTriggerRate());
			processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
			processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationStartTime());
			processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
			processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationEndTime());
		}
		

		FxComplexBarrierBase.FxComplexBarrierBaseBuilder prune();
	}

	/*********************** Immutable Implementation of FxComplexBarrierBase  ***********************/
	class FxComplexBarrierBaseImpl implements FxComplexBarrierBase {
		private final String id;
		private final FxBarrierTypeSimpleEnum barrierType;
		private final FxBarrierStyleEnum style;
		private final FxBarrierScopeEnum scope;
		private final ConditionEnum condition;
		private final Schedule triggerRate;
		private final ZonedDateTime observationStartDate;
		private final BusinessCenterTime observationStartTime;
		private final ZonedDateTime observationEndDate;
		private final BusinessCenterTime observationEndTime;
		
		protected FxComplexBarrierBaseImpl(FxComplexBarrierBase.FxComplexBarrierBaseBuilder builder) {
			this.id = builder.getId();
			this.barrierType = builder.getBarrierType();
			this.style = builder.getStyle();
			this.scope = builder.getScope();
			this.condition = builder.getCondition();
			this.triggerRate = ofNullable(builder.getTriggerRate()).map(f->f.build()).orElse(null);
			this.observationStartDate = builder.getObservationStartDate();
			this.observationStartTime = ofNullable(builder.getObservationStartTime()).map(f->f.build()).orElse(null);
			this.observationEndDate = builder.getObservationEndDate();
			this.observationEndTime = ofNullable(builder.getObservationEndTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("barrierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierType")
		public FxBarrierTypeSimpleEnum getBarrierType() {
			return barrierType;
		}
		
		@Override
		@RosettaAttribute("style")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("style")
		public FxBarrierStyleEnum getStyle() {
			return style;
		}
		
		@Override
		@RosettaAttribute("scope")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scope")
		public FxBarrierScopeEnum getScope() {
			return scope;
		}
		
		@Override
		@RosettaAttribute("condition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("condition")
		public ConditionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("triggerRate")
		public Schedule getTriggerRate() {
			return triggerRate;
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
		public FxComplexBarrierBase build() {
			return this;
		}
		
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder toBuilder() {
			FxComplexBarrierBase.FxComplexBarrierBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxComplexBarrierBase.FxComplexBarrierBaseBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getBarrierType()).ifPresent(builder::setBarrierType);
			ofNullable(getStyle()).ifPresent(builder::setStyle);
			ofNullable(getScope()).ifPresent(builder::setScope);
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getObservationStartDate()).ifPresent(builder::setObservationStartDate);
			ofNullable(getObservationStartTime()).ifPresent(builder::setObservationStartTime);
			ofNullable(getObservationEndDate()).ifPresent(builder::setObservationEndDate);
			ofNullable(getObservationEndTime()).ifPresent(builder::setObservationEndTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxComplexBarrierBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(barrierType, _that.getBarrierType())) return false;
			if (!Objects.equals(style, _that.getStyle())) return false;
			if (!Objects.equals(scope, _that.getScope())) return false;
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(observationEndTime, _that.getObservationEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (barrierType != null ? barrierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (style != null ? style.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (scope != null ? scope.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (observationEndTime != null ? observationEndTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxComplexBarrierBase {" +
				"id=" + this.id + ", " +
				"barrierType=" + this.barrierType + ", " +
				"style=" + this.style + ", " +
				"scope=" + this.scope + ", " +
				"condition=" + this.condition + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime + ", " +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime +
			'}';
		}
	}

	/*********************** Builder Implementation of FxComplexBarrierBase  ***********************/
	class FxComplexBarrierBaseBuilderImpl implements FxComplexBarrierBase.FxComplexBarrierBaseBuilder {
	
		protected String id;
		protected FxBarrierTypeSimpleEnum barrierType;
		protected FxBarrierStyleEnum style;
		protected FxBarrierScopeEnum scope;
		protected ConditionEnum condition;
		protected Schedule.ScheduleBuilder triggerRate;
		protected ZonedDateTime observationStartDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationStartTime;
		protected ZonedDateTime observationEndDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationEndTime;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("barrierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierType")
		public FxBarrierTypeSimpleEnum getBarrierType() {
			return barrierType;
		}
		
		@Override
		@RosettaAttribute("style")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("style")
		public FxBarrierStyleEnum getStyle() {
			return style;
		}
		
		@Override
		@RosettaAttribute("scope")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scope")
		public FxBarrierScopeEnum getScope() {
			return scope;
		}
		
		@Override
		@RosettaAttribute("condition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("condition")
		public ConditionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("triggerRate")
		public Schedule.ScheduleBuilder getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateTriggerRate() {
			Schedule.ScheduleBuilder result;
			if (triggerRate!=null) {
				result = triggerRate;
			}
			else {
				result = triggerRate = Schedule.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("barrierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrierType")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setBarrierType(FxBarrierTypeSimpleEnum _barrierType) {
			this.barrierType = _barrierType == null ? null : _barrierType;
			return this;
		}
		
		@RosettaAttribute("style")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("style")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setStyle(FxBarrierStyleEnum _style) {
			this.style = _style == null ? null : _style;
			return this;
		}
		
		@RosettaAttribute("scope")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scope")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setScope(FxBarrierScopeEnum _scope) {
			this.scope = _scope == null ? null : _scope;
			return this;
		}
		
		@RosettaAttribute("condition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("condition")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setCondition(ConditionEnum _condition) {
			this.condition = _condition == null ? null : _condition;
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("triggerRate")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setTriggerRate(Schedule _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartDate")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setObservationStartDate(ZonedDateTime _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate;
			return this;
		}
		
		@RosettaAttribute("observationStartTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartTime")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setObservationStartTime(BusinessCenterTime _observationStartTime) {
			this.observationStartTime = _observationStartTime == null ? null : _observationStartTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndDate")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setObservationEndDate(ZonedDateTime _observationEndDate) {
			this.observationEndDate = _observationEndDate == null ? null : _observationEndDate;
			return this;
		}
		
		@RosettaAttribute("observationEndTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndTime")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder setObservationEndTime(BusinessCenterTime _observationEndTime) {
			this.observationEndTime = _observationEndTime == null ? null : _observationEndTime.toBuilder();
			return this;
		}
		
		@Override
		public FxComplexBarrierBase build() {
			return new FxComplexBarrierBase.FxComplexBarrierBaseImpl(this);
		}
		
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder prune() {
			if (triggerRate!=null && !triggerRate.prune().hasData()) triggerRate = null;
			if (observationStartTime!=null && !observationStartTime.prune().hasData()) observationStartTime = null;
			if (observationEndTime!=null && !observationEndTime.prune().hasData()) observationEndTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getBarrierType()!=null) return true;
			if (getStyle()!=null) return true;
			if (getScope()!=null) return true;
			if (getCondition()!=null) return true;
			if (getTriggerRate()!=null && getTriggerRate().hasData()) return true;
			if (getObservationStartDate()!=null) return true;
			if (getObservationStartTime()!=null && getObservationStartTime().hasData()) return true;
			if (getObservationEndDate()!=null) return true;
			if (getObservationEndTime()!=null && getObservationEndTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxComplexBarrierBase.FxComplexBarrierBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxComplexBarrierBase.FxComplexBarrierBaseBuilder o = (FxComplexBarrierBase.FxComplexBarrierBaseBuilder) other;
			
			merger.mergeRosetta(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			merger.mergeRosetta(getObservationStartTime(), o.getObservationStartTime(), this::setObservationStartTime);
			merger.mergeRosetta(getObservationEndTime(), o.getObservationEndTime(), this::setObservationEndTime);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getBarrierType(), o.getBarrierType(), this::setBarrierType);
			merger.mergeBasic(getStyle(), o.getStyle(), this::setStyle);
			merger.mergeBasic(getScope(), o.getScope(), this::setScope);
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			merger.mergeBasic(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			merger.mergeBasic(getObservationEndDate(), o.getObservationEndDate(), this::setObservationEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxComplexBarrierBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(barrierType, _that.getBarrierType())) return false;
			if (!Objects.equals(style, _that.getStyle())) return false;
			if (!Objects.equals(scope, _that.getScope())) return false;
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationStartTime, _that.getObservationStartTime())) return false;
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(observationEndTime, _that.getObservationEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (barrierType != null ? barrierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (style != null ? style.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (scope != null ? scope.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationStartTime != null ? observationStartTime.hashCode() : 0);
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (observationEndTime != null ? observationEndTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxComplexBarrierBaseBuilder {" +
				"id=" + this.id + ", " +
				"barrierType=" + this.barrierType + ", " +
				"style=" + this.style + ", " +
				"scope=" + this.scope + ", " +
				"condition=" + this.condition + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationStartTime=" + this.observationStartTime + ", " +
				"observationEndDate=" + this.observationEndDate + ", " +
				"observationEndTime=" + this.observationEndTime +
			'}';
		}
	}
}
