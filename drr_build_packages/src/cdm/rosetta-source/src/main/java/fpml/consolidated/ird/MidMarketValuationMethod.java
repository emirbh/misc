package fpml.consolidated.ird;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.fpmlenum.CsaTypeEnum;
import fpml.consolidated.ird.meta.MidMarketValuationMethodMeta;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
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
 * Provision This type is a generic structure that can represent the fields of several mid-market valuation methods described in the 2021 ISDA Definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision This type is a generic structure that can represent the fields of several mid-market valuation methods described in the 2021 ISDA Definitions.
 *
 */
@RosettaDataType(value="MidMarketValuationMethod", builder=MidMarketValuationMethod.MidMarketValuationMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MidMarketValuationMethod", model="fpml", builder=MidMarketValuationMethod.MidMarketValuationMethodBuilderImpl.class, version="2.1.1")
public interface MidMarketValuationMethod extends RosettaModelObject {

	MidMarketValuationMethodMeta metaData = new MidMarketValuationMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency, or currencies, in which the cash settlement amount(s) will be calculated and settled. While the order in which the currencies are stated is unimportant, the cash settlement currency or currencies must correspond to one or both of the constituent currencies of the swap transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency, or currencies, in which the cash settlement amount(s) will be calculated and settled. While the order in which the currencies are stated is unimportant, the cash settlement currency or currencies must correspond to one or both of the constituent currencies of the swap transaction.
	 *
	 */
	List<? extends Currency> getCashSettlementCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to specify the type of CSA (credit support annex/agreement) to be used for cash settlement purposes.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to specify the type of CSA (credit support annex/agreement) to be used for cash settlement purposes.
	 *
	 */
	CsaTypeEnum getApplicableCsa();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A container for a set of reference institutions. These reference institutions may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A container for a set of reference institutions. These reference institutions may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
	 *
	 */
	CashSettlementReferenceBanks getCashSettlementReferenceBanks();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to indicate the currency of cash collateral for cash settlement purposes.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to indicate the currency of cash collateral for cash settlement purposes.
	 *
	 */
	Currency getCashCollateralCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to indicate the interest rate to be used for cash collateral for cash settlement purposes.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to indicate the interest rate to be used for cash collateral for cash settlement purposes.
	 *
	 */
	BenchmarkRate getCashCollateralInterestRate();
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
	MidMarketValuationMethod build();
	
	MidMarketValuationMethod.MidMarketValuationMethodBuilder toBuilder();
	
	static MidMarketValuationMethod.MidMarketValuationMethodBuilder builder() {
		return new MidMarketValuationMethod.MidMarketValuationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MidMarketValuationMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MidMarketValuationMethod> getType() {
		return MidMarketValuationMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.class, getCashSettlementCurrency());
		processor.processBasic(path.newSubPath("applicableCsa"), CsaTypeEnum.class, getApplicableCsa(), this);
		processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.class, getCashSettlementReferenceBanks());
		processRosetta(path.newSubPath("cashCollateralCurrency"), processor, Currency.class, getCashCollateralCurrency());
		processRosetta(path.newSubPath("cashCollateralInterestRate"), processor, BenchmarkRate.class, getCashCollateralInterestRate());
		processRosetta(path.newSubPath("agreedDiscountRate"), processor, BenchmarkRate.class, getAgreedDiscountRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MidMarketValuationMethodBuilder extends MidMarketValuationMethod, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCashSettlementCurrency(int index);
		@Override
		List<? extends Currency.CurrencyBuilder> getCashSettlementCurrency();
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getOrCreateCashSettlementReferenceBanks();
		@Override
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getCashSettlementReferenceBanks();
		Currency.CurrencyBuilder getOrCreateCashCollateralCurrency();
		@Override
		Currency.CurrencyBuilder getCashCollateralCurrency();
		BenchmarkRate.BenchmarkRateBuilder getOrCreateCashCollateralInterestRate();
		@Override
		BenchmarkRate.BenchmarkRateBuilder getCashCollateralInterestRate();
		BenchmarkRate.BenchmarkRateBuilder getOrCreateAgreedDiscountRate();
		@Override
		BenchmarkRate.BenchmarkRateBuilder getAgreedDiscountRate();
		MidMarketValuationMethod.MidMarketValuationMethodBuilder addCashSettlementCurrency(Currency cashSettlementCurrency);
		MidMarketValuationMethod.MidMarketValuationMethodBuilder addCashSettlementCurrency(Currency cashSettlementCurrency, int idx);
		MidMarketValuationMethod.MidMarketValuationMethodBuilder addCashSettlementCurrency(List<? extends Currency> cashSettlementCurrency);
		MidMarketValuationMethod.MidMarketValuationMethodBuilder setCashSettlementCurrency(List<? extends Currency> cashSettlementCurrency);
		MidMarketValuationMethod.MidMarketValuationMethodBuilder setApplicableCsa(CsaTypeEnum applicableCsa);
		MidMarketValuationMethod.MidMarketValuationMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks);
		MidMarketValuationMethod.MidMarketValuationMethodBuilder setCashCollateralCurrency(Currency cashCollateralCurrency);
		MidMarketValuationMethod.MidMarketValuationMethodBuilder setCashCollateralInterestRate(BenchmarkRate cashCollateralInterestRate);
		MidMarketValuationMethod.MidMarketValuationMethodBuilder setAgreedDiscountRate(BenchmarkRate agreedDiscountRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.CurrencyBuilder.class, getCashSettlementCurrency());
			processor.processBasic(path.newSubPath("applicableCsa"), CsaTypeEnum.class, getApplicableCsa(), this);
			processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder.class, getCashSettlementReferenceBanks());
			processRosetta(path.newSubPath("cashCollateralCurrency"), processor, Currency.CurrencyBuilder.class, getCashCollateralCurrency());
			processRosetta(path.newSubPath("cashCollateralInterestRate"), processor, BenchmarkRate.BenchmarkRateBuilder.class, getCashCollateralInterestRate());
			processRosetta(path.newSubPath("agreedDiscountRate"), processor, BenchmarkRate.BenchmarkRateBuilder.class, getAgreedDiscountRate());
		}
		

		MidMarketValuationMethod.MidMarketValuationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of MidMarketValuationMethod  ***********************/
	class MidMarketValuationMethodImpl implements MidMarketValuationMethod {
		private final List<? extends Currency> cashSettlementCurrency;
		private final CsaTypeEnum applicableCsa;
		private final CashSettlementReferenceBanks cashSettlementReferenceBanks;
		private final Currency cashCollateralCurrency;
		private final BenchmarkRate cashCollateralInterestRate;
		private final BenchmarkRate agreedDiscountRate;
		
		protected MidMarketValuationMethodImpl(MidMarketValuationMethod.MidMarketValuationMethodBuilder builder) {
			this.cashSettlementCurrency = ofNullable(builder.getCashSettlementCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.applicableCsa = builder.getApplicableCsa();
			this.cashSettlementReferenceBanks = ofNullable(builder.getCashSettlementReferenceBanks()).map(f->f.build()).orElse(null);
			this.cashCollateralCurrency = ofNullable(builder.getCashCollateralCurrency()).map(f->f.build()).orElse(null);
			this.cashCollateralInterestRate = ofNullable(builder.getCashCollateralInterestRate()).map(f->f.build()).orElse(null);
			this.agreedDiscountRate = ofNullable(builder.getAgreedDiscountRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cashSettlementCurrency")
		public List<? extends Currency> getCashSettlementCurrency() {
			return cashSettlementCurrency;
		}
		
		@Override
		@RosettaAttribute("applicableCsa")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableCsa")
		public CsaTypeEnum getApplicableCsa() {
			return applicableCsa;
		}
		
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementReferenceBanks")
		public CashSettlementReferenceBanks getCashSettlementReferenceBanks() {
			return cashSettlementReferenceBanks;
		}
		
		@Override
		@RosettaAttribute("cashCollateralCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashCollateralCurrency")
		public Currency getCashCollateralCurrency() {
			return cashCollateralCurrency;
		}
		
		@Override
		@RosettaAttribute("cashCollateralInterestRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashCollateralInterestRate")
		public BenchmarkRate getCashCollateralInterestRate() {
			return cashCollateralInterestRate;
		}
		
		@Override
		@RosettaAttribute("agreedDiscountRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreedDiscountRate")
		public BenchmarkRate getAgreedDiscountRate() {
			return agreedDiscountRate;
		}
		
		@Override
		public MidMarketValuationMethod build() {
			return this;
		}
		
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder toBuilder() {
			MidMarketValuationMethod.MidMarketValuationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MidMarketValuationMethod.MidMarketValuationMethodBuilder builder) {
			ofNullable(getCashSettlementCurrency()).ifPresent(builder::setCashSettlementCurrency);
			ofNullable(getApplicableCsa()).ifPresent(builder::setApplicableCsa);
			ofNullable(getCashSettlementReferenceBanks()).ifPresent(builder::setCashSettlementReferenceBanks);
			ofNullable(getCashCollateralCurrency()).ifPresent(builder::setCashCollateralCurrency);
			ofNullable(getCashCollateralInterestRate()).ifPresent(builder::setCashCollateralInterestRate);
			ofNullable(getAgreedDiscountRate()).ifPresent(builder::setAgreedDiscountRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MidMarketValuationMethod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
			if (!Objects.equals(applicableCsa, _that.getApplicableCsa())) return false;
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			if (!Objects.equals(cashCollateralCurrency, _that.getCashCollateralCurrency())) return false;
			if (!Objects.equals(cashCollateralInterestRate, _that.getCashCollateralInterestRate())) return false;
			if (!Objects.equals(agreedDiscountRate, _that.getAgreedDiscountRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementCurrency != null ? cashSettlementCurrency.hashCode() : 0);
			_result = 31 * _result + (applicableCsa != null ? applicableCsa.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlementReferenceBanks != null ? cashSettlementReferenceBanks.hashCode() : 0);
			_result = 31 * _result + (cashCollateralCurrency != null ? cashCollateralCurrency.hashCode() : 0);
			_result = 31 * _result + (cashCollateralInterestRate != null ? cashCollateralInterestRate.hashCode() : 0);
			_result = 31 * _result + (agreedDiscountRate != null ? agreedDiscountRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MidMarketValuationMethod {" +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"applicableCsa=" + this.applicableCsa + ", " +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks + ", " +
				"cashCollateralCurrency=" + this.cashCollateralCurrency + ", " +
				"cashCollateralInterestRate=" + this.cashCollateralInterestRate + ", " +
				"agreedDiscountRate=" + this.agreedDiscountRate +
			'}';
		}
	}

	/*********************** Builder Implementation of MidMarketValuationMethod  ***********************/
	class MidMarketValuationMethodBuilderImpl implements MidMarketValuationMethod.MidMarketValuationMethodBuilder {
	
		protected List<Currency.CurrencyBuilder> cashSettlementCurrency = new ArrayList<>();
		protected CsaTypeEnum applicableCsa;
		protected CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder cashSettlementReferenceBanks;
		protected Currency.CurrencyBuilder cashCollateralCurrency;
		protected BenchmarkRate.BenchmarkRateBuilder cashCollateralInterestRate;
		protected BenchmarkRate.BenchmarkRateBuilder agreedDiscountRate;
		
		@Override
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cashSettlementCurrency")
		public List<? extends Currency.CurrencyBuilder> getCashSettlementCurrency() {
			return cashSettlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCashSettlementCurrency(int index) {
			if (cashSettlementCurrency==null) {
				this.cashSettlementCurrency = new ArrayList<>();
			}
			return getIndex(cashSettlementCurrency, index, () -> {
						Currency.CurrencyBuilder newCashSettlementCurrency = Currency.builder();
						return newCashSettlementCurrency;
					});
		}
		
		@Override
		@RosettaAttribute("applicableCsa")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableCsa")
		public CsaTypeEnum getApplicableCsa() {
			return applicableCsa;
		}
		
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementReferenceBanks")
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getCashSettlementReferenceBanks() {
			return cashSettlementReferenceBanks;
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getOrCreateCashSettlementReferenceBanks() {
			CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder result;
			if (cashSettlementReferenceBanks!=null) {
				result = cashSettlementReferenceBanks;
			}
			else {
				result = cashSettlementReferenceBanks = CashSettlementReferenceBanks.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashCollateralCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashCollateralCurrency")
		public Currency.CurrencyBuilder getCashCollateralCurrency() {
			return cashCollateralCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCashCollateralCurrency() {
			Currency.CurrencyBuilder result;
			if (cashCollateralCurrency!=null) {
				result = cashCollateralCurrency;
			}
			else {
				result = cashCollateralCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashCollateralInterestRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashCollateralInterestRate")
		public BenchmarkRate.BenchmarkRateBuilder getCashCollateralInterestRate() {
			return cashCollateralInterestRate;
		}
		
		@Override
		public BenchmarkRate.BenchmarkRateBuilder getOrCreateCashCollateralInterestRate() {
			BenchmarkRate.BenchmarkRateBuilder result;
			if (cashCollateralInterestRate!=null) {
				result = cashCollateralInterestRate;
			}
			else {
				result = cashCollateralInterestRate = BenchmarkRate.builder();
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
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cashSettlementCurrency")
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder addCashSettlementCurrency(Currency _cashSettlementCurrency) {
			if (_cashSettlementCurrency != null) {
				this.cashSettlementCurrency.add(_cashSettlementCurrency.toBuilder());
			}
			return this;
		}
		
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder addCashSettlementCurrency(Currency _cashSettlementCurrency, int idx) {
			getIndex(this.cashSettlementCurrency, idx, () -> _cashSettlementCurrency.toBuilder());
			return this;
		}
		
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder addCashSettlementCurrency(List<? extends Currency> cashSettlementCurrencys) {
			if (cashSettlementCurrencys != null) {
				for (final Currency toAdd : cashSettlementCurrencys) {
					this.cashSettlementCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cashSettlementCurrency")
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder setCashSettlementCurrency(List<? extends Currency> cashSettlementCurrencys) {
			if (cashSettlementCurrencys == null) {
				this.cashSettlementCurrency = new ArrayList<>();
			} else {
				this.cashSettlementCurrency = cashSettlementCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("applicableCsa")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicableCsa")
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder setApplicableCsa(CsaTypeEnum _applicableCsa) {
			this.applicableCsa = _applicableCsa == null ? null : _applicableCsa;
			return this;
		}
		
		@RosettaAttribute("cashSettlementReferenceBanks")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementReferenceBanks")
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks _cashSettlementReferenceBanks) {
			this.cashSettlementReferenceBanks = _cashSettlementReferenceBanks == null ? null : _cashSettlementReferenceBanks.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashCollateralCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashCollateralCurrency")
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder setCashCollateralCurrency(Currency _cashCollateralCurrency) {
			this.cashCollateralCurrency = _cashCollateralCurrency == null ? null : _cashCollateralCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashCollateralInterestRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashCollateralInterestRate")
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder setCashCollateralInterestRate(BenchmarkRate _cashCollateralInterestRate) {
			this.cashCollateralInterestRate = _cashCollateralInterestRate == null ? null : _cashCollateralInterestRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreedDiscountRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreedDiscountRate")
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder setAgreedDiscountRate(BenchmarkRate _agreedDiscountRate) {
			this.agreedDiscountRate = _agreedDiscountRate == null ? null : _agreedDiscountRate.toBuilder();
			return this;
		}
		
		@Override
		public MidMarketValuationMethod build() {
			return new MidMarketValuationMethod.MidMarketValuationMethodImpl(this);
		}
		
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder prune() {
			cashSettlementCurrency = cashSettlementCurrency.stream().filter(b->b!=null).<Currency.CurrencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (cashSettlementReferenceBanks!=null && !cashSettlementReferenceBanks.prune().hasData()) cashSettlementReferenceBanks = null;
			if (cashCollateralCurrency!=null && !cashCollateralCurrency.prune().hasData()) cashCollateralCurrency = null;
			if (cashCollateralInterestRate!=null && !cashCollateralInterestRate.prune().hasData()) cashCollateralInterestRate = null;
			if (agreedDiscountRate!=null && !agreedDiscountRate.prune().hasData()) agreedDiscountRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementCurrency()!=null && getCashSettlementCurrency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getApplicableCsa()!=null) return true;
			if (getCashSettlementReferenceBanks()!=null && getCashSettlementReferenceBanks().hasData()) return true;
			if (getCashCollateralCurrency()!=null && getCashCollateralCurrency().hasData()) return true;
			if (getCashCollateralInterestRate()!=null && getCashCollateralInterestRate().hasData()) return true;
			if (getAgreedDiscountRate()!=null && getAgreedDiscountRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MidMarketValuationMethod.MidMarketValuationMethodBuilder o = (MidMarketValuationMethod.MidMarketValuationMethodBuilder) other;
			
			merger.mergeRosetta(getCashSettlementCurrency(), o.getCashSettlementCurrency(), this::getOrCreateCashSettlementCurrency);
			merger.mergeRosetta(getCashSettlementReferenceBanks(), o.getCashSettlementReferenceBanks(), this::setCashSettlementReferenceBanks);
			merger.mergeRosetta(getCashCollateralCurrency(), o.getCashCollateralCurrency(), this::setCashCollateralCurrency);
			merger.mergeRosetta(getCashCollateralInterestRate(), o.getCashCollateralInterestRate(), this::setCashCollateralInterestRate);
			merger.mergeRosetta(getAgreedDiscountRate(), o.getAgreedDiscountRate(), this::setAgreedDiscountRate);
			
			merger.mergeBasic(getApplicableCsa(), o.getApplicableCsa(), this::setApplicableCsa);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MidMarketValuationMethod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
			if (!Objects.equals(applicableCsa, _that.getApplicableCsa())) return false;
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			if (!Objects.equals(cashCollateralCurrency, _that.getCashCollateralCurrency())) return false;
			if (!Objects.equals(cashCollateralInterestRate, _that.getCashCollateralInterestRate())) return false;
			if (!Objects.equals(agreedDiscountRate, _that.getAgreedDiscountRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementCurrency != null ? cashSettlementCurrency.hashCode() : 0);
			_result = 31 * _result + (applicableCsa != null ? applicableCsa.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlementReferenceBanks != null ? cashSettlementReferenceBanks.hashCode() : 0);
			_result = 31 * _result + (cashCollateralCurrency != null ? cashCollateralCurrency.hashCode() : 0);
			_result = 31 * _result + (cashCollateralInterestRate != null ? cashCollateralInterestRate.hashCode() : 0);
			_result = 31 * _result + (agreedDiscountRate != null ? agreedDiscountRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MidMarketValuationMethodBuilder {" +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"applicableCsa=" + this.applicableCsa + ", " +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks + ", " +
				"cashCollateralCurrency=" + this.cashCollateralCurrency + ", " +
				"cashCollateralInterestRate=" + this.cashCollateralInterestRate + ", " +
				"agreedDiscountRate=" + this.agreedDiscountRate +
			'}';
		}
	}
}
