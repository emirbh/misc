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
import fpml.consolidated.loan.meta.LoanTradeTransferFeeOwedMeta;
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
 * Provision A structure that defines details related to the admin agent's determination of transfer fee(s) owed on a trade.
 *
 */
@RosettaDataType(value="LoanTradeTransferFeeOwed", builder=LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeTransferFeeOwed", model="fpml", builder=LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilderImpl.class, version="2.1.1")
public interface LoanTradeTransferFeeOwed extends AbstractLoanTradeEvent {

	LoanTradeTransferFeeOwedMeta metaData = new LoanTradeTransferFeeOwedMeta();

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
	LoanTradeTransferFeeOwed build();
	
	LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder toBuilder();
	
	static LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder builder() {
		return new LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeTransferFeeOwed> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeTransferFeeOwed> getType() {
		return LoanTradeTransferFeeOwed.class;
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
		processor.processBasic(path.newSubPath("waivedFlag"), Boolean.class, getWaivedFlag(), this);
		processRosetta(path.newSubPath("creditAgreementAmount"), processor, NonNegativeMoney.class, getCreditAgreementAmount());
		processRosetta(path.newSubPath("agentAmount"), processor, NonNegativeMoney.class, getAgentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeTransferFeeOwedBuilder extends LoanTradeTransferFeeOwed, AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCreditAgreementAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getCreditAgreementAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAgentAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAgentAmount();
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setComment(String comment);
		@Override
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setWaivedFlag(Boolean waivedFlag);
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setCreditAgreementAmount(NonNegativeMoney creditAgreementAmount);
		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setAgentAmount(NonNegativeMoney agentAmount);

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
			processor.processBasic(path.newSubPath("waivedFlag"), Boolean.class, getWaivedFlag(), this);
			processRosetta(path.newSubPath("creditAgreementAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getCreditAgreementAmount());
			processRosetta(path.newSubPath("agentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAgentAmount());
		}
		

		LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeTransferFeeOwed  ***********************/
	class LoanTradeTransferFeeOwedImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventImpl implements LoanTradeTransferFeeOwed {
		private final Boolean waivedFlag;
		private final NonNegativeMoney creditAgreementAmount;
		private final NonNegativeMoney agentAmount;
		
		protected LoanTradeTransferFeeOwedImpl(LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder builder) {
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
		public LoanTradeTransferFeeOwed build() {
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder toBuilder() {
			LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder builder) {
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
		
			LoanTradeTransferFeeOwed _that = getType().cast(o);
		
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
			return "LoanTradeTransferFeeOwed {" +
				"waivedFlag=" + this.waivedFlag + ", " +
				"creditAgreementAmount=" + this.creditAgreementAmount + ", " +
				"agentAmount=" + this.agentAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeTransferFeeOwed  ***********************/
	class LoanTradeTransferFeeOwedBuilderImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl implements LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder {
	
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
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("waivedFlag")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("waivedFlag")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setWaivedFlag(Boolean _waivedFlag) {
			this.waivedFlag = _waivedFlag == null ? null : _waivedFlag;
			return this;
		}
		
		@RosettaAttribute("creditAgreementAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditAgreementAmount")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setCreditAgreementAmount(NonNegativeMoney _creditAgreementAmount) {
			this.creditAgreementAmount = _creditAgreementAmount == null ? null : _creditAgreementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("agentAmount")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder setAgentAmount(NonNegativeMoney _agentAmount) {
			this.agentAmount = _agentAmount == null ? null : _agentAmount.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeOwed build() {
			return new LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedImpl(this);
		}
		
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder prune() {
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
		public LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder o = (LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder) other;
			
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
		
			LoanTradeTransferFeeOwed _that = getType().cast(o);
		
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
			return "LoanTradeTransferFeeOwedBuilder {" +
				"waivedFlag=" + this.waivedFlag + ", " +
				"creditAgreementAmount=" + this.creditAgreementAmount + ", " +
				"agentAmount=" + this.agentAmount +
			'}' + " " + super.toString();
		}
	}
}
