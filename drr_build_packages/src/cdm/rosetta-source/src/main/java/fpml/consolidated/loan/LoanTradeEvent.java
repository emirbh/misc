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
import fpml.consolidated.loan.meta.LoanTradeEventMeta;
import fpml.consolidated.shared.PartyReference;
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
 * Provision An event structure defining counterparty-to-counterparty loan trade information. This structure contains the main (e.g. fund manager/main counterparty) trade details.
 *
 */
@RosettaDataType(value="LoanTradeEvent", builder=LoanTradeEvent.LoanTradeEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeEvent", model="fpml", builder=LoanTradeEvent.LoanTradeEventBuilderImpl.class, version="2.1.1")
public interface LoanTradeEvent extends AbstractLoanTradeEvent {

	LoanTradeEventMeta metaData = new LoanTradeEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LoanTradeEvent build();
	
	LoanTradeEvent.LoanTradeEventBuilder toBuilder();
	
	static LoanTradeEvent.LoanTradeEventBuilder builder() {
		return new LoanTradeEvent.LoanTradeEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeEvent> getType() {
		return LoanTradeEvent.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeEventBuilder extends LoanTradeEvent, AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder {
		@Override
		LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder setComment(String comment);
		@Override
		LoanTradeEvent.LoanTradeEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);

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
		}
		

		LoanTradeEvent.LoanTradeEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeEvent  ***********************/
	class LoanTradeEventImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventImpl implements LoanTradeEvent {
		
		protected LoanTradeEventImpl(LoanTradeEvent.LoanTradeEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public LoanTradeEvent build() {
			return this;
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder toBuilder() {
			LoanTradeEvent.LoanTradeEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeEvent.LoanTradeEventBuilder builder) {
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
			return "LoanTradeEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeEvent  ***********************/
	class LoanTradeEventBuilderImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl implements LoanTradeEvent.LoanTradeEventBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeEvent.LoanTradeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeEvent.LoanTradeEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradeEvent build() {
			return new LoanTradeEvent.LoanTradeEventImpl(this);
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder prune() {
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
		public LoanTradeEvent.LoanTradeEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeEvent.LoanTradeEventBuilder o = (LoanTradeEvent.LoanTradeEventBuilder) other;
			
			
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
			return "LoanTradeEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
