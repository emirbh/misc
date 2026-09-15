package drr.standards.iosco.cde.version1.collateral.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.product.collateral.Collateral;
import cdm.product.collateral.metafields.ReferenceWithMetaCollateral;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.TradeForEvent;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CollateralPortfolioCodeRule.CollateralPortfolioCodeRuleDefault.class)
public abstract class CollateralPortfolioCodeRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class CollateralPortfolioCodeRuleDefault extends CollateralPortfolioCodeRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final MapperC<AssignedIdentifier> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> {
					if (exists(MapperS.of(positionForEvent.evaluate(item.get())).<ReferenceWithMetaCollateral>map("getCollateral", counterpartyPosition -> counterpartyPosition.getCollateral()).<Collateral>map("Type coercion", referenceWithMetaCollateral0 -> referenceWithMetaCollateral0 == null ? null : referenceWithMetaCollateral0.getValue()).<Identifier>mapC("getPortfolioIdentifier", collateral -> collateral.getPortfolioIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier())).getOrDefault(false)) {
						return MapperS.of(positionForEvent.evaluate(item.get())).<ReferenceWithMetaCollateral>map("getCollateral", counterpartyPosition -> counterpartyPosition.getCollateral()).<Collateral>map("Type coercion", referenceWithMetaCollateral1 -> referenceWithMetaCollateral1 == null ? null : referenceWithMetaCollateral1.getValue()).<Identifier>mapC("getPortfolioIdentifier", collateral -> collateral.getPortfolioIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier());
					}
					if (exists(MapperS.of(tradeForEvent.evaluate(item.get())).<Collateral>map("getCollateral", trade -> trade.getCollateral()).<Identifier>mapC("getPortfolioIdentifier", collateral -> collateral.getPortfolioIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier())).getOrDefault(false)) {
						return MapperS.of(tradeForEvent.evaluate(item.get())).<Collateral>map("getCollateral", trade -> trade.getCollateral()).<Identifier>mapC("getPortfolioIdentifier", collateral -> collateral.getPortfolioIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier());
					}
					return MapperC.<AssignedIdentifier>ofNull();
				});
			final MapperS<AssignedIdentifier> thenArg1 = MapperS.of(distinctIgnoringPrecision(thenArg0).get());
			final FieldWithMetaString fieldWithMetaString = thenArg1
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
