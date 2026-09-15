package fpml.consolidated.generic;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.fx.CrossRate;
import fpml.consolidated.generic.meta.GenericProductExchangeRateMeta;
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
 * Provision A type that is used for describing the exchange rate for a particular transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that is used for describing the exchange rate for a particular transaction.
 *
 */
@RosettaDataType(value="GenericProductExchangeRate", builder=GenericProductExchangeRate.GenericProductExchangeRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericProductExchangeRate", model="fpml", builder=GenericProductExchangeRate.GenericProductExchangeRateBuilderImpl.class, version="2.1.1")
public interface GenericProductExchangeRate extends RosettaModelObject {

	GenericProductExchangeRateMeta metaData = new GenericProductExchangeRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 */
	GenericProductQuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
	 *
	 */
	BigDecimal getRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move "up" or "down" to be triggered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move "up" or "down" to be triggered.
	 *
	 */
	BigDecimal getSpotRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element used for deals consumated in the FX Forwards market. Forward points represent the interest rate differential between the two currencies traded and are quoted as a preminum or a discount. Forward points are added to, or subtracted from, the spot rate to create the rate of the forward trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element used for deals consumated in the FX Forwards market. Forward points represent the interest rate differential between the two currencies traded and are quoted as a preminum or a discount. Forward points are added to, or subtracted from, the spot rate to create the rate of the forward trade.
	 *
	 */
	BigDecimal getForwardPoints();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element that documents the size of point (pip) in which a rate was quoted (or in this case, forwardPoints are calculated). Point (pip) size varies by currency pair: major currencies are all traded in points of 0.0001, with the exception of JPY which has a point size of 0.01.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element that documents the size of point (pip) in which a rate was quoted (or in this case, forwardPoints are calculated). Point (pip) size varies by currency pair: major currencies are all traded in points of 0.0001, with the exception of JPY which has a point size of 0.01.
	 *
	 */
	BigDecimal getPointValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element that allow for definition of the currency exchange rates used to cross between the traded currencies for non-base currency FX contracts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element that allow for definition of the currency exchange rates used to cross between the traded currencies for non-base currency FX contracts.
	 *
	 */
	List<? extends CrossRate> getCrossRate();

	/*********************** Build Methods  ***********************/
	GenericProductExchangeRate build();
	
	GenericProductExchangeRate.GenericProductExchangeRateBuilder toBuilder();
	
	static GenericProductExchangeRate.GenericProductExchangeRateBuilder builder() {
		return new GenericProductExchangeRate.GenericProductExchangeRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericProductExchangeRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericProductExchangeRate> getType() {
		return GenericProductExchangeRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, GenericProductQuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processor.processBasic(path.newSubPath("forwardPoints"), BigDecimal.class, getForwardPoints(), this);
		processor.processBasic(path.newSubPath("pointValue"), BigDecimal.class, getPointValue(), this);
		processRosetta(path.newSubPath("crossRate"), processor, CrossRate.class, getCrossRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericProductExchangeRateBuilder extends GenericProductExchangeRate, RosettaModelObjectBuilder {
		GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder getQuotedCurrencyPair();
		CrossRate.CrossRateBuilder getOrCreateCrossRate(int index);
		@Override
		List<? extends CrossRate.CrossRateBuilder> getCrossRate();
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setQuotedCurrencyPair(GenericProductQuotedCurrencyPair quotedCurrencyPair);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setRate(BigDecimal rate);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setSpotRate(BigDecimal spotRate);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setForwardPoints(BigDecimal forwardPoints);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setPointValue(BigDecimal pointValue);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(CrossRate crossRate);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(CrossRate crossRate, int idx);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(List<? extends CrossRate> crossRate);
		GenericProductExchangeRate.GenericProductExchangeRateBuilder setCrossRate(List<? extends CrossRate> crossRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processor.processBasic(path.newSubPath("forwardPoints"), BigDecimal.class, getForwardPoints(), this);
			processor.processBasic(path.newSubPath("pointValue"), BigDecimal.class, getPointValue(), this);
			processRosetta(path.newSubPath("crossRate"), processor, CrossRate.CrossRateBuilder.class, getCrossRate());
		}
		

		GenericProductExchangeRate.GenericProductExchangeRateBuilder prune();
	}

	/*********************** Immutable Implementation of GenericProductExchangeRate  ***********************/
	class GenericProductExchangeRateImpl implements GenericProductExchangeRate {
		private final GenericProductQuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal rate;
		private final BigDecimal spotRate;
		private final BigDecimal forwardPoints;
		private final BigDecimal pointValue;
		private final List<? extends CrossRate> crossRate;
		
		protected GenericProductExchangeRateImpl(GenericProductExchangeRate.GenericProductExchangeRateBuilder builder) {
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.rate = builder.getRate();
			this.spotRate = builder.getSpotRate();
			this.forwardPoints = builder.getForwardPoints();
			this.pointValue = builder.getPointValue();
			this.crossRate = ofNullable(builder.getCrossRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public GenericProductQuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("forwardPoints")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardPoints")
		public BigDecimal getForwardPoints() {
			return forwardPoints;
		}
		
		@Override
		@RosettaAttribute("pointValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pointValue")
		public BigDecimal getPointValue() {
			return pointValue;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("crossRate")
		public List<? extends CrossRate> getCrossRate() {
			return crossRate;
		}
		
		@Override
		public GenericProductExchangeRate build() {
			return this;
		}
		
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder toBuilder() {
			GenericProductExchangeRate.GenericProductExchangeRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericProductExchangeRate.GenericProductExchangeRateBuilder builder) {
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getForwardPoints()).ifPresent(builder::setForwardPoints);
			ofNullable(getPointValue()).ifPresent(builder::setPointValue);
			ofNullable(getCrossRate()).ifPresent(builder::setCrossRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductExchangeRate _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(forwardPoints, _that.getForwardPoints())) return false;
			if (!Objects.equals(pointValue, _that.getPointValue())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (forwardPoints != null ? forwardPoints.hashCode() : 0);
			_result = 31 * _result + (pointValue != null ? pointValue.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductExchangeRate {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rate=" + this.rate + ", " +
				"spotRate=" + this.spotRate + ", " +
				"forwardPoints=" + this.forwardPoints + ", " +
				"pointValue=" + this.pointValue + ", " +
				"crossRate=" + this.crossRate +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericProductExchangeRate  ***********************/
	class GenericProductExchangeRateBuilderImpl implements GenericProductExchangeRate.GenericProductExchangeRateBuilder {
	
		protected GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal rate;
		protected BigDecimal spotRate;
		protected BigDecimal forwardPoints;
		protected BigDecimal pointValue;
		protected List<CrossRate.CrossRateBuilder> crossRate = new ArrayList<>();
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			GenericProductQuotedCurrencyPair.GenericProductQuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = GenericProductQuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("forwardPoints")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardPoints")
		public BigDecimal getForwardPoints() {
			return forwardPoints;
		}
		
		@Override
		@RosettaAttribute("pointValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pointValue")
		public BigDecimal getPointValue() {
			return pointValue;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("crossRate")
		public List<? extends CrossRate.CrossRateBuilder> getCrossRate() {
			return crossRate;
		}
		
		@Override
		public CrossRate.CrossRateBuilder getOrCreateCrossRate(int index) {
			if (crossRate==null) {
				this.crossRate = new ArrayList<>();
			}
			return getIndex(crossRate, index, () -> {
						CrossRate.CrossRateBuilder newCrossRate = CrossRate.builder();
						return newCrossRate;
					});
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setQuotedCurrencyPair(GenericProductQuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rate")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("forwardPoints")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forwardPoints")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setForwardPoints(BigDecimal _forwardPoints) {
			this.forwardPoints = _forwardPoints == null ? null : _forwardPoints;
			return this;
		}
		
		@RosettaAttribute("pointValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pointValue")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setPointValue(BigDecimal _pointValue) {
			this.pointValue = _pointValue == null ? null : _pointValue;
			return this;
		}
		
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("crossRate")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(CrossRate _crossRate) {
			if (_crossRate != null) {
				this.crossRate.add(_crossRate.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(CrossRate _crossRate, int idx) {
			getIndex(this.crossRate, idx, () -> _crossRate.toBuilder());
			return this;
		}
		
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder addCrossRate(List<? extends CrossRate> crossRates) {
			if (crossRates != null) {
				for (final CrossRate toAdd : crossRates) {
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
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder setCrossRate(List<? extends CrossRate> crossRates) {
			if (crossRates == null) {
				this.crossRate = new ArrayList<>();
			} else {
				this.crossRate = crossRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public GenericProductExchangeRate build() {
			return new GenericProductExchangeRate.GenericProductExchangeRateImpl(this);
		}
		
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			crossRate = crossRate.stream().filter(b->b!=null).<CrossRate.CrossRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getRate()!=null) return true;
			if (getSpotRate()!=null) return true;
			if (getForwardPoints()!=null) return true;
			if (getPointValue()!=null) return true;
			if (getCrossRate()!=null && getCrossRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericProductExchangeRate.GenericProductExchangeRateBuilder o = (GenericProductExchangeRate.GenericProductExchangeRateBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getCrossRate(), o.getCrossRate(), this::getOrCreateCrossRate);
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			merger.mergeBasic(getForwardPoints(), o.getForwardPoints(), this::setForwardPoints);
			merger.mergeBasic(getPointValue(), o.getPointValue(), this::setPointValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericProductExchangeRate _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(forwardPoints, _that.getForwardPoints())) return false;
			if (!Objects.equals(pointValue, _that.getPointValue())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (forwardPoints != null ? forwardPoints.hashCode() : 0);
			_result = 31 * _result + (pointValue != null ? pointValue.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericProductExchangeRateBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rate=" + this.rate + ", " +
				"spotRate=" + this.spotRate + ", " +
				"forwardPoints=" + this.forwardPoints + ", " +
				"pointValue=" + this.pointValue + ", " +
				"crossRate=" + this.crossRate +
			'}';
		}
	}
}
