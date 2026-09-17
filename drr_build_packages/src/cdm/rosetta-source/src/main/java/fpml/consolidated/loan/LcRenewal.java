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
import fpml.consolidated.loan.meta.LcRenewalMeta;
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
 * Provision An event representing a change in the maturity date on an outstanding letter of credit.
 *
 */
@RosettaDataType(value="LcRenewal", builder=LcRenewal.LcRenewalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcRenewal", model="fpml", builder=LcRenewal.LcRenewalBuilderImpl.class, version="2.1.1")
public interface LcRenewal extends AbstractLcEvent {

	LcRenewalMeta metaData = new LcRenewalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The final letter of credit expiry date (as defined by the evergreen option).
	 *
	 */
	ZonedDateTime getFinalExpiryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The original maturity date of the letter of credit.
	 *
	 */
	ZonedDateTime getMaturityDate();

	/*********************** Build Methods  ***********************/
	LcRenewal build();
	
	LcRenewal.LcRenewalBuilder toBuilder();
	
	static LcRenewal.LcRenewalBuilder builder() {
		return new LcRenewal.LcRenewalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcRenewal> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcRenewal> getType() {
		return LcRenewal.class;
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
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
		processor.processBasic(path.newSubPath("finalExpiryDate"), ZonedDateTime.class, getFinalExpiryDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcRenewalBuilder extends LcRenewal, AbstractLcEvent.AbstractLcEventBuilder {
		@Override
		LcRenewal.LcRenewalBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LcRenewal.LcRenewalBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LcRenewal.LcRenewalBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcRenewal.LcRenewalBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcRenewal.LcRenewalBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LcRenewal.LcRenewalBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LcRenewal.LcRenewalBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LcRenewal.LcRenewalBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LcRenewal.LcRenewalBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LcRenewal.LcRenewalBuilder setComment(String comment);
		@Override
		LcRenewal.LcRenewalBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LcRenewal.LcRenewalBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LcRenewal.LcRenewalBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LcRenewal.LcRenewalBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		LcRenewal.LcRenewalBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcRenewal.LcRenewalBuilder setFinalExpiryDate(ZonedDateTime finalExpiryDate);
		LcRenewal.LcRenewalBuilder setMaturityDate(ZonedDateTime maturityDate);

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
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
			processor.processBasic(path.newSubPath("finalExpiryDate"), ZonedDateTime.class, getFinalExpiryDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
		}
		

		LcRenewal.LcRenewalBuilder prune();
	}

	/*********************** Immutable Implementation of LcRenewal  ***********************/
	class LcRenewalImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcRenewal {
		private final ZonedDateTime finalExpiryDate;
		private final ZonedDateTime maturityDate;
		
		protected LcRenewalImpl(LcRenewal.LcRenewalBuilder builder) {
			super(builder);
			this.finalExpiryDate = builder.getFinalExpiryDate();
			this.maturityDate = builder.getMaturityDate();
		}
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("finalExpiryDate")
		public ZonedDateTime getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		public LcRenewal build() {
			return this;
		}
		
		@Override
		public LcRenewal.LcRenewalBuilder toBuilder() {
			LcRenewal.LcRenewalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcRenewal.LcRenewalBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFinalExpiryDate()).ifPresent(builder::setFinalExpiryDate);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcRenewal _that = getType().cast(o);
		
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcRenewal {" +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"maturityDate=" + this.maturityDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcRenewal  ***********************/
	class LcRenewalBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl implements LcRenewal.LcRenewalBuilder {
	
		protected ZonedDateTime finalExpiryDate;
		protected ZonedDateTime maturityDate;
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("finalExpiryDate")
		public ZonedDateTime getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LcRenewal.LcRenewalBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcRenewal.LcRenewalBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcRenewal.LcRenewalBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcRenewal.LcRenewalBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcRenewal.LcRenewalBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LcRenewal.LcRenewalBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LcRenewal.LcRenewalBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LcRenewal.LcRenewalBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LcRenewal.LcRenewalBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LcRenewal.LcRenewalBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public LcRenewal.LcRenewalBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LcRenewal.LcRenewalBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LcRenewal.LcRenewalBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public LcRenewal.LcRenewalBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("letterOfCreditReference")
		@Override
		public LcRenewal.LcRenewalBuilder setLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference) {
			this.letterOfCreditReference = _letterOfCreditReference == null ? null : _letterOfCreditReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalExpiryDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("finalExpiryDate")
		@Override
		public LcRenewal.LcRenewalBuilder setFinalExpiryDate(ZonedDateTime _finalExpiryDate) {
			this.finalExpiryDate = _finalExpiryDate == null ? null : _finalExpiryDate;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public LcRenewal.LcRenewalBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@Override
		public LcRenewal build() {
			return new LcRenewal.LcRenewalImpl(this);
		}
		
		@Override
		public LcRenewal.LcRenewalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcRenewal.LcRenewalBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFinalExpiryDate()!=null) return true;
			if (getMaturityDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcRenewal.LcRenewalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LcRenewal.LcRenewalBuilder o = (LcRenewal.LcRenewalBuilder) other;
			
			
			merger.mergeBasic(getFinalExpiryDate(), o.getFinalExpiryDate(), this::setFinalExpiryDate);
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcRenewal _that = getType().cast(o);
		
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcRenewalBuilder {" +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"maturityDate=" + this.maturityDate +
			'}' + " " + super.toString();
		}
	}
}
