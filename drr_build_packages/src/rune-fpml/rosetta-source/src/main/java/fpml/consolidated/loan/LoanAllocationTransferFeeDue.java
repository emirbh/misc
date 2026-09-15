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
import fpml.consolidated.loan.meta.LoanAllocationTransferFeeDueMeta;
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
 * Provision A structure that defines details related to the admin agent's determination of transfer fee(s) due on an allocation.
 *
 */
@RosettaDataType(value="LoanAllocationTransferFeeDue", builder=LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationTransferFeeDue", model="fpml", builder=LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilderImpl.class, version="2.1.1")
public interface LoanAllocationTransferFeeDue extends AbstractLoanAllocationEvent {

	LoanAllocationTransferFeeDueMeta metaData = new LoanAllocationTransferFeeDueMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Amount of transfer fee due to the admin agent for the allocation.
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
	LoanAllocationTransferFeeDue build();
	
	LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder toBuilder();
	
	static LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder builder() {
		return new LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationTransferFeeDue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationTransferFeeDue> getType() {
		return LoanAllocationTransferFeeDue.class;
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
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("dueDate"), ZonedDateTime.class, getDueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationTransferFeeDueBuilder extends LoanAllocationTransferFeeDue, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setComment(String comment);
		@Override
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setAllocationReference(LoanAllocationReference allocationReference);
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setAmount(NonNegativeMoney amount);
		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setDueDate(ZonedDateTime dueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.ParentEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getPreviousEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.CashPayableBuilder.class, getCashPayable());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("dueDate"), ZonedDateTime.class, getDueDate(), this);
		}
		

		LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationTransferFeeDue  ***********************/
	class LoanAllocationTransferFeeDueImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements LoanAllocationTransferFeeDue {
		private final NonNegativeMoney amount;
		private final ZonedDateTime dueDate;
		
		protected LoanAllocationTransferFeeDueImpl(LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder builder) {
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
		public LoanAllocationTransferFeeDue build() {
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder toBuilder() {
			LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getDueDate()).ifPresent(builder::setDueDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeDue _that = getType().cast(o);
		
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
			return "LoanAllocationTransferFeeDue {" +
				"amount=" + this.amount + ", " +
				"dueDate=" + this.dueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationTransferFeeDue  ***********************/
	class LoanAllocationTransferFeeDueBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl implements LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder {
	
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
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setAllocationReference(LoanAllocationReference _allocationReference) {
			this.allocationReference = _allocationReference == null ? null : _allocationReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dueDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dueDate")
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder setDueDate(ZonedDateTime _dueDate) {
			this.dueDate = _dueDate == null ? null : _dueDate;
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeDue build() {
			return new LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueImpl(this);
		}
		
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder prune() {
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
		public LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder o = (LoanAllocationTransferFeeDue.LoanAllocationTransferFeeDueBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getDueDate(), o.getDueDate(), this::setDueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeDue _that = getType().cast(o);
		
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
			return "LoanAllocationTransferFeeDueBuilder {" +
				"amount=" + this.amount + ", " +
				"dueDate=" + this.dueDate +
			'}' + " " + super.toString();
		}
	}
}
