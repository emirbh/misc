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
import fpml.consolidated.msg.meta.ServiceAdvisoryCategoryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that can be used to describe the category of an advisory message, e.g.. Availability, Rules, Products, etc., etc..
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that can be used to describe the category of an advisory message, e.g.. Availability, Rules, Products, etc., etc..
 *
 */
@RosettaDataType(value="ServiceAdvisoryCategory", builder=ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ServiceAdvisoryCategory", model="fpml", builder=ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilderImpl.class, version="2.1.1")
public interface ServiceAdvisoryCategory extends RosettaModelObject {

	ServiceAdvisoryCategoryMeta metaData = new ServiceAdvisoryCategoryMeta();

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
	String getServiceAdvisoryCategoryScheme();

	/*********************** Build Methods  ***********************/
	ServiceAdvisoryCategory build();
	
	ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder toBuilder();
	
	static ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder builder() {
		return new ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceAdvisoryCategory> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ServiceAdvisoryCategory> getType() {
		return ServiceAdvisoryCategory.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("serviceAdvisoryCategoryScheme"), String.class, getServiceAdvisoryCategoryScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ServiceAdvisoryCategoryBuilder extends ServiceAdvisoryCategory, RosettaModelObjectBuilder {
		ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder setValue(String value);
		ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder setServiceAdvisoryCategoryScheme(String serviceAdvisoryCategoryScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("serviceAdvisoryCategoryScheme"), String.class, getServiceAdvisoryCategoryScheme(), this);
		}
		

		ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceAdvisoryCategory  ***********************/
	class ServiceAdvisoryCategoryImpl implements ServiceAdvisoryCategory {
		private final String value;
		private final String serviceAdvisoryCategoryScheme;
		
		protected ServiceAdvisoryCategoryImpl(ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder builder) {
			this.value = builder.getValue();
			this.serviceAdvisoryCategoryScheme = builder.getServiceAdvisoryCategoryScheme();
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
		@RosettaAttribute("serviceAdvisoryCategoryScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceAdvisoryCategoryScheme")
		public String getServiceAdvisoryCategoryScheme() {
			return serviceAdvisoryCategoryScheme;
		}
		
		@Override
		public ServiceAdvisoryCategory build() {
			return this;
		}
		
		@Override
		public ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder toBuilder() {
			ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getServiceAdvisoryCategoryScheme()).ifPresent(builder::setServiceAdvisoryCategoryScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceAdvisoryCategory _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceAdvisoryCategoryScheme, _that.getServiceAdvisoryCategoryScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceAdvisoryCategoryScheme != null ? serviceAdvisoryCategoryScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceAdvisoryCategory {" +
				"value=" + this.value + ", " +
				"serviceAdvisoryCategoryScheme=" + this.serviceAdvisoryCategoryScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ServiceAdvisoryCategory  ***********************/
	class ServiceAdvisoryCategoryBuilderImpl implements ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder {
	
		protected String value;
		protected String serviceAdvisoryCategoryScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("serviceAdvisoryCategoryScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceAdvisoryCategoryScheme")
		public String getServiceAdvisoryCategoryScheme() {
			return serviceAdvisoryCategoryScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("serviceAdvisoryCategoryScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("serviceAdvisoryCategoryScheme")
		@Override
		public ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder setServiceAdvisoryCategoryScheme(String _serviceAdvisoryCategoryScheme) {
			this.serviceAdvisoryCategoryScheme = _serviceAdvisoryCategoryScheme == null ? null : _serviceAdvisoryCategoryScheme;
			return this;
		}
		
		@Override
		public ServiceAdvisoryCategory build() {
			return new ServiceAdvisoryCategory.ServiceAdvisoryCategoryImpl(this);
		}
		
		@Override
		public ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getServiceAdvisoryCategoryScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder o = (ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getServiceAdvisoryCategoryScheme(), o.getServiceAdvisoryCategoryScheme(), this::setServiceAdvisoryCategoryScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceAdvisoryCategory _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceAdvisoryCategoryScheme, _that.getServiceAdvisoryCategoryScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceAdvisoryCategoryScheme != null ? serviceAdvisoryCategoryScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceAdvisoryCategoryBuilder {" +
				"value=" + this.value + ", " +
				"serviceAdvisoryCategoryScheme=" + this.serviceAdvisoryCategoryScheme +
			'}';
		}
	}
}
