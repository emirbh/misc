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
import fpml.consolidated.fpmlenum.InterestCalculationMethodEnum;
import fpml.consolidated.loan.meta.LoanInterestPaymentMeta;
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
 * Provision An event representing the lender-specific payment of interest amounts for a given accrual period against a single loan contract.
 *
 */
@RosettaDataType(value="LoanInterestPayment", builder=LoanInterestPayment.LoanInterestPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanInterestPayment", model="fpml", builder=LoanInterestPayment.LoanInterestPaymentBuilderImpl.class, version="2.1.1")
public interface LoanInterestPayment extends AbstractLoanContractEvent {

	LoanInterestPaymentMeta metaData = new LoanInterestPaymentMeta();

	/*********************** Getter Methods  ***********************/
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
	 * Provision Defines whether the agent bank is making an interest payment based on the lender pro-rata share at the end of the period (snapshot) or based on the lender position throughout the period (which is the default).
	 *
	 */
	InterestCalculationMethodEnum getLenderShareCalculationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the total amount of the interest payment.
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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Projected interest payment details.
	 *
	 */
	PaymentProjection getProjection();

	/*********************** Build Methods  ***********************/
	LoanInterestPayment build();
	
	LoanInterestPayment.LoanInterestPaymentBuilder toBuilder();
	
	static LoanInterestPayment.LoanInterestPaymentBuilder builder() {
		return new LoanInterestPayment.LoanInterestPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanInterestPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanInterestPayment> getType() {
		return LoanInterestPayment.class;
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
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("lenderShareCalculationMethod"), InterestCalculationMethodEnum.class, getLenderShareCalculationMethod(), this);
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.class, getAccrualSchedule());
		processRosetta(path.newSubPath("projection"), processor, PaymentProjection.class, getProjection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanInterestPaymentBuilder extends LoanInterestPayment, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int index);
		@Override
		List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule();
		PaymentProjection.PaymentProjectionBuilder getOrCreateProjection();
		@Override
		PaymentProjection.PaymentProjectionBuilder getProjection();
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setComment(String comment);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		LoanInterestPayment.LoanInterestPaymentBuilder setLoanContractReference(LoanContractReference loanContractReference);
		LoanInterestPayment.LoanInterestPaymentBuilder setStartDate(ZonedDateTime startDate);
		LoanInterestPayment.LoanInterestPaymentBuilder setEndDate(ZonedDateTime endDate);
		LoanInterestPayment.LoanInterestPaymentBuilder setLenderShareCalculationMethod(InterestCalculationMethodEnum lenderShareCalculationMethod);
		LoanInterestPayment.LoanInterestPaymentBuilder setAmount(MoneyWithParticipantShare amount);
		LoanInterestPayment.LoanInterestPaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule);
		LoanInterestPayment.LoanInterestPaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule, int idx);
		LoanInterestPayment.LoanInterestPaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule);
		LoanInterestPayment.LoanInterestPaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule);
		LoanInterestPayment.LoanInterestPaymentBuilder setProjection(PaymentProjection projection);

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
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("lenderShareCalculationMethod"), InterestCalculationMethodEnum.class, getLenderShareCalculationMethod(), this);
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualSchedule());
			processRosetta(path.newSubPath("projection"), processor, PaymentProjection.PaymentProjectionBuilder.class, getProjection());
		}
		

		LoanInterestPayment.LoanInterestPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanInterestPayment  ***********************/
	class LoanInterestPaymentImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements LoanInterestPayment {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final InterestCalculationMethodEnum lenderShareCalculationMethod;
		private final MoneyWithParticipantShare amount;
		private final List<? extends AccrualPeriod> accrualSchedule;
		private final PaymentProjection projection;
		
		protected LoanInterestPaymentImpl(LoanInterestPayment.LoanInterestPaymentBuilder builder) {
			super(builder);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.lenderShareCalculationMethod = builder.getLenderShareCalculationMethod();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accrualSchedule = ofNullable(builder.getAccrualSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.projection = ofNullable(builder.getProjection()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("lenderShareCalculationMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lenderShareCalculationMethod")
		public InterestCalculationMethodEnum getLenderShareCalculationMethod() {
			return lenderShareCalculationMethod;
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
		@RosettaAttribute("projection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("projection")
		public PaymentProjection getProjection() {
			return projection;
		}
		
		@Override
		public LoanInterestPayment build() {
			return this;
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder toBuilder() {
			LoanInterestPayment.LoanInterestPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanInterestPayment.LoanInterestPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getLenderShareCalculationMethod()).ifPresent(builder::setLenderShareCalculationMethod);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccrualSchedule()).ifPresent(builder::setAccrualSchedule);
			ofNullable(getProjection()).ifPresent(builder::setProjection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanInterestPayment _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(lenderShareCalculationMethod, _that.getLenderShareCalculationMethod())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			if (!Objects.equals(projection, _that.getProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (lenderShareCalculationMethod != null ? lenderShareCalculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			_result = 31 * _result + (projection != null ? projection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanInterestPayment {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"lenderShareCalculationMethod=" + this.lenderShareCalculationMethod + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule + ", " +
				"projection=" + this.projection +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanInterestPayment  ***********************/
	class LoanInterestPaymentBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl implements LoanInterestPayment.LoanInterestPaymentBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected InterestCalculationMethodEnum lenderShareCalculationMethod;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected List<AccrualPeriod.AccrualPeriodBuilder> accrualSchedule = new ArrayList<>();
		protected PaymentProjection.PaymentProjectionBuilder projection;
		
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
		@RosettaAttribute("lenderShareCalculationMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lenderShareCalculationMethod")
		public InterestCalculationMethodEnum getLenderShareCalculationMethod() {
			return lenderShareCalculationMethod;
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
		
		@Override
		@RosettaAttribute("projection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("projection")
		public PaymentProjection.PaymentProjectionBuilder getProjection() {
			return projection;
		}
		
		@Override
		public PaymentProjection.PaymentProjectionBuilder getOrCreateProjection() {
			PaymentProjection.PaymentProjectionBuilder result;
			if (projection!=null) {
				result = projection;
			}
			else {
				result = projection = PaymentProjection.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanInterestPayment.LoanInterestPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanInterestPayment.LoanInterestPaymentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractReference")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("lenderShareCalculationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lenderShareCalculationMethod")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setLenderShareCalculationMethod(InterestCalculationMethodEnum _lenderShareCalculationMethod) {
			this.lenderShareCalculationMethod = _lenderShareCalculationMethod == null ? null : _lenderShareCalculationMethod;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accrualSchedule")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder addAccrualSchedule(AccrualPeriod _accrualSchedule) {
			if (_accrualSchedule != null) {
				this.accrualSchedule.add(_accrualSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder addAccrualSchedule(AccrualPeriod _accrualSchedule, int idx) {
			getIndex(this.accrualSchedule, idx, () -> _accrualSchedule.toBuilder());
			return this;
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
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
		public LoanInterestPayment.LoanInterestPaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules == null) {
				this.accrualSchedule = new ArrayList<>();
			} else {
				this.accrualSchedule = accrualSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("projection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("projection")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder setProjection(PaymentProjection _projection) {
			this.projection = _projection == null ? null : _projection.toBuilder();
			return this;
		}
		
		@Override
		public LoanInterestPayment build() {
			return new LoanInterestPayment.LoanInterestPaymentImpl(this);
		}
		
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			accrualSchedule = accrualSchedule.stream().filter(b->b!=null).<AccrualPeriod.AccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (projection!=null && !projection.prune().hasData()) projection = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getLenderShareCalculationMethod()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccrualSchedule()!=null && getAccrualSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProjection()!=null && getProjection().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanInterestPayment.LoanInterestPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanInterestPayment.LoanInterestPaymentBuilder o = (LoanInterestPayment.LoanInterestPaymentBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccrualSchedule(), o.getAccrualSchedule(), this::getOrCreateAccrualSchedule);
			merger.mergeRosetta(getProjection(), o.getProjection(), this::setProjection);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getLenderShareCalculationMethod(), o.getLenderShareCalculationMethod(), this::setLenderShareCalculationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanInterestPayment _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(lenderShareCalculationMethod, _that.getLenderShareCalculationMethod())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			if (!Objects.equals(projection, _that.getProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (lenderShareCalculationMethod != null ? lenderShareCalculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			_result = 31 * _result + (projection != null ? projection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanInterestPaymentBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"lenderShareCalculationMethod=" + this.lenderShareCalculationMethod + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule + ", " +
				"projection=" + this.projection +
			'}' + " " + super.toString();
		}
	}
}
