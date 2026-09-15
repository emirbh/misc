package drr.regulation.common.trade.link.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TechnicalRecordId.TechnicalRecordIdDefault.class)
public abstract class TechnicalRecordId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableInformation 
	* @param regime 
	* @return technicalRecordIdentifier 
	*/
	public drr.regulation.common.TechnicalRecordId evaluate(ReportableInformation reportableInformation, RegimeNameEnum regime) {
		drr.regulation.common.TechnicalRecordId.TechnicalRecordIdBuilder technicalRecordIdentifierBuilder = doEvaluate(reportableInformation, regime);
		
		final drr.regulation.common.TechnicalRecordId technicalRecordIdentifier;
		if (technicalRecordIdentifierBuilder == null) {
			technicalRecordIdentifier = null;
		} else {
			technicalRecordIdentifier = technicalRecordIdentifierBuilder.build();
			objectValidator.validate(drr.regulation.common.TechnicalRecordId.class, technicalRecordIdentifier);
		}
		
		return technicalRecordIdentifier;
	}

	protected abstract drr.regulation.common.TechnicalRecordId.TechnicalRecordIdBuilder doEvaluate(ReportableInformation reportableInformation, RegimeNameEnum regime);

	public static class TechnicalRecordIdDefault extends TechnicalRecordId {
		@Override
		protected drr.regulation.common.TechnicalRecordId.TechnicalRecordIdBuilder doEvaluate(ReportableInformation reportableInformation, RegimeNameEnum regime) {
			drr.regulation.common.TechnicalRecordId.TechnicalRecordIdBuilder technicalRecordIdentifier = drr.regulation.common.TechnicalRecordId.builder();
			return assignOutput(technicalRecordIdentifier, reportableInformation, regime);
		}
		
		protected drr.regulation.common.TechnicalRecordId.TechnicalRecordIdBuilder assignOutput(drr.regulation.common.TechnicalRecordId.TechnicalRecordIdBuilder technicalRecordIdentifier, ReportableInformation reportableInformation, RegimeNameEnum regime) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(reportableInformation).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", _reportableInformation -> _reportableInformation.getJurisdictionInformation());
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(regime), CardinalityOperator.All).get());
			final MapperListOfLists<drr.regulation.common.TechnicalRecordId> thenArg2 = thenArg1
				.mapItemToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<drr.regulation.common.TechnicalRecordId>map("getTechnicalRecordId", jurisdictionPartyInformation -> jurisdictionPartyInformation.getTechnicalRecordId()));
			technicalRecordIdentifier = toBuilder(MapperS.of(distinctIgnoringPrecision(thenArg2
				.flattenList()).get()).get());
			
			return Optional.ofNullable(technicalRecordIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
