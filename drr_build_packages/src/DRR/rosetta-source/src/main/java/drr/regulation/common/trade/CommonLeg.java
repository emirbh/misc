package drr.regulation.common.trade;

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
import com.rosetta.util.ListEquals;
import drr.base.trade.payment.PeriodicPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.meta.CommonLegMeta;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.standards.iosco.cde.version3.Leg;
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
@RosettaDataType(value="CommonLeg", builder=CommonLeg.CommonLegBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CommonLeg", model="drr", builder=CommonLeg.CommonLegBuilderImpl.class, version="7.7.0")
public interface CommonLeg extends Leg {

	CommonLegMeta metaData = new CommonLegMeta();

	/*********************** Getter Methods  ***********************/
	@Override
	CommonPeriodicPayment getPeriodicPayment();
	BigDecimal getNotionalQuantity();
	ZonedDateTime getFixingDate();
	FrequencyPeriodEnum getQuantityFrequency();
	Integer getQuantityFrequencyMultiplier();
	String getPayerIdentifier();
	String getReceiverIdentifier();
	ISOCountryCodeEnum getSettlementLocation();
	Date getNextFloatingReferenceResetDate();

	/*********************** Build Methods  ***********************/
	CommonLeg build();
	
	CommonLeg.CommonLegBuilder toBuilder();
	
	static CommonLeg.CommonLegBuilder builder() {
		return new CommonLeg.CommonLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonLeg> getType() {
		return CommonLeg.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonLegBuilder extends CommonLeg, Leg.LegBuilder {
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder getOrCreatePeriodicPayment();
		@Override
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder getPeriodicPayment();
		@Override
		CommonLeg.CommonLegBuilder setPeriodicPayment(PeriodicPayment periodicPayment);
		@Override
		CommonLeg.CommonLegBuilder setNotionalAmount(BigDecimal notionalAmount);
		@Override
		CommonLeg.CommonLegBuilder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule);
		@Override
		CommonLeg.CommonLegBuilder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule, int idx);
		@Override
		CommonLeg.CommonLegBuilder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		@Override
		CommonLeg.CommonLegBuilder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		@Override
		CommonLeg.CommonLegBuilder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule);
		@Override
		CommonLeg.CommonLegBuilder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule, int idx);
		@Override
		CommonLeg.CommonLegBuilder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		@Override
		CommonLeg.CommonLegBuilder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		@Override
		CommonLeg.CommonLegBuilder setNotionalCurrency(ISOCurrencyCodeEnum notionalCurrency);
		@Override
		CommonLeg.CommonLegBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		@Override
		CommonLeg.CommonLegBuilder setFixedRate(BigDecimal fixedRate);
		@Override
		CommonLeg.CommonLegBuilder setSettlementCurrency(ISOCurrencyCodeEnum settlementCurrency);
		@Override
		CommonLeg.CommonLegBuilder setSpread(PriceFormat spread);
		@Override
		CommonLeg.CommonLegBuilder setSpreadNotation(PriceNotationEnum spreadNotation);
		@Override
		CommonLeg.CommonLegBuilder setSpreadCurrency(ISOCurrencyCodeEnum spreadCurrency);
		@Override
		CommonLeg.CommonLegBuilder setQuantityUnitOfMeasure(String quantityUnitOfMeasure);
		@Override
		CommonLeg.CommonLegBuilder setDirection2(Direction2Enum direction2);
		CommonLeg.CommonLegBuilder setPeriodicPayment(CommonPeriodicPayment periodicPayment);
		CommonLeg.CommonLegBuilder setNotionalQuantity(BigDecimal notionalQuantity);
		CommonLeg.CommonLegBuilder setFixingDate(ZonedDateTime fixingDate);
		CommonLeg.CommonLegBuilder setQuantityFrequency(FrequencyPeriodEnum quantityFrequency);
		CommonLeg.CommonLegBuilder setQuantityFrequencyMultiplier(Integer quantityFrequencyMultiplier);
		CommonLeg.CommonLegBuilder setPayerIdentifier(String payerIdentifier);
		CommonLeg.CommonLegBuilder setReceiverIdentifier(String receiverIdentifier);
		CommonLeg.CommonLegBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		CommonLeg.CommonLegBuilder setNextFloatingReferenceResetDate(Date nextFloatingReferenceResetDate);

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
		}
		

		CommonLeg.CommonLegBuilder prune();
	}

	/*********************** Immutable Implementation of CommonLeg  ***********************/
	class CommonLegImpl extends Leg.LegImpl implements CommonLeg {
		private final CommonPeriodicPayment periodicPayment;
		private final BigDecimal notionalQuantity;
		private final ZonedDateTime fixingDate;
		private final FrequencyPeriodEnum quantityFrequency;
		private final Integer quantityFrequencyMultiplier;
		private final String payerIdentifier;
		private final String receiverIdentifier;
		private final ISOCountryCodeEnum settlementLocation;
		private final Date nextFloatingReferenceResetDate;
		
		protected CommonLegImpl(CommonLeg.CommonLegBuilder builder) {
			super(builder);
			this.periodicPayment = ofNullable(builder.getPeriodicPayment()).map(f->f.build()).orElse(null);
			this.notionalQuantity = builder.getNotionalQuantity();
			this.fixingDate = builder.getFixingDate();
			this.quantityFrequency = builder.getQuantityFrequency();
			this.quantityFrequencyMultiplier = builder.getQuantityFrequencyMultiplier();
			this.payerIdentifier = builder.getPayerIdentifier();
			this.receiverIdentifier = builder.getReceiverIdentifier();
			this.settlementLocation = builder.getSettlementLocation();
			this.nextFloatingReferenceResetDate = builder.getNextFloatingReferenceResetDate();
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodicPayment")
		public CommonPeriodicPayment getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantity")
		public BigDecimal getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingDate")
		public ZonedDateTime getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequency")
		public FrequencyPeriodEnum getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		@RosettaAttribute("quantityFrequencyMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequencyMultiplier")
		public Integer getQuantityFrequencyMultiplier() {
			return quantityFrequencyMultiplier;
		}
		
		@Override
		@RosettaAttribute("payerIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerIdentifier")
		public String getPayerIdentifier() {
			return payerIdentifier;
		}
		
		@Override
		@RosettaAttribute("receiverIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverIdentifier")
		public String getReceiverIdentifier() {
			return receiverIdentifier;
		}
		
		@Override
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementLocation")
		public ISOCountryCodeEnum getSettlementLocation() {
			return settlementLocation;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDate")
		public Date getNextFloatingReferenceResetDate() {
			return nextFloatingReferenceResetDate;
		}
		
		@Override
		public CommonLeg build() {
			return this;
		}
		
		@Override
		public CommonLeg.CommonLegBuilder toBuilder() {
			CommonLeg.CommonLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonLeg.CommonLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodicPayment()).ifPresent(builder::setPeriodicPayment);
			ofNullable(getNotionalQuantity()).ifPresent(builder::setNotionalQuantity);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getQuantityFrequency()).ifPresent(builder::setQuantityFrequency);
			ofNullable(getQuantityFrequencyMultiplier()).ifPresent(builder::setQuantityFrequencyMultiplier);
			ofNullable(getPayerIdentifier()).ifPresent(builder::setPayerIdentifier);
			ofNullable(getReceiverIdentifier()).ifPresent(builder::setReceiverIdentifier);
			ofNullable(getSettlementLocation()).ifPresent(builder::setSettlementLocation);
			ofNullable(getNextFloatingReferenceResetDate()).ifPresent(builder::setNextFloatingReferenceResetDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommonLeg _that = getType().cast(o);
		
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(quantityFrequencyMultiplier, _that.getQuantityFrequencyMultiplier())) return false;
			if (!Objects.equals(payerIdentifier, _that.getPayerIdentifier())) return false;
			if (!Objects.equals(receiverIdentifier, _that.getReceiverIdentifier())) return false;
			if (!Objects.equals(settlementLocation, _that.getSettlementLocation())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDate, _that.getNextFloatingReferenceResetDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantityFrequencyMultiplier != null ? quantityFrequencyMultiplier.hashCode() : 0);
			_result = 31 * _result + (payerIdentifier != null ? payerIdentifier.hashCode() : 0);
			_result = 31 * _result + (receiverIdentifier != null ? receiverIdentifier.hashCode() : 0);
			_result = 31 * _result + (settlementLocation != null ? settlementLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDate != null ? nextFloatingReferenceResetDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonLeg {" +
				"periodicPayment=" + this.periodicPayment + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"quantityFrequencyMultiplier=" + this.quantityFrequencyMultiplier + ", " +
				"payerIdentifier=" + this.payerIdentifier + ", " +
				"receiverIdentifier=" + this.receiverIdentifier + ", " +
				"settlementLocation=" + this.settlementLocation + ", " +
				"nextFloatingReferenceResetDate=" + this.nextFloatingReferenceResetDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommonLeg  ***********************/
	class CommonLegBuilderImpl implements CommonLeg.CommonLegBuilder {
	
		protected CommonPeriodicPayment.CommonPeriodicPaymentBuilder periodicPayment;
		protected BigDecimal notionalAmount;
		protected List<NotionalPeriod.NotionalPeriodBuilder> notionalAmountSchedule = new ArrayList<>();
		protected List<NotionalPeriod.NotionalPeriodBuilder> notionalQuantitySchedule = new ArrayList<>();
		protected ISOCurrencyCodeEnum notionalCurrency;
		protected BigDecimal totalNotionalQuantity;
		protected BigDecimal fixedRate;
		protected ISOCurrencyCodeEnum settlementCurrency;
		protected PriceFormat.PriceFormatBuilder spread;
		protected PriceNotationEnum spreadNotation;
		protected ISOCurrencyCodeEnum spreadCurrency;
		protected String quantityUnitOfMeasure;
		protected Direction2Enum direction2;
		protected BigDecimal notionalQuantity;
		protected ZonedDateTime fixingDate;
		protected FrequencyPeriodEnum quantityFrequency;
		protected Integer quantityFrequencyMultiplier;
		protected String payerIdentifier;
		protected String receiverIdentifier;
		protected ISOCountryCodeEnum settlementLocation;
		protected Date nextFloatingReferenceResetDate;
		
		@Override
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodicPayment")
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		public CommonPeriodicPayment.CommonPeriodicPaymentBuilder getOrCreatePeriodicPayment() {
			CommonPeriodicPayment.CommonPeriodicPaymentBuilder result;
			if (periodicPayment!=null) {
				result = periodicPayment;
			}
			else {
				result = periodicPayment = CommonPeriodicPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		public List<? extends NotionalPeriod.NotionalPeriodBuilder> getNotionalAmountSchedule() {
			return notionalAmountSchedule;
		}
		
		@Override
		public NotionalPeriod.NotionalPeriodBuilder getOrCreateNotionalAmountSchedule(int index) {
			if (notionalAmountSchedule==null) {
				this.notionalAmountSchedule = new ArrayList<>();
			}
			return getIndex(notionalAmountSchedule, index, () -> {
						NotionalPeriod.NotionalPeriodBuilder newNotionalAmountSchedule = NotionalPeriod.builder();
						return newNotionalAmountSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalQuantitySchedule")
		public List<? extends NotionalPeriod.NotionalPeriodBuilder> getNotionalQuantitySchedule() {
			return notionalQuantitySchedule;
		}
		
		@Override
		public NotionalPeriod.NotionalPeriodBuilder getOrCreateNotionalQuantitySchedule(int index) {
			if (notionalQuantitySchedule==null) {
				this.notionalQuantitySchedule = new ArrayList<>();
			}
			return getIndex(notionalQuantitySchedule, index, () -> {
						NotionalPeriod.NotionalPeriodBuilder newNotionalQuantitySchedule = NotionalPeriod.builder();
						return newNotionalQuantitySchedule;
					});
		}
		
		@Override
		@RosettaAttribute("notionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalCurrency")
		public ISOCurrencyCodeEnum getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public ISOCurrencyCodeEnum getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public PriceFormat.PriceFormatBuilder getSpread() {
			return spread;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreateSpread() {
			PriceFormat.PriceFormatBuilder result;
			if (spread!=null) {
				result = spread;
			}
			else {
				result = spread = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadNotation")
		public PriceNotationEnum getSpreadNotation() {
			return spreadNotation;
		}
		
		@Override
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadCurrency")
		public ISOCurrencyCodeEnum getSpreadCurrency() {
			return spreadCurrency;
		}
		
		@Override
		@RosettaAttribute("quantityUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityUnitOfMeasure")
		public String getQuantityUnitOfMeasure() {
			return quantityUnitOfMeasure;
		}
		
		@Override
		@RosettaAttribute("direction2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction2")
		public Direction2Enum getDirection2() {
			return direction2;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantity")
		public BigDecimal getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingDate")
		public ZonedDateTime getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequency")
		public FrequencyPeriodEnum getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		@RosettaAttribute("quantityFrequencyMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequencyMultiplier")
		public Integer getQuantityFrequencyMultiplier() {
			return quantityFrequencyMultiplier;
		}
		
		@Override
		@RosettaAttribute("payerIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerIdentifier")
		public String getPayerIdentifier() {
			return payerIdentifier;
		}
		
		@Override
		@RosettaAttribute("receiverIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverIdentifier")
		public String getReceiverIdentifier() {
			return receiverIdentifier;
		}
		
		@Override
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementLocation")
		public ISOCountryCodeEnum getSettlementLocation() {
			return settlementLocation;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDate")
		public Date getNextFloatingReferenceResetDate() {
			return nextFloatingReferenceResetDate;
		}
		
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodicPayment")
		@Override
		public CommonLeg.CommonLegBuilder setPeriodicPayment(CommonPeriodicPayment _periodicPayment) {
			this.periodicPayment = _periodicPayment == null ? null : _periodicPayment.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CommonLeg.CommonLegBuilder setPeriodicPayment(PeriodicPayment _periodicPayment) {
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
		public CommonLeg.CommonLegBuilder setNotionalAmount(BigDecimal _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount;
			return this;
		}
		
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		@Override
		public CommonLeg.CommonLegBuilder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule) {
			if (_notionalAmountSchedule != null) {
				this.notionalAmountSchedule.add(_notionalAmountSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommonLeg.CommonLegBuilder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule, int idx) {
			getIndex(this.notionalAmountSchedule, idx, () -> _notionalAmountSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CommonLeg.CommonLegBuilder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
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
		public CommonLeg.CommonLegBuilder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
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
		public CommonLeg.CommonLegBuilder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule) {
			if (_notionalQuantitySchedule != null) {
				this.notionalQuantitySchedule.add(_notionalQuantitySchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommonLeg.CommonLegBuilder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule, int idx) {
			getIndex(this.notionalQuantitySchedule, idx, () -> _notionalQuantitySchedule.toBuilder());
			return this;
		}
		
		@Override
		public CommonLeg.CommonLegBuilder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
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
		public CommonLeg.CommonLegBuilder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
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
		public CommonLeg.CommonLegBuilder setNotionalCurrency(ISOCurrencyCodeEnum _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public CommonLeg.CommonLegBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public CommonLeg.CommonLegBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CommonLeg.CommonLegBuilder setSettlementCurrency(ISOCurrencyCodeEnum _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency;
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public CommonLeg.CommonLegBuilder setSpread(PriceFormat _spread) {
			this.spread = _spread == null ? null : _spread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadNotation")
		@Override
		public CommonLeg.CommonLegBuilder setSpreadNotation(PriceNotationEnum _spreadNotation) {
			this.spreadNotation = _spreadNotation == null ? null : _spreadNotation;
			return this;
		}
		
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadCurrency")
		@Override
		public CommonLeg.CommonLegBuilder setSpreadCurrency(ISOCurrencyCodeEnum _spreadCurrency) {
			this.spreadCurrency = _spreadCurrency == null ? null : _spreadCurrency;
			return this;
		}
		
		@RosettaAttribute("quantityUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityUnitOfMeasure")
		@Override
		public CommonLeg.CommonLegBuilder setQuantityUnitOfMeasure(String _quantityUnitOfMeasure) {
			this.quantityUnitOfMeasure = _quantityUnitOfMeasure == null ? null : _quantityUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("direction2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction2")
		@Override
		public CommonLeg.CommonLegBuilder setDirection2(Direction2Enum _direction2) {
			this.direction2 = _direction2 == null ? null : _direction2;
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public CommonLeg.CommonLegBuilder setNotionalQuantity(BigDecimal _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity;
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingDate")
		@Override
		public CommonLeg.CommonLegBuilder setFixingDate(ZonedDateTime _fixingDate) {
			this.fixingDate = _fixingDate == null ? null : _fixingDate;
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequency")
		@Override
		public CommonLeg.CommonLegBuilder setQuantityFrequency(FrequencyPeriodEnum _quantityFrequency) {
			this.quantityFrequency = _quantityFrequency == null ? null : _quantityFrequency;
			return this;
		}
		
		@RosettaAttribute("quantityFrequencyMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequencyMultiplier")
		@Override
		public CommonLeg.CommonLegBuilder setQuantityFrequencyMultiplier(Integer _quantityFrequencyMultiplier) {
			this.quantityFrequencyMultiplier = _quantityFrequencyMultiplier == null ? null : _quantityFrequencyMultiplier;
			return this;
		}
		
		@RosettaAttribute("payerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerIdentifier")
		@Override
		public CommonLeg.CommonLegBuilder setPayerIdentifier(String _payerIdentifier) {
			this.payerIdentifier = _payerIdentifier == null ? null : _payerIdentifier;
			return this;
		}
		
		@RosettaAttribute("receiverIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverIdentifier")
		@Override
		public CommonLeg.CommonLegBuilder setReceiverIdentifier(String _receiverIdentifier) {
			this.receiverIdentifier = _receiverIdentifier == null ? null : _receiverIdentifier;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public CommonLeg.CommonLegBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDate")
		@Override
		public CommonLeg.CommonLegBuilder setNextFloatingReferenceResetDate(Date _nextFloatingReferenceResetDate) {
			this.nextFloatingReferenceResetDate = _nextFloatingReferenceResetDate == null ? null : _nextFloatingReferenceResetDate;
			return this;
		}
		
		@Override
		public CommonLeg build() {
			return new CommonLeg.CommonLegImpl(this);
		}
		
		@Override
		public CommonLeg.CommonLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonLeg.CommonLegBuilder prune() {
			if (periodicPayment!=null && !periodicPayment.prune().hasData()) periodicPayment = null;
			notionalAmountSchedule = notionalAmountSchedule.stream().filter(b->b!=null).<NotionalPeriod.NotionalPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			notionalQuantitySchedule = notionalQuantitySchedule.stream().filter(b->b!=null).<NotionalPeriod.NotionalPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (spread!=null && !spread.prune().hasData()) spread = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriodicPayment()!=null && getPeriodicPayment().hasData()) return true;
			if (getNotionalAmount()!=null) return true;
			if (getNotionalAmountSchedule()!=null && getNotionalAmountSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotionalQuantitySchedule()!=null && getNotionalQuantitySchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotionalCurrency()!=null) return true;
			if (getTotalNotionalQuantity()!=null) return true;
			if (getFixedRate()!=null) return true;
			if (getSettlementCurrency()!=null) return true;
			if (getSpread()!=null && getSpread().hasData()) return true;
			if (getSpreadNotation()!=null) return true;
			if (getSpreadCurrency()!=null) return true;
			if (getQuantityUnitOfMeasure()!=null) return true;
			if (getDirection2()!=null) return true;
			if (getNotionalQuantity()!=null) return true;
			if (getFixingDate()!=null) return true;
			if (getQuantityFrequency()!=null) return true;
			if (getQuantityFrequencyMultiplier()!=null) return true;
			if (getPayerIdentifier()!=null) return true;
			if (getReceiverIdentifier()!=null) return true;
			if (getSettlementLocation()!=null) return true;
			if (getNextFloatingReferenceResetDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonLeg.CommonLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonLeg.CommonLegBuilder o = (CommonLeg.CommonLegBuilder) other;
			
			merger.mergeRosetta(getPeriodicPayment(), o.getPeriodicPayment(), this::setPeriodicPayment);
			merger.mergeRosetta(getNotionalAmountSchedule(), o.getNotionalAmountSchedule(), this::getOrCreateNotionalAmountSchedule);
			merger.mergeRosetta(getNotionalQuantitySchedule(), o.getNotionalQuantitySchedule(), this::getOrCreateNotionalQuantitySchedule);
			merger.mergeRosetta(getSpread(), o.getSpread(), this::setSpread);
			
			merger.mergeBasic(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeBasic(getNotionalCurrency(), o.getNotionalCurrency(), this::setNotionalCurrency);
			merger.mergeBasic(getTotalNotionalQuantity(), o.getTotalNotionalQuantity(), this::setTotalNotionalQuantity);
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeBasic(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeBasic(getSpreadNotation(), o.getSpreadNotation(), this::setSpreadNotation);
			merger.mergeBasic(getSpreadCurrency(), o.getSpreadCurrency(), this::setSpreadCurrency);
			merger.mergeBasic(getQuantityUnitOfMeasure(), o.getQuantityUnitOfMeasure(), this::setQuantityUnitOfMeasure);
			merger.mergeBasic(getDirection2(), o.getDirection2(), this::setDirection2);
			merger.mergeBasic(getNotionalQuantity(), o.getNotionalQuantity(), this::setNotionalQuantity);
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			merger.mergeBasic(getQuantityFrequency(), o.getQuantityFrequency(), this::setQuantityFrequency);
			merger.mergeBasic(getQuantityFrequencyMultiplier(), o.getQuantityFrequencyMultiplier(), this::setQuantityFrequencyMultiplier);
			merger.mergeBasic(getPayerIdentifier(), o.getPayerIdentifier(), this::setPayerIdentifier);
			merger.mergeBasic(getReceiverIdentifier(), o.getReceiverIdentifier(), this::setReceiverIdentifier);
			merger.mergeBasic(getSettlementLocation(), o.getSettlementLocation(), this::setSettlementLocation);
			merger.mergeBasic(getNextFloatingReferenceResetDate(), o.getNextFloatingReferenceResetDate(), this::setNextFloatingReferenceResetDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonLeg _that = getType().cast(o);
		
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(notionalAmountSchedule, _that.getNotionalAmountSchedule())) return false;
			if (!ListEquals.listEquals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(spreadNotation, _that.getSpreadNotation())) return false;
			if (!Objects.equals(spreadCurrency, _that.getSpreadCurrency())) return false;
			if (!Objects.equals(quantityUnitOfMeasure, _that.getQuantityUnitOfMeasure())) return false;
			if (!Objects.equals(direction2, _that.getDirection2())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(quantityFrequencyMultiplier, _that.getQuantityFrequencyMultiplier())) return false;
			if (!Objects.equals(payerIdentifier, _that.getPayerIdentifier())) return false;
			if (!Objects.equals(receiverIdentifier, _that.getReceiverIdentifier())) return false;
			if (!Objects.equals(settlementLocation, _that.getSettlementLocation())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDate, _that.getNextFloatingReferenceResetDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountSchedule != null ? notionalAmountSchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (spreadNotation != null ? spreadNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spreadCurrency != null ? spreadCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantityUnitOfMeasure != null ? quantityUnitOfMeasure.hashCode() : 0);
			_result = 31 * _result + (direction2 != null ? direction2.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantityFrequencyMultiplier != null ? quantityFrequencyMultiplier.hashCode() : 0);
			_result = 31 * _result + (payerIdentifier != null ? payerIdentifier.hashCode() : 0);
			_result = 31 * _result + (receiverIdentifier != null ? receiverIdentifier.hashCode() : 0);
			_result = 31 * _result + (settlementLocation != null ? settlementLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDate != null ? nextFloatingReferenceResetDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonLegBuilder {" +
				"periodicPayment=" + this.periodicPayment + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountSchedule=" + this.notionalAmountSchedule + ", " +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalCurrency=" + this.notionalCurrency + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"spread=" + this.spread + ", " +
				"spreadNotation=" + this.spreadNotation + ", " +
				"spreadCurrency=" + this.spreadCurrency + ", " +
				"quantityUnitOfMeasure=" + this.quantityUnitOfMeasure + ", " +
				"direction2=" + this.direction2 + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"quantityFrequencyMultiplier=" + this.quantityFrequencyMultiplier + ", " +
				"payerIdentifier=" + this.payerIdentifier + ", " +
				"receiverIdentifier=" + this.receiverIdentifier + ", " +
				"settlementLocation=" + this.settlementLocation + ", " +
				"nextFloatingReferenceResetDate=" + this.nextFloatingReferenceResetDate +
			'}';
		}
	}
}
