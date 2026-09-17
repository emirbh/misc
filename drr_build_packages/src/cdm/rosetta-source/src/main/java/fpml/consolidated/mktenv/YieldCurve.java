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
import fpml.consolidated.mktenv.meta.YieldCurveMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ForecastRateIndex;
import fpml.consolidated.shared.PricingStructure;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A generic yield curve object, which can be valued in a variety of ways.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A generic yield curve object, which can be valued in a variety of ways.
 *
 */
@RosettaDataType(value="YieldCurve", builder=YieldCurve.YieldCurveBuilderImpl.class, version="2.1.1")
@RuneDataType(value="YieldCurve", model="fpml", builder=YieldCurve.YieldCurveBuilderImpl.class, version="2.1.1")
public interface YieldCurve extends PricingStructure {

	YieldCurveMeta metaData = new YieldCurveMeta();

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
	String getAlgorithm();
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
	ForecastRateIndex getForecastRateIndex();

	/*********************** Build Methods  ***********************/
	YieldCurve build();
	
	YieldCurve.YieldCurveBuilder toBuilder();
	
	static YieldCurve.YieldCurveBuilder builder() {
		return new YieldCurve.YieldCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends YieldCurve> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends YieldCurve> getType() {
		return YieldCurve.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		processRosetta(path.newSubPath("forecastRateIndex"), processor, ForecastRateIndex.class, getForecastRateIndex());
	}
	

	/*********************** Builder Interface  ***********************/
	interface YieldCurveBuilder extends YieldCurve, PricingStructure.PricingStructureBuilder {
		ForecastRateIndex.ForecastRateIndexBuilder getOrCreateForecastRateIndex();
		@Override
		ForecastRateIndex.ForecastRateIndexBuilder getForecastRateIndex();
		@Override
		YieldCurve.YieldCurveBuilder setId(String id);
		@Override
		YieldCurve.YieldCurveBuilder setName(String name);
		@Override
		YieldCurve.YieldCurveBuilder setCurrency(Currency currency);
		YieldCurve.YieldCurveBuilder setAlgorithm(String algorithm);
		YieldCurve.YieldCurveBuilder setForecastRateIndex(ForecastRateIndex forecastRateIndex);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
			processRosetta(path.newSubPath("forecastRateIndex"), processor, ForecastRateIndex.ForecastRateIndexBuilder.class, getForecastRateIndex());
		}
		

		YieldCurve.YieldCurveBuilder prune();
	}

	/*********************** Immutable Implementation of YieldCurve  ***********************/
	class YieldCurveImpl extends PricingStructure.PricingStructureImpl implements YieldCurve {
		private final String algorithm;
		private final ForecastRateIndex forecastRateIndex;
		
		protected YieldCurveImpl(YieldCurve.YieldCurveBuilder builder) {
			super(builder);
			this.algorithm = builder.getAlgorithm();
			this.forecastRateIndex = ofNullable(builder.getForecastRateIndex()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("forecastRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastRateIndex")
		public ForecastRateIndex getForecastRateIndex() {
			return forecastRateIndex;
		}
		
		@Override
		public YieldCurve build() {
			return this;
		}
		
		@Override
		public YieldCurve.YieldCurveBuilder toBuilder() {
			YieldCurve.YieldCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(YieldCurve.YieldCurveBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
			ofNullable(getForecastRateIndex()).ifPresent(builder::setForecastRateIndex);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			YieldCurve _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			if (!Objects.equals(forecastRateIndex, _that.getForecastRateIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (forecastRateIndex != null ? forecastRateIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurve {" +
				"algorithm=" + this.algorithm + ", " +
				"forecastRateIndex=" + this.forecastRateIndex +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of YieldCurve  ***********************/
	class YieldCurveBuilderImpl extends PricingStructure.PricingStructureBuilderImpl implements YieldCurve.YieldCurveBuilder {
	
		protected String algorithm;
		protected ForecastRateIndex.ForecastRateIndexBuilder forecastRateIndex;
		
		@Override
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("forecastRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastRateIndex")
		public ForecastRateIndex.ForecastRateIndexBuilder getForecastRateIndex() {
			return forecastRateIndex;
		}
		
		@Override
		public ForecastRateIndex.ForecastRateIndexBuilder getOrCreateForecastRateIndex() {
			ForecastRateIndex.ForecastRateIndexBuilder result;
			if (forecastRateIndex!=null) {
				result = forecastRateIndex;
			}
			else {
				result = forecastRateIndex = ForecastRateIndex.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public YieldCurve.YieldCurveBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public YieldCurve.YieldCurveBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public YieldCurve.YieldCurveBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("algorithm")
		@Override
		public YieldCurve.YieldCurveBuilder setAlgorithm(String _algorithm) {
			this.algorithm = _algorithm == null ? null : _algorithm;
			return this;
		}
		
		@RosettaAttribute("forecastRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forecastRateIndex")
		@Override
		public YieldCurve.YieldCurveBuilder setForecastRateIndex(ForecastRateIndex _forecastRateIndex) {
			this.forecastRateIndex = _forecastRateIndex == null ? null : _forecastRateIndex.toBuilder();
			return this;
		}
		
		@Override
		public YieldCurve build() {
			return new YieldCurve.YieldCurveImpl(this);
		}
		
		@Override
		public YieldCurve.YieldCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurve.YieldCurveBuilder prune() {
			super.prune();
			if (forecastRateIndex!=null && !forecastRateIndex.prune().hasData()) forecastRateIndex = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAlgorithm()!=null) return true;
			if (getForecastRateIndex()!=null && getForecastRateIndex().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurve.YieldCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			YieldCurve.YieldCurveBuilder o = (YieldCurve.YieldCurveBuilder) other;
			
			merger.mergeRosetta(getForecastRateIndex(), o.getForecastRateIndex(), this::setForecastRateIndex);
			
			merger.mergeBasic(getAlgorithm(), o.getAlgorithm(), this::setAlgorithm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			YieldCurve _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			if (!Objects.equals(forecastRateIndex, _that.getForecastRateIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (forecastRateIndex != null ? forecastRateIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveBuilder {" +
				"algorithm=" + this.algorithm + ", " +
				"forecastRateIndex=" + this.forecastRateIndex +
			'}' + " " + super.toString();
		}
	}
}
