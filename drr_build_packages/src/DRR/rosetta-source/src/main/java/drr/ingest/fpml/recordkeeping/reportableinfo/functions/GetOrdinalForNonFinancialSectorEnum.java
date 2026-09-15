package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.NonFinancialSectorEnum;


@ImplementedBy(GetOrdinalForNonFinancialSectorEnum.GetOrdinalForNonFinancialSectorEnumDefault.class)
public abstract class GetOrdinalForNonFinancialSectorEnum implements RosettaFunction {

	/**
	* @param nonFinancialSectorEnum 
	* @return ordinal 
	*/
	public Integer evaluate(NonFinancialSectorEnum nonFinancialSectorEnum) {
		Integer ordinal = doEvaluate(nonFinancialSectorEnum);
		
		return ordinal;
	}

	protected abstract Integer doEvaluate(NonFinancialSectorEnum nonFinancialSectorEnum);

	public static class GetOrdinalForNonFinancialSectorEnumDefault extends GetOrdinalForNonFinancialSectorEnum {
		@Override
		protected Integer doEvaluate(NonFinancialSectorEnum nonFinancialSectorEnum) {
			Integer ordinal = null;
			return assignOutput(ordinal, nonFinancialSectorEnum);
		}
		
		protected Integer assignOutput(Integer ordinal, NonFinancialSectorEnum nonFinancialSectorEnum) {
			if (nonFinancialSectorEnum == null) {
				ordinal = null;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.A) {
				ordinal = 1;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.B) {
				ordinal = 2;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.C) {
				ordinal = 3;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.D) {
				ordinal = 4;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.E) {
				ordinal = 5;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.F) {
				ordinal = 6;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.G) {
				ordinal = 7;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.H) {
				ordinal = 8;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.I) {
				ordinal = 9;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.J) {
				ordinal = 10;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.K) {
				ordinal = 11;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.L) {
				ordinal = 12;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.M) {
				ordinal = 13;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.N) {
				ordinal = 14;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.O) {
				ordinal = 15;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.P) {
				ordinal = 16;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.Q) {
				ordinal = 17;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.R) {
				ordinal = 18;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.S) {
				ordinal = 19;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.T) {
				ordinal = 20;
			} else if (nonFinancialSectorEnum == NonFinancialSectorEnum.U) {
				ordinal = MapperS.of(21).getOrDefault(0);
			} else {
				ordinal = null;
			}
			
			return ordinal;
		}
	}
}
