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
import fpml.consolidated.com.meta.ElectricityDeliverySystemFirmMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The physical delivery obligation options specific to a system firm transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The physical delivery obligation options specific to a system firm transaction.
 *
 */
@RosettaDataType(value="ElectricityDeliverySystemFirm", builder=ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityDeliverySystemFirm", model="fpml", builder=ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilderImpl.class, version="2.1.1")
public interface ElectricityDeliverySystemFirm extends RosettaModelObject {

	ElectricityDeliverySystemFirmMeta metaData = new ElectricityDeliverySystemFirmMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the trade is for a System Firm product. Should always be set to "true".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that the trade is for a System Firm product. Should always be set to "true".
	 *
	 */
	Boolean getApplicable();
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
	CommodityDeliveryPoint getSystem();

	/*********************** Build Methods  ***********************/
	ElectricityDeliverySystemFirm build();
	
	ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder toBuilder();
	
	static ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder builder() {
		return new ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDeliverySystemFirm> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityDeliverySystemFirm> getType() {
		return ElectricityDeliverySystemFirm.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("system"), processor, CommodityDeliveryPoint.class, getSystem());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliverySystemFirmBuilder extends ElectricityDeliverySystemFirm, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateSystem();
		@Override
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getSystem();
		ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder setApplicable(Boolean applicable);
		ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder setSystem(CommodityDeliveryPoint system);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("system"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getSystem());
		}
		

		ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityDeliverySystemFirm  ***********************/
	class ElectricityDeliverySystemFirmImpl implements ElectricityDeliverySystemFirm {
		private final Boolean applicable;
		private final CommodityDeliveryPoint system;
		
		protected ElectricityDeliverySystemFirmImpl(ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder builder) {
			this.applicable = builder.getApplicable();
			this.system = ofNullable(builder.getSystem()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("system")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("system")
		public CommodityDeliveryPoint getSystem() {
			return system;
		}
		
		@Override
		public ElectricityDeliverySystemFirm build() {
			return this;
		}
		
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder toBuilder() {
			ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getSystem()).ifPresent(builder::setSystem);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliverySystemFirm _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(system, _that.getSystem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (system != null ? system.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliverySystemFirm {" +
				"applicable=" + this.applicable + ", " +
				"system=" + this.system +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDeliverySystemFirm  ***********************/
	class ElectricityDeliverySystemFirmBuilderImpl implements ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder {
	
		protected Boolean applicable;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder system;
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("system")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("system")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getSystem() {
			return system;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateSystem() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (system!=null) {
				result = system;
			}
			else {
				result = system = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicable")
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder setApplicable(Boolean _applicable) {
			this.applicable = _applicable == null ? null : _applicable;
			return this;
		}
		
		@RosettaAttribute("system")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("system")
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder setSystem(CommodityDeliveryPoint _system) {
			this.system = _system == null ? null : _system.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityDeliverySystemFirm build() {
			return new ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmImpl(this);
		}
		
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder prune() {
			if (system!=null && !system.prune().hasData()) system = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getSystem()!=null && getSystem().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder o = (ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder) other;
			
			merger.mergeRosetta(getSystem(), o.getSystem(), this::setSystem);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliverySystemFirm _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(system, _that.getSystem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (system != null ? system.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliverySystemFirmBuilder {" +
				"applicable=" + this.applicable + ", " +
				"system=" + this.system +
			'}';
		}
	}
}
