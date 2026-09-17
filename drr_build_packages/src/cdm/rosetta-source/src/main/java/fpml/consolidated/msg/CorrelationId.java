package fpml.consolidated.msg;

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
import fpml.consolidated.msg.meta.CorrelationIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a correlation identifier and qualifying scheme
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a correlation identifier and qualifying scheme
 *
 */
@RosettaDataType(value="CorrelationId", builder=CorrelationId.CorrelationIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CorrelationId", model="fpml", builder=CorrelationId.CorrelationIdBuilderImpl.class, version="2.1.1")
public interface CorrelationId extends RosettaModelObject {

	CorrelationIdMeta metaData = new CorrelationIdMeta();

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
	String getCorrelationIdScheme();

	/*********************** Build Methods  ***********************/
	CorrelationId build();
	
	CorrelationId.CorrelationIdBuilder toBuilder();
	
	static CorrelationId.CorrelationIdBuilder builder() {
		return new CorrelationId.CorrelationIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorrelationId> getType() {
		return CorrelationId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("correlationIdScheme"), String.class, getCorrelationIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationIdBuilder extends CorrelationId, RosettaModelObjectBuilder {
		CorrelationId.CorrelationIdBuilder setValue(String value);
		CorrelationId.CorrelationIdBuilder setCorrelationIdScheme(String correlationIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("correlationIdScheme"), String.class, getCorrelationIdScheme(), this);
		}
		

		CorrelationId.CorrelationIdBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationId  ***********************/
	class CorrelationIdImpl implements CorrelationId {
		private final String value;
		private final String correlationIdScheme;
		
		protected CorrelationIdImpl(CorrelationId.CorrelationIdBuilder builder) {
			this.value = builder.getValue();
			this.correlationIdScheme = builder.getCorrelationIdScheme();
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
		@RosettaAttribute("correlationIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("correlationIdScheme")
		public String getCorrelationIdScheme() {
			return correlationIdScheme;
		}
		
		@Override
		public CorrelationId build() {
			return this;
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder toBuilder() {
			CorrelationId.CorrelationIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationId.CorrelationIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCorrelationIdScheme()).ifPresent(builder::setCorrelationIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(correlationIdScheme, _that.getCorrelationIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (correlationIdScheme != null ? correlationIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationId {" +
				"value=" + this.value + ", " +
				"correlationIdScheme=" + this.correlationIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CorrelationId  ***********************/
	class CorrelationIdBuilderImpl implements CorrelationId.CorrelationIdBuilder {
	
		protected String value;
		protected String correlationIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("correlationIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("correlationIdScheme")
		public String getCorrelationIdScheme() {
			return correlationIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CorrelationId.CorrelationIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("correlationIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("correlationIdScheme")
		@Override
		public CorrelationId.CorrelationIdBuilder setCorrelationIdScheme(String _correlationIdScheme) {
			this.correlationIdScheme = _correlationIdScheme == null ? null : _correlationIdScheme;
			return this;
		}
		
		@Override
		public CorrelationId build() {
			return new CorrelationId.CorrelationIdImpl(this);
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationId.CorrelationIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCorrelationIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationId.CorrelationIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorrelationId.CorrelationIdBuilder o = (CorrelationId.CorrelationIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCorrelationIdScheme(), o.getCorrelationIdScheme(), this::setCorrelationIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(correlationIdScheme, _that.getCorrelationIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (correlationIdScheme != null ? correlationIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationIdBuilder {" +
				"value=" + this.value + ", " +
				"correlationIdScheme=" + this.correlationIdScheme +
			'}';
		}
	}
}
