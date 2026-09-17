package fpml.consolidated.option.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fpmlenum.TriggerTimeTypeEnum;
import fpml.consolidated.fpmlenum.TriggerTypeEnum;
import fpml.consolidated.option.shared.meta.TriggerMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Trigger point at which feature is effective.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Trigger point at which feature is effective.
 *
 */
@RosettaDataType(value="Trigger", builder=Trigger.TriggerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Trigger", model="fpml", builder=Trigger.TriggerBuilderImpl.class, version="2.1.1")
public interface Trigger extends RosettaModelObject {

	TriggerMeta metaData = new TriggerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trigger level.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trigger level.
	 *
	 */
	BigDecimal getLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trigger level percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trigger level percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getLevelPercentage();
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
	CreditEvents getCreditEvents();
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
	CreditEventsReference getCreditEventsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Triggering condition.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Triggering condition.
	 *
	 */
	TriggerTypeEnum getTriggerType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The valuation time type of knock condition.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The valuation time type of knock condition.
	 *
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
		processor.processBasic(path.newSubPath("level"), BigDecimal.class, getLevel(), this);
		processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
		processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.class, getCreditEvents());
		processRosetta(path.newSubPath("creditEventsReference"), processor, CreditEventsReference.class, getCreditEventsReference());
		processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
		processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriggerBuilder extends Trigger, RosettaModelObjectBuilder {
		CreditEvents.CreditEventsBuilder getOrCreateCreditEvents();
		@Override
		CreditEvents.CreditEventsBuilder getCreditEvents();
		CreditEventsReference.CreditEventsReferenceBuilder getOrCreateCreditEventsReference();
		@Override
		CreditEventsReference.CreditEventsReferenceBuilder getCreditEventsReference();
		Trigger.TriggerBuilder setLevel(BigDecimal level);
		Trigger.TriggerBuilder setLevelPercentage(BigDecimal levelPercentage);
		Trigger.TriggerBuilder setCreditEvents(CreditEvents creditEvents);
		Trigger.TriggerBuilder setCreditEventsReference(CreditEventsReference creditEventsReference);
		Trigger.TriggerBuilder setTriggerType(TriggerTypeEnum triggerType);
		Trigger.TriggerBuilder setTriggerTimeType(TriggerTimeTypeEnum triggerTimeType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("level"), BigDecimal.class, getLevel(), this);
			processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
			processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.CreditEventsBuilder.class, getCreditEvents());
			processRosetta(path.newSubPath("creditEventsReference"), processor, CreditEventsReference.CreditEventsReferenceBuilder.class, getCreditEventsReference());
			processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
			processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
		}
		

		Trigger.TriggerBuilder prune();
	}

	/*********************** Immutable Implementation of Trigger  ***********************/
	class TriggerImpl implements Trigger {
		private final BigDecimal level;
		private final BigDecimal levelPercentage;
		private final CreditEvents creditEvents;
		private final CreditEventsReference creditEventsReference;
		private final TriggerTypeEnum triggerType;
		private final TriggerTimeTypeEnum triggerTimeType;
		
		protected TriggerImpl(Trigger.TriggerBuilder builder) {
			this.level = builder.getLevel();
			this.levelPercentage = builder.getLevelPercentage();
			this.creditEvents = ofNullable(builder.getCreditEvents()).map(f->f.build()).orElse(null);
			this.creditEventsReference = ofNullable(builder.getCreditEventsReference()).map(f->f.build()).orElse(null);
			this.triggerType = builder.getTriggerType();
			this.triggerTimeType = builder.getTriggerTimeType();
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public BigDecimal getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
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
		public CreditEventsReference getCreditEventsReference() {
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
			ofNullable(getLevelPercentage()).ifPresent(builder::setLevelPercentage);
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
		
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
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
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
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
				"levelPercentage=" + this.levelPercentage + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"creditEventsReference=" + this.creditEventsReference + ", " +
				"triggerType=" + this.triggerType + ", " +
				"triggerTimeType=" + this.triggerTimeType +
			'}';
		}
	}

	/*********************** Builder Implementation of Trigger  ***********************/
	class TriggerBuilderImpl implements Trigger.TriggerBuilder {
	
		protected BigDecimal level;
		protected BigDecimal levelPercentage;
		protected CreditEvents.CreditEventsBuilder creditEvents;
		protected CreditEventsReference.CreditEventsReferenceBuilder creditEventsReference;
		protected TriggerTypeEnum triggerType;
		protected TriggerTimeTypeEnum triggerTimeType;
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public BigDecimal getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
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
		public CreditEventsReference.CreditEventsReferenceBuilder getCreditEventsReference() {
			return creditEventsReference;
		}
		
		@Override
		public CreditEventsReference.CreditEventsReferenceBuilder getOrCreateCreditEventsReference() {
			CreditEventsReference.CreditEventsReferenceBuilder result;
			if (creditEventsReference!=null) {
				result = creditEventsReference;
			}
			else {
				result = creditEventsReference = CreditEventsReference.builder();
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
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public Trigger.TriggerBuilder setLevel(BigDecimal _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("levelPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("levelPercentage")
		@Override
		public Trigger.TriggerBuilder setLevelPercentage(BigDecimal _levelPercentage) {
			this.levelPercentage = _levelPercentage == null ? null : _levelPercentage;
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
		public Trigger.TriggerBuilder setCreditEventsReference(CreditEventsReference _creditEventsReference) {
			this.creditEventsReference = _creditEventsReference == null ? null : _creditEventsReference.toBuilder();
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
			if (creditEvents!=null && !creditEvents.prune().hasData()) creditEvents = null;
			if (creditEventsReference!=null && !creditEventsReference.prune().hasData()) creditEventsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLevel()!=null) return true;
			if (getLevelPercentage()!=null) return true;
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
			
			merger.mergeRosetta(getCreditEvents(), o.getCreditEvents(), this::setCreditEvents);
			merger.mergeRosetta(getCreditEventsReference(), o.getCreditEventsReference(), this::setCreditEventsReference);
			
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeBasic(getLevelPercentage(), o.getLevelPercentage(), this::setLevelPercentage);
			merger.mergeBasic(getTriggerType(), o.getTriggerType(), this::setTriggerType);
			merger.mergeBasic(getTriggerTimeType(), o.getTriggerTimeType(), this::setTriggerTimeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trigger _that = getType().cast(o);
		
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
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
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
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
				"levelPercentage=" + this.levelPercentage + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"creditEventsReference=" + this.creditEventsReference + ", " +
				"triggerType=" + this.triggerType + ", " +
				"triggerTimeType=" + this.triggerTimeType +
			'}';
		}
	}
}
