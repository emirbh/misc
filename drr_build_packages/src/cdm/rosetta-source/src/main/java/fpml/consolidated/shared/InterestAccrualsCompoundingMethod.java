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
import fpml.consolidated.fpmlenum.CompoundingMethodEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.meta.InterestAccrualsCompoundingMethodMeta;
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
 * Provision A type defining the way in which interests are accrued: the applicable rate (fixed or floating reference) and the compounding method.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the way in which interests are accrued: the applicable rate (fixed or floating reference) and the compounding method.
 *
 */
@RosettaDataType(value="InterestAccrualsCompoundingMethod", builder=InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InterestAccrualsCompoundingMethod", model="fpml", builder=InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilderImpl.class, version="2.1.1")
public interface InterestAccrualsCompoundingMethod extends InterestAccrualsMethod {

	InterestAccrualsCompoundingMethodMeta metaData = new InterestAccrualsCompoundingMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If more that one calculation period contributes to a single payment amount this element specifies whether compounding is applicable, and if so, what compounding method is to be used. This element must only be included when more that one calculation period contributes to a single payment amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If more that one calculation period contributes to a single payment amount this element specifies whether compounding is applicable, and if so, what compounding method is to be used. This element must only be included when more that one calculation period contributes to a single payment amount.
	 *
	 */
	CompoundingMethodEnum getCompoundingMethod();

	/*********************** Build Methods  ***********************/
	InterestAccrualsCompoundingMethod build();
	
	InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder toBuilder();
	
	static InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder builder() {
		return new InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestAccrualsCompoundingMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestAccrualsCompoundingMethod> getType() {
		return InterestAccrualsCompoundingMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.class, getFloatingRateCalculation());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestAccrualsCompoundingMethodBuilder extends InterestAccrualsCompoundingMethod, InterestAccrualsMethod.InterestAccrualsMethodBuilder {
		@Override
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation);
		@Override
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setFixedRate(BigDecimal fixedRate);
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRateCalculation());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
		}
		

		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder prune();
	}

	/*********************** Immutable Implementation of InterestAccrualsCompoundingMethod  ***********************/
	class InterestAccrualsCompoundingMethodImpl extends InterestAccrualsMethod.InterestAccrualsMethodImpl implements InterestAccrualsCompoundingMethod {
		private final CompoundingMethodEnum compoundingMethod;
		
		protected InterestAccrualsCompoundingMethodImpl(InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder builder) {
			super(builder);
			this.compoundingMethod = builder.getCompoundingMethod();
		}
		
		@Override
		@RosettaAttribute("compoundingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		public InterestAccrualsCompoundingMethod build() {
			return this;
		}
		
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder toBuilder() {
			InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCompoundingMethod()).ifPresent(builder::setCompoundingMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestAccrualsCompoundingMethod _that = getType().cast(o);
		
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAccrualsCompoundingMethod {" +
				"compoundingMethod=" + this.compoundingMethod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestAccrualsCompoundingMethod  ***********************/
	class InterestAccrualsCompoundingMethodBuilderImpl extends InterestAccrualsMethod.InterestAccrualsMethodBuilderImpl implements InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder {
	
		protected CompoundingMethodEnum compoundingMethod;
		
		@Override
		@RosettaAttribute("compoundingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@RosettaAttribute("floatingRateCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateCalculation")
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setFloatingRateCalculation(FloatingRateCalculation _floatingRateCalculation) {
			this.floatingRateCalculation = _floatingRateCalculation == null ? null : _floatingRateCalculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("compoundingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compoundingMethod")
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setCompoundingMethod(CompoundingMethodEnum _compoundingMethod) {
			this.compoundingMethod = _compoundingMethod == null ? null : _compoundingMethod;
			return this;
		}
		
		@Override
		public InterestAccrualsCompoundingMethod build() {
			return new InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodImpl(this);
		}
		
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCompoundingMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder o = (InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder) other;
			
			
			merger.mergeBasic(getCompoundingMethod(), o.getCompoundingMethod(), this::setCompoundingMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestAccrualsCompoundingMethod _that = getType().cast(o);
		
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAccrualsCompoundingMethodBuilder {" +
				"compoundingMethod=" + this.compoundingMethod +
			'}' + " " + super.toString();
		}
	}
}
