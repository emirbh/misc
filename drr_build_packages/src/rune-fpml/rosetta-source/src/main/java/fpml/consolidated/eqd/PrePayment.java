package fpml.consolidated.eqd;

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
import fpml.consolidated.eqd.meta.PrePaymentMeta;
import fpml.consolidated.shared.AccountReference;
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
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining PrePayment.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining PrePayment.
 *
 */
@RosettaDataType(value="PrePayment", builder=PrePayment.PrePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PrePayment", model="fpml", builder=PrePayment.PrePaymentBuilderImpl.class, version="2.1.1")
public interface PrePayment extends PaymentBase {

	PrePaymentMeta metaData = new PrePaymentMeta();

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
	Boolean getPrePayment();
	/**
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
	NonNegativeMoney getPrePaymentAmount();
	/**
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
	AdjustableDate getPrePaymentDate();

	/*********************** Build Methods  ***********************/
	PrePayment build();
	
	PrePayment.PrePaymentBuilder toBuilder();
	
	static PrePayment.PrePaymentBuilder builder() {
		return new PrePayment.PrePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PrePayment> getType() {
		return PrePayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processor.processBasic(path.newSubPath("prePayment"), Boolean.class, getPrePayment(), this);
		processRosetta(path.newSubPath("prePaymentAmount"), processor, NonNegativeMoney.class, getPrePaymentAmount());
		processRosetta(path.newSubPath("prePaymentDate"), processor, AdjustableDate.class, getPrePaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrePaymentBuilder extends PrePayment, PaymentBase.PaymentBaseBuilder {
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
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrePaymentAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPrePaymentAmount();
		AdjustableDate.AdjustableDateBuilder getOrCreatePrePaymentDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getPrePaymentDate();
		@Override
		PrePayment.PrePaymentBuilder setId(String id);
		PrePayment.PrePaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		PrePayment.PrePaymentBuilder setPayerAccountReference(AccountReference payerAccountReference);
		PrePayment.PrePaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		PrePayment.PrePaymentBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		PrePayment.PrePaymentBuilder setPrePayment(Boolean prePayment);
		PrePayment.PrePaymentBuilder setPrePaymentAmount(NonNegativeMoney prePaymentAmount);
		PrePayment.PrePaymentBuilder setPrePaymentDate(AdjustableDate prePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processor.processBasic(path.newSubPath("prePayment"), Boolean.class, getPrePayment(), this);
			processRosetta(path.newSubPath("prePaymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPrePaymentAmount());
			processRosetta(path.newSubPath("prePaymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPrePaymentDate());
		}
		

		PrePayment.PrePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of PrePayment  ***********************/
	class PrePaymentImpl extends PaymentBase.PaymentBaseImpl implements PrePayment {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final Boolean prePayment;
		private final NonNegativeMoney prePaymentAmount;
		private final AdjustableDate prePaymentDate;
		
		protected PrePaymentImpl(PrePayment.PrePaymentBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.prePayment = builder.getPrePayment();
			this.prePaymentAmount = ofNullable(builder.getPrePaymentAmount()).map(f->f.build()).orElse(null);
			this.prePaymentDate = ofNullable(builder.getPrePaymentDate()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("prePayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePayment")
		public Boolean getPrePayment() {
			return prePayment;
		}
		
		@Override
		@RosettaAttribute("prePaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePaymentAmount")
		public NonNegativeMoney getPrePaymentAmount() {
			return prePaymentAmount;
		}
		
		@Override
		@RosettaAttribute("prePaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePaymentDate")
		public AdjustableDate getPrePaymentDate() {
			return prePaymentDate;
		}
		
		@Override
		public PrePayment build() {
			return this;
		}
		
		@Override
		public PrePayment.PrePaymentBuilder toBuilder() {
			PrePayment.PrePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrePayment.PrePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getPrePayment()).ifPresent(builder::setPrePayment);
			ofNullable(getPrePaymentAmount()).ifPresent(builder::setPrePaymentAmount);
			ofNullable(getPrePaymentDate()).ifPresent(builder::setPrePaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PrePayment _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(prePaymentAmount, _that.getPrePaymentAmount())) return false;
			if (!Objects.equals(prePaymentDate, _that.getPrePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (prePaymentAmount != null ? prePaymentAmount.hashCode() : 0);
			_result = 31 * _result + (prePaymentDate != null ? prePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrePayment {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"prePayment=" + this.prePayment + ", " +
				"prePaymentAmount=" + this.prePaymentAmount + ", " +
				"prePaymentDate=" + this.prePaymentDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PrePayment  ***********************/
	class PrePaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements PrePayment.PrePaymentBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected Boolean prePayment;
		protected NonNegativeMoney.NonNegativeMoneyBuilder prePaymentAmount;
		protected AdjustableDate.AdjustableDateBuilder prePaymentDate;
		
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
		@RosettaAttribute("prePayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePayment")
		public Boolean getPrePayment() {
			return prePayment;
		}
		
		@Override
		@RosettaAttribute("prePaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePaymentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPrePaymentAmount() {
			return prePaymentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrePaymentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (prePaymentAmount!=null) {
				result = prePaymentAmount;
			}
			else {
				result = prePaymentAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prePaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePaymentDate")
		public AdjustableDate.AdjustableDateBuilder getPrePaymentDate() {
			return prePaymentDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreatePrePaymentDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (prePaymentDate!=null) {
				result = prePaymentDate;
			}
			else {
				result = prePaymentDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PrePayment.PrePaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public PrePayment.PrePaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public PrePayment.PrePaymentBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public PrePayment.PrePaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public PrePayment.PrePaymentBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prePayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prePayment")
		@Override
		public PrePayment.PrePaymentBuilder setPrePayment(Boolean _prePayment) {
			this.prePayment = _prePayment == null ? null : _prePayment;
			return this;
		}
		
		@RosettaAttribute("prePaymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prePaymentAmount")
		@Override
		public PrePayment.PrePaymentBuilder setPrePaymentAmount(NonNegativeMoney _prePaymentAmount) {
			this.prePaymentAmount = _prePaymentAmount == null ? null : _prePaymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prePaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prePaymentDate")
		@Override
		public PrePayment.PrePaymentBuilder setPrePaymentDate(AdjustableDate _prePaymentDate) {
			this.prePaymentDate = _prePaymentDate == null ? null : _prePaymentDate.toBuilder();
			return this;
		}
		
		@Override
		public PrePayment build() {
			return new PrePayment.PrePaymentImpl(this);
		}
		
		@Override
		public PrePayment.PrePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrePayment.PrePaymentBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (prePaymentAmount!=null && !prePaymentAmount.prune().hasData()) prePaymentAmount = null;
			if (prePaymentDate!=null && !prePaymentDate.prune().hasData()) prePaymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getPrePayment()!=null) return true;
			if (getPrePaymentAmount()!=null && getPrePaymentAmount().hasData()) return true;
			if (getPrePaymentDate()!=null && getPrePaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrePayment.PrePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PrePayment.PrePaymentBuilder o = (PrePayment.PrePaymentBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getPrePaymentAmount(), o.getPrePaymentAmount(), this::setPrePaymentAmount);
			merger.mergeRosetta(getPrePaymentDate(), o.getPrePaymentDate(), this::setPrePaymentDate);
			
			merger.mergeBasic(getPrePayment(), o.getPrePayment(), this::setPrePayment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PrePayment _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(prePaymentAmount, _that.getPrePaymentAmount())) return false;
			if (!Objects.equals(prePaymentDate, _that.getPrePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (prePaymentAmount != null ? prePaymentAmount.hashCode() : 0);
			_result = 31 * _result + (prePaymentDate != null ? prePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrePaymentBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"prePayment=" + this.prePayment + ", " +
				"prePaymentAmount=" + this.prePaymentAmount + ", " +
				"prePaymentDate=" + this.prePaymentDate +
			'}' + " " + super.toString();
		}
	}
}
