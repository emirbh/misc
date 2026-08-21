package org.isda.mapper;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.*;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.*;
import cdm.event.workflow.*;
import cdm.observable.asset.PriceQuantity;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import org.isda.mapper.util.CdmBuilderUtil;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Collections;

import static org.isda.mapper.util.CdmBuilderUtil.*;

/**
 * Phase 3: Wraps a CDM TradeState in a WorkflowStep with the correct
 * ActionEnum, EventIntentEnum, and primitive instructions based on
 * the internal SwapTrade's actionType and eventType.
 */
public final class WorkflowStepMapper {

    private WorkflowStepMapper() {}

    public static WorkflowStep map(SwapTrade trade, TradeState tradeState) {
        ActionEnum action = mapAction(trade.getActionType());
        EventIntentEnum intent = mapEventIntent(trade.getEventType());

        Instruction instruction = buildInstruction(trade, tradeState, intent);

        Date eventDate = toDate(trade.getTradeDate());

        return WorkflowStep.builder()
                .setAction(action)
                .setBusinessEvent(BusinessEvent.builder()
                        .setIntent(intent)
                        .setEventDate(eventDate)
                        .addInstruction(instruction)
                        .addAfter(tradeState))
                .addTimestamp(EventTimestamp.builder()
                        .setDateTime(ZonedDateTime.of(
                                trade.getTradeDate(),
                                LocalTime.of(8, 0),
                                ZoneOffset.UTC))
                        .setQualification(EventTimestampQualificationEnum.EVENT_CREATION_DATE_TIME))
                .addEventIdentifier(Identifier.builder()
                        .setIssuer(FieldWithMetaString.builder().setValue("UTI"))
                        .addAssignedIdentifier(AssignedIdentifier.builder()
                                .setIdentifier(FieldWithMetaString.builder()
                                        .setValue(trade.getTradeId()))
                                .setVersion(trade.getTradeVersion())))
                .addParty(buildParty("Party1",
                        trade.getParty1().getLei(), trade.getParty1().getName()))
                .addParty(buildParty("Party2",
                        trade.getParty2().getLei(), trade.getParty2().getName()))
                .setMessageInformation(MessageInformation.builder()
                        .setMessageId(FieldWithMetaString.builder()
                                .setValue(trade.getTradeId() + "_v" + trade.getTradeVersion())))
                .build();
    }

    static ActionEnum mapAction(String actionType) {
        if (actionType == null) return ActionEnum.NEW;
        switch (actionType) {
            case "NEWT": return ActionEnum.NEW;
            case "MODI":
            case "CORR":
            case "REVI": return ActionEnum.CORRECT;
            case "EROR": return ActionEnum.CANCEL;
            case "TERM": return ActionEnum.NEW;
            default: return ActionEnum.NEW;
        }
    }

    static EventIntentEnum mapEventIntent(String eventType) {
        if (eventType == null) return EventIntentEnum.CONTRACT_FORMATION;
        switch (eventType) {
            case "TRAD": return EventIntentEnum.CONTRACT_FORMATION;
            case "NOVA": return EventIntentEnum.NOVATION;
            case "ETRM": return EventIntentEnum.EARLY_TERMINATION_PROVISION;
            case "ALOC": return EventIntentEnum.ALLOCATION;
            case "COMP": return EventIntentEnum.COMPRESSION;
            default: return EventIntentEnum.CONTRACT_FORMATION;
        }
    }

