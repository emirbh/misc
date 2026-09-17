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
import fpml.consolidated.loan.meta.AbstractFacilityPaymentEventMeta;
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
 * Provision An event describing a fee being paid at either the loan contract or facility level.
 *
 */
@RosettaDataType(value="AbstractFacilityPaymentEvent", builder=AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractFacilityPaymentEvent", model="fpml", builder=AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilderImpl.class, version="2.1.1")
public interface AbstractFacilityPaymentEvent extends AbstractFacilityEvent {

	AbstractFacilityPaymentEventMeta metaData = new AbstractFacilityPaymentEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	MoneyWithParticipantShare getAmount();

	/*********************** Build Methods  ***********************/
	AbstractFacilityPaymentEvent build();
	
	AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder toBuilder();
	
	static AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder builder() {
		return new AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacilityPaymentEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractFacilityPaymentEvent> getType() {
		return AbstractFacilityPaymentEvent.class;
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
	interface AbstractFacilityPaymentEventBuilder extends AbstractFacilityPaymentEvent, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setComment(String comment);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setFacilityReference(FacilityReference facilityReference);
		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setAmount(MoneyWithParticipantShare amount);

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
		

		AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacilityPaymentEvent  ***********************/
	class AbstractFacilityPaymentEventImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AbstractFacilityPaymentEvent {
		private final MoneyWithParticipantShare amount;
		
		protected AbstractFacilityPaymentEventImpl(AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		public AbstractFacilityPaymentEvent build() {
			return this;
		}
		
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder toBuilder() {
			AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityPaymentEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityPaymentEvent {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFacilityPaymentEvent  ***********************/
	class AbstractFacilityPaymentEventBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl implements AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder {
	
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount() {
			return amount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@Override
		public AbstractFacilityPaymentEvent build() {
			return new AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventImpl(this);
		}
		
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder o = (AbstractFacilityPaymentEvent.AbstractFacilityPaymentEventBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityPaymentEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityPaymentEventBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
