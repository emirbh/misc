package drr.regulation.common.trade.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractRegimeInformation.ExtractRegimeInformationDefault.class)
public abstract class ExtractRegimeInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param transactionReportInstruction 
	* @param party 
	* @param regimeNm 
	* @param supervisoryBdy 
	* @return result 
	*/
	public JurisdictionPartyInformation evaluate(TransactionReportInstruction transactionReportInstruction, Party party, RegimeNameEnum regimeNm, SupervisoryBodyEnum supervisoryBdy) {
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder resultBuilder = doEvaluate(transactionReportInstruction, party, regimeNm, supervisoryBdy);
		
		final JurisdictionPartyInformation result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.build();
			objectValidator.validate(JurisdictionPartyInformation.class, result);
		}
		
		return result;
	}

	protected abstract JurisdictionPartyInformation.JurisdictionPartyInformationBuilder doEvaluate(TransactionReportInstruction transactionReportInstruction, Party party, RegimeNameEnum regimeNm, SupervisoryBodyEnum supervisoryBdy);

	public static class ExtractRegimeInformationDefault extends ExtractRegimeInformation {
		@Override
		protected JurisdictionPartyInformation.JurisdictionPartyInformationBuilder doEvaluate(TransactionReportInstruction transactionReportInstruction, Party party, RegimeNameEnum regimeNm, SupervisoryBodyEnum supervisoryBdy) {
			JurisdictionPartyInformation.JurisdictionPartyInformationBuilder result = JurisdictionPartyInformation.builder();
			return assignOutput(result, transactionReportInstruction, party, regimeNm, supervisoryBdy);
		}
		
		protected JurisdictionPartyInformation.JurisdictionPartyInformationBuilder assignOutput(JurisdictionPartyInformation.JurisdictionPartyInformationBuilder result, TransactionReportInstruction transactionReportInstruction, Party party, RegimeNameEnum regimeNm, SupervisoryBodyEnum supervisoryBdy) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation())
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(regimeNm), CardinalityOperator.All).andNullSafe(areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(supervisoryBdy), CardinalityOperator.All)).get());
			final MapperS<ReportableJurisdictionInformation> thenArg1 = MapperS.of(thenArg0.get());
			final MapperC<JurisdictionPartyInformation> thenArg2 = thenArg1
				.mapSingleToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
			final MapperC<JurisdictionPartyInformation> thenArg3 = thenArg2
				.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), MapperS.of(party), CardinalityOperator.All).get());
			result = toBuilder(MapperS.of(distinctIgnoringPrecision(thenArg3).get()).get());
			
			return Optional.ofNullable(result)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
