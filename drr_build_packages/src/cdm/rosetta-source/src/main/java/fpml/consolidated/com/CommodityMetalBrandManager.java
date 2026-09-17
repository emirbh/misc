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
import fpml.consolidated.com.meta.CommodityMetalBrandManagerMeta;
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
@RosettaDataType(value="CommodityMetalBrandManager", builder=CommodityMetalBrandManager.CommodityMetalBrandManagerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityMetalBrandManager", model="fpml", builder=CommodityMetalBrandManager.CommodityMetalBrandManagerBuilderImpl.class, version="2.1.1")
public interface CommodityMetalBrandManager extends RosettaModelObject {

	CommodityMetalBrandManagerMeta metaData = new CommodityMetalBrandManagerMeta();

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
	String getCommodityMetalBrandManagerScheme();

	/*********************** Build Methods  ***********************/
	CommodityMetalBrandManager build();
	
	CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder toBuilder();
	
	static CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder builder() {
		return new CommodityMetalBrandManager.CommodityMetalBrandManagerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMetalBrandManager> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityMetalBrandManager> getType() {
		return CommodityMetalBrandManager.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityMetalBrandManagerScheme"), String.class, getCommodityMetalBrandManagerScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMetalBrandManagerBuilder extends CommodityMetalBrandManager, RosettaModelObjectBuilder {
		CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder setValue(String value);
		CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder setCommodityMetalBrandManagerScheme(String commodityMetalBrandManagerScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityMetalBrandManagerScheme"), String.class, getCommodityMetalBrandManagerScheme(), this);
		}
		

		CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMetalBrandManager  ***********************/
	class CommodityMetalBrandManagerImpl implements CommodityMetalBrandManager {
		private final String value;
		private final String commodityMetalBrandManagerScheme;
		
		protected CommodityMetalBrandManagerImpl(CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder builder) {
			this.value = builder.getValue();
			this.commodityMetalBrandManagerScheme = builder.getCommodityMetalBrandManagerScheme();
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
		@RosettaAttribute("commodityMetalBrandManagerScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMetalBrandManagerScheme")
		public String getCommodityMetalBrandManagerScheme() {
			return commodityMetalBrandManagerScheme;
		}
		
		@Override
		public CommodityMetalBrandManager build() {
			return this;
		}
		
		@Override
		public CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder toBuilder() {
			CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityMetalBrandManagerScheme()).ifPresent(builder::setCommodityMetalBrandManagerScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalBrandManager _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalBrandManagerScheme, _that.getCommodityMetalBrandManagerScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalBrandManagerScheme != null ? commodityMetalBrandManagerScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalBrandManager {" +
				"value=" + this.value + ", " +
				"commodityMetalBrandManagerScheme=" + this.commodityMetalBrandManagerScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMetalBrandManager  ***********************/
	class CommodityMetalBrandManagerBuilderImpl implements CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder {
	
		protected String value;
		protected String commodityMetalBrandManagerScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMetalBrandManagerScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMetalBrandManagerScheme")
		public String getCommodityMetalBrandManagerScheme() {
			return commodityMetalBrandManagerScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityMetalBrandManagerScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityMetalBrandManagerScheme")
		@Override
		public CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder setCommodityMetalBrandManagerScheme(String _commodityMetalBrandManagerScheme) {
			this.commodityMetalBrandManagerScheme = _commodityMetalBrandManagerScheme == null ? null : _commodityMetalBrandManagerScheme;
			return this;
		}
		
		@Override
		public CommodityMetalBrandManager build() {
			return new CommodityMetalBrandManager.CommodityMetalBrandManagerImpl(this);
		}
		
		@Override
		public CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityMetalBrandManagerScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder o = (CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityMetalBrandManagerScheme(), o.getCommodityMetalBrandManagerScheme(), this::setCommodityMetalBrandManagerScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalBrandManager _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalBrandManagerScheme, _that.getCommodityMetalBrandManagerScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalBrandManagerScheme != null ? commodityMetalBrandManagerScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalBrandManagerBuilder {" +
				"value=" + this.value + ", " +
				"commodityMetalBrandManagerScheme=" + this.commodityMetalBrandManagerScheme +
			'}';
		}
	}
}
