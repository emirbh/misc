package drr.standards.iosco.uti.functions;

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
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;
import drr.regulation.common.functions.GetRegimeSpecificIdentifiers;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueSwapIdentifierForValuation.UniqueSwapIdentifierForValuationDefault.class)
public abstract class UniqueSwapIdentifierForValuation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetRegimeSpecificIdentifiers getRegimeSpecificIdentifiers;

	/**
	* @param valuationReportInstruction 
	* @param supervisoryBody 
	* @return usi 
	*/
	public String evaluate(ValuationReportInstruction valuationReportInstruction, List<SupervisoryBodyEnum> supervisoryBody) {
		String usi = doEvaluate(valuationReportInstruction, supervisoryBody);
		
		return usi;
	}

	protected abstract String doEvaluate(ValuationReportInstruction valuationReportInstruction, List<SupervisoryBodyEnum> supervisoryBody);

	public static class UniqueSwapIdentifierForValuationDefault extends UniqueSwapIdentifierForValuation {
		@Override
		protected String doEvaluate(ValuationReportInstruction valuationReportInstruction, List<SupervisoryBodyEnum> supervisoryBody) {
			if (supervisoryBody == null) {
				supervisoryBody = Collections.emptyList();
			}
			String usi = null;
			return assignOutput(usi, valuationReportInstruction, supervisoryBody);
		}
		
		protected String assignOutput(String usi, ValuationReportInstruction valuationReportInstruction, List<SupervisoryBodyEnum> supervisoryBody) {
			final MapperS<TradeIdentifier> thenArg0 = MapperS.of(valuationReportInstruction).<ValuationDetails>map("getValuationDetails", _valuationReportInstruction -> _valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<TradeIdentifier>map("getUniqueTradeIdentifier", valuationTradeInformation -> valuationTradeInformation.getUniqueTradeIdentifier());
			final MapperS<TradeIdentifier> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER), CardinalityOperator.All).get());
			final MapperC<String> thenArg2 = MapperC.<String>of(getRegimeSpecificIdentifiers.evaluate(MapperS.of(valuationReportInstruction).<ReportableInformation>map("getReportableInformation", _valuationReportInstruction -> _valuationReportInstruction.getReportableInformation()).get(), supervisoryBody, TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER)).getMulti().isEmpty() ? thenArg1
				.mapSingleToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier())).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()) : MapperC.<String>of(getRegimeSpecificIdentifiers.evaluate(MapperS.of(valuationReportInstruction).<ReportableInformation>map("getReportableInformation", _valuationReportInstruction -> _valuationReportInstruction.getReportableInformation()).get(), supervisoryBody, TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER));
			final MapperC<String> thenArg3 = distinctIgnoringPrecision(thenArg2);
			usi = MapperS.of(thenArg3.get()).get();
			
			return usi;
		}
	}
}
