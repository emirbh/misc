package fpml.consolidated.accumulator;

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
import fpml.consolidated.accumulator.meta.AccumulatorKnockOutMeta;
import fpml.consolidated.fpmlenum.TriggerTimeTypeEnum;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Termination of contract prior to maturity date as a result of stock price reaching specified level or performance reaching target performance.
 *
 */
@RosettaDataType(value="AccumulatorKnockOut", builder=AccumulatorKnockOut.AccumulatorKnockOutBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccumulatorKnockOut", model="fpml", builder=AccumulatorKnockOut.AccumulatorKnockOutBuilderImpl.class, version="2.1.1")
public interface AccumulatorKnockOut extends RosettaModelObject {

	AccumulatorKnockOutMeta metaData = new AccumulatorKnockOutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The target performance.
	 *
	 */
	BigDecimal getTargetPerformance();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The share price, above which the contract is terminated.
	 *
	 */
	BigDecimal getLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time of day which would be considered for valuing the knock event.
	 *
	 */
	TriggerTimeTypeEnum getTriggerTimeType();

	/*********************** Build Methods  ***********************/
	AccumulatorKnockOut build();
	
	AccumulatorKnockOut.AccumulatorKnockOutBuilder toBuilder();
	
	static AccumulatorKnockOut.AccumulatorKnockOutBuilder builder() {
		return new AccumulatorKnockOut.AccumulatorKnockOutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccumulatorKnockOut> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccumulatorKnockOut> getType() {
		return AccumulatorKnockOut.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("targetPerformance"), BigDecimal.class, getTargetPerformance(), this);
		processor.processBasic(path.newSubPath("level"), BigDecimal.class, getLevel(), this);
		processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccumulatorKnockOutBuilder extends AccumulatorKnockOut, RosettaModelObjectBuilder {
		AccumulatorKnockOut.AccumulatorKnockOutBuilder setTargetPerformance(BigDecimal targetPerformance);
		AccumulatorKnockOut.AccumulatorKnockOutBuilder setLevel(BigDecimal level);
		AccumulatorKnockOut.AccumulatorKnockOutBuilder setTriggerTimeType(TriggerTimeTypeEnum triggerTimeType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("targetPerformance"), BigDecimal.class, getTargetPerformance(), this);
			processor.processBasic(path.newSubPath("level"), BigDecimal.class, getLevel(), this);
			processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
		}
		

		AccumulatorKnockOut.AccumulatorKnockOutBuilder prune();
	}

	/*********************** Immutable Implementation of AccumulatorKnockOut  ***********************/
	class AccumulatorKnockOutImpl implements AccumulatorKnockOut {
		private final BigDecimal targetPerformance;
		private final BigDecimal level;
		private final TriggerTimeTypeEnum triggerTimeType;
		
		protected AccumulatorKnockOutImpl(AccumulatorKnockOut.AccumulatorKnockOutBuilder builder) {
			this.targetPerformance = builder.getTargetPerformance();
			this.level = builder.getLevel();
			this.triggerTimeType = builder.getTriggerTimeType();
		}
		
		@Override
		@RosettaAttribute("targetPerformance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("targetPerformance")
		public BigDecimal getTargetPerformance() {
			return targetPerformance;
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public BigDecimal getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("triggerTimeType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("triggerTimeType")
		public TriggerTimeTypeEnum getTriggerTimeType() {
			return triggerTimeType;
		}
		
		@Override
		public AccumulatorKnockOut build() {
			return this;
		}
		
		@Override
		public AccumulatorKnockOut.AccumulatorKnockOutBuilder toBuilder() {
			AccumulatorKnockOut.AccumulatorKnockOutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccumulatorKnockOut.AccumulatorKnockOutBuilder builder) {
			ofNullable(getTargetPerformance()).ifPresent(builder::setTargetPerformance);
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getTriggerTimeType()).ifPresent(builder::setTriggerTimeType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccumulatorKnockOut _that = getType().cast(o);
		
			if (!Objects.equals(targetPerformance, _that.getTargetPerformance())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(triggerTimeType, _that.getTriggerTimeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (targetPerformance != null ? targetPerformance.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (triggerTimeType != null ? triggerTimeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccumulatorKnockOut {" +
				"targetPerformance=" + this.targetPerformance + ", " +
				"level=" + this.level + ", " +
				"triggerTimeType=" + this.triggerTimeType +
			'}';
		}
	}

	/*********************** Builder Implementation of AccumulatorKnockOut  ***********************/
	class AccumulatorKnockOutBuilderImpl implements AccumulatorKnockOut.AccumulatorKnockOutBuilder {
	
		protected BigDecimal targetPerformance;
		protected BigDecimal level;
		protected TriggerTimeTypeEnum triggerTimeType;
		
		@Override
		@RosettaAttribute("targetPerformance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("targetPerformance")
		public BigDecimal getTargetPerformance() {
			return targetPerformance;
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public BigDecimal getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("triggerTimeType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("triggerTimeType")
		public TriggerTimeTypeEnum getTriggerTimeType() {
			return triggerTimeType;
		}
		
		@RosettaAttribute("targetPerformance")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("targetPerformance")
		@Override
		public AccumulatorKnockOut.AccumulatorKnockOutBuilder setTargetPerformance(BigDecimal _targetPerformance) {
			this.targetPerformance = _targetPerformance == null ? null : _targetPerformance;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public AccumulatorKnockOut.AccumulatorKnockOutBuilder setLevel(BigDecimal _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("triggerTimeType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("triggerTimeType")
		@Override
		public AccumulatorKnockOut.AccumulatorKnockOutBuilder setTriggerTimeType(TriggerTimeTypeEnum _triggerTimeType) {
			this.triggerTimeType = _triggerTimeType == null ? null : _triggerTimeType;
			return this;
		}
		
		@Override
		public AccumulatorKnockOut build() {
			return new AccumulatorKnockOut.AccumulatorKnockOutImpl(this);
		}
		
		@Override
		public AccumulatorKnockOut.AccumulatorKnockOutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccumulatorKnockOut.AccumulatorKnockOutBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTargetPerformance()!=null) return true;
			if (getLevel()!=null) return true;
			if (getTriggerTimeType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccumulatorKnockOut.AccumulatorKnockOutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccumulatorKnockOut.AccumulatorKnockOutBuilder o = (AccumulatorKnockOut.AccumulatorKnockOutBuilder) other;
			
			
			merger.mergeBasic(getTargetPerformance(), o.getTargetPerformance(), this::setTargetPerformance);
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeBasic(getTriggerTimeType(), o.getTriggerTimeType(), this::setTriggerTimeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccumulatorKnockOut _that = getType().cast(o);
		
			if (!Objects.equals(targetPerformance, _that.getTargetPerformance())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(triggerTimeType, _that.getTriggerTimeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (targetPerformance != null ? targetPerformance.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (triggerTimeType != null ? triggerTimeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccumulatorKnockOutBuilder {" +
				"targetPerformance=" + this.targetPerformance + ", " +
				"level=" + this.level + ", " +
				"triggerTimeType=" + this.triggerTimeType +
			'}';
		}
	}
}
