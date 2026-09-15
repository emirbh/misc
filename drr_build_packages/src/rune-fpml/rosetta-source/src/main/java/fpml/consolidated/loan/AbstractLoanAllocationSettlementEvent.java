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
import fpml.consolidated.loan.meta.AbstractLoanAllocationSettlementEventMeta;
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
 * Provision An abstract structure defining fundamental settlement event information.
 *
 */
@RosettaDataType(value="AbstractLoanAllocationSettlementEvent", builder=AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanAllocationSettlementEvent", model="fpml", builder=AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl.class, version="2.1.1")
public interface AbstractLoanAllocationSettlementEvent extends AbstractLoanAllocationEvent {

	AbstractLoanAllocationSettlementEventMeta metaData = new AbstractLoanAllocationSettlementEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which settlement will occur.
	 *
	 */
	ZonedDateTime getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount settled.
	 *
	 */
	NonNegativeMoney getAllocationAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision One or more accrual periods which reflect the constituent portions of the accrual amount.
	 *
	 */
	FacilityPosition getFacilityPosition();

	/*********************** Build Methods  ***********************/
	AbstractLoanAllocationSettlementEvent build();
	
	AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder toBuilder();
	
	static AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder builder() {
		return new AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanAllocationSettlementEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanAllocationSettlementEvent> getType() {
		return AbstractLoanAllocationSettlementEvent.class;
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
		processRosetta(path.newSubPath("allocationAmount"), processor, NonNegativeMoney.class, getAllocationAmount());
		processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.class, getFacilityPosition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanAllocationSettlementEventBuilder extends AbstractLoanAllocationSettlementEvent, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAllocationAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAllocationAmount();
		FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition();
		@Override
		FacilityPosition.FacilityPositionBuilder getFacilityPosition();
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setComment(String comment);
		@Override
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setAllocationReference(LoanAllocationReference allocationReference);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setSettlementDate(ZonedDateTime settlementDate);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setAllocationAmount(NonNegativeMoney allocationAmount);
		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setFacilityPosition(FacilityPosition facilityPosition);

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
			processRosetta(path.newSubPath("allocationAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAllocationAmount());
			processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.FacilityPositionBuilder.class, getFacilityPosition());
		}
		

		AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanAllocationSettlementEvent  ***********************/
	class AbstractLoanAllocationSettlementEventImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements AbstractLoanAllocationSettlementEvent {
		private final ZonedDateTime settlementDate;
		private final NonNegativeMoney allocationAmount;
		private final FacilityPosition facilityPosition;
		
		protected AbstractLoanAllocationSettlementEventImpl(AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder builder) {
			super(builder);
			this.settlementDate = builder.getSettlementDate();
			this.allocationAmount = ofNullable(builder.getAllocationAmount()).map(f->f.build()).orElse(null);
			this.facilityPosition = ofNullable(builder.getFacilityPosition()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("allocationAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocationAmount")
		public NonNegativeMoney getAllocationAmount() {
			return allocationAmount;
		}
		
		@Override
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityPosition")
		public FacilityPosition getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder toBuilder() {
			AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getAllocationAmount()).ifPresent(builder::setAllocationAmount);
			ofNullable(getFacilityPosition()).ifPresent(builder::setFacilityPosition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationSettlementEvent _that = getType().cast(o);
		
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(allocationAmount, _that.getAllocationAmount())) return false;
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (allocationAmount != null ? allocationAmount.hashCode() : 0);
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationSettlementEvent {" +
				"settlementDate=" + this.settlementDate + ", " +
				"allocationAmount=" + this.allocationAmount + ", " +
				"facilityPosition=" + this.facilityPosition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanAllocationSettlementEvent  ***********************/
	class AbstractLoanAllocationSettlementEventBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl implements AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder {
	
		protected ZonedDateTime settlementDate;
		protected NonNegativeMoney.NonNegativeMoneyBuilder allocationAmount;
		protected FacilityPosition.FacilityPositionBuilder facilityPosition;
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementDate")
		public ZonedDateTime getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("allocationAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocationAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAllocationAmount() {
			return allocationAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAllocationAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (allocationAmount!=null) {
				result = allocationAmount;
			}
			else {
				result = allocationAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityPosition")
		public FacilityPosition.FacilityPositionBuilder getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition() {
			FacilityPosition.FacilityPositionBuilder result;
			if (facilityPosition!=null) {
				result = facilityPosition;
			}
			else {
				result = facilityPosition = FacilityPosition.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationReference")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setAllocationReference(LoanAllocationReference _allocationReference) {
			this.allocationReference = _allocationReference == null ? null : _allocationReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setSettlementDate(ZonedDateTime _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate;
			return this;
		}
		
		@RosettaAttribute("allocationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationAmount")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setAllocationAmount(NonNegativeMoney _allocationAmount) {
			this.allocationAmount = _allocationAmount == null ? null : _allocationAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityPosition")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder setFacilityPosition(FacilityPosition _facilityPosition) {
			this.facilityPosition = _facilityPosition == null ? null : _facilityPosition.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent build() {
			return new AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventImpl(this);
		}
		
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder prune() {
			super.prune();
			if (allocationAmount!=null && !allocationAmount.prune().hasData()) allocationAmount = null;
			if (facilityPosition!=null && !facilityPosition.prune().hasData()) facilityPosition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementDate()!=null) return true;
			if (getAllocationAmount()!=null && getAllocationAmount().hasData()) return true;
			if (getFacilityPosition()!=null && getFacilityPosition().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder o = (AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder) other;
			
			merger.mergeRosetta(getAllocationAmount(), o.getAllocationAmount(), this::setAllocationAmount);
			merger.mergeRosetta(getFacilityPosition(), o.getFacilityPosition(), this::setFacilityPosition);
			
			merger.mergeBasic(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationSettlementEvent _that = getType().cast(o);
		
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(allocationAmount, _that.getAllocationAmount())) return false;
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (allocationAmount != null ? allocationAmount.hashCode() : 0);
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationSettlementEventBuilder {" +
				"settlementDate=" + this.settlementDate + ", " +
				"allocationAmount=" + this.allocationAmount + ", " +
				"facilityPosition=" + this.facilityPosition +
			'}' + " " + super.toString();
		}
	}
}
