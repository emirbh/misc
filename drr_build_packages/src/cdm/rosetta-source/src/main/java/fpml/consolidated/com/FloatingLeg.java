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
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.meta.FloatingLegMeta;
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
 * Provision Floating Price leg.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Floating Price leg.
 *
 */
@RosettaDataType(value="FloatingLeg", builder=FloatingLeg.FloatingLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FloatingLeg", model="fpml", builder=FloatingLeg.FloatingLegBuilderImpl.class, version="2.1.1")
public interface FloatingLeg extends FloatingPriceLeg {

	FloatingLegMeta metaData = new FloatingLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FloatingLeg build();
	
	FloatingLeg.FloatingLegBuilder toBuilder();
	
	static FloatingLeg.FloatingLegBuilder builder() {
		return new FloatingLeg.FloatingLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingLeg> getType() {
		return FloatingLeg.class;
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
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.class, getNotionalQuantitySchedule());
		processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.class, getNotionalQuantity());
		processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.class, getSettlementPeriodsNotionalQuantity());
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.class, getQuantityReference());
		processRosetta(path.newSubPath("calculation"), processor, FloatingLegCalculation.class, getCalculation());
		processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.class, getRelativePaymentDates());
		processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.class, getPaymentDates());
		processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
		processor.processBasic(path.newSubPath("flatRate"), FlatRateEnum.class, getFlatRate(), this);
		processRosetta(path.newSubPath("flatRateAmount"), processor, NonNegativeMoney.class, getFlatRateAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingLegBuilder extends FloatingLeg, FloatingPriceLeg.FloatingPriceLegBuilder {
		@Override
		FloatingLeg.FloatingLegBuilder setId(String id);
		@Override
		FloatingLeg.FloatingLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		FloatingLeg.FloatingLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		FloatingLeg.FloatingLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		FloatingLeg.FloatingLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		FloatingLeg.FloatingLegBuilder setCalculationDates(AdjustableDates calculationDates);
		@Override
		FloatingLeg.FloatingLegBuilder setCalculationPeriods(AdjustableDates calculationPeriods);
		@Override
		FloatingLeg.FloatingLegBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		@Override
		FloatingLeg.FloatingLegBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		@Override
		FloatingLeg.FloatingLegBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		@Override
		FloatingLeg.FloatingLegBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);
		@Override
		FloatingLeg.FloatingLegBuilder setCommodity(Commodity commodity);
		@Override
		FloatingLeg.FloatingLegBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule notionalQuantitySchedule);
		@Override
		FloatingLeg.FloatingLegBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity);
		@Override
		FloatingLeg.FloatingLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity);
		@Override
		FloatingLeg.FloatingLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity, int idx);
		@Override
		FloatingLeg.FloatingLegBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		@Override
		FloatingLeg.FloatingLegBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		@Override
		FloatingLeg.FloatingLegBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		@Override
		FloatingLeg.FloatingLegBuilder setQuantityReference(QuantityReference quantityReference);
		@Override
		FloatingLeg.FloatingLegBuilder setCalculation(FloatingLegCalculation calculation);
		@Override
		FloatingLeg.FloatingLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates relativePaymentDates);
		@Override
		FloatingLeg.FloatingLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset paymentDates);
		@Override
		FloatingLeg.FloatingLegBuilder setMasterAgreementPaymentDates(Boolean masterAgreementPaymentDates);
		@Override
		FloatingLeg.FloatingLegBuilder setFlatRate(FlatRateEnum flatRate);
		@Override
		FloatingLeg.FloatingLegBuilder setFlatRateAmount(NonNegativeMoney flatRateAmount);

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
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder.class, getNotionalQuantitySchedule());
			processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalQuantity());
			processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder.class, getSettlementPeriodsNotionalQuantity());
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
			processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.QuantityReferenceBuilder.class, getQuantityReference());
			processRosetta(path.newSubPath("calculation"), processor, FloatingLegCalculation.FloatingLegCalculationBuilder.class, getCalculation());
			processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getRelativePaymentDates());
			processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder.class, getPaymentDates());
			processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
			processor.processBasic(path.newSubPath("flatRate"), FlatRateEnum.class, getFlatRate(), this);
			processRosetta(path.newSubPath("flatRateAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getFlatRateAmount());
		}
		

		FloatingLeg.FloatingLegBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingLeg  ***********************/
	class FloatingLegImpl extends FloatingPriceLeg.FloatingPriceLegImpl implements FloatingLeg {
		
		protected FloatingLegImpl(FloatingLeg.FloatingLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public FloatingLeg build() {
			return this;
		}
		
		@Override
		public FloatingLeg.FloatingLegBuilder toBuilder() {
			FloatingLeg.FloatingLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingLeg.FloatingLegBuilder builder) {
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
			return "FloatingLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingLeg  ***********************/
	class FloatingLegBuilderImpl extends FloatingPriceLeg.FloatingPriceLegBuilderImpl implements FloatingLeg.FloatingLegBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FloatingLeg.FloatingLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public FloatingLeg.FloatingLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FloatingLeg.FloatingLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FloatingLeg.FloatingLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FloatingLeg.FloatingLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public FloatingLeg.FloatingLegBuilder setCalculationDates(AdjustableDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriods")
		@Override
		public FloatingLeg.FloatingLegBuilder setCalculationPeriods(AdjustableDates _calculationPeriods) {
			this.calculationPeriods = _calculationPeriods == null ? null : _calculationPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		@Override
		public FloatingLeg.FloatingLegBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule _calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = _calculationPeriodsSchedule == null ? null : _calculationPeriodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public FloatingLeg.FloatingLegBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public FloatingLeg.FloatingLegBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public FloatingLeg.FloatingLegBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("commodity")
		@Override
		public FloatingLeg.FloatingLegBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantitySchedule")
		@Override
		public FloatingLeg.FloatingLegBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule _notionalQuantitySchedule) {
			this.notionalQuantitySchedule = _notionalQuantitySchedule == null ? null : _notionalQuantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public FloatingLeg.FloatingLegBuilder setNotionalQuantity(CommodityNotionalQuantity _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		@Override
		public FloatingLeg.FloatingLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity) {
			if (_settlementPeriodsNotionalQuantity != null) {
				this.settlementPeriodsNotionalQuantity.add(_settlementPeriodsNotionalQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingLeg.FloatingLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity, int idx) {
			getIndex(this.settlementPeriodsNotionalQuantity, idx, () -> _settlementPeriodsNotionalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public FloatingLeg.FloatingLegBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
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
		public FloatingLeg.FloatingLegBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
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
		public FloatingLeg.FloatingLegBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityReference")
		@Override
		public FloatingLeg.FloatingLegBuilder setQuantityReference(QuantityReference _quantityReference) {
			this.quantityReference = _quantityReference == null ? null : _quantityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("calculation")
		@Override
		public FloatingLeg.FloatingLegBuilder setCalculation(FloatingLegCalculation _calculation) {
			this.calculation = _calculation == null ? null : _calculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePaymentDates")
		@Override
		public FloatingLeg.FloatingLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates _relativePaymentDates) {
			this.relativePaymentDates = _relativePaymentDates == null ? null : _relativePaymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDates")
		@Override
		public FloatingLeg.FloatingLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		@Override
		public FloatingLeg.FloatingLegBuilder setMasterAgreementPaymentDates(Boolean _masterAgreementPaymentDates) {
			this.masterAgreementPaymentDates = _masterAgreementPaymentDates == null ? null : _masterAgreementPaymentDates;
			return this;
		}
		
		@RosettaAttribute("flatRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("flatRate")
		@Override
		public FloatingLeg.FloatingLegBuilder setFlatRate(FlatRateEnum _flatRate) {
			this.flatRate = _flatRate == null ? null : _flatRate;
			return this;
		}
		
		@RosettaAttribute("flatRateAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("flatRateAmount")
		@Override
		public FloatingLeg.FloatingLegBuilder setFlatRateAmount(NonNegativeMoney _flatRateAmount) {
			this.flatRateAmount = _flatRateAmount == null ? null : _flatRateAmount.toBuilder();
			return this;
		}
		
		@Override
		public FloatingLeg build() {
			return new FloatingLeg.FloatingLegImpl(this);
		}
		
		@Override
		public FloatingLeg.FloatingLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingLeg.FloatingLegBuilder prune() {
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
		public FloatingLeg.FloatingLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FloatingLeg.FloatingLegBuilder o = (FloatingLeg.FloatingLegBuilder) other;
			
			
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
			return "FloatingLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
