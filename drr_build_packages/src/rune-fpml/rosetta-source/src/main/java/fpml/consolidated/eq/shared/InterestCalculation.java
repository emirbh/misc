package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.InterestCalculationMeta;
import fpml.consolidated.fpmlenum.InterpolationPeriodEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.InterestAccrualsMethod;
import fpml.consolidated.shared.InterpolationMethod;
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
 * Provision Specifies the calculation method of the interest rate leg of the return swap. Includes the floating or fixed rate calculation definitions, along with the determination of the day count fraction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies the calculation method of the interest rate leg of the return swap. Includes the floating or fixed rate calculation definitions, along with the determination of the day count fraction.
 *
 */
@RosettaDataType(value="InterestCalculation", builder=InterestCalculation.InterestCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InterestCalculation", model="fpml", builder=InterestCalculation.InterestCalculationBuilderImpl.class, version="2.1.1")
public interface InterestCalculation extends InterestAccrualsMethod {

	InterestCalculationMeta metaData = new InterestCalculationMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 */
	DayCountFraction getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines compounding rates on the Interest Leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines compounding rates on the Interest Leg.
	 *
	 */
	Compounding getCompounding();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the type of interpolation used.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the type of interpolation used.
	 *
	 */
	InterpolationMethod getInterpolationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines applicable periods for interpolation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines applicable periods for interpolation.
	 *
	 */
	InterpolationPeriodEnum getInterpolationPeriod();

	/*********************** Build Methods  ***********************/
	InterestCalculation build();
	
	InterestCalculation.InterestCalculationBuilder toBuilder();
	
	static InterestCalculation.InterestCalculationBuilder builder() {
		return new InterestCalculation.InterestCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestCalculation> getType() {
		return InterestCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.class, getFloatingRateCalculation());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("compounding"), processor, Compounding.class, getCompounding());
		processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.class, getInterpolationMethod());
		processor.processBasic(path.newSubPath("interpolationPeriod"), InterpolationPeriodEnum.class, getInterpolationPeriod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestCalculationBuilder extends InterestCalculation, InterestAccrualsMethod.InterestAccrualsMethodBuilder {
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		Compounding.CompoundingBuilder getOrCreateCompounding();
		@Override
		Compounding.CompoundingBuilder getCompounding();
		InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod();
		@Override
		InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod();
		@Override
		InterestCalculation.InterestCalculationBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation);
		@Override
		InterestCalculation.InterestCalculationBuilder setFixedRate(BigDecimal fixedRate);
		InterestCalculation.InterestCalculationBuilder setId(String id);
		InterestCalculation.InterestCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		InterestCalculation.InterestCalculationBuilder setCompounding(Compounding compounding);
		InterestCalculation.InterestCalculationBuilder setInterpolationMethod(InterpolationMethod interpolationMethod);
		InterestCalculation.InterestCalculationBuilder setInterpolationPeriod(InterpolationPeriodEnum interpolationPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRateCalculation());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("compounding"), processor, Compounding.CompoundingBuilder.class, getCompounding());
			processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.InterpolationMethodBuilder.class, getInterpolationMethod());
			processor.processBasic(path.newSubPath("interpolationPeriod"), InterpolationPeriodEnum.class, getInterpolationPeriod(), this);
		}
		

		InterestCalculation.InterestCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of InterestCalculation  ***********************/
	class InterestCalculationImpl extends InterestAccrualsMethod.InterestAccrualsMethodImpl implements InterestCalculation {
		private final String id;
		private final DayCountFraction dayCountFraction;
		private final Compounding compounding;
		private final InterpolationMethod interpolationMethod;
		private final InterpolationPeriodEnum interpolationPeriod;
		
		protected InterestCalculationImpl(InterestCalculation.InterestCalculationBuilder builder) {
			super(builder);
			this.id = builder.getId();
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.compounding = ofNullable(builder.getCompounding()).map(f->f.build()).orElse(null);
			this.interpolationMethod = ofNullable(builder.getInterpolationMethod()).map(f->f.build()).orElse(null);
			this.interpolationPeriod = builder.getInterpolationPeriod();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("compounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compounding")
		public Compounding getCompounding() {
			return compounding;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationMethod")
		public InterpolationMethod getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		@RosettaAttribute("interpolationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationPeriod")
		public InterpolationPeriodEnum getInterpolationPeriod() {
			return interpolationPeriod;
		}
		
		@Override
		public InterestCalculation build() {
			return this;
		}
		
		@Override
		public InterestCalculation.InterestCalculationBuilder toBuilder() {
			InterestCalculation.InterestCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestCalculation.InterestCalculationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getCompounding()).ifPresent(builder::setCompounding);
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
			ofNullable(getInterpolationPeriod()).ifPresent(builder::setInterpolationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestCalculation _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(compounding, _that.getCompounding())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(interpolationPeriod, _that.getInterpolationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (compounding != null ? compounding.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (interpolationPeriod != null ? interpolationPeriod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCalculation {" +
				"id=" + this.id + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"compounding=" + this.compounding + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"interpolationPeriod=" + this.interpolationPeriod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestCalculation  ***********************/
	class InterestCalculationBuilderImpl extends InterestAccrualsMethod.InterestAccrualsMethodBuilderImpl implements InterestCalculation.InterestCalculationBuilder {
	
		protected String id;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected Compounding.CompoundingBuilder compounding;
		protected InterpolationMethod.InterpolationMethodBuilder interpolationMethod;
		protected InterpolationPeriodEnum interpolationPeriod;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compounding")
		public Compounding.CompoundingBuilder getCompounding() {
			return compounding;
		}
		
		@Override
		public Compounding.CompoundingBuilder getOrCreateCompounding() {
			Compounding.CompoundingBuilder result;
			if (compounding!=null) {
				result = compounding;
			}
			else {
				result = compounding = Compounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationMethod")
		public InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod() {
			InterpolationMethod.InterpolationMethodBuilder result;
			if (interpolationMethod!=null) {
				result = interpolationMethod;
			}
			else {
				result = interpolationMethod = InterpolationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interpolationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationPeriod")
		public InterpolationPeriodEnum getInterpolationPeriod() {
			return interpolationPeriod;
		}
		
		@RosettaAttribute("floatingRateCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateCalculation")
		@Override
		public InterestCalculation.InterestCalculationBuilder setFloatingRateCalculation(FloatingRateCalculation _floatingRateCalculation) {
			this.floatingRateCalculation = _floatingRateCalculation == null ? null : _floatingRateCalculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public InterestCalculation.InterestCalculationBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public InterestCalculation.InterestCalculationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public InterestCalculation.InterestCalculationBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("compounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compounding")
		@Override
		public InterestCalculation.InterestCalculationBuilder setCompounding(Compounding _compounding) {
			this.compounding = _compounding == null ? null : _compounding.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interpolationMethod")
		@Override
		public InterestCalculation.InterestCalculationBuilder setInterpolationMethod(InterpolationMethod _interpolationMethod) {
			this.interpolationMethod = _interpolationMethod == null ? null : _interpolationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interpolationPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interpolationPeriod")
		@Override
		public InterestCalculation.InterestCalculationBuilder setInterpolationPeriod(InterpolationPeriodEnum _interpolationPeriod) {
			this.interpolationPeriod = _interpolationPeriod == null ? null : _interpolationPeriod;
			return this;
		}
		
		@Override
		public InterestCalculation build() {
			return new InterestCalculation.InterestCalculationImpl(this);
		}
		
		@Override
		public InterestCalculation.InterestCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCalculation.InterestCalculationBuilder prune() {
			super.prune();
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (compounding!=null && !compounding.prune().hasData()) compounding = null;
			if (interpolationMethod!=null && !interpolationMethod.prune().hasData()) interpolationMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getId()!=null) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getCompounding()!=null && getCompounding().hasData()) return true;
			if (getInterpolationMethod()!=null && getInterpolationMethod().hasData()) return true;
			if (getInterpolationPeriod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCalculation.InterestCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			InterestCalculation.InterestCalculationBuilder o = (InterestCalculation.InterestCalculationBuilder) other;
			
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getCompounding(), o.getCompounding(), this::setCompounding);
			merger.mergeRosetta(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getInterpolationPeriod(), o.getInterpolationPeriod(), this::setInterpolationPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestCalculation _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(compounding, _that.getCompounding())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(interpolationPeriod, _that.getInterpolationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (compounding != null ? compounding.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (interpolationPeriod != null ? interpolationPeriod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCalculationBuilder {" +
				"id=" + this.id + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"compounding=" + this.compounding + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"interpolationPeriod=" + this.interpolationPeriod +
			'}' + " " + super.toString();
		}
	}
}
