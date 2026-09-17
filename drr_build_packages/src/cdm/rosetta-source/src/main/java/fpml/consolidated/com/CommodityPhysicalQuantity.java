package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.com.meta.CommodityPhysicalQuantityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the physical quantity of the commodity to be delivered.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the physical quantity of the commodity to be delivered.
 *
 */
@RosettaDataType(value="CommodityPhysicalQuantity", builder=CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityPhysicalQuantity", model="fpml", builder=CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilderImpl.class, version="2.1.1")
public interface CommodityPhysicalQuantity extends CommodityPhysicalQuantityBase {

	CommodityPhysicalQuantityMeta metaData = new CommodityPhysicalQuantityMeta();

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

	/*********************** Build Methods  ***********************/
	CommodityPhysicalQuantity build();
	
	CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder toBuilder();
	
	static CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder builder() {
		return new CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalQuantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityPhysicalQuantity> getType() {
		return CommodityPhysicalQuantity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.class, getPhysicalQuantity());
		processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.class, getPhysicalQuantitySchedule());
		processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.class, getTotalPhysicalQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalQuantityBuilder extends CommodityPhysicalQuantity, CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreatePhysicalQuantity();
		@Override
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getPhysicalQuantity();
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule();
		@Override
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getPhysicalQuantitySchedule();
		UnitQuantity.UnitQuantityBuilder getOrCreateTotalPhysicalQuantity();
		@Override
		UnitQuantity.UnitQuantityBuilder getTotalPhysicalQuantity();
		@Override
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setId(String id);
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setPhysicalQuantity(CommodityNotionalQuantity physicalQuantity);
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule physicalQuantitySchedule);
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setTotalPhysicalQuantity(UnitQuantity totalPhysicalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getPhysicalQuantity());
			processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder.class, getPhysicalQuantitySchedule());
			processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.UnitQuantityBuilder.class, getTotalPhysicalQuantity());
		}
		

		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalQuantity  ***********************/
	class CommodityPhysicalQuantityImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseImpl implements CommodityPhysicalQuantity {
		private final CommodityNotionalQuantity physicalQuantity;
		private final CommodityPhysicalQuantitySchedule physicalQuantitySchedule;
		private final UnitQuantity totalPhysicalQuantity;
		
		protected CommodityPhysicalQuantityImpl(CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder builder) {
			super(builder);
			this.physicalQuantity = ofNullable(builder.getPhysicalQuantity()).map(f->f.build()).orElse(null);
			this.physicalQuantitySchedule = ofNullable(builder.getPhysicalQuantitySchedule()).map(f->f.build()).orElse(null);
			this.totalPhysicalQuantity = ofNullable(builder.getTotalPhysicalQuantity()).map(f->f.build()).orElse(null);
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
		public CommodityPhysicalQuantity build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder toBuilder() {
			CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder builder) {
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
		
			CommodityPhysicalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
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
			return "CommodityPhysicalQuantity {" +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalQuantity  ***********************/
	class CommodityPhysicalQuantityBuilderImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl implements CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder {
	
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder physicalQuantity;
		protected CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder physicalQuantitySchedule;
		protected UnitQuantity.UnitQuantityBuilder totalPhysicalQuantity;
		
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalQuantity")
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setPhysicalQuantity(CommodityNotionalQuantity _physicalQuantity) {
			this.physicalQuantity = _physicalQuantity == null ? null : _physicalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalQuantitySchedule")
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule _physicalQuantitySchedule) {
			this.physicalQuantitySchedule = _physicalQuantitySchedule == null ? null : _physicalQuantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("totalPhysicalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalPhysicalQuantity")
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setTotalPhysicalQuantity(UnitQuantity _totalPhysicalQuantity) {
			this.totalPhysicalQuantity = _totalPhysicalQuantity == null ? null : _totalPhysicalQuantity.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantity build() {
			return new CommodityPhysicalQuantity.CommodityPhysicalQuantityImpl(this);
		}
		
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder prune() {
			super.prune();
			if (physicalQuantity!=null && !physicalQuantity.prune().hasData()) physicalQuantity = null;
			if (physicalQuantitySchedule!=null && !physicalQuantitySchedule.prune().hasData()) physicalQuantitySchedule = null;
			if (totalPhysicalQuantity!=null && !totalPhysicalQuantity.prune().hasData()) totalPhysicalQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPhysicalQuantity()!=null && getPhysicalQuantity().hasData()) return true;
			if (getPhysicalQuantitySchedule()!=null && getPhysicalQuantitySchedule().hasData()) return true;
			if (getTotalPhysicalQuantity()!=null && getTotalPhysicalQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder o = (CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder) other;
			
			merger.mergeRosetta(getPhysicalQuantity(), o.getPhysicalQuantity(), this::setPhysicalQuantity);
			merger.mergeRosetta(getPhysicalQuantitySchedule(), o.getPhysicalQuantitySchedule(), this::setPhysicalQuantitySchedule);
			merger.mergeRosetta(getTotalPhysicalQuantity(), o.getTotalPhysicalQuantity(), this::setTotalPhysicalQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPhysicalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
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
			return "CommodityPhysicalQuantityBuilder {" +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity +
			'}' + " " + super.toString();
		}
	}
}
