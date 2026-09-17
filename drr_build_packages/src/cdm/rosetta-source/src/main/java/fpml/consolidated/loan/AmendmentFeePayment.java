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
import fpml.consolidated.loan.meta.AmendmentFeePaymentMeta;
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
 * Provision A fee charged to the borrower for an amendment being made to the originally agreed credit agreement. The fee is based on a rate (as stated in the agreement) applied to the current commitment level. Calculated as a percentage of the unutilized portion of the facility.
 *
 */
@RosettaDataType(value="AmendmentFeePayment", builder=AmendmentFeePayment.AmendmentFeePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AmendmentFeePayment", model="fpml", builder=AmendmentFeePayment.AmendmentFeePaymentBuilderImpl.class, version="2.1.1")
public interface AmendmentFeePayment extends AbstractFacilityPaymentEvent {

	AmendmentFeePaymentMeta metaData = new AmendmentFeePaymentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	AmendmentFeePayment build();
	
	AmendmentFeePayment.AmendmentFeePaymentBuilder toBuilder();
	
	static AmendmentFeePayment.AmendmentFeePaymentBuilder builder() {
		return new AmendmentFeePayment.AmendmentFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmendmentFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AmendmentFeePayment> getType() {
		return AmendmentFeePayment.class;
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
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmendmentFeePaymentBuilder extends AmendmentFeePayment, AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder {
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setComment(String comment);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		@Override
		AmendmentFeePayment.AmendmentFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);

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
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
		}
		

		AmendmentFeePayment.AmendmentFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of AmendmentFeePayment  ***********************/
	class AmendmentFeePaymentImpl extends AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventImpl implements AmendmentFeePayment {
		
		protected AmendmentFeePaymentImpl(AmendmentFeePayment.AmendmentFeePaymentBuilder builder) {
			super(builder);
		}
		
		@Override
		public AmendmentFeePayment build() {
			return this;
		}
		
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder toBuilder() {
			AmendmentFeePayment.AmendmentFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmendmentFeePayment.AmendmentFeePaymentBuilder builder) {
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
			return "AmendmentFeePayment {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AmendmentFeePayment  ***********************/
	class AmendmentFeePaymentBuilderImpl extends AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilderImpl implements AmendmentFeePayment.AmendmentFeePaymentBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@Override
		public AmendmentFeePayment build() {
			return new AmendmentFeePayment.AmendmentFeePaymentImpl(this);
		}
		
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmendmentFeePayment.AmendmentFeePaymentBuilder prune() {
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
		public AmendmentFeePayment.AmendmentFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AmendmentFeePayment.AmendmentFeePaymentBuilder o = (AmendmentFeePayment.AmendmentFeePaymentBuilder) other;
			
			
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
			return "AmendmentFeePaymentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
