package fpml.consolidated.eq.shared;

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
import fpml.consolidated.asset.Commission;
import fpml.consolidated.asset.FxConversion;
import fpml.consolidated.asset.Price;
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.eq.shared.meta.ReturnLegValuationPriceMeta;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.DeterminationMethod;
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
@RosettaDataType(value="ReturnLegValuationPrice", builder=ReturnLegValuationPrice.ReturnLegValuationPriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnLegValuationPrice", model="fpml", builder=ReturnLegValuationPrice.ReturnLegValuationPriceBuilderImpl.class, version="2.1.1")
public interface ReturnLegValuationPrice extends Price {

	ReturnLegValuationPriceMeta metaData = new ReturnLegValuationPriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies valuation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies valuation.
	 *
	 */
	EquityValuation getValuationRules();

	/*********************** Build Methods  ***********************/
	ReturnLegValuationPrice build();
	
	ReturnLegValuationPrice.ReturnLegValuationPriceBuilder toBuilder();
	
	static ReturnLegValuationPrice.ReturnLegValuationPriceBuilder builder() {
		return new ReturnLegValuationPrice.ReturnLegValuationPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnLegValuationPrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnLegValuationPrice> getType() {
		return ReturnLegValuationPrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commission"), processor, Commission.class, getCommission());
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("grossPrice"), processor, ActualPrice.class, getGrossPrice());
		processRosetta(path.newSubPath("netPrice"), processor, ActualPrice.class, getNetPrice());
		processor.processBasic(path.newSubPath("accruedInterestPrice"), BigDecimal.class, getAccruedInterestPrice(), this);
		processRosetta(path.newSubPath("fxConversion"), processor, FxConversion.class, getFxConversion());
		processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.class, getAmountRelativeTo());
		processor.processBasic(path.newSubPath("cleanNetPrice"), BigDecimal.class, getCleanNetPrice(), this);
		processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.class, getQuotationCharacteristics());
		processRosetta(path.newSubPath("valuationRules"), processor, EquityValuation.class, getValuationRules());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnLegValuationPriceBuilder extends ReturnLegValuationPrice, Price.PriceBuilder {
		EquityValuation.EquityValuationBuilder getOrCreateValuationRules();
		@Override
		EquityValuation.EquityValuationBuilder getValuationRules();
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setCommission(Commission commission);
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setGrossPrice(ActualPrice grossPrice);
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setNetPrice(ActualPrice netPrice);
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setAccruedInterestPrice(BigDecimal accruedInterestPrice);
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setFxConversion(FxConversion fxConversion);
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setAmountRelativeTo(AmountReference amountRelativeTo);
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setCleanNetPrice(BigDecimal cleanNetPrice);
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics);
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setValuationRules(EquityValuation valuationRules);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commission"), processor, Commission.CommissionBuilder.class, getCommission());
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("grossPrice"), processor, ActualPrice.ActualPriceBuilder.class, getGrossPrice());
			processRosetta(path.newSubPath("netPrice"), processor, ActualPrice.ActualPriceBuilder.class, getNetPrice());
			processor.processBasic(path.newSubPath("accruedInterestPrice"), BigDecimal.class, getAccruedInterestPrice(), this);
			processRosetta(path.newSubPath("fxConversion"), processor, FxConversion.FxConversionBuilder.class, getFxConversion());
			processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.AmountReferenceBuilder.class, getAmountRelativeTo());
			processor.processBasic(path.newSubPath("cleanNetPrice"), BigDecimal.class, getCleanNetPrice(), this);
			processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.QuotationCharacteristicsBuilder.class, getQuotationCharacteristics());
			processRosetta(path.newSubPath("valuationRules"), processor, EquityValuation.EquityValuationBuilder.class, getValuationRules());
		}
		

		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnLegValuationPrice  ***********************/
	class ReturnLegValuationPriceImpl extends Price.PriceImpl implements ReturnLegValuationPrice {
		private final EquityValuation valuationRules;
		
		protected ReturnLegValuationPriceImpl(ReturnLegValuationPrice.ReturnLegValuationPriceBuilder builder) {
			super(builder);
			this.valuationRules = ofNullable(builder.getValuationRules()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valuationRules")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationRules")
		public EquityValuation getValuationRules() {
			return valuationRules;
		}
		
		@Override
		public ReturnLegValuationPrice build() {
			return this;
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder toBuilder() {
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnLegValuationPrice.ReturnLegValuationPriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValuationRules()).ifPresent(builder::setValuationRules);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnLegValuationPrice _that = getType().cast(o);
		
			if (!Objects.equals(valuationRules, _that.getValuationRules())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuationRules != null ? valuationRules.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegValuationPrice {" +
				"valuationRules=" + this.valuationRules +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnLegValuationPrice  ***********************/
	class ReturnLegValuationPriceBuilderImpl extends Price.PriceBuilderImpl implements ReturnLegValuationPrice.ReturnLegValuationPriceBuilder {
	
		protected EquityValuation.EquityValuationBuilder valuationRules;
		
		@Override
		@RosettaAttribute("valuationRules")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationRules")
		public EquityValuation.EquityValuationBuilder getValuationRules() {
			return valuationRules;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder getOrCreateValuationRules() {
			EquityValuation.EquityValuationBuilder result;
			if (valuationRules!=null) {
				result = valuationRules;
			}
			else {
				result = valuationRules = EquityValuation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("commission")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commission")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setCommission(Commission _commission) {
			this.commission = _commission == null ? null : _commission.toBuilder();
			return this;
		}
		
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determinationMethod")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setDeterminationMethod(DeterminationMethod _determinationMethod) {
			this.determinationMethod = _determinationMethod == null ? null : _determinationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("grossPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("grossPrice")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setGrossPrice(ActualPrice _grossPrice) {
			this.grossPrice = _grossPrice == null ? null : _grossPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("netPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("netPrice")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setNetPrice(ActualPrice _netPrice) {
			this.netPrice = _netPrice == null ? null : _netPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruedInterestPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruedInterestPrice")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setAccruedInterestPrice(BigDecimal _accruedInterestPrice) {
			this.accruedInterestPrice = _accruedInterestPrice == null ? null : _accruedInterestPrice;
			return this;
		}
		
		@RosettaAttribute("fxConversion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxConversion")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setFxConversion(FxConversion _fxConversion) {
			this.fxConversion = _fxConversion == null ? null : _fxConversion.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amountRelativeTo")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setAmountRelativeTo(AmountReference _amountRelativeTo) {
			this.amountRelativeTo = _amountRelativeTo == null ? null : _amountRelativeTo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cleanNetPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cleanNetPrice")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setCleanNetPrice(BigDecimal _cleanNetPrice) {
			this.cleanNetPrice = _cleanNetPrice == null ? null : _cleanNetPrice;
			return this;
		}
		
		@RosettaAttribute("quotationCharacteristics")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotationCharacteristics")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setQuotationCharacteristics(QuotationCharacteristics _quotationCharacteristics) {
			this.quotationCharacteristics = _quotationCharacteristics == null ? null : _quotationCharacteristics.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationRules")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationRules")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setValuationRules(EquityValuation _valuationRules) {
			this.valuationRules = _valuationRules == null ? null : _valuationRules.toBuilder();
			return this;
		}
		
		@Override
		public ReturnLegValuationPrice build() {
			return new ReturnLegValuationPrice.ReturnLegValuationPriceImpl(this);
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder prune() {
			super.prune();
			if (valuationRules!=null && !valuationRules.prune().hasData()) valuationRules = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValuationRules()!=null && getValuationRules().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder o = (ReturnLegValuationPrice.ReturnLegValuationPriceBuilder) other;
			
			merger.mergeRosetta(getValuationRules(), o.getValuationRules(), this::setValuationRules);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnLegValuationPrice _that = getType().cast(o);
		
			if (!Objects.equals(valuationRules, _that.getValuationRules())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuationRules != null ? valuationRules.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegValuationPriceBuilder {" +
				"valuationRules=" + this.valuationRules +
			'}' + " " + super.toString();
		}
	}
}
