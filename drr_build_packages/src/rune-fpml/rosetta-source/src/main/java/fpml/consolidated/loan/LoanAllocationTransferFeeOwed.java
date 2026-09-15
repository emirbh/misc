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
import fpml.consolidated.loan.meta.LoanAllocationTransferFeeOwedMeta;
import fpml.consolidated.shared.NonNegativeMoney;
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
 * Provision A structure that defines details related to the admin agent's determination of transfer fee(s) owed on an allocation.
 *
 */
@RosettaDataType(value="LoanAllocationTransferFeeOwed", builder=LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationTransferFeeOwed", model="fpml", builder=LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilderImpl.class, version="2.1.1")
public interface LoanAllocationTransferFeeOwed extends AbstractLoanAllocationEvent {

	LoanAllocationTransferFeeOwedMeta metaData = new LoanAllocationTransferFeeOwedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A flag defining whether the transfer fee is to be waived for this allocation.
	 *
	 */
	Boolean getWaivedFlag();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Amount of transfer fee owed to the admin agent for the allocation, per the credit agreement.
	 *
	 */
	NonNegativeMoney getCreditAgreementAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Amount of transfer fee owed to the admin agent for the allocation, as determined by the agent.
	 *
	 */
	NonNegativeMoney getAgentAmount();

	/*********************** Build Methods  ***********************/
	LoanAllocationTransferFeeOwed build();
	
	LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder toBuilder();
	
	static LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder builder() {
		return new LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationTransferFeeOwed> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationTransferFeeOwed> getType() {
		return LoanAllocationTransferFeeOwed.class;
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
	interface LoanAllocationTransferFeeOwedBuilder extends LoanAllocationTransferFeeOwed, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCreditAgreementAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getCreditAgreementAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAgentAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAgentAmount();
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setComment(String comment);
		@Override
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setAllocationReference(LoanAllocationReference allocationReference);
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setWaivedFlag(Boolean waivedFlag);
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setCreditAgreementAmount(NonNegativeMoney creditAgreementAmount);
		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setAgentAmount(NonNegativeMoney agentAmount);

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
		

		LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationTransferFeeOwed  ***********************/
	class LoanAllocationTransferFeeOwedImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements LoanAllocationTransferFeeOwed {
		private final Boolean waivedFlag;
		private final NonNegativeMoney creditAgreementAmount;
		private final NonNegativeMoney agentAmount;
		
		protected LoanAllocationTransferFeeOwedImpl(LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder builder) {
			super(builder);
			this.waivedFlag = builder.getWaivedFlag();
			this.creditAgreementAmount = ofNullable(builder.getCreditAgreementAmount()).map(f->f.build()).orElse(null);
			this.agentAmount = ofNullable(builder.getAgentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("waivedFlag")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("waivedFlag")
		public Boolean getWaivedFlag() {
			return waivedFlag;
		}
		
		@Override
		@RosettaAttribute("creditAgreementAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditAgreementAmount")
		public NonNegativeMoney getCreditAgreementAmount() {
			return creditAgreementAmount;
		}
		
		@Override
		@RosettaAttribute("agentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agentAmount")
		public NonNegativeMoney getAgentAmount() {
			return agentAmount;
		}
		
		@Override
		public LoanAllocationTransferFeeOwed build() {
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder toBuilder() {
			LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getWaivedFlag()).ifPresent(builder::setWaivedFlag);
			ofNullable(getCreditAgreementAmount()).ifPresent(builder::setCreditAgreementAmount);
			ofNullable(getAgentAmount()).ifPresent(builder::setAgentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeOwed _that = getType().cast(o);
		
			if (!Objects.equals(waivedFlag, _that.getWaivedFlag())) return false;
			if (!Objects.equals(creditAgreementAmount, _that.getCreditAgreementAmount())) return false;
			if (!Objects.equals(agentAmount, _that.getAgentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (waivedFlag != null ? waivedFlag.hashCode() : 0);
			_result = 31 * _result + (creditAgreementAmount != null ? creditAgreementAmount.hashCode() : 0);
			_result = 31 * _result + (agentAmount != null ? agentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeOwed {" +
				"waivedFlag=" + this.waivedFlag + ", " +
				"creditAgreementAmount=" + this.creditAgreementAmount + ", " +
				"agentAmount=" + this.agentAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationTransferFeeOwed  ***********************/
	class LoanAllocationTransferFeeOwedBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl implements LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder {
	
		protected Boolean waivedFlag;
		protected NonNegativeMoney.NonNegativeMoneyBuilder creditAgreementAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder agentAmount;
		
		@Override
		@RosettaAttribute("waivedFlag")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("waivedFlag")
		public Boolean getWaivedFlag() {
			return waivedFlag;
		}
		
		@Override
		@RosettaAttribute("creditAgreementAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditAgreementAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getCreditAgreementAmount() {
			return creditAgreementAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCreditAgreementAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (creditAgreementAmount!=null) {
				result = creditAgreementAmount;
			}
			else {
				result = creditAgreementAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("agentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAgentAmount() {
			return agentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAgentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (agentAmount!=null) {
				result = agentAmount;
			}
			else {
				result = agentAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setAllocationReference(LoanAllocationReference _allocationReference) {
			this.allocationReference = _allocationReference == null ? null : _allocationReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("waivedFlag")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("waivedFlag")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setWaivedFlag(Boolean _waivedFlag) {
			this.waivedFlag = _waivedFlag == null ? null : _waivedFlag;
			return this;
		}
		
		@RosettaAttribute("creditAgreementAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditAgreementAmount")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setCreditAgreementAmount(NonNegativeMoney _creditAgreementAmount) {
			this.creditAgreementAmount = _creditAgreementAmount == null ? null : _creditAgreementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("agentAmount")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder setAgentAmount(NonNegativeMoney _agentAmount) {
			this.agentAmount = _agentAmount == null ? null : _agentAmount.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwed build() {
			return new LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedImpl(this);
		}
		
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder prune() {
			super.prune();
			if (creditAgreementAmount!=null && !creditAgreementAmount.prune().hasData()) creditAgreementAmount = null;
			if (agentAmount!=null && !agentAmount.prune().hasData()) agentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getWaivedFlag()!=null) return true;
			if (getCreditAgreementAmount()!=null && getCreditAgreementAmount().hasData()) return true;
			if (getAgentAmount()!=null && getAgentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder o = (LoanAllocationTransferFeeOwed.LoanAllocationTransferFeeOwedBuilder) other;
			
			merger.mergeRosetta(getCreditAgreementAmount(), o.getCreditAgreementAmount(), this::setCreditAgreementAmount);
			merger.mergeRosetta(getAgentAmount(), o.getAgentAmount(), this::setAgentAmount);
			
			merger.mergeBasic(getWaivedFlag(), o.getWaivedFlag(), this::setWaivedFlag);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeOwed _that = getType().cast(o);
		
			if (!Objects.equals(waivedFlag, _that.getWaivedFlag())) return false;
			if (!Objects.equals(creditAgreementAmount, _that.getCreditAgreementAmount())) return false;
			if (!Objects.equals(agentAmount, _that.getAgentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (waivedFlag != null ? waivedFlag.hashCode() : 0);
			_result = 31 * _result + (creditAgreementAmount != null ? creditAgreementAmount.hashCode() : 0);
			_result = 31 * _result + (agentAmount != null ? agentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeOwedBuilder {" +
				"waivedFlag=" + this.waivedFlag + ", " +
				"creditAgreementAmount=" + this.creditAgreementAmount + ", " +
				"agentAmount=" + this.agentAmount +
			'}' + " " + super.toString();
		}
	}
}
