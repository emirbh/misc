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
import fpml.consolidated.eq.shared.meta.EquityPremiumMeta;
import fpml.consolidated.fpmlenum.PremiumTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PaymentBase;
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
 * Provision A type used to describe the amount paid for an equity option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type used to describe the amount paid for an equity option.
 *
 */
@RosettaDataType(value="EquityPremium", builder=EquityPremium.EquityPremiumBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityPremium", model="fpml", builder=EquityPremium.EquityPremiumBuilderImpl.class, version="2.1.1")
public interface EquityPremium extends PaymentBase {

	EquityPremiumMeta metaData = new EquityPremiumMeta();

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
	 * Provision Forward start Premium type
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Forward start Premium type
	 *
	 */
	PremiumTypeEnum getPremiumType();
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
	AdjustableDate getPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether or not the premium is to be paid in the style of payments under an interest rate swap contract.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether or not the premium is to be paid in the style of payments under an interest rate swap contract.
	 *
	 */
	Boolean getSwapPremium();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount of premium to be paid expressed as a function of the number of options.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of premium to be paid expressed as a function of the number of options.
	 *
	 */
	NonNegativeMoney getPricePerOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.
	 *
	 */
	BigDecimal getPercentageOfNotional();

	/*********************** Build Methods  ***********************/
	EquityPremium build();
	
	EquityPremium.EquityPremiumBuilder toBuilder();
	
	static EquityPremium.EquityPremiumBuilder builder() {
		return new EquityPremium.EquityPremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityPremium> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityPremium> getType() {
		return EquityPremium.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.class, getPaymentDate());
		processor.processBasic(path.newSubPath("swapPremium"), Boolean.class, getSwapPremium(), this);
		processRosetta(path.newSubPath("pricePerOption"), processor, NonNegativeMoney.class, getPricePerOption());
		processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityPremiumBuilder extends EquityPremium, PaymentBase.PaymentBaseBuilder {
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
		AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getPaymentDate();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePricePerOption();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPricePerOption();
		@Override
		EquityPremium.EquityPremiumBuilder setId(String id);
		EquityPremium.EquityPremiumBuilder setPayerPartyReference(PartyReference payerPartyReference);
		EquityPremium.EquityPremiumBuilder setPayerAccountReference(AccountReference payerAccountReference);
		EquityPremium.EquityPremiumBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		EquityPremium.EquityPremiumBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		EquityPremium.EquityPremiumBuilder setPremiumType(PremiumTypeEnum premiumType);
		EquityPremium.EquityPremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		EquityPremium.EquityPremiumBuilder setPaymentDate(AdjustableDate paymentDate);
		EquityPremium.EquityPremiumBuilder setSwapPremium(Boolean swapPremium);
		EquityPremium.EquityPremiumBuilder setPricePerOption(NonNegativeMoney pricePerOption);
		EquityPremium.EquityPremiumBuilder setPercentageOfNotional(BigDecimal percentageOfNotional);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPaymentDate());
			processor.processBasic(path.newSubPath("swapPremium"), Boolean.class, getSwapPremium(), this);
			processRosetta(path.newSubPath("pricePerOption"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPricePerOption());
			processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
		}
		

		EquityPremium.EquityPremiumBuilder prune();
	}

	/*********************** Immutable Implementation of EquityPremium  ***********************/
	class EquityPremiumImpl extends PaymentBase.PaymentBaseImpl implements EquityPremium {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final PremiumTypeEnum premiumType;
		private final NonNegativeMoney paymentAmount;
		private final AdjustableDate paymentDate;
		private final Boolean swapPremium;
		private final NonNegativeMoney pricePerOption;
		private final BigDecimal percentageOfNotional;
		
		protected EquityPremiumImpl(EquityPremium.EquityPremiumBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.premiumType = builder.getPremiumType();
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.swapPremium = builder.getSwapPremium();
			this.pricePerOption = ofNullable(builder.getPricePerOption()).map(f->f.build()).orElse(null);
			this.percentageOfNotional = builder.getPercentageOfNotional();
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
		@RosettaAttribute("premiumType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premiumType")
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentAmount")
		public NonNegativeMoney getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public AdjustableDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("swapPremium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("swapPremium")
		public Boolean getSwapPremium() {
			return swapPremium;
		}
		
		@Override
		@RosettaAttribute("pricePerOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricePerOption")
		public NonNegativeMoney getPricePerOption() {
			return pricePerOption;
		}
		
		@Override
		@RosettaAttribute("percentageOfNotional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("percentageOfNotional")
		public BigDecimal getPercentageOfNotional() {
			return percentageOfNotional;
		}
		
		@Override
		public EquityPremium build() {
			return this;
		}
		
		@Override
		public EquityPremium.EquityPremiumBuilder toBuilder() {
			EquityPremium.EquityPremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityPremium.EquityPremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getPremiumType()).ifPresent(builder::setPremiumType);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getSwapPremium()).ifPresent(builder::setSwapPremium);
			ofNullable(getPricePerOption()).ifPresent(builder::setPricePerOption);
			ofNullable(getPercentageOfNotional()).ifPresent(builder::setPercentageOfNotional);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityPremium _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(swapPremium, _that.getSwapPremium())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (swapPremium != null ? swapPremium.hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityPremium {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"premiumType=" + this.premiumType + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"swapPremium=" + this.swapPremium + ", " +
				"pricePerOption=" + this.pricePerOption + ", " +
				"percentageOfNotional=" + this.percentageOfNotional +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityPremium  ***********************/
	class EquityPremiumBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements EquityPremium.EquityPremiumBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected PremiumTypeEnum premiumType;
		protected NonNegativeMoney.NonNegativeMoneyBuilder paymentAmount;
		protected AdjustableDate.AdjustableDateBuilder paymentDate;
		protected Boolean swapPremium;
		protected NonNegativeMoney.NonNegativeMoneyBuilder pricePerOption;
		protected BigDecimal percentageOfNotional;
		
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
		@RosettaAttribute("premiumType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premiumType")
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
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
		
		@Override
		@RosettaAttribute("swapPremium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("swapPremium")
		public Boolean getSwapPremium() {
			return swapPremium;
		}
		
		@Override
		@RosettaAttribute("pricePerOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricePerOption")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPricePerOption() {
			return pricePerOption;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePricePerOption() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (pricePerOption!=null) {
				result = pricePerOption;
			}
			else {
				result = pricePerOption = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("percentageOfNotional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("percentageOfNotional")
		public BigDecimal getPercentageOfNotional() {
			return percentageOfNotional;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquityPremium.EquityPremiumBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public EquityPremium.EquityPremiumBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public EquityPremium.EquityPremiumBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public EquityPremium.EquityPremiumBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public EquityPremium.EquityPremiumBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premiumType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("premiumType")
		@Override
		public EquityPremium.EquityPremiumBuilder setPremiumType(PremiumTypeEnum _premiumType) {
			this.premiumType = _premiumType == null ? null : _premiumType;
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentAmount")
		@Override
		public EquityPremium.EquityPremiumBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public EquityPremium.EquityPremiumBuilder setPaymentDate(AdjustableDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("swapPremium")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swapPremium")
		@Override
		public EquityPremium.EquityPremiumBuilder setSwapPremium(Boolean _swapPremium) {
			this.swapPremium = _swapPremium == null ? null : _swapPremium;
			return this;
		}
		
		@RosettaAttribute("pricePerOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricePerOption")
		@Override
		public EquityPremium.EquityPremiumBuilder setPricePerOption(NonNegativeMoney _pricePerOption) {
			this.pricePerOption = _pricePerOption == null ? null : _pricePerOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("percentageOfNotional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("percentageOfNotional")
		@Override
		public EquityPremium.EquityPremiumBuilder setPercentageOfNotional(BigDecimal _percentageOfNotional) {
			this.percentageOfNotional = _percentageOfNotional == null ? null : _percentageOfNotional;
			return this;
		}
		
		@Override
		public EquityPremium build() {
			return new EquityPremium.EquityPremiumImpl(this);
		}
		
		@Override
		public EquityPremium.EquityPremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityPremium.EquityPremiumBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (pricePerOption!=null && !pricePerOption.prune().hasData()) pricePerOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getPremiumType()!=null) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getSwapPremium()!=null) return true;
			if (getPricePerOption()!=null && getPricePerOption().hasData()) return true;
			if (getPercentageOfNotional()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityPremium.EquityPremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityPremium.EquityPremiumBuilder o = (EquityPremium.EquityPremiumBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getPricePerOption(), o.getPricePerOption(), this::setPricePerOption);
			
			merger.mergeBasic(getPremiumType(), o.getPremiumType(), this::setPremiumType);
			merger.mergeBasic(getSwapPremium(), o.getSwapPremium(), this::setSwapPremium);
			merger.mergeBasic(getPercentageOfNotional(), o.getPercentageOfNotional(), this::setPercentageOfNotional);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityPremium _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(swapPremium, _that.getSwapPremium())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (swapPremium != null ? swapPremium.hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityPremiumBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"premiumType=" + this.premiumType + ", " +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"swapPremium=" + this.swapPremium + ", " +
				"pricePerOption=" + this.pricePerOption + ", " +
				"percentageOfNotional=" + this.percentageOfNotional +
			'}' + " " + super.toString();
		}
	}
}
