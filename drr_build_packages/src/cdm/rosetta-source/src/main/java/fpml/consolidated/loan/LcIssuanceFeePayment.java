package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.meta.LcIssuanceFeePaymentMeta;
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
 * Provision An event representing a letter of credit issuance fee payment.
 *
 */
@RosettaDataType(value="LcIssuanceFeePayment", builder=LcIssuanceFeePayment.LcIssuanceFeePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcIssuanceFeePayment", model="fpml", builder=LcIssuanceFeePayment.LcIssuanceFeePaymentBuilderImpl.class, version="2.1.1")
public interface LcIssuanceFeePayment extends AbstractLcEvent {

	LcIssuanceFeePaymentMeta metaData = new LcIssuanceFeePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique id associated with the loan accrual type.
	 *
	 */
	AccrualTypeId getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period begins.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period ends.
	 *
	 */
	ZonedDateTime getEndDate();
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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A schedule that incorporates all sub-periods of an accrual calculation.
	 *
	 */
	List<? extends AccrualPeriod> getAccrualSchedule();

	/*********************** Build Methods  ***********************/
	LcIssuanceFeePayment build();
	
	LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder toBuilder();
	
	static LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder builder() {
		return new LcIssuanceFeePayment.LcIssuanceFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcIssuanceFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcIssuanceFeePayment> getType() {
		return LcIssuanceFeePayment.class;
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
		processRosetta(path.newSubPath("id"), processor, AccrualTypeId.class, getId());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.class, getAccrualSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcIssuanceFeePaymentBuilder extends LcIssuanceFeePayment, AbstractLcEvent.AbstractLcEventBuilder {
		AccrualTypeId.AccrualTypeIdBuilder getOrCreateId();
		@Override
		AccrualTypeId.AccrualTypeIdBuilder getId();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int index);
		@Override
		List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule();
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setComment(String comment);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setId(AccrualTypeId id);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setStartDate(ZonedDateTime startDate);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEndDate(ZonedDateTime endDate);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule, int idx);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule);
		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule);

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
			processRosetta(path.newSubPath("id"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getId());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualSchedule());
		}
		

		LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LcIssuanceFeePayment  ***********************/
	class LcIssuanceFeePaymentImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcIssuanceFeePayment {
		private final AccrualTypeId id;
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final MoneyWithParticipantShare amount;
		private final List<? extends AccrualPeriod> accrualSchedule;
		
		protected LcIssuanceFeePaymentImpl(LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder builder) {
			super(builder);
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accrualSchedule = ofNullable(builder.getAccrualSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public AccrualTypeId getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
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
		@RosettaAttribute("accrualSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("accrualSchedule")
		public List<? extends AccrualPeriod> getAccrualSchedule() {
			return accrualSchedule;
		}
		
		@Override
		public LcIssuanceFeePayment build() {
			return this;
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder toBuilder() {
			LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccrualSchedule()).ifPresent(builder::setAccrualSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcIssuanceFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcIssuanceFeePayment {" +
				"id=" + this.id + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcIssuanceFeePayment  ***********************/
	class LcIssuanceFeePaymentBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl implements LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder {
	
		protected AccrualTypeId.AccrualTypeIdBuilder id;
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected List<AccrualPeriod.AccrualPeriodBuilder> accrualSchedule = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public AccrualTypeId.AccrualTypeIdBuilder getId() {
			return id;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder getOrCreateId() {
			AccrualTypeId.AccrualTypeIdBuilder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = AccrualTypeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
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
		@RosettaAttribute("accrualSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("accrualSchedule")
		public List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule() {
			return accrualSchedule;
		}
		
		@Override
		public AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int index) {
			if (accrualSchedule==null) {
				this.accrualSchedule = new ArrayList<>();
			}
			return getIndex(accrualSchedule, index, () -> {
						AccrualPeriod.AccrualPeriodBuilder newAccrualSchedule = AccrualPeriod.builder();
						return newAccrualSchedule;
					});
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("letterOfCreditReference")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference) {
			this.letterOfCreditReference = _letterOfCreditReference == null ? null : _letterOfCreditReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setId(AccrualTypeId _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accrualSchedule")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(AccrualPeriod _accrualSchedule) {
			if (_accrualSchedule != null) {
				this.accrualSchedule.add(_accrualSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(AccrualPeriod _accrualSchedule, int idx) {
			getIndex(this.accrualSchedule, idx, () -> _accrualSchedule.toBuilder());
			return this;
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules != null) {
				for (final AccrualPeriod toAdd : accrualSchedules) {
					this.accrualSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accrualSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("accrualSchedule")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules == null) {
				this.accrualSchedule = new ArrayList<>();
			} else {
				this.accrualSchedule = accrualSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LcIssuanceFeePayment build() {
			return new LcIssuanceFeePayment.LcIssuanceFeePaymentImpl(this);
		}
		
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder prune() {
			super.prune();
			if (id!=null && !id.prune().hasData()) id = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			accrualSchedule = accrualSchedule.stream().filter(b->b!=null).<AccrualPeriod.AccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getId()!=null && getId().hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccrualSchedule()!=null && getAccrualSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder o = (LcIssuanceFeePayment.LcIssuanceFeePaymentBuilder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccrualSchedule(), o.getAccrualSchedule(), this::getOrCreateAccrualSchedule);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcIssuanceFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcIssuanceFeePaymentBuilder {" +
				"id=" + this.id + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule +
			'}' + " " + super.toString();
		}
	}
}
