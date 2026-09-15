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
import fpml.consolidated.fx.accruals.meta.FxAverageStrikeMeta;
import fpml.consolidated.shared.FxInformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
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
@RosettaDataType(value="FxAverageStrike", builder=FxAverageStrike.FxAverageStrikeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAverageStrike", model="fpml", builder=FxAverageStrike.FxAverageStrikeBuilderImpl.class, version="2.1.1")
public interface FxAverageStrike extends FxAveragingProcess {

	FxAverageStrikeMeta metaData = new FxAverageStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A layer an Adjustment on the top of the average of the fixings across the schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A layer an Adjustment on the top of the average of the fixings across the schedule.
	 *
	 */
	BigDecimal getStrikeAdjustment();

	/*********************** Build Methods  ***********************/
	FxAverageStrike build();
	
	FxAverageStrike.FxAverageStrikeBuilder toBuilder();
	
	static FxAverageStrike.FxAverageStrikeBuilder builder() {
		return new FxAverageStrike.FxAverageStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAverageStrike> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAverageStrike> getType() {
		return FxAverageStrike.class;
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
		processor.processBasic(path.newSubPath("strikeAdjustment"), BigDecimal.class, getStrikeAdjustment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAverageStrikeBuilder extends FxAverageStrike, FxAveragingProcess.FxAveragingProcessBuilder {
		@Override
		FxAverageStrike.FxAverageStrikeBuilder setId(String id);
		@Override
		FxAverageStrike.FxAverageStrikeBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		@Override
		FxAverageStrike.FxAverageStrikeBuilder setInformationSource(FxInformationSource informationSource);
		@Override
		FxAverageStrike.FxAverageStrikeBuilder addCrossRate(FxCrossRateObservable crossRate);
		@Override
		FxAverageStrike.FxAverageStrikeBuilder addCrossRate(FxCrossRateObservable crossRate, int idx);
		@Override
		FxAverageStrike.FxAverageStrikeBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRate);
		@Override
		FxAverageStrike.FxAverageStrikeBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRate);
		@Override
		FxAverageStrike.FxAverageStrikeBuilder setFixingSchedule(FxWeightedFixingSchedule fixingSchedule);
		@Override
		FxAverageStrike.FxAverageStrikeBuilder setAveragingMethod(FxAveragingMethodEnum averagingMethod);
		@Override
		FxAverageStrike.FxAverageStrikeBuilder setPrecision(Integer precision);
		FxAverageStrike.FxAverageStrikeBuilder setStrikeAdjustment(BigDecimal strikeAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.FxCrossRateObservableBuilder.class, getCrossRate());
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("averagingMethod"), FxAveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
			processor.processBasic(path.newSubPath("strikeAdjustment"), BigDecimal.class, getStrikeAdjustment(), this);
		}
		

		FxAverageStrike.FxAverageStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of FxAverageStrike  ***********************/
	class FxAverageStrikeImpl extends FxAveragingProcess.FxAveragingProcessImpl implements FxAverageStrike {
		private final BigDecimal strikeAdjustment;
		
		protected FxAverageStrikeImpl(FxAverageStrike.FxAverageStrikeBuilder builder) {
			super(builder);
			this.strikeAdjustment = builder.getStrikeAdjustment();
		}
		
		@Override
		@RosettaAttribute("strikeAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeAdjustment")
		public BigDecimal getStrikeAdjustment() {
			return strikeAdjustment;
		}
		
		@Override
		public FxAverageStrike build() {
			return this;
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder toBuilder() {
			FxAverageStrike.FxAverageStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAverageStrike.FxAverageStrikeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrikeAdjustment()).ifPresent(builder::setStrikeAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAverageStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikeAdjustment, _that.getStrikeAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeAdjustment != null ? strikeAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageStrike {" +
				"strikeAdjustment=" + this.strikeAdjustment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAverageStrike  ***********************/
	class FxAverageStrikeBuilderImpl extends FxAveragingProcess.FxAveragingProcessBuilderImpl implements FxAverageStrike.FxAverageStrikeBuilder {
	
		protected BigDecimal strikeAdjustment;
		
		@Override
		@RosettaAttribute("strikeAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeAdjustment")
		public BigDecimal getStrikeAdjustment() {
			return strikeAdjustment;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder setInformationSource(FxInformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("crossRate")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder addCrossRate(FxCrossRateObservable _crossRate) {
			if (_crossRate != null) {
				this.crossRate.add(_crossRate.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder addCrossRate(FxCrossRateObservable _crossRate, int idx) {
			getIndex(this.crossRate, idx, () -> _crossRate.toBuilder());
			return this;
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRates) {
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
		public FxAverageStrike.FxAverageStrikeBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRates) {
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
		public FxAverageStrike.FxAverageStrikeBuilder setFixingSchedule(FxWeightedFixingSchedule _fixingSchedule) {
			this.fixingSchedule = _fixingSchedule == null ? null : _fixingSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("averagingMethod")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder setAveragingMethod(FxAveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("precision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("precision")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder setPrecision(Integer _precision) {
			this.precision = _precision == null ? null : _precision;
			return this;
		}
		
		@RosettaAttribute("strikeAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeAdjustment")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder setStrikeAdjustment(BigDecimal _strikeAdjustment) {
			this.strikeAdjustment = _strikeAdjustment == null ? null : _strikeAdjustment;
			return this;
		}
		
		@Override
		public FxAverageStrike build() {
			return new FxAverageStrike.FxAverageStrikeImpl(this);
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrikeAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAverageStrike.FxAverageStrikeBuilder o = (FxAverageStrike.FxAverageStrikeBuilder) other;
			
			
			merger.mergeBasic(getStrikeAdjustment(), o.getStrikeAdjustment(), this::setStrikeAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAverageStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikeAdjustment, _that.getStrikeAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeAdjustment != null ? strikeAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageStrikeBuilder {" +
				"strikeAdjustment=" + this.strikeAdjustment +
			'}' + " " + super.toString();
		}
	}
}
