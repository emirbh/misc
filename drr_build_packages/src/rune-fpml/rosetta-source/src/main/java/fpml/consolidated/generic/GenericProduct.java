package fpml.consolidated.generic;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.fpmlenum.LoadTypeEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.generic.meta.GenericProductMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate2;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CashflowNotional;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SimplePayment;
import java.math.BigDecimal;
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
 * Provision Simple product representation providing key information about a variety of different products. Generic products - for use in Transparency reporting to define a product that represents an OTC derivative transaction whose economics are not fully described using an FpML schema. In other views, generic products are present for convenience to support internal messaging and workflows that are cross-product. Generic products are not full trade representations as such they are not intended to be used for confirming trades.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Simple product representation providing key information about a variety of different products. Generic products - for use in Transparency reporting to define a product that represents an OTC derivative transaction whose economics are not fully described using an FpML schema. In other views, generic products are present for convenience to support internal messaging and workflows that are cross-product. Generic products are not full trade representations as such they are not intended to be used for confirming trades.
 *
 */
@RosettaDataType(value="GenericProduct", builder=GenericProduct.GenericProductBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericProduct", model="fpml", builder=GenericProduct.GenericProductBuilderImpl.class, version="2.1.1")
public interface GenericProduct extends Product {

	GenericProductMeta metaData = new GenericProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether this transaction has multiple components, not all of which may be reported. The use of this field is not recommended, and it may be deprecated in a future version of this standard.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether this transaction has multiple components, not all of which may be reported. The use of this field is not recommended, and it may be deprecated in a future version of this standard.
	 *
	 */
	Boolean getMultiLeg();
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
	List<? extends PartyReference> getCounterpartyReference();
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
	SimplePayment getPremium();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The earliest of all the effective dates of all constituent streams.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The earliest of all the effective dates of all constituent streams.
	 *
	 */
	AdjustableDate2 getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For options, the last exercise date of the option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For options, the last exercise date of the option.
	 *
	 */
	AdjustableDate2 getExpirationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The latest of all of the termination (accrual end) dates of the constituent or underlying streams.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The latest of all of the termination (accrual end) dates of the constituent or underlying streams.
	 *
	 */
	AdjustableDate2 getTerminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The set of underlyers to the trade that can be used in computing the trade's cashflows. If this information is needed to identify the trade, all of the trade's underlyers should be specified, whether or not they figure into the cashflow calculation. Otherwise, only those underlyers used to compute this particular cashflow need be supplied.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The set of underlyers to the trade that can be used in computing the trade's cashflows. If this information is needed to identify the trade, all of the trade's underlyers should be specified, whether or not they figure into the cashflow calculation. Otherwise, only those underlyers used to compute this particular cashflow need be supplied.
	 *
	 */
	List<? extends TradeUnderlyer2> getUnderlyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The notional or notionals in effect on the reporting date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional or notionals in effect on the reporting date.
	 *
	 */
	List<? extends CashflowNotional> getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The grade(s) of material which can be delivered in seller's option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The grade(s) of material which can be delivered in seller's option.
	 *
	 */
	List<? extends GenericCommodityGrade> getGrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the delivery time periods (normally used for electricity swaps).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the delivery time periods (normally used for electricity swaps).
	 *
	 */
	List<? extends GenericCommodityDeliveryPeriod> getSettlementPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision LoadType is a summary of the full description of the settlement periods with respect to the region. Used for describing Electricity delivery schedules (e.g. Base, Peak, Off-Peak, Custom).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision LoadType is a summary of the full description of the settlement periods with respect to the region. Used for describing Electricity delivery schedules (e.g. Base, Peak, Off-Peak, Custom).
	 *
	 */
	LoadTypeEnum getLoadType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The periodic quantity. Used in conjunction with the quantityFrequency to define quantity per period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The periodic quantity. Used in conjunction with the quantityFrequency to define quantity per period.
	 *
	 */
	BigDecimal getQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
	 *
	 */
	CommodityQuantityFrequency getQuantityFrequency();
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
	 * Provision Identification of the border(s) or border point(s) of a transportation contract.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the border(s) or border point(s) of a transportation contract.
	 *
	 */
	InterconnectionPoint getInterconnectionPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of units of underlyer per option comprised in the option transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of units of underlyer per option comprised in the option transaction.
	 *
	 */
	BigDecimal getOptionEntitlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of options comprised in the option transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of options comprised in the option transaction.
	 *
	 */
	BigDecimal getNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For options, what type of option it is (e.g. butterfly).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For options, what type of option it is (e.g. butterfly).
	 *
	 */
	OptionType getOptionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For options, the earliest exercise date of the option. (For CFTC Part 43, this element corresponds to the option lock-out period defined in the option field table).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For options, the earliest exercise date of the option. (For CFTC Part 43, this element corresponds to the option lock-out period defined in the option field table).
	 *
	 */
	AdjustableDate2 getCommencementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For options, whether the option is a put or call option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For options, whether the option is a put or call option.
	 *
	 */
	GenericExerciseStyle getExerciseStyle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The option strike or strikes.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The option strike or strikes.
	 *
	 */
	List<? extends GenericOptionStrike> getStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Special features that the option may have, such as Asian averaging, Barriers, Digital payout, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Special features that the option may have, such as Asian averaging, Barriers, Digital payout, etc.
	 *
	 */
	List<? extends GenericProductFeature> getFeature();
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
	List<? extends GenericFrequency> getPaymentFrequency();
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
	List<? extends GenericResetFrequency> getResetFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency or currencies in which the product can settle.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency or currencies in which the product can settle.
	 *
	 */
	List<? extends IdentifiedCurrency> getSettlementCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision How the trade settles (cash or physical). This element is also used for CFTC the "Delivery Type" field.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision How the trade settles (cash or physical). This element is also used for CFTC the "Delivery Type" field.
	 *
	 */
	SettlementTypeEnum getSettlementType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Additional payments between the principal parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Additional payments between the principal parties.
	 *
	 */
	List<? extends Payment> getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	GenericProduct build();
	
	GenericProduct.GenericProductBuilder toBuilder();
	
	static GenericProduct.GenericProductBuilder builder() {
		return new GenericProduct.GenericProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericProduct> getType() {
		return GenericProduct.class;
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
		processor.processBasic(path.newSubPath("multiLeg"), Boolean.class, getMultiLeg(), this);
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processRosetta(path.newSubPath("counterpartyReference"), processor, PartyReference.class, getCounterpartyReference());
		processRosetta(path.newSubPath("premium"), processor, SimplePayment.class, getPremium());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate2.class, getEffectiveDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableDate2.class, getExpirationDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableDate2.class, getTerminationDate());
		processRosetta(path.newSubPath("underlyer"), processor, TradeUnderlyer2.class, getUnderlyer());
		processRosetta(path.newSubPath("notional"), processor, CashflowNotional.class, getNotional());
		processRosetta(path.newSubPath("grade"), processor, GenericCommodityGrade.class, getGrade());
		processRosetta(path.newSubPath("settlementPeriods"), processor, GenericCommodityDeliveryPeriod.class, getSettlementPeriods());
		processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.class, getQuantityFrequency());
		processRosetta(path.newSubPath("fixedPrice"), processor, CommodityFixedPrice.class, getFixedPrice());
		processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.class, getInterconnectionPoint());
		processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
		processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
		processRosetta(path.newSubPath("optionType"), processor, OptionType.class, getOptionType());
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableDate2.class, getCommencementDate());
		processRosetta(path.newSubPath("exerciseStyle"), processor, GenericExerciseStyle.class, getExerciseStyle());
		processRosetta(path.newSubPath("strike"), processor, GenericOptionStrike.class, getStrike());
		processRosetta(path.newSubPath("feature"), processor, GenericProductFeature.class, getFeature());
		processRosetta(path.newSubPath("paymentFrequency"), processor, GenericFrequency.class, getPaymentFrequency());
		processRosetta(path.newSubPath("resetFrequency"), processor, GenericResetFrequency.class, getResetFrequency());
		processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.class, getSettlementCurrency());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericProductBuilder extends GenericProduct, Product.ProductBuilder {
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
		PartyReference.PartyReferenceBuilder getOrCreateCounterpartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getCounterpartyReference();
		SimplePayment.SimplePaymentBuilder getOrCreatePremium();
		@Override
		SimplePayment.SimplePaymentBuilder getPremium();
		AdjustableDate2.AdjustableDate2Builder getOrCreateEffectiveDate();
		@Override
		AdjustableDate2.AdjustableDate2Builder getEffectiveDate();
		AdjustableDate2.AdjustableDate2Builder getOrCreateExpirationDate();
		@Override
		AdjustableDate2.AdjustableDate2Builder getExpirationDate();
		AdjustableDate2.AdjustableDate2Builder getOrCreateTerminationDate();
		@Override
		AdjustableDate2.AdjustableDate2Builder getTerminationDate();
		TradeUnderlyer2.TradeUnderlyer2Builder getOrCreateUnderlyer(int index);
		@Override
		List<? extends TradeUnderlyer2.TradeUnderlyer2Builder> getUnderlyer();
		CashflowNotional.CashflowNotionalBuilder getOrCreateNotional(int index);
		@Override
		List<? extends CashflowNotional.CashflowNotionalBuilder> getNotional();
		GenericCommodityGrade.GenericCommodityGradeBuilder getOrCreateGrade(int index);
		@Override
		List<? extends GenericCommodityGrade.GenericCommodityGradeBuilder> getGrade();
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder getOrCreateSettlementPeriods(int index);
		@Override
		List<? extends GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder> getSettlementPeriods();
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency();
		@Override
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency();
		CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateFixedPrice();
		@Override
		CommodityFixedPrice.CommodityFixedPriceBuilder getFixedPrice();
		InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint();
		@Override
		InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint();
		OptionType.OptionTypeBuilder getOrCreateOptionType();
		@Override
		OptionType.OptionTypeBuilder getOptionType();
		AdjustableDate2.AdjustableDate2Builder getOrCreateCommencementDate();
		@Override
		AdjustableDate2.AdjustableDate2Builder getCommencementDate();
		GenericExerciseStyle.GenericExerciseStyleBuilder getOrCreateExerciseStyle();
		@Override
		GenericExerciseStyle.GenericExerciseStyleBuilder getExerciseStyle();
		GenericOptionStrike.GenericOptionStrikeBuilder getOrCreateStrike(int index);
		@Override
		List<? extends GenericOptionStrike.GenericOptionStrikeBuilder> getStrike();
		GenericProductFeature.GenericProductFeatureBuilder getOrCreateFeature(int index);
		@Override
		List<? extends GenericProductFeature.GenericProductFeatureBuilder> getFeature();
		GenericFrequency.GenericFrequencyBuilder getOrCreatePaymentFrequency(int index);
		@Override
		List<? extends GenericFrequency.GenericFrequencyBuilder> getPaymentFrequency();
		GenericResetFrequency.GenericResetFrequencyBuilder getOrCreateResetFrequency(int index);
		@Override
		List<? extends GenericResetFrequency.GenericResetFrequencyBuilder> getResetFrequency();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency(int index);
		@Override
		List<? extends IdentifiedCurrency.IdentifiedCurrencyBuilder> getSettlementCurrency();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		@Override
		GenericProduct.GenericProductBuilder setId(String id);
		@Override
		GenericProduct.GenericProductBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		GenericProduct.GenericProductBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		GenericProduct.GenericProductBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		GenericProduct.GenericProductBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		GenericProduct.GenericProductBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		GenericProduct.GenericProductBuilder addProductType(ProductType productType);
		@Override
		GenericProduct.GenericProductBuilder addProductType(ProductType productType, int idx);
		@Override
		GenericProduct.GenericProductBuilder addProductType(List<? extends ProductType> productType);
		@Override
		GenericProduct.GenericProductBuilder setProductType(List<? extends ProductType> productType);
		@Override
		GenericProduct.GenericProductBuilder addProductId(ProductId productId);
		@Override
		GenericProduct.GenericProductBuilder addProductId(ProductId productId, int idx);
		@Override
		GenericProduct.GenericProductBuilder addProductId(List<? extends ProductId> productId);
		@Override
		GenericProduct.GenericProductBuilder setProductId(List<? extends ProductId> productId);
		@Override
		GenericProduct.GenericProductBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		GenericProduct.GenericProductBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		GenericProduct.GenericProductBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		GenericProduct.GenericProductBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		GenericProduct.GenericProductBuilder addAssetClass(AssetClass assetClass);
		@Override
		GenericProduct.GenericProductBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		GenericProduct.GenericProductBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		GenericProduct.GenericProductBuilder setAssetClass(List<? extends AssetClass> assetClass);
		GenericProduct.GenericProductBuilder setMultiLeg(Boolean multiLeg);
		GenericProduct.GenericProductBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		GenericProduct.GenericProductBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		GenericProduct.GenericProductBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		GenericProduct.GenericProductBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		GenericProduct.GenericProductBuilder addCounterpartyReference(PartyReference counterpartyReference);
		GenericProduct.GenericProductBuilder addCounterpartyReference(PartyReference counterpartyReference, int idx);
		GenericProduct.GenericProductBuilder addCounterpartyReference(List<? extends PartyReference> counterpartyReference);
		GenericProduct.GenericProductBuilder setCounterpartyReference(List<? extends PartyReference> counterpartyReference);
		GenericProduct.GenericProductBuilder setPremium(SimplePayment premium);
		GenericProduct.GenericProductBuilder setEffectiveDate(AdjustableDate2 effectiveDate);
		GenericProduct.GenericProductBuilder setExpirationDate(AdjustableDate2 expirationDate);
		GenericProduct.GenericProductBuilder setTerminationDate(AdjustableDate2 terminationDate);
		GenericProduct.GenericProductBuilder addUnderlyer(TradeUnderlyer2 underlyer);
		GenericProduct.GenericProductBuilder addUnderlyer(TradeUnderlyer2 underlyer, int idx);
		GenericProduct.GenericProductBuilder addUnderlyer(List<? extends TradeUnderlyer2> underlyer);
		GenericProduct.GenericProductBuilder setUnderlyer(List<? extends TradeUnderlyer2> underlyer);
		GenericProduct.GenericProductBuilder addNotional(CashflowNotional notional);
		GenericProduct.GenericProductBuilder addNotional(CashflowNotional notional, int idx);
		GenericProduct.GenericProductBuilder addNotional(List<? extends CashflowNotional> notional);
		GenericProduct.GenericProductBuilder setNotional(List<? extends CashflowNotional> notional);
		GenericProduct.GenericProductBuilder addGrade(GenericCommodityGrade grade);
		GenericProduct.GenericProductBuilder addGrade(GenericCommodityGrade grade, int idx);
		GenericProduct.GenericProductBuilder addGrade(List<? extends GenericCommodityGrade> grade);
		GenericProduct.GenericProductBuilder setGrade(List<? extends GenericCommodityGrade> grade);
		GenericProduct.GenericProductBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod settlementPeriods);
		GenericProduct.GenericProductBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod settlementPeriods, int idx);
		GenericProduct.GenericProductBuilder addSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriods);
		GenericProduct.GenericProductBuilder setSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriods);
		GenericProduct.GenericProductBuilder setLoadType(LoadTypeEnum loadType);
		GenericProduct.GenericProductBuilder setQuantity(BigDecimal quantity);
		GenericProduct.GenericProductBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency);
		GenericProduct.GenericProductBuilder setFixedPrice(CommodityFixedPrice fixedPrice);
		GenericProduct.GenericProductBuilder setInterconnectionPoint(InterconnectionPoint interconnectionPoint);
		GenericProduct.GenericProductBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		GenericProduct.GenericProductBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		GenericProduct.GenericProductBuilder setOptionType(OptionType optionType);
		GenericProduct.GenericProductBuilder setCommencementDate(AdjustableDate2 commencementDate);
		GenericProduct.GenericProductBuilder setExerciseStyle(GenericExerciseStyle exerciseStyle);
		GenericProduct.GenericProductBuilder addStrike(GenericOptionStrike strike);
		GenericProduct.GenericProductBuilder addStrike(GenericOptionStrike strike, int idx);
		GenericProduct.GenericProductBuilder addStrike(List<? extends GenericOptionStrike> strike);
		GenericProduct.GenericProductBuilder setStrike(List<? extends GenericOptionStrike> strike);
		GenericProduct.GenericProductBuilder addFeature(GenericProductFeature feature);
		GenericProduct.GenericProductBuilder addFeature(GenericProductFeature feature, int idx);
		GenericProduct.GenericProductBuilder addFeature(List<? extends GenericProductFeature> feature);
		GenericProduct.GenericProductBuilder setFeature(List<? extends GenericProductFeature> feature);
		GenericProduct.GenericProductBuilder addPaymentFrequency(GenericFrequency paymentFrequency);
		GenericProduct.GenericProductBuilder addPaymentFrequency(GenericFrequency paymentFrequency, int idx);
		GenericProduct.GenericProductBuilder addPaymentFrequency(List<? extends GenericFrequency> paymentFrequency);
		GenericProduct.GenericProductBuilder setPaymentFrequency(List<? extends GenericFrequency> paymentFrequency);
		GenericProduct.GenericProductBuilder addResetFrequency(GenericResetFrequency resetFrequency);
		GenericProduct.GenericProductBuilder addResetFrequency(GenericResetFrequency resetFrequency, int idx);
		GenericProduct.GenericProductBuilder addResetFrequency(List<? extends GenericResetFrequency> resetFrequency);
		GenericProduct.GenericProductBuilder setResetFrequency(List<? extends GenericResetFrequency> resetFrequency);
		GenericProduct.GenericProductBuilder addSettlementCurrency(IdentifiedCurrency settlementCurrency);
		GenericProduct.GenericProductBuilder addSettlementCurrency(IdentifiedCurrency settlementCurrency, int idx);
		GenericProduct.GenericProductBuilder addSettlementCurrency(List<? extends IdentifiedCurrency> settlementCurrency);
		GenericProduct.GenericProductBuilder setSettlementCurrency(List<? extends IdentifiedCurrency> settlementCurrency);
		GenericProduct.GenericProductBuilder setSettlementType(SettlementTypeEnum settlementType);
		GenericProduct.GenericProductBuilder addAdditionalPayment(Payment additionalPayment);
		GenericProduct.GenericProductBuilder addAdditionalPayment(Payment additionalPayment, int idx);
		GenericProduct.GenericProductBuilder addAdditionalPayment(List<? extends Payment> additionalPayment);
		GenericProduct.GenericProductBuilder setAdditionalPayment(List<? extends Payment> additionalPayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processor.processBasic(path.newSubPath("multiLeg"), Boolean.class, getMultiLeg(), this);
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("counterpartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCounterpartyReference());
			processRosetta(path.newSubPath("premium"), processor, SimplePayment.SimplePaymentBuilder.class, getPremium());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getEffectiveDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getExpirationDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getTerminationDate());
			processRosetta(path.newSubPath("underlyer"), processor, TradeUnderlyer2.TradeUnderlyer2Builder.class, getUnderlyer());
			processRosetta(path.newSubPath("notional"), processor, CashflowNotional.CashflowNotionalBuilder.class, getNotional());
			processRosetta(path.newSubPath("grade"), processor, GenericCommodityGrade.GenericCommodityGradeBuilder.class, getGrade());
			processRosetta(path.newSubPath("settlementPeriods"), processor, GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder.class, getSettlementPeriods());
			processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder.class, getQuantityFrequency());
			processRosetta(path.newSubPath("fixedPrice"), processor, CommodityFixedPrice.CommodityFixedPriceBuilder.class, getFixedPrice());
			processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.InterconnectionPointBuilder.class, getInterconnectionPoint());
			processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
			processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
			processRosetta(path.newSubPath("optionType"), processor, OptionType.OptionTypeBuilder.class, getOptionType());
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getCommencementDate());
			processRosetta(path.newSubPath("exerciseStyle"), processor, GenericExerciseStyle.GenericExerciseStyleBuilder.class, getExerciseStyle());
			processRosetta(path.newSubPath("strike"), processor, GenericOptionStrike.GenericOptionStrikeBuilder.class, getStrike());
			processRosetta(path.newSubPath("feature"), processor, GenericProductFeature.GenericProductFeatureBuilder.class, getFeature());
			processRosetta(path.newSubPath("paymentFrequency"), processor, GenericFrequency.GenericFrequencyBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("resetFrequency"), processor, GenericResetFrequency.GenericResetFrequencyBuilder.class, getResetFrequency());
			processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getSettlementCurrency());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
		}
		

		GenericProduct.GenericProductBuilder prune();
	}

	/*********************** Immutable Implementation of GenericProduct  ***********************/
	class GenericProductImpl extends Product.ProductImpl implements GenericProduct {
		private final Boolean multiLeg;
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final List<? extends PartyReference> counterpartyReference;
		private final SimplePayment premium;
		private final AdjustableDate2 effectiveDate;
		private final AdjustableDate2 expirationDate;
		private final AdjustableDate2 terminationDate;
		private final List<? extends TradeUnderlyer2> underlyer;
		private final List<? extends CashflowNotional> notional;
		private final List<? extends GenericCommodityGrade> grade;
		private final List<? extends GenericCommodityDeliveryPeriod> settlementPeriods;
		private final LoadTypeEnum loadType;
		private final BigDecimal quantity;
		private final CommodityQuantityFrequency quantityFrequency;
		private final CommodityFixedPrice fixedPrice;
		private final InterconnectionPoint interconnectionPoint;
		private final BigDecimal optionEntitlement;
		private final BigDecimal numberOfOptions;
		private final OptionType optionType;
		private final AdjustableDate2 commencementDate;
		private final GenericExerciseStyle exerciseStyle;
		private final List<? extends GenericOptionStrike> strike;
		private final List<? extends GenericProductFeature> feature;
		private final List<? extends GenericFrequency> paymentFrequency;
		private final List<? extends GenericResetFrequency> resetFrequency;
		private final List<? extends IdentifiedCurrency> settlementCurrency;
		private final SettlementTypeEnum settlementType;
		private final List<? extends Payment> additionalPayment;
		
		protected GenericProductImpl(GenericProduct.GenericProductBuilder builder) {
			super(builder);
			this.multiLeg = builder.getMultiLeg();
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.counterpartyReference = ofNullable(builder.getCounterpartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premium = ofNullable(builder.getPremium()).map(f->f.build()).orElse(null);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.underlyer = ofNullable(builder.getUnderlyer()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.notional = ofNullable(builder.getNotional()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.grade = ofNullable(builder.getGrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriods = ofNullable(builder.getSettlementPeriods()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loadType = builder.getLoadType();
			this.quantity = builder.getQuantity();
			this.quantityFrequency = ofNullable(builder.getQuantityFrequency()).map(f->f.build()).orElse(null);
			this.fixedPrice = ofNullable(builder.getFixedPrice()).map(f->f.build()).orElse(null);
			this.interconnectionPoint = ofNullable(builder.getInterconnectionPoint()).map(f->f.build()).orElse(null);
			this.optionEntitlement = builder.getOptionEntitlement();
			this.numberOfOptions = builder.getNumberOfOptions();
			this.optionType = ofNullable(builder.getOptionType()).map(f->f.build()).orElse(null);
			this.commencementDate = ofNullable(builder.getCommencementDate()).map(f->f.build()).orElse(null);
			this.exerciseStyle = ofNullable(builder.getExerciseStyle()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.feature = ofNullable(builder.getFeature()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.resetFrequency = ofNullable(builder.getResetFrequency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementType = builder.getSettlementType();
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("multiLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiLeg")
		public Boolean getMultiLeg() {
			return multiLeg;
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("counterpartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("counterpartyReference")
		public List<? extends PartyReference> getCounterpartyReference() {
			return counterpartyReference;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premium")
		public SimplePayment getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableDate2 getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDate")
		public AdjustableDate2 getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationDate")
		public AdjustableDate2 getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyer")
		public List<? extends TradeUnderlyer2> getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notional")
		public List<? extends CashflowNotional> getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("grade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("grade")
		public List<? extends GenericCommodityGrade> getGrade() {
			return grade;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriods")
		public List<? extends GenericCommodityDeliveryPeriod> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequency")
		public CommodityQuantityFrequency getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedPrice")
		public CommodityFixedPrice getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public InterconnectionPoint getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public OptionType getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commencementDate")
		public AdjustableDate2 getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseStyle")
		public GenericExerciseStyle getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strike")
		public List<? extends GenericOptionStrike> getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("feature")
		public List<? extends GenericProductFeature> getFeature() {
			return feature;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentFrequency")
		public List<? extends GenericFrequency> getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("resetFrequency")
		public List<? extends GenericResetFrequency> getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementCurrency")
		public List<? extends IdentifiedCurrency> getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
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
		public GenericProduct build() {
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder toBuilder() {
			GenericProduct.GenericProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericProduct.GenericProductBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultiLeg()).ifPresent(builder::setMultiLeg);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getCounterpartyReference()).ifPresent(builder::setCounterpartyReference);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getGrade()).ifPresent(builder::setGrade);
			ofNullable(getSettlementPeriods()).ifPresent(builder::setSettlementPeriods);
			ofNullable(getLoadType()).ifPresent(builder::setLoadType);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getQuantityFrequency()).ifPresent(builder::setQuantityFrequency);
			ofNullable(getFixedPrice()).ifPresent(builder::setFixedPrice);
			ofNullable(getInterconnectionPoint()).ifPresent(builder::setInterconnectionPoint);
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getNumberOfOptions()).ifPresent(builder::setNumberOfOptions);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getCommencementDate()).ifPresent(builder::setCommencementDate);
			ofNullable(getExerciseStyle()).ifPresent(builder::setExerciseStyle);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getFeature()).ifPresent(builder::setFeature);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getResetFrequency()).ifPresent(builder::setResetFrequency);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericProduct _that = getType().cast(o);
		
			if (!Objects.equals(multiLeg, _that.getMultiLeg())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!ListEquals.listEquals(counterpartyReference, _that.getCounterpartyReference())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!ListEquals.listEquals(underlyer, _that.getUnderlyer())) return false;
			if (!ListEquals.listEquals(notional, _that.getNotional())) return false;
			if (!ListEquals.listEquals(grade, _that.getGrade())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!ListEquals.listEquals(strike, _that.getStrike())) return false;
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			if (!ListEquals.listEquals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!ListEquals.listEquals(resetFrequency, _that.getResetFrequency())) return false;
			if (!ListEquals.listEquals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiLeg != null ? multiLeg.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (counterpartyReference != null ? counterpartyReference.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.hashCode() : 0);
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProduct {" +
				"multiLeg=" + this.multiLeg + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"counterpartyReference=" + this.counterpartyReference + ", " +
				"premium=" + this.premium + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"notional=" + this.notional + ", " +
				"grade=" + this.grade + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"loadType=" + this.loadType + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"optionType=" + this.optionType + ", " +
				"commencementDate=" + this.commencementDate + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"strike=" + this.strike + ", " +
				"feature=" + this.feature + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementType=" + this.settlementType + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericProduct  ***********************/
	class GenericProductBuilderImpl extends Product.ProductBuilderImpl implements GenericProduct.GenericProductBuilder {
	
		protected Boolean multiLeg;
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected List<PartyReference.PartyReferenceBuilder> counterpartyReference = new ArrayList<>();
		protected SimplePayment.SimplePaymentBuilder premium;
		protected AdjustableDate2.AdjustableDate2Builder effectiveDate;
		protected AdjustableDate2.AdjustableDate2Builder expirationDate;
		protected AdjustableDate2.AdjustableDate2Builder terminationDate;
		protected List<TradeUnderlyer2.TradeUnderlyer2Builder> underlyer = new ArrayList<>();
		protected List<CashflowNotional.CashflowNotionalBuilder> notional = new ArrayList<>();
		protected List<GenericCommodityGrade.GenericCommodityGradeBuilder> grade = new ArrayList<>();
		protected List<GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder> settlementPeriods = new ArrayList<>();
		protected LoadTypeEnum loadType;
		protected BigDecimal quantity;
		protected CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder quantityFrequency;
		protected CommodityFixedPrice.CommodityFixedPriceBuilder fixedPrice;
		protected InterconnectionPoint.InterconnectionPointBuilder interconnectionPoint;
		protected BigDecimal optionEntitlement;
		protected BigDecimal numberOfOptions;
		protected OptionType.OptionTypeBuilder optionType;
		protected AdjustableDate2.AdjustableDate2Builder commencementDate;
		protected GenericExerciseStyle.GenericExerciseStyleBuilder exerciseStyle;
		protected List<GenericOptionStrike.GenericOptionStrikeBuilder> strike = new ArrayList<>();
		protected List<GenericProductFeature.GenericProductFeatureBuilder> feature = new ArrayList<>();
		protected List<GenericFrequency.GenericFrequencyBuilder> paymentFrequency = new ArrayList<>();
		protected List<GenericResetFrequency.GenericResetFrequencyBuilder> resetFrequency = new ArrayList<>();
		protected List<IdentifiedCurrency.IdentifiedCurrencyBuilder> settlementCurrency = new ArrayList<>();
		protected SettlementTypeEnum settlementType;
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("multiLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiLeg")
		public Boolean getMultiLeg() {
			return multiLeg;
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("counterpartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("counterpartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getCounterpartyReference() {
			return counterpartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCounterpartyReference(int index) {
			if (counterpartyReference==null) {
				this.counterpartyReference = new ArrayList<>();
			}
			return getIndex(counterpartyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newCounterpartyReference = PartyReference.builder();
						return newCounterpartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premium")
		public SimplePayment.SimplePaymentBuilder getPremium() {
			return premium;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreatePremium() {
			SimplePayment.SimplePaymentBuilder result;
			if (premium!=null) {
				result = premium;
			}
			else {
				result = premium = SimplePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableDate2.AdjustableDate2Builder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateEffectiveDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDate")
		public AdjustableDate2.AdjustableDate2Builder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateExpirationDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationDate")
		public AdjustableDate2.AdjustableDate2Builder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateTerminationDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyer")
		public List<? extends TradeUnderlyer2.TradeUnderlyer2Builder> getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder getOrCreateUnderlyer(int index) {
			if (underlyer==null) {
				this.underlyer = new ArrayList<>();
			}
			return getIndex(underlyer, index, () -> {
						TradeUnderlyer2.TradeUnderlyer2Builder newUnderlyer = TradeUnderlyer2.builder();
						return newUnderlyer;
					});
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notional")
		public List<? extends CashflowNotional.CashflowNotionalBuilder> getNotional() {
			return notional;
		}
		
		@Override
		public CashflowNotional.CashflowNotionalBuilder getOrCreateNotional(int index) {
			if (notional==null) {
				this.notional = new ArrayList<>();
			}
			return getIndex(notional, index, () -> {
						CashflowNotional.CashflowNotionalBuilder newNotional = CashflowNotional.builder();
						return newNotional;
					});
		}
		
		@Override
		@RosettaAttribute("grade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("grade")
		public List<? extends GenericCommodityGrade.GenericCommodityGradeBuilder> getGrade() {
			return grade;
		}
		
		@Override
		public GenericCommodityGrade.GenericCommodityGradeBuilder getOrCreateGrade(int index) {
			if (grade==null) {
				this.grade = new ArrayList<>();
			}
			return getIndex(grade, index, () -> {
						GenericCommodityGrade.GenericCommodityGradeBuilder newGrade = GenericCommodityGrade.builder();
						return newGrade;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriods")
		public List<? extends GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder getOrCreateSettlementPeriods(int index) {
			if (settlementPeriods==null) {
				this.settlementPeriods = new ArrayList<>();
			}
			return getIndex(settlementPeriods, index, () -> {
						GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder newSettlementPeriods = GenericCommodityDeliveryPeriod.builder();
						return newSettlementPeriods;
					});
		}
		
		@Override
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequency")
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency() {
			CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder result;
			if (quantityFrequency!=null) {
				result = quantityFrequency;
			}
			else {
				result = quantityFrequency = CommodityQuantityFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint() {
			InterconnectionPoint.InterconnectionPointBuilder result;
			if (interconnectionPoint!=null) {
				result = interconnectionPoint;
			}
			else {
				result = interconnectionPoint = InterconnectionPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public OptionType.OptionTypeBuilder getOptionType() {
			return optionType;
		}
		
		@Override
		public OptionType.OptionTypeBuilder getOrCreateOptionType() {
			OptionType.OptionTypeBuilder result;
			if (optionType!=null) {
				result = optionType;
			}
			else {
				result = optionType = OptionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commencementDate")
		public AdjustableDate2.AdjustableDate2Builder getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateCommencementDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (commencementDate!=null) {
				result = commencementDate;
			}
			else {
				result = commencementDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseStyle")
		public GenericExerciseStyle.GenericExerciseStyleBuilder getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder getOrCreateExerciseStyle() {
			GenericExerciseStyle.GenericExerciseStyleBuilder result;
			if (exerciseStyle!=null) {
				result = exerciseStyle;
			}
			else {
				result = exerciseStyle = GenericExerciseStyle.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strike")
		public List<? extends GenericOptionStrike.GenericOptionStrikeBuilder> getStrike() {
			return strike;
		}
		
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder getOrCreateStrike(int index) {
			if (strike==null) {
				this.strike = new ArrayList<>();
			}
			return getIndex(strike, index, () -> {
						GenericOptionStrike.GenericOptionStrikeBuilder newStrike = GenericOptionStrike.builder();
						return newStrike;
					});
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("feature")
		public List<? extends GenericProductFeature.GenericProductFeatureBuilder> getFeature() {
			return feature;
		}
		
		@Override
		public GenericProductFeature.GenericProductFeatureBuilder getOrCreateFeature(int index) {
			if (feature==null) {
				this.feature = new ArrayList<>();
			}
			return getIndex(feature, index, () -> {
						GenericProductFeature.GenericProductFeatureBuilder newFeature = GenericProductFeature.builder();
						return newFeature;
					});
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentFrequency")
		public List<? extends GenericFrequency.GenericFrequencyBuilder> getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public GenericFrequency.GenericFrequencyBuilder getOrCreatePaymentFrequency(int index) {
			if (paymentFrequency==null) {
				this.paymentFrequency = new ArrayList<>();
			}
			return getIndex(paymentFrequency, index, () -> {
						GenericFrequency.GenericFrequencyBuilder newPaymentFrequency = GenericFrequency.builder();
						return newPaymentFrequency;
					});
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("resetFrequency")
		public List<? extends GenericResetFrequency.GenericResetFrequencyBuilder> getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder getOrCreateResetFrequency(int index) {
			if (resetFrequency==null) {
				this.resetFrequency = new ArrayList<>();
			}
			return getIndex(resetFrequency, index, () -> {
						GenericResetFrequency.GenericResetFrequencyBuilder newResetFrequency = GenericResetFrequency.builder();
						return newResetFrequency;
					});
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementCurrency")
		public List<? extends IdentifiedCurrency.IdentifiedCurrencyBuilder> getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency(int index) {
			if (settlementCurrency==null) {
				this.settlementCurrency = new ArrayList<>();
			}
			return getIndex(settlementCurrency, index, () -> {
						IdentifiedCurrency.IdentifiedCurrencyBuilder newSettlementCurrency = IdentifiedCurrency.builder();
						return newSettlementCurrency;
					});
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
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
		public GenericProduct.GenericProductBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public GenericProduct.GenericProductBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public GenericProduct.GenericProductBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public GenericProduct.GenericProductBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public GenericProduct.GenericProductBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public GenericProduct.GenericProductBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public GenericProduct.GenericProductBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addProductId(List<? extends ProductId> productIds) {
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
		public GenericProduct.GenericProductBuilder setProductId(List<? extends ProductId> productIds) {
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
		public GenericProduct.GenericProductBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public GenericProduct.GenericProductBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public GenericProduct.GenericProductBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public GenericProduct.GenericProductBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("multiLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiLeg")
		@Override
		public GenericProduct.GenericProductBuilder setMultiLeg(Boolean _multiLeg) {
			this.multiLeg = _multiLeg == null ? null : _multiLeg;
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerPartyReference")
		@Override
		public GenericProduct.GenericProductBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public GenericProduct.GenericProductBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public GenericProduct.GenericProductBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public GenericProduct.GenericProductBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterpartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("counterpartyReference")
		@Override
		public GenericProduct.GenericProductBuilder addCounterpartyReference(PartyReference _counterpartyReference) {
			if (_counterpartyReference != null) {
				this.counterpartyReference.add(_counterpartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addCounterpartyReference(PartyReference _counterpartyReference, int idx) {
			getIndex(this.counterpartyReference, idx, () -> _counterpartyReference.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addCounterpartyReference(List<? extends PartyReference> counterpartyReferences) {
			if (counterpartyReferences != null) {
				for (final PartyReference toAdd : counterpartyReferences) {
					this.counterpartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("counterpartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("counterpartyReference")
		@Override
		public GenericProduct.GenericProductBuilder setCounterpartyReference(List<? extends PartyReference> counterpartyReferences) {
			if (counterpartyReferences == null) {
				this.counterpartyReference = new ArrayList<>();
			} else {
				this.counterpartyReference = counterpartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("premium")
		@Override
		public GenericProduct.GenericProductBuilder setPremium(SimplePayment _premium) {
			this.premium = _premium == null ? null : _premium.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public GenericProduct.GenericProductBuilder setEffectiveDate(AdjustableDate2 _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public GenericProduct.GenericProductBuilder setExpirationDate(AdjustableDate2 _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public GenericProduct.GenericProductBuilder setTerminationDate(AdjustableDate2 _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyer")
		@Override
		public GenericProduct.GenericProductBuilder addUnderlyer(TradeUnderlyer2 _underlyer) {
			if (_underlyer != null) {
				this.underlyer.add(_underlyer.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addUnderlyer(TradeUnderlyer2 _underlyer, int idx) {
			getIndex(this.underlyer, idx, () -> _underlyer.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addUnderlyer(List<? extends TradeUnderlyer2> underlyers) {
			if (underlyers != null) {
				for (final TradeUnderlyer2 toAdd : underlyers) {
					this.underlyer.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyer")
		@Override
		public GenericProduct.GenericProductBuilder setUnderlyer(List<? extends TradeUnderlyer2> underlyers) {
			if (underlyers == null) {
				this.underlyer = new ArrayList<>();
			} else {
				this.underlyer = underlyers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notional")
		@Override
		public GenericProduct.GenericProductBuilder addNotional(CashflowNotional _notional) {
			if (_notional != null) {
				this.notional.add(_notional.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addNotional(CashflowNotional _notional, int idx) {
			getIndex(this.notional, idx, () -> _notional.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addNotional(List<? extends CashflowNotional> notionals) {
			if (notionals != null) {
				for (final CashflowNotional toAdd : notionals) {
					this.notional.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("notional")
		@Override
		public GenericProduct.GenericProductBuilder setNotional(List<? extends CashflowNotional> notionals) {
			if (notionals == null) {
				this.notional = new ArrayList<>();
			} else {
				this.notional = notionals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("grade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("grade")
		@Override
		public GenericProduct.GenericProductBuilder addGrade(GenericCommodityGrade _grade) {
			if (_grade != null) {
				this.grade.add(_grade.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addGrade(GenericCommodityGrade _grade, int idx) {
			getIndex(this.grade, idx, () -> _grade.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addGrade(List<? extends GenericCommodityGrade> grades) {
			if (grades != null) {
				for (final GenericCommodityGrade toAdd : grades) {
					this.grade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("grade")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("grade")
		@Override
		public GenericProduct.GenericProductBuilder setGrade(List<? extends GenericCommodityGrade> grades) {
			if (grades == null) {
				this.grade = new ArrayList<>();
			} else {
				this.grade = grades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriods")
		@Override
		public GenericProduct.GenericProductBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod _settlementPeriods) {
			if (_settlementPeriods != null) {
				this.settlementPeriods.add(_settlementPeriods.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod _settlementPeriods, int idx) {
			getIndex(this.settlementPeriods, idx, () -> _settlementPeriods.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriodss) {
			if (settlementPeriodss != null) {
				for (final GenericCommodityDeliveryPeriod toAdd : settlementPeriodss) {
					this.settlementPeriods.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriods")
		@Override
		public GenericProduct.GenericProductBuilder setSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriodss) {
			if (settlementPeriodss == null) {
				this.settlementPeriods = new ArrayList<>();
			} else {
				this.settlementPeriods = settlementPeriodss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loadType")
		@Override
		public GenericProduct.GenericProductBuilder setLoadType(LoadTypeEnum _loadType) {
			this.loadType = _loadType == null ? null : _loadType;
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantity")
		@Override
		public GenericProduct.GenericProductBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequency")
		@Override
		public GenericProduct.GenericProductBuilder setQuantityFrequency(CommodityQuantityFrequency _quantityFrequency) {
			this.quantityFrequency = _quantityFrequency == null ? null : _quantityFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedPrice")
		@Override
		public GenericProduct.GenericProductBuilder setFixedPrice(CommodityFixedPrice _fixedPrice) {
			this.fixedPrice = _fixedPrice == null ? null : _fixedPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interconnectionPoint")
		@Override
		public GenericProduct.GenericProductBuilder setInterconnectionPoint(InterconnectionPoint _interconnectionPoint) {
			this.interconnectionPoint = _interconnectionPoint == null ? null : _interconnectionPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionEntitlement")
		@Override
		public GenericProduct.GenericProductBuilder setOptionEntitlement(BigDecimal _optionEntitlement) {
			this.optionEntitlement = _optionEntitlement == null ? null : _optionEntitlement;
			return this;
		}
		
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOptions")
		@Override
		public GenericProduct.GenericProductBuilder setNumberOfOptions(BigDecimal _numberOfOptions) {
			this.numberOfOptions = _numberOfOptions == null ? null : _numberOfOptions;
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public GenericProduct.GenericProductBuilder setOptionType(OptionType _optionType) {
			this.optionType = _optionType == null ? null : _optionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commencementDate")
		@Override
		public GenericProduct.GenericProductBuilder setCommencementDate(AdjustableDate2 _commencementDate) {
			this.commencementDate = _commencementDate == null ? null : _commencementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseStyle")
		@Override
		public GenericProduct.GenericProductBuilder setExerciseStyle(GenericExerciseStyle _exerciseStyle) {
			this.exerciseStyle = _exerciseStyle == null ? null : _exerciseStyle.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strike")
		@Override
		public GenericProduct.GenericProductBuilder addStrike(GenericOptionStrike _strike) {
			if (_strike != null) {
				this.strike.add(_strike.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addStrike(GenericOptionStrike _strike, int idx) {
			getIndex(this.strike, idx, () -> _strike.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addStrike(List<? extends GenericOptionStrike> strikes) {
			if (strikes != null) {
				for (final GenericOptionStrike toAdd : strikes) {
					this.strike.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strike")
		@Override
		public GenericProduct.GenericProductBuilder setStrike(List<? extends GenericOptionStrike> strikes) {
			if (strikes == null) {
				this.strike = new ArrayList<>();
			} else {
				this.strike = strikes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public GenericProduct.GenericProductBuilder addFeature(GenericProductFeature _feature) {
			if (_feature != null) {
				this.feature.add(_feature.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addFeature(GenericProductFeature _feature, int idx) {
			getIndex(this.feature, idx, () -> _feature.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addFeature(List<? extends GenericProductFeature> features) {
			if (features != null) {
				for (final GenericProductFeature toAdd : features) {
					this.feature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public GenericProduct.GenericProductBuilder setFeature(List<? extends GenericProductFeature> features) {
			if (features == null) {
				this.feature = new ArrayList<>();
			} else {
				this.feature = features.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("paymentFrequency")
		@Override
		public GenericProduct.GenericProductBuilder addPaymentFrequency(GenericFrequency _paymentFrequency) {
			if (_paymentFrequency != null) {
				this.paymentFrequency.add(_paymentFrequency.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addPaymentFrequency(GenericFrequency _paymentFrequency, int idx) {
			getIndex(this.paymentFrequency, idx, () -> _paymentFrequency.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addPaymentFrequency(List<? extends GenericFrequency> paymentFrequencys) {
			if (paymentFrequencys != null) {
				for (final GenericFrequency toAdd : paymentFrequencys) {
					this.paymentFrequency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("paymentFrequency")
		@Override
		public GenericProduct.GenericProductBuilder setPaymentFrequency(List<? extends GenericFrequency> paymentFrequencys) {
			if (paymentFrequencys == null) {
				this.paymentFrequency = new ArrayList<>();
			} else {
				this.paymentFrequency = paymentFrequencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("resetFrequency")
		@Override
		public GenericProduct.GenericProductBuilder addResetFrequency(GenericResetFrequency _resetFrequency) {
			if (_resetFrequency != null) {
				this.resetFrequency.add(_resetFrequency.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addResetFrequency(GenericResetFrequency _resetFrequency, int idx) {
			getIndex(this.resetFrequency, idx, () -> _resetFrequency.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addResetFrequency(List<? extends GenericResetFrequency> resetFrequencys) {
			if (resetFrequencys != null) {
				for (final GenericResetFrequency toAdd : resetFrequencys) {
					this.resetFrequency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("resetFrequency")
		@Override
		public GenericProduct.GenericProductBuilder setResetFrequency(List<? extends GenericResetFrequency> resetFrequencys) {
			if (resetFrequencys == null) {
				this.resetFrequency = new ArrayList<>();
			} else {
				this.resetFrequency = resetFrequencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementCurrency")
		@Override
		public GenericProduct.GenericProductBuilder addSettlementCurrency(IdentifiedCurrency _settlementCurrency) {
			if (_settlementCurrency != null) {
				this.settlementCurrency.add(_settlementCurrency.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addSettlementCurrency(IdentifiedCurrency _settlementCurrency, int idx) {
			getIndex(this.settlementCurrency, idx, () -> _settlementCurrency.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addSettlementCurrency(List<? extends IdentifiedCurrency> settlementCurrencys) {
			if (settlementCurrencys != null) {
				for (final IdentifiedCurrency toAdd : settlementCurrencys) {
					this.settlementCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementCurrency")
		@Override
		public GenericProduct.GenericProductBuilder setSettlementCurrency(List<? extends IdentifiedCurrency> settlementCurrencys) {
			if (settlementCurrencys == null) {
				this.settlementCurrency = new ArrayList<>();
			} else {
				this.settlementCurrency = settlementCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public GenericProduct.GenericProductBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public GenericProduct.GenericProductBuilder addAdditionalPayment(Payment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addAdditionalPayment(Payment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public GenericProduct.GenericProductBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		public GenericProduct.GenericProductBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		public GenericProduct build() {
			return new GenericProduct.GenericProductImpl(this);
		}
		
		@Override
		public GenericProduct.GenericProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProduct.GenericProductBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			counterpartyReference = counterpartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (premium!=null && !premium.prune().hasData()) premium = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			underlyer = underlyer.stream().filter(b->b!=null).<TradeUnderlyer2.TradeUnderlyer2Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			notional = notional.stream().filter(b->b!=null).<CashflowNotional.CashflowNotionalBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			grade = grade.stream().filter(b->b!=null).<GenericCommodityGrade.GenericCommodityGradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriods = settlementPeriods.stream().filter(b->b!=null).<GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (quantityFrequency!=null && !quantityFrequency.prune().hasData()) quantityFrequency = null;
			if (fixedPrice!=null && !fixedPrice.prune().hasData()) fixedPrice = null;
			if (interconnectionPoint!=null && !interconnectionPoint.prune().hasData()) interconnectionPoint = null;
			if (optionType!=null && !optionType.prune().hasData()) optionType = null;
			if (commencementDate!=null && !commencementDate.prune().hasData()) commencementDate = null;
			if (exerciseStyle!=null && !exerciseStyle.prune().hasData()) exerciseStyle = null;
			strike = strike.stream().filter(b->b!=null).<GenericOptionStrike.GenericOptionStrikeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			feature = feature.stream().filter(b->b!=null).<GenericProductFeature.GenericProductFeatureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			paymentFrequency = paymentFrequency.stream().filter(b->b!=null).<GenericFrequency.GenericFrequencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			resetFrequency = resetFrequency.stream().filter(b->b!=null).<GenericResetFrequency.GenericResetFrequencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementCurrency = settlementCurrency.stream().filter(b->b!=null).<IdentifiedCurrency.IdentifiedCurrencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultiLeg()!=null) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getCounterpartyReference()!=null && getCounterpartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremium()!=null && getPremium().hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotional()!=null && getNotional().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getGrade()!=null && getGrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriods()!=null && getSettlementPeriods().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoadType()!=null) return true;
			if (getQuantity()!=null) return true;
			if (getQuantityFrequency()!=null && getQuantityFrequency().hasData()) return true;
			if (getFixedPrice()!=null && getFixedPrice().hasData()) return true;
			if (getInterconnectionPoint()!=null && getInterconnectionPoint().hasData()) return true;
			if (getOptionEntitlement()!=null) return true;
			if (getNumberOfOptions()!=null) return true;
			if (getOptionType()!=null && getOptionType().hasData()) return true;
			if (getCommencementDate()!=null && getCommencementDate().hasData()) return true;
			if (getExerciseStyle()!=null && getExerciseStyle().hasData()) return true;
			if (getStrike()!=null && getStrike().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFeature()!=null && getFeature().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getResetFrequency()!=null && getResetFrequency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementType()!=null) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProduct.GenericProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GenericProduct.GenericProductBuilder o = (GenericProduct.GenericProductBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getCounterpartyReference(), o.getCounterpartyReference(), this::getOrCreateCounterpartyReference);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::setPremium);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::getOrCreateUnderlyer);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::getOrCreateNotional);
			merger.mergeRosetta(getGrade(), o.getGrade(), this::getOrCreateGrade);
			merger.mergeRosetta(getSettlementPeriods(), o.getSettlementPeriods(), this::getOrCreateSettlementPeriods);
			merger.mergeRosetta(getQuantityFrequency(), o.getQuantityFrequency(), this::setQuantityFrequency);
			merger.mergeRosetta(getFixedPrice(), o.getFixedPrice(), this::setFixedPrice);
			merger.mergeRosetta(getInterconnectionPoint(), o.getInterconnectionPoint(), this::setInterconnectionPoint);
			merger.mergeRosetta(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeRosetta(getCommencementDate(), o.getCommencementDate(), this::setCommencementDate);
			merger.mergeRosetta(getExerciseStyle(), o.getExerciseStyle(), this::setExerciseStyle);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::getOrCreateStrike);
			merger.mergeRosetta(getFeature(), o.getFeature(), this::getOrCreateFeature);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::getOrCreatePaymentFrequency);
			merger.mergeRosetta(getResetFrequency(), o.getResetFrequency(), this::getOrCreateResetFrequency);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::getOrCreateSettlementCurrency);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			
			merger.mergeBasic(getMultiLeg(), o.getMultiLeg(), this::setMultiLeg);
			merger.mergeBasic(getLoadType(), o.getLoadType(), this::setLoadType);
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeBasic(getOptionEntitlement(), o.getOptionEntitlement(), this::setOptionEntitlement);
			merger.mergeBasic(getNumberOfOptions(), o.getNumberOfOptions(), this::setNumberOfOptions);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericProduct _that = getType().cast(o);
		
			if (!Objects.equals(multiLeg, _that.getMultiLeg())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!ListEquals.listEquals(counterpartyReference, _that.getCounterpartyReference())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!ListEquals.listEquals(underlyer, _that.getUnderlyer())) return false;
			if (!ListEquals.listEquals(notional, _that.getNotional())) return false;
			if (!ListEquals.listEquals(grade, _that.getGrade())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!ListEquals.listEquals(strike, _that.getStrike())) return false;
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			if (!ListEquals.listEquals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!ListEquals.listEquals(resetFrequency, _that.getResetFrequency())) return false;
			if (!ListEquals.listEquals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiLeg != null ? multiLeg.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (counterpartyReference != null ? counterpartyReference.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.hashCode() : 0);
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductBuilder {" +
				"multiLeg=" + this.multiLeg + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"counterpartyReference=" + this.counterpartyReference + ", " +
				"premium=" + this.premium + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"notional=" + this.notional + ", " +
				"grade=" + this.grade + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"loadType=" + this.loadType + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"optionType=" + this.optionType + ", " +
				"commencementDate=" + this.commencementDate + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"strike=" + this.strike + ", " +
				"feature=" + this.feature + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementType=" + this.settlementType + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}
