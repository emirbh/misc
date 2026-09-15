package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.PaymentDetailMeta;
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
@RosettaDataType(value="PaymentDetail", builder=PaymentDetail.PaymentDetailBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PaymentDetail", model="fpml", builder=PaymentDetail.PaymentDetailBuilderImpl.class, version="2.1.1")
public interface PaymentDetail extends PaymentBase {

	PaymentDetailMeta metaData = new PaymentDetailMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Payment date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Payment date.
	 *
	 */
	AdjustableOrRelativeDate getPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A structure defining the calculation rule of the independent amount. Users are supposed to use type substitution at PaymentRule. PaymentRule is abstract and it is supposed to be substituted by PercentageRule. There is the expectation that other rules will be created in the future to model other types of independent amount payment rules.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure defining the calculation rule of the independent amount. Users are supposed to use type substitution at PaymentRule. PaymentRule is abstract and it is supposed to be substituted by PercentageRule. There is the expectation that other rules will be created in the future to model other types of independent amount payment rules.
	 *
	 */
	PaymentRule getPaymentRule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A fixed payment amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fixed payment amount.
	 *
	 */
	Money getPaymentAmount();

	/*********************** Build Methods  ***********************/
	PaymentDetail build();
	
	PaymentDetail.PaymentDetailBuilder toBuilder();
	
	static PaymentDetail.PaymentDetailBuilder builder() {
		return new PaymentDetail.PaymentDetailBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentDetail> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaymentDetail> getType() {
		return PaymentDetail.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentRule"), processor, PaymentRule.class, getPaymentRule());
		processRosetta(path.newSubPath("paymentAmount"), processor, Money.class, getPaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentDetailBuilder extends PaymentDetail, PaymentBase.PaymentBaseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate();
		PaymentRule.PaymentRuleBuilder getOrCreatePaymentRule();
		@Override
		PaymentRule.PaymentRuleBuilder getPaymentRule();
		Money.MoneyBuilder getOrCreatePaymentAmount();
		@Override
		Money.MoneyBuilder getPaymentAmount();
		@Override
		PaymentDetail.PaymentDetailBuilder setId(String id);
		PaymentDetail.PaymentDetailBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		PaymentDetail.PaymentDetailBuilder setPaymentRule(PaymentRule paymentRule);
		PaymentDetail.PaymentDetailBuilder setPaymentAmount(Money paymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentRule"), processor, PaymentRule.PaymentRuleBuilder.class, getPaymentRule());
			processRosetta(path.newSubPath("paymentAmount"), processor, Money.MoneyBuilder.class, getPaymentAmount());
		}
		

		PaymentDetail.PaymentDetailBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentDetail  ***********************/
	class PaymentDetailImpl extends PaymentBase.PaymentBaseImpl implements PaymentDetail {
		private final AdjustableOrRelativeDate paymentDate;
		private final PaymentRule paymentRule;
		private final Money paymentAmount;
		
		protected PaymentDetailImpl(PaymentDetail.PaymentDetailBuilder builder) {
			super(builder);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.paymentRule = ofNullable(builder.getPaymentRule()).map(f->f.build()).orElse(null);
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public AdjustableOrRelativeDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("paymentRule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentRule")
		public PaymentRule getPaymentRule() {
			return paymentRule;
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentAmount")
		public Money getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public PaymentDetail build() {
			return this;
		}
		
		@Override
		public PaymentDetail.PaymentDetailBuilder toBuilder() {
			PaymentDetail.PaymentDetailBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDetail.PaymentDetailBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getPaymentRule()).ifPresent(builder::setPaymentRule);
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentDetail _that = getType().cast(o);
		
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentRule, _that.getPaymentRule())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentRule != null ? paymentRule.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetail {" +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentRule=" + this.paymentRule + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PaymentDetail  ***********************/
	class PaymentDetailBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements PaymentDetail.PaymentDetailBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDate;
		protected PaymentRule.PaymentRuleBuilder paymentRule;
		protected Money.MoneyBuilder paymentAmount;
		
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
		@RosettaAttribute("paymentRule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentRule")
		public PaymentRule.PaymentRuleBuilder getPaymentRule() {
			return paymentRule;
		}
		
		@Override
		public PaymentRule.PaymentRuleBuilder getOrCreatePaymentRule() {
			PaymentRule.PaymentRuleBuilder result;
			if (paymentRule!=null) {
				result = paymentRule;
			}
			else {
				result = paymentRule = PaymentRule.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PaymentDetail.PaymentDetailBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public PaymentDetail.PaymentDetailBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentRule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentRule")
		@Override
		public PaymentDetail.PaymentDetailBuilder setPaymentRule(PaymentRule _paymentRule) {
			this.paymentRule = _paymentRule == null ? null : _paymentRule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentAmount")
		@Override
		public PaymentDetail.PaymentDetailBuilder setPaymentAmount(Money _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public PaymentDetail build() {
			return new PaymentDetail.PaymentDetailImpl(this);
		}
		
		@Override
		public PaymentDetail.PaymentDetailBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetail.PaymentDetailBuilder prune() {
			super.prune();
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (paymentRule!=null && !paymentRule.prune().hasData()) paymentRule = null;
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getPaymentRule()!=null && getPaymentRule().hasData()) return true;
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetail.PaymentDetailBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PaymentDetail.PaymentDetailBuilder o = (PaymentDetail.PaymentDetailBuilder) other;
			
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getPaymentRule(), o.getPaymentRule(), this::setPaymentRule);
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentDetail _that = getType().cast(o);
		
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(paymentRule, _that.getPaymentRule())) return false;
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (paymentRule != null ? paymentRule.hashCode() : 0);
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetailBuilder {" +
				"paymentDate=" + this.paymentDate + ", " +
				"paymentRule=" + this.paymentRule + ", " +
				"paymentAmount=" + this.paymentAmount +
			'}' + " " + super.toString();
		}
	}
}
