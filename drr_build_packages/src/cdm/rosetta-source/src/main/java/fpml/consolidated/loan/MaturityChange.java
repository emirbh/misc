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
import fpml.consolidated.loan.meta.MaturityChangeMeta;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="MaturityChange", builder=MaturityChange.MaturityChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MaturityChange", model="fpml", builder=MaturityChange.MaturityChangeBuilderImpl.class, version="2.1.1")
public interface MaturityChange extends LoanContractMaturityChange {

	MaturityChangeMeta metaData = new MaturityChangeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MaturityChange build();
	
	MaturityChange.MaturityChangeBuilder toBuilder();
	
	static MaturityChange.MaturityChangeBuilder builder() {
		return new MaturityChange.MaturityChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MaturityChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MaturityChange> getType() {
		return MaturityChange.class;
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
	interface MaturityChangeBuilder extends MaturityChange, LoanContractMaturityChange.LoanContractMaturityChangeBuilder {
		@Override
		MaturityChange.MaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		MaturityChange.MaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		MaturityChange.MaturityChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		MaturityChange.MaturityChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		MaturityChange.MaturityChangeBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		MaturityChange.MaturityChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		MaturityChange.MaturityChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		MaturityChange.MaturityChangeBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		MaturityChange.MaturityChangeBuilder setCashPayable(CashPayable cashPayable);
		@Override
		MaturityChange.MaturityChangeBuilder setComment(String comment);
		@Override
		MaturityChange.MaturityChangeBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		MaturityChange.MaturityChangeBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		MaturityChange.MaturityChangeBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		MaturityChange.MaturityChangeBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		MaturityChange.MaturityChangeBuilder setLoanContractReference(LoanContractReference loanContractReference);
		@Override
		MaturityChange.MaturityChangeBuilder setCurrentMaturityDate(ZonedDateTime currentMaturityDate);
		@Override
		MaturityChange.MaturityChangeBuilder setPriorMaturityDate(ZonedDateTime priorMaturityDate);

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
		

		MaturityChange.MaturityChangeBuilder prune();
	}

	/*********************** Immutable Implementation of MaturityChange  ***********************/
	class MaturityChangeImpl extends LoanContractMaturityChange.LoanContractMaturityChangeImpl implements MaturityChange {
		
		protected MaturityChangeImpl(MaturityChange.MaturityChangeBuilder builder) {
			super(builder);
		}
		
		@Override
		public MaturityChange build() {
			return this;
		}
		
		@Override
		public MaturityChange.MaturityChangeBuilder toBuilder() {
			MaturityChange.MaturityChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MaturityChange.MaturityChangeBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaturityChange {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MaturityChange  ***********************/
	class MaturityChangeBuilderImpl extends LoanContractMaturityChange.LoanContractMaturityChangeBuilderImpl implements MaturityChange.MaturityChangeBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public MaturityChange.MaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public MaturityChange.MaturityChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public MaturityChange.MaturityChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MaturityChange.MaturityChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MaturityChange.MaturityChangeBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public MaturityChange.MaturityChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public MaturityChange.MaturityChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public MaturityChange.MaturityChangeBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public MaturityChange.MaturityChangeBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public MaturityChange.MaturityChangeBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public MaturityChange.MaturityChangeBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public MaturityChange.MaturityChangeBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public MaturityChange.MaturityChangeBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public MaturityChange.MaturityChangeBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractReference")
		@Override
		public MaturityChange.MaturityChangeBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currentMaturityDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentMaturityDate")
		@Override
		public MaturityChange.MaturityChangeBuilder setCurrentMaturityDate(ZonedDateTime _currentMaturityDate) {
			this.currentMaturityDate = _currentMaturityDate == null ? null : _currentMaturityDate;
			return this;
		}
		
		@RosettaAttribute("priorMaturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorMaturityDate")
		@Override
		public MaturityChange.MaturityChangeBuilder setPriorMaturityDate(ZonedDateTime _priorMaturityDate) {
			this.priorMaturityDate = _priorMaturityDate == null ? null : _priorMaturityDate;
			return this;
		}
		
		@Override
		public MaturityChange build() {
			return new MaturityChange.MaturityChangeImpl(this);
		}
		
		@Override
		public MaturityChange.MaturityChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityChange.MaturityChangeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityChange.MaturityChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MaturityChange.MaturityChangeBuilder o = (MaturityChange.MaturityChangeBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaturityChangeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
