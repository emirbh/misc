package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.PendingPaymentMeta;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PaymentBase;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A structure representing a pending dividend or coupon payment.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure representing a pending dividend or coupon payment.
 *
 */
@RosettaDataType(value="PendingPayment", builder=PendingPayment.PendingPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PendingPayment", model="fpml", builder=PendingPayment.PendingPaymentBuilderImpl.class, version="2.1.1")
public interface PendingPayment extends PaymentBase {

	PendingPaymentMeta metaData = new PendingPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date that the dividend or coupon is due.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date that the dividend or coupon is due.
	 *
	 */
	ZonedDateTime getPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount of the dividend or coupon payment. Value of dividends or coupon between ex and pay date. Stock: if we are between ex-date and pay-date and the dividend is payable under the swap, then this should be the ex-div amount * # of securities. Bond: regardless of where we are vis-a-vis resets: (coupon % * face of bonds on swap * (bond day count fraction using days last coupon pay date of the bond through today).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of the dividend or coupon payment. Value of dividends or coupon between ex and pay date. Stock: if we are between ex-date and pay-date and the dividend is payable under the swap, then this should be the ex-div amount * # of securities. Bond: regardless of where we are vis-a-vis resets: (coupon % * face of bonds on swap * (bond day count fraction using days last coupon pay date of the bond through today).
	 *
	 */
	Money getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Accrued interest on the dividend or coupon payment. When the TRS is structured to pay a dividend or coupon on reset after payable date, you may earn interest on these amounts. This field indicates the interest accrued on dividend/coupon from pay date to statement date. This will only apply to a handful of agreements where dividendss are held to the next reset AND you receive/pay interest on unpaid amounts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Accrued interest on the dividend or coupon payment. When the TRS is structured to pay a dividend or coupon on reset after payable date, you may earn interest on these amounts. This field indicates the interest accrued on dividend/coupon from pay date to statement date. This will only apply to a handful of agreements where dividendss are held to the next reset AND you receive/pay interest on unpaid amounts.
	 *
	 */
	Money getAccruedInterest();

	/*********************** Build Methods  ***********************/
	PendingPayment build();
	
	PendingPayment.PendingPaymentBuilder toBuilder();
	
	static PendingPayment.PendingPaymentBuilder builder() {
		return new PendingPayment.PendingPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PendingPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PendingPayment> getType() {
		return PendingPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("paymentDate"), ZonedDateTime.class, getPaymentDate(), this);
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("accruedInterest"), processor, Money.class, getAccruedInterest());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PendingPaymentBuilder extends PendingPayment, PaymentBase.PaymentBaseBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		@Override
		Money.MoneyBuilder getAmount();
		Money.MoneyBuilder getOrCreateAccruedInterest();
		@Override
		Money.MoneyBuilder getAccruedInterest();
		@Override
		PendingPayment.PendingPaymentBuilder setId(String id);
		PendingPayment.PendingPaymentBuilder setPaymentDate(ZonedDateTime paymentDate);
		PendingPayment.PendingPaymentBuilder setAmount(Money amount);
		PendingPayment.PendingPaymentBuilder setAccruedInterest(Money accruedInterest);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("paymentDate"), ZonedDateTime.class, getPaymentDate(), this);
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accruedInterest"), processor, Money.MoneyBuilder.class, getAccruedInterest());
		}
		

		PendingPayment.PendingPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of PendingPayment  ***********************/
	class PendingPaymentImpl extends PaymentBase.PaymentBaseImpl implements PendingPayment {
		private final ZonedDateTime paymentDate;
		private final Money amount;
		private final Money accruedInterest;
		
		protected PendingPaymentImpl(PendingPayment.PendingPaymentBuilder builder) {
			super(builder);
			this.paymentDate = builder.getPaymentDate();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accruedInterest = ofNullable(builder.getAccruedInterest()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public ZonedDateTime getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("accruedInterest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruedInterest")
		public Money getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		public PendingPayment build() {
			return this;
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder toBuilder() {
			PendingPayment.PendingPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PendingPayment.PendingPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccruedInterest()).ifPresent(builder::setAccruedInterest);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PendingPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PendingPayment {" +
				"paymentDate=" + this.paymentDate + ", " +
				"amount=" + this.amount + ", " +
				"accruedInterest=" + this.accruedInterest +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PendingPayment  ***********************/
	class PendingPaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements PendingPayment.PendingPaymentBuilder {
	
		protected ZonedDateTime paymentDate;
		protected Money.MoneyBuilder amount;
		protected Money.MoneyBuilder accruedInterest;
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public ZonedDateTime getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Money.MoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAmount() {
			Money.MoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruedInterest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruedInterest")
		public Money.MoneyBuilder getAccruedInterest() {
			return accruedInterest;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAccruedInterest() {
			Money.MoneyBuilder result;
			if (accruedInterest!=null) {
				result = accruedInterest;
			}
			else {
				result = accruedInterest = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PendingPayment.PendingPaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public PendingPayment.PendingPaymentBuilder setPaymentDate(ZonedDateTime _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public PendingPayment.PendingPaymentBuilder setAmount(Money _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruedInterest")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruedInterest")
		@Override
		public PendingPayment.PendingPaymentBuilder setAccruedInterest(Money _accruedInterest) {
			this.accruedInterest = _accruedInterest == null ? null : _accruedInterest.toBuilder();
			return this;
		}
		
		@Override
		public PendingPayment build() {
			return new PendingPayment.PendingPaymentImpl(this);
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PendingPayment.PendingPaymentBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (accruedInterest!=null && !accruedInterest.prune().hasData()) accruedInterest = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentDate()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccruedInterest()!=null && getAccruedInterest().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PendingPayment.PendingPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PendingPayment.PendingPaymentBuilder o = (PendingPayment.PendingPaymentBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccruedInterest(), o.getAccruedInterest(), this::setAccruedInterest);
			
			merger.mergeBasic(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PendingPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(accruedInterest, _that.getAccruedInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accruedInterest != null ? accruedInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PendingPaymentBuilder {" +
				"paymentDate=" + this.paymentDate + ", " +
				"amount=" + this.amount + ", " +
				"accruedInterest=" + this.accruedInterest +
			'}' + " " + super.toString();
		}
	}
}
