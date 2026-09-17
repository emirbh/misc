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
import fpml.consolidated.shared.meta.PaymentTypeMeta;
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
@RosettaDataType(value="PaymentType", builder=PaymentType.PaymentTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PaymentType", model="fpml", builder=PaymentType.PaymentTypeBuilderImpl.class, version="2.1.1")
public interface PaymentType extends RosettaModelObject {

	PaymentTypeMeta metaData = new PaymentTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getValue();
	/**
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
	String getPaymentTypeScheme();

	/*********************** Build Methods  ***********************/
	PaymentType build();
	
	PaymentType.PaymentTypeBuilder toBuilder();
	
	static PaymentType.PaymentTypeBuilder builder() {
		return new PaymentType.PaymentTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaymentType> getType() {
		return PaymentType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("paymentTypeScheme"), String.class, getPaymentTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentTypeBuilder extends PaymentType, RosettaModelObjectBuilder {
		PaymentType.PaymentTypeBuilder setValue(String value);
		PaymentType.PaymentTypeBuilder setPaymentTypeScheme(String paymentTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("paymentTypeScheme"), String.class, getPaymentTypeScheme(), this);
		}
		

		PaymentType.PaymentTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentType  ***********************/
	class PaymentTypeImpl implements PaymentType {
		private final String value;
		private final String paymentTypeScheme;
		
		protected PaymentTypeImpl(PaymentType.PaymentTypeBuilder builder) {
			this.value = builder.getValue();
			this.paymentTypeScheme = builder.getPaymentTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("paymentTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentTypeScheme")
		public String getPaymentTypeScheme() {
			return paymentTypeScheme;
		}
		
		@Override
		public PaymentType build() {
			return this;
		}
		
		@Override
		public PaymentType.PaymentTypeBuilder toBuilder() {
			PaymentType.PaymentTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentType.PaymentTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPaymentTypeScheme()).ifPresent(builder::setPaymentTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(paymentTypeScheme, _that.getPaymentTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (paymentTypeScheme != null ? paymentTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentType {" +
				"value=" + this.value + ", " +
				"paymentTypeScheme=" + this.paymentTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentType  ***********************/
	class PaymentTypeBuilderImpl implements PaymentType.PaymentTypeBuilder {
	
		protected String value;
		protected String paymentTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("paymentTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentTypeScheme")
		public String getPaymentTypeScheme() {
			return paymentTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public PaymentType.PaymentTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("paymentTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentTypeScheme")
		@Override
		public PaymentType.PaymentTypeBuilder setPaymentTypeScheme(String _paymentTypeScheme) {
			this.paymentTypeScheme = _paymentTypeScheme == null ? null : _paymentTypeScheme;
			return this;
		}
		
		@Override
		public PaymentType build() {
			return new PaymentType.PaymentTypeImpl(this);
		}
		
		@Override
		public PaymentType.PaymentTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentType.PaymentTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPaymentTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentType.PaymentTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentType.PaymentTypeBuilder o = (PaymentType.PaymentTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPaymentTypeScheme(), o.getPaymentTypeScheme(), this::setPaymentTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(paymentTypeScheme, _that.getPaymentTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (paymentTypeScheme != null ? paymentTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentTypeBuilder {" +
				"value=" + this.value + ", " +
				"paymentTypeScheme=" + this.paymentTypeScheme +
			'}';
		}
	}
}
