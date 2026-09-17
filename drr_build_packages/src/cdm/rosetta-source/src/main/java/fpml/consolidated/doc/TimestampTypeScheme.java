package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.TimestampTypeSchemeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The type or meaning of a timestamp.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The type or meaning of a timestamp.
 *
 */
@RosettaDataType(value="TimestampTypeScheme", builder=TimestampTypeScheme.TimestampTypeSchemeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TimestampTypeScheme", model="fpml", builder=TimestampTypeScheme.TimestampTypeSchemeBuilderImpl.class, version="2.1.1")
public interface TimestampTypeScheme extends RosettaModelObject {

	TimestampTypeSchemeMeta metaData = new TimestampTypeSchemeMeta();

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
	String getTimestampScheme();

	/*********************** Build Methods  ***********************/
	TimestampTypeScheme build();
	
	TimestampTypeScheme.TimestampTypeSchemeBuilder toBuilder();
	
	static TimestampTypeScheme.TimestampTypeSchemeBuilder builder() {
		return new TimestampTypeScheme.TimestampTypeSchemeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TimestampTypeScheme> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TimestampTypeScheme> getType() {
		return TimestampTypeScheme.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("timestampScheme"), String.class, getTimestampScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TimestampTypeSchemeBuilder extends TimestampTypeScheme, RosettaModelObjectBuilder {
		TimestampTypeScheme.TimestampTypeSchemeBuilder setValue(String value);
		TimestampTypeScheme.TimestampTypeSchemeBuilder setTimestampScheme(String timestampScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("timestampScheme"), String.class, getTimestampScheme(), this);
		}
		

		TimestampTypeScheme.TimestampTypeSchemeBuilder prune();
	}

	/*********************** Immutable Implementation of TimestampTypeScheme  ***********************/
	class TimestampTypeSchemeImpl implements TimestampTypeScheme {
		private final String value;
		private final String timestampScheme;
		
		protected TimestampTypeSchemeImpl(TimestampTypeScheme.TimestampTypeSchemeBuilder builder) {
			this.value = builder.getValue();
			this.timestampScheme = builder.getTimestampScheme();
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
		@RosettaAttribute("timestampScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timestampScheme")
		public String getTimestampScheme() {
			return timestampScheme;
		}
		
		@Override
		public TimestampTypeScheme build() {
			return this;
		}
		
		@Override
		public TimestampTypeScheme.TimestampTypeSchemeBuilder toBuilder() {
			TimestampTypeScheme.TimestampTypeSchemeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TimestampTypeScheme.TimestampTypeSchemeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTimestampScheme()).ifPresent(builder::setTimestampScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimestampTypeScheme _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(timestampScheme, _that.getTimestampScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (timestampScheme != null ? timestampScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimestampTypeScheme {" +
				"value=" + this.value + ", " +
				"timestampScheme=" + this.timestampScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TimestampTypeScheme  ***********************/
	class TimestampTypeSchemeBuilderImpl implements TimestampTypeScheme.TimestampTypeSchemeBuilder {
	
		protected String value;
		protected String timestampScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("timestampScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timestampScheme")
		public String getTimestampScheme() {
			return timestampScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public TimestampTypeScheme.TimestampTypeSchemeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("timestampScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("timestampScheme")
		@Override
		public TimestampTypeScheme.TimestampTypeSchemeBuilder setTimestampScheme(String _timestampScheme) {
			this.timestampScheme = _timestampScheme == null ? null : _timestampScheme;
			return this;
		}
		
		@Override
		public TimestampTypeScheme build() {
			return new TimestampTypeScheme.TimestampTypeSchemeImpl(this);
		}
		
		@Override
		public TimestampTypeScheme.TimestampTypeSchemeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimestampTypeScheme.TimestampTypeSchemeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTimestampScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimestampTypeScheme.TimestampTypeSchemeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TimestampTypeScheme.TimestampTypeSchemeBuilder o = (TimestampTypeScheme.TimestampTypeSchemeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTimestampScheme(), o.getTimestampScheme(), this::setTimestampScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimestampTypeScheme _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(timestampScheme, _that.getTimestampScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (timestampScheme != null ? timestampScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimestampTypeSchemeBuilder {" +
				"value=" + this.value + ", " +
				"timestampScheme=" + this.timestampScheme +
			'}';
		}
	}
}
