package fpml.consolidated.dividend.swaps;

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
import fpml.consolidated.dividend.swaps.meta.FixedPaymentAmountMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PaymentBase;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Fixed payment amount within a Dividend Swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Fixed payment amount within a Dividend Swap.
 *
 */
@RosettaDataType(value="FixedPaymentAmount", builder=FixedPaymentAmount.FixedPaymentAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FixedPaymentAmount", model="fpml", builder=FixedPaymentAmount.FixedPaymentAmountBuilderImpl.class, version="2.1.1")
public interface FixedPaymentAmount extends PaymentBase {

	FixedPaymentAmountMeta metaData = new FixedPaymentAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Payment amount, which is optional since the payment amount may be calculated using fixed strike and number of open units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Payment amount, which is optional since the payment amount may be calculated using fixed strike and number of open units.
	 *
	 */
	NonNegativeMoney getPaymentAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Payment date relative to another date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Payment date relative to another date.
	 *
	 */
	RelativeDateOffset getPaymentDate();

	/*********************** Build Methods  ***********************/
	FixedPaymentAmount build();
	
	FixedPaymentAmount.FixedPaymentAmountBuilder toBuilder();
	
	static FixedPaymentAmount.FixedPaymentAmountBuilder builder() {
		return new FixedPaymentAmount.FixedPaymentAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedPaymentAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FixedPaymentAmount> getType() {
		return FixedPaymentAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, RelativeDateOffset.class, getPaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedPaymentAmountBuilder extends FixedPaymentAmount, PaymentBase.PaymentBaseBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreatePaymentDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getPaymentDate();
		@Override
		FixedPaymentAmount.FixedPaymentAmountBuilder setId(String id);
		FixedPaymentAmount.FixedPaymentAmountBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		FixedPaymentAmount.FixedPaymentAmountBuilder setPaymentDate(RelativeDateOffset paymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getPaymentDate());
		}
		

		FixedPaymentAmount.FixedPaymentAmountBuilder prune();
	}

	/*********************** Immutable Implementation of FixedPaymentAmount  ***********************/
	class FixedPaymentAmountImpl extends PaymentBase.PaymentBaseImpl implements FixedPaymentAmount {
		private final NonNegativeMoney paymentAmount;
		private final RelativeDateOffset paymentDate;
		
		protected FixedPaymentAmountImpl(FixedPaymentAmount.FixedPaymentAmountBuilder builder) {
			super(builder);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentAmount")
		public NonNegativeMoney getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public RelativeDateOffset getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public FixedPaymentAmount build() {
			return this;
		}
		
		@Override
		public FixedPaymentAmount.FixedPaymentAmountBuilder toBuilder() {
			FixedPaymentAmount.FixedPaymentAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedPaymentAmount.FixedPaymentAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedPaymentAmount _that = getType().cast(o);
		
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPaymentAmount {" +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedPaymentAmount  ***********************/
	class FixedPaymentAmountBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements FixedPaymentAmount.FixedPaymentAmountBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder paymentAmount;
		protected RelativeDateOffset.RelativeDateOffsetBuilder paymentDate;
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
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
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreatePaymentDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FixedPaymentAmount.FixedPaymentAmountBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentAmount")
		@Override
		public FixedPaymentAmount.FixedPaymentAmountBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public FixedPaymentAmount.FixedPaymentAmountBuilder setPaymentDate(RelativeDateOffset _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@Override
		public FixedPaymentAmount build() {
			return new FixedPaymentAmount.FixedPaymentAmountImpl(this);
		}
		
		@Override
		public FixedPaymentAmount.FixedPaymentAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPaymentAmount.FixedPaymentAmountBuilder prune() {
			super.prune();
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPaymentAmount.FixedPaymentAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FixedPaymentAmount.FixedPaymentAmountBuilder o = (FixedPaymentAmount.FixedPaymentAmountBuilder) other;
			
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedPaymentAmount _that = getType().cast(o);
		
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPaymentAmountBuilder {" +
				"paymentAmount=" + this.paymentAmount + ", " +
				"paymentDate=" + this.paymentDate +
			'}' + " " + super.toString();
		}
	}
}
