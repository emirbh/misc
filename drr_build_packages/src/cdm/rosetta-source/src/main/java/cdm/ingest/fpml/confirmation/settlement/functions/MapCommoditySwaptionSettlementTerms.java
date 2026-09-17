package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.com.CommoditySwaption;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommoditySwaptionSettlementTerms.MapCommoditySwaptionSettlementTermsDefault.class)
public abstract class MapCommoditySwaptionSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommoditySwaption 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(CommoditySwaption fpmlCommoditySwaption) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlCommoditySwaption);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(CommoditySwaption fpmlCommoditySwaption);

	public static class MapCommoditySwaptionSettlementTermsDefault extends MapCommoditySwaptionSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(CommoditySwaption fpmlCommoditySwaption) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlCommoditySwaption);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, CommoditySwaption fpmlCommoditySwaption) {
			SettlementTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlCommoditySwaption).<CommodityPhysicalExercise>map("getPhysicalExercise", commoditySwaption -> commoditySwaption.getPhysicalExercise())).getOrDefault(false)) {
				ifThenElseResult = SettlementTypeEnum.PHYSICAL;
			}
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(ifThenElseResult)
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
