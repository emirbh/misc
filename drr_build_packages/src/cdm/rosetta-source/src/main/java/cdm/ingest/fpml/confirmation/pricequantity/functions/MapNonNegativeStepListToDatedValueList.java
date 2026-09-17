package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.DatedValue;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.NonNegativeStep;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapNonNegativeStepListToDatedValueList.MapNonNegativeStepListToDatedValueListDefault.class)
public abstract class MapNonNegativeStepListToDatedValueList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlStepList 
	* @return datedValueList 
	*/
	public List<? extends DatedValue> evaluate(List<? extends NonNegativeStep> fpmlStepList) {
		List<DatedValue.DatedValueBuilder> datedValueListBuilder = doEvaluate(fpmlStepList);
		
		final List<? extends DatedValue> datedValueList;
		if (datedValueListBuilder == null) {
			datedValueList = null;
		} else {
			datedValueList = datedValueListBuilder.stream().map(DatedValue::build).collect(Collectors.toList());
			objectValidator.validate(DatedValue.class, datedValueList);
		}
		
		return datedValueList;
	}

	protected abstract List<DatedValue.DatedValueBuilder> doEvaluate(List<? extends NonNegativeStep> fpmlStepList);

	public static class MapNonNegativeStepListToDatedValueListDefault extends MapNonNegativeStepListToDatedValueList {
		@Override
		protected List<DatedValue.DatedValueBuilder> doEvaluate(List<? extends NonNegativeStep> fpmlStepList) {
			if (fpmlStepList == null) {
				fpmlStepList = Collections.emptyList();
			}
			List<DatedValue.DatedValueBuilder> datedValueList = new ArrayList<>();
			return assignOutput(datedValueList, fpmlStepList);
		}
		
		protected List<DatedValue.DatedValueBuilder> assignOutput(List<DatedValue.DatedValueBuilder> datedValueList, List<? extends NonNegativeStep> fpmlStepList) {
			datedValueList.addAll(toBuilder(MapperC.<NonNegativeStep>of(fpmlStepList)
				.mapItem(item -> {
					final DatedValue.DatedValueBuilder withMetaArgument = DatedValue.builder()
						.setDate(item.<ZonedDateTime>map("getStepDate", nonNegativeStep -> nonNegativeStep.getStepDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
						.setValue(item.<BigDecimal>map("getStepValue", nonNegativeStep -> nonNegativeStep.getStepValue()).get())
						.build() == null ? null : DatedValue.builder()
						.setDate(item.<ZonedDateTime>map("getStepDate", nonNegativeStep -> nonNegativeStep.getStepDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
						.setValue(item.<BigDecimal>map("getStepValue", nonNegativeStep -> nonNegativeStep.getStepValue()).get())
						.build().toBuilder();
					withMetaArgument.getOrCreateMeta().setExternalKey(item.<String>map("getId", nonNegativeStep -> nonNegativeStep.getId()).get());
					return MapperS.of(withMetaArgument);
				}).getMulti()));
			
			return Optional.ofNullable(datedValueList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
