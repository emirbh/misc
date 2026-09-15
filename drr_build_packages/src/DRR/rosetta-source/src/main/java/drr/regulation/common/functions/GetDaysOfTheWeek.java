package drr.regulation.common.functions;

import cdm.base.datetime.DayOfWeekEnum;
import cdm.product.asset.BankHolidayTreatmentEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetDaysOfTheWeek.GetDaysOfTheWeekDefault.class)
public abstract class GetDaysOfTheWeek implements RosettaFunction {

	/**
	* @param daysOfTheWeek 
	* @param bankHolidaysTreatment 
	* @return dayCode 
	*/
	public List<String> evaluate(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
		List<String> dayCode = doEvaluate(daysOfTheWeek, bankHolidaysTreatment);
		
		return dayCode;
	}

	protected abstract List<String> doEvaluate(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment);

	protected abstract MapperS<Boolean> mon(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment);

	protected abstract MapperS<Boolean> tue(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment);

	protected abstract MapperS<Boolean> wed(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment);

	protected abstract MapperS<Boolean> thu(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment);

	protected abstract MapperS<Boolean> fri(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment);

	protected abstract MapperS<Boolean> sat(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment);

	protected abstract MapperS<Boolean> sun(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment);

	public static class GetDaysOfTheWeekDefault extends GetDaysOfTheWeek {
		@Override
		protected List<String> doEvaluate(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
			if (daysOfTheWeek == null) {
				daysOfTheWeek = Collections.emptyList();
			}
			List<String> dayCode = new ArrayList<>();
			return assignOutput(dayCode, daysOfTheWeek, bankHolidaysTreatment);
		}
		
