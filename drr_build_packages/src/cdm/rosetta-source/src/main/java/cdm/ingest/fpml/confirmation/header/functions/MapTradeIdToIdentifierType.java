package cdm.ingest.fpml.confirmation.header.functions;

import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.TradeId;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapTradeIdToIdentifierType.MapTradeIdToIdentifierTypeDefault.class)
public abstract class MapTradeIdToIdentifierType implements RosettaFunction {

	/**
	* @param fpmlTradeId 
	* @return cdmTradeIdentifierTypeEnum 
	*/
	public TradeIdentifierTypeEnum evaluate(TradeId fpmlTradeId) {
		TradeIdentifierTypeEnum cdmTradeIdentifierTypeEnum = doEvaluate(fpmlTradeId);
		
		return cdmTradeIdentifierTypeEnum;
	}

	protected abstract TradeIdentifierTypeEnum doEvaluate(TradeId fpmlTradeId);

	protected abstract MapperS<String> tradeIdScheme(TradeId fpmlTradeId);

	public static class MapTradeIdToIdentifierTypeDefault extends MapTradeIdToIdentifierType {
		@Override
		protected TradeIdentifierTypeEnum doEvaluate(TradeId fpmlTradeId) {
			TradeIdentifierTypeEnum cdmTradeIdentifierTypeEnum = null;
			return assignOutput(cdmTradeIdentifierTypeEnum, fpmlTradeId);
		}
		
		protected TradeIdentifierTypeEnum assignOutput(TradeIdentifierTypeEnum cdmTradeIdentifierTypeEnum, TradeId fpmlTradeId) {
			if (areEqual(tradeIdScheme(fpmlTradeId), MapperS.of("http://www.fpml.org/coding-scheme/external/uti"), CardinalityOperator.All).orNullSafe(areEqual(tradeIdScheme(fpmlTradeId), MapperS.of("http://www.fpml.org/coding-scheme/external/unique-transaction-identifier"), CardinalityOperator.All)).getOrDefault(false)) {
				cdmTradeIdentifierTypeEnum = TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER;
			} else if (areEqual(tradeIdScheme(fpmlTradeId), MapperS.of("http://www.fpml.org/coding-scheme/external/usi"), CardinalityOperator.All).orNullSafe(areEqual(tradeIdScheme(fpmlTradeId), MapperS.of("http://www.fpml.org/coding-scheme/external/unique-swap-identifier"), CardinalityOperator.All)).getOrDefault(false)) {
				cdmTradeIdentifierTypeEnum = TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER;
			} else {
				cdmTradeIdentifierTypeEnum = null;
			}
			
			return cdmTradeIdentifierTypeEnum;
		}
		
		@Override
		protected MapperS<String> tradeIdScheme(TradeId fpmlTradeId) {
			return MapperS.of(fpmlTradeId).<String>map("getTradeIdScheme", tradeId -> tradeId.getTradeIdScheme());
		}
	}
}
