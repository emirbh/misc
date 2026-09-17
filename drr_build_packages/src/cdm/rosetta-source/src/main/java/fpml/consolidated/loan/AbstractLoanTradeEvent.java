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
import fpml.consolidated.loan.meta.AbstractLoanTradeEventMeta;
import fpml.consolidated.shared.PartyReference;
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
 * Provision An abstract structure defining fundamental master loan trade event information.
 *
 */
@RosettaDataType(value="AbstractLoanTradeEvent", builder=AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanTradeEvent", model="fpml", builder=AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl.class, version="2.1.1")
public interface AbstractLoanTradeEvent extends AbstractLoanEvent {

	AbstractLoanTradeEventMeta metaData = new AbstractLoanTradeEventMeta();

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
	LoanTradeReference getLoanTradeReference();

	/*********************** Build Methods  ***********************/
	AbstractLoanTradeEvent build();
	
	AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder toBuilder();
	
	static AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder builder() {
		return new AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanTradeEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanTradeEvent> getType() {
		return AbstractLoanTradeEvent.class;
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
	interface AbstractLoanTradeEventBuilder extends AbstractLoanTradeEvent, AbstractLoanEvent.AbstractLoanEventBuilder {
		LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference();
		@Override
		LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference();
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setComment(String comment);
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);

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
		

		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanTradeEvent  ***********************/
	class AbstractLoanTradeEventImpl extends AbstractLoanEvent.AbstractLoanEventImpl implements AbstractLoanTradeEvent {
		private final LoanTradeReference loanTradeReference;
		
		protected AbstractLoanTradeEventImpl(AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder builder) {
			super(builder);
			this.loanTradeReference = ofNullable(builder.getLoanTradeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		public LoanTradeReference getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public AbstractLoanTradeEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder toBuilder() {
			AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradeReference()).ifPresent(builder::setLoanTradeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTradeEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTradeEvent {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanTradeEvent  ***********************/
	class AbstractLoanTradeEventBuilderImpl extends AbstractLoanEvent.AbstractLoanEventBuilderImpl implements AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder {
	
		protected LoanTradeReference.LoanTradeReferenceBuilder loanTradeReference;
		
		@Override
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		public LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference() {
			LoanTradeReference.LoanTradeReferenceBuilder result;
			if (loanTradeReference!=null) {
				result = loanTradeReference;
			}
			else {
				result = loanTradeReference = LoanTradeReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLoanTradeEvent build() {
			return new AbstractLoanTradeEvent.AbstractLoanTradeEventImpl(this);
		}
		
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder prune() {
			super.prune();
			if (loanTradeReference!=null && !loanTradeReference.prune().hasData()) loanTradeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradeReference()!=null && getLoanTradeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder o = (AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder) other;
			
			merger.mergeRosetta(getLoanTradeReference(), o.getLoanTradeReference(), this::setLoanTradeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTradeEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTradeEventBuilder {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}
}
