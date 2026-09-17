package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Qualify_EquityForward_PriceReturnBasicPerformance_SingleName.Qualify_EquityForward_PriceReturnBasicPerformance_SingleNameDefault.class)
public abstract class Qualify_EquityForward_PriceReturnBasicPerformance_SingleName implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
	@Inject protected SettlementPayoutOnlyExists settlementPayoutOnlyExists;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	@Override
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_product = doEvaluate(economicTerms);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	public static class Qualify_EquityForward_PriceReturnBasicPerformance_SingleNameDefault extends Qualify_EquityForward_PriceReturnBasicPerformance_SingleName {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = areEqual(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(settlementPayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti())))).andNullSafe(exists(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()))).get();
			
			return is_product;
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
