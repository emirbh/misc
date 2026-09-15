package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.asset.DayDistributionEnum;
import cdm.product.asset.metafields.FieldWithMetaDayDistributionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDayDistributionEnumWithScheme.MapDayDistributionEnumWithSchemeDefault.class)
public abstract class MapDayDistributionEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param value 
	* @param scheme 
	* @return dayDistribution 
	*/
	public FieldWithMetaDayDistributionEnum evaluate(String value, String scheme) {
		FieldWithMetaDayDistributionEnum.FieldWithMetaDayDistributionEnumBuilder dayDistributionBuilder = doEvaluate(value, scheme);
		
		final FieldWithMetaDayDistributionEnum dayDistribution;
		if (dayDistributionBuilder == null) {
			dayDistribution = null;
		} else {
			dayDistribution = dayDistributionBuilder.build();
			objectValidator.validate(FieldWithMetaDayDistributionEnum.class, dayDistribution);
		}
		
		return dayDistribution;
	}

	protected abstract FieldWithMetaDayDistributionEnum.FieldWithMetaDayDistributionEnumBuilder doEvaluate(String value, String scheme);

	public static class MapDayDistributionEnumWithSchemeDefault extends MapDayDistributionEnumWithScheme {
		@Override
		protected FieldWithMetaDayDistributionEnum.FieldWithMetaDayDistributionEnumBuilder doEvaluate(String value, String scheme) {
			FieldWithMetaDayDistributionEnum.FieldWithMetaDayDistributionEnumBuilder dayDistribution = FieldWithMetaDayDistributionEnum.builder();
			return assignOutput(dayDistribution, value, scheme);
		}
		
		protected FieldWithMetaDayDistributionEnum.FieldWithMetaDayDistributionEnumBuilder assignOutput(FieldWithMetaDayDistributionEnum.FieldWithMetaDayDistributionEnumBuilder dayDistribution, String value, String scheme) {
			final DayDistributionEnum dayDistributionEnum = MapperS.of(value).checkedMap("to-enum", DayDistributionEnum::fromDisplayName, IllegalArgumentException.class).get();
			if (dayDistributionEnum == null) {
				dayDistribution = toBuilder(FieldWithMetaDayDistributionEnum.builder().build(), () -> FieldWithMetaDayDistributionEnum.builder());
			} else {
				dayDistribution = toBuilder(FieldWithMetaDayDistributionEnum.builder().setValue(dayDistributionEnum).build(), () -> FieldWithMetaDayDistributionEnum.builder());
			}
			
			dayDistribution
				.getOrCreateMeta().setScheme(scheme);
			
			return Optional.ofNullable(dayDistribution)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
