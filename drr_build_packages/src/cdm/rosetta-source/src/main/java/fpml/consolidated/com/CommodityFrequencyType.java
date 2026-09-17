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
import fpml.consolidated.com.meta.CommodityFrequencyTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Frequency Type for use in Pricing Date specifications.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Frequency Type for use in Pricing Date specifications.
 *
 */
@RosettaDataType(value="CommodityFrequencyType", builder=CommodityFrequencyType.CommodityFrequencyTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityFrequencyType", model="fpml", builder=CommodityFrequencyType.CommodityFrequencyTypeBuilderImpl.class, version="2.1.1")
public interface CommodityFrequencyType extends RosettaModelObject {

	CommodityFrequencyTypeMeta metaData = new CommodityFrequencyTypeMeta();

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
	String getCommodityFrequencyTypeScheme();

	/*********************** Build Methods  ***********************/
	CommodityFrequencyType build();
	
	CommodityFrequencyType.CommodityFrequencyTypeBuilder toBuilder();
	
	static CommodityFrequencyType.CommodityFrequencyTypeBuilder builder() {
		return new CommodityFrequencyType.CommodityFrequencyTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFrequencyType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityFrequencyType> getType() {
		return CommodityFrequencyType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityFrequencyTypeScheme"), String.class, getCommodityFrequencyTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFrequencyTypeBuilder extends CommodityFrequencyType, RosettaModelObjectBuilder {
		CommodityFrequencyType.CommodityFrequencyTypeBuilder setValue(String value);
		CommodityFrequencyType.CommodityFrequencyTypeBuilder setCommodityFrequencyTypeScheme(String commodityFrequencyTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityFrequencyTypeScheme"), String.class, getCommodityFrequencyTypeScheme(), this);
		}
		

		CommodityFrequencyType.CommodityFrequencyTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFrequencyType  ***********************/
	class CommodityFrequencyTypeImpl implements CommodityFrequencyType {
		private final String value;
		private final String commodityFrequencyTypeScheme;
		
		protected CommodityFrequencyTypeImpl(CommodityFrequencyType.CommodityFrequencyTypeBuilder builder) {
			this.value = builder.getValue();
			this.commodityFrequencyTypeScheme = builder.getCommodityFrequencyTypeScheme();
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
		@RosettaAttribute("commodityFrequencyTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityFrequencyTypeScheme")
		public String getCommodityFrequencyTypeScheme() {
			return commodityFrequencyTypeScheme;
		}
		
		@Override
		public CommodityFrequencyType build() {
			return this;
		}
		
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder toBuilder() {
			CommodityFrequencyType.CommodityFrequencyTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFrequencyType.CommodityFrequencyTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityFrequencyTypeScheme()).ifPresent(builder::setCommodityFrequencyTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFrequencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityFrequencyTypeScheme, _that.getCommodityFrequencyTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityFrequencyTypeScheme != null ? commodityFrequencyTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFrequencyType {" +
				"value=" + this.value + ", " +
				"commodityFrequencyTypeScheme=" + this.commodityFrequencyTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFrequencyType  ***********************/
	class CommodityFrequencyTypeBuilderImpl implements CommodityFrequencyType.CommodityFrequencyTypeBuilder {
	
		protected String value;
		protected String commodityFrequencyTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityFrequencyTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityFrequencyTypeScheme")
		public String getCommodityFrequencyTypeScheme() {
			return commodityFrequencyTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityFrequencyTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityFrequencyTypeScheme")
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder setCommodityFrequencyTypeScheme(String _commodityFrequencyTypeScheme) {
			this.commodityFrequencyTypeScheme = _commodityFrequencyTypeScheme == null ? null : _commodityFrequencyTypeScheme;
			return this;
		}
		
		@Override
		public CommodityFrequencyType build() {
			return new CommodityFrequencyType.CommodityFrequencyTypeImpl(this);
		}
		
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityFrequencyTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFrequencyType.CommodityFrequencyTypeBuilder o = (CommodityFrequencyType.CommodityFrequencyTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityFrequencyTypeScheme(), o.getCommodityFrequencyTypeScheme(), this::setCommodityFrequencyTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFrequencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityFrequencyTypeScheme, _that.getCommodityFrequencyTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityFrequencyTypeScheme != null ? commodityFrequencyTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFrequencyTypeBuilder {" +
				"value=" + this.value + ", " +
				"commodityFrequencyTypeScheme=" + this.commodityFrequencyTypeScheme +
			'}';
		}
	}
}
