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
import fpml.consolidated.loan.meta.MandatoryCostRateExpiryMeta;
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
 * Provision An event representing expiration of the mandatory cost rate applicable in the UK market.
 *
 */
@RosettaDataType(value="MandatoryCostRateExpiry", builder=MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MandatoryCostRateExpiry", model="fpml", builder=MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilderImpl.class, version="2.1.1")
public interface MandatoryCostRateExpiry extends AbstractFacilityContractEvent {

	MandatoryCostRateExpiryMeta metaData = new MandatoryCostRateExpiryMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MandatoryCostRateExpiry build();
	
	MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder toBuilder();
	
	static MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder builder() {
		return new MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MandatoryCostRateExpiry> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MandatoryCostRateExpiry> getType() {
		return MandatoryCostRateExpiry.class;
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
	interface MandatoryCostRateExpiryBuilder extends MandatoryCostRateExpiry, AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setCashPayable(CashPayable cashPayable);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setComment(String comment);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setFacilityReference(FacilityReference facilityReference);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference, int idx);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference);
		@Override
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference);

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
		

		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder prune();
	}

	/*********************** Immutable Implementation of MandatoryCostRateExpiry  ***********************/
	class MandatoryCostRateExpiryImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventImpl implements MandatoryCostRateExpiry {
		
		protected MandatoryCostRateExpiryImpl(MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder builder) {
			super(builder);
		}
		
		@Override
		public MandatoryCostRateExpiry build() {
			return this;
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder toBuilder() {
			MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder builder) {
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
			return "MandatoryCostRateExpiry {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MandatoryCostRateExpiry  ***********************/
	class MandatoryCostRateExpiryBuilderImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl implements MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanContractReference")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(LoanContractReference _loanContractReference) {
			if (_loanContractReference != null) {
				this.loanContractReference.add(_loanContractReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(LoanContractReference _loanContractReference, int idx) {
			getIndex(this.loanContractReference, idx, () -> _loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public MandatoryCostRateExpiry build() {
			return new MandatoryCostRateExpiry.MandatoryCostRateExpiryImpl(this);
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder prune() {
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
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder o = (MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder) other;
			
			
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
			return "MandatoryCostRateExpiryBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
