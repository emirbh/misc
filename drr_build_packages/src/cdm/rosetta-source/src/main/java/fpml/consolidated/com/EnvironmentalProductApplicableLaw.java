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
import fpml.consolidated.com.meta.EnvironmentalProductApplicableLawMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision TBD.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision TBD.
 *
 */
@RosettaDataType(value="EnvironmentalProductApplicableLaw", builder=EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EnvironmentalProductApplicableLaw", model="fpml", builder=EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilderImpl.class, version="2.1.1")
public interface EnvironmentalProductApplicableLaw extends RosettaModelObject {

	EnvironmentalProductApplicableLawMeta metaData = new EnvironmentalProductApplicableLawMeta();

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
	String getEnvironmentalProductApplicableLawScheme();

	/*********************** Build Methods  ***********************/
	EnvironmentalProductApplicableLaw build();
	
	EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder toBuilder();
	
	static EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder builder() {
		return new EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalProductApplicableLaw> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnvironmentalProductApplicableLaw> getType() {
		return EnvironmentalProductApplicableLaw.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("environmentalProductApplicableLawScheme"), String.class, getEnvironmentalProductApplicableLawScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalProductApplicableLawBuilder extends EnvironmentalProductApplicableLaw, RosettaModelObjectBuilder {
		EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder setValue(String value);
		EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder setEnvironmentalProductApplicableLawScheme(String environmentalProductApplicableLawScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("environmentalProductApplicableLawScheme"), String.class, getEnvironmentalProductApplicableLawScheme(), this);
		}
		

		EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalProductApplicableLaw  ***********************/
	class EnvironmentalProductApplicableLawImpl implements EnvironmentalProductApplicableLaw {
		private final String value;
		private final String environmentalProductApplicableLawScheme;
		
		protected EnvironmentalProductApplicableLawImpl(EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder builder) {
			this.value = builder.getValue();
			this.environmentalProductApplicableLawScheme = builder.getEnvironmentalProductApplicableLawScheme();
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
		@RosettaAttribute("environmentalProductApplicableLawScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("environmentalProductApplicableLawScheme")
		public String getEnvironmentalProductApplicableLawScheme() {
			return environmentalProductApplicableLawScheme;
		}
		
		@Override
		public EnvironmentalProductApplicableLaw build() {
			return this;
		}
		
		@Override
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder toBuilder() {
			EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEnvironmentalProductApplicableLawScheme()).ifPresent(builder::setEnvironmentalProductApplicableLawScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProductApplicableLaw _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(environmentalProductApplicableLawScheme, _that.getEnvironmentalProductApplicableLawScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (environmentalProductApplicableLawScheme != null ? environmentalProductApplicableLawScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProductApplicableLaw {" +
				"value=" + this.value + ", " +
				"environmentalProductApplicableLawScheme=" + this.environmentalProductApplicableLawScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentalProductApplicableLaw  ***********************/
	class EnvironmentalProductApplicableLawBuilderImpl implements EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder {
	
		protected String value;
		protected String environmentalProductApplicableLawScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("environmentalProductApplicableLawScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("environmentalProductApplicableLawScheme")
		public String getEnvironmentalProductApplicableLawScheme() {
			return environmentalProductApplicableLawScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("environmentalProductApplicableLawScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("environmentalProductApplicableLawScheme")
		@Override
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder setEnvironmentalProductApplicableLawScheme(String _environmentalProductApplicableLawScheme) {
			this.environmentalProductApplicableLawScheme = _environmentalProductApplicableLawScheme == null ? null : _environmentalProductApplicableLawScheme;
			return this;
		}
		
		@Override
		public EnvironmentalProductApplicableLaw build() {
			return new EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawImpl(this);
		}
		
		@Override
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEnvironmentalProductApplicableLawScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder o = (EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEnvironmentalProductApplicableLawScheme(), o.getEnvironmentalProductApplicableLawScheme(), this::setEnvironmentalProductApplicableLawScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProductApplicableLaw _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(environmentalProductApplicableLawScheme, _that.getEnvironmentalProductApplicableLawScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (environmentalProductApplicableLawScheme != null ? environmentalProductApplicableLawScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProductApplicableLawBuilder {" +
				"value=" + this.value + ", " +
				"environmentalProductApplicableLawScheme=" + this.environmentalProductApplicableLawScheme +
			'}';
		}
	}
}
