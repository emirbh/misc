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
import fpml.consolidated.com.meta.CommodityPhysicalQuantityScheduleMeta;
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
 * Provision The Quantity per Delivery Period. There must be a Quantity step specified for each Delivery Period, regardless of whether the Quantity changes or remains the same between periods.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The Quantity per Delivery Period. There must be a Quantity step specified for each Delivery Period, regardless of whether the Quantity changes or remains the same between periods.
 *
 */
@RosettaDataType(value="CommodityPhysicalQuantitySchedule", builder=CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityPhysicalQuantitySchedule", model="fpml", builder=CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilderImpl.class, version="2.1.1")
public interface CommodityPhysicalQuantitySchedule extends RosettaModelObject {

	CommodityPhysicalQuantityScheduleMeta metaData = new CommodityPhysicalQuantityScheduleMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The quantity per Calculation Period. There must be a quantity specified for each Calculation Period, regardless of whether the quantity changes or remains the same between periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The quantity per Calculation Period. There must be a quantity specified for each Calculation Period, regardless of whether the quantity changes or remains the same between periods.
	 *
	 */
	List<? extends CommodityNotionalQuantity> getQuantityStep();
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
	CommodityPhysicalQuantitySchedule build();
	
	CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder toBuilder();
	
	static CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder builder() {
		return new CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalQuantitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityPhysicalQuantitySchedule> getType() {
		return CommodityPhysicalQuantitySchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quantityStep"), processor, CommodityNotionalQuantity.class, getQuantityStep());
		processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.class, getDeliveryPeriodsReference());
		processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getDeliveryPeriodsScheduleReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalQuantityScheduleBuilder extends CommodityPhysicalQuantitySchedule, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateQuantityStep(int index);
		@Override
		List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getQuantityStep();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateDeliveryPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getDeliveryPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateDeliveryPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getDeliveryPeriodsScheduleReference();
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setId(String id);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep, int idx);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(List<? extends CommodityNotionalQuantity> quantityStep);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setQuantityStep(List<? extends CommodityNotionalQuantity> quantityStep);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setDeliveryPeriodsReference(CalculationPeriodsReference deliveryPeriodsReference);
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quantityStep"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getQuantityStep());
			processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getDeliveryPeriodsReference());
			processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getDeliveryPeriodsScheduleReference());
		}
		

		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalQuantitySchedule  ***********************/
	class CommodityPhysicalQuantityScheduleImpl implements CommodityPhysicalQuantitySchedule {
		private final String id;
		private final List<? extends CommodityNotionalQuantity> quantityStep;
		private final CalculationPeriodsReference deliveryPeriodsReference;
		private final CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference;
		
		protected CommodityPhysicalQuantityScheduleImpl(CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder builder) {
			this.id = builder.getId();
			this.quantityStep = ofNullable(builder.getQuantityStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.deliveryPeriodsReference = ofNullable(builder.getDeliveryPeriodsReference()).map(f->f.build()).orElse(null);
			this.deliveryPeriodsScheduleReference = ofNullable(builder.getDeliveryPeriodsScheduleReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quantityStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantityStep")
		public List<? extends CommodityNotionalQuantity> getQuantityStep() {
			return quantityStep;
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
		public CommodityPhysicalQuantitySchedule build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder toBuilder() {
			CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getQuantityStep()).ifPresent(builder::setQuantityStep);
			ofNullable(getDeliveryPeriodsReference()).ifPresent(builder::setDeliveryPeriodsReference);
			ofNullable(getDeliveryPeriodsScheduleReference()).ifPresent(builder::setDeliveryPeriodsScheduleReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalQuantitySchedule _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(quantityStep, _that.getQuantityStep())) return false;
			if (!Objects.equals(deliveryPeriodsReference, _that.getDeliveryPeriodsReference())) return false;
			if (!Objects.equals(deliveryPeriodsScheduleReference, _that.getDeliveryPeriodsScheduleReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quantityStep != null ? quantityStep.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsReference != null ? deliveryPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsScheduleReference != null ? deliveryPeriodsScheduleReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalQuantitySchedule {" +
				"id=" + this.id + ", " +
				"quantityStep=" + this.quantityStep + ", " +
				"deliveryPeriodsReference=" + this.deliveryPeriodsReference + ", " +
				"deliveryPeriodsScheduleReference=" + this.deliveryPeriodsScheduleReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalQuantitySchedule  ***********************/
	class CommodityPhysicalQuantityScheduleBuilderImpl implements CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder {
	
		protected String id;
		protected List<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> quantityStep = new ArrayList<>();
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder deliveryPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder deliveryPeriodsScheduleReference;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quantityStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantityStep")
		public List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getQuantityStep() {
			return quantityStep;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateQuantityStep(int index) {
			if (quantityStep==null) {
				this.quantityStep = new ArrayList<>();
			}
			return getIndex(quantityStep, index, () -> {
						CommodityNotionalQuantity.CommodityNotionalQuantityBuilder newQuantityStep = CommodityNotionalQuantity.builder();
						return newQuantityStep;
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quantityStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quantityStep")
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity _quantityStep) {
			if (_quantityStep != null) {
				this.quantityStep.add(_quantityStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity _quantityStep, int idx) {
			getIndex(this.quantityStep, idx, () -> _quantityStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder addQuantityStep(List<? extends CommodityNotionalQuantity> quantitySteps) {
			if (quantitySteps != null) {
				for (final CommodityNotionalQuantity toAdd : quantitySteps) {
					this.quantityStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quantityStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quantityStep")
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setQuantityStep(List<? extends CommodityNotionalQuantity> quantitySteps) {
			if (quantitySteps == null) {
				this.quantityStep = new ArrayList<>();
			} else {
				this.quantityStep = quantitySteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deliveryPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriodsReference")
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setDeliveryPeriodsReference(CalculationPeriodsReference _deliveryPeriodsReference) {
			this.deliveryPeriodsReference = _deliveryPeriodsReference == null ? null : _deliveryPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriodsScheduleReference")
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference _deliveryPeriodsScheduleReference) {
			this.deliveryPeriodsScheduleReference = _deliveryPeriodsScheduleReference == null ? null : _deliveryPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule build() {
			return new CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleImpl(this);
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder prune() {
			quantityStep = quantityStep.stream().filter(b->b!=null).<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (deliveryPeriodsReference!=null && !deliveryPeriodsReference.prune().hasData()) deliveryPeriodsReference = null;
			if (deliveryPeriodsScheduleReference!=null && !deliveryPeriodsScheduleReference.prune().hasData()) deliveryPeriodsScheduleReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getQuantityStep()!=null && getQuantityStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDeliveryPeriodsReference()!=null && getDeliveryPeriodsReference().hasData()) return true;
			if (getDeliveryPeriodsScheduleReference()!=null && getDeliveryPeriodsScheduleReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder o = (CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder) other;
			
			merger.mergeRosetta(getQuantityStep(), o.getQuantityStep(), this::getOrCreateQuantityStep);
			merger.mergeRosetta(getDeliveryPeriodsReference(), o.getDeliveryPeriodsReference(), this::setDeliveryPeriodsReference);
			merger.mergeRosetta(getDeliveryPeriodsScheduleReference(), o.getDeliveryPeriodsScheduleReference(), this::setDeliveryPeriodsScheduleReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalQuantitySchedule _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(quantityStep, _that.getQuantityStep())) return false;
			if (!Objects.equals(deliveryPeriodsReference, _that.getDeliveryPeriodsReference())) return false;
			if (!Objects.equals(deliveryPeriodsScheduleReference, _that.getDeliveryPeriodsScheduleReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quantityStep != null ? quantityStep.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsReference != null ? deliveryPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsScheduleReference != null ? deliveryPeriodsScheduleReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalQuantityScheduleBuilder {" +
				"id=" + this.id + ", " +
				"quantityStep=" + this.quantityStep + ", " +
				"deliveryPeriodsReference=" + this.deliveryPeriodsReference + ", " +
				"deliveryPeriodsScheduleReference=" + this.deliveryPeriodsScheduleReference +
			'}';
		}
	}
}
