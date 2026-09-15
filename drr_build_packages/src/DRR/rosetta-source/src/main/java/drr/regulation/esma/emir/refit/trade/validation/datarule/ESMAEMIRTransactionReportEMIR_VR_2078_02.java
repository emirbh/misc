package drr.regulation.esma.emir.refit.trade.validation.datarule;

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
import drr.base.trade.payment.OtherPayment;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import drr.enrichment.lei.functions.GetOrFetchLeiData;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2078_02")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2078_02.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2078_02 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2078_02";
	String DEFINITION = "if (IsVRAllowedForActionType(actionType) or actionType = ActionTypeEnum -> TERM) and otherPayment exists then (otherPayment extract (if receiverFormat = Lei then if GetOrFetchLeiData(empty, receiver) exists then [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] any = GetOrFetchLeiData( empty, receiver ) -> registrationStatus else True) then all = True)";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2078_02 {
	
		@Inject protected GetOrFetchLeiData getOrFetchLeiData;
		
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			try {
				if (ComparisonResult.ofNullSafe(MapperS.of(isVRAllowedForActionType.evaluate(MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()).get()))).orNullSafe(areEqual(MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All)).andNullSafe(exists(MapperS.of(eSMAEMIRTransactionReport).<OtherPayment>mapC("getOtherPayment", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getOtherPayment()))).getOrDefault(false)) {
					final MapperC<Boolean> thenArg = MapperS.of(eSMAEMIRTransactionReport).<OtherPayment>mapC("getOtherPayment", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getOtherPayment())
						.mapItem(item -> {
							if (areEqual(item.<PartyIdentifierFormatEnum>map("getReceiverFormat", otherPayment -> otherPayment.getReceiverFormat()), MapperS.of(PartyIdentifierFormatEnum.LEI), CardinalityOperator.All).getOrDefault(false)) {
								if (exists(MapperS.of(getOrFetchLeiData.evaluate(Collections.<LeiData>emptyList(), item.<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).get()))).getOrDefault(false)) {
									return areEqual(MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)), MapperS.of(getOrFetchLeiData.evaluate(Collections.<LeiData>emptyList(), item.<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).get())).<LeiRegistrationStatusEnum>map("getRegistrationStatus", leiData -> leiData.getRegistrationStatus()), CardinalityOperator.Any).asMapper();
								}
								return MapperS.of(true);
							}
							return MapperS.<Boolean>ofNull();
						});
					return ComparisonResult.ofNullSafe(areEqual(thenArg, MapperS.of(true), CardinalityOperator.All).asMapper());
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2078_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
