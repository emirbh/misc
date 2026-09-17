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
import fpml.consolidated.doc.UnprocessedElementWrapper;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.LoanNotificationAcknowledgementMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
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
 * Provision A message used to acknowledge a loan notification.
 *
 */
@RosettaDataType(value="LoanNotificationAcknowledgement", builder=LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanNotificationAcknowledgement", model="fpml", builder=LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilderImpl.class, version="2.1.1")
public interface LoanNotificationAcknowledgement extends LoanAcknowledgement {

	LoanNotificationAcknowledgementMeta metaData = new LoanNotificationAcknowledgementMeta();

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

	/*********************** Build Methods  ***********************/
	LoanNotificationAcknowledgement build();
	
	LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder toBuilder();
	
	static LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder builder() {
		return new LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanNotificationAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanNotificationAcknowledgement> getType() {
		return LoanNotificationAcknowledgement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.class, getOriginalMessage());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.class, getTaskIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanNotificationAcknowledgementBuilder extends LoanNotificationAcknowledgement, LoanAcknowledgement.LoanAcknowledgementBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier();
		@Override
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier();
		@Override
		TaskIdentifier.TaskIdentifierBuilder getTaskIdentifier();
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addValidation(Validation validation);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addValidation(Validation validation, int idx);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setCorrelationId(CorrelationId correlationId);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addParty(Party party);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addParty(Party party, int idx);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addParty(List<? extends Party> party);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setParty(List<? extends Party> party);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addAccount(Account account);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addAccount(Account account, int idx);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addAccount(List<? extends Account> account);
		@Override
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setAccount(List<? extends Account> account);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier);
		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setTaskIdentifier(TaskIdentifier taskIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getTaskIdentifier());
		}
		

		LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of LoanNotificationAcknowledgement  ***********************/
	class LoanNotificationAcknowledgementImpl extends LoanAcknowledgement.LoanAcknowledgementImpl implements LoanNotificationAcknowledgement {
		private final BusinessEventIdentifier eventIdentifier;
		private final TaskIdentifier taskIdentifier;
		
		protected LoanNotificationAcknowledgementImpl(LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder builder) {
			super(builder);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
			this.taskIdentifier = ofNullable(builder.getTaskIdentifier()).map(f->f.build()).orElse(null);
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
		public LoanNotificationAcknowledgement build() {
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder toBuilder() {
			LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getTaskIdentifier()).ifPresent(builder::setTaskIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationAcknowledgement {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"taskIdentifier=" + this.taskIdentifier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanNotificationAcknowledgement  ***********************/
	class LoanNotificationAcknowledgementBuilderImpl extends LoanAcknowledgement.LoanAcknowledgementBuilderImpl implements LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder {
	
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder eventIdentifier;
		protected TaskIdentifier.TaskIdentifierBuilder taskIdentifier;
		
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
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("header")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addValidation(List<? extends Validation> validations) {
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
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setValidation(List<? extends Validation> validations) {
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
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correlationId")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setCorrelationId(CorrelationId _correlationId) {
			this.correlationId = _correlationId == null ? null : _correlationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setOnBehalfOf(OnBehalfOf _onBehalfOf) {
			this.onBehalfOf = _onBehalfOf == null ? null : _onBehalfOf.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalMessage")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper _originalMessage) {
			this.originalMessage = _originalMessage == null ? null : _originalMessage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("account")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("account")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder addAccount(List<? extends Account> accounts) {
			if (accounts != null) {
				for (final Account toAdd : accounts) {
					this.account.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("account")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("account")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null) {
				this.account = new ArrayList<>();
			} else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("taskIdentifier")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder setTaskIdentifier(TaskIdentifier _taskIdentifier) {
			this.taskIdentifier = _taskIdentifier == null ? null : _taskIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public LoanNotificationAcknowledgement build() {
			return new LoanNotificationAcknowledgement.LoanNotificationAcknowledgementImpl(this);
		}
		
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder prune() {
			super.prune();
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			if (taskIdentifier!=null && !taskIdentifier.prune().hasData()) taskIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			if (getTaskIdentifier()!=null && getTaskIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder o = (LoanNotificationAcknowledgement.LoanNotificationAcknowledgementBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeRosetta(getTaskIdentifier(), o.getTaskIdentifier(), this::setTaskIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationAcknowledgementBuilder {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"taskIdentifier=" + this.taskIdentifier +
			'}' + " " + super.toString();
		}
	}
}
