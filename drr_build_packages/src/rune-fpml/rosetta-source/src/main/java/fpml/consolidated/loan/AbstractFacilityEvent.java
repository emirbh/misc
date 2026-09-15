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
import fpml.consolidated.loan.meta.AbstractFacilityEventMeta;
import fpml.consolidated.shared.PartyReference;
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
 * Provision An abstract base type for all facility-level business events.
 *
 */
@RosettaDataType(value="AbstractFacilityEvent", builder=AbstractFacilityEvent.AbstractFacilityEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractFacilityEvent", model="fpml", builder=AbstractFacilityEvent.AbstractFacilityEventBuilderImpl.class, version="2.1.1")
public interface AbstractFacilityEvent extends AbstractLoanServicingEvent {

	AbstractFacilityEventMeta metaData = new AbstractFacilityEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a facility.
	 *
	 */
	FacilityReference getFacilityReference();

	/*********************** Build Methods  ***********************/
	AbstractFacilityEvent build();
	
	AbstractFacilityEvent.AbstractFacilityEventBuilder toBuilder();
	
	static AbstractFacilityEvent.AbstractFacilityEventBuilder builder() {
		return new AbstractFacilityEvent.AbstractFacilityEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacilityEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractFacilityEvent> getType() {
		return AbstractFacilityEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.class, getPreviousEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.class, getLenderPartyReference());
		processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.class, getCashPayable());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.class, getLegalActionReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractFacilityEventBuilder extends AbstractFacilityEvent, AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder {
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		@Override
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setComment(String comment);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		AbstractFacilityEvent.AbstractFacilityEventBuilder setFacilityReference(FacilityReference facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.ParentEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getPreviousEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.CashPayableBuilder.class, getCashPayable());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.LoanLegalActionReferenceBuilder.class, getLegalActionReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		AbstractFacilityEvent.AbstractFacilityEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacilityEvent  ***********************/
	class AbstractFacilityEventImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventImpl implements AbstractFacilityEvent {
		private final FacilityReference facilityReference;
		
		protected AbstractFacilityEventImpl(AbstractFacilityEvent.AbstractFacilityEventBuilder builder) {
			super(builder);
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public AbstractFacilityEvent build() {
			return this;
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder toBuilder() {
			AbstractFacilityEvent.AbstractFacilityEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacilityEvent.AbstractFacilityEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityEvent _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityEvent {" +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFacilityEvent  ***********************/
	class AbstractFacilityEventBuilderImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl implements AbstractFacilityEvent.AbstractFacilityEventBuilder {
	
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentEventIdentifier")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@Override
		public AbstractFacilityEvent build() {
			return new AbstractFacilityEvent.AbstractFacilityEventImpl(this);
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder prune() {
			super.prune();
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractFacilityEvent.AbstractFacilityEventBuilder o = (AbstractFacilityEvent.AbstractFacilityEventBuilder) other;
			
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityEvent _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityEventBuilder {" +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}
}
