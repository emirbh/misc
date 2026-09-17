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
import fpml.consolidated.loan.meta.AbstractLoanAllocationEventMeta;
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
 * Provision An abstract structure defining fundamental allocation event information.
 *
 */
@RosettaDataType(value="AbstractLoanAllocationEvent", builder=AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanAllocationEvent", model="fpml", builder=AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl.class, version="2.1.1")
public interface AbstractLoanAllocationEvent extends AbstractLoanEvent {

	AbstractLoanAllocationEventMeta metaData = new AbstractLoanAllocationEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to an allocation.
	 *
	 */
	LoanAllocationReference getAllocationReference();

	/*********************** Build Methods  ***********************/
	AbstractLoanAllocationEvent build();
	
	AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder toBuilder();
	
	static AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder builder() {
		return new AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanAllocationEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanAllocationEvent> getType() {
		return AbstractLoanAllocationEvent.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanAllocationEventBuilder extends AbstractLoanAllocationEvent, AbstractLoanEvent.AbstractLoanEventBuilder {
		LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference();
		@Override
		LoanAllocationReference.LoanAllocationReferenceBuilder getAllocationReference();
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setComment(String comment);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setAllocationReference(LoanAllocationReference allocationReference);

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
		}
		

		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanAllocationEvent  ***********************/
	class AbstractLoanAllocationEventImpl extends AbstractLoanEvent.AbstractLoanEventImpl implements AbstractLoanAllocationEvent {
		private final LoanAllocationReference allocationReference;
		
		protected AbstractLoanAllocationEventImpl(AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder builder) {
			super(builder);
			this.allocationReference = ofNullable(builder.getAllocationReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocationReference")
		public LoanAllocationReference getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public AbstractLoanAllocationEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder toBuilder() {
			AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAllocationReference()).ifPresent(builder::setAllocationReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationEvent _that = getType().cast(o);
		
			if (!Objects.equals(allocationReference, _that.getAllocationReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationEvent {" +
				"allocationReference=" + this.allocationReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanAllocationEvent  ***********************/
	class AbstractLoanAllocationEventBuilderImpl extends AbstractLoanEvent.AbstractLoanEventBuilderImpl implements AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
	
		protected LoanAllocationReference.LoanAllocationReferenceBuilder allocationReference;
		
		@Override
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocationReference")
		public LoanAllocationReference.LoanAllocationReferenceBuilder getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference() {
			LoanAllocationReference.LoanAllocationReferenceBuilder result;
			if (allocationReference!=null) {
				result = allocationReference;
			}
			else {
				result = allocationReference = LoanAllocationReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationReference")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setAllocationReference(LoanAllocationReference _allocationReference) {
			this.allocationReference = _allocationReference == null ? null : _allocationReference.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLoanAllocationEvent build() {
			return new AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl(this);
		}
		
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder prune() {
			super.prune();
			if (allocationReference!=null && !allocationReference.prune().hasData()) allocationReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAllocationReference()!=null && getAllocationReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder o = (AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder) other;
			
			merger.mergeRosetta(getAllocationReference(), o.getAllocationReference(), this::setAllocationReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationEvent _that = getType().cast(o);
		
			if (!Objects.equals(allocationReference, _that.getAllocationReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationEventBuilder {" +
				"allocationReference=" + this.allocationReference +
			'}' + " " + super.toString();
		}
	}
}
