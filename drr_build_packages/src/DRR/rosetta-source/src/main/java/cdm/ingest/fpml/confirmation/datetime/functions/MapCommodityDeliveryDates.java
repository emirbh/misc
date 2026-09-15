package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.Offset;
import cdm.base.datetime.PeriodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.fpmlenum.DeliveryDatesEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityDeliveryDates.MapCommodityDeliveryDatesDefault.class)
public abstract class MapCommodityDeliveryDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDeliveryDatesToPeriodMultiplier mapDeliveryDatesToPeriodMultiplier;

	/**
	* @param fpmlCommodity 
	* @return offset 
	*/
	public Offset evaluate(Commodity fpmlCommodity) {
		Offset.OffsetBuilder offsetBuilder = doEvaluate(fpmlCommodity);
		
		final Offset offset;
		if (offsetBuilder == null) {
			offset = null;
		} else {
			offset = offsetBuilder.build();
			objectValidator.validate(Offset.class, offset);
		}
		
		return offset;
	}

	protected abstract Offset.OffsetBuilder doEvaluate(Commodity fpmlCommodity);

	protected abstract MapperS<DeliveryDatesEnum> deliveryDates(Commodity fpmlCommodity);

	public static class MapCommodityDeliveryDatesDefault extends MapCommodityDeliveryDates {
		@Override
		protected Offset.OffsetBuilder doEvaluate(Commodity fpmlCommodity) {
			Offset.OffsetBuilder offset = Offset.builder();
			return assignOutput(offset, fpmlCommodity);
		}
		
		protected Offset.OffsetBuilder assignOutput(Offset.OffsetBuilder offset, Commodity fpmlCommodity) {
			PeriodEnum ifThenElseResult = null;
			if (exists(deliveryDates(fpmlCommodity)).getOrDefault(false)) {
				ifThenElseResult = PeriodEnum.M;
			}
			offset = toBuilder(Offset.builder()
				.setPeriod(ifThenElseResult)
				.setPeriodMultiplier(mapDeliveryDatesToPeriodMultiplier.evaluate(deliveryDates(fpmlCommodity).get()))
				.build());
			
			return Optional.ofNullable(offset)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<DeliveryDatesEnum> deliveryDates(Commodity fpmlCommodity) {
			return MapperS.of(fpmlCommodity).<DeliveryDatesEnum>map("getDeliveryDates", commodity -> commodity.getDeliveryDates());
		}
	}
}
