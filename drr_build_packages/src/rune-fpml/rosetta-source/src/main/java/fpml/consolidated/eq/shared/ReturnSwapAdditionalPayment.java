package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.ReturnSwapAdditionalPaymentMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PaymentBase;
import fpml.consolidated.shared.PaymentType;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the additional payment(s) between the principal parties to the trade. This component extends some of the features of the additionalPayment component previously developed in FpML. Appropriate discussions will determine whether it would be appropriate to extend the shared component in order to meet the further requirements of equity swaps.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the additional payment(s) between the principal parties to the trade. This component extends some of the features of the additionalPayment component previously developed in FpML. Appropriate discussions will determine whether it would be appropriate to extend the shared component in order to meet the further requirements of equity swaps.
 *
 */
@RosettaDataType(value="ReturnSwapAdditionalPayment", builder=ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnSwapAdditionalPayment", model="fpml", builder=ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilderImpl.class, version="2.1.1")
public interface ReturnSwapAdditionalPayment extends PaymentBase {

	ReturnSwapAdditionalPaymentMeta metaData = new ReturnSwapAdditionalPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 */
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 */
	AccountReference getPayerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 */
	AccountReference getReceiverAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the amount of the fee along with, when applicable, the formula that supports its determination.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the amount of the fee along with, when applicable, the formula that supports its determination.
	 *
	 */
	AdditionalPaymentAmount getAdditionalPaymentAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the value date of the fee payment/receipt.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the value date of the fee payment/receipt.
	 *
	 */
	AdjustableOrRelativeDate getAdditionalPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Classification of the payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Classification of the payment.
	 *
	 */
	PaymentType getPaymentType();

	/*********************** Build Methods  ***********************/
	ReturnSwapAdditionalPayment build();
	
	ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder toBuilder();
	
	static ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder builder() {
		return new ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapAdditionalPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnSwapAdditionalPayment> getType() {
		return ReturnSwapAdditionalPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("additionalPaymentAmount"), processor, AdditionalPaymentAmount.class, getAdditionalPaymentAmount());
		processRosetta(path.newSubPath("additionalPaymentDate"), processor, AdjustableOrRelativeDate.class, getAdditionalPaymentDate());
		processRosetta(path.newSubPath("paymentType"), processor, PaymentType.class, getPaymentType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapAdditionalPaymentBuilder extends ReturnSwapAdditionalPayment, PaymentBase.PaymentBaseBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getPayerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getReceiverAccountReference();
		AdditionalPaymentAmount.AdditionalPaymentAmountBuilder getOrCreateAdditionalPaymentAmount();
		@Override
		AdditionalPaymentAmount.AdditionalPaymentAmountBuilder getAdditionalPaymentAmount();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateAdditionalPaymentDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getAdditionalPaymentDate();
		PaymentType.PaymentTypeBuilder getOrCreatePaymentType();
		@Override
		PaymentType.PaymentTypeBuilder getPaymentType();
		@Override
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setId(String id);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPayerAccountReference(AccountReference payerAccountReference);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setAdditionalPaymentAmount(AdditionalPaymentAmount additionalPaymentAmount);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setAdditionalPaymentDate(AdjustableOrRelativeDate additionalPaymentDate);
		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPaymentType(PaymentType paymentType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("additionalPaymentAmount"), processor, AdditionalPaymentAmount.AdditionalPaymentAmountBuilder.class, getAdditionalPaymentAmount());
			processRosetta(path.newSubPath("additionalPaymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getAdditionalPaymentDate());
			processRosetta(path.newSubPath("paymentType"), processor, PaymentType.PaymentTypeBuilder.class, getPaymentType());
		}
		

		ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapAdditionalPayment  ***********************/
	class ReturnSwapAdditionalPaymentImpl extends PaymentBase.PaymentBaseImpl implements ReturnSwapAdditionalPayment {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final AdditionalPaymentAmount additionalPaymentAmount;
		private final AdjustableOrRelativeDate additionalPaymentDate;
		private final PaymentType paymentType;
		
		protected ReturnSwapAdditionalPaymentImpl(ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.additionalPaymentAmount = ofNullable(builder.getAdditionalPaymentAmount()).map(f->f.build()).orElse(null);
			this.additionalPaymentDate = ofNullable(builder.getAdditionalPaymentDate()).map(f->f.build()).orElse(null);
			this.paymentType = ofNullable(builder.getPaymentType()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		@RosettaAttribute("additionalPaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalPaymentAmount")
		public AdditionalPaymentAmount getAdditionalPaymentAmount() {
			return additionalPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("additionalPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalPaymentDate")
		public AdjustableOrRelativeDate getAdditionalPaymentDate() {
			return additionalPaymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentType")
		public PaymentType getPaymentType() {
			return paymentType;
		}
		
		@Override
		public ReturnSwapAdditionalPayment build() {
			return this;
		}
		
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder toBuilder() {
			ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getAdditionalPaymentAmount()).ifPresent(builder::setAdditionalPaymentAmount);
			ofNullable(getAdditionalPaymentDate()).ifPresent(builder::setAdditionalPaymentDate);
			ofNullable(getPaymentType()).ifPresent(builder::setPaymentType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapAdditionalPayment _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(additionalPaymentAmount, _that.getAdditionalPaymentAmount())) return false;
			if (!Objects.equals(additionalPaymentDate, _that.getAdditionalPaymentDate())) return false;
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (additionalPaymentAmount != null ? additionalPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (additionalPaymentDate != null ? additionalPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapAdditionalPayment {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"additionalPaymentAmount=" + this.additionalPaymentAmount + ", " +
				"additionalPaymentDate=" + this.additionalPaymentDate + ", " +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapAdditionalPayment  ***********************/
	class ReturnSwapAdditionalPaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected AdditionalPaymentAmount.AdditionalPaymentAmountBuilder additionalPaymentAmount;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder additionalPaymentDate;
		protected PaymentType.PaymentTypeBuilder paymentType;
		
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
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference.AccountReferenceBuilder getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (payerAccountReference!=null) {
				result = payerAccountReference;
			}
			else {
				result = payerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference.AccountReferenceBuilder getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (receiverAccountReference!=null) {
				result = receiverAccountReference;
			}
			else {
				result = receiverAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalPaymentAmount")
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder getAdditionalPaymentAmount() {
			return additionalPaymentAmount;
		}
		
		@Override
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder getOrCreateAdditionalPaymentAmount() {
			AdditionalPaymentAmount.AdditionalPaymentAmountBuilder result;
			if (additionalPaymentAmount!=null) {
				result = additionalPaymentAmount;
			}
			else {
				result = additionalPaymentAmount = AdditionalPaymentAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalPaymentDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getAdditionalPaymentDate() {
			return additionalPaymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateAdditionalPaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (additionalPaymentDate!=null) {
				result = additionalPaymentDate;
			}
			else {
				result = additionalPaymentDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentType")
		public PaymentType.PaymentTypeBuilder getPaymentType() {
			return paymentType;
		}
		
		@Override
		public PaymentType.PaymentTypeBuilder getOrCreatePaymentType() {
			PaymentType.PaymentTypeBuilder result;
			if (paymentType!=null) {
				result = paymentType;
			}
			else {
				result = paymentType = PaymentType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalPaymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalPaymentAmount")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setAdditionalPaymentAmount(AdditionalPaymentAmount _additionalPaymentAmount) {
			this.additionalPaymentAmount = _additionalPaymentAmount == null ? null : _additionalPaymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalPaymentDate")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setAdditionalPaymentDate(AdjustableOrRelativeDate _additionalPaymentDate) {
			this.additionalPaymentDate = _additionalPaymentDate == null ? null : _additionalPaymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentType")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder setPaymentType(PaymentType _paymentType) {
			this.paymentType = _paymentType == null ? null : _paymentType.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwapAdditionalPayment build() {
			return new ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentImpl(this);
		}
		
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (additionalPaymentAmount!=null && !additionalPaymentAmount.prune().hasData()) additionalPaymentAmount = null;
			if (additionalPaymentDate!=null && !additionalPaymentDate.prune().hasData()) additionalPaymentDate = null;
			if (paymentType!=null && !paymentType.prune().hasData()) paymentType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getAdditionalPaymentAmount()!=null && getAdditionalPaymentAmount().hasData()) return true;
			if (getAdditionalPaymentDate()!=null && getAdditionalPaymentDate().hasData()) return true;
			if (getPaymentType()!=null && getPaymentType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder o = (ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getAdditionalPaymentAmount(), o.getAdditionalPaymentAmount(), this::setAdditionalPaymentAmount);
			merger.mergeRosetta(getAdditionalPaymentDate(), o.getAdditionalPaymentDate(), this::setAdditionalPaymentDate);
			merger.mergeRosetta(getPaymentType(), o.getPaymentType(), this::setPaymentType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapAdditionalPayment _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(additionalPaymentAmount, _that.getAdditionalPaymentAmount())) return false;
			if (!Objects.equals(additionalPaymentDate, _that.getAdditionalPaymentDate())) return false;
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (additionalPaymentAmount != null ? additionalPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (additionalPaymentDate != null ? additionalPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapAdditionalPaymentBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"additionalPaymentAmount=" + this.additionalPaymentAmount + ", " +
				"additionalPaymentDate=" + this.additionalPaymentDate + ", " +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}
}
