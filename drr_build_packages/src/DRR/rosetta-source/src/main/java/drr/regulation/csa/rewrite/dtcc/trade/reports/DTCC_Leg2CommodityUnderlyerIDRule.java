package drr.regulation.csa.rewrite.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractCommodityClassificationLeg1;
import drr.regulation.common.functions.ExtractCommodityClassificationLeg2;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.IsCSALeg2Aligned;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_Leg2CommodityUnderlyerIDRule.DTCC_Leg2CommodityUnderlyerIDRuleDefault.class)
public abstract class DTCC_Leg2CommodityUnderlyerIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ExtractCommodityClassificationLeg1 extractCommodityClassificationLeg1;
	@Inject protected ExtractCommodityClassificationLeg2 extractCommodityClassificationLeg2;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCSALeg2Aligned isCSALeg2Aligned;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;

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

	public static class DTCC_Leg2CommodityUnderlyerIDRuleDefault extends DTCC_Leg2CommodityUnderlyerIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get())))), MapperS.of(true), CardinalityOperator.All).get());
			final MapperS<String> ifThenElseResult;
			if (areEqual(MapperS.of(isCSALeg2Aligned.evaluate(thenArg1.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = thenArg1
					.mapSingleToItem(item -> MapperS.of(extractCommodityClassificationLeg2.evaluate(productForEvent.evaluate(item.get()), TaxonomySourceEnum.CSA, 1)));
			} else {
				ifThenElseResult = thenArg1
					.mapSingleToItem(item -> MapperS.of(extractCommodityClassificationLeg1.evaluate(productForEvent.evaluate(item.get()), TaxonomySourceEnum.CSA, 1)));
			}
			output = ifThenElseResult
				.mapSingleToItem(item -> {
					if (areEqual(MapperC.<String>of(MapperS.of("Agricultural"), MapperS.of("Benzene"), MapperS.of("Bullion"), MapperS.of("Coal"), MapperS.of("Composite Commodity Indices"), MapperS.of("Diesel Fuel"), MapperS.of("Electricity"), MapperS.of("Emissions Allowances"), MapperS.of("Ethanol and Bio Fuels"), MapperS.of("Fuel Oil"), MapperS.of("Freight"), MapperS.of("Gas Oil"), MapperS.of("Gasoline"), MapperS.of("Heating Oil"), MapperS.of("Jet Fuel"), MapperS.of("Kerosene"), MapperS.of("Metals"), MapperS.of("Methanol"), MapperS.of("Naptha"), MapperS.of("Natural Gas"), MapperS.of("NGL"), MapperS.of("Oil"), MapperS.of("Paper"), MapperS.of("Plastic"), MapperS.of("Weather")), item, CardinalityOperator.Any).getOrDefault(false)) {
						return item;
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
