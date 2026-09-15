package cdm.ingest.fpml.confirmation.tradestate.functions;

import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.AssetMeasureType;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.doc.Trade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapTradeLotList.MapTradeLotListDefault.class)
public abstract class MapTradeLotList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPriceQuantityList mapPriceQuantityList;

	/**
	* @param fpmlTrade 
	* @param fpmlQuoteList 
	* @return tradeLotList 
	*/
	public List<? extends TradeLot> evaluate(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
		List<TradeLot.TradeLotBuilder> tradeLotListBuilder = doEvaluate(fpmlTrade, fpmlQuoteList);
		
		final List<? extends TradeLot> tradeLotList;
		if (tradeLotListBuilder == null) {
			tradeLotList = null;
		} else {
			tradeLotList = tradeLotListBuilder.stream().map(TradeLot::build).collect(Collectors.toList());
			objectValidator.validate(TradeLot.class, tradeLotList);
		}
		
		return tradeLotList;
	}

	protected abstract List<TradeLot.TradeLotBuilder> doEvaluate(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList);

	protected abstract MapperS<? extends BasicQuotation> quotationModel(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList);

	public static class MapTradeLotListDefault extends MapTradeLotList {
		@Override
		protected List<TradeLot.TradeLotBuilder> doEvaluate(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			if (fpmlQuoteList == null) {
				fpmlQuoteList = Collections.emptyList();
			}
			List<TradeLot.TradeLotBuilder> tradeLotList = new ArrayList<>();
			return assignOutput(tradeLotList, fpmlTrade, fpmlQuoteList);
		}
		
		protected List<TradeLot.TradeLotBuilder> assignOutput(List<TradeLot.TradeLotBuilder> tradeLotList, Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			final TradeLot tradeLot = TradeLot.builder()
				.setPriceQuantity(new ArrayList(mapPriceQuantityList.evaluate(fpmlTrade, quotationModel(fpmlTrade, fpmlQuoteList).get())))
				.build();
			if (tradeLot == null) {
				tradeLotList.addAll(toBuilder(Collections.<TradeLot>emptyList()));
			} else {
				tradeLotList.addAll(toBuilder(Collections.singletonList(tradeLot)));
			}
			
			return Optional.ofNullable(tradeLotList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends BasicQuotation> quotationModel(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			final MapperC<BasicQuotation> thenArg = MapperC.<BasicQuotation>of(fpmlQuoteList)
				.filterItemNullSafe(item -> areEqual(item.<AssetMeasureType>map("getMeasureType", basicQuotation -> basicQuotation.getMeasureType()).<String>map("getValue", assetMeasureType -> assetMeasureType.getValue()), MapperS.of("PriceNotation"), CardinalityOperator.All).get());
			return MapperS.of(thenArg.get());
		}
	}
}
