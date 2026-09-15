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
import fpml.consolidated.loan.meta.LoanNotificationRetractedMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NonCorrectableRequestMessage;
import fpml.consolidated.msg.RequestMessageHeader;
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
 * Provision A message used to indicate a retraction of a loan notification.
 *
 */
@RosettaDataType(value="LoanNotificationRetracted", builder=LoanNotificationRetracted.LoanNotificationRetractedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanNotificationRetracted", model="fpml", builder=LoanNotificationRetracted.LoanNotificationRetractedBuilderImpl.class, version="2.1.1")
public interface LoanNotificationRetracted extends NonCorrectableRequestMessage {

	LoanNotificationRetractedMeta metaData = new LoanNotificationRetractedMeta();

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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	UnprocessedElementWrapper getOriginalMessage();

	/*********************** Build Methods  ***********************/
	LoanNotificationRetracted build();
	
	LoanNotificationRetracted.LoanNotificationRetractedBuilder toBuilder();
	
	static LoanNotificationRetracted.LoanNotificationRetractedBuilder builder() {
		return new LoanNotificationRetracted.LoanNotificationRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanNotificationRetracted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanNotificationRetracted> getType() {
		return LoanNotificationRetracted.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.class, getTaskIdentifier());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.class, getOriginalMessage());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanNotificationRetractedBuilder extends LoanNotificationRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier();
		@Override
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier();
		@Override
		TaskIdentifier.TaskIdentifierBuilder getTaskIdentifier();
		Party.PartyBuilder getOrCreateParty();
		@Override
		Party.PartyBuilder getParty();
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage();
		@Override
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage();
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setHeader(RequestMessageHeader header);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder addValidation(Validation validation);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder addValidation(Validation validation, int idx);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setTaskIdentifier(TaskIdentifier taskIdentifier);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setParty(Party party);
		LoanNotificationRetracted.LoanNotificationRetractedBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getTaskIdentifier());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
		}
		

		LoanNotificationRetracted.LoanNotificationRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of LoanNotificationRetracted  ***********************/
	class LoanNotificationRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements LoanNotificationRetracted {
		private final BusinessEventIdentifier eventIdentifier;
		private final TaskIdentifier taskIdentifier;
		private final Party party;
		private final UnprocessedElementWrapper originalMessage;
		
		protected LoanNotificationRetractedImpl(LoanNotificationRetracted.LoanNotificationRetractedBuilder builder) {
			super(builder);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
			this.taskIdentifier = ofNullable(builder.getTaskIdentifier()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.originalMessage = ofNullable(builder.getOriginalMessage()).map(f->f.build()).orElse(null);
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
		@Required
		@RuneAttribute("party")
		public Party getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalMessage")
		public UnprocessedElementWrapper getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		public LoanNotificationRetracted build() {
			return this;
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder toBuilder() {
			LoanNotificationRetracted.LoanNotificationRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanNotificationRetracted.LoanNotificationRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getTaskIdentifier()).ifPresent(builder::setTaskIdentifier);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getOriginalMessage()).ifPresent(builder::setOriginalMessage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationRetracted _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationRetracted {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"taskIdentifier=" + this.taskIdentifier + ", " +
				"party=" + this.party + ", " +
				"originalMessage=" + this.originalMessage +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanNotificationRetracted  ***********************/
	class LoanNotificationRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl implements LoanNotificationRetracted.LoanNotificationRetractedBuilder {
	
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder eventIdentifier;
		protected TaskIdentifier.TaskIdentifierBuilder taskIdentifier;
		protected Party.PartyBuilder party;
		protected UnprocessedElementWrapper.UnprocessedElementWrapperBuilder originalMessage;
		
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
		@Required
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
		
		@Override
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalMessage")
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage() {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder result;
			if (originalMessage!=null) {
				result = originalMessage;
			}
			else {
				result = originalMessage = UnprocessedElementWrapper.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder addValidation(List<? extends Validation> validations) {
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
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setValidation(List<? extends Validation> validations) {
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
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("taskIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("taskIdentifier")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setTaskIdentifier(TaskIdentifier _taskIdentifier) {
			this.taskIdentifier = _taskIdentifier == null ? null : _taskIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setParty(Party _party) {
			this.party = _party == null ? null : _party.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalMessage")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder setOriginalMessage(UnprocessedElementWrapper _originalMessage) {
			this.originalMessage = _originalMessage == null ? null : _originalMessage.toBuilder();
			return this;
		}
		
		@Override
		public LoanNotificationRetracted build() {
			return new LoanNotificationRetracted.LoanNotificationRetractedImpl(this);
		}
		
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder prune() {
			super.prune();
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			if (taskIdentifier!=null && !taskIdentifier.prune().hasData()) taskIdentifier = null;
			if (party!=null && !party.prune().hasData()) party = null;
			if (originalMessage!=null && !originalMessage.prune().hasData()) originalMessage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			if (getTaskIdentifier()!=null && getTaskIdentifier().hasData()) return true;
			if (getParty()!=null && getParty().hasData()) return true;
			if (getOriginalMessage()!=null && getOriginalMessage().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationRetracted.LoanNotificationRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanNotificationRetracted.LoanNotificationRetractedBuilder o = (LoanNotificationRetracted.LoanNotificationRetractedBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeRosetta(getTaskIdentifier(), o.getTaskIdentifier(), this::setTaskIdentifier);
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			merger.mergeRosetta(getOriginalMessage(), o.getOriginalMessage(), this::setOriginalMessage);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationRetracted _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationRetractedBuilder {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"taskIdentifier=" + this.taskIdentifier + ", " +
				"party=" + this.party + ", " +
				"originalMessage=" + this.originalMessage +
			'}' + " " + super.toString();
		}
	}
}
