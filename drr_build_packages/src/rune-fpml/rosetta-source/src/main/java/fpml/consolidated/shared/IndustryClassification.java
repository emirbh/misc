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
import fpml.consolidated.shared.meta.IndustryClassificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A party's industry sector classification.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A party's industry sector classification.
 *
 */
@RosettaDataType(value="IndustryClassification", builder=IndustryClassification.IndustryClassificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IndustryClassification", model="fpml", builder=IndustryClassification.IndustryClassificationBuilderImpl.class, version="2.1.1")
public interface IndustryClassification extends RosettaModelObject {

	IndustryClassificationMeta metaData = new IndustryClassificationMeta();

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
	String getIndustryClassificationScheme();

	/*********************** Build Methods  ***********************/
	IndustryClassification build();
	
	IndustryClassification.IndustryClassificationBuilder toBuilder();
	
	static IndustryClassification.IndustryClassificationBuilder builder() {
		return new IndustryClassification.IndustryClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndustryClassification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndustryClassification> getType() {
		return IndustryClassification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("industryClassificationScheme"), String.class, getIndustryClassificationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndustryClassificationBuilder extends IndustryClassification, RosettaModelObjectBuilder {
		IndustryClassification.IndustryClassificationBuilder setValue(String value);
		IndustryClassification.IndustryClassificationBuilder setIndustryClassificationScheme(String industryClassificationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("industryClassificationScheme"), String.class, getIndustryClassificationScheme(), this);
		}
		

		IndustryClassification.IndustryClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of IndustryClassification  ***********************/
	class IndustryClassificationImpl implements IndustryClassification {
		private final String value;
		private final String industryClassificationScheme;
		
		protected IndustryClassificationImpl(IndustryClassification.IndustryClassificationBuilder builder) {
			this.value = builder.getValue();
			this.industryClassificationScheme = builder.getIndustryClassificationScheme();
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
		@RosettaAttribute("industryClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("industryClassificationScheme")
		public String getIndustryClassificationScheme() {
			return industryClassificationScheme;
		}
		
		@Override
		public IndustryClassification build() {
			return this;
		}
		
		@Override
		public IndustryClassification.IndustryClassificationBuilder toBuilder() {
			IndustryClassification.IndustryClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndustryClassification.IndustryClassificationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getIndustryClassificationScheme()).ifPresent(builder::setIndustryClassificationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndustryClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(industryClassificationScheme, _that.getIndustryClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (industryClassificationScheme != null ? industryClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndustryClassification {" +
				"value=" + this.value + ", " +
				"industryClassificationScheme=" + this.industryClassificationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of IndustryClassification  ***********************/
	class IndustryClassificationBuilderImpl implements IndustryClassification.IndustryClassificationBuilder {
	
		protected String value;
		protected String industryClassificationScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("industryClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("industryClassificationScheme")
		public String getIndustryClassificationScheme() {
			return industryClassificationScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public IndustryClassification.IndustryClassificationBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("industryClassificationScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("industryClassificationScheme")
		@Override
		public IndustryClassification.IndustryClassificationBuilder setIndustryClassificationScheme(String _industryClassificationScheme) {
			this.industryClassificationScheme = _industryClassificationScheme == null ? null : _industryClassificationScheme;
			return this;
		}
		
		@Override
		public IndustryClassification build() {
			return new IndustryClassification.IndustryClassificationImpl(this);
		}
		
		@Override
		public IndustryClassification.IndustryClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndustryClassification.IndustryClassificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getIndustryClassificationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndustryClassification.IndustryClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndustryClassification.IndustryClassificationBuilder o = (IndustryClassification.IndustryClassificationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getIndustryClassificationScheme(), o.getIndustryClassificationScheme(), this::setIndustryClassificationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndustryClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(industryClassificationScheme, _that.getIndustryClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (industryClassificationScheme != null ? industryClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndustryClassificationBuilder {" +
				"value=" + this.value + ", " +
				"industryClassificationScheme=" + this.industryClassificationScheme +
			'}';
		}
	}
}
