package drr.projection.iso20022.esma.emir.refit.trade.functions;

import cdm.base.math.functions.Abs;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.ReportableDelivery;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.DurationType1Code;
import drr.standards.iso.EnergyQuantityUnit2Code;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd20Amount;
import iso20022.auth030.esma.AmountAndDirection106__3;
import iso20022.auth030.esma.DatePeriod1;
import iso20022.auth030.esma.DeliveryInterconnectionPoint1Choice__1;
import iso20022.auth030.esma.EnergyDeliveryAttribute10__1;
import iso20022.auth030.esma.EnergyLoadType1Code;
import iso20022.auth030.esma.EnergyQuantityUnit2Choice__1;
import iso20022.auth030.esma.EnergySpecificAttribute9__1;
import iso20022.auth030.esma.Quantity47Choice__1;
import iso20022.auth030.esma.TimePeriodDetails1;
import iso20022.auth030.esma.WeekDay3Code__1;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetNrgySpcfcAttrbts.GetNrgySpcfcAttrbtsDefault.class)
public abstract class GetNrgySpcfcAttrbts implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;

	/**
	* @param drrReport 
	* @return nrgySpcfcAttrbts 
	*/
	public EnergySpecificAttribute9__1 evaluate(ESMAEMIRTransactionReport drrReport) {
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder nrgySpcfcAttrbtsBuilder = doEvaluate(drrReport);
		
		final EnergySpecificAttribute9__1 nrgySpcfcAttrbts;
		if (nrgySpcfcAttrbtsBuilder == null) {
			nrgySpcfcAttrbts = null;
		} else {
			nrgySpcfcAttrbts = nrgySpcfcAttrbtsBuilder.build();
			objectValidator.validate(EnergySpecificAttribute9__1.class, nrgySpcfcAttrbts);
		}
		
		return nrgySpcfcAttrbts;
	}

	protected abstract EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetNrgySpcfcAttrbtsDefault extends GetNrgySpcfcAttrbts {
		@Override
		protected EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder nrgySpcfcAttrbts = EnergySpecificAttribute9__1.builder();
			return assignOutput(nrgySpcfcAttrbts, drrReport);
		}
		
		protected EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder assignOutput(EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder nrgySpcfcAttrbts, ESMAEMIRTransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("ELEC"), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("NGAS"), CardinalityOperator.All))).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getInterconnectionPoint", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getInterconnectionPoint()).map("to-string", Object::toString).get();
			}
			EnergyLoadType1Code ifThenElseResult1 = null;
			if (exists(MapperS.of(drrReport).<String>mapC("getDeliveryPoint", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getDeliveryPoint())).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<drr.standards.iso.EnergyLoadType1Code>map("getLoadType", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLoadType()).checkedMap("to-enum", e -> EnergyLoadType1Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			nrgySpcfcAttrbts = toBuilder(EnergySpecificAttribute9__1.builder()
				.setDlvryPtOrZone(MapperS.of(drrReport).<String>mapC("getDeliveryPoint", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getDeliveryPoint())
					.mapItem(item -> MapperS.of(DeliveryInterconnectionPoint1Choice__1.builder()
						.setCd(item.get())
						.build())).getMulti())
				.setIntrCnnctnPt(DeliveryInterconnectionPoint1Choice__1.builder()
					.setCd(ifThenElseResult0)
					.build())
				.setLdTp(ifThenElseResult1)
				.setDlvryAttr(MapperS.of(drrReport).<ReportableDelivery>mapC("getDeliveryReport", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getDeliveryReport())
					.mapItem(item -> {
						final TimePeriodDetails1 timePeriodDetails1 = TimePeriodDetails1.builder()
							.setFrTm(item.<LocalTime>map("getDeliveryStartTime", reportableDelivery -> reportableDelivery.getDeliveryStartTime()).get())
							.setToTm(item.<LocalTime>map("getDeliveryEndTime", reportableDelivery -> reportableDelivery.getDeliveryEndTime()).get())
							.build();
						Boolean ifThenElseResult = null;
						if (lessThan(item.<BigDecimal>map("getPriceTimeIntervalQuantity", reportableDelivery -> reportableDelivery.getPriceTimeIntervalQuantity()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						return MapperS.of(EnergyDeliveryAttribute10__1.builder()
							.setDlvryIntrvl((timePeriodDetails1 == null ? Collections.<TimePeriodDetails1>emptyList() : Collections.singletonList(timePeriodDetails1)))
							.setDlvryDt(DatePeriod1.builder()
								.setFrDt(item.<Date>map("getDeliveryStartDate", reportableDelivery -> reportableDelivery.getDeliveryStartDate()).get())
								.setToDt(item.<Date>map("getDeliveryEndDate", reportableDelivery -> reportableDelivery.getDeliveryEndDate()).get())
								.build())
							.setDrtn(item.<DurationType1Code>map("getDuration", reportableDelivery -> reportableDelivery.getDuration()).checkedMap("to-enum", e -> iso20022.auth030.esma.DurationType1Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.setWkDay(item.<String>mapC("getDaysOfTheWeek", reportableDelivery -> reportableDelivery.getDaysOfTheWeek())
								.mapItem(_item -> _item.checkedMap("to-enum", WeekDay3Code__1::fromDisplayName, IllegalArgumentException.class)).getMulti())
							.setDlvryCpcty(Quantity47Choice__1.builder()
								.setQty(item.<BigDecimal>map("getDeliveryCapacity", reportableDelivery -> reportableDelivery.getDeliveryCapacity()).get())
								.build())
							.setQtyUnit(EnergyQuantityUnit2Choice__1.builder()
								.setCd(item.<EnergyQuantityUnit2Code>map("getQuantityUnit", reportableDelivery -> reportableDelivery.getQuantityUnit()).checkedMap("to-enum", e -> iso20022.auth030.esma.EnergyQuantityUnit2Code.valueOf(e.name()), IllegalArgumentException.class).get())
								.build())
							.setPricTmIntrvlQty(AmountAndDirection106__3.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd20Amount.builder()
									.setValue(abs.evaluate(item.<BigDecimal>map("getPriceTimeIntervalQuantity", reportableDelivery -> reportableDelivery.getPriceTimeIntervalQuantity()).get()))
									.setCcy(item.<String>map("getCurrencyOfThePriceTimeIntervalQuantity", reportableDelivery -> reportableDelivery.getCurrencyOfThePriceTimeIntervalQuantity()).map("to-string", Object::toString).get())
									.build())
								.setSgn(ifThenElseResult)
								.build())
							.build());
					}).getMulti())
				.build());
			
			return Optional.ofNullable(nrgySpcfcAttrbts)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
