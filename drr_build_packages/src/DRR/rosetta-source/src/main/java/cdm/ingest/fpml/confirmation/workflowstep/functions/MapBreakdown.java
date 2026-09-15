package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.event.common.PartyChangeInstruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.QuantityChangeInstruction;
import cdm.event.common.TransferInstruction;
import cdm.observable.asset.FeeTypeEnum;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.TradeLegSizeChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Payment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapBreakdown.MapBreakdownDefault.class)
public abstract class MapBreakdown implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoneyToNonNegativeQuantitySchedule mapMoneyToNonNegativeQuantitySchedule;
	@Inject protected MapNonNegativeMoneyNonNegativeQuantitySchedule mapNonNegativeMoneyNonNegativeQuantitySchedule;
	@Inject protected MapPartyChangeInstruction mapPartyChangeInstruction;
	@Inject protected MapTransferInstruction mapTransferInstruction;

	/**
	* @param fpmlNovation 
	* @return breakdown 
	*/
	public List<? extends PrimitiveInstruction> evaluate(TradeNovationContent fpmlNovation) {
		List<PrimitiveInstruction.PrimitiveInstructionBuilder> breakdownBuilder = doEvaluate(fpmlNovation);
		
		final List<? extends PrimitiveInstruction> breakdown;
		if (breakdownBuilder == null) {
			breakdown = null;
		} else {
			breakdown = breakdownBuilder.stream().map(PrimitiveInstruction::build).collect(Collectors.toList());
			objectValidator.validate(PrimitiveInstruction.class, breakdown);
		}
		
		return breakdown;
	}

	protected abstract List<PrimitiveInstruction.PrimitiveInstructionBuilder> doEvaluate(TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends Money> novatedAmount(TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeMoney> changeInNotionalAmount(TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> newTradeAmount(TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeMoney> outstandingNotionalAmount(TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends Money> remainingAmount(TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> oldTradeAmount(TradeNovationContent fpmlNovation);

	protected abstract MapperS<? extends PartyChangeInstruction> partyChange(TradeNovationContent fpmlNovation);

	protected abstract MapperS<? extends TransferInstruction> transfer(TradeNovationContent fpmlNovation);

	public static class MapBreakdownDefault extends MapBreakdown {
		@Override
		protected List<PrimitiveInstruction.PrimitiveInstructionBuilder> doEvaluate(TradeNovationContent fpmlNovation) {
			List<PrimitiveInstruction.PrimitiveInstructionBuilder> breakdown = new ArrayList<>();
			return assignOutput(breakdown, fpmlNovation);
		}
		
		protected List<PrimitiveInstruction.PrimitiveInstructionBuilder> assignOutput(List<PrimitiveInstruction.PrimitiveInstructionBuilder> breakdown, TradeNovationContent fpmlNovation) {
			if (exists(newTradeAmount(fpmlNovation)).getOrDefault(false)) {
				final PriceQuantity priceQuantity0 = PriceQuantity.builder()
					.setQuantityValue(new ArrayList<>(newTradeAmount(fpmlNovation).getMulti()))
					.build();
				final PrimitiveInstruction primitiveInstruction0 = PrimitiveInstruction.builder()
					.setQuantityChange(QuantityChangeInstruction.builder()
						.setChange((priceQuantity0 == null ? Collections.<PriceQuantity>emptyList() : Collections.singletonList(priceQuantity0)))
						.setDirection(QuantityChangeDirectionEnum.REPLACE)
						.build())
					.setPartyChange(partyChange(fpmlNovation).get())
					.setTransfer(transfer(fpmlNovation).get())
					.build();
				if (primitiveInstruction0 == null) {
					breakdown.addAll(toBuilder(Collections.<PrimitiveInstruction>emptyList()));
				} else {
					breakdown.addAll(toBuilder(Collections.singletonList(primitiveInstruction0)));
				}
			} else {
				breakdown.addAll(toBuilder(Collections.<PrimitiveInstruction>emptyList()));
			}
			
			if (exists(oldTradeAmount(fpmlNovation)).orNullSafe(exists(newTradeAmount(fpmlNovation))).getOrDefault(false)) {
				final PriceQuantity priceQuantity1 = PriceQuantity.builder()
					.setQuantityValue((oldTradeAmount(fpmlNovation).getMulti().isEmpty() ? new ArrayList<>(newTradeAmount(fpmlNovation).getMulti()) : new ArrayList<>(oldTradeAmount(fpmlNovation).getMulti())))
					.build();
				final QuantityChangeDirectionEnum ifThenElseResult;
				if (exists(oldTradeAmount(fpmlNovation)).getOrDefault(false)) {
					ifThenElseResult = QuantityChangeDirectionEnum.REPLACE;
				} else {
					ifThenElseResult = QuantityChangeDirectionEnum.DECREASE;
				}
				final PrimitiveInstruction primitiveInstruction1 = PrimitiveInstruction.builder()
					.setQuantityChange(QuantityChangeInstruction.builder()
						.setChange((priceQuantity1 == null ? Collections.<PriceQuantity>emptyList() : Collections.singletonList(priceQuantity1)))
						.setDirection(ifThenElseResult)
						.build())
					.build();
				if (primitiveInstruction1 == null) {
					breakdown.addAll(toBuilder(Collections.<PrimitiveInstruction>emptyList()));
				} else {
					breakdown.addAll(toBuilder(Collections.singletonList(primitiveInstruction1)));
				}
			} else {
				breakdown.addAll(toBuilder(Collections.<PrimitiveInstruction>emptyList()));
			}
			
			return Optional.ofNullable(breakdown)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Money> novatedAmount(TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlNovation).<Money>mapC("getNovatedAmount", tradeNovationContent -> tradeNovationContent.getNovatedAmount());
		}
		
		@Override
		protected MapperC<? extends NonNegativeMoney> changeInNotionalAmount(TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlNovation).<TradeLegSizeChange>mapC("getNovationAmount", tradeNovationContent -> tradeNovationContent.getNovationAmount()).<NonNegativeMoney>map("getChangeInNotionalAmount", tradeLegSizeChange -> tradeLegSizeChange.getChangeInNotionalAmount());
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> newTradeAmount(TradeNovationContent fpmlNovation) {
			final MapperC<NonNegativeQuantitySchedule> thenArg = changeInNotionalAmount(fpmlNovation)
				.mapItem(item -> MapperS.of(mapNonNegativeMoneyNonNegativeQuantitySchedule.evaluate(item.get())));
			return (thenArg.getMulti().isEmpty() ? novatedAmount(fpmlNovation)
				.mapItem(item -> MapperS.of(mapMoneyToNonNegativeQuantitySchedule.evaluate(item.get()))) : thenArg);
		}
		
		@Override
		protected MapperC<? extends NonNegativeMoney> outstandingNotionalAmount(TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlNovation).<TradeLegSizeChange>mapC("getNovationAmount", tradeNovationContent -> tradeNovationContent.getNovationAmount()).<NonNegativeMoney>map("getOutstandingNotionalAmount", tradeLegSizeChange -> tradeLegSizeChange.getOutstandingNotionalAmount());
		}
		
		@Override
		protected MapperC<? extends Money> remainingAmount(TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlNovation).<Money>mapC("getRemainingAmount", tradeNovationContent -> tradeNovationContent.getRemainingAmount());
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> oldTradeAmount(TradeNovationContent fpmlNovation) {
			final MapperC<NonNegativeQuantitySchedule> thenArg = outstandingNotionalAmount(fpmlNovation)
				.mapItem(item -> MapperS.of(mapNonNegativeMoneyNonNegativeQuantitySchedule.evaluate(item.get())));
			return (thenArg.getMulti().isEmpty() ? remainingAmount(fpmlNovation)
				.mapItem(item -> MapperS.of(mapMoneyToNonNegativeQuantitySchedule.evaluate(item.get()))) : thenArg);
		}
		
		@Override
		protected MapperS<? extends PartyChangeInstruction> partyChange(TradeNovationContent fpmlNovation) {
			return MapperS.of(mapPartyChangeInstruction.evaluate(fpmlNovation));
		}
		
		@Override
		protected MapperS<? extends TransferInstruction> transfer(TradeNovationContent fpmlNovation) {
			return MapperS.of(mapTransferInstruction.evaluate(MapperS.of(fpmlNovation).<Payment>map("getPayment", tradeNovationContent -> tradeNovationContent.getPayment()).getMulti(), FeeTypeEnum.NOVATION));
		}
	}
}
