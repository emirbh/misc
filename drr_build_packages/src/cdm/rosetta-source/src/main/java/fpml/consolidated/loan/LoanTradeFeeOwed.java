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
import fpml.consolidated.loan.meta.LoanTradeFeeOwedMeta;
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
@RosettaDataType(value="LoanTradeFeeOwed", builder=LoanTradeFeeOwed.LoanTradeFeeOwedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeFeeOwed", model="fpml", builder=LoanTradeFeeOwed.LoanTradeFeeOwedBuilderImpl.class, version="2.1.1")
public interface LoanTradeFeeOwed extends LoanTradeTransferFeeOwed {

	LoanTradeFeeOwedMeta metaData = new LoanTradeFeeOwedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LoanTradeFeeOwed build();
	
	LoanTradeFeeOwed.LoanTradeFeeOwedBuilder toBuilder();
	
	static LoanTradeFeeOwed.LoanTradeFeeOwedBuilder builder() {
		return new LoanTradeFeeOwed.LoanTradeFeeOwedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeFeeOwed> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeFeeOwed> getType() {
		return LoanTradeFeeOwed.class;
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
	interface LoanTradeFeeOwedBuilder extends LoanTradeFeeOwed, LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilder {
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setComment(String comment);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setWaivedFlag(Boolean waivedFlag);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setCreditAgreementAmount(NonNegativeMoney creditAgreementAmount);
		@Override
		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setAgentAmount(NonNegativeMoney agentAmount);

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
		

		LoanTradeFeeOwed.LoanTradeFeeOwedBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeFeeOwed  ***********************/
	class LoanTradeFeeOwedImpl extends LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedImpl implements LoanTradeFeeOwed {
		
		protected LoanTradeFeeOwedImpl(LoanTradeFeeOwed.LoanTradeFeeOwedBuilder builder) {
			super(builder);
		}
		
		@Override
		public LoanTradeFeeOwed build() {
			return this;
		}
		
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder toBuilder() {
			LoanTradeFeeOwed.LoanTradeFeeOwedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeFeeOwed.LoanTradeFeeOwedBuilder builder) {
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
			return "LoanTradeFeeOwed {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeFeeOwed  ***********************/
	class LoanTradeFeeOwedBuilderImpl extends LoanTradeTransferFeeOwed.LoanTradeTransferFeeOwedBuilderImpl implements LoanTradeFeeOwed.LoanTradeFeeOwedBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("waivedFlag")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("waivedFlag")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setWaivedFlag(Boolean _waivedFlag) {
			this.waivedFlag = _waivedFlag == null ? null : _waivedFlag;
			return this;
		}
		
		@RosettaAttribute("creditAgreementAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditAgreementAmount")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setCreditAgreementAmount(NonNegativeMoney _creditAgreementAmount) {
			this.creditAgreementAmount = _creditAgreementAmount == null ? null : _creditAgreementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("agentAmount")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder setAgentAmount(NonNegativeMoney _agentAmount) {
			this.agentAmount = _agentAmount == null ? null : _agentAmount.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradeFeeOwed build() {
			return new LoanTradeFeeOwed.LoanTradeFeeOwedImpl(this);
		}
		
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder prune() {
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
		public LoanTradeFeeOwed.LoanTradeFeeOwedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeFeeOwed.LoanTradeFeeOwedBuilder o = (LoanTradeFeeOwed.LoanTradeFeeOwedBuilder) other;
			
			
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
			return "LoanTradeFeeOwedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
