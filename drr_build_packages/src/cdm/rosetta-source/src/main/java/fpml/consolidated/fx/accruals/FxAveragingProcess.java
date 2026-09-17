package fpml.consolidated.fx.accruals;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.fpmlenum.FxAveragingMethodEnum;
import fpml.consolidated.fx.accruals.meta.FxAveragingProcessMeta;
import fpml.consolidated.shared.FxInformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Accrual calculation process.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Accrual calculation process.
 *
 */
@RosettaDataType(value="FxAveragingProcess", builder=FxAveragingProcess.FxAveragingProcessBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAveragingProcess", model="fpml", builder=FxAveragingProcess.FxAveragingProcessBuilderImpl.class, version="2.1.1")
public interface FxAveragingProcess extends FxRateObservable {

	FxAveragingProcessMeta metaData = new FxAveragingProcessMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes a parametric schedule of fixing dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes a parametric schedule of fixing dates.
	 *
	 */
	FxWeightedFixingSchedule getFixingSchedule();
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
	FxAveragingMethodEnum getAveragingMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the rounding precision in terms of a number of decimal places. Note how a percentage rate rounding of 5 decimal places is expressed as a rounding precision of 7 in the FpML document since the percentage is expressed as a decimal, e.g. 9.876543% (or 0.09876543) being rounded to the nearest 5 decimal places is 9.87654% (or 0.0987654).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the rounding precision in terms of a number of decimal places. Note how a percentage rate rounding of 5 decimal places is expressed as a rounding precision of 7 in the FpML document since the percentage is expressed as a decimal, e.g. 9.876543% (or 0.09876543) being rounded to the nearest 5 decimal places is 9.87654% (or 0.0987654).
	 *
	 */
	Integer getPrecision();

	/*********************** Build Methods  ***********************/
	FxAveragingProcess build();
	
	FxAveragingProcess.FxAveragingProcessBuilder toBuilder();
	
	static FxAveragingProcess.FxAveragingProcessBuilder builder() {
		return new FxAveragingProcess.FxAveragingProcessBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAveragingProcess> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAveragingProcess> getType() {
		return FxAveragingProcess.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.class, getCrossRate());
		processRosetta(path.newSubPath("fixingSchedule"), processor, FxWeightedFixingSchedule.class, getFixingSchedule());
		processor.processBasic(path.newSubPath("averagingMethod"), FxAveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAveragingProcessBuilder extends FxAveragingProcess, FxRateObservable.FxRateObservableBuilder {
		FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder getOrCreateFixingSchedule();
		@Override
		FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder getFixingSchedule();
		@Override
		FxAveragingProcess.FxAveragingProcessBuilder setId(String id);
		@Override
		FxAveragingProcess.FxAveragingProcessBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		@Override
		FxAveragingProcess.FxAveragingProcessBuilder setInformationSource(FxInformationSource informationSource);
		@Override
		FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(FxCrossRateObservable crossRate);
		@Override
		FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(FxCrossRateObservable crossRate, int idx);
		@Override
		FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRate);
		@Override
		FxAveragingProcess.FxAveragingProcessBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRate);
		FxAveragingProcess.FxAveragingProcessBuilder setFixingSchedule(FxWeightedFixingSchedule fixingSchedule);
		FxAveragingProcess.FxAveragingProcessBuilder setAveragingMethod(FxAveragingMethodEnum averagingMethod);
		FxAveragingProcess.FxAveragingProcessBuilder setPrecision(Integer precision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.FxCrossRateObservableBuilder.class, getCrossRate());
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("averagingMethod"), FxAveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
		}
		

		FxAveragingProcess.FxAveragingProcessBuilder prune();
	}

	/*********************** Immutable Implementation of FxAveragingProcess  ***********************/
	class FxAveragingProcessImpl extends FxRateObservable.FxRateObservableImpl implements FxAveragingProcess {
		private final FxWeightedFixingSchedule fixingSchedule;
		private final FxAveragingMethodEnum averagingMethod;
		private final Integer precision;
		
		protected FxAveragingProcessImpl(FxAveragingProcess.FxAveragingProcessBuilder builder) {
			super(builder);
			this.fixingSchedule = ofNullable(builder.getFixingSchedule()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.precision = builder.getPrecision();
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		public FxWeightedFixingSchedule getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("averagingMethod")
		public FxAveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("precision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@Override
		public FxAveragingProcess build() {
			return this;
		}
		
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder toBuilder() {
			FxAveragingProcess.FxAveragingProcessBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAveragingProcess.FxAveragingProcessBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixingSchedule()).ifPresent(builder::setFixingSchedule);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getPrecision()).ifPresent(builder::setPrecision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAveragingProcess _that = getType().cast(o);
		
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAveragingProcess {" +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"precision=" + this.precision +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAveragingProcess  ***********************/
	class FxAveragingProcessBuilderImpl extends FxRateObservable.FxRateObservableBuilderImpl implements FxAveragingProcess.FxAveragingProcessBuilder {
	
		protected FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder fixingSchedule;
		protected FxAveragingMethodEnum averagingMethod;
		protected Integer precision;
		
		@Override
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder getOrCreateFixingSchedule() {
			FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder result;
			if (fixingSchedule!=null) {
				result = fixingSchedule;
			}
			else {
				result = fixingSchedule = FxWeightedFixingSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("averagingMethod")
		public FxAveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("precision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder setInformationSource(FxInformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("crossRate")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(FxCrossRateObservable _crossRate) {
			if (_crossRate != null) {
				this.crossRate.add(_crossRate.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(FxCrossRateObservable _crossRate, int idx) {
			getIndex(this.crossRate, idx, () -> _crossRate.toBuilder());
			return this;
		}
		
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates != null) {
				for (final FxCrossRateObservable toAdd : crossRates) {
					this.crossRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("crossRate")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates == null) {
				this.crossRate = new ArrayList<>();
			} else {
				this.crossRate = crossRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder setFixingSchedule(FxWeightedFixingSchedule _fixingSchedule) {
			this.fixingSchedule = _fixingSchedule == null ? null : _fixingSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("averagingMethod")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder setAveragingMethod(FxAveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("precision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("precision")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder setPrecision(Integer _precision) {
			this.precision = _precision == null ? null : _precision;
			return this;
		}
		
		@Override
		public FxAveragingProcess build() {
			return new FxAveragingProcess.FxAveragingProcessImpl(this);
		}
		
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder prune() {
			super.prune();
			if (fixingSchedule!=null && !fixingSchedule.prune().hasData()) fixingSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixingSchedule()!=null && getFixingSchedule().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getPrecision()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAveragingProcess.FxAveragingProcessBuilder o = (FxAveragingProcess.FxAveragingProcessBuilder) other;
			
			merger.mergeRosetta(getFixingSchedule(), o.getFixingSchedule(), this::setFixingSchedule);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getPrecision(), o.getPrecision(), this::setPrecision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAveragingProcess _that = getType().cast(o);
		
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAveragingProcessBuilder {" +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"precision=" + this.precision +
			'}' + " " + super.toString();
		}
	}
}
