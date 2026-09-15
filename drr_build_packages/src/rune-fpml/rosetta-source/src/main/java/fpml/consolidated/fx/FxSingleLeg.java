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
import fpml.consolidated.fpmlenum.DealtCurrencyEnum;
import fpml.consolidated.fpmlenum.FxTenorPeriodEnum;
import fpml.consolidated.fx.meta.FxSingleLegMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
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
 * Provision A type defining either a spot or forward FX transactions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining either a spot or forward FX transactions.
 *
 */
@RosettaDataType(value="FxSingleLeg", builder=FxSingleLeg.FxSingleLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxSingleLeg", model="fpml", builder=FxSingleLeg.FxSingleLegBuilderImpl.class, version="2.1.1")
public interface FxSingleLeg extends Product {

	FxSingleLegMeta metaData = new FxSingleLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This is the first of the two currency flows that define a single leg of a standard foreign exchange transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This is the first of the two currency flows that define a single leg of a standard foreign exchange transaction.
	 *
	 */
	Payment getExchangedCurrency1();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This is the second of the two currency flows that define a single leg of a standard foreign exchange transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This is the second of the two currency flows that define a single leg of a standard foreign exchange transaction.
	 *
	 */
	Payment getExchangedCurrency2();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates which currency was dealt.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates which currency was dealt.
	 *
	 */
	DealtCurrencyEnum getDealtCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A tenor expressed with a standard business term (i.e. Spot, TomorrowNext, etc.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A tenor expressed with a standard business term (i.e. Spot, TomorrowNext, etc.)
	 *
	 */
	FxTenorPeriodEnum getTenorName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
	 *
	 */
	Period getTenorPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which both currencies traded will settle.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which both currencies traded will settle.
	 *
	 */
	ZonedDateTime getValueDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the currency1 amount will be settled. To be used in a split value date scenario.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the currency1 amount will be settled. To be used in a split value date scenario.
	 *
	 */
	ZonedDateTime getCurrency1ValueDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the currency2 amount will be settled. To be used in a split value date scenario.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the currency2 amount will be settled. To be used in a split value date scenario.
	 *
	 */
	ZonedDateTime getCurrency2ValueDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rate of exchange between the two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate of exchange between the two currencies.
	 *
	 */
	ExchangeRate getExchangeRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe a particular type of FX forward transaction that is settled in a single currency (for example, a non-deliverable forward).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to describe a particular type of FX forward transaction that is settled in a single currency (for example, a non-deliverable forward).
	 *
	 */
	FxCashSettlement getNonDeliverableSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the disruption events and fallbacks applicable to a currency pair referenced by the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the disruption events and fallbacks applicable to a currency pair referenced by the transaction.
	 *
	 */
	List<? extends FxDisruption> getDisruption();

	/*********************** Build Methods  ***********************/
	FxSingleLeg build();
	
	FxSingleLeg.FxSingleLegBuilder toBuilder();
	
	static FxSingleLeg.FxSingleLegBuilder builder() {
		return new FxSingleLeg.FxSingleLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSingleLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxSingleLeg> getType() {
		return FxSingleLeg.class;
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
		processRosetta(path.newSubPath("exchangedCurrency1"), processor, Payment.class, getExchangedCurrency1());
		processRosetta(path.newSubPath("exchangedCurrency2"), processor, Payment.class, getExchangedCurrency2());
		processor.processBasic(path.newSubPath("dealtCurrency"), DealtCurrencyEnum.class, getDealtCurrency(), this);
		processor.processBasic(path.newSubPath("tenorName"), FxTenorPeriodEnum.class, getTenorName(), this);
		processRosetta(path.newSubPath("tenorPeriod"), processor, Period.class, getTenorPeriod());
		processor.processBasic(path.newSubPath("valueDate"), ZonedDateTime.class, getValueDate(), this);
		processor.processBasic(path.newSubPath("currency1ValueDate"), ZonedDateTime.class, getCurrency1ValueDate(), this);
		processor.processBasic(path.newSubPath("currency2ValueDate"), ZonedDateTime.class, getCurrency2ValueDate(), this);
		processRosetta(path.newSubPath("exchangeRate"), processor, ExchangeRate.class, getExchangeRate());
		processRosetta(path.newSubPath("nonDeliverableSettlement"), processor, FxCashSettlement.class, getNonDeliverableSettlement());
		processRosetta(path.newSubPath("disruption"), processor, FxDisruption.class, getDisruption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSingleLegBuilder extends FxSingleLeg, Product.ProductBuilder {
		Payment.PaymentBuilder getOrCreateExchangedCurrency1();
		@Override
		Payment.PaymentBuilder getExchangedCurrency1();
		Payment.PaymentBuilder getOrCreateExchangedCurrency2();
		@Override
		Payment.PaymentBuilder getExchangedCurrency2();
		Period.PeriodBuilder getOrCreateTenorPeriod();
		@Override
		Period.PeriodBuilder getTenorPeriod();
		ExchangeRate.ExchangeRateBuilder getOrCreateExchangeRate();
		@Override
		ExchangeRate.ExchangeRateBuilder getExchangeRate();
		FxCashSettlement.FxCashSettlementBuilder getOrCreateNonDeliverableSettlement();
		@Override
		FxCashSettlement.FxCashSettlementBuilder getNonDeliverableSettlement();
		FxDisruption.FxDisruptionBuilder getOrCreateDisruption(int index);
		@Override
		List<? extends FxDisruption.FxDisruptionBuilder> getDisruption();
		@Override
		FxSingleLeg.FxSingleLegBuilder setId(String id);
		@Override
		FxSingleLeg.FxSingleLegBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxSingleLeg.FxSingleLegBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxSingleLeg.FxSingleLegBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxSingleLeg.FxSingleLegBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxSingleLeg.FxSingleLegBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxSingleLeg.FxSingleLegBuilder addProductType(ProductType productType);
		@Override
		FxSingleLeg.FxSingleLegBuilder addProductType(ProductType productType, int idx);
		@Override
		FxSingleLeg.FxSingleLegBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxSingleLeg.FxSingleLegBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxSingleLeg.FxSingleLegBuilder addProductId(ProductId productId);
		@Override
		FxSingleLeg.FxSingleLegBuilder addProductId(ProductId productId, int idx);
		@Override
		FxSingleLeg.FxSingleLegBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxSingleLeg.FxSingleLegBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxSingleLeg.FxSingleLegBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxSingleLeg.FxSingleLegBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxSingleLeg.FxSingleLegBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxSingleLeg.FxSingleLegBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxSingleLeg.FxSingleLegBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxSingleLeg.FxSingleLegBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxSingleLeg.FxSingleLegBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxSingleLeg.FxSingleLegBuilder setAssetClass(List<? extends AssetClass> assetClass);
		FxSingleLeg.FxSingleLegBuilder setExchangedCurrency1(Payment exchangedCurrency1);
		FxSingleLeg.FxSingleLegBuilder setExchangedCurrency2(Payment exchangedCurrency2);
		FxSingleLeg.FxSingleLegBuilder setDealtCurrency(DealtCurrencyEnum dealtCurrency);
		FxSingleLeg.FxSingleLegBuilder setTenorName(FxTenorPeriodEnum tenorName);
		FxSingleLeg.FxSingleLegBuilder setTenorPeriod(Period tenorPeriod);
		FxSingleLeg.FxSingleLegBuilder setValueDate(ZonedDateTime valueDate);
		FxSingleLeg.FxSingleLegBuilder setCurrency1ValueDate(ZonedDateTime currency1ValueDate);
		FxSingleLeg.FxSingleLegBuilder setCurrency2ValueDate(ZonedDateTime currency2ValueDate);
		FxSingleLeg.FxSingleLegBuilder setExchangeRate(ExchangeRate exchangeRate);
		FxSingleLeg.FxSingleLegBuilder setNonDeliverableSettlement(FxCashSettlement nonDeliverableSettlement);
		FxSingleLeg.FxSingleLegBuilder addDisruption(FxDisruption disruption);
		FxSingleLeg.FxSingleLegBuilder addDisruption(FxDisruption disruption, int idx);
		FxSingleLeg.FxSingleLegBuilder addDisruption(List<? extends FxDisruption> disruption);
		FxSingleLeg.FxSingleLegBuilder setDisruption(List<? extends FxDisruption> disruption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("exchangedCurrency1"), processor, Payment.PaymentBuilder.class, getExchangedCurrency1());
			processRosetta(path.newSubPath("exchangedCurrency2"), processor, Payment.PaymentBuilder.class, getExchangedCurrency2());
			processor.processBasic(path.newSubPath("dealtCurrency"), DealtCurrencyEnum.class, getDealtCurrency(), this);
			processor.processBasic(path.newSubPath("tenorName"), FxTenorPeriodEnum.class, getTenorName(), this);
			processRosetta(path.newSubPath("tenorPeriod"), processor, Period.PeriodBuilder.class, getTenorPeriod());
			processor.processBasic(path.newSubPath("valueDate"), ZonedDateTime.class, getValueDate(), this);
			processor.processBasic(path.newSubPath("currency1ValueDate"), ZonedDateTime.class, getCurrency1ValueDate(), this);
			processor.processBasic(path.newSubPath("currency2ValueDate"), ZonedDateTime.class, getCurrency2ValueDate(), this);
			processRosetta(path.newSubPath("exchangeRate"), processor, ExchangeRate.ExchangeRateBuilder.class, getExchangeRate());
			processRosetta(path.newSubPath("nonDeliverableSettlement"), processor, FxCashSettlement.FxCashSettlementBuilder.class, getNonDeliverableSettlement());
			processRosetta(path.newSubPath("disruption"), processor, FxDisruption.FxDisruptionBuilder.class, getDisruption());
		}
		

		FxSingleLeg.FxSingleLegBuilder prune();
	}

	/*********************** Immutable Implementation of FxSingleLeg  ***********************/
	class FxSingleLegImpl extends Product.ProductImpl implements FxSingleLeg {
		private final Payment exchangedCurrency1;
		private final Payment exchangedCurrency2;
		private final DealtCurrencyEnum dealtCurrency;
		private final FxTenorPeriodEnum tenorName;
		private final Period tenorPeriod;
		private final ZonedDateTime valueDate;
		private final ZonedDateTime currency1ValueDate;
		private final ZonedDateTime currency2ValueDate;
		private final ExchangeRate exchangeRate;
		private final FxCashSettlement nonDeliverableSettlement;
		private final List<? extends FxDisruption> disruption;
		
		protected FxSingleLegImpl(FxSingleLeg.FxSingleLegBuilder builder) {
			super(builder);
			this.exchangedCurrency1 = ofNullable(builder.getExchangedCurrency1()).map(f->f.build()).orElse(null);
			this.exchangedCurrency2 = ofNullable(builder.getExchangedCurrency2()).map(f->f.build()).orElse(null);
			this.dealtCurrency = builder.getDealtCurrency();
			this.tenorName = builder.getTenorName();
			this.tenorPeriod = ofNullable(builder.getTenorPeriod()).map(f->f.build()).orElse(null);
			this.valueDate = builder.getValueDate();
			this.currency1ValueDate = builder.getCurrency1ValueDate();
			this.currency2ValueDate = builder.getCurrency2ValueDate();
			this.exchangeRate = ofNullable(builder.getExchangeRate()).map(f->f.build()).orElse(null);
			this.nonDeliverableSettlement = ofNullable(builder.getNonDeliverableSettlement()).map(f->f.build()).orElse(null);
			this.disruption = ofNullable(builder.getDisruption()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency1")
		public Payment getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency2")
		public Payment getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		@RosettaAttribute("dealtCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealtCurrency")
		public DealtCurrencyEnum getDealtCurrency() {
			return dealtCurrency;
		}
		
		@Override
		@RosettaAttribute("tenorName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorName")
		public FxTenorPeriodEnum getTenorName() {
			return tenorName;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorPeriod")
		public Period getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valueDate")
		public ZonedDateTime getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("currency1ValueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency1ValueDate")
		public ZonedDateTime getCurrency1ValueDate() {
			return currency1ValueDate;
		}
		
		@Override
		@RosettaAttribute("currency2ValueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency2ValueDate")
		public ZonedDateTime getCurrency2ValueDate() {
			return currency2ValueDate;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRate")
		public ExchangeRate getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		@RosettaAttribute("nonDeliverableSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonDeliverableSettlement")
		public FxCashSettlement getNonDeliverableSettlement() {
			return nonDeliverableSettlement;
		}
		
		@Override
		@RosettaAttribute("disruption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("disruption")
		public List<? extends FxDisruption> getDisruption() {
			return disruption;
		}
		
		@Override
		public FxSingleLeg build() {
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder toBuilder() {
			FxSingleLeg.FxSingleLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSingleLeg.FxSingleLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExchangedCurrency1()).ifPresent(builder::setExchangedCurrency1);
			ofNullable(getExchangedCurrency2()).ifPresent(builder::setExchangedCurrency2);
			ofNullable(getDealtCurrency()).ifPresent(builder::setDealtCurrency);
			ofNullable(getTenorName()).ifPresent(builder::setTenorName);
			ofNullable(getTenorPeriod()).ifPresent(builder::setTenorPeriod);
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
			ofNullable(getCurrency1ValueDate()).ifPresent(builder::setCurrency1ValueDate);
			ofNullable(getCurrency2ValueDate()).ifPresent(builder::setCurrency2ValueDate);
			ofNullable(getExchangeRate()).ifPresent(builder::setExchangeRate);
			ofNullable(getNonDeliverableSettlement()).ifPresent(builder::setNonDeliverableSettlement);
			ofNullable(getDisruption()).ifPresent(builder::setDisruption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSingleLeg _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			if (!Objects.equals(dealtCurrency, _that.getDealtCurrency())) return false;
			if (!Objects.equals(tenorName, _that.getTenorName())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!Objects.equals(currency1ValueDate, _that.getCurrency1ValueDate())) return false;
			if (!Objects.equals(currency2ValueDate, _that.getCurrency2ValueDate())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(nonDeliverableSettlement, _that.getNonDeliverableSettlement())) return false;
			if (!ListEquals.listEquals(disruption, _that.getDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			_result = 31 * _result + (dealtCurrency != null ? dealtCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorName != null ? tenorName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (currency1ValueDate != null ? currency1ValueDate.hashCode() : 0);
			_result = 31 * _result + (currency2ValueDate != null ? currency2ValueDate.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSettlement != null ? nonDeliverableSettlement.hashCode() : 0);
			_result = 31 * _result + (disruption != null ? disruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSingleLeg {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 + ", " +
				"dealtCurrency=" + this.dealtCurrency + ", " +
				"tenorName=" + this.tenorName + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"valueDate=" + this.valueDate + ", " +
				"currency1ValueDate=" + this.currency1ValueDate + ", " +
				"currency2ValueDate=" + this.currency2ValueDate + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"nonDeliverableSettlement=" + this.nonDeliverableSettlement + ", " +
				"disruption=" + this.disruption +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxSingleLeg  ***********************/
	class FxSingleLegBuilderImpl extends Product.ProductBuilderImpl implements FxSingleLeg.FxSingleLegBuilder {
	
		protected Payment.PaymentBuilder exchangedCurrency1;
		protected Payment.PaymentBuilder exchangedCurrency2;
		protected DealtCurrencyEnum dealtCurrency;
		protected FxTenorPeriodEnum tenorName;
		protected Period.PeriodBuilder tenorPeriod;
		protected ZonedDateTime valueDate;
		protected ZonedDateTime currency1ValueDate;
		protected ZonedDateTime currency2ValueDate;
		protected ExchangeRate.ExchangeRateBuilder exchangeRate;
		protected FxCashSettlement.FxCashSettlementBuilder nonDeliverableSettlement;
		protected List<FxDisruption.FxDisruptionBuilder> disruption = new ArrayList<>();
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency1")
		public Payment.PaymentBuilder getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateExchangedCurrency1() {
			Payment.PaymentBuilder result;
			if (exchangedCurrency1!=null) {
				result = exchangedCurrency1;
			}
			else {
				result = exchangedCurrency1 = Payment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency2")
		public Payment.PaymentBuilder getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateExchangedCurrency2() {
			Payment.PaymentBuilder result;
			if (exchangedCurrency2!=null) {
				result = exchangedCurrency2;
			}
			else {
				result = exchangedCurrency2 = Payment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealtCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealtCurrency")
		public DealtCurrencyEnum getDealtCurrency() {
			return dealtCurrency;
		}
		
		@Override
		@RosettaAttribute("tenorName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorName")
		public FxTenorPeriodEnum getTenorName() {
			return tenorName;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorPeriod")
		public Period.PeriodBuilder getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenorPeriod() {
			Period.PeriodBuilder result;
			if (tenorPeriod!=null) {
				result = tenorPeriod;
			}
			else {
				result = tenorPeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valueDate")
		public ZonedDateTime getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("currency1ValueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency1ValueDate")
		public ZonedDateTime getCurrency1ValueDate() {
			return currency1ValueDate;
		}
		
		@Override
		@RosettaAttribute("currency2ValueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency2ValueDate")
		public ZonedDateTime getCurrency2ValueDate() {
			return currency2ValueDate;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRate")
		public ExchangeRate.ExchangeRateBuilder getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		public ExchangeRate.ExchangeRateBuilder getOrCreateExchangeRate() {
			ExchangeRate.ExchangeRateBuilder result;
			if (exchangeRate!=null) {
				result = exchangeRate;
			}
			else {
				result = exchangeRate = ExchangeRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonDeliverableSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonDeliverableSettlement")
		public FxCashSettlement.FxCashSettlementBuilder getNonDeliverableSettlement() {
			return nonDeliverableSettlement;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder getOrCreateNonDeliverableSettlement() {
			FxCashSettlement.FxCashSettlementBuilder result;
			if (nonDeliverableSettlement!=null) {
				result = nonDeliverableSettlement;
			}
			else {
				result = nonDeliverableSettlement = FxCashSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("disruption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("disruption")
		public List<? extends FxDisruption.FxDisruptionBuilder> getDisruption() {
			return disruption;
		}
		
		@Override
		public FxDisruption.FxDisruptionBuilder getOrCreateDisruption(int index) {
			if (disruption==null) {
				this.disruption = new ArrayList<>();
			}
			return getIndex(disruption, index, () -> {
						FxDisruption.FxDisruptionBuilder newDisruption = FxDisruption.builder();
						return newDisruption;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxSingleLeg.FxSingleLegBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxSingleLeg.FxSingleLegBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxSingleLeg.FxSingleLegBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxSingleLeg.FxSingleLegBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxSingleLeg.FxSingleLegBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxSingleLeg.FxSingleLegBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxSingleLeg.FxSingleLegBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxSingleLeg.FxSingleLegBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxSingleLeg.FxSingleLegBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxSingleLeg.FxSingleLegBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exchangedCurrency1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exchangedCurrency1")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setExchangedCurrency1(Payment _exchangedCurrency1) {
			this.exchangedCurrency1 = _exchangedCurrency1 == null ? null : _exchangedCurrency1.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangedCurrency2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exchangedCurrency2")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setExchangedCurrency2(Payment _exchangedCurrency2) {
			this.exchangedCurrency2 = _exchangedCurrency2 == null ? null : _exchangedCurrency2.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealtCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealtCurrency")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setDealtCurrency(DealtCurrencyEnum _dealtCurrency) {
			this.dealtCurrency = _dealtCurrency == null ? null : _dealtCurrency;
			return this;
		}
		
		@RosettaAttribute("tenorName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenorName")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setTenorName(FxTenorPeriodEnum _tenorName) {
			this.tenorName = _tenorName == null ? null : _tenorName;
			return this;
		}
		
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenorPeriod")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setTenorPeriod(Period _tenorPeriod) {
			this.tenorPeriod = _tenorPeriod == null ? null : _tenorPeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valueDate")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setValueDate(ZonedDateTime _valueDate) {
			this.valueDate = _valueDate == null ? null : _valueDate;
			return this;
		}
		
		@RosettaAttribute("currency1ValueDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency1ValueDate")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setCurrency1ValueDate(ZonedDateTime _currency1ValueDate) {
			this.currency1ValueDate = _currency1ValueDate == null ? null : _currency1ValueDate;
			return this;
		}
		
		@RosettaAttribute("currency2ValueDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency2ValueDate")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setCurrency2ValueDate(ZonedDateTime _currency2ValueDate) {
			this.currency2ValueDate = _currency2ValueDate == null ? null : _currency2ValueDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setExchangeRate(ExchangeRate _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonDeliverableSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonDeliverableSettlement")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setNonDeliverableSettlement(FxCashSettlement _nonDeliverableSettlement) {
			this.nonDeliverableSettlement = _nonDeliverableSettlement == null ? null : _nonDeliverableSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("disruption")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("disruption")
		@Override
		public FxSingleLeg.FxSingleLegBuilder addDisruption(FxDisruption _disruption) {
			if (_disruption != null) {
				this.disruption.add(_disruption.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addDisruption(FxDisruption _disruption, int idx) {
			getIndex(this.disruption, idx, () -> _disruption.toBuilder());
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder addDisruption(List<? extends FxDisruption> disruptions) {
			if (disruptions != null) {
				for (final FxDisruption toAdd : disruptions) {
					this.disruption.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("disruption")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("disruption")
		@Override
		public FxSingleLeg.FxSingleLegBuilder setDisruption(List<? extends FxDisruption> disruptions) {
			if (disruptions == null) {
				this.disruption = new ArrayList<>();
			} else {
				this.disruption = disruptions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxSingleLeg build() {
			return new FxSingleLeg.FxSingleLegImpl(this);
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSingleLeg.FxSingleLegBuilder prune() {
			super.prune();
			if (exchangedCurrency1!=null && !exchangedCurrency1.prune().hasData()) exchangedCurrency1 = null;
			if (exchangedCurrency2!=null && !exchangedCurrency2.prune().hasData()) exchangedCurrency2 = null;
			if (tenorPeriod!=null && !tenorPeriod.prune().hasData()) tenorPeriod = null;
			if (exchangeRate!=null && !exchangeRate.prune().hasData()) exchangeRate = null;
			if (nonDeliverableSettlement!=null && !nonDeliverableSettlement.prune().hasData()) nonDeliverableSettlement = null;
			disruption = disruption.stream().filter(b->b!=null).<FxDisruption.FxDisruptionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExchangedCurrency1()!=null && getExchangedCurrency1().hasData()) return true;
			if (getExchangedCurrency2()!=null && getExchangedCurrency2().hasData()) return true;
			if (getDealtCurrency()!=null) return true;
			if (getTenorName()!=null) return true;
			if (getTenorPeriod()!=null && getTenorPeriod().hasData()) return true;
			if (getValueDate()!=null) return true;
			if (getCurrency1ValueDate()!=null) return true;
			if (getCurrency2ValueDate()!=null) return true;
			if (getExchangeRate()!=null && getExchangeRate().hasData()) return true;
			if (getNonDeliverableSettlement()!=null && getNonDeliverableSettlement().hasData()) return true;
			if (getDisruption()!=null && getDisruption().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSingleLeg.FxSingleLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxSingleLeg.FxSingleLegBuilder o = (FxSingleLeg.FxSingleLegBuilder) other;
			
			merger.mergeRosetta(getExchangedCurrency1(), o.getExchangedCurrency1(), this::setExchangedCurrency1);
			merger.mergeRosetta(getExchangedCurrency2(), o.getExchangedCurrency2(), this::setExchangedCurrency2);
			merger.mergeRosetta(getTenorPeriod(), o.getTenorPeriod(), this::setTenorPeriod);
			merger.mergeRosetta(getExchangeRate(), o.getExchangeRate(), this::setExchangeRate);
			merger.mergeRosetta(getNonDeliverableSettlement(), o.getNonDeliverableSettlement(), this::setNonDeliverableSettlement);
			merger.mergeRosetta(getDisruption(), o.getDisruption(), this::getOrCreateDisruption);
			
			merger.mergeBasic(getDealtCurrency(), o.getDealtCurrency(), this::setDealtCurrency);
			merger.mergeBasic(getTenorName(), o.getTenorName(), this::setTenorName);
			merger.mergeBasic(getValueDate(), o.getValueDate(), this::setValueDate);
			merger.mergeBasic(getCurrency1ValueDate(), o.getCurrency1ValueDate(), this::setCurrency1ValueDate);
			merger.mergeBasic(getCurrency2ValueDate(), o.getCurrency2ValueDate(), this::setCurrency2ValueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSingleLeg _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			if (!Objects.equals(dealtCurrency, _that.getDealtCurrency())) return false;
			if (!Objects.equals(tenorName, _that.getTenorName())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!Objects.equals(currency1ValueDate, _that.getCurrency1ValueDate())) return false;
			if (!Objects.equals(currency2ValueDate, _that.getCurrency2ValueDate())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(nonDeliverableSettlement, _that.getNonDeliverableSettlement())) return false;
			if (!ListEquals.listEquals(disruption, _that.getDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			_result = 31 * _result + (dealtCurrency != null ? dealtCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorName != null ? tenorName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (currency1ValueDate != null ? currency1ValueDate.hashCode() : 0);
			_result = 31 * _result + (currency2ValueDate != null ? currency2ValueDate.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSettlement != null ? nonDeliverableSettlement.hashCode() : 0);
			_result = 31 * _result + (disruption != null ? disruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSingleLegBuilder {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 + ", " +
				"dealtCurrency=" + this.dealtCurrency + ", " +
				"tenorName=" + this.tenorName + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"valueDate=" + this.valueDate + ", " +
				"currency1ValueDate=" + this.currency1ValueDate + ", " +
				"currency2ValueDate=" + this.currency2ValueDate + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"nonDeliverableSettlement=" + this.nonDeliverableSettlement + ", " +
				"disruption=" + this.disruption +
			'}' + " " + super.toString();
		}
	}
}
