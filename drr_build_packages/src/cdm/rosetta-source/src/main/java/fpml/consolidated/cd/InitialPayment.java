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
import fpml.consolidated.cd.meta.InitialPaymentMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
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
@RosettaDataType(value="InitialPayment", builder=InitialPayment.InitialPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InitialPayment", model="fpml", builder=InitialPayment.InitialPaymentBuilderImpl.class, version="2.1.1")
public interface InitialPayment extends PaymentBase {

	InitialPaymentMeta metaData = new InitialPaymentMeta();

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
	 * Provision A fixed payment date that shall be subject to adjustment in accordance with the applicable business day convention if it would otherwise fall on a day that is not a business day. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fixed payment date that shall be subject to adjustment in accordance with the applicable business day convention if it would otherwise fall on a day that is not a business day. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component.
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
	 * Provision A fixed payment amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fixed payment amount.
	 *
	 */
	Money getPaymentAmount();

	/*********************** Build Methods  ***********************/
	InitialPayment build();
	
	InitialPayment.InitialPaymentBuilder toBuilder();
	
	static InitialPayment.InitialPaymentBuilder builder() {
		return new InitialPayment.InitialPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InitialPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InitialPayment> getType() {
		return InitialPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processor.processBasic(path.newSubPath("adjustablePaymentDate"), ZonedDateTime.class, getAdjustablePaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedPaymentDate"), ZonedDateTime.class, getAdjustedPaymentDate(), this);
		processRosetta(path.newSubPath("paymentAmount"), processor, Money.class, getPaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InitialPaymentBuilder extends InitialPayment, PaymentBase.PaymentBaseBuilder {
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
		Money.MoneyBuilder getOrCreatePaymentAmount();
		@Override
		Money.MoneyBuilder getPaymentAmount();
		@Override
		InitialPayment.InitialPaymentBuilder setId(String id);
		InitialPayment.InitialPaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		InitialPayment.InitialPaymentBuilder setPayerAccountReference(AccountReference payerAccountReference);
		InitialPayment.InitialPaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		InitialPayment.InitialPaymentBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		InitialPayment.InitialPaymentBuilder setAdjustablePaymentDate(ZonedDateTime adjustablePaymentDate);
		InitialPayment.InitialPaymentBuilder setAdjustedPaymentDate(ZonedDateTime adjustedPaymentDate);
		InitialPayment.InitialPaymentBuilder setPaymentAmount(Money paymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processor.processBasic(path.newSubPath("adjustablePaymentDate"), ZonedDateTime.class, getAdjustablePaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedPaymentDate"), ZonedDateTime.class, getAdjustedPaymentDate(), this);
			processRosetta(path.newSubPath("paymentAmount"), processor, Money.MoneyBuilder.class, getPaymentAmount());
		}
		

		InitialPayment.InitialPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of InitialPayment  ***********************/
	class InitialPaymentImpl extends PaymentBase.PaymentBaseImpl implements InitialPayment {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final ZonedDateTime adjustablePaymentDate;
		private final ZonedDateTime adjustedPaymentDate;
		private final Money paymentAmount;
		
		protected InitialPaymentImpl(InitialPayment.InitialPaymentBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.adjustablePaymentDate = builder.getAdjustablePaymentDate();
			this.adjustedPaymentDate = builder.getAdjustedPaymentDate();
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentAmount")
		public Money getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public InitialPayment build() {
			return this;
		}
		
		@Override
		public InitialPayment.InitialPaymentBuilder toBuilder() {
			InitialPayment.InitialPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InitialPayment.InitialPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getAdjustablePaymentDate()).ifPresent(builder::setAdjustablePaymentDate);
			ofNullable(getAdjustedPaymentDate()).ifPresent(builder::setAdjustedPaymentDate);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InitialPayment _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(adjustablePaymentDate, _that.getAdjustablePaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (adjustablePaymentDate != null ? adjustablePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialPayment {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"adjustablePaymentDate=" + this.adjustablePaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InitialPayment  ***********************/
	class InitialPaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements InitialPayment.InitialPaymentBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected ZonedDateTime adjustablePaymentDate;
		protected ZonedDateTime adjustedPaymentDate;
		protected Money.MoneyBuilder paymentAmount;
		
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
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentAmount")
		public Money.MoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePaymentAmount() {
			Money.MoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public InitialPayment.InitialPaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public InitialPayment.InitialPaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public InitialPayment.InitialPaymentBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public InitialPayment.InitialPaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public InitialPayment.InitialPaymentBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustablePaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustablePaymentDate")
		@Override
		public InitialPayment.InitialPaymentBuilder setAdjustablePaymentDate(ZonedDateTime _adjustablePaymentDate) {
			this.adjustablePaymentDate = _adjustablePaymentDate == null ? null : _adjustablePaymentDate;
			return this;
		}
		
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedPaymentDate")
		@Override
		public InitialPayment.InitialPaymentBuilder setAdjustedPaymentDate(ZonedDateTime _adjustedPaymentDate) {
			this.adjustedPaymentDate = _adjustedPaymentDate == null ? null : _adjustedPaymentDate;
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public InitialPayment.InitialPaymentBuilder setPaymentAmount(Money _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public InitialPayment build() {
			return new InitialPayment.InitialPaymentImpl(this);
		}
		
		@Override
		public InitialPayment.InitialPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialPayment.InitialPaymentBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getAdjustablePaymentDate()!=null) return true;
			if (getAdjustedPaymentDate()!=null) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialPayment.InitialPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			InitialPayment.InitialPaymentBuilder o = (InitialPayment.InitialPaymentBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			
			merger.mergeBasic(getAdjustablePaymentDate(), o.getAdjustablePaymentDate(), this::setAdjustablePaymentDate);
			merger.mergeBasic(getAdjustedPaymentDate(), o.getAdjustedPaymentDate(), this::setAdjustedPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InitialPayment _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(adjustablePaymentDate, _that.getAdjustablePaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (adjustablePaymentDate != null ? adjustablePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialPaymentBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"adjustablePaymentDate=" + this.adjustablePaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}
}
