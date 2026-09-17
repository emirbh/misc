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
import fpml.consolidated.com.meta.GasPhysicalQuantityMeta;
import fpml.consolidated.shared.PartyReference;
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
@RosettaDataType(value="GasPhysicalQuantity", builder=GasPhysicalQuantity.GasPhysicalQuantityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GasPhysicalQuantity", model="fpml", builder=GasPhysicalQuantity.GasPhysicalQuantityBuilderImpl.class, version="2.1.1")
public interface GasPhysicalQuantity extends CommodityPhysicalQuantityBase {

	GasPhysicalQuantityMeta metaData = new GasPhysicalQuantityMeta();

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
	CommodityNotionalQuantity getPhysicalQuantity();
	/**
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
	CommodityPhysicalQuantitySchedule getPhysicalQuantitySchedule();
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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The minimum quantity to be delivered. If separate minimums need to be specified for different periods (e.g. a minimum per day and a minimum per month) this element should be repeated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The minimum quantity to be delivered. If separate minimums need to be specified for different periods (e.g. a minimum per day and a minimum per month) this element should be repeated.
	 *
	 */
	List<? extends CommodityNotionalQuantity> getMinPhysicalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The maximum quantity to be delivered. If separate minimums need to be specified for different periods (e.g. a minimum per day and a minimum per month) this element should be repeated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maximum quantity to be delivered. If separate minimums need to be specified for different periods (e.g. a minimum per day and a minimum per month) this element should be repeated.
	 *
	 */
	List<? extends CommodityNotionalQuantity> getMaxPhysicalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party able to choose whether the gas is delivered for a particular period e.g. a swing or interruptible contract.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the party able to choose whether the gas is delivered for a particular period e.g. a swing or interruptible contract.
	 *
	 */
	PartyReference getElectingParty();

	/*********************** Build Methods  ***********************/
	GasPhysicalQuantity build();
	
	GasPhysicalQuantity.GasPhysicalQuantityBuilder toBuilder();
	
	static GasPhysicalQuantity.GasPhysicalQuantityBuilder builder() {
		return new GasPhysicalQuantity.GasPhysicalQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasPhysicalQuantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GasPhysicalQuantity> getType() {
		return GasPhysicalQuantity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.class, getPhysicalQuantity());
		processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.class, getPhysicalQuantitySchedule());
		processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.class, getTotalPhysicalQuantity());
		processRosetta(path.newSubPath("minPhysicalQuantity"), processor, CommodityNotionalQuantity.class, getMinPhysicalQuantity());
		processRosetta(path.newSubPath("maxPhysicalQuantity"), processor, CommodityNotionalQuantity.class, getMaxPhysicalQuantity());
		processRosetta(path.newSubPath("electingParty"), processor, PartyReference.class, getElectingParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasPhysicalQuantityBuilder extends GasPhysicalQuantity, CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreatePhysicalQuantity();
		@Override
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getPhysicalQuantity();
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule();
		@Override
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getPhysicalQuantitySchedule();
		UnitQuantity.UnitQuantityBuilder getOrCreateTotalPhysicalQuantity();
		@Override
		UnitQuantity.UnitQuantityBuilder getTotalPhysicalQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMinPhysicalQuantity(int index);
		@Override
		List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getMinPhysicalQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMaxPhysicalQuantity(int index);
		@Override
		List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getMaxPhysicalQuantity();
		PartyReference.PartyReferenceBuilder getOrCreateElectingParty();
		@Override
		PartyReference.PartyReferenceBuilder getElectingParty();
		@Override
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setId(String id);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setPhysicalQuantity(CommodityNotionalQuantity physicalQuantity);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule physicalQuantitySchedule);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setTotalPhysicalQuantity(UnitQuantity totalPhysicalQuantity);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder addMinPhysicalQuantity(CommodityNotionalQuantity minPhysicalQuantity);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder addMinPhysicalQuantity(CommodityNotionalQuantity minPhysicalQuantity, int idx);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder addMinPhysicalQuantity(List<? extends CommodityNotionalQuantity> minPhysicalQuantity);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setMinPhysicalQuantity(List<? extends CommodityNotionalQuantity> minPhysicalQuantity);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder addMaxPhysicalQuantity(CommodityNotionalQuantity maxPhysicalQuantity);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder addMaxPhysicalQuantity(CommodityNotionalQuantity maxPhysicalQuantity, int idx);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder addMaxPhysicalQuantity(List<? extends CommodityNotionalQuantity> maxPhysicalQuantity);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setMaxPhysicalQuantity(List<? extends CommodityNotionalQuantity> maxPhysicalQuantity);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setElectingParty(PartyReference electingParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getPhysicalQuantity());
			processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder.class, getPhysicalQuantitySchedule());
			processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.UnitQuantityBuilder.class, getTotalPhysicalQuantity());
			processRosetta(path.newSubPath("minPhysicalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getMinPhysicalQuantity());
			processRosetta(path.newSubPath("maxPhysicalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getMaxPhysicalQuantity());
			processRosetta(path.newSubPath("electingParty"), processor, PartyReference.PartyReferenceBuilder.class, getElectingParty());
		}
		

		GasPhysicalQuantity.GasPhysicalQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of GasPhysicalQuantity  ***********************/
	class GasPhysicalQuantityImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseImpl implements GasPhysicalQuantity {
		private final CommodityNotionalQuantity physicalQuantity;
		private final CommodityPhysicalQuantitySchedule physicalQuantitySchedule;
		private final UnitQuantity totalPhysicalQuantity;
		private final List<? extends CommodityNotionalQuantity> minPhysicalQuantity;
		private final List<? extends CommodityNotionalQuantity> maxPhysicalQuantity;
		private final PartyReference electingParty;
		
		protected GasPhysicalQuantityImpl(GasPhysicalQuantity.GasPhysicalQuantityBuilder builder) {
			super(builder);
			this.physicalQuantity = ofNullable(builder.getPhysicalQuantity()).map(f->f.build()).orElse(null);
			this.physicalQuantitySchedule = ofNullable(builder.getPhysicalQuantitySchedule()).map(f->f.build()).orElse(null);
			this.totalPhysicalQuantity = ofNullable(builder.getTotalPhysicalQuantity()).map(f->f.build()).orElse(null);
			this.minPhysicalQuantity = ofNullable(builder.getMinPhysicalQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.maxPhysicalQuantity = ofNullable(builder.getMaxPhysicalQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.electingParty = ofNullable(builder.getElectingParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalQuantity")
		public CommodityNotionalQuantity getPhysicalQuantity() {
			return physicalQuantity;
		}
		
		@Override
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalQuantitySchedule")
		public CommodityPhysicalQuantitySchedule getPhysicalQuantitySchedule() {
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
		@RosettaAttribute("minPhysicalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("minPhysicalQuantity")
		public List<? extends CommodityNotionalQuantity> getMinPhysicalQuantity() {
			return minPhysicalQuantity;
		}
		
		@Override
		@RosettaAttribute("maxPhysicalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("maxPhysicalQuantity")
		public List<? extends CommodityNotionalQuantity> getMaxPhysicalQuantity() {
			return maxPhysicalQuantity;
		}
		
		@Override
		@RosettaAttribute("electingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electingParty")
		public PartyReference getElectingParty() {
			return electingParty;
		}
		
		@Override
		public GasPhysicalQuantity build() {
			return this;
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder toBuilder() {
			GasPhysicalQuantity.GasPhysicalQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasPhysicalQuantity.GasPhysicalQuantityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPhysicalQuantity()).ifPresent(builder::setPhysicalQuantity);
			ofNullable(getPhysicalQuantitySchedule()).ifPresent(builder::setPhysicalQuantitySchedule);
			ofNullable(getTotalPhysicalQuantity()).ifPresent(builder::setTotalPhysicalQuantity);
			ofNullable(getMinPhysicalQuantity()).ifPresent(builder::setMinPhysicalQuantity);
			ofNullable(getMaxPhysicalQuantity()).ifPresent(builder::setMaxPhysicalQuantity);
			ofNullable(getElectingParty()).ifPresent(builder::setElectingParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasPhysicalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			if (!ListEquals.listEquals(minPhysicalQuantity, _that.getMinPhysicalQuantity())) return false;
			if (!ListEquals.listEquals(maxPhysicalQuantity, _that.getMaxPhysicalQuantity())) return false;
			if (!Objects.equals(electingParty, _that.getElectingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (minPhysicalQuantity != null ? minPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (maxPhysicalQuantity != null ? maxPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (electingParty != null ? electingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalQuantity {" +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity + ", " +
				"minPhysicalQuantity=" + this.minPhysicalQuantity + ", " +
				"maxPhysicalQuantity=" + this.maxPhysicalQuantity + ", " +
				"electingParty=" + this.electingParty +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GasPhysicalQuantity  ***********************/
	class GasPhysicalQuantityBuilderImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl implements GasPhysicalQuantity.GasPhysicalQuantityBuilder {
	
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder physicalQuantity;
		protected CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder physicalQuantitySchedule;
		protected UnitQuantity.UnitQuantityBuilder totalPhysicalQuantity;
		protected List<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> minPhysicalQuantity = new ArrayList<>();
		protected List<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> maxPhysicalQuantity = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder electingParty;
		
		@Override
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getPhysicalQuantity() {
			return physicalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreatePhysicalQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (physicalQuantity!=null) {
				result = physicalQuantity;
			}
			else {
				result = physicalQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalQuantitySchedule")
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getPhysicalQuantitySchedule() {
			return physicalQuantitySchedule;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule() {
			CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder result;
			if (physicalQuantitySchedule!=null) {
				result = physicalQuantitySchedule;
			}
			else {
				result = physicalQuantitySchedule = CommodityPhysicalQuantitySchedule.builder();
			}
			
			return result;
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
		
		@Override
		@RosettaAttribute("minPhysicalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("minPhysicalQuantity")
		public List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getMinPhysicalQuantity() {
			return minPhysicalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMinPhysicalQuantity(int index) {
			if (minPhysicalQuantity==null) {
				this.minPhysicalQuantity = new ArrayList<>();
			}
			return getIndex(minPhysicalQuantity, index, () -> {
						CommodityNotionalQuantity.CommodityNotionalQuantityBuilder newMinPhysicalQuantity = CommodityNotionalQuantity.builder();
						return newMinPhysicalQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("maxPhysicalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("maxPhysicalQuantity")
		public List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getMaxPhysicalQuantity() {
			return maxPhysicalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMaxPhysicalQuantity(int index) {
			if (maxPhysicalQuantity==null) {
				this.maxPhysicalQuantity = new ArrayList<>();
			}
			return getIndex(maxPhysicalQuantity, index, () -> {
						CommodityNotionalQuantity.CommodityNotionalQuantityBuilder newMaxPhysicalQuantity = CommodityNotionalQuantity.builder();
						return newMaxPhysicalQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("electingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electingParty")
		public PartyReference.PartyReferenceBuilder getElectingParty() {
			return electingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateElectingParty() {
			PartyReference.PartyReferenceBuilder result;
			if (electingParty!=null) {
				result = electingParty;
			}
			else {
				result = electingParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalQuantity")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setPhysicalQuantity(CommodityNotionalQuantity _physicalQuantity) {
			this.physicalQuantity = _physicalQuantity == null ? null : _physicalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalQuantitySchedule")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule _physicalQuantitySchedule) {
			this.physicalQuantitySchedule = _physicalQuantitySchedule == null ? null : _physicalQuantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("totalPhysicalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalPhysicalQuantity")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setTotalPhysicalQuantity(UnitQuantity _totalPhysicalQuantity) {
			this.totalPhysicalQuantity = _totalPhysicalQuantity == null ? null : _totalPhysicalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minPhysicalQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("minPhysicalQuantity")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder addMinPhysicalQuantity(CommodityNotionalQuantity _minPhysicalQuantity) {
			if (_minPhysicalQuantity != null) {
				this.minPhysicalQuantity.add(_minPhysicalQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder addMinPhysicalQuantity(CommodityNotionalQuantity _minPhysicalQuantity, int idx) {
			getIndex(this.minPhysicalQuantity, idx, () -> _minPhysicalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder addMinPhysicalQuantity(List<? extends CommodityNotionalQuantity> minPhysicalQuantitys) {
			if (minPhysicalQuantitys != null) {
				for (final CommodityNotionalQuantity toAdd : minPhysicalQuantitys) {
					this.minPhysicalQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("minPhysicalQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("minPhysicalQuantity")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setMinPhysicalQuantity(List<? extends CommodityNotionalQuantity> minPhysicalQuantitys) {
			if (minPhysicalQuantitys == null) {
				this.minPhysicalQuantity = new ArrayList<>();
			} else {
				this.minPhysicalQuantity = minPhysicalQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("maxPhysicalQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("maxPhysicalQuantity")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder addMaxPhysicalQuantity(CommodityNotionalQuantity _maxPhysicalQuantity) {
			if (_maxPhysicalQuantity != null) {
				this.maxPhysicalQuantity.add(_maxPhysicalQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder addMaxPhysicalQuantity(CommodityNotionalQuantity _maxPhysicalQuantity, int idx) {
			getIndex(this.maxPhysicalQuantity, idx, () -> _maxPhysicalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder addMaxPhysicalQuantity(List<? extends CommodityNotionalQuantity> maxPhysicalQuantitys) {
			if (maxPhysicalQuantitys != null) {
				for (final CommodityNotionalQuantity toAdd : maxPhysicalQuantitys) {
					this.maxPhysicalQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("maxPhysicalQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("maxPhysicalQuantity")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setMaxPhysicalQuantity(List<? extends CommodityNotionalQuantity> maxPhysicalQuantitys) {
			if (maxPhysicalQuantitys == null) {
				this.maxPhysicalQuantity = new ArrayList<>();
			} else {
				this.maxPhysicalQuantity = maxPhysicalQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("electingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("electingParty")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setElectingParty(PartyReference _electingParty) {
			this.electingParty = _electingParty == null ? null : _electingParty.toBuilder();
			return this;
		}
		
		@Override
		public GasPhysicalQuantity build() {
			return new GasPhysicalQuantity.GasPhysicalQuantityImpl(this);
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder prune() {
			super.prune();
			if (physicalQuantity!=null && !physicalQuantity.prune().hasData()) physicalQuantity = null;
			if (physicalQuantitySchedule!=null && !physicalQuantitySchedule.prune().hasData()) physicalQuantitySchedule = null;
			if (totalPhysicalQuantity!=null && !totalPhysicalQuantity.prune().hasData()) totalPhysicalQuantity = null;
			minPhysicalQuantity = minPhysicalQuantity.stream().filter(b->b!=null).<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			maxPhysicalQuantity = maxPhysicalQuantity.stream().filter(b->b!=null).<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (electingParty!=null && !electingParty.prune().hasData()) electingParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPhysicalQuantity()!=null && getPhysicalQuantity().hasData()) return true;
			if (getPhysicalQuantitySchedule()!=null && getPhysicalQuantitySchedule().hasData()) return true;
			if (getTotalPhysicalQuantity()!=null && getTotalPhysicalQuantity().hasData()) return true;
			if (getMinPhysicalQuantity()!=null && getMinPhysicalQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMaxPhysicalQuantity()!=null && getMaxPhysicalQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getElectingParty()!=null && getElectingParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GasPhysicalQuantity.GasPhysicalQuantityBuilder o = (GasPhysicalQuantity.GasPhysicalQuantityBuilder) other;
			
			merger.mergeRosetta(getPhysicalQuantity(), o.getPhysicalQuantity(), this::setPhysicalQuantity);
			merger.mergeRosetta(getPhysicalQuantitySchedule(), o.getPhysicalQuantitySchedule(), this::setPhysicalQuantitySchedule);
			merger.mergeRosetta(getTotalPhysicalQuantity(), o.getTotalPhysicalQuantity(), this::setTotalPhysicalQuantity);
			merger.mergeRosetta(getMinPhysicalQuantity(), o.getMinPhysicalQuantity(), this::getOrCreateMinPhysicalQuantity);
			merger.mergeRosetta(getMaxPhysicalQuantity(), o.getMaxPhysicalQuantity(), this::getOrCreateMaxPhysicalQuantity);
			merger.mergeRosetta(getElectingParty(), o.getElectingParty(), this::setElectingParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasPhysicalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			if (!ListEquals.listEquals(minPhysicalQuantity, _that.getMinPhysicalQuantity())) return false;
			if (!ListEquals.listEquals(maxPhysicalQuantity, _that.getMaxPhysicalQuantity())) return false;
			if (!Objects.equals(electingParty, _that.getElectingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (minPhysicalQuantity != null ? minPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (maxPhysicalQuantity != null ? maxPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (electingParty != null ? electingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalQuantityBuilder {" +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity + ", " +
				"minPhysicalQuantity=" + this.minPhysicalQuantity + ", " +
				"maxPhysicalQuantity=" + this.maxPhysicalQuantity + ", " +
				"electingParty=" + this.electingParty +
			'}' + " " + super.toString();
		}
	}
}
