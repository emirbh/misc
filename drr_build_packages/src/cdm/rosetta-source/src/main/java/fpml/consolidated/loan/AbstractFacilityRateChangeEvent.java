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
import fpml.consolidated.loan.meta.AbstractFacilityRateChangeEventMeta;
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
 * Provision An abstract type describing changes in a facility-level rate.
 *
 */
@RosettaDataType(value="AbstractFacilityRateChangeEvent", builder=AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractFacilityRateChangeEvent", model="fpml", builder=AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilderImpl.class, version="2.1.1")
public interface AbstractFacilityRateChangeEvent extends AbstractFacilityContractEvent {

	AbstractFacilityRateChangeEventMeta metaData = new AbstractFacilityRateChangeEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This represents a 'surcharge' rate that may apply in addition to a regular margin (on outstanding loan contracts).
	 *
	 */
	PeriodRate getRate();

	/*********************** Build Methods  ***********************/
	AbstractFacilityRateChangeEvent build();
	
	AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder toBuilder();
	
	static AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder builder() {
		return new AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacilityRateChangeEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractFacilityRateChangeEvent> getType() {
		return AbstractFacilityRateChangeEvent.class;
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
		processRosetta(path.newSubPath("rate"), processor, PeriodRate.class, getRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractFacilityRateChangeEventBuilder extends AbstractFacilityRateChangeEvent, AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
		PeriodRate.PeriodRateBuilder getOrCreateRate();
		@Override
		PeriodRate.PeriodRateBuilder getRate();
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setComment(String comment);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setFacilityReference(FacilityReference facilityReference);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addLoanContractReference(LoanContractReference loanContractReference);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addLoanContractReference(LoanContractReference loanContractReference, int idx);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference);
		@Override
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference);
		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setRate(PeriodRate rate);

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
			processRosetta(path.newSubPath("rate"), processor, PeriodRate.PeriodRateBuilder.class, getRate());
		}
		

		AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacilityRateChangeEvent  ***********************/
	class AbstractFacilityRateChangeEventImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventImpl implements AbstractFacilityRateChangeEvent {
		private final PeriodRate rate;
		
		protected AbstractFacilityRateChangeEventImpl(AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder builder) {
			super(builder);
			this.rate = ofNullable(builder.getRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public PeriodRate getRate() {
			return rate;
		}
		
		@Override
		public AbstractFacilityRateChangeEvent build() {
			return this;
		}
		
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder toBuilder() {
			AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityRateChangeEvent _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityRateChangeEvent {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFacilityRateChangeEvent  ***********************/
	class AbstractFacilityRateChangeEventBuilderImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl implements AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder {
	
		protected PeriodRate.PeriodRateBuilder rate;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public PeriodRate.PeriodRateBuilder getRate() {
			return rate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreateRate() {
			PeriodRate.PeriodRateBuilder result;
			if (rate!=null) {
				result = rate;
			}
			else {
				result = rate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanContractReference")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addLoanContractReference(LoanContractReference _loanContractReference) {
			if (_loanContractReference != null) {
				this.loanContractReference.add(_loanContractReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addLoanContractReference(LoanContractReference _loanContractReference, int idx) {
			getIndex(this.loanContractReference, idx, () -> _loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences == null) {
				this.loanContractReference = new ArrayList<>();
			} else {
				this.loanContractReference = loanContractReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder setRate(PeriodRate _rate) {
			this.rate = _rate == null ? null : _rate.toBuilder();
			return this;
		}
		
		@Override
		public AbstractFacilityRateChangeEvent build() {
			return new AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventImpl(this);
		}
		
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder prune() {
			super.prune();
			if (rate!=null && !rate.prune().hasData()) rate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null && getRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder o = (AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder) other;
			
			merger.mergeRosetta(getRate(), o.getRate(), this::setRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityRateChangeEvent _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityRateChangeEventBuilder {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}
}
