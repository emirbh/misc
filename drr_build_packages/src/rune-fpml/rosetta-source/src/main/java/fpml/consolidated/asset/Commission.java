package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.CommissionMeta;
import fpml.consolidated.fpmlenum.CommissionDenominationEnum;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxRate;
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
 * Provision A type describing the commission that will be charged for each of the hedge transactions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the commission that will be charged for each of the hedge transactions.
 *
 */
@RosettaDataType(value="Commission", builder=Commission.CommissionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Commission", model="fpml", builder=Commission.CommissionBuilderImpl.class, version="2.1.1")
public interface Commission extends RosettaModelObject {

	CommissionMeta metaData = new CommissionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of units used to express a commission.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of units used to express a commission.
	 *
	 */
	CommissionDenominationEnum getCommissionDenomination();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The commission amount, expressed in the way indicated by the commissionType element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The commission amount, expressed in the way indicated by the commissionType element.
	 *
	 */
	BigDecimal getCommissionAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The total commission per trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total commission per trade.
	 *
	 */
	BigDecimal getCommissionPerTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision FX Rates that have been used to convert commissions to a single currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision FX Rates that have been used to convert commissions to a single currency.
	 *
	 */
	List<? extends FxRate> getFxRate();

	/*********************** Build Methods  ***********************/
	Commission build();
	
	Commission.CommissionBuilder toBuilder();
	
	static Commission.CommissionBuilder builder() {
		return new Commission.CommissionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Commission> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Commission> getType() {
		return Commission.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("commissionDenomination"), CommissionDenominationEnum.class, getCommissionDenomination(), this);
		processor.processBasic(path.newSubPath("commissionAmount"), BigDecimal.class, getCommissionAmount(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("commissionPerTrade"), BigDecimal.class, getCommissionPerTrade(), this);
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommissionBuilder extends Commission, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		FxRate.FxRateBuilder getOrCreateFxRate(int index);
		@Override
		List<? extends FxRate.FxRateBuilder> getFxRate();
		Commission.CommissionBuilder setCommissionDenomination(CommissionDenominationEnum commissionDenomination);
		Commission.CommissionBuilder setCommissionAmount(BigDecimal commissionAmount);
		Commission.CommissionBuilder setCurrency(Currency currency);
		Commission.CommissionBuilder setCommissionPerTrade(BigDecimal commissionPerTrade);
		Commission.CommissionBuilder addFxRate(FxRate fxRate);
		Commission.CommissionBuilder addFxRate(FxRate fxRate, int idx);
		Commission.CommissionBuilder addFxRate(List<? extends FxRate> fxRate);
		Commission.CommissionBuilder setFxRate(List<? extends FxRate> fxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("commissionDenomination"), CommissionDenominationEnum.class, getCommissionDenomination(), this);
			processor.processBasic(path.newSubPath("commissionAmount"), BigDecimal.class, getCommissionAmount(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("commissionPerTrade"), BigDecimal.class, getCommissionPerTrade(), this);
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
		}
		

		Commission.CommissionBuilder prune();
	}

	/*********************** Immutable Implementation of Commission  ***********************/
	class CommissionImpl implements Commission {
		private final CommissionDenominationEnum commissionDenomination;
		private final BigDecimal commissionAmount;
		private final Currency currency;
		private final BigDecimal commissionPerTrade;
		private final List<? extends FxRate> fxRate;
		
		protected CommissionImpl(Commission.CommissionBuilder builder) {
			this.commissionDenomination = builder.getCommissionDenomination();
			this.commissionAmount = builder.getCommissionAmount();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.commissionPerTrade = builder.getCommissionPerTrade();
			this.fxRate = ofNullable(builder.getFxRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commissionDenomination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commissionDenomination")
		public CommissionDenominationEnum getCommissionDenomination() {
			return commissionDenomination;
		}
		
		@Override
		@RosettaAttribute("commissionAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commissionAmount")
		public BigDecimal getCommissionAmount() {
			return commissionAmount;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("commissionPerTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commissionPerTrade")
		public BigDecimal getCommissionPerTrade() {
			return commissionPerTrade;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxRate")
		public List<? extends FxRate> getFxRate() {
			return fxRate;
		}
		
		@Override
		public Commission build() {
			return this;
		}
		
		@Override
		public Commission.CommissionBuilder toBuilder() {
			Commission.CommissionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Commission.CommissionBuilder builder) {
			ofNullable(getCommissionDenomination()).ifPresent(builder::setCommissionDenomination);
			ofNullable(getCommissionAmount()).ifPresent(builder::setCommissionAmount);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getCommissionPerTrade()).ifPresent(builder::setCommissionPerTrade);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Commission _that = getType().cast(o);
		
			if (!Objects.equals(commissionDenomination, _that.getCommissionDenomination())) return false;
			if (!Objects.equals(commissionAmount, _that.getCommissionAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(commissionPerTrade, _that.getCommissionPerTrade())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commissionDenomination != null ? commissionDenomination.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commissionAmount != null ? commissionAmount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (commissionPerTrade != null ? commissionPerTrade.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Commission {" +
				"commissionDenomination=" + this.commissionDenomination + ", " +
				"commissionAmount=" + this.commissionAmount + ", " +
				"currency=" + this.currency + ", " +
				"commissionPerTrade=" + this.commissionPerTrade + ", " +
				"fxRate=" + this.fxRate +
			'}';
		}
	}

	/*********************** Builder Implementation of Commission  ***********************/
	class CommissionBuilderImpl implements Commission.CommissionBuilder {
	
		protected CommissionDenominationEnum commissionDenomination;
		protected BigDecimal commissionAmount;
		protected Currency.CurrencyBuilder currency;
		protected BigDecimal commissionPerTrade;
		protected List<FxRate.FxRateBuilder> fxRate = new ArrayList<>();
		
		@Override
		@RosettaAttribute("commissionDenomination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commissionDenomination")
		public CommissionDenominationEnum getCommissionDenomination() {
			return commissionDenomination;
		}
		
		@Override
		@RosettaAttribute("commissionAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commissionAmount")
		public BigDecimal getCommissionAmount() {
			return commissionAmount;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commissionPerTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commissionPerTrade")
		public BigDecimal getCommissionPerTrade() {
			return commissionPerTrade;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxRate")
		public List<? extends FxRate.FxRateBuilder> getFxRate() {
			return fxRate;
		}
		
		@Override
		public FxRate.FxRateBuilder getOrCreateFxRate(int index) {
			if (fxRate==null) {
				this.fxRate = new ArrayList<>();
			}
			return getIndex(fxRate, index, () -> {
						FxRate.FxRateBuilder newFxRate = FxRate.builder();
						return newFxRate;
					});
		}
		
		@RosettaAttribute("commissionDenomination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commissionDenomination")
		@Override
		public Commission.CommissionBuilder setCommissionDenomination(CommissionDenominationEnum _commissionDenomination) {
			this.commissionDenomination = _commissionDenomination == null ? null : _commissionDenomination;
			return this;
		}
		
		@RosettaAttribute("commissionAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commissionAmount")
		@Override
		public Commission.CommissionBuilder setCommissionAmount(BigDecimal _commissionAmount) {
			this.commissionAmount = _commissionAmount == null ? null : _commissionAmount;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Commission.CommissionBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commissionPerTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commissionPerTrade")
		@Override
		public Commission.CommissionBuilder setCommissionPerTrade(BigDecimal _commissionPerTrade) {
			this.commissionPerTrade = _commissionPerTrade == null ? null : _commissionPerTrade;
			return this;
		}
		
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fxRate")
		@Override
		public Commission.CommissionBuilder addFxRate(FxRate _fxRate) {
			if (_fxRate != null) {
				this.fxRate.add(_fxRate.toBuilder());
			}
			return this;
		}
		
		@Override
		public Commission.CommissionBuilder addFxRate(FxRate _fxRate, int idx) {
			getIndex(this.fxRate, idx, () -> _fxRate.toBuilder());
			return this;
		}
		
		@Override
		public Commission.CommissionBuilder addFxRate(List<? extends FxRate> fxRates) {
			if (fxRates != null) {
				for (final FxRate toAdd : fxRates) {
					this.fxRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fxRate")
		@Override
		public Commission.CommissionBuilder setFxRate(List<? extends FxRate> fxRates) {
			if (fxRates == null) {
				this.fxRate = new ArrayList<>();
			} else {
				this.fxRate = fxRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Commission build() {
			return new Commission.CommissionImpl(this);
		}
		
		@Override
		public Commission.CommissionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commission.CommissionBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			fxRate = fxRate.stream().filter(b->b!=null).<FxRate.FxRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommissionDenomination()!=null) return true;
			if (getCommissionAmount()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getCommissionPerTrade()!=null) return true;
			if (getFxRate()!=null && getFxRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commission.CommissionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Commission.CommissionBuilder o = (Commission.CommissionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::getOrCreateFxRate);
			
			merger.mergeBasic(getCommissionDenomination(), o.getCommissionDenomination(), this::setCommissionDenomination);
			merger.mergeBasic(getCommissionAmount(), o.getCommissionAmount(), this::setCommissionAmount);
			merger.mergeBasic(getCommissionPerTrade(), o.getCommissionPerTrade(), this::setCommissionPerTrade);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Commission _that = getType().cast(o);
		
			if (!Objects.equals(commissionDenomination, _that.getCommissionDenomination())) return false;
			if (!Objects.equals(commissionAmount, _that.getCommissionAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(commissionPerTrade, _that.getCommissionPerTrade())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commissionDenomination != null ? commissionDenomination.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commissionAmount != null ? commissionAmount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (commissionPerTrade != null ? commissionPerTrade.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommissionBuilder {" +
				"commissionDenomination=" + this.commissionDenomination + ", " +
				"commissionAmount=" + this.commissionAmount + ", " +
				"currency=" + this.currency + ", " +
				"commissionPerTrade=" + this.commissionPerTrade + ", " +
				"fxRate=" + this.fxRate +
			'}';
		}
	}
}
