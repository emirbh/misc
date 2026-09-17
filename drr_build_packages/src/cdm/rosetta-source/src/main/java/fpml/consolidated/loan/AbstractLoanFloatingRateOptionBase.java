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
import fpml.consolidated.loan.meta.AbstractLoanFloatingRateOptionBaseMeta;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract type that specifies an underlying floating rate cash accrual option.
 *
 */
@RosettaDataType(value="AbstractLoanFloatingRateOptionBase", builder=AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanFloatingRateOptionBase", model="fpml", builder=AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilderImpl.class, version="2.1.1")
public interface AbstractLoanFloatingRateOptionBase extends AbstractAccrualOptionBase {

	AbstractLoanFloatingRateOptionBaseMeta metaData = new AbstractLoanFloatingRateOptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the rate option.
	 *
	 */
	LoanFloatingRate getRate();

	/*********************** Build Methods  ***********************/
	AbstractLoanFloatingRateOptionBase build();
	
	AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder toBuilder();
	
	static AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder builder() {
		return new AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanFloatingRateOptionBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanFloatingRateOptionBase> getType() {
		return AbstractLoanFloatingRateOptionBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("rate"), processor, LoanFloatingRate.class, getRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanFloatingRateOptionBaseBuilder extends AbstractLoanFloatingRateOptionBase, AbstractAccrualOptionBase.AbstractAccrualOptionBaseBuilder {
		LoanFloatingRate.LoanFloatingRateBuilder getOrCreateRate();
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder getRate();
		@Override
		AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency);
		AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder setRate(LoanFloatingRate rate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("rate"), processor, LoanFloatingRate.LoanFloatingRateBuilder.class, getRate());
		}
		

		AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanFloatingRateOptionBase  ***********************/
	class AbstractLoanFloatingRateOptionBaseImpl extends AbstractAccrualOptionBase.AbstractAccrualOptionBaseImpl implements AbstractLoanFloatingRateOptionBase {
		private final LoanFloatingRate rate;
		
		protected AbstractLoanFloatingRateOptionBaseImpl(AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder builder) {
			super(builder);
			this.rate = ofNullable(builder.getRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public LoanFloatingRate getRate() {
			return rate;
		}
		
		@Override
		public AbstractLoanFloatingRateOptionBase build() {
			return this;
		}
		
		@Override
		public AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder toBuilder() {
			AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanFloatingRateOptionBase _that = getType().cast(o);
		
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
			return "AbstractLoanFloatingRateOptionBase {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanFloatingRateOptionBase  ***********************/
	class AbstractLoanFloatingRateOptionBaseBuilderImpl extends AbstractAccrualOptionBase.AbstractAccrualOptionBaseBuilderImpl implements AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder {
	
		protected LoanFloatingRate.LoanFloatingRateBuilder rate;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public LoanFloatingRate.LoanFloatingRateBuilder getRate() {
			return rate;
		}
		
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder getOrCreateRate() {
			LoanFloatingRate.LoanFloatingRateBuilder result;
			if (rate!=null) {
				result = rate;
			}
			else {
				result = rate = LoanFloatingRate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder setRate(LoanFloatingRate _rate) {
			this.rate = _rate == null ? null : _rate.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLoanFloatingRateOptionBase build() {
			return new AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseImpl(this);
		}
		
		@Override
		public AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder prune() {
			super.prune();
			if (rate!=null && !rate.prune().hasData()) rate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null && getRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder o = (AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder) other;
			
			merger.mergeRosetta(getRate(), o.getRate(), this::setRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanFloatingRateOptionBase _that = getType().cast(o);
		
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
			return "AbstractLoanFloatingRateOptionBaseBuilder {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}
}
