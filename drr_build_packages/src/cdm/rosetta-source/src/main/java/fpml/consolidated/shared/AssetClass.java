package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.AssetClassMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="AssetClass", builder=AssetClass.AssetClassBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AssetClass", model="fpml", builder=AssetClass.AssetClassBuilderImpl.class, version="2.1.1")
public interface AssetClass extends RosettaModelObject {

	AssetClassMeta metaData = new AssetClassMeta();

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
	String getAssetClassScheme();

	/*********************** Build Methods  ***********************/
	AssetClass build();
	
	AssetClass.AssetClassBuilder toBuilder();
	
	static AssetClass.AssetClassBuilder builder() {
		return new AssetClass.AssetClassBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClass> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClass> getType() {
		return AssetClass.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("assetClassScheme"), String.class, getAssetClassScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassBuilder extends AssetClass, RosettaModelObjectBuilder {
		AssetClass.AssetClassBuilder setValue(String value);
		AssetClass.AssetClassBuilder setAssetClassScheme(String assetClassScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("assetClassScheme"), String.class, getAssetClassScheme(), this);
		}
		

		AssetClass.AssetClassBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClass  ***********************/
	class AssetClassImpl implements AssetClass {
		private final String value;
		private final String assetClassScheme;
		
		protected AssetClassImpl(AssetClass.AssetClassBuilder builder) {
			this.value = builder.getValue();
			this.assetClassScheme = builder.getAssetClassScheme();
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
		@RosettaAttribute("assetClassScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetClassScheme")
		public String getAssetClassScheme() {
			return assetClassScheme;
		}
		
		@Override
		public AssetClass build() {
			return this;
		}
		
		@Override
		public AssetClass.AssetClassBuilder toBuilder() {
			AssetClass.AssetClassBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClass.AssetClassBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAssetClassScheme()).ifPresent(builder::setAssetClassScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClass _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(assetClassScheme, _that.getAssetClassScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (assetClassScheme != null ? assetClassScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClass {" +
				"value=" + this.value + ", " +
				"assetClassScheme=" + this.assetClassScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClass  ***********************/
	class AssetClassBuilderImpl implements AssetClass.AssetClassBuilder {
	
		protected String value;
		protected String assetClassScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("assetClassScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetClassScheme")
		public String getAssetClassScheme() {
			return assetClassScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public AssetClass.AssetClassBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("assetClassScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetClassScheme")
		@Override
		public AssetClass.AssetClassBuilder setAssetClassScheme(String _assetClassScheme) {
			this.assetClassScheme = _assetClassScheme == null ? null : _assetClassScheme;
			return this;
		}
		
		@Override
		public AssetClass build() {
			return new AssetClass.AssetClassImpl(this);
		}
		
		@Override
		public AssetClass.AssetClassBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClass.AssetClassBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAssetClassScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClass.AssetClassBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClass.AssetClassBuilder o = (AssetClass.AssetClassBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAssetClassScheme(), o.getAssetClassScheme(), this::setAssetClassScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClass _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(assetClassScheme, _that.getAssetClassScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (assetClassScheme != null ? assetClassScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassBuilder {" +
				"value=" + this.value + ", " +
				"assetClassScheme=" + this.assetClassScheme +
			'}';
		}
	}
}
