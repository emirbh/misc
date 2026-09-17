package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.AdjustedPaymentDatesMeta;
import fpml.consolidated.shared.Money;
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
@RosettaDataType(value="AdjustedPaymentDates", builder=AdjustedPaymentDates.AdjustedPaymentDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdjustedPaymentDates", model="fpml", builder=AdjustedPaymentDates.AdjustedPaymentDatesBuilderImpl.class, version="2.1.1")
public interface AdjustedPaymentDates extends RosettaModelObject {

	AdjustedPaymentDatesMeta metaData = new AdjustedPaymentDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but my be specified to allow the fee structure to also serve as a cashflow type component (all dates the the Cashflows type are adjusted payment dates).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but my be specified to allow the fee structure to also serve as a cashflow type component (all dates the the Cashflows type are adjusted payment dates).
	 *
	 */
	ZonedDateTime getAdjustedPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency amount of the payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency amount of the payment.
	 *
	 */
	Money getPaymentAmount();

	/*********************** Build Methods  ***********************/
	AdjustedPaymentDates build();
	
	AdjustedPaymentDates.AdjustedPaymentDatesBuilder toBuilder();
	
	static AdjustedPaymentDates.AdjustedPaymentDatesBuilder builder() {
		return new AdjustedPaymentDates.AdjustedPaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustedPaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustedPaymentDates> getType() {
		return AdjustedPaymentDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedPaymentDate"), ZonedDateTime.class, getAdjustedPaymentDate(), this);
		processRosetta(path.newSubPath("paymentAmount"), processor, Money.class, getPaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustedPaymentDatesBuilder extends AdjustedPaymentDates, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreatePaymentAmount();
		@Override
		Money.MoneyBuilder getPaymentAmount();
		AdjustedPaymentDates.AdjustedPaymentDatesBuilder setAdjustedPaymentDate(ZonedDateTime adjustedPaymentDate);
		AdjustedPaymentDates.AdjustedPaymentDatesBuilder setPaymentAmount(Money paymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustedPaymentDate"), ZonedDateTime.class, getAdjustedPaymentDate(), this);
			processRosetta(path.newSubPath("paymentAmount"), processor, Money.MoneyBuilder.class, getPaymentAmount());
		}
		

		AdjustedPaymentDates.AdjustedPaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustedPaymentDates  ***********************/
	class AdjustedPaymentDatesImpl implements AdjustedPaymentDates {
		private final ZonedDateTime adjustedPaymentDate;
		private final Money paymentAmount;
		
		protected AdjustedPaymentDatesImpl(AdjustedPaymentDates.AdjustedPaymentDatesBuilder builder) {
			this.adjustedPaymentDate = builder.getAdjustedPaymentDate();
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedPaymentDate")
		public ZonedDateTime getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentAmount")
		public Money getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public AdjustedPaymentDates build() {
			return this;
		}
		
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder toBuilder() {
			AdjustedPaymentDates.AdjustedPaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustedPaymentDates.AdjustedPaymentDatesBuilder builder) {
			ofNullable(getAdjustedPaymentDate()).ifPresent(builder::setAdjustedPaymentDate);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustedPaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedPaymentDates {" +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustedPaymentDates  ***********************/
	class AdjustedPaymentDatesBuilderImpl implements AdjustedPaymentDates.AdjustedPaymentDatesBuilder {
	
		protected ZonedDateTime adjustedPaymentDate;
		protected Money.MoneyBuilder paymentAmount;
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedPaymentDate")
		public ZonedDateTime getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentAmount")
		public Money.MoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePaymentAmount() {
			Money.MoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedPaymentDate")
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder setAdjustedPaymentDate(ZonedDateTime _adjustedPaymentDate) {
			this.adjustedPaymentDate = _adjustedPaymentDate == null ? null : _adjustedPaymentDate;
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentAmount")
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder setPaymentAmount(Money _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedPaymentDates build() {
			return new AdjustedPaymentDates.AdjustedPaymentDatesImpl(this);
		}
		
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder prune() {
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedPaymentDate()!=null) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustedPaymentDates.AdjustedPaymentDatesBuilder o = (AdjustedPaymentDates.AdjustedPaymentDatesBuilder) other;
			
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			
			merger.mergeBasic(getAdjustedPaymentDate(), o.getAdjustedPaymentDate(), this::setAdjustedPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustedPaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedPaymentDatesBuilder {" +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}';
		}
	}
}
