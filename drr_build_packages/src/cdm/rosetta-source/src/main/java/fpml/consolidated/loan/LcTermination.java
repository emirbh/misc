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
import fpml.consolidated.loan.meta.LcTerminationMeta;
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
 * Provision An event representing either the expiry or cancellation of a letter of credit
 *
 */
@RosettaDataType(value="LcTermination", builder=LcTermination.LcTerminationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcTermination", model="fpml", builder=LcTermination.LcTerminationBuilderImpl.class, version="2.1.1")
public interface LcTermination extends AbstractLcEvent {

	LcTerminationMeta metaData = new LcTerminationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Determines whether this event was created due to a natural expiration of the letter of credit or an unscheduled cancellation.
	 *
	 */
	Boolean getExpiry();

	/*********************** Build Methods  ***********************/
	LcTermination build();
	
	LcTermination.LcTerminationBuilder toBuilder();
	
	static LcTermination.LcTerminationBuilder builder() {
		return new LcTermination.LcTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcTermination> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcTermination> getType() {
		return LcTermination.class;
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
		processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcTerminationBuilder extends LcTermination, AbstractLcEvent.AbstractLcEventBuilder {
		@Override
		LcTermination.LcTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LcTermination.LcTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LcTermination.LcTerminationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcTermination.LcTerminationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcTermination.LcTerminationBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LcTermination.LcTerminationBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LcTermination.LcTerminationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LcTermination.LcTerminationBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LcTermination.LcTerminationBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LcTermination.LcTerminationBuilder setComment(String comment);
		@Override
		LcTermination.LcTerminationBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LcTermination.LcTerminationBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LcTermination.LcTerminationBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LcTermination.LcTerminationBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		LcTermination.LcTerminationBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcTermination.LcTerminationBuilder setExpiry(Boolean expiry);

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
			processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
		}
		

		LcTermination.LcTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of LcTermination  ***********************/
	class LcTerminationImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcTermination {
		private final Boolean expiry;
		
		protected LcTerminationImpl(LcTermination.LcTerminationBuilder builder) {
			super(builder);
			this.expiry = builder.getExpiry();
		}
		
		@Override
		@RosettaAttribute("expiry")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@Override
		public LcTermination build() {
			return this;
		}
		
		@Override
		public LcTermination.LcTerminationBuilder toBuilder() {
			LcTermination.LcTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcTermination.LcTerminationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpiry()).ifPresent(builder::setExpiry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcTermination _that = getType().cast(o);
		
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcTermination {" +
				"expiry=" + this.expiry +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcTermination  ***********************/
	class LcTerminationBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl implements LcTermination.LcTerminationBuilder {
	
		protected Boolean expiry;
		
		@Override
		@RosettaAttribute("expiry")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LcTermination.LcTerminationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcTermination.LcTerminationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcTermination.LcTerminationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcTermination.LcTerminationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcTermination.LcTerminationBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LcTermination.LcTerminationBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LcTermination.LcTerminationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LcTermination.LcTerminationBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LcTermination.LcTerminationBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LcTermination.LcTerminationBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public LcTermination.LcTerminationBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LcTermination.LcTerminationBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LcTermination.LcTerminationBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public LcTermination.LcTerminationBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("letterOfCreditReference")
		@Override
		public LcTermination.LcTerminationBuilder setLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference) {
			this.letterOfCreditReference = _letterOfCreditReference == null ? null : _letterOfCreditReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expiry")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expiry")
		@Override
		public LcTermination.LcTerminationBuilder setExpiry(Boolean _expiry) {
			this.expiry = _expiry == null ? null : _expiry;
			return this;
		}
		
		@Override
		public LcTermination build() {
			return new LcTermination.LcTerminationImpl(this);
		}
		
		@Override
		public LcTermination.LcTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcTermination.LcTerminationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpiry()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcTermination.LcTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LcTermination.LcTerminationBuilder o = (LcTermination.LcTerminationBuilder) other;
			
			
			merger.mergeBasic(getExpiry(), o.getExpiry(), this::setExpiry);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcTermination _that = getType().cast(o);
		
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcTerminationBuilder {" +
				"expiry=" + this.expiry +
			'}' + " " + super.toString();
		}
	}
}
