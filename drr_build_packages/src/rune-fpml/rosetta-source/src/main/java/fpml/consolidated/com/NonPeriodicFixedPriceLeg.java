package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.NonPeriodicFixedPriceLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.NonNegativeMoney;
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
 * Provision The details of a fixed payment. Can be used for a forward transaction or as the base for a more complex fixed leg component such as the fixed leg of a swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The details of a fixed payment. Can be used for a forward transaction or as the base for a more complex fixed leg component such as the fixed leg of a swap.
 *
 */
@RosettaDataType(value="NonPeriodicFixedPriceLeg", builder=NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonPeriodicFixedPriceLeg", model="fpml", builder=NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilderImpl.class, version="2.1.1")
public interface NonPeriodicFixedPriceLeg extends CommodityLeg {

	NonPeriodicFixedPriceLegMeta metaData = new NonPeriodicFixedPriceLegMeta();

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
	 * Provision Fixed price on which fixed payments are based.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fixed price on which fixed payments are based.
	 *
	 */
	CommodityFixedPrice getFixedPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The total amount of the fixed payment for all units of the underlying commodity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total amount of the fixed payment for all units of the underlying commodity.
	 *
	 */
	NonNegativeMoney getTotalPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a quantity defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a quantity defined on another leg.
	 *
	 */
	QuantityReference getQuantityReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 */
	CommodityRelativePaymentDates getRelativePaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 */
	AdjustableDatesOrRelativeDateOffset getPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 */
	Boolean getMasterAgreementPaymentDates();

	/*********************** Build Methods  ***********************/
	NonPeriodicFixedPriceLeg build();
	
	NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder toBuilder();
	
	static NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder builder() {
		return new NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonPeriodicFixedPriceLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonPeriodicFixedPriceLeg> getType() {
		return NonPeriodicFixedPriceLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("fixedPrice"), processor, CommodityFixedPrice.class, getFixedPrice());
		processRosetta(path.newSubPath("totalPrice"), processor, NonNegativeMoney.class, getTotalPrice());
		processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.class, getQuantityReference());
		processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.class, getRelativePaymentDates());
		processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.class, getPaymentDates());
		processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonPeriodicFixedPriceLegBuilder extends NonPeriodicFixedPriceLeg, CommodityLeg.CommodityLegBuilder {
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
		CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateFixedPrice();
		@Override
		CommodityFixedPrice.CommodityFixedPriceBuilder getFixedPrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalPrice();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getTotalPrice();
		QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference();
		@Override
		QuantityReference.QuantityReferenceBuilder getQuantityReference();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates();
		@Override
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates();
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates();
		@Override
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates();
		@Override
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setId(String id);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setFixedPrice(CommodityFixedPrice fixedPrice);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setTotalPrice(NonNegativeMoney totalPrice);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setQuantityReference(QuantityReference quantityReference);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates relativePaymentDates);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset paymentDates);
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setMasterAgreementPaymentDates(Boolean masterAgreementPaymentDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("fixedPrice"), processor, CommodityFixedPrice.CommodityFixedPriceBuilder.class, getFixedPrice());
			processRosetta(path.newSubPath("totalPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getTotalPrice());
			processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.QuantityReferenceBuilder.class, getQuantityReference());
			processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getRelativePaymentDates());
			processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder.class, getPaymentDates());
			processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
		}
		

		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder prune();
	}

	/*********************** Immutable Implementation of NonPeriodicFixedPriceLeg  ***********************/
	class NonPeriodicFixedPriceLegImpl extends CommodityLeg.CommodityLegImpl implements NonPeriodicFixedPriceLeg {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final CommodityFixedPrice fixedPrice;
		private final NonNegativeMoney totalPrice;
		private final QuantityReference quantityReference;
		private final CommodityRelativePaymentDates relativePaymentDates;
		private final AdjustableDatesOrRelativeDateOffset paymentDates;
		private final Boolean masterAgreementPaymentDates;
		
		protected NonPeriodicFixedPriceLegImpl(NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.fixedPrice = ofNullable(builder.getFixedPrice()).map(f->f.build()).orElse(null);
			this.totalPrice = ofNullable(builder.getTotalPrice()).map(f->f.build()).orElse(null);
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
			this.relativePaymentDates = ofNullable(builder.getRelativePaymentDates()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.masterAgreementPaymentDates = builder.getMasterAgreementPaymentDates();
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
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedPrice")
		public CommodityFixedPrice getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		@RosettaAttribute("totalPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalPrice")
		public NonNegativeMoney getTotalPrice() {
			return totalPrice;
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityReference")
		public QuantityReference getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@Override
		public NonPeriodicFixedPriceLeg build() {
			return this;
		}
		
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder toBuilder() {
			NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getFixedPrice()).ifPresent(builder::setFixedPrice);
			ofNullable(getTotalPrice()).ifPresent(builder::setTotalPrice);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
			ofNullable(getRelativePaymentDates()).ifPresent(builder::setRelativePaymentDates);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getMasterAgreementPaymentDates()).ifPresent(builder::setMasterAgreementPaymentDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonPeriodicFixedPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(totalPrice, _that.getTotalPrice())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (totalPrice != null ? totalPrice.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonPeriodicFixedPriceLeg {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"totalPrice=" + this.totalPrice + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonPeriodicFixedPriceLeg  ***********************/
	class NonPeriodicFixedPriceLegBuilderImpl extends CommodityLeg.CommodityLegBuilderImpl implements NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected CommodityFixedPrice.CommodityFixedPriceBuilder fixedPrice;
		protected NonNegativeMoney.NonNegativeMoneyBuilder totalPrice;
		protected QuantityReference.QuantityReferenceBuilder quantityReference;
		protected CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder relativePaymentDates;
		protected AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder paymentDates;
		protected Boolean masterAgreementPaymentDates;
		
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
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedPrice")
		public CommodityFixedPrice.CommodityFixedPriceBuilder getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateFixedPrice() {
			CommodityFixedPrice.CommodityFixedPriceBuilder result;
			if (fixedPrice!=null) {
				result = fixedPrice;
			}
			else {
				result = fixedPrice = CommodityFixedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalPrice")
		public NonNegativeMoney.NonNegativeMoneyBuilder getTotalPrice() {
			return totalPrice;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalPrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (totalPrice!=null) {
				result = totalPrice;
			}
			else {
				result = totalPrice = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityReference")
		public QuantityReference.QuantityReferenceBuilder getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference() {
			QuantityReference.QuantityReferenceBuilder result;
			if (quantityReference!=null) {
				result = quantityReference;
			}
			else {
				result = quantityReference = QuantityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder result;
			if (relativePaymentDates!=null) {
				result = relativePaymentDates;
			}
			else {
				result = relativePaymentDates = CommodityRelativePaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates() {
			AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = AdjustableDatesOrRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixedPrice")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setFixedPrice(CommodityFixedPrice _fixedPrice) {
			this.fixedPrice = _fixedPrice == null ? null : _fixedPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("totalPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalPrice")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setTotalPrice(NonNegativeMoney _totalPrice) {
			this.totalPrice = _totalPrice == null ? null : _totalPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityReference")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setQuantityReference(QuantityReference _quantityReference) {
			this.quantityReference = _quantityReference == null ? null : _quantityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePaymentDates")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates _relativePaymentDates) {
			this.relativePaymentDates = _relativePaymentDates == null ? null : _relativePaymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDates")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder setMasterAgreementPaymentDates(Boolean _masterAgreementPaymentDates) {
			this.masterAgreementPaymentDates = _masterAgreementPaymentDates == null ? null : _masterAgreementPaymentDates;
			return this;
		}
		
		@Override
		public NonPeriodicFixedPriceLeg build() {
			return new NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegImpl(this);
		}
		
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (fixedPrice!=null && !fixedPrice.prune().hasData()) fixedPrice = null;
			if (totalPrice!=null && !totalPrice.prune().hasData()) totalPrice = null;
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			if (relativePaymentDates!=null && !relativePaymentDates.prune().hasData()) relativePaymentDates = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getFixedPrice()!=null && getFixedPrice().hasData()) return true;
			if (getTotalPrice()!=null && getTotalPrice().hasData()) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			if (getRelativePaymentDates()!=null && getRelativePaymentDates().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getMasterAgreementPaymentDates()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder o = (NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getFixedPrice(), o.getFixedPrice(), this::setFixedPrice);
			merger.mergeRosetta(getTotalPrice(), o.getTotalPrice(), this::setTotalPrice);
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			merger.mergeRosetta(getRelativePaymentDates(), o.getRelativePaymentDates(), this::setRelativePaymentDates);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			
			merger.mergeBasic(getMasterAgreementPaymentDates(), o.getMasterAgreementPaymentDates(), this::setMasterAgreementPaymentDates);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonPeriodicFixedPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(totalPrice, _that.getTotalPrice())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (totalPrice != null ? totalPrice.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonPeriodicFixedPriceLegBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"totalPrice=" + this.totalPrice + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates +
			'}' + " " + super.toString();
		}
	}
}
