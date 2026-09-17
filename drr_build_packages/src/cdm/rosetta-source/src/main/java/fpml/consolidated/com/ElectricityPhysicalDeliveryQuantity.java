package fpml.consolidated.com;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.meta.ElectricityPhysicalDeliveryQuantityMeta;
import java.math.BigDecimal;
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
 * Provision A type defining the physical quantity of the electricity to be delivered.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the physical quantity of the electricity to be delivered.
 *
 */
@RosettaDataType(value="ElectricityPhysicalDeliveryQuantity", builder=ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityPhysicalDeliveryQuantity", model="fpml", builder=ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilderImpl.class, version="2.1.1")
public interface ElectricityPhysicalDeliveryQuantity extends CommodityNotionalQuantity {

	ElectricityPhysicalDeliveryQuantityMeta metaData = new ElectricityPhysicalDeliveryQuantityMeta();

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
	ElectricityPhysicalDeliveryQuantity build();
	
	ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder toBuilder();
	
	static ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder builder() {
		return new ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityPhysicalDeliveryQuantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityPhysicalDeliveryQuantity> getType() {
		return ElectricityPhysicalDeliveryQuantity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.class, getQuantityUnit());
		processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.class, getQuantityFrequency());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityPhysicalDeliveryQuantityBuilder extends ElectricityPhysicalDeliveryQuantity, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder {
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int index);
		@Override
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		@Override
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setId(String id);
		@Override
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit);
		@Override
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency);
		@Override
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantity(BigDecimal quantity);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int idx);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getQuantityUnit());
			processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder.class, getQuantityFrequency());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityPhysicalDeliveryQuantity  ***********************/
	class ElectricityPhysicalDeliveryQuantityImpl extends CommodityNotionalQuantity.CommodityNotionalQuantityImpl implements ElectricityPhysicalDeliveryQuantity {
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected ElectricityPhysicalDeliveryQuantityImpl(ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder builder) {
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
		public ElectricityPhysicalDeliveryQuantity build() {
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder toBuilder() {
			ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalDeliveryQuantity _that = getType().cast(o);
		
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
			return "ElectricityPhysicalDeliveryQuantity {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ElectricityPhysicalDeliveryQuantity  ***********************/
	class ElectricityPhysicalDeliveryQuantityBuilderImpl extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl implements ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder {
	
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
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quantityUnit")
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantityUnit(QuantityUnit _quantityUnit) {
			this.quantityUnit = _quantityUnit == null ? null : _quantityUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequency")
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency _quantityFrequency) {
			this.quantityFrequency = _quantityFrequency == null ? null : _quantityFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantity")
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsReference")
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference) {
			if (_settlementPeriodsReference != null) {
				this.settlementPeriodsReference.add(_settlementPeriodsReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference _settlementPeriodsReference, int idx) {
			getIndex(this.settlementPeriodsReference, idx, () -> _settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
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
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
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
		public ElectricityPhysicalDeliveryQuantity build() {
			return new ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityImpl(this);
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder prune() {
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
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder o = (ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalDeliveryQuantity _that = getType().cast(o);
		
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
			return "ElectricityPhysicalDeliveryQuantityBuilder {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}
}
