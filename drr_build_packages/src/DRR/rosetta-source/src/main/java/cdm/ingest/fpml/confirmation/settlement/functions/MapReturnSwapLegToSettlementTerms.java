package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.eq.shared.ReturnSwapAmount;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReturnSwapLegToSettlementTerms.MapReturnSwapLegToSettlementTermsDefault.class)
public abstract class MapReturnSwapLegToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlReturnLeg 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(ReturnLeg fpmlReturnLeg) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlReturnLeg);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(ReturnLeg fpmlReturnLeg);

	public static class MapReturnSwapLegToSettlementTermsDefault extends MapReturnSwapLegToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(ReturnLeg fpmlReturnLeg) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlReturnLeg);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, ReturnLeg fpmlReturnLeg) {
			final SettlementTypeEnum ifThenElseResult0;
			if (areEqual(MapperS.of(fpmlReturnLeg).<ReturnSwapAmount>map("getAmount", returnLeg -> returnLeg.getAmount()).<Boolean>map("getCashSettlement", returnSwapAmount -> returnSwapAmount.getCashSettlement()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = SettlementTypeEnum.CASH;
			} else {
				ifThenElseResult0 = MapperS.of(fpmlReturnLeg).<fpml.consolidated.fpmlenum.SettlementTypeEnum>map("getSettlementType", returnLeg -> returnLeg.getSettlementType()).checkedMap("to-enum", e -> SettlementTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			final FieldWithMetaString ifThenElseResult1;
			if (exists(MapperS.of(fpmlReturnLeg).<ReturnSwapAmount>map("getAmount", returnLeg -> returnLeg.getAmount())).getOrDefault(false)) {
				ifThenElseResult1 = mapCurrency.evaluate(MapperS.of(fpmlReturnLeg).<ReturnSwapAmount>map("getAmount", returnLeg -> returnLeg.getAmount()).<IdentifiedCurrency>map("getCurrency", returnSwapAmount -> returnSwapAmount.getCurrency()).get());
			} else if (exists(MapperS.of(fpmlReturnLeg).<Currency>map("getSettlementCurrency", returnLeg -> returnLeg.getSettlementCurrency())).getOrDefault(false)) {
				ifThenElseResult1 = mapCurrency.evaluate(MapperS.of(fpmlReturnLeg).<Currency>map("getSettlementCurrency", returnLeg -> returnLeg.getSettlementCurrency()).get());
			} else {
				ifThenElseResult1 = FieldWithMetaString.builder().build();
			}
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(ifThenElseResult0)
				.setSettlementCurrency(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
