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
import fpml.consolidated.loan.meta.LcAdjustmentMeta;
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
 * Provision An event representing a change in the notional amount associated with an outstanding letter of credit.
 *
 */
@RosettaDataType(value="LcAdjustment", builder=LcAdjustment.LcAdjustmentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcAdjustment", model="fpml", builder=LcAdjustment.LcAdjustmentBuilderImpl.class, version="2.1.1")
public interface LcAdjustment extends AbstractLcEvent {

	LcAdjustmentMeta metaData = new LcAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the type of adjustment applied - increase or decrease.
	 *
	 */
	Adjustment getAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The letter of credit amount after the adjustment has been applied.
	 *
	 */
	MoneyWithParticipantShare getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Set to false for a normal increase or decrease in the letter of credit amount. If set to true, it signifies that a loan borrowing will take place in conjunction with this business event.
	 *
	 */
	Boolean getRelatedBorrowing();

	/*********************** Build Methods  ***********************/
	LcAdjustment build();
	
	LcAdjustment.LcAdjustmentBuilder toBuilder();
	
	static LcAdjustment.LcAdjustmentBuilder builder() {
		return new LcAdjustment.LcAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcAdjustment> getType() {
		return LcAdjustment.class;
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
		processRosetta(path.newSubPath("adjustment"), processor, Adjustment.class, getAdjustment());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processor.processBasic(path.newSubPath("relatedBorrowing"), Boolean.class, getRelatedBorrowing(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcAdjustmentBuilder extends LcAdjustment, AbstractLcEvent.AbstractLcEventBuilder {
		Adjustment.AdjustmentBuilder getOrCreateAdjustment();
		@Override
		Adjustment.AdjustmentBuilder getAdjustment();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		@Override
		LcAdjustment.LcAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LcAdjustment.LcAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LcAdjustment.LcAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcAdjustment.LcAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcAdjustment.LcAdjustmentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LcAdjustment.LcAdjustmentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LcAdjustment.LcAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LcAdjustment.LcAdjustmentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LcAdjustment.LcAdjustmentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LcAdjustment.LcAdjustmentBuilder setComment(String comment);
		@Override
		LcAdjustment.LcAdjustmentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LcAdjustment.LcAdjustmentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LcAdjustment.LcAdjustmentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LcAdjustment.LcAdjustmentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		LcAdjustment.LcAdjustmentBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcAdjustment.LcAdjustmentBuilder setAdjustment(Adjustment adjustment);
		LcAdjustment.LcAdjustmentBuilder setAmount(MoneyWithParticipantShare amount);
		LcAdjustment.LcAdjustmentBuilder setRelatedBorrowing(Boolean relatedBorrowing);

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
			processRosetta(path.newSubPath("adjustment"), processor, Adjustment.AdjustmentBuilder.class, getAdjustment());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("relatedBorrowing"), Boolean.class, getRelatedBorrowing(), this);
		}
		

		LcAdjustment.LcAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of LcAdjustment  ***********************/
	class LcAdjustmentImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcAdjustment {
		private final Adjustment adjustment;
		private final MoneyWithParticipantShare amount;
		private final Boolean relatedBorrowing;
		
		protected LcAdjustmentImpl(LcAdjustment.LcAdjustmentBuilder builder) {
			super(builder);
			this.adjustment = ofNullable(builder.getAdjustment()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.relatedBorrowing = builder.getRelatedBorrowing();
		}
		
		@Override
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustment")
		public Adjustment getAdjustment() {
			return adjustment;
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
		@RosettaAttribute("relatedBorrowing")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("relatedBorrowing")
		public Boolean getRelatedBorrowing() {
			return relatedBorrowing;
		}
		
		@Override
		public LcAdjustment build() {
			return this;
		}
		
		@Override
		public LcAdjustment.LcAdjustmentBuilder toBuilder() {
			LcAdjustment.LcAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcAdjustment.LcAdjustmentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAdjustment()).ifPresent(builder::setAdjustment);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getRelatedBorrowing()).ifPresent(builder::setRelatedBorrowing);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(relatedBorrowing, _that.getRelatedBorrowing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (relatedBorrowing != null ? relatedBorrowing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAdjustment {" +
				"adjustment=" + this.adjustment + ", " +
				"amount=" + this.amount + ", " +
				"relatedBorrowing=" + this.relatedBorrowing +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcAdjustment  ***********************/
	class LcAdjustmentBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl implements LcAdjustment.LcAdjustmentBuilder {
	
		protected Adjustment.AdjustmentBuilder adjustment;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected Boolean relatedBorrowing;
		
		@Override
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustment")
		public Adjustment.AdjustmentBuilder getAdjustment() {
			return adjustment;
		}
		
		@Override
		public Adjustment.AdjustmentBuilder getOrCreateAdjustment() {
			Adjustment.AdjustmentBuilder result;
			if (adjustment!=null) {
				result = adjustment;
			}
			else {
				result = adjustment = Adjustment.builder();
			}
			
			return result;
		}
		
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
		
		@Override
		@RosettaAttribute("relatedBorrowing")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("relatedBorrowing")
		public Boolean getRelatedBorrowing() {
			return relatedBorrowing;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LcAdjustment.LcAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcAdjustment.LcAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcAdjustment.LcAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcAdjustment.LcAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcAdjustment.LcAdjustmentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("letterOfCreditReference")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference) {
			this.letterOfCreditReference = _letterOfCreditReference == null ? null : _letterOfCreditReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("adjustment")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setAdjustment(Adjustment _adjustment) {
			this.adjustment = _adjustment == null ? null : _adjustment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedBorrowing")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("relatedBorrowing")
		@Override
		public LcAdjustment.LcAdjustmentBuilder setRelatedBorrowing(Boolean _relatedBorrowing) {
			this.relatedBorrowing = _relatedBorrowing == null ? null : _relatedBorrowing;
			return this;
		}
		
		@Override
		public LcAdjustment build() {
			return new LcAdjustment.LcAdjustmentImpl(this);
		}
		
		@Override
		public LcAdjustment.LcAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAdjustment.LcAdjustmentBuilder prune() {
			super.prune();
			if (adjustment!=null && !adjustment.prune().hasData()) adjustment = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAdjustment()!=null && getAdjustment().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getRelatedBorrowing()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAdjustment.LcAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LcAdjustment.LcAdjustmentBuilder o = (LcAdjustment.LcAdjustmentBuilder) other;
			
			merger.mergeRosetta(getAdjustment(), o.getAdjustment(), this::setAdjustment);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getRelatedBorrowing(), o.getRelatedBorrowing(), this::setRelatedBorrowing);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(relatedBorrowing, _that.getRelatedBorrowing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (relatedBorrowing != null ? relatedBorrowing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAdjustmentBuilder {" +
				"adjustment=" + this.adjustment + ", " +
				"amount=" + this.amount + ", " +
				"relatedBorrowing=" + this.relatedBorrowing +
			'}' + " " + super.toString();
		}
	}
}
