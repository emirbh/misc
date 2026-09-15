package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.Extract_UnderlyingAssetTradingPlatformIdentifier;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlyingAssetTradingPlatformIdentifierLeg1Rule;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlyingAssetTradingPlatformIdentifierLeg2Rule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingAssetTradingPlatformIdentifierRule.UnderlyingAssetTradingPlatformIdentifierRuleDefault.class)
public abstract class UnderlyingAssetTradingPlatformIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Extract_UnderlyingAssetTradingPlatformIdentifier extract_UnderlyingAssetTradingPlatformIdentifier;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected UnderlyingAssetTradingPlatformIdentifierLeg1Rule underlyingAssetTradingPlatformIdentifierLeg1Rule;
	@Inject protected UnderlyingAssetTradingPlatformIdentifierLeg2Rule underlyingAssetTradingPlatformIdentifierLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingAssetTradingPlatformIdentifierRuleDefault extends UnderlyingAssetTradingPlatformIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					final String string0 = underlyingAssetTradingPlatformIdentifierLeg1Rule.evaluate(item.get());
					if ((string0 == null ? exists(MapperS.<FieldWithMetaString>ofNull()).getOrDefault(false) : exists(MapperS.of(FieldWithMetaString.builder().setValue(string0).build())).getOrDefault(false))) {
						return MapperS.of(underlyingAssetTradingPlatformIdentifierLeg1Rule.evaluate(item.get()));
					}
					final String string1 = underlyingAssetTradingPlatformIdentifierLeg1Rule.evaluate(item.get());
					final String string2 = underlyingAssetTradingPlatformIdentifierLeg2Rule.evaluate(item.get());
					if ((string1 == null ? notExists(MapperS.<FieldWithMetaString>ofNull()) : notExists(MapperS.of(FieldWithMetaString.builder().setValue(string1).build()))).andNullSafe((string2 == null ? exists(MapperS.<FieldWithMetaString>ofNull()) : exists(MapperS.of(FieldWithMetaString.builder().setValue(string2).build())))).getOrDefault(false)) {
						return MapperS.of(underlyingAssetTradingPlatformIdentifierLeg2Rule.evaluate(item.get()));
					}
					return MapperS.of(extract_UnderlyingAssetTradingPlatformIdentifier.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get()));
				}).get();
			
			return output;
		}
	}
}
