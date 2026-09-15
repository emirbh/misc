package drr.regulation.cftc.rewrite.margin.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.functions.GetRegimeSpecificIdentifiers;
import java.util.Collections;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueSwapIdentifierRule.UniqueSwapIdentifierRuleDefault.class)
public abstract class UniqueSwapIdentifierRule implements ReportFunction<CollateralReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetRegimeSpecificIdentifiers getRegimeSpecificIdentifiers;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstruction input);

	public static class UniqueSwapIdentifierRuleDefault extends UniqueSwapIdentifierRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			final MapperC<String> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> {
					final SupervisoryBodyEnum supervisoryBodyEnum0 = SupervisoryBodyEnum.CFTC;
					if (exists(MapperC.<String>of(getRegimeSpecificIdentifiers.evaluate(item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum0 == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum0)), TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER))).getOrDefault(false)) {
						final SupervisoryBodyEnum supervisoryBodyEnum1 = SupervisoryBodyEnum.CFTC;
						return MapperC.<String>of(getRegimeSpecificIdentifiers.evaluate(item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum1 == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum1)), TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER));
					}
					final MapperS<TradeIdentifier> _thenArg0 = item
						.mapSingleToItem(_item -> _item.<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<TradeIdentifier>map("getUniqueTradeIdentifier", collateralDetails -> collateralDetails.getUniqueTradeIdentifier()));
					final MapperS<TradeIdentifier> _thenArg1 = _thenArg0
						.filterSingleNullSafe(_item -> areEqual(_item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER), CardinalityOperator.All).get());
					return _thenArg1
						.mapSingleToList(_item -> _item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier())).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue());
				});
			final MapperC<String> thenArg1 = distinctIgnoringPrecision(thenArg0);
			output = MapperS.of(thenArg1.get()).get();
			
			return output;
		}
	}
}
