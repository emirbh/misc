package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityReturnCalculationMeta;
import fpml.consolidated.fpmlenum.CommodityReturnCalculationFormulaEnum;
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
@RosettaDataType(value="CommodityReturnCalculation", builder=CommodityReturnCalculation.CommodityReturnCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityReturnCalculation", model="fpml", builder=CommodityReturnCalculation.CommodityReturnCalculationBuilderImpl.class, version="2.1.1")
public interface CommodityReturnCalculation extends RosettaModelObject {

	CommodityReturnCalculationMeta metaData = new CommodityReturnCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the value of the commodity return calculation formula as simple or compound.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the value of the commodity return calculation formula as simple or compound.
	 *
	 */
	CommodityReturnCalculationFormulaEnum getFormula();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes which dates are valid dates on which to observe a price or index level
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes which dates are valid dates on which to observe a price or index level
	 *
	 */
	CommodityPricingDates getPricingDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines when a price or index level will be observed that will figure in the return calculation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines when a price or index level will be observed that will figure in the return calculation.
	 *
	 */
	CommodityValuationDates getValuationDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If specified in the confirmation, the price or index level at the beginning of the initial Calculation Period. For example, if the return calculation is [(Index End / Index Begin) - 1] and Index Begin is defined as equal to Index End for the immediately preceeding Calculation Period, then the value of Index Begin in the very first Calculation Period is not defined and is usually specified in the confirmation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If specified in the confirmation, the price or index level at the beginning of the initial Calculation Period. For example, if the return calculation is [(Index End / Index Begin) - 1] and Index Begin is defined as equal to Index End for the immediately preceeding Calculation Period, then the value of Index Begin in the very first Calculation Period is not defined and is usually specified in the confirmation.
	 *
	 */
	BigDecimal getInitialPrice();

	/*********************** Build Methods  ***********************/
	CommodityReturnCalculation build();
	
	CommodityReturnCalculation.CommodityReturnCalculationBuilder toBuilder();
	
	static CommodityReturnCalculation.CommodityReturnCalculationBuilder builder() {
		return new CommodityReturnCalculation.CommodityReturnCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityReturnCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityReturnCalculation> getType() {
		return CommodityReturnCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("formula"), CommodityReturnCalculationFormulaEnum.class, getFormula(), this);
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processRosetta(path.newSubPath("valuationDates"), processor, CommodityValuationDates.class, getValuationDates());
		processor.processBasic(path.newSubPath("initialPrice"), BigDecimal.class, getInitialPrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityReturnCalculationBuilder extends CommodityReturnCalculation, RosettaModelObjectBuilder {
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		@Override
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		CommodityValuationDates.CommodityValuationDatesBuilder getOrCreateValuationDates();
		@Override
		CommodityValuationDates.CommodityValuationDatesBuilder getValuationDates();
		CommodityReturnCalculation.CommodityReturnCalculationBuilder setFormula(CommodityReturnCalculationFormulaEnum formula);
		CommodityReturnCalculation.CommodityReturnCalculationBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityReturnCalculation.CommodityReturnCalculationBuilder setValuationDates(CommodityValuationDates valuationDates);
		CommodityReturnCalculation.CommodityReturnCalculationBuilder setInitialPrice(BigDecimal initialPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("formula"), CommodityReturnCalculationFormulaEnum.class, getFormula(), this);
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processRosetta(path.newSubPath("valuationDates"), processor, CommodityValuationDates.CommodityValuationDatesBuilder.class, getValuationDates());
			processor.processBasic(path.newSubPath("initialPrice"), BigDecimal.class, getInitialPrice(), this);
		}
		

		CommodityReturnCalculation.CommodityReturnCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityReturnCalculation  ***********************/
	class CommodityReturnCalculationImpl implements CommodityReturnCalculation {
		private final CommodityReturnCalculationFormulaEnum formula;
		private final CommodityPricingDates pricingDates;
		private final CommodityValuationDates valuationDates;
		private final BigDecimal initialPrice;
		
		protected CommodityReturnCalculationImpl(CommodityReturnCalculation.CommodityReturnCalculationBuilder builder) {
			this.formula = builder.getFormula();
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).map(f->f.build()).orElse(null);
			this.initialPrice = builder.getInitialPrice();
		}
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public CommodityReturnCalculationFormulaEnum getFormula() {
			return formula;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingDates")
		public CommodityPricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDates")
		public CommodityValuationDates getValuationDates() {
			return valuationDates;
		}
		
		@Override
		@RosettaAttribute("initialPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPrice")
		public BigDecimal getInitialPrice() {
			return initialPrice;
		}
		
		@Override
		public CommodityReturnCalculation build() {
			return this;
		}
		
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder toBuilder() {
			CommodityReturnCalculation.CommodityReturnCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityReturnCalculation.CommodityReturnCalculationBuilder builder) {
			ofNullable(getFormula()).ifPresent(builder::setFormula);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
			ofNullable(getInitialPrice()).ifPresent(builder::setInitialPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityReturnCalculation _that = getType().cast(o);
		
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (formula != null ? formula.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReturnCalculation {" +
				"formula=" + this.formula + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"initialPrice=" + this.initialPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityReturnCalculation  ***********************/
	class CommodityReturnCalculationBuilderImpl implements CommodityReturnCalculation.CommodityReturnCalculationBuilder {
	
		protected CommodityReturnCalculationFormulaEnum formula;
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected CommodityValuationDates.CommodityValuationDatesBuilder valuationDates;
		protected BigDecimal initialPrice;
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public CommodityReturnCalculationFormulaEnum getFormula() {
			return formula;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDates")
		public CommodityValuationDates.CommodityValuationDatesBuilder getValuationDates() {
			return valuationDates;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder getOrCreateValuationDates() {
			CommodityValuationDates.CommodityValuationDatesBuilder result;
			if (valuationDates!=null) {
				result = valuationDates;
			}
			else {
				result = valuationDates = CommodityValuationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPrice")
		public BigDecimal getInitialPrice() {
			return initialPrice;
		}
		
		@RosettaAttribute("formula")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("formula")
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder setFormula(CommodityReturnCalculationFormulaEnum _formula) {
			this.formula = _formula == null ? null : _formula;
			return this;
		}
		
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingDates")
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder setPricingDates(CommodityPricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDates")
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder setValuationDates(CommodityValuationDates _valuationDates) {
			this.valuationDates = _valuationDates == null ? null : _valuationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialPrice")
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder setInitialPrice(BigDecimal _initialPrice) {
			this.initialPrice = _initialPrice == null ? null : _initialPrice;
			return this;
		}
		
		@Override
		public CommodityReturnCalculation build() {
			return new CommodityReturnCalculation.CommodityReturnCalculationImpl(this);
		}
		
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder prune() {
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			if (valuationDates!=null && !valuationDates.prune().hasData()) valuationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFormula()!=null) return true;
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getValuationDates()!=null && getValuationDates().hasData()) return true;
			if (getInitialPrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityReturnCalculation.CommodityReturnCalculationBuilder o = (CommodityReturnCalculation.CommodityReturnCalculationBuilder) other;
			
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::setValuationDates);
			
			merger.mergeBasic(getFormula(), o.getFormula(), this::setFormula);
			merger.mergeBasic(getInitialPrice(), o.getInitialPrice(), this::setInitialPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityReturnCalculation _that = getType().cast(o);
		
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (formula != null ? formula.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReturnCalculationBuilder {" +
				"formula=" + this.formula + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"initialPrice=" + this.initialPrice +
			'}';
		}
	}
}
