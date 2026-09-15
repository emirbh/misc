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
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.meta.AbstractFacilityContractEventMeta;
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
 * Provision An abstract base type for all facility and optionally contract-level business events.
 *
 */
@RosettaDataType(value="AbstractFacilityContractEvent", builder=AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractFacilityContractEvent", model="fpml", builder=AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl.class, version="2.1.1")
public interface AbstractFacilityContractEvent extends AbstractFacilityEvent {

	AbstractFacilityContractEventMeta metaData = new AbstractFacilityContractEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A loan contract reference structure.
	 *
	 */
	List<? extends LoanContractReference> getLoanContractReference();

	/*********************** Build Methods  ***********************/
	AbstractFacilityContractEvent build();
	
	AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder toBuilder();
	
	static AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder builder() {
		return new AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacilityContractEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractFacilityContractEvent> getType() {
		return AbstractFacilityContractEvent.class;
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
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractFacilityContractEventBuilder extends AbstractFacilityContractEvent, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference(int index);
		@Override
		List<? extends LoanContractReference.LoanContractReferenceBuilder> getLoanContractReference();
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setComment(String comment);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setFacilityReference(FacilityReference facilityReference);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(LoanContractReference loanContractReference);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(LoanContractReference loanContractReference, int idx);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference);

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
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
		}
		

		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacilityContractEvent  ***********************/
	class AbstractFacilityContractEventImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AbstractFacilityContractEvent {
		private final List<? extends LoanContractReference> loanContractReference;
		
		protected AbstractFacilityContractEventImpl(AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder builder) {
			super(builder);
			this.loanContractReference = ofNullable(builder.getLoanContractReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanContractReference")
		public List<? extends LoanContractReference> getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public AbstractFacilityContractEvent build() {
			return this;
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder toBuilder() {
			AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanContractReference()).ifPresent(builder::setLoanContractReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityContractEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityContractEvent {" +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFacilityContractEvent  ***********************/
	class AbstractFacilityContractEventBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl implements AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
	
		protected List<LoanContractReference.LoanContractReferenceBuilder> loanContractReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanContractReference")
		public List<? extends LoanContractReference.LoanContractReferenceBuilder> getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference(int index) {
			if (loanContractReference==null) {
				this.loanContractReference = new ArrayList<>();
			}
			return getIndex(loanContractReference, index, () -> {
						LoanContractReference.LoanContractReferenceBuilder newLoanContractReference = LoanContractReference.builder();
						return newLoanContractReference;
					});
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanContractReference")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(LoanContractReference _loanContractReference) {
			if (_loanContractReference != null) {
				this.loanContractReference.add(_loanContractReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(LoanContractReference _loanContractReference, int idx) {
			getIndex(this.loanContractReference, idx, () -> _loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (final LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanContractReference")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences == null) {
				this.loanContractReference = new ArrayList<>();
			} else {
				this.loanContractReference = loanContractReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AbstractFacilityContractEvent build() {
			return new AbstractFacilityContractEvent.AbstractFacilityContractEventImpl(this);
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder prune() {
			super.prune();
			loanContractReference = loanContractReference.stream().filter(b->b!=null).<LoanContractReference.LoanContractReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanContractReference()!=null && getLoanContractReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder o = (AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder) other;
			
			merger.mergeRosetta(getLoanContractReference(), o.getLoanContractReference(), this::getOrCreateLoanContractReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityContractEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityContractEventBuilder {" +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}
}
