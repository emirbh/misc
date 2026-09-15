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
import fpml.consolidated.fpmlenum.BreakageCalculatedByEnum;
import fpml.consolidated.loan.meta.BreakageFeePaymentMeta;
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
 * Provision A fee calculated as the cost of breaking financing against a loan contract which is repaid early.
 *
 */
@RosettaDataType(value="BreakageFeePayment", builder=BreakageFeePayment.BreakageFeePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BreakageFeePayment", model="fpml", builder=BreakageFeePayment.BreakageFeePaymentBuilderImpl.class, version="2.1.1")
public interface BreakageFeePayment extends AbstractLoanContractPaymentEvent {

	BreakageFeePaymentMeta metaData = new BreakageFeePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date by which any breakage costs (if applicable) must be submitted by Lenders to the Agent.
	 *
	 */
	ZonedDateTime getBreakageFeeClaimDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Where breakage cost is applicable, this enumeration defines who is calculating it - agent bank or lender.
	 *
	 */
	BreakageCalculatedByEnum getBreakageFeeCalculatedBy();

	/*********************** Build Methods  ***********************/
	BreakageFeePayment build();
	
	BreakageFeePayment.BreakageFeePaymentBuilder toBuilder();
	
	static BreakageFeePayment.BreakageFeePaymentBuilder builder() {
		return new BreakageFeePayment.BreakageFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BreakageFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BreakageFeePayment> getType() {
		return BreakageFeePayment.class;
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
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processor.processBasic(path.newSubPath("breakageFeeClaimDate"), ZonedDateTime.class, getBreakageFeeClaimDate(), this);
		processor.processBasic(path.newSubPath("breakageFeeCalculatedBy"), BreakageCalculatedByEnum.class, getBreakageFeeCalculatedBy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BreakageFeePaymentBuilder extends BreakageFeePayment, AbstractLoanContractPaymentEvent.AbstractLoanContractPaymentEventBuilder {
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setComment(String comment);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setLoanContractReference(LoanContractReference loanContractReference);
		@Override
		BreakageFeePayment.BreakageFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);
		BreakageFeePayment.BreakageFeePaymentBuilder setBreakageFeeClaimDate(ZonedDateTime breakageFeeClaimDate);
		BreakageFeePayment.BreakageFeePaymentBuilder setBreakageFeeCalculatedBy(BreakageCalculatedByEnum breakageFeeCalculatedBy);

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
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("breakageFeeClaimDate"), ZonedDateTime.class, getBreakageFeeClaimDate(), this);
			processor.processBasic(path.newSubPath("breakageFeeCalculatedBy"), BreakageCalculatedByEnum.class, getBreakageFeeCalculatedBy(), this);
		}
		

		BreakageFeePayment.BreakageFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of BreakageFeePayment  ***********************/
	class BreakageFeePaymentImpl extends AbstractLoanContractPaymentEvent.AbstractLoanContractPaymentEventImpl implements BreakageFeePayment {
		private final ZonedDateTime breakageFeeClaimDate;
		private final BreakageCalculatedByEnum breakageFeeCalculatedBy;
		
		protected BreakageFeePaymentImpl(BreakageFeePayment.BreakageFeePaymentBuilder builder) {
			super(builder);
			this.breakageFeeClaimDate = builder.getBreakageFeeClaimDate();
			this.breakageFeeCalculatedBy = builder.getBreakageFeeCalculatedBy();
		}
		
		@Override
		@RosettaAttribute("breakageFeeClaimDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakageFeeClaimDate")
		public ZonedDateTime getBreakageFeeClaimDate() {
			return breakageFeeClaimDate;
		}
		
		@Override
		@RosettaAttribute("breakageFeeCalculatedBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakageFeeCalculatedBy")
		public BreakageCalculatedByEnum getBreakageFeeCalculatedBy() {
			return breakageFeeCalculatedBy;
		}
		
		@Override
		public BreakageFeePayment build() {
			return this;
		}
		
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder toBuilder() {
			BreakageFeePayment.BreakageFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BreakageFeePayment.BreakageFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBreakageFeeClaimDate()).ifPresent(builder::setBreakageFeeClaimDate);
			ofNullable(getBreakageFeeCalculatedBy()).ifPresent(builder::setBreakageFeeCalculatedBy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BreakageFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(breakageFeeClaimDate, _that.getBreakageFeeClaimDate())) return false;
			if (!Objects.equals(breakageFeeCalculatedBy, _that.getBreakageFeeCalculatedBy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (breakageFeeClaimDate != null ? breakageFeeClaimDate.hashCode() : 0);
			_result = 31 * _result + (breakageFeeCalculatedBy != null ? breakageFeeCalculatedBy.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BreakageFeePayment {" +
				"breakageFeeClaimDate=" + this.breakageFeeClaimDate + ", " +
				"breakageFeeCalculatedBy=" + this.breakageFeeCalculatedBy +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BreakageFeePayment  ***********************/
	class BreakageFeePaymentBuilderImpl extends AbstractLoanContractPaymentEvent.AbstractLoanContractPaymentEventBuilderImpl implements BreakageFeePayment.BreakageFeePaymentBuilder {
	
		protected ZonedDateTime breakageFeeClaimDate;
		protected BreakageCalculatedByEnum breakageFeeCalculatedBy;
		
		@Override
		@RosettaAttribute("breakageFeeClaimDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakageFeeClaimDate")
		public ZonedDateTime getBreakageFeeClaimDate() {
			return breakageFeeClaimDate;
		}
		
		@Override
		@RosettaAttribute("breakageFeeCalculatedBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakageFeeCalculatedBy")
		public BreakageCalculatedByEnum getBreakageFeeCalculatedBy() {
			return breakageFeeCalculatedBy;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public BreakageFeePayment.BreakageFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public BreakageFeePayment.BreakageFeePaymentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractReference")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("breakageFeeClaimDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("breakageFeeClaimDate")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setBreakageFeeClaimDate(ZonedDateTime _breakageFeeClaimDate) {
			this.breakageFeeClaimDate = _breakageFeeClaimDate == null ? null : _breakageFeeClaimDate;
			return this;
		}
		
		@RosettaAttribute("breakageFeeCalculatedBy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("breakageFeeCalculatedBy")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder setBreakageFeeCalculatedBy(BreakageCalculatedByEnum _breakageFeeCalculatedBy) {
			this.breakageFeeCalculatedBy = _breakageFeeCalculatedBy == null ? null : _breakageFeeCalculatedBy;
			return this;
		}
		
		@Override
		public BreakageFeePayment build() {
			return new BreakageFeePayment.BreakageFeePaymentImpl(this);
		}
		
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBreakageFeeClaimDate()!=null) return true;
			if (getBreakageFeeCalculatedBy()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BreakageFeePayment.BreakageFeePaymentBuilder o = (BreakageFeePayment.BreakageFeePaymentBuilder) other;
			
			
			merger.mergeBasic(getBreakageFeeClaimDate(), o.getBreakageFeeClaimDate(), this::setBreakageFeeClaimDate);
			merger.mergeBasic(getBreakageFeeCalculatedBy(), o.getBreakageFeeCalculatedBy(), this::setBreakageFeeCalculatedBy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BreakageFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(breakageFeeClaimDate, _that.getBreakageFeeClaimDate())) return false;
			if (!Objects.equals(breakageFeeCalculatedBy, _that.getBreakageFeeCalculatedBy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (breakageFeeClaimDate != null ? breakageFeeClaimDate.hashCode() : 0);
			_result = 31 * _result + (breakageFeeCalculatedBy != null ? breakageFeeCalculatedBy.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BreakageFeePaymentBuilder {" +
				"breakageFeeClaimDate=" + this.breakageFeeClaimDate + ", " +
				"breakageFeeCalculatedBy=" + this.breakageFeeCalculatedBy +
			'}' + " " + super.toString();
		}
	}
}
