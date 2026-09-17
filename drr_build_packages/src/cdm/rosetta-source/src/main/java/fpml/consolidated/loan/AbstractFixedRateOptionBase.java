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
import fpml.consolidated.loan.meta.AbstractFixedRateOptionBaseMeta;
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
@RosettaDataType(value="AbstractFixedRateOptionBase", builder=AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractFixedRateOptionBase", model="fpml", builder=AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilderImpl.class, version="2.1.1")
public interface AbstractFixedRateOptionBase extends AbstractAccrualOptionBase {

	AbstractFixedRateOptionBaseMeta metaData = new AbstractFixedRateOptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	BigDecimal getRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	BigDecimal getPikSpread();

	/*********************** Build Methods  ***********************/
	AbstractFixedRateOptionBase build();
	
	AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder toBuilder();
	
	static AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder builder() {
		return new AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFixedRateOptionBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractFixedRateOptionBase> getType() {
		return AbstractFixedRateOptionBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractFixedRateOptionBaseBuilder extends AbstractFixedRateOptionBase, AbstractAccrualOptionBase.AbstractAccrualOptionBaseBuilder {
		@Override
		AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency);
		AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setRate(BigDecimal rate);
		AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setPikSpread(BigDecimal pikSpread);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		}
		

		AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFixedRateOptionBase  ***********************/
	class AbstractFixedRateOptionBaseImpl extends AbstractAccrualOptionBase.AbstractAccrualOptionBaseImpl implements AbstractFixedRateOptionBase {
		private final BigDecimal rate;
		private final BigDecimal pikSpread;
		
		protected AbstractFixedRateOptionBaseImpl(AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
			this.pikSpread = builder.getPikSpread();
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
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@Override
		public AbstractFixedRateOptionBase build() {
			return this;
		}
		
		@Override
		public AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder toBuilder() {
			AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getPikSpread()).ifPresent(builder::setPikSpread);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFixedRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFixedRateOptionBase {" +
				"rate=" + this.rate + ", " +
				"pikSpread=" + this.pikSpread +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFixedRateOptionBase  ***********************/
	class AbstractFixedRateOptionBaseBuilderImpl extends AbstractAccrualOptionBase.AbstractAccrualOptionBaseBuilderImpl implements AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder {
	
		protected BigDecimal rate;
		protected BigDecimal pikSpread;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pikSpread")
		@Override
		public AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder setPikSpread(BigDecimal _pikSpread) {
			this.pikSpread = _pikSpread == null ? null : _pikSpread;
			return this;
		}
		
		@Override
		public AbstractFixedRateOptionBase build() {
			return new AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseImpl(this);
		}
		
		@Override
		public AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			if (getPikSpread()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder o = (AbstractFixedRateOptionBase.AbstractFixedRateOptionBaseBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getPikSpread(), o.getPikSpread(), this::setPikSpread);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFixedRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFixedRateOptionBaseBuilder {" +
				"rate=" + this.rate + ", " +
				"pikSpread=" + this.pikSpread +
			'}' + " " + super.toString();
		}
	}
}
