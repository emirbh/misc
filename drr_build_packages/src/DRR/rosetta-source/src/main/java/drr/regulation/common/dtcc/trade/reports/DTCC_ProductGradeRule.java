package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.asset.commodity.ProductGradeEnum;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.CommodityPayout;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(DTCC_ProductGradeRule.DTCC_ProductGradeRuleDefault.class)
public abstract class DTCC_ProductGradeRule implements ReportFunction<TransactionReportInstruction, List<? extends ProductGradeReport>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends ProductGradeReport> evaluate(TransactionReportInstruction input) {
		List<ProductGradeReport.ProductGradeReportBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends ProductGradeReport> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(ProductGradeReport::build).collect(Collectors.toList());
			objectValidator.validate(ProductGradeReport.class, output);
		}
		
		return output;
	}

	protected abstract List<ProductGradeReport.ProductGradeReportBuilder> doEvaluate(TransactionReportInstruction input);

	public static class DTCC_ProductGradeRuleDefault extends DTCC_ProductGradeRule {
		@Override
		protected List<ProductGradeReport.ProductGradeReportBuilder> doEvaluate(TransactionReportInstruction input) {
			List<ProductGradeReport.ProductGradeReportBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<ProductGradeReport.ProductGradeReportBuilder> assignOutput(List<ProductGradeReport.ProductGradeReportBuilder> output, TransactionReportInstruction input) {
			final MapperS<EconomicTerms> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))));
			final MapperS<EconomicTerms> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> qualify_AssetClass_Commodity.evaluate(item.get()));
			final MapperC<CommodityPayout> thenArg2 = thenArg1
				.mapSingleToList(item -> item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()));
			output = toBuilder(thenArg2
				.mapItem(item -> MapperS.of(ProductGradeReport.builder()
					.setProductGrade(item.<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery()).<ProductGradeEnum>mapC("getCommodityGrade", assetDeliveryInformation -> assetDeliveryInformation.getCommodityGrade())
						.mapItem(_item -> _item.map("to-string", ProductGradeEnum::toDisplayString)).getMulti())
					.build())).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
