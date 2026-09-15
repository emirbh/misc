package drr.regulation.cftc.rewrite.trade;

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
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.regulation.cftc.rewrite.trade.meta.CFTCPart45LegMeta;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
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
@RosettaDataType(value="CFTCPart45Leg", builder=CFTCPart45Leg.CFTCPart45LegBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CFTCPart45Leg", model="drr", builder=CFTCPart45Leg.CFTCPart45LegBuilderImpl.class, version="7.7.0")
public interface CFTCPart45Leg extends CommonLeg {

	CFTCPart45LegMeta metaData = new CFTCPart45LegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * PayerIdentifierLeg1 Format - LEI, or LEI and Person.
	 */
	PartyIdentifierFormatEnum getPayerIdentifierFormat();
	/**
	 * ReceiverIdentifierLeg1 Format - LEI, or LEI and Person.
	 */
	PartyIdentifierFormatEnum getReceiverIdentifierFormat();

	/*********************** Build Methods  ***********************/
	CFTCPart45Leg build();
	
	CFTCPart45Leg.CFTCPart45LegBuilder toBuilder();
	
	static CFTCPart45Leg.CFTCPart45LegBuilder builder() {
		return new CFTCPart45Leg.CFTCPart45LegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CFTCPart45Leg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CFTCPart45Leg> getType() {
		return CFTCPart45Leg.class;
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
		processor.processBasic(path.newSubPath("payerIdentifierFormat"), PartyIdentifierFormatEnum.class, getPayerIdentifierFormat(), this);
		processor.processBasic(path.newSubPath("receiverIdentifierFormat"), PartyIdentifierFormatEnum.class, getReceiverIdentifierFormat(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CFTCPart45LegBuilder extends CFTCPart45Leg, CommonLeg.CommonLegBuilder {
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setPeriodicPayment(PeriodicPayment periodicPayment);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setNotionalAmount(BigDecimal notionalAmount);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule, int idx);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule, int idx);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setNotionalCurrency(ISOCurrencyCodeEnum notionalCurrency);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setFixedRate(BigDecimal fixedRate);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setSettlementCurrency(ISOCurrencyCodeEnum settlementCurrency);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setSpread(PriceFormat spread);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setSpreadNotation(PriceNotationEnum spreadNotation);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setSpreadCurrency(ISOCurrencyCodeEnum spreadCurrency);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setQuantityUnitOfMeasure(String quantityUnitOfMeasure);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setDirection2(Direction2Enum direction2);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setPeriodicPayment(CommonPeriodicPayment periodicPayment);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setNotionalQuantity(BigDecimal notionalQuantity);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setFixingDate(ZonedDateTime fixingDate);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setQuantityFrequency(FrequencyPeriodEnum quantityFrequency);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setQuantityFrequencyMultiplier(Integer quantityFrequencyMultiplier);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setPayerIdentifier(String payerIdentifier);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setReceiverIdentifier(String receiverIdentifier);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		CFTCPart45Leg.CFTCPart45LegBuilder setNextFloatingReferenceResetDate(Date nextFloatingReferenceResetDate);
		CFTCPart45Leg.CFTCPart45LegBuilder setPayerIdentifierFormat(PartyIdentifierFormatEnum payerIdentifierFormat);
		CFTCPart45Leg.CFTCPart45LegBuilder setReceiverIdentifierFormat(PartyIdentifierFormatEnum receiverIdentifierFormat);

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
			processor.processBasic(path.newSubPath("payerIdentifierFormat"), PartyIdentifierFormatEnum.class, getPayerIdentifierFormat(), this);
			processor.processBasic(path.newSubPath("receiverIdentifierFormat"), PartyIdentifierFormatEnum.class, getReceiverIdentifierFormat(), this);
		}
		

		CFTCPart45Leg.CFTCPart45LegBuilder prune();
	}

	/*********************** Immutable Implementation of CFTCPart45Leg  ***********************/
	class CFTCPart45LegImpl extends CommonLeg.CommonLegImpl implements CFTCPart45Leg {
		private final PartyIdentifierFormatEnum payerIdentifierFormat;
		private final PartyIdentifierFormatEnum receiverIdentifierFormat;
		
		protected CFTCPart45LegImpl(CFTCPart45Leg.CFTCPart45LegBuilder builder) {
			super(builder);
			this.payerIdentifierFormat = builder.getPayerIdentifierFormat();
			this.receiverIdentifierFormat = builder.getReceiverIdentifierFormat();
		}
		
		@Override
		@RosettaAttribute("payerIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerIdentifierFormat")
		public PartyIdentifierFormatEnum getPayerIdentifierFormat() {
			return payerIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("receiverIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverIdentifierFormat")
		public PartyIdentifierFormatEnum getReceiverIdentifierFormat() {
			return receiverIdentifierFormat;
		}
		
		@Override
		public CFTCPart45Leg build() {
			return this;
		}
		
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder toBuilder() {
			CFTCPart45Leg.CFTCPart45LegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CFTCPart45Leg.CFTCPart45LegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerIdentifierFormat()).ifPresent(builder::setPayerIdentifierFormat);
			ofNullable(getReceiverIdentifierFormat()).ifPresent(builder::setReceiverIdentifierFormat);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCPart45Leg _that = getType().cast(o);
		
			if (!Objects.equals(payerIdentifierFormat, _that.getPayerIdentifierFormat())) return false;
			if (!Objects.equals(receiverIdentifierFormat, _that.getReceiverIdentifierFormat())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerIdentifierFormat != null ? payerIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (receiverIdentifierFormat != null ? receiverIdentifierFormat.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCPart45Leg {" +
				"payerIdentifierFormat=" + this.payerIdentifierFormat + ", " +
				"receiverIdentifierFormat=" + this.receiverIdentifierFormat +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CFTCPart45Leg  ***********************/
	class CFTCPart45LegBuilderImpl extends CommonLeg.CommonLegBuilderImpl implements CFTCPart45Leg.CFTCPart45LegBuilder {
	
		protected PartyIdentifierFormatEnum payerIdentifierFormat;
		protected PartyIdentifierFormatEnum receiverIdentifierFormat;
		
		@Override
		@RosettaAttribute("payerIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerIdentifierFormat")
		public PartyIdentifierFormatEnum getPayerIdentifierFormat() {
			return payerIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("receiverIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverIdentifierFormat")
		public PartyIdentifierFormatEnum getReceiverIdentifierFormat() {
			return receiverIdentifierFormat;
		}
		
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodicPayment")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setPeriodicPayment(CommonPeriodicPayment _periodicPayment) {
			this.periodicPayment = _periodicPayment == null ? null : _periodicPayment.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setPeriodicPayment(PeriodicPayment _periodicPayment) {
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
		public CFTCPart45Leg.CFTCPart45LegBuilder setNotionalAmount(BigDecimal _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount;
			return this;
		}
		
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule) {
			if (_notionalAmountSchedule != null) {
				this.notionalAmountSchedule.add(_notionalAmountSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule, int idx) {
			getIndex(this.notionalAmountSchedule, idx, () -> _notionalAmountSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
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
		public CFTCPart45Leg.CFTCPart45LegBuilder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
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
		public CFTCPart45Leg.CFTCPart45LegBuilder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule) {
			if (_notionalQuantitySchedule != null) {
				this.notionalQuantitySchedule.add(_notionalQuantitySchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule, int idx) {
			getIndex(this.notionalQuantitySchedule, idx, () -> _notionalQuantitySchedule.toBuilder());
			return this;
		}
		
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
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
		public CFTCPart45Leg.CFTCPart45LegBuilder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
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
		public CFTCPart45Leg.CFTCPart45LegBuilder setNotionalCurrency(ISOCurrencyCodeEnum _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setSettlementCurrency(ISOCurrencyCodeEnum _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency;
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setSpread(PriceFormat _spread) {
			this.spread = _spread == null ? null : _spread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadNotation")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setSpreadNotation(PriceNotationEnum _spreadNotation) {
			this.spreadNotation = _spreadNotation == null ? null : _spreadNotation;
			return this;
		}
		
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadCurrency")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setSpreadCurrency(ISOCurrencyCodeEnum _spreadCurrency) {
			this.spreadCurrency = _spreadCurrency == null ? null : _spreadCurrency;
			return this;
		}
		
		@RosettaAttribute("quantityUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityUnitOfMeasure")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setQuantityUnitOfMeasure(String _quantityUnitOfMeasure) {
			this.quantityUnitOfMeasure = _quantityUnitOfMeasure == null ? null : _quantityUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("direction2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction2")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setDirection2(Direction2Enum _direction2) {
			this.direction2 = _direction2 == null ? null : _direction2;
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setNotionalQuantity(BigDecimal _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity;
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingDate")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setFixingDate(ZonedDateTime _fixingDate) {
			this.fixingDate = _fixingDate == null ? null : _fixingDate;
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequency")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setQuantityFrequency(FrequencyPeriodEnum _quantityFrequency) {
			this.quantityFrequency = _quantityFrequency == null ? null : _quantityFrequency;
			return this;
		}
		
		@RosettaAttribute("quantityFrequencyMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequencyMultiplier")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setQuantityFrequencyMultiplier(Integer _quantityFrequencyMultiplier) {
			this.quantityFrequencyMultiplier = _quantityFrequencyMultiplier == null ? null : _quantityFrequencyMultiplier;
			return this;
		}
		
		@RosettaAttribute("payerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerIdentifier")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setPayerIdentifier(String _payerIdentifier) {
			this.payerIdentifier = _payerIdentifier == null ? null : _payerIdentifier;
			return this;
		}
		
		@RosettaAttribute("receiverIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverIdentifier")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setReceiverIdentifier(String _receiverIdentifier) {
			this.receiverIdentifier = _receiverIdentifier == null ? null : _receiverIdentifier;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDate")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setNextFloatingReferenceResetDate(Date _nextFloatingReferenceResetDate) {
			this.nextFloatingReferenceResetDate = _nextFloatingReferenceResetDate == null ? null : _nextFloatingReferenceResetDate;
			return this;
		}
		
		@RosettaAttribute("payerIdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerIdentifierFormat")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setPayerIdentifierFormat(PartyIdentifierFormatEnum _payerIdentifierFormat) {
			this.payerIdentifierFormat = _payerIdentifierFormat == null ? null : _payerIdentifierFormat;
			return this;
		}
		
		@RosettaAttribute("receiverIdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverIdentifierFormat")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder setReceiverIdentifierFormat(PartyIdentifierFormatEnum _receiverIdentifierFormat) {
			this.receiverIdentifierFormat = _receiverIdentifierFormat == null ? null : _receiverIdentifierFormat;
			return this;
		}
		
		@Override
		public CFTCPart45Leg build() {
			return new CFTCPart45Leg.CFTCPart45LegImpl(this);
		}
		
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerIdentifierFormat()!=null) return true;
			if (getReceiverIdentifierFormat()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCPart45Leg.CFTCPart45LegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CFTCPart45Leg.CFTCPart45LegBuilder o = (CFTCPart45Leg.CFTCPart45LegBuilder) other;
			
			
			merger.mergeBasic(getPayerIdentifierFormat(), o.getPayerIdentifierFormat(), this::setPayerIdentifierFormat);
			merger.mergeBasic(getReceiverIdentifierFormat(), o.getReceiverIdentifierFormat(), this::setReceiverIdentifierFormat);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCPart45Leg _that = getType().cast(o);
		
			if (!Objects.equals(payerIdentifierFormat, _that.getPayerIdentifierFormat())) return false;
			if (!Objects.equals(receiverIdentifierFormat, _that.getReceiverIdentifierFormat())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerIdentifierFormat != null ? payerIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (receiverIdentifierFormat != null ? receiverIdentifierFormat.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCPart45LegBuilder {" +
				"payerIdentifierFormat=" + this.payerIdentifierFormat + ", " +
				"receiverIdentifierFormat=" + this.receiverIdentifierFormat +
			'}' + " " + super.toString();
		}
	}
}
