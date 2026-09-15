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
import fpml.consolidated.business.events.meta.RequestedWithdrawalActionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that describes what the requester would like to see done to implement the withdrawal, e.g. ExpungeRecords, RetainRecords.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes what the requester would like to see done to implement the withdrawal, e.g. ExpungeRecords, RetainRecords.
 *
 */
@RosettaDataType(value="RequestedWithdrawalAction", builder=RequestedWithdrawalAction.RequestedWithdrawalActionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestedWithdrawalAction", model="fpml", builder=RequestedWithdrawalAction.RequestedWithdrawalActionBuilderImpl.class, version="2.1.1")
public interface RequestedWithdrawalAction extends RosettaModelObject {

	RequestedWithdrawalActionMeta metaData = new RequestedWithdrawalActionMeta();

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
	String getRequestedWithdrawalActionScheme();

	/*********************** Build Methods  ***********************/
	RequestedWithdrawalAction build();
	
	RequestedWithdrawalAction.RequestedWithdrawalActionBuilder toBuilder();
	
	static RequestedWithdrawalAction.RequestedWithdrawalActionBuilder builder() {
		return new RequestedWithdrawalAction.RequestedWithdrawalActionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestedWithdrawalAction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestedWithdrawalAction> getType() {
		return RequestedWithdrawalAction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("requestedWithdrawalActionScheme"), String.class, getRequestedWithdrawalActionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestedWithdrawalActionBuilder extends RequestedWithdrawalAction, RosettaModelObjectBuilder {
		RequestedWithdrawalAction.RequestedWithdrawalActionBuilder setValue(String value);
		RequestedWithdrawalAction.RequestedWithdrawalActionBuilder setRequestedWithdrawalActionScheme(String requestedWithdrawalActionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("requestedWithdrawalActionScheme"), String.class, getRequestedWithdrawalActionScheme(), this);
		}
		

		RequestedWithdrawalAction.RequestedWithdrawalActionBuilder prune();
	}

	/*********************** Immutable Implementation of RequestedWithdrawalAction  ***********************/
	class RequestedWithdrawalActionImpl implements RequestedWithdrawalAction {
		private final String value;
		private final String requestedWithdrawalActionScheme;
		
		protected RequestedWithdrawalActionImpl(RequestedWithdrawalAction.RequestedWithdrawalActionBuilder builder) {
			this.value = builder.getValue();
			this.requestedWithdrawalActionScheme = builder.getRequestedWithdrawalActionScheme();
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
		@RosettaAttribute("requestedWithdrawalActionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedWithdrawalActionScheme")
		public String getRequestedWithdrawalActionScheme() {
			return requestedWithdrawalActionScheme;
		}
		
		@Override
		public RequestedWithdrawalAction build() {
			return this;
		}
		
		@Override
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder toBuilder() {
			RequestedWithdrawalAction.RequestedWithdrawalActionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestedWithdrawalAction.RequestedWithdrawalActionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRequestedWithdrawalActionScheme()).ifPresent(builder::setRequestedWithdrawalActionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequestedWithdrawalAction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(requestedWithdrawalActionScheme, _that.getRequestedWithdrawalActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (requestedWithdrawalActionScheme != null ? requestedWithdrawalActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestedWithdrawalAction {" +
				"value=" + this.value + ", " +
				"requestedWithdrawalActionScheme=" + this.requestedWithdrawalActionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RequestedWithdrawalAction  ***********************/
	class RequestedWithdrawalActionBuilderImpl implements RequestedWithdrawalAction.RequestedWithdrawalActionBuilder {
	
		protected String value;
		protected String requestedWithdrawalActionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("requestedWithdrawalActionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedWithdrawalActionScheme")
		public String getRequestedWithdrawalActionScheme() {
			return requestedWithdrawalActionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("requestedWithdrawalActionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("requestedWithdrawalActionScheme")
		@Override
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder setRequestedWithdrawalActionScheme(String _requestedWithdrawalActionScheme) {
			this.requestedWithdrawalActionScheme = _requestedWithdrawalActionScheme == null ? null : _requestedWithdrawalActionScheme;
			return this;
		}
		
		@Override
		public RequestedWithdrawalAction build() {
			return new RequestedWithdrawalAction.RequestedWithdrawalActionImpl(this);
		}
		
		@Override
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRequestedWithdrawalActionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RequestedWithdrawalAction.RequestedWithdrawalActionBuilder o = (RequestedWithdrawalAction.RequestedWithdrawalActionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRequestedWithdrawalActionScheme(), o.getRequestedWithdrawalActionScheme(), this::setRequestedWithdrawalActionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequestedWithdrawalAction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(requestedWithdrawalActionScheme, _that.getRequestedWithdrawalActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (requestedWithdrawalActionScheme != null ? requestedWithdrawalActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestedWithdrawalActionBuilder {" +
				"value=" + this.value + ", " +
				"requestedWithdrawalActionScheme=" + this.requestedWithdrawalActionScheme +
			'}';
		}
	}
}
