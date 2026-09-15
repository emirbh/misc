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
import fpml.consolidated.loan.meta.LegacyInterestCapitalizationMeta;
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
 * Provision An event representing the legacy version (pre-IBOR replacement) of the capitalization of interest amounts for a given accrual period against a single loan contract.
 *
 */
@RosettaDataType(value="LegacyInterestCapitalization", builder=LegacyInterestCapitalization.LegacyInterestCapitalizationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegacyInterestCapitalization", model="fpml", builder=LegacyInterestCapitalization.LegacyInterestCapitalizationBuilderImpl.class, version="2.1.1")
public interface LegacyInterestCapitalization extends AbstractLoanContractEvent {

	LegacyInterestCapitalizationMeta metaData = new LegacyInterestCapitalizationMeta();

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
	 * Provision Defines the way in which the agent bank is allocating cash/PIK interest - can be (i) pro-rata at the time of the interest payment/PIK or (ii) based on the loan contract share throughout the interest period (which is the preferred method).
	 *
	 */
	InterestCalculationMethodEnum getCalculationMethod();
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
	List<? extends LegacyAccrualPeriod> getAccrualSchedule();
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
	LegacyInterestCapitalization build();
	
	LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder toBuilder();
	
	static LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder builder() {
		return new LegacyInterestCapitalization.LegacyInterestCapitalizationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyInterestCapitalization> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyInterestCapitalization> getType() {
		return LegacyInterestCapitalization.class;
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
		processor.processBasic(path.newSubPath("calculationMethod"), InterestCalculationMethodEnum.class, getCalculationMethod(), this);
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("accrualSchedule"), processor, LegacyAccrualPeriod.class, getAccrualSchedule());
		processRosetta(path.newSubPath("projection"), processor, PaymentProjection.class, getProjection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyInterestCapitalizationBuilder extends LegacyInterestCapitalization, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		LegacyAccrualPeriod.LegacyAccrualPeriodBuilder getOrCreateAccrualSchedule(int index);
		@Override
		List<? extends LegacyAccrualPeriod.LegacyAccrualPeriodBuilder> getAccrualSchedule();
		PaymentProjection.PaymentProjectionBuilder getOrCreateProjection();
		@Override
		PaymentProjection.PaymentProjectionBuilder getProjection();
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setComment(String comment);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setLoanContractReference(LoanContractReference loanContractReference);
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setStartDate(ZonedDateTime startDate);
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setEndDate(ZonedDateTime endDate);
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setCalculationMethod(InterestCalculationMethodEnum calculationMethod);
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setAmount(MoneyWithParticipantShare amount);
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addAccrualSchedule(LegacyAccrualPeriod accrualSchedule);
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addAccrualSchedule(LegacyAccrualPeriod accrualSchedule, int idx);
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addAccrualSchedule(List<? extends LegacyAccrualPeriod> accrualSchedule);
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setAccrualSchedule(List<? extends LegacyAccrualPeriod> accrualSchedule);
		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setProjection(PaymentProjection projection);

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
			processor.processBasic(path.newSubPath("calculationMethod"), InterestCalculationMethodEnum.class, getCalculationMethod(), this);
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualSchedule"), processor, LegacyAccrualPeriod.LegacyAccrualPeriodBuilder.class, getAccrualSchedule());
			processRosetta(path.newSubPath("projection"), processor, PaymentProjection.PaymentProjectionBuilder.class, getProjection());
		}
		

		LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyInterestCapitalization  ***********************/
	class LegacyInterestCapitalizationImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements LegacyInterestCapitalization {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final InterestCalculationMethodEnum calculationMethod;
		private final MoneyWithParticipantShare amount;
		private final List<? extends LegacyAccrualPeriod> accrualSchedule;
		private final PaymentProjection projection;
		
		protected LegacyInterestCapitalizationImpl(LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder builder) {
			super(builder);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.calculationMethod = builder.getCalculationMethod();
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
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationMethod")
		public InterestCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
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
		public List<? extends LegacyAccrualPeriod> getAccrualSchedule() {
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
		public LegacyInterestCapitalization build() {
			return this;
		}
		
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder toBuilder() {
			LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getCalculationMethod()).ifPresent(builder::setCalculationMethod);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccrualSchedule()).ifPresent(builder::setAccrualSchedule);
			ofNullable(getProjection()).ifPresent(builder::setProjection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LegacyInterestCapitalization _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
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
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			_result = 31 * _result + (projection != null ? projection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyInterestCapitalization {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule + ", " +
				"projection=" + this.projection +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LegacyInterestCapitalization  ***********************/
	class LegacyInterestCapitalizationBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl implements LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected InterestCalculationMethodEnum calculationMethod;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected List<LegacyAccrualPeriod.LegacyAccrualPeriodBuilder> accrualSchedule = new ArrayList<>();
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
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationMethod")
		public InterestCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
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
		public List<? extends LegacyAccrualPeriod.LegacyAccrualPeriodBuilder> getAccrualSchedule() {
			return accrualSchedule;
		}
		
		@Override
		public LegacyAccrualPeriod.LegacyAccrualPeriodBuilder getOrCreateAccrualSchedule(int index) {
			if (accrualSchedule==null) {
				this.accrualSchedule = new ArrayList<>();
			}
			return getIndex(accrualSchedule, index, () -> {
						LegacyAccrualPeriod.LegacyAccrualPeriodBuilder newAccrualSchedule = LegacyAccrualPeriod.builder();
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
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractReference")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("calculationMethod")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setCalculationMethod(InterestCalculationMethodEnum _calculationMethod) {
			this.calculationMethod = _calculationMethod == null ? null : _calculationMethod;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accrualSchedule")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addAccrualSchedule(LegacyAccrualPeriod _accrualSchedule) {
			if (_accrualSchedule != null) {
				this.accrualSchedule.add(_accrualSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addAccrualSchedule(LegacyAccrualPeriod _accrualSchedule, int idx) {
			getIndex(this.accrualSchedule, idx, () -> _accrualSchedule.toBuilder());
			return this;
		}
		
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder addAccrualSchedule(List<? extends LegacyAccrualPeriod> accrualSchedules) {
			if (accrualSchedules != null) {
				for (final LegacyAccrualPeriod toAdd : accrualSchedules) {
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
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setAccrualSchedule(List<? extends LegacyAccrualPeriod> accrualSchedules) {
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
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder setProjection(PaymentProjection _projection) {
			this.projection = _projection == null ? null : _projection.toBuilder();
			return this;
		}
		
		@Override
		public LegacyInterestCapitalization build() {
			return new LegacyInterestCapitalization.LegacyInterestCapitalizationImpl(this);
		}
		
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			accrualSchedule = accrualSchedule.stream().filter(b->b!=null).<LegacyAccrualPeriod.LegacyAccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (projection!=null && !projection.prune().hasData()) projection = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getCalculationMethod()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccrualSchedule()!=null && getAccrualSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProjection()!=null && getProjection().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder o = (LegacyInterestCapitalization.LegacyInterestCapitalizationBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccrualSchedule(), o.getAccrualSchedule(), this::getOrCreateAccrualSchedule);
			merger.mergeRosetta(getProjection(), o.getProjection(), this::setProjection);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getCalculationMethod(), o.getCalculationMethod(), this::setCalculationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LegacyInterestCapitalization _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
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
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			_result = 31 * _result + (projection != null ? projection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyInterestCapitalizationBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"amount=" + this.amount + ", " +
				"accrualSchedule=" + this.accrualSchedule + ", " +
				"projection=" + this.projection +
			'}' + " " + super.toString();
		}
	}
}
