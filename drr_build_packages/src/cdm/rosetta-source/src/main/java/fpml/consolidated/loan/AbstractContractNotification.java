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
import fpml.consolidated.loan.meta.AbstractContractNotificationMeta;
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
 * Provision An extension of the AbstractServicingNotification which includes a reference to the facility and the loan contract to which embedded loan events apply. This abtract type should be used to 'wrap' contract-level business events.
 *
 */
@RosettaDataType(value="AbstractContractNotification", builder=AbstractContractNotification.AbstractContractNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractContractNotification", model="fpml", builder=AbstractContractNotification.AbstractContractNotificationBuilderImpl.class, version="2.1.1")
public interface AbstractContractNotification extends AbstractServicingNotification {

	AbstractContractNotificationMeta metaData = new AbstractContractNotificationMeta();

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
	List<? extends FacilityPosition> getFacilityPosition();

	/*********************** Build Methods  ***********************/
	AbstractContractNotification build();
	
	AbstractContractNotification.AbstractContractNotificationBuilder toBuilder();
	
	static AbstractContractNotification.AbstractContractNotificationBuilder builder() {
		return new AbstractContractNotification.AbstractContractNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractContractNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractContractNotification> getType() {
		return AbstractContractNotification.class;
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
	interface AbstractContractNotificationBuilder extends AbstractContractNotification, AbstractServicingNotification.AbstractServicingNotificationBuilder {
		FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition(int index);
		@Override
		List<? extends FacilityPosition.FacilityPositionBuilder> getFacilityPosition();
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addValidation(Validation validation);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(EventPayment eventPayment);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(EventPayment eventPayment, int idx);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		AbstractContractNotification.AbstractContractNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment);
		AbstractContractNotification.AbstractContractNotificationBuilder addFacilityPosition(FacilityPosition facilityPosition);
		AbstractContractNotification.AbstractContractNotificationBuilder addFacilityPosition(FacilityPosition facilityPosition, int idx);
		AbstractContractNotification.AbstractContractNotificationBuilder addFacilityPosition(List<? extends FacilityPosition> facilityPosition);
		AbstractContractNotification.AbstractContractNotificationBuilder setFacilityPosition(List<? extends FacilityPosition> facilityPosition);

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
		

		AbstractContractNotification.AbstractContractNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractContractNotification  ***********************/
	class AbstractContractNotificationImpl extends AbstractServicingNotification.AbstractServicingNotificationImpl implements AbstractContractNotification {
		private final List<? extends FacilityPosition> facilityPosition;
		
		protected AbstractContractNotificationImpl(AbstractContractNotification.AbstractContractNotificationBuilder builder) {
			super(builder);
			this.facilityPosition = ofNullable(builder.getFacilityPosition()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityPosition")
		public List<? extends FacilityPosition> getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public AbstractContractNotification build() {
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder toBuilder() {
			AbstractContractNotification.AbstractContractNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractContractNotification.AbstractContractNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityPosition()).ifPresent(builder::setFacilityPosition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractContractNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(facilityPosition, _that.getFacilityPosition())) return false;
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
			return "AbstractContractNotification {" +
				"facilityPosition=" + this.facilityPosition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractContractNotification  ***********************/
	class AbstractContractNotificationBuilderImpl extends AbstractServicingNotification.AbstractServicingNotificationBuilderImpl implements AbstractContractNotification.AbstractContractNotificationBuilder {
	
		protected List<FacilityPosition.FacilityPositionBuilder> facilityPosition = new ArrayList<>();
		
		@Override
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityPosition")
		public List<? extends FacilityPosition.FacilityPositionBuilder> getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition(int index) {
			if (facilityPosition==null) {
				this.facilityPosition = new ArrayList<>();
			}
			return getIndex(facilityPosition, index, () -> {
						FacilityPosition.FacilityPositionBuilder newFacilityPosition = FacilityPosition.builder();
						return newFacilityPosition;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public AbstractContractNotification.AbstractContractNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public AbstractContractNotification.AbstractContractNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractContractNotification.AbstractContractNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractContractNotification.AbstractContractNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AbstractContractNotification.AbstractContractNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AbstractContractNotification.AbstractContractNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder setIsGlobalOnly(Boolean _isGlobalOnly) {
			this.isGlobalOnly = _isGlobalOnly == null ? null : _isGlobalOnly;
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(EventPayment _eventPayment) {
			if (_eventPayment != null) {
				this.eventPayment.add(_eventPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(EventPayment _eventPayment, int idx) {
			getIndex(this.eventPayment, idx, () -> _eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
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
		public AbstractContractNotification.AbstractContractNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityPosition")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addFacilityPosition(FacilityPosition _facilityPosition) {
			if (_facilityPosition != null) {
				this.facilityPosition.add(_facilityPosition.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addFacilityPosition(FacilityPosition _facilityPosition, int idx) {
			getIndex(this.facilityPosition, idx, () -> _facilityPosition.toBuilder());
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addFacilityPosition(List<? extends FacilityPosition> facilityPositions) {
			if (facilityPositions != null) {
				for (final FacilityPosition toAdd : facilityPositions) {
					this.facilityPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityPosition")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder setFacilityPosition(List<? extends FacilityPosition> facilityPositions) {
			if (facilityPositions == null) {
				this.facilityPosition = new ArrayList<>();
			} else {
				this.facilityPosition = facilityPositions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AbstractContractNotification build() {
			return new AbstractContractNotification.AbstractContractNotificationImpl(this);
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder prune() {
			super.prune();
			facilityPosition = facilityPosition.stream().filter(b->b!=null).<FacilityPosition.FacilityPositionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityPosition()!=null && getFacilityPosition().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractContractNotification.AbstractContractNotificationBuilder o = (AbstractContractNotification.AbstractContractNotificationBuilder) other;
			
			merger.mergeRosetta(getFacilityPosition(), o.getFacilityPosition(), this::getOrCreateFacilityPosition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractContractNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(facilityPosition, _that.getFacilityPosition())) return false;
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
			return "AbstractContractNotificationBuilder {" +
				"facilityPosition=" + this.facilityPosition +
			'}' + " " + super.toString();
		}
	}
}
