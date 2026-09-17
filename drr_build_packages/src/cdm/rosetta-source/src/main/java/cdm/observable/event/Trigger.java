package cdm.observable.event;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.event.meta.TriggerMeta;
import cdm.observable.event.metafields.ReferenceWithMetaCreditEvents;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Trigger point at which feature is effective.
 * @version 6.23.0
 */
@RosettaDataType(value="Trigger", builder=Trigger.TriggerBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Trigger", model="cdm", builder=Trigger.TriggerBuilderImpl.class, version="6.23.0")
public interface Trigger extends RosettaModelObject {

	TriggerMeta metaData = new TriggerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The trigger level.
	 */
	List<? extends PriceSchedule> getLevel();
	CreditEvents getCreditEvents();
	ReferenceWithMetaCreditEvents getCreditEventsReference();
	/**
	 * The Triggering condition.
	 */
	TriggerTypeEnum getTriggerType();
	/**
	 * The valuation time type of knock condition.
	 */
	TriggerTimeTypeEnum getTriggerTimeType();

	/*********************** Build Methods  ***********************/
	Trigger build();
	
	Trigger.TriggerBuilder toBuilder();
	
	static Trigger.TriggerBuilder builder() {
		return new Trigger.TriggerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Trigger> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Trigger> getType() {
		return Trigger.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("level"), processor, PriceSchedule.class, getLevel());
		processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.class, getCreditEvents());
		processRosetta(path.newSubPath("creditEventsReference"), processor, ReferenceWithMetaCreditEvents.class, getCreditEventsReference());
		processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
		processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriggerBuilder extends Trigger, RosettaModelObjectBuilder {
		PriceSchedule.PriceScheduleBuilder getOrCreateLevel(int index);
		@Override
		List<? extends PriceSchedule.PriceScheduleBuilder> getLevel();
		CreditEvents.CreditEventsBuilder getOrCreateCreditEvents();
		@Override
		CreditEvents.CreditEventsBuilder getCreditEvents();
		ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder getOrCreateCreditEventsReference();
		@Override
		ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder getCreditEventsReference();
		Trigger.TriggerBuilder addLevel(PriceSchedule level);
		Trigger.TriggerBuilder addLevel(PriceSchedule level, int idx);
		Trigger.TriggerBuilder addLevel(List<? extends PriceSchedule> level);
		Trigger.TriggerBuilder setLevel(List<? extends PriceSchedule> level);
		Trigger.TriggerBuilder setCreditEvents(CreditEvents creditEvents);
		Trigger.TriggerBuilder setCreditEventsReference(ReferenceWithMetaCreditEvents creditEventsReference);
		Trigger.TriggerBuilder setCreditEventsReferenceValue(CreditEvents creditEventsReference);
		Trigger.TriggerBuilder setTriggerType(TriggerTypeEnum triggerType);
		Trigger.TriggerBuilder setTriggerTimeType(TriggerTimeTypeEnum triggerTimeType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("level"), processor, PriceSchedule.PriceScheduleBuilder.class, getLevel());
			processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.CreditEventsBuilder.class, getCreditEvents());
			processRosetta(path.newSubPath("creditEventsReference"), processor, ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder.class, getCreditEventsReference());
			processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
			processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
		}
		

		Trigger.TriggerBuilder prune();
	}

	/*********************** Immutable Implementation of Trigger  ***********************/
	class TriggerImpl implements Trigger {
		private final List<? extends PriceSchedule> level;
		private final CreditEvents creditEvents;
		private final ReferenceWithMetaCreditEvents creditEventsReference;
		private final TriggerTypeEnum triggerType;
		private final TriggerTimeTypeEnum triggerTimeType;
		
		protected TriggerImpl(Trigger.TriggerBuilder builder) {
			this.level = ofNullable(builder.getLevel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditEvents = ofNullable(builder.getCreditEvents()).map(f->f.build()).orElse(null);
			this.creditEventsReference = ofNullable(builder.getCreditEventsReference()).map(f->f.build()).orElse(null);
			this.triggerType = builder.getTriggerType();
			this.triggerTimeType = builder.getTriggerTimeType();
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("level")
		public List<? extends PriceSchedule> getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEvents")
		public CreditEvents getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		@RosettaAttribute("creditEventsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEventsReference")
		public ReferenceWithMetaCreditEvents getCreditEventsReference() {
			return creditEventsReference;
		}
		
		@Override
		@RosettaAttribute("triggerType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerType")
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
		@Override
		@RosettaAttribute("triggerTimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerTimeType")
		public TriggerTimeTypeEnum getTriggerTimeType() {
			return triggerTimeType;
		}
		
		@Override
		public Trigger build() {
			return this;
		}
		
		@Override
		public Trigger.TriggerBuilder toBuilder() {
			Trigger.TriggerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Trigger.TriggerBuilder builder) {
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getCreditEvents()).ifPresent(builder::setCreditEvents);
			ofNullable(getCreditEventsReference()).ifPresent(builder::setCreditEventsReference);
			ofNullable(getTriggerType()).ifPresent(builder::setTriggerType);
			ofNullable(getTriggerTimeType()).ifPresent(builder::setTriggerTimeType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trigger _that = getType().cast(o);
		
			if (!ListEquals.listEquals(level, _that.getLevel())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(creditEventsReference, _that.getCreditEventsReference())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			if (!Objects.equals(triggerTimeType, _that.getTriggerTimeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (creditEventsReference != null ? creditEventsReference.hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerTimeType != null ? triggerTimeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Trigger {" +
				"level=" + this.level + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"creditEventsReference=" + this.creditEventsReference + ", " +
				"triggerType=" + this.triggerType + ", " +
				"triggerTimeType=" + this.triggerTimeType +
			'}';
		}
	}

	/*********************** Builder Implementation of Trigger  ***********************/
	class TriggerBuilderImpl implements Trigger.TriggerBuilder {
	
		protected List<PriceSchedule.PriceScheduleBuilder> level = new ArrayList<>();
		protected CreditEvents.CreditEventsBuilder creditEvents;
		protected ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder creditEventsReference;
		protected TriggerTypeEnum triggerType;
		protected TriggerTimeTypeEnum triggerTimeType;
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("level")
		public List<? extends PriceSchedule.PriceScheduleBuilder> getLevel() {
			return level;
		}
		
		@Override
		public PriceSchedule.PriceScheduleBuilder getOrCreateLevel(int index) {
			if (level==null) {
				this.level = new ArrayList<>();
			}
			return getIndex(level, index, () -> {
						PriceSchedule.PriceScheduleBuilder newLevel = PriceSchedule.builder();
						return newLevel;
					});
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEvents")
		public CreditEvents.CreditEventsBuilder getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder getOrCreateCreditEvents() {
			CreditEvents.CreditEventsBuilder result;
			if (creditEvents!=null) {
				result = creditEvents;
			}
			else {
				result = creditEvents = CreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEventsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEventsReference")
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder getCreditEventsReference() {
			return creditEventsReference;
		}
		
		@Override
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder getOrCreateCreditEventsReference() {
			ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder result;
			if (creditEventsReference!=null) {
				result = creditEventsReference;
			}
			else {
				result = creditEventsReference = ReferenceWithMetaCreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerType")
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
		@Override
		@RosettaAttribute("triggerTimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerTimeType")
		public TriggerTimeTypeEnum getTriggerTimeType() {
			return triggerTimeType;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("level")
		@Override
		public Trigger.TriggerBuilder addLevel(PriceSchedule _level) {
			if (_level != null) {
				this.level.add(_level.toBuilder());
			}
			return this;
		}
		
		@Override
		public Trigger.TriggerBuilder addLevel(PriceSchedule _level, int idx) {
			getIndex(this.level, idx, () -> _level.toBuilder());
			return this;
		}
		
		@Override
		public Trigger.TriggerBuilder addLevel(List<? extends PriceSchedule> levels) {
			if (levels != null) {
				for (final PriceSchedule toAdd : levels) {
					this.level.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("level")
		@Override
		public Trigger.TriggerBuilder setLevel(List<? extends PriceSchedule> levels) {
			if (levels == null) {
				this.level = new ArrayList<>();
			} else {
				this.level = levels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEvents")
		@Override
		public Trigger.TriggerBuilder setCreditEvents(CreditEvents _creditEvents) {
			this.creditEvents = _creditEvents == null ? null : _creditEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditEventsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEventsReference")
		@Override
		public Trigger.TriggerBuilder setCreditEventsReference(ReferenceWithMetaCreditEvents _creditEventsReference) {
			this.creditEventsReference = _creditEventsReference == null ? null : _creditEventsReference.toBuilder();
			return this;
		}
		
		@Override
		public Trigger.TriggerBuilder setCreditEventsReferenceValue(CreditEvents _creditEventsReference) {
			this.getOrCreateCreditEventsReference().setValue(_creditEventsReference);
			return this;
		}
		
		@RosettaAttribute("triggerType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerType")
		@Override
		public Trigger.TriggerBuilder setTriggerType(TriggerTypeEnum _triggerType) {
			this.triggerType = _triggerType == null ? null : _triggerType;
			return this;
		}
		
		@RosettaAttribute("triggerTimeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerTimeType")
		@Override
		public Trigger.TriggerBuilder setTriggerTimeType(TriggerTimeTypeEnum _triggerTimeType) {
			this.triggerTimeType = _triggerTimeType == null ? null : _triggerTimeType;
			return this;
		}
		
		@Override
		public Trigger build() {
			return new Trigger.TriggerImpl(this);
		}
		
		@Override
		public Trigger.TriggerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trigger.TriggerBuilder prune() {
			level = level.stream().filter(b->b!=null).<PriceSchedule.PriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (creditEvents!=null && !creditEvents.prune().hasData()) creditEvents = null;
			if (creditEventsReference!=null && !creditEventsReference.prune().hasData()) creditEventsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLevel()!=null && getLevel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditEvents()!=null && getCreditEvents().hasData()) return true;
			if (getCreditEventsReference()!=null && getCreditEventsReference().hasData()) return true;
			if (getTriggerType()!=null) return true;
			if (getTriggerTimeType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trigger.TriggerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Trigger.TriggerBuilder o = (Trigger.TriggerBuilder) other;
			
			merger.mergeRosetta(getLevel(), o.getLevel(), this::getOrCreateLevel);
			merger.mergeRosetta(getCreditEvents(), o.getCreditEvents(), this::setCreditEvents);
			merger.mergeRosetta(getCreditEventsReference(), o.getCreditEventsReference(), this::setCreditEventsReference);
			
			merger.mergeBasic(getTriggerType(), o.getTriggerType(), this::setTriggerType);
			merger.mergeBasic(getTriggerTimeType(), o.getTriggerTimeType(), this::setTriggerTimeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trigger _that = getType().cast(o);
		
			if (!ListEquals.listEquals(level, _that.getLevel())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(creditEventsReference, _that.getCreditEventsReference())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			if (!Objects.equals(triggerTimeType, _that.getTriggerTimeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (creditEventsReference != null ? creditEventsReference.hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerTimeType != null ? triggerTimeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerBuilder {" +
				"level=" + this.level + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"creditEventsReference=" + this.creditEventsReference + ", " +
				"triggerType=" + this.triggerType + ", " +
				"triggerTimeType=" + this.triggerTimeType +
			'}';
		}
	}
}
