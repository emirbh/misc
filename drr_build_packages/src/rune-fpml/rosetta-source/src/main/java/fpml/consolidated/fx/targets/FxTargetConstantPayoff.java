package fpml.consolidated.fx.targets;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fx.targets.meta.FxTargetConstantPayoffMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PositiveMoney;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxTargetConstantPayoff", builder=FxTargetConstantPayoff.FxTargetConstantPayoffBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetConstantPayoff", model="fpml", builder=FxTargetConstantPayoff.FxTargetConstantPayoffBuilderImpl.class, version="2.1.1")
public interface FxTargetConstantPayoff extends RosettaModelObject {

	FxTargetConstantPayoffMeta metaData = new FxTargetConstantPayoffMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 */
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 */
	AccountReference getPayerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 */
	AccountReference getReceiverAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Cash payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Cash payment.
	 *
	 */
	PositiveMoney getPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Payoff (gain) expressed as a fixing adjustment. This style is used in the "bonus collar" TARF.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Payoff (gain) expressed as a fixing adjustment. This style is used in the "bonus collar" TARF.
	 *
	 */
	BigDecimal getFixingAdjustment();

	/*********************** Build Methods  ***********************/
	FxTargetConstantPayoff build();
	
	FxTargetConstantPayoff.FxTargetConstantPayoffBuilder toBuilder();
	
	static FxTargetConstantPayoff.FxTargetConstantPayoffBuilder builder() {
		return new FxTargetConstantPayoff.FxTargetConstantPayoffBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetConstantPayoff> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetConstantPayoff> getType() {
		return FxTargetConstantPayoff.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("payment"), processor, PositiveMoney.class, getPayment());
		processor.processBasic(path.newSubPath("fixingAdjustment"), BigDecimal.class, getFixingAdjustment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetConstantPayoffBuilder extends FxTargetConstantPayoff, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getPayerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getReceiverAccountReference();
		PositiveMoney.PositiveMoneyBuilder getOrCreatePayment();
		@Override
		PositiveMoney.PositiveMoneyBuilder getPayment();
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setPayerPartyReference(PartyReference payerPartyReference);
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setPayerAccountReference(AccountReference payerAccountReference);
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setPayment(PositiveMoney payment);
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setFixingAdjustment(BigDecimal fixingAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("payment"), processor, PositiveMoney.PositiveMoneyBuilder.class, getPayment());
			processor.processBasic(path.newSubPath("fixingAdjustment"), BigDecimal.class, getFixingAdjustment(), this);
		}
		

		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetConstantPayoff  ***********************/
	class FxTargetConstantPayoffImpl implements FxTargetConstantPayoff {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final PositiveMoney payment;
		private final BigDecimal fixingAdjustment;
		
		protected FxTargetConstantPayoffImpl(FxTargetConstantPayoff.FxTargetConstantPayoffBuilder builder) {
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
			this.fixingAdjustment = builder.getFixingAdjustment();
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public PositiveMoney getPayment() {
			return payment;
		}
		
		@Override
		@RosettaAttribute("fixingAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingAdjustment")
		public BigDecimal getFixingAdjustment() {
			return fixingAdjustment;
		}
		
		@Override
		public FxTargetConstantPayoff build() {
			return this;
		}
		
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder toBuilder() {
			FxTargetConstantPayoff.FxTargetConstantPayoffBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetConstantPayoff.FxTargetConstantPayoffBuilder builder) {
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
			ofNullable(getFixingAdjustment()).ifPresent(builder::setFixingAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetConstantPayoff _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(fixingAdjustment, _that.getFixingAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (fixingAdjustment != null ? fixingAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoff {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"payment=" + this.payment + ", " +
				"fixingAdjustment=" + this.fixingAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetConstantPayoff  ***********************/
	class FxTargetConstantPayoffBuilderImpl implements FxTargetConstantPayoff.FxTargetConstantPayoffBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected PositiveMoney.PositiveMoneyBuilder payment;
		protected BigDecimal fixingAdjustment;
		
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
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference.AccountReferenceBuilder getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (payerAccountReference!=null) {
				result = payerAccountReference;
			}
			else {
				result = payerAccountReference = AccountReference.builder();
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
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference.AccountReferenceBuilder getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (receiverAccountReference!=null) {
				result = receiverAccountReference;
			}
			else {
				result = receiverAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public PositiveMoney.PositiveMoneyBuilder getPayment() {
			return payment;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreatePayment() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingAdjustment")
		public BigDecimal getFixingAdjustment() {
			return fixingAdjustment;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerPartyReference")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payment")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setPayment(PositiveMoney _payment) {
			this.payment = _payment == null ? null : _payment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingAdjustment")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setFixingAdjustment(BigDecimal _fixingAdjustment) {
			this.fixingAdjustment = _fixingAdjustment == null ? null : _fixingAdjustment;
			return this;
		}
		
		@Override
		public FxTargetConstantPayoff build() {
			return new FxTargetConstantPayoff.FxTargetConstantPayoffImpl(this);
		}
		
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (payment!=null && !payment.prune().hasData()) payment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			if (getFixingAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetConstantPayoff.FxTargetConstantPayoffBuilder o = (FxTargetConstantPayoff.FxTargetConstantPayoffBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			
			merger.mergeBasic(getFixingAdjustment(), o.getFixingAdjustment(), this::setFixingAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetConstantPayoff _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(fixingAdjustment, _that.getFixingAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (fixingAdjustment != null ? fixingAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoffBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"payment=" + this.payment + ", " +
				"fixingAdjustment=" + this.fixingAdjustment +
			'}';
		}
	}
}
