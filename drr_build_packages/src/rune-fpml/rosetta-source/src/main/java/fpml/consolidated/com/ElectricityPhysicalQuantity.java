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
import fpml.consolidated.com.meta.ElectricityPhysicalQuantityMeta;
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
 * Provision The quantity of gas to be delivered.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The quantity of gas to be delivered.
 *
 */
@RosettaDataType(value="ElectricityPhysicalQuantity", builder=ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityPhysicalQuantity", model="fpml", builder=ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilderImpl.class, version="2.1.1")
public interface ElectricityPhysicalQuantity extends CommodityPhysicalQuantityBase {

	ElectricityPhysicalQuantityMeta metaData = new ElectricityPhysicalQuantityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Quantity per Delivery Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Quantity per Delivery Period.
	 *
	 */
	List<? extends ElectricityPhysicalDeliveryQuantity> getPhysicalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the documentation of a shaped quantity trade where the quantity changes over the life of the transaction. Note that if the range of Settlement Periods also varies over the life of the transaction this element should not be used. Instead, physicalQuantity should be repeated for each range of Settlement Periods that apply at any point during the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows the documentation of a shaped quantity trade where the quantity changes over the life of the transaction. Note that if the range of Settlement Periods also varies over the life of the transaction this element should not be used. Instead, physicalQuantity should be repeated for each range of Settlement Periods that apply at any point during the trade.
	 *
	 */
	List<? extends ElectricityPhysicalDeliveryQuantitySchedule> getPhysicalQuantitySchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Total Quantity of the commodity to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Total Quantity of the commodity to be delivered.
	 *
	 */
	UnitQuantity getTotalPhysicalQuantity();

	/*********************** Build Methods  ***********************/
	ElectricityPhysicalQuantity build();
	
	ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder toBuilder();
	
	static ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder builder() {
		return new ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityPhysicalQuantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityPhysicalQuantity> getType() {
		return ElectricityPhysicalQuantity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("physicalQuantity"), processor, ElectricityPhysicalDeliveryQuantity.class, getPhysicalQuantity());
		processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, ElectricityPhysicalDeliveryQuantitySchedule.class, getPhysicalQuantitySchedule());
		processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.class, getTotalPhysicalQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityPhysicalQuantityBuilder extends ElectricityPhysicalQuantity, CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder {
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder getOrCreatePhysicalQuantity(int index);
		@Override
		List<? extends ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder> getPhysicalQuantity();
		ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule(int index);
		@Override
		List<? extends ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder> getPhysicalQuantitySchedule();
		UnitQuantity.UnitQuantityBuilder getOrCreateTotalPhysicalQuantity();
		@Override
		UnitQuantity.UnitQuantityBuilder getTotalPhysicalQuantity();
		@Override
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder setId(String id);
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantity(ElectricityPhysicalDeliveryQuantity physicalQuantity);
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantity(ElectricityPhysicalDeliveryQuantity physicalQuantity, int idx);
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantity(List<? extends ElectricityPhysicalDeliveryQuantity> physicalQuantity);
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder setPhysicalQuantity(List<? extends ElectricityPhysicalDeliveryQuantity> physicalQuantity);
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantitySchedule(ElectricityPhysicalDeliveryQuantitySchedule physicalQuantitySchedule);
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantitySchedule(ElectricityPhysicalDeliveryQuantitySchedule physicalQuantitySchedule, int idx);
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantitySchedule(List<? extends ElectricityPhysicalDeliveryQuantitySchedule> physicalQuantitySchedule);
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder setPhysicalQuantitySchedule(List<? extends ElectricityPhysicalDeliveryQuantitySchedule> physicalQuantitySchedule);
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder setTotalPhysicalQuantity(UnitQuantity totalPhysicalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("physicalQuantity"), processor, ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder.class, getPhysicalQuantity());
			processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder.class, getPhysicalQuantitySchedule());
			processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.UnitQuantityBuilder.class, getTotalPhysicalQuantity());
		}
		

		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityPhysicalQuantity  ***********************/
	class ElectricityPhysicalQuantityImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseImpl implements ElectricityPhysicalQuantity {
		private final List<? extends ElectricityPhysicalDeliveryQuantity> physicalQuantity;
		private final List<? extends ElectricityPhysicalDeliveryQuantitySchedule> physicalQuantitySchedule;
		private final UnitQuantity totalPhysicalQuantity;
		
		protected ElectricityPhysicalQuantityImpl(ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder builder) {
			super(builder);
			this.physicalQuantity = ofNullable(builder.getPhysicalQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.physicalQuantitySchedule = ofNullable(builder.getPhysicalQuantitySchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.totalPhysicalQuantity = ofNullable(builder.getTotalPhysicalQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("physicalQuantity")
		public List<? extends ElectricityPhysicalDeliveryQuantity> getPhysicalQuantity() {
			return physicalQuantity;
		}
		
		@Override
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("physicalQuantitySchedule")
		public List<? extends ElectricityPhysicalDeliveryQuantitySchedule> getPhysicalQuantitySchedule() {
			return physicalQuantitySchedule;
		}
		
		@Override
		@RosettaAttribute("totalPhysicalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalPhysicalQuantity")
		public UnitQuantity getTotalPhysicalQuantity() {
			return totalPhysicalQuantity;
		}
		
		@Override
		public ElectricityPhysicalQuantity build() {
			return this;
		}
		
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder toBuilder() {
			ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPhysicalQuantity()).ifPresent(builder::setPhysicalQuantity);
			ofNullable(getPhysicalQuantitySchedule()).ifPresent(builder::setPhysicalQuantitySchedule);
			ofNullable(getTotalPhysicalQuantity()).ifPresent(builder::setTotalPhysicalQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalQuantity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!ListEquals.listEquals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalQuantity {" +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ElectricityPhysicalQuantity  ***********************/
	class ElectricityPhysicalQuantityBuilderImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl implements ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder {
	
		protected List<ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder> physicalQuantity = new ArrayList<>();
		protected List<ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder> physicalQuantitySchedule = new ArrayList<>();
		protected UnitQuantity.UnitQuantityBuilder totalPhysicalQuantity;
		
		@Override
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("physicalQuantity")
		public List<? extends ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder> getPhysicalQuantity() {
			return physicalQuantity;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder getOrCreatePhysicalQuantity(int index) {
			if (physicalQuantity==null) {
				this.physicalQuantity = new ArrayList<>();
			}
			return getIndex(physicalQuantity, index, () -> {
						ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder newPhysicalQuantity = ElectricityPhysicalDeliveryQuantity.builder();
						return newPhysicalQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("physicalQuantitySchedule")
		public List<? extends ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder> getPhysicalQuantitySchedule() {
			return physicalQuantitySchedule;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule(int index) {
			if (physicalQuantitySchedule==null) {
				this.physicalQuantitySchedule = new ArrayList<>();
			}
			return getIndex(physicalQuantitySchedule, index, () -> {
						ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder newPhysicalQuantitySchedule = ElectricityPhysicalDeliveryQuantitySchedule.builder();
						return newPhysicalQuantitySchedule;
					});
		}
		
		@Override
		@RosettaAttribute("totalPhysicalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalPhysicalQuantity")
		public UnitQuantity.UnitQuantityBuilder getTotalPhysicalQuantity() {
			return totalPhysicalQuantity;
		}
		
		@Override
		public UnitQuantity.UnitQuantityBuilder getOrCreateTotalPhysicalQuantity() {
			UnitQuantity.UnitQuantityBuilder result;
			if (totalPhysicalQuantity!=null) {
				result = totalPhysicalQuantity;
			}
			else {
				result = totalPhysicalQuantity = UnitQuantity.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("physicalQuantity")
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantity(ElectricityPhysicalDeliveryQuantity _physicalQuantity) {
			if (_physicalQuantity != null) {
				this.physicalQuantity.add(_physicalQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantity(ElectricityPhysicalDeliveryQuantity _physicalQuantity, int idx) {
			getIndex(this.physicalQuantity, idx, () -> _physicalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantity(List<? extends ElectricityPhysicalDeliveryQuantity> physicalQuantitys) {
			if (physicalQuantitys != null) {
				for (final ElectricityPhysicalDeliveryQuantity toAdd : physicalQuantitys) {
					this.physicalQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("physicalQuantity")
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder setPhysicalQuantity(List<? extends ElectricityPhysicalDeliveryQuantity> physicalQuantitys) {
			if (physicalQuantitys == null) {
				this.physicalQuantity = new ArrayList<>();
			} else {
				this.physicalQuantity = physicalQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("physicalQuantitySchedule")
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantitySchedule(ElectricityPhysicalDeliveryQuantitySchedule _physicalQuantitySchedule) {
			if (_physicalQuantitySchedule != null) {
				this.physicalQuantitySchedule.add(_physicalQuantitySchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantitySchedule(ElectricityPhysicalDeliveryQuantitySchedule _physicalQuantitySchedule, int idx) {
			getIndex(this.physicalQuantitySchedule, idx, () -> _physicalQuantitySchedule.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder addPhysicalQuantitySchedule(List<? extends ElectricityPhysicalDeliveryQuantitySchedule> physicalQuantitySchedules) {
			if (physicalQuantitySchedules != null) {
				for (final ElectricityPhysicalDeliveryQuantitySchedule toAdd : physicalQuantitySchedules) {
					this.physicalQuantitySchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("physicalQuantitySchedule")
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder setPhysicalQuantitySchedule(List<? extends ElectricityPhysicalDeliveryQuantitySchedule> physicalQuantitySchedules) {
			if (physicalQuantitySchedules == null) {
				this.physicalQuantitySchedule = new ArrayList<>();
			} else {
				this.physicalQuantitySchedule = physicalQuantitySchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("totalPhysicalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalPhysicalQuantity")
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder setTotalPhysicalQuantity(UnitQuantity _totalPhysicalQuantity) {
			this.totalPhysicalQuantity = _totalPhysicalQuantity == null ? null : _totalPhysicalQuantity.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityPhysicalQuantity build() {
			return new ElectricityPhysicalQuantity.ElectricityPhysicalQuantityImpl(this);
		}
		
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder prune() {
			super.prune();
			physicalQuantity = physicalQuantity.stream().filter(b->b!=null).<ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			physicalQuantitySchedule = physicalQuantitySchedule.stream().filter(b->b!=null).<ElectricityPhysicalDeliveryQuantitySchedule.ElectricityPhysicalDeliveryQuantityScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (totalPhysicalQuantity!=null && !totalPhysicalQuantity.prune().hasData()) totalPhysicalQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPhysicalQuantity()!=null && getPhysicalQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPhysicalQuantitySchedule()!=null && getPhysicalQuantitySchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTotalPhysicalQuantity()!=null && getTotalPhysicalQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder o = (ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder) other;
			
			merger.mergeRosetta(getPhysicalQuantity(), o.getPhysicalQuantity(), this::getOrCreatePhysicalQuantity);
			merger.mergeRosetta(getPhysicalQuantitySchedule(), o.getPhysicalQuantitySchedule(), this::getOrCreatePhysicalQuantitySchedule);
			merger.mergeRosetta(getTotalPhysicalQuantity(), o.getTotalPhysicalQuantity(), this::setTotalPhysicalQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalQuantity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!ListEquals.listEquals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalQuantityBuilder {" +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity +
			'}' + " " + super.toString();
		}
	}
}
