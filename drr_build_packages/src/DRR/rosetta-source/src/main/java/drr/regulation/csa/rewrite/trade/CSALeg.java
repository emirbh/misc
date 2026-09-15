package drr.regulation.csa.rewrite.trade;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RosettaIgnore;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneIgnore;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.PeriodicPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.csa.rewrite.trade.meta.CSALegMeta;
import drr.standards.iso.Direction2Enum;
import drr.standards.iso.FrequencyPeriodEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CSALeg", builder=CSALeg.CSALegBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CSALeg", model="drr", builder=CSALeg.CSALegBuilderImpl.class, version="7.7.0")
public interface CSALeg extends CommonLeg {

	CSALegMeta metaData = new CSALegMeta();

	/*********************** Getter Methods  ***********************/
	String getUnderlierIDOther();
	String getUnderlierIDOtherSource();
	String getUnderlyingAssetTradingPlatformIdentifier();
	String getUnderlyingAssetPriceSource();
	Boolean getCryptoAssetUnderlyingIndicator();
	String getCommodityUnderlyerID();
	String getCommodityInstrumentID();
	String getFloatingRateIndex();

	/*********************** Build Methods  ***********************/
	CSALeg build();
	
	CSALeg.CSALegBuilder toBuilder();
	
	static CSALeg.CSALegBuilder builder() {
		return new CSALeg.CSALegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSALeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSALeg> getType() {
		return CSALeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periodicPayment"), processor, CommonPeriodicPayment.class, getPeriodicPayment());
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		processRosetta(path.newSubPath("notionalAmountSchedule"), processor, NotionalPeriod.class, getNotionalAmountSchedule());
		processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, NotionalPeriod.class, getNotionalQuantitySchedule());
		processor.processBasic(path.newSubPath("notionalCurrency"), ISOCurrencyCodeEnum.class, getNotionalCurrency(), this);
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processor.processBasic(path.newSubPath("settlementCurrency"), ISOCurrencyCodeEnum.class, getSettlementCurrency(), this);
		processRosetta(path.newSubPath("spread"), processor, PriceFormat.class, getSpread());
		processor.processBasic(path.newSubPath("spreadNotation"), PriceNotationEnum.class, getSpreadNotation(), this);
		processor.processBasic(path.newSubPath("spreadCurrency"), ISOCurrencyCodeEnum.class, getSpreadCurrency(), this);
		processor.processBasic(path.newSubPath("quantityUnitOfMeasure"), String.class, getQuantityUnitOfMeasure(), this);
		processor.processBasic(path.newSubPath("direction2"), Direction2Enum.class, getDirection2(), this);
		processor.processBasic(path.newSubPath("notionalQuantity"), BigDecimal.class, getNotionalQuantity(), this);
		processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
		processor.processBasic(path.newSubPath("quantityFrequency"), FrequencyPeriodEnum.class, getQuantityFrequency(), this);
		processor.processBasic(path.newSubPath("quantityFrequencyMultiplier"), Integer.class, getQuantityFrequencyMultiplier(), this);
		processor.processBasic(path.newSubPath("payerIdentifier"), String.class, getPayerIdentifier(), this);
		processor.processBasic(path.newSubPath("receiverIdentifier"), String.class, getReceiverIdentifier(), this);
		processor.processBasic(path.newSubPath("settlementLocation"), ISOCountryCodeEnum.class, getSettlementLocation(), this);
		processor.processBasic(path.newSubPath("nextFloatingReferenceResetDate"), Date.class, getNextFloatingReferenceResetDate(), this);
		processor.processBasic(path.newSubPath("underlierIDOther"), String.class, getUnderlierIDOther(), this);
		processor.processBasic(path.newSubPath("underlierIDOtherSource"), String.class, getUnderlierIDOtherSource(), this);
		processor.processBasic(path.newSubPath("underlyingAssetTradingPlatformIdentifier"), String.class, getUnderlyingAssetTradingPlatformIdentifier(), this);
		processor.processBasic(path.newSubPath("underlyingAssetPriceSource"), String.class, getUnderlyingAssetPriceSource(), this);
		processor.processBasic(path.newSubPath("cryptoAssetUnderlyingIndicator"), Boolean.class, getCryptoAssetUnderlyingIndicator(), this);
		processor.processBasic(path.newSubPath("commodityUnderlyerID"), String.class, getCommodityUnderlyerID(), this);
		processor.processBasic(path.newSubPath("commodityInstrumentID"), String.class, getCommodityInstrumentID(), this);
		processor.processBasic(path.newSubPath("floatingRateIndex"), String.class, getFloatingRateIndex(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSALegBuilder extends CSALeg, CommonLeg.CommonLegBuilder {
		@Override
		CSALeg.CSALegBuilder setPeriodicPayment(PeriodicPayment periodicPayment);
		@Override
		CSALeg.CSALegBuilder setNotionalAmount(BigDecimal notionalAmount);
		@Override
		CSALeg.CSALegBuilder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule);
		@Override
		CSALeg.CSALegBuilder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule, int idx);
		@Override
		CSALeg.CSALegBuilder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		@Override
		CSALeg.CSALegBuilder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		@Override
		CSALeg.CSALegBuilder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule);
		@Override
		CSALeg.CSALegBuilder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule, int idx);
		@Override
		CSALeg.CSALegBuilder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		@Override
		CSALeg.CSALegBuilder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		@Override
		CSALeg.CSALegBuilder setNotionalCurrency(ISOCurrencyCodeEnum notionalCurrency);
		@Override
		CSALeg.CSALegBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		@Override
		CSALeg.CSALegBuilder setFixedRate(BigDecimal fixedRate);
		@Override
		CSALeg.CSALegBuilder setSettlementCurrency(ISOCurrencyCodeEnum settlementCurrency);
		@Override
		CSALeg.CSALegBuilder setSpread(PriceFormat spread);
		@Override
		CSALeg.CSALegBuilder setSpreadNotation(PriceNotationEnum spreadNotation);
		@Override
		CSALeg.CSALegBuilder setSpreadCurrency(ISOCurrencyCodeEnum spreadCurrency);
		@Override
		CSALeg.CSALegBuilder setQuantityUnitOfMeasure(String quantityUnitOfMeasure);
		@Override
		CSALeg.CSALegBuilder setDirection2(Direction2Enum direction2);
		@Override
		CSALeg.CSALegBuilder setPeriodicPayment(CommonPeriodicPayment periodicPayment);
		@Override
		CSALeg.CSALegBuilder setNotionalQuantity(BigDecimal notionalQuantity);
		@Override
		CSALeg.CSALegBuilder setFixingDate(ZonedDateTime fixingDate);
		@Override
		CSALeg.CSALegBuilder setQuantityFrequency(FrequencyPeriodEnum quantityFrequency);
		@Override
		CSALeg.CSALegBuilder setQuantityFrequencyMultiplier(Integer quantityFrequencyMultiplier);
		@Override
		CSALeg.CSALegBuilder setPayerIdentifier(String payerIdentifier);
		@Override
		CSALeg.CSALegBuilder setReceiverIdentifier(String receiverIdentifier);
		@Override
		CSALeg.CSALegBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		CSALeg.CSALegBuilder setNextFloatingReferenceResetDate(Date nextFloatingReferenceResetDate);
		CSALeg.CSALegBuilder setUnderlierIDOther(String underlierIDOther);
		CSALeg.CSALegBuilder setUnderlierIDOtherSource(String underlierIDOtherSource);
		CSALeg.CSALegBuilder setUnderlyingAssetTradingPlatformIdentifier(String underlyingAssetTradingPlatformIdentifier);
		CSALeg.CSALegBuilder setUnderlyingAssetPriceSource(String underlyingAssetPriceSource);
		CSALeg.CSALegBuilder setCryptoAssetUnderlyingIndicator(Boolean cryptoAssetUnderlyingIndicator);
		CSALeg.CSALegBuilder setCommodityUnderlyerID(String commodityUnderlyerID);
		CSALeg.CSALegBuilder setCommodityInstrumentID(String commodityInstrumentID);
		CSALeg.CSALegBuilder setFloatingRateIndex(String floatingRateIndex);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periodicPayment"), processor, CommonPeriodicPayment.CommonPeriodicPaymentBuilder.class, getPeriodicPayment());
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
			processRosetta(path.newSubPath("notionalAmountSchedule"), processor, NotionalPeriod.NotionalPeriodBuilder.class, getNotionalAmountSchedule());
			processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, NotionalPeriod.NotionalPeriodBuilder.class, getNotionalQuantitySchedule());
			processor.processBasic(path.newSubPath("notionalCurrency"), ISOCurrencyCodeEnum.class, getNotionalCurrency(), this);
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processor.processBasic(path.newSubPath("settlementCurrency"), ISOCurrencyCodeEnum.class, getSettlementCurrency(), this);
			processRosetta(path.newSubPath("spread"), processor, PriceFormat.PriceFormatBuilder.class, getSpread());
			processor.processBasic(path.newSubPath("spreadNotation"), PriceNotationEnum.class, getSpreadNotation(), this);
			processor.processBasic(path.newSubPath("spreadCurrency"), ISOCurrencyCodeEnum.class, getSpreadCurrency(), this);
			processor.processBasic(path.newSubPath("quantityUnitOfMeasure"), String.class, getQuantityUnitOfMeasure(), this);
			processor.processBasic(path.newSubPath("direction2"), Direction2Enum.class, getDirection2(), this);
			processor.processBasic(path.newSubPath("notionalQuantity"), BigDecimal.class, getNotionalQuantity(), this);
			processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
			processor.processBasic(path.newSubPath("quantityFrequency"), FrequencyPeriodEnum.class, getQuantityFrequency(), this);
			processor.processBasic(path.newSubPath("quantityFrequencyMultiplier"), Integer.class, getQuantityFrequencyMultiplier(), this);
			processor.processBasic(path.newSubPath("payerIdentifier"), String.class, getPayerIdentifier(), this);
			processor.processBasic(path.newSubPath("receiverIdentifier"), String.class, getReceiverIdentifier(), this);
			processor.processBasic(path.newSubPath("settlementLocation"), ISOCountryCodeEnum.class, getSettlementLocation(), this);
			processor.processBasic(path.newSubPath("nextFloatingReferenceResetDate"), Date.class, getNextFloatingReferenceResetDate(), this);
			processor.processBasic(path.newSubPath("underlierIDOther"), String.class, getUnderlierIDOther(), this);
			processor.processBasic(path.newSubPath("underlierIDOtherSource"), String.class, getUnderlierIDOtherSource(), this);
			processor.processBasic(path.newSubPath("underlyingAssetTradingPlatformIdentifier"), String.class, getUnderlyingAssetTradingPlatformIdentifier(), this);
			processor.processBasic(path.newSubPath("underlyingAssetPriceSource"), String.class, getUnderlyingAssetPriceSource(), this);
			processor.processBasic(path.newSubPath("cryptoAssetUnderlyingIndicator"), Boolean.class, getCryptoAssetUnderlyingIndicator(), this);
			processor.processBasic(path.newSubPath("commodityUnderlyerID"), String.class, getCommodityUnderlyerID(), this);
			processor.processBasic(path.newSubPath("commodityInstrumentID"), String.class, getCommodityInstrumentID(), this);
			processor.processBasic(path.newSubPath("floatingRateIndex"), String.class, getFloatingRateIndex(), this);
		}
		

		CSALeg.CSALegBuilder prune();
	}

	/*********************** Immutable Implementation of CSALeg  ***********************/
	class CSALegImpl extends CommonLeg.CommonLegImpl implements CSALeg {
		private final String underlierIDOther;
		private final String underlierIDOtherSource;
		private final String underlyingAssetTradingPlatformIdentifier;
		private final String underlyingAssetPriceSource;
		private final Boolean cryptoAssetUnderlyingIndicator;
		private final String commodityUnderlyerID;
		private final String commodityInstrumentID;
		private final String floatingRateIndex;
		
		protected CSALegImpl(CSALeg.CSALegBuilder builder) {
			super(builder);
			this.underlierIDOther = builder.getUnderlierIDOther();
			this.underlierIDOtherSource = builder.getUnderlierIDOtherSource();
			this.underlyingAssetTradingPlatformIdentifier = builder.getUnderlyingAssetTradingPlatformIdentifier();
			this.underlyingAssetPriceSource = builder.getUnderlyingAssetPriceSource();
			this.cryptoAssetUnderlyingIndicator = builder.getCryptoAssetUnderlyingIndicator();
			this.commodityUnderlyerID = builder.getCommodityUnderlyerID();
			this.commodityInstrumentID = builder.getCommodityInstrumentID();
			this.floatingRateIndex = builder.getFloatingRateIndex();
		}
		
		@Override
		@RosettaAttribute("underlierIDOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlierIDOther")
		public String getUnderlierIDOther() {
			return underlierIDOther;
		}
		
		@Override
		@RosettaAttribute("underlierIDOtherSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlierIDOtherSource")
		public String getUnderlierIDOtherSource() {
			return underlierIDOtherSource;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		public String getUnderlyingAssetTradingPlatformIdentifier() {
			return underlyingAssetTradingPlatformIdentifier;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		public String getUnderlyingAssetPriceSource() {
			return underlyingAssetPriceSource;
		}
		
		@Override
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		public Boolean getCryptoAssetUnderlyingIndicator() {
			return cryptoAssetUnderlyingIndicator;
		}
		
		@Override
		@RosettaAttribute("commodityUnderlyerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityUnderlyerID")
		public String getCommodityUnderlyerID() {
			return commodityUnderlyerID;
		}
		
		@Override
		@RosettaAttribute("commodityInstrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityInstrumentID")
		public String getCommodityInstrumentID() {
			return commodityInstrumentID;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndex")
		public String getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public CSALeg build() {
			return this;
		}
		
		@Override
		public CSALeg.CSALegBuilder toBuilder() {
			CSALeg.CSALegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSALeg.CSALegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlierIDOther()).ifPresent(builder::setUnderlierIDOther);
			ofNullable(getUnderlierIDOtherSource()).ifPresent(builder::setUnderlierIDOtherSource);
			ofNullable(getUnderlyingAssetTradingPlatformIdentifier()).ifPresent(builder::setUnderlyingAssetTradingPlatformIdentifier);
			ofNullable(getUnderlyingAssetPriceSource()).ifPresent(builder::setUnderlyingAssetPriceSource);
			ofNullable(getCryptoAssetUnderlyingIndicator()).ifPresent(builder::setCryptoAssetUnderlyingIndicator);
			ofNullable(getCommodityUnderlyerID()).ifPresent(builder::setCommodityUnderlyerID);
			ofNullable(getCommodityInstrumentID()).ifPresent(builder::setCommodityInstrumentID);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CSALeg _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDOther, _that.getUnderlierIDOther())) return false;
			if (!Objects.equals(underlierIDOtherSource, _that.getUnderlierIDOtherSource())) return false;
			if (!Objects.equals(underlyingAssetTradingPlatformIdentifier, _that.getUnderlyingAssetTradingPlatformIdentifier())) return false;
			if (!Objects.equals(underlyingAssetPriceSource, _that.getUnderlyingAssetPriceSource())) return false;
			if (!Objects.equals(cryptoAssetUnderlyingIndicator, _that.getCryptoAssetUnderlyingIndicator())) return false;
			if (!Objects.equals(commodityUnderlyerID, _that.getCommodityUnderlyerID())) return false;
			if (!Objects.equals(commodityInstrumentID, _that.getCommodityInstrumentID())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlierIDOther != null ? underlierIDOther.hashCode() : 0);
			_result = 31 * _result + (underlierIDOtherSource != null ? underlierIDOtherSource.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetTradingPlatformIdentifier != null ? underlyingAssetTradingPlatformIdentifier.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPriceSource != null ? underlyingAssetPriceSource.hashCode() : 0);
			_result = 31 * _result + (cryptoAssetUnderlyingIndicator != null ? cryptoAssetUnderlyingIndicator.hashCode() : 0);
			_result = 31 * _result + (commodityUnderlyerID != null ? commodityUnderlyerID.hashCode() : 0);
			_result = 31 * _result + (commodityInstrumentID != null ? commodityInstrumentID.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSALeg {" +
				"underlierIDOther=" + this.underlierIDOther + ", " +
				"underlierIDOtherSource=" + this.underlierIDOtherSource + ", " +
				"underlyingAssetTradingPlatformIdentifier=" + this.underlyingAssetTradingPlatformIdentifier + ", " +
				"underlyingAssetPriceSource=" + this.underlyingAssetPriceSource + ", " +
				"cryptoAssetUnderlyingIndicator=" + this.cryptoAssetUnderlyingIndicator + ", " +
				"commodityUnderlyerID=" + this.commodityUnderlyerID + ", " +
				"commodityInstrumentID=" + this.commodityInstrumentID + ", " +
				"floatingRateIndex=" + this.floatingRateIndex +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CSALeg  ***********************/
	class CSALegBuilderImpl extends CommonLeg.CommonLegBuilderImpl implements CSALeg.CSALegBuilder {
	
		protected String underlierIDOther;
		protected String underlierIDOtherSource;
		protected String underlyingAssetTradingPlatformIdentifier;
		protected String underlyingAssetPriceSource;
		protected Boolean cryptoAssetUnderlyingIndicator;
		protected String commodityUnderlyerID;
		protected String commodityInstrumentID;
		protected String floatingRateIndex;
		
		@Override
		@RosettaAttribute("underlierIDOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlierIDOther")
		public String getUnderlierIDOther() {
			return underlierIDOther;
		}
		
		@Override
		@RosettaAttribute("underlierIDOtherSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlierIDOtherSource")
		public String getUnderlierIDOtherSource() {
			return underlierIDOtherSource;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		public String getUnderlyingAssetTradingPlatformIdentifier() {
			return underlyingAssetTradingPlatformIdentifier;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		public String getUnderlyingAssetPriceSource() {
			return underlyingAssetPriceSource;
		}
		
		@Override
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		public Boolean getCryptoAssetUnderlyingIndicator() {
			return cryptoAssetUnderlyingIndicator;
		}
		
		@Override
		@RosettaAttribute("commodityUnderlyerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityUnderlyerID")
		public String getCommodityUnderlyerID() {
			return commodityUnderlyerID;
		}
		
		@Override
		@RosettaAttribute("commodityInstrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityInstrumentID")
		public String getCommodityInstrumentID() {
			return commodityInstrumentID;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndex")
		public String getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodicPayment")
		@Override
		public CSALeg.CSALegBuilder setPeriodicPayment(CommonPeriodicPayment _periodicPayment) {
			this.periodicPayment = _periodicPayment == null ? null : _periodicPayment.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CSALeg.CSALegBuilder setPeriodicPayment(PeriodicPayment _periodicPayment) {
			final CommonPeriodicPayment ifThenElseResult;
			if (_periodicPayment == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _periodicPayment instanceof CommonPeriodicPayment ? CommonPeriodicPayment.class.cast(_periodicPayment) : null;
			}
			return setPeriodicPayment(ifThenElseResult);
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public CSALeg.CSALegBuilder setNotionalAmount(BigDecimal _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount;
			return this;
		}
		
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		@Override
		public CSALeg.CSALegBuilder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule) {
			if (_notionalAmountSchedule != null) {
				this.notionalAmountSchedule.add(_notionalAmountSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CSALeg.CSALegBuilder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule, int idx) {
			getIndex(this.notionalAmountSchedule, idx, () -> _notionalAmountSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CSALeg.CSALegBuilder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
			if (notionalAmountSchedules != null) {
				for (final NotionalPeriod toAdd : notionalAmountSchedules) {
					this.notionalAmountSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		@Override
		public CSALeg.CSALegBuilder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
			if (notionalAmountSchedules == null) {
				this.notionalAmountSchedule = new ArrayList<>();
			} else {
				this.notionalAmountSchedule = notionalAmountSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalQuantitySchedule")
		@Override
		public CSALeg.CSALegBuilder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule) {
			if (_notionalQuantitySchedule != null) {
				this.notionalQuantitySchedule.add(_notionalQuantitySchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CSALeg.CSALegBuilder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule, int idx) {
			getIndex(this.notionalQuantitySchedule, idx, () -> _notionalQuantitySchedule.toBuilder());
			return this;
		}
		
		@Override
		public CSALeg.CSALegBuilder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
			if (notionalQuantitySchedules != null) {
				for (final NotionalPeriod toAdd : notionalQuantitySchedules) {
					this.notionalQuantitySchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("notionalQuantitySchedule")
		@Override
		public CSALeg.CSALegBuilder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
			if (notionalQuantitySchedules == null) {
				this.notionalQuantitySchedule = new ArrayList<>();
			} else {
				this.notionalQuantitySchedule = notionalQuantitySchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalCurrency")
		@Override
		public CSALeg.CSALegBuilder setNotionalCurrency(ISOCurrencyCodeEnum _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public CSALeg.CSALegBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public CSALeg.CSALegBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CSALeg.CSALegBuilder setSettlementCurrency(ISOCurrencyCodeEnum _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency;
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public CSALeg.CSALegBuilder setSpread(PriceFormat _spread) {
			this.spread = _spread == null ? null : _spread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadNotation")
		@Override
		public CSALeg.CSALegBuilder setSpreadNotation(PriceNotationEnum _spreadNotation) {
			this.spreadNotation = _spreadNotation == null ? null : _spreadNotation;
			return this;
		}
		
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadCurrency")
		@Override
		public CSALeg.CSALegBuilder setSpreadCurrency(ISOCurrencyCodeEnum _spreadCurrency) {
			this.spreadCurrency = _spreadCurrency == null ? null : _spreadCurrency;
			return this;
		}
		
		@RosettaAttribute("quantityUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityUnitOfMeasure")
		@Override
		public CSALeg.CSALegBuilder setQuantityUnitOfMeasure(String _quantityUnitOfMeasure) {
			this.quantityUnitOfMeasure = _quantityUnitOfMeasure == null ? null : _quantityUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("direction2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction2")
		@Override
		public CSALeg.CSALegBuilder setDirection2(Direction2Enum _direction2) {
			this.direction2 = _direction2 == null ? null : _direction2;
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public CSALeg.CSALegBuilder setNotionalQuantity(BigDecimal _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity;
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingDate")
		@Override
		public CSALeg.CSALegBuilder setFixingDate(ZonedDateTime _fixingDate) {
			this.fixingDate = _fixingDate == null ? null : _fixingDate;
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequency")
		@Override
		public CSALeg.CSALegBuilder setQuantityFrequency(FrequencyPeriodEnum _quantityFrequency) {
			this.quantityFrequency = _quantityFrequency == null ? null : _quantityFrequency;
			return this;
		}
		
		@RosettaAttribute("quantityFrequencyMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequencyMultiplier")
		@Override
		public CSALeg.CSALegBuilder setQuantityFrequencyMultiplier(Integer _quantityFrequencyMultiplier) {
			this.quantityFrequencyMultiplier = _quantityFrequencyMultiplier == null ? null : _quantityFrequencyMultiplier;
			return this;
		}
		
		@RosettaAttribute("payerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerIdentifier")
		@Override
		public CSALeg.CSALegBuilder setPayerIdentifier(String _payerIdentifier) {
			this.payerIdentifier = _payerIdentifier == null ? null : _payerIdentifier;
			return this;
		}
		
		@RosettaAttribute("receiverIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverIdentifier")
		@Override
		public CSALeg.CSALegBuilder setReceiverIdentifier(String _receiverIdentifier) {
			this.receiverIdentifier = _receiverIdentifier == null ? null : _receiverIdentifier;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public CSALeg.CSALegBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDate")
		@Override
		public CSALeg.CSALegBuilder setNextFloatingReferenceResetDate(Date _nextFloatingReferenceResetDate) {
			this.nextFloatingReferenceResetDate = _nextFloatingReferenceResetDate == null ? null : _nextFloatingReferenceResetDate;
			return this;
		}
		
		@RosettaAttribute("underlierIDOther")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlierIDOther")
		@Override
		public CSALeg.CSALegBuilder setUnderlierIDOther(String _underlierIDOther) {
			this.underlierIDOther = _underlierIDOther == null ? null : _underlierIDOther;
			return this;
		}
		
		@RosettaAttribute("underlierIDOtherSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlierIDOtherSource")
		@Override
		public CSALeg.CSALegBuilder setUnderlierIDOtherSource(String _underlierIDOtherSource) {
			this.underlierIDOtherSource = _underlierIDOtherSource == null ? null : _underlierIDOtherSource;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		@Override
		public CSALeg.CSALegBuilder setUnderlyingAssetTradingPlatformIdentifier(String _underlyingAssetTradingPlatformIdentifier) {
			this.underlyingAssetTradingPlatformIdentifier = _underlyingAssetTradingPlatformIdentifier == null ? null : _underlyingAssetTradingPlatformIdentifier;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public CSALeg.CSALegBuilder setUnderlyingAssetPriceSource(String _underlyingAssetPriceSource) {
			this.underlyingAssetPriceSource = _underlyingAssetPriceSource == null ? null : _underlyingAssetPriceSource;
			return this;
		}
		
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		@Override
		public CSALeg.CSALegBuilder setCryptoAssetUnderlyingIndicator(Boolean _cryptoAssetUnderlyingIndicator) {
			this.cryptoAssetUnderlyingIndicator = _cryptoAssetUnderlyingIndicator == null ? null : _cryptoAssetUnderlyingIndicator;
			return this;
		}
		
		@RosettaAttribute("commodityUnderlyerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityUnderlyerID")
		@Override
		public CSALeg.CSALegBuilder setCommodityUnderlyerID(String _commodityUnderlyerID) {
			this.commodityUnderlyerID = _commodityUnderlyerID == null ? null : _commodityUnderlyerID;
			return this;
		}
		
		@RosettaAttribute("commodityInstrumentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityInstrumentID")
		@Override
		public CSALeg.CSALegBuilder setCommodityInstrumentID(String _commodityInstrumentID) {
			this.commodityInstrumentID = _commodityInstrumentID == null ? null : _commodityInstrumentID;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateIndex")
		@Override
		public CSALeg.CSALegBuilder setFloatingRateIndex(String _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex;
			return this;
		}
		
		@Override
		public CSALeg build() {
			return new CSALeg.CSALegImpl(this);
		}
		
		@Override
		public CSALeg.CSALegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSALeg.CSALegBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlierIDOther()!=null) return true;
			if (getUnderlierIDOtherSource()!=null) return true;
			if (getUnderlyingAssetTradingPlatformIdentifier()!=null) return true;
			if (getUnderlyingAssetPriceSource()!=null) return true;
			if (getCryptoAssetUnderlyingIndicator()!=null) return true;
			if (getCommodityUnderlyerID()!=null) return true;
			if (getCommodityInstrumentID()!=null) return true;
			if (getFloatingRateIndex()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSALeg.CSALegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CSALeg.CSALegBuilder o = (CSALeg.CSALegBuilder) other;
			
			
			merger.mergeBasic(getUnderlierIDOther(), o.getUnderlierIDOther(), this::setUnderlierIDOther);
			merger.mergeBasic(getUnderlierIDOtherSource(), o.getUnderlierIDOtherSource(), this::setUnderlierIDOtherSource);
			merger.mergeBasic(getUnderlyingAssetTradingPlatformIdentifier(), o.getUnderlyingAssetTradingPlatformIdentifier(), this::setUnderlyingAssetTradingPlatformIdentifier);
			merger.mergeBasic(getUnderlyingAssetPriceSource(), o.getUnderlyingAssetPriceSource(), this::setUnderlyingAssetPriceSource);
			merger.mergeBasic(getCryptoAssetUnderlyingIndicator(), o.getCryptoAssetUnderlyingIndicator(), this::setCryptoAssetUnderlyingIndicator);
			merger.mergeBasic(getCommodityUnderlyerID(), o.getCommodityUnderlyerID(), this::setCommodityUnderlyerID);
			merger.mergeBasic(getCommodityInstrumentID(), o.getCommodityInstrumentID(), this::setCommodityInstrumentID);
			merger.mergeBasic(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CSALeg _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDOther, _that.getUnderlierIDOther())) return false;
			if (!Objects.equals(underlierIDOtherSource, _that.getUnderlierIDOtherSource())) return false;
			if (!Objects.equals(underlyingAssetTradingPlatformIdentifier, _that.getUnderlyingAssetTradingPlatformIdentifier())) return false;
			if (!Objects.equals(underlyingAssetPriceSource, _that.getUnderlyingAssetPriceSource())) return false;
			if (!Objects.equals(cryptoAssetUnderlyingIndicator, _that.getCryptoAssetUnderlyingIndicator())) return false;
			if (!Objects.equals(commodityUnderlyerID, _that.getCommodityUnderlyerID())) return false;
			if (!Objects.equals(commodityInstrumentID, _that.getCommodityInstrumentID())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlierIDOther != null ? underlierIDOther.hashCode() : 0);
			_result = 31 * _result + (underlierIDOtherSource != null ? underlierIDOtherSource.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetTradingPlatformIdentifier != null ? underlyingAssetTradingPlatformIdentifier.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPriceSource != null ? underlyingAssetPriceSource.hashCode() : 0);
			_result = 31 * _result + (cryptoAssetUnderlyingIndicator != null ? cryptoAssetUnderlyingIndicator.hashCode() : 0);
			_result = 31 * _result + (commodityUnderlyerID != null ? commodityUnderlyerID.hashCode() : 0);
			_result = 31 * _result + (commodityInstrumentID != null ? commodityInstrumentID.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSALegBuilder {" +
				"underlierIDOther=" + this.underlierIDOther + ", " +
				"underlierIDOtherSource=" + this.underlierIDOtherSource + ", " +
				"underlyingAssetTradingPlatformIdentifier=" + this.underlyingAssetTradingPlatformIdentifier + ", " +
				"underlyingAssetPriceSource=" + this.underlyingAssetPriceSource + ", " +
				"cryptoAssetUnderlyingIndicator=" + this.cryptoAssetUnderlyingIndicator + ", " +
				"commodityUnderlyerID=" + this.commodityUnderlyerID + ", " +
				"commodityInstrumentID=" + this.commodityInstrumentID + ", " +
				"floatingRateIndex=" + this.floatingRateIndex +
			'}' + " " + super.toString();
		}
	}
}
