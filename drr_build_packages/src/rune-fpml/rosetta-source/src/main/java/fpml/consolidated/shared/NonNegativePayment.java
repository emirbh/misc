package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.NonNegativePaymentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A complex type to specify non negative payments.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A complex type to specify non negative payments.
 *
 */
@RosettaDataType(value="NonNegativePayment", builder=NonNegativePayment.NonNegativePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonNegativePayment", model="fpml", builder=NonNegativePayment.NonNegativePaymentBuilderImpl.class, version="2.1.1")
public interface NonNegativePayment extends PaymentBaseExtended {

	NonNegativePaymentMeta metaData = new NonNegativePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Non negative payment amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Non negative payment amount.
	 *
	 */
	NonNegativeMoney getPaymentAmount();

	/*********************** Build Methods  ***********************/
	NonNegativePayment build();
	
	NonNegativePayment.NonNegativePaymentBuilder toBuilder();
	
	static NonNegativePayment.NonNegativePaymentBuilder builder() {
		return new NonNegativePayment.NonNegativePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonNegativePayment> getType() {
		return NonNegativePayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativePaymentBuilder extends NonNegativePayment, PaymentBaseExtended.PaymentBaseExtendedBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount();
		@Override
		NonNegativePayment.NonNegativePaymentBuilder setId(String id);
		@Override
		NonNegativePayment.NonNegativePaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		NonNegativePayment.NonNegativePaymentBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		NonNegativePayment.NonNegativePaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		NonNegativePayment.NonNegativePaymentBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		NonNegativePayment.NonNegativePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		NonNegativePayment.NonNegativePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
		}
		

		NonNegativePayment.NonNegativePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativePayment  ***********************/
	class NonNegativePaymentImpl extends PaymentBaseExtended.PaymentBaseExtendedImpl implements NonNegativePayment {
		private final NonNegativeMoney paymentAmount;
		
		protected NonNegativePaymentImpl(NonNegativePayment.NonNegativePaymentBuilder builder) {
			super(builder);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentAmount")
		public NonNegativeMoney getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public NonNegativePayment build() {
			return this;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder toBuilder() {
			NonNegativePayment.NonNegativePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativePayment.NonNegativePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativePayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativePayment {" +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativePayment  ***********************/
	class NonNegativePaymentBuilderImpl extends PaymentBaseExtended.PaymentBaseExtendedBuilderImpl implements NonNegativePayment.NonNegativePaymentBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder paymentAmount;
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public NonNegativePayment build() {
			return new NonNegativePayment.NonNegativePaymentImpl(this);
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder prune() {
			super.prune();
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NonNegativePayment.NonNegativePaymentBuilder o = (NonNegativePayment.NonNegativePaymentBuilder) other;
			
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativePayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativePaymentBuilder {" +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}
}
