package cdm.ingest.fpml.confirmation.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.DeliveryDatesEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapDeliveryDatesToPeriodMultiplier.MapDeliveryDatesToPeriodMultiplierDefault.class)
public abstract class MapDeliveryDatesToPeriodMultiplier implements RosettaFunction {

	/**
	* @param fpmlDeliveryDates 
	* @return periodMultiplier 
	*/
	public Integer evaluate(DeliveryDatesEnum fpmlDeliveryDates) {
		Integer periodMultiplier = doEvaluate(fpmlDeliveryDates);
		
		return periodMultiplier;
	}

	protected abstract Integer doEvaluate(DeliveryDatesEnum fpmlDeliveryDates);

	public static class MapDeliveryDatesToPeriodMultiplierDefault extends MapDeliveryDatesToPeriodMultiplier {
		@Override
		protected Integer doEvaluate(DeliveryDatesEnum fpmlDeliveryDates) {
			Integer periodMultiplier = null;
			return assignOutput(periodMultiplier, fpmlDeliveryDates);
		}
		
		protected Integer assignOutput(Integer periodMultiplier, DeliveryDatesEnum fpmlDeliveryDates) {
			if (areEqual(MapperS.of(fpmlDeliveryDates), MapperS.of(DeliveryDatesEnum.FIRST_NEARBY), CardinalityOperator.All).getOrDefault(false)) {
				periodMultiplier = 1;
			} else if (areEqual(MapperS.of(fpmlDeliveryDates), MapperS.of(DeliveryDatesEnum.SECOND_NEARBY), CardinalityOperator.All).getOrDefault(false)) {
				periodMultiplier = 2;
			} else if (areEqual(MapperS.of(fpmlDeliveryDates), MapperS.of(DeliveryDatesEnum.THIRD_NEARBY), CardinalityOperator.All).getOrDefault(false)) {
				periodMultiplier = 3;
			} else if (areEqual(MapperS.of(fpmlDeliveryDates), MapperS.of(DeliveryDatesEnum.FOURTH_NEARBY), CardinalityOperator.All).getOrDefault(false)) {
				periodMultiplier = 4;
			} else if (areEqual(MapperS.of(fpmlDeliveryDates), MapperS.of(DeliveryDatesEnum.FIFTH_NEARBY), CardinalityOperator.All).getOrDefault(false)) {
				periodMultiplier = 5;
			} else if (areEqual(MapperS.of(fpmlDeliveryDates), MapperS.of(DeliveryDatesEnum.SIXTH_NEARBY), CardinalityOperator.All).getOrDefault(false)) {
				periodMultiplier = 6;
			} else if (areEqual(MapperS.of(fpmlDeliveryDates), MapperS.of(DeliveryDatesEnum.SEVENTH_NEARBY), CardinalityOperator.All).getOrDefault(false)) {
				periodMultiplier = 7;
			} else {
				periodMultiplier = null;
			}
			
			return periodMultiplier;
		}
	}
}
