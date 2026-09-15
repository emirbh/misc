package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.FixedLegMeta;
import fpml.consolidated.fpmlenum.FlatRateEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Fixed Price Leg.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Fixed Price Leg.
 *
 */
@RosettaDataType(value="FixedLeg", builder=FixedLeg.FixedLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FixedLeg", model="fpml", builder=FixedLeg.FixedLegBuilderImpl.class, version="2.1.1")
public interface FixedLeg extends FixedPriceLeg {

	FixedLegMeta metaData = new FixedLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FixedLeg build();
	
	FixedLeg.FixedLegBuilder toBuilder();
	
	static FixedLeg.FixedLegBuilder builder() {
		return new FixedLeg.FixedLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FixedLeg> getType() {
		return FixedLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableDates.class, getCalculationDates());
		processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.class, getCalculationPeriods());
		processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getCalculationPeriodsSchedule());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
		processRosetta(path.newSubPath("fixedPriceSchedule"), processor, CommodityFixedPriceSchedule.class, getFixedPriceSchedule());
		processRosetta(path.newSubPath("fixedPrice"), processor, CommodityFixedPrice.class, getFixedPrice());
		processor.processBasic(path.newSubPath("worldscaleRate"), BigDecimal.class, getWorldscaleRate(), this);
		processRosetta(path.newSubPath("contractRate"), processor, NonNegativeMoney.class, getContractRate());
		processRosetta(path.newSubPath("settlementPeriodsPrice"), processor, SettlementPeriodsFixedPrice.class, getSettlementPeriodsPrice());
		processRosetta(path.newSubPath("totalPrice"), processor, NonNegativeMoney.class, getTotalPrice());
		processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.class, getNotionalQuantitySchedule());
		processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.class, getNotionalQuantity());
		processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.class, getSettlementPeriodsNotionalQuantity());
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.class, getQuantityReference());
		processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.class, getRelativePaymentDates());
		processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.class, getPaymentDates());
		processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
		processor.processBasic(path.newSubPath("flatRate"), FlatRateEnum.class, getFlatRate(), this);
		processRosetta(path.newSubPath("flatRateAmount"), processor, NonNegativeMoney.class, getFlatRateAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedLegBuilder extends FixedLeg, FixedPriceLeg.FixedPriceLegBuilder {
		@Override
		FixedLeg.FixedLegBuilder setId(String id);
		@Override
		FixedLeg.FixedLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		FixedLeg.FixedLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		FixedLeg.FixedLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		FixedLeg.FixedLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		FixedLeg.FixedLegBuilder setCalculationDates(AdjustableDates calculationDates);
		@Override
		FixedLeg.FixedLegBuilder setCalculationPeriods(AdjustableDates calculationPeriods);
		@Override
		FixedLeg.FixedLegBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		@Override
		FixedLeg.FixedLegBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		@Override
		FixedLeg.FixedLegBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		@Override
		FixedLeg.FixedLegBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);
		@Override
		FixedLeg.FixedLegBuilder setFixedPriceSchedule(CommodityFixedPriceSchedule fixedPriceSchedule);
		@Override
		FixedLeg.FixedLegBuilder setFixedPrice(CommodityFixedPrice fixedPrice);
		@Override
		FixedLeg.FixedLegBuilder setWorldscaleRate(BigDecimal worldscaleRate);
		@Override
		FixedLeg.FixedLegBuilder setContractRate(NonNegativeMoney contractRate);
		@Override
		FixedLeg.FixedLegBuilder addSettlementPeriodsPrice(SettlementPeriodsFixedPrice settlementPeriodsPrice);
		@Override
		FixedLeg.FixedLegBuilder addSettlementPeriodsPrice(SettlementPeriodsFixedPrice settlementPeriodsPrice, int idx);
		@Override
		FixedLeg.FixedLegBuilder addSettlementPeriodsPrice(List<? extends SettlementPeriodsFixedPrice> settlementPeriodsPrice);
		@Override
		FixedLeg.FixedLegBuilder setSettlementPeriodsPrice(List<? extends SettlementPeriodsFixedPrice> settlementPeriodsPrice);
		@Override
		FixedLeg.FixedLegBuilder setTotalPrice(NonNegativeMoney totalPrice);
		@Override
		FixedLeg.FixedLegBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule notionalQuantitySchedule);
		@Override
		FixedLeg.FixedLegBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity);
		@Override
		FixedLeg.FixedLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity);
		@Override
		FixedLeg.FixedLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity, int idx);
		@Override
		FixedLeg.FixedLegBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		@Override
		FixedLeg.FixedLegBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		@Override
		FixedLeg.FixedLegBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		@Override
		FixedLeg.FixedLegBuilder setQuantityReference(QuantityReference quantityReference);
		@Override
		FixedLeg.FixedLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates relativePaymentDates);
		@Override
		FixedLeg.FixedLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset paymentDates);
		@Override
		FixedLeg.FixedLegBuilder setMasterAgreementPaymentDates(Boolean masterAgreementPaymentDates);
		@Override
		FixedLeg.FixedLegBuilder setFlatRate(FlatRateEnum flatRate);
		@Override
		FixedLeg.FixedLegBuilder setFlatRateAmount(NonNegativeMoney flatRateAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationPeriods());
			processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getCalculationPeriodsSchedule());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
			processRosetta(path.newSubPath("fixedPriceSchedule"), processor, CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder.class, getFixedPriceSchedule());
			processRosetta(path.newSubPath("fixedPrice"), processor, CommodityFixedPrice.CommodityFixedPriceBuilder.class, getFixedPrice());
			processor.processBasic(path.newSubPath("worldscaleRate"), BigDecimal.class, getWorldscaleRate(), this);
			processRosetta(path.newSubPath("contractRate"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getContractRate());
			processRosetta(path.newSubPath("settlementPeriodsPrice"), processor, SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder.class, getSettlementPeriodsPrice());
			processRosetta(path.newSubPath("totalPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getTotalPrice());
			processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder.class, getNotionalQuantitySchedule());
			processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalQuantity());
			processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder.class, getSettlementPeriodsNotionalQuantity());
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
			processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.QuantityReferenceBuilder.class, getQuantityReference());
			processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getRelativePaymentDates());
			processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder.class, getPaymentDates());
			processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
			processor.processBasic(path.newSubPath("flatRate"), FlatRateEnum.class, getFlatRate(), this);
			processRosetta(path.newSubPath("flatRateAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getFlatRateAmount());
		}
		

		FixedLeg.FixedLegBuilder prune();
	}

	/*********************** Immutable Implementation of FixedLeg  ***********************/
	class FixedLegImpl extends FixedPriceLeg.FixedPriceLegImpl implements FixedLeg {
		
		protected FixedLegImpl(FixedLeg.FixedLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public FixedLeg build() {
			return this;
		}
		
		@Override
		public FixedLeg.FixedLegBuilder toBuilder() {
			FixedLeg.FixedLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedLeg.FixedLegBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedLeg  ***********************/
	class FixedLegBuilderImpl extends FixedPriceLeg.FixedPriceLegBuilderImpl implements FixedLeg.FixedLegBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FixedLeg.FixedLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public FixedLeg.FixedLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FixedLeg.FixedLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FixedLeg.FixedLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FixedLeg.FixedLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public FixedLeg.FixedLegBuilder setCalculationDates(AdjustableDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriods")
		@Override
		public FixedLeg.FixedLegBuilder setCalculationPeriods(AdjustableDates _calculationPeriods) {
			this.calculationPeriods = _calculationPeriods == null ? null : _calculationPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		@Override
		public FixedLeg.FixedLegBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule _calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = _calculationPeriodsSchedule == null ? null : _calculationPeriodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public FixedLeg.FixedLegBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public FixedLeg.FixedLegBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public FixedLeg.FixedLegBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedPriceSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedPriceSchedule")
		@Override
		public FixedLeg.FixedLegBuilder setFixedPriceSchedule(CommodityFixedPriceSchedule _fixedPriceSchedule) {
			this.fixedPriceSchedule = _fixedPriceSchedule == null ? null : _fixedPriceSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedPrice")
		@Override
		public FixedLeg.FixedLegBuilder setFixedPrice(CommodityFixedPrice _fixedPrice) {
			this.fixedPrice = _fixedPrice == null ? null : _fixedPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("worldscaleRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("worldscaleRate")
		@Override
		public FixedLeg.FixedLegBuilder setWorldscaleRate(BigDecimal _worldscaleRate) {
			this.worldscaleRate = _worldscaleRate == null ? null : _worldscaleRate;
			return this;
		}
		
		@RosettaAttribute("contractRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractRate")
		@Override
		public FixedLeg.FixedLegBuilder setContractRate(NonNegativeMoney _contractRate) {
			this.contractRate = _contractRate == null ? null : _contractRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsPrice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsPrice")
		@Override
		public FixedLeg.FixedLegBuilder addSettlementPeriodsPrice(SettlementPeriodsFixedPrice _settlementPeriodsPrice) {
			if (_settlementPeriodsPrice != null) {
				this.settlementPeriodsPrice.add(_settlementPeriodsPrice.toBuilder());
			}
			return this;
		}
		
		@Override
		public FixedLeg.FixedLegBuilder addSettlementPeriodsPrice(SettlementPeriodsFixedPrice _settlementPeriodsPrice, int idx) {
			getIndex(this.settlementPeriodsPrice, idx, () -> _settlementPeriodsPrice.toBuilder());
			return this;
		}
		
		@Override
		public FixedLeg.FixedLegBuilder addSettlementPeriodsPrice(List<? extends SettlementPeriodsFixedPrice> settlementPeriodsPrices) {
			if (settlementPeriodsPrices != null) {
				for (final SettlementPeriodsFixedPrice toAdd : settlementPeriodsPrices) {
					this.settlementPeriodsPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsPrice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsPrice")
		@Override
		public FixedLeg.FixedLegBuilder setSettlementPeriodsPrice(List<? extends SettlementPeriodsFixedPrice> settlementPeriodsPrices) {
			if (settlementPeriodsPrices == null) {
				this.settlementPeriodsPrice = new ArrayList<>();
			} else {
				this.settlementPeriodsPrice = settlementPeriodsPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("totalPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalPrice")
		@Override
		public FixedLeg.FixedLegBuilder setTotalPrice(NonNegativeMoney _totalPrice) {
			this.totalPrice = _totalPrice == null ? null : _totalPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantitySchedule")
		@Override
		public FixedLeg.FixedLegBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule _notionalQuantitySchedule) {
			this.notionalQuantitySchedule = _notionalQuantitySchedule == null ? null : _notionalQuantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public FixedLeg.FixedLegBuilder setNotionalQuantity(CommodityNotionalQuantity _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		@Override
		public FixedLeg.FixedLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity) {
			if (_settlementPeriodsNotionalQuantity != null) {
				this.settlementPeriodsNotionalQuantity.add(_settlementPeriodsNotionalQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public FixedLeg.FixedLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity, int idx) {
			getIndex(this.settlementPeriodsNotionalQuantity, idx, () -> _settlementPeriodsNotionalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public FixedLeg.FixedLegBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
			if (settlementPeriodsNotionalQuantitys != null) {
				for (final CommoditySettlementPeriodsNotionalQuantity toAdd : settlementPeriodsNotionalQuantitys) {
					this.settlementPeriodsNotionalQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		@Override
		public FixedLeg.FixedLegBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
			if (settlementPeriodsNotionalQuantitys == null) {
				this.settlementPeriodsNotionalQuantity = new ArrayList<>();
			} else {
				this.settlementPeriodsNotionalQuantity = settlementPeriodsNotionalQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public FixedLeg.FixedLegBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityReference")
		@Override
		public FixedLeg.FixedLegBuilder setQuantityReference(QuantityReference _quantityReference) {
			this.quantityReference = _quantityReference == null ? null : _quantityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePaymentDates")
		@Override
		public FixedLeg.FixedLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates _relativePaymentDates) {
			this.relativePaymentDates = _relativePaymentDates == null ? null : _relativePaymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDates")
		@Override
		public FixedLeg.FixedLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		@Override
		public FixedLeg.FixedLegBuilder setMasterAgreementPaymentDates(Boolean _masterAgreementPaymentDates) {
			this.masterAgreementPaymentDates = _masterAgreementPaymentDates == null ? null : _masterAgreementPaymentDates;
			return this;
		}
		
		@RosettaAttribute("flatRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("flatRate")
		@Override
		public FixedLeg.FixedLegBuilder setFlatRate(FlatRateEnum _flatRate) {
			this.flatRate = _flatRate == null ? null : _flatRate;
			return this;
		}
		
		@RosettaAttribute("flatRateAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("flatRateAmount")
		@Override
		public FixedLeg.FixedLegBuilder setFlatRateAmount(NonNegativeMoney _flatRateAmount) {
			this.flatRateAmount = _flatRateAmount == null ? null : _flatRateAmount.toBuilder();
			return this;
		}
		
		@Override
		public FixedLeg build() {
			return new FixedLeg.FixedLegImpl(this);
		}
		
		@Override
		public FixedLeg.FixedLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedLeg.FixedLegBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedLeg.FixedLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FixedLeg.FixedLegBuilder o = (FixedLeg.FixedLegBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
