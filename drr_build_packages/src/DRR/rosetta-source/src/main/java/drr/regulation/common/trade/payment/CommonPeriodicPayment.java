package drr.regulation.common.trade.payment;

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
import drr.base.trade.payment.PeriodicPayment;
import drr.regulation.common.trade.payment.meta.CommonPeriodicPaymentMeta;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.IndexEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CommonPeriodicPayment", builder=CommonPeriodicPayment.CommonPeriodicPaymentBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CommonPeriodicPayment", model="drr", builder=CommonPeriodicPayment.CommonPeriodicPaymentBuilderImpl.class, version="7.7.0")
public interface CommonPeriodicPayment extends PeriodicPayment {

	CommonPeriodicPaymentMeta metaData = new CommonPeriodicPaymentMeta();

	/*********************** Getter Methods  ***********************/
	FrequencyPeriodEnum getFloatingRateResetFrequencyPeriod();
	Integer getFloatingRateResetFrequencyMultiplier();
	IndexEnum getFloatingRateIndicator();
	String getFloatingRateIdentifier();
	FrequencyPeriodEnum getFloatingRateReferencePeriod();
	Integer getFloatingRateReferencePeriodMultiplier();
	String getNameOfTheFloatingRate();

	/*********************** Build Methods  ***********************/
	CommonPeriodicPayment build();
	
	CommonPeriodicPayment.CommonPeriodicPaymentBuilder toBuilder();
	
