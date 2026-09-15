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
import fpml.consolidated.generic.meta.GenericExerciseStyleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used to hold the exercise style description of an option in a generic product (e.g. American, European, Bermudan).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used to hold the exercise style description of an option in a generic product (e.g. American, European, Bermudan).
 *
 */
@RosettaDataType(value="GenericExerciseStyle", builder=GenericExerciseStyle.GenericExerciseStyleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericExerciseStyle", model="fpml", builder=GenericExerciseStyle.GenericExerciseStyleBuilderImpl.class, version="2.1.1")
public interface GenericExerciseStyle extends RosettaModelObject {

	GenericExerciseStyleMeta metaData = new GenericExerciseStyleMeta();

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
	 * Provision The value scheme used with this property.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value scheme used with this property.
	 *
	 */
	String getExerciseStyleScheme();

	/*********************** Build Methods  ***********************/
	GenericExerciseStyle build();
	
	GenericExerciseStyle.GenericExerciseStyleBuilder toBuilder();
	
	static GenericExerciseStyle.GenericExerciseStyleBuilder builder() {
		return new GenericExerciseStyle.GenericExerciseStyleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericExerciseStyle> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericExerciseStyle> getType() {
		return GenericExerciseStyle.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("exerciseStyleScheme"), String.class, getExerciseStyleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericExerciseStyleBuilder extends GenericExerciseStyle, RosettaModelObjectBuilder {
		GenericExerciseStyle.GenericExerciseStyleBuilder setValue(String value);
		GenericExerciseStyle.GenericExerciseStyleBuilder setExerciseStyleScheme(String exerciseStyleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("exerciseStyleScheme"), String.class, getExerciseStyleScheme(), this);
		}
		

		GenericExerciseStyle.GenericExerciseStyleBuilder prune();
	}

	/*********************** Immutable Implementation of GenericExerciseStyle  ***********************/
	class GenericExerciseStyleImpl implements GenericExerciseStyle {
		private final String value;
		private final String exerciseStyleScheme;
		
		protected GenericExerciseStyleImpl(GenericExerciseStyle.GenericExerciseStyleBuilder builder) {
			this.value = builder.getValue();
			this.exerciseStyleScheme = builder.getExerciseStyleScheme();
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
		@RosettaAttribute("exerciseStyleScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseStyleScheme")
		public String getExerciseStyleScheme() {
			return exerciseStyleScheme;
		}
		
		@Override
		public GenericExerciseStyle build() {
			return this;
		}
		
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder toBuilder() {
			GenericExerciseStyle.GenericExerciseStyleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericExerciseStyle.GenericExerciseStyleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getExerciseStyleScheme()).ifPresent(builder::setExerciseStyleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericExerciseStyle _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(exerciseStyleScheme, _that.getExerciseStyleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (exerciseStyleScheme != null ? exerciseStyleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericExerciseStyle {" +
				"value=" + this.value + ", " +
				"exerciseStyleScheme=" + this.exerciseStyleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericExerciseStyle  ***********************/
	class GenericExerciseStyleBuilderImpl implements GenericExerciseStyle.GenericExerciseStyleBuilder {
	
		protected String value;
		protected String exerciseStyleScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("exerciseStyleScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseStyleScheme")
		public String getExerciseStyleScheme() {
			return exerciseStyleScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("exerciseStyleScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseStyleScheme")
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder setExerciseStyleScheme(String _exerciseStyleScheme) {
			this.exerciseStyleScheme = _exerciseStyleScheme == null ? null : _exerciseStyleScheme;
			return this;
		}
		
		@Override
		public GenericExerciseStyle build() {
			return new GenericExerciseStyle.GenericExerciseStyleImpl(this);
		}
		
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getExerciseStyleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericExerciseStyle.GenericExerciseStyleBuilder o = (GenericExerciseStyle.GenericExerciseStyleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getExerciseStyleScheme(), o.getExerciseStyleScheme(), this::setExerciseStyleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericExerciseStyle _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(exerciseStyleScheme, _that.getExerciseStyleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (exerciseStyleScheme != null ? exerciseStyleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericExerciseStyleBuilder {" +
				"value=" + this.value + ", " +
				"exerciseStyleScheme=" + this.exerciseStyleScheme +
			'}';
		}
	}
}
