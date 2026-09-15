package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.com.meta.MaterialMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A scheme identifying the types of metal product for a physically settled metal trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A scheme identifying the types of metal product for a physically settled metal trade.
 *
 */
@RosettaDataType(value="Material", builder=Material.MaterialBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Material", model="fpml", builder=Material.MaterialBuilderImpl.class, version="2.1.1")
public interface Material extends RosettaModelObject {

	MaterialMeta metaData = new MaterialMeta();

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
	String getValue();
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
	String getCommodityMetalProductTypeScheme();

	/*********************** Build Methods  ***********************/
	Material build();
	
	Material.MaterialBuilder toBuilder();
	
	static Material.MaterialBuilder builder() {
		return new Material.MaterialBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Material> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Material> getType() {
		return Material.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityMetalProductTypeScheme"), String.class, getCommodityMetalProductTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MaterialBuilder extends Material, RosettaModelObjectBuilder {
		Material.MaterialBuilder setValue(String value);
		Material.MaterialBuilder setCommodityMetalProductTypeScheme(String commodityMetalProductTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityMetalProductTypeScheme"), String.class, getCommodityMetalProductTypeScheme(), this);
		}
		

		Material.MaterialBuilder prune();
	}

	/*********************** Immutable Implementation of Material  ***********************/
	class MaterialImpl implements Material {
		private final String value;
		private final String commodityMetalProductTypeScheme;
		
		protected MaterialImpl(Material.MaterialBuilder builder) {
			this.value = builder.getValue();
			this.commodityMetalProductTypeScheme = builder.getCommodityMetalProductTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMetalProductTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMetalProductTypeScheme")
		public String getCommodityMetalProductTypeScheme() {
			return commodityMetalProductTypeScheme;
		}
		
		@Override
		public Material build() {
			return this;
		}
		
		@Override
		public Material.MaterialBuilder toBuilder() {
			Material.MaterialBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Material.MaterialBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityMetalProductTypeScheme()).ifPresent(builder::setCommodityMetalProductTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Material _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalProductTypeScheme, _that.getCommodityMetalProductTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalProductTypeScheme != null ? commodityMetalProductTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Material {" +
				"value=" + this.value + ", " +
				"commodityMetalProductTypeScheme=" + this.commodityMetalProductTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Material  ***********************/
	class MaterialBuilderImpl implements Material.MaterialBuilder {
	
		protected String value;
		protected String commodityMetalProductTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMetalProductTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMetalProductTypeScheme")
		public String getCommodityMetalProductTypeScheme() {
			return commodityMetalProductTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public Material.MaterialBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityMetalProductTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityMetalProductTypeScheme")
		@Override
		public Material.MaterialBuilder setCommodityMetalProductTypeScheme(String _commodityMetalProductTypeScheme) {
			this.commodityMetalProductTypeScheme = _commodityMetalProductTypeScheme == null ? null : _commodityMetalProductTypeScheme;
			return this;
		}
		
		@Override
		public Material build() {
			return new Material.MaterialImpl(this);
		}
		
		@Override
		public Material.MaterialBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Material.MaterialBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityMetalProductTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Material.MaterialBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Material.MaterialBuilder o = (Material.MaterialBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityMetalProductTypeScheme(), o.getCommodityMetalProductTypeScheme(), this::setCommodityMetalProductTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Material _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalProductTypeScheme, _that.getCommodityMetalProductTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalProductTypeScheme != null ? commodityMetalProductTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaterialBuilder {" +
				"value=" + this.value + ", " +
				"commodityMetalProductTypeScheme=" + this.commodityMetalProductTypeScheme +
			'}';
		}
	}
}
