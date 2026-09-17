package cdm.ingest.fpml.confirmation.product.genericproduct.functions;

import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapAssetToObservableWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithLocation;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.shared.CashflowNotional;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapGenericProductPriceQuantityList.MapGenericProductPriceQuantityListDefault.class)
public abstract class MapGenericProductPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetToObservableWithLocation mapAssetToObservableWithLocation;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapNotionalAmountToQuantityWithLocation mapNotionalAmountToQuantityWithLocation;

	/**
	* @param fpmlGenericProduct 
	* @param fpmlQuotation 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlGenericProduct, fpmlQuotation);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation);

	protected abstract MapperS<BigDecimal> quotationModelValue(GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation);

	protected abstract MapperS<? extends FieldWithMetaString> unitFromQuotation(GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation);

	protected abstract MapperS<? extends FieldWithMetaString> unitFromNotional(GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation);

	public static class MapGenericProductPriceQuantityListDefault extends MapGenericProductPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlGenericProduct, fpmlQuotation);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation) {
			final FieldWithMetaString ifThenElseResult;
			if (exists(unitFromQuotation(fpmlGenericProduct, fpmlQuotation)).getOrDefault(false)) {
				ifThenElseResult = unitFromQuotation(fpmlGenericProduct, fpmlQuotation).get();
			} else {
				ifThenElseResult = unitFromNotional(fpmlGenericProduct, fpmlQuotation).get();
			}
			final PriceSchedule priceSchedule = PriceSchedule.builder()
				.setValue(quotationModelValue(fpmlGenericProduct, fpmlQuotation).get())
				.setUnit(UnitType.builder()
					.setCurrency(ifThenElseResult)
					.build())
				.setPerUnitOf(UnitType.builder()
					.setCurrency(unitFromNotional(fpmlGenericProduct, fpmlQuotation).get())
					.build())
				.setPriceType(PriceTypeEnum.ASSET_PRICE)
				.build();
			final MapperC<CashflowNotional> thenArg0 = MapperS.of(fpmlGenericProduct).<CashflowNotional>mapC("getNotional", genericProduct -> genericProduct.getNotional());
			final MapperS<Asset> thenArg1 = MapperS.of(fpmlGenericProduct).<TradeUnderlyer2>mapC("getUnderlyer", genericProduct -> genericProduct.getUnderlyer()).<Asset>map("getUnderlyingAsset", tradeUnderlyer2 -> tradeUnderlyer2.getUnderlyingAsset())
				.first();
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setPriceValue((priceSchedule == null ? Collections.<PriceSchedule>emptyList() : Collections.singletonList(priceSchedule)))
				.setQuantity(thenArg0
					.mapItem(item -> MapperS.of(mapNotionalAmountToQuantityWithLocation.evaluate(item.<BigDecimal>map("getAmount", cashflowNotional -> cashflowNotional.getAmount()).get(), Collections.<Step>emptyList(), item.<Currency>map("getCurrency", cashflowNotional -> cashflowNotional.getCurrency()).get(), null))).getMulti())
				.setObservable(thenArg1
					.mapSingleToItem(item -> MapperS.of(mapAssetToObservableWithLocation.evaluate(item.get()))).get())
				.build();
			if (priceQuantity == null) {
				priceQuantityList.addAll(toBuilder(Collections.<PriceQuantity>emptyList()));
			} else {
				priceQuantityList.addAll(toBuilder(Collections.singletonList(priceQuantity)));
			}
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> quotationModelValue(GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation) {
			return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(fpmlQuotation).<BigDecimal>map("getValue", basicQuotation -> basicQuotation.getValue()), MapperS.of(BigDecimal.valueOf(100)));
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> unitFromQuotation(GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation) {
			if (exists(MapperS.of(fpmlQuotation).<Currency>map("getCurrency", basicQuotation -> basicQuotation.getCurrency())).getOrDefault(false)) {
				return MapperS.of(mapCurrency.evaluate(MapperS.of(fpmlQuotation).<Currency>map("getCurrency", basicQuotation -> basicQuotation.getCurrency()).get()));
			}
			return MapperS.<FieldWithMetaString>ofNull();
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> unitFromNotional(GenericProduct fpmlGenericProduct, BasicQuotation fpmlQuotation) {
			final MapperC<CashflowNotional> thenArg0 = MapperS.of(fpmlGenericProduct).<CashflowNotional>mapC("getNotional", genericProduct -> genericProduct.getNotional());
			final MapperC<FieldWithMetaString> thenArg1 = thenArg0
				.mapItem(item -> {
					Currency ifThenElseResult = null;
					if (exists(item.<Currency>map("getCurrency", cashflowNotional -> cashflowNotional.getCurrency())).getOrDefault(false)) {
						ifThenElseResult = item.<Currency>map("getCurrency", cashflowNotional -> cashflowNotional.getCurrency()).get();
					}
					return MapperS.of(mapCurrency.evaluate(ifThenElseResult));
				});
			return MapperS.of(thenArg1.get());
		}
	}
}
