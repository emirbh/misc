package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractCommodityClassificationLeg1;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_Leg1CommodityUnderlyerIDRule.DTCC_Leg1CommodityUnderlyerIDRuleDefault.class)
public abstract class DTCC_Leg1CommodityUnderlyerIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ExtractCommodityClassificationLeg1 extractCommodityClassificationLeg1;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
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

	public static class DTCC_Leg1CommodityUnderlyerIDRuleDefault extends DTCC_Leg1CommodityUnderlyerIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			final MapperS<NonTransferableProduct> thenArg2 = thenArg1
				.filterSingleNullSafe(item -> areEqual(MapperS.of(qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(item.get()))), MapperS.of(true), CardinalityOperator.All).get());
			final MapperS<String> thenArg3 = thenArg2
				.mapSingleToItem(item -> MapperS.of(extractCommodityClassificationLeg1.evaluate(item.get(), TaxonomySourceEnum.CFTC, 1)));
			output = thenArg3
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
