package drr.regulation.sec.rewrite.trade;

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
import drr.regulation.sec.rewrite.trade.meta.SECLegMeta;
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
@RosettaDataType(value="SECLeg", builder=SECLeg.SECLegBuilderImpl.class, version="7.7.0")
@RuneDataType(value="SECLeg", model="drr", builder=SECLeg.SECLegBuilderImpl.class, version="7.7.0")
public interface SECLeg extends CommonLeg {

	SECLegMeta metaData = new SECLegMeta();

	/*********************** Getter Methods  ***********************/
	String getFloatingRateIndex();

	/*********************** Build Methods  ***********************/
	SECLeg build();
	
	SECLeg.SECLegBuilder toBuilder();
	
	static SECLeg.SECLegBuilder builder() {
		return new SECLeg.SECLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SECLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SECLeg> getType() {
		return SECLeg.class;
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
		processor.processBasic(path.newSubPath("floatingRateIndex"), String.class, getFloatingRateIndex(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SECLegBuilder extends SECLeg, CommonLeg.CommonLegBuilder {
		@Override
		SECLeg.SECLegBuilder setPeriodicPayment(PeriodicPayment periodicPayment);
		@Override
		SECLeg.SECLegBuilder setNotionalAmount(BigDecimal notionalAmount);
		@Override
		SECLeg.SECLegBuilder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule);
		@Override
		SECLeg.SECLegBuilder addNotionalAmountSchedule(NotionalPeriod notionalAmountSchedule, int idx);
		@Override
		SECLeg.SECLegBuilder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		@Override
		SECLeg.SECLegBuilder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedule);
		@Override
		SECLeg.SECLegBuilder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule);
		@Override
		SECLeg.SECLegBuilder addNotionalQuantitySchedule(NotionalPeriod notionalQuantitySchedule, int idx);
		@Override
		SECLeg.SECLegBuilder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		@Override
		SECLeg.SECLegBuilder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedule);
		@Override
		SECLeg.SECLegBuilder setNotionalCurrency(ISOCurrencyCodeEnum notionalCurrency);
		@Override
		SECLeg.SECLegBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		@Override
		SECLeg.SECLegBuilder setFixedRate(BigDecimal fixedRate);
		@Override
		SECLeg.SECLegBuilder setSettlementCurrency(ISOCurrencyCodeEnum settlementCurrency);
		@Override
		SECLeg.SECLegBuilder setSpread(PriceFormat spread);
		@Override
		SECLeg.SECLegBuilder setSpreadNotation(PriceNotationEnum spreadNotation);
		@Override
		SECLeg.SECLegBuilder setSpreadCurrency(ISOCurrencyCodeEnum spreadCurrency);
		@Override
		SECLeg.SECLegBuilder setQuantityUnitOfMeasure(String quantityUnitOfMeasure);
		@Override
		SECLeg.SECLegBuilder setDirection2(Direction2Enum direction2);
		@Override
		SECLeg.SECLegBuilder setPeriodicPayment(CommonPeriodicPayment periodicPayment);
		@Override
		SECLeg.SECLegBuilder setNotionalQuantity(BigDecimal notionalQuantity);
		@Override
		SECLeg.SECLegBuilder setFixingDate(ZonedDateTime fixingDate);
		@Override
		SECLeg.SECLegBuilder setQuantityFrequency(FrequencyPeriodEnum quantityFrequency);
		@Override
		SECLeg.SECLegBuilder setQuantityFrequencyMultiplier(Integer quantityFrequencyMultiplier);
		@Override
		SECLeg.SECLegBuilder setPayerIdentifier(String payerIdentifier);
		@Override
		SECLeg.SECLegBuilder setReceiverIdentifier(String receiverIdentifier);
		@Override
		SECLeg.SECLegBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		SECLeg.SECLegBuilder setNextFloatingReferenceResetDate(Date nextFloatingReferenceResetDate);
		SECLeg.SECLegBuilder setFloatingRateIndex(String floatingRateIndex);

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
			processor.processBasic(path.newSubPath("floatingRateIndex"), String.class, getFloatingRateIndex(), this);
		}
		

