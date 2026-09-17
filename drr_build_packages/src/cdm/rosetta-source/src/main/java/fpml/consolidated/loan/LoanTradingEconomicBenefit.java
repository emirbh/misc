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
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.meta.LoanTradingEconomicBenefitMeta;
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
 * Provision A structure that combines a simple (money) amount with an optional event, for the purpose of defining economic benefit at settlement.
 *
 */
@RosettaDataType(value="LoanTradingEconomicBenefit", builder=LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingEconomicBenefit", model="fpml", builder=LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilderImpl.class, version="2.1.1")
public interface LoanTradingEconomicBenefit extends RosettaModelObject {

	LoanTradingEconomicBenefitMeta metaData = new LoanTradingEconomicBenefitMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Economic benefit amount.
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
	 * Provision 
	 *
	 */
	BusinessEventIdentifier getEventIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Any commitment adjustments which have occurred during settlement of the trade. Represented by the business event structure.
	 *
	 */
	CommitmentAdjustment getCommitmentAdjustment();

	/*********************** Build Methods  ***********************/
	LoanTradingEconomicBenefit build();
	
	LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder toBuilder();
	
	static LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder builder() {
		return new LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingEconomicBenefit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingEconomicBenefit> getType() {
		return LoanTradingEconomicBenefit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("commitmentAdjustment"), processor, CommitmentAdjustment.class, getCommitmentAdjustment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingEconomicBenefitBuilder extends LoanTradingEconomicBenefit, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier();
		@Override
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier();
		CommitmentAdjustment.CommitmentAdjustmentBuilder getOrCreateCommitmentAdjustment();
		@Override
		CommitmentAdjustment.CommitmentAdjustmentBuilder getCommitmentAdjustment();
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setAmount(NonNegativeMoney amount);
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setPayerPartyReference(PartyReference payerPartyReference);
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier);
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setCommitmentAdjustment(CommitmentAdjustment commitmentAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("commitmentAdjustment"), processor, CommitmentAdjustment.CommitmentAdjustmentBuilder.class, getCommitmentAdjustment());
		}
		

		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingEconomicBenefit  ***********************/
	class LoanTradingEconomicBenefitImpl implements LoanTradingEconomicBenefit {
		private final NonNegativeMoney amount;
		private final PartyReference payerPartyReference;
		private final PartyReference receiverPartyReference;
		private final BusinessEventIdentifier eventIdentifier;
		private final CommitmentAdjustment commitmentAdjustment;
		
		protected LoanTradingEconomicBenefitImpl(LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
			this.commitmentAdjustment = ofNullable(builder.getCommitmentAdjustment()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventIdentifier")
		public BusinessEventIdentifier getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("commitmentAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commitmentAdjustment")
		public CommitmentAdjustment getCommitmentAdjustment() {
			return commitmentAdjustment;
		}
		
		@Override
		public LoanTradingEconomicBenefit build() {
			return this;
		}
		
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder toBuilder() {
			LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getCommitmentAdjustment()).ifPresent(builder::setCommitmentAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingEconomicBenefit _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(commitmentAdjustment, _that.getCommitmentAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (commitmentAdjustment != null ? commitmentAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingEconomicBenefit {" +
				"amount=" + this.amount + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"commitmentAdjustment=" + this.commitmentAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingEconomicBenefit  ***********************/
	class LoanTradingEconomicBenefitBuilderImpl implements LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder eventIdentifier;
		protected CommitmentAdjustment.CommitmentAdjustmentBuilder commitmentAdjustment;
		
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
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (eventIdentifier!=null) {
				result = eventIdentifier;
			}
			else {
				result = eventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitmentAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commitmentAdjustment")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder getCommitmentAdjustment() {
			return commitmentAdjustment;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder getOrCreateCommitmentAdjustment() {
			CommitmentAdjustment.CommitmentAdjustmentBuilder result;
			if (commitmentAdjustment!=null) {
				result = commitmentAdjustment;
			}
			else {
				result = commitmentAdjustment = CommitmentAdjustment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerPartyReference")
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commitmentAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commitmentAdjustment")
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setCommitmentAdjustment(CommitmentAdjustment _commitmentAdjustment) {
			this.commitmentAdjustment = _commitmentAdjustment == null ? null : _commitmentAdjustment.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingEconomicBenefit build() {
			return new LoanTradingEconomicBenefit.LoanTradingEconomicBenefitImpl(this);
		}
		
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			if (commitmentAdjustment!=null && !commitmentAdjustment.prune().hasData()) commitmentAdjustment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			if (getCommitmentAdjustment()!=null && getCommitmentAdjustment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder o = (LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeRosetta(getCommitmentAdjustment(), o.getCommitmentAdjustment(), this::setCommitmentAdjustment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingEconomicBenefit _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(commitmentAdjustment, _that.getCommitmentAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (commitmentAdjustment != null ? commitmentAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingEconomicBenefitBuilder {" +
				"amount=" + this.amount + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"commitmentAdjustment=" + this.commitmentAdjustment +
			'}';
		}
	}
}
