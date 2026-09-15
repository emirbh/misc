package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.hkma.tr.AmountAndDirection106__1;
import iso20022.auth030.hkma.tr.Package4__1;
import iso20022.auth030.hkma.tr.SecuritiesTransactionPrice17Choice__1;
import iso20022.auth030.hkma.tr.SecuritiesTransactionPrice20Choice__1;
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
	public Package4__1 evaluate(HKMATransactionReport drrReport) {
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

	protected abstract Package4__1.Package4__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetPackgDefault extends GetPackg {
		@Override
		protected Package4__1.Package4__1Builder doEvaluate(HKMATransactionReport drrReport) {
			Package4__1.Package4__1Builder packg = Package4__1.builder();
			return assignOutput(packg, drrReport);
		}
		
		protected Package4__1.Package4__1Builder assignOutput(Package4__1.Package4__1Builder packg, HKMATransactionReport drrReport) {
			packg = toBuilder(Package4__1.builder()
				.setCmplxTradId(MapperS.of(drrReport).<String>map("getPackageIdentifier", hKMATransactionReport -> hKMATransactionReport.getPackageIdentifier()).get())
				.setFxSwpLkId(MapperS.of(drrReport).<String>map("getSwapLinkID", hKMATransactionReport -> hKMATransactionReport.getSwapLinkID()).get())
				.setPric(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						Boolean ifThenElseResult = null;
						if (lessThan(item.<PriceFormat>map("getPackageTransactionPrice", hKMATransactionReport -> hKMATransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPackageTransactionPrice", hKMATransactionReport -> hKMATransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(item.<ISOCurrencyCodeEnum>map("getPackageTransactionPriceCurrency", hKMATransactionReport -> hKMATransactionReport.getPackageTransactionPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult)
								.build())
							.setDcml(item.<PriceFormat>map("getPackageTransactionPrice", hKMATransactionReport -> hKMATransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build());
					}).get())
				.setSprd(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						Boolean ifThenElseResult = null;
						if (lessThan(item.<PriceFormat>map("getPackageTransactionSpread", hKMATransactionReport -> hKMATransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						final BigDecimal bigDecimal = item.<PriceFormat>map("getPackageTransactionSpread", hKMATransactionReport -> hKMATransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get();
						return MapperS.of(SecuritiesTransactionPrice20Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPackageTransactionSpread", hKMATransactionReport -> hKMATransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(item.<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", hKMATransactionReport -> hKMATransactionReport.getPackageTransactionSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult)
								.build())
							.setDcml(item.<PriceFormat>map("getPackageTransactionSpread", hKMATransactionReport -> hKMATransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
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
