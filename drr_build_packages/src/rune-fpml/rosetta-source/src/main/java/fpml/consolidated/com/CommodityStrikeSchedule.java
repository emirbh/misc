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
import fpml.consolidated.com.meta.CommodityStrikeScheduleMeta;
import fpml.consolidated.shared.NonNegativeMoney;
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
 * Provision The Strike Price per Unit per Calculation Period. There must be a Strike Price per Unit step specified for each Calculation Period, regardless of whether the Strike changes or remains the same between periods.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The Strike Price per Unit per Calculation Period. There must be a Strike Price per Unit step specified for each Calculation Period, regardless of whether the Strike changes or remains the same between periods.
 *
 */
@RosettaDataType(value="CommodityStrikeSchedule", builder=CommodityStrikeSchedule.CommodityStrikeScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityStrikeSchedule", model="fpml", builder=CommodityStrikeSchedule.CommodityStrikeScheduleBuilderImpl.class, version="2.1.1")
public interface CommodityStrikeSchedule extends RosettaModelObject {

	CommodityStrikeScheduleMeta metaData = new CommodityStrikeScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The strike price per unit per Calculation Period. There must be a strike price per unit specified for each Calculation Period, regardless of whether the price changes or remains the same between periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The strike price per unit per Calculation Period. There must be a strike price per unit specified for each Calculation Period, regardless of whether the price changes or remains the same between periods.
	 *
	 */
	List<? extends NonNegativeMoney> getStrikePricePerUnitStep();
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
	CommodityStrikeSchedule build();
	
	CommodityStrikeSchedule.CommodityStrikeScheduleBuilder toBuilder();
	
	static CommodityStrikeSchedule.CommodityStrikeScheduleBuilder builder() {
		return new CommodityStrikeSchedule.CommodityStrikeScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityStrikeSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityStrikeSchedule> getType() {
		return CommodityStrikeSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("strikePricePerUnitStep"), processor, NonNegativeMoney.class, getStrikePricePerUnitStep());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityStrikeScheduleBuilder extends CommodityStrikeSchedule, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateStrikePricePerUnitStep(int index);
		@Override
		List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getStrikePricePerUnitStep();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(NonNegativeMoney strikePricePerUnitStep);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(NonNegativeMoney strikePricePerUnitStep, int idx);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(List<? extends NonNegativeMoney> strikePricePerUnitStep);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setStrikePricePerUnitStep(List<? extends NonNegativeMoney> strikePricePerUnitStep);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("strikePricePerUnitStep"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getStrikePricePerUnitStep());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
		}
		

		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityStrikeSchedule  ***********************/
	class CommodityStrikeScheduleImpl implements CommodityStrikeSchedule {
		private final List<? extends NonNegativeMoney> strikePricePerUnitStep;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		
		protected CommodityStrikeScheduleImpl(CommodityStrikeSchedule.CommodityStrikeScheduleBuilder builder) {
			this.strikePricePerUnitStep = ofNullable(builder.getStrikePricePerUnitStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnitStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePricePerUnitStep")
		public List<? extends NonNegativeMoney> getStrikePricePerUnitStep() {
			return strikePricePerUnitStep;
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
		public CommodityStrikeSchedule build() {
			return this;
		}
		
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder toBuilder() {
			CommodityStrikeSchedule.CommodityStrikeScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityStrikeSchedule.CommodityStrikeScheduleBuilder builder) {
			ofNullable(getStrikePricePerUnitStep()).ifPresent(builder::setStrikePricePerUnitStep);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityStrikeSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(strikePricePerUnitStep, _that.getStrikePricePerUnitStep())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePricePerUnitStep != null ? strikePricePerUnitStep.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityStrikeSchedule {" +
				"strikePricePerUnitStep=" + this.strikePricePerUnitStep + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityStrikeSchedule  ***********************/
	class CommodityStrikeScheduleBuilderImpl implements CommodityStrikeSchedule.CommodityStrikeScheduleBuilder {
	
		protected List<NonNegativeMoney.NonNegativeMoneyBuilder> strikePricePerUnitStep = new ArrayList<>();
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		
		@Override
		@RosettaAttribute("strikePricePerUnitStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePricePerUnitStep")
		public List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getStrikePricePerUnitStep() {
			return strikePricePerUnitStep;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateStrikePricePerUnitStep(int index) {
			if (strikePricePerUnitStep==null) {
				this.strikePricePerUnitStep = new ArrayList<>();
			}
			return getIndex(strikePricePerUnitStep, index, () -> {
						NonNegativeMoney.NonNegativeMoneyBuilder newStrikePricePerUnitStep = NonNegativeMoney.builder();
						return newStrikePricePerUnitStep;
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
		
		@RosettaAttribute("strikePricePerUnitStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strikePricePerUnitStep")
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(NonNegativeMoney _strikePricePerUnitStep) {
			if (_strikePricePerUnitStep != null) {
				this.strikePricePerUnitStep.add(_strikePricePerUnitStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(NonNegativeMoney _strikePricePerUnitStep, int idx) {
			getIndex(this.strikePricePerUnitStep, idx, () -> _strikePricePerUnitStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder addStrikePricePerUnitStep(List<? extends NonNegativeMoney> strikePricePerUnitSteps) {
			if (strikePricePerUnitSteps != null) {
				for (final NonNegativeMoney toAdd : strikePricePerUnitSteps) {
					this.strikePricePerUnitStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("strikePricePerUnitStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strikePricePerUnitStep")
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setStrikePricePerUnitStep(List<? extends NonNegativeMoney> strikePricePerUnitSteps) {
			if (strikePricePerUnitSteps == null) {
				this.strikePricePerUnitStep = new ArrayList<>();
			} else {
				this.strikePricePerUnitStep = strikePricePerUnitSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@Override
		public CommodityStrikeSchedule build() {
			return new CommodityStrikeSchedule.CommodityStrikeScheduleImpl(this);
		}
		
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder prune() {
			strikePricePerUnitStep = strikePricePerUnitStep.stream().filter(b->b!=null).<NonNegativeMoney.NonNegativeMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrikePricePerUnitStep()!=null && getStrikePricePerUnitStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityStrikeSchedule.CommodityStrikeScheduleBuilder o = (CommodityStrikeSchedule.CommodityStrikeScheduleBuilder) other;
			
			merger.mergeRosetta(getStrikePricePerUnitStep(), o.getStrikePricePerUnitStep(), this::getOrCreateStrikePricePerUnitStep);
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityStrikeSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(strikePricePerUnitStep, _that.getStrikePricePerUnitStep())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePricePerUnitStep != null ? strikePricePerUnitStep.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityStrikeScheduleBuilder {" +
				"strikePricePerUnitStep=" + this.strikePricePerUnitStep + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}
}
