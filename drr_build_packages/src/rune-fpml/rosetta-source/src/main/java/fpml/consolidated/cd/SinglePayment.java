package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.SinglePaymentMeta;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PaymentBase;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="SinglePayment", builder=SinglePayment.SinglePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SinglePayment", model="fpml", builder=SinglePayment.SinglePaymentBuilderImpl.class, version="2.1.1")
public interface SinglePayment extends PaymentBase {

	SinglePaymentMeta metaData = new SinglePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A fixed amount payment date that shall be subject to adjustment in accordance with the applicable business day convention if it would otherwise fall on a day that is not a business day. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component. ISDA 2003 Term: Fixed Rate Payer Payment Date
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fixed amount payment date that shall be subject to adjustment in accordance with the applicable business day convention if it would otherwise fall on a day that is not a business day. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component. ISDA 2003 Term: Fixed Rate Payer Payment Date
	 *
	 */
	ZonedDateTime getAdjustablePaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component.
	 *
	 */
	ZonedDateTime getAdjustedPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A fixed payment amount. ISDA 2003 Term: Fixed Amount
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fixed payment amount. ISDA 2003 Term: Fixed Amount
	 *
	 */
	Money getFixedAmount();

	/*********************** Build Methods  ***********************/
	SinglePayment build();
	
	SinglePayment.SinglePaymentBuilder toBuilder();
	
	static SinglePayment.SinglePaymentBuilder builder() {
		return new SinglePayment.SinglePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SinglePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SinglePayment> getType() {
		return SinglePayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("adjustablePaymentDate"), ZonedDateTime.class, getAdjustablePaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedPaymentDate"), ZonedDateTime.class, getAdjustedPaymentDate(), this);
		processRosetta(path.newSubPath("fixedAmount"), processor, Money.class, getFixedAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SinglePaymentBuilder extends SinglePayment, PaymentBase.PaymentBaseBuilder {
		Money.MoneyBuilder getOrCreateFixedAmount();
		@Override
		Money.MoneyBuilder getFixedAmount();
		@Override
		SinglePayment.SinglePaymentBuilder setId(String id);
		SinglePayment.SinglePaymentBuilder setAdjustablePaymentDate(ZonedDateTime adjustablePaymentDate);
		SinglePayment.SinglePaymentBuilder setAdjustedPaymentDate(ZonedDateTime adjustedPaymentDate);
		SinglePayment.SinglePaymentBuilder setFixedAmount(Money fixedAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("adjustablePaymentDate"), ZonedDateTime.class, getAdjustablePaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedPaymentDate"), ZonedDateTime.class, getAdjustedPaymentDate(), this);
			processRosetta(path.newSubPath("fixedAmount"), processor, Money.MoneyBuilder.class, getFixedAmount());
		}
		

		SinglePayment.SinglePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of SinglePayment  ***********************/
	class SinglePaymentImpl extends PaymentBase.PaymentBaseImpl implements SinglePayment {
		private final ZonedDateTime adjustablePaymentDate;
		private final ZonedDateTime adjustedPaymentDate;
		private final Money fixedAmount;
		
		protected SinglePaymentImpl(SinglePayment.SinglePaymentBuilder builder) {
			super(builder);
			this.adjustablePaymentDate = builder.getAdjustablePaymentDate();
			this.adjustedPaymentDate = builder.getAdjustedPaymentDate();
			this.fixedAmount = ofNullable(builder.getFixedAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("adjustablePaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustablePaymentDate")
		public ZonedDateTime getAdjustablePaymentDate() {
			return adjustablePaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedPaymentDate")
		public ZonedDateTime getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedAmount")
		public Money getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		public SinglePayment build() {
			return this;
		}
		
		@Override
		public SinglePayment.SinglePaymentBuilder toBuilder() {
			SinglePayment.SinglePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SinglePayment.SinglePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAdjustablePaymentDate()).ifPresent(builder::setAdjustablePaymentDate);
			ofNullable(getAdjustedPaymentDate()).ifPresent(builder::setAdjustedPaymentDate);
			ofNullable(getFixedAmount()).ifPresent(builder::setFixedAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SinglePayment _that = getType().cast(o);
		
			if (!Objects.equals(adjustablePaymentDate, _that.getAdjustablePaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustablePaymentDate != null ? adjustablePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SinglePayment {" +
				"adjustablePaymentDate=" + this.adjustablePaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"fixedAmount=" + this.fixedAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SinglePayment  ***********************/
	class SinglePaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements SinglePayment.SinglePaymentBuilder {
	
		protected ZonedDateTime adjustablePaymentDate;
		protected ZonedDateTime adjustedPaymentDate;
		protected Money.MoneyBuilder fixedAmount;
		
		@Override
		@RosettaAttribute("adjustablePaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustablePaymentDate")
		public ZonedDateTime getAdjustablePaymentDate() {
			return adjustablePaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedPaymentDate")
		public ZonedDateTime getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedAmount")
		public Money.MoneyBuilder getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateFixedAmount() {
			Money.MoneyBuilder result;
			if (fixedAmount!=null) {
				result = fixedAmount;
			}
			else {
				result = fixedAmount = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SinglePayment.SinglePaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustablePaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustablePaymentDate")
		@Override
		public SinglePayment.SinglePaymentBuilder setAdjustablePaymentDate(ZonedDateTime _adjustablePaymentDate) {
			this.adjustablePaymentDate = _adjustablePaymentDate == null ? null : _adjustablePaymentDate;
			return this;
		}
		
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedPaymentDate")
		@Override
		public SinglePayment.SinglePaymentBuilder setAdjustedPaymentDate(ZonedDateTime _adjustedPaymentDate) {
			this.adjustedPaymentDate = _adjustedPaymentDate == null ? null : _adjustedPaymentDate;
			return this;
		}
		
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixedAmount")
		@Override
		public SinglePayment.SinglePaymentBuilder setFixedAmount(Money _fixedAmount) {
			this.fixedAmount = _fixedAmount == null ? null : _fixedAmount.toBuilder();
			return this;
		}
		
		@Override
		public SinglePayment build() {
			return new SinglePayment.SinglePaymentImpl(this);
		}
		
		@Override
		public SinglePayment.SinglePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SinglePayment.SinglePaymentBuilder prune() {
			super.prune();
			if (fixedAmount!=null && !fixedAmount.prune().hasData()) fixedAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAdjustablePaymentDate()!=null) return true;
			if (getAdjustedPaymentDate()!=null) return true;
			if (getFixedAmount()!=null && getFixedAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SinglePayment.SinglePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SinglePayment.SinglePaymentBuilder o = (SinglePayment.SinglePaymentBuilder) other;
			
			merger.mergeRosetta(getFixedAmount(), o.getFixedAmount(), this::setFixedAmount);
			
			merger.mergeBasic(getAdjustablePaymentDate(), o.getAdjustablePaymentDate(), this::setAdjustablePaymentDate);
			merger.mergeBasic(getAdjustedPaymentDate(), o.getAdjustedPaymentDate(), this::setAdjustedPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SinglePayment _that = getType().cast(o);
		
			if (!Objects.equals(adjustablePaymentDate, _that.getAdjustablePaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustablePaymentDate != null ? adjustablePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SinglePaymentBuilder {" +
				"adjustablePaymentDate=" + this.adjustablePaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"fixedAmount=" + this.fixedAmount +
			'}' + " " + super.toString();
		}
	}
}
