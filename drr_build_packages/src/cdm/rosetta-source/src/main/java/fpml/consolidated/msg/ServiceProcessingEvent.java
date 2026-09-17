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
import fpml.consolidated.msg.meta.ServiceProcessingEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that can be used to describe a stage or step in processing provided by a service, for example processing completed.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that can be used to describe a stage or step in processing provided by a service, for example processing completed.
 *
 */
@RosettaDataType(value="ServiceProcessingEvent", builder=ServiceProcessingEvent.ServiceProcessingEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ServiceProcessingEvent", model="fpml", builder=ServiceProcessingEvent.ServiceProcessingEventBuilderImpl.class, version="2.1.1")
public interface ServiceProcessingEvent extends RosettaModelObject {

	ServiceProcessingEventMeta metaData = new ServiceProcessingEventMeta();

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
	String getServiceProcessingEventScheme();

	/*********************** Build Methods  ***********************/
	ServiceProcessingEvent build();
	
	ServiceProcessingEvent.ServiceProcessingEventBuilder toBuilder();
	
	static ServiceProcessingEvent.ServiceProcessingEventBuilder builder() {
		return new ServiceProcessingEvent.ServiceProcessingEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceProcessingEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ServiceProcessingEvent> getType() {
		return ServiceProcessingEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("serviceProcessingEventScheme"), String.class, getServiceProcessingEventScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ServiceProcessingEventBuilder extends ServiceProcessingEvent, RosettaModelObjectBuilder {
		ServiceProcessingEvent.ServiceProcessingEventBuilder setValue(String value);
		ServiceProcessingEvent.ServiceProcessingEventBuilder setServiceProcessingEventScheme(String serviceProcessingEventScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("serviceProcessingEventScheme"), String.class, getServiceProcessingEventScheme(), this);
		}
		

		ServiceProcessingEvent.ServiceProcessingEventBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceProcessingEvent  ***********************/
	class ServiceProcessingEventImpl implements ServiceProcessingEvent {
		private final String value;
		private final String serviceProcessingEventScheme;
		
		protected ServiceProcessingEventImpl(ServiceProcessingEvent.ServiceProcessingEventBuilder builder) {
			this.value = builder.getValue();
			this.serviceProcessingEventScheme = builder.getServiceProcessingEventScheme();
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
		@RosettaAttribute("serviceProcessingEventScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceProcessingEventScheme")
		public String getServiceProcessingEventScheme() {
			return serviceProcessingEventScheme;
		}
		
		@Override
		public ServiceProcessingEvent build() {
			return this;
		}
		
		@Override
		public ServiceProcessingEvent.ServiceProcessingEventBuilder toBuilder() {
			ServiceProcessingEvent.ServiceProcessingEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceProcessingEvent.ServiceProcessingEventBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getServiceProcessingEventScheme()).ifPresent(builder::setServiceProcessingEventScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceProcessingEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceProcessingEventScheme, _that.getServiceProcessingEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceProcessingEventScheme != null ? serviceProcessingEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceProcessingEvent {" +
				"value=" + this.value + ", " +
				"serviceProcessingEventScheme=" + this.serviceProcessingEventScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ServiceProcessingEvent  ***********************/
	class ServiceProcessingEventBuilderImpl implements ServiceProcessingEvent.ServiceProcessingEventBuilder {
	
		protected String value;
		protected String serviceProcessingEventScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("serviceProcessingEventScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceProcessingEventScheme")
		public String getServiceProcessingEventScheme() {
			return serviceProcessingEventScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ServiceProcessingEvent.ServiceProcessingEventBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("serviceProcessingEventScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("serviceProcessingEventScheme")
		@Override
		public ServiceProcessingEvent.ServiceProcessingEventBuilder setServiceProcessingEventScheme(String _serviceProcessingEventScheme) {
			this.serviceProcessingEventScheme = _serviceProcessingEventScheme == null ? null : _serviceProcessingEventScheme;
			return this;
		}
		
		@Override
		public ServiceProcessingEvent build() {
			return new ServiceProcessingEvent.ServiceProcessingEventImpl(this);
		}
		
		@Override
		public ServiceProcessingEvent.ServiceProcessingEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceProcessingEvent.ServiceProcessingEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getServiceProcessingEventScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceProcessingEvent.ServiceProcessingEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ServiceProcessingEvent.ServiceProcessingEventBuilder o = (ServiceProcessingEvent.ServiceProcessingEventBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getServiceProcessingEventScheme(), o.getServiceProcessingEventScheme(), this::setServiceProcessingEventScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceProcessingEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceProcessingEventScheme, _that.getServiceProcessingEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceProcessingEventScheme != null ? serviceProcessingEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceProcessingEventBuilder {" +
				"value=" + this.value + ", " +
				"serviceProcessingEventScheme=" + this.serviceProcessingEventScheme +
			'}';
		}
	}
}
