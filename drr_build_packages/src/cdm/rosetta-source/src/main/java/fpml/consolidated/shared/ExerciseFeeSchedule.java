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
import fpml.consolidated.shared.meta.ExerciseFeeScheduleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type to define a fee or schedule of fees to be payable on the exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to define a fee or schedule of fees to be payable on the exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised.
 *
 */
@RosettaDataType(value="ExerciseFeeSchedule", builder=ExerciseFeeSchedule.ExerciseFeeScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExerciseFeeSchedule", model="fpml", builder=ExerciseFeeSchedule.ExerciseFeeScheduleBuilderImpl.class, version="2.1.1")
public interface ExerciseFeeSchedule extends RosettaModelObject {

	ExerciseFeeScheduleMeta metaData = new ExerciseFeeScheduleMeta();

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
	ScheduleReference getNotionalReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The exercise fee amount schedule. The fees are expressed as currency amounts. The currency of the fee is assumed to be that of the notional schedule referenced.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The exercise fee amount schedule. The fees are expressed as currency amounts. The currency of the fee is assumed to be that of the notional schedule referenced.
	 *
	 */
	AmountSchedule getFeeAmountSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The exercise free rate schedule. The fees are expressed as percentage rates of the notional being exercised. The currency of the fee is assumed to be that of the notional schedule referenced.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The exercise free rate schedule. The fees are expressed as percentage rates of the notional being exercised. The currency of the fee is assumed to be that of the notional schedule referenced.
	 *
	 */
	Schedule getFeeRateSchedule();
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
	ExerciseFeeSchedule build();
	
	ExerciseFeeSchedule.ExerciseFeeScheduleBuilder toBuilder();
	
	static ExerciseFeeSchedule.ExerciseFeeScheduleBuilder builder() {
		return new ExerciseFeeSchedule.ExerciseFeeScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseFeeSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExerciseFeeSchedule> getType() {
		return ExerciseFeeSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("notionalReference"), processor, ScheduleReference.class, getNotionalReference());
		processRosetta(path.newSubPath("feeAmountSchedule"), processor, AmountSchedule.class, getFeeAmountSchedule());
		processRosetta(path.newSubPath("feeRateSchedule"), processor, Schedule.class, getFeeRateSchedule());
		processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.class, getFeePaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseFeeScheduleBuilder extends ExerciseFeeSchedule, RosettaModelObjectBuilder {
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
		ScheduleReference.ScheduleReferenceBuilder getOrCreateNotionalReference();
		@Override
		ScheduleReference.ScheduleReferenceBuilder getNotionalReference();
		AmountSchedule.AmountScheduleBuilder getOrCreateFeeAmountSchedule();
		@Override
		AmountSchedule.AmountScheduleBuilder getFeeAmountSchedule();
		Schedule.ScheduleBuilder getOrCreateFeeRateSchedule();
		@Override
		Schedule.ScheduleBuilder getFeeRateSchedule();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate();
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerPartyReference(PartyReference payerPartyReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerAccountReference(AccountReference payerAccountReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setNotionalReference(ScheduleReference notionalReference);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeeAmountSchedule(AmountSchedule feeAmountSchedule);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeeRateSchedule(Schedule feeRateSchedule);
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeePaymentDate(RelativeDateOffset feePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("notionalReference"), processor, ScheduleReference.ScheduleReferenceBuilder.class, getNotionalReference());
			processRosetta(path.newSubPath("feeAmountSchedule"), processor, AmountSchedule.AmountScheduleBuilder.class, getFeeAmountSchedule());
			processRosetta(path.newSubPath("feeRateSchedule"), processor, Schedule.ScheduleBuilder.class, getFeeRateSchedule());
			processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getFeePaymentDate());
		}
		

		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseFeeSchedule  ***********************/
	class ExerciseFeeScheduleImpl implements ExerciseFeeSchedule {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final ScheduleReference notionalReference;
		private final AmountSchedule feeAmountSchedule;
		private final Schedule feeRateSchedule;
		private final RelativeDateOffset feePaymentDate;
		
		protected ExerciseFeeScheduleImpl(ExerciseFeeSchedule.ExerciseFeeScheduleBuilder builder) {
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.feeAmountSchedule = ofNullable(builder.getFeeAmountSchedule()).map(f->f.build()).orElse(null);
			this.feeRateSchedule = ofNullable(builder.getFeeRateSchedule()).map(f->f.build()).orElse(null);
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
		public ScheduleReference getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("feeAmountSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeAmountSchedule")
		public AmountSchedule getFeeAmountSchedule() {
			return feeAmountSchedule;
		}
		
		@Override
		@RosettaAttribute("feeRateSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeRateSchedule")
		public Schedule getFeeRateSchedule() {
			return feeRateSchedule;
		}
		
		@Override
		@RosettaAttribute("feePaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feePaymentDate")
		public RelativeDateOffset getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public ExerciseFeeSchedule build() {
			return this;
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder toBuilder() {
			ExerciseFeeSchedule.ExerciseFeeScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseFeeSchedule.ExerciseFeeScheduleBuilder builder) {
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getFeeAmountSchedule()).ifPresent(builder::setFeeAmountSchedule);
			ofNullable(getFeeRateSchedule()).ifPresent(builder::setFeeRateSchedule);
			ofNullable(getFeePaymentDate()).ifPresent(builder::setFeePaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseFeeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(feeAmountSchedule, _that.getFeeAmountSchedule())) return false;
			if (!Objects.equals(feeRateSchedule, _that.getFeeRateSchedule())) return false;
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
			_result = 31 * _result + (feeAmountSchedule != null ? feeAmountSchedule.hashCode() : 0);
			_result = 31 * _result + (feeRateSchedule != null ? feeRateSchedule.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFeeSchedule {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"feeAmountSchedule=" + this.feeAmountSchedule + ", " +
				"feeRateSchedule=" + this.feeRateSchedule + ", " +
				"feePaymentDate=" + this.feePaymentDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseFeeSchedule  ***********************/
	class ExerciseFeeScheduleBuilderImpl implements ExerciseFeeSchedule.ExerciseFeeScheduleBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected ScheduleReference.ScheduleReferenceBuilder notionalReference;
		protected AmountSchedule.AmountScheduleBuilder feeAmountSchedule;
		protected Schedule.ScheduleBuilder feeRateSchedule;
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
		public ScheduleReference.ScheduleReferenceBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public ScheduleReference.ScheduleReferenceBuilder getOrCreateNotionalReference() {
			ScheduleReference.ScheduleReferenceBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = ScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeAmountSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeAmountSchedule")
		public AmountSchedule.AmountScheduleBuilder getFeeAmountSchedule() {
			return feeAmountSchedule;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder getOrCreateFeeAmountSchedule() {
			AmountSchedule.AmountScheduleBuilder result;
			if (feeAmountSchedule!=null) {
				result = feeAmountSchedule;
			}
			else {
				result = feeAmountSchedule = AmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeRateSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeRateSchedule")
		public Schedule.ScheduleBuilder getFeeRateSchedule() {
			return feeRateSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFeeRateSchedule() {
			Schedule.ScheduleBuilder result;
			if (feeRateSchedule!=null) {
				result = feeRateSchedule;
			}
			else {
				result = feeRateSchedule = Schedule.builder();
			}
			
			return result;
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
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalReference")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setNotionalReference(ScheduleReference _notionalReference) {
			this.notionalReference = _notionalReference == null ? null : _notionalReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feeAmountSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feeAmountSchedule")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeeAmountSchedule(AmountSchedule _feeAmountSchedule) {
			this.feeAmountSchedule = _feeAmountSchedule == null ? null : _feeAmountSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feeRateSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feeRateSchedule")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeeRateSchedule(Schedule _feeRateSchedule) {
			this.feeRateSchedule = _feeRateSchedule == null ? null : _feeRateSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feePaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feePaymentDate")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder setFeePaymentDate(RelativeDateOffset _feePaymentDate) {
			this.feePaymentDate = _feePaymentDate == null ? null : _feePaymentDate.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseFeeSchedule build() {
			return new ExerciseFeeSchedule.ExerciseFeeScheduleImpl(this);
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (feeAmountSchedule!=null && !feeAmountSchedule.prune().hasData()) feeAmountSchedule = null;
			if (feeRateSchedule!=null && !feeRateSchedule.prune().hasData()) feeRateSchedule = null;
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
			if (getFeeAmountSchedule()!=null && getFeeAmountSchedule().hasData()) return true;
			if (getFeeRateSchedule()!=null && getFeeRateSchedule().hasData()) return true;
			if (getFeePaymentDate()!=null && getFeePaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseFeeSchedule.ExerciseFeeScheduleBuilder o = (ExerciseFeeSchedule.ExerciseFeeScheduleBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getFeeAmountSchedule(), o.getFeeAmountSchedule(), this::setFeeAmountSchedule);
			merger.mergeRosetta(getFeeRateSchedule(), o.getFeeRateSchedule(), this::setFeeRateSchedule);
			merger.mergeRosetta(getFeePaymentDate(), o.getFeePaymentDate(), this::setFeePaymentDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseFeeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(feeAmountSchedule, _that.getFeeAmountSchedule())) return false;
			if (!Objects.equals(feeRateSchedule, _that.getFeeRateSchedule())) return false;
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
			_result = 31 * _result + (feeAmountSchedule != null ? feeAmountSchedule.hashCode() : 0);
			_result = 31 * _result + (feeRateSchedule != null ? feeRateSchedule.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFeeScheduleBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"feeAmountSchedule=" + this.feeAmountSchedule + ", " +
				"feeRateSchedule=" + this.feeRateSchedule + ", " +
				"feePaymentDate=" + this.feePaymentDate +
			'}';
		}
	}
}
