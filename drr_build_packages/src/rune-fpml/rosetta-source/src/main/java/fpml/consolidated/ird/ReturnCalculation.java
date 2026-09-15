package fpml.consolidated.ird;

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
import fpml.consolidated.asset.ActualPrice;
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.ird.meta.ReturnCalculationMeta;
import fpml.consolidated.shared.Rate;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the floating rate and definitions relating to the Return Calculation
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the floating rate and definitions relating to the Return Calculation
 *
 */
@RosettaDataType(value="ReturnCalculation", builder=ReturnCalculation.ReturnCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnCalculation", model="fpml", builder=ReturnCalculation.ReturnCalculationBuilderImpl.class, version="2.1.1")
public interface ReturnCalculation extends Rate {

	ReturnCalculationMeta metaData = new ReturnCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The underlyer
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The underlyer
	 *
	 */
	Underlyer getUnderlyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The settlement type
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The settlement type
	 *
	 */
	SettlementTypeEnum getSettlementType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The final valuation
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The final valuation
	 *
	 */
	QuotationCharacteristics getFinalValuation();
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
	InflationRate getInflationRate();
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
	ActualPrice getInitialPrice();

	/*********************** Build Methods  ***********************/
	ReturnCalculation build();
	
	ReturnCalculation.ReturnCalculationBuilder toBuilder();
	
	static ReturnCalculation.ReturnCalculationBuilder builder() {
		return new ReturnCalculation.ReturnCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnCalculation> getType() {
		return ReturnCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("finalValuation"), processor, QuotationCharacteristics.class, getFinalValuation());
		processRosetta(path.newSubPath("inflationRate"), processor, InflationRate.class, getInflationRate());
		processRosetta(path.newSubPath("initialPrice"), processor, ActualPrice.class, getInitialPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnCalculationBuilder extends ReturnCalculation, Rate.RateBuilder {
		Underlyer.UnderlyerBuilder getOrCreateUnderlyer();
		@Override
		Underlyer.UnderlyerBuilder getUnderlyer();
		QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateFinalValuation();
		@Override
		QuotationCharacteristics.QuotationCharacteristicsBuilder getFinalValuation();
		InflationRate.InflationRateBuilder getOrCreateInflationRate();
		@Override
		InflationRate.InflationRateBuilder getInflationRate();
		ActualPrice.ActualPriceBuilder getOrCreateInitialPrice();
		@Override
		ActualPrice.ActualPriceBuilder getInitialPrice();
		@Override
		ReturnCalculation.ReturnCalculationBuilder setId(String id);
		ReturnCalculation.ReturnCalculationBuilder setUnderlyer(Underlyer underlyer);
		ReturnCalculation.ReturnCalculationBuilder setSettlementType(SettlementTypeEnum settlementType);
		ReturnCalculation.ReturnCalculationBuilder setFinalValuation(QuotationCharacteristics finalValuation);
		ReturnCalculation.ReturnCalculationBuilder setInflationRate(InflationRate inflationRate);
		ReturnCalculation.ReturnCalculationBuilder setInitialPrice(ActualPrice initialPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("finalValuation"), processor, QuotationCharacteristics.QuotationCharacteristicsBuilder.class, getFinalValuation());
			processRosetta(path.newSubPath("inflationRate"), processor, InflationRate.InflationRateBuilder.class, getInflationRate());
			processRosetta(path.newSubPath("initialPrice"), processor, ActualPrice.ActualPriceBuilder.class, getInitialPrice());
		}
		

		ReturnCalculation.ReturnCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnCalculation  ***********************/
	class ReturnCalculationImpl extends Rate.RateImpl implements ReturnCalculation {
		private final Underlyer underlyer;
		private final SettlementTypeEnum settlementType;
		private final QuotationCharacteristics finalValuation;
		private final InflationRate inflationRate;
		private final ActualPrice initialPrice;
		
		protected ReturnCalculationImpl(ReturnCalculation.ReturnCalculationBuilder builder) {
			super(builder);
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
			this.finalValuation = ofNullable(builder.getFinalValuation()).map(f->f.build()).orElse(null);
			this.inflationRate = ofNullable(builder.getInflationRate()).map(f->f.build()).orElse(null);
			this.initialPrice = ofNullable(builder.getInitialPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public Underlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("finalValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalValuation")
		public QuotationCharacteristics getFinalValuation() {
			return finalValuation;
		}
		
		@Override
		@RosettaAttribute("inflationRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inflationRate")
		public InflationRate getInflationRate() {
			return inflationRate;
		}
		
		@Override
		@RosettaAttribute("initialPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPrice")
		public ActualPrice getInitialPrice() {
			return initialPrice;
		}
		
		@Override
		public ReturnCalculation build() {
			return this;
		}
		
		@Override
		public ReturnCalculation.ReturnCalculationBuilder toBuilder() {
			ReturnCalculation.ReturnCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnCalculation.ReturnCalculationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getFinalValuation()).ifPresent(builder::setFinalValuation);
			ofNullable(getInflationRate()).ifPresent(builder::setInflationRate);
			ofNullable(getInitialPrice()).ifPresent(builder::setInitialPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnCalculation _that = getType().cast(o);
		
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(finalValuation, _that.getFinalValuation())) return false;
			if (!Objects.equals(inflationRate, _that.getInflationRate())) return false;
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (finalValuation != null ? finalValuation.hashCode() : 0);
			_result = 31 * _result + (inflationRate != null ? inflationRate.hashCode() : 0);
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnCalculation {" +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType + ", " +
				"finalValuation=" + this.finalValuation + ", " +
				"inflationRate=" + this.inflationRate + ", " +
				"initialPrice=" + this.initialPrice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnCalculation  ***********************/
	class ReturnCalculationBuilderImpl extends Rate.RateBuilderImpl implements ReturnCalculation.ReturnCalculationBuilder {
	
		protected Underlyer.UnderlyerBuilder underlyer;
		protected SettlementTypeEnum settlementType;
		protected QuotationCharacteristics.QuotationCharacteristicsBuilder finalValuation;
		protected InflationRate.InflationRateBuilder inflationRate;
		protected ActualPrice.ActualPriceBuilder initialPrice;
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public Underlyer.UnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public Underlyer.UnderlyerBuilder getOrCreateUnderlyer() {
			Underlyer.UnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = Underlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("finalValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalValuation")
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getFinalValuation() {
			return finalValuation;
		}
		
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateFinalValuation() {
			QuotationCharacteristics.QuotationCharacteristicsBuilder result;
			if (finalValuation!=null) {
				result = finalValuation;
			}
			else {
				result = finalValuation = QuotationCharacteristics.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("inflationRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inflationRate")
		public InflationRate.InflationRateBuilder getInflationRate() {
			return inflationRate;
		}
		
		@Override
		public InflationRate.InflationRateBuilder getOrCreateInflationRate() {
			InflationRate.InflationRateBuilder result;
			if (inflationRate!=null) {
				result = inflationRate;
			}
			else {
				result = inflationRate = InflationRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPrice")
		public ActualPrice.ActualPriceBuilder getInitialPrice() {
			return initialPrice;
		}
		
		@Override
		public ActualPrice.ActualPriceBuilder getOrCreateInitialPrice() {
			ActualPrice.ActualPriceBuilder result;
			if (initialPrice!=null) {
				result = initialPrice;
			}
			else {
				result = initialPrice = ActualPrice.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ReturnCalculation.ReturnCalculationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyer")
		@Override
		public ReturnCalculation.ReturnCalculationBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public ReturnCalculation.ReturnCalculationBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("finalValuation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalValuation")
		@Override
		public ReturnCalculation.ReturnCalculationBuilder setFinalValuation(QuotationCharacteristics _finalValuation) {
			this.finalValuation = _finalValuation == null ? null : _finalValuation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inflationRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inflationRate")
		@Override
		public ReturnCalculation.ReturnCalculationBuilder setInflationRate(InflationRate _inflationRate) {
			this.inflationRate = _inflationRate == null ? null : _inflationRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialPrice")
		@Override
		public ReturnCalculation.ReturnCalculationBuilder setInitialPrice(ActualPrice _initialPrice) {
			this.initialPrice = _initialPrice == null ? null : _initialPrice.toBuilder();
			return this;
		}
		
		@Override
		public ReturnCalculation build() {
			return new ReturnCalculation.ReturnCalculationImpl(this);
		}
		
		@Override
		public ReturnCalculation.ReturnCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnCalculation.ReturnCalculationBuilder prune() {
			super.prune();
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			if (finalValuation!=null && !finalValuation.prune().hasData()) finalValuation = null;
			if (inflationRate!=null && !inflationRate.prune().hasData()) inflationRate = null;
			if (initialPrice!=null && !initialPrice.prune().hasData()) initialPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getSettlementType()!=null) return true;
			if (getFinalValuation()!=null && getFinalValuation().hasData()) return true;
			if (getInflationRate()!=null && getInflationRate().hasData()) return true;
			if (getInitialPrice()!=null && getInitialPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnCalculation.ReturnCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReturnCalculation.ReturnCalculationBuilder o = (ReturnCalculation.ReturnCalculationBuilder) other;
			
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			merger.mergeRosetta(getFinalValuation(), o.getFinalValuation(), this::setFinalValuation);
			merger.mergeRosetta(getInflationRate(), o.getInflationRate(), this::setInflationRate);
			merger.mergeRosetta(getInitialPrice(), o.getInitialPrice(), this::setInitialPrice);
			
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnCalculation _that = getType().cast(o);
		
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(finalValuation, _that.getFinalValuation())) return false;
			if (!Objects.equals(inflationRate, _that.getInflationRate())) return false;
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (finalValuation != null ? finalValuation.hashCode() : 0);
			_result = 31 * _result + (inflationRate != null ? inflationRate.hashCode() : 0);
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnCalculationBuilder {" +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType + ", " +
				"finalValuation=" + this.finalValuation + ", " +
				"inflationRate=" + this.inflationRate + ", " +
				"initialPrice=" + this.initialPrice +
			'}' + " " + super.toString();
		}
	}
}