		SECLeg.SECLegBuilder prune();
	}

	/*********************** Immutable Implementation of SECLeg  ***********************/
	class SECLegImpl extends CommonLeg.CommonLegImpl implements SECLeg {
		private final String floatingRateIndex;
		
		protected SECLegImpl(SECLeg.SECLegBuilder builder) {
			super(builder);
			this.floatingRateIndex = builder.getFloatingRateIndex();
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndex")
		public String getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public SECLeg build() {
			return this;
		}
		
		@Override
		public SECLeg.SECLegBuilder toBuilder() {
			SECLeg.SECLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SECLeg.SECLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SECLeg _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SECLeg {" +
				"floatingRateIndex=" + this.floatingRateIndex +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SECLeg  ***********************/
	class SECLegBuilderImpl extends CommonLeg.CommonLegBuilderImpl implements SECLeg.SECLegBuilder {
	
		protected String floatingRateIndex;
		
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
		public SECLeg.SECLegBuilder setPeriodicPayment(CommonPeriodicPayment _periodicPayment) {
			this.periodicPayment = _periodicPayment == null ? null : _periodicPayment.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECLeg.SECLegBuilder setPeriodicPayment(PeriodicPayment _periodicPayment) {
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
		public SECLeg.SECLegBuilder setNotionalAmount(BigDecimal _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount;
			return this;
		}
		
		@RosettaAttribute("notionalAmountSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalAmountSchedule")
		@Override
		public SECLeg.SECLegBuilder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule) {
			if (_notionalAmountSchedule != null) {
				this.notionalAmountSchedule.add(_notionalAmountSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECLeg.SECLegBuilder addNotionalAmountSchedule(NotionalPeriod _notionalAmountSchedule, int idx) {
			getIndex(this.notionalAmountSchedule, idx, () -> _notionalAmountSchedule.toBuilder());
			return this;
		}
		
		@Override
		public SECLeg.SECLegBuilder addNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
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
		public SECLeg.SECLegBuilder setNotionalAmountSchedule(List<? extends NotionalPeriod> notionalAmountSchedules) {
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
		public SECLeg.SECLegBuilder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule) {
			if (_notionalQuantitySchedule != null) {
				this.notionalQuantitySchedule.add(_notionalQuantitySchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECLeg.SECLegBuilder addNotionalQuantitySchedule(NotionalPeriod _notionalQuantitySchedule, int idx) {
			getIndex(this.notionalQuantitySchedule, idx, () -> _notionalQuantitySchedule.toBuilder());
			return this;
		}
		
		@Override
		public SECLeg.SECLegBuilder addNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
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
		public SECLeg.SECLegBuilder setNotionalQuantitySchedule(List<? extends NotionalPeriod> notionalQuantitySchedules) {
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
		public SECLeg.SECLegBuilder setNotionalCurrency(ISOCurrencyCodeEnum _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public SECLeg.SECLegBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public SECLeg.SECLegBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public SECLeg.SECLegBuilder setSettlementCurrency(ISOCurrencyCodeEnum _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency;
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public SECLeg.SECLegBuilder setSpread(PriceFormat _spread) {
			this.spread = _spread == null ? null : _spread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadNotation")
		@Override
		public SECLeg.SECLegBuilder setSpreadNotation(PriceNotationEnum _spreadNotation) {
			this.spreadNotation = _spreadNotation == null ? null : _spreadNotation;
			return this;
		}
		
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadCurrency")
		@Override
		public SECLeg.SECLegBuilder setSpreadCurrency(ISOCurrencyCodeEnum _spreadCurrency) {
			this.spreadCurrency = _spreadCurrency == null ? null : _spreadCurrency;
			return this;
		}
		
		@RosettaAttribute("quantityUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityUnitOfMeasure")
		@Override
		public SECLeg.SECLegBuilder setQuantityUnitOfMeasure(String _quantityUnitOfMeasure) {
			this.quantityUnitOfMeasure = _quantityUnitOfMeasure == null ? null : _quantityUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("direction2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction2")
		@Override
		public SECLeg.SECLegBuilder setDirection2(Direction2Enum _direction2) {
			this.direction2 = _direction2 == null ? null : _direction2;
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public SECLeg.SECLegBuilder setNotionalQuantity(BigDecimal _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity;
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingDate")
		@Override
		public SECLeg.SECLegBuilder setFixingDate(ZonedDateTime _fixingDate) {
			this.fixingDate = _fixingDate == null ? null : _fixingDate;
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequency")
		@Override
		public SECLeg.SECLegBuilder setQuantityFrequency(FrequencyPeriodEnum _quantityFrequency) {
			this.quantityFrequency = _quantityFrequency == null ? null : _quantityFrequency;
			return this;
		}
		
		@RosettaAttribute("quantityFrequencyMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequencyMultiplier")
		@Override
		public SECLeg.SECLegBuilder setQuantityFrequencyMultiplier(Integer _quantityFrequencyMultiplier) {
			this.quantityFrequencyMultiplier = _quantityFrequencyMultiplier == null ? null : _quantityFrequencyMultiplier;
			return this;
		}
		
		@RosettaAttribute("payerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerIdentifier")
		@Override
		public SECLeg.SECLegBuilder setPayerIdentifier(String _payerIdentifier) {
			this.payerIdentifier = _payerIdentifier == null ? null : _payerIdentifier;
			return this;
		}
		
		@RosettaAttribute("receiverIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverIdentifier")
		@Override
		public SECLeg.SECLegBuilder setReceiverIdentifier(String _receiverIdentifier) {
			this.receiverIdentifier = _receiverIdentifier == null ? null : _receiverIdentifier;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public SECLeg.SECLegBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDate")
		@Override
		public SECLeg.SECLegBuilder setNextFloatingReferenceResetDate(Date _nextFloatingReferenceResetDate) {
			this.nextFloatingReferenceResetDate = _nextFloatingReferenceResetDate == null ? null : _nextFloatingReferenceResetDate;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateIndex")
		@Override
		public SECLeg.SECLegBuilder setFloatingRateIndex(String _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex;
			return this;
		}
		
		@Override
		public SECLeg build() {
			return new SECLeg.SECLegImpl(this);
		}
		
		@Override
		public SECLeg.SECLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SECLeg.SECLegBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateIndex()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SECLeg.SECLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SECLeg.SECLegBuilder o = (SECLeg.SECLegBuilder) other;
			
			
			merger.mergeBasic(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SECLeg _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SECLegBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex +
			'}' + " " + super.toString();
		}
	}
}
