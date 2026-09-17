package fpml.consolidated.reg.fpmlreporting.product;

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
import fpml.consolidated.reg.fpmlreporting.product.meta.RegReportingPaymentMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PaymentType;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Simple product representation providing key information about trade economics of any type of trade for regulatory reporting purposes. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegReportingPayment", builder=RegReportingPayment.RegReportingPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegReportingPayment", model="fpml", builder=RegReportingPayment.RegReportingPaymentBuilderImpl.class, version="2.1.1")
public interface RegReportingPayment extends NonNegativePayment {

	RegReportingPaymentMeta metaData = new RegReportingPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A classification of the type of fee or additional payment, e.g. brokerage, upfront fee etc. FpML does not define domain values for this element. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	PaymentType getPaymentType();

	/*********************** Build Methods  ***********************/
	RegReportingPayment build();
	
	RegReportingPayment.RegReportingPaymentBuilder toBuilder();
	
	static RegReportingPayment.RegReportingPaymentBuilder builder() {
		return new RegReportingPayment.RegReportingPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegReportingPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegReportingPayment> getType() {
		return RegReportingPayment.class;
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
		processRosetta(path.newSubPath("paymentType"), processor, PaymentType.class, getPaymentType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegReportingPaymentBuilder extends RegReportingPayment, NonNegativePayment.NonNegativePaymentBuilder {
		PaymentType.PaymentTypeBuilder getOrCreatePaymentType();
		@Override
		PaymentType.PaymentTypeBuilder getPaymentType();
		@Override
		RegReportingPayment.RegReportingPaymentBuilder setId(String id);
		@Override
		RegReportingPayment.RegReportingPaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		RegReportingPayment.RegReportingPaymentBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		RegReportingPayment.RegReportingPaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		RegReportingPayment.RegReportingPaymentBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		RegReportingPayment.RegReportingPaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		@Override
		RegReportingPayment.RegReportingPaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		RegReportingPayment.RegReportingPaymentBuilder setPaymentType(PaymentType paymentType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentType"), processor, PaymentType.PaymentTypeBuilder.class, getPaymentType());
		}
		

		RegReportingPayment.RegReportingPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of RegReportingPayment  ***********************/
	class RegReportingPaymentImpl extends NonNegativePayment.NonNegativePaymentImpl implements RegReportingPayment {
		private final PaymentType paymentType;
		
		protected RegReportingPaymentImpl(RegReportingPayment.RegReportingPaymentBuilder builder) {
			super(builder);
			this.paymentType = ofNullable(builder.getPaymentType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentType")
		public PaymentType getPaymentType() {
			return paymentType;
		}
		
		@Override
		public RegReportingPayment build() {
			return this;
		}
		
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder toBuilder() {
			RegReportingPayment.RegReportingPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegReportingPayment.RegReportingPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentType()).ifPresent(builder::setPaymentType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegReportingPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegReportingPayment {" +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegReportingPayment  ***********************/
	class RegReportingPaymentBuilderImpl extends NonNegativePayment.NonNegativePaymentBuilderImpl implements RegReportingPayment.RegReportingPaymentBuilder {
	
		protected PaymentType.PaymentTypeBuilder paymentType;
		
		@Override
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentType")
		public PaymentType.PaymentTypeBuilder getPaymentType() {
			return paymentType;
		}
		
		@Override
		public PaymentType.PaymentTypeBuilder getOrCreatePaymentType() {
			PaymentType.PaymentTypeBuilder result;
			if (paymentType!=null) {
				result = paymentType;
			}
			else {
				result = paymentType = PaymentType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentType")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder setPaymentType(PaymentType _paymentType) {
			this.paymentType = _paymentType == null ? null : _paymentType.toBuilder();
			return this;
		}
		
		@Override
		public RegReportingPayment build() {
			return new RegReportingPayment.RegReportingPaymentImpl(this);
		}
		
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder prune() {
			super.prune();
			if (paymentType!=null && !paymentType.prune().hasData()) paymentType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentType()!=null && getPaymentType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegReportingPayment.RegReportingPaymentBuilder o = (RegReportingPayment.RegReportingPaymentBuilder) other;
			
			merger.mergeRosetta(getPaymentType(), o.getPaymentType(), this::setPaymentType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegReportingPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegReportingPaymentBuilder {" +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}
}
