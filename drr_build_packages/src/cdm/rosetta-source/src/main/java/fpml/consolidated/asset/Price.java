package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.PriceMeta;
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
 * Provision A type describing the strike price.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the strike price.
 *
 */
@RosettaDataType(value="Price", builder=Price.PriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Price", model="fpml", builder=Price.PriceBuilderImpl.class, version="2.1.1")
public interface Price extends RosettaModelObject {

	PriceMeta metaData = new PriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This optional component specifies the commission to be charged for executing the hedge transactions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This optional component specifies the commission to be charged for executing the hedge transactions.
	 *
	 */
	Commission getCommission();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the method according to which an amount or a date is determined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the method according to which an amount or a date is determined.
	 *
	 */
	DeterminationMethod getDeterminationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the price of the underlyer, before commissions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the price of the underlyer, before commissions.
	 *
	 */
	ActualPrice getGrossPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the price of the underlyer, net of commissions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the price of the underlyer, net of commissions.
	 *
	 */
	ActualPrice getNetPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the accrued interest that are part of the dirty price in the case of a fixed income security or a convertible bond. Expressed in percentage of the notional.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the accrued interest that are part of the dirty price in the case of a fixed income security or a convertible bond. Expressed in percentage of the notional.
	 *
	 */
	BigDecimal getAccruedInterestPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the currency conversion rate that applies to an amount. This rate can either be defined elsewhere in the document (case of a quanto swap), or explicitly described through this component.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the currency conversion rate that applies to an amount. This rate can either be defined elsewhere in the document (case of a quanto swap), or explicitly described through this component.
	 *
	 */
	FxConversion getFxConversion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The href attribute value will be a pointer style reference to the element or component elsewhere in the document where the anchor amount is defined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The href attribute value will be a pointer style reference to the element or component elsewhere in the document where the anchor amount is defined.
	 *
	 */
	AmountReference getAmountRelativeTo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The net price excluding accrued interest. The "Dirty Price" for bonds is put in the "netPrice" element, which includes accrued interest. Thus netPrice - cleanNetPrice = accruedInterest. The currency and price expression for this field are the same as those for the (dirty) netPrice.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The net price excluding accrued interest. The "Dirty Price" for bonds is put in the "netPrice" element, which includes accrued interest. Thus netPrice - cleanNetPrice = accruedInterest. The currency and price expression for this field are the same as those for the (dirty) netPrice.
	 *
	 */
	BigDecimal getCleanNetPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows information about how the price was quoted to be provided.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows information about how the price was quoted to be provided.
	 *
	 */
	QuotationCharacteristics getQuotationCharacteristics();

	/*********************** Build Methods  ***********************/
	Price build();
	
	Price.PriceBuilder toBuilder();
	
	static Price.PriceBuilder builder() {
		return new Price.PriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Price> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Price> getType() {
		return Price.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceBuilder extends Price, RosettaModelObjectBuilder {
		Commission.CommissionBuilder getOrCreateCommission();
		@Override
		Commission.CommissionBuilder getCommission();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		ActualPrice.ActualPriceBuilder getOrCreateGrossPrice();
		@Override
		ActualPrice.ActualPriceBuilder getGrossPrice();
		ActualPrice.ActualPriceBuilder getOrCreateNetPrice();
		@Override
		ActualPrice.ActualPriceBuilder getNetPrice();
		FxConversion.FxConversionBuilder getOrCreateFxConversion();
		@Override
		FxConversion.FxConversionBuilder getFxConversion();
		AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo();
		@Override
		AmountReference.AmountReferenceBuilder getAmountRelativeTo();
		QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateQuotationCharacteristics();
		@Override
		QuotationCharacteristics.QuotationCharacteristicsBuilder getQuotationCharacteristics();
		Price.PriceBuilder setCommission(Commission commission);
		Price.PriceBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		Price.PriceBuilder setGrossPrice(ActualPrice grossPrice);
		Price.PriceBuilder setNetPrice(ActualPrice netPrice);
		Price.PriceBuilder setAccruedInterestPrice(BigDecimal accruedInterestPrice);
		Price.PriceBuilder setFxConversion(FxConversion fxConversion);
		Price.PriceBuilder setAmountRelativeTo(AmountReference amountRelativeTo);
		Price.PriceBuilder setCleanNetPrice(BigDecimal cleanNetPrice);
		Price.PriceBuilder setQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics);

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
		}
		

		Price.PriceBuilder prune();
	}

	/*********************** Immutable Implementation of Price  ***********************/
	class PriceImpl implements Price {
		private final Commission commission;
		private final DeterminationMethod determinationMethod;
		private final ActualPrice grossPrice;
		private final ActualPrice netPrice;
		private final BigDecimal accruedInterestPrice;
		private final FxConversion fxConversion;
		private final AmountReference amountRelativeTo;
		private final BigDecimal cleanNetPrice;
		private final QuotationCharacteristics quotationCharacteristics;
		
		protected PriceImpl(Price.PriceBuilder builder) {
			this.commission = ofNullable(builder.getCommission()).map(f->f.build()).orElse(null);
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.grossPrice = ofNullable(builder.getGrossPrice()).map(f->f.build()).orElse(null);
			this.netPrice = ofNullable(builder.getNetPrice()).map(f->f.build()).orElse(null);
			this.accruedInterestPrice = builder.getAccruedInterestPrice();
			this.fxConversion = ofNullable(builder.getFxConversion()).map(f->f.build()).orElse(null);
			this.amountRelativeTo = ofNullable(builder.getAmountRelativeTo()).map(f->f.build()).orElse(null);
			this.cleanNetPrice = builder.getCleanNetPrice();
			this.quotationCharacteristics = ofNullable(builder.getQuotationCharacteristics()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commission")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commission")
		public Commission getCommission() {
			return commission;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("grossPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grossPrice")
		public ActualPrice getGrossPrice() {
			return grossPrice;
		}
		
		@Override
		@RosettaAttribute("netPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("netPrice")
		public ActualPrice getNetPrice() {
			return netPrice;
		}
		
		@Override
		@RosettaAttribute("accruedInterestPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruedInterestPrice")
		public BigDecimal getAccruedInterestPrice() {
			return accruedInterestPrice;
		}
		
		@Override
		@RosettaAttribute("fxConversion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxConversion")
		public FxConversion getFxConversion() {
			return fxConversion;
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountRelativeTo")
		public AmountReference getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		@RosettaAttribute("cleanNetPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cleanNetPrice")
		public BigDecimal getCleanNetPrice() {
			return cleanNetPrice;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristics")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationCharacteristics")
		public QuotationCharacteristics getQuotationCharacteristics() {
			return quotationCharacteristics;
		}
		
		@Override
		public Price build() {
			return this;
		}
		
		@Override
		public Price.PriceBuilder toBuilder() {
			Price.PriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Price.PriceBuilder builder) {
			ofNullable(getCommission()).ifPresent(builder::setCommission);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getGrossPrice()).ifPresent(builder::setGrossPrice);
			ofNullable(getNetPrice()).ifPresent(builder::setNetPrice);
			ofNullable(getAccruedInterestPrice()).ifPresent(builder::setAccruedInterestPrice);
			ofNullable(getFxConversion()).ifPresent(builder::setFxConversion);
			ofNullable(getAmountRelativeTo()).ifPresent(builder::setAmountRelativeTo);
			ofNullable(getCleanNetPrice()).ifPresent(builder::setCleanNetPrice);
			ofNullable(getQuotationCharacteristics()).ifPresent(builder::setQuotationCharacteristics);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Price _that = getType().cast(o);
		
			if (!Objects.equals(commission, _that.getCommission())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(grossPrice, _that.getGrossPrice())) return false;
			if (!Objects.equals(netPrice, _that.getNetPrice())) return false;
			if (!Objects.equals(accruedInterestPrice, _that.getAccruedInterestPrice())) return false;
			if (!Objects.equals(fxConversion, _that.getFxConversion())) return false;
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!Objects.equals(cleanNetPrice, _that.getCleanNetPrice())) return false;
			if (!Objects.equals(quotationCharacteristics, _that.getQuotationCharacteristics())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commission != null ? commission.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (grossPrice != null ? grossPrice.hashCode() : 0);
			_result = 31 * _result + (netPrice != null ? netPrice.hashCode() : 0);
			_result = 31 * _result + (accruedInterestPrice != null ? accruedInterestPrice.hashCode() : 0);
			_result = 31 * _result + (fxConversion != null ? fxConversion.hashCode() : 0);
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (cleanNetPrice != null ? cleanNetPrice.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristics != null ? quotationCharacteristics.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Price {" +
				"commission=" + this.commission + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"grossPrice=" + this.grossPrice + ", " +
				"netPrice=" + this.netPrice + ", " +
				"accruedInterestPrice=" + this.accruedInterestPrice + ", " +
				"fxConversion=" + this.fxConversion + ", " +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"cleanNetPrice=" + this.cleanNetPrice + ", " +
				"quotationCharacteristics=" + this.quotationCharacteristics +
			'}';
		}
	}

	/*********************** Builder Implementation of Price  ***********************/
	class PriceBuilderImpl implements Price.PriceBuilder {
	
		protected Commission.CommissionBuilder commission;
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected ActualPrice.ActualPriceBuilder grossPrice;
		protected ActualPrice.ActualPriceBuilder netPrice;
		protected BigDecimal accruedInterestPrice;
		protected FxConversion.FxConversionBuilder fxConversion;
		protected AmountReference.AmountReferenceBuilder amountRelativeTo;
		protected BigDecimal cleanNetPrice;
		protected QuotationCharacteristics.QuotationCharacteristicsBuilder quotationCharacteristics;
		
		@Override
		@RosettaAttribute("commission")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commission")
		public Commission.CommissionBuilder getCommission() {
			return commission;
		}
		
		@Override
		public Commission.CommissionBuilder getOrCreateCommission() {
			Commission.CommissionBuilder result;
			if (commission!=null) {
				result = commission;
			}
			else {
				result = commission = Commission.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethod")
		public DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (determinationMethod!=null) {
				result = determinationMethod;
			}
			else {
				result = determinationMethod = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grossPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grossPrice")
		public ActualPrice.ActualPriceBuilder getGrossPrice() {
			return grossPrice;
		}
		
		@Override
		public ActualPrice.ActualPriceBuilder getOrCreateGrossPrice() {
			ActualPrice.ActualPriceBuilder result;
			if (grossPrice!=null) {
				result = grossPrice;
			}
			else {
				result = grossPrice = ActualPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("netPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("netPrice")
		public ActualPrice.ActualPriceBuilder getNetPrice() {
			return netPrice;
		}
		
		@Override
		public ActualPrice.ActualPriceBuilder getOrCreateNetPrice() {
			ActualPrice.ActualPriceBuilder result;
			if (netPrice!=null) {
				result = netPrice;
			}
			else {
				result = netPrice = ActualPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruedInterestPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruedInterestPrice")
		public BigDecimal getAccruedInterestPrice() {
			return accruedInterestPrice;
		}
		
		@Override
		@RosettaAttribute("fxConversion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxConversion")
		public FxConversion.FxConversionBuilder getFxConversion() {
			return fxConversion;
		}
		
		@Override
		public FxConversion.FxConversionBuilder getOrCreateFxConversion() {
			FxConversion.FxConversionBuilder result;
			if (fxConversion!=null) {
				result = fxConversion;
			}
			else {
				result = fxConversion = FxConversion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountRelativeTo")
		public AmountReference.AmountReferenceBuilder getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo() {
			AmountReference.AmountReferenceBuilder result;
			if (amountRelativeTo!=null) {
				result = amountRelativeTo;
			}
			else {
				result = amountRelativeTo = AmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cleanNetPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cleanNetPrice")
		public BigDecimal getCleanNetPrice() {
			return cleanNetPrice;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristics")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationCharacteristics")
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getQuotationCharacteristics() {
			return quotationCharacteristics;
		}
		
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateQuotationCharacteristics() {
			QuotationCharacteristics.QuotationCharacteristicsBuilder result;
			if (quotationCharacteristics!=null) {
				result = quotationCharacteristics;
			}
			else {
				result = quotationCharacteristics = QuotationCharacteristics.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("commission")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commission")
		@Override
		public Price.PriceBuilder setCommission(Commission _commission) {
			this.commission = _commission == null ? null : _commission.toBuilder();
			return this;
		}
		
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determinationMethod")
		@Override
		public Price.PriceBuilder setDeterminationMethod(DeterminationMethod _determinationMethod) {
			this.determinationMethod = _determinationMethod == null ? null : _determinationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("grossPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("grossPrice")
		@Override
		public Price.PriceBuilder setGrossPrice(ActualPrice _grossPrice) {
			this.grossPrice = _grossPrice == null ? null : _grossPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("netPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("netPrice")
		@Override
		public Price.PriceBuilder setNetPrice(ActualPrice _netPrice) {
			this.netPrice = _netPrice == null ? null : _netPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruedInterestPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruedInterestPrice")
		@Override
		public Price.PriceBuilder setAccruedInterestPrice(BigDecimal _accruedInterestPrice) {
			this.accruedInterestPrice = _accruedInterestPrice == null ? null : _accruedInterestPrice;
			return this;
		}
		
		@RosettaAttribute("fxConversion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxConversion")
		@Override
		public Price.PriceBuilder setFxConversion(FxConversion _fxConversion) {
			this.fxConversion = _fxConversion == null ? null : _fxConversion.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amountRelativeTo")
		@Override
		public Price.PriceBuilder setAmountRelativeTo(AmountReference _amountRelativeTo) {
			this.amountRelativeTo = _amountRelativeTo == null ? null : _amountRelativeTo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cleanNetPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cleanNetPrice")
		@Override
		public Price.PriceBuilder setCleanNetPrice(BigDecimal _cleanNetPrice) {
			this.cleanNetPrice = _cleanNetPrice == null ? null : _cleanNetPrice;
			return this;
		}
		
		@RosettaAttribute("quotationCharacteristics")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotationCharacteristics")
		@Override
		public Price.PriceBuilder setQuotationCharacteristics(QuotationCharacteristics _quotationCharacteristics) {
			this.quotationCharacteristics = _quotationCharacteristics == null ? null : _quotationCharacteristics.toBuilder();
			return this;
		}
		
		@Override
		public Price build() {
			return new Price.PriceImpl(this);
		}
		
		@Override
		public Price.PriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Price.PriceBuilder prune() {
			if (commission!=null && !commission.prune().hasData()) commission = null;
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (grossPrice!=null && !grossPrice.prune().hasData()) grossPrice = null;
			if (netPrice!=null && !netPrice.prune().hasData()) netPrice = null;
			if (fxConversion!=null && !fxConversion.prune().hasData()) fxConversion = null;
			if (amountRelativeTo!=null && !amountRelativeTo.prune().hasData()) amountRelativeTo = null;
			if (quotationCharacteristics!=null && !quotationCharacteristics.prune().hasData()) quotationCharacteristics = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommission()!=null && getCommission().hasData()) return true;
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getGrossPrice()!=null && getGrossPrice().hasData()) return true;
			if (getNetPrice()!=null && getNetPrice().hasData()) return true;
			if (getAccruedInterestPrice()!=null) return true;
			if (getFxConversion()!=null && getFxConversion().hasData()) return true;
			if (getAmountRelativeTo()!=null && getAmountRelativeTo().hasData()) return true;
			if (getCleanNetPrice()!=null) return true;
			if (getQuotationCharacteristics()!=null && getQuotationCharacteristics().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Price.PriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Price.PriceBuilder o = (Price.PriceBuilder) other;
			
			merger.mergeRosetta(getCommission(), o.getCommission(), this::setCommission);
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getGrossPrice(), o.getGrossPrice(), this::setGrossPrice);
			merger.mergeRosetta(getNetPrice(), o.getNetPrice(), this::setNetPrice);
			merger.mergeRosetta(getFxConversion(), o.getFxConversion(), this::setFxConversion);
			merger.mergeRosetta(getAmountRelativeTo(), o.getAmountRelativeTo(), this::setAmountRelativeTo);
			merger.mergeRosetta(getQuotationCharacteristics(), o.getQuotationCharacteristics(), this::setQuotationCharacteristics);
			
			merger.mergeBasic(getAccruedInterestPrice(), o.getAccruedInterestPrice(), this::setAccruedInterestPrice);
			merger.mergeBasic(getCleanNetPrice(), o.getCleanNetPrice(), this::setCleanNetPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Price _that = getType().cast(o);
		
			if (!Objects.equals(commission, _that.getCommission())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(grossPrice, _that.getGrossPrice())) return false;
			if (!Objects.equals(netPrice, _that.getNetPrice())) return false;
			if (!Objects.equals(accruedInterestPrice, _that.getAccruedInterestPrice())) return false;
			if (!Objects.equals(fxConversion, _that.getFxConversion())) return false;
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!Objects.equals(cleanNetPrice, _that.getCleanNetPrice())) return false;
			if (!Objects.equals(quotationCharacteristics, _that.getQuotationCharacteristics())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commission != null ? commission.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (grossPrice != null ? grossPrice.hashCode() : 0);
			_result = 31 * _result + (netPrice != null ? netPrice.hashCode() : 0);
			_result = 31 * _result + (accruedInterestPrice != null ? accruedInterestPrice.hashCode() : 0);
			_result = 31 * _result + (fxConversion != null ? fxConversion.hashCode() : 0);
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (cleanNetPrice != null ? cleanNetPrice.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristics != null ? quotationCharacteristics.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceBuilder {" +
				"commission=" + this.commission + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"grossPrice=" + this.grossPrice + ", " +
				"netPrice=" + this.netPrice + ", " +
				"accruedInterestPrice=" + this.accruedInterestPrice + ", " +
				"fxConversion=" + this.fxConversion + ", " +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"cleanNetPrice=" + this.cleanNetPrice + ", " +
				"quotationCharacteristics=" + this.quotationCharacteristics +
			'}';
		}
	}
}
