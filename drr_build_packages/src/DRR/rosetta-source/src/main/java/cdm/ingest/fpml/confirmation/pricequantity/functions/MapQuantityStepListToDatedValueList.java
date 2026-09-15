package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.DatedValue;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityNotionalQuantity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapQuantityStepListToDatedValueList.MapQuantityStepListToDatedValueListDefault.class)
public abstract class MapQuantityStepListToDatedValueList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlQuantityStepList 
	* @return datedValueList 
	*/
	public List<? extends DatedValue> evaluate(List<? extends CommodityNotionalQuantity> fpmlQuantityStepList) {
		List<DatedValue.DatedValueBuilder> datedValueListBuilder = doEvaluate(fpmlQuantityStepList);
		
		final List<? extends DatedValue> datedValueList;
		if (datedValueListBuilder == null) {
			datedValueList = null;
		} else {
			datedValueList = datedValueListBuilder.stream().map(DatedValue::build).collect(Collectors.toList());
			objectValidator.validate(DatedValue.class, datedValueList);
		}
		
		return datedValueList;
	}

	protected abstract List<DatedValue.DatedValueBuilder> doEvaluate(List<? extends CommodityNotionalQuantity> fpmlQuantityStepList);

	public static class MapQuantityStepListToDatedValueListDefault extends MapQuantityStepListToDatedValueList {
		@Override
		protected List<DatedValue.DatedValueBuilder> doEvaluate(List<? extends CommodityNotionalQuantity> fpmlQuantityStepList) {
			if (fpmlQuantityStepList == null) {
				fpmlQuantityStepList = Collections.emptyList();
			}
			List<DatedValue.DatedValueBuilder> datedValueList = new ArrayList<>();
			return assignOutput(datedValueList, fpmlQuantityStepList);
		}
		
		protected List<DatedValue.DatedValueBuilder> assignOutput(List<DatedValue.DatedValueBuilder> datedValueList, List<? extends CommodityNotionalQuantity> fpmlQuantityStepList) {
			datedValueList.addAll(toBuilder(MapperC.<CommodityNotionalQuantity>of(fpmlQuantityStepList)
				.mapItem(item -> {
					final DatedValue.DatedValueBuilder withMetaArgument = DatedValue.builder()
						.setDate(null)
						.setValue(item.<BigDecimal>map("getQuantity", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantity()).get())
						.build() == null ? null : DatedValue.builder()
						.setDate(null)
						.setValue(item.<BigDecimal>map("getQuantity", commodityNotionalQuantity -> commodityNotionalQuantity.getQuantity()).get())
						.build().toBuilder();
					withMetaArgument.getOrCreateMeta().setExternalKey(item.<String>map("getId", commodityNotionalQuantity -> commodityNotionalQuantity.getId()).get());
					return MapperS.of(withMetaArgument);
				}).getMulti()));
			
			return Optional.ofNullable(datedValueList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
