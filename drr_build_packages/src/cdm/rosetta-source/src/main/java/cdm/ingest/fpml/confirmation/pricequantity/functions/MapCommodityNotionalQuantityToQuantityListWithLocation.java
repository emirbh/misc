package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommodityNotionalQuantityToQuantityListWithLocation.MapCommodityNotionalQuantityToQuantityListWithLocationDefault.class)
public abstract class MapCommodityNotionalQuantityToQuantityListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityNotionalQuantityToQuantityWithLocation mapCommodityNotionalQuantityToQuantityWithLocation;
	@Inject protected MapCommodityTotalNotionalQuantityToQuantityWithLocation mapCommodityTotalNotionalQuantityToQuantityWithLocation;

	/**
	* @param fpmlNotionalQuantity 
	* @param totalNotionalQuantity 
	* @param fpmlNotionalQuantitySchedule 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public List<? extends FieldWithMetaNonNegativeQuantitySchedule> evaluate(CommodityNotionalQuantity fpmlNotionalQuantity, BigDecimal totalNotionalQuantity, CommodityNotionalQuantitySchedule fpmlNotionalQuantitySchedule, Leg fpmlLeg) {
		List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNotionalQuantity, totalNotionalQuantity, fpmlNotionalQuantitySchedule, fpmlLeg);
		
		final List<? extends FieldWithMetaNonNegativeQuantitySchedule> nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.stream().map(FieldWithMetaNonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(CommodityNotionalQuantity fpmlNotionalQuantity, BigDecimal totalNotionalQuantity, CommodityNotionalQuantitySchedule fpmlNotionalQuantitySchedule, Leg fpmlLeg);

	public static class MapCommodityNotionalQuantityToQuantityListWithLocationDefault extends MapCommodityNotionalQuantityToQuantityListWithLocation {
		@Override
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(CommodityNotionalQuantity fpmlNotionalQuantity, BigDecimal totalNotionalQuantity, CommodityNotionalQuantitySchedule fpmlNotionalQuantitySchedule, Leg fpmlLeg) {
			List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedule = new ArrayList<>();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNotionalQuantity, totalNotionalQuantity, fpmlNotionalQuantitySchedule, fpmlLeg);
		}
		
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> assignOutput(List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedule, CommodityNotionalQuantity fpmlNotionalQuantity, BigDecimal totalNotionalQuantity, CommodityNotionalQuantitySchedule fpmlNotionalQuantitySchedule, Leg fpmlLeg) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule0 = mapCommodityNotionalQuantityToQuantityWithLocation.evaluate(MapperS.of(fpmlNotionalQuantity).<BigDecimal>map("getQuantity", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantity()).get(), Collections.<CommodityNotionalQuantity>emptyList(), MapperS.of(fpmlNotionalQuantity).<QuantityUnit>map("getQuantityUnit", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantityUnit()).get(), MapperS.of(fpmlNotionalQuantity).<CommodityQuantityFrequency>map("getQuantityFrequency", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantityFrequency()).get(), fpmlLeg);
			if (fieldWithMetaNonNegativeQuantitySchedule0 == null) {
				nonNegativeQuantitySchedule.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			} else {
				nonNegativeQuantitySchedule.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule0)));
			}
			
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule1 = mapCommodityTotalNotionalQuantityToQuantityWithLocation.evaluate(totalNotionalQuantity, MapperS.of(fpmlNotionalQuantity).<QuantityUnit>map("getQuantityUnit", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantityUnit()).getOrDefault(MapperS.of(fpmlNotionalQuantitySchedule).<CommodityNotionalQuantity>mapC("getNotionalStep", commodityNotionalQuantitySchedule -> commodityNotionalQuantitySchedule.getNotionalStep())
				.first().<QuantityUnit>map("getQuantityUnit", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantityUnit()).get()), fpmlLeg);
			if (fieldWithMetaNonNegativeQuantitySchedule1 == null) {
				nonNegativeQuantitySchedule.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			} else {
				nonNegativeQuantitySchedule.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule1)));
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
