package cdm.observable.event;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.observable.common.TimeTypeEnum;
import cdm.observable.event.meta.FeaturePaymentMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Payment made following trigger occurrence.
 * @version 6.23.0
 */
@RosettaDataType(value="FeaturePayment", builder=FeaturePayment.FeaturePaymentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FeaturePayment", model="cdm", builder=FeaturePayment.FeaturePaymentBuilderImpl.class, version="6.23.0")
public interface FeaturePayment extends RosettaModelObject, GlobalKey {

	FeaturePaymentMeta metaData = new FeaturePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This attribute doesn&#39;t exist as part of the FpML construct, which makes use of the PayerReceiver.model group.
	 */
	PartyReferencePayerReceiver getPayerReceiver();
	/**
	 * The trigger level percentage.
	 */
	BigDecimal getLevelPercentage();
	/**
	 * The monetary quantity in currency units.
	 */
	BigDecimal getAmount();
	/**
	 * The feature payment time.
	 */
	TimeTypeEnum getTime();
	/**
	 * The currency in which an amount is denominated.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * The feature payment date.
	 */
	AdjustableOrRelativeDate getPaymentDate();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FeaturePayment build();
	
	FeaturePayment.FeaturePaymentBuilder toBuilder();
	
	static FeaturePayment.FeaturePaymentBuilder builder() {
		return new FeaturePayment.FeaturePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeaturePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FeaturePayment> getType() {
		return FeaturePayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.class, getPayerReceiver());
		processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("time"), TimeTypeEnum.class, getTime(), this);
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeaturePaymentBuilder extends FeaturePayment, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver();
		@Override
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCurrency();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getCurrency();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		FeaturePayment.FeaturePaymentBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver);
		FeaturePayment.FeaturePaymentBuilder setLevelPercentage(BigDecimal levelPercentage);
		FeaturePayment.FeaturePaymentBuilder setAmount(BigDecimal amount);
		FeaturePayment.FeaturePaymentBuilder setTime(TimeTypeEnum time);
		FeaturePayment.FeaturePaymentBuilder setCurrency(FieldWithMetaString currency);
		FeaturePayment.FeaturePaymentBuilder setCurrencyValue(String currency);
		FeaturePayment.FeaturePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		FeaturePayment.FeaturePaymentBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder.class, getPayerReceiver());
			processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("time"), TimeTypeEnum.class, getTime(), this);
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getCurrency());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FeaturePayment.FeaturePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of FeaturePayment  ***********************/
	class FeaturePaymentImpl implements FeaturePayment {
		private final PartyReferencePayerReceiver payerReceiver;
		private final BigDecimal levelPercentage;
		private final BigDecimal amount;
		private final TimeTypeEnum time;
		private final FieldWithMetaString currency;
		private final AdjustableOrRelativeDate paymentDate;
		private final MetaFields meta;
		
		protected FeaturePaymentImpl(FeaturePayment.FeaturePaymentBuilder builder) {
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
			this.levelPercentage = builder.getLevelPercentage();
			this.amount = builder.getAmount();
			this.time = builder.getTime();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerReceiver")
		public PartyReferencePayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public TimeTypeEnum getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public AdjustableOrRelativeDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public FeaturePayment build() {
			return this;
		}
		
		@Override
		public FeaturePayment.FeaturePaymentBuilder toBuilder() {
			FeaturePayment.FeaturePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeaturePayment.FeaturePaymentBuilder builder) {
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
			ofNullable(getLevelPercentage()).ifPresent(builder::setLevelPercentage);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeaturePayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeaturePayment {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"amount=" + this.amount + ", " +
				"time=" + this.time + ", " +
				"currency=" + this.currency + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FeaturePayment  ***********************/
	class FeaturePaymentBuilderImpl implements FeaturePayment.FeaturePaymentBuilder {
	
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder payerReceiver;
		protected BigDecimal levelPercentage;
		protected BigDecimal amount;
		protected TimeTypeEnum time;
		protected FieldWithMetaString.FieldWithMetaStringBuilder currency;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDate;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("payerReceiver")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerReceiver")
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver() {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PartyReferencePayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public TimeTypeEnum getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public FieldWithMetaString.FieldWithMetaStringBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCurrency() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("payerReceiver")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerReceiver")
		@Override
		public FeaturePayment.FeaturePaymentBuilder setPayerReceiver(PartyReferencePayerReceiver _payerReceiver) {
			this.payerReceiver = _payerReceiver == null ? null : _payerReceiver.toBuilder();
			return this;
		}
		
		@RosettaAttribute("levelPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("levelPercentage")
		@Override
		public FeaturePayment.FeaturePaymentBuilder setLevelPercentage(BigDecimal _levelPercentage) {
			this.levelPercentage = _levelPercentage == null ? null : _levelPercentage;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public FeaturePayment.FeaturePaymentBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("time")
		@Override
		public FeaturePayment.FeaturePaymentBuilder setTime(TimeTypeEnum _time) {
			this.time = _time == null ? null : _time;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public FeaturePayment.FeaturePaymentBuilder setCurrency(FieldWithMetaString _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@Override
		public FeaturePayment.FeaturePaymentBuilder setCurrencyValue(String _currency) {
			this.getOrCreateCurrency().setValue(_currency);
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public FeaturePayment.FeaturePaymentBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public FeaturePayment.FeaturePaymentBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public FeaturePayment build() {
			return new FeaturePayment.FeaturePaymentImpl(this);
		}
		
		@Override
		public FeaturePayment.FeaturePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeaturePayment.FeaturePaymentBuilder prune() {
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			if (getLevelPercentage()!=null) return true;
			if (getAmount()!=null) return true;
			if (getTime()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeaturePayment.FeaturePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FeaturePayment.FeaturePaymentBuilder o = (FeaturePayment.FeaturePaymentBuilder) other;
			
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getLevelPercentage(), o.getLevelPercentage(), this::setLevelPercentage);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeaturePayment _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeaturePaymentBuilder {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"amount=" + this.amount + ", " +
				"time=" + this.time + ", " +
				"currency=" + this.currency + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
