package drr.standards.iosco.cde.version1.collateral.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.CollateralBalance;
import cdm.product.collateral.CollateralMarginTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.margin.ReportableCollateralBase;
import drr.base.margin.functions.GetCollateralBalancesForMarginType;
import drr.base.margin.functions.GetMarginCurrency;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InitialMarginPostedByReportingCounterpartyCurrency.InitialMarginPostedByReportingCounterpartyCurrencyDefault.class)
public abstract class InitialMarginPostedByReportingCounterpartyCurrency implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetCollateralBalancesForMarginType getCollateralBalancesForMarginType;
	@Inject protected GetMarginCurrency getMarginCurrency;

	/**
	* @param reportableCollateral 
	* @param reportingCounterparty 
	* @return marginCurrency 
	*/
	public ISOCurrencyCodeEnum evaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
		ISOCurrencyCodeEnum marginCurrency = doEvaluate(reportableCollateral, reportingCounterparty);
		
		return marginCurrency;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty);

	public static class InitialMarginPostedByReportingCounterpartyCurrencyDefault extends InitialMarginPostedByReportingCounterpartyCurrency {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			ISOCurrencyCodeEnum marginCurrency = null;
			return assignOutput(marginCurrency, reportableCollateral, reportingCounterparty);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum marginCurrency, ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			marginCurrency = getMarginCurrency.evaluate(MapperC.<CollateralBalance>of(getCollateralBalancesForMarginType.evaluate(reportableCollateral, CollateralMarginTypeEnum.INITIAL_MARGIN))
				.filterItemNullSafe(item -> areEqual(item.<PartyReferencePayerReceiver>map("getPayerReceiver", collateralBalance -> collateralBalance.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), MapperS.of(reportingCounterparty), CardinalityOperator.All).get()).getMulti());
			
			return marginCurrency;
		}
	}
}
