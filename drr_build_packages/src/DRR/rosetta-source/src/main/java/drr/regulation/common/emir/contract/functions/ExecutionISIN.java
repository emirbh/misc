package drr.regulation.common.emir.contract.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TradableOnTradingVenueEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetIsin;
import drr.regulation.common.functions.GetTransactionInformationForRegime;
import drr.standards.iosco.cde.version3.datetime.reports.ExecutionTimestampRule;
import drr.standards.iso.MicData;
import drr.standards.iso.MicTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExecutionISIN.ExecutionISINDefault.class)
public abstract class ExecutionISIN implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExecutionTimestampRule executionTimestampRule;
	@Inject protected GetIsin getIsin;
	@Inject protected GetMicDataForFacility getMicDataForFacility;
	@Inject protected GetTransactionInformationForRegime getTransactionInformationForRegime;
	@Inject protected IsEmirTradingVenue isEmirTradingVenue;
	@Inject protected IsSI isSI;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param transaction 
	* @param regime 
	* @return isin 
	*/
	public String evaluate(TransactionReportInstruction transaction, RegimeNameEnum regime) {
		String isin = doEvaluate(transaction, regime);
		
		return isin;
	}

	protected abstract String doEvaluate(TransactionReportInstruction transaction, RegimeNameEnum regime);

	protected abstract MapperS<? extends MicData> micDataForFacility(TransactionReportInstruction transaction, RegimeNameEnum regime);

	protected abstract MapperS<String> venueMic(TransactionReportInstruction transaction, RegimeNameEnum regime);

	protected abstract MapperS<String> productIsin(TransactionReportInstruction transaction, RegimeNameEnum regime);

	protected abstract MapperS<? extends ReportableJurisdictionInformation> transactionInformation(TransactionReportInstruction transaction, RegimeNameEnum regime);

	protected abstract MapperS<Boolean> isinTotv(TransactionReportInstruction transaction, RegimeNameEnum regime);

	public static class ExecutionISINDefault extends ExecutionISIN {
		@Override
		protected String doEvaluate(TransactionReportInstruction transaction, RegimeNameEnum regime) {
			String isin = null;
			return assignOutput(isin, transaction, regime);
		}
		
		protected String assignOutput(String isin, TransactionReportInstruction transaction, RegimeNameEnum regime) {
			if (exists(venueMic(transaction, regime)).getOrDefault(false)) {
				if (exists(productIsin(transaction, regime)).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isEmirTradingVenue.evaluate(micDataForFacility(transaction, regime).get())))).getOrDefault(false)) {
					isin = productIsin(transaction, regime).get();
				} else if (ComparisonResult.ofNullSafe(MapperS.of(isSI.evaluate(micDataForFacility(transaction, regime).get()))).andNullSafe(ComparisonResult.ofNullSafe(isinTotv(transaction, regime))).getOrDefault(false)) {
					isin = productIsin(transaction, regime).get();
				} else {
					isin = null;
				}
			} else if (exists(productIsin(transaction, regime)).andNullSafe(ComparisonResult.ofNullSafe(isinTotv(transaction, regime))).getOrDefault(false)) {
				isin = productIsin(transaction, regime).get();
			} else {
				isin = null;
			}
			
			return isin;
		}
		
		@Override
		protected MapperS<? extends MicData> micDataForFacility(TransactionReportInstruction transaction, RegimeNameEnum regime) {
			return MapperS.of(getMicDataForFacility.evaluate(MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get()));
		}
		
		@Override
		protected MapperS<String> venueMic(TransactionReportInstruction transaction, RegimeNameEnum regime) {
			final MapperS<? extends MicData> thenArg = micDataForFacility(transaction, regime);
			return thenArg
				.mapSingleToItem(item -> {
					if (areEqual(item.<String>map("getStatus", micData -> micData.getStatus()), MapperS.of("EXPIRED"), CardinalityOperator.All).andNullSafe(lessThanEquals(item.<Date>map("getExpiryDate", micData -> micData.getExpiryDate()), MapperS.of(executionTimestampRule.evaluate(transaction)).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), CardinalityOperator.All)).orNullSafe(notEqual(item.<String>map("getStatus", micData -> micData.getStatus()), MapperS.of("EXPIRED"), CardinalityOperator.Any)).getOrDefault(false)) {
						if (areEqual(item.<MicTypeEnum>map("getMicType", micData -> micData.getMicType()), MapperS.of(MicTypeEnum.SGMT), CardinalityOperator.All).getOrDefault(false)) {
							return item.<String>map("getMic", micData -> micData.getMic());
						}
						return item.<String>map("getOperatingMic", micData -> micData.getOperatingMic());
					}
					return MapperS.<String>ofNull();
				});
		}
		
		@Override
		protected MapperS<String> productIsin(TransactionReportInstruction transaction, RegimeNameEnum regime) {
			return MapperS.of(getIsin.evaluate(productForEvent.evaluate(transaction)));
		}
		
		@Override
		protected MapperS<? extends ReportableJurisdictionInformation> transactionInformation(TransactionReportInstruction transaction, RegimeNameEnum regime) {
			if (areEqual(MapperS.of(regime), MapperS.of(RegimeNameEnum.UKEMIR), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(getTransactionInformationForRegime.evaluate(transaction, RegimeNameEnum.UKEMIR, SupervisoryBodyEnum.FCA));
			}
			return MapperS.of(getTransactionInformationForRegime.evaluate(transaction, RegimeNameEnum.EMIR, SupervisoryBodyEnum.ESMA));
		}
		
		@Override
		protected MapperS<Boolean> isinTotv(TransactionReportInstruction transaction, RegimeNameEnum regime) {
			if (areEqual(MapperS.of(regime), MapperS.of(RegimeNameEnum.UKEMIR), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(areEqual(MapperS.of(getTransactionInformationForRegime.evaluate(transaction, RegimeNameEnum.UKEMIR, SupervisoryBodyEnum.FCA)).<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<TradableOnTradingVenueEnum>map("getTradableOnTradingVenue", _transactionInformation -> _transactionInformation.getTradableOnTradingVenue()), MapperS.of(TradableOnTradingVenueEnum.ADMITTED), CardinalityOperator.All).getOrDefault(false));
			}
			return MapperS.of(areEqual(MapperS.of(getTransactionInformationForRegime.evaluate(transaction, RegimeNameEnum.EMIR, SupervisoryBodyEnum.ESMA)).<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<TradableOnTradingVenueEnum>map("getTradableOnTradingVenue", _transactionInformation -> _transactionInformation.getTradableOnTradingVenue()), MapperS.of(TradableOnTradingVenueEnum.ADMITTED), CardinalityOperator.All).getOrDefault(false));
		}
	}
}
