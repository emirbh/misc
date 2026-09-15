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
import fpml.consolidated.loan.meta.LoanSimplePaymentMeta;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PaymentBase;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A complex type to specified payments in a simpler fashion than the Payment type. This construct should be used from the version 4.3 onwards.
 *
 */
@RosettaDataType(value="LoanSimplePayment", builder=LoanSimplePayment.LoanSimplePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanSimplePayment", model="fpml", builder=LoanSimplePayment.LoanSimplePaymentBuilderImpl.class, version="2.1.1")
public interface LoanSimplePayment extends PaymentBase {

	LoanSimplePaymentMeta metaData = new LoanSimplePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for the allocation.
	 *
	 */
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that has been allocated to.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	NonNegativeMoney getPaymentAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The payment date. This date is subject to adjustment in accordance with any applicable business day convention.
	 *
	 */
	AdjustableDate getPaymentDate();

	/*********************** Build Methods  ***********************/
	LoanSimplePayment build();
	
	LoanSimplePayment.LoanSimplePaymentBuilder toBuilder();
	
	static LoanSimplePayment.LoanSimplePaymentBuilder builder() {
		return new LoanSimplePayment.LoanSimplePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanSimplePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanSimplePayment> getType() {
		return LoanSimplePayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.class, getPaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanSimplePaymentBuilder extends LoanSimplePayment, PaymentBase.PaymentBaseBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount();
		AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getPaymentDate();
		@Override
		LoanSimplePayment.LoanSimplePaymentBuilder setId(String id);
		LoanSimplePayment.LoanSimplePaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		LoanSimplePayment.LoanSimplePaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		LoanSimplePayment.LoanSimplePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		LoanSimplePayment.LoanSimplePaymentBuilder setPaymentDate(AdjustableDate paymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPaymentDate());
		}
		

		LoanSimplePayment.LoanSimplePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanSimplePayment  ***********************/
	class LoanSimplePaymentImpl extends PaymentBase.PaymentBaseImpl implements LoanSimplePayment {
		private final PartyReference payerPartyReference;
		private final PartyReference receiverPartyReference;
		private final NonNegativeMoney paymentAmount;
		private final AdjustableDate paymentDate;
		
		protected LoanSimplePaymentImpl(LoanSimplePayment.LoanSimplePaymentBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentAmount")
		public NonNegativeMoney getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentDate")
		public AdjustableDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public LoanSimplePayment build() {
			return this;
		}
		
		@Override
		public LoanSimplePayment.LoanSimplePaymentBuilder toBuilder() {
			LoanSimplePayment.LoanSimplePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanSimplePayment.LoanSimplePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanSimplePayment _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanSimplePayment {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanSimplePayment  ***********************/
	class LoanSimplePaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements LoanSimplePayment.LoanSimplePaymentBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder paymentAmount;
		protected AdjustableDate.AdjustableDateBuilder paymentDate;
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		public PartyReference.PartyReferenceBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("receiverPartyReference")
		public PartyReference.PartyReferenceBuilder getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (receiverPartyReference!=null) {
				result = receiverPartyReference;
			}
			else {
				result = receiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentDate")
		public AdjustableDate.AdjustableDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanSimplePayment.LoanSimplePaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public LoanSimplePayment.LoanSimplePaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("receiverPartyReference")
		@Override
		public LoanSimplePayment.LoanSimplePaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public LoanSimplePayment.LoanSimplePaymentBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentDate")
		@Override
		public LoanSimplePayment.LoanSimplePaymentBuilder setPaymentDate(AdjustableDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@Override
		public LoanSimplePayment build() {
			return new LoanSimplePayment.LoanSimplePaymentImpl(this);
		}
		
		@Override
		public LoanSimplePayment.LoanSimplePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanSimplePayment.LoanSimplePaymentBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanSimplePayment.LoanSimplePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanSimplePayment.LoanSimplePaymentBuilder o = (LoanSimplePayment.LoanSimplePaymentBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanSimplePayment _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanSimplePaymentBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate +
			'}' + " " + super.toString();
		}
	}
}
