package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.IndexEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2015_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2015_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2015_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2015_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if indicatorOfTheUnderlyingIndex exists then (indicatorOfTheUnderlyingIndex extract ([IndexEnum -> ESTR, IndexEnum -> SONA, IndexEnum -> SOFR, IndexEnum -> EONA, IndexEnum -> EONS, IndexEnum -> EURI, IndexEnum -> EUUS, IndexEnum -> EUCH, IndexEnum -> GCFR, IndexEnum -> ISDA, IndexEnum -> LIBI, IndexEnum -> LIBO, IndexEnum -> MAAA, IndexEnum -> PFAN, IndexEnum -> TIBO, IndexEnum -> STBO, IndexEnum -> BBSW, IndexEnum -> JIBA, IndexEnum -> BUBO, IndexEnum -> CDOR, IndexEnum -> CIBO, IndexEnum -> MOSP, IndexEnum -> NIBO, IndexEnum -> PRBO, IndexEnum -> TLBO, IndexEnum -> WIBO, IndexEnum -> TREA, IndexEnum -> SWAP, IndexEnum -> FUSW, IndexEnum -> EFFR, IndexEnum -> OBFR, IndexEnum -> CZNA, IndexEnum -> TONA] contains item) then all = True)";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2015_01 {
	
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			try {
				final Boolean _boolean = isVRAllowedForActionType.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()).get());
				if ((_boolean == null ? false : _boolean)) {
					if (exists(MapperS.of(fCAUKEMIRTransactionReport).<IndexEnum>mapC("getIndicatorOfTheUnderlyingIndex", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getIndicatorOfTheUnderlyingIndex())).getOrDefault(false)) {
						final MapperC<Boolean> thenArg = MapperS.of(fCAUKEMIRTransactionReport).<IndexEnum>mapC("getIndicatorOfTheUnderlyingIndex", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getIndicatorOfTheUnderlyingIndex())
							.mapItem(item -> contains(MapperC.<IndexEnum>of(MapperS.of(IndexEnum.ESTR), MapperS.of(IndexEnum.SONA), MapperS.of(IndexEnum.SOFR), MapperS.of(IndexEnum.EONA), MapperS.of(IndexEnum.EONS), MapperS.of(IndexEnum.EURI), MapperS.of(IndexEnum.EUUS), MapperS.of(IndexEnum.EUCH), MapperS.of(IndexEnum.GCFR), MapperS.of(IndexEnum.ISDA), MapperS.of(IndexEnum.LIBI), MapperS.of(IndexEnum.LIBO), MapperS.of(IndexEnum.MAAA), MapperS.of(IndexEnum.PFAN), MapperS.of(IndexEnum.TIBO), MapperS.of(IndexEnum.STBO), MapperS.of(IndexEnum.BBSW), MapperS.of(IndexEnum.JIBA), MapperS.of(IndexEnum.BUBO), MapperS.of(IndexEnum.CDOR), MapperS.of(IndexEnum.CIBO), MapperS.of(IndexEnum.MOSP), MapperS.of(IndexEnum.NIBO), MapperS.of(IndexEnum.PRBO), MapperS.of(IndexEnum.TLBO), MapperS.of(IndexEnum.WIBO), MapperS.of(IndexEnum.TREA), MapperS.of(IndexEnum.SWAP), MapperS.of(IndexEnum.FUSW), MapperS.of(IndexEnum.EFFR), MapperS.of(IndexEnum.OBFR), MapperS.of(IndexEnum.CZNA), MapperS.of(IndexEnum.TONA)), item).asMapper());
						return ComparisonResult.ofNullSafe(areEqual(thenArg, MapperS.of(true), CardinalityOperator.All).asMapper());
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2015_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
