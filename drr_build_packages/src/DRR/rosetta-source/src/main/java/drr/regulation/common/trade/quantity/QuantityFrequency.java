package drr.regulation.common.trade.quantity;

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
import drr.regulation.common.trade.quantity.meta.QuantityFrequencyMeta;
import drr.standards.iso.FrequencyPeriodEnum;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="QuantityFrequency", builder=QuantityFrequency.QuantityFrequencyBuilderImpl.class, version="7.7.0")
@RuneDataType(value="QuantityFrequency", model="drr", builder=QuantityFrequency.QuantityFrequencyBuilderImpl.class, version="7.7.0")
public interface QuantityFrequency extends RosettaModelObject {

	QuantityFrequencyMeta metaData = new QuantityFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	FrequencyPeriodEnum getPeriod();
	Integer getPeriodMultiplier();

	/*********************** Build Methods  ***********************/
	QuantityFrequency build();
	
	QuantityFrequency.QuantityFrequencyBuilder toBuilder();
	
	static QuantityFrequency.QuantityFrequencyBuilder builder() {
		return new QuantityFrequency.QuantityFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuantityFrequency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QuantityFrequency> getType() {
		return QuantityFrequency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("period"), FrequencyPeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuantityFrequencyBuilder extends QuantityFrequency, RosettaModelObjectBuilder {
		QuantityFrequency.QuantityFrequencyBuilder setPeriod(FrequencyPeriodEnum period);
		QuantityFrequency.QuantityFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("period"), FrequencyPeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		}
		

		QuantityFrequency.QuantityFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of QuantityFrequency  ***********************/
	class QuantityFrequencyImpl implements QuantityFrequency {
		private final FrequencyPeriodEnum period;
		private final Integer periodMultiplier;
		
		protected QuantityFrequencyImpl(QuantityFrequency.QuantityFrequencyBuilder builder) {
			this.period = builder.getPeriod();
			this.periodMultiplier = builder.getPeriodMultiplier();
		}
		
		@Override
		@RosettaAttribute("period")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("period")
		public FrequencyPeriodEnum getPeriod() {
			return period;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodMultiplier")
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		public QuantityFrequency build() {
			return this;
		}
		
		@Override
		public QuantityFrequency.QuantityFrequencyBuilder toBuilder() {
			QuantityFrequency.QuantityFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantityFrequency.QuantityFrequencyBuilder builder) {
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
			ofNullable(getPeriodMultiplier()).ifPresent(builder::setPeriodMultiplier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityFrequency _that = getType().cast(o);
		
			if (!Objects.equals(period, _that.getPeriod())) return false;
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityFrequency {" +
				"period=" + this.period + ", " +
				"periodMultiplier=" + this.periodMultiplier +
			'}';
		}
	}

	/*********************** Builder Implementation of QuantityFrequency  ***********************/
	class QuantityFrequencyBuilderImpl implements QuantityFrequency.QuantityFrequencyBuilder {
	
		protected FrequencyPeriodEnum period;
		protected Integer periodMultiplier;
		
		@Override
		@RosettaAttribute("period")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("period")
		public FrequencyPeriodEnum getPeriod() {
			return period;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodMultiplier")
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("period")
		@Override
		public QuantityFrequency.QuantityFrequencyBuilder setPeriod(FrequencyPeriodEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodMultiplier")
		@Override
		public QuantityFrequency.QuantityFrequencyBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@Override
		public QuantityFrequency build() {
			return new QuantityFrequency.QuantityFrequencyImpl(this);
		}
		
		@Override
		public QuantityFrequency.QuantityFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityFrequency.QuantityFrequencyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriod()!=null) return true;
			if (getPeriodMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityFrequency.QuantityFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuantityFrequency.QuantityFrequencyBuilder o = (QuantityFrequency.QuantityFrequencyBuilder) other;
			
			
			merger.mergeBasic(getPeriod(), o.getPeriod(), this::setPeriod);
			merger.mergeBasic(getPeriodMultiplier(), o.getPeriodMultiplier(), this::setPeriodMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityFrequency _that = getType().cast(o);
		
			if (!Objects.equals(period, _that.getPeriod())) return false;
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityFrequencyBuilder {" +
				"period=" + this.period + ", " +
				"periodMultiplier=" + this.periodMultiplier +
			'}';
		}
	}
}