	static CommonPeriodicPayment.CommonPeriodicPaymentBuilder builder() {
		return new CommonPeriodicPayment.CommonPeriodicPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonPeriodicPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonPeriodicPayment> getType() {
		return CommonPeriodicPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fixedRateDayCountConvention"), InterestComputationMethod4Code.class, getFixedRateDayCountConvention(), this);
		processor.processBasic(path.newSubPath("floatingRateDayCountConvention"), InterestComputationMethod4Code.class, getFloatingRateDayCountConvention(), this);
		processor.processBasic(path.newSubPath("fixedRatePaymentFrequencyPeriod"), FrequencyPeriodEnum.class, getFixedRatePaymentFrequencyPeriod(), this);
		processor.processBasic(path.newSubPath("floatingRatePaymentFrequencyPeriod"), FrequencyPeriodEnum.class, getFloatingRatePaymentFrequencyPeriod(), this);
		processor.processBasic(path.newSubPath("fixedRatePaymentFrequencyPeriodMultiplier"), Integer.class, getFixedRatePaymentFrequencyPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("floatingRatePaymentFrequencyPeriodMultiplier"), Integer.class, getFloatingRatePaymentFrequencyPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("floatingRateResetFrequencyPeriod"), FrequencyPeriodEnum.class, getFloatingRateResetFrequencyPeriod(), this);
		processor.processBasic(path.newSubPath("floatingRateResetFrequencyMultiplier"), Integer.class, getFloatingRateResetFrequencyMultiplier(), this);
		processor.processBasic(path.newSubPath("floatingRateIndicator"), IndexEnum.class, getFloatingRateIndicator(), this);
		processor.processBasic(path.newSubPath("floatingRateIdentifier"), String.class, getFloatingRateIdentifier(), this);
		processor.processBasic(path.newSubPath("floatingRateReferencePeriod"), FrequencyPeriodEnum.class, getFloatingRateReferencePeriod(), this);
		processor.processBasic(path.newSubPath("floatingRateReferencePeriodMultiplier"), Integer.class, getFloatingRateReferencePeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("nameOfTheFloatingRate"), String.class, getNameOfTheFloatingRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonPeriodicPaymentBuilder extends CommonPeriodicPayment, PeriodicPayment.PeriodicPaymentBuilder {
		@Override
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFixedRateDayCountConvention(InterestComputationMethod4Code fixedRateDayCountConvention);
		@Override
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateDayCountConvention(InterestComputationMethod4Code floatingRateDayCountConvention);
		@Override
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFixedRatePaymentFrequencyPeriod(FrequencyPeriodEnum fixedRatePaymentFrequencyPeriod);
		@Override
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRatePaymentFrequencyPeriod(FrequencyPeriodEnum floatingRatePaymentFrequencyPeriod);
		@Override
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFixedRatePaymentFrequencyPeriodMultiplier(Integer fixedRatePaymentFrequencyPeriodMultiplier);
		@Override
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRatePaymentFrequencyPeriodMultiplier(Integer floatingRatePaymentFrequencyPeriodMultiplier);
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateResetFrequencyPeriod(FrequencyPeriodEnum floatingRateResetFrequencyPeriod);
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateResetFrequencyMultiplier(Integer floatingRateResetFrequencyMultiplier);
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateIndicator(IndexEnum floatingRateIndicator);
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateIdentifier(String floatingRateIdentifier);
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateReferencePeriod(FrequencyPeriodEnum floatingRateReferencePeriod);
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateReferencePeriodMultiplier(Integer floatingRateReferencePeriodMultiplier);
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder setNameOfTheFloatingRate(String nameOfTheFloatingRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fixedRateDayCountConvention"), InterestComputationMethod4Code.class, getFixedRateDayCountConvention(), this);
			processor.processBasic(path.newSubPath("floatingRateDayCountConvention"), InterestComputationMethod4Code.class, getFloatingRateDayCountConvention(), this);
			processor.processBasic(path.newSubPath("fixedRatePaymentFrequencyPeriod"), FrequencyPeriodEnum.class, getFixedRatePaymentFrequencyPeriod(), this);
			processor.processBasic(path.newSubPath("floatingRatePaymentFrequencyPeriod"), FrequencyPeriodEnum.class, getFloatingRatePaymentFrequencyPeriod(), this);
			processor.processBasic(path.newSubPath("fixedRatePaymentFrequencyPeriodMultiplier"), Integer.class, getFixedRatePaymentFrequencyPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("floatingRatePaymentFrequencyPeriodMultiplier"), Integer.class, getFloatingRatePaymentFrequencyPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("floatingRateResetFrequencyPeriod"), FrequencyPeriodEnum.class, getFloatingRateResetFrequencyPeriod(), this);
			processor.processBasic(path.newSubPath("floatingRateResetFrequencyMultiplier"), Integer.class, getFloatingRateResetFrequencyMultiplier(), this);
			processor.processBasic(path.newSubPath("floatingRateIndicator"), IndexEnum.class, getFloatingRateIndicator(), this);
			processor.processBasic(path.newSubPath("floatingRateIdentifier"), String.class, getFloatingRateIdentifier(), this);
			processor.processBasic(path.newSubPath("floatingRateReferencePeriod"), FrequencyPeriodEnum.class, getFloatingRateReferencePeriod(), this);
			processor.processBasic(path.newSubPath("floatingRateReferencePeriodMultiplier"), Integer.class, getFloatingRateReferencePeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("nameOfTheFloatingRate"), String.class, getNameOfTheFloatingRate(), this);
		}
		

		CommonPeriodicPayment.CommonPeriodicPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of CommonPeriodicPayment  ***********************/
	class CommonPeriodicPaymentImpl extends PeriodicPayment.PeriodicPaymentImpl implements CommonPeriodicPayment {
		private final FrequencyPeriodEnum floatingRateResetFrequencyPeriod;
		private final Integer floatingRateResetFrequencyMultiplier;
		private final IndexEnum floatingRateIndicator;
		private final String floatingRateIdentifier;
		private final FrequencyPeriodEnum floatingRateReferencePeriod;
		private final Integer floatingRateReferencePeriodMultiplier;
		private final String nameOfTheFloatingRate;
		
		protected CommonPeriodicPaymentImpl(CommonPeriodicPayment.CommonPeriodicPaymentBuilder builder) {
			super(builder);
			this.floatingRateResetFrequencyPeriod = builder.getFloatingRateResetFrequencyPeriod();
			this.floatingRateResetFrequencyMultiplier = builder.getFloatingRateResetFrequencyMultiplier();
			this.floatingRateIndicator = builder.getFloatingRateIndicator();
			this.floatingRateIdentifier = builder.getFloatingRateIdentifier();
			this.floatingRateReferencePeriod = builder.getFloatingRateReferencePeriod();
			this.floatingRateReferencePeriodMultiplier = builder.getFloatingRateReferencePeriodMultiplier();
			this.nameOfTheFloatingRate = builder.getNameOfTheFloatingRate();
		}
		
		@Override
		@RosettaAttribute("floatingRateResetFrequencyPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateResetFrequencyPeriod")
		public FrequencyPeriodEnum getFloatingRateResetFrequencyPeriod() {
			return floatingRateResetFrequencyPeriod;
		}
		
		@Override
		@RosettaAttribute("floatingRateResetFrequencyMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateResetFrequencyMultiplier")
		public Integer getFloatingRateResetFrequencyMultiplier() {
			return floatingRateResetFrequencyMultiplier;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndicator")
		public IndexEnum getFloatingRateIndicator() {
			return floatingRateIndicator;
		}
		
		@Override
		@RosettaAttribute("floatingRateIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIdentifier")
		public String getFloatingRateIdentifier() {
			return floatingRateIdentifier;
		}
		
		@Override
		@RosettaAttribute("floatingRateReferencePeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateReferencePeriod")
		public FrequencyPeriodEnum getFloatingRateReferencePeriod() {
			return floatingRateReferencePeriod;
		}
		
		@Override
		@RosettaAttribute("floatingRateReferencePeriodMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateReferencePeriodMultiplier")
		public Integer getFloatingRateReferencePeriodMultiplier() {
			return floatingRateReferencePeriodMultiplier;
		}
		
		@Override
		@RosettaAttribute("nameOfTheFloatingRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nameOfTheFloatingRate")
		public String getNameOfTheFloatingRate() {
			return nameOfTheFloatingRate;
		}
		
		@Override
		public CommonPeriodicPayment build() {
			return this;
		}
		
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder toBuilder() {
			CommonPeriodicPayment.CommonPeriodicPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonPeriodicPayment.CommonPeriodicPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateResetFrequencyPeriod()).ifPresent(builder::setFloatingRateResetFrequencyPeriod);
			ofNullable(getFloatingRateResetFrequencyMultiplier()).ifPresent(builder::setFloatingRateResetFrequencyMultiplier);
			ofNullable(getFloatingRateIndicator()).ifPresent(builder::setFloatingRateIndicator);
			ofNullable(getFloatingRateIdentifier()).ifPresent(builder::setFloatingRateIdentifier);
			ofNullable(getFloatingRateReferencePeriod()).ifPresent(builder::setFloatingRateReferencePeriod);
			ofNullable(getFloatingRateReferencePeriodMultiplier()).ifPresent(builder::setFloatingRateReferencePeriodMultiplier);
			ofNullable(getNameOfTheFloatingRate()).ifPresent(builder::setNameOfTheFloatingRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommonPeriodicPayment _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateResetFrequencyPeriod, _that.getFloatingRateResetFrequencyPeriod())) return false;
			if (!Objects.equals(floatingRateResetFrequencyMultiplier, _that.getFloatingRateResetFrequencyMultiplier())) return false;
			if (!Objects.equals(floatingRateIndicator, _that.getFloatingRateIndicator())) return false;
			if (!Objects.equals(floatingRateIdentifier, _that.getFloatingRateIdentifier())) return false;
			if (!Objects.equals(floatingRateReferencePeriod, _that.getFloatingRateReferencePeriod())) return false;
			if (!Objects.equals(floatingRateReferencePeriodMultiplier, _that.getFloatingRateReferencePeriodMultiplier())) return false;
			if (!Objects.equals(nameOfTheFloatingRate, _that.getNameOfTheFloatingRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateResetFrequencyPeriod != null ? floatingRateResetFrequencyPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateResetFrequencyMultiplier != null ? floatingRateResetFrequencyMultiplier.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndicator != null ? floatingRateIndicator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateIdentifier != null ? floatingRateIdentifier.hashCode() : 0);
			_result = 31 * _result + (floatingRateReferencePeriod != null ? floatingRateReferencePeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateReferencePeriodMultiplier != null ? floatingRateReferencePeriodMultiplier.hashCode() : 0);
			_result = 31 * _result + (nameOfTheFloatingRate != null ? nameOfTheFloatingRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonPeriodicPayment {" +
				"floatingRateResetFrequencyPeriod=" + this.floatingRateResetFrequencyPeriod + ", " +
				"floatingRateResetFrequencyMultiplier=" + this.floatingRateResetFrequencyMultiplier + ", " +
				"floatingRateIndicator=" + this.floatingRateIndicator + ", " +
				"floatingRateIdentifier=" + this.floatingRateIdentifier + ", " +
				"floatingRateReferencePeriod=" + this.floatingRateReferencePeriod + ", " +
				"floatingRateReferencePeriodMultiplier=" + this.floatingRateReferencePeriodMultiplier + ", " +
				"nameOfTheFloatingRate=" + this.nameOfTheFloatingRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommonPeriodicPayment  ***********************/
	class CommonPeriodicPaymentBuilderImpl extends PeriodicPayment.PeriodicPaymentBuilderImpl implements CommonPeriodicPayment.CommonPeriodicPaymentBuilder {
	
		protected FrequencyPeriodEnum floatingRateResetFrequencyPeriod;
		protected Integer floatingRateResetFrequencyMultiplier;
		protected IndexEnum floatingRateIndicator;
		protected String floatingRateIdentifier;
		protected FrequencyPeriodEnum floatingRateReferencePeriod;
		protected Integer floatingRateReferencePeriodMultiplier;
		protected String nameOfTheFloatingRate;
		
		@Override
		@RosettaAttribute("floatingRateResetFrequencyPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateResetFrequencyPeriod")
		public FrequencyPeriodEnum getFloatingRateResetFrequencyPeriod() {
			return floatingRateResetFrequencyPeriod;
		}
		
		@Override
		@RosettaAttribute("floatingRateResetFrequencyMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateResetFrequencyMultiplier")
		public Integer getFloatingRateResetFrequencyMultiplier() {
			return floatingRateResetFrequencyMultiplier;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndicator")
		public IndexEnum getFloatingRateIndicator() {
			return floatingRateIndicator;
		}
		
		@Override
		@RosettaAttribute("floatingRateIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIdentifier")
		public String getFloatingRateIdentifier() {
			return floatingRateIdentifier;
		}
		
		@Override
		@RosettaAttribute("floatingRateReferencePeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateReferencePeriod")
		public FrequencyPeriodEnum getFloatingRateReferencePeriod() {
			return floatingRateReferencePeriod;
		}
		
		@Override
		@RosettaAttribute("floatingRateReferencePeriodMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateReferencePeriodMultiplier")
		public Integer getFloatingRateReferencePeriodMultiplier() {
			return floatingRateReferencePeriodMultiplier;
		}
		
		@Override
		@RosettaAttribute("nameOfTheFloatingRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nameOfTheFloatingRate")
		public String getNameOfTheFloatingRate() {
			return nameOfTheFloatingRate;
		}
		
		@RosettaAttribute("fixedRateDayCountConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRateDayCountConvention")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFixedRateDayCountConvention(InterestComputationMethod4Code _fixedRateDayCountConvention) {
			this.fixedRateDayCountConvention = _fixedRateDayCountConvention == null ? null : _fixedRateDayCountConvention;
			return this;
		}
		
		@RosettaAttribute("floatingRateDayCountConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateDayCountConvention")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateDayCountConvention(InterestComputationMethod4Code _floatingRateDayCountConvention) {
			this.floatingRateDayCountConvention = _floatingRateDayCountConvention == null ? null : _floatingRateDayCountConvention;
			return this;
		}
		
		@RosettaAttribute("fixedRatePaymentFrequencyPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRatePaymentFrequencyPeriod")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFixedRatePaymentFrequencyPeriod(FrequencyPeriodEnum _fixedRatePaymentFrequencyPeriod) {
			this.fixedRatePaymentFrequencyPeriod = _fixedRatePaymentFrequencyPeriod == null ? null : _fixedRatePaymentFrequencyPeriod;
			return this;
		}
		
		@RosettaAttribute("floatingRatePaymentFrequencyPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRatePaymentFrequencyPeriod")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRatePaymentFrequencyPeriod(FrequencyPeriodEnum _floatingRatePaymentFrequencyPeriod) {
			this.floatingRatePaymentFrequencyPeriod = _floatingRatePaymentFrequencyPeriod == null ? null : _floatingRatePaymentFrequencyPeriod;
			return this;
		}
		
		@RosettaAttribute("fixedRatePaymentFrequencyPeriodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRatePaymentFrequencyPeriodMultiplier")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFixedRatePaymentFrequencyPeriodMultiplier(Integer _fixedRatePaymentFrequencyPeriodMultiplier) {
			this.fixedRatePaymentFrequencyPeriodMultiplier = _fixedRatePaymentFrequencyPeriodMultiplier == null ? null : _fixedRatePaymentFrequencyPeriodMultiplier;
			return this;
		}
		
		@RosettaAttribute("floatingRatePaymentFrequencyPeriodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRatePaymentFrequencyPeriodMultiplier")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRatePaymentFrequencyPeriodMultiplier(Integer _floatingRatePaymentFrequencyPeriodMultiplier) {
			this.floatingRatePaymentFrequencyPeriodMultiplier = _floatingRatePaymentFrequencyPeriodMultiplier == null ? null : _floatingRatePaymentFrequencyPeriodMultiplier;
			return this;
		}
		
		@RosettaAttribute("floatingRateResetFrequencyPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateResetFrequencyPeriod")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateResetFrequencyPeriod(FrequencyPeriodEnum _floatingRateResetFrequencyPeriod) {
			this.floatingRateResetFrequencyPeriod = _floatingRateResetFrequencyPeriod == null ? null : _floatingRateResetFrequencyPeriod;
			return this;
		}
		
		@RosettaAttribute("floatingRateResetFrequencyMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateResetFrequencyMultiplier")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateResetFrequencyMultiplier(Integer _floatingRateResetFrequencyMultiplier) {
			this.floatingRateResetFrequencyMultiplier = _floatingRateResetFrequencyMultiplier == null ? null : _floatingRateResetFrequencyMultiplier;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateIndicator")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateIndicator(IndexEnum _floatingRateIndicator) {
			this.floatingRateIndicator = _floatingRateIndicator == null ? null : _floatingRateIndicator;
			return this;
		}
		
		@RosettaAttribute("floatingRateIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateIdentifier")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateIdentifier(String _floatingRateIdentifier) {
			this.floatingRateIdentifier = _floatingRateIdentifier == null ? null : _floatingRateIdentifier;
			return this;
		}
		
		@RosettaAttribute("floatingRateReferencePeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateReferencePeriod")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateReferencePeriod(FrequencyPeriodEnum _floatingRateReferencePeriod) {
			this.floatingRateReferencePeriod = _floatingRateReferencePeriod == null ? null : _floatingRateReferencePeriod;
			return this;
		}
		
		@RosettaAttribute("floatingRateReferencePeriodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateReferencePeriodMultiplier")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setFloatingRateReferencePeriodMultiplier(Integer _floatingRateReferencePeriodMultiplier) {
			this.floatingRateReferencePeriodMultiplier = _floatingRateReferencePeriodMultiplier == null ? null : _floatingRateReferencePeriodMultiplier;
			return this;
		}
		
		@RosettaAttribute("nameOfTheFloatingRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nameOfTheFloatingRate")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder setNameOfTheFloatingRate(String _nameOfTheFloatingRate) {
			this.nameOfTheFloatingRate = _nameOfTheFloatingRate == null ? null : _nameOfTheFloatingRate;
			return this;
		}
		
		@Override
		public CommonPeriodicPayment build() {
			return new CommonPeriodicPayment.CommonPeriodicPaymentImpl(this);
		}
		
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateResetFrequencyPeriod()!=null) return true;
			if (getFloatingRateResetFrequencyMultiplier()!=null) return true;
			if (getFloatingRateIndicator()!=null) return true;
			if (getFloatingRateIdentifier()!=null) return true;
			if (getFloatingRateReferencePeriod()!=null) return true;
			if (getFloatingRateReferencePeriodMultiplier()!=null) return true;
			if (getNameOfTheFloatingRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommonPeriodicPayment.CommonPeriodicPaymentBuilder o = (CommonPeriodicPayment.CommonPeriodicPaymentBuilder) other;
			
			
			merger.mergeBasic(getFloatingRateResetFrequencyPeriod(), o.getFloatingRateResetFrequencyPeriod(), this::setFloatingRateResetFrequencyPeriod);
			merger.mergeBasic(getFloatingRateResetFrequencyMultiplier(), o.getFloatingRateResetFrequencyMultiplier(), this::setFloatingRateResetFrequencyMultiplier);
			merger.mergeBasic(getFloatingRateIndicator(), o.getFloatingRateIndicator(), this::setFloatingRateIndicator);
			merger.mergeBasic(getFloatingRateIdentifier(), o.getFloatingRateIdentifier(), this::setFloatingRateIdentifier);
			merger.mergeBasic(getFloatingRateReferencePeriod(), o.getFloatingRateReferencePeriod(), this::setFloatingRateReferencePeriod);
			merger.mergeBasic(getFloatingRateReferencePeriodMultiplier(), o.getFloatingRateReferencePeriodMultiplier(), this::setFloatingRateReferencePeriodMultiplier);
			merger.mergeBasic(getNameOfTheFloatingRate(), o.getNameOfTheFloatingRate(), this::setNameOfTheFloatingRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommonPeriodicPayment _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateResetFrequencyPeriod, _that.getFloatingRateResetFrequencyPeriod())) return false;
			if (!Objects.equals(floatingRateResetFrequencyMultiplier, _that.getFloatingRateResetFrequencyMultiplier())) return false;
			if (!Objects.equals(floatingRateIndicator, _that.getFloatingRateIndicator())) return false;
			if (!Objects.equals(floatingRateIdentifier, _that.getFloatingRateIdentifier())) return false;
			if (!Objects.equals(floatingRateReferencePeriod, _that.getFloatingRateReferencePeriod())) return false;
			if (!Objects.equals(floatingRateReferencePeriodMultiplier, _that.getFloatingRateReferencePeriodMultiplier())) return false;
			if (!Objects.equals(nameOfTheFloatingRate, _that.getNameOfTheFloatingRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateResetFrequencyPeriod != null ? floatingRateResetFrequencyPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateResetFrequencyMultiplier != null ? floatingRateResetFrequencyMultiplier.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndicator != null ? floatingRateIndicator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateIdentifier != null ? floatingRateIdentifier.hashCode() : 0);
			_result = 31 * _result + (floatingRateReferencePeriod != null ? floatingRateReferencePeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateReferencePeriodMultiplier != null ? floatingRateReferencePeriodMultiplier.hashCode() : 0);
			_result = 31 * _result + (nameOfTheFloatingRate != null ? nameOfTheFloatingRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonPeriodicPaymentBuilder {" +
				"floatingRateResetFrequencyPeriod=" + this.floatingRateResetFrequencyPeriod + ", " +
				"floatingRateResetFrequencyMultiplier=" + this.floatingRateResetFrequencyMultiplier + ", " +
				"floatingRateIndicator=" + this.floatingRateIndicator + ", " +
				"floatingRateIdentifier=" + this.floatingRateIdentifier + ", " +
				"floatingRateReferencePeriod=" + this.floatingRateReferencePeriod + ", " +
				"floatingRateReferencePeriodMultiplier=" + this.floatingRateReferencePeriodMultiplier + ", " +
				"nameOfTheFloatingRate=" + this.nameOfTheFloatingRate +
			'}' + " " + super.toString();
		}
	}
}
