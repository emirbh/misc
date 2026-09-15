package drr.regulation.hkma.rewrite.valuation.functions;

import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.UTIProprietarySchemeNameEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Extract_HKMATransactionSchemeName.Extract_HKMATransactionSchemeNameDefault.class)
public abstract class Extract_HKMATransactionSchemeName implements RosettaFunction {

	/**
	* @param tradeIdentifier 
	* @return schmeNm 
	*/
	public UTIProprietarySchemeNameEnum evaluate(TradeIdentifier tradeIdentifier) {
		UTIProprietarySchemeNameEnum schmeNm = doEvaluate(tradeIdentifier);
		
		return schmeNm;
	}

	protected abstract UTIProprietarySchemeNameEnum doEvaluate(TradeIdentifier tradeIdentifier);

	public static class Extract_HKMATransactionSchemeNameDefault extends Extract_HKMATransactionSchemeName {
		@Override
		protected UTIProprietarySchemeNameEnum doEvaluate(TradeIdentifier tradeIdentifier) {
			UTIProprietarySchemeNameEnum schmeNm = null;
			return assignOutput(schmeNm, tradeIdentifier);
		}
		
		protected UTIProprietarySchemeNameEnum assignOutput(UTIProprietarySchemeNameEnum schmeNm, TradeIdentifier tradeIdentifier) {
			final MapperS<TradeIdentifier> thenArg = MapperS.of(tradeIdentifier);
			schmeNm = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", _tradeIdentifier -> _tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(UTIProprietarySchemeNameEnum.UTI_USI);
					}
					if (areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", _tradeIdentifier -> _tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).orNullSafe(notExists(item.<TradeIdentifierTypeEnum>map("getIdentifierType", _tradeIdentifier -> _tradeIdentifier.getIdentifierType()))).getOrDefault(false)) {
						return MapperS.of(UTIProprietarySchemeNameEnum.UTI_TID);
					}
					return MapperS.<UTIProprietarySchemeNameEnum>ofNull();
				}).get();
			
			return schmeNm;
		}
	}
}
