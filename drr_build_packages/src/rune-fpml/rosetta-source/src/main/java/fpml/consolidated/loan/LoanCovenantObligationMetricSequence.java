package fpml.consolidated.loan;

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
import fpml.consolidated.fpmlenum.LoanCovenantObligationMetricValueTypeEnum;
import fpml.consolidated.loan.meta.LoanCovenantObligationMetricSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LoanCovenantObligationMetricSequence", builder=LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationMetricSequence", model="fpml", builder=LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationMetricSequence extends RosettaModelObject {

	LoanCovenantObligationMetricSequenceMeta metaData = new LoanCovenantObligationMetricSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A metric value of the covenant obligation.
	 *
	 */
	BigDecimal getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of metric value of the covenant obligation, described by an enumeration.
	 *
	 */
	LoanCovenantObligationMetricValueTypeEnum getValueType();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationMetricSequence build();
	
	LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder toBuilder();
	
	static LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder builder() {
		return new LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationMetricSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationMetricSequence> getType() {
		return LoanCovenantObligationMetricSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("valueType"), LoanCovenantObligationMetricValueTypeEnum.class, getValueType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationMetricSequenceBuilder extends LoanCovenantObligationMetricSequence, RosettaModelObjectBuilder {
		LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder setValue(BigDecimal value);
		LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder setValueType(LoanCovenantObligationMetricValueTypeEnum valueType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("valueType"), LoanCovenantObligationMetricValueTypeEnum.class, getValueType(), this);
		}
		

		LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationMetricSequence  ***********************/
	class LoanCovenantObligationMetricSequenceImpl implements LoanCovenantObligationMetricSequence {
		private final BigDecimal value;
		private final LoanCovenantObligationMetricValueTypeEnum valueType;
		
		protected LoanCovenantObligationMetricSequenceImpl(LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder builder) {
			this.value = builder.getValue();
			this.valueType = builder.getValueType();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("valueType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valueType")
		public LoanCovenantObligationMetricValueTypeEnum getValueType() {
			return valueType;
		}
		
		@Override
		public LoanCovenantObligationMetricSequence build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder toBuilder() {
			LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getValueType()).ifPresent(builder::setValueType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetricSequence _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(valueType, _that.getValueType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (valueType != null ? valueType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetricSequence {" +
				"value=" + this.value + ", " +
				"valueType=" + this.valueType +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationMetricSequence  ***********************/
	class LoanCovenantObligationMetricSequenceBuilderImpl implements LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder {
	
		protected BigDecimal value;
		protected LoanCovenantObligationMetricValueTypeEnum valueType;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("valueType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valueType")
		public LoanCovenantObligationMetricValueTypeEnum getValueType() {
			return valueType;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("valueType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valueType")
		@Override
		public LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder setValueType(LoanCovenantObligationMetricValueTypeEnum _valueType) {
			this.valueType = _valueType == null ? null : _valueType;
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricSequence build() {
			return new LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceImpl(this);
		}
		
		@Override
		public LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getValueType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder o = (LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getValueType(), o.getValueType(), this::setValueType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetricSequence _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(valueType, _that.getValueType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (valueType != null ? valueType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetricSequenceBuilder {" +
				"value=" + this.value + ", " +
				"valueType=" + this.valueType +
			'}';
		}
	}
}
