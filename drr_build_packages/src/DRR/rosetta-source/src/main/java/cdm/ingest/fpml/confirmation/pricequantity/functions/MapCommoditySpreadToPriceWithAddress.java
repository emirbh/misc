package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.meta.Reference;
import fpml.consolidated.com.CommoditySpread;
import fpml.consolidated.shared.Leg;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommoditySpreadToPriceWithAddress.MapCommoditySpreadToPriceWithAddressDefault.class)
public abstract class MapCommoditySpreadToPriceWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;

	/**
	* @param fpmlCommoditySpread 
	* @param fpmlLeg 
	* @return priceSchedule 
	*/
	public ReferenceWithMetaPriceSchedule evaluate(CommoditySpread fpmlCommoditySpread, Leg fpmlLeg) {
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlCommoditySpread, fpmlLeg);
		
		final ReferenceWithMetaPriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaPriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(CommoditySpread fpmlCommoditySpread, Leg fpmlLeg);

	public static class MapCommoditySpreadToPriceWithAddressDefault extends MapCommoditySpreadToPriceWithAddress {
		@Override
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(CommoditySpread fpmlCommoditySpread, Leg fpmlLeg) {
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceSchedule = ReferenceWithMetaPriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlCommoditySpread, fpmlLeg);
		}
		
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder assignOutput(ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceSchedule, CommoditySpread fpmlCommoditySpread, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlCommoditySpread)).getOrDefault(false)) {
				priceSchedule = toBuilder(ReferenceWithMetaPriceSchedule.builder().setValue(null).setReference(Reference.builder().setReference(createPriceKey.evaluate("spreadPrice", fpmlLeg))).build());
			} else {
				priceSchedule = toBuilder(ReferenceWithMetaPriceSchedule.builder().build());
			}
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
