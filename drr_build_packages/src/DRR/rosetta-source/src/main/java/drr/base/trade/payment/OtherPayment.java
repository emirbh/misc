package drr.base.trade.payment;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
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
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.meta.OtherPaymentMeta;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="OtherPayment", builder=OtherPayment.OtherPaymentBuilderImpl.class, version="7.7.0")
@RuneDataType(value="OtherPayment", model="drr", builder=OtherPayment.OtherPaymentBuilderImpl.class, version="7.7.0")
public interface OtherPayment extends RosettaModelObject {

	OtherPaymentMeta metaData = new OtherPaymentMeta();

	/*********************** Getter Methods  ***********************/
	PaymentType4Code getPaymentType();
	BigDecimal getAmount();
	ISOCurrencyCodeEnum getCurrency();
	Date getDate();
	String getPayer();
	PartyIdentifierFormatEnum getPayerFormat();
	String getReceiver();
	PartyIdentifierFormatEnum getReceiverFormat();
	String getPayerSchemeName();
	String getReceiverSchemeName();

	/*********************** Build Methods  ***********************/
	OtherPayment build();
	
	OtherPayment.OtherPaymentBuilder toBuilder();
	
	static OtherPayment.OtherPaymentBuilder builder() {
		return new OtherPayment.OtherPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtherPayment> getType() {
		return OtherPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("paymentType"), PaymentType4Code.class, getPaymentType(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("payer"), String.class, getPayer(), this);
		processor.processBasic(path.newSubPath("payerFormat"), PartyIdentifierFormatEnum.class, getPayerFormat(), this);
		processor.processBasic(path.newSubPath("receiver"), String.class, getReceiver(), this);
		processor.processBasic(path.newSubPath("receiverFormat"), PartyIdentifierFormatEnum.class, getReceiverFormat(), this);
		processor.processBasic(path.newSubPath("payerSchemeName"), String.class, getPayerSchemeName(), this);
		processor.processBasic(path.newSubPath("receiverSchemeName"), String.class, getReceiverSchemeName(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherPaymentBuilder extends OtherPayment, RosettaModelObjectBuilder {
		OtherPayment.OtherPaymentBuilder setPaymentType(PaymentType4Code paymentType);
		OtherPayment.OtherPaymentBuilder setAmount(BigDecimal amount);
		OtherPayment.OtherPaymentBuilder setCurrency(ISOCurrencyCodeEnum currency);
		OtherPayment.OtherPaymentBuilder setDate(Date date);
		OtherPayment.OtherPaymentBuilder setPayer(String payer);
		OtherPayment.OtherPaymentBuilder setPayerFormat(PartyIdentifierFormatEnum payerFormat);
		OtherPayment.OtherPaymentBuilder setReceiver(String receiver);
		OtherPayment.OtherPaymentBuilder setReceiverFormat(PartyIdentifierFormatEnum receiverFormat);
		OtherPayment.OtherPaymentBuilder setPayerSchemeName(String payerSchemeName);
		OtherPayment.OtherPaymentBuilder setReceiverSchemeName(String receiverSchemeName);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("paymentType"), PaymentType4Code.class, getPaymentType(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("payer"), String.class, getPayer(), this);
			processor.processBasic(path.newSubPath("payerFormat"), PartyIdentifierFormatEnum.class, getPayerFormat(), this);
			processor.processBasic(path.newSubPath("receiver"), String.class, getReceiver(), this);
			processor.processBasic(path.newSubPath("receiverFormat"), PartyIdentifierFormatEnum.class, getReceiverFormat(), this);
			processor.processBasic(path.newSubPath("payerSchemeName"), String.class, getPayerSchemeName(), this);
			processor.processBasic(path.newSubPath("receiverSchemeName"), String.class, getReceiverSchemeName(), this);
		}
		

		OtherPayment.OtherPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of OtherPayment  ***********************/
	class OtherPaymentImpl implements OtherPayment {
		private final PaymentType4Code paymentType;
		private final BigDecimal amount;
		private final ISOCurrencyCodeEnum currency;
		private final Date date;
		private final String payer;
		private final PartyIdentifierFormatEnum payerFormat;
		private final String receiver;
		private final PartyIdentifierFormatEnum receiverFormat;
		private final String payerSchemeName;
		private final String receiverSchemeName;
		
		protected OtherPaymentImpl(OtherPayment.OtherPaymentBuilder builder) {
			this.paymentType = builder.getPaymentType();
			this.amount = builder.getAmount();
			this.currency = builder.getCurrency();
			this.date = builder.getDate();
			this.payer = builder.getPayer();
			this.payerFormat = builder.getPayerFormat();
			this.receiver = builder.getReceiver();
			this.receiverFormat = builder.getReceiverFormat();
			this.payerSchemeName = builder.getPayerSchemeName();
			this.receiverSchemeName = builder.getReceiverSchemeName();
		}
		
		@Override
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentType")
		public PaymentType4Code getPaymentType() {
			return paymentType;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("payer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payer")
		public String getPayer() {
			return payer;
		}
		
		@Override
		@RosettaAttribute("payerFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerFormat")
		public PartyIdentifierFormatEnum getPayerFormat() {
			return payerFormat;
		}
		
		@Override
		@RosettaAttribute("receiver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiver")
		public String getReceiver() {
			return receiver;
		}
		
		@Override
		@RosettaAttribute("receiverFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverFormat")
		public PartyIdentifierFormatEnum getReceiverFormat() {
			return receiverFormat;
		}
		
		@Override
		@RosettaAttribute("payerSchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerSchemeName")
		public String getPayerSchemeName() {
			return payerSchemeName;
		}
		
		@Override
		@RosettaAttribute("receiverSchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverSchemeName")
		public String getReceiverSchemeName() {
			return receiverSchemeName;
		}
		
		@Override
		public OtherPayment build() {
			return this;
		}
		
		@Override
		public OtherPayment.OtherPaymentBuilder toBuilder() {
			OtherPayment.OtherPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherPayment.OtherPaymentBuilder builder) {
			ofNullable(getPaymentType()).ifPresent(builder::setPaymentType);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getPayer()).ifPresent(builder::setPayer);
			ofNullable(getPayerFormat()).ifPresent(builder::setPayerFormat);
			ofNullable(getReceiver()).ifPresent(builder::setReceiver);
			ofNullable(getReceiverFormat()).ifPresent(builder::setReceiverFormat);
			ofNullable(getPayerSchemeName()).ifPresent(builder::setPayerSchemeName);
			ofNullable(getReceiverSchemeName()).ifPresent(builder::setReceiverSchemeName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(payer, _that.getPayer())) return false;
			if (!Objects.equals(payerFormat, _that.getPayerFormat())) return false;
			if (!Objects.equals(receiver, _that.getReceiver())) return false;
			if (!Objects.equals(receiverFormat, _that.getReceiverFormat())) return false;
			if (!Objects.equals(payerSchemeName, _that.getPayerSchemeName())) return false;
			if (!Objects.equals(receiverSchemeName, _that.getReceiverSchemeName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentType != null ? paymentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (payer != null ? payer.hashCode() : 0);
			_result = 31 * _result + (payerFormat != null ? payerFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (receiver != null ? receiver.hashCode() : 0);
			_result = 31 * _result + (receiverFormat != null ? receiverFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerSchemeName != null ? payerSchemeName.hashCode() : 0);
			_result = 31 * _result + (receiverSchemeName != null ? receiverSchemeName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherPayment {" +
				"paymentType=" + this.paymentType + ", " +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency + ", " +
				"date=" + this.date + ", " +
				"payer=" + this.payer + ", " +
				"payerFormat=" + this.payerFormat + ", " +
				"receiver=" + this.receiver + ", " +
				"receiverFormat=" + this.receiverFormat + ", " +
				"payerSchemeName=" + this.payerSchemeName + ", " +
				"receiverSchemeName=" + this.receiverSchemeName +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherPayment  ***********************/
	class OtherPaymentBuilderImpl implements OtherPayment.OtherPaymentBuilder {
	
		protected PaymentType4Code paymentType;
		protected BigDecimal amount;
		protected ISOCurrencyCodeEnum currency;
		protected Date date;
		protected String payer;
		protected PartyIdentifierFormatEnum payerFormat;
		protected String receiver;
		protected PartyIdentifierFormatEnum receiverFormat;
		protected String payerSchemeName;
		protected String receiverSchemeName;
		
		@Override
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentType")
		public PaymentType4Code getPaymentType() {
			return paymentType;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("payer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payer")
		public String getPayer() {
			return payer;
		}
		
		@Override
		@RosettaAttribute("payerFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerFormat")
		public PartyIdentifierFormatEnum getPayerFormat() {
			return payerFormat;
		}
		
		@Override
		@RosettaAttribute("receiver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiver")
		public String getReceiver() {
			return receiver;
		}
		
		@Override
		@RosettaAttribute("receiverFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverFormat")
		public PartyIdentifierFormatEnum getReceiverFormat() {
			return receiverFormat;
		}
		
		@Override
		@RosettaAttribute("payerSchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerSchemeName")
		public String getPayerSchemeName() {
			return payerSchemeName;
		}
		
		@Override
		@RosettaAttribute("receiverSchemeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverSchemeName")
		public String getReceiverSchemeName() {
			return receiverSchemeName;
		}
		
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentType")
		@Override
		public OtherPayment.OtherPaymentBuilder setPaymentType(PaymentType4Code _paymentType) {
			this.paymentType = _paymentType == null ? null : _paymentType;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public OtherPayment.OtherPaymentBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public OtherPayment.OtherPaymentBuilder setCurrency(ISOCurrencyCodeEnum _currency) {
			this.currency = _currency == null ? null : _currency;
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public OtherPayment.OtherPaymentBuilder setDate(Date _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("payer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payer")
		@Override
		public OtherPayment.OtherPaymentBuilder setPayer(String _payer) {
			this.payer = _payer == null ? null : _payer;
			return this;
		}
		
		@RosettaAttribute("payerFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerFormat")
		@Override
		public OtherPayment.OtherPaymentBuilder setPayerFormat(PartyIdentifierFormatEnum _payerFormat) {
			this.payerFormat = _payerFormat == null ? null : _payerFormat;
			return this;
		}
		
		@RosettaAttribute("receiver")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiver")
		@Override
		public OtherPayment.OtherPaymentBuilder setReceiver(String _receiver) {
			this.receiver = _receiver == null ? null : _receiver;
			return this;
		}
		
		@RosettaAttribute("receiverFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverFormat")
		@Override
		public OtherPayment.OtherPaymentBuilder setReceiverFormat(PartyIdentifierFormatEnum _receiverFormat) {
			this.receiverFormat = _receiverFormat == null ? null : _receiverFormat;
			return this;
		}
		
		@RosettaAttribute("payerSchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerSchemeName")
		@Override
		public OtherPayment.OtherPaymentBuilder setPayerSchemeName(String _payerSchemeName) {
			this.payerSchemeName = _payerSchemeName == null ? null : _payerSchemeName;
			return this;
		}
		
		@RosettaAttribute("receiverSchemeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverSchemeName")
		@Override
		public OtherPayment.OtherPaymentBuilder setReceiverSchemeName(String _receiverSchemeName) {
			this.receiverSchemeName = _receiverSchemeName == null ? null : _receiverSchemeName;
			return this;
		}
		
		@Override
		public OtherPayment build() {
			return new OtherPayment.OtherPaymentImpl(this);
		}
		
		@Override
		public OtherPayment.OtherPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherPayment.OtherPaymentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentType()!=null) return true;
			if (getAmount()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getDate()!=null) return true;
			if (getPayer()!=null) return true;
			if (getPayerFormat()!=null) return true;
			if (getReceiver()!=null) return true;
			if (getReceiverFormat()!=null) return true;
			if (getPayerSchemeName()!=null) return true;
			if (getReceiverSchemeName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherPayment.OtherPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherPayment.OtherPaymentBuilder o = (OtherPayment.OtherPaymentBuilder) other;
			
			
			merger.mergeBasic(getPaymentType(), o.getPaymentType(), this::setPaymentType);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getPayer(), o.getPayer(), this::setPayer);
			merger.mergeBasic(getPayerFormat(), o.getPayerFormat(), this::setPayerFormat);
			merger.mergeBasic(getReceiver(), o.getReceiver(), this::setReceiver);
			merger.mergeBasic(getReceiverFormat(), o.getReceiverFormat(), this::setReceiverFormat);
			merger.mergeBasic(getPayerSchemeName(), o.getPayerSchemeName(), this::setPayerSchemeName);
			merger.mergeBasic(getReceiverSchemeName(), o.getReceiverSchemeName(), this::setReceiverSchemeName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentType, _that.getPaymentType())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(payer, _that.getPayer())) return false;
			if (!Objects.equals(payerFormat, _that.getPayerFormat())) return false;
			if (!Objects.equals(receiver, _that.getReceiver())) return false;
			if (!Objects.equals(receiverFormat, _that.getReceiverFormat())) return false;
			if (!Objects.equals(payerSchemeName, _that.getPayerSchemeName())) return false;
			if (!Objects.equals(receiverSchemeName, _that.getReceiverSchemeName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentType != null ? paymentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (payer != null ? payer.hashCode() : 0);
			_result = 31 * _result + (payerFormat != null ? payerFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (receiver != null ? receiver.hashCode() : 0);
			_result = 31 * _result + (receiverFormat != null ? receiverFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerSchemeName != null ? payerSchemeName.hashCode() : 0);
			_result = 31 * _result + (receiverSchemeName != null ? receiverSchemeName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherPaymentBuilder {" +
				"paymentType=" + this.paymentType + ", " +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency + ", " +
				"date=" + this.date + ", " +
				"payer=" + this.payer + ", " +
				"payerFormat=" + this.payerFormat + ", " +
				"receiver=" + this.receiver + ", " +
				"receiverFormat=" + this.receiverFormat + ", " +
				"payerSchemeName=" + this.payerSchemeName + ", " +
				"receiverSchemeName=" + this.receiverSchemeName +
			'}';
		}
	}
}
