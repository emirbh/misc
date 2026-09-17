package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.AbstractServicingNotificationMeta;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import java.time.ZonedDateTime;
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
 * Provision An abstract base type for all syndicated loan servicing notifications; the wrapper for loan events which occur through the life-cycle of a deal.
 *
 */
@RosettaDataType(value="AbstractServicingNotification", builder=AbstractServicingNotification.AbstractServicingNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractServicingNotification", model="fpml", builder=AbstractServicingNotification.AbstractServicingNotificationBuilderImpl.class, version="2.1.1")
public interface AbstractServicingNotification extends CorrectableRequestMessage {

	AbstractServicingNotificationMeta metaData = new AbstractServicingNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The business date on which the notice is valid (and was communicated).
	 *
	 */
	ZonedDateTime getNoticeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether the embedded business event is 'global', i.e. NOT lender specific.
	 *
	 */
	Boolean getIsGlobalOnly();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The payments/wiring instructions associated with all embedded loan events.
	 *
	 */
	List<? extends EventPayment> getEventPayment();

	/*********************** Build Methods  ***********************/
	AbstractServicingNotification build();
	
	AbstractServicingNotification.AbstractServicingNotificationBuilder toBuilder();
	
	static AbstractServicingNotification.AbstractServicingNotificationBuilder builder() {
		return new AbstractServicingNotification.AbstractServicingNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractServicingNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractServicingNotification> getType() {
		return AbstractServicingNotification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
		processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
		processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.class, getEventPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractServicingNotificationBuilder extends AbstractServicingNotification, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		EventPayment.EventPaymentBuilder getOrCreateEventPayment(int index);
		@Override
		List<? extends EventPayment.EventPaymentBuilder> getEventPayment();
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder addValidation(Validation validation);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AbstractServicingNotification.AbstractServicingNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(EventPayment eventPayment);
		AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(EventPayment eventPayment, int idx);
		AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
			processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
			processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.EventPaymentBuilder.class, getEventPayment());
		}
		

		AbstractServicingNotification.AbstractServicingNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractServicingNotification  ***********************/
	class AbstractServicingNotificationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements AbstractServicingNotification {
		private final ZonedDateTime noticeDate;
		private final Boolean isGlobalOnly;
		private final List<? extends EventPayment> eventPayment;
		
		protected AbstractServicingNotificationImpl(AbstractServicingNotification.AbstractServicingNotificationBuilder builder) {
			super(builder);
			this.noticeDate = builder.getNoticeDate();
			this.isGlobalOnly = builder.getIsGlobalOnly();
			this.eventPayment = ofNullable(builder.getEventPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("noticeDate")
		public ZonedDateTime getNoticeDate() {
			return noticeDate;
		}
		
		@Override
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		public Boolean getIsGlobalOnly() {
			return isGlobalOnly;
		}
		
		@Override
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventPayment")
		public List<? extends EventPayment> getEventPayment() {
			return eventPayment;
		}
		
		@Override
		public AbstractServicingNotification build() {
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder toBuilder() {
			AbstractServicingNotification.AbstractServicingNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractServicingNotification.AbstractServicingNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNoticeDate()).ifPresent(builder::setNoticeDate);
			ofNullable(getIsGlobalOnly()).ifPresent(builder::setIsGlobalOnly);
			ofNullable(getEventPayment()).ifPresent(builder::setEventPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractServicingNotification _that = getType().cast(o);
		
			if (!Objects.equals(noticeDate, _that.getNoticeDate())) return false;
			if (!Objects.equals(isGlobalOnly, _that.getIsGlobalOnly())) return false;
			if (!ListEquals.listEquals(eventPayment, _that.getEventPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (noticeDate != null ? noticeDate.hashCode() : 0);
			_result = 31 * _result + (isGlobalOnly != null ? isGlobalOnly.hashCode() : 0);
			_result = 31 * _result + (eventPayment != null ? eventPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractServicingNotification {" +
				"noticeDate=" + this.noticeDate + ", " +
				"isGlobalOnly=" + this.isGlobalOnly + ", " +
				"eventPayment=" + this.eventPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractServicingNotification  ***********************/
	class AbstractServicingNotificationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements AbstractServicingNotification.AbstractServicingNotificationBuilder {
	
		protected ZonedDateTime noticeDate;
		protected Boolean isGlobalOnly;
		protected List<EventPayment.EventPaymentBuilder> eventPayment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("noticeDate")
		public ZonedDateTime getNoticeDate() {
			return noticeDate;
		}
		
		@Override
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		public Boolean getIsGlobalOnly() {
			return isGlobalOnly;
		}
		
		@Override
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventPayment")
		public List<? extends EventPayment.EventPaymentBuilder> getEventPayment() {
			return eventPayment;
		}
		
		@Override
		public EventPayment.EventPaymentBuilder getOrCreateEventPayment(int index) {
			if (eventPayment==null) {
				this.eventPayment = new ArrayList<>();
			}
			return getIndex(eventPayment, index, () -> {
						EventPayment.EventPaymentBuilder newEventPayment = EventPayment.builder();
						return newEventPayment;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCorrection")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("noticeDate")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setIsGlobalOnly(Boolean _isGlobalOnly) {
			this.isGlobalOnly = _isGlobalOnly == null ? null : _isGlobalOnly;
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(EventPayment _eventPayment) {
			if (_eventPayment != null) {
				this.eventPayment.add(_eventPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(EventPayment _eventPayment, int idx) {
			getIndex(this.eventPayment, idx, () -> _eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (final EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments == null) {
				this.eventPayment = new ArrayList<>();
			} else {
				this.eventPayment = eventPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AbstractServicingNotification build() {
			return new AbstractServicingNotification.AbstractServicingNotificationImpl(this);
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder prune() {
			super.prune();
			eventPayment = eventPayment.stream().filter(b->b!=null).<EventPayment.EventPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNoticeDate()!=null) return true;
			if (getIsGlobalOnly()!=null) return true;
			if (getEventPayment()!=null && getEventPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractServicingNotification.AbstractServicingNotificationBuilder o = (AbstractServicingNotification.AbstractServicingNotificationBuilder) other;
			
			merger.mergeRosetta(getEventPayment(), o.getEventPayment(), this::getOrCreateEventPayment);
			
			merger.mergeBasic(getNoticeDate(), o.getNoticeDate(), this::setNoticeDate);
			merger.mergeBasic(getIsGlobalOnly(), o.getIsGlobalOnly(), this::setIsGlobalOnly);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractServicingNotification _that = getType().cast(o);
		
			if (!Objects.equals(noticeDate, _that.getNoticeDate())) return false;
			if (!Objects.equals(isGlobalOnly, _that.getIsGlobalOnly())) return false;
			if (!ListEquals.listEquals(eventPayment, _that.getEventPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (noticeDate != null ? noticeDate.hashCode() : 0);
			_result = 31 * _result + (isGlobalOnly != null ? isGlobalOnly.hashCode() : 0);
			_result = 31 * _result + (eventPayment != null ? eventPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractServicingNotificationBuilder {" +
				"noticeDate=" + this.noticeDate + ", " +
				"isGlobalOnly=" + this.isGlobalOnly + ", " +
				"eventPayment=" + this.eventPayment +
			'}' + " " + super.toString();
		}
	}
}
