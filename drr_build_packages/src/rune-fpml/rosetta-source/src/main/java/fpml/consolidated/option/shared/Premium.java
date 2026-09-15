package fpml.consolidated.option.shared;

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
import fpml.consolidated.fpmlenum.PremiumTypeEnum;
import fpml.consolidated.option.shared.meta.PremiumMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SimplePayment;
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
 * Provision A type for defining a premium.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining a premium.
 *
 */
@RosettaDataType(value="Premium", builder=Premium.PremiumBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Premium", model="fpml", builder=Premium.PremiumBuilderImpl.class, version="2.1.1")
public interface Premium extends SimplePayment {

	PremiumMeta metaData = new PremiumMeta();

	/*********************** Getter Methods  ***********************/
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
	Money getPricePerOption();
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

	/*********************** Build Methods  ***********************/
	Premium build();
	
	Premium.PremiumBuilder toBuilder();
	
	static Premium.PremiumBuilder builder() {
		return new Premium.PremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Premium> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Premium> getType() {
		return Premium.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
		processRosetta(path.newSubPath("pricePerOption"), processor, Money.class, getPricePerOption());
		processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processRosetta(path.newSubPath("presentValueAmount"), processor, Money.class, getPresentValueAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PremiumBuilder extends Premium, SimplePayment.SimplePaymentBuilder {
		Money.MoneyBuilder getOrCreatePricePerOption();
		@Override
		Money.MoneyBuilder getPricePerOption();
		Money.MoneyBuilder getOrCreatePresentValueAmount();
		@Override
		Money.MoneyBuilder getPresentValueAmount();
		@Override
		Premium.PremiumBuilder setId(String id);
		@Override
		Premium.PremiumBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		Premium.PremiumBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		Premium.PremiumBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		Premium.PremiumBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		Premium.PremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		@Override
		Premium.PremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		Premium.PremiumBuilder setPremiumType(PremiumTypeEnum premiumType);
		Premium.PremiumBuilder setPricePerOption(Money pricePerOption);
		Premium.PremiumBuilder setPercentageOfNotional(BigDecimal percentageOfNotional);
		Premium.PremiumBuilder setDiscountFactor(BigDecimal discountFactor);
		Premium.PremiumBuilder setPresentValueAmount(Money presentValueAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
			processRosetta(path.newSubPath("pricePerOption"), processor, Money.MoneyBuilder.class, getPricePerOption());
			processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processRosetta(path.newSubPath("presentValueAmount"), processor, Money.MoneyBuilder.class, getPresentValueAmount());
		}
		

		Premium.PremiumBuilder prune();
	}

	/*********************** Immutable Implementation of Premium  ***********************/
	class PremiumImpl extends SimplePayment.SimplePaymentImpl implements Premium {
		private final PremiumTypeEnum premiumType;
		private final Money pricePerOption;
		private final BigDecimal percentageOfNotional;
		private final BigDecimal discountFactor;
		private final Money presentValueAmount;
		
		protected PremiumImpl(Premium.PremiumBuilder builder) {
			super(builder);
			this.premiumType = builder.getPremiumType();
			this.pricePerOption = ofNullable(builder.getPricePerOption()).map(f->f.build()).orElse(null);
			this.percentageOfNotional = builder.getPercentageOfNotional();
			this.discountFactor = builder.getDiscountFactor();
			this.presentValueAmount = ofNullable(builder.getPresentValueAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("premiumType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premiumType")
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
		}
		
		@Override
		@RosettaAttribute("pricePerOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricePerOption")
		public Money getPricePerOption() {
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
		public Premium build() {
			return this;
		}
		
		@Override
		public Premium.PremiumBuilder toBuilder() {
			Premium.PremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Premium.PremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPremiumType()).ifPresent(builder::setPremiumType);
			ofNullable(getPricePerOption()).ifPresent(builder::setPricePerOption);
			ofNullable(getPercentageOfNotional()).ifPresent(builder::setPercentageOfNotional);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getPresentValueAmount()).ifPresent(builder::setPresentValueAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Premium _that = getType().cast(o);
		
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Premium {" +
				"premiumType=" + this.premiumType + ", " +
				"pricePerOption=" + this.pricePerOption + ", " +
				"percentageOfNotional=" + this.percentageOfNotional + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValueAmount=" + this.presentValueAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Premium  ***********************/
	class PremiumBuilderImpl extends SimplePayment.SimplePaymentBuilderImpl implements Premium.PremiumBuilder {
	
		protected PremiumTypeEnum premiumType;
		protected Money.MoneyBuilder pricePerOption;
		protected BigDecimal percentageOfNotional;
		protected BigDecimal discountFactor;
		protected Money.MoneyBuilder presentValueAmount;
		
		@Override
		@RosettaAttribute("premiumType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premiumType")
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
		}
		
		@Override
		@RosettaAttribute("pricePerOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricePerOption")
		public Money.MoneyBuilder getPricePerOption() {
			return pricePerOption;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePricePerOption() {
			Money.MoneyBuilder result;
			if (pricePerOption!=null) {
				result = pricePerOption;
			}
			else {
				result = pricePerOption = Money.builder();
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Premium.PremiumBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public Premium.PremiumBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public Premium.PremiumBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public Premium.PremiumBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public Premium.PremiumBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentAmount")
		@Override
		public Premium.PremiumBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public Premium.PremiumBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premiumType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("premiumType")
		@Override
		public Premium.PremiumBuilder setPremiumType(PremiumTypeEnum _premiumType) {
			this.premiumType = _premiumType == null ? null : _premiumType;
			return this;
		}
		
		@RosettaAttribute("pricePerOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricePerOption")
		@Override
		public Premium.PremiumBuilder setPricePerOption(Money _pricePerOption) {
			this.pricePerOption = _pricePerOption == null ? null : _pricePerOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("percentageOfNotional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("percentageOfNotional")
		@Override
		public Premium.PremiumBuilder setPercentageOfNotional(BigDecimal _percentageOfNotional) {
			this.percentageOfNotional = _percentageOfNotional == null ? null : _percentageOfNotional;
			return this;
		}
		
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("discountFactor")
		@Override
		public Premium.PremiumBuilder setDiscountFactor(BigDecimal _discountFactor) {
			this.discountFactor = _discountFactor == null ? null : _discountFactor;
			return this;
		}
		
		@RosettaAttribute("presentValueAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("presentValueAmount")
		@Override
		public Premium.PremiumBuilder setPresentValueAmount(Money _presentValueAmount) {
			this.presentValueAmount = _presentValueAmount == null ? null : _presentValueAmount.toBuilder();
			return this;
		}
		
		@Override
		public Premium build() {
			return new Premium.PremiumImpl(this);
		}
		
		@Override
		public Premium.PremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Premium.PremiumBuilder prune() {
			super.prune();
			if (pricePerOption!=null && !pricePerOption.prune().hasData()) pricePerOption = null;
			if (presentValueAmount!=null && !presentValueAmount.prune().hasData()) presentValueAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPremiumType()!=null) return true;
			if (getPricePerOption()!=null && getPricePerOption().hasData()) return true;
			if (getPercentageOfNotional()!=null) return true;
			if (getDiscountFactor()!=null) return true;
			if (getPresentValueAmount()!=null && getPresentValueAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Premium.PremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Premium.PremiumBuilder o = (Premium.PremiumBuilder) other;
			
			merger.mergeRosetta(getPricePerOption(), o.getPricePerOption(), this::setPricePerOption);
			merger.mergeRosetta(getPresentValueAmount(), o.getPresentValueAmount(), this::setPresentValueAmount);
			
			merger.mergeBasic(getPremiumType(), o.getPremiumType(), this::setPremiumType);
			merger.mergeBasic(getPercentageOfNotional(), o.getPercentageOfNotional(), this::setPercentageOfNotional);
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Premium _that = getType().cast(o);
		
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PremiumBuilder {" +
				"premiumType=" + this.premiumType + ", " +
				"pricePerOption=" + this.pricePerOption + ", " +
				"percentageOfNotional=" + this.percentageOfNotional + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValueAmount=" + this.presentValueAmount +
			'}' + " " + super.toString();
		}
	}
}
