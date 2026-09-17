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
import fpml.consolidated.fpmlenum.InterestCalculationMethodEnum;
import fpml.consolidated.loan.meta.InterestPaymentMeta;
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
 * Provision 
 *
 */
@RosettaDataType(value="InterestPayment", builder=InterestPayment.InterestPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InterestPayment", model="fpml", builder=InterestPayment.InterestPaymentBuilderImpl.class, version="2.1.1")
public interface InterestPayment extends LoanInterestPayment {

	InterestPaymentMeta metaData = new InterestPaymentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	InterestPayment build();
	
	InterestPayment.InterestPaymentBuilder toBuilder();
	
	static InterestPayment.InterestPaymentBuilder builder() {
		return new InterestPayment.InterestPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestPayment> getType() {
		return InterestPayment.class;
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
	interface InterestPaymentBuilder extends InterestPayment, LoanInterestPayment.LoanInterestPaymentBuilder {
		@Override
		InterestPayment.InterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		InterestPayment.InterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		InterestPayment.InterestPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		InterestPayment.InterestPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		InterestPayment.InterestPaymentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		InterestPayment.InterestPaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		InterestPayment.InterestPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		InterestPayment.InterestPaymentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		InterestPayment.InterestPaymentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		InterestPayment.InterestPaymentBuilder setComment(String comment);
		@Override
		InterestPayment.InterestPaymentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		InterestPayment.InterestPaymentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		InterestPayment.InterestPaymentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		InterestPayment.InterestPaymentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		InterestPayment.InterestPaymentBuilder setLoanContractReference(LoanContractReference loanContractReference);
		@Override
		InterestPayment.InterestPaymentBuilder setStartDate(ZonedDateTime startDate);
		@Override
		InterestPayment.InterestPaymentBuilder setEndDate(ZonedDateTime endDate);
		@Override
		InterestPayment.InterestPaymentBuilder setLenderShareCalculationMethod(InterestCalculationMethodEnum lenderShareCalculationMethod);
		@Override
		InterestPayment.InterestPaymentBuilder setAmount(MoneyWithParticipantShare amount);
		@Override
		InterestPayment.InterestPaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule);
		@Override
		InterestPayment.InterestPaymentBuilder addAccrualSchedule(AccrualPeriod accrualSchedule, int idx);
		@Override
		InterestPayment.InterestPaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule);
		@Override
		InterestPayment.InterestPaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule);
		@Override
		InterestPayment.InterestPaymentBuilder setProjection(PaymentProjection projection);

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
		

		InterestPayment.InterestPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of InterestPayment  ***********************/
	class InterestPaymentImpl extends LoanInterestPayment.LoanInterestPaymentImpl implements InterestPayment {
		
		protected InterestPaymentImpl(InterestPayment.InterestPaymentBuilder builder) {
			super(builder);
		}
		
		@Override
		public InterestPayment build() {
			return this;
		}
		
		@Override
		public InterestPayment.InterestPaymentBuilder toBuilder() {
			InterestPayment.InterestPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestPayment.InterestPaymentBuilder builder) {
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
			return "InterestPayment {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestPayment  ***********************/
	class InterestPaymentBuilderImpl extends LoanInterestPayment.LoanInterestPaymentBuilderImpl implements InterestPayment.InterestPaymentBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public InterestPayment.InterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public InterestPayment.InterestPaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public InterestPayment.InterestPaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public InterestPayment.InterestPaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public InterestPayment.InterestPaymentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public InterestPayment.InterestPaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public InterestPayment.InterestPaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public InterestPayment.InterestPaymentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public InterestPayment.InterestPaymentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public InterestPayment.InterestPaymentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public InterestPayment.InterestPaymentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public InterestPayment.InterestPaymentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public InterestPayment.InterestPaymentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public InterestPayment.InterestPaymentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractReference")
		@Override
		public InterestPayment.InterestPaymentBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public InterestPayment.InterestPaymentBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public InterestPayment.InterestPaymentBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("lenderShareCalculationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lenderShareCalculationMethod")
		@Override
		public InterestPayment.InterestPaymentBuilder setLenderShareCalculationMethod(InterestCalculationMethodEnum _lenderShareCalculationMethod) {
			this.lenderShareCalculationMethod = _lenderShareCalculationMethod == null ? null : _lenderShareCalculationMethod;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public InterestPayment.InterestPaymentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accrualSchedule")
		@Override
		public InterestPayment.InterestPaymentBuilder addAccrualSchedule(AccrualPeriod _accrualSchedule) {
			if (_accrualSchedule != null) {
				this.accrualSchedule.add(_accrualSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public InterestPayment.InterestPaymentBuilder addAccrualSchedule(AccrualPeriod _accrualSchedule, int idx) {
			getIndex(this.accrualSchedule, idx, () -> _accrualSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InterestPayment.InterestPaymentBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
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
		public InterestPayment.InterestPaymentBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
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
		public InterestPayment.InterestPaymentBuilder setProjection(PaymentProjection _projection) {
			this.projection = _projection == null ? null : _projection.toBuilder();
			return this;
		}
		
		@Override
		public InterestPayment build() {
			return new InterestPayment.InterestPaymentImpl(this);
		}
		
		@Override
		public InterestPayment.InterestPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestPayment.InterestPaymentBuilder prune() {
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
		public InterestPayment.InterestPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			InterestPayment.InterestPaymentBuilder o = (InterestPayment.InterestPaymentBuilder) other;
			
			
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
			return "InterestPaymentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
