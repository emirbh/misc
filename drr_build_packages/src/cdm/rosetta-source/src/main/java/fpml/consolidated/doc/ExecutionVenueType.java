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
import fpml.consolidated.doc.meta.ExecutionVenueTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type used to represent the type of market where a trade can be executed.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type used to represent the type of market where a trade can be executed.
 *
 */
@RosettaDataType(value="ExecutionVenueType", builder=ExecutionVenueType.ExecutionVenueTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExecutionVenueType", model="fpml", builder=ExecutionVenueType.ExecutionVenueTypeBuilderImpl.class, version="2.1.1")
public interface ExecutionVenueType extends RosettaModelObject {

	ExecutionVenueTypeMeta metaData = new ExecutionVenueTypeMeta();

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
	String getExecutionVenueTypeScheme();

	/*********************** Build Methods  ***********************/
	ExecutionVenueType build();
	
	ExecutionVenueType.ExecutionVenueTypeBuilder toBuilder();
	
	static ExecutionVenueType.ExecutionVenueTypeBuilder builder() {
		return new ExecutionVenueType.ExecutionVenueTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionVenueType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExecutionVenueType> getType() {
		return ExecutionVenueType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("executionVenueTypeScheme"), String.class, getExecutionVenueTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionVenueTypeBuilder extends ExecutionVenueType, RosettaModelObjectBuilder {
		ExecutionVenueType.ExecutionVenueTypeBuilder setValue(String value);
		ExecutionVenueType.ExecutionVenueTypeBuilder setExecutionVenueTypeScheme(String executionVenueTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("executionVenueTypeScheme"), String.class, getExecutionVenueTypeScheme(), this);
		}
		

		ExecutionVenueType.ExecutionVenueTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionVenueType  ***********************/
	class ExecutionVenueTypeImpl implements ExecutionVenueType {
		private final String value;
		private final String executionVenueTypeScheme;
		
		protected ExecutionVenueTypeImpl(ExecutionVenueType.ExecutionVenueTypeBuilder builder) {
			this.value = builder.getValue();
			this.executionVenueTypeScheme = builder.getExecutionVenueTypeScheme();
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
		@RosettaAttribute("executionVenueTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueTypeScheme")
		public String getExecutionVenueTypeScheme() {
			return executionVenueTypeScheme;
		}
		
		@Override
		public ExecutionVenueType build() {
			return this;
		}
		
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder toBuilder() {
			ExecutionVenueType.ExecutionVenueTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionVenueType.ExecutionVenueTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getExecutionVenueTypeScheme()).ifPresent(builder::setExecutionVenueTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionVenueType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(executionVenueTypeScheme, _that.getExecutionVenueTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (executionVenueTypeScheme != null ? executionVenueTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionVenueType {" +
				"value=" + this.value + ", " +
				"executionVenueTypeScheme=" + this.executionVenueTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ExecutionVenueType  ***********************/
	class ExecutionVenueTypeBuilderImpl implements ExecutionVenueType.ExecutionVenueTypeBuilder {
	
		protected String value;
		protected String executionVenueTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("executionVenueTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueTypeScheme")
		public String getExecutionVenueTypeScheme() {
			return executionVenueTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("executionVenueTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueTypeScheme")
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder setExecutionVenueTypeScheme(String _executionVenueTypeScheme) {
			this.executionVenueTypeScheme = _executionVenueTypeScheme == null ? null : _executionVenueTypeScheme;
			return this;
		}
		
		@Override
		public ExecutionVenueType build() {
			return new ExecutionVenueType.ExecutionVenueTypeImpl(this);
		}
		
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getExecutionVenueTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionVenueType.ExecutionVenueTypeBuilder o = (ExecutionVenueType.ExecutionVenueTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getExecutionVenueTypeScheme(), o.getExecutionVenueTypeScheme(), this::setExecutionVenueTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionVenueType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(executionVenueTypeScheme, _that.getExecutionVenueTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (executionVenueTypeScheme != null ? executionVenueTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionVenueTypeBuilder {" +
				"value=" + this.value + ", " +
				"executionVenueTypeScheme=" + this.executionVenueTypeScheme +
			'}';
		}
	}
}
