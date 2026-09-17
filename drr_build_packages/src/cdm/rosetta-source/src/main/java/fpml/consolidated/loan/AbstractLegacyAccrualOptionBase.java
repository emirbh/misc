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
import fpml.consolidated.loan.meta.AbstractLegacyAccrualOptionBaseMeta;
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
 * Provision An abstract type used for defining accrual structures within loan instruments.
 *
 */
@RosettaDataType(value="AbstractLegacyAccrualOptionBase", builder=AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLegacyAccrualOptionBase", model="fpml", builder=AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilderImpl.class, version="2.1.1")
public interface AbstractLegacyAccrualOptionBase extends RosettaModelObject {

	AbstractLegacyAccrualOptionBaseMeta metaData = new AbstractLegacyAccrualOptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique id associated with the loan accrual type.
	 *
	 */
	AccrualTypeId getAccrualOptionId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count basis for the accrual.
	 *
	 */
	DayCountFraction getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Period getPaymentFrequency();

	/*********************** Build Methods  ***********************/
	AbstractLegacyAccrualOptionBase build();
	
	AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder toBuilder();
	
	static AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder builder() {
		return new AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLegacyAccrualOptionBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLegacyAccrualOptionBase> getType() {
		return AbstractLegacyAccrualOptionBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLegacyAccrualOptionBaseBuilder extends AbstractLegacyAccrualOptionBase, RosettaModelObjectBuilder {
		AccrualTypeId.AccrualTypeIdBuilder getOrCreateAccrualOptionId();
		@Override
		AccrualTypeId.AccrualTypeIdBuilder getAccrualOptionId();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		Period.PeriodBuilder getOrCreatePaymentFrequency();
		@Override
		Period.PeriodBuilder getPaymentFrequency();
		AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder setPaymentFrequency(Period paymentFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
		}
		

		AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLegacyAccrualOptionBase  ***********************/
	class AbstractLegacyAccrualOptionBaseImpl implements AbstractLegacyAccrualOptionBase {
		private final AccrualTypeId accrualOptionId;
		private final DayCountFraction dayCountFraction;
		private final Period paymentFrequency;
		
		protected AbstractLegacyAccrualOptionBaseImpl(AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder builder) {
			this.accrualOptionId = ofNullable(builder.getAccrualOptionId()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		public AccrualTypeId getAccrualOptionId() {
			return accrualOptionId;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Period getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public AbstractLegacyAccrualOptionBase build() {
			return this;
		}
		
		@Override
		public AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder toBuilder() {
			AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder builder) {
			ofNullable(getAccrualOptionId()).ifPresent(builder::setAccrualOptionId);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLegacyAccrualOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(accrualOptionId, _that.getAccrualOptionId())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualOptionId != null ? accrualOptionId.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLegacyAccrualOptionBase {" +
				"accrualOptionId=" + this.accrualOptionId + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"paymentFrequency=" + this.paymentFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractLegacyAccrualOptionBase  ***********************/
	class AbstractLegacyAccrualOptionBaseBuilderImpl implements AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder {
	
		protected AccrualTypeId.AccrualTypeIdBuilder accrualOptionId;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected Period.PeriodBuilder paymentFrequency;
		
		@Override
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		public AccrualTypeId.AccrualTypeIdBuilder getAccrualOptionId() {
			return accrualOptionId;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder getOrCreateAccrualOptionId() {
			AccrualTypeId.AccrualTypeIdBuilder result;
			if (accrualOptionId!=null) {
				result = accrualOptionId;
			}
			else {
				result = accrualOptionId = AccrualTypeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Period.PeriodBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreatePaymentFrequency() {
			Period.PeriodBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Period.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLegacyAccrualOptionBase build() {
			return new AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseImpl(this);
		}
		
		@Override
		public AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder prune() {
			if (accrualOptionId!=null && !accrualOptionId.prune().hasData()) accrualOptionId = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccrualOptionId()!=null && getAccrualOptionId().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder o = (AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder) other;
			
			merger.mergeRosetta(getAccrualOptionId(), o.getAccrualOptionId(), this::setAccrualOptionId);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLegacyAccrualOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(accrualOptionId, _that.getAccrualOptionId())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualOptionId != null ? accrualOptionId.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLegacyAccrualOptionBaseBuilder {" +
				"accrualOptionId=" + this.accrualOptionId + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"paymentFrequency=" + this.paymentFrequency +
			'}';
		}
	}
}
