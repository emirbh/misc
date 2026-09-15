package drr.regulation.common.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetRegimeSpecificIdentifiers.GetRegimeSpecificIdentifiersDefault.class)
public abstract class GetRegimeSpecificIdentifiers implements RosettaFunction {

	/**
	* @param reportableInformation 
	* @param supervisoryBody 
	* @param tradeIdentifierType 
	* @return regimeSpecificIdentifiers 
	*/
	public List<String> evaluate(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifierTypeEnum tradeIdentifierType) {
		List<String> regimeSpecificIdentifiers = doEvaluate(reportableInformation, supervisoryBody, tradeIdentifierType);
		
		return regimeSpecificIdentifiers;
	}

	protected abstract List<String> doEvaluate(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifierTypeEnum tradeIdentifierType);

	protected abstract MapperC<? extends TradeIdentifier> regimeTransactionIds(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifierTypeEnum tradeIdentifierType);

	public static class GetRegimeSpecificIdentifiersDefault extends GetRegimeSpecificIdentifiers {
		@Override
		protected List<String> doEvaluate(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifierTypeEnum tradeIdentifierType) {
			if (supervisoryBody == null) {
				supervisoryBody = Collections.emptyList();
			}
			List<String> regimeSpecificIdentifiers = new ArrayList<>();
			return assignOutput(regimeSpecificIdentifiers, reportableInformation, supervisoryBody, tradeIdentifierType);
		}
		
		protected List<String> assignOutput(List<String> regimeSpecificIdentifiers, ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifierTypeEnum tradeIdentifierType) {
			if (exists(regimeTransactionIds(reportableInformation, supervisoryBody, tradeIdentifierType)).getOrDefault(false)) {
				regimeSpecificIdentifiers.addAll(regimeTransactionIds(reportableInformation, supervisoryBody, tradeIdentifierType).<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti());
			} else {
				regimeSpecificIdentifiers.addAll(Collections.<String>emptyList());
			}
			
			return regimeSpecificIdentifiers;
		}
		
		@Override
		protected MapperC<? extends TradeIdentifier> regimeTransactionIds(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifierTypeEnum tradeIdentifierType) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(reportableInformation).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", _reportableInformation -> _reportableInformation.getJurisdictionInformation());
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBody), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any).get());
			return thenArg1.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<TradeIdentifier>map("getTransactionIdentifier", transactionInformation -> transactionInformation.getTransactionIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(tradeIdentifierType), CardinalityOperator.All).get());
		}
	}
}
