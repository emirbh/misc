package drr.standards.iosco.cde.version1.party.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiverEnum;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.template.StrikeSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.Direction1Enum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CapFloorPayerReceiver.CapFloorPayerReceiverDefault.class)
public abstract class CapFloorPayerReceiver implements RosettaFunction {

	/**
	* @param interestRatePayout 
	* @param side 
	* @return payerReceiver 
	*/
	public CounterpartyRoleEnum evaluate(InterestRatePayout interestRatePayout, Direction1Enum side) {
		CounterpartyRoleEnum payerReceiver = doEvaluate(interestRatePayout, side);
		
		return payerReceiver;
	}

	protected abstract CounterpartyRoleEnum doEvaluate(InterestRatePayout interestRatePayout, Direction1Enum side);

	protected abstract MapperC<? extends StrikeSchedule> schedule(InterestRatePayout interestRatePayout, Direction1Enum side);

	protected abstract MapperS<CounterpartyRoleEnum> streamPayer(InterestRatePayout interestRatePayout, Direction1Enum side);

	protected abstract MapperS<CounterpartyRoleEnum> streamReceiver(InterestRatePayout interestRatePayout, Direction1Enum side);

	protected abstract MapperC<CounterpartyRoleEnum> seller(InterestRatePayout interestRatePayout, Direction1Enum side);

	protected abstract MapperC<CounterpartyRoleEnum> buyer(InterestRatePayout interestRatePayout, Direction1Enum side);

	public static class CapFloorPayerReceiverDefault extends CapFloorPayerReceiver {
		@Override
		protected CounterpartyRoleEnum doEvaluate(InterestRatePayout interestRatePayout, Direction1Enum side) {
			CounterpartyRoleEnum payerReceiver = null;
			return assignOutput(payerReceiver, interestRatePayout, side);
		}
		
		protected CounterpartyRoleEnum assignOutput(CounterpartyRoleEnum payerReceiver, InterestRatePayout interestRatePayout, Direction1Enum side) {
			if (side == null) {
				payerReceiver = null;
			} else if (side == Direction1Enum.BYER) {
				payerReceiver = buyer(interestRatePayout, side).get();
			} else if (side == Direction1Enum.SLLR) {
				payerReceiver = seller(interestRatePayout, side).get();
			} else {
				payerReceiver = null;
			}
			
			return payerReceiver;
		}
		
		@Override
		protected MapperC<? extends StrikeSchedule> schedule(InterestRatePayout interestRatePayout, Direction1Enum side) {
			return MapperC.<StrikeSchedule>of(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<StrikeSchedule>map("getCapRateSchedule", floatingRateSpecification -> floatingRateSpecification.getCapRateSchedule()), MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<StrikeSchedule>map("getFloorRateSchedule", floatingRateSpecification -> floatingRateSpecification.getFloorRateSchedule()));
		}
		
		@Override
		protected MapperS<CounterpartyRoleEnum> streamPayer(InterestRatePayout interestRatePayout, Direction1Enum side) {
			return MapperS.of(interestRatePayout).<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer());
		}
		
		@Override
		protected MapperS<CounterpartyRoleEnum> streamReceiver(InterestRatePayout interestRatePayout, Direction1Enum side) {
			return MapperS.of(interestRatePayout).<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver());
		}
		
		@Override
		protected MapperC<CounterpartyRoleEnum> seller(InterestRatePayout interestRatePayout, Direction1Enum side) {
			return schedule(interestRatePayout, side)
				.mapItem(item -> {
					if (areEqual(item.<PayerReceiverEnum>map("getSeller", strikeSchedule -> strikeSchedule.getSeller()), MapperS.of(PayerReceiverEnum.RECEIVER), CardinalityOperator.All).getOrDefault(false)) {
						return streamReceiver(interestRatePayout, side);
					}
					if (areEqual(item.<PayerReceiverEnum>map("getSeller", strikeSchedule -> strikeSchedule.getSeller()), MapperS.of(PayerReceiverEnum.PAYER), CardinalityOperator.All).getOrDefault(false)) {
						return streamPayer(interestRatePayout, side);
					}
					return MapperS.<CounterpartyRoleEnum>ofNull();
				});
		}
		
		@Override
		protected MapperC<CounterpartyRoleEnum> buyer(InterestRatePayout interestRatePayout, Direction1Enum side) {
			return schedule(interestRatePayout, side)
				.mapItem(item -> {
					if (areEqual(item.<PayerReceiverEnum>map("getBuyer", strikeSchedule -> strikeSchedule.getBuyer()), MapperS.of(PayerReceiverEnum.RECEIVER), CardinalityOperator.All).getOrDefault(false)) {
						return streamReceiver(interestRatePayout, side);
					}
					if (areEqual(item.<PayerReceiverEnum>map("getBuyer", strikeSchedule -> strikeSchedule.getBuyer()), MapperS.of(PayerReceiverEnum.PAYER), CardinalityOperator.All).getOrDefault(false)) {
						return streamPayer(interestRatePayout, side);
					}
					return MapperS.<CounterpartyRoleEnum>ofNull();
				});
		}
	}
}
