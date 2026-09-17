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
import fpml.consolidated.com.meta.CoalStandardQualityScheduleMeta;
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
 * Provision The quality attributes of the coal to be delivered, specified on a periodic basis.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The quality attributes of the coal to be delivered, specified on a periodic basis.
 *
 */
@RosettaDataType(value="CoalStandardQualitySchedule", builder=CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CoalStandardQualitySchedule", model="fpml", builder=CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilderImpl.class, version="2.1.1")
public interface CoalStandardQualitySchedule extends RosettaModelObject {

	CoalStandardQualityScheduleMeta metaData = new CoalStandardQualityScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends CoalStandardQuality> getStandardQualityStep();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Delivery Periods defined elsewhere.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Delivery Periods defined elsewhere.
	 *
	 */
	CalculationPeriodsReference getDeliveryPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined elsewhere.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined elsewhere.
	 *
	 */
	CalculationPeriodsScheduleReference getDeliveryPeriodsScheduleReference();

	/*********************** Build Methods  ***********************/
	CoalStandardQualitySchedule build();
	
	CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder toBuilder();
	
	static CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder builder() {
		return new CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalStandardQualitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoalStandardQualitySchedule> getType() {
		return CoalStandardQualitySchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("standardQualityStep"), processor, CoalStandardQuality.class, getStandardQualityStep());
		processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.class, getDeliveryPeriodsReference());
		processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getDeliveryPeriodsScheduleReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalStandardQualityScheduleBuilder extends CoalStandardQualitySchedule, RosettaModelObjectBuilder {
		CoalStandardQuality.CoalStandardQualityBuilder getOrCreateStandardQualityStep(int index);
		@Override
		List<? extends CoalStandardQuality.CoalStandardQualityBuilder> getStandardQualityStep();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateDeliveryPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getDeliveryPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateDeliveryPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getDeliveryPeriodsScheduleReference();
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(CoalStandardQuality standardQualityStep);
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(CoalStandardQuality standardQualityStep, int idx);
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(List<? extends CoalStandardQuality> standardQualityStep);
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setStandardQualityStep(List<? extends CoalStandardQuality> standardQualityStep);
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setDeliveryPeriodsReference(CalculationPeriodsReference deliveryPeriodsReference);
		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("standardQualityStep"), processor, CoalStandardQuality.CoalStandardQualityBuilder.class, getStandardQualityStep());
			processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getDeliveryPeriodsReference());
			processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getDeliveryPeriodsScheduleReference());
		}
		

		CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CoalStandardQualitySchedule  ***********************/
	class CoalStandardQualityScheduleImpl implements CoalStandardQualitySchedule {
		private final List<? extends CoalStandardQuality> standardQualityStep;
		private final CalculationPeriodsReference deliveryPeriodsReference;
		private final CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference;
		
		protected CoalStandardQualityScheduleImpl(CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder builder) {
			this.standardQualityStep = ofNullable(builder.getStandardQualityStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.deliveryPeriodsReference = ofNullable(builder.getDeliveryPeriodsReference()).map(f->f.build()).orElse(null);
			this.deliveryPeriodsScheduleReference = ofNullable(builder.getDeliveryPeriodsScheduleReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("standardQualityStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("standardQualityStep")
		public List<? extends CoalStandardQuality> getStandardQualityStep() {
			return standardQualityStep;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriodsReference")
		public CalculationPeriodsReference getDeliveryPeriodsReference() {
			return deliveryPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference getDeliveryPeriodsScheduleReference() {
			return deliveryPeriodsScheduleReference;
		}
		
		@Override
		public CoalStandardQualitySchedule build() {
			return this;
		}
		
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder toBuilder() {
			CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder builder) {
			ofNullable(getStandardQualityStep()).ifPresent(builder::setStandardQualityStep);
			ofNullable(getDeliveryPeriodsReference()).ifPresent(builder::setDeliveryPeriodsReference);
			ofNullable(getDeliveryPeriodsScheduleReference()).ifPresent(builder::setDeliveryPeriodsScheduleReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalStandardQualitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(standardQualityStep, _that.getStandardQualityStep())) return false;
			if (!Objects.equals(deliveryPeriodsReference, _that.getDeliveryPeriodsReference())) return false;
			if (!Objects.equals(deliveryPeriodsScheduleReference, _that.getDeliveryPeriodsScheduleReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardQualityStep != null ? standardQualityStep.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsReference != null ? deliveryPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsScheduleReference != null ? deliveryPeriodsScheduleReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalStandardQualitySchedule {" +
				"standardQualityStep=" + this.standardQualityStep + ", " +
				"deliveryPeriodsReference=" + this.deliveryPeriodsReference + ", " +
				"deliveryPeriodsScheduleReference=" + this.deliveryPeriodsScheduleReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalStandardQualitySchedule  ***********************/
	class CoalStandardQualityScheduleBuilderImpl implements CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder {
	
		protected List<CoalStandardQuality.CoalStandardQualityBuilder> standardQualityStep = new ArrayList<>();
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder deliveryPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder deliveryPeriodsScheduleReference;
		
		@Override
		@RosettaAttribute("standardQualityStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("standardQualityStep")
		public List<? extends CoalStandardQuality.CoalStandardQualityBuilder> getStandardQualityStep() {
			return standardQualityStep;
		}
		
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder getOrCreateStandardQualityStep(int index) {
			if (standardQualityStep==null) {
				this.standardQualityStep = new ArrayList<>();
			}
			return getIndex(standardQualityStep, index, () -> {
						CoalStandardQuality.CoalStandardQualityBuilder newStandardQualityStep = CoalStandardQuality.builder();
						return newStandardQualityStep;
					});
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getDeliveryPeriodsReference() {
			return deliveryPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateDeliveryPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (deliveryPeriodsReference!=null) {
				result = deliveryPeriodsReference;
			}
			else {
				result = deliveryPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getDeliveryPeriodsScheduleReference() {
			return deliveryPeriodsScheduleReference;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateDeliveryPeriodsScheduleReference() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder result;
			if (deliveryPeriodsScheduleReference!=null) {
				result = deliveryPeriodsScheduleReference;
			}
			else {
				result = deliveryPeriodsScheduleReference = CalculationPeriodsScheduleReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("standardQualityStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("standardQualityStep")
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(CoalStandardQuality _standardQualityStep) {
			if (_standardQualityStep != null) {
				this.standardQualityStep.add(_standardQualityStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(CoalStandardQuality _standardQualityStep, int idx) {
			getIndex(this.standardQualityStep, idx, () -> _standardQualityStep.toBuilder());
			return this;
		}
		
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder addStandardQualityStep(List<? extends CoalStandardQuality> standardQualitySteps) {
			if (standardQualitySteps != null) {
				for (final CoalStandardQuality toAdd : standardQualitySteps) {
					this.standardQualityStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("standardQualityStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("standardQualityStep")
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setStandardQualityStep(List<? extends CoalStandardQuality> standardQualitySteps) {
			if (standardQualitySteps == null) {
				this.standardQualityStep = new ArrayList<>();
			} else {
				this.standardQualityStep = standardQualitySteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deliveryPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriodsReference")
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setDeliveryPeriodsReference(CalculationPeriodsReference _deliveryPeriodsReference) {
			this.deliveryPeriodsReference = _deliveryPeriodsReference == null ? null : _deliveryPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriodsScheduleReference")
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference _deliveryPeriodsScheduleReference) {
			this.deliveryPeriodsScheduleReference = _deliveryPeriodsScheduleReference == null ? null : _deliveryPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@Override
		public CoalStandardQualitySchedule build() {
			return new CoalStandardQualitySchedule.CoalStandardQualityScheduleImpl(this);
		}
		
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder prune() {
			standardQualityStep = standardQualityStep.stream().filter(b->b!=null).<CoalStandardQuality.CoalStandardQualityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (deliveryPeriodsReference!=null && !deliveryPeriodsReference.prune().hasData()) deliveryPeriodsReference = null;
			if (deliveryPeriodsScheduleReference!=null && !deliveryPeriodsScheduleReference.prune().hasData()) deliveryPeriodsScheduleReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardQualityStep()!=null && getStandardQualityStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDeliveryPeriodsReference()!=null && getDeliveryPeriodsReference().hasData()) return true;
			if (getDeliveryPeriodsScheduleReference()!=null && getDeliveryPeriodsScheduleReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder o = (CoalStandardQualitySchedule.CoalStandardQualityScheduleBuilder) other;
			
			merger.mergeRosetta(getStandardQualityStep(), o.getStandardQualityStep(), this::getOrCreateStandardQualityStep);
			merger.mergeRosetta(getDeliveryPeriodsReference(), o.getDeliveryPeriodsReference(), this::setDeliveryPeriodsReference);
			merger.mergeRosetta(getDeliveryPeriodsScheduleReference(), o.getDeliveryPeriodsScheduleReference(), this::setDeliveryPeriodsScheduleReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalStandardQualitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(standardQualityStep, _that.getStandardQualityStep())) return false;
			if (!Objects.equals(deliveryPeriodsReference, _that.getDeliveryPeriodsReference())) return false;
			if (!Objects.equals(deliveryPeriodsScheduleReference, _that.getDeliveryPeriodsScheduleReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardQualityStep != null ? standardQualityStep.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsReference != null ? deliveryPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsScheduleReference != null ? deliveryPeriodsScheduleReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalStandardQualityScheduleBuilder {" +
				"standardQualityStep=" + this.standardQualityStep + ", " +
				"deliveryPeriodsReference=" + this.deliveryPeriodsReference + ", " +
				"deliveryPeriodsScheduleReference=" + this.deliveryPeriodsScheduleReference +
			'}';
		}
	}
}
