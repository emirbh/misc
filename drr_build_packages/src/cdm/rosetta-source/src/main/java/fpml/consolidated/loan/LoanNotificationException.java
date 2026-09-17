package fpml.consolidated.loan;

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
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.LoanNotificationExceptionMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ExceptionMessageHeader;
import fpml.consolidated.shared.Party;
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
 * version "confirmation-5.13"
 *
 * Provision A message used to indicate an exception issue with a loan notification.
 *
 */
@RosettaDataType(value="LoanNotificationException", builder=LoanNotificationException.LoanNotificationExceptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanNotificationException", model="fpml", builder=LoanNotificationException.LoanNotificationExceptionBuilderImpl.class, version="2.1.1")
public interface LoanNotificationException extends fpml.consolidated.msg.Exception {

	LoanNotificationExceptionMeta metaData = new LoanNotificationExceptionMeta();

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
	BusinessEventIdentifier getEventIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TaskIdentifier getTaskIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Party getParty();

	/*********************** Build Methods  ***********************/
	LoanNotificationException build();
	
	LoanNotificationException.LoanNotificationExceptionBuilder toBuilder();
	
	static LoanNotificationException.LoanNotificationExceptionBuilder builder() {
		return new LoanNotificationException.LoanNotificationExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanNotificationException> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanNotificationException> getType() {
		return LoanNotificationException.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
		processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.class, getAdditionalData());
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.class, getTaskIdentifier());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanNotificationExceptionBuilder extends LoanNotificationException, fpml.consolidated.msg.Exception.ExceptionBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier();
		@Override
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier();
		@Override
		TaskIdentifier.TaskIdentifierBuilder getTaskIdentifier();
		Party.PartyBuilder getOrCreateParty();
		@Override
		Party.PartyBuilder getParty();
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setHeader(ExceptionMessageHeader header);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder addValidation(Validation validation);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder addValidation(Validation validation, int idx);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder addReason(Reason reason);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder addReason(Reason reason, int idx);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder addReason(List<? extends Reason> reason);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setReason(List<? extends Reason> reason);
		@Override
		LoanNotificationException.LoanNotificationExceptionBuilder setAdditionalData(AdditionalData additionalData);
		LoanNotificationException.LoanNotificationExceptionBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier);
		LoanNotificationException.LoanNotificationExceptionBuilder setTaskIdentifier(TaskIdentifier taskIdentifier);
		LoanNotificationException.LoanNotificationExceptionBuilder setParty(Party party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.AdditionalDataBuilder.class, getAdditionalData());
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getTaskIdentifier());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanNotificationException.LoanNotificationExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of LoanNotificationException  ***********************/
	class LoanNotificationExceptionImpl extends fpml.consolidated.msg.Exception.ExceptionImpl implements LoanNotificationException {
		private final BusinessEventIdentifier eventIdentifier;
		private final TaskIdentifier taskIdentifier;
		private final Party party;
		
		protected LoanNotificationExceptionImpl(LoanNotificationException.LoanNotificationExceptionBuilder builder) {
			super(builder);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
			this.taskIdentifier = ofNullable(builder.getTaskIdentifier()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventIdentifier")
		public BusinessEventIdentifier getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("taskIdentifier")
		public TaskIdentifier getTaskIdentifier() {
			return taskIdentifier;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public Party getParty() {
			return party;
		}
		
		@Override
		public LoanNotificationException build() {
			return this;
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder toBuilder() {
			LoanNotificationException.LoanNotificationExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanNotificationException.LoanNotificationExceptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getTaskIdentifier()).ifPresent(builder::setTaskIdentifier);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationException _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationException {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"taskIdentifier=" + this.taskIdentifier + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanNotificationException  ***********************/
	class LoanNotificationExceptionBuilderImpl extends fpml.consolidated.msg.Exception.ExceptionBuilderImpl implements LoanNotificationException.LoanNotificationExceptionBuilder {
	
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder eventIdentifier;
		protected TaskIdentifier.TaskIdentifierBuilder taskIdentifier;
		protected Party.PartyBuilder party;
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (eventIdentifier!=null) {
				result = eventIdentifier;
			}
			else {
				result = eventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("taskIdentifier")
		public TaskIdentifier.TaskIdentifierBuilder getTaskIdentifier() {
			return taskIdentifier;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier() {
			TaskIdentifier.TaskIdentifierBuilder result;
			if (taskIdentifier!=null) {
				result = taskIdentifier;
			}
			else {
				result = taskIdentifier = TaskIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder setHeader(ExceptionMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder addValidation(List<? extends Validation> validations) {
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
		public LoanNotificationException.LoanNotificationExceptionBuilder setValidation(List<? extends Validation> validations) {
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
		public LoanNotificationException.LoanNotificationExceptionBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanNotificationException.LoanNotificationExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanNotificationException.LoanNotificationExceptionBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (final Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalData")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder setEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("taskIdentifier")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder setTaskIdentifier(TaskIdentifier _taskIdentifier) {
			this.taskIdentifier = _taskIdentifier == null ? null : _taskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("party")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder setParty(Party _party) {
			this.party = _party == null ? null : _party.toBuilder();
			return this;
		}
		
		@Override
		public LoanNotificationException build() {
			return new LoanNotificationException.LoanNotificationExceptionImpl(this);
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder prune() {
			super.prune();
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			if (taskIdentifier!=null && !taskIdentifier.prune().hasData()) taskIdentifier = null;
			if (party!=null && !party.prune().hasData()) party = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			if (getTaskIdentifier()!=null && getTaskIdentifier().hasData()) return true;
			if (getParty()!=null && getParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanNotificationException.LoanNotificationExceptionBuilder o = (LoanNotificationException.LoanNotificationExceptionBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeRosetta(getTaskIdentifier(), o.getTaskIdentifier(), this::setTaskIdentifier);
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationException _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationExceptionBuilder {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"taskIdentifier=" + this.taskIdentifier + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
