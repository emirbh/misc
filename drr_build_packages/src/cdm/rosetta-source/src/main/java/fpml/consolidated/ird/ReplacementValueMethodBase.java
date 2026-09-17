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
import fpml.consolidated.ird.meta.ReplacementValueMethodBaseMeta;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision This type is a generic base type holding shared data fields several different replacement value cash settlement methods described in the 2021 ISDA Definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision This type is a generic base type holding shared data fields several different replacement value cash settlement methods described in the 2021 ISDA Definitions.
 *
 */
@RosettaDataType(value="ReplacementValueMethodBase", builder=ReplacementValueMethodBase.ReplacementValueMethodBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReplacementValueMethodBase", model="fpml", builder=ReplacementValueMethodBase.ReplacementValueMethodBaseBuilderImpl.class, version="2.1.1")
public interface ReplacementValueMethodBase extends RosettaModelObject {

	ReplacementValueMethodBaseMeta metaData = new ReplacementValueMethodBaseMeta();

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
	Currency getCashSettlementCurrency();
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
	 * Provision This may be used to specify which party is protected (e.g. under Replacement Value cash settlement methods).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to specify which party is protected (e.g. under Replacement Value cash settlement methods).
	 *
	 */
	PartySelector getProtectedParty();
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

	/*********************** Build Methods  ***********************/
	ReplacementValueMethodBase build();
	
	ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder toBuilder();
	
	static ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder builder() {
		return new ReplacementValueMethodBase.ReplacementValueMethodBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReplacementValueMethodBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReplacementValueMethodBase> getType() {
		return ReplacementValueMethodBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.class, getCashSettlementCurrency());
		processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.class, getCashSettlementReferenceBanks());
		processRosetta(path.newSubPath("protectedParty"), processor, PartySelector.class, getProtectedParty());
		processRosetta(path.newSubPath("cashCollateralCurrency"), processor, Currency.class, getCashCollateralCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReplacementValueMethodBaseBuilder extends ReplacementValueMethodBase, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCashSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getCashSettlementCurrency();
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getOrCreateCashSettlementReferenceBanks();
		@Override
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getCashSettlementReferenceBanks();
		PartySelector.PartySelectorBuilder getOrCreateProtectedParty();
		@Override
		PartySelector.PartySelectorBuilder getProtectedParty();
		Currency.CurrencyBuilder getOrCreateCashCollateralCurrency();
		@Override
		Currency.CurrencyBuilder getCashCollateralCurrency();
		ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder setCashSettlementCurrency(Currency cashSettlementCurrency);
		ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks);
		ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder setProtectedParty(PartySelector protectedParty);
		ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder setCashCollateralCurrency(Currency cashCollateralCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.CurrencyBuilder.class, getCashSettlementCurrency());
			processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder.class, getCashSettlementReferenceBanks());
			processRosetta(path.newSubPath("protectedParty"), processor, PartySelector.PartySelectorBuilder.class, getProtectedParty());
			processRosetta(path.newSubPath("cashCollateralCurrency"), processor, Currency.CurrencyBuilder.class, getCashCollateralCurrency());
		}
		

		ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder prune();
	}

	/*********************** Immutable Implementation of ReplacementValueMethodBase  ***********************/
	class ReplacementValueMethodBaseImpl implements ReplacementValueMethodBase {
		private final Currency cashSettlementCurrency;
		private final CashSettlementReferenceBanks cashSettlementReferenceBanks;
		private final PartySelector protectedParty;
		private final Currency cashCollateralCurrency;
		
		protected ReplacementValueMethodBaseImpl(ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder builder) {
			this.cashSettlementCurrency = ofNullable(builder.getCashSettlementCurrency()).map(f->f.build()).orElse(null);
			this.cashSettlementReferenceBanks = ofNullable(builder.getCashSettlementReferenceBanks()).map(f->f.build()).orElse(null);
			this.protectedParty = ofNullable(builder.getProtectedParty()).map(f->f.build()).orElse(null);
			this.cashCollateralCurrency = ofNullable(builder.getCashCollateralCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementCurrency")
		public Currency getCashSettlementCurrency() {
			return cashSettlementCurrency;
		}
		
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementReferenceBanks")
		public CashSettlementReferenceBanks getCashSettlementReferenceBanks() {
			return cashSettlementReferenceBanks;
		}
		
		@Override
		@RosettaAttribute("protectedParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("protectedParty")
		public PartySelector getProtectedParty() {
			return protectedParty;
		}
		
		@Override
		@RosettaAttribute("cashCollateralCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashCollateralCurrency")
		public Currency getCashCollateralCurrency() {
			return cashCollateralCurrency;
		}
		
		@Override
		public ReplacementValueMethodBase build() {
			return this;
		}
		
		@Override
		public ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder toBuilder() {
			ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder builder) {
			ofNullable(getCashSettlementCurrency()).ifPresent(builder::setCashSettlementCurrency);
			ofNullable(getCashSettlementReferenceBanks()).ifPresent(builder::setCashSettlementReferenceBanks);
			ofNullable(getProtectedParty()).ifPresent(builder::setProtectedParty);
			ofNullable(getCashCollateralCurrency()).ifPresent(builder::setCashCollateralCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReplacementValueMethodBase _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			if (!Objects.equals(protectedParty, _that.getProtectedParty())) return false;
			if (!Objects.equals(cashCollateralCurrency, _that.getCashCollateralCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementCurrency != null ? cashSettlementCurrency.hashCode() : 0);
			_result = 31 * _result + (cashSettlementReferenceBanks != null ? cashSettlementReferenceBanks.hashCode() : 0);
			_result = 31 * _result + (protectedParty != null ? protectedParty.hashCode() : 0);
			_result = 31 * _result + (cashCollateralCurrency != null ? cashCollateralCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReplacementValueMethodBase {" +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks + ", " +
				"protectedParty=" + this.protectedParty + ", " +
				"cashCollateralCurrency=" + this.cashCollateralCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of ReplacementValueMethodBase  ***********************/
	class ReplacementValueMethodBaseBuilderImpl implements ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder {
	
		protected Currency.CurrencyBuilder cashSettlementCurrency;
		protected CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder cashSettlementReferenceBanks;
		protected PartySelector.PartySelectorBuilder protectedParty;
		protected Currency.CurrencyBuilder cashCollateralCurrency;
		
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
		@RosettaAttribute("protectedParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("protectedParty")
		public PartySelector.PartySelectorBuilder getProtectedParty() {
			return protectedParty;
		}
		
		@Override
		public PartySelector.PartySelectorBuilder getOrCreateProtectedParty() {
			PartySelector.PartySelectorBuilder result;
			if (protectedParty!=null) {
				result = protectedParty;
			}
			else {
				result = protectedParty = PartySelector.builder();
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
		
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementCurrency")
		@Override
		public ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder setCashSettlementCurrency(Currency _cashSettlementCurrency) {
			this.cashSettlementCurrency = _cashSettlementCurrency == null ? null : _cashSettlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlementReferenceBanks")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementReferenceBanks")
		@Override
		public ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks _cashSettlementReferenceBanks) {
			this.cashSettlementReferenceBanks = _cashSettlementReferenceBanks == null ? null : _cashSettlementReferenceBanks.toBuilder();
			return this;
		}
		
		@RosettaAttribute("protectedParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("protectedParty")
		@Override
		public ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder setProtectedParty(PartySelector _protectedParty) {
			this.protectedParty = _protectedParty == null ? null : _protectedParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashCollateralCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashCollateralCurrency")
		@Override
		public ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder setCashCollateralCurrency(Currency _cashCollateralCurrency) {
			this.cashCollateralCurrency = _cashCollateralCurrency == null ? null : _cashCollateralCurrency.toBuilder();
			return this;
		}
		
		@Override
		public ReplacementValueMethodBase build() {
			return new ReplacementValueMethodBase.ReplacementValueMethodBaseImpl(this);
		}
		
		@Override
		public ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder prune() {
			if (cashSettlementCurrency!=null && !cashSettlementCurrency.prune().hasData()) cashSettlementCurrency = null;
			if (cashSettlementReferenceBanks!=null && !cashSettlementReferenceBanks.prune().hasData()) cashSettlementReferenceBanks = null;
			if (protectedParty!=null && !protectedParty.prune().hasData()) protectedParty = null;
			if (cashCollateralCurrency!=null && !cashCollateralCurrency.prune().hasData()) cashCollateralCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementCurrency()!=null && getCashSettlementCurrency().hasData()) return true;
			if (getCashSettlementReferenceBanks()!=null && getCashSettlementReferenceBanks().hasData()) return true;
			if (getProtectedParty()!=null && getProtectedParty().hasData()) return true;
			if (getCashCollateralCurrency()!=null && getCashCollateralCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder o = (ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder) other;
			
			merger.mergeRosetta(getCashSettlementCurrency(), o.getCashSettlementCurrency(), this::setCashSettlementCurrency);
			merger.mergeRosetta(getCashSettlementReferenceBanks(), o.getCashSettlementReferenceBanks(), this::setCashSettlementReferenceBanks);
			merger.mergeRosetta(getProtectedParty(), o.getProtectedParty(), this::setProtectedParty);
			merger.mergeRosetta(getCashCollateralCurrency(), o.getCashCollateralCurrency(), this::setCashCollateralCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReplacementValueMethodBase _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementCurrency, _that.getCashSettlementCurrency())) return false;
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			if (!Objects.equals(protectedParty, _that.getProtectedParty())) return false;
			if (!Objects.equals(cashCollateralCurrency, _that.getCashCollateralCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementCurrency != null ? cashSettlementCurrency.hashCode() : 0);
			_result = 31 * _result + (cashSettlementReferenceBanks != null ? cashSettlementReferenceBanks.hashCode() : 0);
			_result = 31 * _result + (protectedParty != null ? protectedParty.hashCode() : 0);
			_result = 31 * _result + (cashCollateralCurrency != null ? cashCollateralCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReplacementValueMethodBaseBuilder {" +
				"cashSettlementCurrency=" + this.cashSettlementCurrency + ", " +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks + ", " +
				"protectedParty=" + this.protectedParty + ", " +
				"cashCollateralCurrency=" + this.cashCollateralCurrency +
			'}';
		}
	}
}
