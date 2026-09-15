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
import fpml.consolidated.shared.meta.ProductIdMeta;
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
@RosettaDataType(value="ProductId", builder=ProductId.ProductIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ProductId", model="fpml", builder=ProductId.ProductIdBuilderImpl.class, version="2.1.1")
public interface ProductId extends RosettaModelObject {

	ProductIdMeta metaData = new ProductIdMeta();

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
	String getProductIdScheme();

	/*********************** Build Methods  ***********************/
	ProductId build();
	
	ProductId.ProductIdBuilder toBuilder();
	
	static ProductId.ProductIdBuilder builder() {
		return new ProductId.ProductIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProductId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ProductId> getType() {
		return ProductId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("productIdScheme"), String.class, getProductIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductIdBuilder extends ProductId, RosettaModelObjectBuilder {
		ProductId.ProductIdBuilder setValue(String value);
		ProductId.ProductIdBuilder setProductIdScheme(String productIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("productIdScheme"), String.class, getProductIdScheme(), this);
		}
		

		ProductId.ProductIdBuilder prune();
	}

	/*********************** Immutable Implementation of ProductId  ***********************/
	class ProductIdImpl implements ProductId {
		private final String value;
		private final String productIdScheme;
		
		protected ProductIdImpl(ProductId.ProductIdBuilder builder) {
			this.value = builder.getValue();
			this.productIdScheme = builder.getProductIdScheme();
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
		@RosettaAttribute("productIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productIdScheme")
		public String getProductIdScheme() {
			return productIdScheme;
		}
		
		@Override
		public ProductId build() {
			return this;
		}
		
		@Override
		public ProductId.ProductIdBuilder toBuilder() {
			ProductId.ProductIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductId.ProductIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getProductIdScheme()).ifPresent(builder::setProductIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(productIdScheme, _that.getProductIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (productIdScheme != null ? productIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductId {" +
				"value=" + this.value + ", " +
				"productIdScheme=" + this.productIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ProductId  ***********************/
	class ProductIdBuilderImpl implements ProductId.ProductIdBuilder {
	
		protected String value;
		protected String productIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("productIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productIdScheme")
		public String getProductIdScheme() {
			return productIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ProductId.ProductIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("productIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("productIdScheme")
		@Override
		public ProductId.ProductIdBuilder setProductIdScheme(String _productIdScheme) {
			this.productIdScheme = _productIdScheme == null ? null : _productIdScheme;
			return this;
		}
		
		@Override
		public ProductId build() {
			return new ProductId.ProductIdImpl(this);
		}
		
		@Override
		public ProductId.ProductIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductId.ProductIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getProductIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductId.ProductIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductId.ProductIdBuilder o = (ProductId.ProductIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getProductIdScheme(), o.getProductIdScheme(), this::setProductIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(productIdScheme, _that.getProductIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (productIdScheme != null ? productIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductIdBuilder {" +
				"value=" + this.value + ", " +
				"productIdScheme=" + this.productIdScheme +
			'}';
		}
	}
}
