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
import fpml.consolidated.loan.meta.LoanTradeTransferFeeDueMeta;
import fpml.consolidated.shared.NonNegativeMoney;
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
 * Provision A structure that defines details related to the admin agent's determination of transfer fee(s) due on a trade.
 *
 */
@RosettaDataType(value="LoanTradeTransferFeeDue", builder=LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeTransferFeeDue", model="fpml", builder=LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilderImpl.class, version="2.1.1")
public interface LoanTradeTransferFeeDue extends AbstractLoanTradeEvent {

	LoanTradeTransferFeeDueMeta metaData = new LoanTradeTransferFeeDueMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Amount of transfer fee owed to the admin agent for the trade.
	 *
	 */
	NonNegativeMoney getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The business date on which the transfer fee is due.
	 *
	 */
	ZonedDateTime getDueDate();

	/*********************** Build Methods  ***********************/
	LoanTradeTransferFeeDue build();
	
	LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder toBuilder();
	
	static LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder builder() {
		return new LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeTransferFeeDue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeTransferFeeDue> getType() {
		return LoanTradeTransferFeeDue.class;
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
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("dueDate"), ZonedDateTime.class, getDueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeTransferFeeDueBuilder extends LoanTradeTransferFeeDue, AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setComment(String comment);
		@Override
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setAmount(NonNegativeMoney amount);
		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setDueDate(ZonedDateTime dueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.ParentEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getPreviousEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.CashPayableBuilder.class, getCashPayable());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("dueDate"), ZonedDateTime.class, getDueDate(), this);
		}
		

		LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeTransferFeeDue  ***********************/
	class LoanTradeTransferFeeDueImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventImpl implements LoanTradeTransferFeeDue {
		private final NonNegativeMoney amount;
		private final ZonedDateTime dueDate;
		
		protected LoanTradeTransferFeeDueImpl(LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.dueDate = builder.getDueDate();
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("dueDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dueDate")
		public ZonedDateTime getDueDate() {
			return dueDate;
		}
		
		@Override
		public LoanTradeTransferFeeDue build() {
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder toBuilder() {
			LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getDueDate()).ifPresent(builder::setDueDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeDue _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(dueDate, _that.getDueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (dueDate != null ? dueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeTransferFeeDue {" +
				"amount=" + this.amount + ", " +
				"dueDate=" + this.dueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeTransferFeeDue  ***********************/
	class LoanTradeTransferFeeDueBuilderImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl implements LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected ZonedDateTime dueDate;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dueDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dueDate")
		public ZonedDateTime getDueDate() {
			return dueDate;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dueDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dueDate")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder setDueDate(ZonedDateTime _dueDate) {
			this.dueDate = _dueDate == null ? null : _dueDate;
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeDue build() {
			return new LoanTradeTransferFeeDue.LoanTradeTransferFeeDueImpl(this);
		}
		
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getDueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder o = (LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getDueDate(), o.getDueDate(), this::setDueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeDue _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(dueDate, _that.getDueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (dueDate != null ? dueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeTransferFeeDueBuilder {" +
				"amount=" + this.amount + ", " +
				"dueDate=" + this.dueDate +
			'}' + " " + super.toString();
		}
	}
}
