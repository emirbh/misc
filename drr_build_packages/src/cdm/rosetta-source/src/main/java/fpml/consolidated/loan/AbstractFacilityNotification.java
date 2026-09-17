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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.AbstractFacilityNotificationMeta;
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
 * Provision An extension of the AbstractServicingNotification which includes a reference to the facility to which embedded loan events apply. This abtract type should be used to 'wrap' facility-level business events.
 *
 */
@RosettaDataType(value="AbstractFacilityNotification", builder=AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractFacilityNotification", model="fpml", builder=AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl.class, version="2.1.1")
public interface AbstractFacilityNotification extends AbstractServicingNotification {

	AbstractFacilityNotificationMeta metaData = new AbstractFacilityNotificationMeta();

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
	FacilityPosition getFacilityPosition();

	/*********************** Build Methods  ***********************/
	AbstractFacilityNotification build();
	
	AbstractFacilityNotification.AbstractFacilityNotificationBuilder toBuilder();
	
	static AbstractFacilityNotification.AbstractFacilityNotificationBuilder builder() {
		return new AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacilityNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractFacilityNotification> getType() {
		return AbstractFacilityNotification.class;
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
		processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.class, getFacilityPosition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractFacilityNotificationBuilder extends AbstractFacilityNotification, AbstractServicingNotification.AbstractServicingNotificationBuilder {
		FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition();
		@Override
		FacilityPosition.FacilityPositionBuilder getFacilityPosition();
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addValidation(Validation validation);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(EventPayment eventPayment);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(EventPayment eventPayment, int idx);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition);

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
			processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.FacilityPositionBuilder.class, getFacilityPosition());
		}
		

		AbstractFacilityNotification.AbstractFacilityNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacilityNotification  ***********************/
	class AbstractFacilityNotificationImpl extends AbstractServicingNotification.AbstractServicingNotificationImpl implements AbstractFacilityNotification {
		private final FacilityPosition facilityPosition;
		
		protected AbstractFacilityNotificationImpl(AbstractFacilityNotification.AbstractFacilityNotificationBuilder builder) {
			super(builder);
			this.facilityPosition = ofNullable(builder.getFacilityPosition()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityPosition")
		public FacilityPosition getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public AbstractFacilityNotification build() {
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder toBuilder() {
			AbstractFacilityNotification.AbstractFacilityNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacilityNotification.AbstractFacilityNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityPosition()).ifPresent(builder::setFacilityPosition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityNotification {" +
				"facilityPosition=" + this.facilityPosition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFacilityNotification  ***********************/
	class AbstractFacilityNotificationBuilderImpl extends AbstractServicingNotification.AbstractServicingNotificationBuilderImpl implements AbstractFacilityNotification.AbstractFacilityNotificationBuilder {
	
		protected FacilityPosition.FacilityPositionBuilder facilityPosition;
		
		@Override
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityPosition")
		public FacilityPosition.FacilityPositionBuilder getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition() {
			FacilityPosition.FacilityPositionBuilder result;
			if (facilityPosition!=null) {
				result = facilityPosition;
			}
			else {
				result = facilityPosition = FacilityPosition.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setIsGlobalOnly(Boolean _isGlobalOnly) {
			this.isGlobalOnly = _isGlobalOnly == null ? null : _isGlobalOnly;
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(EventPayment _eventPayment) {
			if (_eventPayment != null) {
				this.eventPayment.add(_eventPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(EventPayment _eventPayment, int idx) {
			getIndex(this.eventPayment, idx, () -> _eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
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
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments == null) {
				this.eventPayment = new ArrayList<>();
			} else {
				this.eventPayment = eventPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityPosition")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setFacilityPosition(FacilityPosition _facilityPosition) {
			this.facilityPosition = _facilityPosition == null ? null : _facilityPosition.toBuilder();
			return this;
		}
		
		@Override
		public AbstractFacilityNotification build() {
			return new AbstractFacilityNotification.AbstractFacilityNotificationImpl(this);
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder prune() {
			super.prune();
			if (facilityPosition!=null && !facilityPosition.prune().hasData()) facilityPosition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityPosition()!=null && getFacilityPosition().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractFacilityNotification.AbstractFacilityNotificationBuilder o = (AbstractFacilityNotification.AbstractFacilityNotificationBuilder) other;
			
			merger.mergeRosetta(getFacilityPosition(), o.getFacilityPosition(), this::setFacilityPosition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityNotificationBuilder {" +
				"facilityPosition=" + this.facilityPosition +
			'}' + " " + super.toString();
		}
	}
}
