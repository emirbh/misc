package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.PercentageRuleMeta;
import fpml.consolidated.shared.NotionalAmountReference;
import fpml.consolidated.shared.PaymentRule;
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
 * Provision A type defining a content model for a calculation rule defined as percentage of the notional amount. Do not delete this orphan. This is used as an example for defining a different content model for a calculation rule.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a content model for a calculation rule defined as percentage of the notional amount. Do not delete this orphan. This is used as an example for defining a different content model for a calculation rule.
 *
 */
@RosettaDataType(value="PercentageRule", builder=PercentageRule.PercentageRuleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PercentageRule", model="fpml", builder=PercentageRule.PercentageRuleBuilderImpl.class, version="2.1.1")
public interface PercentageRule extends PaymentRule {

	PercentageRuleMeta metaData = new PercentageRuleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A percentage of the notional amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A percentage of the notional amount.
	 *
	 */
	BigDecimal getPaymentPercent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the notional amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the notional amount.
	 *
	 */
	NotionalAmountReference getNotionalAmountReference();

	/*********************** Build Methods  ***********************/
	PercentageRule build();
	
	PercentageRule.PercentageRuleBuilder toBuilder();
	
	static PercentageRule.PercentageRuleBuilder builder() {
		return new PercentageRule.PercentageRuleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PercentageRule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PercentageRule> getType() {
		return PercentageRule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("paymentPercent"), BigDecimal.class, getPaymentPercent(), this);
		processRosetta(path.newSubPath("notionalAmountReference"), processor, NotionalAmountReference.class, getNotionalAmountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PercentageRuleBuilder extends PercentageRule, PaymentRule.PaymentRuleBuilder {
		NotionalAmountReference.NotionalAmountReferenceBuilder getOrCreateNotionalAmountReference();
		@Override
		NotionalAmountReference.NotionalAmountReferenceBuilder getNotionalAmountReference();
		PercentageRule.PercentageRuleBuilder setPaymentPercent(BigDecimal paymentPercent);
		PercentageRule.PercentageRuleBuilder setNotionalAmountReference(NotionalAmountReference notionalAmountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("paymentPercent"), BigDecimal.class, getPaymentPercent(), this);
			processRosetta(path.newSubPath("notionalAmountReference"), processor, NotionalAmountReference.NotionalAmountReferenceBuilder.class, getNotionalAmountReference());
		}
		

		PercentageRule.PercentageRuleBuilder prune();
	}

	/*********************** Immutable Implementation of PercentageRule  ***********************/
	class PercentageRuleImpl extends PaymentRule.PaymentRuleImpl implements PercentageRule {
		private final BigDecimal paymentPercent;
		private final NotionalAmountReference notionalAmountReference;
		
		protected PercentageRuleImpl(PercentageRule.PercentageRuleBuilder builder) {
			super(builder);
			this.paymentPercent = builder.getPaymentPercent();
			this.notionalAmountReference = ofNullable(builder.getNotionalAmountReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentPercent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentPercent")
		public BigDecimal getPaymentPercent() {
			return paymentPercent;
		}
		
		@Override
		@RosettaAttribute("notionalAmountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmountReference")
		public NotionalAmountReference getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		public PercentageRule build() {
			return this;
		}
		
		@Override
		public PercentageRule.PercentageRuleBuilder toBuilder() {
			PercentageRule.PercentageRuleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PercentageRule.PercentageRuleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentPercent()).ifPresent(builder::setPaymentPercent);
			ofNullable(getNotionalAmountReference()).ifPresent(builder::setNotionalAmountReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PercentageRule _that = getType().cast(o);
		
			if (!Objects.equals(paymentPercent, _that.getPaymentPercent())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentPercent != null ? paymentPercent.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PercentageRule {" +
				"paymentPercent=" + this.paymentPercent + ", " +
				"notionalAmountReference=" + this.notionalAmountReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PercentageRule  ***********************/
	class PercentageRuleBuilderImpl extends PaymentRule.PaymentRuleBuilderImpl implements PercentageRule.PercentageRuleBuilder {
	
		protected BigDecimal paymentPercent;
		protected NotionalAmountReference.NotionalAmountReferenceBuilder notionalAmountReference;
		
		@Override
		@RosettaAttribute("paymentPercent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentPercent")
		public BigDecimal getPaymentPercent() {
			return paymentPercent;
		}
		
		@Override
		@RosettaAttribute("notionalAmountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmountReference")
		public NotionalAmountReference.NotionalAmountReferenceBuilder getNotionalAmountReference() {
			return notionalAmountReference;
		}
		
		@Override
		public NotionalAmountReference.NotionalAmountReferenceBuilder getOrCreateNotionalAmountReference() {
			NotionalAmountReference.NotionalAmountReferenceBuilder result;
			if (notionalAmountReference!=null) {
				result = notionalAmountReference;
			}
			else {
				result = notionalAmountReference = NotionalAmountReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("paymentPercent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentPercent")
		@Override
		public PercentageRule.PercentageRuleBuilder setPaymentPercent(BigDecimal _paymentPercent) {
			this.paymentPercent = _paymentPercent == null ? null : _paymentPercent;
			return this;
		}
		
		@RosettaAttribute("notionalAmountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmountReference")
		@Override
		public PercentageRule.PercentageRuleBuilder setNotionalAmountReference(NotionalAmountReference _notionalAmountReference) {
			this.notionalAmountReference = _notionalAmountReference == null ? null : _notionalAmountReference.toBuilder();
			return this;
		}
		
		@Override
		public PercentageRule build() {
			return new PercentageRule.PercentageRuleImpl(this);
		}
		
		@Override
		public PercentageRule.PercentageRuleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PercentageRule.PercentageRuleBuilder prune() {
			super.prune();
			if (notionalAmountReference!=null && !notionalAmountReference.prune().hasData()) notionalAmountReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentPercent()!=null) return true;
			if (getNotionalAmountReference()!=null && getNotionalAmountReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PercentageRule.PercentageRuleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PercentageRule.PercentageRuleBuilder o = (PercentageRule.PercentageRuleBuilder) other;
			
			merger.mergeRosetta(getNotionalAmountReference(), o.getNotionalAmountReference(), this::setNotionalAmountReference);
			
			merger.mergeBasic(getPaymentPercent(), o.getPaymentPercent(), this::setPaymentPercent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PercentageRule _that = getType().cast(o);
		
			if (!Objects.equals(paymentPercent, _that.getPaymentPercent())) return false;
			if (!Objects.equals(notionalAmountReference, _that.getNotionalAmountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentPercent != null ? paymentPercent.hashCode() : 0);
			_result = 31 * _result + (notionalAmountReference != null ? notionalAmountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PercentageRuleBuilder {" +
				"paymentPercent=" + this.paymentPercent + ", " +
				"notionalAmountReference=" + this.notionalAmountReference +
			'}' + " " + super.toString();
		}
	}
}
