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
import fpml.consolidated.loan.meta.RepaymentMeta;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
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
 * Provision An event representing a principal repayment being made by the borrower.
 *
 */
@RosettaDataType(value="Repayment", builder=Repayment.RepaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Repayment", model="fpml", builder=Repayment.RepaymentBuilderImpl.class, version="2.1.1")
public interface Repayment extends AbstractLoanContractEvent {

	RepaymentMeta metaData = new RepaymentMeta();

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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The price at which the repayment occurred. This is usually Par but there could be scenarios where a repayment was made at a discounted level.
	 *
	 */
	BigDecimal getPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether the lender has an option to accept or deny the payment.
	 *
	 */
	Boolean getRefusalAllowed();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether the repayment is mandatory from the borrower's perspective, based on the (amortization) schedule on the credit agreement.
	 *
	 */
	Boolean getBorrowerMandatory();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether the repayment is a scheduled repayment. This is normally the case when the repayment is defined on the amortization schedule associated with the facility (on the credit agreement).
	 *
	 */
	Boolean getScheduledRepayment();

	/*********************** Build Methods  ***********************/
	Repayment build();
	
	Repayment.RepaymentBuilder toBuilder();
	
	static Repayment.RepaymentBuilder builder() {
		return new Repayment.RepaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Repayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Repayment> getType() {
		return Repayment.class;
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
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processor.processBasic(path.newSubPath("refusalAllowed"), Boolean.class, getRefusalAllowed(), this);
		processor.processBasic(path.newSubPath("borrowerMandatory"), Boolean.class, getBorrowerMandatory(), this);
		processor.processBasic(path.newSubPath("scheduledRepayment"), Boolean.class, getScheduledRepayment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepaymentBuilder extends Repayment, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		@Override
		Repayment.RepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		Repayment.RepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		Repayment.RepaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		Repayment.RepaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		Repayment.RepaymentBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		Repayment.RepaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		Repayment.RepaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		Repayment.RepaymentBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		Repayment.RepaymentBuilder setCashPayable(CashPayable cashPayable);
		@Override
		Repayment.RepaymentBuilder setComment(String comment);
		@Override
		Repayment.RepaymentBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		Repayment.RepaymentBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		Repayment.RepaymentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		Repayment.RepaymentBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		Repayment.RepaymentBuilder setLoanContractReference(LoanContractReference loanContractReference);
		Repayment.RepaymentBuilder setAmount(MoneyWithParticipantShare amount);
		Repayment.RepaymentBuilder setPrice(BigDecimal price);
		Repayment.RepaymentBuilder setRefusalAllowed(Boolean refusalAllowed);
		Repayment.RepaymentBuilder setBorrowerMandatory(Boolean borrowerMandatory);
		Repayment.RepaymentBuilder setScheduledRepayment(Boolean scheduledRepayment);

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
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processor.processBasic(path.newSubPath("refusalAllowed"), Boolean.class, getRefusalAllowed(), this);
			processor.processBasic(path.newSubPath("borrowerMandatory"), Boolean.class, getBorrowerMandatory(), this);
			processor.processBasic(path.newSubPath("scheduledRepayment"), Boolean.class, getScheduledRepayment(), this);
		}
		

		Repayment.RepaymentBuilder prune();
	}

	/*********************** Immutable Implementation of Repayment  ***********************/
	class RepaymentImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements Repayment {
		private final MoneyWithParticipantShare amount;
		private final BigDecimal price;
		private final Boolean refusalAllowed;
		private final Boolean borrowerMandatory;
		private final Boolean scheduledRepayment;
		
		protected RepaymentImpl(Repayment.RepaymentBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.price = builder.getPrice();
			this.refusalAllowed = builder.getRefusalAllowed();
			this.borrowerMandatory = builder.getBorrowerMandatory();
			this.scheduledRepayment = builder.getScheduledRepayment();
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
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("refusalAllowed")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("refusalAllowed")
		public Boolean getRefusalAllowed() {
			return refusalAllowed;
		}
		
		@Override
		@RosettaAttribute("borrowerMandatory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("borrowerMandatory")
		public Boolean getBorrowerMandatory() {
			return borrowerMandatory;
		}
		
		@Override
		@RosettaAttribute("scheduledRepayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scheduledRepayment")
		public Boolean getScheduledRepayment() {
			return scheduledRepayment;
		}
		
		@Override
		public Repayment build() {
			return this;
		}
		
		@Override
		public Repayment.RepaymentBuilder toBuilder() {
			Repayment.RepaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Repayment.RepaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getRefusalAllowed()).ifPresent(builder::setRefusalAllowed);
			ofNullable(getBorrowerMandatory()).ifPresent(builder::setBorrowerMandatory);
			ofNullable(getScheduledRepayment()).ifPresent(builder::setScheduledRepayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Repayment _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(refusalAllowed, _that.getRefusalAllowed())) return false;
			if (!Objects.equals(borrowerMandatory, _that.getBorrowerMandatory())) return false;
			if (!Objects.equals(scheduledRepayment, _that.getScheduledRepayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (refusalAllowed != null ? refusalAllowed.hashCode() : 0);
			_result = 31 * _result + (borrowerMandatory != null ? borrowerMandatory.hashCode() : 0);
			_result = 31 * _result + (scheduledRepayment != null ? scheduledRepayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Repayment {" +
				"amount=" + this.amount + ", " +
				"price=" + this.price + ", " +
				"refusalAllowed=" + this.refusalAllowed + ", " +
				"borrowerMandatory=" + this.borrowerMandatory + ", " +
				"scheduledRepayment=" + this.scheduledRepayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Repayment  ***********************/
	class RepaymentBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl implements Repayment.RepaymentBuilder {
	
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected BigDecimal price;
		protected Boolean refusalAllowed;
		protected Boolean borrowerMandatory;
		protected Boolean scheduledRepayment;
		
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
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("refusalAllowed")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("refusalAllowed")
		public Boolean getRefusalAllowed() {
			return refusalAllowed;
		}
		
		@Override
		@RosettaAttribute("borrowerMandatory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("borrowerMandatory")
		public Boolean getBorrowerMandatory() {
			return borrowerMandatory;
		}
		
		@Override
		@RosettaAttribute("scheduledRepayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scheduledRepayment")
		public Boolean getScheduledRepayment() {
			return scheduledRepayment;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public Repayment.RepaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Repayment.RepaymentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Repayment.RepaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public Repayment.RepaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public Repayment.RepaymentBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public Repayment.RepaymentBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public Repayment.RepaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public Repayment.RepaymentBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public Repayment.RepaymentBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public Repayment.RepaymentBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public Repayment.RepaymentBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public Repayment.RepaymentBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public Repayment.RepaymentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public Repayment.RepaymentBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractReference")
		@Override
		public Repayment.RepaymentBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public Repayment.RepaymentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("price")
		@Override
		public Repayment.RepaymentBuilder setPrice(BigDecimal _price) {
			this.price = _price == null ? null : _price;
			return this;
		}
		
		@RosettaAttribute("refusalAllowed")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("refusalAllowed")
		@Override
		public Repayment.RepaymentBuilder setRefusalAllowed(Boolean _refusalAllowed) {
			this.refusalAllowed = _refusalAllowed == null ? null : _refusalAllowed;
			return this;
		}
		
		@RosettaAttribute("borrowerMandatory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerMandatory")
		@Override
		public Repayment.RepaymentBuilder setBorrowerMandatory(Boolean _borrowerMandatory) {
			this.borrowerMandatory = _borrowerMandatory == null ? null : _borrowerMandatory;
			return this;
		}
		
		@RosettaAttribute("scheduledRepayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scheduledRepayment")
		@Override
		public Repayment.RepaymentBuilder setScheduledRepayment(Boolean _scheduledRepayment) {
			this.scheduledRepayment = _scheduledRepayment == null ? null : _scheduledRepayment;
			return this;
		}
		
		@Override
		public Repayment build() {
			return new Repayment.RepaymentImpl(this);
		}
		
		@Override
		public Repayment.RepaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Repayment.RepaymentBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getPrice()!=null) return true;
			if (getRefusalAllowed()!=null) return true;
			if (getBorrowerMandatory()!=null) return true;
			if (getScheduledRepayment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Repayment.RepaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Repayment.RepaymentBuilder o = (Repayment.RepaymentBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeBasic(getRefusalAllowed(), o.getRefusalAllowed(), this::setRefusalAllowed);
			merger.mergeBasic(getBorrowerMandatory(), o.getBorrowerMandatory(), this::setBorrowerMandatory);
			merger.mergeBasic(getScheduledRepayment(), o.getScheduledRepayment(), this::setScheduledRepayment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Repayment _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(refusalAllowed, _that.getRefusalAllowed())) return false;
			if (!Objects.equals(borrowerMandatory, _that.getBorrowerMandatory())) return false;
			if (!Objects.equals(scheduledRepayment, _that.getScheduledRepayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (refusalAllowed != null ? refusalAllowed.hashCode() : 0);
			_result = 31 * _result + (borrowerMandatory != null ? borrowerMandatory.hashCode() : 0);
			_result = 31 * _result + (scheduledRepayment != null ? scheduledRepayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepaymentBuilder {" +
				"amount=" + this.amount + ", " +
				"price=" + this.price + ", " +
				"refusalAllowed=" + this.refusalAllowed + ", " +
				"borrowerMandatory=" + this.borrowerMandatory + ", " +
				"scheduledRepayment=" + this.scheduledRepayment +
			'}' + " " + super.toString();
		}
	}
}
