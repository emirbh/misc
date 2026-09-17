package cdm.product.asset;

import cdm.observable.asset.DividendApplicability;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.product.asset.meta.ReturnTermsBaseMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Contains all common elements in variance, volatility and correlation return Terms.
 * @version 6.23.0
 */
@RosettaDataType(value="ReturnTermsBase", builder=ReturnTermsBase.ReturnTermsBaseBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ReturnTermsBase", model="cdm", builder=ReturnTermsBase.ReturnTermsBaseBuilderImpl.class, version="6.23.0")
public interface ReturnTermsBase extends RosettaModelObject {

	ReturnTermsBaseMeta metaData = new ReturnTermsBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Contains all non-date valuation information.
	 */
	ValuationTerms getValuationTerms();
	/**
	 * This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
	 */
	Integer getAnnualizationFactor();
	/**
	 * The parameters which define whether dividends are applicable
	 */
	DividendApplicability getDividendApplicability();
	/**
	 * Contains Equity Underlyer provisions regarding jurisdiction and fallbacks.
	 */
	EquityUnderlierProvisions getEquityUnderlierProvisions();
	/**
	 * Indicates whether the price of shares is adjusted for dividends or not.
	 */
	Boolean getSharePriceDividendAdjustment();
	/**
	 * Expected number of trading days.
	 */
	Integer getExpectedN();
	/**
	 * Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
	 */
	BigDecimal getInitialLevel();
	/**
	 * In this context, this is AgreedInitialPrice - a specified Initial Index Level.
	 */
	DeterminationMethodEnum getInitialLevelSource();
	/**
	 * Specifies whether Mean Adjustment is applicable or not in the calculation of the Realized Volatility, Variance or Correlation
	 */
	Boolean getMeanAdjustment();
	/**
	 * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. &#39;Equity Performance&#39;. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
	 */
	String getPerformance();

	/*********************** Build Methods  ***********************/
	ReturnTermsBase build();
	
	ReturnTermsBase.ReturnTermsBaseBuilder toBuilder();
	
	static ReturnTermsBase.ReturnTermsBaseBuilder builder() {
		return new ReturnTermsBase.ReturnTermsBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnTermsBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnTermsBase> getType() {
		return ReturnTermsBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuationTerms"), processor, ValuationTerms.class, getValuationTerms());
		processor.processBasic(path.newSubPath("annualizationFactor"), Integer.class, getAnnualizationFactor(), this);
		processRosetta(path.newSubPath("dividendApplicability"), processor, DividendApplicability.class, getDividendApplicability());
		processRosetta(path.newSubPath("equityUnderlierProvisions"), processor, EquityUnderlierProvisions.class, getEquityUnderlierProvisions());
		processor.processBasic(path.newSubPath("sharePriceDividendAdjustment"), Boolean.class, getSharePriceDividendAdjustment(), this);
		processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
		processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
		processor.processBasic(path.newSubPath("initialLevelSource"), DeterminationMethodEnum.class, getInitialLevelSource(), this);
		processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
		processor.processBasic(path.newSubPath("performance"), String.class, getPerformance(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnTermsBaseBuilder extends ReturnTermsBase, RosettaModelObjectBuilder {
		ValuationTerms.ValuationTermsBuilder getOrCreateValuationTerms();
		@Override
		ValuationTerms.ValuationTermsBuilder getValuationTerms();
		DividendApplicability.DividendApplicabilityBuilder getOrCreateDividendApplicability();
		@Override
		DividendApplicability.DividendApplicabilityBuilder getDividendApplicability();
		EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder getOrCreateEquityUnderlierProvisions();
		@Override
		EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder getEquityUnderlierProvisions();
		ReturnTermsBase.ReturnTermsBaseBuilder setValuationTerms(ValuationTerms valuationTerms);
		ReturnTermsBase.ReturnTermsBaseBuilder setAnnualizationFactor(Integer annualizationFactor);
		ReturnTermsBase.ReturnTermsBaseBuilder setDividendApplicability(DividendApplicability dividendApplicability);
		ReturnTermsBase.ReturnTermsBaseBuilder setEquityUnderlierProvisions(EquityUnderlierProvisions equityUnderlierProvisions);
		ReturnTermsBase.ReturnTermsBaseBuilder setSharePriceDividendAdjustment(Boolean sharePriceDividendAdjustment);
		ReturnTermsBase.ReturnTermsBaseBuilder setExpectedN(Integer expectedN);
		ReturnTermsBase.ReturnTermsBaseBuilder setInitialLevel(BigDecimal initialLevel);
		ReturnTermsBase.ReturnTermsBaseBuilder setInitialLevelSource(DeterminationMethodEnum initialLevelSource);
		ReturnTermsBase.ReturnTermsBaseBuilder setMeanAdjustment(Boolean meanAdjustment);
		ReturnTermsBase.ReturnTermsBaseBuilder setPerformance(String performance);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuationTerms"), processor, ValuationTerms.ValuationTermsBuilder.class, getValuationTerms());
			processor.processBasic(path.newSubPath("annualizationFactor"), Integer.class, getAnnualizationFactor(), this);
			processRosetta(path.newSubPath("dividendApplicability"), processor, DividendApplicability.DividendApplicabilityBuilder.class, getDividendApplicability());
			processRosetta(path.newSubPath("equityUnderlierProvisions"), processor, EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder.class, getEquityUnderlierProvisions());
			processor.processBasic(path.newSubPath("sharePriceDividendAdjustment"), Boolean.class, getSharePriceDividendAdjustment(), this);
			processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
			processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
			processor.processBasic(path.newSubPath("initialLevelSource"), DeterminationMethodEnum.class, getInitialLevelSource(), this);
			processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
			processor.processBasic(path.newSubPath("performance"), String.class, getPerformance(), this);
		}
		

		ReturnTermsBase.ReturnTermsBaseBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnTermsBase  ***********************/
	class ReturnTermsBaseImpl implements ReturnTermsBase {
		private final ValuationTerms valuationTerms;
		private final Integer annualizationFactor;
		private final DividendApplicability dividendApplicability;
		private final EquityUnderlierProvisions equityUnderlierProvisions;
		private final Boolean sharePriceDividendAdjustment;
		private final Integer expectedN;
		private final BigDecimal initialLevel;
		private final DeterminationMethodEnum initialLevelSource;
		private final Boolean meanAdjustment;
		private final String performance;
		
		protected ReturnTermsBaseImpl(ReturnTermsBase.ReturnTermsBaseBuilder builder) {
			this.valuationTerms = ofNullable(builder.getValuationTerms()).map(f->f.build()).orElse(null);
			this.annualizationFactor = builder.getAnnualizationFactor();
			this.dividendApplicability = ofNullable(builder.getDividendApplicability()).map(f->f.build()).orElse(null);
			this.equityUnderlierProvisions = ofNullable(builder.getEquityUnderlierProvisions()).map(f->f.build()).orElse(null);
			this.sharePriceDividendAdjustment = builder.getSharePriceDividendAdjustment();
			this.expectedN = builder.getExpectedN();
			this.initialLevel = builder.getInitialLevel();
			this.initialLevelSource = builder.getInitialLevelSource();
			this.meanAdjustment = builder.getMeanAdjustment();
			this.performance = builder.getPerformance();
		}
		
		@Override
		@RosettaAttribute("valuationTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationTerms")
		public ValuationTerms getValuationTerms() {
			return valuationTerms;
		}
		
		@Override
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("annualizationFactor")
		public Integer getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("dividendApplicability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendApplicability")
		public DividendApplicability getDividendApplicability() {
			return dividendApplicability;
		}
		
		@Override
		@RosettaAttribute("equityUnderlierProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityUnderlierProvisions")
		public EquityUnderlierProvisions getEquityUnderlierProvisions() {
			return equityUnderlierProvisions;
		}
		
		@Override
		@RosettaAttribute("sharePriceDividendAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sharePriceDividendAdjustment")
		public Boolean getSharePriceDividendAdjustment() {
			return sharePriceDividendAdjustment;
		}
		
		@Override
		@RosettaAttribute("expectedN")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expectedN")
		public Integer getExpectedN() {
			return expectedN;
		}
		
		@Override
		@RosettaAttribute("initialLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialLevel")
		public BigDecimal getInitialLevel() {
			return initialLevel;
		}
		
		@Override
		@RosettaAttribute("initialLevelSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialLevelSource")
		public DeterminationMethodEnum getInitialLevelSource() {
			return initialLevelSource;
		}
		
		@Override
		@RosettaAttribute("meanAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meanAdjustment")
		public Boolean getMeanAdjustment() {
			return meanAdjustment;
		}
		
		@Override
		@RosettaAttribute("performance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("performance")
		public String getPerformance() {
			return performance;
		}
		
		@Override
		public ReturnTermsBase build() {
			return this;
		}
		
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder toBuilder() {
			ReturnTermsBase.ReturnTermsBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnTermsBase.ReturnTermsBaseBuilder builder) {
			ofNullable(getValuationTerms()).ifPresent(builder::setValuationTerms);
			ofNullable(getAnnualizationFactor()).ifPresent(builder::setAnnualizationFactor);
			ofNullable(getDividendApplicability()).ifPresent(builder::setDividendApplicability);
			ofNullable(getEquityUnderlierProvisions()).ifPresent(builder::setEquityUnderlierProvisions);
			ofNullable(getSharePriceDividendAdjustment()).ifPresent(builder::setSharePriceDividendAdjustment);
			ofNullable(getExpectedN()).ifPresent(builder::setExpectedN);
			ofNullable(getInitialLevel()).ifPresent(builder::setInitialLevel);
			ofNullable(getInitialLevelSource()).ifPresent(builder::setInitialLevelSource);
			ofNullable(getMeanAdjustment()).ifPresent(builder::setMeanAdjustment);
			ofNullable(getPerformance()).ifPresent(builder::setPerformance);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnTermsBase _that = getType().cast(o);
		
			if (!Objects.equals(valuationTerms, _that.getValuationTerms())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(dividendApplicability, _that.getDividendApplicability())) return false;
			if (!Objects.equals(equityUnderlierProvisions, _that.getEquityUnderlierProvisions())) return false;
			if (!Objects.equals(sharePriceDividendAdjustment, _that.getSharePriceDividendAdjustment())) return false;
			if (!Objects.equals(expectedN, _that.getExpectedN())) return false;
			if (!Objects.equals(initialLevel, _that.getInitialLevel())) return false;
			if (!Objects.equals(initialLevelSource, _that.getInitialLevelSource())) return false;
			if (!Objects.equals(meanAdjustment, _that.getMeanAdjustment())) return false;
			if (!Objects.equals(performance, _that.getPerformance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationTerms != null ? valuationTerms.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (dividendApplicability != null ? dividendApplicability.hashCode() : 0);
			_result = 31 * _result + (equityUnderlierProvisions != null ? equityUnderlierProvisions.hashCode() : 0);
			_result = 31 * _result + (sharePriceDividendAdjustment != null ? sharePriceDividendAdjustment.hashCode() : 0);
			_result = 31 * _result + (expectedN != null ? expectedN.hashCode() : 0);
			_result = 31 * _result + (initialLevel != null ? initialLevel.hashCode() : 0);
			_result = 31 * _result + (initialLevelSource != null ? initialLevelSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meanAdjustment != null ? meanAdjustment.hashCode() : 0);
			_result = 31 * _result + (performance != null ? performance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnTermsBase {" +
				"valuationTerms=" + this.valuationTerms + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"dividendApplicability=" + this.dividendApplicability + ", " +
				"equityUnderlierProvisions=" + this.equityUnderlierProvisions + ", " +
				"sharePriceDividendAdjustment=" + this.sharePriceDividendAdjustment + ", " +
				"expectedN=" + this.expectedN + ", " +
				"initialLevel=" + this.initialLevel + ", " +
				"initialLevelSource=" + this.initialLevelSource + ", " +
				"meanAdjustment=" + this.meanAdjustment + ", " +
				"performance=" + this.performance +
			'}';
		}
	}

	/*********************** Builder Implementation of ReturnTermsBase  ***********************/
	class ReturnTermsBaseBuilderImpl implements ReturnTermsBase.ReturnTermsBaseBuilder {
	
		protected ValuationTerms.ValuationTermsBuilder valuationTerms;
		protected Integer annualizationFactor;
		protected DividendApplicability.DividendApplicabilityBuilder dividendApplicability;
		protected EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder equityUnderlierProvisions;
		protected Boolean sharePriceDividendAdjustment;
		protected Integer expectedN;
		protected BigDecimal initialLevel;
		protected DeterminationMethodEnum initialLevelSource;
		protected Boolean meanAdjustment;
		protected String performance;
		
		@Override
		@RosettaAttribute("valuationTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationTerms")
		public ValuationTerms.ValuationTermsBuilder getValuationTerms() {
			return valuationTerms;
		}
		
		@Override
		public ValuationTerms.ValuationTermsBuilder getOrCreateValuationTerms() {
			ValuationTerms.ValuationTermsBuilder result;
			if (valuationTerms!=null) {
				result = valuationTerms;
			}
			else {
				result = valuationTerms = ValuationTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("annualizationFactor")
		public Integer getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("dividendApplicability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendApplicability")
		public DividendApplicability.DividendApplicabilityBuilder getDividendApplicability() {
			return dividendApplicability;
		}
		
		@Override
		public DividendApplicability.DividendApplicabilityBuilder getOrCreateDividendApplicability() {
			DividendApplicability.DividendApplicabilityBuilder result;
			if (dividendApplicability!=null) {
				result = dividendApplicability;
			}
			else {
				result = dividendApplicability = DividendApplicability.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityUnderlierProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityUnderlierProvisions")
		public EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder getEquityUnderlierProvisions() {
			return equityUnderlierProvisions;
		}
		
		@Override
		public EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder getOrCreateEquityUnderlierProvisions() {
			EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder result;
			if (equityUnderlierProvisions!=null) {
				result = equityUnderlierProvisions;
			}
			else {
				result = equityUnderlierProvisions = EquityUnderlierProvisions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sharePriceDividendAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sharePriceDividendAdjustment")
		public Boolean getSharePriceDividendAdjustment() {
			return sharePriceDividendAdjustment;
		}
		
		@Override
		@RosettaAttribute("expectedN")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expectedN")
		public Integer getExpectedN() {
			return expectedN;
		}
		
		@Override
		@RosettaAttribute("initialLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialLevel")
		public BigDecimal getInitialLevel() {
			return initialLevel;
		}
		
		@Override
		@RosettaAttribute("initialLevelSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialLevelSource")
		public DeterminationMethodEnum getInitialLevelSource() {
			return initialLevelSource;
		}
		
		@Override
		@RosettaAttribute("meanAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meanAdjustment")
		public Boolean getMeanAdjustment() {
			return meanAdjustment;
		}
		
		@Override
		@RosettaAttribute("performance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("performance")
		public String getPerformance() {
			return performance;
		}
		
		@RosettaAttribute("valuationTerms")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationTerms")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setValuationTerms(ValuationTerms _valuationTerms) {
			this.valuationTerms = _valuationTerms == null ? null : _valuationTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("annualizationFactor")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setAnnualizationFactor(Integer _annualizationFactor) {
			this.annualizationFactor = _annualizationFactor == null ? null : _annualizationFactor;
			return this;
		}
		
		@RosettaAttribute("dividendApplicability")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendApplicability")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setDividendApplicability(DividendApplicability _dividendApplicability) {
			this.dividendApplicability = _dividendApplicability == null ? null : _dividendApplicability.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityUnderlierProvisions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityUnderlierProvisions")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setEquityUnderlierProvisions(EquityUnderlierProvisions _equityUnderlierProvisions) {
			this.equityUnderlierProvisions = _equityUnderlierProvisions == null ? null : _equityUnderlierProvisions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sharePriceDividendAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sharePriceDividendAdjustment")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setSharePriceDividendAdjustment(Boolean _sharePriceDividendAdjustment) {
			this.sharePriceDividendAdjustment = _sharePriceDividendAdjustment == null ? null : _sharePriceDividendAdjustment;
			return this;
		}
		
		@RosettaAttribute("expectedN")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expectedN")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setExpectedN(Integer _expectedN) {
			this.expectedN = _expectedN == null ? null : _expectedN;
			return this;
		}
		
		@RosettaAttribute("initialLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialLevel")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setInitialLevel(BigDecimal _initialLevel) {
			this.initialLevel = _initialLevel == null ? null : _initialLevel;
			return this;
		}
		
		@RosettaAttribute("initialLevelSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialLevelSource")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setInitialLevelSource(DeterminationMethodEnum _initialLevelSource) {
			this.initialLevelSource = _initialLevelSource == null ? null : _initialLevelSource;
			return this;
		}
		
		@RosettaAttribute("meanAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meanAdjustment")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setMeanAdjustment(Boolean _meanAdjustment) {
			this.meanAdjustment = _meanAdjustment == null ? null : _meanAdjustment;
			return this;
		}
		
		@RosettaAttribute("performance")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("performance")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder setPerformance(String _performance) {
			this.performance = _performance == null ? null : _performance;
			return this;
		}
		
		@Override
		public ReturnTermsBase build() {
			return new ReturnTermsBase.ReturnTermsBaseImpl(this);
		}
		
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder prune() {
			if (valuationTerms!=null && !valuationTerms.prune().hasData()) valuationTerms = null;
			if (dividendApplicability!=null && !dividendApplicability.prune().hasData()) dividendApplicability = null;
			if (equityUnderlierProvisions!=null && !equityUnderlierProvisions.prune().hasData()) equityUnderlierProvisions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValuationTerms()!=null && getValuationTerms().hasData()) return true;
			if (getAnnualizationFactor()!=null) return true;
			if (getDividendApplicability()!=null && getDividendApplicability().hasData()) return true;
			if (getEquityUnderlierProvisions()!=null && getEquityUnderlierProvisions().hasData()) return true;
			if (getSharePriceDividendAdjustment()!=null) return true;
			if (getExpectedN()!=null) return true;
			if (getInitialLevel()!=null) return true;
			if (getInitialLevelSource()!=null) return true;
			if (getMeanAdjustment()!=null) return true;
			if (getPerformance()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnTermsBase.ReturnTermsBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnTermsBase.ReturnTermsBaseBuilder o = (ReturnTermsBase.ReturnTermsBaseBuilder) other;
			
			merger.mergeRosetta(getValuationTerms(), o.getValuationTerms(), this::setValuationTerms);
			merger.mergeRosetta(getDividendApplicability(), o.getDividendApplicability(), this::setDividendApplicability);
			merger.mergeRosetta(getEquityUnderlierProvisions(), o.getEquityUnderlierProvisions(), this::setEquityUnderlierProvisions);
			
			merger.mergeBasic(getAnnualizationFactor(), o.getAnnualizationFactor(), this::setAnnualizationFactor);
			merger.mergeBasic(getSharePriceDividendAdjustment(), o.getSharePriceDividendAdjustment(), this::setSharePriceDividendAdjustment);
			merger.mergeBasic(getExpectedN(), o.getExpectedN(), this::setExpectedN);
			merger.mergeBasic(getInitialLevel(), o.getInitialLevel(), this::setInitialLevel);
			merger.mergeBasic(getInitialLevelSource(), o.getInitialLevelSource(), this::setInitialLevelSource);
			merger.mergeBasic(getMeanAdjustment(), o.getMeanAdjustment(), this::setMeanAdjustment);
			merger.mergeBasic(getPerformance(), o.getPerformance(), this::setPerformance);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnTermsBase _that = getType().cast(o);
		
			if (!Objects.equals(valuationTerms, _that.getValuationTerms())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(dividendApplicability, _that.getDividendApplicability())) return false;
			if (!Objects.equals(equityUnderlierProvisions, _that.getEquityUnderlierProvisions())) return false;
			if (!Objects.equals(sharePriceDividendAdjustment, _that.getSharePriceDividendAdjustment())) return false;
			if (!Objects.equals(expectedN, _that.getExpectedN())) return false;
			if (!Objects.equals(initialLevel, _that.getInitialLevel())) return false;
			if (!Objects.equals(initialLevelSource, _that.getInitialLevelSource())) return false;
			if (!Objects.equals(meanAdjustment, _that.getMeanAdjustment())) return false;
			if (!Objects.equals(performance, _that.getPerformance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationTerms != null ? valuationTerms.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (dividendApplicability != null ? dividendApplicability.hashCode() : 0);
			_result = 31 * _result + (equityUnderlierProvisions != null ? equityUnderlierProvisions.hashCode() : 0);
			_result = 31 * _result + (sharePriceDividendAdjustment != null ? sharePriceDividendAdjustment.hashCode() : 0);
			_result = 31 * _result + (expectedN != null ? expectedN.hashCode() : 0);
			_result = 31 * _result + (initialLevel != null ? initialLevel.hashCode() : 0);
			_result = 31 * _result + (initialLevelSource != null ? initialLevelSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meanAdjustment != null ? meanAdjustment.hashCode() : 0);
			_result = 31 * _result + (performance != null ? performance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnTermsBaseBuilder {" +
				"valuationTerms=" + this.valuationTerms + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"dividendApplicability=" + this.dividendApplicability + ", " +
				"equityUnderlierProvisions=" + this.equityUnderlierProvisions + ", " +
				"sharePriceDividendAdjustment=" + this.sharePriceDividendAdjustment + ", " +
				"expectedN=" + this.expectedN + ", " +
				"initialLevel=" + this.initialLevel + ", " +
				"initialLevelSource=" + this.initialLevelSource + ", " +
				"meanAdjustment=" + this.meanAdjustment + ", " +
				"performance=" + this.performance +
			'}';
		}
	}
}
