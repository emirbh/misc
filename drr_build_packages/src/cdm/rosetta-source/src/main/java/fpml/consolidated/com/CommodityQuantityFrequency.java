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
import fpml.consolidated.com.meta.CommodityQuantityFrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining the frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining the frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
 *
 */
@RosettaDataType(value="CommodityQuantityFrequency", builder=CommodityQuantityFrequency.CommodityQuantityFrequencyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityQuantityFrequency", model="fpml", builder=CommodityQuantityFrequency.CommodityQuantityFrequencyBuilderImpl.class, version="2.1.1")
public interface CommodityQuantityFrequency extends RosettaModelObject {

	CommodityQuantityFrequencyMeta metaData = new CommodityQuantityFrequencyMeta();

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
	String getQuantityFrequencyScheme();

	/*********************** Build Methods  ***********************/
	CommodityQuantityFrequency build();
	
	CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder toBuilder();
	
	static CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder builder() {
		return new CommodityQuantityFrequency.CommodityQuantityFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityQuantityFrequency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityQuantityFrequency> getType() {
		return CommodityQuantityFrequency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("quantityFrequencyScheme"), String.class, getQuantityFrequencyScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityQuantityFrequencyBuilder extends CommodityQuantityFrequency, RosettaModelObjectBuilder {
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder setValue(String value);
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder setQuantityFrequencyScheme(String quantityFrequencyScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("quantityFrequencyScheme"), String.class, getQuantityFrequencyScheme(), this);
		}
		

		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityQuantityFrequency  ***********************/
	class CommodityQuantityFrequencyImpl implements CommodityQuantityFrequency {
		private final String value;
		private final String quantityFrequencyScheme;
		
		protected CommodityQuantityFrequencyImpl(CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder builder) {
			this.value = builder.getValue();
			this.quantityFrequencyScheme = builder.getQuantityFrequencyScheme();
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
		@RosettaAttribute("quantityFrequencyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequencyScheme")
		public String getQuantityFrequencyScheme() {
			return quantityFrequencyScheme;
		}
		
		@Override
		public CommodityQuantityFrequency build() {
			return this;
		}
		
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder toBuilder() {
			CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getQuantityFrequencyScheme()).ifPresent(builder::setQuantityFrequencyScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityQuantityFrequency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quantityFrequencyScheme, _that.getQuantityFrequencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quantityFrequencyScheme != null ? quantityFrequencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityQuantityFrequency {" +
				"value=" + this.value + ", " +
				"quantityFrequencyScheme=" + this.quantityFrequencyScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityQuantityFrequency  ***********************/
	class CommodityQuantityFrequencyBuilderImpl implements CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder {
	
		protected String value;
		protected String quantityFrequencyScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quantityFrequencyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequencyScheme")
		public String getQuantityFrequencyScheme() {
			return quantityFrequencyScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("quantityFrequencyScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequencyScheme")
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder setQuantityFrequencyScheme(String _quantityFrequencyScheme) {
			this.quantityFrequencyScheme = _quantityFrequencyScheme == null ? null : _quantityFrequencyScheme;
			return this;
		}
		
		@Override
		public CommodityQuantityFrequency build() {
			return new CommodityQuantityFrequency.CommodityQuantityFrequencyImpl(this);
		}
		
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getQuantityFrequencyScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder o = (CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getQuantityFrequencyScheme(), o.getQuantityFrequencyScheme(), this::setQuantityFrequencyScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityQuantityFrequency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quantityFrequencyScheme, _that.getQuantityFrequencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quantityFrequencyScheme != null ? quantityFrequencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityQuantityFrequencyBuilder {" +
				"value=" + this.value + ", " +
				"quantityFrequencyScheme=" + this.quantityFrequencyScheme +
			'}';
		}
	}
}
