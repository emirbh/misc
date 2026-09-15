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
import fpml.consolidated.loan.meta.LoanAllocationSettlementDateFinalizationMeta;
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
 * Provision An event structure defining the trade settlement date.
 *
 */
@RosettaDataType(value="LoanAllocationSettlementDateFinalization", builder=LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationSettlementDateFinalization", model="fpml", builder=LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilderImpl.class, version="2.1.1")
public interface LoanAllocationSettlementDateFinalization extends AbstractLoanAllocationEvent {

	LoanAllocationSettlementDateFinalizationMeta metaData = new LoanAllocationSettlementDateFinalizationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The settlement date associated with a single loan trade allocation.
	 *
	 */
	ZonedDateTime getSettlementDate();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementDateFinalization build();
	
	LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder toBuilder();
	
	static LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder builder() {
		return new LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementDateFinalization> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationSettlementDateFinalization> getType() {
		return LoanAllocationSettlementDateFinalization.class;
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
		processor.processBasic(path.newSubPath("settlementDate"), ZonedDateTime.class, getSettlementDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementDateFinalizationBuilder extends LoanAllocationSettlementDateFinalization, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setComment(String comment);
		@Override
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setAllocationReference(LoanAllocationReference allocationReference);
		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setSettlementDate(ZonedDateTime settlementDate);

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
			processor.processBasic(path.newSubPath("settlementDate"), ZonedDateTime.class, getSettlementDate(), this);
		}
		

		LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementDateFinalization  ***********************/
	class LoanAllocationSettlementDateFinalizationImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements LoanAllocationSettlementDateFinalization {
		private final ZonedDateTime settlementDate;
		
		protected LoanAllocationSettlementDateFinalizationImpl(LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder builder) {
			super(builder);
			this.settlementDate = builder.getSettlementDate();
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementDate")
		public ZonedDateTime getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalization build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder toBuilder() {
			LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementDateFinalization _that = getType().cast(o);
		
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementDateFinalization {" +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementDateFinalization  ***********************/
	class LoanAllocationSettlementDateFinalizationBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl implements LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder {
	
		protected ZonedDateTime settlementDate;
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementDate")
		public ZonedDateTime getSettlementDate() {
			return settlementDate;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setAllocationReference(LoanAllocationReference _allocationReference) {
			this.allocationReference = _allocationReference == null ? null : _allocationReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder setSettlementDate(ZonedDateTime _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate;
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateFinalization build() {
			return new LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder o = (LoanAllocationSettlementDateFinalization.LoanAllocationSettlementDateFinalizationBuilder) other;
			
			
			merger.mergeBasic(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementDateFinalization _that = getType().cast(o);
		
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementDateFinalizationBuilder {" +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}
}
