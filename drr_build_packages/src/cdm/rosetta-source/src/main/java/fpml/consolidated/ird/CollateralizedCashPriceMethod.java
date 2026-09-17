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
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.ird.meta.CollateralizedCashPriceMethodMeta;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.MutuallyAgreedClearinghouse;
import fpml.consolidated.shared.SettlementRateSource;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the parameters required for each of the ISDA defined yield curve methods for cash settlement. See the 2021 ISDA Definitions, section 18.2.6.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the parameters required for each of the ISDA defined yield curve methods for cash settlement. See the 2021 ISDA Definitions, section 18.2.6.
 *
 */
@RosettaDataType(value="CollateralizedCashPriceMethod", builder=CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralizedCashPriceMethod", model="fpml", builder=CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilderImpl.class, version="2.1.1")
public interface CollateralizedCashPriceMethod extends RosettaModelObject {

	CollateralizedCashPriceMethodMeta metaData = new CollateralizedCashPriceMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency or currencies in which the cash settlement amount will be calculated and settled. (2 Currencies are supported for cross-currency settlement methods.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency or currencies in which the cash settlement amount will be calculated and settled. (2 Currencies are supported for cross-currency settlement methods.)
	 *
	 */
	Currency getCashSettlementCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method for obtaining a settlement rate. This may be from some information source (e.g. Reuters) or from a set of reference banks.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method for obtaining a settlement rate. This may be from some information source (e.g. Reuters) or from a set of reference banks.
	 *
	 */
	SettlementRateSource getSettlementRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Which rate quote is to be observed, either Bid, Mid, Offer or Exercising Party Pays. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Which rate quote is to be observed, either Bid, Mid, Offer or Exercising Party Pays. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j)
	 *
	 */
	QuotationRateTypeEnum getQuotationRateType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to specify a "mutually-agreed clearinghouse" for settlement. This is only applicable for cash-settled swaptions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to specify a "mutually-agreed clearinghouse" for settlement. This is only applicable for cash-settled swaptions.
	 *
	 */
	MutuallyAgreedClearinghouse getMutuallyAgreedClearinghouse();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to indicate the discount rate to be used for cash collateral for cash settlement purposes.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to indicate the discount rate to be used for cash collateral for cash settlement purposes.
	 *
	 */
	BenchmarkRate getAgreedDiscountRate();

	/*********************** Build Methods  ***********************/
	CollateralizedCashPriceMethod build();
	
	CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder toBuilder();
	
	static CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder builder() {
		return new CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralizedCashPriceMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralizedCashPriceMethod> getType() {
		return CollateralizedCashPriceMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.class, getCashSettlementCurrency());
		processRosetta(path.newSubPath("settlementRateSource"), processor, SettlementRateSource.class, getSettlementRateSource());
		processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
		processRosetta(path.newSubPath("mutuallyAgreedClearinghouse"), processor, MutuallyAgreedClearinghouse.class, getMutuallyAgreedClearinghouse());
		processRosetta(path.newSubPath("agreedDiscountRate"), processor, BenchmarkRate.class, getAgreedDiscountRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralizedCashPriceMethodBuilder extends CollateralizedCashPriceMethod, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCashSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getCashSettlementCurrency();
		SettlementRateSource.SettlementRateSourceBuilder getOrCreateSettlementRateSource();
		@Override
		SettlementRateSource.SettlementRateSourceBuilder getSettlementRateSource();
		MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder getOrCreateMutuallyAgreedClearinghouse();
		@Override
		MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder getMutuallyAgreedClearinghouse();
		BenchmarkRate.BenchmarkRateBuilder getOrCreateAgreedDiscountRate();
		@Override
		BenchmarkRate.BenchmarkRateBuilder getAgreedDiscountRate();
		CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setCashSettlementCurrency(Currency cashSettlementCurrency);
		CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setSettlementRateSource(SettlementRateSource settlementRateSource);
		CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setQuotationRateType(QuotationRateTypeEnum quotationRateType);
		CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setMutuallyAgreedClearinghouse(MutuallyAgreedClearinghouse mutuallyAgreedClearinghouse);
		CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setAgreedDiscountRate(BenchmarkRate agreedDiscountRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.CurrencyBuilder.class, getCashSettlementCurrency());
			processRosetta(path.newSubPath("settlementRateSource"), processor, SettlementRateSource.SettlementRateSourceBuilder.class, getSettlementRateSource());
			processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
			processRosetta(path.newSubPath("mutuallyAgreedClearinghouse"), processor, MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder.class, getMutuallyAgreedClearinghouse());
			processRosetta(path.newSubPath("agreedDiscountRate"), processor, BenchmarkRate.BenchmarkRateBuilder.class, getAgreedDiscountRate());
		}
		

		CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralizedCashPriceMethod  ***********************/
	class CollateralizedCashPriceMethodImpl implements CollateralizedCashPriceMethod {
		private final Currency cashSettlementCurrency;
		private final SettlementRateSource settlementRateSource;
		private final QuotationRateTypeEnum quotationRateType;
		private final MutuallyAgreedClearinghouse mutuallyAgreedClearinghouse;
		private final BenchmarkRate agreedDiscountRate;
		
		protected CollateralizedCashPriceMethodImpl(CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder builder) {
			this.cashSettlementCurrency = ofNullable(builder.getCashSettlementCurrency()).map(f->f.build()).orElse(null);
			this.settlementRateSource = ofNullable(builder.getSettlementRateSource()).map(f->f.build()).orElse(null);
			this.quotationRateType = builder.getQuotationRateType();
			this.mutuallyAgreedClearinghouse = ofNullable(builder.getMutuallyAgreedClearinghouse()).map(f->f.build()).orElse(null);
			this.agreedDiscountRate = ofNullable(builder.getAgreedDiscountRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementCurrency")
		public Currency getCashSettlementCurrency() {
			return cashSettlementCurrency;
		}
		
		@Override
		@RosettaAttribute("settlementRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateSource")
		public SettlementRateSource getSettlementRateSource() {
			return settlementRateSource;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@Override
		@RosettaAttribute("mutuallyAgreedClearinghouse")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mutuallyAgreedClearinghouse")
		public MutuallyAgreedClearinghouse getMutuallyAgreedClearinghouse() {
			return mutuallyAgreedClearinghouse;
		}
		
		@Override
		@RosettaAttribute("agreedDiscountRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreedDiscountRate")
		public BenchmarkRate getAgreedDiscountRate() {
			return agreedDiscountRate;
		}
		
		@Override
		public CollateralizedCashPriceMethod build() {
			return this;
		}
		
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder toBuilder() {
			CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder builder) {
			ofNullable(getCashSettlementCurrency()).ifPresent(builder::setCashSettlementCurrency);
			ofNullable(getSettlementRateSource()).ifPresent(builder::setSettlementRateSource);
			ofNullable(getQuotationRateType()).ifPresent(builder::setQuotationRateType);
			ofNullable(getMutuallyAgreedClearinghouse()).ifPresent(builder::setMutuallyAgreedClearinghouse);
			ofNullable(getAgreedDiscountRate()).ifPresent(builder::setAgreedDiscountRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralizedCashPriceMethod _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
			if (!Objects.equals(settlementRateSource, _that.getSettlementRateSource())) return false;
			if (!Objects.equals(quotationRateType, _that.getQuotationRateType())) return false;
			if (!Objects.equals(mutuallyAgreedClearinghouse, _that.getMutuallyAgreedClearinghouse())) return false;
			if (!Objects.equals(agreedDiscountRate, _that.getAgreedDiscountRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementCurrency != null ? cashSettlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementRateSource != null ? settlementRateSource.hashCode() : 0);
			_result = 31 * _result + (quotationRateType != null ? quotationRateType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (mutuallyAgreedClearinghouse != null ? mutuallyAgreedClearinghouse.hashCode() : 0);
			_result = 31 * _result + (agreedDiscountRate != null ? agreedDiscountRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralizedCashPriceMethod {" +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"settlementRateSource=" + this.settlementRateSource + ", " +
				"quotationRateType=" + this.quotationRateType + ", " +
				"mutuallyAgreedClearinghouse=" + this.mutuallyAgreedClearinghouse + ", " +
				"agreedDiscountRate=" + this.agreedDiscountRate +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralizedCashPriceMethod  ***********************/
	class CollateralizedCashPriceMethodBuilderImpl implements CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder {
	
		protected Currency.CurrencyBuilder cashSettlementCurrency;
		protected SettlementRateSource.SettlementRateSourceBuilder settlementRateSource;
		protected QuotationRateTypeEnum quotationRateType;
		protected MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder mutuallyAgreedClearinghouse;
		protected BenchmarkRate.BenchmarkRateBuilder agreedDiscountRate;
		
		@Override
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementCurrency")
		public Currency.CurrencyBuilder getCashSettlementCurrency() {
			return cashSettlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCashSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (cashSettlementCurrency!=null) {
				result = cashSettlementCurrency;
			}
			else {
				result = cashSettlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateSource")
		public SettlementRateSource.SettlementRateSourceBuilder getSettlementRateSource() {
			return settlementRateSource;
		}
		
		@Override
		public SettlementRateSource.SettlementRateSourceBuilder getOrCreateSettlementRateSource() {
			SettlementRateSource.SettlementRateSourceBuilder result;
			if (settlementRateSource!=null) {
				result = settlementRateSource;
			}
			else {
				result = settlementRateSource = SettlementRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@Override
		@RosettaAttribute("mutuallyAgreedClearinghouse")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mutuallyAgreedClearinghouse")
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder getMutuallyAgreedClearinghouse() {
			return mutuallyAgreedClearinghouse;
		}
		
		@Override
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder getOrCreateMutuallyAgreedClearinghouse() {
			MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder result;
			if (mutuallyAgreedClearinghouse!=null) {
				result = mutuallyAgreedClearinghouse;
			}
			else {
				result = mutuallyAgreedClearinghouse = MutuallyAgreedClearinghouse.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("agreedDiscountRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreedDiscountRate")
		public BenchmarkRate.BenchmarkRateBuilder getAgreedDiscountRate() {
			return agreedDiscountRate;
		}
		
		@Override
		public BenchmarkRate.BenchmarkRateBuilder getOrCreateAgreedDiscountRate() {
			BenchmarkRate.BenchmarkRateBuilder result;
			if (agreedDiscountRate!=null) {
				result = agreedDiscountRate;
			}
			else {
				result = agreedDiscountRate = BenchmarkRate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementCurrency")
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setCashSettlementCurrency(Currency _cashSettlementCurrency) {
			this.cashSettlementCurrency = _cashSettlementCurrency == null ? null : _cashSettlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementRateSource")
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setSettlementRateSource(SettlementRateSource _settlementRateSource) {
			this.settlementRateSource = _settlementRateSource == null ? null : _settlementRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotationRateType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotationRateType")
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setQuotationRateType(QuotationRateTypeEnum _quotationRateType) {
			this.quotationRateType = _quotationRateType == null ? null : _quotationRateType;
			return this;
		}
		
		@RosettaAttribute("mutuallyAgreedClearinghouse")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mutuallyAgreedClearinghouse")
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setMutuallyAgreedClearinghouse(MutuallyAgreedClearinghouse _mutuallyAgreedClearinghouse) {
			this.mutuallyAgreedClearinghouse = _mutuallyAgreedClearinghouse == null ? null : _mutuallyAgreedClearinghouse.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreedDiscountRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreedDiscountRate")
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder setAgreedDiscountRate(BenchmarkRate _agreedDiscountRate) {
			this.agreedDiscountRate = _agreedDiscountRate == null ? null : _agreedDiscountRate.toBuilder();
			return this;
		}
		
		@Override
		public CollateralizedCashPriceMethod build() {
			return new CollateralizedCashPriceMethod.CollateralizedCashPriceMethodImpl(this);
		}
		
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder prune() {
			if (cashSettlementCurrency!=null && !cashSettlementCurrency.prune().hasData()) cashSettlementCurrency = null;
			if (settlementRateSource!=null && !settlementRateSource.prune().hasData()) settlementRateSource = null;
			if (mutuallyAgreedClearinghouse!=null && !mutuallyAgreedClearinghouse.prune().hasData()) mutuallyAgreedClearinghouse = null;
			if (agreedDiscountRate!=null && !agreedDiscountRate.prune().hasData()) agreedDiscountRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementCurrency()!=null && getCashSettlementCurrency().hasData()) return true;
			if (getSettlementRateSource()!=null && getSettlementRateSource().hasData()) return true;
			if (getQuotationRateType()!=null) return true;
			if (getMutuallyAgreedClearinghouse()!=null && getMutuallyAgreedClearinghouse().hasData()) return true;
			if (getAgreedDiscountRate()!=null && getAgreedDiscountRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder o = (CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder) other;
			
			merger.mergeRosetta(getCashSettlementCurrency(), o.getCashSettlementCurrency(), this::setCashSettlementCurrency);
			merger.mergeRosetta(getSettlementRateSource(), o.getSettlementRateSource(), this::setSettlementRateSource);
			merger.mergeRosetta(getMutuallyAgreedClearinghouse(), o.getMutuallyAgreedClearinghouse(), this::setMutuallyAgreedClearinghouse);
			merger.mergeRosetta(getAgreedDiscountRate(), o.getAgreedDiscountRate(), this::setAgreedDiscountRate);
			
			merger.mergeBasic(getQuotationRateType(), o.getQuotationRateType(), this::setQuotationRateType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralizedCashPriceMethod _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
			if (!Objects.equals(settlementRateSource, _that.getSettlementRateSource())) return false;
			if (!Objects.equals(quotationRateType, _that.getQuotationRateType())) return false;
			if (!Objects.equals(mutuallyAgreedClearinghouse, _that.getMutuallyAgreedClearinghouse())) return false;
			if (!Objects.equals(agreedDiscountRate, _that.getAgreedDiscountRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementCurrency != null ? cashSettlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementRateSource != null ? settlementRateSource.hashCode() : 0);
			_result = 31 * _result + (quotationRateType != null ? quotationRateType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (mutuallyAgreedClearinghouse != null ? mutuallyAgreedClearinghouse.hashCode() : 0);
			_result = 31 * _result + (agreedDiscountRate != null ? agreedDiscountRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralizedCashPriceMethodBuilder {" +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"settlementRateSource=" + this.settlementRateSource + ", " +
				"quotationRateType=" + this.quotationRateType + ", " +
				"mutuallyAgreedClearinghouse=" + this.mutuallyAgreedClearinghouse + ", " +
				"agreedDiscountRate=" + this.agreedDiscountRate +
			'}';
		}
	}
}
