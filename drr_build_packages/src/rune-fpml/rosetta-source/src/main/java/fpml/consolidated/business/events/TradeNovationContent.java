package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.meta.TradeNovationContentMeta;
import fpml.consolidated.doc.CreditDerivativesNotices;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.FirstPeriodStartDate;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.ContractualDefinitions;
import fpml.consolidated.shared.ContractualTermsSupplement;
import fpml.consolidated.shared.Empty;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A structure describing a novation.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing a novation.
 *
 */
@RosettaDataType(value="TradeNovationContent", builder=TradeNovationContent.TradeNovationContentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeNovationContent", model="fpml", builder=TradeNovationContent.TradeNovationContentBuilderImpl.class, version="2.1.1")
public interface TradeNovationContent extends AbstractEvent {

	TradeNovationContentMeta metaData = new TradeNovationContentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates a reference to the new trade between the transferee and the remaining party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates a reference to the new trade between the transferee and the remaining party.
	 *
	 */
	List<? extends PartyTradeIdentifier> getNewTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the new trade between the transferee and the remaining party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the new trade between the transferee and the remaining party.
	 *
	 */
	Trade getNewTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates a reference to the original trade between the transferor and the remaining party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates a reference to the original trade between the transferor and the remaining party.
	 *
	 */
	List<? extends PartyTradeIdentifier> getOldTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the original trade between the transferor and the remaining party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the original trade between the transferor and the remaining party.
	 *
	 */
	Trade getOldTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates a reference to the implied trade (the "fee trade") that the associated novation fee based on. This is equivalent to the new trade that is created by the novation (between the transferee and the remaining party), but is between the transferor and the transferee. A reference to the Fee Trade supports regulatory reporting of novations.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates a reference to the implied trade (the "fee trade") that the associated novation fee based on. This is equivalent to the new trade that is created by the novation (between the transferee and the remaining party), but is between the transferor and the transferee. A reference to the Fee Trade supports regulatory reporting of novations.
	 *
	 */
	PartyTradeIdentifier getFeeTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the implied trade (the "fee trade") that the associated novation fee based on. This is equivalent to the new trade that is created by the novation (between the transferee and the remaining party), but is between the transferor and the transferee. Fee Trade supports regulatory reporting of novations.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the implied trade (the "fee trade") that the associated novation fee based on. This is equivalent to the new trade that is created by the novation (between the transferee and the remaining party), but is between the transferor and the transferee. Fee Trade supports regulatory reporting of novations.
	 *
	 */
	Trade getFeeTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. In a three-way novation the party referenced is the Transferor (outgoing party) in the novation. The Transferor means a party which transfers by novation to a Transferee all of its rights, liabilities, duties and obligations with respect to a Remaining Party. In a four-way novation the party referenced is Transferor 1 which transfers by novation to Transferee 1 all of its rights, liabilities, duties and obligations with respect to Transferor 2. ISDA 2004 Novation Term: Transferor (three-way novation) or Transferor 1 (four-way novation).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. In a three-way novation the party referenced is the Transferor (outgoing party) in the novation. The Transferor means a party which transfers by novation to a Transferee all of its rights, liabilities, duties and obligations with respect to a Remaining Party. In a four-way novation the party referenced is Transferor 1 which transfers by novation to Transferee 1 all of its rights, liabilities, duties and obligations with respect to Transferor 2. ISDA 2004 Novation Term: Transferor (three-way novation) or Transferor 1 (four-way novation).
	 *
	 */
	PartyReference getTransferor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AccountReference getTransferorAccount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. In a three-way novation the party referenced is the Transferee (incoming party) in the novation. Transferee means a party which accepts by way of novation all rights, liabilities, duties and obligations of a Transferor with respect to a Remaining Party. In a four-way novation the party referenced is Transferee 1 which accepts by way of novation the rights, liabilities, duties and obligations of Transferor 1. ISDA 2004 Novation Term: Transferee (three-way novation) or Transferee 1 (four-way novation).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. In a three-way novation the party referenced is the Transferee (incoming party) in the novation. Transferee means a party which accepts by way of novation all rights, liabilities, duties and obligations of a Transferor with respect to a Remaining Party. In a four-way novation the party referenced is Transferee 1 which accepts by way of novation the rights, liabilities, duties and obligations of Transferor 1. ISDA 2004 Novation Term: Transferee (three-way novation) or Transferee 1 (four-way novation).
	 *
	 */
	PartyReference getTransferee();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. In a five-way novation the party referenced is the Transferee's legal entity that is involved in the settlement of the fee leg of the novation transaction (this might be a different legal entity than the one that assumes the novation trade). NB: this element has been added pending confirmation of the business need/context in which it would be used, and might not appear in a subsequent draft of this schema.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. In a five-way novation the party referenced is the Transferee's legal entity that is involved in the settlement of the fee leg of the novation transaction (this might be a different legal entity than the one that assumes the novation trade). NB: this element has been added pending confirmation of the business need/context in which it would be used, and might not appear in a subsequent draft of this schema.
	 *
	 */
	PartyReference getOtherTransferee();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AccountReference getTransfereeAccount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AccountReference getOtherTransfereeAccount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. In a three-way novation the party referenced is the Remaining Party in the novation. Remaining Party means a party which consents to a Transferor's transfer by novation and the acceptance thereof by the Transferee of all of the Transferor's rights, liabilities, duties and obligations with respect to such Remaining Party under and with respect of the Novated Amount of a transaction. In a four-way novation the party referenced is Transferor 2 per the ISDA definition and acts in the role of a Transferor. Transferor 2 transfers by novation to Transferee 2 all of its rights, liabilities, duties and obligations with respect to Transferor 1. ISDA 2004 Novation Term: Remaining Party (three-way novation) or Transferor 2 (four-way novation).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. In a three-way novation the party referenced is the Remaining Party in the novation. Remaining Party means a party which consents to a Transferor's transfer by novation and the acceptance thereof by the Transferee of all of the Transferor's rights, liabilities, duties and obligations with respect to such Remaining Party under and with respect of the Novated Amount of a transaction. In a four-way novation the party referenced is Transferor 2 per the ISDA definition and acts in the role of a Transferor. Transferor 2 transfers by novation to Transferee 2 all of its rights, liabilities, duties and obligations with respect to Transferor 1. ISDA 2004 Novation Term: Remaining Party (three-way novation) or Transferor 2 (four-way novation).
	 *
	 */
	PartyReference getRemainingParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AccountReference getRemainingPartyAccount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. This element is not applicable in a three-way novation and should be omitted. In a four-way novation the party referenced is Transferee 2. Transferee 2 means a party which accepts by way of novation the rights, liabilities, duties and obligations of Transferor 2. ISDA 2004 Novation Term: Transferee 2 (four-way novation).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. This element is not applicable in a three-way novation and should be omitted. In a four-way novation the party referenced is Transferee 2. Transferee 2 means a party which accepts by way of novation the rights, liabilities, duties and obligations of Transferor 2. ISDA 2004 Novation Term: Transferee 2 (four-way novation).
	 *
	 */
	PartyReference getOtherRemainingParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AccountReference getOtherRemainingPartyAccount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the date that one party's legal obligations with regard to a trade are transferred to another party. It corresponds to the Novation Date section of the 2004 ISDA Novation Definitions, section 1.16.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the date that one party's legal obligations with regard to a trade are transferred to another party. It corresponds to the Novation Date section of the 2004 ISDA Novation Definitions, section 1.16.
	 *
	 */
	ZonedDateTime getNovationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date and time at which the change was agreed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date and time at which the change was agreed.
	 *
	 */
	ExecutionDateTime getExecutionDateTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the date the parties agree to assign or novate a Contract. If this element is not specified, the novationContractDate will be deemed to be the novationDate. It corresponds to the Novation Trade Date section of the 2004 ISDA Novation Definitions, section 1.17.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the date the parties agree to assign or novate a Contract. If this element is not specified, the novationContractDate will be deemed to be the novationDate. It corresponds to the Novation Trade Date section of the 2004 ISDA Novation Definitions, section 1.17.
	 *
	 */
	ZonedDateTime getNovationTradeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount which represents the portion of the Old Contract being novated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount which represents the portion of the Old Contract being novated.
	 *
	 */
	List<? extends Money> getNovatedAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount which represents the portion of the Old Contract not being novated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount which represents the portion of the Old Contract not being novated.
	 *
	 */
	List<? extends Money> getRemainingAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of options which represent the portion of the Old Contract being novated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of options which represent the portion of the Old Contract being novated.
	 *
	 */
	BigDecimal getNovatedNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of options which represent the portion of the Old Contract not being novated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of options which represent the portion of the Old Contract not being novated.
	 *
	 */
	BigDecimal getRemainingNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of options which represent the portion of the Old Contract being novated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of options which represent the portion of the Old Contract being novated.
	 *
	 */
	BigDecimal getNovatedNumberOfUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of options which represent the portion of the Old Contract not being novated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of options which represent the portion of the Old Contract not being novated.
	 *
	 */
	BigDecimal getRemainingNumberOfUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends TradeLegSizeChange> getNovationAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element corresponds to the applicability of the Full First Calculation Period as defined in the 2004 ISDA Novation Definitions, section 1.20.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element corresponds to the applicability of the Full First Calculation Period as defined in the 2004 ISDA Novation Definitions, section 1.20.
	 *
	 */
	Boolean getFullFirstCalculationPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Element that is used to be able to make sense of the “new transaction” without requiring reference back to the “old transaction”. In the case of interest rate products there are potentially 2 “first period start dates” to reference – one with respect to each party to the new transaction. For Credit Default Swaps there is just the one with respect to the party that is the fixed rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Element that is used to be able to make sense of the “new transaction” without requiring reference back to the “old transaction”. In the case of interest rate products there are potentially 2 “first period start dates” to reference – one with respect to each party to the new transaction. For Credit Default Swaps there is just the one with respect to the party that is the fixed rate payer.
	 *
	 */
	List<? extends FirstPeriodStartDate> getFirstPeriodStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element corresponds to the non-Reliance section in the 2004 ISDA Novation Definitions, section 2.1 (c) (i). The element appears in the instance document when non-Reliance is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element corresponds to the non-Reliance section in the 2004 ISDA Novation Definitions, section 2.1 (c) (i). The element appears in the instance document when non-Reliance is applicable.
	 *
	 */
	Empty getNonReliance();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element should be specified if one or more of either a Credit Event Notice, Notice of Publicly Available Information, Notice of Physical Settlement or Notice of Intended Physical Settlement, as applicable, has been delivered by or to the Transferor or the Remaining Party. The type of notice or notices that have been delivered should be indicated by setting the relevant boolean element value(s) to true. The absence of the element means that no Credit Event Notice, Notice of Publicly Available Information, Notice of Physical Settlement or Notice of Intended Physical Settlement, as applicable, has been delivered by or to the Transferor or the Remaining Party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element should be specified if one or more of either a Credit Event Notice, Notice of Publicly Available Information, Notice of Physical Settlement or Notice of Intended Physical Settlement, as applicable, has been delivered by or to the Transferor or the Remaining Party. The type of notice or notices that have been delivered should be indicated by setting the relevant boolean element value(s) to true. The absence of the element means that no Credit Event Notice, Notice of Publicly Available Information, Notice of Physical Settlement or Notice of Intended Physical Settlement, as applicable, has been delivered by or to the Transferor or the Remaining Party.
	 *
	 */
	CreditDerivativesNotices getCreditDerivativesNotices();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The definitions (such as those published by ISDA) that will define the terms of the novation transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The definitions (such as those published by ISDA) that will define the terms of the novation transaction.
	 *
	 */
	List<? extends ContractualDefinitions> getContractualDefinitions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A contractual supplement (such as those published by ISDA) that will apply to the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A contractual supplement (such as those published by ISDA) that will apply to the trade.
	 *
	 */
	List<? extends ContractualTermsSupplement> getContractualTermsSupplement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes a payment made in settlement of the novation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes a payment made in settlement of the novation.
	 *
	 */
	Payment getPayment();

	/*********************** Build Methods  ***********************/
	TradeNovationContent build();
	
	TradeNovationContent.TradeNovationContentBuilder toBuilder();
	
	static TradeNovationContent.TradeNovationContentBuilder builder() {
		return new TradeNovationContent.TradeNovationContentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNovationContent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeNovationContent> getType() {
		return TradeNovationContent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("newTradeIdentifier"), processor, PartyTradeIdentifier.class, getNewTradeIdentifier());
		processRosetta(path.newSubPath("newTrade"), processor, Trade.class, getNewTrade());
		processRosetta(path.newSubPath("oldTradeIdentifier"), processor, PartyTradeIdentifier.class, getOldTradeIdentifier());
		processRosetta(path.newSubPath("oldTrade"), processor, Trade.class, getOldTrade());
		processRosetta(path.newSubPath("feeTradeIdentifier"), processor, PartyTradeIdentifier.class, getFeeTradeIdentifier());
		processRosetta(path.newSubPath("feeTrade"), processor, Trade.class, getFeeTrade());
		processRosetta(path.newSubPath("transferor"), processor, PartyReference.class, getTransferor());
		processRosetta(path.newSubPath("transferorAccount"), processor, AccountReference.class, getTransferorAccount());
		processRosetta(path.newSubPath("transferee"), processor, PartyReference.class, getTransferee());
		processRosetta(path.newSubPath("otherTransferee"), processor, PartyReference.class, getOtherTransferee());
		processRosetta(path.newSubPath("transfereeAccount"), processor, AccountReference.class, getTransfereeAccount());
		processRosetta(path.newSubPath("otherTransfereeAccount"), processor, AccountReference.class, getOtherTransfereeAccount());
		processRosetta(path.newSubPath("remainingParty"), processor, PartyReference.class, getRemainingParty());
		processRosetta(path.newSubPath("remainingPartyAccount"), processor, AccountReference.class, getRemainingPartyAccount());
		processRosetta(path.newSubPath("otherRemainingParty"), processor, PartyReference.class, getOtherRemainingParty());
		processRosetta(path.newSubPath("otherRemainingPartyAccount"), processor, AccountReference.class, getOtherRemainingPartyAccount());
		processor.processBasic(path.newSubPath("novationDate"), ZonedDateTime.class, getNovationDate(), this);
		processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.class, getExecutionDateTime());
		processor.processBasic(path.newSubPath("novationTradeDate"), ZonedDateTime.class, getNovationTradeDate(), this);
		processRosetta(path.newSubPath("novatedAmount"), processor, Money.class, getNovatedAmount());
		processRosetta(path.newSubPath("remainingAmount"), processor, Money.class, getRemainingAmount());
		processor.processBasic(path.newSubPath("novatedNumberOfOptions"), BigDecimal.class, getNovatedNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("remainingNumberOfOptions"), BigDecimal.class, getRemainingNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("novatedNumberOfUnits"), BigDecimal.class, getNovatedNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("remainingNumberOfUnits"), BigDecimal.class, getRemainingNumberOfUnits(), this);
		processRosetta(path.newSubPath("novationAmount"), processor, TradeLegSizeChange.class, getNovationAmount());
		processor.processBasic(path.newSubPath("fullFirstCalculationPeriod"), Boolean.class, getFullFirstCalculationPeriod(), this);
		processRosetta(path.newSubPath("firstPeriodStartDate"), processor, FirstPeriodStartDate.class, getFirstPeriodStartDate());
		processRosetta(path.newSubPath("nonReliance"), processor, Empty.class, getNonReliance());
		processRosetta(path.newSubPath("creditDerivativesNotices"), processor, CreditDerivativesNotices.class, getCreditDerivativesNotices());
		processRosetta(path.newSubPath("contractualDefinitions"), processor, ContractualDefinitions.class, getContractualDefinitions());
		processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.class, getContractualTermsSupplement());
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNovationContentBuilder extends TradeNovationContent, AbstractEvent.AbstractEventBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateNewTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getNewTradeIdentifier();
		Trade.TradeBuilder getOrCreateNewTrade();
		@Override
		Trade.TradeBuilder getNewTrade();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateOldTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getOldTradeIdentifier();
		Trade.TradeBuilder getOrCreateOldTrade();
		@Override
		Trade.TradeBuilder getOldTrade();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateFeeTradeIdentifier();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getFeeTradeIdentifier();
		Trade.TradeBuilder getOrCreateFeeTrade();
		@Override
		Trade.TradeBuilder getFeeTrade();
		PartyReference.PartyReferenceBuilder getOrCreateTransferor();
		@Override
		PartyReference.PartyReferenceBuilder getTransferor();
		AccountReference.AccountReferenceBuilder getOrCreateTransferorAccount();
		@Override
		AccountReference.AccountReferenceBuilder getTransferorAccount();
		PartyReference.PartyReferenceBuilder getOrCreateTransferee();
		@Override
		PartyReference.PartyReferenceBuilder getTransferee();
		PartyReference.PartyReferenceBuilder getOrCreateOtherTransferee();
		@Override
		PartyReference.PartyReferenceBuilder getOtherTransferee();
		AccountReference.AccountReferenceBuilder getOrCreateTransfereeAccount();
		@Override
		AccountReference.AccountReferenceBuilder getTransfereeAccount();
		AccountReference.AccountReferenceBuilder getOrCreateOtherTransfereeAccount();
		@Override
		AccountReference.AccountReferenceBuilder getOtherTransfereeAccount();
		PartyReference.PartyReferenceBuilder getOrCreateRemainingParty();
		@Override
		PartyReference.PartyReferenceBuilder getRemainingParty();
		AccountReference.AccountReferenceBuilder getOrCreateRemainingPartyAccount();
		@Override
		AccountReference.AccountReferenceBuilder getRemainingPartyAccount();
		PartyReference.PartyReferenceBuilder getOrCreateOtherRemainingParty();
		@Override
		PartyReference.PartyReferenceBuilder getOtherRemainingParty();
		AccountReference.AccountReferenceBuilder getOrCreateOtherRemainingPartyAccount();
		@Override
		AccountReference.AccountReferenceBuilder getOtherRemainingPartyAccount();
		ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime();
		@Override
		ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime();
		Money.MoneyBuilder getOrCreateNovatedAmount(int index);
		@Override
		List<? extends Money.MoneyBuilder> getNovatedAmount();
		Money.MoneyBuilder getOrCreateRemainingAmount(int index);
		@Override
		List<? extends Money.MoneyBuilder> getRemainingAmount();
		TradeLegSizeChange.TradeLegSizeChangeBuilder getOrCreateNovationAmount(int index);
		@Override
		List<? extends TradeLegSizeChange.TradeLegSizeChangeBuilder> getNovationAmount();
		FirstPeriodStartDate.FirstPeriodStartDateBuilder getOrCreateFirstPeriodStartDate(int index);
		@Override
		List<? extends FirstPeriodStartDate.FirstPeriodStartDateBuilder> getFirstPeriodStartDate();
		Empty.EmptyBuilder getOrCreateNonReliance();
		@Override
		Empty.EmptyBuilder getNonReliance();
		CreditDerivativesNotices.CreditDerivativesNoticesBuilder getOrCreateCreditDerivativesNotices();
		@Override
		CreditDerivativesNotices.CreditDerivativesNoticesBuilder getCreditDerivativesNotices();
		ContractualDefinitions.ContractualDefinitionsBuilder getOrCreateContractualDefinitions(int index);
		@Override
		List<? extends ContractualDefinitions.ContractualDefinitionsBuilder> getContractualDefinitions();
		ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int index);
		@Override
		List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement();
		Payment.PaymentBuilder getOrCreatePayment();
		@Override
		Payment.PaymentBuilder getPayment();
		@Override
		TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		TradeNovationContent.TradeNovationContentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		TradeNovationContent.TradeNovationContentBuilder addNewTradeIdentifier(PartyTradeIdentifier newTradeIdentifier);
		TradeNovationContent.TradeNovationContentBuilder addNewTradeIdentifier(PartyTradeIdentifier newTradeIdentifier, int idx);
		TradeNovationContent.TradeNovationContentBuilder addNewTradeIdentifier(List<? extends PartyTradeIdentifier> newTradeIdentifier);
		TradeNovationContent.TradeNovationContentBuilder setNewTradeIdentifier(List<? extends PartyTradeIdentifier> newTradeIdentifier);
		TradeNovationContent.TradeNovationContentBuilder setNewTrade(Trade newTrade);
		TradeNovationContent.TradeNovationContentBuilder addOldTradeIdentifier(PartyTradeIdentifier oldTradeIdentifier);
		TradeNovationContent.TradeNovationContentBuilder addOldTradeIdentifier(PartyTradeIdentifier oldTradeIdentifier, int idx);
		TradeNovationContent.TradeNovationContentBuilder addOldTradeIdentifier(List<? extends PartyTradeIdentifier> oldTradeIdentifier);
		TradeNovationContent.TradeNovationContentBuilder setOldTradeIdentifier(List<? extends PartyTradeIdentifier> oldTradeIdentifier);
		TradeNovationContent.TradeNovationContentBuilder setOldTrade(Trade oldTrade);
		TradeNovationContent.TradeNovationContentBuilder setFeeTradeIdentifier(PartyTradeIdentifier feeTradeIdentifier);
		TradeNovationContent.TradeNovationContentBuilder setFeeTrade(Trade feeTrade);
		TradeNovationContent.TradeNovationContentBuilder setTransferor(PartyReference transferor);
		TradeNovationContent.TradeNovationContentBuilder setTransferorAccount(AccountReference transferorAccount);
		TradeNovationContent.TradeNovationContentBuilder setTransferee(PartyReference transferee);
		TradeNovationContent.TradeNovationContentBuilder setOtherTransferee(PartyReference otherTransferee);
		TradeNovationContent.TradeNovationContentBuilder setTransfereeAccount(AccountReference transfereeAccount);
		TradeNovationContent.TradeNovationContentBuilder setOtherTransfereeAccount(AccountReference otherTransfereeAccount);
		TradeNovationContent.TradeNovationContentBuilder setRemainingParty(PartyReference remainingParty);
		TradeNovationContent.TradeNovationContentBuilder setRemainingPartyAccount(AccountReference remainingPartyAccount);
		TradeNovationContent.TradeNovationContentBuilder setOtherRemainingParty(PartyReference otherRemainingParty);
		TradeNovationContent.TradeNovationContentBuilder setOtherRemainingPartyAccount(AccountReference otherRemainingPartyAccount);
		TradeNovationContent.TradeNovationContentBuilder setNovationDate(ZonedDateTime novationDate);
		TradeNovationContent.TradeNovationContentBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		TradeNovationContent.TradeNovationContentBuilder setNovationTradeDate(ZonedDateTime novationTradeDate);
		TradeNovationContent.TradeNovationContentBuilder addNovatedAmount(Money novatedAmount);
		TradeNovationContent.TradeNovationContentBuilder addNovatedAmount(Money novatedAmount, int idx);
		TradeNovationContent.TradeNovationContentBuilder addNovatedAmount(List<? extends Money> novatedAmount);
		TradeNovationContent.TradeNovationContentBuilder setNovatedAmount(List<? extends Money> novatedAmount);
		TradeNovationContent.TradeNovationContentBuilder addRemainingAmount(Money remainingAmount);
		TradeNovationContent.TradeNovationContentBuilder addRemainingAmount(Money remainingAmount, int idx);
		TradeNovationContent.TradeNovationContentBuilder addRemainingAmount(List<? extends Money> remainingAmount);
		TradeNovationContent.TradeNovationContentBuilder setRemainingAmount(List<? extends Money> remainingAmount);
		TradeNovationContent.TradeNovationContentBuilder setNovatedNumberOfOptions(BigDecimal novatedNumberOfOptions);
		TradeNovationContent.TradeNovationContentBuilder setRemainingNumberOfOptions(BigDecimal remainingNumberOfOptions);
		TradeNovationContent.TradeNovationContentBuilder setNovatedNumberOfUnits(BigDecimal novatedNumberOfUnits);
		TradeNovationContent.TradeNovationContentBuilder setRemainingNumberOfUnits(BigDecimal remainingNumberOfUnits);
		TradeNovationContent.TradeNovationContentBuilder addNovationAmount(TradeLegSizeChange novationAmount);
		TradeNovationContent.TradeNovationContentBuilder addNovationAmount(TradeLegSizeChange novationAmount, int idx);
		TradeNovationContent.TradeNovationContentBuilder addNovationAmount(List<? extends TradeLegSizeChange> novationAmount);
		TradeNovationContent.TradeNovationContentBuilder setNovationAmount(List<? extends TradeLegSizeChange> novationAmount);
		TradeNovationContent.TradeNovationContentBuilder setFullFirstCalculationPeriod(Boolean fullFirstCalculationPeriod);
		TradeNovationContent.TradeNovationContentBuilder addFirstPeriodStartDate(FirstPeriodStartDate firstPeriodStartDate);
		TradeNovationContent.TradeNovationContentBuilder addFirstPeriodStartDate(FirstPeriodStartDate firstPeriodStartDate, int idx);
		TradeNovationContent.TradeNovationContentBuilder addFirstPeriodStartDate(List<? extends FirstPeriodStartDate> firstPeriodStartDate);
		TradeNovationContent.TradeNovationContentBuilder setFirstPeriodStartDate(List<? extends FirstPeriodStartDate> firstPeriodStartDate);
		TradeNovationContent.TradeNovationContentBuilder setNonReliance(Empty nonReliance);
		TradeNovationContent.TradeNovationContentBuilder setCreditDerivativesNotices(CreditDerivativesNotices creditDerivativesNotices);
		TradeNovationContent.TradeNovationContentBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions);
		TradeNovationContent.TradeNovationContentBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions, int idx);
		TradeNovationContent.TradeNovationContentBuilder addContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitions);
		TradeNovationContent.TradeNovationContentBuilder setContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitions);
		TradeNovationContent.TradeNovationContentBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement);
		TradeNovationContent.TradeNovationContentBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement, int idx);
		TradeNovationContent.TradeNovationContentBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement);
		TradeNovationContent.TradeNovationContentBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement);
		TradeNovationContent.TradeNovationContentBuilder setPayment(Payment payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("newTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getNewTradeIdentifier());
			processRosetta(path.newSubPath("newTrade"), processor, Trade.TradeBuilder.class, getNewTrade());
			processRosetta(path.newSubPath("oldTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getOldTradeIdentifier());
			processRosetta(path.newSubPath("oldTrade"), processor, Trade.TradeBuilder.class, getOldTrade());
			processRosetta(path.newSubPath("feeTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getFeeTradeIdentifier());
			processRosetta(path.newSubPath("feeTrade"), processor, Trade.TradeBuilder.class, getFeeTrade());
			processRosetta(path.newSubPath("transferor"), processor, PartyReference.PartyReferenceBuilder.class, getTransferor());
			processRosetta(path.newSubPath("transferorAccount"), processor, AccountReference.AccountReferenceBuilder.class, getTransferorAccount());
			processRosetta(path.newSubPath("transferee"), processor, PartyReference.PartyReferenceBuilder.class, getTransferee());
			processRosetta(path.newSubPath("otherTransferee"), processor, PartyReference.PartyReferenceBuilder.class, getOtherTransferee());
			processRosetta(path.newSubPath("transfereeAccount"), processor, AccountReference.AccountReferenceBuilder.class, getTransfereeAccount());
			processRosetta(path.newSubPath("otherTransfereeAccount"), processor, AccountReference.AccountReferenceBuilder.class, getOtherTransfereeAccount());
			processRosetta(path.newSubPath("remainingParty"), processor, PartyReference.PartyReferenceBuilder.class, getRemainingParty());
			processRosetta(path.newSubPath("remainingPartyAccount"), processor, AccountReference.AccountReferenceBuilder.class, getRemainingPartyAccount());
			processRosetta(path.newSubPath("otherRemainingParty"), processor, PartyReference.PartyReferenceBuilder.class, getOtherRemainingParty());
			processRosetta(path.newSubPath("otherRemainingPartyAccount"), processor, AccountReference.AccountReferenceBuilder.class, getOtherRemainingPartyAccount());
			processor.processBasic(path.newSubPath("novationDate"), ZonedDateTime.class, getNovationDate(), this);
			processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.ExecutionDateTimeBuilder.class, getExecutionDateTime());
			processor.processBasic(path.newSubPath("novationTradeDate"), ZonedDateTime.class, getNovationTradeDate(), this);
			processRosetta(path.newSubPath("novatedAmount"), processor, Money.MoneyBuilder.class, getNovatedAmount());
			processRosetta(path.newSubPath("remainingAmount"), processor, Money.MoneyBuilder.class, getRemainingAmount());
			processor.processBasic(path.newSubPath("novatedNumberOfOptions"), BigDecimal.class, getNovatedNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("remainingNumberOfOptions"), BigDecimal.class, getRemainingNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("novatedNumberOfUnits"), BigDecimal.class, getNovatedNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("remainingNumberOfUnits"), BigDecimal.class, getRemainingNumberOfUnits(), this);
			processRosetta(path.newSubPath("novationAmount"), processor, TradeLegSizeChange.TradeLegSizeChangeBuilder.class, getNovationAmount());
			processor.processBasic(path.newSubPath("fullFirstCalculationPeriod"), Boolean.class, getFullFirstCalculationPeriod(), this);
			processRosetta(path.newSubPath("firstPeriodStartDate"), processor, FirstPeriodStartDate.FirstPeriodStartDateBuilder.class, getFirstPeriodStartDate());
			processRosetta(path.newSubPath("nonReliance"), processor, Empty.EmptyBuilder.class, getNonReliance());
			processRosetta(path.newSubPath("creditDerivativesNotices"), processor, CreditDerivativesNotices.CreditDerivativesNoticesBuilder.class, getCreditDerivativesNotices());
			processRosetta(path.newSubPath("contractualDefinitions"), processor, ContractualDefinitions.ContractualDefinitionsBuilder.class, getContractualDefinitions());
			processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.ContractualTermsSupplementBuilder.class, getContractualTermsSupplement());
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		TradeNovationContent.TradeNovationContentBuilder prune();
	}

	/*********************** Immutable Implementation of TradeNovationContent  ***********************/
	class TradeNovationContentImpl extends AbstractEvent.AbstractEventImpl implements TradeNovationContent {
		private final List<? extends PartyTradeIdentifier> newTradeIdentifier;
		private final Trade newTrade;
		private final List<? extends PartyTradeIdentifier> oldTradeIdentifier;
		private final Trade oldTrade;
		private final PartyTradeIdentifier feeTradeIdentifier;
		private final Trade feeTrade;
		private final PartyReference transferor;
		private final AccountReference transferorAccount;
		private final PartyReference transferee;
		private final PartyReference otherTransferee;
		private final AccountReference transfereeAccount;
		private final AccountReference otherTransfereeAccount;
		private final PartyReference remainingParty;
		private final AccountReference remainingPartyAccount;
		private final PartyReference otherRemainingParty;
		private final AccountReference otherRemainingPartyAccount;
		private final ZonedDateTime novationDate;
		private final ExecutionDateTime executionDateTime;
		private final ZonedDateTime novationTradeDate;
		private final List<? extends Money> novatedAmount;
		private final List<? extends Money> remainingAmount;
		private final BigDecimal novatedNumberOfOptions;
		private final BigDecimal remainingNumberOfOptions;
		private final BigDecimal novatedNumberOfUnits;
		private final BigDecimal remainingNumberOfUnits;
		private final List<? extends TradeLegSizeChange> novationAmount;
		private final Boolean fullFirstCalculationPeriod;
		private final List<? extends FirstPeriodStartDate> firstPeriodStartDate;
		private final Empty nonReliance;
		private final CreditDerivativesNotices creditDerivativesNotices;
		private final List<? extends ContractualDefinitions> contractualDefinitions;
		private final List<? extends ContractualTermsSupplement> contractualTermsSupplement;
		private final Payment payment;
		
		protected TradeNovationContentImpl(TradeNovationContent.TradeNovationContentBuilder builder) {
			super(builder);
			this.newTradeIdentifier = ofNullable(builder.getNewTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.newTrade = ofNullable(builder.getNewTrade()).map(f->f.build()).orElse(null);
			this.oldTradeIdentifier = ofNullable(builder.getOldTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.oldTrade = ofNullable(builder.getOldTrade()).map(f->f.build()).orElse(null);
			this.feeTradeIdentifier = ofNullable(builder.getFeeTradeIdentifier()).map(f->f.build()).orElse(null);
			this.feeTrade = ofNullable(builder.getFeeTrade()).map(f->f.build()).orElse(null);
			this.transferor = ofNullable(builder.getTransferor()).map(f->f.build()).orElse(null);
			this.transferorAccount = ofNullable(builder.getTransferorAccount()).map(f->f.build()).orElse(null);
			this.transferee = ofNullable(builder.getTransferee()).map(f->f.build()).orElse(null);
			this.otherTransferee = ofNullable(builder.getOtherTransferee()).map(f->f.build()).orElse(null);
			this.transfereeAccount = ofNullable(builder.getTransfereeAccount()).map(f->f.build()).orElse(null);
			this.otherTransfereeAccount = ofNullable(builder.getOtherTransfereeAccount()).map(f->f.build()).orElse(null);
			this.remainingParty = ofNullable(builder.getRemainingParty()).map(f->f.build()).orElse(null);
			this.remainingPartyAccount = ofNullable(builder.getRemainingPartyAccount()).map(f->f.build()).orElse(null);
			this.otherRemainingParty = ofNullable(builder.getOtherRemainingParty()).map(f->f.build()).orElse(null);
			this.otherRemainingPartyAccount = ofNullable(builder.getOtherRemainingPartyAccount()).map(f->f.build()).orElse(null);
			this.novationDate = builder.getNovationDate();
			this.executionDateTime = ofNullable(builder.getExecutionDateTime()).map(f->f.build()).orElse(null);
			this.novationTradeDate = builder.getNovationTradeDate();
			this.novatedAmount = ofNullable(builder.getNovatedAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.remainingAmount = ofNullable(builder.getRemainingAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.novatedNumberOfOptions = builder.getNovatedNumberOfOptions();
			this.remainingNumberOfOptions = builder.getRemainingNumberOfOptions();
			this.novatedNumberOfUnits = builder.getNovatedNumberOfUnits();
			this.remainingNumberOfUnits = builder.getRemainingNumberOfUnits();
			this.novationAmount = ofNullable(builder.getNovationAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fullFirstCalculationPeriod = builder.getFullFirstCalculationPeriod();
			this.firstPeriodStartDate = ofNullable(builder.getFirstPeriodStartDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.nonReliance = ofNullable(builder.getNonReliance()).map(f->f.build()).orElse(null);
			this.creditDerivativesNotices = ofNullable(builder.getCreditDerivativesNotices()).map(f->f.build()).orElse(null);
			this.contractualDefinitions = ofNullable(builder.getContractualDefinitions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualTermsSupplement = ofNullable(builder.getContractualTermsSupplement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("newTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("newTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getNewTradeIdentifier() {
			return newTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("newTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("newTrade")
		public Trade getNewTrade() {
			return newTrade;
		}
		
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("oldTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getOldTradeIdentifier() {
			return oldTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("oldTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oldTrade")
		public Trade getOldTrade() {
			return oldTrade;
		}
		
		@Override
		@RosettaAttribute("feeTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeTradeIdentifier")
		public PartyTradeIdentifier getFeeTradeIdentifier() {
			return feeTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("feeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeTrade")
		public Trade getFeeTrade() {
			return feeTrade;
		}
		
		@Override
		@RosettaAttribute("transferor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferor")
		public PartyReference getTransferor() {
			return transferor;
		}
		
		@Override
		@RosettaAttribute("transferorAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferorAccount")
		public AccountReference getTransferorAccount() {
			return transferorAccount;
		}
		
		@Override
		@RosettaAttribute("transferee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferee")
		public PartyReference getTransferee() {
			return transferee;
		}
		
		@Override
		@RosettaAttribute("otherTransferee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherTransferee")
		public PartyReference getOtherTransferee() {
			return otherTransferee;
		}
		
		@Override
		@RosettaAttribute("transfereeAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transfereeAccount")
		public AccountReference getTransfereeAccount() {
			return transfereeAccount;
		}
		
		@Override
		@RosettaAttribute("otherTransfereeAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherTransfereeAccount")
		public AccountReference getOtherTransfereeAccount() {
			return otherTransfereeAccount;
		}
		
		@Override
		@RosettaAttribute("remainingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remainingParty")
		public PartyReference getRemainingParty() {
			return remainingParty;
		}
		
		@Override
		@RosettaAttribute("remainingPartyAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remainingPartyAccount")
		public AccountReference getRemainingPartyAccount() {
			return remainingPartyAccount;
		}
		
		@Override
		@RosettaAttribute("otherRemainingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherRemainingParty")
		public PartyReference getOtherRemainingParty() {
			return otherRemainingParty;
		}
		
		@Override
		@RosettaAttribute("otherRemainingPartyAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherRemainingPartyAccount")
		public AccountReference getOtherRemainingPartyAccount() {
			return otherRemainingPartyAccount;
		}
		
		@Override
		@RosettaAttribute("novationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novationDate")
		public ZonedDateTime getNovationDate() {
			return novationDate;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionDateTime")
		public ExecutionDateTime getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		@RosettaAttribute("novationTradeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novationTradeDate")
		public ZonedDateTime getNovationTradeDate() {
			return novationTradeDate;
		}
		
		@Override
		@RosettaAttribute("novatedAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("novatedAmount")
		public List<? extends Money> getNovatedAmount() {
			return novatedAmount;
		}
		
		@Override
		@RosettaAttribute("remainingAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("remainingAmount")
		public List<? extends Money> getRemainingAmount() {
			return remainingAmount;
		}
		
		@Override
		@RosettaAttribute("novatedNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novatedNumberOfOptions")
		public BigDecimal getNovatedNumberOfOptions() {
			return novatedNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("remainingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remainingNumberOfOptions")
		public BigDecimal getRemainingNumberOfOptions() {
			return remainingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("novatedNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novatedNumberOfUnits")
		public BigDecimal getNovatedNumberOfUnits() {
			return novatedNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("remainingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remainingNumberOfUnits")
		public BigDecimal getRemainingNumberOfUnits() {
			return remainingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("novationAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("novationAmount")
		public List<? extends TradeLegSizeChange> getNovationAmount() {
			return novationAmount;
		}
		
		@Override
		@RosettaAttribute("fullFirstCalculationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullFirstCalculationPeriod")
		public Boolean getFullFirstCalculationPeriod() {
			return fullFirstCalculationPeriod;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("firstPeriodStartDate")
		public List<? extends FirstPeriodStartDate> getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("nonReliance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReliance")
		public Empty getNonReliance() {
			return nonReliance;
		}
		
		@Override
		@RosettaAttribute("creditDerivativesNotices")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditDerivativesNotices")
		public CreditDerivativesNotices getCreditDerivativesNotices() {
			return creditDerivativesNotices;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualDefinitions")
		public List<? extends ContractualDefinitions> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public Payment getPayment() {
			return payment;
		}
		
		@Override
		public TradeNovationContent build() {
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder toBuilder() {
			TradeNovationContent.TradeNovationContentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNovationContent.TradeNovationContentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNewTradeIdentifier()).ifPresent(builder::setNewTradeIdentifier);
			ofNullable(getNewTrade()).ifPresent(builder::setNewTrade);
			ofNullable(getOldTradeIdentifier()).ifPresent(builder::setOldTradeIdentifier);
			ofNullable(getOldTrade()).ifPresent(builder::setOldTrade);
			ofNullable(getFeeTradeIdentifier()).ifPresent(builder::setFeeTradeIdentifier);
			ofNullable(getFeeTrade()).ifPresent(builder::setFeeTrade);
			ofNullable(getTransferor()).ifPresent(builder::setTransferor);
			ofNullable(getTransferorAccount()).ifPresent(builder::setTransferorAccount);
			ofNullable(getTransferee()).ifPresent(builder::setTransferee);
			ofNullable(getOtherTransferee()).ifPresent(builder::setOtherTransferee);
			ofNullable(getTransfereeAccount()).ifPresent(builder::setTransfereeAccount);
			ofNullable(getOtherTransfereeAccount()).ifPresent(builder::setOtherTransfereeAccount);
			ofNullable(getRemainingParty()).ifPresent(builder::setRemainingParty);
			ofNullable(getRemainingPartyAccount()).ifPresent(builder::setRemainingPartyAccount);
			ofNullable(getOtherRemainingParty()).ifPresent(builder::setOtherRemainingParty);
			ofNullable(getOtherRemainingPartyAccount()).ifPresent(builder::setOtherRemainingPartyAccount);
			ofNullable(getNovationDate()).ifPresent(builder::setNovationDate);
			ofNullable(getExecutionDateTime()).ifPresent(builder::setExecutionDateTime);
			ofNullable(getNovationTradeDate()).ifPresent(builder::setNovationTradeDate);
			ofNullable(getNovatedAmount()).ifPresent(builder::setNovatedAmount);
			ofNullable(getRemainingAmount()).ifPresent(builder::setRemainingAmount);
			ofNullable(getNovatedNumberOfOptions()).ifPresent(builder::setNovatedNumberOfOptions);
			ofNullable(getRemainingNumberOfOptions()).ifPresent(builder::setRemainingNumberOfOptions);
			ofNullable(getNovatedNumberOfUnits()).ifPresent(builder::setNovatedNumberOfUnits);
			ofNullable(getRemainingNumberOfUnits()).ifPresent(builder::setRemainingNumberOfUnits);
			ofNullable(getNovationAmount()).ifPresent(builder::setNovationAmount);
			ofNullable(getFullFirstCalculationPeriod()).ifPresent(builder::setFullFirstCalculationPeriod);
			ofNullable(getFirstPeriodStartDate()).ifPresent(builder::setFirstPeriodStartDate);
			ofNullable(getNonReliance()).ifPresent(builder::setNonReliance);
			ofNullable(getCreditDerivativesNotices()).ifPresent(builder::setCreditDerivativesNotices);
			ofNullable(getContractualDefinitions()).ifPresent(builder::setContractualDefinitions);
			ofNullable(getContractualTermsSupplement()).ifPresent(builder::setContractualTermsSupplement);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeNovationContent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(newTradeIdentifier, _that.getNewTradeIdentifier())) return false;
			if (!Objects.equals(newTrade, _that.getNewTrade())) return false;
			if (!ListEquals.listEquals(oldTradeIdentifier, _that.getOldTradeIdentifier())) return false;
			if (!Objects.equals(oldTrade, _that.getOldTrade())) return false;
			if (!Objects.equals(feeTradeIdentifier, _that.getFeeTradeIdentifier())) return false;
			if (!Objects.equals(feeTrade, _that.getFeeTrade())) return false;
			if (!Objects.equals(transferor, _that.getTransferor())) return false;
			if (!Objects.equals(transferorAccount, _that.getTransferorAccount())) return false;
			if (!Objects.equals(transferee, _that.getTransferee())) return false;
			if (!Objects.equals(otherTransferee, _that.getOtherTransferee())) return false;
			if (!Objects.equals(transfereeAccount, _that.getTransfereeAccount())) return false;
			if (!Objects.equals(otherTransfereeAccount, _that.getOtherTransfereeAccount())) return false;
			if (!Objects.equals(remainingParty, _that.getRemainingParty())) return false;
			if (!Objects.equals(remainingPartyAccount, _that.getRemainingPartyAccount())) return false;
			if (!Objects.equals(otherRemainingParty, _that.getOtherRemainingParty())) return false;
			if (!Objects.equals(otherRemainingPartyAccount, _that.getOtherRemainingPartyAccount())) return false;
			if (!Objects.equals(novationDate, _that.getNovationDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(novationTradeDate, _that.getNovationTradeDate())) return false;
			if (!ListEquals.listEquals(novatedAmount, _that.getNovatedAmount())) return false;
			if (!ListEquals.listEquals(remainingAmount, _that.getRemainingAmount())) return false;
			if (!Objects.equals(novatedNumberOfOptions, _that.getNovatedNumberOfOptions())) return false;
			if (!Objects.equals(remainingNumberOfOptions, _that.getRemainingNumberOfOptions())) return false;
			if (!Objects.equals(novatedNumberOfUnits, _that.getNovatedNumberOfUnits())) return false;
			if (!Objects.equals(remainingNumberOfUnits, _that.getRemainingNumberOfUnits())) return false;
			if (!ListEquals.listEquals(novationAmount, _that.getNovationAmount())) return false;
			if (!Objects.equals(fullFirstCalculationPeriod, _that.getFullFirstCalculationPeriod())) return false;
			if (!ListEquals.listEquals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			if (!Objects.equals(creditDerivativesNotices, _that.getCreditDerivativesNotices())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (newTradeIdentifier != null ? newTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (newTrade != null ? newTrade.hashCode() : 0);
			_result = 31 * _result + (oldTradeIdentifier != null ? oldTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (oldTrade != null ? oldTrade.hashCode() : 0);
			_result = 31 * _result + (feeTradeIdentifier != null ? feeTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (feeTrade != null ? feeTrade.hashCode() : 0);
			_result = 31 * _result + (transferor != null ? transferor.hashCode() : 0);
			_result = 31 * _result + (transferorAccount != null ? transferorAccount.hashCode() : 0);
			_result = 31 * _result + (transferee != null ? transferee.hashCode() : 0);
			_result = 31 * _result + (otherTransferee != null ? otherTransferee.hashCode() : 0);
			_result = 31 * _result + (transfereeAccount != null ? transfereeAccount.hashCode() : 0);
			_result = 31 * _result + (otherTransfereeAccount != null ? otherTransfereeAccount.hashCode() : 0);
			_result = 31 * _result + (remainingParty != null ? remainingParty.hashCode() : 0);
			_result = 31 * _result + (remainingPartyAccount != null ? remainingPartyAccount.hashCode() : 0);
			_result = 31 * _result + (otherRemainingParty != null ? otherRemainingParty.hashCode() : 0);
			_result = 31 * _result + (otherRemainingPartyAccount != null ? otherRemainingPartyAccount.hashCode() : 0);
			_result = 31 * _result + (novationDate != null ? novationDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (novationTradeDate != null ? novationTradeDate.hashCode() : 0);
			_result = 31 * _result + (novatedAmount != null ? novatedAmount.hashCode() : 0);
			_result = 31 * _result + (remainingAmount != null ? remainingAmount.hashCode() : 0);
			_result = 31 * _result + (novatedNumberOfOptions != null ? novatedNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (remainingNumberOfOptions != null ? remainingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (novatedNumberOfUnits != null ? novatedNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (remainingNumberOfUnits != null ? remainingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (novationAmount != null ? novationAmount.hashCode() : 0);
			_result = 31 * _result + (fullFirstCalculationPeriod != null ? fullFirstCalculationPeriod.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			_result = 31 * _result + (creditDerivativesNotices != null ? creditDerivativesNotices.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNovationContent {" +
				"newTradeIdentifier=" + this.newTradeIdentifier + ", " +
				"newTrade=" + this.newTrade + ", " +
				"oldTradeIdentifier=" + this.oldTradeIdentifier + ", " +
				"oldTrade=" + this.oldTrade + ", " +
				"feeTradeIdentifier=" + this.feeTradeIdentifier + ", " +
				"feeTrade=" + this.feeTrade + ", " +
				"transferor=" + this.transferor + ", " +
				"transferorAccount=" + this.transferorAccount + ", " +
				"transferee=" + this.transferee + ", " +
				"otherTransferee=" + this.otherTransferee + ", " +
				"transfereeAccount=" + this.transfereeAccount + ", " +
				"otherTransfereeAccount=" + this.otherTransfereeAccount + ", " +
				"remainingParty=" + this.remainingParty + ", " +
				"remainingPartyAccount=" + this.remainingPartyAccount + ", " +
				"otherRemainingParty=" + this.otherRemainingParty + ", " +
				"otherRemainingPartyAccount=" + this.otherRemainingPartyAccount + ", " +
				"novationDate=" + this.novationDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"novationTradeDate=" + this.novationTradeDate + ", " +
				"novatedAmount=" + this.novatedAmount + ", " +
				"remainingAmount=" + this.remainingAmount + ", " +
				"novatedNumberOfOptions=" + this.novatedNumberOfOptions + ", " +
				"remainingNumberOfOptions=" + this.remainingNumberOfOptions + ", " +
				"novatedNumberOfUnits=" + this.novatedNumberOfUnits + ", " +
				"remainingNumberOfUnits=" + this.remainingNumberOfUnits + ", " +
				"novationAmount=" + this.novationAmount + ", " +
				"fullFirstCalculationPeriod=" + this.fullFirstCalculationPeriod + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"nonReliance=" + this.nonReliance + ", " +
				"creditDerivativesNotices=" + this.creditDerivativesNotices + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeNovationContent  ***********************/
	class TradeNovationContentBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements TradeNovationContent.TradeNovationContentBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> newTradeIdentifier = new ArrayList<>();
		protected Trade.TradeBuilder newTrade;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> oldTradeIdentifier = new ArrayList<>();
		protected Trade.TradeBuilder oldTrade;
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder feeTradeIdentifier;
		protected Trade.TradeBuilder feeTrade;
		protected PartyReference.PartyReferenceBuilder transferor;
		protected AccountReference.AccountReferenceBuilder transferorAccount;
		protected PartyReference.PartyReferenceBuilder transferee;
		protected PartyReference.PartyReferenceBuilder otherTransferee;
		protected AccountReference.AccountReferenceBuilder transfereeAccount;
		protected AccountReference.AccountReferenceBuilder otherTransfereeAccount;
		protected PartyReference.PartyReferenceBuilder remainingParty;
		protected AccountReference.AccountReferenceBuilder remainingPartyAccount;
		protected PartyReference.PartyReferenceBuilder otherRemainingParty;
		protected AccountReference.AccountReferenceBuilder otherRemainingPartyAccount;
		protected ZonedDateTime novationDate;
		protected ExecutionDateTime.ExecutionDateTimeBuilder executionDateTime;
		protected ZonedDateTime novationTradeDate;
		protected List<Money.MoneyBuilder> novatedAmount = new ArrayList<>();
		protected List<Money.MoneyBuilder> remainingAmount = new ArrayList<>();
		protected BigDecimal novatedNumberOfOptions;
		protected BigDecimal remainingNumberOfOptions;
		protected BigDecimal novatedNumberOfUnits;
		protected BigDecimal remainingNumberOfUnits;
		protected List<TradeLegSizeChange.TradeLegSizeChangeBuilder> novationAmount = new ArrayList<>();
		protected Boolean fullFirstCalculationPeriod;
		protected List<FirstPeriodStartDate.FirstPeriodStartDateBuilder> firstPeriodStartDate = new ArrayList<>();
		protected Empty.EmptyBuilder nonReliance;
		protected CreditDerivativesNotices.CreditDerivativesNoticesBuilder creditDerivativesNotices;
		protected List<ContractualDefinitions.ContractualDefinitionsBuilder> contractualDefinitions = new ArrayList<>();
		protected List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> contractualTermsSupplement = new ArrayList<>();
		protected Payment.PaymentBuilder payment;
		
		@Override
		@RosettaAttribute("newTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("newTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getNewTradeIdentifier() {
			return newTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateNewTradeIdentifier(int index) {
			if (newTradeIdentifier==null) {
				this.newTradeIdentifier = new ArrayList<>();
			}
			return getIndex(newTradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newNewTradeIdentifier = PartyTradeIdentifier.builder();
						return newNewTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("newTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("newTrade")
		public Trade.TradeBuilder getNewTrade() {
			return newTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateNewTrade() {
			Trade.TradeBuilder result;
			if (newTrade!=null) {
				result = newTrade;
			}
			else {
				result = newTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("oldTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getOldTradeIdentifier() {
			return oldTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateOldTradeIdentifier(int index) {
			if (oldTradeIdentifier==null) {
				this.oldTradeIdentifier = new ArrayList<>();
			}
			return getIndex(oldTradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newOldTradeIdentifier = PartyTradeIdentifier.builder();
						return newOldTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("oldTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oldTrade")
		public Trade.TradeBuilder getOldTrade() {
			return oldTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOldTrade() {
			Trade.TradeBuilder result;
			if (oldTrade!=null) {
				result = oldTrade;
			}
			else {
				result = oldTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeTradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getFeeTradeIdentifier() {
			return feeTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateFeeTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (feeTradeIdentifier!=null) {
				result = feeTradeIdentifier;
			}
			else {
				result = feeTradeIdentifier = PartyTradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feeTrade")
		public Trade.TradeBuilder getFeeTrade() {
			return feeTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateFeeTrade() {
			Trade.TradeBuilder result;
			if (feeTrade!=null) {
				result = feeTrade;
			}
			else {
				result = feeTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transferor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferor")
		public PartyReference.PartyReferenceBuilder getTransferor() {
			return transferor;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateTransferor() {
			PartyReference.PartyReferenceBuilder result;
			if (transferor!=null) {
				result = transferor;
			}
			else {
				result = transferor = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transferorAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferorAccount")
		public AccountReference.AccountReferenceBuilder getTransferorAccount() {
			return transferorAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateTransferorAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (transferorAccount!=null) {
				result = transferorAccount;
			}
			else {
				result = transferorAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transferee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferee")
		public PartyReference.PartyReferenceBuilder getTransferee() {
			return transferee;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateTransferee() {
			PartyReference.PartyReferenceBuilder result;
			if (transferee!=null) {
				result = transferee;
			}
			else {
				result = transferee = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherTransferee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherTransferee")
		public PartyReference.PartyReferenceBuilder getOtherTransferee() {
			return otherTransferee;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOtherTransferee() {
			PartyReference.PartyReferenceBuilder result;
			if (otherTransferee!=null) {
				result = otherTransferee;
			}
			else {
				result = otherTransferee = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transfereeAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transfereeAccount")
		public AccountReference.AccountReferenceBuilder getTransfereeAccount() {
			return transfereeAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateTransfereeAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (transfereeAccount!=null) {
				result = transfereeAccount;
			}
			else {
				result = transfereeAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherTransfereeAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherTransfereeAccount")
		public AccountReference.AccountReferenceBuilder getOtherTransfereeAccount() {
			return otherTransfereeAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateOtherTransfereeAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (otherTransfereeAccount!=null) {
				result = otherTransfereeAccount;
			}
			else {
				result = otherTransfereeAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("remainingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remainingParty")
		public PartyReference.PartyReferenceBuilder getRemainingParty() {
			return remainingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateRemainingParty() {
			PartyReference.PartyReferenceBuilder result;
			if (remainingParty!=null) {
				result = remainingParty;
			}
			else {
				result = remainingParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("remainingPartyAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remainingPartyAccount")
		public AccountReference.AccountReferenceBuilder getRemainingPartyAccount() {
			return remainingPartyAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateRemainingPartyAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (remainingPartyAccount!=null) {
				result = remainingPartyAccount;
			}
			else {
				result = remainingPartyAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherRemainingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherRemainingParty")
		public PartyReference.PartyReferenceBuilder getOtherRemainingParty() {
			return otherRemainingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOtherRemainingParty() {
			PartyReference.PartyReferenceBuilder result;
			if (otherRemainingParty!=null) {
				result = otherRemainingParty;
			}
			else {
				result = otherRemainingParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherRemainingPartyAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherRemainingPartyAccount")
		public AccountReference.AccountReferenceBuilder getOtherRemainingPartyAccount() {
			return otherRemainingPartyAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateOtherRemainingPartyAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (otherRemainingPartyAccount!=null) {
				result = otherRemainingPartyAccount;
			}
			else {
				result = otherRemainingPartyAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novationDate")
		public ZonedDateTime getNovationDate() {
			return novationDate;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionDateTime")
		public ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		public ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime() {
			ExecutionDateTime.ExecutionDateTimeBuilder result;
			if (executionDateTime!=null) {
				result = executionDateTime;
			}
			else {
				result = executionDateTime = ExecutionDateTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationTradeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novationTradeDate")
		public ZonedDateTime getNovationTradeDate() {
			return novationTradeDate;
		}
		
		@Override
		@RosettaAttribute("novatedAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("novatedAmount")
		public List<? extends Money.MoneyBuilder> getNovatedAmount() {
			return novatedAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNovatedAmount(int index) {
			if (novatedAmount==null) {
				this.novatedAmount = new ArrayList<>();
			}
			return getIndex(novatedAmount, index, () -> {
						Money.MoneyBuilder newNovatedAmount = Money.builder();
						return newNovatedAmount;
					});
		}
		
		@Override
		@RosettaAttribute("remainingAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("remainingAmount")
		public List<? extends Money.MoneyBuilder> getRemainingAmount() {
			return remainingAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateRemainingAmount(int index) {
			if (remainingAmount==null) {
				this.remainingAmount = new ArrayList<>();
			}
			return getIndex(remainingAmount, index, () -> {
						Money.MoneyBuilder newRemainingAmount = Money.builder();
						return newRemainingAmount;
					});
		}
		
		@Override
		@RosettaAttribute("novatedNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novatedNumberOfOptions")
		public BigDecimal getNovatedNumberOfOptions() {
			return novatedNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("remainingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remainingNumberOfOptions")
		public BigDecimal getRemainingNumberOfOptions() {
			return remainingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("novatedNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novatedNumberOfUnits")
		public BigDecimal getNovatedNumberOfUnits() {
			return novatedNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("remainingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("remainingNumberOfUnits")
		public BigDecimal getRemainingNumberOfUnits() {
			return remainingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("novationAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("novationAmount")
		public List<? extends TradeLegSizeChange.TradeLegSizeChangeBuilder> getNovationAmount() {
			return novationAmount;
		}
		
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder getOrCreateNovationAmount(int index) {
			if (novationAmount==null) {
				this.novationAmount = new ArrayList<>();
			}
			return getIndex(novationAmount, index, () -> {
						TradeLegSizeChange.TradeLegSizeChangeBuilder newNovationAmount = TradeLegSizeChange.builder();
						return newNovationAmount;
					});
		}
		
		@Override
		@RosettaAttribute("fullFirstCalculationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullFirstCalculationPeriod")
		public Boolean getFullFirstCalculationPeriod() {
			return fullFirstCalculationPeriod;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("firstPeriodStartDate")
		public List<? extends FirstPeriodStartDate.FirstPeriodStartDateBuilder> getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		public FirstPeriodStartDate.FirstPeriodStartDateBuilder getOrCreateFirstPeriodStartDate(int index) {
			if (firstPeriodStartDate==null) {
				this.firstPeriodStartDate = new ArrayList<>();
			}
			return getIndex(firstPeriodStartDate, index, () -> {
						FirstPeriodStartDate.FirstPeriodStartDateBuilder newFirstPeriodStartDate = FirstPeriodStartDate.builder();
						return newFirstPeriodStartDate;
					});
		}
		
		@Override
		@RosettaAttribute("nonReliance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReliance")
		public Empty.EmptyBuilder getNonReliance() {
			return nonReliance;
		}
		
		@Override
		public Empty.EmptyBuilder getOrCreateNonReliance() {
			Empty.EmptyBuilder result;
			if (nonReliance!=null) {
				result = nonReliance;
			}
			else {
				result = nonReliance = Empty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditDerivativesNotices")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditDerivativesNotices")
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder getCreditDerivativesNotices() {
			return creditDerivativesNotices;
		}
		
		@Override
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder getOrCreateCreditDerivativesNotices() {
			CreditDerivativesNotices.CreditDerivativesNoticesBuilder result;
			if (creditDerivativesNotices!=null) {
				result = creditDerivativesNotices;
			}
			else {
				result = creditDerivativesNotices = CreditDerivativesNotices.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualDefinitions")
		public List<? extends ContractualDefinitions.ContractualDefinitionsBuilder> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		@Override
		public ContractualDefinitions.ContractualDefinitionsBuilder getOrCreateContractualDefinitions(int index) {
			if (contractualDefinitions==null) {
				this.contractualDefinitions = new ArrayList<>();
			}
			return getIndex(contractualDefinitions, index, () -> {
						ContractualDefinitions.ContractualDefinitionsBuilder newContractualDefinitions = ContractualDefinitions.builder();
						return newContractualDefinitions;
					});
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int index) {
			if (contractualTermsSupplement==null) {
				this.contractualTermsSupplement = new ArrayList<>();
			}
			return getIndex(contractualTermsSupplement, index, () -> {
						ContractualTermsSupplement.ContractualTermsSupplementBuilder newContractualTermsSupplement = ContractualTermsSupplement.builder();
						return newContractualTermsSupplement;
					});
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public Payment.PaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePayment() {
			Payment.PaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = Payment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("newTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("newTradeIdentifier")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addNewTradeIdentifier(PartyTradeIdentifier _newTradeIdentifier) {
			if (_newTradeIdentifier != null) {
				this.newTradeIdentifier.add(_newTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addNewTradeIdentifier(PartyTradeIdentifier _newTradeIdentifier, int idx) {
			getIndex(this.newTradeIdentifier, idx, () -> _newTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addNewTradeIdentifier(List<? extends PartyTradeIdentifier> newTradeIdentifiers) {
			if (newTradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : newTradeIdentifiers) {
					this.newTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("newTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("newTradeIdentifier")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setNewTradeIdentifier(List<? extends PartyTradeIdentifier> newTradeIdentifiers) {
			if (newTradeIdentifiers == null) {
				this.newTradeIdentifier = new ArrayList<>();
			} else {
				this.newTradeIdentifier = newTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("newTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newTrade")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setNewTrade(Trade _newTrade) {
			this.newTrade = _newTrade == null ? null : _newTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("oldTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("oldTradeIdentifier")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addOldTradeIdentifier(PartyTradeIdentifier _oldTradeIdentifier) {
			if (_oldTradeIdentifier != null) {
				this.oldTradeIdentifier.add(_oldTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addOldTradeIdentifier(PartyTradeIdentifier _oldTradeIdentifier, int idx) {
			getIndex(this.oldTradeIdentifier, idx, () -> _oldTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addOldTradeIdentifier(List<? extends PartyTradeIdentifier> oldTradeIdentifiers) {
			if (oldTradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : oldTradeIdentifiers) {
					this.oldTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("oldTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("oldTradeIdentifier")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setOldTradeIdentifier(List<? extends PartyTradeIdentifier> oldTradeIdentifiers) {
			if (oldTradeIdentifiers == null) {
				this.oldTradeIdentifier = new ArrayList<>();
			} else {
				this.oldTradeIdentifier = oldTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("oldTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("oldTrade")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setOldTrade(Trade _oldTrade) {
			this.oldTrade = _oldTrade == null ? null : _oldTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feeTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feeTradeIdentifier")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setFeeTradeIdentifier(PartyTradeIdentifier _feeTradeIdentifier) {
			this.feeTradeIdentifier = _feeTradeIdentifier == null ? null : _feeTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feeTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feeTrade")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setFeeTrade(Trade _feeTrade) {
			this.feeTrade = _feeTrade == null ? null : _feeTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transferor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferor")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setTransferor(PartyReference _transferor) {
			this.transferor = _transferor == null ? null : _transferor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transferorAccount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferorAccount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setTransferorAccount(AccountReference _transferorAccount) {
			this.transferorAccount = _transferorAccount == null ? null : _transferorAccount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transferee")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferee")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setTransferee(PartyReference _transferee) {
			this.transferee = _transferee == null ? null : _transferee.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherTransferee")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherTransferee")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setOtherTransferee(PartyReference _otherTransferee) {
			this.otherTransferee = _otherTransferee == null ? null : _otherTransferee.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transfereeAccount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transfereeAccount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setTransfereeAccount(AccountReference _transfereeAccount) {
			this.transfereeAccount = _transfereeAccount == null ? null : _transfereeAccount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherTransfereeAccount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherTransfereeAccount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setOtherTransfereeAccount(AccountReference _otherTransfereeAccount) {
			this.otherTransfereeAccount = _otherTransfereeAccount == null ? null : _otherTransfereeAccount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("remainingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remainingParty")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setRemainingParty(PartyReference _remainingParty) {
			this.remainingParty = _remainingParty == null ? null : _remainingParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("remainingPartyAccount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remainingPartyAccount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setRemainingPartyAccount(AccountReference _remainingPartyAccount) {
			this.remainingPartyAccount = _remainingPartyAccount == null ? null : _remainingPartyAccount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherRemainingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherRemainingParty")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setOtherRemainingParty(PartyReference _otherRemainingParty) {
			this.otherRemainingParty = _otherRemainingParty == null ? null : _otherRemainingParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherRemainingPartyAccount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherRemainingPartyAccount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setOtherRemainingPartyAccount(AccountReference _otherRemainingPartyAccount) {
			this.otherRemainingPartyAccount = _otherRemainingPartyAccount == null ? null : _otherRemainingPartyAccount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("novationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("novationDate")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setNovationDate(ZonedDateTime _novationDate) {
			this.novationDate = _novationDate == null ? null : _novationDate;
			return this;
		}
		
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionDateTime")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setExecutionDateTime(ExecutionDateTime _executionDateTime) {
			this.executionDateTime = _executionDateTime == null ? null : _executionDateTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("novationTradeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("novationTradeDate")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setNovationTradeDate(ZonedDateTime _novationTradeDate) {
			this.novationTradeDate = _novationTradeDate == null ? null : _novationTradeDate;
			return this;
		}
		
		@RosettaAttribute("novatedAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("novatedAmount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addNovatedAmount(Money _novatedAmount) {
			if (_novatedAmount != null) {
				this.novatedAmount.add(_novatedAmount.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addNovatedAmount(Money _novatedAmount, int idx) {
			getIndex(this.novatedAmount, idx, () -> _novatedAmount.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addNovatedAmount(List<? extends Money> novatedAmounts) {
			if (novatedAmounts != null) {
				for (final Money toAdd : novatedAmounts) {
					this.novatedAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("novatedAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("novatedAmount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setNovatedAmount(List<? extends Money> novatedAmounts) {
			if (novatedAmounts == null) {
				this.novatedAmount = new ArrayList<>();
			} else {
				this.novatedAmount = novatedAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("remainingAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("remainingAmount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addRemainingAmount(Money _remainingAmount) {
			if (_remainingAmount != null) {
				this.remainingAmount.add(_remainingAmount.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addRemainingAmount(Money _remainingAmount, int idx) {
			getIndex(this.remainingAmount, idx, () -> _remainingAmount.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addRemainingAmount(List<? extends Money> remainingAmounts) {
			if (remainingAmounts != null) {
				for (final Money toAdd : remainingAmounts) {
					this.remainingAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("remainingAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("remainingAmount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setRemainingAmount(List<? extends Money> remainingAmounts) {
			if (remainingAmounts == null) {
				this.remainingAmount = new ArrayList<>();
			} else {
				this.remainingAmount = remainingAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("novatedNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("novatedNumberOfOptions")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setNovatedNumberOfOptions(BigDecimal _novatedNumberOfOptions) {
			this.novatedNumberOfOptions = _novatedNumberOfOptions == null ? null : _novatedNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("remainingNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remainingNumberOfOptions")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setRemainingNumberOfOptions(BigDecimal _remainingNumberOfOptions) {
			this.remainingNumberOfOptions = _remainingNumberOfOptions == null ? null : _remainingNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("novatedNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("novatedNumberOfUnits")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setNovatedNumberOfUnits(BigDecimal _novatedNumberOfUnits) {
			this.novatedNumberOfUnits = _novatedNumberOfUnits == null ? null : _novatedNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("remainingNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("remainingNumberOfUnits")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setRemainingNumberOfUnits(BigDecimal _remainingNumberOfUnits) {
			this.remainingNumberOfUnits = _remainingNumberOfUnits == null ? null : _remainingNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("novationAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("novationAmount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addNovationAmount(TradeLegSizeChange _novationAmount) {
			if (_novationAmount != null) {
				this.novationAmount.add(_novationAmount.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addNovationAmount(TradeLegSizeChange _novationAmount, int idx) {
			getIndex(this.novationAmount, idx, () -> _novationAmount.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addNovationAmount(List<? extends TradeLegSizeChange> novationAmounts) {
			if (novationAmounts != null) {
				for (final TradeLegSizeChange toAdd : novationAmounts) {
					this.novationAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("novationAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("novationAmount")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setNovationAmount(List<? extends TradeLegSizeChange> novationAmounts) {
			if (novationAmounts == null) {
				this.novationAmount = new ArrayList<>();
			} else {
				this.novationAmount = novationAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fullFirstCalculationPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fullFirstCalculationPeriod")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setFullFirstCalculationPeriod(Boolean _fullFirstCalculationPeriod) {
			this.fullFirstCalculationPeriod = _fullFirstCalculationPeriod == null ? null : _fullFirstCalculationPeriod;
			return this;
		}
		
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("firstPeriodStartDate")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addFirstPeriodStartDate(FirstPeriodStartDate _firstPeriodStartDate) {
			if (_firstPeriodStartDate != null) {
				this.firstPeriodStartDate.add(_firstPeriodStartDate.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addFirstPeriodStartDate(FirstPeriodStartDate _firstPeriodStartDate, int idx) {
			getIndex(this.firstPeriodStartDate, idx, () -> _firstPeriodStartDate.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addFirstPeriodStartDate(List<? extends FirstPeriodStartDate> firstPeriodStartDates) {
			if (firstPeriodStartDates != null) {
				for (final FirstPeriodStartDate toAdd : firstPeriodStartDates) {
					this.firstPeriodStartDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("firstPeriodStartDate")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setFirstPeriodStartDate(List<? extends FirstPeriodStartDate> firstPeriodStartDates) {
			if (firstPeriodStartDates == null) {
				this.firstPeriodStartDate = new ArrayList<>();
			} else {
				this.firstPeriodStartDate = firstPeriodStartDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("nonReliance")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReliance")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setNonReliance(Empty _nonReliance) {
			this.nonReliance = _nonReliance == null ? null : _nonReliance.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditDerivativesNotices")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditDerivativesNotices")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setCreditDerivativesNotices(CreditDerivativesNotices _creditDerivativesNotices) {
			this.creditDerivativesNotices = _creditDerivativesNotices == null ? null : _creditDerivativesNotices.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractualDefinitions")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractualDefinitions")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addContractualDefinitions(ContractualDefinitions _contractualDefinitions) {
			if (_contractualDefinitions != null) {
				this.contractualDefinitions.add(_contractualDefinitions.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addContractualDefinitions(ContractualDefinitions _contractualDefinitions, int idx) {
			getIndex(this.contractualDefinitions, idx, () -> _contractualDefinitions.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitionss) {
			if (contractualDefinitionss != null) {
				for (final ContractualDefinitions toAdd : contractualDefinitionss) {
					this.contractualDefinitions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("contractualDefinitions")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("contractualDefinitions")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitionss) {
			if (contractualDefinitionss == null) {
				this.contractualDefinitions = new ArrayList<>();
			} else {
				this.contractualDefinitions = contractualDefinitionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("contractualTermsSupplement")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractualTermsSupplement")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addContractualTermsSupplement(ContractualTermsSupplement _contractualTermsSupplement) {
			if (_contractualTermsSupplement != null) {
				this.contractualTermsSupplement.add(_contractualTermsSupplement.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addContractualTermsSupplement(ContractualTermsSupplement _contractualTermsSupplement, int idx) {
			getIndex(this.contractualTermsSupplement, idx, () -> _contractualTermsSupplement.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements != null) {
				for (final ContractualTermsSupplement toAdd : contractualTermsSupplements) {
					this.contractualTermsSupplement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("contractualTermsSupplement")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("contractualTermsSupplement")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements == null) {
				this.contractualTermsSupplement = new ArrayList<>();
			} else {
				this.contractualTermsSupplement = contractualTermsSupplements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payment")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder setPayment(Payment _payment) {
			this.payment = _payment == null ? null : _payment.toBuilder();
			return this;
		}
		
		@Override
		public TradeNovationContent build() {
			return new TradeNovationContent.TradeNovationContentImpl(this);
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder prune() {
			super.prune();
			newTradeIdentifier = newTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (newTrade!=null && !newTrade.prune().hasData()) newTrade = null;
			oldTradeIdentifier = oldTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (oldTrade!=null && !oldTrade.prune().hasData()) oldTrade = null;
			if (feeTradeIdentifier!=null && !feeTradeIdentifier.prune().hasData()) feeTradeIdentifier = null;
			if (feeTrade!=null && !feeTrade.prune().hasData()) feeTrade = null;
			if (transferor!=null && !transferor.prune().hasData()) transferor = null;
			if (transferorAccount!=null && !transferorAccount.prune().hasData()) transferorAccount = null;
			if (transferee!=null && !transferee.prune().hasData()) transferee = null;
			if (otherTransferee!=null && !otherTransferee.prune().hasData()) otherTransferee = null;
			if (transfereeAccount!=null && !transfereeAccount.prune().hasData()) transfereeAccount = null;
			if (otherTransfereeAccount!=null && !otherTransfereeAccount.prune().hasData()) otherTransfereeAccount = null;
			if (remainingParty!=null && !remainingParty.prune().hasData()) remainingParty = null;
			if (remainingPartyAccount!=null && !remainingPartyAccount.prune().hasData()) remainingPartyAccount = null;
			if (otherRemainingParty!=null && !otherRemainingParty.prune().hasData()) otherRemainingParty = null;
			if (otherRemainingPartyAccount!=null && !otherRemainingPartyAccount.prune().hasData()) otherRemainingPartyAccount = null;
			if (executionDateTime!=null && !executionDateTime.prune().hasData()) executionDateTime = null;
			novatedAmount = novatedAmount.stream().filter(b->b!=null).<Money.MoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			remainingAmount = remainingAmount.stream().filter(b->b!=null).<Money.MoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			novationAmount = novationAmount.stream().filter(b->b!=null).<TradeLegSizeChange.TradeLegSizeChangeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			firstPeriodStartDate = firstPeriodStartDate.stream().filter(b->b!=null).<FirstPeriodStartDate.FirstPeriodStartDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (nonReliance!=null && !nonReliance.prune().hasData()) nonReliance = null;
			if (creditDerivativesNotices!=null && !creditDerivativesNotices.prune().hasData()) creditDerivativesNotices = null;
			contractualDefinitions = contractualDefinitions.stream().filter(b->b!=null).<ContractualDefinitions.ContractualDefinitionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualTermsSupplement = contractualTermsSupplement.stream().filter(b->b!=null).<ContractualTermsSupplement.ContractualTermsSupplementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (payment!=null && !payment.prune().hasData()) payment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNewTradeIdentifier()!=null && getNewTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNewTrade()!=null && getNewTrade().hasData()) return true;
			if (getOldTradeIdentifier()!=null && getOldTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOldTrade()!=null && getOldTrade().hasData()) return true;
			if (getFeeTradeIdentifier()!=null && getFeeTradeIdentifier().hasData()) return true;
			if (getFeeTrade()!=null && getFeeTrade().hasData()) return true;
			if (getTransferor()!=null && getTransferor().hasData()) return true;
			if (getTransferorAccount()!=null && getTransferorAccount().hasData()) return true;
			if (getTransferee()!=null && getTransferee().hasData()) return true;
			if (getOtherTransferee()!=null && getOtherTransferee().hasData()) return true;
			if (getTransfereeAccount()!=null && getTransfereeAccount().hasData()) return true;
			if (getOtherTransfereeAccount()!=null && getOtherTransfereeAccount().hasData()) return true;
			if (getRemainingParty()!=null && getRemainingParty().hasData()) return true;
			if (getRemainingPartyAccount()!=null && getRemainingPartyAccount().hasData()) return true;
			if (getOtherRemainingParty()!=null && getOtherRemainingParty().hasData()) return true;
			if (getOtherRemainingPartyAccount()!=null && getOtherRemainingPartyAccount().hasData()) return true;
			if (getNovationDate()!=null) return true;
			if (getExecutionDateTime()!=null && getExecutionDateTime().hasData()) return true;
			if (getNovationTradeDate()!=null) return true;
			if (getNovatedAmount()!=null && getNovatedAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRemainingAmount()!=null && getRemainingAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNovatedNumberOfOptions()!=null) return true;
			if (getRemainingNumberOfOptions()!=null) return true;
			if (getNovatedNumberOfUnits()!=null) return true;
			if (getRemainingNumberOfUnits()!=null) return true;
			if (getNovationAmount()!=null && getNovationAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFullFirstCalculationPeriod()!=null) return true;
			if (getFirstPeriodStartDate()!=null && getFirstPeriodStartDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNonReliance()!=null && getNonReliance().hasData()) return true;
			if (getCreditDerivativesNotices()!=null && getCreditDerivativesNotices().hasData()) return true;
			if (getContractualDefinitions()!=null && getContractualDefinitions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContractualTermsSupplement()!=null && getContractualTermsSupplement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TradeNovationContent.TradeNovationContentBuilder o = (TradeNovationContent.TradeNovationContentBuilder) other;
			
			merger.mergeRosetta(getNewTradeIdentifier(), o.getNewTradeIdentifier(), this::getOrCreateNewTradeIdentifier);
			merger.mergeRosetta(getNewTrade(), o.getNewTrade(), this::setNewTrade);
			merger.mergeRosetta(getOldTradeIdentifier(), o.getOldTradeIdentifier(), this::getOrCreateOldTradeIdentifier);
			merger.mergeRosetta(getOldTrade(), o.getOldTrade(), this::setOldTrade);
			merger.mergeRosetta(getFeeTradeIdentifier(), o.getFeeTradeIdentifier(), this::setFeeTradeIdentifier);
			merger.mergeRosetta(getFeeTrade(), o.getFeeTrade(), this::setFeeTrade);
			merger.mergeRosetta(getTransferor(), o.getTransferor(), this::setTransferor);
			merger.mergeRosetta(getTransferorAccount(), o.getTransferorAccount(), this::setTransferorAccount);
			merger.mergeRosetta(getTransferee(), o.getTransferee(), this::setTransferee);
			merger.mergeRosetta(getOtherTransferee(), o.getOtherTransferee(), this::setOtherTransferee);
			merger.mergeRosetta(getTransfereeAccount(), o.getTransfereeAccount(), this::setTransfereeAccount);
			merger.mergeRosetta(getOtherTransfereeAccount(), o.getOtherTransfereeAccount(), this::setOtherTransfereeAccount);
			merger.mergeRosetta(getRemainingParty(), o.getRemainingParty(), this::setRemainingParty);
			merger.mergeRosetta(getRemainingPartyAccount(), o.getRemainingPartyAccount(), this::setRemainingPartyAccount);
			merger.mergeRosetta(getOtherRemainingParty(), o.getOtherRemainingParty(), this::setOtherRemainingParty);
			merger.mergeRosetta(getOtherRemainingPartyAccount(), o.getOtherRemainingPartyAccount(), this::setOtherRemainingPartyAccount);
			merger.mergeRosetta(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			merger.mergeRosetta(getNovatedAmount(), o.getNovatedAmount(), this::getOrCreateNovatedAmount);
			merger.mergeRosetta(getRemainingAmount(), o.getRemainingAmount(), this::getOrCreateRemainingAmount);
			merger.mergeRosetta(getNovationAmount(), o.getNovationAmount(), this::getOrCreateNovationAmount);
			merger.mergeRosetta(getFirstPeriodStartDate(), o.getFirstPeriodStartDate(), this::getOrCreateFirstPeriodStartDate);
			merger.mergeRosetta(getNonReliance(), o.getNonReliance(), this::setNonReliance);
			merger.mergeRosetta(getCreditDerivativesNotices(), o.getCreditDerivativesNotices(), this::setCreditDerivativesNotices);
			merger.mergeRosetta(getContractualDefinitions(), o.getContractualDefinitions(), this::getOrCreateContractualDefinitions);
			merger.mergeRosetta(getContractualTermsSupplement(), o.getContractualTermsSupplement(), this::getOrCreateContractualTermsSupplement);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			
			merger.mergeBasic(getNovationDate(), o.getNovationDate(), this::setNovationDate);
			merger.mergeBasic(getNovationTradeDate(), o.getNovationTradeDate(), this::setNovationTradeDate);
			merger.mergeBasic(getNovatedNumberOfOptions(), o.getNovatedNumberOfOptions(), this::setNovatedNumberOfOptions);
			merger.mergeBasic(getRemainingNumberOfOptions(), o.getRemainingNumberOfOptions(), this::setRemainingNumberOfOptions);
			merger.mergeBasic(getNovatedNumberOfUnits(), o.getNovatedNumberOfUnits(), this::setNovatedNumberOfUnits);
			merger.mergeBasic(getRemainingNumberOfUnits(), o.getRemainingNumberOfUnits(), this::setRemainingNumberOfUnits);
			merger.mergeBasic(getFullFirstCalculationPeriod(), o.getFullFirstCalculationPeriod(), this::setFullFirstCalculationPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeNovationContent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(newTradeIdentifier, _that.getNewTradeIdentifier())) return false;
			if (!Objects.equals(newTrade, _that.getNewTrade())) return false;
			if (!ListEquals.listEquals(oldTradeIdentifier, _that.getOldTradeIdentifier())) return false;
			if (!Objects.equals(oldTrade, _that.getOldTrade())) return false;
			if (!Objects.equals(feeTradeIdentifier, _that.getFeeTradeIdentifier())) return false;
			if (!Objects.equals(feeTrade, _that.getFeeTrade())) return false;
			if (!Objects.equals(transferor, _that.getTransferor())) return false;
			if (!Objects.equals(transferorAccount, _that.getTransferorAccount())) return false;
			if (!Objects.equals(transferee, _that.getTransferee())) return false;
			if (!Objects.equals(otherTransferee, _that.getOtherTransferee())) return false;
			if (!Objects.equals(transfereeAccount, _that.getTransfereeAccount())) return false;
			if (!Objects.equals(otherTransfereeAccount, _that.getOtherTransfereeAccount())) return false;
			if (!Objects.equals(remainingParty, _that.getRemainingParty())) return false;
			if (!Objects.equals(remainingPartyAccount, _that.getRemainingPartyAccount())) return false;
			if (!Objects.equals(otherRemainingParty, _that.getOtherRemainingParty())) return false;
			if (!Objects.equals(otherRemainingPartyAccount, _that.getOtherRemainingPartyAccount())) return false;
			if (!Objects.equals(novationDate, _that.getNovationDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(novationTradeDate, _that.getNovationTradeDate())) return false;
			if (!ListEquals.listEquals(novatedAmount, _that.getNovatedAmount())) return false;
			if (!ListEquals.listEquals(remainingAmount, _that.getRemainingAmount())) return false;
			if (!Objects.equals(novatedNumberOfOptions, _that.getNovatedNumberOfOptions())) return false;
			if (!Objects.equals(remainingNumberOfOptions, _that.getRemainingNumberOfOptions())) return false;
			if (!Objects.equals(novatedNumberOfUnits, _that.getNovatedNumberOfUnits())) return false;
			if (!Objects.equals(remainingNumberOfUnits, _that.getRemainingNumberOfUnits())) return false;
			if (!ListEquals.listEquals(novationAmount, _that.getNovationAmount())) return false;
			if (!Objects.equals(fullFirstCalculationPeriod, _that.getFullFirstCalculationPeriod())) return false;
			if (!ListEquals.listEquals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			if (!Objects.equals(creditDerivativesNotices, _that.getCreditDerivativesNotices())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (newTradeIdentifier != null ? newTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (newTrade != null ? newTrade.hashCode() : 0);
			_result = 31 * _result + (oldTradeIdentifier != null ? oldTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (oldTrade != null ? oldTrade.hashCode() : 0);
			_result = 31 * _result + (feeTradeIdentifier != null ? feeTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (feeTrade != null ? feeTrade.hashCode() : 0);
			_result = 31 * _result + (transferor != null ? transferor.hashCode() : 0);
			_result = 31 * _result + (transferorAccount != null ? transferorAccount.hashCode() : 0);
			_result = 31 * _result + (transferee != null ? transferee.hashCode() : 0);
			_result = 31 * _result + (otherTransferee != null ? otherTransferee.hashCode() : 0);
			_result = 31 * _result + (transfereeAccount != null ? transfereeAccount.hashCode() : 0);
			_result = 31 * _result + (otherTransfereeAccount != null ? otherTransfereeAccount.hashCode() : 0);
			_result = 31 * _result + (remainingParty != null ? remainingParty.hashCode() : 0);
			_result = 31 * _result + (remainingPartyAccount != null ? remainingPartyAccount.hashCode() : 0);
			_result = 31 * _result + (otherRemainingParty != null ? otherRemainingParty.hashCode() : 0);
			_result = 31 * _result + (otherRemainingPartyAccount != null ? otherRemainingPartyAccount.hashCode() : 0);
			_result = 31 * _result + (novationDate != null ? novationDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (novationTradeDate != null ? novationTradeDate.hashCode() : 0);
			_result = 31 * _result + (novatedAmount != null ? novatedAmount.hashCode() : 0);
			_result = 31 * _result + (remainingAmount != null ? remainingAmount.hashCode() : 0);
			_result = 31 * _result + (novatedNumberOfOptions != null ? novatedNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (remainingNumberOfOptions != null ? remainingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (novatedNumberOfUnits != null ? novatedNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (remainingNumberOfUnits != null ? remainingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (novationAmount != null ? novationAmount.hashCode() : 0);
			_result = 31 * _result + (fullFirstCalculationPeriod != null ? fullFirstCalculationPeriod.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			_result = 31 * _result + (creditDerivativesNotices != null ? creditDerivativesNotices.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNovationContentBuilder {" +
				"newTradeIdentifier=" + this.newTradeIdentifier + ", " +
				"newTrade=" + this.newTrade + ", " +
				"oldTradeIdentifier=" + this.oldTradeIdentifier + ", " +
				"oldTrade=" + this.oldTrade + ", " +
				"feeTradeIdentifier=" + this.feeTradeIdentifier + ", " +
				"feeTrade=" + this.feeTrade + ", " +
				"transferor=" + this.transferor + ", " +
				"transferorAccount=" + this.transferorAccount + ", " +
				"transferee=" + this.transferee + ", " +
				"otherTransferee=" + this.otherTransferee + ", " +
				"transfereeAccount=" + this.transfereeAccount + ", " +
				"otherTransfereeAccount=" + this.otherTransfereeAccount + ", " +
				"remainingParty=" + this.remainingParty + ", " +
				"remainingPartyAccount=" + this.remainingPartyAccount + ", " +
				"otherRemainingParty=" + this.otherRemainingParty + ", " +
				"otherRemainingPartyAccount=" + this.otherRemainingPartyAccount + ", " +
				"novationDate=" + this.novationDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"novationTradeDate=" + this.novationTradeDate + ", " +
				"novatedAmount=" + this.novatedAmount + ", " +
				"remainingAmount=" + this.remainingAmount + ", " +
				"novatedNumberOfOptions=" + this.novatedNumberOfOptions + ", " +
				"remainingNumberOfOptions=" + this.remainingNumberOfOptions + ", " +
				"novatedNumberOfUnits=" + this.novatedNumberOfUnits + ", " +
				"remainingNumberOfUnits=" + this.remainingNumberOfUnits + ", " +
				"novationAmount=" + this.novationAmount + ", " +
				"fullFirstCalculationPeriod=" + this.fullFirstCalculationPeriod + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"nonReliance=" + this.nonReliance + ", " +
				"creditDerivativesNotices=" + this.creditDerivativesNotices + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}
