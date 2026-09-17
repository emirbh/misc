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
import fpml.consolidated.ird.meta.ReplacementValueCalculationAgentDeterminationMethodMeta;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision This type is a specific type holding the data fields for the replacement value calculation agent determination cash settlement method described in the 2021 ISDA Definitions, section 18.2.5.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision This type is a specific type holding the data fields for the replacement value calculation agent determination cash settlement method described in the 2021 ISDA Definitions, section 18.2.5.
 *
 */
@RosettaDataType(value="ReplacementValueCalculationAgentDeterminationMethod", builder=ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReplacementValueCalculationAgentDeterminationMethod", model="fpml", builder=ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilderImpl.class, version="2.1.1")
public interface ReplacementValueCalculationAgentDeterminationMethod extends ReplacementValueMethodBase {

	ReplacementValueCalculationAgentDeterminationMethodMeta metaData = new ReplacementValueCalculationAgentDeterminationMethodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ReplacementValueCalculationAgentDeterminationMethod build();
	
	ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder toBuilder();
	
	static ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder builder() {
		return new ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReplacementValueCalculationAgentDeterminationMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReplacementValueCalculationAgentDeterminationMethod> getType() {
		return ReplacementValueCalculationAgentDeterminationMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.class, getCashSettlementCurrency());
		processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.class, getCashSettlementReferenceBanks());
		processRosetta(path.newSubPath("protectedParty"), processor, PartySelector.class, getProtectedParty());
		processRosetta(path.newSubPath("cashCollateralCurrency"), processor, Currency.class, getCashCollateralCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReplacementValueCalculationAgentDeterminationMethodBuilder extends ReplacementValueCalculationAgentDeterminationMethod, ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder {
		@Override
		ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder setCashSettlementCurrency(Currency cashSettlementCurrency);
		@Override
		ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks);
		@Override
		ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder setProtectedParty(PartySelector protectedParty);
		@Override
		ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder setCashCollateralCurrency(Currency cashCollateralCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.CurrencyBuilder.class, getCashSettlementCurrency());
			processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder.class, getCashSettlementReferenceBanks());
			processRosetta(path.newSubPath("protectedParty"), processor, PartySelector.PartySelectorBuilder.class, getProtectedParty());
			processRosetta(path.newSubPath("cashCollateralCurrency"), processor, Currency.CurrencyBuilder.class, getCashCollateralCurrency());
		}
		

		ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of ReplacementValueCalculationAgentDeterminationMethod  ***********************/
	class ReplacementValueCalculationAgentDeterminationMethodImpl extends ReplacementValueMethodBase.ReplacementValueMethodBaseImpl implements ReplacementValueCalculationAgentDeterminationMethod {
		
		protected ReplacementValueCalculationAgentDeterminationMethodImpl(ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder builder) {
			super(builder);
		}
		
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod build() {
			return this;
		}
		
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder toBuilder() {
			ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReplacementValueCalculationAgentDeterminationMethod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReplacementValueCalculationAgentDeterminationMethod  ***********************/
	class ReplacementValueCalculationAgentDeterminationMethodBuilderImpl extends ReplacementValueMethodBase.ReplacementValueMethodBaseBuilderImpl implements ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder {
	
		
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementCurrency")
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder setCashSettlementCurrency(Currency _cashSettlementCurrency) {
			this.cashSettlementCurrency = _cashSettlementCurrency == null ? null : _cashSettlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlementReferenceBanks")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementReferenceBanks")
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks _cashSettlementReferenceBanks) {
			this.cashSettlementReferenceBanks = _cashSettlementReferenceBanks == null ? null : _cashSettlementReferenceBanks.toBuilder();
			return this;
		}
		
		@RosettaAttribute("protectedParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("protectedParty")
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder setProtectedParty(PartySelector _protectedParty) {
			this.protectedParty = _protectedParty == null ? null : _protectedParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashCollateralCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashCollateralCurrency")
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder setCashCollateralCurrency(Currency _cashCollateralCurrency) {
			this.cashCollateralCurrency = _cashCollateralCurrency == null ? null : _cashCollateralCurrency.toBuilder();
			return this;
		}
		
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod build() {
			return new ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodImpl(this);
		}
		
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder o = (ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReplacementValueCalculationAgentDeterminationMethodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
