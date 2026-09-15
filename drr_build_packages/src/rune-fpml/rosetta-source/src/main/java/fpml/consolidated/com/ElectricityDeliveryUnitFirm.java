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
import fpml.consolidated.com.meta.ElectricityDeliveryUnitFirmMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The physical delivery obligation options specific to a unit firm transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The physical delivery obligation options specific to a unit firm transaction.
 *
 */
@RosettaDataType(value="ElectricityDeliveryUnitFirm", builder=ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityDeliveryUnitFirm", model="fpml", builder=ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilderImpl.class, version="2.1.1")
public interface ElectricityDeliveryUnitFirm extends RosettaModelObject {

	ElectricityDeliveryUnitFirmMeta metaData = new ElectricityDeliveryUnitFirmMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the trade is for a Unit Firm product. Should always be set to "true".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that the trade is for a Unit Firm product. Should always be set to "true".
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
	CommodityDeliveryPoint getGenerationAsset();

	/*********************** Build Methods  ***********************/
	ElectricityDeliveryUnitFirm build();
	
	ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder toBuilder();
	
	static ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder builder() {
		return new ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDeliveryUnitFirm> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityDeliveryUnitFirm> getType() {
		return ElectricityDeliveryUnitFirm.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("generationAsset"), processor, CommodityDeliveryPoint.class, getGenerationAsset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliveryUnitFirmBuilder extends ElectricityDeliveryUnitFirm, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateGenerationAsset();
		@Override
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getGenerationAsset();
		ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder setApplicable(Boolean applicable);
		ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder setGenerationAsset(CommodityDeliveryPoint generationAsset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("generationAsset"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getGenerationAsset());
		}
		

		ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityDeliveryUnitFirm  ***********************/
	class ElectricityDeliveryUnitFirmImpl implements ElectricityDeliveryUnitFirm {
		private final Boolean applicable;
		private final CommodityDeliveryPoint generationAsset;
		
		protected ElectricityDeliveryUnitFirmImpl(ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder builder) {
			this.applicable = builder.getApplicable();
			this.generationAsset = ofNullable(builder.getGenerationAsset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("generationAsset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generationAsset")
		public CommodityDeliveryPoint getGenerationAsset() {
			return generationAsset;
		}
		
		@Override
		public ElectricityDeliveryUnitFirm build() {
			return this;
		}
		
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder toBuilder() {
			ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getGenerationAsset()).ifPresent(builder::setGenerationAsset);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryUnitFirm _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(generationAsset, _that.getGenerationAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (generationAsset != null ? generationAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryUnitFirm {" +
				"applicable=" + this.applicable + ", " +
				"generationAsset=" + this.generationAsset +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDeliveryUnitFirm  ***********************/
	class ElectricityDeliveryUnitFirmBuilderImpl implements ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder {
	
		protected Boolean applicable;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder generationAsset;
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("generationAsset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generationAsset")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getGenerationAsset() {
			return generationAsset;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateGenerationAsset() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (generationAsset!=null) {
				result = generationAsset;
			}
			else {
				result = generationAsset = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicable")
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder setApplicable(Boolean _applicable) {
			this.applicable = _applicable == null ? null : _applicable;
			return this;
		}
		
		@RosettaAttribute("generationAsset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("generationAsset")
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder setGenerationAsset(CommodityDeliveryPoint _generationAsset) {
			this.generationAsset = _generationAsset == null ? null : _generationAsset.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityDeliveryUnitFirm build() {
			return new ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmImpl(this);
		}
		
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder prune() {
			if (generationAsset!=null && !generationAsset.prune().hasData()) generationAsset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getGenerationAsset()!=null && getGenerationAsset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder o = (ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder) other;
			
			merger.mergeRosetta(getGenerationAsset(), o.getGenerationAsset(), this::setGenerationAsset);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryUnitFirm _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(generationAsset, _that.getGenerationAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (generationAsset != null ? generationAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryUnitFirmBuilder {" +
				"applicable=" + this.applicable + ", " +
				"generationAsset=" + this.generationAsset +
			'}';
		}
	}
}
