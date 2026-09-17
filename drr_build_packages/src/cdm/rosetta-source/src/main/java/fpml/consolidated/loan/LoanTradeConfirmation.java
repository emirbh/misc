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
import fpml.consolidated.loan.meta.LoanTradeConfirmationMeta;
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
 * Provision 
 *
 */
@RosettaDataType(value="LoanTradeConfirmation", builder=LoanTradeConfirmation.LoanTradeConfirmationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeConfirmation", model="fpml", builder=LoanTradeConfirmation.LoanTradeConfirmationBuilderImpl.class, version="2.1.1")
public interface LoanTradeConfirmation extends LoanTradeEvent {

	LoanTradeConfirmationMeta metaData = new LoanTradeConfirmationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LoanTradeConfirmation build();
	
	LoanTradeConfirmation.LoanTradeConfirmationBuilder toBuilder();
	
	static LoanTradeConfirmation.LoanTradeConfirmationBuilder builder() {
		return new LoanTradeConfirmation.LoanTradeConfirmationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeConfirmation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeConfirmation> getType() {
		return LoanTradeConfirmation.class;
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
	interface LoanTradeConfirmationBuilder extends LoanTradeConfirmation, LoanTradeEvent.LoanTradeEventBuilder {
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder setComment(String comment);
		@Override
		LoanTradeConfirmation.LoanTradeConfirmationBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);

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
		

		LoanTradeConfirmation.LoanTradeConfirmationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeConfirmation  ***********************/
	class LoanTradeConfirmationImpl extends LoanTradeEvent.LoanTradeEventImpl implements LoanTradeConfirmation {
		
		protected LoanTradeConfirmationImpl(LoanTradeConfirmation.LoanTradeConfirmationBuilder builder) {
			super(builder);
		}
		
		@Override
		public LoanTradeConfirmation build() {
			return this;
		}
		
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder toBuilder() {
			LoanTradeConfirmation.LoanTradeConfirmationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeConfirmation.LoanTradeConfirmationBuilder builder) {
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
			return "LoanTradeConfirmation {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeConfirmation  ***********************/
	class LoanTradeConfirmationBuilderImpl extends LoanTradeEvent.LoanTradeEventBuilderImpl implements LoanTradeConfirmation.LoanTradeConfirmationBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradeConfirmation build() {
			return new LoanTradeConfirmation.LoanTradeConfirmationImpl(this);
		}
		
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder prune() {
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
		public LoanTradeConfirmation.LoanTradeConfirmationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeConfirmation.LoanTradeConfirmationBuilder o = (LoanTradeConfirmation.LoanTradeConfirmationBuilder) other;
			
			
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
			return "LoanTradeConfirmationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
