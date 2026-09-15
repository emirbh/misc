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
import fpml.consolidated.msg.meta.ServiceStatusMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that can be used to describe the availability or other state of a service, e.g. Available, Unavaialble.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that can be used to describe the availability or other state of a service, e.g. Available, Unavaialble.
 *
 */
@RosettaDataType(value="ServiceStatus", builder=ServiceStatus.ServiceStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ServiceStatus", model="fpml", builder=ServiceStatus.ServiceStatusBuilderImpl.class, version="2.1.1")
public interface ServiceStatus extends RosettaModelObject {

	ServiceStatusMeta metaData = new ServiceStatusMeta();

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
	String getServiceStatusScheme();

	/*********************** Build Methods  ***********************/
	ServiceStatus build();
	
	ServiceStatus.ServiceStatusBuilder toBuilder();
	
	static ServiceStatus.ServiceStatusBuilder builder() {
		return new ServiceStatus.ServiceStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ServiceStatus> getType() {
		return ServiceStatus.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("serviceStatusScheme"), String.class, getServiceStatusScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ServiceStatusBuilder extends ServiceStatus, RosettaModelObjectBuilder {
		ServiceStatus.ServiceStatusBuilder setValue(String value);
		ServiceStatus.ServiceStatusBuilder setServiceStatusScheme(String serviceStatusScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("serviceStatusScheme"), String.class, getServiceStatusScheme(), this);
		}
		

		ServiceStatus.ServiceStatusBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceStatus  ***********************/
	class ServiceStatusImpl implements ServiceStatus {
		private final String value;
		private final String serviceStatusScheme;
		
		protected ServiceStatusImpl(ServiceStatus.ServiceStatusBuilder builder) {
			this.value = builder.getValue();
			this.serviceStatusScheme = builder.getServiceStatusScheme();
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
		@RosettaAttribute("serviceStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceStatusScheme")
		public String getServiceStatusScheme() {
			return serviceStatusScheme;
		}
		
		@Override
		public ServiceStatus build() {
			return this;
		}
		
		@Override
		public ServiceStatus.ServiceStatusBuilder toBuilder() {
			ServiceStatus.ServiceStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceStatus.ServiceStatusBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getServiceStatusScheme()).ifPresent(builder::setServiceStatusScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceStatusScheme, _that.getServiceStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceStatusScheme != null ? serviceStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceStatus {" +
				"value=" + this.value + ", " +
				"serviceStatusScheme=" + this.serviceStatusScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ServiceStatus  ***********************/
	class ServiceStatusBuilderImpl implements ServiceStatus.ServiceStatusBuilder {
	
		protected String value;
		protected String serviceStatusScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("serviceStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceStatusScheme")
		public String getServiceStatusScheme() {
			return serviceStatusScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ServiceStatus.ServiceStatusBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("serviceStatusScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("serviceStatusScheme")
		@Override
		public ServiceStatus.ServiceStatusBuilder setServiceStatusScheme(String _serviceStatusScheme) {
			this.serviceStatusScheme = _serviceStatusScheme == null ? null : _serviceStatusScheme;
			return this;
		}
		
		@Override
		public ServiceStatus build() {
			return new ServiceStatus.ServiceStatusImpl(this);
		}
		
		@Override
		public ServiceStatus.ServiceStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceStatus.ServiceStatusBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getServiceStatusScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceStatus.ServiceStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ServiceStatus.ServiceStatusBuilder o = (ServiceStatus.ServiceStatusBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getServiceStatusScheme(), o.getServiceStatusScheme(), this::setServiceStatusScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceStatusScheme, _that.getServiceStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceStatusScheme != null ? serviceStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceStatusBuilder {" +
				"value=" + this.value + ", " +
				"serviceStatusScheme=" + this.serviceStatusScheme +
			'}';
		}
	}
}
