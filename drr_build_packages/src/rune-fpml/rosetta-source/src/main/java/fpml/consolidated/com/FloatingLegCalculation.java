package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.FloatingLegCalculationMeta;
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
 * Provision A type to capture details relevant to the calculation of the floating price.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to capture details relevant to the calculation of the floating price.
 *
 */
@RosettaDataType(value="FloatingLegCalculation", builder=FloatingLegCalculation.FloatingLegCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FloatingLegCalculation", model="fpml", builder=FloatingLegCalculation.FloatingLegCalculationBuilderImpl.class, version="2.1.1")
public interface FloatingLegCalculation extends RosettaModelObject {

	FloatingLegCalculationMeta metaData = new FloatingLegCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Commodity Pricing Dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Commodity Pricing Dates.
	 *
	 */
	CommodityPricingDates getPricingDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parties may specify a Method of Averaging where more than one pricing Dates is being specified as being applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parties may specify a Method of Averaging where more than one pricing Dates is being specified as being applicable.
	 *
	 */
	AveragingMethodEnum getAveragingMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If the Notional Quantity is specified in units that do not match the units in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price units into the Notional Quantity units should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If the Notional Quantity is specified in units that do not match the units in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price units into the Notional Quantity units should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 */
	BigDecimal getConversionFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Rounding direction and precision for price values.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Rounding direction and precision for price values.
	 *
	 */
	Rounding getRounding();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The spread over or under the Commodity Reference Price for this leg of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The spread over or under the Commodity Reference Price for this leg of the trade.
	 *
	 */
	CommoditySpread getSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The spread over or under the Commodity Reference Price for this leg of the trade for each Calculation Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The spread over or under the Commodity Reference Price for this leg of the trade for each Calculation Period.
	 *
	 */
	List<? extends CommoditySpreadSchedule> getSpreadSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The spread percentage over or under the Commodity Reference Price for this leg of the trade. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The spread percentage over or under the Commodity Reference Price for this leg of the trade. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getSpreadPercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines how observations of FX prices are to be used to calculate a factor with which to convert the observed Commodity Reference Price to the Settlement Currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines how observations of FX prices are to be used to calculate a factor with which to convert the observed Commodity Reference Price to the Settlement Currency.
	 *
	 */
	CommodityFx getFx();

	/*********************** Build Methods  ***********************/
	FloatingLegCalculation build();
	
	FloatingLegCalculation.FloatingLegCalculationBuilder toBuilder();
	
	static FloatingLegCalculation.FloatingLegCalculationBuilder builder() {
		return new FloatingLegCalculation.FloatingLegCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingLegCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingLegCalculation> getType() {
		return FloatingLegCalculation.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingLegCalculationBuilder extends FloatingLegCalculation, RosettaModelObjectBuilder {
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		@Override
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		Rounding.RoundingBuilder getOrCreateRounding();
		@Override
		Rounding.RoundingBuilder getRounding();
		CommoditySpread.CommoditySpreadBuilder getOrCreateSpread();
		@Override
		CommoditySpread.CommoditySpreadBuilder getSpread();
		CommoditySpreadSchedule.CommoditySpreadScheduleBuilder getOrCreateSpreadSchedule(int index);
		@Override
		List<? extends CommoditySpreadSchedule.CommoditySpreadScheduleBuilder> getSpreadSchedule();
		CommodityFx.CommodityFxBuilder getOrCreateFx();
		@Override
		CommodityFx.CommodityFxBuilder getFx();
		FloatingLegCalculation.FloatingLegCalculationBuilder setPricingDates(CommodityPricingDates pricingDates);
		FloatingLegCalculation.FloatingLegCalculationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		FloatingLegCalculation.FloatingLegCalculationBuilder setConversionFactor(BigDecimal conversionFactor);
		FloatingLegCalculation.FloatingLegCalculationBuilder setRounding(Rounding rounding);
		FloatingLegCalculation.FloatingLegCalculationBuilder setSpread(CommoditySpread spread);
		FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule);
		FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(CommoditySpreadSchedule spreadSchedule, int idx);
		FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedule);
		FloatingLegCalculation.FloatingLegCalculationBuilder setSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedule);
		FloatingLegCalculation.FloatingLegCalculationBuilder setSpreadPercentage(BigDecimal spreadPercentage);
		FloatingLegCalculation.FloatingLegCalculationBuilder setFx(CommodityFx fx);

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
		}
		

		FloatingLegCalculation.FloatingLegCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingLegCalculation  ***********************/
	class FloatingLegCalculationImpl implements FloatingLegCalculation {
		private final CommodityPricingDates pricingDates;
		private final AveragingMethodEnum averagingMethod;
		private final BigDecimal conversionFactor;
		private final Rounding rounding;
		private final CommoditySpread spread;
		private final List<? extends CommoditySpreadSchedule> spreadSchedule;
		private final BigDecimal spreadPercentage;
		private final CommodityFx fx;
		
		protected FloatingLegCalculationImpl(FloatingLegCalculation.FloatingLegCalculationBuilder builder) {
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.conversionFactor = builder.getConversionFactor();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
			this.spread = ofNullable(builder.getSpread()).map(f->f.build()).orElse(null);
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.spreadPercentage = builder.getSpreadPercentage();
			this.fx = ofNullable(builder.getFx()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pricingDates")
		public CommodityPricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding getRounding() {
			return rounding;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public CommoditySpread getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		public List<? extends CommoditySpreadSchedule> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		@RosettaAttribute("spreadPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadPercentage")
		public BigDecimal getSpreadPercentage() {
			return spreadPercentage;
		}
		
		@Override
		@RosettaAttribute("fx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fx")
		public CommodityFx getFx() {
			return fx;
		}
		
		@Override
		public FloatingLegCalculation build() {
			return this;
		}
		
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder toBuilder() {
			FloatingLegCalculation.FloatingLegCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingLegCalculation.FloatingLegCalculationBuilder builder) {
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
			ofNullable(getSpreadPercentage()).ifPresent(builder::setSpreadPercentage);
			ofNullable(getFx()).ifPresent(builder::setFx);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingLegCalculation _that = getType().cast(o);
		
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(spreadPercentage, _that.getSpreadPercentage())) return false;
			if (!Objects.equals(fx, _that.getFx())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadPercentage != null ? spreadPercentage.hashCode() : 0);
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingLegCalculation {" +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"rounding=" + this.rounding + ", " +
				"spread=" + this.spread + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"spreadPercentage=" + this.spreadPercentage + ", " +
				"fx=" + this.fx +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingLegCalculation  ***********************/
	class FloatingLegCalculationBuilderImpl implements FloatingLegCalculation.FloatingLegCalculationBuilder {
	
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected AveragingMethodEnum averagingMethod;
		protected BigDecimal conversionFactor;
		protected Rounding.RoundingBuilder rounding;
		protected CommoditySpread.CommoditySpreadBuilder spread;
		protected List<CommoditySpreadSchedule.CommoditySpreadScheduleBuilder> spreadSchedule = new ArrayList<>();
		protected BigDecimal spreadPercentage;
		protected CommodityFx.CommodityFxBuilder fx;
		
		@Override
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pricingDates")
		public CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates() {
			CommodityPricingDates.CommodityPricingDatesBuilder result;
			if (pricingDates!=null) {
				result = pricingDates;
			}
			else {
				result = pricingDates = CommodityPricingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding.RoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateRounding() {
			Rounding.RoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public CommoditySpread.CommoditySpreadBuilder getSpread() {
			return spread;
		}
		
		@Override
		public CommoditySpread.CommoditySpreadBuilder getOrCreateSpread() {
			CommoditySpread.CommoditySpreadBuilder result;
			if (spread!=null) {
				result = spread;
			}
			else {
				result = spread = CommoditySpread.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		public List<? extends CommoditySpreadSchedule.CommoditySpreadScheduleBuilder> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		public CommoditySpreadSchedule.CommoditySpreadScheduleBuilder getOrCreateSpreadSchedule(int index) {
			if (spreadSchedule==null) {
				this.spreadSchedule = new ArrayList<>();
			}
			return getIndex(spreadSchedule, index, () -> {
						CommoditySpreadSchedule.CommoditySpreadScheduleBuilder newSpreadSchedule = CommoditySpreadSchedule.builder();
						return newSpreadSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("spreadPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadPercentage")
		public BigDecimal getSpreadPercentage() {
			return spreadPercentage;
		}
		
		@Override
		@RosettaAttribute("fx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fx")
		public CommodityFx.CommodityFxBuilder getFx() {
			return fx;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder getOrCreateFx() {
			CommodityFx.CommodityFxBuilder result;
			if (fx!=null) {
				result = fx;
			}
			else {
				result = fx = CommodityFx.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pricingDates")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder setPricingDates(CommodityPricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("conversionFactor")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder setConversionFactor(BigDecimal _conversionFactor) {
			this.conversionFactor = _conversionFactor == null ? null : _conversionFactor;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder setSpread(CommoditySpread _spread) {
			this.spread = _spread == null ? null : _spread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(CommoditySpreadSchedule _spreadSchedule) {
			if (_spreadSchedule != null) {
				this.spreadSchedule.add(_spreadSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(CommoditySpreadSchedule _spreadSchedule, int idx) {
			getIndex(this.spreadSchedule, idx, () -> _spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder addSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedules) {
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
		public FloatingLegCalculation.FloatingLegCalculationBuilder setSpreadSchedule(List<? extends CommoditySpreadSchedule> spreadSchedules) {
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
		public FloatingLegCalculation.FloatingLegCalculationBuilder setSpreadPercentage(BigDecimal _spreadPercentage) {
			this.spreadPercentage = _spreadPercentage == null ? null : _spreadPercentage;
			return this;
		}
		
		@RosettaAttribute("fx")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fx")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder setFx(CommodityFx _fx) {
			this.fx = _fx == null ? null : _fx.toBuilder();
			return this;
		}
		
		@Override
		public FloatingLegCalculation build() {
			return new FloatingLegCalculation.FloatingLegCalculationImpl(this);
		}
		
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder prune() {
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			if (spread!=null && !spread.prune().hasData()) spread = null;
			spreadSchedule = spreadSchedule.stream().filter(b->b!=null).<CommoditySpreadSchedule.CommoditySpreadScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fx!=null && !fx.prune().hasData()) fx = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getConversionFactor()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			if (getSpread()!=null && getSpread().hasData()) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpreadPercentage()!=null) return true;
			if (getFx()!=null && getFx().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingLegCalculation.FloatingLegCalculationBuilder o = (FloatingLegCalculation.FloatingLegCalculationBuilder) other;
			
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			merger.mergeRosetta(getSpread(), o.getSpread(), this::setSpread);
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::getOrCreateSpreadSchedule);
			merger.mergeRosetta(getFx(), o.getFx(), this::setFx);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			merger.mergeBasic(getSpreadPercentage(), o.getSpreadPercentage(), this::setSpreadPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingLegCalculation _that = getType().cast(o);
		
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(spreadPercentage, _that.getSpreadPercentage())) return false;
			if (!Objects.equals(fx, _that.getFx())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadPercentage != null ? spreadPercentage.hashCode() : 0);
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingLegCalculationBuilder {" +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"rounding=" + this.rounding + ", " +
				"spread=" + this.spread + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"spreadPercentage=" + this.spreadPercentage + ", " +
				"fx=" + this.fx +
			'}';
		}
	}
}
