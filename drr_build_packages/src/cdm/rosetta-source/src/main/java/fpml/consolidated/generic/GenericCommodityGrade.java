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
import fpml.consolidated.generic.meta.GenericCommodityGradeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A flexible description of the type or characteristics of a commodity grade
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A flexible description of the type or characteristics of a commodity grade
 *
 */
@RosettaDataType(value="GenericCommodityGrade", builder=GenericCommodityGrade.GenericCommodityGradeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericCommodityGrade", model="fpml", builder=GenericCommodityGrade.GenericCommodityGradeBuilderImpl.class, version="2.1.1")
public interface GenericCommodityGrade extends RosettaModelObject {

	GenericCommodityGradeMeta metaData = new GenericCommodityGradeMeta();

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
	 * Provision The type scheme used with this commodity grade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type scheme used with this commodity grade.
	 *
	 */
	String getCommodityGradeScheme();

	/*********************** Build Methods  ***********************/
	GenericCommodityGrade build();
	
	GenericCommodityGrade.GenericCommodityGradeBuilder toBuilder();
	
	static GenericCommodityGrade.GenericCommodityGradeBuilder builder() {
		return new GenericCommodityGrade.GenericCommodityGradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericCommodityGrade> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericCommodityGrade> getType() {
		return GenericCommodityGrade.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityGradeScheme"), String.class, getCommodityGradeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericCommodityGradeBuilder extends GenericCommodityGrade, RosettaModelObjectBuilder {
		GenericCommodityGrade.GenericCommodityGradeBuilder setValue(String value);
		GenericCommodityGrade.GenericCommodityGradeBuilder setCommodityGradeScheme(String commodityGradeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityGradeScheme"), String.class, getCommodityGradeScheme(), this);
		}
		

		GenericCommodityGrade.GenericCommodityGradeBuilder prune();
	}

	/*********************** Immutable Implementation of GenericCommodityGrade  ***********************/
	class GenericCommodityGradeImpl implements GenericCommodityGrade {
		private final String value;
		private final String commodityGradeScheme;
		
		protected GenericCommodityGradeImpl(GenericCommodityGrade.GenericCommodityGradeBuilder builder) {
			this.value = builder.getValue();
			this.commodityGradeScheme = builder.getCommodityGradeScheme();
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
		@RosettaAttribute("commodityGradeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityGradeScheme")
		public String getCommodityGradeScheme() {
			return commodityGradeScheme;
		}
		
		@Override
		public GenericCommodityGrade build() {
			return this;
		}
		
		@Override
		public GenericCommodityGrade.GenericCommodityGradeBuilder toBuilder() {
			GenericCommodityGrade.GenericCommodityGradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericCommodityGrade.GenericCommodityGradeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityGradeScheme()).ifPresent(builder::setCommodityGradeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityGrade _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityGradeScheme, _that.getCommodityGradeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityGradeScheme != null ? commodityGradeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityGrade {" +
				"value=" + this.value + ", " +
				"commodityGradeScheme=" + this.commodityGradeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericCommodityGrade  ***********************/
	class GenericCommodityGradeBuilderImpl implements GenericCommodityGrade.GenericCommodityGradeBuilder {
	
		protected String value;
		protected String commodityGradeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityGradeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityGradeScheme")
		public String getCommodityGradeScheme() {
			return commodityGradeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public GenericCommodityGrade.GenericCommodityGradeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityGradeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityGradeScheme")
		@Override
		public GenericCommodityGrade.GenericCommodityGradeBuilder setCommodityGradeScheme(String _commodityGradeScheme) {
			this.commodityGradeScheme = _commodityGradeScheme == null ? null : _commodityGradeScheme;
			return this;
		}
		
		@Override
		public GenericCommodityGrade build() {
			return new GenericCommodityGrade.GenericCommodityGradeImpl(this);
		}
		
		@Override
		public GenericCommodityGrade.GenericCommodityGradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityGrade.GenericCommodityGradeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityGradeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityGrade.GenericCommodityGradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericCommodityGrade.GenericCommodityGradeBuilder o = (GenericCommodityGrade.GenericCommodityGradeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityGradeScheme(), o.getCommodityGradeScheme(), this::setCommodityGradeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityGrade _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityGradeScheme, _that.getCommodityGradeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityGradeScheme != null ? commodityGradeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityGradeBuilder {" +
				"value=" + this.value + ", " +
				"commodityGradeScheme=" + this.commodityGradeScheme +
			'}';
		}
	}
}
