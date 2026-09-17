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
import fpml.consolidated.com.meta.ElectricityPhysicalDeliveryQuantityScheduleMeta;
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
 * Provision Allows the documentation of a shaped quantity trade where the quantity changes over the life of the transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Allows the documentation of a shaped quantity trade where the quantity changes over the life of the transaction.
 *
 */
@RosettaDataType(value="ElectricityPhysicalDeliveryQuantitySchedule", builder=ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityPhysicalDeliveryQuantitySchedule", model="fpml", builder=ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilderImpl.class, version="2.1.1")
public interface ElectricityPhysicalDeliveryQuantitySchedule extends CommodityPhysicalQuantitySchedule {

	ElectricityPhysicalDeliveryQuantityScheduleMeta metaData = new ElectricityPhysicalDeliveryQuantityScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the range(s) of Settlement Periods to which this quantity applies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the range(s) of Settlement Periods to which this quantity applies.
	 *
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	ElectricityPhysicalDeliveryQuantitySchedule build();
	
	ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder toBuilder();
	
	static ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder builder() {
		return new ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityPhysicalDeliveryQuantitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityPhysicalDeliveryQuantitySchedule> getType() {
		return ElectricityPhysicalDeliveryQuantitySchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quantityStep"), processor, CommodityNotionalQuantity.class, getQuantityStep());
		processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.class, getDeliveryPeriodsReference());
		processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getDeliveryPeriodsScheduleReference());
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityPhysicalDeliveryQuantityScheduleBuilder extends ElectricityPhysicalDeliveryQuantitySchedule, CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder {
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int index);
		@Override
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		@Override
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setId(String id);
		@Override
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep);
		@Override
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity quantityStep, int idx);
		@Override
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(List<? extends CommodityNotionalQuantity> quantityStep);
		@Override
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setQuantityStep(List<? extends CommodityNotionalQuantity> quantityStep);
		@Override
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setDeliveryPeriodsReference(CalculationPeriodsReference deliveryPeriodsReference);
		@Override
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int idx);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quantityStep"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getQuantityStep());
			processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getDeliveryPeriodsReference());
			processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getDeliveryPeriodsScheduleReference());
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityPhysicalDeliveryQuantitySchedule  ***********************/
	class ElectricityPhysicalDeliveryQuantityScheduleImpl extends CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleImpl implements ElectricityPhysicalDeliveryQuantitySchedule {
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected ElectricityPhysicalDeliveryQuantityScheduleImpl(ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder builder) {
			super(builder);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule build() {
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder toBuilder() {
			ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalDeliveryQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalDeliveryQuantitySchedule {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ElectricityPhysicalDeliveryQuantitySchedule  ***********************/
	class ElectricityPhysicalDeliveryQuantityScheduleBuilderImpl extends CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilderImpl implements ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder {
	
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int index) {
			if (settlementPeriodsReference==null) {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			return getIndex(settlementPeriodsReference, index, () -> {
						SettlementPeriodsReference.SettlementPeriodsReferenceBuilder newSettlementPeriodsReference = SettlementPeriodsReference.builder();
						return newSettlementPeriodsReference;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quantityStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quantityStep")
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity _quantityStep) {
			if (_quantityStep != null) {
				this.quantityStep.add(_quantityStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(CommodityNotionalQuantity _quantityStep, int idx) {
			getIndex(this.quantityStep, idx, () -> _quantityStep.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addQuantityStep(List<? extends CommodityNotionalQuantity> quantitySteps) {
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
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setQuantityStep(List<? extends CommodityNotionalQuantity> quantitySteps) {
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
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setDeliveryPeriodsReference(CalculationPeriodsReference _deliveryPeriodsReference) {
			this.deliveryPeriodsReference = _deliveryPeriodsReference == null ? null : _deliveryPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriodsScheduleReference")
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference _deliveryPeriodsScheduleReference) {
			this.deliveryPeriodsScheduleReference = _deliveryPeriodsScheduleReference == null ? null : _deliveryPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference) {
			if (_settlementPeriodsReference != null) {
				this.settlementPeriodsReference.add(_settlementPeriodsReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference, int idx) {
			getIndex(this.settlementPeriodsReference, idx, () -> _settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (final SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences == null) {
				this.settlementPeriodsReference = new ArrayList<>();
			} else {
				this.settlementPeriodsReference = settlementPeriodsReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule build() {
			return new ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleImpl(this);
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder prune() {
			super.prune();
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder o = (ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalDeliveryQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalDeliveryQuantityScheduleBuilder {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}
}
