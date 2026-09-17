package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.CommodityClassificationLayerMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type used to identify commodities. It can be used with several schemes in order to specify different classification layers or different classification systems or jurisdictions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type used to identify commodities. It can be used with several schemes in order to specify different classification layers or different classification systems or jurisdictions.
 *
 */
@RosettaDataType(value="CommodityClassificationLayer", builder=CommodityClassificationLayer.CommodityClassificationLayerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityClassificationLayer", model="fpml", builder=CommodityClassificationLayer.CommodityClassificationLayerBuilderImpl.class, version="2.1.1")
public interface CommodityClassificationLayer extends RosettaModelObject {

	CommodityClassificationLayerMeta metaData = new CommodityClassificationLayerMeta();

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
	String getCommodityClassificationScheme();

	/*********************** Build Methods  ***********************/
	CommodityClassificationLayer build();
	
	CommodityClassificationLayer.CommodityClassificationLayerBuilder toBuilder();
	
	static CommodityClassificationLayer.CommodityClassificationLayerBuilder builder() {
		return new CommodityClassificationLayer.CommodityClassificationLayerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityClassificationLayer> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityClassificationLayer> getType() {
		return CommodityClassificationLayer.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityClassificationScheme"), String.class, getCommodityClassificationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityClassificationLayerBuilder extends CommodityClassificationLayer, RosettaModelObjectBuilder {
		CommodityClassificationLayer.CommodityClassificationLayerBuilder setValue(String value);
		CommodityClassificationLayer.CommodityClassificationLayerBuilder setCommodityClassificationScheme(String commodityClassificationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityClassificationScheme"), String.class, getCommodityClassificationScheme(), this);
		}
		

		CommodityClassificationLayer.CommodityClassificationLayerBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityClassificationLayer  ***********************/
	class CommodityClassificationLayerImpl implements CommodityClassificationLayer {
		private final String value;
		private final String commodityClassificationScheme;
		
		protected CommodityClassificationLayerImpl(CommodityClassificationLayer.CommodityClassificationLayerBuilder builder) {
			this.value = builder.getValue();
			this.commodityClassificationScheme = builder.getCommodityClassificationScheme();
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
		@RosettaAttribute("commodityClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityClassificationScheme")
		public String getCommodityClassificationScheme() {
			return commodityClassificationScheme;
		}
		
		@Override
		public CommodityClassificationLayer build() {
			return this;
		}
		
		@Override
		public CommodityClassificationLayer.CommodityClassificationLayerBuilder toBuilder() {
			CommodityClassificationLayer.CommodityClassificationLayerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityClassificationLayer.CommodityClassificationLayerBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityClassificationScheme()).ifPresent(builder::setCommodityClassificationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityClassificationLayer _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityClassificationScheme, _that.getCommodityClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityClassificationScheme != null ? commodityClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityClassificationLayer {" +
				"value=" + this.value + ", " +
				"commodityClassificationScheme=" + this.commodityClassificationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityClassificationLayer  ***********************/
	class CommodityClassificationLayerBuilderImpl implements CommodityClassificationLayer.CommodityClassificationLayerBuilder {
	
		protected String value;
		protected String commodityClassificationScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityClassificationScheme")
		public String getCommodityClassificationScheme() {
			return commodityClassificationScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityClassificationLayer.CommodityClassificationLayerBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityClassificationScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityClassificationScheme")
		@Override
		public CommodityClassificationLayer.CommodityClassificationLayerBuilder setCommodityClassificationScheme(String _commodityClassificationScheme) {
			this.commodityClassificationScheme = _commodityClassificationScheme == null ? null : _commodityClassificationScheme;
			return this;
		}
		
		@Override
		public CommodityClassificationLayer build() {
			return new CommodityClassificationLayer.CommodityClassificationLayerImpl(this);
		}
		
		@Override
		public CommodityClassificationLayer.CommodityClassificationLayerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityClassificationLayer.CommodityClassificationLayerBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityClassificationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityClassificationLayer.CommodityClassificationLayerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityClassificationLayer.CommodityClassificationLayerBuilder o = (CommodityClassificationLayer.CommodityClassificationLayerBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityClassificationScheme(), o.getCommodityClassificationScheme(), this::setCommodityClassificationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityClassificationLayer _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityClassificationScheme, _that.getCommodityClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityClassificationScheme != null ? commodityClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityClassificationLayerBuilder {" +
				"value=" + this.value + ", " +
				"commodityClassificationScheme=" + this.commodityClassificationScheme +
			'}';
		}
	}
}
