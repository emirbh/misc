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
import fpml.consolidated.com.meta.CommodityFxTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Identifes how the FX rate will be applied. This is intended to differentiate between the various methods for applying FX to the floating price such as a daily calculation, or averaging the FX and applying the average at the end of each CalculationPeriod.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifes how the FX rate will be applied. This is intended to differentiate between the various methods for applying FX to the floating price such as a daily calculation, or averaging the FX and applying the average at the end of each CalculationPeriod.
 *
 */
@RosettaDataType(value="CommodityFxType", builder=CommodityFxType.CommodityFxTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityFxType", model="fpml", builder=CommodityFxType.CommodityFxTypeBuilderImpl.class, version="2.1.1")
public interface CommodityFxType extends RosettaModelObject {

	CommodityFxTypeMeta metaData = new CommodityFxTypeMeta();

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
	String getCommodityFxTypeScheme();

	/*********************** Build Methods  ***********************/
	CommodityFxType build();
	
	CommodityFxType.CommodityFxTypeBuilder toBuilder();
	
	static CommodityFxType.CommodityFxTypeBuilder builder() {
		return new CommodityFxType.CommodityFxTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFxType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityFxType> getType() {
		return CommodityFxType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityFxTypeScheme"), String.class, getCommodityFxTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFxTypeBuilder extends CommodityFxType, RosettaModelObjectBuilder {
		CommodityFxType.CommodityFxTypeBuilder setValue(String value);
		CommodityFxType.CommodityFxTypeBuilder setCommodityFxTypeScheme(String commodityFxTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityFxTypeScheme"), String.class, getCommodityFxTypeScheme(), this);
		}
		

		CommodityFxType.CommodityFxTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFxType  ***********************/
	class CommodityFxTypeImpl implements CommodityFxType {
		private final String value;
		private final String commodityFxTypeScheme;
		
		protected CommodityFxTypeImpl(CommodityFxType.CommodityFxTypeBuilder builder) {
			this.value = builder.getValue();
			this.commodityFxTypeScheme = builder.getCommodityFxTypeScheme();
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
		@RosettaAttribute("commodityFxTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityFxTypeScheme")
		public String getCommodityFxTypeScheme() {
			return commodityFxTypeScheme;
		}
		
		@Override
		public CommodityFxType build() {
			return this;
		}
		
		@Override
		public CommodityFxType.CommodityFxTypeBuilder toBuilder() {
			CommodityFxType.CommodityFxTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFxType.CommodityFxTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityFxTypeScheme()).ifPresent(builder::setCommodityFxTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityFxTypeScheme, _that.getCommodityFxTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityFxTypeScheme != null ? commodityFxTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxType {" +
				"value=" + this.value + ", " +
				"commodityFxTypeScheme=" + this.commodityFxTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFxType  ***********************/
	class CommodityFxTypeBuilderImpl implements CommodityFxType.CommodityFxTypeBuilder {
	
		protected String value;
		protected String commodityFxTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityFxTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityFxTypeScheme")
		public String getCommodityFxTypeScheme() {
			return commodityFxTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityFxType.CommodityFxTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityFxTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityFxTypeScheme")
		@Override
		public CommodityFxType.CommodityFxTypeBuilder setCommodityFxTypeScheme(String _commodityFxTypeScheme) {
			this.commodityFxTypeScheme = _commodityFxTypeScheme == null ? null : _commodityFxTypeScheme;
			return this;
		}
		
		@Override
		public CommodityFxType build() {
			return new CommodityFxType.CommodityFxTypeImpl(this);
		}
		
		@Override
		public CommodityFxType.CommodityFxTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxType.CommodityFxTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityFxTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxType.CommodityFxTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFxType.CommodityFxTypeBuilder o = (CommodityFxType.CommodityFxTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityFxTypeScheme(), o.getCommodityFxTypeScheme(), this::setCommodityFxTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityFxTypeScheme, _that.getCommodityFxTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityFxTypeScheme != null ? commodityFxTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxTypeBuilder {" +
				"value=" + this.value + ", " +
				"commodityFxTypeScheme=" + this.commodityFxTypeScheme +
			'}';
		}
	}
}
