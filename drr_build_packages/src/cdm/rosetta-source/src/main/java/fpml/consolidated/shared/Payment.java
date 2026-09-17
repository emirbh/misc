package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.PaymentMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining payments. Developers of FpML models are encouraged to make use of the SimplePayment type instead of this Payment type. In Transparency view, normally the payer and receiver party references are not used; however they may be provided if necessary for administrative activities such as Reporting Party Determination in FX.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining payments. Developers of FpML models are encouraged to make use of the SimplePayment type instead of this Payment type. In Transparency view, normally the payer and receiver party references are not used; however they may be provided if necessary for administrative activities such as Reporting Party Determination in FX.
 *
 */
@RosettaDataType(value="Payment", builder=Payment.PaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Payment", model="fpml", builder=Payment.PaymentBuilderImpl.class, version="2.1.1")
public interface Payment extends PaymentBase {

	PaymentMeta metaData = new PaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Can be used to reference the yield curve used to estimate the discount factor.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Can be used to reference the yield curve used to estimate the discount factor.
	 *
	 */
	String getHref();
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
	 * Provision The currency amount of the payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency amount of the payment.
	 *
	 */
	NonNegativeMoney getPaymentAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The payment date. This date is subject to adjustment in accordance with any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The payment date. This date is subject to adjustment in accordance with any applicable business day convention.
	 *
	 */
	AdjustableOrAdjustedDate getPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A classification of the type of fee or additional payment, e.g. brokerage, upfront fee etc. FpML does not define domain values for this element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A classification of the type of fee or additional payment, e.g. brokerage, upfront fee etc. FpML does not define domain values for this element.
	 *
	 */
	PaymentType getPaymentType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The information required to settle a currency payment that results from a trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The information required to settle a currency payment that results from a trade.
	 *
	 */
	SettlementInformation getSettlementInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The value representing the discount factor used to calculate the present value of the cash flow.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value representing the discount factor used to calculate the present value of the cash flow.
	 *
	 */
	BigDecimal getDiscountFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount representing the present value of the forecast payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount representing the present value of the forecast payment.
	 *
	 */
	Money getPresentValueAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Can be used to reference the yield curve used to estimate the discount factor.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Can be used to reference the yield curve used to estimate the discount factor.
	 *
	 */
	PricingStructureReference getPricingStructureReference();

	/*********************** Build Methods  ***********************/
	Payment build();
	
	Payment.PaymentBuilder toBuilder();
	
	static Payment.PaymentBuilder builder() {
		return new Payment.PaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Payment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Payment> getType() {
		return Payment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrAdjustedDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentType"), processor, PaymentType.class, getPaymentType());
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processRosetta(path.newSubPath("presentValueAmount"), processor, Money.class, getPresentValueAmount());
		processRosetta(path.newSubPath("pricingStructureReference"), processor, PricingStructureReference.class, getPricingStructureReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentBuilder extends Payment, PaymentBase.PaymentBaseBuilder {
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
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreatePaymentDate();
		@Override
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getPaymentDate();
		PaymentType.PaymentTypeBuilder getOrCreatePaymentType();
		@Override
		PaymentType.PaymentTypeBuilder getPaymentType();
		SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation();
		@Override
		SettlementInformation.SettlementInformationBuilder getSettlementInformation();
		Money.MoneyBuilder getOrCreatePresentValueAmount();
		@Override
		Money.MoneyBuilder getPresentValueAmount();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingStructureReference();
		@Override
		PricingStructureReference.PricingStructureReferenceBuilder getPricingStructureReference();
		@Override
		Payment.PaymentBuilder setId(String id);
		Payment.PaymentBuilder setHref(String href);
		Payment.PaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		Payment.PaymentBuilder setPayerAccountReference(AccountReference payerAccountReference);
		Payment.PaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		Payment.PaymentBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		Payment.PaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		Payment.PaymentBuilder setPaymentDate(AdjustableOrAdjustedDate paymentDate);
		Payment.PaymentBuilder setPaymentType(PaymentType paymentType);
		Payment.PaymentBuilder setSettlementInformation(SettlementInformation settlementInformation);
		Payment.PaymentBuilder setDiscountFactor(BigDecimal discountFactor);
		Payment.PaymentBuilder setPresentValueAmount(Money presentValueAmount);
		Payment.PaymentBuilder setPricingStructureReference(PricingStructureReference pricingStructureReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentType"), processor, PaymentType.PaymentTypeBuilder.class, getPaymentType());
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processRosetta(path.newSubPath("presentValueAmount"), processor, Money.MoneyBuilder.class, getPresentValueAmount());
			processRosetta(path.newSubPath("pricingStructureReference"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getPricingStructureReference());
		}
		

		Payment.PaymentBuilder prune();
	}

	/*********************** Immutable Implementation of Payment  ***********************/
	class PaymentImpl extends PaymentBase.PaymentBaseImpl implements Payment {
		private final String href;
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final NonNegativeMoney paymentAmount;
		private final AdjustableOrAdjustedDate paymentDate;
		private final PaymentType paymentType;
		private final SettlementInformation settlementInformation;
		private final BigDecimal discountFactor;
		private final Money presentValueAmount;
		private final PricingStructureReference pricingStructureReference;
		
		protected PaymentImpl(Payment.PaymentBuilder builder) {
			super(builder);
			this.href = builder.getHref();
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.paymentType = ofNullable(builder.getPaymentType()).map(f->f.build()).orElse(null);
			this.settlementInformation = ofNullable(builder.getSettlementInformation()).map(f->f.build()).orElse(null);
			this.discountFactor = builder.getDiscountFactor();
			this.presentValueAmount = ofNullable(builder.getPresentValueAmount()).map(f->f.build()).orElse(null);
			this.pricingStructureReference = ofNullable(builder.getPricingStructureReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("href")
		public String getHref() {
			return href;
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
		@RuneAttribute("paymentDate")
		public AdjustableOrAdjustedDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentType")
		public PaymentType getPaymentType() {
			return paymentType;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInformation")
		public SettlementInformation getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("presentValueAmount")
		public Money getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		@RosettaAttribute("pricingStructureReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingStructureReference")
		public PricingStructureReference getPricingStructureReference() {
			return pricingStructureReference;
		}
		
		@Override
		public Payment build() {
			return this;
		}
		
		@Override
		public Payment.PaymentBuilder toBuilder() {
			Payment.PaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Payment.PaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getPaymentType()).ifPresent(builder::setPaymentType);
			ofNullable(getSettlementInformation()).ifPresent(builder::setSettlementInformation);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getPresentValueAmount()).ifPresent(builder::setPresentValueAmount);
			ofNullable(getPricingStructureReference()).ifPresent(builder::setPricingStructureReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Payment _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			if (!Objects.equals(pricingStructureReference, _that.getPricingStructureReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			_result = 31 * _result + (pricingStructureReference != null ? pricingStructureReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Payment {" +
				"href=" + this.href + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentType=" + this.paymentType + ", " +
				"settlementInformation=" + this.settlementInformation + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValueAmount=" + this.presentValueAmount + ", " +
				"pricingStructureReference=" + this.pricingStructureReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Payment  ***********************/
	class PaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements Payment.PaymentBuilder {
	
		protected String href;
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder paymentAmount;
		protected AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder paymentDate;
		protected PaymentType.PaymentTypeBuilder paymentType;
		protected SettlementInformation.SettlementInformationBuilder settlementInformation;
		protected BigDecimal discountFactor;
		protected Money.MoneyBuilder presentValueAmount;
		protected PricingStructureReference.PricingStructureReferenceBuilder pricingStructureReference;
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
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
		@RuneAttribute("paymentDate")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreatePaymentDate() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableOrAdjustedDate.builder();
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
		
		@Override
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInformation")
		public SettlementInformation.SettlementInformationBuilder getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation() {
			SettlementInformation.SettlementInformationBuilder result;
			if (settlementInformation!=null) {
				result = settlementInformation;
			}
			else {
				result = settlementInformation = SettlementInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("presentValueAmount")
		public Money.MoneyBuilder getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValueAmount() {
			Money.MoneyBuilder result;
			if (presentValueAmount!=null) {
				result = presentValueAmount;
			}
			else {
				result = presentValueAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingStructureReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingStructureReference")
		public PricingStructureReference.PricingStructureReferenceBuilder getPricingStructureReference() {
			return pricingStructureReference;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingStructureReference() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (pricingStructureReference!=null) {
				result = pricingStructureReference;
			}
			else {
				result = pricingStructureReference = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Payment.PaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("href")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("href")
		@Override
		public Payment.PaymentBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public Payment.PaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public Payment.PaymentBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public Payment.PaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public Payment.PaymentBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public Payment.PaymentBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public Payment.PaymentBuilder setPaymentDate(AdjustableOrAdjustedDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentType")
		@Override
		public Payment.PaymentBuilder setPaymentType(PaymentType _paymentType) {
			this.paymentType = _paymentType == null ? null : _paymentType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementInformation")
		@Override
		public Payment.PaymentBuilder setSettlementInformation(SettlementInformation _settlementInformation) {
			this.settlementInformation = _settlementInformation == null ? null : _settlementInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("discountFactor")
		@Override
		public Payment.PaymentBuilder setDiscountFactor(BigDecimal _discountFactor) {
			this.discountFactor = _discountFactor == null ? null : _discountFactor;
			return this;
		}
		
		@RosettaAttribute("presentValueAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("presentValueAmount")
		@Override
		public Payment.PaymentBuilder setPresentValueAmount(Money _presentValueAmount) {
			this.presentValueAmount = _presentValueAmount == null ? null : _presentValueAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingStructureReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingStructureReference")
		@Override
		public Payment.PaymentBuilder setPricingStructureReference(PricingStructureReference _pricingStructureReference) {
			this.pricingStructureReference = _pricingStructureReference == null ? null : _pricingStructureReference.toBuilder();
			return this;
		}
		
		@Override
		public Payment build() {
			return new Payment.PaymentImpl(this);
		}
		
		@Override
		public Payment.PaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payment.PaymentBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (paymentType!=null && !paymentType.prune().hasData()) paymentType = null;
			if (settlementInformation!=null && !settlementInformation.prune().hasData()) settlementInformation = null;
			if (presentValueAmount!=null && !presentValueAmount.prune().hasData()) presentValueAmount = null;
			if (pricingStructureReference!=null && !pricingStructureReference.prune().hasData()) pricingStructureReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getPaymentType()!=null && getPaymentType().hasData()) return true;
			if (getSettlementInformation()!=null && getSettlementInformation().hasData()) return true;
			if (getDiscountFactor()!=null) return true;
			if (getPresentValueAmount()!=null && getPresentValueAmount().hasData()) return true;
			if (getPricingStructureReference()!=null && getPricingStructureReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payment.PaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Payment.PaymentBuilder o = (Payment.PaymentBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getPaymentType(), o.getPaymentType(), this::setPaymentType);
			merger.mergeRosetta(getSettlementInformation(), o.getSettlementInformation(), this::setSettlementInformation);
			merger.mergeRosetta(getPresentValueAmount(), o.getPresentValueAmount(), this::setPresentValueAmount);
			merger.mergeRosetta(getPricingStructureReference(), o.getPricingStructureReference(), this::setPricingStructureReference);
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Payment _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			if (!Objects.equals(pricingStructureReference, _that.getPricingStructureReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			_result = 31 * _result + (pricingStructureReference != null ? pricingStructureReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentBuilder {" +
				"href=" + this.href + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentType=" + this.paymentType + ", " +
				"settlementInformation=" + this.settlementInformation + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValueAmount=" + this.presentValueAmount + ", " +
				"pricingStructureReference=" + this.pricingStructureReference +
			'}' + " " + super.toString();
		}
	}
}
