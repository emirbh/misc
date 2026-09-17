package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.TerminatingEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that describes why a trade terminated.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes why a trade terminated.
 *
 */
@RosettaDataType(value="TerminatingEvent", builder=TerminatingEvent.TerminatingEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TerminatingEvent", model="fpml", builder=TerminatingEvent.TerminatingEventBuilderImpl.class, version="2.1.1")
public interface TerminatingEvent extends RosettaModelObject {

	TerminatingEventMeta metaData = new TerminatingEventMeta();

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
	String getTerminatingEventScheme();

	/*********************** Build Methods  ***********************/
	TerminatingEvent build();
	
	TerminatingEvent.TerminatingEventBuilder toBuilder();
	
	static TerminatingEvent.TerminatingEventBuilder builder() {
		return new TerminatingEvent.TerminatingEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TerminatingEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TerminatingEvent> getType() {
		return TerminatingEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("terminatingEventScheme"), String.class, getTerminatingEventScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TerminatingEventBuilder extends TerminatingEvent, RosettaModelObjectBuilder {
		TerminatingEvent.TerminatingEventBuilder setValue(String value);
		TerminatingEvent.TerminatingEventBuilder setTerminatingEventScheme(String terminatingEventScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("terminatingEventScheme"), String.class, getTerminatingEventScheme(), this);
		}
		

		TerminatingEvent.TerminatingEventBuilder prune();
	}

	/*********************** Immutable Implementation of TerminatingEvent  ***********************/
	class TerminatingEventImpl implements TerminatingEvent {
		private final String value;
		private final String terminatingEventScheme;
		
		protected TerminatingEventImpl(TerminatingEvent.TerminatingEventBuilder builder) {
			this.value = builder.getValue();
			this.terminatingEventScheme = builder.getTerminatingEventScheme();
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
		@RosettaAttribute("terminatingEventScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminatingEventScheme")
		public String getTerminatingEventScheme() {
			return terminatingEventScheme;
		}
		
		@Override
		public TerminatingEvent build() {
			return this;
		}
		
		@Override
		public TerminatingEvent.TerminatingEventBuilder toBuilder() {
			TerminatingEvent.TerminatingEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminatingEvent.TerminatingEventBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTerminatingEventScheme()).ifPresent(builder::setTerminatingEventScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminatingEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(terminatingEventScheme, _that.getTerminatingEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (terminatingEventScheme != null ? terminatingEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminatingEvent {" +
				"value=" + this.value + ", " +
				"terminatingEventScheme=" + this.terminatingEventScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TerminatingEvent  ***********************/
	class TerminatingEventBuilderImpl implements TerminatingEvent.TerminatingEventBuilder {
	
		protected String value;
		protected String terminatingEventScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("terminatingEventScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminatingEventScheme")
		public String getTerminatingEventScheme() {
			return terminatingEventScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public TerminatingEvent.TerminatingEventBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("terminatingEventScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminatingEventScheme")
		@Override
		public TerminatingEvent.TerminatingEventBuilder setTerminatingEventScheme(String _terminatingEventScheme) {
			this.terminatingEventScheme = _terminatingEventScheme == null ? null : _terminatingEventScheme;
			return this;
		}
		
		@Override
		public TerminatingEvent build() {
			return new TerminatingEvent.TerminatingEventImpl(this);
		}
		
		@Override
		public TerminatingEvent.TerminatingEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminatingEvent.TerminatingEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTerminatingEventScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminatingEvent.TerminatingEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminatingEvent.TerminatingEventBuilder o = (TerminatingEvent.TerminatingEventBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTerminatingEventScheme(), o.getTerminatingEventScheme(), this::setTerminatingEventScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminatingEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(terminatingEventScheme, _that.getTerminatingEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (terminatingEventScheme != null ? terminatingEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminatingEventBuilder {" +
				"value=" + this.value + ", " +
				"terminatingEventScheme=" + this.terminatingEventScheme +
			'}';
		}
	}
}
