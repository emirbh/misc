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
import fpml.consolidated.loan.meta.LoanTradeFeeDueMeta;
import fpml.consolidated.shared.NonNegativeMoney;
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
@RosettaDataType(value="LoanTradeFeeDue", builder=LoanTradeFeeDue.LoanTradeFeeDueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeFeeDue", model="fpml", builder=LoanTradeFeeDue.LoanTradeFeeDueBuilderImpl.class, version="2.1.1")
public interface LoanTradeFeeDue extends LoanTradeTransferFeeDue {

	LoanTradeFeeDueMeta metaData = new LoanTradeFeeDueMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LoanTradeFeeDue build();
	
	LoanTradeFeeDue.LoanTradeFeeDueBuilder toBuilder();
	
	static LoanTradeFeeDue.LoanTradeFeeDueBuilder builder() {
		return new LoanTradeFeeDue.LoanTradeFeeDueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeFeeDue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeFeeDue> getType() {
		return LoanTradeFeeDue.class;
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
	interface LoanTradeFeeDueBuilder extends LoanTradeFeeDue, LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilder {
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setComment(String comment);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setAmount(NonNegativeMoney amount);
		@Override
		LoanTradeFeeDue.LoanTradeFeeDueBuilder setDueDate(ZonedDateTime dueDate);

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
		

		LoanTradeFeeDue.LoanTradeFeeDueBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeFeeDue  ***********************/
	class LoanTradeFeeDueImpl extends LoanTradeTransferFeeDue.LoanTradeTransferFeeDueImpl implements LoanTradeFeeDue {
		
		protected LoanTradeFeeDueImpl(LoanTradeFeeDue.LoanTradeFeeDueBuilder builder) {
			super(builder);
		}
		
		@Override
		public LoanTradeFeeDue build() {
			return this;
		}
		
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder toBuilder() {
			LoanTradeFeeDue.LoanTradeFeeDueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeFeeDue.LoanTradeFeeDueBuilder builder) {
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
			return "LoanTradeFeeDue {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeFeeDue  ***********************/
	class LoanTradeFeeDueBuilderImpl extends LoanTradeTransferFeeDue.LoanTradeTransferFeeDueBuilderImpl implements LoanTradeFeeDue.LoanTradeFeeDueBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dueDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dueDate")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder setDueDate(ZonedDateTime _dueDate) {
			this.dueDate = _dueDate == null ? null : _dueDate;
			return this;
		}
		
		@Override
		public LoanTradeFeeDue build() {
			return new LoanTradeFeeDue.LoanTradeFeeDueImpl(this);
		}
		
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder prune() {
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
		public LoanTradeFeeDue.LoanTradeFeeDueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeFeeDue.LoanTradeFeeDueBuilder o = (LoanTradeFeeDue.LoanTradeFeeDueBuilder) other;
			
			
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
			return "LoanTradeFeeDueBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
