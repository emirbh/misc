package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.loan.meta.LoanTradingCostOfCarryMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that incorporates elements of an accrual calculation, for the purpose of defining cost-of-carry.
 *
 */
@RosettaDataType(value="LoanTradingCostOfCarry", builder=LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingCostOfCarry", model="fpml", builder=LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilderImpl.class, version="2.1.1")
public interface LoanTradingCostOfCarry extends RosettaModelObject {

	LoanTradingCostOfCarryMeta metaData = new LoanTradingCostOfCarryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of cost of carry accrued for the given loan contract. Funded Amount * Price + (100-Price) * Unfunded - (100-Price) * Paydown - Non-Recurring Fees.
	 *
	 */
	NonNegativeMoney getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for the allocation.
	 *
	 */
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that has been allocated to.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Details of the accrual schedule in support of the cost of carry amount: The commencement amount is the calculated 'value' of the asset being purchased/sold, as of the end of the REGULAR settlement period (e.g. at T+7 for Par). This amount takes into account ALL potential adjustments, price and utilized/unutilized balances as of the regular settlement date. Hence, the reference amount will be the commencement amount and the rate will be the average LIBOR (between T+7 and actual settlement date). If however, the settlement amount at the END of the delay period has changed by more than 25 percent as compared to the commencement amount, then the (calculated) settlement amount for each applicable day within the delay period must be calculated and used to accrue the cost of carry. The average LIBOR will still be the applicable rate.
	 *
	 */
	LoanTradingCostOfCarryAccrual getAccrual();

	/*********************** Build Methods  ***********************/
	LoanTradingCostOfCarry build();
	
	LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder toBuilder();
	
	static LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder builder() {
		return new LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingCostOfCarry> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingCostOfCarry> getType() {
		return LoanTradingCostOfCarry.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("accrual"), processor, LoanTradingCostOfCarryAccrual.class, getAccrual());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingCostOfCarryBuilder extends LoanTradingCostOfCarry, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder getOrCreateAccrual();
		@Override
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder getAccrual();
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setAmount(NonNegativeMoney amount);
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setPayerPartyReference(PartyReference payerPartyReference);
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setAccrual(LoanTradingCostOfCarryAccrual accrual);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("accrual"), processor, LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder.class, getAccrual());
		}
		

		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingCostOfCarry  ***********************/
	class LoanTradingCostOfCarryImpl implements LoanTradingCostOfCarry {
		private final NonNegativeMoney amount;
		private final PartyReference payerPartyReference;
		private final PartyReference receiverPartyReference;
		private final LoanTradingCostOfCarryAccrual accrual;
		
		protected LoanTradingCostOfCarryImpl(LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrual")
		public LoanTradingCostOfCarryAccrual getAccrual() {
			return accrual;
		}
		
		@Override
		public LoanTradingCostOfCarry build() {
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder toBuilder() {
			LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCostOfCarry _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCostOfCarry {" +
				"amount=" + this.amount + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"accrual=" + this.accrual +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingCostOfCarry  ***********************/
	class LoanTradingCostOfCarryBuilderImpl implements LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder accrual;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerPartyReference")
		public PartyReference.PartyReferenceBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference.PartyReferenceBuilder getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (receiverPartyReference!=null) {
				result = receiverPartyReference;
			}
			else {
				result = receiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrual")
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder getAccrual() {
			return accrual;
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder getOrCreateAccrual() {
			LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder result;
			if (accrual!=null) {
				result = accrual;
			}
			else {
				result = accrual = LoanTradingCostOfCarryAccrual.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerPartyReference")
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accrual")
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder setAccrual(LoanTradingCostOfCarryAccrual _accrual) {
			this.accrual = _accrual == null ? null : _accrual.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarry build() {
			return new LoanTradingCostOfCarry.LoanTradingCostOfCarryImpl(this);
		}
		
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getAccrual()!=null && getAccrual().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder o = (LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCostOfCarry _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCostOfCarryBuilder {" +
				"amount=" + this.amount + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"accrual=" + this.accrual +
			'}';
		}
	}
}
