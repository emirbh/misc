package drr.base.trade.payment;

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
import drr.base.trade.payment.meta.PeriodicPaymentMeta;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="PeriodicPayment", builder=PeriodicPayment.PeriodicPaymentBuilderImpl.class, version="7.7.0")
@RuneDataType(value="PeriodicPayment", model="drr", builder=PeriodicPayment.PeriodicPaymentBuilderImpl.class, version="7.7.0")
public interface PeriodicPayment extends RosettaModelObject {

	PeriodicPaymentMeta metaData = new PeriodicPaymentMeta();

	/*********************** Getter Methods  ***********************/
	InterestComputationMethod4Code getFixedRateDayCountConvention();
	InterestComputationMethod4Code getFloatingRateDayCountConvention();
	FrequencyPeriodEnum getFixedRatePaymentFrequencyPeriod();
	FrequencyPeriodEnum getFloatingRatePaymentFrequencyPeriod();
	Integer getFixedRatePaymentFrequencyPeriodMultiplier();
	Integer getFloatingRatePaymentFrequencyPeriodMultiplier();

	/*********************** Build Methods  ***********************/
	PeriodicPayment build();
	
	PeriodicPayment.PeriodicPaymentBuilder toBuilder();
	
	static PeriodicPayment.PeriodicPaymentBuilder builder() {
		return new PeriodicPayment.PeriodicPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PeriodicPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PeriodicPayment> getType() {
		return PeriodicPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fixedRateDayCountConvention"), InterestComputationMethod4Code.class, getFixedRateDayCountConvention(), this);
		processor.processBasic(path.newSubPath("floatingRateDayCountConvention"), InterestComputationMethod4Code.class, getFloatingRateDayCountConvention(), this);
		processor.processBasic(path.newSubPath("fixedRatePaymentFrequencyPeriod"), FrequencyPeriodEnum.class, getFixedRatePaymentFrequencyPeriod(), this);
		processor.processBasic(path.newSubPath("floatingRatePaymentFrequencyPeriod"), FrequencyPeriodEnum.class, getFloatingRatePaymentFrequencyPeriod(), this);
		processor.processBasic(path.newSubPath("fixedRatePaymentFrequencyPeriodMultiplier"), Integer.class, getFixedRatePaymentFrequencyPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("floatingRatePaymentFrequencyPeriodMultiplier"), Integer.class, getFloatingRatePaymentFrequencyPeriodMultiplier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PeriodicPaymentBuilder extends PeriodicPayment, RosettaModelObjectBuilder {
		PeriodicPayment.PeriodicPaymentBuilder setFixedRateDayCountConvention(InterestComputationMethod4Code fixedRateDayCountConvention);
		PeriodicPayment.PeriodicPaymentBuilder setFloatingRateDayCountConvention(InterestComputationMethod4Code floatingRateDayCountConvention);
		PeriodicPayment.PeriodicPaymentBuilder setFixedRatePaymentFrequencyPeriod(FrequencyPeriodEnum fixedRatePaymentFrequencyPeriod);
		PeriodicPayment.PeriodicPaymentBuilder setFloatingRatePaymentFrequencyPeriod(FrequencyPeriodEnum floatingRatePaymentFrequencyPeriod);
		PeriodicPayment.PeriodicPaymentBuilder setFixedRatePaymentFrequencyPeriodMultiplier(Integer fixedRatePaymentFrequencyPeriodMultiplier);
		PeriodicPayment.PeriodicPaymentBuilder setFloatingRatePaymentFrequencyPeriodMultiplier(Integer floatingRatePaymentFrequencyPeriodMultiplier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fixedRateDayCountConvention"), InterestComputationMethod4Code.class, getFixedRateDayCountConvention(), this);
			processor.processBasic(path.newSubPath("floatingRateDayCountConvention"), InterestComputationMethod4Code.class, getFloatingRateDayCountConvention(), this);
			processor.processBasic(path.newSubPath("fixedRatePaymentFrequencyPeriod"), FrequencyPeriodEnum.class, getFixedRatePaymentFrequencyPeriod(), this);
			processor.processBasic(path.newSubPath("floatingRatePaymentFrequencyPeriod"), FrequencyPeriodEnum.class, getFloatingRatePaymentFrequencyPeriod(), this);
			processor.processBasic(path.newSubPath("fixedRatePaymentFrequencyPeriodMultiplier"), Integer.class, getFixedRatePaymentFrequencyPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("floatingRatePaymentFrequencyPeriodMultiplier"), Integer.class, getFloatingRatePaymentFrequencyPeriodMultiplier(), this);
		}
		

		PeriodicPayment.PeriodicPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of PeriodicPayment  ***********************/
	class PeriodicPaymentImpl implements PeriodicPayment {
		private final InterestComputationMethod4Code fixedRateDayCountConvention;
		private final InterestComputationMethod4Code floatingRateDayCountConvention;
		private final FrequencyPeriodEnum fixedRatePaymentFrequencyPeriod;
		private final FrequencyPeriodEnum floatingRatePaymentFrequencyPeriod;
		private final Integer fixedRatePaymentFrequencyPeriodMultiplier;
		private final Integer floatingRatePaymentFrequencyPeriodMultiplier;
		
		protected PeriodicPaymentImpl(PeriodicPayment.PeriodicPaymentBuilder builder) {
			this.fixedRateDayCountConvention = builder.getFixedRateDayCountConvention();
			this.floatingRateDayCountConvention = builder.getFloatingRateDayCountConvention();
			this.fixedRatePaymentFrequencyPeriod = builder.getFixedRatePaymentFrequencyPeriod();
			this.floatingRatePaymentFrequencyPeriod = builder.getFloatingRatePaymentFrequencyPeriod();
			this.fixedRatePaymentFrequencyPeriodMultiplier = builder.getFixedRatePaymentFrequencyPeriodMultiplier();
			this.floatingRatePaymentFrequencyPeriodMultiplier = builder.getFloatingRatePaymentFrequencyPeriodMultiplier();
		}
		
		@Override
		@RosettaAttribute("fixedRateDayCountConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateDayCountConvention")
		public InterestComputationMethod4Code getFixedRateDayCountConvention() {
			return fixedRateDayCountConvention;
		}
		
		@Override
		@RosettaAttribute("floatingRateDayCountConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateDayCountConvention")
		public InterestComputationMethod4Code getFloatingRateDayCountConvention() {
			return floatingRateDayCountConvention;
		}
		
		@Override
		@RosettaAttribute("fixedRatePaymentFrequencyPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRatePaymentFrequencyPeriod")
		public FrequencyPeriodEnum getFixedRatePaymentFrequencyPeriod() {
			return fixedRatePaymentFrequencyPeriod;
		}
		
		@Override
		@RosettaAttribute("floatingRatePaymentFrequencyPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRatePaymentFrequencyPeriod")
		public FrequencyPeriodEnum getFloatingRatePaymentFrequencyPeriod() {
			return floatingRatePaymentFrequencyPeriod;
		}
		
		@Override
		@RosettaAttribute("fixedRatePaymentFrequencyPeriodMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRatePaymentFrequencyPeriodMultiplier")
		public Integer getFixedRatePaymentFrequencyPeriodMultiplier() {
			return fixedRatePaymentFrequencyPeriodMultiplier;
		}
		
		@Override
		@RosettaAttribute("floatingRatePaymentFrequencyPeriodMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRatePaymentFrequencyPeriodMultiplier")
		public Integer getFloatingRatePaymentFrequencyPeriodMultiplier() {
			return floatingRatePaymentFrequencyPeriodMultiplier;
		}
		
		@Override
		public PeriodicPayment build() {
			return this;
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder toBuilder() {
			PeriodicPayment.PeriodicPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PeriodicPayment.PeriodicPaymentBuilder builder) {
			ofNullable(getFixedRateDayCountConvention()).ifPresent(builder::setFixedRateDayCountConvention);
			ofNullable(getFloatingRateDayCountConvention()).ifPresent(builder::setFloatingRateDayCountConvention);
			ofNullable(getFixedRatePaymentFrequencyPeriod()).ifPresent(builder::setFixedRatePaymentFrequencyPeriod);
			ofNullable(getFloatingRatePaymentFrequencyPeriod()).ifPresent(builder::setFloatingRatePaymentFrequencyPeriod);
			ofNullable(getFixedRatePaymentFrequencyPeriodMultiplier()).ifPresent(builder::setFixedRatePaymentFrequencyPeriodMultiplier);
			ofNullable(getFloatingRatePaymentFrequencyPeriodMultiplier()).ifPresent(builder::setFloatingRatePaymentFrequencyPeriodMultiplier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodicPayment _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateDayCountConvention, _that.getFixedRateDayCountConvention())) return false;
			if (!Objects.equals(floatingRateDayCountConvention, _that.getFloatingRateDayCountConvention())) return false;
			if (!Objects.equals(fixedRatePaymentFrequencyPeriod, _that.getFixedRatePaymentFrequencyPeriod())) return false;
			if (!Objects.equals(floatingRatePaymentFrequencyPeriod, _that.getFloatingRatePaymentFrequencyPeriod())) return false;
			if (!Objects.equals(fixedRatePaymentFrequencyPeriodMultiplier, _that.getFixedRatePaymentFrequencyPeriodMultiplier())) return false;
			if (!Objects.equals(floatingRatePaymentFrequencyPeriodMultiplier, _that.getFloatingRatePaymentFrequencyPeriodMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateDayCountConvention != null ? fixedRateDayCountConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateDayCountConvention != null ? floatingRateDayCountConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixedRatePaymentFrequencyPeriod != null ? fixedRatePaymentFrequencyPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRatePaymentFrequencyPeriod != null ? floatingRatePaymentFrequencyPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixedRatePaymentFrequencyPeriodMultiplier != null ? fixedRatePaymentFrequencyPeriodMultiplier.hashCode() : 0);
			_result = 31 * _result + (floatingRatePaymentFrequencyPeriodMultiplier != null ? floatingRatePaymentFrequencyPeriodMultiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodicPayment {" +
				"fixedRateDayCountConvention=" + this.fixedRateDayCountConvention + ", " +
				"floatingRateDayCountConvention=" + this.floatingRateDayCountConvention + ", " +
				"fixedRatePaymentFrequencyPeriod=" + this.fixedRatePaymentFrequencyPeriod + ", " +
				"floatingRatePaymentFrequencyPeriod=" + this.floatingRatePaymentFrequencyPeriod + ", " +
				"fixedRatePaymentFrequencyPeriodMultiplier=" + this.fixedRatePaymentFrequencyPeriodMultiplier + ", " +
				"floatingRatePaymentFrequencyPeriodMultiplier=" + this.floatingRatePaymentFrequencyPeriodMultiplier +
			'}';
		}
	}

	/*********************** Builder Implementation of PeriodicPayment  ***********************/
	class PeriodicPaymentBuilderImpl implements PeriodicPayment.PeriodicPaymentBuilder {
	
		protected InterestComputationMethod4Code fixedRateDayCountConvention;
		protected InterestComputationMethod4Code floatingRateDayCountConvention;
		protected FrequencyPeriodEnum fixedRatePaymentFrequencyPeriod;
		protected FrequencyPeriodEnum floatingRatePaymentFrequencyPeriod;
		protected Integer fixedRatePaymentFrequencyPeriodMultiplier;
		protected Integer floatingRatePaymentFrequencyPeriodMultiplier;
		
		@Override
		@RosettaAttribute("fixedRateDayCountConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateDayCountConvention")
		public InterestComputationMethod4Code getFixedRateDayCountConvention() {
			return fixedRateDayCountConvention;
		}
		
		@Override
		@RosettaAttribute("floatingRateDayCountConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateDayCountConvention")
		public InterestComputationMethod4Code getFloatingRateDayCountConvention() {
			return floatingRateDayCountConvention;
		}
		
		@Override
		@RosettaAttribute("fixedRatePaymentFrequencyPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRatePaymentFrequencyPeriod")
		public FrequencyPeriodEnum getFixedRatePaymentFrequencyPeriod() {
			return fixedRatePaymentFrequencyPeriod;
		}
		
		@Override
		@RosettaAttribute("floatingRatePaymentFrequencyPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRatePaymentFrequencyPeriod")
		public FrequencyPeriodEnum getFloatingRatePaymentFrequencyPeriod() {
			return floatingRatePaymentFrequencyPeriod;
		}
		
		@Override
		@RosettaAttribute("fixedRatePaymentFrequencyPeriodMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRatePaymentFrequencyPeriodMultiplier")
		public Integer getFixedRatePaymentFrequencyPeriodMultiplier() {
			return fixedRatePaymentFrequencyPeriodMultiplier;
		}
		
		@Override
		@RosettaAttribute("floatingRatePaymentFrequencyPeriodMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRatePaymentFrequencyPeriodMultiplier")
		public Integer getFloatingRatePaymentFrequencyPeriodMultiplier() {
			return floatingRatePaymentFrequencyPeriodMultiplier;
		}
		
		@RosettaAttribute("fixedRateDayCountConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRateDayCountConvention")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFixedRateDayCountConvention(InterestComputationMethod4Code _fixedRateDayCountConvention) {
			this.fixedRateDayCountConvention = _fixedRateDayCountConvention == null ? null : _fixedRateDayCountConvention;
			return this;
		}
		
		@RosettaAttribute("floatingRateDayCountConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateDayCountConvention")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFloatingRateDayCountConvention(InterestComputationMethod4Code _floatingRateDayCountConvention) {
			this.floatingRateDayCountConvention = _floatingRateDayCountConvention == null ? null : _floatingRateDayCountConvention;
			return this;
		}
		
		@RosettaAttribute("fixedRatePaymentFrequencyPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRatePaymentFrequencyPeriod")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFixedRatePaymentFrequencyPeriod(FrequencyPeriodEnum _fixedRatePaymentFrequencyPeriod) {
			this.fixedRatePaymentFrequencyPeriod = _fixedRatePaymentFrequencyPeriod == null ? null : _fixedRatePaymentFrequencyPeriod;
			return this;
		}
		
		@RosettaAttribute("floatingRatePaymentFrequencyPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRatePaymentFrequencyPeriod")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFloatingRatePaymentFrequencyPeriod(FrequencyPeriodEnum _floatingRatePaymentFrequencyPeriod) {
			this.floatingRatePaymentFrequencyPeriod = _floatingRatePaymentFrequencyPeriod == null ? null : _floatingRatePaymentFrequencyPeriod;
			return this;
		}
		
		@RosettaAttribute("fixedRatePaymentFrequencyPeriodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRatePaymentFrequencyPeriodMultiplier")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFixedRatePaymentFrequencyPeriodMultiplier(Integer _fixedRatePaymentFrequencyPeriodMultiplier) {
			this.fixedRatePaymentFrequencyPeriodMultiplier = _fixedRatePaymentFrequencyPeriodMultiplier == null ? null : _fixedRatePaymentFrequencyPeriodMultiplier;
			return this;
		}
		
		@RosettaAttribute("floatingRatePaymentFrequencyPeriodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRatePaymentFrequencyPeriodMultiplier")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFloatingRatePaymentFrequencyPeriodMultiplier(Integer _floatingRatePaymentFrequencyPeriodMultiplier) {
			this.floatingRatePaymentFrequencyPeriodMultiplier = _floatingRatePaymentFrequencyPeriodMultiplier == null ? null : _floatingRatePaymentFrequencyPeriodMultiplier;
			return this;
		}
		
		@Override
		public PeriodicPayment build() {
			return new PeriodicPayment.PeriodicPaymentImpl(this);
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRateDayCountConvention()!=null) return true;
			if (getFloatingRateDayCountConvention()!=null) return true;
			if (getFixedRatePaymentFrequencyPeriod()!=null) return true;
			if (getFloatingRatePaymentFrequencyPeriod()!=null) return true;
			if (getFixedRatePaymentFrequencyPeriodMultiplier()!=null) return true;
			if (getFloatingRatePaymentFrequencyPeriodMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PeriodicPayment.PeriodicPaymentBuilder o = (PeriodicPayment.PeriodicPaymentBuilder) other;
			
			
			merger.mergeBasic(getFixedRateDayCountConvention(), o.getFixedRateDayCountConvention(), this::setFixedRateDayCountConvention);
			merger.mergeBasic(getFloatingRateDayCountConvention(), o.getFloatingRateDayCountConvention(), this::setFloatingRateDayCountConvention);
			merger.mergeBasic(getFixedRatePaymentFrequencyPeriod(), o.getFixedRatePaymentFrequencyPeriod(), this::setFixedRatePaymentFrequencyPeriod);
			merger.mergeBasic(getFloatingRatePaymentFrequencyPeriod(), o.getFloatingRatePaymentFrequencyPeriod(), this::setFloatingRatePaymentFrequencyPeriod);
			merger.mergeBasic(getFixedRatePaymentFrequencyPeriodMultiplier(), o.getFixedRatePaymentFrequencyPeriodMultiplier(), this::setFixedRatePaymentFrequencyPeriodMultiplier);
			merger.mergeBasic(getFloatingRatePaymentFrequencyPeriodMultiplier(), o.getFloatingRatePaymentFrequencyPeriodMultiplier(), this::setFloatingRatePaymentFrequencyPeriodMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodicPayment _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateDayCountConvention, _that.getFixedRateDayCountConvention())) return false;
			if (!Objects.equals(floatingRateDayCountConvention, _that.getFloatingRateDayCountConvention())) return false;
			if (!Objects.equals(fixedRatePaymentFrequencyPeriod, _that.getFixedRatePaymentFrequencyPeriod())) return false;
			if (!Objects.equals(floatingRatePaymentFrequencyPeriod, _that.getFloatingRatePaymentFrequencyPeriod())) return false;
			if (!Objects.equals(fixedRatePaymentFrequencyPeriodMultiplier, _that.getFixedRatePaymentFrequencyPeriodMultiplier())) return false;
			if (!Objects.equals(floatingRatePaymentFrequencyPeriodMultiplier, _that.getFloatingRatePaymentFrequencyPeriodMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateDayCountConvention != null ? fixedRateDayCountConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateDayCountConvention != null ? floatingRateDayCountConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixedRatePaymentFrequencyPeriod != null ? fixedRatePaymentFrequencyPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRatePaymentFrequencyPeriod != null ? floatingRatePaymentFrequencyPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixedRatePaymentFrequencyPeriodMultiplier != null ? fixedRatePaymentFrequencyPeriodMultiplier.hashCode() : 0);
			_result = 31 * _result + (floatingRatePaymentFrequencyPeriodMultiplier != null ? floatingRatePaymentFrequencyPeriodMultiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodicPaymentBuilder {" +
				"fixedRateDayCountConvention=" + this.fixedRateDayCountConvention + ", " +
				"floatingRateDayCountConvention=" + this.floatingRateDayCountConvention + ", " +
				"fixedRatePaymentFrequencyPeriod=" + this.fixedRatePaymentFrequencyPeriod + ", " +
				"floatingRatePaymentFrequencyPeriod=" + this.floatingRatePaymentFrequencyPeriod + ", " +
				"fixedRatePaymentFrequencyPeriodMultiplier=" + this.fixedRatePaymentFrequencyPeriodMultiplier + ", " +
				"floatingRatePaymentFrequencyPeriodMultiplier=" + this.floatingRatePaymentFrequencyPeriodMultiplier +
			'}';
		}
	}
}
