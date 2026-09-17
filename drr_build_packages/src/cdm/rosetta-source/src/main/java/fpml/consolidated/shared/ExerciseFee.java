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
import fpml.consolidated.shared.meta.ExerciseFeeMeta;
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
 * Provision A type defining the fee payable on exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the fee payable on exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised.
 *
 */
@RosettaDataType(value="ExerciseFee", builder=ExerciseFee.ExerciseFeeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExerciseFee", model="fpml", builder=ExerciseFee.ExerciseFeeBuilderImpl.class, version="2.1.1")
public interface ExerciseFee extends RosettaModelObject {

	ExerciseFeeMeta metaData = new ExerciseFeeMeta();

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
	 * Provision A pointer style reference to the associated notional schedule defined elsewhere in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the associated notional schedule defined elsewhere in the document.
	 *
	 */
	NotionalReference getNotionalReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount of fee to be paid on exercise. The fee currency is that of the referenced notional.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of fee to be paid on exercise. The fee currency is that of the referenced notional.
	 *
	 */
	BigDecimal getFeeAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A fee represented as a percentage of some referenced notional. A percentage of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fee represented as a percentage of some referenced notional. A percentage of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getFeeRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which exercise fee(s) will be paid. It is specified as a relative date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which exercise fee(s) will be paid. It is specified as a relative date.
	 *
	 */
	RelativeDateOffset getFeePaymentDate();

	/*********************** Build Methods  ***********************/
	ExerciseFee build();
	
	ExerciseFee.ExerciseFeeBuilder toBuilder();
	
	static ExerciseFee.ExerciseFeeBuilder builder() {
		return new ExerciseFee.ExerciseFeeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseFee> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExerciseFee> getType() {
		return ExerciseFee.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
		processor.processBasic(path.newSubPath("feeAmount"), BigDecimal.class, getFeeAmount(), this);
		processor.processBasic(path.newSubPath("feeRate"), BigDecimal.class, getFeeRate(), this);
		processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.class, getFeePaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseFeeBuilder extends ExerciseFee, RosettaModelObjectBuilder {
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
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference();
		@Override
		NotionalReference.NotionalReferenceBuilder getNotionalReference();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate();
		ExerciseFee.ExerciseFeeBuilder setPayerPartyReference(PartyReference payerPartyReference);
		ExerciseFee.ExerciseFeeBuilder setPayerAccountReference(AccountReference payerAccountReference);
		ExerciseFee.ExerciseFeeBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		ExerciseFee.ExerciseFeeBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		ExerciseFee.ExerciseFeeBuilder setNotionalReference(NotionalReference notionalReference);
		ExerciseFee.ExerciseFeeBuilder setFeeAmount(BigDecimal feeAmount);
		ExerciseFee.ExerciseFeeBuilder setFeeRate(BigDecimal feeRate);
		ExerciseFee.ExerciseFeeBuilder setFeePaymentDate(RelativeDateOffset feePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
			processor.processBasic(path.newSubPath("feeAmount"), BigDecimal.class, getFeeAmount(), this);
			processor.processBasic(path.newSubPath("feeRate"), BigDecimal.class, getFeeRate(), this);
			processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getFeePaymentDate());
		}
		

		ExerciseFee.ExerciseFeeBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseFee  ***********************/
	class ExerciseFeeImpl implements ExerciseFee {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final NotionalReference notionalReference;
		private final BigDecimal feeAmount;
		private final BigDecimal feeRate;
		private final RelativeDateOffset feePaymentDate;
		
		protected ExerciseFeeImpl(ExerciseFee.ExerciseFeeBuilder builder) {
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.feeAmount = builder.getFeeAmount();
			this.feeRate = builder.getFeeRate();
			this.feePaymentDate = ofNullable(builder.getFeePaymentDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReference")
		public NotionalReference getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("feeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeAmount")
		public BigDecimal getFeeAmount() {
			return feeAmount;
		}
		
		@Override
		@RosettaAttribute("feeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeRate")
		public BigDecimal getFeeRate() {
			return feeRate;
		}
		
		@Override
		@RosettaAttribute("feePaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feePaymentDate")
		public RelativeDateOffset getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public ExerciseFee build() {
			return this;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder toBuilder() {
			ExerciseFee.ExerciseFeeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseFee.ExerciseFeeBuilder builder) {
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getFeeAmount()).ifPresent(builder::setFeeAmount);
			ofNullable(getFeeRate()).ifPresent(builder::setFeeRate);
			ofNullable(getFeePaymentDate()).ifPresent(builder::setFeePaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseFee _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(feeAmount, _that.getFeeAmount())) return false;
			if (!Objects.equals(feeRate, _that.getFeeRate())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (feeAmount != null ? feeAmount.hashCode() : 0);
			_result = 31 * _result + (feeRate != null ? feeRate.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFee {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"feeAmount=" + this.feeAmount + ", " +
				"feeRate=" + this.feeRate + ", " +
				"feePaymentDate=" + this.feePaymentDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseFee  ***********************/
	class ExerciseFeeBuilderImpl implements ExerciseFee.ExerciseFeeBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected NotionalReference.NotionalReferenceBuilder notionalReference;
		protected BigDecimal feeAmount;
		protected BigDecimal feeRate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder feePaymentDate;
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReference")
		public NotionalReference.NotionalReferenceBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeAmount")
		public BigDecimal getFeeAmount() {
			return feeAmount;
		}
		
		@Override
		@RosettaAttribute("feeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeRate")
		public BigDecimal getFeeRate() {
			return feeRate;
		}
		
		@Override
		@RosettaAttribute("feePaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feePaymentDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (feePaymentDate!=null) {
				result = feePaymentDate;
			}
			else {
				result = feePaymentDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public ExerciseFee.ExerciseFeeBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public ExerciseFee.ExerciseFeeBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public ExerciseFee.ExerciseFeeBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public ExerciseFee.ExerciseFeeBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalReference")
		@Override
		public ExerciseFee.ExerciseFeeBuilder setNotionalReference(NotionalReference _notionalReference) {
			this.notionalReference = _notionalReference == null ? null : _notionalReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feeAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feeAmount")
		@Override
		public ExerciseFee.ExerciseFeeBuilder setFeeAmount(BigDecimal _feeAmount) {
			this.feeAmount = _feeAmount == null ? null : _feeAmount;
			return this;
		}
		
		@RosettaAttribute("feeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feeRate")
		@Override
		public ExerciseFee.ExerciseFeeBuilder setFeeRate(BigDecimal _feeRate) {
			this.feeRate = _feeRate == null ? null : _feeRate;
			return this;
		}
		
		@RosettaAttribute("feePaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feePaymentDate")
		@Override
		public ExerciseFee.ExerciseFeeBuilder setFeePaymentDate(RelativeDateOffset _feePaymentDate) {
			this.feePaymentDate = _feePaymentDate == null ? null : _feePaymentDate.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseFee build() {
			return new ExerciseFee.ExerciseFeeImpl(this);
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFee.ExerciseFeeBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (feePaymentDate!=null && !feePaymentDate.prune().hasData()) feePaymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			if (getFeeAmount()!=null) return true;
			if (getFeeRate()!=null) return true;
			if (getFeePaymentDate()!=null && getFeePaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFee.ExerciseFeeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseFee.ExerciseFeeBuilder o = (ExerciseFee.ExerciseFeeBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getFeePaymentDate(), o.getFeePaymentDate(), this::setFeePaymentDate);
			
			merger.mergeBasic(getFeeAmount(), o.getFeeAmount(), this::setFeeAmount);
			merger.mergeBasic(getFeeRate(), o.getFeeRate(), this::setFeeRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseFee _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(feeAmount, _that.getFeeAmount())) return false;
			if (!Objects.equals(feeRate, _that.getFeeRate())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (feeAmount != null ? feeAmount.hashCode() : 0);
			_result = 31 * _result + (feeRate != null ? feeRate.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFeeBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"feeAmount=" + this.feeAmount + ", " +
				"feeRate=" + this.feeRate + ", " +
				"feePaymentDate=" + this.feePaymentDate +
			'}';
		}
	}
}
