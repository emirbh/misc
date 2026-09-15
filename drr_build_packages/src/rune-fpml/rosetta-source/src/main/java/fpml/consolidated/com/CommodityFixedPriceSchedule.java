package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityFixedPriceScheduleMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The Fixed Price for a given Calculation Period during the life of the trade. There must be a Fixed Price step specified for each Calculation Period, regardless of whether the Fixed Price changes or remains the same between periods.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The Fixed Price for a given Calculation Period during the life of the trade. There must be a Fixed Price step specified for each Calculation Period, regardless of whether the Fixed Price changes or remains the same between periods.
 *
 */
@RosettaDataType(value="CommodityFixedPriceSchedule", builder=CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityFixedPriceSchedule", model="fpml", builder=CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilderImpl.class, version="2.1.1")
public interface CommodityFixedPriceSchedule extends RosettaModelObject {

	CommodityFixedPriceScheduleMeta metaData = new CommodityFixedPriceScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Fixed Price for a given Calculation Period during the life of the trade. There must be a Fixed Price step specified for each Calculation Period, regardless of whether the Fixed Price changes or remains the same between periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Fixed Price for a given Calculation Period during the life of the trade. There must be a Fixed Price step specified for each Calculation Period, regardless of whether the Fixed Price changes or remains the same between periods.
	 *
	 */
	List<? extends CommodityFixedPrice> getFixedPriceStep();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For a Wet Voyager Charter Freight Swap, the number of Worldscale Points for purposes of the calculation of a Fixed Amount for a given Calculation Period during the life of the trade. There must be Worldscale Rate Step specified for each Calculation Period, regardless of whether the Worldscale Rate Step changes or remains the same between periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For a Wet Voyager Charter Freight Swap, the number of Worldscale Points for purposes of the calculation of a Fixed Amount for a given Calculation Period during the life of the trade. There must be Worldscale Rate Step specified for each Calculation Period, regardless of whether the Worldscale Rate Step changes or remains the same between periods.
	 *
	 */
	List<BigDecimal> getWorldscaleRateStep();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For a DRY Voyage Charter or Time Charter Freight Swap, the price per relevant unit for pruposes of the calculation of a Fixed Amount for a given Calculation Period during the life of the trade. There must be Worldscale Rate Step specified for each Calculation Period, regardless of whether the Worldscale Rate Step changes or remains the same between periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For a DRY Voyage Charter or Time Charter Freight Swap, the price per relevant unit for pruposes of the calculation of a Fixed Amount for a given Calculation Period during the life of the trade. There must be Worldscale Rate Step specified for each Calculation Period, regardless of whether the Worldscale Rate Step changes or remains the same between periods.
	 *
	 */
	List<? extends NonNegativeMoney> getContractRateStep();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an electricity transaction, the fixed price schedule for one or more groups of Settlement Periods on which fixed payments are based. if the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an electricity transaction, the fixed price schedule for one or more groups of Settlement Periods on which fixed payments are based. if the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 *
	 */
	List<? extends CommoditySettlementPeriodsPriceSchedule> getSettlementPeriodsPriceSchedule();
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

	/*********************** Build Methods  ***********************/
	CommodityFixedPriceSchedule build();
	
	CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder toBuilder();
	
	static CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder builder() {
		return new CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFixedPriceSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityFixedPriceSchedule> getType() {
		return CommodityFixedPriceSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedPriceStep"), processor, CommodityFixedPrice.class, getFixedPriceStep());
		processor.processBasic(path.newSubPath("worldscaleRateStep"), BigDecimal.class, getWorldscaleRateStep(), this);
		processRosetta(path.newSubPath("contractRateStep"), processor, NonNegativeMoney.class, getContractRateStep());
		processRosetta(path.newSubPath("settlementPeriodsPriceSchedule"), processor, CommoditySettlementPeriodsPriceSchedule.class, getSettlementPeriodsPriceSchedule());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFixedPriceScheduleBuilder extends CommodityFixedPriceSchedule, RosettaModelObjectBuilder {
		CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateFixedPriceStep(int index);
		@Override
		List<? extends CommodityFixedPrice.CommodityFixedPriceBuilder> getFixedPriceStep();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateContractRateStep(int index);
		@Override
		List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getContractRateStep();
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder getOrCreateSettlementPeriodsPriceSchedule(int index);
		@Override
		List<? extends CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder> getSettlementPeriodsPriceSchedule();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(CommodityFixedPrice fixedPriceStep);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(CommodityFixedPrice fixedPriceStep, int idx);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(List<? extends CommodityFixedPrice> fixedPriceStep);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setFixedPriceStep(List<? extends CommodityFixedPrice> fixedPriceStep);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(BigDecimal worldscaleRateStep);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(BigDecimal worldscaleRateStep, int idx);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(List<BigDecimal> worldscaleRateStep);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setWorldscaleRateStep(List<BigDecimal> worldscaleRateStep);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(NonNegativeMoney contractRateStep);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(NonNegativeMoney contractRateStep, int idx);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(List<? extends NonNegativeMoney> contractRateStep);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setContractRateStep(List<? extends NonNegativeMoney> contractRateStep);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(CommoditySettlementPeriodsPriceSchedule settlementPeriodsPriceSchedule);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(CommoditySettlementPeriodsPriceSchedule settlementPeriodsPriceSchedule, int idx);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedule);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setSettlementPeriodsPriceSchedule(List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedule);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedPriceStep"), processor, CommodityFixedPrice.CommodityFixedPriceBuilder.class, getFixedPriceStep());
			processor.processBasic(path.newSubPath("worldscaleRateStep"), BigDecimal.class, getWorldscaleRateStep(), this);
			processRosetta(path.newSubPath("contractRateStep"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getContractRateStep());
			processRosetta(path.newSubPath("settlementPeriodsPriceSchedule"), processor, CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder.class, getSettlementPeriodsPriceSchedule());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
		}
		

		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFixedPriceSchedule  ***********************/
	class CommodityFixedPriceScheduleImpl implements CommodityFixedPriceSchedule {
		private final List<? extends CommodityFixedPrice> fixedPriceStep;
		private final List<BigDecimal> worldscaleRateStep;
		private final List<? extends NonNegativeMoney> contractRateStep;
		private final List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedule;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		
		protected CommodityFixedPriceScheduleImpl(CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder builder) {
			this.fixedPriceStep = ofNullable(builder.getFixedPriceStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.worldscaleRateStep = ofNullable(builder.getWorldscaleRateStep()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.contractRateStep = ofNullable(builder.getContractRateStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsPriceSchedule = ofNullable(builder.getSettlementPeriodsPriceSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedPriceStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedPriceStep")
		public List<? extends CommodityFixedPrice> getFixedPriceStep() {
			return fixedPriceStep;
		}
		
		@Override
		@RosettaAttribute("worldscaleRateStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("worldscaleRateStep")
		public List<BigDecimal> getWorldscaleRateStep() {
			return worldscaleRateStep;
		}
		
		@Override
		@RosettaAttribute("contractRateStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractRateStep")
		public List<? extends NonNegativeMoney> getContractRateStep() {
			return contractRateStep;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsPriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsPriceSchedule")
		public List<? extends CommoditySettlementPeriodsPriceSchedule> getSettlementPeriodsPriceSchedule() {
			return settlementPeriodsPriceSchedule;
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
		public CommodityFixedPriceSchedule build() {
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder toBuilder() {
			CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder builder) {
			ofNullable(getFixedPriceStep()).ifPresent(builder::setFixedPriceStep);
			ofNullable(getWorldscaleRateStep()).ifPresent(builder::setWorldscaleRateStep);
			ofNullable(getContractRateStep()).ifPresent(builder::setContractRateStep);
			ofNullable(getSettlementPeriodsPriceSchedule()).ifPresent(builder::setSettlementPeriodsPriceSchedule);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPriceSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedPriceStep, _that.getFixedPriceStep())) return false;
			if (!ListEquals.listEquals(worldscaleRateStep, _that.getWorldscaleRateStep())) return false;
			if (!ListEquals.listEquals(contractRateStep, _that.getContractRateStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsPriceSchedule, _that.getSettlementPeriodsPriceSchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedPriceStep != null ? fixedPriceStep.hashCode() : 0);
			_result = 31 * _result + (worldscaleRateStep != null ? worldscaleRateStep.hashCode() : 0);
			_result = 31 * _result + (contractRateStep != null ? contractRateStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsPriceSchedule != null ? settlementPeriodsPriceSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPriceSchedule {" +
				"fixedPriceStep=" + this.fixedPriceStep + ", " +
				"worldscaleRateStep=" + this.worldscaleRateStep + ", " +
				"contractRateStep=" + this.contractRateStep + ", " +
				"settlementPeriodsPriceSchedule=" + this.settlementPeriodsPriceSchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFixedPriceSchedule  ***********************/
	class CommodityFixedPriceScheduleBuilderImpl implements CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder {
	
		protected List<CommodityFixedPrice.CommodityFixedPriceBuilder> fixedPriceStep = new ArrayList<>();
		protected List<BigDecimal> worldscaleRateStep = new ArrayList<>();
		protected List<NonNegativeMoney.NonNegativeMoneyBuilder> contractRateStep = new ArrayList<>();
		protected List<CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder> settlementPeriodsPriceSchedule = new ArrayList<>();
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		
		@Override
		@RosettaAttribute("fixedPriceStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedPriceStep")
		public List<? extends CommodityFixedPrice.CommodityFixedPriceBuilder> getFixedPriceStep() {
			return fixedPriceStep;
		}
		
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateFixedPriceStep(int index) {
			if (fixedPriceStep==null) {
				this.fixedPriceStep = new ArrayList<>();
			}
			return getIndex(fixedPriceStep, index, () -> {
						CommodityFixedPrice.CommodityFixedPriceBuilder newFixedPriceStep = CommodityFixedPrice.builder();
						return newFixedPriceStep;
					});
		}
		
		@Override
		@RosettaAttribute("worldscaleRateStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("worldscaleRateStep")
		public List<BigDecimal> getWorldscaleRateStep() {
			return worldscaleRateStep;
		}
		
		@Override
		@RosettaAttribute("contractRateStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractRateStep")
		public List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getContractRateStep() {
			return contractRateStep;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateContractRateStep(int index) {
			if (contractRateStep==null) {
				this.contractRateStep = new ArrayList<>();
			}
			return getIndex(contractRateStep, index, () -> {
						NonNegativeMoney.NonNegativeMoneyBuilder newContractRateStep = NonNegativeMoney.builder();
						return newContractRateStep;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsPriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsPriceSchedule")
		public List<? extends CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder> getSettlementPeriodsPriceSchedule() {
			return settlementPeriodsPriceSchedule;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder getOrCreateSettlementPeriodsPriceSchedule(int index) {
			if (settlementPeriodsPriceSchedule==null) {
				this.settlementPeriodsPriceSchedule = new ArrayList<>();
			}
			return getIndex(settlementPeriodsPriceSchedule, index, () -> {
						CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder newSettlementPeriodsPriceSchedule = CommoditySettlementPeriodsPriceSchedule.builder();
						return newSettlementPeriodsPriceSchedule;
					});
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
		
		@RosettaAttribute("fixedPriceStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixedPriceStep")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(CommodityFixedPrice _fixedPriceStep) {
			if (_fixedPriceStep != null) {
				this.fixedPriceStep.add(_fixedPriceStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(CommodityFixedPrice _fixedPriceStep, int idx) {
			getIndex(this.fixedPriceStep, idx, () -> _fixedPriceStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addFixedPriceStep(List<? extends CommodityFixedPrice> fixedPriceSteps) {
			if (fixedPriceSteps != null) {
				for (final CommodityFixedPrice toAdd : fixedPriceSteps) {
					this.fixedPriceStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixedPriceStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixedPriceStep")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setFixedPriceStep(List<? extends CommodityFixedPrice> fixedPriceSteps) {
			if (fixedPriceSteps == null) {
				this.fixedPriceStep = new ArrayList<>();
			} else {
				this.fixedPriceStep = fixedPriceSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("worldscaleRateStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("worldscaleRateStep")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(BigDecimal _worldscaleRateStep) {
			if (_worldscaleRateStep != null) {
				this.worldscaleRateStep.add(_worldscaleRateStep);
			}
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(BigDecimal _worldscaleRateStep, int idx) {
			getIndex(this.worldscaleRateStep, idx, () -> _worldscaleRateStep);
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addWorldscaleRateStep(List<BigDecimal> worldscaleRateSteps) {
			if (worldscaleRateSteps != null) {
				for (final BigDecimal toAdd : worldscaleRateSteps) {
					this.worldscaleRateStep.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("worldscaleRateStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("worldscaleRateStep")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setWorldscaleRateStep(List<BigDecimal> worldscaleRateSteps) {
			if (worldscaleRateSteps == null) {
				this.worldscaleRateStep = new ArrayList<>();
			} else {
				this.worldscaleRateStep = worldscaleRateSteps.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("contractRateStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractRateStep")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(NonNegativeMoney _contractRateStep) {
			if (_contractRateStep != null) {
				this.contractRateStep.add(_contractRateStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(NonNegativeMoney _contractRateStep, int idx) {
			getIndex(this.contractRateStep, idx, () -> _contractRateStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addContractRateStep(List<? extends NonNegativeMoney> contractRateSteps) {
			if (contractRateSteps != null) {
				for (final NonNegativeMoney toAdd : contractRateSteps) {
					this.contractRateStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("contractRateStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("contractRateStep")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setContractRateStep(List<? extends NonNegativeMoney> contractRateSteps) {
			if (contractRateSteps == null) {
				this.contractRateStep = new ArrayList<>();
			} else {
				this.contractRateStep = contractRateSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsPriceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsPriceSchedule")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(CommoditySettlementPeriodsPriceSchedule _settlementPeriodsPriceSchedule) {
			if (_settlementPeriodsPriceSchedule != null) {
				this.settlementPeriodsPriceSchedule.add(_settlementPeriodsPriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(CommoditySettlementPeriodsPriceSchedule _settlementPeriodsPriceSchedule, int idx) {
			getIndex(this.settlementPeriodsPriceSchedule, idx, () -> _settlementPeriodsPriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder addSettlementPeriodsPriceSchedule(List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedules) {
			if (settlementPeriodsPriceSchedules != null) {
				for (final CommoditySettlementPeriodsPriceSchedule toAdd : settlementPeriodsPriceSchedules) {
					this.settlementPeriodsPriceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsPriceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsPriceSchedule")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setSettlementPeriodsPriceSchedule(List<? extends CommoditySettlementPeriodsPriceSchedule> settlementPeriodsPriceSchedules) {
			if (settlementPeriodsPriceSchedules == null) {
				this.settlementPeriodsPriceSchedule = new ArrayList<>();
			} else {
				this.settlementPeriodsPriceSchedule = settlementPeriodsPriceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFixedPriceSchedule build() {
			return new CommodityFixedPriceSchedule.CommodityFixedPriceScheduleImpl(this);
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder prune() {
			fixedPriceStep = fixedPriceStep.stream().filter(b->b!=null).<CommodityFixedPrice.CommodityFixedPriceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractRateStep = contractRateStep.stream().filter(b->b!=null).<NonNegativeMoney.NonNegativeMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsPriceSchedule = settlementPeriodsPriceSchedule.stream().filter(b->b!=null).<CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedPriceStep()!=null && getFixedPriceStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getWorldscaleRateStep()!=null && !getWorldscaleRateStep().isEmpty()) return true;
			if (getContractRateStep()!=null && getContractRateStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsPriceSchedule()!=null && getSettlementPeriodsPriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder o = (CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder) other;
			
			merger.mergeRosetta(getFixedPriceStep(), o.getFixedPriceStep(), this::getOrCreateFixedPriceStep);
			merger.mergeRosetta(getContractRateStep(), o.getContractRateStep(), this::getOrCreateContractRateStep);
			merger.mergeRosetta(getSettlementPeriodsPriceSchedule(), o.getSettlementPeriodsPriceSchedule(), this::getOrCreateSettlementPeriodsPriceSchedule);
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			
			merger.mergeBasic(getWorldscaleRateStep(), o.getWorldscaleRateStep(), (Consumer<BigDecimal>) this::addWorldscaleRateStep);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPriceSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedPriceStep, _that.getFixedPriceStep())) return false;
			if (!ListEquals.listEquals(worldscaleRateStep, _that.getWorldscaleRateStep())) return false;
			if (!ListEquals.listEquals(contractRateStep, _that.getContractRateStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsPriceSchedule, _that.getSettlementPeriodsPriceSchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedPriceStep != null ? fixedPriceStep.hashCode() : 0);
			_result = 31 * _result + (worldscaleRateStep != null ? worldscaleRateStep.hashCode() : 0);
			_result = 31 * _result + (contractRateStep != null ? contractRateStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsPriceSchedule != null ? settlementPeriodsPriceSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPriceScheduleBuilder {" +
				"fixedPriceStep=" + this.fixedPriceStep + ", " +
				"worldscaleRateStep=" + this.worldscaleRateStep + ", " +
				"contractRateStep=" + this.contractRateStep + ", " +
				"settlementPeriodsPriceSchedule=" + this.settlementPeriodsPriceSchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}
}
