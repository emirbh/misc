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
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MasterAgreementTypeRule.MasterAgreementTypeRuleDefault.class)
public abstract class MasterAgreementTypeRule implements ReportFunction<TransactionReportInstruction, MasterAgreementEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public MasterAgreementEnum evaluate(TransactionReportInstruction input) {
		MasterAgreementEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract MasterAgreementEnum doEvaluate(TransactionReportInstruction input);

	public static class MasterAgreementTypeRuleDefault extends MasterAgreementTypeRule {
		@Override
		protected MasterAgreementEnum doEvaluate(TransactionReportInstruction input) {
			MasterAgreementEnum output = null;
			return assignOutput(output, input);
		}
		
		protected MasterAgreementEnum assignOutput(MasterAgreementEnum output, TransactionReportInstruction input) {
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
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum0 -> fieldWithMetaMasterAgreementTypeEnum0 == null ? null : fieldWithMetaMasterAgreementTypeEnum0.getValue()), MapperS.of(MasterAgreementTypeEnum.ISDA_MASTER), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.ISDA);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum1 -> fieldWithMetaMasterAgreementTypeEnum1 == null ? null : fieldWithMetaMasterAgreementTypeEnum1.getValue()), MapperS.of(MasterAgreementTypeEnum.ISDAFIA_CDEA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.CDEA);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum2 -> fieldWithMetaMasterAgreementTypeEnum2 == null ? null : fieldWithMetaMasterAgreementTypeEnum2.getValue()), MapperS.of(MasterAgreementTypeEnum.EMA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.EUMA);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum3 -> fieldWithMetaMasterAgreementTypeEnum3 == null ? null : fieldWithMetaMasterAgreementTypeEnum3.getValue()), MapperS.of(MasterAgreementTypeEnum.FBF), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.FMAT);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum4 -> fieldWithMetaMasterAgreementTypeEnum4 == null ? null : fieldWithMetaMasterAgreementTypeEnum4.getValue()), MapperS.of(MasterAgreementTypeEnum.GERMAN), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.DERV);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum5 -> fieldWithMetaMasterAgreementTypeEnum5 == null ? null : fieldWithMetaMasterAgreementTypeEnum5.getValue()), MapperS.of(MasterAgreementTypeEnum.CMOF), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.CMOP);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum6 -> fieldWithMetaMasterAgreementTypeEnum6 == null ? null : fieldWithMetaMasterAgreementTypeEnum6.getValue()), MapperS.of(MasterAgreementTypeEnum.SWISS), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.CHMA);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum7 -> fieldWithMetaMasterAgreementTypeEnum7 == null ? null : fieldWithMetaMasterAgreementTypeEnum7.getValue()), MapperS.of(MasterAgreementTypeEnum.EFET_ELECTRICITY), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.EFMA);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum8 -> fieldWithMetaMasterAgreementTypeEnum8 == null ? null : fieldWithMetaMasterAgreementTypeEnum8.getValue()), MapperS.of(MasterAgreementTypeEnum.EFET_GAS), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.EFMA);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum9 -> fieldWithMetaMasterAgreementTypeEnum9 == null ? null : fieldWithMetaMasterAgreementTypeEnum9.getValue()), MapperS.of(MasterAgreementTypeEnum.GMRA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.GMRA);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum10 -> fieldWithMetaMasterAgreementTypeEnum10 == null ? null : fieldWithMetaMasterAgreementTypeEnum10.getValue()), MapperS.of(MasterAgreementTypeEnum.GMSLA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.GMSL);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum11 -> fieldWithMetaMasterAgreementTypeEnum11 == null ? null : fieldWithMetaMasterAgreementTypeEnum11.getValue()), MapperS.of(MasterAgreementTypeEnum.BESPOKE), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.BIAG);
					}
					if (areEqual(item.<FieldWithMetaMasterAgreementTypeEnum>map("getMasterAgreementType", agreementName -> agreementName.getMasterAgreementType()).<MasterAgreementTypeEnum>map("Type coercion", fieldWithMetaMasterAgreementTypeEnum12 -> fieldWithMetaMasterAgreementTypeEnum12 == null ? null : fieldWithMetaMasterAgreementTypeEnum12.getValue()), MapperS.of(MasterAgreementTypeEnum.ISDAIIFM_TMA), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(MasterAgreementEnum.IDMA);
					}
					return MapperS.of(MasterAgreementEnum.OTHR);
				}).get();
			
			return output;
		}
	}
}
