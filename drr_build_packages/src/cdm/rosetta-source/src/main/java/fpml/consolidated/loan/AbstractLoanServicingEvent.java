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
import fpml.consolidated.loan.meta.AbstractLoanServicingEventMeta;
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
 * Provision An abstract base type defining common features of a syndicated loan servicing business event. Such events are originated by the borrower and are required to be communicated to the lender syndicate by agents.
 *
 */
@RosettaDataType(value="AbstractLoanServicingEvent", builder=AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanServicingEvent", model="fpml", builder=AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl.class, version="2.1.1")
public interface AbstractLoanServicingEvent extends AbstractLoanEvent {

	AbstractLoanServicingEventMeta metaData = new AbstractLoanServicingEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the agent bank for the associated deal.
	 *
	 */
	PartyReference getAgentPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the main borrower associated with the specific business event.
	 *
	 */
	PartyReference getBorrowerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the associated business event is effective.
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a legal action.
	 *
	 */
	LoanLegalActionReference getLegalActionReference();

	/*********************** Build Methods  ***********************/
	AbstractLoanServicingEvent build();
	
	AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder toBuilder();
	
	static AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder builder() {
		return new AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanServicingEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanServicingEvent> getType() {
		return AbstractLoanServicingEvent.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanServicingEventBuilder extends AbstractLoanServicingEvent, AbstractLoanEvent.AbstractLoanEventBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getAgentPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBorrowerPartyReference();
		LoanLegalActionReference.LoanLegalActionReferenceBuilder getOrCreateLegalActionReference();
		@Override
		LoanLegalActionReference.LoanLegalActionReferenceBuilder getLegalActionReference();
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setComment(String comment);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setAgentPartyReference(PartyReference agentPartyReference);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);

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
		}
		

		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanServicingEvent  ***********************/
	class AbstractLoanServicingEventImpl extends AbstractLoanEvent.AbstractLoanEventImpl implements AbstractLoanServicingEvent {
		private final PartyReference agentPartyReference;
		private final PartyReference borrowerPartyReference;
		private final ZonedDateTime effectiveDate;
		private final LoanLegalActionReference legalActionReference;
		
		protected AbstractLoanServicingEventImpl(AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder builder) {
			super(builder);
			this.agentPartyReference = ofNullable(builder.getAgentPartyReference()).map(f->f.build()).orElse(null);
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.legalActionReference = ofNullable(builder.getLegalActionReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agentPartyReference")
		public PartyReference getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("borrowerPartyReference")
		public PartyReference getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionReference")
		public LoanLegalActionReference getLegalActionReference() {
			return legalActionReference;
		}
		
		@Override
		public AbstractLoanServicingEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder toBuilder() {
			AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAgentPartyReference()).ifPresent(builder::setAgentPartyReference);
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getLegalActionReference()).ifPresent(builder::setLegalActionReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanServicingEvent _that = getType().cast(o);
		
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(legalActionReference, _that.getLegalActionReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (legalActionReference != null ? legalActionReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanServicingEvent {" +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"legalActionReference=" + this.legalActionReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanServicingEvent  ***********************/
	class AbstractLoanServicingEventBuilderImpl extends AbstractLoanEvent.AbstractLoanEventBuilderImpl implements AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder {
	
		protected PartyReference.PartyReferenceBuilder agentPartyReference;
		protected PartyReference.PartyReferenceBuilder borrowerPartyReference;
		protected ZonedDateTime effectiveDate;
		protected LoanLegalActionReference.LoanLegalActionReferenceBuilder legalActionReference;
		
		@Override
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agentPartyReference")
		public PartyReference.PartyReferenceBuilder getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (agentPartyReference!=null) {
				result = agentPartyReference;
			}
			else {
				result = agentPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("borrowerPartyReference")
		public PartyReference.PartyReferenceBuilder getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (borrowerPartyReference!=null) {
				result = borrowerPartyReference;
			}
			else {
				result = borrowerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionReference")
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder getLegalActionReference() {
			return legalActionReference;
		}
		
		@Override
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder getOrCreateLegalActionReference() {
			LoanLegalActionReference.LoanLegalActionReferenceBuilder result;
			if (legalActionReference!=null) {
				result = legalActionReference;
			}
			else {
				result = legalActionReference = LoanLegalActionReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLoanServicingEvent build() {
			return new AbstractLoanServicingEvent.AbstractLoanServicingEventImpl(this);
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder prune() {
			super.prune();
			if (agentPartyReference!=null && !agentPartyReference.prune().hasData()) agentPartyReference = null;
			if (borrowerPartyReference!=null && !borrowerPartyReference.prune().hasData()) borrowerPartyReference = null;
			if (legalActionReference!=null && !legalActionReference.prune().hasData()) legalActionReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAgentPartyReference()!=null && getAgentPartyReference().hasData()) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getLegalActionReference()!=null && getLegalActionReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder o = (AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder) other;
			
			merger.mergeRosetta(getAgentPartyReference(), o.getAgentPartyReference(), this::setAgentPartyReference);
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::setBorrowerPartyReference);
			merger.mergeRosetta(getLegalActionReference(), o.getLegalActionReference(), this::setLegalActionReference);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanServicingEvent _that = getType().cast(o);
		
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(legalActionReference, _that.getLegalActionReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (legalActionReference != null ? legalActionReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanServicingEventBuilder {" +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"legalActionReference=" + this.legalActionReference +
			'}' + " " + super.toString();
		}
	}
}
