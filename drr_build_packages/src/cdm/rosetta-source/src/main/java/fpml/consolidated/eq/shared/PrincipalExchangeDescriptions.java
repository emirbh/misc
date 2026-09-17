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
import fpml.consolidated.eq.shared.meta.PrincipalExchangeDescriptionsMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Specifies each of the characteristics of the principal exchange cashflows, in terms of paying/receiving counterparties, amounts and dates.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies each of the characteristics of the principal exchange cashflows, in terms of paying/receiving counterparties, amounts and dates.
 *
 */
@RosettaDataType(value="PrincipalExchangeDescriptions", builder=PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PrincipalExchangeDescriptions", model="fpml", builder=PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilderImpl.class, version="2.1.1")
public interface PrincipalExchangeDescriptions extends RosettaModelObject {

	PrincipalExchangeDescriptionsMeta metaData = new PrincipalExchangeDescriptionsMeta();

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
	 * Provision Specifies the principal echange amount, either by explicitly defining it, or by point to an amount defined somewhere else in the swap document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the principal echange amount, either by explicitly defining it, or by point to an amount defined somewhere else in the swap document.
	 *
	 */
	PrincipalExchangeAmount getPrincipalExchangeAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date on which each of the principal exchanges will take place. This date is either explictly stated, or is defined by reference to another date in the swap document. In this latter case, it will typically refer to one other date of the equity leg: either the effective date (initial exchange), or the last payment date (final exchange).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which each of the principal exchanges will take place. This date is either explictly stated, or is defined by reference to another date in the swap document. In this latter case, it will typically refer to one other date of the equity leg: either the effective date (initial exchange), or the last payment date (final exchange).
	 *
	 */
	AdjustableOrRelativeDate getPrincipalExchangeDate();

	/*********************** Build Methods  ***********************/
	PrincipalExchangeDescriptions build();
	
	PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder toBuilder();
	
	static PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder builder() {
		return new PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchangeDescriptions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PrincipalExchangeDescriptions> getType() {
		return PrincipalExchangeDescriptions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("principalExchangeAmount"), processor, PrincipalExchangeAmount.class, getPrincipalExchangeAmount());
		processRosetta(path.newSubPath("principalExchangeDate"), processor, AdjustableOrRelativeDate.class, getPrincipalExchangeDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangeDescriptionsBuilder extends PrincipalExchangeDescriptions, RosettaModelObjectBuilder {
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
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder getOrCreatePrincipalExchangeAmount();
		@Override
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder getPrincipalExchangeAmount();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePrincipalExchangeDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPrincipalExchangeDate();
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPayerPartyReference(PartyReference payerPartyReference);
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPayerAccountReference(AccountReference payerAccountReference);
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPrincipalExchangeAmount(PrincipalExchangeAmount principalExchangeAmount);
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPrincipalExchangeDate(AdjustableOrRelativeDate principalExchangeDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("principalExchangeAmount"), processor, PrincipalExchangeAmount.PrincipalExchangeAmountBuilder.class, getPrincipalExchangeAmount());
			processRosetta(path.newSubPath("principalExchangeDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPrincipalExchangeDate());
		}
		

		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchangeDescriptions  ***********************/
	class PrincipalExchangeDescriptionsImpl implements PrincipalExchangeDescriptions {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final PrincipalExchangeAmount principalExchangeAmount;
		private final AdjustableOrRelativeDate principalExchangeDate;
		
		protected PrincipalExchangeDescriptionsImpl(PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder builder) {
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.principalExchangeAmount = ofNullable(builder.getPrincipalExchangeAmount()).map(f->f.build()).orElse(null);
			this.principalExchangeDate = ofNullable(builder.getPrincipalExchangeDate()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("principalExchangeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchangeAmount")
		public PrincipalExchangeAmount getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		@RosettaAttribute("principalExchangeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchangeDate")
		public AdjustableOrRelativeDate getPrincipalExchangeDate() {
			return principalExchangeDate;
		}
		
		@Override
		public PrincipalExchangeDescriptions build() {
			return this;
		}
		
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder toBuilder() {
			PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder builder) {
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getPrincipalExchangeAmount()).ifPresent(builder::setPrincipalExchangeAmount);
			ofNullable(getPrincipalExchangeDate()).ifPresent(builder::setPrincipalExchangeDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeDescriptions _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(principalExchangeDate, _that.getPrincipalExchangeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchangeDate != null ? principalExchangeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeDescriptions {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"principalExchangeDate=" + this.principalExchangeDate +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchangeDescriptions  ***********************/
	class PrincipalExchangeDescriptionsBuilderImpl implements PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected PrincipalExchangeAmount.PrincipalExchangeAmountBuilder principalExchangeAmount;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder principalExchangeDate;
		
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
		@RosettaAttribute("principalExchangeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchangeAmount")
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder getOrCreatePrincipalExchangeAmount() {
			PrincipalExchangeAmount.PrincipalExchangeAmountBuilder result;
			if (principalExchangeAmount!=null) {
				result = principalExchangeAmount;
			}
			else {
				result = principalExchangeAmount = PrincipalExchangeAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalExchangeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchangeDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPrincipalExchangeDate() {
			return principalExchangeDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePrincipalExchangeDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (principalExchangeDate!=null) {
				result = principalExchangeDate;
			}
			else {
				result = principalExchangeDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("principalExchangeAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principalExchangeAmount")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPrincipalExchangeAmount(PrincipalExchangeAmount _principalExchangeAmount) {
			this.principalExchangeAmount = _principalExchangeAmount == null ? null : _principalExchangeAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("principalExchangeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principalExchangeDate")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPrincipalExchangeDate(AdjustableOrRelativeDate _principalExchangeDate) {
			this.principalExchangeDate = _principalExchangeDate == null ? null : _principalExchangeDate.toBuilder();
			return this;
		}
		
		@Override
		public PrincipalExchangeDescriptions build() {
			return new PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsImpl(this);
		}
		
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (principalExchangeAmount!=null && !principalExchangeAmount.prune().hasData()) principalExchangeAmount = null;
			if (principalExchangeDate!=null && !principalExchangeDate.prune().hasData()) principalExchangeDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getPrincipalExchangeAmount()!=null && getPrincipalExchangeAmount().hasData()) return true;
			if (getPrincipalExchangeDate()!=null && getPrincipalExchangeDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder o = (PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getPrincipalExchangeAmount(), o.getPrincipalExchangeAmount(), this::setPrincipalExchangeAmount);
			merger.mergeRosetta(getPrincipalExchangeDate(), o.getPrincipalExchangeDate(), this::setPrincipalExchangeDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeDescriptions _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(principalExchangeDate, _that.getPrincipalExchangeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchangeDate != null ? principalExchangeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeDescriptionsBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"principalExchangeDate=" + this.principalExchangeDate +
			'}';
		}
	}
}
