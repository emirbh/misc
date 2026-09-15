package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ShortSaleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A short sale concluded by an investment firm on its own behalf or on behalf of a client, as described in Article 11.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A short sale concluded by an investment firm on its own behalf or on behalf of a client, as described in Article 11.
 *
 */
@RosettaDataType(value="ShortSale", builder=ShortSale.ShortSaleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ShortSale", model="fpml", builder=ShortSale.ShortSaleBuilderImpl.class, version="2.1.1")
public interface ShortSale extends RosettaModelObject {

	ShortSaleMeta metaData = new ShortSaleMeta();

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
	String getShortSaleScheme();

	/*********************** Build Methods  ***********************/
	ShortSale build();
	
	ShortSale.ShortSaleBuilder toBuilder();
	
	static ShortSale.ShortSaleBuilder builder() {
		return new ShortSale.ShortSaleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ShortSale> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ShortSale> getType() {
		return ShortSale.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("shortSaleScheme"), String.class, getShortSaleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ShortSaleBuilder extends ShortSale, RosettaModelObjectBuilder {
		ShortSale.ShortSaleBuilder setValue(String value);
		ShortSale.ShortSaleBuilder setShortSaleScheme(String shortSaleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("shortSaleScheme"), String.class, getShortSaleScheme(), this);
		}
		

		ShortSale.ShortSaleBuilder prune();
	}

	/*********************** Immutable Implementation of ShortSale  ***********************/
	class ShortSaleImpl implements ShortSale {
		private final String value;
		private final String shortSaleScheme;
		
		protected ShortSaleImpl(ShortSale.ShortSaleBuilder builder) {
			this.value = builder.getValue();
			this.shortSaleScheme = builder.getShortSaleScheme();
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
		@RosettaAttribute("shortSaleScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shortSaleScheme")
		public String getShortSaleScheme() {
			return shortSaleScheme;
		}
		
		@Override
		public ShortSale build() {
			return this;
		}
		
		@Override
		public ShortSale.ShortSaleBuilder toBuilder() {
			ShortSale.ShortSaleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ShortSale.ShortSaleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getShortSaleScheme()).ifPresent(builder::setShortSaleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ShortSale _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(shortSaleScheme, _that.getShortSaleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (shortSaleScheme != null ? shortSaleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ShortSale {" +
				"value=" + this.value + ", " +
				"shortSaleScheme=" + this.shortSaleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ShortSale  ***********************/
	class ShortSaleBuilderImpl implements ShortSale.ShortSaleBuilder {
	
		protected String value;
		protected String shortSaleScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("shortSaleScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shortSaleScheme")
		public String getShortSaleScheme() {
			return shortSaleScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ShortSale.ShortSaleBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("shortSaleScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shortSaleScheme")
		@Override
		public ShortSale.ShortSaleBuilder setShortSaleScheme(String _shortSaleScheme) {
			this.shortSaleScheme = _shortSaleScheme == null ? null : _shortSaleScheme;
			return this;
		}
		
		@Override
		public ShortSale build() {
			return new ShortSale.ShortSaleImpl(this);
		}
		
		@Override
		public ShortSale.ShortSaleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ShortSale.ShortSaleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getShortSaleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ShortSale.ShortSaleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ShortSale.ShortSaleBuilder o = (ShortSale.ShortSaleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getShortSaleScheme(), o.getShortSaleScheme(), this::setShortSaleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ShortSale _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(shortSaleScheme, _that.getShortSaleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (shortSaleScheme != null ? shortSaleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ShortSaleBuilder {" +
				"value=" + this.value + ", " +
				"shortSaleScheme=" + this.shortSaleScheme +
			'}';
		}
	}
}
