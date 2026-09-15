package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CoalPhysicalLeg;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.com.ElectricityPhysicalLeg;
import fpml.consolidated.com.EnvironmentalPhysicalLeg;
import fpml.consolidated.com.FixedLeg;
import fpml.consolidated.com.FloatingLeg;
import fpml.consolidated.com.GasPhysicalLeg;
import fpml.consolidated.com.OilPhysicalLeg;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwapLegListToPayoutList.MapCommoditySwapLegListToPayoutListDefault.class)
public abstract class MapCommoditySwapLegListToPayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCoalPhysicalLegToSettlementPayout mapCoalPhysicalLegToSettlementPayout;
	@Inject protected MapElectricityPhysicalLegToSettlementPayout mapElectricityPhysicalLegToSettlementPayout;
	@Inject protected MapEnvironmentalPhysicalLegToSettlementPayout mapEnvironmentalPhysicalLegToSettlementPayout;
	@Inject protected MapFixedLegToFixedPricePayout mapFixedLegToFixedPricePayout;
	@Inject protected MapFloatingLegToCommodityPayout mapFloatingLegToCommodityPayout;
	@Inject protected MapGasPhysicalLegToSettlementPayout mapGasPhysicalLegToSettlementPayout;
	@Inject protected MapOilPhysicalLegToSettlementPayout mapOilPhysicalLegToSettlementPayout;

	/**
	* @param fpmlCommoditySwapLegList 
	* @param fpmlSettlementCurrency 
	* @param cdmCounterpartyList 
	* @return payoutList 
	*/
	public List<? extends Payout> evaluate(List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, List<? extends Counterparty> cdmCounterpartyList) {
		List<Payout.PayoutBuilder> payoutListBuilder = doEvaluate(fpmlCommoditySwapLegList, fpmlSettlementCurrency, cdmCounterpartyList);
		
		final List<? extends Payout> payoutList;
		if (payoutListBuilder == null) {
			payoutList = null;
		} else {
			payoutList = payoutListBuilder.stream().map(Payout::build).collect(Collectors.toList());
			objectValidator.validate(Payout.class, payoutList);
		}
		
		return payoutList;
	}

	protected abstract List<Payout.PayoutBuilder> doEvaluate(List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommoditySwapLegListToPayoutListDefault extends MapCommoditySwapLegListToPayoutList {
		@Override
		protected List<Payout.PayoutBuilder> doEvaluate(List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, List<? extends Counterparty> cdmCounterpartyList) {
			if (fpmlCommoditySwapLegList == null) {
				fpmlCommoditySwapLegList = Collections.emptyList();
			}
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<Payout.PayoutBuilder> payoutList = new ArrayList<>();
			return assignOutput(payoutList, fpmlCommoditySwapLegList, fpmlSettlementCurrency, cdmCounterpartyList);
		}
		
		protected List<Payout.PayoutBuilder> assignOutput(List<Payout.PayoutBuilder> payoutList, List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, List<? extends Counterparty> cdmCounterpartyList) {
			payoutList.addAll(toBuilder(MapperC.<CommodityLeg>of(fpmlCommoditySwapLegList)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<Payout>ofNull();
					}
					if (switchArgument instanceof FloatingLeg) {
						final FloatingLeg floatingLeg = (FloatingLeg) switchArgument;
						return MapperS.of(mapFloatingLegToCommodityPayout.evaluate(fpmlSettlementCurrency, floatingLeg, cdmCounterpartyList));
					}
					return MapperS.<Payout>ofNull();
				}).getMulti()));
			
			payoutList.addAll(toBuilder(MapperC.<CommodityLeg>of(fpmlCommoditySwapLegList)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<Payout>ofNull();
					}
					if (switchArgument instanceof GasPhysicalLeg) {
						final GasPhysicalLeg gasPhysicalLeg = (GasPhysicalLeg) switchArgument;
						return MapperS.of(mapGasPhysicalLegToSettlementPayout.evaluate(gasPhysicalLeg, cdmCounterpartyList));
					}
					return MapperS.<Payout>ofNull();
				}).getMulti()));
			
			payoutList.addAll(toBuilder(MapperC.<CommodityLeg>of(fpmlCommoditySwapLegList)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<Payout>ofNull();
					}
					if (switchArgument instanceof OilPhysicalLeg) {
						final OilPhysicalLeg oilPhysicalLeg = (OilPhysicalLeg) switchArgument;
						return MapperS.of(mapOilPhysicalLegToSettlementPayout.evaluate(oilPhysicalLeg, cdmCounterpartyList));
					}
					return MapperS.<Payout>ofNull();
				}).getMulti()));
			
			payoutList.addAll(toBuilder(MapperC.<CommodityLeg>of(fpmlCommoditySwapLegList)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<Payout>ofNull();
					}
					if (switchArgument instanceof ElectricityPhysicalLeg) {
						final ElectricityPhysicalLeg electricityPhysicalLeg = (ElectricityPhysicalLeg) switchArgument;
						return MapperS.of(mapElectricityPhysicalLegToSettlementPayout.evaluate(electricityPhysicalLeg, cdmCounterpartyList));
					}
					return MapperS.<Payout>ofNull();
				}).getMulti()));
			
			payoutList.addAll(toBuilder(MapperC.<CommodityLeg>of(fpmlCommoditySwapLegList)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<Payout>ofNull();
					}
					if (switchArgument instanceof EnvironmentalPhysicalLeg) {
						final EnvironmentalPhysicalLeg environmentalPhysicalLeg = (EnvironmentalPhysicalLeg) switchArgument;
						return MapperS.of(mapEnvironmentalPhysicalLegToSettlementPayout.evaluate(environmentalPhysicalLeg, cdmCounterpartyList));
					}
					return MapperS.<Payout>ofNull();
				}).getMulti()));
			
			payoutList.addAll(toBuilder(MapperC.<CommodityLeg>of(fpmlCommoditySwapLegList)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<Payout>ofNull();
					}
					if (switchArgument instanceof CoalPhysicalLeg) {
						final CoalPhysicalLeg coalPhysicalLeg = (CoalPhysicalLeg) switchArgument;
						return MapperS.of(mapCoalPhysicalLegToSettlementPayout.evaluate(coalPhysicalLeg, cdmCounterpartyList));
					}
					return MapperS.<Payout>ofNull();
				}).getMulti()));
			
			payoutList.addAll(toBuilder(MapperC.<CommodityLeg>of(fpmlCommoditySwapLegList)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<Payout>ofNull();
					}
					if (switchArgument instanceof FixedLeg) {
						final FixedLeg fixedLeg = (FixedLeg) switchArgument;
						return MapperS.of(mapFixedLegToFixedPricePayout.evaluate(fixedLeg, cdmCounterpartyList));
					}
					return MapperS.<Payout>ofNull();
				}).getMulti()));
			
			return Optional.ofNullable(payoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
