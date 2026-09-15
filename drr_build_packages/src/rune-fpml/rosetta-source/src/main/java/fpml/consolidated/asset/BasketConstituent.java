package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.BasketConstituentMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SpreadScheduleReference;
import fpml.consolidated.shared.UnderlyerInterestLeg;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing each of the constituents of a basket.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing each of the constituents of a basket.
 *
 */
@RosettaDataType(value="BasketConstituent", builder=BasketConstituent.BasketConstituentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BasketConstituent", model="fpml", builder=BasketConstituent.BasketConstituentBuilderImpl.class, version="2.1.1")
public interface BasketConstituent extends RosettaModelObject {

	BasketConstituentMeta metaData = new BasketConstituentMeta();

	/*********************** Getter Methods  ***********************/
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
	String getId();
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
	Asset getUnderlyingAsset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the weight of each of the underlyer constituent within the basket, either in absolute or relative terms. This is an optional component, as certain swaps do not specify a specific weight for each of their basket constituents.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the weight of each of the underlyer constituent within the basket, either in absolute or relative terms. This is an optional component, as certain swaps do not specify a specific weight for each of their basket constituents.
	 *
	 */
	ConstituentWeight getConstituentWeight();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the price that is associated with each of the basket constituents. This component is optional, as it is not absolutely required to accurately describe the economics of the trade, considering the price that characterizes the equity swap is associated to the leg of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the price that is associated with each of the basket constituents. This component is optional, as it is not absolutely required to accurately describe the economics of the trade, considering the price that characterizes the equity swap is associated to the leg of the trade.
	 *
	 */
	Price getUnderlyerPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the notional (i.e. price * quantity) that is associated with each of the basket constituents. This component is optional, as it is not absolutely required to accurately describe the economics of the trade, considering the notional that characterizes the equity swap is associated to the leg of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the notional (i.e. price * quantity) that is associated with each of the basket constituents. This component is optional, as it is not absolutely required to accurately describe the economics of the trade, considering the notional that characterizes the equity swap is associated to the leg of the trade.
	 *
	 */
	Money getUnderlyerNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides a link to the spread schedule used for this underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides a link to the spread schedule used for this underlyer.
	 *
	 */
	SpreadScheduleReference getUnderlyerSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Financing terms associated with this underlyer
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Financing terms associated with this underlyer
	 *
	 */
	UnderlyerInterestLeg getUnderlyerFinancing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Loan rate terms associated with this underlyer. Commonly used for stock loan. You must not duplicate data elements already contained within dividend conditions at transaction level
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Loan rate terms associated with this underlyer. Commonly used for stock loan. You must not duplicate data elements already contained within dividend conditions at transaction level
	 *
	 */
	UnderlyerLoanRate getUnderlyerLoanRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Collateral associated with this underlyer. Note that this is not typical usage, collateral is more often at transaction level
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Collateral associated with this underlyer. Note that this is not typical usage, collateral is more often at transaction level
	 *
	 */
	Collateral getUnderlyerCollateral();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the dividend payout ratio associated with an equity underlyer. A basket swap can have different payout ratios across the various underlying constituents. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified. Users should note that FpML makes a distinction between the derivative contract and the underlyer of the contract. It would be better if the agreed dividend payout on a derivative contract was modelled at the level of the derivative contract, an approach which may be adopted in the next major version of FpML.
	 *
	 */
	DividendPayout getDividendPayout();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The next upcoming coupon payment.
	 *
	 */
	PendingPayment getCouponPayment();

	/*********************** Build Methods  ***********************/
	BasketConstituent build();
	
	BasketConstituent.BasketConstituentBuilder toBuilder();
	
	static BasketConstituent.BasketConstituentBuilder builder() {
		return new BasketConstituent.BasketConstituentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketConstituent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketConstituent> getType() {
		return BasketConstituent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processRosetta(path.newSubPath("constituentWeight"), processor, ConstituentWeight.class, getConstituentWeight());
		processRosetta(path.newSubPath("underlyerPrice"), processor, Price.class, getUnderlyerPrice());
		processRosetta(path.newSubPath("underlyerNotional"), processor, Money.class, getUnderlyerNotional());
		processRosetta(path.newSubPath("underlyerSpread"), processor, SpreadScheduleReference.class, getUnderlyerSpread());
		processRosetta(path.newSubPath("underlyerFinancing"), processor, UnderlyerInterestLeg.class, getUnderlyerFinancing());
		processRosetta(path.newSubPath("underlyerLoanRate"), processor, UnderlyerLoanRate.class, getUnderlyerLoanRate());
		processRosetta(path.newSubPath("underlyerCollateral"), processor, Collateral.class, getUnderlyerCollateral());
		processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.class, getDividendPayout());
		processRosetta(path.newSubPath("couponPayment"), processor, PendingPayment.class, getCouponPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketConstituentBuilder extends BasketConstituent, RosettaModelObjectBuilder {
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
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		@Override
		Asset.AssetBuilder getUnderlyingAsset();
		ConstituentWeight.ConstituentWeightBuilder getOrCreateConstituentWeight();
		@Override
		ConstituentWeight.ConstituentWeightBuilder getConstituentWeight();
		Price.PriceBuilder getOrCreateUnderlyerPrice();
		@Override
		Price.PriceBuilder getUnderlyerPrice();
		Money.MoneyBuilder getOrCreateUnderlyerNotional();
		@Override
		Money.MoneyBuilder getUnderlyerNotional();
		SpreadScheduleReference.SpreadScheduleReferenceBuilder getOrCreateUnderlyerSpread();
		@Override
		SpreadScheduleReference.SpreadScheduleReferenceBuilder getUnderlyerSpread();
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder getOrCreateUnderlyerFinancing();
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder getUnderlyerFinancing();
		UnderlyerLoanRate.UnderlyerLoanRateBuilder getOrCreateUnderlyerLoanRate();
		@Override
		UnderlyerLoanRate.UnderlyerLoanRateBuilder getUnderlyerLoanRate();
		Collateral.CollateralBuilder getOrCreateUnderlyerCollateral();
		@Override
		Collateral.CollateralBuilder getUnderlyerCollateral();
		DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout();
		@Override
		DividendPayout.DividendPayoutBuilder getDividendPayout();
		PendingPayment.PendingPaymentBuilder getOrCreateCouponPayment();
		@Override
		PendingPayment.PendingPaymentBuilder getCouponPayment();
		BasketConstituent.BasketConstituentBuilder setId(String id);
		BasketConstituent.BasketConstituentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		BasketConstituent.BasketConstituentBuilder setPayerAccountReference(AccountReference payerAccountReference);
		BasketConstituent.BasketConstituentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		BasketConstituent.BasketConstituentBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		BasketConstituent.BasketConstituentBuilder setUnderlyingAsset(Asset underlyingAsset);
		BasketConstituent.BasketConstituentBuilder setConstituentWeight(ConstituentWeight constituentWeight);
		BasketConstituent.BasketConstituentBuilder setUnderlyerPrice(Price underlyerPrice);
		BasketConstituent.BasketConstituentBuilder setUnderlyerNotional(Money underlyerNotional);
		BasketConstituent.BasketConstituentBuilder setUnderlyerSpread(SpreadScheduleReference underlyerSpread);
		BasketConstituent.BasketConstituentBuilder setUnderlyerFinancing(UnderlyerInterestLeg underlyerFinancing);
		BasketConstituent.BasketConstituentBuilder setUnderlyerLoanRate(UnderlyerLoanRate underlyerLoanRate);
		BasketConstituent.BasketConstituentBuilder setUnderlyerCollateral(Collateral underlyerCollateral);
		BasketConstituent.BasketConstituentBuilder setDividendPayout(DividendPayout dividendPayout);
		BasketConstituent.BasketConstituentBuilder setCouponPayment(PendingPayment couponPayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processRosetta(path.newSubPath("constituentWeight"), processor, ConstituentWeight.ConstituentWeightBuilder.class, getConstituentWeight());
			processRosetta(path.newSubPath("underlyerPrice"), processor, Price.PriceBuilder.class, getUnderlyerPrice());
			processRosetta(path.newSubPath("underlyerNotional"), processor, Money.MoneyBuilder.class, getUnderlyerNotional());
			processRosetta(path.newSubPath("underlyerSpread"), processor, SpreadScheduleReference.SpreadScheduleReferenceBuilder.class, getUnderlyerSpread());
			processRosetta(path.newSubPath("underlyerFinancing"), processor, UnderlyerInterestLeg.UnderlyerInterestLegBuilder.class, getUnderlyerFinancing());
			processRosetta(path.newSubPath("underlyerLoanRate"), processor, UnderlyerLoanRate.UnderlyerLoanRateBuilder.class, getUnderlyerLoanRate());
			processRosetta(path.newSubPath("underlyerCollateral"), processor, Collateral.CollateralBuilder.class, getUnderlyerCollateral());
			processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.DividendPayoutBuilder.class, getDividendPayout());
			processRosetta(path.newSubPath("couponPayment"), processor, PendingPayment.PendingPaymentBuilder.class, getCouponPayment());
		}
		

		BasketConstituent.BasketConstituentBuilder prune();
	}

	/*********************** Immutable Implementation of BasketConstituent  ***********************/
	class BasketConstituentImpl implements BasketConstituent {
		private final String id;
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final Asset underlyingAsset;
		private final ConstituentWeight constituentWeight;
		private final Price underlyerPrice;
		private final Money underlyerNotional;
		private final SpreadScheduleReference underlyerSpread;
		private final UnderlyerInterestLeg underlyerFinancing;
		private final UnderlyerLoanRate underlyerLoanRate;
		private final Collateral underlyerCollateral;
		private final DividendPayout dividendPayout;
		private final PendingPayment couponPayment;
		
		protected BasketConstituentImpl(BasketConstituent.BasketConstituentBuilder builder) {
			this.id = builder.getId();
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.constituentWeight = ofNullable(builder.getConstituentWeight()).map(f->f.build()).orElse(null);
			this.underlyerPrice = ofNullable(builder.getUnderlyerPrice()).map(f->f.build()).orElse(null);
			this.underlyerNotional = ofNullable(builder.getUnderlyerNotional()).map(f->f.build()).orElse(null);
			this.underlyerSpread = ofNullable(builder.getUnderlyerSpread()).map(f->f.build()).orElse(null);
			this.underlyerFinancing = ofNullable(builder.getUnderlyerFinancing()).map(f->f.build()).orElse(null);
			this.underlyerLoanRate = ofNullable(builder.getUnderlyerLoanRate()).map(f->f.build()).orElse(null);
			this.underlyerCollateral = ofNullable(builder.getUnderlyerCollateral()).map(f->f.build()).orElse(null);
			this.dividendPayout = ofNullable(builder.getDividendPayout()).map(f->f.build()).orElse(null);
			this.couponPayment = ofNullable(builder.getCouponPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("constituentWeight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("constituentWeight")
		public ConstituentWeight getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		@RosettaAttribute("underlyerPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerPrice")
		public Price getUnderlyerPrice() {
			return underlyerPrice;
		}
		
		@Override
		@RosettaAttribute("underlyerNotional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerNotional")
		public Money getUnderlyerNotional() {
			return underlyerNotional;
		}
		
		@Override
		@RosettaAttribute("underlyerSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerSpread")
		public SpreadScheduleReference getUnderlyerSpread() {
			return underlyerSpread;
		}
		
		@Override
		@RosettaAttribute("underlyerFinancing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerFinancing")
		public UnderlyerInterestLeg getUnderlyerFinancing() {
			return underlyerFinancing;
		}
		
		@Override
		@RosettaAttribute("underlyerLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerLoanRate")
		public UnderlyerLoanRate getUnderlyerLoanRate() {
			return underlyerLoanRate;
		}
		
		@Override
		@RosettaAttribute("underlyerCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerCollateral")
		public Collateral getUnderlyerCollateral() {
			return underlyerCollateral;
		}
		
		@Override
		@RosettaAttribute("dividendPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayout")
		public DividendPayout getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		@RosettaAttribute("couponPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponPayment")
		public PendingPayment getCouponPayment() {
			return couponPayment;
		}
		
		@Override
		public BasketConstituent build() {
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder toBuilder() {
			BasketConstituent.BasketConstituentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketConstituent.BasketConstituentBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getConstituentWeight()).ifPresent(builder::setConstituentWeight);
			ofNullable(getUnderlyerPrice()).ifPresent(builder::setUnderlyerPrice);
			ofNullable(getUnderlyerNotional()).ifPresent(builder::setUnderlyerNotional);
			ofNullable(getUnderlyerSpread()).ifPresent(builder::setUnderlyerSpread);
			ofNullable(getUnderlyerFinancing()).ifPresent(builder::setUnderlyerFinancing);
			ofNullable(getUnderlyerLoanRate()).ifPresent(builder::setUnderlyerLoanRate);
			ofNullable(getUnderlyerCollateral()).ifPresent(builder::setUnderlyerCollateral);
			ofNullable(getDividendPayout()).ifPresent(builder::setDividendPayout);
			ofNullable(getCouponPayment()).ifPresent(builder::setCouponPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			if (!Objects.equals(underlyerPrice, _that.getUnderlyerPrice())) return false;
			if (!Objects.equals(underlyerNotional, _that.getUnderlyerNotional())) return false;
			if (!Objects.equals(underlyerSpread, _that.getUnderlyerSpread())) return false;
			if (!Objects.equals(underlyerFinancing, _that.getUnderlyerFinancing())) return false;
			if (!Objects.equals(underlyerLoanRate, _that.getUnderlyerLoanRate())) return false;
			if (!Objects.equals(underlyerCollateral, _that.getUnderlyerCollateral())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(couponPayment, _that.getCouponPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			_result = 31 * _result + (underlyerPrice != null ? underlyerPrice.hashCode() : 0);
			_result = 31 * _result + (underlyerNotional != null ? underlyerNotional.hashCode() : 0);
			_result = 31 * _result + (underlyerSpread != null ? underlyerSpread.hashCode() : 0);
			_result = 31 * _result + (underlyerFinancing != null ? underlyerFinancing.hashCode() : 0);
			_result = 31 * _result + (underlyerLoanRate != null ? underlyerLoanRate.hashCode() : 0);
			_result = 31 * _result + (underlyerCollateral != null ? underlyerCollateral.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (couponPayment != null ? couponPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituent {" +
				"id=" + this.id + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"constituentWeight=" + this.constituentWeight + ", " +
				"underlyerPrice=" + this.underlyerPrice + ", " +
				"underlyerNotional=" + this.underlyerNotional + ", " +
				"underlyerSpread=" + this.underlyerSpread + ", " +
				"underlyerFinancing=" + this.underlyerFinancing + ", " +
				"underlyerLoanRate=" + this.underlyerLoanRate + ", " +
				"underlyerCollateral=" + this.underlyerCollateral + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"couponPayment=" + this.couponPayment +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketConstituent  ***********************/
	class BasketConstituentBuilderImpl implements BasketConstituent.BasketConstituentBuilder {
	
		protected String id;
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected Asset.AssetBuilder underlyingAsset;
		protected ConstituentWeight.ConstituentWeightBuilder constituentWeight;
		protected Price.PriceBuilder underlyerPrice;
		protected Money.MoneyBuilder underlyerNotional;
		protected SpreadScheduleReference.SpreadScheduleReferenceBuilder underlyerSpread;
		protected UnderlyerInterestLeg.UnderlyerInterestLegBuilder underlyerFinancing;
		protected UnderlyerLoanRate.UnderlyerLoanRateBuilder underlyerLoanRate;
		protected Collateral.CollateralBuilder underlyerCollateral;
		protected DividendPayout.DividendPayoutBuilder dividendPayout;
		protected PendingPayment.PendingPaymentBuilder couponPayment;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("constituentWeight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("constituentWeight")
		public ConstituentWeight.ConstituentWeightBuilder getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		public ConstituentWeight.ConstituentWeightBuilder getOrCreateConstituentWeight() {
			ConstituentWeight.ConstituentWeightBuilder result;
			if (constituentWeight!=null) {
				result = constituentWeight;
			}
			else {
				result = constituentWeight = ConstituentWeight.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerPrice")
		public Price.PriceBuilder getUnderlyerPrice() {
			return underlyerPrice;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateUnderlyerPrice() {
			Price.PriceBuilder result;
			if (underlyerPrice!=null) {
				result = underlyerPrice;
			}
			else {
				result = underlyerPrice = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerNotional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerNotional")
		public Money.MoneyBuilder getUnderlyerNotional() {
			return underlyerNotional;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateUnderlyerNotional() {
			Money.MoneyBuilder result;
			if (underlyerNotional!=null) {
				result = underlyerNotional;
			}
			else {
				result = underlyerNotional = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerSpread")
		public SpreadScheduleReference.SpreadScheduleReferenceBuilder getUnderlyerSpread() {
			return underlyerSpread;
		}
		
		@Override
		public SpreadScheduleReference.SpreadScheduleReferenceBuilder getOrCreateUnderlyerSpread() {
			SpreadScheduleReference.SpreadScheduleReferenceBuilder result;
			if (underlyerSpread!=null) {
				result = underlyerSpread;
			}
			else {
				result = underlyerSpread = SpreadScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerFinancing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerFinancing")
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder getUnderlyerFinancing() {
			return underlyerFinancing;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder getOrCreateUnderlyerFinancing() {
			UnderlyerInterestLeg.UnderlyerInterestLegBuilder result;
			if (underlyerFinancing!=null) {
				result = underlyerFinancing;
			}
			else {
				result = underlyerFinancing = UnderlyerInterestLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerLoanRate")
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder getUnderlyerLoanRate() {
			return underlyerLoanRate;
		}
		
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder getOrCreateUnderlyerLoanRate() {
			UnderlyerLoanRate.UnderlyerLoanRateBuilder result;
			if (underlyerLoanRate!=null) {
				result = underlyerLoanRate;
			}
			else {
				result = underlyerLoanRate = UnderlyerLoanRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerCollateral")
		public Collateral.CollateralBuilder getUnderlyerCollateral() {
			return underlyerCollateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateUnderlyerCollateral() {
			Collateral.CollateralBuilder result;
			if (underlyerCollateral!=null) {
				result = underlyerCollateral;
			}
			else {
				result = underlyerCollateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayout")
		public DividendPayout.DividendPayoutBuilder getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout() {
			DividendPayout.DividendPayoutBuilder result;
			if (dividendPayout!=null) {
				result = dividendPayout;
			}
			else {
				result = dividendPayout = DividendPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("couponPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponPayment")
		public PendingPayment.PendingPaymentBuilder getCouponPayment() {
			return couponPayment;
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder getOrCreateCouponPayment() {
			PendingPayment.PendingPaymentBuilder result;
			if (couponPayment!=null) {
				result = couponPayment;
			}
			else {
				result = couponPayment = PendingPayment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BasketConstituent.BasketConstituentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerPartyReference")
		@Override
		public BasketConstituent.BasketConstituentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public BasketConstituent.BasketConstituentBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public BasketConstituent.BasketConstituentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public BasketConstituent.BasketConstituentBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyingAsset")
		@Override
		public BasketConstituent.BasketConstituentBuilder setUnderlyingAsset(Asset _underlyingAsset) {
			this.underlyingAsset = _underlyingAsset == null ? null : _underlyingAsset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("constituentWeight")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("constituentWeight")
		@Override
		public BasketConstituent.BasketConstituentBuilder setConstituentWeight(ConstituentWeight _constituentWeight) {
			this.constituentWeight = _constituentWeight == null ? null : _constituentWeight.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerPrice")
		@Override
		public BasketConstituent.BasketConstituentBuilder setUnderlyerPrice(Price _underlyerPrice) {
			this.underlyerPrice = _underlyerPrice == null ? null : _underlyerPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerNotional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerNotional")
		@Override
		public BasketConstituent.BasketConstituentBuilder setUnderlyerNotional(Money _underlyerNotional) {
			this.underlyerNotional = _underlyerNotional == null ? null : _underlyerNotional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerSpread")
		@Override
		public BasketConstituent.BasketConstituentBuilder setUnderlyerSpread(SpreadScheduleReference _underlyerSpread) {
			this.underlyerSpread = _underlyerSpread == null ? null : _underlyerSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerFinancing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerFinancing")
		@Override
		public BasketConstituent.BasketConstituentBuilder setUnderlyerFinancing(UnderlyerInterestLeg _underlyerFinancing) {
			this.underlyerFinancing = _underlyerFinancing == null ? null : _underlyerFinancing.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerLoanRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerLoanRate")
		@Override
		public BasketConstituent.BasketConstituentBuilder setUnderlyerLoanRate(UnderlyerLoanRate _underlyerLoanRate) {
			this.underlyerLoanRate = _underlyerLoanRate == null ? null : _underlyerLoanRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerCollateral")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerCollateral")
		@Override
		public BasketConstituent.BasketConstituentBuilder setUnderlyerCollateral(Collateral _underlyerCollateral) {
			this.underlyerCollateral = _underlyerCollateral == null ? null : _underlyerCollateral.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividendPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPayout")
		@Override
		public BasketConstituent.BasketConstituentBuilder setDividendPayout(DividendPayout _dividendPayout) {
			this.dividendPayout = _dividendPayout == null ? null : _dividendPayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("couponPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("couponPayment")
		@Override
		public BasketConstituent.BasketConstituentBuilder setCouponPayment(PendingPayment _couponPayment) {
			this.couponPayment = _couponPayment == null ? null : _couponPayment.toBuilder();
			return this;
		}
		
		@Override
		public BasketConstituent build() {
			return new BasketConstituent.BasketConstituentImpl(this);
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituent.BasketConstituentBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (constituentWeight!=null && !constituentWeight.prune().hasData()) constituentWeight = null;
			if (underlyerPrice!=null && !underlyerPrice.prune().hasData()) underlyerPrice = null;
			if (underlyerNotional!=null && !underlyerNotional.prune().hasData()) underlyerNotional = null;
			if (underlyerSpread!=null && !underlyerSpread.prune().hasData()) underlyerSpread = null;
			if (underlyerFinancing!=null && !underlyerFinancing.prune().hasData()) underlyerFinancing = null;
			if (underlyerLoanRate!=null && !underlyerLoanRate.prune().hasData()) underlyerLoanRate = null;
			if (underlyerCollateral!=null && !underlyerCollateral.prune().hasData()) underlyerCollateral = null;
			if (dividendPayout!=null && !dividendPayout.prune().hasData()) dividendPayout = null;
			if (couponPayment!=null && !couponPayment.prune().hasData()) couponPayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getConstituentWeight()!=null && getConstituentWeight().hasData()) return true;
			if (getUnderlyerPrice()!=null && getUnderlyerPrice().hasData()) return true;
			if (getUnderlyerNotional()!=null && getUnderlyerNotional().hasData()) return true;
			if (getUnderlyerSpread()!=null && getUnderlyerSpread().hasData()) return true;
			if (getUnderlyerFinancing()!=null && getUnderlyerFinancing().hasData()) return true;
			if (getUnderlyerLoanRate()!=null && getUnderlyerLoanRate().hasData()) return true;
			if (getUnderlyerCollateral()!=null && getUnderlyerCollateral().hasData()) return true;
			if (getDividendPayout()!=null && getDividendPayout().hasData()) return true;
			if (getCouponPayment()!=null && getCouponPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituent.BasketConstituentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketConstituent.BasketConstituentBuilder o = (BasketConstituent.BasketConstituentBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getConstituentWeight(), o.getConstituentWeight(), this::setConstituentWeight);
			merger.mergeRosetta(getUnderlyerPrice(), o.getUnderlyerPrice(), this::setUnderlyerPrice);
			merger.mergeRosetta(getUnderlyerNotional(), o.getUnderlyerNotional(), this::setUnderlyerNotional);
			merger.mergeRosetta(getUnderlyerSpread(), o.getUnderlyerSpread(), this::setUnderlyerSpread);
			merger.mergeRosetta(getUnderlyerFinancing(), o.getUnderlyerFinancing(), this::setUnderlyerFinancing);
			merger.mergeRosetta(getUnderlyerLoanRate(), o.getUnderlyerLoanRate(), this::setUnderlyerLoanRate);
			merger.mergeRosetta(getUnderlyerCollateral(), o.getUnderlyerCollateral(), this::setUnderlyerCollateral);
			merger.mergeRosetta(getDividendPayout(), o.getDividendPayout(), this::setDividendPayout);
			merger.mergeRosetta(getCouponPayment(), o.getCouponPayment(), this::setCouponPayment);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituent _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			if (!Objects.equals(underlyerPrice, _that.getUnderlyerPrice())) return false;
			if (!Objects.equals(underlyerNotional, _that.getUnderlyerNotional())) return false;
			if (!Objects.equals(underlyerSpread, _that.getUnderlyerSpread())) return false;
			if (!Objects.equals(underlyerFinancing, _that.getUnderlyerFinancing())) return false;
			if (!Objects.equals(underlyerLoanRate, _that.getUnderlyerLoanRate())) return false;
			if (!Objects.equals(underlyerCollateral, _that.getUnderlyerCollateral())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(couponPayment, _that.getCouponPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			_result = 31 * _result + (underlyerPrice != null ? underlyerPrice.hashCode() : 0);
			_result = 31 * _result + (underlyerNotional != null ? underlyerNotional.hashCode() : 0);
			_result = 31 * _result + (underlyerSpread != null ? underlyerSpread.hashCode() : 0);
			_result = 31 * _result + (underlyerFinancing != null ? underlyerFinancing.hashCode() : 0);
			_result = 31 * _result + (underlyerLoanRate != null ? underlyerLoanRate.hashCode() : 0);
			_result = 31 * _result + (underlyerCollateral != null ? underlyerCollateral.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (couponPayment != null ? couponPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituentBuilder {" +
				"id=" + this.id + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"constituentWeight=" + this.constituentWeight + ", " +
				"underlyerPrice=" + this.underlyerPrice + ", " +
				"underlyerNotional=" + this.underlyerNotional + ", " +
				"underlyerSpread=" + this.underlyerSpread + ", " +
				"underlyerFinancing=" + this.underlyerFinancing + ", " +
				"underlyerLoanRate=" + this.underlyerLoanRate + ", " +
				"underlyerCollateral=" + this.underlyerCollateral + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"couponPayment=" + this.couponPayment +
			'}';
		}
	}
}
