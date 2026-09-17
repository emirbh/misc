package fpml.consolidated.com;

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
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.meta.FloatingStrikePriceMeta;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.shared.Rounding;
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
@RosettaDataType(value="FloatingStrikePrice", builder=FloatingStrikePrice.FloatingStrikePriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FloatingStrikePrice", model="fpml", builder=FloatingStrikePrice.FloatingStrikePriceBuilderImpl.class, version="2.1.1")
public interface FloatingStrikePrice extends FloatingLegCalculation {

	FloatingStrikePriceMeta metaData = new FloatingStrikePriceMeta();

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
	Commodity getCommodity();

	/*********************** Build Methods  ***********************/
	FloatingStrikePrice build();
	
	FloatingStrikePrice.FloatingStrikePriceBuilder toBuilder();
	
	static FloatingStrikePrice.FloatingStrikePriceBuilder builder() {
		return new FloatingStrikePrice.FloatingStrikePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingStrikePrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingStrikePrice> getType() {
		return FloatingStrikePrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
		processRosetta(path.newSubPath("spread"), processor, CommoditySpread.class, getSpread());
		processRosetta(path.newSubPath("spreadSchedule"), processor, CommoditySpreadSchedule.class, getSpreadSchedule());
		processor.processBasic(path.newSubPath("spreadPercentage"), BigDecimal.class, getSpreadPercentage(), this);
		processRosetta(path.newSubPath("fx"), processor, CommodityFx.class, getFx());
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingStrikePriceBuilder extends FloatingStrikePrice, FloatingLegCalculation.FloatingLegCalculationBuilder {
		Commodity.CommodityBuilder getOrCreateCommodity();
		@Override
		Commodity.CommodityBuilder getCommodity();
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder setPricingDates(CommodityPricingDates pricingDates);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder setConversionFactor(BigDecimal conversionFactor);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder setRounding(Rounding rounding);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder setSpread(CommoditySpread spread);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule, int idx);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedule);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder setSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedule);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder setSpreadPercentage(BigDecimal spreadPercentage);
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder setFx(CommodityFx fx);
		FloatingStrikePrice.FloatingStrikePriceBuilder setCommodity(Commodity commodity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
			processRosetta(path.newSubPath("spread"), processor, CommoditySpread.CommoditySpreadBuilder.class, getSpread());
			processRosetta(path.newSubPath("spreadSchedule"), processor, CommoditySpreadSchedule.CommoditySpreadScheduleBuilder.class, getSpreadSchedule());
			processor.processBasic(path.newSubPath("spreadPercentage"), BigDecimal.class, getSpreadPercentage(), this);
			processRosetta(path.newSubPath("fx"), processor, CommodityFx.CommodityFxBuilder.class, getFx());
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
		}
		

		FloatingStrikePrice.FloatingStrikePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingStrikePrice  ***********************/
	class FloatingStrikePriceImpl extends FloatingLegCalculation.FloatingLegCalculationImpl implements FloatingStrikePrice {
		private final Commodity commodity;
		
		protected FloatingStrikePriceImpl(FloatingStrikePrice.FloatingStrikePriceBuilder builder) {
			super(builder);
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		public FloatingStrikePrice build() {
			return this;
		}
		
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder toBuilder() {
			FloatingStrikePrice.FloatingStrikePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingStrikePrice.FloatingStrikePriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingStrikePrice {" +
				"commodity=" + this.commodity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingStrikePrice  ***********************/
	class FloatingStrikePriceBuilderImpl extends FloatingLegCalculation.FloatingLegCalculationBuilderImpl implements FloatingStrikePrice.FloatingStrikePriceBuilder {
	
		protected Commodity.CommodityBuilder commodity;
		
		@Override
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pricingDates")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder setPricingDates(CommodityPricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("conversionFactor")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder setConversionFactor(BigDecimal _conversionFactor) {
			this.conversionFactor = _conversionFactor == null ? null : _conversionFactor;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder setSpread(CommoditySpread _spread) {
			this.spread = _spread == null ? null : _spread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(CommoditySpreadSchedule _spreadSchedule) {
			if (_spreadSchedule != null) {
				this.spreadSchedule.add(_spreadSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(CommoditySpreadSchedule _spreadSchedule, int idx) {
			getIndex(this.spreadSchedule, idx, () -> _spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder addSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (final CommoditySpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder setSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedules) {
			if (spreadSchedules == null) {
				this.spreadSchedule = new ArrayList<>();
			} else {
				this.spreadSchedule = spreadSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("spreadPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadPercentage")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder setSpreadPercentage(BigDecimal _spreadPercentage) {
			this.spreadPercentage = _spreadPercentage == null ? null : _spreadPercentage;
			return this;
		}
		
		@RosettaAttribute("fx")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fx")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder setFx(CommodityFx _fx) {
			this.fx = _fx == null ? null : _fx.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("commodity")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@Override
		public FloatingStrikePrice build() {
			return new FloatingStrikePrice.FloatingStrikePriceImpl(this);
		}
		
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder prune() {
			super.prune();
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FloatingStrikePrice.FloatingStrikePriceBuilder o = (FloatingStrikePrice.FloatingStrikePriceBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingStrikePriceBuilder {" +
				"commodity=" + this.commodity +
			'}' + " " + super.toString();
		}
	}
}
