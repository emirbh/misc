package fpml.consolidated.mktenv;

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
import fpml.consolidated.mktenv.meta.CompoundingFrequencyMeta;
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
@RosettaDataType(value="CompoundingFrequency", builder=CompoundingFrequency.CompoundingFrequencyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CompoundingFrequency", model="fpml", builder=CompoundingFrequency.CompoundingFrequencyBuilderImpl.class, version="2.1.1")
public interface CompoundingFrequency extends RosettaModelObject {

	CompoundingFrequencyMeta metaData = new CompoundingFrequencyMeta();

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
	String getCompoundingFrequencyScheme();

	/*********************** Build Methods  ***********************/
	CompoundingFrequency build();
	
	CompoundingFrequency.CompoundingFrequencyBuilder toBuilder();
	
	static CompoundingFrequency.CompoundingFrequencyBuilder builder() {
		return new CompoundingFrequency.CompoundingFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompoundingFrequency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CompoundingFrequency> getType() {
		return CompoundingFrequency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("compoundingFrequencyScheme"), String.class, getCompoundingFrequencyScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompoundingFrequencyBuilder extends CompoundingFrequency, RosettaModelObjectBuilder {
		CompoundingFrequency.CompoundingFrequencyBuilder setValue(String value);
		CompoundingFrequency.CompoundingFrequencyBuilder setCompoundingFrequencyScheme(String compoundingFrequencyScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("compoundingFrequencyScheme"), String.class, getCompoundingFrequencyScheme(), this);
		}
		

		CompoundingFrequency.CompoundingFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of CompoundingFrequency  ***********************/
	class CompoundingFrequencyImpl implements CompoundingFrequency {
		private final String value;
		private final String compoundingFrequencyScheme;
		
		protected CompoundingFrequencyImpl(CompoundingFrequency.CompoundingFrequencyBuilder builder) {
			this.value = builder.getValue();
			this.compoundingFrequencyScheme = builder.getCompoundingFrequencyScheme();
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
		@RosettaAttribute("compoundingFrequencyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundingFrequencyScheme")
		public String getCompoundingFrequencyScheme() {
			return compoundingFrequencyScheme;
		}
		
		@Override
		public CompoundingFrequency build() {
			return this;
		}
		
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder toBuilder() {
			CompoundingFrequency.CompoundingFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompoundingFrequency.CompoundingFrequencyBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCompoundingFrequencyScheme()).ifPresent(builder::setCompoundingFrequencyScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompoundingFrequency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(compoundingFrequencyScheme, _that.getCompoundingFrequencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (compoundingFrequencyScheme != null ? compoundingFrequencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompoundingFrequency {" +
				"value=" + this.value + ", " +
				"compoundingFrequencyScheme=" + this.compoundingFrequencyScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CompoundingFrequency  ***********************/
	class CompoundingFrequencyBuilderImpl implements CompoundingFrequency.CompoundingFrequencyBuilder {
	
		protected String value;
		protected String compoundingFrequencyScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("compoundingFrequencyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundingFrequencyScheme")
		public String getCompoundingFrequencyScheme() {
			return compoundingFrequencyScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("compoundingFrequencyScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compoundingFrequencyScheme")
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder setCompoundingFrequencyScheme(String _compoundingFrequencyScheme) {
			this.compoundingFrequencyScheme = _compoundingFrequencyScheme == null ? null : _compoundingFrequencyScheme;
			return this;
		}
		
		@Override
		public CompoundingFrequency build() {
			return new CompoundingFrequency.CompoundingFrequencyImpl(this);
		}
		
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCompoundingFrequencyScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompoundingFrequency.CompoundingFrequencyBuilder o = (CompoundingFrequency.CompoundingFrequencyBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCompoundingFrequencyScheme(), o.getCompoundingFrequencyScheme(), this::setCompoundingFrequencyScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompoundingFrequency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(compoundingFrequencyScheme, _that.getCompoundingFrequencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (compoundingFrequencyScheme != null ? compoundingFrequencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompoundingFrequencyBuilder {" +
				"value=" + this.value + ", " +
				"compoundingFrequencyScheme=" + this.compoundingFrequencyScheme +
			'}';
		}
	}
}
