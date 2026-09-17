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
import fpml.consolidated.com.meta.CommoditySpreadScheduleMeta;
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
 * Provision The Spread per Calculation Period. There must be a Spread specified for each Calculation Period, regardless of whether the Spread changes or remains the same between periods.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The Spread per Calculation Period. There must be a Spread specified for each Calculation Period, regardless of whether the Spread changes or remains the same between periods.
 *
 */
@RosettaDataType(value="CommoditySpreadSchedule", builder=CommoditySpreadSchedule.CommoditySpreadScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommoditySpreadSchedule", model="fpml", builder=CommoditySpreadSchedule.CommoditySpreadScheduleBuilderImpl.class, version="2.1.1")
public interface CommoditySpreadSchedule extends RosettaModelObject {

	CommoditySpreadScheduleMeta metaData = new CommoditySpreadScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The spread per Calculation Period. There must be a spread step specified for each Calculation Period, regardless of whether the spread changes or remains the same between periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The spread per Calculation Period. There must be a spread step specified for each Calculation Period, regardless of whether the spread changes or remains the same between periods.
	 *
	 */
	List<? extends CommoditySpread> getSpreadStep();
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
	CommoditySpreadSchedule build();
	
	CommoditySpreadSchedule.CommoditySpreadScheduleBuilder toBuilder();
	
	static CommoditySpreadSchedule.CommoditySpreadScheduleBuilder builder() {
		return new CommoditySpreadSchedule.CommoditySpreadScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySpreadSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommoditySpreadSchedule> getType() {
		return CommoditySpreadSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("spreadStep"), processor, CommoditySpread.class, getSpreadStep());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySpreadScheduleBuilder extends CommoditySpreadSchedule, RosettaModelObjectBuilder {
		CommoditySpread.CommoditySpreadBuilder getOrCreateSpreadStep(int index);
		@Override
		List<? extends CommoditySpread.CommoditySpreadBuilder> getSpreadStep();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(CommoditySpread spreadStep);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(CommoditySpread spreadStep, int idx);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(List<? extends CommoditySpread> spreadStep);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setSpreadStep(List<? extends CommoditySpread> spreadStep);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("spreadStep"), processor, CommoditySpread.CommoditySpreadBuilder.class, getSpreadStep());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
		}
		

		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySpreadSchedule  ***********************/
	class CommoditySpreadScheduleImpl implements CommoditySpreadSchedule {
		private final List<? extends CommoditySpread> spreadStep;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		
		protected CommoditySpreadScheduleImpl(CommoditySpreadSchedule.CommoditySpreadScheduleBuilder builder) {
			this.spreadStep = ofNullable(builder.getSpreadStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spreadStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadStep")
		public List<? extends CommoditySpread> getSpreadStep() {
			return spreadStep;
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
		public CommoditySpreadSchedule build() {
			return this;
		}
		
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder toBuilder() {
			CommoditySpreadSchedule.CommoditySpreadScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySpreadSchedule.CommoditySpreadScheduleBuilder builder) {
			ofNullable(getSpreadStep()).ifPresent(builder::setSpreadStep);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySpreadSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(spreadStep, _that.getSpreadStep())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spreadStep != null ? spreadStep.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySpreadSchedule {" +
				"spreadStep=" + this.spreadStep + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommoditySpreadSchedule  ***********************/
	class CommoditySpreadScheduleBuilderImpl implements CommoditySpreadSchedule.CommoditySpreadScheduleBuilder {
	
		protected List<CommoditySpread.CommoditySpreadBuilder> spreadStep = new ArrayList<>();
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		
		@Override
		@RosettaAttribute("spreadStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadStep")
		public List<? extends CommoditySpread.CommoditySpreadBuilder> getSpreadStep() {
			return spreadStep;
		}
		
		@Override
		public CommoditySpread.CommoditySpreadBuilder getOrCreateSpreadStep(int index) {
			if (spreadStep==null) {
				this.spreadStep = new ArrayList<>();
			}
			return getIndex(spreadStep, index, () -> {
						CommoditySpread.CommoditySpreadBuilder newSpreadStep = CommoditySpread.builder();
						return newSpreadStep;
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
		
		@RosettaAttribute("spreadStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadStep")
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(CommoditySpread _spreadStep) {
			if (_spreadStep != null) {
				this.spreadStep.add(_spreadStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(CommoditySpread _spreadStep, int idx) {
			getIndex(this.spreadStep, idx, () -> _spreadStep.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder addSpreadStep(List<? extends CommoditySpread> spreadSteps) {
			if (spreadSteps != null) {
				for (final CommoditySpread toAdd : spreadSteps) {
					this.spreadStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("spreadStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("spreadStep")
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setSpreadStep(List<? extends CommoditySpread> spreadSteps) {
			if (spreadSteps == null) {
				this.spreadStep = new ArrayList<>();
			} else {
				this.spreadStep = spreadSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySpreadSchedule build() {
			return new CommoditySpreadSchedule.CommoditySpreadScheduleImpl(this);
		}
		
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder prune() {
			spreadStep = spreadStep.stream().filter(b->b!=null).<CommoditySpread.CommoditySpreadBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpreadStep()!=null && getSpreadStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommoditySpreadSchedule.CommoditySpreadScheduleBuilder o = (CommoditySpreadSchedule.CommoditySpreadScheduleBuilder) other;
			
			merger.mergeRosetta(getSpreadStep(), o.getSpreadStep(), this::getOrCreateSpreadStep);
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySpreadSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(spreadStep, _that.getSpreadStep())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spreadStep != null ? spreadStep.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySpreadScheduleBuilder {" +
				"spreadStep=" + this.spreadStep + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}
}
