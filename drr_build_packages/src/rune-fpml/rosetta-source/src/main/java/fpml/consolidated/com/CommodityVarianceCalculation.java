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
import fpml.consolidated.com.meta.CommodityVarianceCalculationMeta;
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
@RosettaDataType(value="CommodityVarianceCalculation", builder=CommodityVarianceCalculation.CommodityVarianceCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityVarianceCalculation", model="fpml", builder=CommodityVarianceCalculation.CommodityVarianceCalculationBuilderImpl.class, version="2.1.1")
public interface CommodityVarianceCalculation extends RosettaModelObject {

	CommodityVarianceCalculationMeta metaData = new CommodityVarianceCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes which dates are valid dates on which to observe a price or index level.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes which dates are valid dates on which to observe a price or index level.
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
	 * Provision This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
	 *
	 */
	BigDecimal getAnnualizationFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether denominator of the annualization factor is N ("false") or N - 1 ("true").
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether denominator of the annualization factor is N ("false") or N - 1 ("true").
	 *
	 */
	Boolean getNAdjustment();

	/*********************** Build Methods  ***********************/
	CommodityVarianceCalculation build();
	
	CommodityVarianceCalculation.CommodityVarianceCalculationBuilder toBuilder();
	
	static CommodityVarianceCalculation.CommodityVarianceCalculationBuilder builder() {
		return new CommodityVarianceCalculation.CommodityVarianceCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityVarianceCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityVarianceCalculation> getType() {
		return CommodityVarianceCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processRosetta(path.newSubPath("valuationDates"), processor, CommodityValuationDates.class, getValuationDates());
		processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
		processor.processBasic(path.newSubPath("nAdjustment"), Boolean.class, getNAdjustment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityVarianceCalculationBuilder extends CommodityVarianceCalculation, RosettaModelObjectBuilder {
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		@Override
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		CommodityValuationDates.CommodityValuationDatesBuilder getOrCreateValuationDates();
		@Override
		CommodityValuationDates.CommodityValuationDatesBuilder getValuationDates();
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setValuationDates(CommodityValuationDates valuationDates);
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setAnnualizationFactor(BigDecimal annualizationFactor);
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setNAdjustment(Boolean nAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processRosetta(path.newSubPath("valuationDates"), processor, CommodityValuationDates.CommodityValuationDatesBuilder.class, getValuationDates());
			processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
			processor.processBasic(path.newSubPath("nAdjustment"), Boolean.class, getNAdjustment(), this);
		}
		

		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityVarianceCalculation  ***********************/
	class CommodityVarianceCalculationImpl implements CommodityVarianceCalculation {
		private final CommodityPricingDates pricingDates;
		private final CommodityValuationDates valuationDates;
		private final BigDecimal annualizationFactor;
		private final Boolean nAdjustment;
		
		protected CommodityVarianceCalculationImpl(CommodityVarianceCalculation.CommodityVarianceCalculationBuilder builder) {
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).map(f->f.build()).orElse(null);
			this.annualizationFactor = builder.getAnnualizationFactor();
			this.nAdjustment = builder.getNAdjustment();
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
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("annualizationFactor")
		public BigDecimal getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("nAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nAdjustment")
		public Boolean getNAdjustment() {
			return nAdjustment;
		}
		
		@Override
		public CommodityVarianceCalculation build() {
			return this;
		}
		
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder toBuilder() {
			CommodityVarianceCalculation.CommodityVarianceCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityVarianceCalculation.CommodityVarianceCalculationBuilder builder) {
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
			ofNullable(getAnnualizationFactor()).ifPresent(builder::setAnnualizationFactor);
			ofNullable(getNAdjustment()).ifPresent(builder::setNAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityVarianceCalculation _that = getType().cast(o);
		
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(nAdjustment, _that.getNAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (nAdjustment != null ? nAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityVarianceCalculation {" +
				"pricingDates=" + this.pricingDates + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"nAdjustment=" + this.nAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityVarianceCalculation  ***********************/
	class CommodityVarianceCalculationBuilderImpl implements CommodityVarianceCalculation.CommodityVarianceCalculationBuilder {
	
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected CommodityValuationDates.CommodityValuationDatesBuilder valuationDates;
		protected BigDecimal annualizationFactor;
		protected Boolean nAdjustment;
		
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
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("annualizationFactor")
		public BigDecimal getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("nAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nAdjustment")
		public Boolean getNAdjustment() {
			return nAdjustment;
		}
		
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingDates")
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setPricingDates(CommodityPricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDates")
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setValuationDates(CommodityValuationDates _valuationDates) {
			this.valuationDates = _valuationDates == null ? null : _valuationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("annualizationFactor")
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setAnnualizationFactor(BigDecimal _annualizationFactor) {
			this.annualizationFactor = _annualizationFactor == null ? null : _annualizationFactor;
			return this;
		}
		
		@RosettaAttribute("nAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nAdjustment")
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setNAdjustment(Boolean _nAdjustment) {
			this.nAdjustment = _nAdjustment == null ? null : _nAdjustment;
			return this;
		}
		
		@Override
		public CommodityVarianceCalculation build() {
			return new CommodityVarianceCalculation.CommodityVarianceCalculationImpl(this);
		}
		
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder prune() {
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			if (valuationDates!=null && !valuationDates.prune().hasData()) valuationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getValuationDates()!=null && getValuationDates().hasData()) return true;
			if (getAnnualizationFactor()!=null) return true;
			if (getNAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityVarianceCalculation.CommodityVarianceCalculationBuilder o = (CommodityVarianceCalculation.CommodityVarianceCalculationBuilder) other;
			
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::setValuationDates);
			
			merger.mergeBasic(getAnnualizationFactor(), o.getAnnualizationFactor(), this::setAnnualizationFactor);
			merger.mergeBasic(getNAdjustment(), o.getNAdjustment(), this::setNAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityVarianceCalculation _that = getType().cast(o);
		
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(nAdjustment, _that.getNAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (nAdjustment != null ? nAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityVarianceCalculationBuilder {" +
				"pricingDates=" + this.pricingDates + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"nAdjustment=" + this.nAdjustment +
			'}';
		}
	}
}
