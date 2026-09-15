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
import fpml.consolidated.loan.meta.LoanAllocationSettlementMeta;
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
 * Provision An event structure defining the counterparty-to-counterparty trade settlement details.
 *
 */
@RosettaDataType(value="LoanAllocationSettlement", builder=LoanAllocationSettlement.LoanAllocationSettlementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationSettlement", model="fpml", builder=LoanAllocationSettlement.LoanAllocationSettlementBuilderImpl.class, version="2.1.1")
public interface LoanAllocationSettlement extends AbstractLoanAllocationSettlementEvent {

	LoanAllocationSettlementMeta metaData = new LoanAllocationSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Factors impacting the setttlement cash flows.
	 *
	 */
	LoanTradingCounterpartySettlementFundingFactors getFundingFactors();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlement build();
	
	LoanAllocationSettlement.LoanAllocationSettlementBuilder toBuilder();
	
	static LoanAllocationSettlement.LoanAllocationSettlementBuilder builder() {
		return new LoanAllocationSettlement.LoanAllocationSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationSettlement> getType() {
		return LoanAllocationSettlement.class;
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
		processRosetta(path.newSubPath("fundingFactors"), processor, LoanTradingCounterpartySettlementFundingFactors.class, getFundingFactors());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementBuilder extends LoanAllocationSettlement, AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder {
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder getOrCreateFundingFactors();
		@Override
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder getFundingFactors();
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setComment(String comment);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setAllocationReference(LoanAllocationReference allocationReference);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setSettlementDate(ZonedDateTime settlementDate);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setAllocationAmount(NonNegativeMoney allocationAmount);
		@Override
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setFacilityPosition(FacilityPosition facilityPosition);
		LoanAllocationSettlement.LoanAllocationSettlementBuilder setFundingFactors(LoanTradingCounterpartySettlementFundingFactors fundingFactors);

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
			processRosetta(path.newSubPath("fundingFactors"), processor, LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder.class, getFundingFactors());
		}
		

		LoanAllocationSettlement.LoanAllocationSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlement  ***********************/
	class LoanAllocationSettlementImpl extends AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventImpl implements LoanAllocationSettlement {
		private final LoanTradingCounterpartySettlementFundingFactors fundingFactors;
		
		protected LoanAllocationSettlementImpl(LoanAllocationSettlement.LoanAllocationSettlementBuilder builder) {
			super(builder);
			this.fundingFactors = ofNullable(builder.getFundingFactors()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fundingFactors")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundingFactors")
		public LoanTradingCounterpartySettlementFundingFactors getFundingFactors() {
			return fundingFactors;
		}
		
		@Override
		public LoanAllocationSettlement build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder toBuilder() {
			LoanAllocationSettlement.LoanAllocationSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlement.LoanAllocationSettlementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFundingFactors()).ifPresent(builder::setFundingFactors);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlement _that = getType().cast(o);
		
			if (!Objects.equals(fundingFactors, _that.getFundingFactors())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fundingFactors != null ? fundingFactors.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlement {" +
				"fundingFactors=" + this.fundingFactors +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlement  ***********************/
	class LoanAllocationSettlementBuilderImpl extends AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl implements LoanAllocationSettlement.LoanAllocationSettlementBuilder {
	
		protected LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder fundingFactors;
		
		@Override
		@RosettaAttribute("fundingFactors")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundingFactors")
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder getFundingFactors() {
			return fundingFactors;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder getOrCreateFundingFactors() {
			LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder result;
			if (fundingFactors!=null) {
				result = fundingFactors;
			}
			else {
				result = fundingFactors = LoanTradingCounterpartySettlementFundingFactors.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setAllocationReference(LoanAllocationReference _allocationReference) {
			this.allocationReference = _allocationReference == null ? null : _allocationReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setSettlementDate(ZonedDateTime _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate;
			return this;
		}
		
		@RosettaAttribute("allocationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationAmount")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setAllocationAmount(NonNegativeMoney _allocationAmount) {
			this.allocationAmount = _allocationAmount == null ? null : _allocationAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityPosition")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setFacilityPosition(FacilityPosition _facilityPosition) {
			this.facilityPosition = _facilityPosition == null ? null : _facilityPosition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fundingFactors")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fundingFactors")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder setFundingFactors(LoanTradingCounterpartySettlementFundingFactors _fundingFactors) {
			this.fundingFactors = _fundingFactors == null ? null : _fundingFactors.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationSettlement build() {
			return new LoanAllocationSettlement.LoanAllocationSettlementImpl(this);
		}
		
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder prune() {
			super.prune();
			if (fundingFactors!=null && !fundingFactors.prune().hasData()) fundingFactors = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFundingFactors()!=null && getFundingFactors().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlement.LoanAllocationSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationSettlement.LoanAllocationSettlementBuilder o = (LoanAllocationSettlement.LoanAllocationSettlementBuilder) other;
			
			merger.mergeRosetta(getFundingFactors(), o.getFundingFactors(), this::setFundingFactors);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlement _that = getType().cast(o);
		
			if (!Objects.equals(fundingFactors, _that.getFundingFactors())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fundingFactors != null ? fundingFactors.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementBuilder {" +
				"fundingFactors=" + this.fundingFactors +
			'}' + " " + super.toString();
		}
	}
}
