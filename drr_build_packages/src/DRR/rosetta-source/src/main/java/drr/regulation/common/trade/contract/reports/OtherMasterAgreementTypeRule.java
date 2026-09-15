package drr.regulation.common.trade.contract.reports;

import cdm.event.common.ContractDetails;
import cdm.event.common.metafields.ReferenceWithMetaContractDetails;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.common.LegalAgreementTypeEnum;
import cdm.legaldocumentation.master.MasterAgreementTypeEnum;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterAgreementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OtherMasterAgreementTypeRule.OtherMasterAgreementTypeRuleDefault.class)
public abstract class OtherMasterAgreementTypeRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class OtherMasterAgreementTypeRuleDefault extends OtherMasterAgreementTypeRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<ContractDetails> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(tradeForEvent.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(tradeForEvent.evaluate(item.get())).<ContractDetails>map("getContractDetails", trade -> trade.getContractDetails());
					}
					if (exists(MapperS.of(positionForEvent.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(positionForEvent.evaluate(item.get())).<ReferenceWithMetaContractDetails>map("getContractDetails", counterpartyPosition -> counterpartyPosition.getContractDetails()).<ContractDetails>map("Type coercion", referenceWithMetaContractDetails -> referenceWithMetaContractDetails == null ? null : referenceWithMetaContractDetails.getValue());
					}
					return MapperS.<ContractDetails>ofNull();
				});
			final MapperC<LegalAgreement> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()));
			final MapperC<LegalAgreement> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<LegalAgreementTypeEnum>map("getAgreementType", agreementName -> agreementName.getAgreementType()), MapperS.of(LegalAgreementTypeEnum.MASTER_AGREEMENT), CardinalityOperator.All).get());
			final MapperS<LegalAgreement> thenArg3 = MapperS.of(thenArg2.get());
			final MapperS<AgreementName> thenArg4 = thenArg3
				.mapSingleToItem(item -> item.<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()));
			output = thenArg4
				.mapSingleToItem(item -> {
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum0 -> fieldWithMetaMasterAgreementTypeEnum0 == null ? null : fieldWithMetaMasterAgreementTypeEnum0.getValue()), MapperS.of(MasterAgreementTypeEnum.AFB), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("AFBMAForFXAndDerivativesTransactions");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum1 -> fieldWithMetaMasterAgreementTypeEnum1 == null ? null : fieldWithMetaMasterAgreementTypeEnum1.getValue()), MapperS.of(MasterAgreementTypeEnum.CMA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("ClearingMA");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum2 -> fieldWithMetaMasterAgreementTypeEnum2 == null ? null : fieldWithMetaMasterAgreementTypeEnum2.getValue()), MapperS.of(MasterAgreementTypeEnum.IFEMA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("InternationalForeignExchangeMA");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum3 -> fieldWithMetaMasterAgreementTypeEnum3 == null ? null : fieldWithMetaMasterAgreementTypeEnum3.getValue()), MapperS.of(MasterAgreementTypeEnum.IFEOMA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("InternationalForeignExchangeAndOptionsMA");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum4 -> fieldWithMetaMasterAgreementTypeEnum4 == null ? null : fieldWithMetaMasterAgreementTypeEnum4.getValue()), MapperS.of(MasterAgreementTypeEnum.ICOM), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("InternationalCurrencyOptionsMarketMA");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum5 -> fieldWithMetaMasterAgreementTypeEnum5 == null ? null : fieldWithMetaMasterAgreementTypeEnum5.getValue()), MapperS.of(MasterAgreementTypeEnum.JSCC), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("MasterAgreementOfJapanSecuritiesClearingCorp");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum6 -> fieldWithMetaMasterAgreementTypeEnum6 == null ? null : fieldWithMetaMasterAgreementTypeEnum6.getValue()), MapperS.of(MasterAgreementTypeEnum.EEI_POWER), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("EEIMasterPowerPurchaseAndSaleAgreement");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum7 -> fieldWithMetaMasterAgreementTypeEnum7 == null ? null : fieldWithMetaMasterAgreementTypeEnum7.getValue()), MapperS.of(MasterAgreementTypeEnum.GTMA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("FOAGridTradeMasterAgreement");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum8 -> fieldWithMetaMasterAgreementTypeEnum8 == null ? null : fieldWithMetaMasterAgreementTypeEnum8.getValue()), MapperS.of(MasterAgreementTypeEnum.GAS_EDI), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("GasEDIBaseCntrctShortTermSaleAndPurNatGas");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum9 -> fieldWithMetaMasterAgreementTypeEnum9 == null ? null : fieldWithMetaMasterAgreementTypeEnum9.getValue()), MapperS.of(MasterAgreementTypeEnum.IETA_ERPA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("IntlEmissionTAEmissionReductionPurchaseAgrmt");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum10 -> fieldWithMetaMasterAgreementTypeEnum10 == null ? null : fieldWithMetaMasterAgreementTypeEnum10.getValue()), MapperS.of(MasterAgreementTypeEnum.IETA_ETMA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("IntlEmissionsTradingAssocEmissionsTradingMA");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum11 -> fieldWithMetaMasterAgreementTypeEnum11 == null ? null : fieldWithMetaMasterAgreementTypeEnum11.getValue()), MapperS.of(MasterAgreementTypeEnum.IETA_IETMA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("IntlEmissionsTradingAssocAndTradingMA");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum12 -> fieldWithMetaMasterAgreementTypeEnum12 == null ? null : fieldWithMetaMasterAgreementTypeEnum12.getValue()), MapperS.of(MasterAgreementTypeEnum.LBMA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("IntlBullionMATermsByTheLdnBullionMktAssoc");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum13 -> fieldWithMetaMasterAgreementTypeEnum13 == null ? null : fieldWithMetaMasterAgreementTypeEnum13.getValue()), MapperS.of(MasterAgreementTypeEnum.LEAP), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("LeadershipInEnergyAutomatedProcessing");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum14 -> fieldWithMetaMasterAgreementTypeEnum14 == null ? null : fieldWithMetaMasterAgreementTypeEnum14.getValue()), MapperS.of(MasterAgreementTypeEnum.MCPSA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("CTAMasterCoalPurchaseAndSalesAgreement");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum15 -> fieldWithMetaMasterAgreementTypeEnum15 == null ? null : fieldWithMetaMasterAgreementTypeEnum15.getValue()), MapperS.of(MasterAgreementTypeEnum.NAESB_GAS), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("NAESBBaseContractSaleAndPurchaseOfNaturalGas");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum16 -> fieldWithMetaMasterAgreementTypeEnum16 == null ? null : fieldWithMetaMasterAgreementTypeEnum16.getValue()), MapperS.of(MasterAgreementTypeEnum.NBP), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("ShortTermFlatNBPTradingTermsAndConditions");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum17 -> fieldWithMetaMasterAgreementTypeEnum17 == null ? null : fieldWithMetaMasterAgreementTypeEnum17.getValue()), MapperS.of(MasterAgreementTypeEnum.RUSSIAN_DERIVATIVES), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("StdDocForDerivTxnsOnTheRussianFinMarkets");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum18 -> fieldWithMetaMasterAgreementTypeEnum18 == null ? null : fieldWithMetaMasterAgreementTypeEnum18.getValue()), MapperS.of(MasterAgreementTypeEnum.RUSSIAN_REPO), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("MAForRepurchaseAgreementOnTheRussianFinMkt");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum19 -> fieldWithMetaMasterAgreementTypeEnum19 == null ? null : fieldWithMetaMasterAgreementTypeEnum19.getValue()), MapperS.of(MasterAgreementTypeEnum.S_CO_TA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("globalCOALStandardCoalTradingAgreement");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum20 -> fieldWithMetaMasterAgreementTypeEnum20 == null ? null : fieldWithMetaMasterAgreementTypeEnum20.getValue()), MapperS.of(MasterAgreementTypeEnum.TTF), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("TTFHubNaturalGasTradingTermsAndConditions");
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum21 -> fieldWithMetaMasterAgreementTypeEnum21 == null ? null : fieldWithMetaMasterAgreementTypeEnum21.getValue()), MapperS.of(MasterAgreementTypeEnum.ZBT), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("ZeebruggeHubNaturalGasTradingTandC");
					}
					return item.<String>map("getOtherAgreement", agreementName -> agreementName.getOtherAgreement());
				}).get();
			
			return output;
		}
	}
}
