package fpml.consolidated.mktenv;

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
import fpml.consolidated.mktenv.meta.ParametricAdjustmentPointMeta;
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
 * Provision A value of the adjustment point, consisting of the x value and the corresponding y value.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A value of the adjustment point, consisting of the x value and the corresponding y value.
 *
 */
@RosettaDataType(value="ParametricAdjustmentPoint", builder=ParametricAdjustmentPoint.ParametricAdjustmentPointBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ParametricAdjustmentPoint", model="fpml", builder=ParametricAdjustmentPoint.ParametricAdjustmentPointBuilderImpl.class, version="2.1.1")
public interface ParametricAdjustmentPoint extends RosettaModelObject {

	ParametricAdjustmentPointMeta metaData = new ParametricAdjustmentPointMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The value of the independent variable (e.g. strike offset).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value of the independent variable (e.g. strike offset).
	 *
	 */
	BigDecimal getParameterValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The value of the dependent variable, the actual adjustment amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value of the dependent variable, the actual adjustment amount.
	 *
	 */
	BigDecimal getAdjustmentValue();

	/*********************** Build Methods  ***********************/
	ParametricAdjustmentPoint build();
	
	ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder toBuilder();
	
	static ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder builder() {
		return new ParametricAdjustmentPoint.ParametricAdjustmentPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ParametricAdjustmentPoint> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ParametricAdjustmentPoint> getType() {
		return ParametricAdjustmentPoint.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("parameterValue"), BigDecimal.class, getParameterValue(), this);
		processor.processBasic(path.newSubPath("adjustmentValue"), BigDecimal.class, getAdjustmentValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ParametricAdjustmentPointBuilder extends ParametricAdjustmentPoint, RosettaModelObjectBuilder {
		ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder setParameterValue(BigDecimal parameterValue);
		ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder setAdjustmentValue(BigDecimal adjustmentValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("parameterValue"), BigDecimal.class, getParameterValue(), this);
			processor.processBasic(path.newSubPath("adjustmentValue"), BigDecimal.class, getAdjustmentValue(), this);
		}
		

		ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder prune();
	}

	/*********************** Immutable Implementation of ParametricAdjustmentPoint  ***********************/
	class ParametricAdjustmentPointImpl implements ParametricAdjustmentPoint {
		private final BigDecimal parameterValue;
		private final BigDecimal adjustmentValue;
		
		protected ParametricAdjustmentPointImpl(ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder builder) {
			this.parameterValue = builder.getParameterValue();
			this.adjustmentValue = builder.getAdjustmentValue();
		}
		
		@Override
		@RosettaAttribute("parameterValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parameterValue")
		public BigDecimal getParameterValue() {
			return parameterValue;
		}
		
		@Override
		@RosettaAttribute("adjustmentValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustmentValue")
		public BigDecimal getAdjustmentValue() {
			return adjustmentValue;
		}
		
		@Override
		public ParametricAdjustmentPoint build() {
			return this;
		}
		
		@Override
		public ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder toBuilder() {
			ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder builder) {
			ofNullable(getParameterValue()).ifPresent(builder::setParameterValue);
			ofNullable(getAdjustmentValue()).ifPresent(builder::setAdjustmentValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricAdjustmentPoint _that = getType().cast(o);
		
			if (!Objects.equals(parameterValue, _that.getParameterValue())) return false;
			if (!Objects.equals(adjustmentValue, _that.getAdjustmentValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parameterValue != null ? parameterValue.hashCode() : 0);
			_result = 31 * _result + (adjustmentValue != null ? adjustmentValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricAdjustmentPoint {" +
				"parameterValue=" + this.parameterValue + ", " +
				"adjustmentValue=" + this.adjustmentValue +
			'}';
		}
	}

	/*********************** Builder Implementation of ParametricAdjustmentPoint  ***********************/
	class ParametricAdjustmentPointBuilderImpl implements ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder {
	
		protected BigDecimal parameterValue;
		protected BigDecimal adjustmentValue;
		
		@Override
		@RosettaAttribute("parameterValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parameterValue")
		public BigDecimal getParameterValue() {
			return parameterValue;
		}
		
		@Override
		@RosettaAttribute("adjustmentValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustmentValue")
		public BigDecimal getAdjustmentValue() {
			return adjustmentValue;
		}
		
		@RosettaAttribute("parameterValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parameterValue")
		@Override
		public ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder setParameterValue(BigDecimal _parameterValue) {
			this.parameterValue = _parameterValue == null ? null : _parameterValue;
			return this;
		}
		
		@RosettaAttribute("adjustmentValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustmentValue")
		@Override
		public ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder setAdjustmentValue(BigDecimal _adjustmentValue) {
			this.adjustmentValue = _adjustmentValue == null ? null : _adjustmentValue;
			return this;
		}
		
		@Override
		public ParametricAdjustmentPoint build() {
			return new ParametricAdjustmentPoint.ParametricAdjustmentPointImpl(this);
		}
		
		@Override
		public ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParameterValue()!=null) return true;
			if (getAdjustmentValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder o = (ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder) other;
			
			
			merger.mergeBasic(getParameterValue(), o.getParameterValue(), this::setParameterValue);
			merger.mergeBasic(getAdjustmentValue(), o.getAdjustmentValue(), this::setAdjustmentValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricAdjustmentPoint _that = getType().cast(o);
		
			if (!Objects.equals(parameterValue, _that.getParameterValue())) return false;
			if (!Objects.equals(adjustmentValue, _that.getAdjustmentValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parameterValue != null ? parameterValue.hashCode() : 0);
			_result = 31 * _result + (adjustmentValue != null ? adjustmentValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricAdjustmentPointBuilder {" +
				"parameterValue=" + this.parameterValue + ", " +
				"adjustmentValue=" + this.adjustmentValue +
			'}';
		}
	}
}
