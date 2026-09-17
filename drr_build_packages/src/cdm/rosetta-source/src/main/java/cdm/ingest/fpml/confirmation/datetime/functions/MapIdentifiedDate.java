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


@ImplementedBy(MapIdentifiedDate.MapIdentifiedDateDefault.class)
public abstract class MapIdentifiedDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlIdentifiedDate 
	* @return dateWithId 
	*/
	public FieldWithMetaDate evaluate(IdentifiedDate fpmlIdentifiedDate) {
		FieldWithMetaDate.FieldWithMetaDateBuilder dateWithIdBuilder = doEvaluate(fpmlIdentifiedDate);
		
		final FieldWithMetaDate dateWithId;
		if (dateWithIdBuilder == null) {
			dateWithId = null;
		} else {
			dateWithId = dateWithIdBuilder.build();
			objectValidator.validate(FieldWithMetaDate.class, dateWithId);
		}
		
		return dateWithId;
	}

	protected abstract FieldWithMetaDate.FieldWithMetaDateBuilder doEvaluate(IdentifiedDate fpmlIdentifiedDate);

	public static class MapIdentifiedDateDefault extends MapIdentifiedDate {
		@Override
		protected FieldWithMetaDate.FieldWithMetaDateBuilder doEvaluate(IdentifiedDate fpmlIdentifiedDate) {
			FieldWithMetaDate.FieldWithMetaDateBuilder dateWithId = FieldWithMetaDate.builder();
			return assignOutput(dateWithId, fpmlIdentifiedDate);
		}
		
		protected FieldWithMetaDate.FieldWithMetaDateBuilder assignOutput(FieldWithMetaDate.FieldWithMetaDateBuilder dateWithId, IdentifiedDate fpmlIdentifiedDate) {
			final Date withMetaArgument = MapperS.of(fpmlIdentifiedDate).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get();
			dateWithId = toBuilder(FieldWithMetaDate.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setExternalKey(MapperS.of(fpmlIdentifiedDate).<String>map("getId", identifiedDate -> identifiedDate.getId()).get())));
			
			return Optional.ofNullable(dateWithId)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
