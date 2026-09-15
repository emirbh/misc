package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TechnicalRecordId;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.msg.RequestMessageHeader;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapTechnicalRecordId.MapTechnicalRecordIdDefault.class)
public abstract class MapTechnicalRecordId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlRequestMessageHeader 
	* @param supervisoryBody 
	* @return technicalRecordId 
	*/
	public TechnicalRecordId evaluate(RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody) {
		TechnicalRecordId.TechnicalRecordIdBuilder technicalRecordIdBuilder = doEvaluate(fpmlRequestMessageHeader, supervisoryBody);
		
		final TechnicalRecordId technicalRecordId;
		if (technicalRecordIdBuilder == null) {
			technicalRecordId = null;
		} else {
			technicalRecordId = technicalRecordIdBuilder.build();
			objectValidator.validate(TechnicalRecordId.class, technicalRecordId);
		}
		
		return technicalRecordId;
	}

	protected abstract TechnicalRecordId.TechnicalRecordIdBuilder doEvaluate(RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperC<SupervisoryBodyEnum> relevantSupervisoryBodies(RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<String> messageIdValue(RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<String> id(RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody);

	public static class MapTechnicalRecordIdDefault extends MapTechnicalRecordId {
		@Override
		protected TechnicalRecordId.TechnicalRecordIdBuilder doEvaluate(RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody) {
			TechnicalRecordId.TechnicalRecordIdBuilder technicalRecordId = TechnicalRecordId.builder();
			return assignOutput(technicalRecordId, fpmlRequestMessageHeader, supervisoryBody);
		}
		
		protected TechnicalRecordId.TechnicalRecordIdBuilder assignOutput(TechnicalRecordId.TechnicalRecordIdBuilder technicalRecordId, RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody) {
			final String withMetaArgument = id(fpmlRequestMessageHeader, supervisoryBody).get();
			technicalRecordId = toBuilder(TechnicalRecordId.builder()
				.setId(FieldWithMetaString.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme("http://www.fpml.org/coding-scheme/external/technical-record-id")))
				.build());
			
			return Optional.ofNullable(technicalRecordId)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<SupervisoryBodyEnum> relevantSupervisoryBodies(RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody) {
			return MapperC.<SupervisoryBodyEnum>of(MapperS.of(SupervisoryBodyEnum.ASIC), MapperS.of(SupervisoryBodyEnum.JFSA), MapperS.of(SupervisoryBodyEnum.MAS));
		}
		
		@Override
		protected MapperS<String> messageIdValue(RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody) {
			final MapperS<MessageId> thenArg = MapperS.of(fpmlRequestMessageHeader).<MessageId>map("getMessageId", requestMessageHeader -> requestMessageHeader.getMessageId())
				.filterSingleNullSafe(item -> areEqual(item.<String>map("getMessageIdScheme", messageId -> messageId.getMessageIdScheme()), MapperS.of("http://www.fpml.org/coding-scheme/external/technical-record-id"), CardinalityOperator.All).get());
			return thenArg
				.mapSingleToItem(item -> item.<String>map("getValue", messageId -> messageId.getValue()));
		}
		
		@Override
		protected MapperS<String> id(RequestMessageHeader fpmlRequestMessageHeader, SupervisoryBodyEnum supervisoryBody) {
			final MapperC<SupervisoryBodyEnum> thenArg = relevantSupervisoryBodies(fpmlRequestMessageHeader, supervisoryBody)
				.filterItemNullSafe(item -> areEqual(item, MapperS.of(supervisoryBody), CardinalityOperator.All).get());
			if (exists(thenArg).asMapper().getOrDefault(false)) {
				return messageIdValue(fpmlRequestMessageHeader, supervisoryBody);
			}
			return MapperS.<String>ofNull();
		}
	}
}
