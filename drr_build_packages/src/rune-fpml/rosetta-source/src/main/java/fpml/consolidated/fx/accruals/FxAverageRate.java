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
import fpml.consolidated.fx.accruals.meta.FxAverageRateMeta;
import fpml.consolidated.shared.FxInformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
@RosettaDataType(value="FxAverageRate", builder=FxAverageRate.FxAverageRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAverageRate", model="fpml", builder=FxAverageRate.FxAverageRateBuilderImpl.class, version="2.1.1")
public interface FxAverageRate extends FxAveragingProcess {

	FxAverageRateMeta metaData = new FxAverageRateMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxAverageRate build();
	
	FxAverageRate.FxAverageRateBuilder toBuilder();
	
	static FxAverageRate.FxAverageRateBuilder builder() {
		return new FxAverageRate.FxAverageRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAverageRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAverageRate> getType() {
		return FxAverageRate.class;
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
	interface FxAverageRateBuilder extends FxAverageRate, FxAveragingProcess.FxAveragingProcessBuilder {
		@Override
		FxAverageRate.FxAverageRateBuilder setId(String id);
		@Override
		FxAverageRate.FxAverageRateBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		@Override
		FxAverageRate.FxAverageRateBuilder setInformationSource(FxInformationSource informationSource);
		@Override
		FxAverageRate.FxAverageRateBuilder addCrossRate(FxCrossRateObservable crossRate);
		@Override
		FxAverageRate.FxAverageRateBuilder addCrossRate(FxCrossRateObservable crossRate, int idx);
		@Override
		FxAverageRate.FxAverageRateBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRate);
		@Override
		FxAverageRate.FxAverageRateBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRate);
		@Override
		FxAverageRate.FxAverageRateBuilder setFixingSchedule(FxWeightedFixingSchedule fixingSchedule);
		@Override
		FxAverageRate.FxAverageRateBuilder setAveragingMethod(FxAveragingMethodEnum averagingMethod);
		@Override
		FxAverageRate.FxAverageRateBuilder setPrecision(Integer precision);

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
		

		FxAverageRate.FxAverageRateBuilder prune();
	}

	/*********************** Immutable Implementation of FxAverageRate  ***********************/
	class FxAverageRateImpl extends FxAveragingProcess.FxAveragingProcessImpl implements FxAverageRate {
		
		protected FxAverageRateImpl(FxAverageRate.FxAverageRateBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxAverageRate build() {
			return this;
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder toBuilder() {
			FxAverageRate.FxAverageRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAverageRate.FxAverageRateBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageRate {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAverageRate  ***********************/
	class FxAverageRateBuilderImpl extends FxAveragingProcess.FxAveragingProcessBuilderImpl implements FxAverageRate.FxAverageRateBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAverageRate.FxAverageRateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxAverageRate.FxAverageRateBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public FxAverageRate.FxAverageRateBuilder setInformationSource(FxInformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("crossRate")
		@Override
		public FxAverageRate.FxAverageRateBuilder addCrossRate(FxCrossRateObservable _crossRate) {
			if (_crossRate != null) {
				this.crossRate.add(_crossRate.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder addCrossRate(FxCrossRateObservable _crossRate, int idx) {
			getIndex(this.crossRate, idx, () -> _crossRate.toBuilder());
			return this;
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRates) {
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
		public FxAverageRate.FxAverageRateBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRates) {
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
		public FxAverageRate.FxAverageRateBuilder setFixingSchedule(FxWeightedFixingSchedule _fixingSchedule) {
			this.fixingSchedule = _fixingSchedule == null ? null : _fixingSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("averagingMethod")
		@Override
		public FxAverageRate.FxAverageRateBuilder setAveragingMethod(FxAveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("precision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("precision")
		@Override
		public FxAverageRate.FxAverageRateBuilder setPrecision(Integer _precision) {
			this.precision = _precision == null ? null : _precision;
			return this;
		}
		
		@Override
		public FxAverageRate build() {
			return new FxAverageRate.FxAverageRateImpl(this);
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageRate.FxAverageRateBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageRate.FxAverageRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAverageRate.FxAverageRateBuilder o = (FxAverageRate.FxAverageRateBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageRateBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
