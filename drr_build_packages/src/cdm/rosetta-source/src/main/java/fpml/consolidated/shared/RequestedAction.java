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
import fpml.consolidated.shared.meta.RequestedActionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="RequestedAction", builder=RequestedAction.RequestedActionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestedAction", model="fpml", builder=RequestedAction.RequestedActionBuilderImpl.class, version="2.1.1")
public interface RequestedAction extends RosettaModelObject {

	RequestedActionMeta metaData = new RequestedActionMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getRequestedActionScheme();

	/*********************** Build Methods  ***********************/
	RequestedAction build();
	
	RequestedAction.RequestedActionBuilder toBuilder();
	
	static RequestedAction.RequestedActionBuilder builder() {
		return new RequestedAction.RequestedActionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestedAction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestedAction> getType() {
		return RequestedAction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("requestedActionScheme"), String.class, getRequestedActionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestedActionBuilder extends RequestedAction, RosettaModelObjectBuilder {
		RequestedAction.RequestedActionBuilder setValue(String value);
		RequestedAction.RequestedActionBuilder setRequestedActionScheme(String requestedActionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("requestedActionScheme"), String.class, getRequestedActionScheme(), this);
		}
		

		RequestedAction.RequestedActionBuilder prune();
	}

	/*********************** Immutable Implementation of RequestedAction  ***********************/
	class RequestedActionImpl implements RequestedAction {
		private final String value;
		private final String requestedActionScheme;
		
		protected RequestedActionImpl(RequestedAction.RequestedActionBuilder builder) {
			this.value = builder.getValue();
			this.requestedActionScheme = builder.getRequestedActionScheme();
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
		@RosettaAttribute("requestedActionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedActionScheme")
		public String getRequestedActionScheme() {
			return requestedActionScheme;
		}
		
		@Override
		public RequestedAction build() {
			return this;
		}
		
		@Override
		public RequestedAction.RequestedActionBuilder toBuilder() {
			RequestedAction.RequestedActionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestedAction.RequestedActionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRequestedActionScheme()).ifPresent(builder::setRequestedActionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequestedAction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(requestedActionScheme, _that.getRequestedActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (requestedActionScheme != null ? requestedActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestedAction {" +
				"value=" + this.value + ", " +
				"requestedActionScheme=" + this.requestedActionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RequestedAction  ***********************/
	class RequestedActionBuilderImpl implements RequestedAction.RequestedActionBuilder {
	
		protected String value;
		protected String requestedActionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("requestedActionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedActionScheme")
		public String getRequestedActionScheme() {
			return requestedActionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public RequestedAction.RequestedActionBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("requestedActionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("requestedActionScheme")
		@Override
		public RequestedAction.RequestedActionBuilder setRequestedActionScheme(String _requestedActionScheme) {
			this.requestedActionScheme = _requestedActionScheme == null ? null : _requestedActionScheme;
			return this;
		}
		
		@Override
		public RequestedAction build() {
			return new RequestedAction.RequestedActionImpl(this);
		}
		
		@Override
		public RequestedAction.RequestedActionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestedAction.RequestedActionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRequestedActionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestedAction.RequestedActionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RequestedAction.RequestedActionBuilder o = (RequestedAction.RequestedActionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRequestedActionScheme(), o.getRequestedActionScheme(), this::setRequestedActionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequestedAction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(requestedActionScheme, _that.getRequestedActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (requestedActionScheme != null ? requestedActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestedActionBuilder {" +
				"value=" + this.value + ", " +
				"requestedActionScheme=" + this.requestedActionScheme +
			'}';
		}
	}
}
