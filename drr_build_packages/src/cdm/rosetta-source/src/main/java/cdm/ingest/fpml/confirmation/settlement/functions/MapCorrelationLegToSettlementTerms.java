package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrAdjustedOrRelativeDate;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.correlation.swaps.CorrelationLeg;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCorrelationLegToSettlementTerms.MapCorrelationLegToSettlementTermsDefault.class)
public abstract class MapCorrelationLegToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlCorrelationLeg 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(CorrelationLeg fpmlCorrelationLeg) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlCorrelationLeg);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(CorrelationLeg fpmlCorrelationLeg);

	public static class MapCorrelationLegToSettlementTermsDefault extends MapCorrelationLegToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(CorrelationLeg fpmlCorrelationLeg) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlCorrelationLeg);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, CorrelationLeg fpmlCorrelationLeg) {
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(MapperS.of(fpmlCorrelationLeg).<SettlementTypeEnum>map("getSettlementType", correlationLeg -> correlationLeg.getSettlementType()).checkedMap("to-enum", e -> cdm.product.common.settlement.SettlementTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setSettlementCurrency(mapCurrency.evaluate(MapperS.of(fpmlCorrelationLeg).<Currency>map("getSettlementCurrency", correlationLeg -> correlationLeg.getSettlementCurrency()).get()))
				.setSettlementDate(SettlementDate.builder()
					.setAdjustableOrRelativeDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(null, MapperS.of(fpmlCorrelationLeg).<AdjustableOrRelativeDate>map("getSettlementDate", correlationLeg -> correlationLeg.getSettlementDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), MapperS.of(fpmlCorrelationLeg).<AdjustableOrRelativeDate>map("getSettlementDate", correlationLeg -> correlationLeg.getSettlementDate()).<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
