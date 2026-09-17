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
import fpml.consolidated.fx.targets.meta.FxTargetBarrierMeta;
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
@RosettaDataType(value="FxTargetBarrier", builder=FxTargetBarrier.FxTargetBarrierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetBarrier", model="fpml", builder=FxTargetBarrier.FxTargetBarrierBuilderImpl.class, version="2.1.1")
public interface FxTargetBarrier extends FxComplexBarrierBase {

	FxTargetBarrierMeta metaData = new FxTargetBarrierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A rebate payable in the event of knockout. This element may be produced in conjunction with a Global Knockout barrier (barrierType = "Knockout" scope = "Global"), and must be omitted otherwise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A rebate payable in the event of knockout. This element may be produced in conjunction with a Global Knockout barrier (barrierType = "Knockout" scope = "Global"), and must be omitted otherwise.
	 *
	 */
	FxTargetRebate getRebate();

	/*********************** Build Methods  ***********************/
	FxTargetBarrier build();
	
	FxTargetBarrier.FxTargetBarrierBuilder toBuilder();
	
	static FxTargetBarrier.FxTargetBarrierBuilder builder() {
		return new FxTargetBarrier.FxTargetBarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetBarrier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetBarrier> getType() {
		return FxTargetBarrier.class;
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
		processRosetta(path.newSubPath("rebate"), processor, FxTargetRebate.class, getRebate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetBarrierBuilder extends FxTargetBarrier, FxComplexBarrierBase.FxComplexBarrierBaseBuilder {
		FxTargetRebate.FxTargetRebateBuilder getOrCreateRebate();
		@Override
		FxTargetRebate.FxTargetRebateBuilder getRebate();
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setId(String id);
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setBarrierType(FxBarrierTypeSimpleEnum barrierType);
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setStyle(FxBarrierStyleEnum style);
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setScope(FxBarrierScopeEnum scope);
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setCondition(ConditionEnum condition);
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setTriggerRate(Schedule triggerRate);
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setObservationStartDate(ZonedDateTime observationStartDate);
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setObservationStartTime(BusinessCenterTime observationStartTime);
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setObservationEndDate(ZonedDateTime observationEndDate);
		@Override
		FxTargetBarrier.FxTargetBarrierBuilder setObservationEndTime(BusinessCenterTime observationEndTime);
		FxTargetBarrier.FxTargetBarrierBuilder setRebate(FxTargetRebate rebate);

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
			processRosetta(path.newSubPath("rebate"), processor, FxTargetRebate.FxTargetRebateBuilder.class, getRebate());
		}
		

		FxTargetBarrier.FxTargetBarrierBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetBarrier  ***********************/
	class FxTargetBarrierImpl extends FxComplexBarrierBase.FxComplexBarrierBaseImpl implements FxTargetBarrier {
		private final FxTargetRebate rebate;
		
		protected FxTargetBarrierImpl(FxTargetBarrier.FxTargetBarrierBuilder builder) {
			super(builder);
			this.rebate = ofNullable(builder.getRebate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rebate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rebate")
		public FxTargetRebate getRebate() {
			return rebate;
		}
		
		@Override
		public FxTargetBarrier build() {
			return this;
		}
		
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder toBuilder() {
			FxTargetBarrier.FxTargetBarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetBarrier.FxTargetBarrierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRebate()).ifPresent(builder::setRebate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetBarrier _that = getType().cast(o);
		
			if (!Objects.equals(rebate, _that.getRebate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rebate != null ? rebate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetBarrier {" +
				"rebate=" + this.rebate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetBarrier  ***********************/
	class FxTargetBarrierBuilderImpl extends FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl implements FxTargetBarrier.FxTargetBarrierBuilder {
	
		protected FxTargetRebate.FxTargetRebateBuilder rebate;
		
		@Override
		@RosettaAttribute("rebate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rebate")
		public FxTargetRebate.FxTargetRebateBuilder getRebate() {
			return rebate;
		}
		
		@Override
		public FxTargetRebate.FxTargetRebateBuilder getOrCreateRebate() {
			FxTargetRebate.FxTargetRebateBuilder result;
			if (rebate!=null) {
				result = rebate;
			}
			else {
				result = rebate = FxTargetRebate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("barrierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrierType")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setBarrierType(FxBarrierTypeSimpleEnum _barrierType) {
			this.barrierType = _barrierType == null ? null : _barrierType;
			return this;
		}
		
		@RosettaAttribute("style")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("style")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setStyle(FxBarrierStyleEnum _style) {
			this.style = _style == null ? null : _style;
			return this;
		}
		
		@RosettaAttribute("scope")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scope")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setScope(FxBarrierScopeEnum _scope) {
			this.scope = _scope == null ? null : _scope;
			return this;
		}
		
		@RosettaAttribute("condition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("condition")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setCondition(ConditionEnum _condition) {
			this.condition = _condition == null ? null : _condition;
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("triggerRate")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setTriggerRate(Schedule _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartDate")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setObservationStartDate(ZonedDateTime _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate;
			return this;
		}
		
		@RosettaAttribute("observationStartTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartTime")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setObservationStartTime(BusinessCenterTime _observationStartTime) {
			this.observationStartTime = _observationStartTime == null ? null : _observationStartTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndDate")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setObservationEndDate(ZonedDateTime _observationEndDate) {
			this.observationEndDate = _observationEndDate == null ? null : _observationEndDate;
			return this;
		}
		
		@RosettaAttribute("observationEndTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndTime")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setObservationEndTime(BusinessCenterTime _observationEndTime) {
			this.observationEndTime = _observationEndTime == null ? null : _observationEndTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rebate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rebate")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder setRebate(FxTargetRebate _rebate) {
			this.rebate = _rebate == null ? null : _rebate.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetBarrier build() {
			return new FxTargetBarrier.FxTargetBarrierImpl(this);
		}
		
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder prune() {
			super.prune();
			if (rebate!=null && !rebate.prune().hasData()) rebate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRebate()!=null && getRebate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxTargetBarrier.FxTargetBarrierBuilder o = (FxTargetBarrier.FxTargetBarrierBuilder) other;
			
			merger.mergeRosetta(getRebate(), o.getRebate(), this::setRebate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetBarrier _that = getType().cast(o);
		
			if (!Objects.equals(rebate, _that.getRebate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rebate != null ? rebate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetBarrierBuilder {" +
				"rebate=" + this.rebate +
			'}' + " " + super.toString();
		}
	}
}
