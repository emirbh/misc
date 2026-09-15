package drr.standards.iosco.cde.version1.collateral.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.CollateralBalance;
import cdm.event.common.HaircutIndicatorEnum;
import cdm.product.collateral.CollateralMarginTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.margin.ReportableCollateralBase;
import drr.base.margin.functions.GetCollateralBalancesForMarginType;
import drr.base.margin.functions.GetMarginValue;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(VariationMarginPostedByReportingCounterpartyPreHaircut.VariationMarginPostedByReportingCounterpartyPreHaircutDefault.class)
public abstract class VariationMarginPostedByReportingCounterpartyPreHaircut implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;
	@Inject protected GetCollateralBalancesForMarginType getCollateralBalancesForMarginType;
	@Inject protected GetMarginValue getMarginValue;

	/**
	* @param reportableCollateral 
	* @param reportingCounterparty 
	* @return marginValue 
	*/
	public BigDecimal evaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
		BigDecimal marginValue = doEvaluate(reportableCollateral, reportingCounterparty);
		
		return marginValue;
	}

	protected abstract BigDecimal doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty);

	public static class VariationMarginPostedByReportingCounterpartyPreHaircutDefault extends VariationMarginPostedByReportingCounterpartyPreHaircut {
		@Override
		protected BigDecimal doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			BigDecimal marginValue = null;
			return assignOutput(marginValue, reportableCollateral, reportingCounterparty);
		}
		
		protected BigDecimal assignOutput(BigDecimal marginValue, ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			final MapperS<BigDecimal> thenArg = MapperS.of(getMarginValue.evaluate(MapperC.<CollateralBalance>of(getCollateralBalancesForMarginType.evaluate(reportableCollateral, CollateralMarginTypeEnum.VARIATION_MARGIN))
				.filterItemNullSafe(item -> areEqual(item.<PartyReferencePayerReceiver>map("getPayerReceiver", collateralBalance -> collateralBalance.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), MapperS.of(reportingCounterparty), CardinalityOperator.All).get()).getMulti(), HaircutIndicatorEnum.PRE_HAIRCUT)).<BigDecimal>map("getValue", money -> money.getValue());
			marginValue = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg.get())).get();
			
			return marginValue;
		}
	}
}
