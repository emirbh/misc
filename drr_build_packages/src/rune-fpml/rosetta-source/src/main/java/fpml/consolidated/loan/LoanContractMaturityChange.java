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
import fpml.consolidated.loan.meta.LoanContractMaturityChangeMeta;
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
 * Provision An event representing a change of maturity date on a one or more outstanding loan contracts.
 *
 */
@RosettaDataType(value="LoanContractMaturityChange", builder=LoanContractMaturityChange.LoanContractMaturityChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanContractMaturityChange", model="fpml", builder=LoanContractMaturityChange.LoanContractMaturityChangeBuilderImpl.class, version="2.1.1")
public interface LoanContractMaturityChange extends AbstractLoanContractEvent {

	LoanContractMaturityChangeMeta metaData = new LoanContractMaturityChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The new loan contract maturity date.
	 *
	 */
	ZonedDateTime getCurrentMaturityDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The previous loan contract maturity date.
	 *
	 */
	ZonedDateTime getPriorMaturityDate();

	/*********************** Build Methods  ***********************/
	LoanContractMaturityChange build();
	
	LoanContractMaturityChange.LoanContractMaturityChangeBuilder toBuilder();
	
	static LoanContractMaturityChange.LoanContractMaturityChangeBuilder builder() {
		return new LoanContractMaturityChange.LoanContractMaturityChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractMaturityChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanContractMaturityChange> getType() {
		return LoanContractMaturityChange.class;
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
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processor.processBasic(path.newSubPath("currentMaturityDate"), ZonedDateTime.class, getCurrentMaturityDate(), this);
		processor.processBasic(path.newSubPath("priorMaturityDate"), ZonedDateTime.class, getPriorMaturityDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractMaturityChangeBuilder extends LoanContractMaturityChange, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setComment(String comment);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLoanContractReference(LoanContractReference loanContractReference);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCurrentMaturityDate(ZonedDateTime currentMaturityDate);
		LoanContractMaturityChange.LoanContractMaturityChangeBuilder setPriorMaturityDate(ZonedDateTime priorMaturityDate);

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
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processor.processBasic(path.newSubPath("currentMaturityDate"), ZonedDateTime.class, getCurrentMaturityDate(), this);
			processor.processBasic(path.newSubPath("priorMaturityDate"), ZonedDateTime.class, getPriorMaturityDate(), this);
		}
		

		LoanContractMaturityChange.LoanContractMaturityChangeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractMaturityChange  ***********************/
	class LoanContractMaturityChangeImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements LoanContractMaturityChange {
		private final ZonedDateTime currentMaturityDate;
		private final ZonedDateTime priorMaturityDate;
		
		protected LoanContractMaturityChangeImpl(LoanContractMaturityChange.LoanContractMaturityChangeBuilder builder) {
			super(builder);
			this.currentMaturityDate = builder.getCurrentMaturityDate();
			this.priorMaturityDate = builder.getPriorMaturityDate();
		}
		
		@Override
		@RosettaAttribute("currentMaturityDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currentMaturityDate")
		public ZonedDateTime getCurrentMaturityDate() {
			return currentMaturityDate;
		}
		
		@Override
		@RosettaAttribute("priorMaturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorMaturityDate")
		public ZonedDateTime getPriorMaturityDate() {
			return priorMaturityDate;
		}
		
		@Override
		public LoanContractMaturityChange build() {
			return this;
		}
		
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder toBuilder() {
			LoanContractMaturityChange.LoanContractMaturityChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractMaturityChange.LoanContractMaturityChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrentMaturityDate()).ifPresent(builder::setCurrentMaturityDate);
			ofNullable(getPriorMaturityDate()).ifPresent(builder::setPriorMaturityDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractMaturityChange _that = getType().cast(o);
		
			if (!Objects.equals(currentMaturityDate, _that.getCurrentMaturityDate())) return false;
			if (!Objects.equals(priorMaturityDate, _that.getPriorMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currentMaturityDate != null ? currentMaturityDate.hashCode() : 0);
			_result = 31 * _result + (priorMaturityDate != null ? priorMaturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractMaturityChange {" +
				"currentMaturityDate=" + this.currentMaturityDate + ", " +
				"priorMaturityDate=" + this.priorMaturityDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractMaturityChange  ***********************/
	class LoanContractMaturityChangeBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl implements LoanContractMaturityChange.LoanContractMaturityChangeBuilder {
	
		protected ZonedDateTime currentMaturityDate;
		protected ZonedDateTime priorMaturityDate;
		
		@Override
		@RosettaAttribute("currentMaturityDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currentMaturityDate")
		public ZonedDateTime getCurrentMaturityDate() {
			return currentMaturityDate;
		}
		
		@Override
		@RosettaAttribute("priorMaturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorMaturityDate")
		public ZonedDateTime getPriorMaturityDate() {
			return priorMaturityDate;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractReference")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currentMaturityDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentMaturityDate")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setCurrentMaturityDate(ZonedDateTime _currentMaturityDate) {
			this.currentMaturityDate = _currentMaturityDate == null ? null : _currentMaturityDate;
			return this;
		}
		
		@RosettaAttribute("priorMaturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorMaturityDate")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder setPriorMaturityDate(ZonedDateTime _priorMaturityDate) {
			this.priorMaturityDate = _priorMaturityDate == null ? null : _priorMaturityDate;
			return this;
		}
		
		@Override
		public LoanContractMaturityChange build() {
			return new LoanContractMaturityChange.LoanContractMaturityChangeImpl(this);
		}
		
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrentMaturityDate()!=null) return true;
			if (getPriorMaturityDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractMaturityChange.LoanContractMaturityChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanContractMaturityChange.LoanContractMaturityChangeBuilder o = (LoanContractMaturityChange.LoanContractMaturityChangeBuilder) other;
			
			
			merger.mergeBasic(getCurrentMaturityDate(), o.getCurrentMaturityDate(), this::setCurrentMaturityDate);
			merger.mergeBasic(getPriorMaturityDate(), o.getPriorMaturityDate(), this::setPriorMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractMaturityChange _that = getType().cast(o);
		
			if (!Objects.equals(currentMaturityDate, _that.getCurrentMaturityDate())) return false;
			if (!Objects.equals(priorMaturityDate, _that.getPriorMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currentMaturityDate != null ? currentMaturityDate.hashCode() : 0);
			_result = 31 * _result + (priorMaturityDate != null ? priorMaturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractMaturityChangeBuilder {" +
				"currentMaturityDate=" + this.currentMaturityDate + ", " +
				"priorMaturityDate=" + this.priorMaturityDate +
			'}' + " " + super.toString();
		}
	}
}
