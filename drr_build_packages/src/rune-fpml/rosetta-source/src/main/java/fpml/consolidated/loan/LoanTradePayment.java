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
import fpml.consolidated.loan.meta.LoanTradePaymentMeta;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementInstruction;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that represents a payment related to a loan trade (loan trade level).
 *
 */
@RosettaDataType(value="LoanTradePayment", builder=LoanTradePayment.LoanTradePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradePayment", model="fpml", builder=LoanTradePayment.LoanTradePaymentBuilderImpl.class, version="2.1.1")
public interface LoanTradePayment extends LoanSimplePayment {

	LoanTradePaymentMeta metaData = new LoanTradePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the loan trade.
	 *
	 */
	LoanTradeReference getTradeReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This structure can be utilized as an override to previously-communicated settlement instructions (via the LoanPartyProfileNotification).
	 *
	 */
	SettlementInstruction getReceiverSettlementInstruction();

	/*********************** Build Methods  ***********************/
	LoanTradePayment build();
	
	LoanTradePayment.LoanTradePaymentBuilder toBuilder();
	
	static LoanTradePayment.LoanTradePaymentBuilder builder() {
		return new LoanTradePayment.LoanTradePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradePayment> getType() {
		return LoanTradePayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.class, getPaymentDate());
		processRosetta(path.newSubPath("tradeReference"), processor, LoanTradeReference.class, getTradeReference());
		processRosetta(path.newSubPath("receiverSettlementInstruction"), processor, SettlementInstruction.class, getReceiverSettlementInstruction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradePaymentBuilder extends LoanTradePayment, LoanSimplePayment.LoanSimplePaymentBuilder {
		LoanTradeReference.LoanTradeReferenceBuilder getOrCreateTradeReference();
		@Override
		LoanTradeReference.LoanTradeReferenceBuilder getTradeReference();
		SettlementInstruction.SettlementInstructionBuilder getOrCreateReceiverSettlementInstruction();
		@Override
		SettlementInstruction.SettlementInstructionBuilder getReceiverSettlementInstruction();
		@Override
		LoanTradePayment.LoanTradePaymentBuilder setId(String id);
		@Override
		LoanTradePayment.LoanTradePaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		LoanTradePayment.LoanTradePaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		LoanTradePayment.LoanTradePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		@Override
		LoanTradePayment.LoanTradePaymentBuilder setPaymentDate(AdjustableDate paymentDate);
		LoanTradePayment.LoanTradePaymentBuilder setTradeReference(LoanTradeReference tradeReference);
		LoanTradePayment.LoanTradePaymentBuilder setReceiverSettlementInstruction(SettlementInstruction receiverSettlementInstruction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("tradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getTradeReference());
			processRosetta(path.newSubPath("receiverSettlementInstruction"), processor, SettlementInstruction.SettlementInstructionBuilder.class, getReceiverSettlementInstruction());
		}
		

		LoanTradePayment.LoanTradePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradePayment  ***********************/
	class LoanTradePaymentImpl extends LoanSimplePayment.LoanSimplePaymentImpl implements LoanTradePayment {
		private final LoanTradeReference tradeReference;
		private final SettlementInstruction receiverSettlementInstruction;
		
		protected LoanTradePaymentImpl(LoanTradePayment.LoanTradePaymentBuilder builder) {
			super(builder);
			this.tradeReference = ofNullable(builder.getTradeReference()).map(f->f.build()).orElse(null);
			this.receiverSettlementInstruction = ofNullable(builder.getReceiverSettlementInstruction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeReference")
		public LoanTradeReference getTradeReference() {
			return tradeReference;
		}
		
		@Override
		@RosettaAttribute("receiverSettlementInstruction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverSettlementInstruction")
		public SettlementInstruction getReceiverSettlementInstruction() {
			return receiverSettlementInstruction;
		}
		
		@Override
		public LoanTradePayment build() {
			return this;
		}
		
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder toBuilder() {
			LoanTradePayment.LoanTradePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradePayment.LoanTradePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeReference()).ifPresent(builder::setTradeReference);
			ofNullable(getReceiverSettlementInstruction()).ifPresent(builder::setReceiverSettlementInstruction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradePayment _that = getType().cast(o);
		
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			if (!Objects.equals(receiverSettlementInstruction, _that.getReceiverSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			_result = 31 * _result + (receiverSettlementInstruction != null ? receiverSettlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradePayment {" +
				"tradeReference=" + this.tradeReference + ", " +
				"receiverSettlementInstruction=" + this.receiverSettlementInstruction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradePayment  ***********************/
	class LoanTradePaymentBuilderImpl extends LoanSimplePayment.LoanSimplePaymentBuilderImpl implements LoanTradePayment.LoanTradePaymentBuilder {
	
		protected LoanTradeReference.LoanTradeReferenceBuilder tradeReference;
		protected SettlementInstruction.SettlementInstructionBuilder receiverSettlementInstruction;
		
		@Override
		@RosettaAttribute("tradeReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeReference")
		public LoanTradeReference.LoanTradeReferenceBuilder getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder getOrCreateTradeReference() {
			LoanTradeReference.LoanTradeReferenceBuilder result;
			if (tradeReference!=null) {
				result = tradeReference;
			}
			else {
				result = tradeReference = LoanTradeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverSettlementInstruction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverSettlementInstruction")
		public SettlementInstruction.SettlementInstructionBuilder getReceiverSettlementInstruction() {
			return receiverSettlementInstruction;
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder getOrCreateReceiverSettlementInstruction() {
			SettlementInstruction.SettlementInstructionBuilder result;
			if (receiverSettlementInstruction!=null) {
				result = receiverSettlementInstruction;
			}
			else {
				result = receiverSettlementInstruction = SettlementInstruction.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("receiverPartyReference")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentDate")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder setPaymentDate(AdjustableDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradeReference")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder setTradeReference(LoanTradeReference _tradeReference) {
			this.tradeReference = _tradeReference == null ? null : _tradeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverSettlementInstruction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverSettlementInstruction")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder setReceiverSettlementInstruction(SettlementInstruction _receiverSettlementInstruction) {
			this.receiverSettlementInstruction = _receiverSettlementInstruction == null ? null : _receiverSettlementInstruction.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradePayment build() {
			return new LoanTradePayment.LoanTradePaymentImpl(this);
		}
		
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder prune() {
			super.prune();
			if (tradeReference!=null && !tradeReference.prune().hasData()) tradeReference = null;
			if (receiverSettlementInstruction!=null && !receiverSettlementInstruction.prune().hasData()) receiverSettlementInstruction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeReference()!=null && getTradeReference().hasData()) return true;
			if (getReceiverSettlementInstruction()!=null && getReceiverSettlementInstruction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradePayment.LoanTradePaymentBuilder o = (LoanTradePayment.LoanTradePaymentBuilder) other;
			
			merger.mergeRosetta(getTradeReference(), o.getTradeReference(), this::setTradeReference);
			merger.mergeRosetta(getReceiverSettlementInstruction(), o.getReceiverSettlementInstruction(), this::setReceiverSettlementInstruction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradePayment _that = getType().cast(o);
		
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			if (!Objects.equals(receiverSettlementInstruction, _that.getReceiverSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			_result = 31 * _result + (receiverSettlementInstruction != null ? receiverSettlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradePaymentBuilder {" +
				"tradeReference=" + this.tradeReference + ", " +
				"receiverSettlementInstruction=" + this.receiverSettlementInstruction +
			'}' + " " + super.toString();
		}
	}
}
