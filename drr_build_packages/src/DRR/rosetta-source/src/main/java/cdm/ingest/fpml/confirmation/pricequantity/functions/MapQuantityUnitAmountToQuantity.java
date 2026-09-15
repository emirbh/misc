package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.datetime.Frequency;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapUnitTypeWithScheme;
import cdm.ingest.fpml.confirmation.other.functions.MapFrequencyToPeriodMultiplier;
import cdm.ingest.fpml.confirmation.other.functions.MapPeriodExtendedEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityQuantityFrequency;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapQuantityUnitAmountToQuantity.MapQuantityUnitAmountToQuantityDefault.class)
public abstract class MapQuantityUnitAmountToQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFrequencyToPeriodMultiplier mapFrequencyToPeriodMultiplier;
	@Inject protected MapPeriodExtendedEnum mapPeriodExtendedEnum;
	@Inject protected MapQuantityStepListToDatedValueList mapQuantityStepListToDatedValueList;
	@Inject protected MapUnitTypeWithScheme mapUnitTypeWithScheme;

	/**
	* @param fpmlAmount 
	* @param fpmlQuantityStep 
	* @param fpmlQuantityUnit 
	* @param fpmlFrequency 
	* @return nonNegativeQuantitySchedule 
	*/
	public NonNegativeQuantitySchedule evaluate(BigDecimal fpmlAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlAmount, fpmlQuantityStep, fpmlQuantityUnit, fpmlFrequency);
		
		final NonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency);

	protected abstract MapperS<? extends UnitType> unit(BigDecimal fpmlAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency);

	public static class MapQuantityUnitAmountToQuantityDefault extends MapQuantityUnitAmountToQuantity {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency) {
			if (fpmlQuantityStep == null) {
				fpmlQuantityStep = Collections.emptyList();
			}
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = NonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlAmount, fpmlQuantityStep, fpmlQuantityUnit, fpmlFrequency);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency) {
			if (exists(MapperS.of(fpmlAmount)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(NonNegativeQuantitySchedule.builder()
					.setValue(fpmlAmount)
					.setDatedValue(new ArrayList(mapQuantityStepListToDatedValueList.evaluate(fpmlQuantityStep)))
					.setUnit(unit(fpmlAmount, fpmlQuantityStep, fpmlQuantityUnit, fpmlFrequency).get())
					.setFrequency(Frequency.builder()
						.setPeriod(mapPeriodExtendedEnum.evaluate(MapperS.of(fpmlFrequency).<String>map("getValue", commodityQuantityFrequency -> commodityQuantityFrequency.getValue()).get()))
						.setPeriodMultiplier(mapFrequencyToPeriodMultiplier.evaluate(MapperS.of(fpmlFrequency).<String>map("getValue", commodityQuantityFrequency -> commodityQuantityFrequency.getValue()).get()))
						.build())
					.build());
			} else {
				nonNegativeQuantitySchedule = null;
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> unit(BigDecimal fpmlAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency) {
			return MapperS.of(mapUnitTypeWithScheme.evaluate(MapperS.of(fpmlQuantityUnit).<String>map("getValue", quantityUnit -> quantityUnit.getValue()).get(), MapperS.of(fpmlQuantityUnit).<String>map("getQuantityUnitScheme", quantityUnit -> quantityUnit.getQuantityUnitScheme()).get()));
		}
	}
}
