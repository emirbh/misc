package drr.standards.iso.functions;

import cdm.base.math.CapacityUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CapacityUnitToISO20022UnitOfMeasure.CapacityUnitToISO20022UnitOfMeasureDefault.class)
public abstract class CapacityUnitToISO20022UnitOfMeasure implements RosettaFunction {

	/**
	* @param capacityUnit 
	* @return result 
	*/
	public String evaluate(CapacityUnitEnum capacityUnit) {
		String result = doEvaluate(capacityUnit);
		
		return result;
	}

	protected abstract String doEvaluate(CapacityUnitEnum capacityUnit);

	public static class CapacityUnitToISO20022UnitOfMeasureDefault extends CapacityUnitToISO20022UnitOfMeasure {
		@Override
		protected String doEvaluate(CapacityUnitEnum capacityUnit) {
			String result = null;
			return assignOutput(result, capacityUnit);
		}
		
		protected String assignOutput(String result, CapacityUnitEnum capacityUnit) {
			if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.ALW), CardinalityOperator.All).getOrDefault(false)) {
				result = "ALOW";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.BBL), CardinalityOperator.All).getOrDefault(false)) {
				result = "BARL";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.BCF), CardinalityOperator.All).getOrDefault(false)) {
				result = "BCUF";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.BDFT), CardinalityOperator.All).getOrDefault(false)) {
				result = "BDFT";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.GBBSH), CardinalityOperator.All).getOrDefault(false)) {
				result = "BUSL";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.GBBTU), CardinalityOperator.All).getOrDefault(false)) {
				result = "BRTU";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.CBM), CardinalityOperator.All).getOrDefault(false)) {
				result = "CBME";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.CER), CardinalityOperator.All).getOrDefault(false)) {
				result = "CEER";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.CRT), CardinalityOperator.All).getOrDefault(false)) {
				result = "CLRT";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.DAG), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.DAY), CardinalityOperator.All).getOrDefault(false)) {
				result = "DAYS";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.DMTU), CardinalityOperator.All).getOrDefault(false)) {
				result = "DMET";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.ENVCRD), CardinalityOperator.All).getOrDefault(false)) {
				result = "ENVC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.ENVOFST), CardinalityOperator.All).getOrDefault(false)) {
				result = "ENVO";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.FEU), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.G), CardinalityOperator.All).getOrDefault(false)) {
				result = "GRAM";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.GBCWT), CardinalityOperator.All).getOrDefault(false)) {
				result = "HUWG";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.GBGAL), CardinalityOperator.All).getOrDefault(false)) {
				result = "GBGA";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.GBT), CardinalityOperator.All).getOrDefault(false)) {
				result = "GBTN";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.GJ), CardinalityOperator.All).getOrDefault(false)) {
				result = "GGJL";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.GW), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.GWH), CardinalityOperator.All).getOrDefault(false)) {
				result = "GWHO";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.HL), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.J), CardinalityOperator.All).getOrDefault(false)) {
				result = "JOUL";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.KG), CardinalityOperator.All).getOrDefault(false)) {
				result = "KILO";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.KL), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.KW), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.KWD), CardinalityOperator.All).getOrDefault(false)) {
				result = "KWDC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.KWH), CardinalityOperator.All).getOrDefault(false)) {
				result = "KWHO";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.KWH), CardinalityOperator.All).getOrDefault(false)) {
				result = "KWHC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.KWMIN), CardinalityOperator.All).getOrDefault(false)) {
				result = "KMOC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.KWM), CardinalityOperator.All).getOrDefault(false)) {
				result = "KWMC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.KWY), CardinalityOperator.All).getOrDefault(false)) {
				result = "KWYC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.L), CardinalityOperator.All).getOrDefault(false)) {
				result = "LITR";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.LB), CardinalityOperator.All).getOrDefault(false)) {
				result = "PUND";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MB), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MBF), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MJ), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MMBF), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MMBBL), CardinalityOperator.All).getOrDefault(false)) {
				result = "MIBA";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.USMMBTU), CardinalityOperator.All).getOrDefault(false)) {
				result = "MBTU";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MSF), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MT), CardinalityOperator.All).getOrDefault(false)) {
				result = "TONE";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MW), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MWD), CardinalityOperator.All).getOrDefault(false)) {
				result = "MWDC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MWH), CardinalityOperator.All).getOrDefault(false)) {
				result = "MWHO";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MWH), CardinalityOperator.All).getOrDefault(false)) {
				result = "MWHC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MWM), CardinalityOperator.All).getOrDefault(false)) {
				result = "MMOC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MWMIN), CardinalityOperator.All).getOrDefault(false)) {
				result = "MWMC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.MWY), CardinalityOperator.All).getOrDefault(false)) {
				result = "MWYC";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.OZT), CardinalityOperator.All).getOrDefault(false)) {
				result = "OZTR";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.TEU), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.USTHM), CardinalityOperator.All).getOrDefault(false)) {
				result = "THMS";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.USCWT), CardinalityOperator.All).getOrDefault(false)) {
				result = "UCWT";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.USGAL), CardinalityOperator.All).getOrDefault(false)) {
				result = "USGA";
			} else if (areEqual(MapperS.of(capacityUnit), MapperS.of(CapacityUnitEnum.UST), CardinalityOperator.All).getOrDefault(false)) {
				result = "USTN";
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
