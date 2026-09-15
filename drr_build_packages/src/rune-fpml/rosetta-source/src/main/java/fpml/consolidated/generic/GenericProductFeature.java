package fpml.consolidated.generic;

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
import fpml.consolidated.generic.meta.GenericProductFeatureMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A flexible description a special feature or characteristic of a complex product not otherwise modeled, such as digital payout.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A flexible description a special feature or characteristic of a complex product not otherwise modeled, such as digital payout.
 *
 */
@RosettaDataType(value="GenericProductFeature", builder=GenericProductFeature.GenericProductFeatureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericProductFeature", model="fpml", builder=GenericProductFeature.GenericProductFeatureBuilderImpl.class, version="2.1.1")
public interface GenericProductFeature extends RosettaModelObject {

	GenericProductFeatureMeta metaData = new GenericProductFeatureMeta();

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
	 * Provision A feature included as part of this product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A feature included as part of this product.
	 *
	 */
	String getFeatureScheme();

	/*********************** Build Methods  ***********************/
	GenericProductFeature build();
	
	GenericProductFeature.GenericProductFeatureBuilder toBuilder();
	
	static GenericProductFeature.GenericProductFeatureBuilder builder() {
		return new GenericProductFeature.GenericProductFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericProductFeature> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericProductFeature> getType() {
		return GenericProductFeature.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("featureScheme"), String.class, getFeatureScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericProductFeatureBuilder extends GenericProductFeature, RosettaModelObjectBuilder {
		GenericProductFeature.GenericProductFeatureBuilder setValue(String value);
		GenericProductFeature.GenericProductFeatureBuilder setFeatureScheme(String featureScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("featureScheme"), String.class, getFeatureScheme(), this);
		}
		

		GenericProductFeature.GenericProductFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of GenericProductFeature  ***********************/
	class GenericProductFeatureImpl implements GenericProductFeature {
		private final String value;
		private final String featureScheme;
		
		protected GenericProductFeatureImpl(GenericProductFeature.GenericProductFeatureBuilder builder) {
			this.value = builder.getValue();
			this.featureScheme = builder.getFeatureScheme();
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
		@RosettaAttribute("featureScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("featureScheme")
		public String getFeatureScheme() {
			return featureScheme;
		}
		
		@Override
		public GenericProductFeature build() {
			return this;
		}
		
		@Override
		public GenericProductFeature.GenericProductFeatureBuilder toBuilder() {
			GenericProductFeature.GenericProductFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericProductFeature.GenericProductFeatureBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFeatureScheme()).ifPresent(builder::setFeatureScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductFeature _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(featureScheme, _that.getFeatureScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (featureScheme != null ? featureScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductFeature {" +
				"value=" + this.value + ", " +
				"featureScheme=" + this.featureScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericProductFeature  ***********************/
	class GenericProductFeatureBuilderImpl implements GenericProductFeature.GenericProductFeatureBuilder {
	
		protected String value;
		protected String featureScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("featureScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("featureScheme")
		public String getFeatureScheme() {
			return featureScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public GenericProductFeature.GenericProductFeatureBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("featureScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("featureScheme")
		@Override
		public GenericProductFeature.GenericProductFeatureBuilder setFeatureScheme(String _featureScheme) {
			this.featureScheme = _featureScheme == null ? null : _featureScheme;
			return this;
		}
		
		@Override
		public GenericProductFeature build() {
			return new GenericProductFeature.GenericProductFeatureImpl(this);
		}
		
		@Override
		public GenericProductFeature.GenericProductFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductFeature.GenericProductFeatureBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFeatureScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductFeature.GenericProductFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericProductFeature.GenericProductFeatureBuilder o = (GenericProductFeature.GenericProductFeatureBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFeatureScheme(), o.getFeatureScheme(), this::setFeatureScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductFeature _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(featureScheme, _that.getFeatureScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (featureScheme != null ? featureScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductFeatureBuilder {" +
				"value=" + this.value + ", " +
				"featureScheme=" + this.featureScheme +
			'}';
		}
	}
}