		protected List<String> assignOutput(List<String> dayCode, List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
			if (ComparisonResult.ofNullSafe(mon(daysOfTheWeek, bankHolidaysTreatment)).andNullSafe(areEqual(tue(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(wed(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(thu(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(fri(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All))).getOrDefault(false)) {
				final String string0 = "MOND";
				if (string0 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string0));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (ComparisonResult.ofNullSafe(tue(daysOfTheWeek, bankHolidaysTreatment)).andNullSafe(areEqual(mon(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(wed(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(thu(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(fri(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All))).getOrDefault(false)) {
				final String string1 = "TUED";
				if (string1 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string1));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (ComparisonResult.ofNullSafe(wed(daysOfTheWeek, bankHolidaysTreatment)).andNullSafe(areEqual(mon(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(tue(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(thu(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(fri(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All))).getOrDefault(false)) {
				final String string2 = "WEDD";
				if (string2 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string2));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (ComparisonResult.ofNullSafe(thu(daysOfTheWeek, bankHolidaysTreatment)).andNullSafe(areEqual(mon(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(tue(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(wed(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(fri(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All))).getOrDefault(false)) {
				final String string3 = "THUD";
				if (string3 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string3));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (ComparisonResult.ofNullSafe(fri(daysOfTheWeek, bankHolidaysTreatment)).andNullSafe(areEqual(mon(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(tue(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(wed(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(thu(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All))).getOrDefault(false)) {
				final String string4 = "FRID";
				if (string4 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string4));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (ComparisonResult.ofNullSafe(sat(daysOfTheWeek, bankHolidaysTreatment)).andNullSafe(areEqual(sun(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				final String string5 = "SATD";
				if (string5 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string5));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (ComparisonResult.ofNullSafe(sun(daysOfTheWeek, bankHolidaysTreatment)).andNullSafe(areEqual(sat(daysOfTheWeek, bankHolidaysTreatment), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				final String string6 = "SUND";
				if (string6 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string6));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (ComparisonResult.ofNullSafe(mon(daysOfTheWeek, bankHolidaysTreatment)).andNullSafe(ComparisonResult.ofNullSafe(tue(daysOfTheWeek, bankHolidaysTreatment))).andNullSafe(ComparisonResult.ofNullSafe(wed(daysOfTheWeek, bankHolidaysTreatment))).andNullSafe(ComparisonResult.ofNullSafe(thu(daysOfTheWeek, bankHolidaysTreatment))).andNullSafe(ComparisonResult.ofNullSafe(fri(daysOfTheWeek, bankHolidaysTreatment))).getOrDefault(false)) {
				final String string7 = "WDAY";
				if (string7 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string7));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (ComparisonResult.ofNullSafe(sat(daysOfTheWeek, bankHolidaysTreatment)).andNullSafe(ComparisonResult.ofNullSafe(sun(daysOfTheWeek, bankHolidaysTreatment))).getOrDefault(false)) {
				final String string8 = "WEND";
				if (string8 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string8));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (areEqual(MapperS.of(bankHolidaysTreatment), MapperS.of(BankHolidayTreatmentEnum.AS_WEEKDAY), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(mon(daysOfTheWeek, bankHolidaysTreatment)).orNullSafe(ComparisonResult.ofNullSafe(tue(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(wed(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(thu(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(fri(daysOfTheWeek, bankHolidaysTreatment)))).andNullSafe(areEqual(ComparisonResult.ofNullSafe(sat(daysOfTheWeek, bankHolidaysTreatment)).orNullSafe(ComparisonResult.ofNullSafe(sun(daysOfTheWeek, bankHolidaysTreatment))), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				final String string9 = "IBHL";
				if (string9 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string9));
				}
			} else if (areEqual(MapperS.of(bankHolidaysTreatment), MapperS.of(BankHolidayTreatmentEnum.AS_WEEKEND), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(sat(daysOfTheWeek, bankHolidaysTreatment)).orNullSafe(ComparisonResult.ofNullSafe(sun(daysOfTheWeek, bankHolidaysTreatment)))).andNullSafe(areEqual(ComparisonResult.ofNullSafe(mon(daysOfTheWeek, bankHolidaysTreatment)).orNullSafe(ComparisonResult.ofNullSafe(tue(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(wed(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(thu(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(fri(daysOfTheWeek, bankHolidaysTreatment))), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				final String string10 = "IBHL";
				if (string10 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string10));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			if (areEqual(MapperS.of(bankHolidaysTreatment), MapperS.of(BankHolidayTreatmentEnum.AS_WEEKEND), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(mon(daysOfTheWeek, bankHolidaysTreatment)).orNullSafe(ComparisonResult.ofNullSafe(tue(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(wed(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(thu(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(fri(daysOfTheWeek, bankHolidaysTreatment)))).andNullSafe(areEqual(ComparisonResult.ofNullSafe(sat(daysOfTheWeek, bankHolidaysTreatment)).orNullSafe(ComparisonResult.ofNullSafe(sun(daysOfTheWeek, bankHolidaysTreatment))), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				final String string11 = "XBHL";
				if (string11 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string11));
				}
			} else if (areEqual(MapperS.of(bankHolidaysTreatment), MapperS.of(BankHolidayTreatmentEnum.AS_WEEKDAY), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(sat(daysOfTheWeek, bankHolidaysTreatment)).orNullSafe(ComparisonResult.ofNullSafe(sun(daysOfTheWeek, bankHolidaysTreatment)))).andNullSafe(areEqual(ComparisonResult.ofNullSafe(mon(daysOfTheWeek, bankHolidaysTreatment)).orNullSafe(ComparisonResult.ofNullSafe(tue(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(wed(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(thu(daysOfTheWeek, bankHolidaysTreatment))).orNullSafe(ComparisonResult.ofNullSafe(fri(daysOfTheWeek, bankHolidaysTreatment))), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				final String string12 = "XBHL";
				if (string12 == null) {
					dayCode.addAll(Collections.<String>emptyList());
				} else {
					dayCode.addAll(Collections.singletonList(string12));
				}
			} else {
				dayCode.addAll(Collections.<String>emptyList());
			}
			
			return dayCode;
		}
		
		@Override
		protected MapperS<Boolean> mon(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
			return contains(MapperC.<DayOfWeekEnum>of(daysOfTheWeek), MapperS.of(DayOfWeekEnum.MON)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> tue(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
			return contains(MapperC.<DayOfWeekEnum>of(daysOfTheWeek), MapperS.of(DayOfWeekEnum.TUE)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> wed(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
			return contains(MapperC.<DayOfWeekEnum>of(daysOfTheWeek), MapperS.of(DayOfWeekEnum.WED)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> thu(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
			return contains(MapperC.<DayOfWeekEnum>of(daysOfTheWeek), MapperS.of(DayOfWeekEnum.THU)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> fri(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
			return contains(MapperC.<DayOfWeekEnum>of(daysOfTheWeek), MapperS.of(DayOfWeekEnum.FRI)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> sat(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
			return contains(MapperC.<DayOfWeekEnum>of(daysOfTheWeek), MapperS.of(DayOfWeekEnum.SAT)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> sun(List<DayOfWeekEnum> daysOfTheWeek, BankHolidayTreatmentEnum bankHolidaysTreatment) {
			return contains(MapperC.<DayOfWeekEnum>of(daysOfTheWeek), MapperS.of(DayOfWeekEnum.SUN)).asMapper();
		}
	}
}
