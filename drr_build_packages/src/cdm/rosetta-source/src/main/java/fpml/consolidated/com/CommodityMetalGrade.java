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
import fpml.consolidated.com.meta.CommodityMetalGradeMeta;
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
@RosettaDataType(value="CommodityMetalGrade", builder=CommodityMetalGrade.CommodityMetalGradeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityMetalGrade", model="fpml", builder=CommodityMetalGrade.CommodityMetalGradeBuilderImpl.class, version="2.1.1")
public interface CommodityMetalGrade extends RosettaModelObject {

	CommodityMetalGradeMeta metaData = new CommodityMetalGradeMeta();

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
	String getCommodityMetalGradeScheme();

	/*********************** Build Methods  ***********************/
	CommodityMetalGrade build();
	
	CommodityMetalGrade.CommodityMetalGradeBuilder toBuilder();
	
	static CommodityMetalGrade.CommodityMetalGradeBuilder builder() {
		return new CommodityMetalGrade.CommodityMetalGradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMetalGrade> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityMetalGrade> getType() {
		return CommodityMetalGrade.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityMetalGradeScheme"), String.class, getCommodityMetalGradeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMetalGradeBuilder extends CommodityMetalGrade, RosettaModelObjectBuilder {
		CommodityMetalGrade.CommodityMetalGradeBuilder setValue(String value);
		CommodityMetalGrade.CommodityMetalGradeBuilder setCommodityMetalGradeScheme(String commodityMetalGradeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityMetalGradeScheme"), String.class, getCommodityMetalGradeScheme(), this);
		}
		

		CommodityMetalGrade.CommodityMetalGradeBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMetalGrade  ***********************/
	class CommodityMetalGradeImpl implements CommodityMetalGrade {
		private final String value;
		private final String commodityMetalGradeScheme;
		
		protected CommodityMetalGradeImpl(CommodityMetalGrade.CommodityMetalGradeBuilder builder) {
			this.value = builder.getValue();
			this.commodityMetalGradeScheme = builder.getCommodityMetalGradeScheme();
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
		@RosettaAttribute("commodityMetalGradeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMetalGradeScheme")
		public String getCommodityMetalGradeScheme() {
			return commodityMetalGradeScheme;
		}
		
		@Override
		public CommodityMetalGrade build() {
			return this;
		}
		
		@Override
		public CommodityMetalGrade.CommodityMetalGradeBuilder toBuilder() {
			CommodityMetalGrade.CommodityMetalGradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMetalGrade.CommodityMetalGradeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityMetalGradeScheme()).ifPresent(builder::setCommodityMetalGradeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalGrade _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalGradeScheme, _that.getCommodityMetalGradeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalGradeScheme != null ? commodityMetalGradeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalGrade {" +
				"value=" + this.value + ", " +
				"commodityMetalGradeScheme=" + this.commodityMetalGradeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMetalGrade  ***********************/
	class CommodityMetalGradeBuilderImpl implements CommodityMetalGrade.CommodityMetalGradeBuilder {
	
		protected String value;
		protected String commodityMetalGradeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMetalGradeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMetalGradeScheme")
		public String getCommodityMetalGradeScheme() {
			return commodityMetalGradeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityMetalGrade.CommodityMetalGradeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityMetalGradeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityMetalGradeScheme")
		@Override
		public CommodityMetalGrade.CommodityMetalGradeBuilder setCommodityMetalGradeScheme(String _commodityMetalGradeScheme) {
			this.commodityMetalGradeScheme = _commodityMetalGradeScheme == null ? null : _commodityMetalGradeScheme;
			return this;
		}
		
		@Override
		public CommodityMetalGrade build() {
			return new CommodityMetalGrade.CommodityMetalGradeImpl(this);
		}
		
		@Override
		public CommodityMetalGrade.CommodityMetalGradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalGrade.CommodityMetalGradeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityMetalGradeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalGrade.CommodityMetalGradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMetalGrade.CommodityMetalGradeBuilder o = (CommodityMetalGrade.CommodityMetalGradeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityMetalGradeScheme(), o.getCommodityMetalGradeScheme(), this::setCommodityMetalGradeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalGrade _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMetalGradeScheme, _that.getCommodityMetalGradeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMetalGradeScheme != null ? commodityMetalGradeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalGradeBuilder {" +
				"value=" + this.value + ", " +
				"commodityMetalGradeScheme=" + this.commodityMetalGradeScheme +
			'}';
		}
	}
}