    private static Instruction buildInstruction(SwapTrade trade, TradeState tradeState,
                                                 EventIntentEnum intent) {
        PrimitiveInstruction primitive;

        switch (intent) {
            case CONTRACT_FORMATION:
                primitive = PrimitiveInstruction.builder()
                        .setContractFormation(ContractFormationInstruction.builder()
                                .addLegalAgreement(
                                        cdm.legaldocumentation.common.LegalAgreement.builder()
                                                .setLegalAgreementIdentification(
                                                        cdm.legaldocumentation.common.LegalAgreementIdentification.builder()
                                                                .setAgreementName(
                                                                        cdm.legaldocumentation.common.AgreementName.builder()
                                                                                .setAgreementType(
                                                                                        cdm.legaldocumentation.common.LegalAgreementTypeEnum.MASTER_AGREEMENT)
                                                                                .setMasterAgreementTypeValue(
                                                                                        org.isda.mapper.util.CdmBuilderUtil
                                                                                                .parseMasterAgreementType(
                                                                                                        trade.getMasterAgreementType())))
                                                                .setVintage(2002))
                                                .addContractualParty(ReferenceWithMetaParty.builder()
                                                        .setExternalReference("Party1"))
                                                .addContractualParty(ReferenceWithMetaParty.builder()
                                                        .setExternalReference("Party2"))))
                        .setExecution(buildExecutionInstruction(tradeState))
                        .build();
                break;

            case NOVATION:
                Party newParty = null;
                if (trade.getNovationNewParty() != null) {
                    newParty = buildParty("Party3",
                            trade.getNovationNewParty().getLei(),
                            trade.getNovationNewParty().getName());
                }

                SplitInstruction.SplitInstructionBuilder splitBuilder = SplitInstruction.builder()
                        .addBreakdown(PrimitiveInstruction.builder()
                                .setQuantityChange(QuantityChangeInstruction.builder()
                                        .setDirection(QuantityChangeDirectionEnum.REPLACE)
                                        .addChange(PriceQuantity.builder()
                                                .addQuantity(FieldWithMetaNonNegativeQuantitySchedule.builder()
                                                        .setValue(NonNegativeQuantitySchedule.builder()
                                                                .setValue(BigDecimal.ZERO)
                                                                .setUnit(UnitType.builder()
                                                                        .setCurrency(FieldWithMetaString.builder()
                                                                                .setValue(trade.getNotionalCurrency()))))))));

                if (newParty != null) {
                    splitBuilder.addBreakdown(PrimitiveInstruction.builder()
                            .setPartyChange(PartyChangeInstruction.builder()
                                    .setCounterparty(Counterparty.builder()
                                            .setRole(CounterpartyRoleEnum.PARTY_2)
                                            .setPartyReference(ReferenceWithMetaParty.builder()
                                                    .setExternalReference("Party3")))
                                    .setTradeId(Collections.singletonList(
                                            TradeIdentifier.builder()
                                                    .setIdentifierType(
                                                            cdm.base.staticdata.identifier.TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER)
                                                    .addAssignedIdentifier(AssignedIdentifier.builder()
                                                            .setIdentifier(FieldWithMetaString.builder()
                                                                    .setValue(trade.getTradeId() + "_NOVA"))
                                                            .setVersion(1))
                                                    .setIssuer(FieldWithMetaString.builder()
                                                            .setValue(trade.getNovationNewParty().getLei()))))));
                }

                primitive = PrimitiveInstruction.builder()
                        .setSplit(splitBuilder)
                        .build();
                break;

            case EARLY_TERMINATION_PROVISION:
                primitive = PrimitiveInstruction.builder()
                        .setQuantityChange(QuantityChangeInstruction.builder()
                                .setDirection(QuantityChangeDirectionEnum.REPLACE)
                                .addChange(PriceQuantity.builder()
                                        .addQuantity(FieldWithMetaNonNegativeQuantitySchedule.builder()
                                                .setValue(NonNegativeQuantitySchedule.builder()
                                                        .setValue(BigDecimal.ZERO)
                                                        .setUnit(UnitType.builder()
                                                                .setCurrency(FieldWithMetaString.builder()
                                                                        .setValue(trade.getNotionalCurrency())))))))
                        .build();
                break;

            case ALLOCATION:
                primitive = PrimitiveInstruction.builder()
                        .setSplit(SplitInstruction.builder()
                                .addBreakdown(PrimitiveInstruction.builder()
                                        .setContractFormation(ContractFormationInstruction.builder())))
                        .build();
                break;

            case COMPRESSION:
                primitive = PrimitiveInstruction.builder()
                        .setQuantityChange(QuantityChangeInstruction.builder()
                                .setDirection(QuantityChangeDirectionEnum.REPLACE)
                                .addChange(PriceQuantity.builder()
                                        .addQuantity(FieldWithMetaNonNegativeQuantitySchedule.builder()
                                                .setValue(NonNegativeQuantitySchedule.builder()
                                                        .setValue(BigDecimal.ZERO)
                                                        .setUnit(UnitType.builder()
                                                                .setCurrency(FieldWithMetaString.builder()
                                                                        .setValue(trade.getNotionalCurrency())))))))
                        .build();
                break;

            default:
                primitive = PrimitiveInstruction.builder()
                        .setContractFormation(ContractFormationInstruction.builder())
                        .build();
        }

        return Instruction.builder()
                .setBeforeValue(tradeState)
                .setPrimitiveInstruction(primitive)
                .build();
    }

    /**
     * ExecutionInstruction restates the trade's components flat. In CDM 6
     * these already sit directly on Trade rather than under TradableProduct.
     */
    private static cdm.event.common.ExecutionInstruction buildExecutionInstruction(TradeState tradeState) {
        cdm.event.common.Trade cdmTrade = tradeState.getTrade();

        cdm.event.common.ExecutionInstruction.ExecutionInstructionBuilder builder =
                cdm.event.common.ExecutionInstruction.builder()
                        .setProduct(cdmTrade.getProduct())
                        .setCounterparty(cdmTrade.getCounterparty())
                        .setParties(cdmTrade.getParty())
                        .setExecutionDetails(cdmTrade.getExecutionDetails())
                        .setTradeDate(cdmTrade.getTradeDate())
                        .setTradeIdentifier(cdmTrade.getTradeIdentifier());

        if (!cdmTrade.getTradeLot().isEmpty()) {
            builder.setPriceQuantity(cdmTrade.getTradeLot().get(0).getPriceQuantity());
        }

        return builder.build();
    }
}
