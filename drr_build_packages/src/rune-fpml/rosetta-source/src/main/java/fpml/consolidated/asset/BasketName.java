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
import fpml.consolidated.asset.meta.BasketNameMeta;
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
@RosettaDataType(value="BasketName", builder=BasketName.BasketNameBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BasketName", model="fpml", builder=BasketName.BasketNameBuilderImpl.class, version="2.1.1")
public interface BasketName extends RosettaModelObject {

	BasketNameMeta metaData = new BasketNameMeta();

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
	String getBasketNameScheme();

	/*********************** Build Methods  ***********************/
	BasketName build();
	
	BasketName.BasketNameBuilder toBuilder();
	
	static BasketName.BasketNameBuilder builder() {
		return new BasketName.BasketNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketName> getType() {
		return BasketName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("basketNameScheme"), String.class, getBasketNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketNameBuilder extends BasketName, RosettaModelObjectBuilder {
		BasketName.BasketNameBuilder setValue(String value);
		BasketName.BasketNameBuilder setBasketNameScheme(String basketNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("basketNameScheme"), String.class, getBasketNameScheme(), this);
		}
		

		BasketName.BasketNameBuilder prune();
	}

	/*********************** Immutable Implementation of BasketName  ***********************/
	class BasketNameImpl implements BasketName {
		private final String value;
		private final String basketNameScheme;
		
		protected BasketNameImpl(BasketName.BasketNameBuilder builder) {
			this.value = builder.getValue();
			this.basketNameScheme = builder.getBasketNameScheme();
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
		@RosettaAttribute("basketNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketNameScheme")
		public String getBasketNameScheme() {
			return basketNameScheme;
		}
		
		@Override
		public BasketName build() {
			return this;
		}
		
		@Override
		public BasketName.BasketNameBuilder toBuilder() {
			BasketName.BasketNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketName.BasketNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBasketNameScheme()).ifPresent(builder::setBasketNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(basketNameScheme, _that.getBasketNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (basketNameScheme != null ? basketNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketName {" +
				"value=" + this.value + ", " +
				"basketNameScheme=" + this.basketNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketName  ***********************/
	class BasketNameBuilderImpl implements BasketName.BasketNameBuilder {
	
		protected String value;
		protected String basketNameScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("basketNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketNameScheme")
		public String getBasketNameScheme() {
			return basketNameScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public BasketName.BasketNameBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("basketNameScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketNameScheme")
		@Override
		public BasketName.BasketNameBuilder setBasketNameScheme(String _basketNameScheme) {
			this.basketNameScheme = _basketNameScheme == null ? null : _basketNameScheme;
			return this;
		}
		
		@Override
		public BasketName build() {
			return new BasketName.BasketNameImpl(this);
		}
		
		@Override
		public BasketName.BasketNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketName.BasketNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBasketNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketName.BasketNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketName.BasketNameBuilder o = (BasketName.BasketNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBasketNameScheme(), o.getBasketNameScheme(), this::setBasketNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(basketNameScheme, _that.getBasketNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (basketNameScheme != null ? basketNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketNameBuilder {" +
				"value=" + this.value + ", " +
				"basketNameScheme=" + this.basketNameScheme +
			'}';
		}
	}
}
