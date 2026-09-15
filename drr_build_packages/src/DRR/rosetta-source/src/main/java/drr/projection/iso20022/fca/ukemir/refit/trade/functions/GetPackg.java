package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd13DecimalAmount__1;
import iso20022.auth030.fca.AmountAndDirection106__1;
import iso20022.auth030.fca.Package4__1;
import iso20022.auth030.fca.SecuritiesTransactionPrice17Choice__1;
import iso20022.auth030.fca.SecuritiesTransactionPrice20Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetPackg.GetPackgDefault.class)
public abstract class GetPackg implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;

	/**
	* @param drrReport 
	* @return packg 
	*/
	public Package4__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		Package4__1.Package4__1Builder packgBuilder = doEvaluate(drrReport);
		
		final Package4__1 packg;
		if (packgBuilder == null) {
			packg = null;
		} else {
			packg = packgBuilder.build();
			objectValidator.validate(Package4__1.class, packg);
		}
		
		return packg;
	}

	protected abstract Package4__1.Package4__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetPackgDefault extends GetPackg {
		@Override
		protected Package4__1.Package4__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			Package4__1.Package4__1Builder packg = Package4__1.builder();
			return assignOutput(packg, drrReport);
		}
		
		protected Package4__1.Package4__1Builder assignOutput(Package4__1.Package4__1Builder packg, FCAUKEMIRTransactionReport drrReport) {
			packg = toBuilder(Package4__1.builder()
				.setCmplxTradId(MapperS.of(drrReport).<String>map("getPackageIdentifier", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageIdentifier()).get())
				.setPric(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						Boolean ifThenElseResult0 = null;
						if (lessThan(item.<PriceFormat>map("getPackageTransactionPrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult0 = false;
						}
						final BigDecimal ifThenElseResult1;
						if (exists(item.<PriceFormat>map("getPackageTransactionPrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage())).getOrDefault(false)) {
							ifThenElseResult1 = item.<PriceFormat>map("getPackageTransactionPrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get();
						} else if (exists(item.<PriceFormat>map("getPackageTransactionPrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).getOrDefault(false)) {
							ifThenElseResult1 = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(item.<PriceFormat>map("getPackageTransactionPrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()), MapperS.of(BigDecimal.valueOf(100))).get();
						} else {
							ifThenElseResult1 = null;
						}
						return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPackageTransactionPrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPackageTransactionPriceCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult0)
								.build())
							.setPctg(ifThenElseResult1)
							.build());
					}).get())
				.setSprd(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						Boolean ifThenElseResult = null;
						if (lessThan(item.<PriceFormat>map("getPackageTransactionSpread", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						final BigDecimal bigDecimal = item.<PriceFormat>map("getPackageTransactionSpread", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get();
						return MapperS.of(SecuritiesTransactionPrice20Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPackageTransactionSpread", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult)
								.build())
							.setPctg(item.<PriceFormat>map("getPackageTransactionSpread", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get())
							.setBsisPtSprd((bigDecimal == null ? null : bigDecimal.intValueExact()))
							.build());
					}).get())
				.build());
			
			return Optional.ofNullable(packg)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
