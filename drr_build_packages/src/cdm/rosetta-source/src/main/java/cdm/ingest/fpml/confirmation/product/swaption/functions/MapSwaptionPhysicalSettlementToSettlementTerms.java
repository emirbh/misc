package cdm.ingest.fpml.confirmation.product.swaption.functions;

import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSwaptionPhysicalSettlementToSettlementTerms.MapSwaptionPhysicalSettlementToSettlementTermsDefault.class)
public abstract class MapSwaptionPhysicalSettlementToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlSwaptionPhysicalSettlement 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(SwaptionPhysicalSettlement fpmlSwaptionPhysicalSettlement) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlSwaptionPhysicalSettlement);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(SwaptionPhysicalSettlement fpmlSwaptionPhysicalSettlement);

	public static class MapSwaptionPhysicalSettlementToSettlementTermsDefault extends MapSwaptionPhysicalSettlementToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(SwaptionPhysicalSettlement fpmlSwaptionPhysicalSettlement) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlSwaptionPhysicalSettlement);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, SwaptionPhysicalSettlement fpmlSwaptionPhysicalSettlement) {
			if (exists(MapperS.of(fpmlSwaptionPhysicalSettlement)).getOrDefault(false)) {
				settlementTerms = toBuilder(SettlementTerms.builder()
					.setSettlementType(SettlementTypeEnum.PHYSICAL)
					.setPhysicalSettlementTerms(PhysicalSettlementTerms.builder()
						.setClearedPhysicalSettlement(MapperS.of(fpmlSwaptionPhysicalSettlement).<Boolean>map("getClearedPhysicalSettlement", swaptionPhysicalSettlement -> swaptionPhysicalSettlement.getClearedPhysicalSettlement()).get())
						.build())
					.build());
			} else {
				settlementTerms = null;
			}
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
