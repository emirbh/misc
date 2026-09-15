package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.com.UnitQuantity;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommodityFixedPhysicalQuantityToQuantityListWithLocation.MapCommodityFixedPhysicalQuantityToQuantityListWithLocationDefault.class)
public abstract class MapCommodityFixedPhysicalQuantityToQuantityListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityNotionalQuantityToQuantityWithLocation mapCommodityNotionalQuantityToQuantityWithLocation;
	@Inject protected MapCommodityTotalNotionalQuantityToQuantityWithLocation mapCommodityTotalNotionalQuantityToQuantityWithLocation;

	/**
	* @param fpmlPhysicalQuantity 
	* @param fpmlPhysicalQuantitySchedule 
	* @param fpmlTotalPhysicalQuantity 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public List<? extends FieldWithMetaNonNegativeQuantitySchedule> evaluate(CommodityNotionalQuantity fpmlPhysicalQuantity, CommodityPhysicalQuantitySchedule fpmlPhysicalQuantitySchedule, UnitQuantity fpmlTotalPhysicalQuantity, Leg fpmlLeg) {
		List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlPhysicalQuantity, fpmlPhysicalQuantitySchedule, fpmlTotalPhysicalQuantity, fpmlLeg);
		
		final List<? extends FieldWithMetaNonNegativeQuantitySchedule> nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.stream().map(FieldWithMetaNonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(CommodityNotionalQuantity fpmlPhysicalQuantity, CommodityPhysicalQuantitySchedule fpmlPhysicalQuantitySchedule, UnitQuantity fpmlTotalPhysicalQuantity, Leg fpmlLeg);

	public static class MapCommodityFixedPhysicalQuantityToQuantityListWithLocationDefault extends MapCommodityFixedPhysicalQuantityToQuantityListWithLocation {
		@Override
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(CommodityNotionalQuantity fpmlPhysicalQuantity, CommodityPhysicalQuantitySchedule fpmlPhysicalQuantitySchedule, UnitQuantity fpmlTotalPhysicalQuantity, Leg fpmlLeg) {
			List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedule = new ArrayList<>();
			return assignOutput(nonNegativeQuantitySchedule, fpmlPhysicalQuantity, fpmlPhysicalQuantitySchedule, fpmlTotalPhysicalQuantity, fpmlLeg);
		}
		
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> assignOutput(List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedule, CommodityNotionalQuantity fpmlPhysicalQuantity, CommodityPhysicalQuantitySchedule fpmlPhysicalQuantitySchedule, UnitQuantity fpmlTotalPhysicalQuantity, Leg fpmlLeg) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule0 = mapCommodityNotionalQuantityToQuantityWithLocation.evaluate(MapperS.of(fpmlPhysicalQuantity).<BigDecimal>map("getQuantity", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantity()).get(), MapperS.of(fpmlPhysicalQuantitySchedule).<CommodityNotionalQuantity>mapC("getQuantityStep", commodityPhysicalQuantitySchedule -> commodityPhysicalQuantitySchedule.getQuantityStep()).getMulti(), MapperS.of(fpmlPhysicalQuantity).<QuantityUnit>map("getQuantityUnit", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantityUnit()).get(), MapperS.of(fpmlPhysicalQuantity).<CommodityQuantityFrequency>map("getQuantityFrequency", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantityFrequency()).get(), fpmlLeg);
			if (fieldWithMetaNonNegativeQuantitySchedule0 == null) {
				nonNegativeQuantitySchedule.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			} else {
				nonNegativeQuantitySchedule.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule0)));
			}
			
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule1 = mapCommodityTotalNotionalQuantityToQuantityWithLocation.evaluate(MapperS.of(fpmlTotalPhysicalQuantity).<BigDecimal>map("getQuantity", unitQuantity -> unitQuantity.getQuantity()).get(), MapperS.of(fpmlTotalPhysicalQuantity).<QuantityUnit>map("getQuantityUnit", unitQuantity -> unitQuantity.getQuantityUnit()).get(), fpmlLeg);
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
