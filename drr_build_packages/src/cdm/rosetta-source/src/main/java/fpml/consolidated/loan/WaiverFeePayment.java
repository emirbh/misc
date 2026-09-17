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
import fpml.consolidated.loan.meta.WaiverFeePaymentMeta;
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
 * Provision A fee structure that represents a payment made by the borrower to the syndicate lenders for processing and accepting a waiver request. The request is sent by the borrower to obtain approval from the syndicate lenders formally requesting waivers around particular terms of the credit agreement.
 *
 */
@RosettaDataType(value="WaiverFeePayment", builder=WaiverFeePayment.WaiverFeePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WaiverFeePayment", model="fpml", builder=WaiverFeePayment.WaiverFeePaymentBuilderImpl.class, version="2.1.1")
public interface WaiverFeePayment extends AbstractFacilityPaymentEvent {

	WaiverFeePaymentMeta metaData = new WaiverFeePaymentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	WaiverFeePayment build();
	
	WaiverFeePayment.WaiverFeePaymentBuilder toBuilder();
	
	static WaiverFeePayment.WaiverFeePaymentBuilder builder() {
		return new WaiverFeePayment.WaiverFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WaiverFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WaiverFeePayment> getType() {
		return WaiverFeePayment.class;
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
	interface WaiverFeePaymentBuilder extends WaiverFeePayment, AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder {
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setComment(String comment);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		@Override
		WaiverFeePayment.WaiverFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);

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
		

		WaiverFeePayment.WaiverFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of WaiverFeePayment  ***********************/
	class WaiverFeePaymentImpl extends AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventImpl implements WaiverFeePayment {
		
		protected WaiverFeePaymentImpl(WaiverFeePayment.WaiverFeePaymentBuilder builder) {
			super(builder);
		}
		
		@Override
		public WaiverFeePayment build() {
			return this;
		}
		
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder toBuilder() {
			WaiverFeePayment.WaiverFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WaiverFeePayment.WaiverFeePaymentBuilder builder) {
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
			return "WaiverFeePayment {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of WaiverFeePayment  ***********************/
	class WaiverFeePaymentBuilderImpl extends AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilderImpl implements WaiverFeePayment.WaiverFeePaymentBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public WaiverFeePayment.WaiverFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public WaiverFeePayment.WaiverFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@Override
		public WaiverFeePayment build() {
			return new WaiverFeePayment.WaiverFeePaymentImpl(this);
		}
		
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WaiverFeePayment.WaiverFeePaymentBuilder prune() {
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
		public WaiverFeePayment.WaiverFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			WaiverFeePayment.WaiverFeePaymentBuilder o = (WaiverFeePayment.WaiverFeePaymentBuilder) other;
			
			
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
			return "WaiverFeePaymentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
