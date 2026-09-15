package drr.regulation.hkma.rewrite.valuation.functions;

import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ReportableValuation;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationTradeInformation;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Extract_UTIPropietary.Extract_UTIPropietaryDefault.class)
public abstract class Extract_UTIPropietary implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableValuation 
	* @return tradeIdentifier 
	*/
	public TradeIdentifier evaluate(ReportableValuation reportableValuation) {
		TradeIdentifier.TradeIdentifierBuilder tradeIdentifierBuilder = doEvaluate(reportableValuation);
		
		final TradeIdentifier tradeIdentifier;
		if (tradeIdentifierBuilder == null) {
			tradeIdentifier = null;
		} else {
			tradeIdentifier = tradeIdentifierBuilder.build();
			objectValidator.validate(TradeIdentifier.class, tradeIdentifier);
		}
		
		return tradeIdentifier;
	}

	protected abstract TradeIdentifier.TradeIdentifierBuilder doEvaluate(ReportableValuation reportableValuation);

	public static class Extract_UTIPropietaryDefault extends Extract_UTIPropietary {
		@Override
		protected TradeIdentifier.TradeIdentifierBuilder doEvaluate(ReportableValuation reportableValuation) {
			TradeIdentifier.TradeIdentifierBuilder tradeIdentifier = TradeIdentifier.builder();
			return assignOutput(tradeIdentifier, reportableValuation);
		}
		
		protected TradeIdentifier.TradeIdentifierBuilder assignOutput(TradeIdentifier.TradeIdentifierBuilder tradeIdentifier, ReportableValuation reportableValuation) {
			final MapperS<ReportableValuation> thenArg = MapperS.of(reportableValuation);
			tradeIdentifier = toBuilder(thenArg
				.mapSingleToItem(item -> {
					if (exists(item.<ValuationDetails>map("getValuationDetails", _reportableValuation -> _reportableValuation.getValuationDetails())).getOrDefault(false)) {
						return item.<ValuationDetails>map("getValuationDetails", _reportableValuation -> _reportableValuation.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<TradeIdentifier>map("getUniqueTradeIdentifier", valuationTradeInformation -> valuationTradeInformation.getUniqueTradeIdentifier());
					}
					return MapperS.<TradeIdentifier>ofNull();
				}).get());
			
			return Optional.ofNullable(tradeIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
