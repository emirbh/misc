package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.common.functions.GetMultiplerUnitTypeUnderlyingAsset;
import cdm.ingest.fpml.confirmation.common.functions.GetUnitTypeForUnderlyingAsset;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eqd.EquityDerivativeBase;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapEquityDerivativeBaseQuantityListWithLocation.MapEquityDerivativeBaseQuantityListWithLocationDefault.class)
public abstract class MapEquityDerivativeBaseQuantityListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected GetMultiplerUnitTypeUnderlyingAsset getMultiplerUnitTypeUnderlyingAsset;
	@Inject protected GetUnitTypeForUnderlyingAsset getUnitTypeForUnderlyingAsset;
	@Inject protected MapCurrencyAmountToQuantity mapCurrencyAmountToQuantity;
	@Inject protected MapNumberOfOptionsAndOptionEntitlementToQuantity mapNumberOfOptionsAndOptionEntitlementToQuantity;
	@Inject protected MapOpenUnitsToQuantity mapOpenUnitsToQuantity;

	/**
	* @param fpmlEquityDerivativeBase 
	* @param fpmlNumberOfOptions 
	* @param fpmlOptionEntitlement 
	* @param fpmlOpenUnits 
	* @return quantityList 
	*/
	public List<? extends FieldWithMetaNonNegativeQuantitySchedule> evaluate(EquityDerivativeBase fpmlEquityDerivativeBase, BigDecimal fpmlNumberOfOptions, BigDecimal fpmlOptionEntitlement, BigDecimal fpmlOpenUnits) {
		List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityListBuilder = doEvaluate(fpmlEquityDerivativeBase, fpmlNumberOfOptions, fpmlOptionEntitlement, fpmlOpenUnits);
		
		final List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantityList;
		if (quantityListBuilder == null) {
			quantityList = null;
		} else {
			quantityList = quantityListBuilder.stream().map(FieldWithMetaNonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, quantityList);
		}
		
		return quantityList;
	}

	protected abstract List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(EquityDerivativeBase fpmlEquityDerivativeBase, BigDecimal fpmlNumberOfOptions, BigDecimal fpmlOptionEntitlement, BigDecimal fpmlOpenUnits);

	public static class MapEquityDerivativeBaseQuantityListWithLocationDefault extends MapEquityDerivativeBaseQuantityListWithLocation {
		@Override
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(EquityDerivativeBase fpmlEquityDerivativeBase, BigDecimal fpmlNumberOfOptions, BigDecimal fpmlOptionEntitlement, BigDecimal fpmlOpenUnits) {
			List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityList = new ArrayList<>();
			return assignOutput(quantityList, fpmlEquityDerivativeBase, fpmlNumberOfOptions, fpmlOptionEntitlement, fpmlOpenUnits);
		}
		
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> assignOutput(List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityList, EquityDerivativeBase fpmlEquityDerivativeBase, BigDecimal fpmlNumberOfOptions, BigDecimal fpmlOptionEntitlement, BigDecimal fpmlOpenUnits) {
			if (exists(MapperS.of(fpmlNumberOfOptions)).orNullSafe(exists(MapperS.of(fpmlOptionEntitlement))).getOrDefault(false)) {
				final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule0 = createQuantityWithLocation.evaluate(mapNumberOfOptionsAndOptionEntitlementToQuantity.evaluate(fpmlNumberOfOptions, MapperS.of(getMultiplerUnitTypeUnderlyingAsset.evaluate(MapperS.of(fpmlEquityDerivativeBase).<Underlyer>map("getUnderlyer", equityDerivativeBase -> equityDerivativeBase.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<Asset>map("getUnderlyingAsset", singleUnderlyer -> singleUnderlyer.getUnderlyingAsset()).get())).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()).get(), fpmlOptionEntitlement, MapperS.of(fpmlEquityDerivativeBase).<NonNegativeMoney>map("getNotional", equityDerivativeBase -> equityDerivativeBase.getNotional()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get()), createQuantityKey.evaluate("numberOfOptions", null));
				if (fieldWithMetaNonNegativeQuantitySchedule0 == null) {
					quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
				} else {
					quantityList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule0)));
				}
			} else {
				quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			}
			
			if (exists(MapperS.of(fpmlEquityDerivativeBase).<NonNegativeMoney>map("getNotional", equityDerivativeBase -> equityDerivativeBase.getNotional())).getOrDefault(false)) {
				final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule1 = createQuantityWithLocation.evaluate(mapCurrencyAmountToQuantity.evaluate(MapperS.of(fpmlEquityDerivativeBase).<NonNegativeMoney>map("getNotional", equityDerivativeBase -> equityDerivativeBase.getNotional()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlEquityDerivativeBase).<NonNegativeMoney>map("getNotional", equityDerivativeBase -> equityDerivativeBase.getNotional()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), null), createQuantityKey.evaluate("notional", null));
				if (fieldWithMetaNonNegativeQuantitySchedule1 == null) {
					quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
				} else {
					quantityList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule1)));
				}
			} else {
				quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			}
			
			if (exists(MapperS.of(fpmlOpenUnits)).getOrDefault(false)) {
				final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule2 = createQuantityWithLocation.evaluate(mapOpenUnitsToQuantity.evaluate(fpmlOpenUnits, MapperS.of(getUnitTypeForUnderlyingAsset.evaluate(MapperS.of(fpmlEquityDerivativeBase).<Underlyer>map("getUnderlyer", equityDerivativeBase -> equityDerivativeBase.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<Asset>map("getUnderlyingAsset", singleUnderlyer -> singleUnderlyer.getUnderlyingAsset()).get())).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()).get(), null), createQuantityKey.evaluate("openUnits", null));
				if (fieldWithMetaNonNegativeQuantitySchedule2 == null) {
					quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
				} else {
					quantityList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule2)));
				}
			} else {
				quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			}
			
			return Optional.ofNullable(quantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
