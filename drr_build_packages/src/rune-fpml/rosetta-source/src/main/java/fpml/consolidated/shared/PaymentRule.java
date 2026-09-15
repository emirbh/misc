package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.PaymentRuleMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The abstract base type from which all calculation rules of the independent amount must be derived. Users are supposed to use type substitution at PaymentRule. PaymentRule is supposed to be substituted by PercentageRule. There is the expectation that other rules will be created to model other types of independent amount payment rules in the future.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The abstract base type from which all calculation rules of the independent amount must be derived. Users are supposed to use type substitution at PaymentRule. PaymentRule is supposed to be substituted by PercentageRule. There is the expectation that other rules will be created to model other types of independent amount payment rules in the future.
 *
 */
@RosettaDataType(value="PaymentRule", builder=PaymentRule.PaymentRuleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PaymentRule", model="fpml", builder=PaymentRule.PaymentRuleBuilderImpl.class, version="2.1.1")
public interface PaymentRule extends RosettaModelObject {

	PaymentRuleMeta metaData = new PaymentRuleMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	PaymentRule build();
	
	PaymentRule.PaymentRuleBuilder toBuilder();
	
	static PaymentRule.PaymentRuleBuilder builder() {
		return new PaymentRule.PaymentRuleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentRule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaymentRule> getType() {
		return PaymentRule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentRuleBuilder extends PaymentRule, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		PaymentRule.PaymentRuleBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentRule  ***********************/
	class PaymentRuleImpl implements PaymentRule {
		
		protected PaymentRuleImpl(PaymentRule.PaymentRuleBuilder builder) {
		}
		
		@Override
		public PaymentRule build() {
			return this;
		}
		
		@Override
		public PaymentRule.PaymentRuleBuilder toBuilder() {
			PaymentRule.PaymentRuleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentRule.PaymentRuleBuilder builder) {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentRule {" +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentRule  ***********************/
	class PaymentRuleBuilderImpl implements PaymentRule.PaymentRuleBuilder {
	
		
		@Override
		public PaymentRule build() {
			return new PaymentRule.PaymentRuleImpl(this);
		}
		
		@Override
		public PaymentRule.PaymentRuleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentRule.PaymentRuleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentRule.PaymentRuleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentRule.PaymentRuleBuilder o = (PaymentRule.PaymentRuleBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentRuleBuilder {" +
			'}';
		}
	}
}
