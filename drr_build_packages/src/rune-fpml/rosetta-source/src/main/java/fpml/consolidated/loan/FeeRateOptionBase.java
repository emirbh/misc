package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.FeeRateOptionBaseMeta;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
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
 * Provision An abstract type that specifies an underlying fixed rate cash accrual option.
 *
 */
@RosettaDataType(value="FeeRateOptionBase", builder=FeeRateOptionBase.FeeRateOptionBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FeeRateOptionBase", model="fpml", builder=FeeRateOptionBase.FeeRateOptionBaseBuilderImpl.class, version="2.1.1")
public interface FeeRateOptionBase extends AbstractAccrualOptionBase {

	FeeRateOptionBaseMeta metaData = new FeeRateOptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The applicable rate.
	 *
	 */
	BigDecimal getRate();

	/*********************** Build Methods  ***********************/
	FeeRateOptionBase build();
	
	FeeRateOptionBase.FeeRateOptionBaseBuilder toBuilder();
	
	static FeeRateOptionBase.FeeRateOptionBaseBuilder builder() {
		return new FeeRateOptionBase.FeeRateOptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeeRateOptionBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FeeRateOptionBase> getType() {
		return FeeRateOptionBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeeRateOptionBaseBuilder extends FeeRateOptionBase, AbstractAccrualOptionBase.AbstractAccrualOptionBaseBuilder {
		@Override
		FeeRateOptionBase.FeeRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		FeeRateOptionBase.FeeRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		FeeRateOptionBase.FeeRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency);
		FeeRateOptionBase.FeeRateOptionBaseBuilder setRate(BigDecimal rate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		}
		

		FeeRateOptionBase.FeeRateOptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of FeeRateOptionBase  ***********************/
	class FeeRateOptionBaseImpl extends AbstractAccrualOptionBase.AbstractAccrualOptionBaseImpl implements FeeRateOptionBase {
		private final BigDecimal rate;
		
		protected FeeRateOptionBaseImpl(FeeRateOptionBase.FeeRateOptionBaseBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		public FeeRateOptionBase build() {
			return this;
		}
		
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder toBuilder() {
			FeeRateOptionBase.FeeRateOptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeeRateOptionBase.FeeRateOptionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeeRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeRateOptionBase {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FeeRateOptionBase  ***********************/
	class FeeRateOptionBaseBuilderImpl extends AbstractAccrualOptionBase.AbstractAccrualOptionBaseBuilderImpl implements FeeRateOptionBase.FeeRateOptionBaseBuilder {
	
		protected BigDecimal rate;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@Override
		public FeeRateOptionBase build() {
			return new FeeRateOptionBase.FeeRateOptionBaseImpl(this);
		}
		
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeRateOptionBase.FeeRateOptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FeeRateOptionBase.FeeRateOptionBaseBuilder o = (FeeRateOptionBase.FeeRateOptionBaseBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeeRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeRateOptionBaseBuilder {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}
}
