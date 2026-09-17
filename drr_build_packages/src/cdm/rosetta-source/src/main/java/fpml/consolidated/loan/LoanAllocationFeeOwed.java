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
import fpml.consolidated.loan.meta.LoanAllocationFeeOwedMeta;
import fpml.consolidated.shared.NonNegativeMoney;
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
@RosettaDataType(value="LoanAllocationFeeOwed", builder=LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationFeeOwed", model="fpml", builder=LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilderImpl.class, version="2.1.1")
public interface LoanAllocationFeeOwed extends LoanAllocationTransferFeeOwed {

	LoanAllocationFeeOwedMeta metaData = new LoanAllocationFeeOwedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LoanAllocationFeeOwed build();
	
	LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder toBuilder();
	
	static LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder builder() {
		return new LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationFeeOwed> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationFeeOwed> getType() {
		return LoanAllocationFeeOwed.class;
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
		processor.processBasic(path.newSubPath("waivedFlag"), Boolean.class, getWaivedFlag(), this);
		processRosetta(path.newSubPath("creditAgreementAmount"), processor, NonNegativeMoney.class, getCreditAgreementAmount());
		processRosetta(path.newSubPath("agentAmount"), processor, NonNegativeMoney.class, getAgentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationFeeOwedBuilder extends LoanAllocationFeeOwed, LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder {
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setComment(String comment);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setAllocationReference(LoanAllocationReference allocationReference);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setWaivedFlag(Boolean waivedFlag);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setCreditAgreementAmount(NonNegativeMoney creditAgreementAmount);
		@Override
		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setAgentAmount(NonNegativeMoney agentAmount);

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
			processor.processBasic(path.newSubPath("waivedFlag"), Boolean.class, getWaivedFlag(), this);
			processRosetta(path.newSubPath("creditAgreementAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getCreditAgreementAmount());
			processRosetta(path.newSubPath("agentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAgentAmount());
		}
		

		LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationFeeOwed  ***********************/
	class LoanAllocationFeeOwedImpl extends LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedImpl implements LoanAllocationFeeOwed {
		
		protected LoanAllocationFeeOwedImpl(LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder builder) {
			super(builder);
		}
		
		@Override
		public LoanAllocationFeeOwed build() {
			return this;
		}
		
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder toBuilder() {
			LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder builder) {
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
			return "LoanAllocationFeeOwed {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationFeeOwed  ***********************/
	class LoanAllocationFeeOwedBuilderImpl extends LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilderImpl implements LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setAllocationReference(LoanAllocationReference _allocationReference) {
			this.allocationReference = _allocationReference == null ? null : _allocationReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("waivedFlag")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("waivedFlag")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setWaivedFlag(Boolean _waivedFlag) {
			this.waivedFlag = _waivedFlag == null ? null : _waivedFlag;
			return this;
		}
		
		@RosettaAttribute("creditAgreementAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditAgreementAmount")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setCreditAgreementAmount(NonNegativeMoney _creditAgreementAmount) {
			this.creditAgreementAmount = _creditAgreementAmount == null ? null : _creditAgreementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("agentAmount")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder setAgentAmount(NonNegativeMoney _agentAmount) {
			this.agentAmount = _agentAmount == null ? null : _agentAmount.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationFeeOwed build() {
			return new LoanAllocationFeeOwed.LoanAllocationFeeOwedImpl(this);
		}
		
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder prune() {
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
		public LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder o = (LoanAllocationFeeOwed.LoanAllocationFeeOwedBuilder) other;
			
			
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
			return "LoanAllocationFeeOwedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
