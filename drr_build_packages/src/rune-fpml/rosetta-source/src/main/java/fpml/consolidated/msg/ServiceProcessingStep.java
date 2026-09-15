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
import fpml.consolidated.msg.meta.ServiceProcessingStepMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that can be used to describe what stage of processing a service is in. For example, Netting or Valuation.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that can be used to describe what stage of processing a service is in. For example, Netting or Valuation.
 *
 */
@RosettaDataType(value="ServiceProcessingStep", builder=ServiceProcessingStep.ServiceProcessingStepBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ServiceProcessingStep", model="fpml", builder=ServiceProcessingStep.ServiceProcessingStepBuilderImpl.class, version="2.1.1")
public interface ServiceProcessingStep extends RosettaModelObject {

	ServiceProcessingStepMeta metaData = new ServiceProcessingStepMeta();

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
	String getServiceProcessingStep();

	/*********************** Build Methods  ***********************/
	ServiceProcessingStep build();
	
	ServiceProcessingStep.ServiceProcessingStepBuilder toBuilder();
	
	static ServiceProcessingStep.ServiceProcessingStepBuilder builder() {
		return new ServiceProcessingStep.ServiceProcessingStepBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceProcessingStep> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ServiceProcessingStep> getType() {
		return ServiceProcessingStep.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("serviceProcessingStep"), String.class, getServiceProcessingStep(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ServiceProcessingStepBuilder extends ServiceProcessingStep, RosettaModelObjectBuilder {
		ServiceProcessingStep.ServiceProcessingStepBuilder setValue(String value);
		ServiceProcessingStep.ServiceProcessingStepBuilder setServiceProcessingStep(String serviceProcessingStep);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("serviceProcessingStep"), String.class, getServiceProcessingStep(), this);
		}
		

		ServiceProcessingStep.ServiceProcessingStepBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceProcessingStep  ***********************/
	class ServiceProcessingStepImpl implements ServiceProcessingStep {
		private final String value;
		private final String serviceProcessingStep;
		
		protected ServiceProcessingStepImpl(ServiceProcessingStep.ServiceProcessingStepBuilder builder) {
			this.value = builder.getValue();
			this.serviceProcessingStep = builder.getServiceProcessingStep();
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
		@RosettaAttribute("serviceProcessingStep")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceProcessingStep")
		public String getServiceProcessingStep() {
			return serviceProcessingStep;
		}
		
		@Override
		public ServiceProcessingStep build() {
			return this;
		}
		
		@Override
		public ServiceProcessingStep.ServiceProcessingStepBuilder toBuilder() {
			ServiceProcessingStep.ServiceProcessingStepBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceProcessingStep.ServiceProcessingStepBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getServiceProcessingStep()).ifPresent(builder::setServiceProcessingStep);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceProcessingStep _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceProcessingStep, _that.getServiceProcessingStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceProcessingStep != null ? serviceProcessingStep.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceProcessingStep {" +
				"value=" + this.value + ", " +
				"serviceProcessingStep=" + this.serviceProcessingStep +
			'}';
		}
	}

	/*********************** Builder Implementation of ServiceProcessingStep  ***********************/
	class ServiceProcessingStepBuilderImpl implements ServiceProcessingStep.ServiceProcessingStepBuilder {
	
		protected String value;
		protected String serviceProcessingStep;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("serviceProcessingStep")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceProcessingStep")
		public String getServiceProcessingStep() {
			return serviceProcessingStep;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ServiceProcessingStep.ServiceProcessingStepBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("serviceProcessingStep")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("serviceProcessingStep")
		@Override
		public ServiceProcessingStep.ServiceProcessingStepBuilder setServiceProcessingStep(String _serviceProcessingStep) {
			this.serviceProcessingStep = _serviceProcessingStep == null ? null : _serviceProcessingStep;
			return this;
		}
		
		@Override
		public ServiceProcessingStep build() {
			return new ServiceProcessingStep.ServiceProcessingStepImpl(this);
		}
		
		@Override
		public ServiceProcessingStep.ServiceProcessingStepBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceProcessingStep.ServiceProcessingStepBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getServiceProcessingStep()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceProcessingStep.ServiceProcessingStepBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ServiceProcessingStep.ServiceProcessingStepBuilder o = (ServiceProcessingStep.ServiceProcessingStepBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getServiceProcessingStep(), o.getServiceProcessingStep(), this::setServiceProcessingStep);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceProcessingStep _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceProcessingStep, _that.getServiceProcessingStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceProcessingStep != null ? serviceProcessingStep.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceProcessingStepBuilder {" +
				"value=" + this.value + ", " +
				"serviceProcessingStep=" + this.serviceProcessingStep +
			'}';
		}
	}
}
