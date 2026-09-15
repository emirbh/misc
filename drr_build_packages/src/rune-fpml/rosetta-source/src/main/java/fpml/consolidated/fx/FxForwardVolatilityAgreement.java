package fpml.consolidated.fx;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.fx.meta.FxForwardVolatilityAgreementMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Describes a contract on future levels of implied volatility. The main characteristic of this product is that the underlying is a straddle (underlying options) with a specific tenor starting from the fixing (effective or pricing) date, and are priced on that fixing date using a level of volatility that is agreed at the time of execution of the volatility agreement.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes a contract on future levels of implied volatility. The main characteristic of this product is that the underlying is a straddle (underlying options) with a specific tenor starting from the fixing (effective or pricing) date, and are priced on that fixing date using a level of volatility that is agreed at the time of execution of the volatility agreement.
 *
 */
@RosettaDataType(value="FxForwardVolatilityAgreement", builder=FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxForwardVolatilityAgreement", model="fpml", builder=FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilderImpl.class, version="2.1.1")
public interface FxForwardVolatilityAgreement extends Product {

	FxForwardVolatilityAgreementMeta metaData = new FxForwardVolatilityAgreementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 */
	AccountReference getBuyerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 */
	AccountReference getSellerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A currency Pair the straddle is based on.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A currency Pair the straddle is based on.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date when the underlying options are priced using the agreed forwardVolatilityStrikePrice and other market factors as agreed by the parties. Also known as "Effective Date" or "Reference Date".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date when the underlying options are priced using the agreed forwardVolatilityStrikePrice and other market factors as agreed by the parties. Also known as "Effective Date" or "Reference Date".
	 *
	 */
	ZonedDateTime getFixingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time of the fixing date when the underlying options are priced using the agreed forwardVolatilityStrikePrice and other market factors as agreed by the parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time of the fixing date when the underlying options are priced using the agreed forwardVolatilityStrikePrice and other market factors as agreed by the parties.
	 *
	 */
	BusinessCenterTime getFixingTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision the Volatility level as agreed on the Trade Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision the Volatility level as agreed on the Trade Date.
	 *
	 */
	BigDecimal getForwardVolatilityStrikePrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision details of the straddle (underlying options).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision details of the straddle (underlying options).
	 *
	 */
	FxStraddle getStraddle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency, amount and payment details for the Forward Volatility Agreement, as agreed at the time of execution.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency, amount and payment details for the Forward Volatility Agreement, as agreed at the time of execution.
	 *
	 */
	List<? extends Payment> getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	FxForwardVolatilityAgreement build();
	
	FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder toBuilder();
	
	static FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder builder() {
		return new FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxForwardVolatilityAgreement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxForwardVolatilityAgreement> getType() {
		return FxForwardVolatilityAgreement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.class, getEmbeddedOptionType());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
		processor.processBasic(path.newSubPath("forwardVolatilityStrikePrice"), BigDecimal.class, getForwardVolatilityStrikePrice(), this);
		processRosetta(path.newSubPath("straddle"), processor, FxStraddle.class, getStraddle());
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxForwardVolatilityAgreementBuilder extends FxForwardVolatilityAgreement, Product.ProductBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getBuyerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getSellerAccountReference();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		FxStraddle.FxStraddleBuilder getOrCreateStraddle();
		@Override
		FxStraddle.FxStraddleBuilder getStraddle();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setId(String id);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductType(ProductType productType);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductType(ProductType productType, int idx);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductId(ProductId productId);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductId(ProductId productId, int idx);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setAssetClass(List<? extends AssetClass> assetClass);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setFixingDate(ZonedDateTime fixingDate);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setFixingTime(BusinessCenterTime fixingTime);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setForwardVolatilityStrikePrice(BigDecimal forwardVolatilityStrikePrice);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setStraddle(FxStraddle straddle);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(Payment additionalPayment);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(Payment additionalPayment, int idx);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(List<? extends Payment> additionalPayment);
		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setAdditionalPayment(List<? extends Payment> additionalPayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
			processor.processBasic(path.newSubPath("forwardVolatilityStrikePrice"), BigDecimal.class, getForwardVolatilityStrikePrice(), this);
			processRosetta(path.newSubPath("straddle"), processor, FxStraddle.FxStraddleBuilder.class, getStraddle());
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
		}
		

		FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of FxForwardVolatilityAgreement  ***********************/
	class FxForwardVolatilityAgreementImpl extends Product.ProductImpl implements FxForwardVolatilityAgreement {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final ZonedDateTime fixingDate;
		private final BusinessCenterTime fixingTime;
		private final BigDecimal forwardVolatilityStrikePrice;
		private final FxStraddle straddle;
		private final List<? extends Payment> additionalPayment;
		
		protected FxForwardVolatilityAgreementImpl(FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.fixingDate = builder.getFixingDate();
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.forwardVolatilityStrikePrice = builder.getForwardVolatilityStrikePrice();
			this.straddle = ofNullable(builder.getStraddle()).map(f->f.build()).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingDate")
		public ZonedDateTime getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		@RosettaAttribute("forwardVolatilityStrikePrice")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("forwardVolatilityStrikePrice")
		public BigDecimal getForwardVolatilityStrikePrice() {
			return forwardVolatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("straddle")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("straddle")
		public FxStraddle getStraddle() {
			return straddle;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public FxForwardVolatilityAgreement build() {
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder toBuilder() {
			FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getForwardVolatilityStrikePrice()).ifPresent(builder::setForwardVolatilityStrikePrice);
			ofNullable(getStraddle()).ifPresent(builder::setStraddle);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxForwardVolatilityAgreement _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(forwardVolatilityStrikePrice, _that.getForwardVolatilityStrikePrice())) return false;
			if (!Objects.equals(straddle, _that.getStraddle())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (forwardVolatilityStrikePrice != null ? forwardVolatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (straddle != null ? straddle.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxForwardVolatilityAgreement {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"forwardVolatilityStrikePrice=" + this.forwardVolatilityStrikePrice + ", " +
				"straddle=" + this.straddle + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxForwardVolatilityAgreement  ***********************/
	class FxForwardVolatilityAgreementBuilderImpl extends Product.ProductBuilderImpl implements FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected ZonedDateTime fixingDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		protected BigDecimal forwardVolatilityStrikePrice;
		protected FxStraddle.FxStraddleBuilder straddle;
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference.AccountReferenceBuilder getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (buyerAccountReference!=null) {
				result = buyerAccountReference;
			}
			else {
				result = buyerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference.AccountReferenceBuilder getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (sellerAccountReference!=null) {
				result = sellerAccountReference;
			}
			else {
				result = sellerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingDate")
		public ZonedDateTime getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forwardVolatilityStrikePrice")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("forwardVolatilityStrikePrice")
		public BigDecimal getForwardVolatilityStrikePrice() {
			return forwardVolatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("straddle")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("straddle")
		public FxStraddle.FxStraddleBuilder getStraddle() {
			return straddle;
		}
		
		@Override
		public FxStraddle.FxStraddleBuilder getOrCreateStraddle() {
			FxStraddle.FxStraddleBuilder result;
			if (straddle!=null) {
				result = straddle;
			}
			else {
				result = straddle = FxStraddle.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends Payment.PaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateAdditionalPayment(int index) {
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			return getIndex(additionalPayment, index, () -> {
						Payment.PaymentBuilder newAdditionalPayment = Payment.builder();
						return newAdditionalPayment;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss != null) {
				for (final AssetClass toAdd : secondaryAssetClasss) {
					this.secondaryAssetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss == null) {
				this.secondaryAssetClass = new ArrayList<>();
			} else {
				this.secondaryAssetClass = secondaryAssetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductType(List<? extends ProductType> productTypes) {
			if (productTypes != null) {
				for (final ProductType toAdd : productTypes) {
					this.productType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null) {
				this.productType = new ArrayList<>();
			} else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addProductId(List<? extends ProductId> productIds) {
			if (productIds != null) {
				for (final ProductId toAdd : productIds) {
					this.productId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null) {
				this.productId = new ArrayList<>();
			} else {
				this.productId = productIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes != null) {
				for (final EmbeddedOptionType toAdd : embeddedOptionTypes) {
					this.embeddedOptionType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes == null) {
				this.embeddedOptionType = new ArrayList<>();
			} else {
				this.embeddedOptionType = embeddedOptionTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss != null) {
				for (final AssetClass toAdd : assetClasss) {
					this.assetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixingDate")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setFixingDate(ZonedDateTime _fixingDate) {
			this.fixingDate = _fixingDate == null ? null : _fixingDate;
			return this;
		}
		
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingTime")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setFixingTime(BusinessCenterTime _fixingTime) {
			this.fixingTime = _fixingTime == null ? null : _fixingTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("forwardVolatilityStrikePrice")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("forwardVolatilityStrikePrice")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setForwardVolatilityStrikePrice(BigDecimal _forwardVolatilityStrikePrice) {
			this.forwardVolatilityStrikePrice = _forwardVolatilityStrikePrice == null ? null : _forwardVolatilityStrikePrice;
			return this;
		}
		
		@RosettaAttribute("straddle")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("straddle")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setStraddle(FxStraddle _straddle) {
			this.straddle = _straddle == null ? null : _straddle.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(Payment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(Payment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (final Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments == null) {
				this.additionalPayment = new ArrayList<>();
			} else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxForwardVolatilityAgreement build() {
			return new FxForwardVolatilityAgreement.FxForwardVolatilityAgreementImpl(this);
		}
		
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			if (straddle!=null && !straddle.prune().hasData()) straddle = null;
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getFixingDate()!=null) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getForwardVolatilityStrikePrice()!=null) return true;
			if (getStraddle()!=null && getStraddle().hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder o = (FxForwardVolatilityAgreement.FxForwardVolatilityAgreementBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getStraddle(), o.getStraddle(), this::setStraddle);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			merger.mergeBasic(getForwardVolatilityStrikePrice(), o.getForwardVolatilityStrikePrice(), this::setForwardVolatilityStrikePrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxForwardVolatilityAgreement _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(forwardVolatilityStrikePrice, _that.getForwardVolatilityStrikePrice())) return false;
			if (!Objects.equals(straddle, _that.getStraddle())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (forwardVolatilityStrikePrice != null ? forwardVolatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (straddle != null ? straddle.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxForwardVolatilityAgreementBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"forwardVolatilityStrikePrice=" + this.forwardVolatilityStrikePrice + ", " +
				"straddle=" + this.straddle + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}
