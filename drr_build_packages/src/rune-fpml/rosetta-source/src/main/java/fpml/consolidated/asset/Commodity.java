package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.CommodityMeta;
import fpml.consolidated.fpmlenum.DeliveryDatesEnum;
import fpml.consolidated.fpmlenum.SpecifiedPriceEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.Offset;
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
 * Provision A type describing a commodity underlying asset.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a commodity underlying asset.
 *
 */
@RosettaDataType(value="Commodity", builder=Commodity.CommodityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Commodity", model="fpml", builder=Commodity.CommodityBuilderImpl.class, version="2.1.1")
public interface Commodity extends IdentifiedAsset {

	CommodityMeta metaData = new CommodityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A coding scheme value to identify the base type of the commodity being traded. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions. For example, 'Oil'.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A coding scheme value to identify the base type of the commodity being traded. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions. For example, 'Oil'.
	 *
	 */
	CommodityBase getCommodityBase();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A coding scheme value to identify the commodity being traded more specifically. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions. For example, 'Brent'.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A coding scheme value to identify the commodity being traded more specifically. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions. For example, 'Brent'.
	 *
	 */
	CommodityDetails getCommodityDetails();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the classification of a commodity in the context of an n-layer classification system such as 2005 ISDA Commodity Definitions Sub Annex A or that in Table 4 of the Annex of the Comission Implementing Regulation (EU)laying down implementing technical standards for the application of Regulation (EU) No 648/2012 of the European Parliament and of the Council with regard to the standards, formats, frequency and methods and arrangements for reporting for EMIR Refit.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the classification of a commodity in the context of an n-layer classification system such as 2005 ISDA Commodity Definitions Sub Annex A or that in Table 4 of the Annex of the Comission Implementing Regulation (EU)laying down implementing technical standards for the application of Regulation (EU) No 648/2012 of the European Parliament and of the Council with regard to the standards, formats, frequency and methods and arrangements for reporting for EMIR Refit.
	 *
	 */
	List<? extends CommodityClassification> getCommodityClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A coding scheme value to identify the unit of measure (e.g. Therms) in which the undelryer is denominated. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A coding scheme value to identify the unit of measure (e.g. Therms) in which the undelryer is denominated. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions.
	 *
	 */
	QuantityUnit getUnit();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which the Commodity Reference Price is published (e.g. GBP).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which the Commodity Reference Price is published (e.g. GBP).
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For those commodities being traded with reference to the price of a listed instrument, the exchange where that instrument is listed should be specified in the 'exchange' element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For those commodities being traded with reference to the price of a listed instrument, the exchange where that instrument is listed should be specified in the 'exchange' element.
	 *
	 */
	ExchangeId getExchangeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For those commodities being traded with reference to a price distributed by a publication, that publication should be specified in the 'publication' element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For those commodities being traded with reference to a price distributed by a publication, that publication should be specified in the 'publication' element.
	 *
	 */
	CommodityInformationSource getPublication();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The 'specified Price' describes the nature of the underlying price that is observed. It must be be stated in the underlyer definition as it is not defined in the Commodity Reference Price. Example values of 'specifiedPrice' are 'Settlement' (for a futures contract) and 'WeightedAverage' (for some published prices and indices).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The 'specified Price' describes the nature of the underlying price that is observed. It must be be stated in the underlyer definition as it is not defined in the Commodity Reference Price. Example values of 'specifiedPrice' are 'Settlement' (for a futures contract) and 'WeightedAverage' (for some published prices and indices).
	 *
	 */
	SpecifiedPriceEnum getSpecifiedPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Deprecated: The 'deliveryDates' element is applicable for a Commodity Reference Price that references a listed future contract (e.g. The Delivery Date is a NearbyMonth).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Deprecated: The 'deliveryDates' element is applicable for a Commodity Reference Price that references a listed future contract (e.g. The Delivery Date is a NearbyMonth).
	 *
	 */
	DeliveryDatesEnum getDeliveryDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A container for the parametric representation of nearby contracts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A container for the parametric representation of nearby contracts.
	 *
	 */
	DeliveryNearby getDeliveryNearby();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Delivery Date is a fixed, single day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Delivery Date is a fixed, single day.
	 *
	 */
	AdjustableDate getDeliveryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Delivery Date is a fixed, single month.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Delivery Date is a fixed, single month.
	 *
	 */
	String getDeliveryDateYearMonth();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The 'deliveryDateRollConvention' specifies, for a Commodity Transaction that references a listed future via the 'deliveryDates' element, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 should be specified and so on.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The 'deliveryDateRollConvention' specifies, for a Commodity Transaction that references a listed future via the 'deliveryDates' element, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 should be specified and so on.
	 *
	 */
	Offset getDeliveryDateRollConvention();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The 'deliveryDateExpirationConvention' specifies, for a Commodity Transaction that references a listed future via the 'deliveryDates' element, the day on which the specified future will expire ahead of the actual expiration of the referenced future. For example: Z21 Contract expires on 19Nov21, with an adjust of 2D the "expire" will be 16Nov21. DeliveryDateRollConvention takes precedence. Example: Pricing on the Z21 Contract with NearbyContractDay and a deliveryDateRoll of 10D, Sampling of the F22 Contract will occur on 8Nov21 through the last Date of the Z21 Contract. With an ExpConvention of 5D, the last sampling date on the F22 contract will be 12Nov21.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The 'deliveryDateExpirationConvention' specifies, for a Commodity Transaction that references a listed future via the 'deliveryDates' element, the day on which the specified future will expire ahead of the actual expiration of the referenced future. For example: Z21 Contract expires on 19Nov21, with an adjust of 2D the "expire" will be 16Nov21. DeliveryDateRollConvention takes precedence. Example: Pricing on the Z21 Contract with NearbyContractDay and a deliveryDateRoll of 10D, Sampling of the F22 Contract will occur on 8Nov21 through the last Date of the Z21 Contract. With an ExpConvention of 5D, the last sampling date on the F22 contract will be 12Nov21.
	 *
	 */
	Offset getDeliveryDateExpirationConvention();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The 'multiplier' specifies the multiplier associated with the Transaction. The 'multiplier' element has two uses: (1) for Freight Transactions or any Calculation Period specified for a Freight Transaction, if an amount is specified as the Multiplier then it is captured by this element and (2) if the Transaction is a heat rate option, the heat rate multiplier is represented in this element. If multiplier is not provided, multiplier is assumed to be 1. (i.e. rate source states 1 BBL of Oil as 90 Dollars. Multiplier of 10 will change the value to 900 dollars.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The 'multiplier' specifies the multiplier associated with the Transaction. The 'multiplier' element has two uses: (1) for Freight Transactions or any Calculation Period specified for a Freight Transaction, if an amount is specified as the Multiplier then it is captured by this element and (2) if the Transaction is a heat rate option, the heat rate multiplier is represented in this element. If multiplier is not provided, multiplier is assumed to be 1. (i.e. rate source states 1 BBL of Oil as 90 Dollars. Multiplier of 10 will change the value to 900 dollars.)
	 *
	 */
	BigDecimal getMultiplier();

	/*********************** Build Methods  ***********************/
	Commodity build();
	
	Commodity.CommodityBuilder toBuilder();
	
	static Commodity.CommodityBuilder builder() {
		return new Commodity.CommodityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Commodity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Commodity> getType() {
		return Commodity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("commodityBase"), processor, CommodityBase.class, getCommodityBase());
		processRosetta(path.newSubPath("commodityDetails"), processor, CommodityDetails.class, getCommodityDetails());
		processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.class, getCommodityClassification());
		processRosetta(path.newSubPath("unit"), processor, QuantityUnit.class, getUnit());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("publication"), processor, CommodityInformationSource.class, getPublication());
		processor.processBasic(path.newSubPath("specifiedPrice"), SpecifiedPriceEnum.class, getSpecifiedPrice(), this);
		processor.processBasic(path.newSubPath("deliveryDates"), DeliveryDatesEnum.class, getDeliveryDates(), this);
		processRosetta(path.newSubPath("deliveryNearby"), processor, DeliveryNearby.class, getDeliveryNearby());
		processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableDate.class, getDeliveryDate());
		processor.processBasic(path.newSubPath("deliveryDateYearMonth"), String.class, getDeliveryDateYearMonth(), this);
		processRosetta(path.newSubPath("deliveryDateRollConvention"), processor, Offset.class, getDeliveryDateRollConvention());
		processRosetta(path.newSubPath("deliveryDateExpirationConvention"), processor, Offset.class, getDeliveryDateExpirationConvention());
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBuilder extends Commodity, IdentifiedAsset.IdentifiedAssetBuilder {
		CommodityBase.CommodityBaseBuilder getOrCreateCommodityBase();
		@Override
		CommodityBase.CommodityBaseBuilder getCommodityBase();
		CommodityDetails.CommodityDetailsBuilder getOrCreateCommodityDetails();
		@Override
		CommodityDetails.CommodityDetailsBuilder getCommodityDetails();
		CommodityClassification.CommodityClassificationBuilder getOrCreateCommodityClassification(int index);
		@Override
		List<? extends CommodityClassification.CommodityClassificationBuilder> getCommodityClassification();
		QuantityUnit.QuantityUnitBuilder getOrCreateUnit();
		@Override
		QuantityUnit.QuantityUnitBuilder getUnit();
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		ExchangeId.ExchangeIdBuilder getOrCreateExchangeId();
		@Override
		ExchangeId.ExchangeIdBuilder getExchangeId();
		CommodityInformationSource.CommodityInformationSourceBuilder getOrCreatePublication();
		@Override
		CommodityInformationSource.CommodityInformationSourceBuilder getPublication();
		DeliveryNearby.DeliveryNearbyBuilder getOrCreateDeliveryNearby();
		@Override
		DeliveryNearby.DeliveryNearbyBuilder getDeliveryNearby();
		AdjustableDate.AdjustableDateBuilder getOrCreateDeliveryDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getDeliveryDate();
		Offset.OffsetBuilder getOrCreateDeliveryDateRollConvention();
		@Override
		Offset.OffsetBuilder getDeliveryDateRollConvention();
		Offset.OffsetBuilder getOrCreateDeliveryDateExpirationConvention();
		@Override
		Offset.OffsetBuilder getDeliveryDateExpirationConvention();
		@Override
		Commodity.CommodityBuilder setId(String id);
		@Override
		Commodity.CommodityBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Commodity.CommodityBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Commodity.CommodityBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Commodity.CommodityBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Commodity.CommodityBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		Commodity.CommodityBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		Commodity.CommodityBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Commodity.CommodityBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Commodity.CommodityBuilder setDescription(String description);
		Commodity.CommodityBuilder setCommodityBase(CommodityBase commodityBase);
		Commodity.CommodityBuilder setCommodityDetails(CommodityDetails commodityDetails);
		Commodity.CommodityBuilder addCommodityClassification(CommodityClassification commodityClassification);
		Commodity.CommodityBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		Commodity.CommodityBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		Commodity.CommodityBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		Commodity.CommodityBuilder setUnit(QuantityUnit unit);
		Commodity.CommodityBuilder setCurrency(Currency currency);
		Commodity.CommodityBuilder setExchangeId(ExchangeId exchangeId);
		Commodity.CommodityBuilder setPublication(CommodityInformationSource publication);
		Commodity.CommodityBuilder setSpecifiedPrice(SpecifiedPriceEnum specifiedPrice);
		Commodity.CommodityBuilder setDeliveryDates(DeliveryDatesEnum deliveryDates);
		Commodity.CommodityBuilder setDeliveryNearby(DeliveryNearby deliveryNearby);
		Commodity.CommodityBuilder setDeliveryDate(AdjustableDate deliveryDate);
		Commodity.CommodityBuilder setDeliveryDateYearMonth(String deliveryDateYearMonth);
		Commodity.CommodityBuilder setDeliveryDateRollConvention(Offset deliveryDateRollConvention);
		Commodity.CommodityBuilder setDeliveryDateExpirationConvention(Offset deliveryDateExpirationConvention);
		Commodity.CommodityBuilder setMultiplier(BigDecimal multiplier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("commodityBase"), processor, CommodityBase.CommodityBaseBuilder.class, getCommodityBase());
			processRosetta(path.newSubPath("commodityDetails"), processor, CommodityDetails.CommodityDetailsBuilder.class, getCommodityDetails());
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
			processRosetta(path.newSubPath("unit"), processor, QuantityUnit.QuantityUnitBuilder.class, getUnit());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("publication"), processor, CommodityInformationSource.CommodityInformationSourceBuilder.class, getPublication());
			processor.processBasic(path.newSubPath("specifiedPrice"), SpecifiedPriceEnum.class, getSpecifiedPrice(), this);
			processor.processBasic(path.newSubPath("deliveryDates"), DeliveryDatesEnum.class, getDeliveryDates(), this);
			processRosetta(path.newSubPath("deliveryNearby"), processor, DeliveryNearby.DeliveryNearbyBuilder.class, getDeliveryNearby());
			processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getDeliveryDate());
			processor.processBasic(path.newSubPath("deliveryDateYearMonth"), String.class, getDeliveryDateYearMonth(), this);
			processRosetta(path.newSubPath("deliveryDateRollConvention"), processor, Offset.OffsetBuilder.class, getDeliveryDateRollConvention());
			processRosetta(path.newSubPath("deliveryDateExpirationConvention"), processor, Offset.OffsetBuilder.class, getDeliveryDateExpirationConvention());
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		}
		

		Commodity.CommodityBuilder prune();
	}

	/*********************** Immutable Implementation of Commodity  ***********************/
	class CommodityImpl extends IdentifiedAsset.IdentifiedAssetImpl implements Commodity {
		private final CommodityBase commodityBase;
		private final CommodityDetails commodityDetails;
		private final List<? extends CommodityClassification> commodityClassification;
		private final QuantityUnit unit;
		private final Currency currency;
		private final ExchangeId exchangeId;
		private final CommodityInformationSource publication;
		private final SpecifiedPriceEnum specifiedPrice;
		private final DeliveryDatesEnum deliveryDates;
		private final DeliveryNearby deliveryNearby;
		private final AdjustableDate deliveryDate;
		private final String deliveryDateYearMonth;
		private final Offset deliveryDateRollConvention;
		private final Offset deliveryDateExpirationConvention;
		private final BigDecimal multiplier;
		
		protected CommodityImpl(Commodity.CommodityBuilder builder) {
			super(builder);
			this.commodityBase = ofNullable(builder.getCommodityBase()).map(f->f.build()).orElse(null);
			this.commodityDetails = ofNullable(builder.getCommodityDetails()).map(f->f.build()).orElse(null);
			this.commodityClassification = ofNullable(builder.getCommodityClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.unit = ofNullable(builder.getUnit()).map(f->f.build()).orElse(null);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.exchangeId = ofNullable(builder.getExchangeId()).map(f->f.build()).orElse(null);
			this.publication = ofNullable(builder.getPublication()).map(f->f.build()).orElse(null);
			this.specifiedPrice = builder.getSpecifiedPrice();
			this.deliveryDates = builder.getDeliveryDates();
			this.deliveryNearby = ofNullable(builder.getDeliveryNearby()).map(f->f.build()).orElse(null);
			this.deliveryDate = ofNullable(builder.getDeliveryDate()).map(f->f.build()).orElse(null);
			this.deliveryDateYearMonth = builder.getDeliveryDateYearMonth();
			this.deliveryDateRollConvention = ofNullable(builder.getDeliveryDateRollConvention()).map(f->f.build()).orElse(null);
			this.deliveryDateExpirationConvention = ofNullable(builder.getDeliveryDateExpirationConvention()).map(f->f.build()).orElse(null);
			this.multiplier = builder.getMultiplier();
		}
		
		@Override
		@RosettaAttribute("commodityBase")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityBase")
		public CommodityBase getCommodityBase() {
			return commodityBase;
		}
		
		@Override
		@RosettaAttribute("commodityDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityDetails")
		public CommodityDetails getCommodityDetails() {
			return commodityDetails;
		}
		
		@Override
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("commodityClassification")
		public List<? extends CommodityClassification> getCommodityClassification() {
			return commodityClassification;
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public QuantityUnit getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeId")
		public ExchangeId getExchangeId() {
			return exchangeId;
		}
		
		@Override
		@RosettaAttribute("publication")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publication")
		public CommodityInformationSource getPublication() {
			return publication;
		}
		
		@Override
		@RosettaAttribute("specifiedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specifiedPrice")
		public SpecifiedPriceEnum getSpecifiedPrice() {
			return specifiedPrice;
		}
		
		@Override
		@RosettaAttribute("deliveryDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDates")
		public DeliveryDatesEnum getDeliveryDates() {
			return deliveryDates;
		}
		
		@Override
		@RosettaAttribute("deliveryNearby")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryNearby")
		public DeliveryNearby getDeliveryNearby() {
			return deliveryNearby;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDate")
		public AdjustableDate getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		@RosettaAttribute("deliveryDateYearMonth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDateYearMonth")
		public String getDeliveryDateYearMonth() {
			return deliveryDateYearMonth;
		}
		
		@Override
		@RosettaAttribute("deliveryDateRollConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDateRollConvention")
		public Offset getDeliveryDateRollConvention() {
			return deliveryDateRollConvention;
		}
		
		@Override
		@RosettaAttribute("deliveryDateExpirationConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDateExpirationConvention")
		public Offset getDeliveryDateExpirationConvention() {
			return deliveryDateExpirationConvention;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		public Commodity build() {
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder toBuilder() {
			Commodity.CommodityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Commodity.CommodityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityBase()).ifPresent(builder::setCommodityBase);
			ofNullable(getCommodityDetails()).ifPresent(builder::setCommodityDetails);
			ofNullable(getCommodityClassification()).ifPresent(builder::setCommodityClassification);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getExchangeId()).ifPresent(builder::setExchangeId);
			ofNullable(getPublication()).ifPresent(builder::setPublication);
			ofNullable(getSpecifiedPrice()).ifPresent(builder::setSpecifiedPrice);
			ofNullable(getDeliveryDates()).ifPresent(builder::setDeliveryDates);
			ofNullable(getDeliveryNearby()).ifPresent(builder::setDeliveryNearby);
			ofNullable(getDeliveryDate()).ifPresent(builder::setDeliveryDate);
			ofNullable(getDeliveryDateYearMonth()).ifPresent(builder::setDeliveryDateYearMonth);
			ofNullable(getDeliveryDateRollConvention()).ifPresent(builder::setDeliveryDateRollConvention);
			ofNullable(getDeliveryDateExpirationConvention()).ifPresent(builder::setDeliveryDateExpirationConvention);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Commodity _that = getType().cast(o);
		
			if (!Objects.equals(commodityBase, _that.getCommodityBase())) return false;
			if (!Objects.equals(commodityDetails, _that.getCommodityDetails())) return false;
			if (!ListEquals.listEquals(commodityClassification, _that.getCommodityClassification())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(publication, _that.getPublication())) return false;
			if (!Objects.equals(specifiedPrice, _that.getSpecifiedPrice())) return false;
			if (!Objects.equals(deliveryDates, _that.getDeliveryDates())) return false;
			if (!Objects.equals(deliveryNearby, _that.getDeliveryNearby())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!Objects.equals(deliveryDateYearMonth, _that.getDeliveryDateYearMonth())) return false;
			if (!Objects.equals(deliveryDateRollConvention, _that.getDeliveryDateRollConvention())) return false;
			if (!Objects.equals(deliveryDateExpirationConvention, _that.getDeliveryDateExpirationConvention())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityBase != null ? commodityBase.hashCode() : 0);
			_result = 31 * _result + (commodityDetails != null ? commodityDetails.hashCode() : 0);
			_result = 31 * _result + (commodityClassification != null ? commodityClassification.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (publication != null ? publication.hashCode() : 0);
			_result = 31 * _result + (specifiedPrice != null ? specifiedPrice.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryDates != null ? deliveryDates.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryNearby != null ? deliveryNearby.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (deliveryDateYearMonth != null ? deliveryDateYearMonth.hashCode() : 0);
			_result = 31 * _result + (deliveryDateRollConvention != null ? deliveryDateRollConvention.hashCode() : 0);
			_result = 31 * _result + (deliveryDateExpirationConvention != null ? deliveryDateExpirationConvention.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Commodity {" +
				"commodityBase=" + this.commodityBase + ", " +
				"commodityDetails=" + this.commodityDetails + ", " +
				"commodityClassification=" + this.commodityClassification + ", " +
				"unit=" + this.unit + ", " +
				"currency=" + this.currency + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"publication=" + this.publication + ", " +
				"specifiedPrice=" + this.specifiedPrice + ", " +
				"deliveryDates=" + this.deliveryDates + ", " +
				"deliveryNearby=" + this.deliveryNearby + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"deliveryDateYearMonth=" + this.deliveryDateYearMonth + ", " +
				"deliveryDateRollConvention=" + this.deliveryDateRollConvention + ", " +
				"deliveryDateExpirationConvention=" + this.deliveryDateExpirationConvention + ", " +
				"multiplier=" + this.multiplier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Commodity  ***********************/
	class CommodityBuilderImpl extends IdentifiedAsset.IdentifiedAssetBuilderImpl implements Commodity.CommodityBuilder {
	
		protected CommodityBase.CommodityBaseBuilder commodityBase;
		protected CommodityDetails.CommodityDetailsBuilder commodityDetails;
		protected List<CommodityClassification.CommodityClassificationBuilder> commodityClassification = new ArrayList<>();
		protected QuantityUnit.QuantityUnitBuilder unit;
		protected Currency.CurrencyBuilder currency;
		protected ExchangeId.ExchangeIdBuilder exchangeId;
		protected CommodityInformationSource.CommodityInformationSourceBuilder publication;
		protected SpecifiedPriceEnum specifiedPrice;
		protected DeliveryDatesEnum deliveryDates;
		protected DeliveryNearby.DeliveryNearbyBuilder deliveryNearby;
		protected AdjustableDate.AdjustableDateBuilder deliveryDate;
		protected String deliveryDateYearMonth;
		protected Offset.OffsetBuilder deliveryDateRollConvention;
		protected Offset.OffsetBuilder deliveryDateExpirationConvention;
		protected BigDecimal multiplier;
		
		@Override
		@RosettaAttribute("commodityBase")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityBase")
		public CommodityBase.CommodityBaseBuilder getCommodityBase() {
			return commodityBase;
		}
		
		@Override
		public CommodityBase.CommodityBaseBuilder getOrCreateCommodityBase() {
			CommodityBase.CommodityBaseBuilder result;
			if (commodityBase!=null) {
				result = commodityBase;
			}
			else {
				result = commodityBase = CommodityBase.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityDetails")
		public CommodityDetails.CommodityDetailsBuilder getCommodityDetails() {
			return commodityDetails;
		}
		
		@Override
		public CommodityDetails.CommodityDetailsBuilder getOrCreateCommodityDetails() {
			CommodityDetails.CommodityDetailsBuilder result;
			if (commodityDetails!=null) {
				result = commodityDetails;
			}
			else {
				result = commodityDetails = CommodityDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("commodityClassification")
		public List<? extends CommodityClassification.CommodityClassificationBuilder> getCommodityClassification() {
			return commodityClassification;
		}
		
		@Override
		public CommodityClassification.CommodityClassificationBuilder getOrCreateCommodityClassification(int index) {
			if (commodityClassification==null) {
				this.commodityClassification = new ArrayList<>();
			}
			return getIndex(commodityClassification, index, () -> {
						CommodityClassification.CommodityClassificationBuilder newCommodityClassification = CommodityClassification.builder();
						return newCommodityClassification;
					});
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public QuantityUnit.QuantityUnitBuilder getUnit() {
			return unit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (unit!=null) {
				result = unit;
			}
			else {
				result = unit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeId")
		public ExchangeId.ExchangeIdBuilder getExchangeId() {
			return exchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateExchangeId() {
			ExchangeId.ExchangeIdBuilder result;
			if (exchangeId!=null) {
				result = exchangeId;
			}
			else {
				result = exchangeId = ExchangeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publication")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publication")
		public CommodityInformationSource.CommodityInformationSourceBuilder getPublication() {
			return publication;
		}
		
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder getOrCreatePublication() {
			CommodityInformationSource.CommodityInformationSourceBuilder result;
			if (publication!=null) {
				result = publication;
			}
			else {
				result = publication = CommodityInformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specifiedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specifiedPrice")
		public SpecifiedPriceEnum getSpecifiedPrice() {
			return specifiedPrice;
		}
		
		@Override
		@RosettaAttribute("deliveryDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDates")
		public DeliveryDatesEnum getDeliveryDates() {
			return deliveryDates;
		}
		
		@Override
		@RosettaAttribute("deliveryNearby")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryNearby")
		public DeliveryNearby.DeliveryNearbyBuilder getDeliveryNearby() {
			return deliveryNearby;
		}
		
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder getOrCreateDeliveryNearby() {
			DeliveryNearby.DeliveryNearbyBuilder result;
			if (deliveryNearby!=null) {
				result = deliveryNearby;
			}
			else {
				result = deliveryNearby = DeliveryNearby.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDate")
		public AdjustableDate.AdjustableDateBuilder getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateDeliveryDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (deliveryDate!=null) {
				result = deliveryDate;
			}
			else {
				result = deliveryDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryDateYearMonth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDateYearMonth")
		public String getDeliveryDateYearMonth() {
			return deliveryDateYearMonth;
		}
		
		@Override
		@RosettaAttribute("deliveryDateRollConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDateRollConvention")
		public Offset.OffsetBuilder getDeliveryDateRollConvention() {
			return deliveryDateRollConvention;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateDeliveryDateRollConvention() {
			Offset.OffsetBuilder result;
			if (deliveryDateRollConvention!=null) {
				result = deliveryDateRollConvention;
			}
			else {
				result = deliveryDateRollConvention = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryDateExpirationConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDateExpirationConvention")
		public Offset.OffsetBuilder getDeliveryDateExpirationConvention() {
			return deliveryDateExpirationConvention;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateDeliveryDateExpirationConvention() {
			Offset.OffsetBuilder result;
			if (deliveryDateExpirationConvention!=null) {
				result = deliveryDateExpirationConvention;
			}
			else {
				result = deliveryDateExpirationConvention = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Commodity.CommodityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Commodity.CommodityBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Commodity.CommodityBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public Commodity.CommodityBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public Commodity.CommodityBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public Commodity.CommodityBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("commodityBase")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityBase")
		@Override
		public Commodity.CommodityBuilder setCommodityBase(CommodityBase _commodityBase) {
			this.commodityBase = _commodityBase == null ? null : _commodityBase.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityDetails")
		@Override
		public Commodity.CommodityBuilder setCommodityDetails(CommodityDetails _commodityDetails) {
			this.commodityDetails = _commodityDetails == null ? null : _commodityDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public Commodity.CommodityBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications != null) {
				for (final CommodityClassification toAdd : commodityClassifications) {
					this.commodityClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public Commodity.CommodityBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications == null) {
				this.commodityClassification = new ArrayList<>();
			} else {
				this.commodityClassification = commodityClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("unit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unit")
		@Override
		public Commodity.CommodityBuilder setUnit(QuantityUnit _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Commodity.CommodityBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public Commodity.CommodityBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publication")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("publication")
		@Override
		public Commodity.CommodityBuilder setPublication(CommodityInformationSource _publication) {
			this.publication = _publication == null ? null : _publication.toBuilder();
			return this;
		}
		
		@RosettaAttribute("specifiedPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specifiedPrice")
		@Override
		public Commodity.CommodityBuilder setSpecifiedPrice(SpecifiedPriceEnum _specifiedPrice) {
			this.specifiedPrice = _specifiedPrice == null ? null : _specifiedPrice;
			return this;
		}
		
		@RosettaAttribute("deliveryDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryDates")
		@Override
		public Commodity.CommodityBuilder setDeliveryDates(DeliveryDatesEnum _deliveryDates) {
			this.deliveryDates = _deliveryDates == null ? null : _deliveryDates;
			return this;
		}
		
		@RosettaAttribute("deliveryNearby")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryNearby")
		@Override
		public Commodity.CommodityBuilder setDeliveryNearby(DeliveryNearby _deliveryNearby) {
			this.deliveryNearby = _deliveryNearby == null ? null : _deliveryNearby.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryDate")
		@Override
		public Commodity.CommodityBuilder setDeliveryDate(AdjustableDate _deliveryDate) {
			this.deliveryDate = _deliveryDate == null ? null : _deliveryDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryDateYearMonth")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryDateYearMonth")
		@Override
		public Commodity.CommodityBuilder setDeliveryDateYearMonth(String _deliveryDateYearMonth) {
			this.deliveryDateYearMonth = _deliveryDateYearMonth == null ? null : _deliveryDateYearMonth;
			return this;
		}
		
		@RosettaAttribute("deliveryDateRollConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryDateRollConvention")
		@Override
		public Commodity.CommodityBuilder setDeliveryDateRollConvention(Offset _deliveryDateRollConvention) {
			this.deliveryDateRollConvention = _deliveryDateRollConvention == null ? null : _deliveryDateRollConvention.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryDateExpirationConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryDateExpirationConvention")
		@Override
		public Commodity.CommodityBuilder setDeliveryDateExpirationConvention(Offset _deliveryDateExpirationConvention) {
			this.deliveryDateExpirationConvention = _deliveryDateExpirationConvention == null ? null : _deliveryDateExpirationConvention.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public Commodity.CommodityBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@Override
		public Commodity build() {
			return new Commodity.CommodityImpl(this);
		}
		
		@Override
		public Commodity.CommodityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commodity.CommodityBuilder prune() {
			super.prune();
			if (commodityBase!=null && !commodityBase.prune().hasData()) commodityBase = null;
			if (commodityDetails!=null && !commodityDetails.prune().hasData()) commodityDetails = null;
			commodityClassification = commodityClassification.stream().filter(b->b!=null).<CommodityClassification.CommodityClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (unit!=null && !unit.prune().hasData()) unit = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (exchangeId!=null && !exchangeId.prune().hasData()) exchangeId = null;
			if (publication!=null && !publication.prune().hasData()) publication = null;
			if (deliveryNearby!=null && !deliveryNearby.prune().hasData()) deliveryNearby = null;
			if (deliveryDate!=null && !deliveryDate.prune().hasData()) deliveryDate = null;
			if (deliveryDateRollConvention!=null && !deliveryDateRollConvention.prune().hasData()) deliveryDateRollConvention = null;
			if (deliveryDateExpirationConvention!=null && !deliveryDateExpirationConvention.prune().hasData()) deliveryDateExpirationConvention = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityBase()!=null && getCommodityBase().hasData()) return true;
			if (getCommodityDetails()!=null && getCommodityDetails().hasData()) return true;
			if (getCommodityClassification()!=null && getCommodityClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getUnit()!=null && getUnit().hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getExchangeId()!=null && getExchangeId().hasData()) return true;
			if (getPublication()!=null && getPublication().hasData()) return true;
			if (getSpecifiedPrice()!=null) return true;
			if (getDeliveryDates()!=null) return true;
			if (getDeliveryNearby()!=null && getDeliveryNearby().hasData()) return true;
			if (getDeliveryDate()!=null && getDeliveryDate().hasData()) return true;
			if (getDeliveryDateYearMonth()!=null) return true;
			if (getDeliveryDateRollConvention()!=null && getDeliveryDateRollConvention().hasData()) return true;
			if (getDeliveryDateExpirationConvention()!=null && getDeliveryDateExpirationConvention().hasData()) return true;
			if (getMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commodity.CommodityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Commodity.CommodityBuilder o = (Commodity.CommodityBuilder) other;
			
			merger.mergeRosetta(getCommodityBase(), o.getCommodityBase(), this::setCommodityBase);
			merger.mergeRosetta(getCommodityDetails(), o.getCommodityDetails(), this::setCommodityDetails);
			merger.mergeRosetta(getCommodityClassification(), o.getCommodityClassification(), this::getOrCreateCommodityClassification);
			merger.mergeRosetta(getUnit(), o.getUnit(), this::setUnit);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getExchangeId(), o.getExchangeId(), this::setExchangeId);
			merger.mergeRosetta(getPublication(), o.getPublication(), this::setPublication);
			merger.mergeRosetta(getDeliveryNearby(), o.getDeliveryNearby(), this::setDeliveryNearby);
			merger.mergeRosetta(getDeliveryDate(), o.getDeliveryDate(), this::setDeliveryDate);
			merger.mergeRosetta(getDeliveryDateRollConvention(), o.getDeliveryDateRollConvention(), this::setDeliveryDateRollConvention);
			merger.mergeRosetta(getDeliveryDateExpirationConvention(), o.getDeliveryDateExpirationConvention(), this::setDeliveryDateExpirationConvention);
			
			merger.mergeBasic(getSpecifiedPrice(), o.getSpecifiedPrice(), this::setSpecifiedPrice);
			merger.mergeBasic(getDeliveryDates(), o.getDeliveryDates(), this::setDeliveryDates);
			merger.mergeBasic(getDeliveryDateYearMonth(), o.getDeliveryDateYearMonth(), this::setDeliveryDateYearMonth);
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Commodity _that = getType().cast(o);
		
			if (!Objects.equals(commodityBase, _that.getCommodityBase())) return false;
			if (!Objects.equals(commodityDetails, _that.getCommodityDetails())) return false;
			if (!ListEquals.listEquals(commodityClassification, _that.getCommodityClassification())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(publication, _that.getPublication())) return false;
			if (!Objects.equals(specifiedPrice, _that.getSpecifiedPrice())) return false;
			if (!Objects.equals(deliveryDates, _that.getDeliveryDates())) return false;
			if (!Objects.equals(deliveryNearby, _that.getDeliveryNearby())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!Objects.equals(deliveryDateYearMonth, _that.getDeliveryDateYearMonth())) return false;
			if (!Objects.equals(deliveryDateRollConvention, _that.getDeliveryDateRollConvention())) return false;
			if (!Objects.equals(deliveryDateExpirationConvention, _that.getDeliveryDateExpirationConvention())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityBase != null ? commodityBase.hashCode() : 0);
			_result = 31 * _result + (commodityDetails != null ? commodityDetails.hashCode() : 0);
			_result = 31 * _result + (commodityClassification != null ? commodityClassification.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (publication != null ? publication.hashCode() : 0);
			_result = 31 * _result + (specifiedPrice != null ? specifiedPrice.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryDates != null ? deliveryDates.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryNearby != null ? deliveryNearby.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (deliveryDateYearMonth != null ? deliveryDateYearMonth.hashCode() : 0);
			_result = 31 * _result + (deliveryDateRollConvention != null ? deliveryDateRollConvention.hashCode() : 0);
			_result = 31 * _result + (deliveryDateExpirationConvention != null ? deliveryDateExpirationConvention.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBuilder {" +
				"commodityBase=" + this.commodityBase + ", " +
				"commodityDetails=" + this.commodityDetails + ", " +
				"commodityClassification=" + this.commodityClassification + ", " +
				"unit=" + this.unit + ", " +
				"currency=" + this.currency + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"publication=" + this.publication + ", " +
				"specifiedPrice=" + this.specifiedPrice + ", " +
				"deliveryDates=" + this.deliveryDates + ", " +
				"deliveryNearby=" + this.deliveryNearby + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"deliveryDateYearMonth=" + this.deliveryDateYearMonth + ", " +
				"deliveryDateRollConvention=" + this.deliveryDateRollConvention + ", " +
				"deliveryDateExpirationConvention=" + this.deliveryDateExpirationConvention + ", " +
				"multiplier=" + this.multiplier +
			'}' + " " + super.toString();
		}
	}
}
