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
import fpml.consolidated.loan.meta.MandatoryCostRateChangeMeta;
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
 * Provision An event representing a change in the mandatory cost rate, applicable to certain outstanding loans in the UK market.
 *
 */
@RosettaDataType(value="MandatoryCostRateChange", builder=MandatoryCostRateChange.MandatoryCostRateChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MandatoryCostRateChange", model="fpml", builder=MandatoryCostRateChange.MandatoryCostRateChangeBuilderImpl.class, version="2.1.1")
public interface MandatoryCostRateChange extends AbstractFacilityRateChangeEvent {

	MandatoryCostRateChangeMeta metaData = new MandatoryCostRateChangeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MandatoryCostRateChange build();
	
	MandatoryCostRateChange.MandatoryCostRateChangeBuilder toBuilder();
	
	static MandatoryCostRateChange.MandatoryCostRateChangeBuilder builder() {
		return new MandatoryCostRateChange.MandatoryCostRateChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MandatoryCostRateChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MandatoryCostRateChange> getType() {
		return MandatoryCostRateChange.class;
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
	interface MandatoryCostRateChangeBuilder extends MandatoryCostRateChange, AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilder {
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setCashPayable(CashPayable cashPayable);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setComment(String comment);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setFacilityReference(FacilityReference facilityReference);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference, int idx);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference);
		@Override
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setRate(PeriodRate rate);

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
		

		MandatoryCostRateChange.MandatoryCostRateChangeBuilder prune();
	}

	/*********************** Immutable Implementation of MandatoryCostRateChange  ***********************/
	class MandatoryCostRateChangeImpl extends AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventImpl implements MandatoryCostRateChange {
		
		protected MandatoryCostRateChangeImpl(MandatoryCostRateChange.MandatoryCostRateChangeBuilder builder) {
			super(builder);
		}
		
		@Override
		public MandatoryCostRateChange build() {
			return this;
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder toBuilder() {
			MandatoryCostRateChange.MandatoryCostRateChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryCostRateChange.MandatoryCostRateChangeBuilder builder) {
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
			return "MandatoryCostRateChange {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MandatoryCostRateChange  ***********************/
	class MandatoryCostRateChangeBuilderImpl extends AbstractFacilityRateChangeEvent.AbstractFacilityRateChangeEventBuilderImpl implements MandatoryCostRateChange.MandatoryCostRateChangeBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanContractReference")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(LoanContractReference _loanContractReference) {
			if (_loanContractReference != null) {
				this.loanContractReference.add(_loanContractReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(LoanContractReference _loanContractReference, int idx) {
			getIndex(this.loanContractReference, idx, () -> _loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setRate(PeriodRate _rate) {
			this.rate = _rate == null ? null : _rate.toBuilder();
			return this;
		}
		
		@Override
		public MandatoryCostRateChange build() {
			return new MandatoryCostRateChange.MandatoryCostRateChangeImpl(this);
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder prune() {
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
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MandatoryCostRateChange.MandatoryCostRateChangeBuilder o = (MandatoryCostRateChange.MandatoryCostRateChangeBuilder) other;
			
			
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
			return "MandatoryCostRateChangeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
