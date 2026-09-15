package cdm.ingest.fpml.confirmation.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateWithId.MapDateWithIdDefault.class)
public abstract class MapDateWithId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlIdentifiedDate 
	* @return date 
	*/
	public FieldWithMetaDate evaluate(IdentifiedDate fpmlIdentifiedDate) {
		FieldWithMetaDate.FieldWithMetaDateBuilder dateBuilder = doEvaluate(fpmlIdentifiedDate);
		
		final FieldWithMetaDate date;
		if (dateBuilder == null) {
			date = null;
		} else {
			date = dateBuilder.build();
			objectValidator.validate(FieldWithMetaDate.class, date);
		}
		
		return date;
	}

	protected abstract FieldWithMetaDate.FieldWithMetaDateBuilder doEvaluate(IdentifiedDate fpmlIdentifiedDate);

	public static class MapDateWithIdDefault extends MapDateWithId {
		@Override
		protected FieldWithMetaDate.FieldWithMetaDateBuilder doEvaluate(IdentifiedDate fpmlIdentifiedDate) {
			FieldWithMetaDate.FieldWithMetaDateBuilder date = FieldWithMetaDate.builder();
			return assignOutput(date, fpmlIdentifiedDate);
		}
		
		protected FieldWithMetaDate.FieldWithMetaDateBuilder assignOutput(FieldWithMetaDate.FieldWithMetaDateBuilder date, IdentifiedDate fpmlIdentifiedDate) {
			final Date withMetaArgument = MapperS.of(fpmlIdentifiedDate).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get();
			date = toBuilder(FieldWithMetaDate.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setExternalKey(MapperS.of(fpmlIdentifiedDate).<String>map("getId", identifiedDate -> identifiedDate.getId()).get())));
			
			return Optional.ofNullable(date)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
