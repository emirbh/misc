package fpml.consolidated.ird;

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
import fpml.consolidated.fpmlenum.FraDiscountingEnum;
import fpml.consolidated.ird.meta.FraMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.IdentifiedRate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.RequiredIdentifierDate;
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
 * Provision A type defining a Forward Rate Agreement (FRA) product.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a Forward Rate Agreement (FRA) product.
 *
 */
@RosettaDataType(value="Fra", builder=Fra.FraBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Fra", model="fpml", builder=Fra.FraBuilderImpl.class, version="2.1.1")
public interface Fra extends Product {

	FraMeta metaData = new FraMeta();

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
	 * Provision The start date of the calculation period. This date should already be adjusted for any applicable business day convention. This is also the date when the observed rate is applied, the reset date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The start date of the calculation period. This date should already be adjusted for any applicable business day convention. This is also the date when the observed rate is applied, the reset date.
	 *
	 */
	RequiredIdentifierDate getAdjustedEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The end date of the calculation period. This date should already be adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The end date of the calculation period. This date should already be adjusted for any applicable business day convention.
	 *
	 */
	ZonedDateTime getAdjustedTerminationDate();
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
	 * Provision Specifies the fixing date relative to the reset date in terms of a business days offset and an associated set of financial business centers. Normally these offset calculation rules will be those specified in the ISDA definition for the relevant floating rate index (ISDA's Floating Rate Option). However, non-standard offset calculation rules may apply for a trade if mutually agreed by the principal parties to the transaction. The href attribute on the dateRelativeTo element should reference the id attribute on the adjustedEffectiveDate element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixing date relative to the reset date in terms of a business days offset and an associated set of financial business centers. Normally these offset calculation rules will be those specified in the ISDA definition for the relevant floating rate index (ISDA's Floating Rate Option). However, non-standard offset calculation rules may apply for a trade if mutually agreed by the principal parties to the transaction. The href attribute on the dateRelativeTo element should reference the id attribute on the adjustedEffectiveDate element.
	 *
	 */
	RelativeDateOffset getFixingDateOffset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 */
	DayCountFraction getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of days from the adjusted effective date to the adjusted termination date calculated in accordance with the applicable day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of days from the adjusted effective date to the adjusted termination date calculated in accordance with the applicable day count fraction.
	 *
	 */
	Integer getCalculationPeriodNumberOfDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The notional amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional amount.
	 *
	 */
	Money getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 *
	 */
	IdentifiedRate getFixedRate();
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
	FloatingRateIndex getFloatingRateIndex();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Designated Maturity, i.e. the tenor of the floating rate. A FRA can contain either one or two indexTenor instances.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Designated Maturity, i.e. the tenor of the floating rate. A FRA can contain either one or two indexTenor instances.
	 *
	 */
	List<? extends Period> getIndexTenor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether discounting applies and, if so, what type.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether discounting applies and, if so, what type.
	 *
	 */
	FraDiscountingEnum getFraDiscounting();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Additional payments between the principal parties (i.e. the parties referenced as the FRA buyer and seller).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Additional payments between the principal parties (i.e. the parties referenced as the FRA buyer and seller).
	 *
	 */
	List<? extends Payment> getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	Fra build();
	
	Fra.FraBuilder toBuilder();
	
	static Fra.FraBuilder builder() {
		return new Fra.FraBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Fra> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Fra> getType() {
		return Fra.class;
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
		processRosetta(path.newSubPath("adjustedEffectiveDate"), processor, RequiredIdentifierDate.class, getAdjustedEffectiveDate());
		processor.processBasic(path.newSubPath("adjustedTerminationDate"), ZonedDateTime.class, getAdjustedTerminationDate(), this);
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.class, getPaymentDate());
		processRosetta(path.newSubPath("fixingDateOffset"), processor, RelativeDateOffset.class, getFixingDateOffset());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
		processRosetta(path.newSubPath("notional"), processor, Money.class, getNotional());
		processRosetta(path.newSubPath("fixedRate"), processor, IdentifiedRate.class, getFixedRate());
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processor.processBasic(path.newSubPath("fraDiscounting"), FraDiscountingEnum.class, getFraDiscounting(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FraBuilder extends Fra, Product.ProductBuilder {
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
		RequiredIdentifierDate.RequiredIdentifierDateBuilder getOrCreateAdjustedEffectiveDate();
		@Override
		RequiredIdentifierDate.RequiredIdentifierDateBuilder getAdjustedEffectiveDate();
		AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getPaymentDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFixingDateOffset();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getFixingDateOffset();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		Money.MoneyBuilder getOrCreateNotional();
		@Override
		Money.MoneyBuilder getNotional();
		IdentifiedRate.IdentifiedRateBuilder getOrCreateFixedRate();
		@Override
		IdentifiedRate.IdentifiedRateBuilder getFixedRate();
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor(int index);
		@Override
		List<? extends Period.PeriodBuilder> getIndexTenor();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		@Override
		Fra.FraBuilder setId(String id);
		@Override
		Fra.FraBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		Fra.FraBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		Fra.FraBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		Fra.FraBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Fra.FraBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Fra.FraBuilder addProductType(ProductType productType);
		@Override
		Fra.FraBuilder addProductType(ProductType productType, int idx);
		@Override
		Fra.FraBuilder addProductType(List<? extends ProductType> productType);
		@Override
		Fra.FraBuilder setProductType(List<? extends ProductType> productType);
		@Override
		Fra.FraBuilder addProductId(ProductId productId);
		@Override
		Fra.FraBuilder addProductId(ProductId productId, int idx);
		@Override
		Fra.FraBuilder addProductId(List<? extends ProductId> productId);
		@Override
		Fra.FraBuilder setProductId(List<? extends ProductId> productId);
		@Override
		Fra.FraBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		Fra.FraBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		Fra.FraBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Fra.FraBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Fra.FraBuilder addAssetClass(AssetClass assetClass);
		@Override
		Fra.FraBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		Fra.FraBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		Fra.FraBuilder setAssetClass(List<? extends AssetClass> assetClass);
		Fra.FraBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		Fra.FraBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		Fra.FraBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		Fra.FraBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		Fra.FraBuilder setAdjustedEffectiveDate(RequiredIdentifierDate adjustedEffectiveDate);
		Fra.FraBuilder setAdjustedTerminationDate(ZonedDateTime adjustedTerminationDate);
		Fra.FraBuilder setPaymentDate(AdjustableDate paymentDate);
		Fra.FraBuilder setFixingDateOffset(RelativeDateOffset fixingDateOffset);
		Fra.FraBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		Fra.FraBuilder setCalculationPeriodNumberOfDays(Integer calculationPeriodNumberOfDays);
		Fra.FraBuilder setNotional(Money notional);
		Fra.FraBuilder setFixedRate(IdentifiedRate fixedRate);
		Fra.FraBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		Fra.FraBuilder addIndexTenor(Period indexTenor);
		Fra.FraBuilder addIndexTenor(Period indexTenor, int idx);
		Fra.FraBuilder addIndexTenor(List<? extends Period> indexTenor);
		Fra.FraBuilder setIndexTenor(List<? extends Period> indexTenor);
		Fra.FraBuilder setFraDiscounting(FraDiscountingEnum fraDiscounting);
		Fra.FraBuilder addAdditionalPayment(Payment additionalPayment);
		Fra.FraBuilder addAdditionalPayment(Payment additionalPayment, int idx);
		Fra.FraBuilder addAdditionalPayment(List<? extends Payment> additionalPayment);
		Fra.FraBuilder setAdditionalPayment(List<? extends Payment> additionalPayment);

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
			processRosetta(path.newSubPath("adjustedEffectiveDate"), processor, RequiredIdentifierDate.RequiredIdentifierDateBuilder.class, getAdjustedEffectiveDate());
			processor.processBasic(path.newSubPath("adjustedTerminationDate"), ZonedDateTime.class, getAdjustedTerminationDate(), this);
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("fixingDateOffset"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getFixingDateOffset());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
			processRosetta(path.newSubPath("notional"), processor, Money.MoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("fixedRate"), processor, IdentifiedRate.IdentifiedRateBuilder.class, getFixedRate());
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processor.processBasic(path.newSubPath("fraDiscounting"), FraDiscountingEnum.class, getFraDiscounting(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
		}
		

		Fra.FraBuilder prune();
	}

	/*********************** Immutable Implementation of Fra  ***********************/
	class FraImpl extends Product.ProductImpl implements Fra {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final RequiredIdentifierDate adjustedEffectiveDate;
		private final ZonedDateTime adjustedTerminationDate;
		private final AdjustableDate paymentDate;
		private final RelativeDateOffset fixingDateOffset;
		private final DayCountFraction dayCountFraction;
		private final Integer calculationPeriodNumberOfDays;
		private final Money notional;
		private final IdentifiedRate fixedRate;
		private final FloatingRateIndex floatingRateIndex;
		private final List<? extends Period> indexTenor;
		private final FraDiscountingEnum fraDiscounting;
		private final List<? extends Payment> additionalPayment;
		
		protected FraImpl(Fra.FraBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.adjustedEffectiveDate = ofNullable(builder.getAdjustedEffectiveDate()).map(f->f.build()).orElse(null);
			this.adjustedTerminationDate = builder.getAdjustedTerminationDate();
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.fixingDateOffset = ofNullable(builder.getFixingDateOffset()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.calculationPeriodNumberOfDays = builder.getCalculationPeriodNumberOfDays();
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.fixedRate = ofNullable(builder.getFixedRate()).map(f->f.build()).orElse(null);
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fraDiscounting = builder.getFraDiscounting();
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
		@RosettaAttribute("adjustedEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustedEffectiveDate")
		public RequiredIdentifierDate getAdjustedEffectiveDate() {
			return adjustedEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("adjustedTerminationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustedTerminationDate")
		public ZonedDateTime getAdjustedTerminationDate() {
			return adjustedTerminationDate;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public AdjustableDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("fixingDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingDateOffset")
		public RelativeDateOffset getFixingDateOffset() {
			return fixingDateOffset;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notional")
		public Money getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedRate")
		public IdentifiedRate getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("indexTenor")
		public List<? extends Period> getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		@RosettaAttribute("fraDiscounting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fraDiscounting")
		public FraDiscountingEnum getFraDiscounting() {
			return fraDiscounting;
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
		public Fra build() {
			return this;
		}
		
		@Override
		public Fra.FraBuilder toBuilder() {
			Fra.FraBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Fra.FraBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getAdjustedEffectiveDate()).ifPresent(builder::setAdjustedEffectiveDate);
			ofNullable(getAdjustedTerminationDate()).ifPresent(builder::setAdjustedTerminationDate);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getFixingDateOffset()).ifPresent(builder::setFixingDateOffset);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getCalculationPeriodNumberOfDays()).ifPresent(builder::setCalculationPeriodNumberOfDays);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
			ofNullable(getFraDiscounting()).ifPresent(builder::setFraDiscounting);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Fra _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(adjustedEffectiveDate, _that.getAdjustedEffectiveDate())) return false;
			if (!Objects.equals(adjustedTerminationDate, _that.getAdjustedTerminationDate())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(fixingDateOffset, _that.getFixingDateOffset())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!ListEquals.listEquals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(fraDiscounting, _that.getFraDiscounting())) return false;
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
			_result = 31 * _result + (adjustedEffectiveDate != null ? adjustedEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (adjustedTerminationDate != null ? adjustedTerminationDate.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (fixingDateOffset != null ? fixingDateOffset.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (fraDiscounting != null ? fraDiscounting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Fra {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"adjustedEffectiveDate=" + this.adjustedEffectiveDate + ", " +
				"adjustedTerminationDate=" + this.adjustedTerminationDate + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"fixingDateOffset=" + this.fixingDateOffset + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"notional=" + this.notional + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"fraDiscounting=" + this.fraDiscounting + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Fra  ***********************/
	class FraBuilderImpl extends Product.ProductBuilderImpl implements Fra.FraBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected RequiredIdentifierDate.RequiredIdentifierDateBuilder adjustedEffectiveDate;
		protected ZonedDateTime adjustedTerminationDate;
		protected AdjustableDate.AdjustableDateBuilder paymentDate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder fixingDateOffset;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected Integer calculationPeriodNumberOfDays;
		protected Money.MoneyBuilder notional;
		protected IdentifiedRate.IdentifiedRateBuilder fixedRate;
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected List<Period.PeriodBuilder> indexTenor = new ArrayList<>();
		protected FraDiscountingEnum fraDiscounting;
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
		@RosettaAttribute("adjustedEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustedEffectiveDate")
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder getAdjustedEffectiveDate() {
			return adjustedEffectiveDate;
		}
		
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder getOrCreateAdjustedEffectiveDate() {
			RequiredIdentifierDate.RequiredIdentifierDateBuilder result;
			if (adjustedEffectiveDate!=null) {
				result = adjustedEffectiveDate;
			}
			else {
				result = adjustedEffectiveDate = RequiredIdentifierDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedTerminationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustedTerminationDate")
		public ZonedDateTime getAdjustedTerminationDate() {
			return adjustedTerminationDate;
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
		@RosettaAttribute("fixingDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingDateOffset")
		public RelativeDateOffset.RelativeDateOffsetBuilder getFixingDateOffset() {
			return fixingDateOffset;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFixingDateOffset() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (fixingDateOffset!=null) {
				result = fixingDateOffset;
			}
			else {
				result = fixingDateOffset = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notional")
		public Money.MoneyBuilder getNotional() {
			return notional;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNotional() {
			Money.MoneyBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedRate")
		public IdentifiedRate.IdentifiedRateBuilder getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public IdentifiedRate.IdentifiedRateBuilder getOrCreateFixedRate() {
			IdentifiedRate.IdentifiedRateBuilder result;
			if (fixedRate!=null) {
				result = fixedRate;
			}
			else {
				result = fixedRate = IdentifiedRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("indexTenor")
		public List<? extends Period.PeriodBuilder> getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor(int index) {
			if (indexTenor==null) {
				this.indexTenor = new ArrayList<>();
			}
			return getIndex(indexTenor, index, () -> {
						Period.PeriodBuilder newIndexTenor = Period.builder();
						return newIndexTenor;
					});
		}
		
		@Override
		@RosettaAttribute("fraDiscounting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fraDiscounting")
		public FraDiscountingEnum getFraDiscounting() {
			return fraDiscounting;
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
		public Fra.FraBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public Fra.FraBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public Fra.FraBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Fra.FraBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public Fra.FraBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public Fra.FraBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public Fra.FraBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Fra.FraBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public Fra.FraBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public Fra.FraBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public Fra.FraBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Fra.FraBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public Fra.FraBuilder addProductId(List<? extends ProductId> productIds) {
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
		public Fra.FraBuilder setProductId(List<? extends ProductId> productIds) {
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
		public Fra.FraBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Fra.FraBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public Fra.FraBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public Fra.FraBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public Fra.FraBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Fra.FraBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public Fra.FraBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public Fra.FraBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public Fra.FraBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public Fra.FraBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public Fra.FraBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public Fra.FraBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("adjustedEffectiveDate")
		@Override
		public Fra.FraBuilder setAdjustedEffectiveDate(RequiredIdentifierDate _adjustedEffectiveDate) {
			this.adjustedEffectiveDate = _adjustedEffectiveDate == null ? null : _adjustedEffectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedTerminationDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("adjustedTerminationDate")
		@Override
		public Fra.FraBuilder setAdjustedTerminationDate(ZonedDateTime _adjustedTerminationDate) {
			this.adjustedTerminationDate = _adjustedTerminationDate == null ? null : _adjustedTerminationDate;
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public Fra.FraBuilder setPaymentDate(AdjustableDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingDateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingDateOffset")
		@Override
		public Fra.FraBuilder setFixingDateOffset(RelativeDateOffset _fixingDateOffset) {
			this.fixingDateOffset = _fixingDateOffset == null ? null : _fixingDateOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public Fra.FraBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodNumberOfDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodNumberOfDays")
		@Override
		public Fra.FraBuilder setCalculationPeriodNumberOfDays(Integer _calculationPeriodNumberOfDays) {
			this.calculationPeriodNumberOfDays = _calculationPeriodNumberOfDays == null ? null : _calculationPeriodNumberOfDays;
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notional")
		@Override
		public Fra.FraBuilder setNotional(Money _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixedRate")
		@Override
		public Fra.FraBuilder setFixedRate(IdentifiedRate _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("floatingRateIndex")
		@Override
		public Fra.FraBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("indexTenor")
		@Override
		public Fra.FraBuilder addIndexTenor(Period _indexTenor) {
			if (_indexTenor != null) {
				this.indexTenor.add(_indexTenor.toBuilder());
			}
			return this;
		}
		
		@Override
		public Fra.FraBuilder addIndexTenor(Period _indexTenor, int idx) {
			getIndex(this.indexTenor, idx, () -> _indexTenor.toBuilder());
			return this;
		}
		
		@Override
		public Fra.FraBuilder addIndexTenor(List<? extends Period> indexTenors) {
			if (indexTenors != null) {
				for (final Period toAdd : indexTenors) {
					this.indexTenor.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("indexTenor")
		@Override
		public Fra.FraBuilder setIndexTenor(List<? extends Period> indexTenors) {
			if (indexTenors == null) {
				this.indexTenor = new ArrayList<>();
			} else {
				this.indexTenor = indexTenors.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fraDiscounting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fraDiscounting")
		@Override
		public Fra.FraBuilder setFraDiscounting(FraDiscountingEnum _fraDiscounting) {
			this.fraDiscounting = _fraDiscounting == null ? null : _fraDiscounting;
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public Fra.FraBuilder addAdditionalPayment(Payment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public Fra.FraBuilder addAdditionalPayment(Payment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public Fra.FraBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		public Fra.FraBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		public Fra build() {
			return new Fra.FraImpl(this);
		}
		
		@Override
		public Fra.FraBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Fra.FraBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (adjustedEffectiveDate!=null && !adjustedEffectiveDate.prune().hasData()) adjustedEffectiveDate = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (fixingDateOffset!=null && !fixingDateOffset.prune().hasData()) fixingDateOffset = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (fixedRate!=null && !fixedRate.prune().hasData()) fixedRate = null;
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			indexTenor = indexTenor.stream().filter(b->b!=null).<Period.PeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
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
			if (getAdjustedEffectiveDate()!=null && getAdjustedEffectiveDate().hasData()) return true;
			if (getAdjustedTerminationDate()!=null) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getFixingDateOffset()!=null && getFixingDateOffset().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getCalculationPeriodNumberOfDays()!=null) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getFixedRate()!=null && getFixedRate().hasData()) return true;
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getIndexTenor()!=null && getIndexTenor().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFraDiscounting()!=null) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Fra.FraBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Fra.FraBuilder o = (Fra.FraBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getAdjustedEffectiveDate(), o.getAdjustedEffectiveDate(), this::setAdjustedEffectiveDate);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getFixingDateOffset(), o.getFixingDateOffset(), this::setFixingDateOffset);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::getOrCreateIndexTenor);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			
			merger.mergeBasic(getAdjustedTerminationDate(), o.getAdjustedTerminationDate(), this::setAdjustedTerminationDate);
			merger.mergeBasic(getCalculationPeriodNumberOfDays(), o.getCalculationPeriodNumberOfDays(), this::setCalculationPeriodNumberOfDays);
			merger.mergeBasic(getFraDiscounting(), o.getFraDiscounting(), this::setFraDiscounting);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Fra _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(adjustedEffectiveDate, _that.getAdjustedEffectiveDate())) return false;
			if (!Objects.equals(adjustedTerminationDate, _that.getAdjustedTerminationDate())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(fixingDateOffset, _that.getFixingDateOffset())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!ListEquals.listEquals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(fraDiscounting, _that.getFraDiscounting())) return false;
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
			_result = 31 * _result + (adjustedEffectiveDate != null ? adjustedEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (adjustedTerminationDate != null ? adjustedTerminationDate.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (fixingDateOffset != null ? fixingDateOffset.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (fraDiscounting != null ? fraDiscounting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FraBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"adjustedEffectiveDate=" + this.adjustedEffectiveDate + ", " +
				"adjustedTerminationDate=" + this.adjustedTerminationDate + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"fixingDateOffset=" + this.fixingDateOffset + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"notional=" + this.notional + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"fraDiscounting=" + this.fraDiscounting + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}
