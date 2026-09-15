package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.com.meta.CommodityReturnLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the return leg of a commodity return swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the return leg of a commodity return swap.
 *
 */
@RosettaDataType(value="CommodityReturnLeg", builder=CommodityReturnLeg.CommodityReturnLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityReturnLeg", model="fpml", builder=CommodityReturnLeg.CommodityReturnLegBuilderImpl.class, version="2.1.1")
public interface CommodityReturnLeg extends CommodityPerformanceSwapLeg {

	CommodityReturnLegMeta metaData = new CommodityReturnLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Calculation Period dates for this leg of the trade where the Calculation Periods are all one day long. Only dates explicitly included determine the Calculation Periods and there is a Calculation Period for each date specified. As such one-day Calculation Period are typical a physically-settled emissions or metals trades it is expected that this element will not be used in performance swaps.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Calculation Period dates for this leg of the trade where the Calculation Periods are all one day long. Only dates explicitly included determine the Calculation Periods and there is a Calculation Period for each date specified. As such one-day Calculation Period are typical a physically-settled emissions or metals trades it is expected that this element will not be used in performance swaps.
	 *
	 */
	AdjustableDates getCalculationDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Calculation Period start dates for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Calculation Period start dates for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 */
	AdjustableDates getCalculationPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Calculation Periods for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on the other leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Calculation Periods for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on the other leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 */
	CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsReference getCalculationPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 */
	CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsDatesReference getCalculationPeriodsDatesReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 */
	CommodityRelativePaymentDates getRelativePaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 */
	AdjustableDatesOrRelativeDateOffset getPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 */
	Boolean getMasterAgreementPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the swap's underlyer when it has only one asset component.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the swap's underlyer when it has only one asset component.
	 *
	 */
	Commodity getCommodity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the swap's underlyer when it has multiple asset components.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the swap's underlyer when it has multiple asset components.
	 *
	 */
	CommodityBasket getCommodityBasket();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the notional amount of a commodity performance type swap. It is a currency-denominated value (i.e. price-times-quantity). In confirmations is also referred to as the Notional Quantity (sic, expressed in currency units), Notional Amount, Equity Notional Amount and, in the case of reinvesting swaps, Initial Notional Amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the notional amount of a commodity performance type swap. It is a currency-denominated value (i.e. price-times-quantity). In confirmations is also referred to as the Notional Quantity (sic, expressed in currency units), Notional Amount, Equity Notional Amount and, in the case of reinvesting swaps, Initial Notional Amount.
	 *
	 */
	CommodityNotionalAmount getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the Return swap notional amount defined in another leg of the return swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the Return swap notional amount defined in another leg of the return swap.
	 *
	 */
	CommodityNotionalAmountReference getNotionalAmountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies, in relation to each Payment Date, the return percentage which, when multiplied times the notional amount is the amount to which the Payment Date relates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies, in relation to each Payment Date, the return percentage which, when multiplied times the notional amount is the amount to which the Payment Date relates.
	 *
	 */
	CommodityReturnCalculation getCommodityReturnCalculation();

	/*********************** Build Methods  ***********************/
	CommodityReturnLeg build();
	
	CommodityReturnLeg.CommodityReturnLegBuilder toBuilder();
	
	static CommodityReturnLeg.CommodityReturnLegBuilder builder() {
		return new CommodityReturnLeg.CommodityReturnLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityReturnLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityReturnLeg> getType() {
		return CommodityReturnLeg.class;
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
		processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.class, getRelativePaymentDates());
		processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.class, getPaymentDates());
		processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("commodityBasket"), processor, CommodityBasket.class, getCommodityBasket());
		processRosetta(path.newSubPath("notionalAmount"), processor, CommodityNotionalAmount.class, getNotionalAmount());
		processRosetta(path.newSubPath("notionalAmountReference"), processor, CommodityNotionalAmountReference.class, getNotionalAmountReference());
		processRosetta(path.newSubPath("commodityReturnCalculation"), processor, CommodityReturnCalculation.class, getCommodityReturnCalculation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityReturnLegBuilder extends CommodityReturnLeg, CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationDates();
		@Override
		AdjustableDates.AdjustableDatesBuilder getCalculationDates();
		AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods();
		@Override
		AdjustableDates.AdjustableDatesBuilder getCalculationPeriods();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule();
		@Override
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates();
		@Override
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates();
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates();
		@Override
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates();
		Commodity.CommodityBuilder getOrCreateCommodity();
		@Override
		Commodity.CommodityBuilder getCommodity();
		CommodityBasket.CommodityBasketBuilder getOrCreateCommodityBasket();
		@Override
		CommodityBasket.CommodityBasketBuilder getCommodityBasket();
		CommodityNotionalAmount.CommodityNotionalAmountBuilder getOrCreateNotionalAmount();
		@Override
		CommodityNotionalAmount.CommodityNotionalAmountBuilder getNotionalAmount();
		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getOrCreateNotionalAmountReference();
		@Override
		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getNotionalAmountReference();
		CommodityReturnCalculation.CommodityReturnCalculationBuilder getOrCreateCommodityReturnCalculation();
		@Override
		CommodityReturnCalculation.CommodityReturnCalculationBuilder getCommodityReturnCalculation();
		@Override
		CommodityReturnLeg.CommodityReturnLegBuilder setId(String id);
		@Override
		CommodityReturnLeg.CommodityReturnLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		CommodityReturnLeg.CommodityReturnLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		CommodityReturnLeg.CommodityReturnLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		CommodityReturnLeg.CommodityReturnLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		CommodityReturnLeg.CommodityReturnLegBuilder setCalculationDates(AdjustableDates calculationDates);
		CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriods(AdjustableDates calculationPeriods);
		CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);
		CommodityReturnLeg.CommodityReturnLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates relativePaymentDates);
		CommodityReturnLeg.CommodityReturnLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset paymentDates);
		CommodityReturnLeg.CommodityReturnLegBuilder setMasterAgreementPaymentDates(Boolean masterAgreementPaymentDates);
		CommodityReturnLeg.CommodityReturnLegBuilder setCommodity(Commodity commodity);
		CommodityReturnLeg.CommodityReturnLegBuilder setCommodityBasket(CommodityBasket commodityBasket);
		CommodityReturnLeg.CommodityReturnLegBuilder setNotionalAmount(CommodityNotionalAmount notionalAmount);
		CommodityReturnLeg.CommodityReturnLegBuilder setNotionalAmountReference(CommodityNotionalAmountReference notionalAmountReference);
		CommodityReturnLeg.CommodityReturnLegBuilder setCommodityReturnCalculation(CommodityReturnCalculation commodityReturnCalculation);

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
			processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getRelativePaymentDates());
			processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder.class, getPaymentDates());
			processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("commodityBasket"), processor, CommodityBasket.CommodityBasketBuilder.class, getCommodityBasket());
			processRosetta(path.newSubPath("notionalAmount"), processor, CommodityNotionalAmount.CommodityNotionalAmountBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("notionalAmountReference"), processor, CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder.class, getNotionalAmountReference());
			processRosetta(path.newSubPath("commodityReturnCalculation"), processor, CommodityReturnCalculation.CommodityReturnCalculationBuilder.class, getCommodityReturnCalculation());
		}
		

		CommodityReturnLeg.CommodityReturnLegBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityReturnLeg  ***********************/
	class CommodityReturnLegImpl extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegImpl implements CommodityReturnLeg {
		private final AdjustableDates calculationDates;
		private final AdjustableDates calculationPeriods;
		private final CommodityCalculationPeriodsSchedule calculationPeriodsSchedule;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		private final CommodityRelativePaymentDates relativePaymentDates;
		private final AdjustableDatesOrRelativeDateOffset paymentDates;
		private final Boolean masterAgreementPaymentDates;
		private final Commodity commodity;
		private final CommodityBasket commodityBasket;
		private final CommodityNotionalAmount notionalAmount;
		private final CommodityNotionalAmountReference notionalAmountReference;
		private final CommodityReturnCalculation commodityReturnCalculation;
		
		protected CommodityReturnLegImpl(CommodityReturnLeg.CommodityReturnLegBuilder builder) {
			super(builder);
			this.calculationDates = ofNullable(builder.getCalculationDates()).map(f->f.build()).orElse(null);
			this.calculationPeriods = ofNullable(builder.getCalculationPeriods()).map(f->f.build()).orElse(null);
			this.calculationPeriodsSchedule = ofNullable(builder.getCalculationPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
			this.relativePaymentDates = ofNullable(builder.getRelativePaymentDates()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.masterAgreementPaymentDates = builder.getMasterAgreementPaymentDates();
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.commodityBasket = ofNullable(builder.getCommodityBasket()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.notionalAmountReference = ofNullable(builder.getNotionalAmountReference()).map(f->f.build()).orElse(null);
			this.commodityReturnCalculation = ofNullable(builder.getCommodityReturnCalculation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDates")
		public AdjustableDates getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriods")
		public AdjustableDates getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@Override
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		@RosettaAttribute("commodityBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityBasket")
		public CommodityBasket getCommodityBasket() {
			return commodityBasket;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public CommodityNotionalAmount getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("notionalAmountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmountReference")
		public CommodityNotionalAmountReference getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		@RosettaAttribute("commodityReturnCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityReturnCalculation")
		public CommodityReturnCalculation getCommodityReturnCalculation() {
			return commodityReturnCalculation;
		}
		
		@Override
		public CommodityReturnLeg build() {
			return this;
		}
		
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder toBuilder() {
			CommodityReturnLeg.CommodityReturnLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityReturnLeg.CommodityReturnLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCalculationDates()).ifPresent(builder::setCalculationDates);
			ofNullable(getCalculationPeriods()).ifPresent(builder::setCalculationPeriods);
			ofNullable(getCalculationPeriodsSchedule()).ifPresent(builder::setCalculationPeriodsSchedule);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
			ofNullable(getRelativePaymentDates()).ifPresent(builder::setRelativePaymentDates);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getMasterAgreementPaymentDates()).ifPresent(builder::setMasterAgreementPaymentDates);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getCommodityBasket()).ifPresent(builder::setCommodityBasket);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getNotionalAmountReference()).ifPresent(builder::setNotionalAmountReference);
			ofNullable(getCommodityReturnCalculation()).ifPresent(builder::setCommodityReturnCalculation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityReturnLeg _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityBasket, _that.getCommodityBasket())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(commodityReturnCalculation, _that.getCommodityReturnCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityBasket != null ? commodityBasket.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (commodityReturnCalculation != null ? commodityReturnCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReturnLeg {" +
				"calculationDates=" + this.calculationDates + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates + ", " +
				"commodity=" + this.commodity + ", " +
				"commodityBasket=" + this.commodityBasket + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"commodityReturnCalculation=" + this.commodityReturnCalculation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityReturnLeg  ***********************/
	class CommodityReturnLegBuilderImpl extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilderImpl implements CommodityReturnLeg.CommodityReturnLegBuilder {
	
		protected AdjustableDates.AdjustableDatesBuilder calculationDates;
		protected AdjustableDates.AdjustableDatesBuilder calculationPeriods;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder calculationPeriodsSchedule;
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		protected CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder relativePaymentDates;
		protected AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder paymentDates;
		protected Boolean masterAgreementPaymentDates;
		protected Commodity.CommodityBuilder commodity;
		protected CommodityBasket.CommodityBasketBuilder commodityBasket;
		protected CommodityNotionalAmount.CommodityNotionalAmountBuilder notionalAmount;
		protected CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder notionalAmountReference;
		protected CommodityReturnCalculation.CommodityReturnCalculationBuilder commodityReturnCalculation;
		
		@Override
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDates")
		public AdjustableDates.AdjustableDatesBuilder getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (calculationDates!=null) {
				result = calculationDates;
			}
			else {
				result = calculationDates = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriods")
		public AdjustableDates.AdjustableDatesBuilder getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (calculationPeriods!=null) {
				result = calculationPeriods;
			}
			else {
				result = calculationPeriods = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder result;
			if (calculationPeriodsSchedule!=null) {
				result = calculationPeriodsSchedule;
			}
			else {
				result = calculationPeriodsSchedule = CommodityCalculationPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (calculationPeriodsReference!=null) {
				result = calculationPeriodsReference;
			}
			else {
				result = calculationPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder result;
			if (calculationPeriodsScheduleReference!=null) {
				result = calculationPeriodsScheduleReference;
			}
			else {
				result = calculationPeriodsScheduleReference = CalculationPeriodsScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference() {
			CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder result;
			if (calculationPeriodsDatesReference!=null) {
				result = calculationPeriodsDatesReference;
			}
			else {
				result = calculationPeriodsDatesReference = CalculationPeriodsDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder result;
			if (relativePaymentDates!=null) {
				result = relativePaymentDates;
			}
			else {
				result = relativePaymentDates = CommodityRelativePaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates() {
			AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = AdjustableDatesOrRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@Override
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityBasket")
		public CommodityBasket.CommodityBasketBuilder getCommodityBasket() {
			return commodityBasket;
		}
		
		@Override
		public CommodityBasket.CommodityBasketBuilder getOrCreateCommodityBasket() {
			CommodityBasket.CommodityBasketBuilder result;
			if (commodityBasket!=null) {
				result = commodityBasket;
			}
			else {
				result = commodityBasket = CommodityBasket.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder getOrCreateNotionalAmount() {
			CommodityNotionalAmount.CommodityNotionalAmountBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = CommodityNotionalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmountReference")
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder getOrCreateNotionalAmountReference() {
			CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder result;
			if (notionalAmountReference!=null) {
				result = notionalAmountReference;
			}
			else {
				result = notionalAmountReference = CommodityNotionalAmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityReturnCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityReturnCalculation")
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder getCommodityReturnCalculation() {
			return commodityReturnCalculation;
		}
		
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder getOrCreateCommodityReturnCalculation() {
			CommodityReturnCalculation.CommodityReturnCalculationBuilder result;
			if (commodityReturnCalculation!=null) {
				result = commodityReturnCalculation;
			}
			else {
				result = commodityReturnCalculation = CommodityReturnCalculation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setCalculationDates(AdjustableDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriods")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriods(AdjustableDates _calculationPeriods) {
			this.calculationPeriods = _calculationPeriods == null ? null : _calculationPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule _calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = _calculationPeriodsSchedule == null ? null : _calculationPeriodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePaymentDates")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates _relativePaymentDates) {
			this.relativePaymentDates = _relativePaymentDates == null ? null : _relativePaymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDates")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setMasterAgreementPaymentDates(Boolean _masterAgreementPaymentDates) {
			this.masterAgreementPaymentDates = _masterAgreementPaymentDates == null ? null : _masterAgreementPaymentDates;
			return this;
		}
		
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodity")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityBasket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityBasket")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setCommodityBasket(CommodityBasket _commodityBasket) {
			this.commodityBasket = _commodityBasket == null ? null : _commodityBasket.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setNotionalAmount(CommodityNotionalAmount _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmountReference")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setNotionalAmountReference(CommodityNotionalAmountReference _notionalAmountReference) {
			this.notionalAmountReference = _notionalAmountReference == null ? null : _notionalAmountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityReturnCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityReturnCalculation")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder setCommodityReturnCalculation(CommodityReturnCalculation _commodityReturnCalculation) {
			this.commodityReturnCalculation = _commodityReturnCalculation == null ? null : _commodityReturnCalculation.toBuilder();
			return this;
		}
		
		@Override
		public CommodityReturnLeg build() {
			return new CommodityReturnLeg.CommodityReturnLegImpl(this);
		}
		
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder prune() {
			super.prune();
			if (calculationDates!=null && !calculationDates.prune().hasData()) calculationDates = null;
			if (calculationPeriods!=null && !calculationPeriods.prune().hasData()) calculationPeriods = null;
			if (calculationPeriodsSchedule!=null && !calculationPeriodsSchedule.prune().hasData()) calculationPeriodsSchedule = null;
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			if (relativePaymentDates!=null && !relativePaymentDates.prune().hasData()) relativePaymentDates = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (commodityBasket!=null && !commodityBasket.prune().hasData()) commodityBasket = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (notionalAmountReference!=null && !notionalAmountReference.prune().hasData()) notionalAmountReference = null;
			if (commodityReturnCalculation!=null && !commodityReturnCalculation.prune().hasData()) commodityReturnCalculation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCalculationDates()!=null && getCalculationDates().hasData()) return true;
			if (getCalculationPeriods()!=null && getCalculationPeriods().hasData()) return true;
			if (getCalculationPeriodsSchedule()!=null && getCalculationPeriodsSchedule().hasData()) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			if (getRelativePaymentDates()!=null && getRelativePaymentDates().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getMasterAgreementPaymentDates()!=null) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getCommodityBasket()!=null && getCommodityBasket().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getNotionalAmountReference()!=null && getNotionalAmountReference().hasData()) return true;
			if (getCommodityReturnCalculation()!=null && getCommodityReturnCalculation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReturnLeg.CommodityReturnLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityReturnLeg.CommodityReturnLegBuilder o = (CommodityReturnLeg.CommodityReturnLegBuilder) other;
			
			merger.mergeRosetta(getCalculationDates(), o.getCalculationDates(), this::setCalculationDates);
			merger.mergeRosetta(getCalculationPeriods(), o.getCalculationPeriods(), this::setCalculationPeriods);
			merger.mergeRosetta(getCalculationPeriodsSchedule(), o.getCalculationPeriodsSchedule(), this::setCalculationPeriodsSchedule);
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			merger.mergeRosetta(getRelativePaymentDates(), o.getRelativePaymentDates(), this::setRelativePaymentDates);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getCommodityBasket(), o.getCommodityBasket(), this::setCommodityBasket);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getNotionalAmountReference(), o.getNotionalAmountReference(), this::setNotionalAmountReference);
			merger.mergeRosetta(getCommodityReturnCalculation(), o.getCommodityReturnCalculation(), this::setCommodityReturnCalculation);
			
			merger.mergeBasic(getMasterAgreementPaymentDates(), o.getMasterAgreementPaymentDates(), this::setMasterAgreementPaymentDates);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityReturnLeg _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityBasket, _that.getCommodityBasket())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			if (!Objects.equals(commodityReturnCalculation, _that.getCommodityReturnCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityBasket != null ? commodityBasket.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			_result = 31 * _result + (commodityReturnCalculation != null ? commodityReturnCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReturnLegBuilder {" +
				"calculationDates=" + this.calculationDates + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates + ", " +
				"commodity=" + this.commodity + ", " +
				"commodityBasket=" + this.commodityBasket + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalAmountReference=" + this.notionalAmountReference + ", " +
				"commodityReturnCalculation=" + this.commodityReturnCalculation +
			'}' + " " + super.toString();
		}
	}
}
