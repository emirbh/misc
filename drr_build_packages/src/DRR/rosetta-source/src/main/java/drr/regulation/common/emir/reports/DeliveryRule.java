package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableDelivery;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.functions.GetReportableDelivery;
import drr.standards.iso.DurationType1Code;
import drr.standards.iso.EnergyQuantityUnit2Code;
import drr.standards.iso.functions.FormatToLongFraction20DecimalNumber;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(DeliveryRule.DeliveryRuleDefault.class)
public abstract class DeliveryRule implements ReportFunction<TransactionReportInstruction, List<? extends ReportableDelivery>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToLongFraction20DecimalNumber formatToLongFraction20DecimalNumber;
	@Inject protected GetReportableDelivery getReportableDelivery;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends ReportableDelivery> evaluate(TransactionReportInstruction input) {
		List<ReportableDelivery.ReportableDeliveryBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends ReportableDelivery> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(ReportableDelivery::build).collect(Collectors.toList());
			objectValidator.validate(ReportableDelivery.class, output);
		}
		
		return output;
	}

	protected abstract List<ReportableDelivery.ReportableDeliveryBuilder> doEvaluate(TransactionReportInstruction input);

	public static class DeliveryRuleDefault extends DeliveryRule {
		@Override
		protected List<ReportableDelivery.ReportableDeliveryBuilder> doEvaluate(TransactionReportInstruction input) {
			List<ReportableDelivery.ReportableDeliveryBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<ReportableDelivery.ReportableDeliveryBuilder> assignOutput(List<ReportableDelivery.ReportableDeliveryBuilder> output, TransactionReportInstruction input) {
			final MapperC<ReportableDelivery> thenArg = MapperS.of(input)
				.mapSingleToList(item -> MapperC.<ReportableDelivery>of(getReportableDelivery.evaluate(item.get())));
			output = toBuilder(thenArg
				.mapItem(item -> {
					final MapperS<BigDecimal> thenArg0 = item.<BigDecimal>map("getDeliveryCapacity", reportableDelivery -> reportableDelivery.getDeliveryCapacity());
					final MapperS<BigDecimal> thenArg1 = item.<BigDecimal>map("getPriceTimeIntervalQuantity", reportableDelivery -> reportableDelivery.getPriceTimeIntervalQuantity());
					return MapperS.of(ReportableDelivery.builder()
						.setDeliveryStartTime(item.<LocalTime>map("getDeliveryStartTime", reportableDelivery -> reportableDelivery.getDeliveryStartTime()).get())
						.setDeliveryEndTime(item.<LocalTime>map("getDeliveryEndTime", reportableDelivery -> reportableDelivery.getDeliveryEndTime()).get())
						.setDeliveryStartDate(item.<Date>map("getDeliveryStartDate", reportableDelivery -> reportableDelivery.getDeliveryStartDate()).get())
						.setDeliveryEndDate(item.<Date>map("getDeliveryEndDate", reportableDelivery -> reportableDelivery.getDeliveryEndDate()).get())
						.setDuration(item.<DurationType1Code>map("getDuration", reportableDelivery -> reportableDelivery.getDuration()).get())
						.setDaysOfTheWeek(item.<String>mapC("getDaysOfTheWeek", reportableDelivery -> reportableDelivery.getDaysOfTheWeek()).getMulti())
						.setDeliveryCapacity(MapperS.of(formatToLongFraction20DecimalNumber.evaluate(thenArg0.get())).get())
						.setQuantityUnit(item.<EnergyQuantityUnit2Code>map("getQuantityUnit", reportableDelivery -> reportableDelivery.getQuantityUnit()).checkedMap("to-enum", e -> EnergyQuantityUnit2Code.valueOf(e.name()), IllegalArgumentException.class).get())
						.setPriceTimeIntervalQuantity(MapperS.of(formatToLongFraction20DecimalNumber.evaluate(thenArg1.get())).get())
						.setCurrencyOfThePriceTimeIntervalQuantity(item.<String>map("getCurrencyOfThePriceTimeIntervalQuantity", reportableDelivery -> reportableDelivery.getCurrencyOfThePriceTimeIntervalQuantity()).get())
						.build());
				}).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
