package fpml.consolidated.msg;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.meta.ServiceNotificationMeta;
import fpml.consolidated.shared.OnBehalfOf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the content model for a message that allows a service to send a notification message to a user of the service.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the content model for a message that allows a service to send a notification message to a user of the service.
 *
 */
@RosettaDataType(value="ServiceNotification", builder=ServiceNotification.ServiceNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ServiceNotification", model="fpml", builder=ServiceNotification.ServiceNotificationBuilderImpl.class, version="2.1.1")
public interface ServiceNotification extends NotificationMessage {

	ServiceNotificationMeta metaData = new ServiceNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The name of the service to which the message applies
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the service to which the message applies
	 *
	 */
	String getServiceName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The current state of the service (e.g. Available, Unavailable).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The current state of the service (e.g. Available, Unavailable).
	 *
	 */
	ServiceStatus getStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A description of the stage of processing of the service, for example EndofDayProcessingCutoffOccurred, EndOfDayProcessingCompleted. [TBD: could be combined with advisory]
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A description of the stage of processing of the service, for example EndofDayProcessingCutoffOccurred, EndOfDayProcessingCompleted. [TBD: could be combined with advisory]
	 *
	 */
	ServiceProcessingStatus getProcessingStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A human-readable message providing information about the service..
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A human-readable message providing information about the service..
	 *
	 */
	ServiceAdvisory getAdvisory();

	/*********************** Build Methods  ***********************/
	ServiceNotification build();
	
	ServiceNotification.ServiceNotificationBuilder toBuilder();
	
	static ServiceNotification.ServiceNotificationBuilder builder() {
		return new ServiceNotification.ServiceNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ServiceNotification> getType() {
		return ServiceNotification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processor.processBasic(path.newSubPath("serviceName"), String.class, getServiceName(), this);
		processRosetta(path.newSubPath("status"), processor, ServiceStatus.class, getStatus());
		processRosetta(path.newSubPath("processingStatus"), processor, ServiceProcessingStatus.class, getProcessingStatus());
		processRosetta(path.newSubPath("advisory"), processor, ServiceAdvisory.class, getAdvisory());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ServiceNotificationBuilder extends ServiceNotification, NotificationMessage.NotificationMessageBuilder {
		ServiceStatus.ServiceStatusBuilder getOrCreateStatus();
		@Override
		ServiceStatus.ServiceStatusBuilder getStatus();
		ServiceProcessingStatus.ServiceProcessingStatusBuilder getOrCreateProcessingStatus();
		@Override
		ServiceProcessingStatus.ServiceProcessingStatusBuilder getProcessingStatus();
		ServiceAdvisory.ServiceAdvisoryBuilder getOrCreateAdvisory();
		@Override
		ServiceAdvisory.ServiceAdvisoryBuilder getAdvisory();
		@Override
		ServiceNotification.ServiceNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ServiceNotification.ServiceNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ServiceNotification.ServiceNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		ServiceNotification.ServiceNotificationBuilder setHeader(NotificationMessageHeader header);
		@Override
		ServiceNotification.ServiceNotificationBuilder addValidation(Validation validation);
		@Override
		ServiceNotification.ServiceNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		ServiceNotification.ServiceNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		ServiceNotification.ServiceNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		ServiceNotification.ServiceNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ServiceNotification.ServiceNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ServiceNotification.ServiceNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ServiceNotification.ServiceNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ServiceNotification.ServiceNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ServiceNotification.ServiceNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ServiceNotification.ServiceNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ServiceNotification.ServiceNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ServiceNotification.ServiceNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ServiceNotification.ServiceNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ServiceNotification.ServiceNotificationBuilder setServiceName(String serviceName);
		ServiceNotification.ServiceNotificationBuilder setStatus(ServiceStatus status);
		ServiceNotification.ServiceNotificationBuilder setProcessingStatus(ServiceProcessingStatus processingStatus);
		ServiceNotification.ServiceNotificationBuilder setAdvisory(ServiceAdvisory advisory);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processor.processBasic(path.newSubPath("serviceName"), String.class, getServiceName(), this);
			processRosetta(path.newSubPath("status"), processor, ServiceStatus.ServiceStatusBuilder.class, getStatus());
			processRosetta(path.newSubPath("processingStatus"), processor, ServiceProcessingStatus.ServiceProcessingStatusBuilder.class, getProcessingStatus());
			processRosetta(path.newSubPath("advisory"), processor, ServiceAdvisory.ServiceAdvisoryBuilder.class, getAdvisory());
		}
		

		ServiceNotification.ServiceNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceNotification  ***********************/
	class ServiceNotificationImpl extends NotificationMessage.NotificationMessageImpl implements ServiceNotification {
		private final String serviceName;
		private final ServiceStatus status;
		private final ServiceProcessingStatus processingStatus;
		private final ServiceAdvisory advisory;
		
		protected ServiceNotificationImpl(ServiceNotification.ServiceNotificationBuilder builder) {
			super(builder);
			this.serviceName = builder.getServiceName();
			this.status = ofNullable(builder.getStatus()).map(f->f.build()).orElse(null);
			this.processingStatus = ofNullable(builder.getProcessingStatus()).map(f->f.build()).orElse(null);
			this.advisory = ofNullable(builder.getAdvisory()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("serviceName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceName")
		public String getServiceName() {
			return serviceName;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("status")
		public ServiceStatus getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("processingStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("processingStatus")
		public ServiceProcessingStatus getProcessingStatus() {
			return processingStatus;
		}
		
		@Override
		@RosettaAttribute("advisory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("advisory")
		public ServiceAdvisory getAdvisory() {
			return advisory;
		}
		
		@Override
		public ServiceNotification build() {
			return this;
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder toBuilder() {
			ServiceNotification.ServiceNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceNotification.ServiceNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getServiceName()).ifPresent(builder::setServiceName);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getProcessingStatus()).ifPresent(builder::setProcessingStatus);
			ofNullable(getAdvisory()).ifPresent(builder::setAdvisory);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ServiceNotification _that = getType().cast(o);
		
			if (!Objects.equals(serviceName, _that.getServiceName())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(processingStatus, _that.getProcessingStatus())) return false;
			if (!Objects.equals(advisory, _that.getAdvisory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (serviceName != null ? serviceName.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (processingStatus != null ? processingStatus.hashCode() : 0);
			_result = 31 * _result + (advisory != null ? advisory.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceNotification {" +
				"serviceName=" + this.serviceName + ", " +
				"status=" + this.status + ", " +
				"processingStatus=" + this.processingStatus + ", " +
				"advisory=" + this.advisory +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ServiceNotification  ***********************/
	class ServiceNotificationBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl implements ServiceNotification.ServiceNotificationBuilder {
	
		protected String serviceName;
		protected ServiceStatus.ServiceStatusBuilder status;
		protected ServiceProcessingStatus.ServiceProcessingStatusBuilder processingStatus;
		protected ServiceAdvisory.ServiceAdvisoryBuilder advisory;
		
		@Override
		@RosettaAttribute("serviceName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceName")
		public String getServiceName() {
			return serviceName;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("status")
		public ServiceStatus.ServiceStatusBuilder getStatus() {
			return status;
		}
		
		@Override
		public ServiceStatus.ServiceStatusBuilder getOrCreateStatus() {
			ServiceStatus.ServiceStatusBuilder result;
			if (status!=null) {
				result = status;
			}
			else {
				result = status = ServiceStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("processingStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("processingStatus")
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder getProcessingStatus() {
			return processingStatus;
		}
		
		@Override
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder getOrCreateProcessingStatus() {
			ServiceProcessingStatus.ServiceProcessingStatusBuilder result;
			if (processingStatus!=null) {
				result = processingStatus;
			}
			else {
				result = processingStatus = ServiceProcessingStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("advisory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("advisory")
		public ServiceAdvisory.ServiceAdvisoryBuilder getAdvisory() {
			return advisory;
		}
		
		@Override
		public ServiceAdvisory.ServiceAdvisoryBuilder getOrCreateAdvisory() {
			ServiceAdvisory.ServiceAdvisoryBuilder result;
			if (advisory!=null) {
				result = advisory;
			}
			else {
				result = advisory = ServiceAdvisory.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ServiceNotification.ServiceNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (final Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ServiceNotification.ServiceNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds != null) {
				for (final CorrelationId toAdd : correlationIds) {
					this.correlationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds == null) {
				this.correlationId = new ArrayList<>();
			} else {
				this.correlationId = correlationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ServiceNotification.ServiceNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("serviceName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("serviceName")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setServiceName(String _serviceName) {
			this.serviceName = _serviceName == null ? null : _serviceName;
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("status")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setStatus(ServiceStatus _status) {
			this.status = _status == null ? null : _status.toBuilder();
			return this;
		}
		
		@RosettaAttribute("processingStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("processingStatus")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setProcessingStatus(ServiceProcessingStatus _processingStatus) {
			this.processingStatus = _processingStatus == null ? null : _processingStatus.toBuilder();
			return this;
		}
		
		@RosettaAttribute("advisory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("advisory")
		@Override
		public ServiceNotification.ServiceNotificationBuilder setAdvisory(ServiceAdvisory _advisory) {
			this.advisory = _advisory == null ? null : _advisory.toBuilder();
			return this;
		}
		
		@Override
		public ServiceNotification build() {
			return new ServiceNotification.ServiceNotificationImpl(this);
		}
		
		@Override
		public ServiceNotification.ServiceNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceNotification.ServiceNotificationBuilder prune() {
			super.prune();
			if (status!=null && !status.prune().hasData()) status = null;
			if (processingStatus!=null && !processingStatus.prune().hasData()) processingStatus = null;
			if (advisory!=null && !advisory.prune().hasData()) advisory = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getServiceName()!=null) return true;
			if (getStatus()!=null && getStatus().hasData()) return true;
			if (getProcessingStatus()!=null && getProcessingStatus().hasData()) return true;
			if (getAdvisory()!=null && getAdvisory().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceNotification.ServiceNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ServiceNotification.ServiceNotificationBuilder o = (ServiceNotification.ServiceNotificationBuilder) other;
			
			merger.mergeRosetta(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeRosetta(getProcessingStatus(), o.getProcessingStatus(), this::setProcessingStatus);
			merger.mergeRosetta(getAdvisory(), o.getAdvisory(), this::setAdvisory);
			
			merger.mergeBasic(getServiceName(), o.getServiceName(), this::setServiceName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ServiceNotification _that = getType().cast(o);
		
			if (!Objects.equals(serviceName, _that.getServiceName())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(processingStatus, _that.getProcessingStatus())) return false;
			if (!Objects.equals(advisory, _that.getAdvisory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (serviceName != null ? serviceName.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (processingStatus != null ? processingStatus.hashCode() : 0);
			_result = 31 * _result + (advisory != null ? advisory.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceNotificationBuilder {" +
				"serviceName=" + this.serviceName + ", " +
				"status=" + this.status + ", " +
				"processingStatus=" + this.processingStatus + ", " +
				"advisory=" + this.advisory +
			'}' + " " + super.toString();
		}
	}
}
