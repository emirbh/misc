package drr.regulation.common.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.NonReportable;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iosco.upi.AnnaDsbValuationMethodorTriggerEnum;
import drr.standards.iso.ActionTypeEnum;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(StrikePrice_Validation_01.StrikePrice_Validation_01Default.class)
public abstract class StrikePrice_Validation_01 implements RosettaFunction {

	/**
	* @param actionType 
	* @param contractType 
	* @param strikePriceSchedule 
	* @param strikePrice 
	* @param nonReportable 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonContractType contractType, List<? extends PricePeriod> strikePriceSchedule, PriceFormat strikePrice, NonReportable nonReportable) {
		Boolean result = doEvaluate(actionType, contractType, strikePriceSchedule, strikePrice, nonReportable);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonContractType contractType, List<? extends PricePeriod> strikePriceSchedule, PriceFormat strikePrice, NonReportable nonReportable);

	public static class StrikePrice_Validation_01Default extends StrikePrice_Validation_01 {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonContractType contractType, List<? extends PricePeriod> strikePriceSchedule, PriceFormat strikePrice, NonReportable nonReportable) {
			if (strikePriceSchedule == null) {
				strikePriceSchedule = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, actionType, contractType, strikePriceSchedule, strikePrice, nonReportable);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonContractType contractType, List<? extends PricePeriod> strikePriceSchedule, PriceFormat strikePrice, NonReportable nonReportable) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(contractType), CardinalityOperator.Any)).getOrDefault(false)) {
				final ComparisonResult ifThenElseResult0;
				if (areEqual(MapperS.of(nonReportable).<AnnaDsbUpiRecord>map("getPostUpiData", _nonReportable -> _nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).andNullSafe(notEqual(MapperC.<AnnaDsbValuationMethodorTriggerEnum>of(MapperS.of(AnnaDsbValuationMethodorTriggerEnum.BARRIER), MapperS.of(AnnaDsbValuationMethodorTriggerEnum.DIGITAL_BARRIER)), MapperS.of(nonReportable).<AnnaDsbUpiRecord>map("getPostUpiData", _nonReportable -> _nonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbValuationMethodorTriggerEnum>map("getValuationMethodorTrigger", annaDsbDerived -> annaDsbDerived.getValuationMethodorTrigger()), CardinalityOperator.All)).getOrDefault(false)) {
					ifThenElseResult0 = exists(MapperS.of(strikePrice));
				} else {
					ifThenElseResult0 = ComparisonResult.ofEmpty();
				}
				final ComparisonResult ifThenElseResult1;
				if (exists(MapperC.<PricePeriod>of(strikePriceSchedule).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice())).getOrDefault(false)) {
					ifThenElseResult1 = exists(MapperS.of(strikePrice));
				} else {
					ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = ifThenElseResult0.andNullSafe(ifThenElseResult1).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
