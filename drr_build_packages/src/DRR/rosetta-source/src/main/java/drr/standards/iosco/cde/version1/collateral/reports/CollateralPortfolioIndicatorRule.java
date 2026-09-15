package drr.standards.iosco.cde.version1.collateral.reports;

import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.CollateralPortfolio;
import cdm.event.common.metafields.ReferenceWithMetaCollateralPortfolio;
import cdm.product.collateral.Collateral;
import cdm.product.collateral.metafields.ReferenceWithMetaCollateral;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.TradeForEvent;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CollateralPortfolioIndicatorRule.CollateralPortfolioIndicatorRuleDefault.class)
public abstract class CollateralPortfolioIndicatorRule implements ReportFunction<TransactionReportInstructionBase, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstructionBase input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstructionBase input);

	public static class CollateralPortfolioIndicatorRuleDefault extends CollateralPortfolioIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstructionBase input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstructionBase input) {
			final MapperS<Collateral> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(MapperS.of(positionForEvent.evaluate(item.get())).<ReferenceWithMetaCollateral>map("getCollateral", counterpartyPosition -> counterpartyPosition.getCollateral()).<Collateral>map("Type coercion", referenceWithMetaCollateral -> referenceWithMetaCollateral == null ? null : referenceWithMetaCollateral.getValue()).getOrDefault(MapperS.of(tradeForEvent.evaluate(item.get())).<Collateral>map("getCollateral", trade -> trade.getCollateral()).get())));
			output = exists(thenArg.<Identifier>mapC("getPortfolioIdentifier", collateral -> collateral.getPortfolioIdentifier())).orNullSafe(exists(thenArg.<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", collateral -> collateral.getCollateralPortfolio()).<CollateralPortfolio>map("Type coercion", referenceWithMetaCollateralPortfolio -> referenceWithMetaCollateralPortfolio.getValue()).<Identifier>map("getPortfolioIdentifier", collateralPortfolio -> collateralPortfolio.getPortfolioIdentifier()))).asMapper().get();
			
			return output;
		}
	}
}
