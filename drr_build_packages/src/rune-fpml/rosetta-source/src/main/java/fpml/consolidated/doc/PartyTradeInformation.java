package fpml.consolidated.doc;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
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
import fpml.consolidated.doc.meta.PartyTradeInformationMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedBusinessUnit;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.shared.RelatedPerson;
import fpml.consolidated.shared.Unit;
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
 * Provision A type defining party-specific additional information that may be recorded against a trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining party-specific additional information that may be recorded against a trade.
 *
 */
@RosettaDataType(value="PartyTradeInformation", builder=PartyTradeInformation.PartyTradeInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyTradeInformation", model="fpml", builder=PartyTradeInformation.PartyTradeInformationBuilderImpl.class, version="2.1.1")
public interface PartyTradeInformation extends RosettaModelObject {

	PartyTradeInformationMeta metaData = new PartyTradeInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 */
	AccountReference getAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the role of this party in reporting this trade (e.g. originator, counterparty).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the role of this party in reporting this trade (e.g. originator, counterparty).
	 *
	 */
	ReportingRole getReportingRole();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides information about a unit/division/desk etc. that executed or supports this trade
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides information about a unit/division/desk etc. that executed or supports this trade
	 *
	 */
	List<? extends RelatedBusinessUnit> getRelatedBusinessUnit();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides information about a person that executed or supports this trade
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides information about a person that executed or supports this trade
	 *
	 */
	List<? extends RelatedPerson> getRelatedPerson();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides information about an algorithm that executed or otherwise participated in this trade this trade
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides information about an algorithm that executed or otherwise participated in this trade this trade
	 *
	 */
	List<? extends Algorithm> getAlgorithm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the trade used to hedge a risk for accounting purposes for the specified party. (TODO: do we need to distinguish between asset and liability hedges?)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the trade used to hedge a risk for accounting purposes for the specified party. (TODO: do we need to distinguish between asset and liability hedges?)
	 *
	 */
	Boolean getIsAccountingHedge();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to categorize trades into user-defined categories, such as house trades vs. customer trades.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to categorize trades into user-defined categories, such as house trades vs. customer trades.
	 *
	 */
	List<? extends TradeCategory> getCategory();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Trade execution date time, for example as provided by a central execution facility. Normally this refers to the original execution time of the trade, not the execution time of any post-trade events that may have affeted it. However, in the case of a post trade event that reports the new version of the trade (for example, the novation trade in an novation event, or the amended trade in an amendment event), the execution date time may contain the time that the newly created or modified trade was created or modified.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Trade execution date time, for example as provided by a central execution facility. Normally this refers to the original execution time of the trade, not the execution time of any post-trade events that may have affeted it. However, in the case of a post trade event that reports the new version of the trade (for example, the novation trade in an novation event, or the amended trade in an amendment event), the execution date time may contain the time that the newly created or modified trade was created or modified.
	 *
	 */
	ExecutionDateTime getExecutionDateTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows timing information about a trade to be recorded.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows timing information about a trade to be recorded.
	 *
	 */
	TradeProcessingTimestamps getTimestamps();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be allocated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be allocated.
	 *
	 */
	Boolean getIntentToAllocate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be allocated, has been allocated, or will not be allocated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be allocated, has been allocated, or will not be allocated.
	 *
	 */
	AllocationReportingStatus getAllocationStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be cleared via a derivative clearing organization
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be cleared via a derivative clearing organization
	 *
	 */
	Boolean getIntentToClear();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the status with respect to clearing (e.g. AwaitingAcceptance, Pending, Accepted, Rejected, etc.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the status with respect to clearing (e.g. AwaitingAcceptance, Pending, Accepted, Rejected, etc.)
	 *
	 */
	ClearingStatusValue getClearingStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether this party posts collateral. For Recordkeeping, the collateralization type refers to collateral that is posted by this firm, and One-Way is not meaningful. In other words, if the collateralization type is Full, this trade is fully collateralized by this party. For Transparency view, the options include Full, Partial, Uncollateralized, and One-Way.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether this party posts collateral. For Recordkeeping, the collateralization type refers to collateral that is posted by this firm, and One-Way is not meaningful. In other words, if the collateralization type is Full, this trade is fully collateralized by this party. For Transparency view, the options include Full, Partial, Uncollateralized, and One-Way.
	 *
	 */
	CollateralizationType getCollateralizationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides a name, code, or other identifier for the collateral portfolio to which this belongs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides a name, code, or other identifier for the collateral portfolio to which this belongs.
	 *
	 */
	PortfolioName getCollateralPortfolio();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides a name, code, or other identifier for the initial margin collateral portfolio to which this belongs. Added to support CFTC Amendments to Part 43/45 (Published November 2020).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides a name, code, or other identifier for the initial margin collateral portfolio to which this belongs. Added to support CFTC Amendments to Part 43/45 (Published November 2020).
	 *
	 */
	PortfolioName getCollateralPortfolioInitialMargin();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides a name, code, or other identifier for the variation margin collateral portfolio to which this belongs. Added to support CFTC Amendments to Part 43/45 (Published November 2020).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides a name, code, or other identifier for the variation margin collateral portfolio to which this belongs. Added to support CFTC Amendments to Part 43/45 (Published November 2020).
	 *
	 */
	PortfolioName getCollateralPortfolioVariationMargin();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the organization to specify which if any relevant regulators or other supervisory bodies this is relevant for, and what reporting rules apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows the organization to specify which if any relevant regulators or other supervisory bodies this is relevant for, and what reporting rules apply.
	 *
	 */
	List<? extends ReportingRegime> getReportingRegime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the trade is not obligated to be cleared via a derivative clearing organization, i.e. whether there is an exemption from clearing. For historical reasons this is called "end-user exception", but this may be used to indication any exception from normal clearing mandates caused by the type of the partiees or their relationship, such as inter-affiliate trades. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the trade is not obligated to be cleared via a derivative clearing organization, i.e. whether there is an exemption from clearing. For historical reasons this is called "end-user exception", but this may be used to indication any exception from normal clearing mandates caused by the type of the partiees or their relationship, such as inter-affiliate trades. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 *
	 */
	Boolean getEndUserException();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a reason that the trade is exempted from a clearing requirement. This exemption may be an end-user exception, or another type such as in inter-affiliate trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a reason that the trade is exempted from a clearing requirement. This exemption may be an end-user exception, or another type such as in inter-affiliate trade.
	 *
	 */
	List<? extends ClearingExceptionReason> getEndUserExceptionReason();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Claims an end user exception and provides supporting evidence. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Claims an end user exception and provides supporting evidence. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 *
	 */
	EndUserExceptionDeclaration getEndUserExceptionDeclaration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the trade has price-affecting characteristics in addition to the standard real-time reportable terms. The flag indicates that the price for this trade is not to be construed as being indicative of the market for standardised trades with otherwise identical reportable terms.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that the trade has price-affecting characteristics in addition to the standard real-time reportable terms. The flag indicates that the price for this trade is not to be construed as being indicative of the market for standardised trades with otherwise identical reportable terms.
	 *
	 */
	Boolean getNonStandardTerms();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the price does not reflect the current market. For example, in a credit trade where the two counterparties are not of equal credit standing, there is no initial margin and one party pays collateral to the other in the form of an add-on to the price (say a price that would otherwise be 100 at the market is struck at 105 to include the collateral, resulting in a very off-market looking price.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that the price does not reflect the current market. For example, in a credit trade where the two counterparties are not of equal credit standing, there is no initial margin and one party pays collateral to the other in the form of an add-on to the price (say a price that would otherwise be 100 at the market is struck at 105 to include the collateral, resulting in a very off-market looking price.)
	 *
	 */
	Boolean getOffMarketPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes why the price of this trade does not reflect the current market price. For example, the trade may have been traded off-market as part of a termination or compression operation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes why the price of this trade does not reflect the current market price. For example, the trade may have been traded off-market as part of a termination or compression operation.
	 *
	 */
	List<? extends PricingContext> getPricingContext();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For off-facility trades, specifies whether the sender of this trade considers it to be a large notional trade or block trade for reporting purposes, and thus eligible for delayed public reporting. This element is used to supply CFTC Large notional off-facility swap election indicator.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For off-facility trades, specifies whether the sender of this trade considers it to be a large notional trade or block trade for reporting purposes, and thus eligible for delayed public reporting. This element is used to supply CFTC Large notional off-facility swap election indicator.
	 *
	 */
	Boolean getLargeSizeTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For on-facility trades, indicator of whether an election has been made to report the swap transaction as a block transaction by the reporting counterparty or as calculated by either the swap data repository acting on behalf of the reporting counterparty or by using a third party. This element is used to provide CFTC 93 Block Trade Election Indicator.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For on-facility trades, indicator of whether an election has been made to report the swap transaction as a block transaction by the reporting counterparty or as calculated by either the swap data repository acting on behalf of the reporting counterparty or by using a third party. This element is used to provide CFTC 93 Block Trade Election Indicator.
	 *
	 */
	Boolean getBlockTradeIndicator();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe how the trade was executed, e.g. via voice or electronically.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to describe how the trade was executed, e.g. via voice or electronically.
	 *
	 */
	ExecutionType getExecutionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe the type of venue where trade was executed, e.g via an execution facility or privately.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to describe the type of venue where trade was executed, e.g via an execution facility or privately.
	 *
	 */
	ExecutionVenueType getExecutionVenueType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe how the trade was or will be verified, e.g via a confirmation facility, via private electronic service, or via written documentation. This affect the timing of real-time reporting requirements. This field is provisional pending detailed confirmation of the data requirements, and may not be included in subsequent working drafts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to describe how the trade was or will be verified, e.g via a confirmation facility, via private electronic service, or via written documentation. This affect the timing of real-time reporting requirements. This field is provisional pending detailed confirmation of the data requirements, and may not be included in subsequent working drafts.
	 *
	 */
	VerificationMethod getVerificationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe how the trade was confirmed, e.g via a confirmation facility, via private electronic service, or via written documentation. This affects the process flow for confirmation messages. This field is provisional pending detailed confirmation of the data requirements, and may not be included in subsequent working drafts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to describe how the trade was confirmed, e.g via a confirmation facility, via private electronic service, or via written documentation. This affects the process flow for confirmation messages. This field is provisional pending detailed confirmation of the data requirements, and may not be included in subsequent working drafts.
	 *
	 */
	ConfirmationMethod getConfirmationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether this trade is a result of compression activity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether this trade is a result of compression activity.
	 *
	 */
	Boolean getCompressedTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the transaction falls within the scope of activity but is exempted from reporting under [Securities Financing Transactions Regulation]
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the transaction falls within the scope of activity but is exempted from reporting under [Securities Financing Transactions Regulation]
	 *
	 */
	Boolean getIsSecuritiesFinancing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Classification of the OTC transaction. Note: Coding scheme definition to encapsulate: Articles 20(3)(a) and 21(5)(a) of Regulation (EU) 600/2014. e.g. default="http://www.fpml.org/coding-scheme/esma-mifir-otc-classification"
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Classification of the OTC transaction. Note: Coding scheme definition to encapsulate: Articles 20(3)(a) and 21(5)(a) of Regulation (EU) 600/2014. e.g. default="http://www.fpml.org/coding-scheme/esma-mifir-otc-classification"
	 *
	 */
	List<? extends OtcClassification> getOtcClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Classification of the pre-trade waiver, if any, that the transaction was executed under. Note: Coding scheme to encapsulate: Articles 4 and 9 of Regulation (EU) 600/2014. e.g. default="http://www.fpml.org/coding-scheme/esma-mifir-trading-waiver"
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Classification of the pre-trade waiver, if any, that the transaction was executed under. Note: Coding scheme to encapsulate: Articles 4 and 9 of Regulation (EU) 600/2014. e.g. default="http://www.fpml.org/coding-scheme/esma-mifir-trading-waiver"
	 *
	 */
	List<? extends TradingWaiver> getTradingWaiver();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Classification of the transaction as a short sale or not and, if short, of the type of transaction. Note: Coding scheme to encapsulate: Article 11 of Regulation (EU) 600/2014. e.g. default="http://www.fpml.org/coding-scheme/esma-mifir-short-sale"
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Classification of the transaction as a short sale or not and, if short, of the type of transaction. Note: Coding scheme to encapsulate: Article 11 of Regulation (EU) 600/2014. e.g. default="http://www.fpml.org/coding-scheme/esma-mifir-short-sale"
	 *
	 */
	ShortSale getShortSale();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the transaction reduces risk in an objectively measurable way. Only applicable for commodity derivative transactions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the transaction reduces risk in an objectively measurable way. Only applicable for commodity derivative transactions.
	 *
	 */
	Boolean getIsCommodityHedge();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to report whether the trade is in dispute
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to report whether the trade is in dispute
	 *
	 */
	Boolean getIsDisputed();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the unit/division/desk etc. that executed or supports this trade
	 *
	 */
	List<? extends Unit> getUnit();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the person or persons who assumed the role of trader for this trade. New implementations are encouraged to use the relatedPerson structure instead.
	 *
	 */
	List<? extends Trader> getTrader();

	/*********************** Build Methods  ***********************/
	PartyTradeInformation build();
	
	PartyTradeInformation.PartyTradeInformationBuilder toBuilder();
	
	static PartyTradeInformation.PartyTradeInformationBuilder builder() {
		return new PartyTradeInformation.PartyTradeInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyTradeInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyTradeInformation> getType() {
		return PartyTradeInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("relatedBusinessUnit"), processor, RelatedBusinessUnit.class, getRelatedBusinessUnit());
		processRosetta(path.newSubPath("relatedPerson"), processor, RelatedPerson.class, getRelatedPerson());
		processRosetta(path.newSubPath("algorithm"), processor, Algorithm.class, getAlgorithm());
		processor.processBasic(path.newSubPath("isAccountingHedge"), Boolean.class, getIsAccountingHedge(), this);
		processRosetta(path.newSubPath("category"), processor, TradeCategory.class, getCategory());
		processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.class, getExecutionDateTime());
		processRosetta(path.newSubPath("timestamps"), processor, TradeProcessingTimestamps.class, getTimestamps());
		processor.processBasic(path.newSubPath("intentToAllocate"), Boolean.class, getIntentToAllocate(), this);
		processRosetta(path.newSubPath("allocationStatus"), processor, AllocationReportingStatus.class, getAllocationStatus());
		processor.processBasic(path.newSubPath("intentToClear"), Boolean.class, getIntentToClear(), this);
		processRosetta(path.newSubPath("clearingStatus"), processor, ClearingStatusValue.class, getClearingStatus());
		processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.class, getCollateralizationType());
		processRosetta(path.newSubPath("collateralPortfolio"), processor, PortfolioName.class, getCollateralPortfolio());
		processRosetta(path.newSubPath("collateralPortfolioInitialMargin"), processor, PortfolioName.class, getCollateralPortfolioInitialMargin());
		processRosetta(path.newSubPath("collateralPortfolioVariationMargin"), processor, PortfolioName.class, getCollateralPortfolioVariationMargin());
		processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegime.class, getReportingRegime());
		processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
		processRosetta(path.newSubPath("endUserExceptionReason"), processor, ClearingExceptionReason.class, getEndUserExceptionReason());
		processRosetta(path.newSubPath("endUserExceptionDeclaration"), processor, EndUserExceptionDeclaration.class, getEndUserExceptionDeclaration());
		processor.processBasic(path.newSubPath("nonStandardTerms"), Boolean.class, getNonStandardTerms(), this);
		processor.processBasic(path.newSubPath("offMarketPrice"), Boolean.class, getOffMarketPrice(), this);
		processRosetta(path.newSubPath("pricingContext"), processor, PricingContext.class, getPricingContext());
		processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
		processor.processBasic(path.newSubPath("blockTradeIndicator"), Boolean.class, getBlockTradeIndicator(), this);
		processRosetta(path.newSubPath("executionType"), processor, ExecutionType.class, getExecutionType());
		processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.class, getExecutionVenueType());
		processRosetta(path.newSubPath("verificationMethod"), processor, VerificationMethod.class, getVerificationMethod());
		processRosetta(path.newSubPath("confirmationMethod"), processor, ConfirmationMethod.class, getConfirmationMethod());
		processor.processBasic(path.newSubPath("compressedTrade"), Boolean.class, getCompressedTrade(), this);
		processor.processBasic(path.newSubPath("isSecuritiesFinancing"), Boolean.class, getIsSecuritiesFinancing(), this);
		processRosetta(path.newSubPath("otcClassification"), processor, OtcClassification.class, getOtcClassification());
		processRosetta(path.newSubPath("tradingWaiver"), processor, TradingWaiver.class, getTradingWaiver());
		processRosetta(path.newSubPath("shortSale"), processor, ShortSale.class, getShortSale());
		processor.processBasic(path.newSubPath("isCommodityHedge"), Boolean.class, getIsCommodityHedge(), this);
		processor.processBasic(path.newSubPath("isDisputed"), Boolean.class, getIsDisputed(), this);
		processRosetta(path.newSubPath("unit"), processor, Unit.class, getUnit());
		processRosetta(path.newSubPath("trader"), processor, Trader.class, getTrader());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyTradeInformationBuilder extends PartyTradeInformation, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAccountReference();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		RelatedBusinessUnit.RelatedBusinessUnitBuilder getOrCreateRelatedBusinessUnit(int index);
		@Override
		List<? extends RelatedBusinessUnit.RelatedBusinessUnitBuilder> getRelatedBusinessUnit();
		RelatedPerson.RelatedPersonBuilder getOrCreateRelatedPerson(int index);
		@Override
		List<? extends RelatedPerson.RelatedPersonBuilder> getRelatedPerson();
		Algorithm.AlgorithmBuilder getOrCreateAlgorithm(int index);
		@Override
		List<? extends Algorithm.AlgorithmBuilder> getAlgorithm();
		TradeCategory.TradeCategoryBuilder getOrCreateCategory(int index);
		@Override
		List<? extends TradeCategory.TradeCategoryBuilder> getCategory();
		ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime();
		@Override
		ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime();
		TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getOrCreateTimestamps();
		@Override
		TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getTimestamps();
		AllocationReportingStatus.AllocationReportingStatusBuilder getOrCreateAllocationStatus();
		@Override
		AllocationReportingStatus.AllocationReportingStatusBuilder getAllocationStatus();
		ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatus();
		@Override
		ClearingStatusValue.ClearingStatusValueBuilder getClearingStatus();
		CollateralizationType.CollateralizationTypeBuilder getOrCreateCollateralizationType();
		@Override
		CollateralizationType.CollateralizationTypeBuilder getCollateralizationType();
		PortfolioName.PortfolioNameBuilder getOrCreateCollateralPortfolio();
		@Override
		PortfolioName.PortfolioNameBuilder getCollateralPortfolio();
		PortfolioName.PortfolioNameBuilder getOrCreateCollateralPortfolioInitialMargin();
		@Override
		PortfolioName.PortfolioNameBuilder getCollateralPortfolioInitialMargin();
		PortfolioName.PortfolioNameBuilder getOrCreateCollateralPortfolioVariationMargin();
		@Override
		PortfolioName.PortfolioNameBuilder getCollateralPortfolioVariationMargin();
		ReportingRegime.ReportingRegimeBuilder getOrCreateReportingRegime(int index);
		@Override
		List<? extends ReportingRegime.ReportingRegimeBuilder> getReportingRegime();
		ClearingExceptionReason.ClearingExceptionReasonBuilder getOrCreateEndUserExceptionReason(int index);
		@Override
		List<? extends ClearingExceptionReason.ClearingExceptionReasonBuilder> getEndUserExceptionReason();
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getOrCreateEndUserExceptionDeclaration();
		@Override
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getEndUserExceptionDeclaration();
		PricingContext.PricingContextBuilder getOrCreatePricingContext(int index);
		@Override
		List<? extends PricingContext.PricingContextBuilder> getPricingContext();
		ExecutionType.ExecutionTypeBuilder getOrCreateExecutionType();
		@Override
		ExecutionType.ExecutionTypeBuilder getExecutionType();
		ExecutionVenueType.ExecutionVenueTypeBuilder getOrCreateExecutionVenueType();
		@Override
		ExecutionVenueType.ExecutionVenueTypeBuilder getExecutionVenueType();
		VerificationMethod.VerificationMethodBuilder getOrCreateVerificationMethod();
		@Override
		VerificationMethod.VerificationMethodBuilder getVerificationMethod();
		ConfirmationMethod.ConfirmationMethodBuilder getOrCreateConfirmationMethod();
		@Override
		ConfirmationMethod.ConfirmationMethodBuilder getConfirmationMethod();
		OtcClassification.OtcClassificationBuilder getOrCreateOtcClassification(int index);
		@Override
		List<? extends OtcClassification.OtcClassificationBuilder> getOtcClassification();
		TradingWaiver.TradingWaiverBuilder getOrCreateTradingWaiver(int index);
		@Override
		List<? extends TradingWaiver.TradingWaiverBuilder> getTradingWaiver();
		ShortSale.ShortSaleBuilder getOrCreateShortSale();
		@Override
		ShortSale.ShortSaleBuilder getShortSale();
		Unit.UnitBuilder getOrCreateUnit(int index);
		@Override
		List<? extends Unit.UnitBuilder> getUnit();
		Trader.TraderBuilder getOrCreateTrader(int index);
		@Override
		List<? extends Trader.TraderBuilder> getTrader();
		PartyTradeInformation.PartyTradeInformationBuilder setPartyReference(PartyReference partyReference);
		PartyTradeInformation.PartyTradeInformationBuilder setAccountReference(AccountReference accountReference);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		PartyTradeInformation.PartyTradeInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		PartyTradeInformation.PartyTradeInformationBuilder setReportingRole(ReportingRole reportingRole);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(RelatedBusinessUnit relatedBusinessUnit);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(RelatedBusinessUnit relatedBusinessUnit, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(List<? extends RelatedBusinessUnit> relatedBusinessUnit);
		PartyTradeInformation.PartyTradeInformationBuilder setRelatedBusinessUnit(List<? extends RelatedBusinessUnit> relatedBusinessUnit);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(RelatedPerson relatedPerson);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(RelatedPerson relatedPerson, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(List<? extends RelatedPerson> relatedPerson);
		PartyTradeInformation.PartyTradeInformationBuilder setRelatedPerson(List<? extends RelatedPerson> relatedPerson);
		PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(Algorithm algorithm);
		PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(Algorithm algorithm, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(List<? extends Algorithm> algorithm);
		PartyTradeInformation.PartyTradeInformationBuilder setAlgorithm(List<? extends Algorithm> algorithm);
		PartyTradeInformation.PartyTradeInformationBuilder setIsAccountingHedge(Boolean isAccountingHedge);
		PartyTradeInformation.PartyTradeInformationBuilder addCategory(TradeCategory category);
		PartyTradeInformation.PartyTradeInformationBuilder addCategory(TradeCategory category, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addCategory(List<? extends TradeCategory> category);
		PartyTradeInformation.PartyTradeInformationBuilder setCategory(List<? extends TradeCategory> category);
		PartyTradeInformation.PartyTradeInformationBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		PartyTradeInformation.PartyTradeInformationBuilder setTimestamps(TradeProcessingTimestamps timestamps);
		PartyTradeInformation.PartyTradeInformationBuilder setIntentToAllocate(Boolean intentToAllocate);
		PartyTradeInformation.PartyTradeInformationBuilder setAllocationStatus(AllocationReportingStatus allocationStatus);
		PartyTradeInformation.PartyTradeInformationBuilder setIntentToClear(Boolean intentToClear);
		PartyTradeInformation.PartyTradeInformationBuilder setClearingStatus(ClearingStatusValue clearingStatus);
		PartyTradeInformation.PartyTradeInformationBuilder setCollateralizationType(CollateralizationType collateralizationType);
		PartyTradeInformation.PartyTradeInformationBuilder setCollateralPortfolio(PortfolioName collateralPortfolio);
		PartyTradeInformation.PartyTradeInformationBuilder setCollateralPortfolioInitialMargin(PortfolioName collateralPortfolioInitialMargin);
		PartyTradeInformation.PartyTradeInformationBuilder setCollateralPortfolioVariationMargin(PortfolioName collateralPortfolioVariationMargin);
		PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(ReportingRegime reportingRegime);
		PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(ReportingRegime reportingRegime, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(List<? extends ReportingRegime> reportingRegime);
		PartyTradeInformation.PartyTradeInformationBuilder setReportingRegime(List<? extends ReportingRegime> reportingRegime);
		PartyTradeInformation.PartyTradeInformationBuilder setEndUserException(Boolean endUserException);
		PartyTradeInformation.PartyTradeInformationBuilder addEndUserExceptionReason(ClearingExceptionReason endUserExceptionReason);
		PartyTradeInformation.PartyTradeInformationBuilder addEndUserExceptionReason(ClearingExceptionReason endUserExceptionReason, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReason);
		PartyTradeInformation.PartyTradeInformationBuilder setEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReason);
		PartyTradeInformation.PartyTradeInformationBuilder setEndUserExceptionDeclaration(EndUserExceptionDeclaration endUserExceptionDeclaration);
		PartyTradeInformation.PartyTradeInformationBuilder setNonStandardTerms(Boolean nonStandardTerms);
		PartyTradeInformation.PartyTradeInformationBuilder setOffMarketPrice(Boolean offMarketPrice);
		PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(PricingContext pricingContext);
		PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(PricingContext pricingContext, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(List<? extends PricingContext> pricingContext);
		PartyTradeInformation.PartyTradeInformationBuilder setPricingContext(List<? extends PricingContext> pricingContext);
		PartyTradeInformation.PartyTradeInformationBuilder setLargeSizeTrade(Boolean largeSizeTrade);
		PartyTradeInformation.PartyTradeInformationBuilder setBlockTradeIndicator(Boolean blockTradeIndicator);
		PartyTradeInformation.PartyTradeInformationBuilder setExecutionType(ExecutionType executionType);
		PartyTradeInformation.PartyTradeInformationBuilder setExecutionVenueType(ExecutionVenueType executionVenueType);
		PartyTradeInformation.PartyTradeInformationBuilder setVerificationMethod(VerificationMethod verificationMethod);
		PartyTradeInformation.PartyTradeInformationBuilder setConfirmationMethod(ConfirmationMethod confirmationMethod);
		PartyTradeInformation.PartyTradeInformationBuilder setCompressedTrade(Boolean compressedTrade);
		PartyTradeInformation.PartyTradeInformationBuilder setIsSecuritiesFinancing(Boolean isSecuritiesFinancing);
		PartyTradeInformation.PartyTradeInformationBuilder addOtcClassification(OtcClassification otcClassification);
		PartyTradeInformation.PartyTradeInformationBuilder addOtcClassification(OtcClassification otcClassification, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addOtcClassification(List<? extends OtcClassification> otcClassification);
		PartyTradeInformation.PartyTradeInformationBuilder setOtcClassification(List<? extends OtcClassification> otcClassification);
		PartyTradeInformation.PartyTradeInformationBuilder addTradingWaiver(TradingWaiver tradingWaiver);
		PartyTradeInformation.PartyTradeInformationBuilder addTradingWaiver(TradingWaiver tradingWaiver, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addTradingWaiver(List<? extends TradingWaiver> tradingWaiver);
		PartyTradeInformation.PartyTradeInformationBuilder setTradingWaiver(List<? extends TradingWaiver> tradingWaiver);
		PartyTradeInformation.PartyTradeInformationBuilder setShortSale(ShortSale shortSale);
		PartyTradeInformation.PartyTradeInformationBuilder setIsCommodityHedge(Boolean isCommodityHedge);
		PartyTradeInformation.PartyTradeInformationBuilder setIsDisputed(Boolean isDisputed);
		PartyTradeInformation.PartyTradeInformationBuilder addUnit(Unit unit);
		PartyTradeInformation.PartyTradeInformationBuilder addUnit(Unit unit, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addUnit(List<? extends Unit> unit);
		PartyTradeInformation.PartyTradeInformationBuilder setUnit(List<? extends Unit> unit);
		PartyTradeInformation.PartyTradeInformationBuilder addTrader(Trader trader);
		PartyTradeInformation.PartyTradeInformationBuilder addTrader(Trader trader, int idx);
		PartyTradeInformation.PartyTradeInformationBuilder addTrader(List<? extends Trader> trader);
		PartyTradeInformation.PartyTradeInformationBuilder setTrader(List<? extends Trader> trader);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("relatedBusinessUnit"), processor, RelatedBusinessUnit.RelatedBusinessUnitBuilder.class, getRelatedBusinessUnit());
			processRosetta(path.newSubPath("relatedPerson"), processor, RelatedPerson.RelatedPersonBuilder.class, getRelatedPerson());
			processRosetta(path.newSubPath("algorithm"), processor, Algorithm.AlgorithmBuilder.class, getAlgorithm());
			processor.processBasic(path.newSubPath("isAccountingHedge"), Boolean.class, getIsAccountingHedge(), this);
			processRosetta(path.newSubPath("category"), processor, TradeCategory.TradeCategoryBuilder.class, getCategory());
			processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.ExecutionDateTimeBuilder.class, getExecutionDateTime());
			processRosetta(path.newSubPath("timestamps"), processor, TradeProcessingTimestamps.TradeProcessingTimestampsBuilder.class, getTimestamps());
			processor.processBasic(path.newSubPath("intentToAllocate"), Boolean.class, getIntentToAllocate(), this);
			processRosetta(path.newSubPath("allocationStatus"), processor, AllocationReportingStatus.AllocationReportingStatusBuilder.class, getAllocationStatus());
			processor.processBasic(path.newSubPath("intentToClear"), Boolean.class, getIntentToClear(), this);
			processRosetta(path.newSubPath("clearingStatus"), processor, ClearingStatusValue.ClearingStatusValueBuilder.class, getClearingStatus());
			processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.CollateralizationTypeBuilder.class, getCollateralizationType());
			processRosetta(path.newSubPath("collateralPortfolio"), processor, PortfolioName.PortfolioNameBuilder.class, getCollateralPortfolio());
			processRosetta(path.newSubPath("collateralPortfolioInitialMargin"), processor, PortfolioName.PortfolioNameBuilder.class, getCollateralPortfolioInitialMargin());
			processRosetta(path.newSubPath("collateralPortfolioVariationMargin"), processor, PortfolioName.PortfolioNameBuilder.class, getCollateralPortfolioVariationMargin());
			processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegime.ReportingRegimeBuilder.class, getReportingRegime());
			processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
			processRosetta(path.newSubPath("endUserExceptionReason"), processor, ClearingExceptionReason.ClearingExceptionReasonBuilder.class, getEndUserExceptionReason());
			processRosetta(path.newSubPath("endUserExceptionDeclaration"), processor, EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder.class, getEndUserExceptionDeclaration());
			processor.processBasic(path.newSubPath("nonStandardTerms"), Boolean.class, getNonStandardTerms(), this);
			processor.processBasic(path.newSubPath("offMarketPrice"), Boolean.class, getOffMarketPrice(), this);
			processRosetta(path.newSubPath("pricingContext"), processor, PricingContext.PricingContextBuilder.class, getPricingContext());
			processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
			processor.processBasic(path.newSubPath("blockTradeIndicator"), Boolean.class, getBlockTradeIndicator(), this);
			processRosetta(path.newSubPath("executionType"), processor, ExecutionType.ExecutionTypeBuilder.class, getExecutionType());
			processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.ExecutionVenueTypeBuilder.class, getExecutionVenueType());
			processRosetta(path.newSubPath("verificationMethod"), processor, VerificationMethod.VerificationMethodBuilder.class, getVerificationMethod());
			processRosetta(path.newSubPath("confirmationMethod"), processor, ConfirmationMethod.ConfirmationMethodBuilder.class, getConfirmationMethod());
			processor.processBasic(path.newSubPath("compressedTrade"), Boolean.class, getCompressedTrade(), this);
			processor.processBasic(path.newSubPath("isSecuritiesFinancing"), Boolean.class, getIsSecuritiesFinancing(), this);
			processRosetta(path.newSubPath("otcClassification"), processor, OtcClassification.OtcClassificationBuilder.class, getOtcClassification());
			processRosetta(path.newSubPath("tradingWaiver"), processor, TradingWaiver.TradingWaiverBuilder.class, getTradingWaiver());
			processRosetta(path.newSubPath("shortSale"), processor, ShortSale.ShortSaleBuilder.class, getShortSale());
			processor.processBasic(path.newSubPath("isCommodityHedge"), Boolean.class, getIsCommodityHedge(), this);
			processor.processBasic(path.newSubPath("isDisputed"), Boolean.class, getIsDisputed(), this);
			processRosetta(path.newSubPath("unit"), processor, Unit.UnitBuilder.class, getUnit());
			processRosetta(path.newSubPath("trader"), processor, Trader.TraderBuilder.class, getTrader());
		}
		

		PartyTradeInformation.PartyTradeInformationBuilder prune();
	}

	/*********************** Immutable Implementation of PartyTradeInformation  ***********************/
	class PartyTradeInformationImpl implements PartyTradeInformation {
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		private final List<? extends RelatedParty> relatedParty;
		private final ReportingRole reportingRole;
		private final List<? extends RelatedBusinessUnit> relatedBusinessUnit;
		private final List<? extends RelatedPerson> relatedPerson;
		private final List<? extends Algorithm> algorithm;
		private final Boolean isAccountingHedge;
		private final List<? extends TradeCategory> category;
		private final ExecutionDateTime executionDateTime;
		private final TradeProcessingTimestamps timestamps;
		private final Boolean intentToAllocate;
		private final AllocationReportingStatus allocationStatus;
		private final Boolean intentToClear;
		private final ClearingStatusValue clearingStatus;
		private final CollateralizationType collateralizationType;
		private final PortfolioName collateralPortfolio;
		private final PortfolioName collateralPortfolioInitialMargin;
		private final PortfolioName collateralPortfolioVariationMargin;
		private final List<? extends ReportingRegime> reportingRegime;
		private final Boolean endUserException;
		private final List<? extends ClearingExceptionReason> endUserExceptionReason;
		private final EndUserExceptionDeclaration endUserExceptionDeclaration;
		private final Boolean nonStandardTerms;
		private final Boolean offMarketPrice;
		private final List<? extends PricingContext> pricingContext;
		private final Boolean largeSizeTrade;
		private final Boolean blockTradeIndicator;
		private final ExecutionType executionType;
		private final ExecutionVenueType executionVenueType;
		private final VerificationMethod verificationMethod;
		private final ConfirmationMethod confirmationMethod;
		private final Boolean compressedTrade;
		private final Boolean isSecuritiesFinancing;
		private final List<? extends OtcClassification> otcClassification;
		private final List<? extends TradingWaiver> tradingWaiver;
		private final ShortSale shortSale;
		private final Boolean isCommodityHedge;
		private final Boolean isDisputed;
		private final List<? extends Unit> unit;
		private final List<? extends Trader> trader;
		
		protected PartyTradeInformationImpl(PartyTradeInformation.PartyTradeInformationBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.relatedBusinessUnit = ofNullable(builder.getRelatedBusinessUnit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.relatedPerson = ofNullable(builder.getRelatedPerson()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.algorithm = ofNullable(builder.getAlgorithm()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.isAccountingHedge = builder.getIsAccountingHedge();
			this.category = ofNullable(builder.getCategory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.executionDateTime = ofNullable(builder.getExecutionDateTime()).map(f->f.build()).orElse(null);
			this.timestamps = ofNullable(builder.getTimestamps()).map(f->f.build()).orElse(null);
			this.intentToAllocate = builder.getIntentToAllocate();
			this.allocationStatus = ofNullable(builder.getAllocationStatus()).map(f->f.build()).orElse(null);
			this.intentToClear = builder.getIntentToClear();
			this.clearingStatus = ofNullable(builder.getClearingStatus()).map(f->f.build()).orElse(null);
			this.collateralizationType = ofNullable(builder.getCollateralizationType()).map(f->f.build()).orElse(null);
			this.collateralPortfolio = ofNullable(builder.getCollateralPortfolio()).map(f->f.build()).orElse(null);
			this.collateralPortfolioInitialMargin = ofNullable(builder.getCollateralPortfolioInitialMargin()).map(f->f.build()).orElse(null);
			this.collateralPortfolioVariationMargin = ofNullable(builder.getCollateralPortfolioVariationMargin()).map(f->f.build()).orElse(null);
			this.reportingRegime = ofNullable(builder.getReportingRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.endUserException = builder.getEndUserException();
			this.endUserExceptionReason = ofNullable(builder.getEndUserExceptionReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.endUserExceptionDeclaration = ofNullable(builder.getEndUserExceptionDeclaration()).map(f->f.build()).orElse(null);
			this.nonStandardTerms = builder.getNonStandardTerms();
			this.offMarketPrice = builder.getOffMarketPrice();
			this.pricingContext = ofNullable(builder.getPricingContext()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.largeSizeTrade = builder.getLargeSizeTrade();
			this.blockTradeIndicator = builder.getBlockTradeIndicator();
			this.executionType = ofNullable(builder.getExecutionType()).map(f->f.build()).orElse(null);
			this.executionVenueType = ofNullable(builder.getExecutionVenueType()).map(f->f.build()).orElse(null);
			this.verificationMethod = ofNullable(builder.getVerificationMethod()).map(f->f.build()).orElse(null);
			this.confirmationMethod = ofNullable(builder.getConfirmationMethod()).map(f->f.build()).orElse(null);
			this.compressedTrade = builder.getCompressedTrade();
			this.isSecuritiesFinancing = builder.getIsSecuritiesFinancing();
			this.otcClassification = ofNullable(builder.getOtcClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradingWaiver = ofNullable(builder.getTradingWaiver()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.shortSale = ofNullable(builder.getShortSale()).map(f->f.build()).orElse(null);
			this.isCommodityHedge = builder.getIsCommodityHedge();
			this.isDisputed = builder.getIsDisputed();
			this.unit = ofNullable(builder.getUnit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.trader = ofNullable(builder.getTrader()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference getAccountReference() {
			return accountReference;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRole getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("relatedBusinessUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedBusinessUnit")
		public List<? extends RelatedBusinessUnit> getRelatedBusinessUnit() {
			return relatedBusinessUnit;
		}
		
		@Override
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedPerson")
		public List<? extends RelatedPerson> getRelatedPerson() {
			return relatedPerson;
		}
		
		@Override
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("algorithm")
		public List<? extends Algorithm> getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("isAccountingHedge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isAccountingHedge")
		public Boolean getIsAccountingHedge() {
			return isAccountingHedge;
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("category")
		public List<? extends TradeCategory> getCategory() {
			return category;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionDateTime")
		public ExecutionDateTime getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		@RosettaAttribute("timestamps")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timestamps")
		public TradeProcessingTimestamps getTimestamps() {
			return timestamps;
		}
		
		@Override
		@RosettaAttribute("intentToAllocate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intentToAllocate")
		public Boolean getIntentToAllocate() {
			return intentToAllocate;
		}
		
		@Override
		@RosettaAttribute("allocationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationStatus")
		public AllocationReportingStatus getAllocationStatus() {
			return allocationStatus;
		}
		
		@Override
		@RosettaAttribute("intentToClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intentToClear")
		public Boolean getIntentToClear() {
			return intentToClear;
		}
		
		@Override
		@RosettaAttribute("clearingStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatus")
		public ClearingStatusValue getClearingStatus() {
			return clearingStatus;
		}
		
		@Override
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizationType")
		public CollateralizationType getCollateralizationType() {
			return collateralizationType;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolio")
		public PortfolioName getCollateralPortfolio() {
			return collateralPortfolio;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioInitialMargin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioInitialMargin")
		public PortfolioName getCollateralPortfolioInitialMargin() {
			return collateralPortfolioInitialMargin;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioVariationMargin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioVariationMargin")
		public PortfolioName getCollateralPortfolioVariationMargin() {
			return collateralPortfolioVariationMargin;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		public List<? extends ReportingRegime> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserException")
		public Boolean getEndUserException() {
			return endUserException;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionReason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("endUserExceptionReason")
		public List<? extends ClearingExceptionReason> getEndUserExceptionReason() {
			return endUserExceptionReason;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserExceptionDeclaration")
		public EndUserExceptionDeclaration getEndUserExceptionDeclaration() {
			return endUserExceptionDeclaration;
		}
		
		@Override
		@RosettaAttribute("nonStandardTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonStandardTerms")
		public Boolean getNonStandardTerms() {
			return nonStandardTerms;
		}
		
		@Override
		@RosettaAttribute("offMarketPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offMarketPrice")
		public Boolean getOffMarketPrice() {
			return offMarketPrice;
		}
		
		@Override
		@RosettaAttribute("pricingContext")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("pricingContext")
		public List<? extends PricingContext> getPricingContext() {
			return pricingContext;
		}
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("blockTradeIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("blockTradeIndicator")
		public Boolean getBlockTradeIndicator() {
			return blockTradeIndicator;
		}
		
		@Override
		@RosettaAttribute("executionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionType")
		public ExecutionType getExecutionType() {
			return executionType;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueType getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		@RosettaAttribute("verificationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("verificationMethod")
		public VerificationMethod getVerificationMethod() {
			return verificationMethod;
		}
		
		@Override
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationMethod")
		public ConfirmationMethod getConfirmationMethod() {
			return confirmationMethod;
		}
		
		@Override
		@RosettaAttribute("compressedTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compressedTrade")
		public Boolean getCompressedTrade() {
			return compressedTrade;
		}
		
		@Override
		@RosettaAttribute("isSecuritiesFinancing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isSecuritiesFinancing")
		public Boolean getIsSecuritiesFinancing() {
			return isSecuritiesFinancing;
		}
		
		@Override
		@RosettaAttribute("otcClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otcClassification")
		public List<? extends OtcClassification> getOtcClassification() {
			return otcClassification;
		}
		
		@Override
		@RosettaAttribute("tradingWaiver")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradingWaiver")
		public List<? extends TradingWaiver> getTradingWaiver() {
			return tradingWaiver;
		}
		
		@Override
		@RosettaAttribute("shortSale")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shortSale")
		public ShortSale getShortSale() {
			return shortSale;
		}
		
		@Override
		@RosettaAttribute("isCommodityHedge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCommodityHedge")
		public Boolean getIsCommodityHedge() {
			return isCommodityHedge;
		}
		
		@Override
		@RosettaAttribute("isDisputed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isDisputed")
		public Boolean getIsDisputed() {
			return isDisputed;
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("unit")
		public List<? extends Unit> getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("trader")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("trader")
		public List<? extends Trader> getTrader() {
			return trader;
		}
		
		@Override
		public PartyTradeInformation build() {
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder toBuilder() {
			PartyTradeInformation.PartyTradeInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTradeInformation.PartyTradeInformationBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getRelatedBusinessUnit()).ifPresent(builder::setRelatedBusinessUnit);
			ofNullable(getRelatedPerson()).ifPresent(builder::setRelatedPerson);
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
			ofNullable(getIsAccountingHedge()).ifPresent(builder::setIsAccountingHedge);
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getExecutionDateTime()).ifPresent(builder::setExecutionDateTime);
			ofNullable(getTimestamps()).ifPresent(builder::setTimestamps);
			ofNullable(getIntentToAllocate()).ifPresent(builder::setIntentToAllocate);
			ofNullable(getAllocationStatus()).ifPresent(builder::setAllocationStatus);
			ofNullable(getIntentToClear()).ifPresent(builder::setIntentToClear);
			ofNullable(getClearingStatus()).ifPresent(builder::setClearingStatus);
			ofNullable(getCollateralizationType()).ifPresent(builder::setCollateralizationType);
			ofNullable(getCollateralPortfolio()).ifPresent(builder::setCollateralPortfolio);
			ofNullable(getCollateralPortfolioInitialMargin()).ifPresent(builder::setCollateralPortfolioInitialMargin);
			ofNullable(getCollateralPortfolioVariationMargin()).ifPresent(builder::setCollateralPortfolioVariationMargin);
			ofNullable(getReportingRegime()).ifPresent(builder::setReportingRegime);
			ofNullable(getEndUserException()).ifPresent(builder::setEndUserException);
			ofNullable(getEndUserExceptionReason()).ifPresent(builder::setEndUserExceptionReason);
			ofNullable(getEndUserExceptionDeclaration()).ifPresent(builder::setEndUserExceptionDeclaration);
			ofNullable(getNonStandardTerms()).ifPresent(builder::setNonStandardTerms);
			ofNullable(getOffMarketPrice()).ifPresent(builder::setOffMarketPrice);
			ofNullable(getPricingContext()).ifPresent(builder::setPricingContext);
			ofNullable(getLargeSizeTrade()).ifPresent(builder::setLargeSizeTrade);
			ofNullable(getBlockTradeIndicator()).ifPresent(builder::setBlockTradeIndicator);
			ofNullable(getExecutionType()).ifPresent(builder::setExecutionType);
			ofNullable(getExecutionVenueType()).ifPresent(builder::setExecutionVenueType);
			ofNullable(getVerificationMethod()).ifPresent(builder::setVerificationMethod);
			ofNullable(getConfirmationMethod()).ifPresent(builder::setConfirmationMethod);
			ofNullable(getCompressedTrade()).ifPresent(builder::setCompressedTrade);
			ofNullable(getIsSecuritiesFinancing()).ifPresent(builder::setIsSecuritiesFinancing);
			ofNullable(getOtcClassification()).ifPresent(builder::setOtcClassification);
			ofNullable(getTradingWaiver()).ifPresent(builder::setTradingWaiver);
			ofNullable(getShortSale()).ifPresent(builder::setShortSale);
			ofNullable(getIsCommodityHedge()).ifPresent(builder::setIsCommodityHedge);
			ofNullable(getIsDisputed()).ifPresent(builder::setIsDisputed);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
			ofNullable(getTrader()).ifPresent(builder::setTrader);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(relatedBusinessUnit, _that.getRelatedBusinessUnit())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!ListEquals.listEquals(algorithm, _that.getAlgorithm())) return false;
			if (!Objects.equals(isAccountingHedge, _that.getIsAccountingHedge())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(timestamps, _that.getTimestamps())) return false;
			if (!Objects.equals(intentToAllocate, _that.getIntentToAllocate())) return false;
			if (!Objects.equals(allocationStatus, _that.getAllocationStatus())) return false;
			if (!Objects.equals(intentToClear, _that.getIntentToClear())) return false;
			if (!Objects.equals(clearingStatus, _that.getClearingStatus())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(collateralPortfolio, _that.getCollateralPortfolio())) return false;
			if (!Objects.equals(collateralPortfolioInitialMargin, _that.getCollateralPortfolioInitialMargin())) return false;
			if (!Objects.equals(collateralPortfolioVariationMargin, _that.getCollateralPortfolioVariationMargin())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!ListEquals.listEquals(endUserExceptionReason, _that.getEndUserExceptionReason())) return false;
			if (!Objects.equals(endUserExceptionDeclaration, _that.getEndUserExceptionDeclaration())) return false;
			if (!Objects.equals(nonStandardTerms, _that.getNonStandardTerms())) return false;
			if (!Objects.equals(offMarketPrice, _that.getOffMarketPrice())) return false;
			if (!ListEquals.listEquals(pricingContext, _that.getPricingContext())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(blockTradeIndicator, _that.getBlockTradeIndicator())) return false;
			if (!Objects.equals(executionType, _that.getExecutionType())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(verificationMethod, _that.getVerificationMethod())) return false;
			if (!Objects.equals(confirmationMethod, _that.getConfirmationMethod())) return false;
			if (!Objects.equals(compressedTrade, _that.getCompressedTrade())) return false;
			if (!Objects.equals(isSecuritiesFinancing, _that.getIsSecuritiesFinancing())) return false;
			if (!ListEquals.listEquals(otcClassification, _that.getOtcClassification())) return false;
			if (!ListEquals.listEquals(tradingWaiver, _that.getTradingWaiver())) return false;
			if (!Objects.equals(shortSale, _that.getShortSale())) return false;
			if (!Objects.equals(isCommodityHedge, _that.getIsCommodityHedge())) return false;
			if (!Objects.equals(isDisputed, _that.getIsDisputed())) return false;
			if (!ListEquals.listEquals(unit, _that.getUnit())) return false;
			if (!ListEquals.listEquals(trader, _that.getTrader())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (relatedBusinessUnit != null ? relatedBusinessUnit.hashCode() : 0);
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (isAccountingHedge != null ? isAccountingHedge.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (timestamps != null ? timestamps.hashCode() : 0);
			_result = 31 * _result + (intentToAllocate != null ? intentToAllocate.hashCode() : 0);
			_result = 31 * _result + (allocationStatus != null ? allocationStatus.hashCode() : 0);
			_result = 31 * _result + (intentToClear != null ? intentToClear.hashCode() : 0);
			_result = 31 * _result + (clearingStatus != null ? clearingStatus.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolio != null ? collateralPortfolio.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioInitialMargin != null ? collateralPortfolioInitialMargin.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioVariationMargin != null ? collateralPortfolioVariationMargin.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionReason != null ? endUserExceptionReason.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionDeclaration != null ? endUserExceptionDeclaration.hashCode() : 0);
			_result = 31 * _result + (nonStandardTerms != null ? nonStandardTerms.hashCode() : 0);
			_result = 31 * _result + (offMarketPrice != null ? offMarketPrice.hashCode() : 0);
			_result = 31 * _result + (pricingContext != null ? pricingContext.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (blockTradeIndicator != null ? blockTradeIndicator.hashCode() : 0);
			_result = 31 * _result + (executionType != null ? executionType.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (verificationMethod != null ? verificationMethod.hashCode() : 0);
			_result = 31 * _result + (confirmationMethod != null ? confirmationMethod.hashCode() : 0);
			_result = 31 * _result + (compressedTrade != null ? compressedTrade.hashCode() : 0);
			_result = 31 * _result + (isSecuritiesFinancing != null ? isSecuritiesFinancing.hashCode() : 0);
			_result = 31 * _result + (otcClassification != null ? otcClassification.hashCode() : 0);
			_result = 31 * _result + (tradingWaiver != null ? tradingWaiver.hashCode() : 0);
			_result = 31 * _result + (shortSale != null ? shortSale.hashCode() : 0);
			_result = 31 * _result + (isCommodityHedge != null ? isCommodityHedge.hashCode() : 0);
			_result = 31 * _result + (isDisputed != null ? isDisputed.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (trader != null ? trader.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeInformation {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"relatedBusinessUnit=" + this.relatedBusinessUnit + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"algorithm=" + this.algorithm + ", " +
				"isAccountingHedge=" + this.isAccountingHedge + ", " +
				"category=" + this.category + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"timestamps=" + this.timestamps + ", " +
				"intentToAllocate=" + this.intentToAllocate + ", " +
				"allocationStatus=" + this.allocationStatus + ", " +
				"intentToClear=" + this.intentToClear + ", " +
				"clearingStatus=" + this.clearingStatus + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"collateralPortfolio=" + this.collateralPortfolio + ", " +
				"collateralPortfolioInitialMargin=" + this.collateralPortfolioInitialMargin + ", " +
				"collateralPortfolioVariationMargin=" + this.collateralPortfolioVariationMargin + ", " +
				"reportingRegime=" + this.reportingRegime + ", " +
				"endUserException=" + this.endUserException + ", " +
				"endUserExceptionReason=" + this.endUserExceptionReason + ", " +
				"endUserExceptionDeclaration=" + this.endUserExceptionDeclaration + ", " +
				"nonStandardTerms=" + this.nonStandardTerms + ", " +
				"offMarketPrice=" + this.offMarketPrice + ", " +
				"pricingContext=" + this.pricingContext + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"blockTradeIndicator=" + this.blockTradeIndicator + ", " +
				"executionType=" + this.executionType + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"verificationMethod=" + this.verificationMethod + ", " +
				"confirmationMethod=" + this.confirmationMethod + ", " +
				"compressedTrade=" + this.compressedTrade + ", " +
				"isSecuritiesFinancing=" + this.isSecuritiesFinancing + ", " +
				"otcClassification=" + this.otcClassification + ", " +
				"tradingWaiver=" + this.tradingWaiver + ", " +
				"shortSale=" + this.shortSale + ", " +
				"isCommodityHedge=" + this.isCommodityHedge + ", " +
				"isDisputed=" + this.isDisputed + ", " +
				"unit=" + this.unit + ", " +
				"trader=" + this.trader +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyTradeInformation  ***********************/
	class PartyTradeInformationBuilderImpl implements PartyTradeInformation.PartyTradeInformationBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<RelatedBusinessUnit.RelatedBusinessUnitBuilder> relatedBusinessUnit = new ArrayList<>();
		protected List<RelatedPerson.RelatedPersonBuilder> relatedPerson = new ArrayList<>();
		protected List<Algorithm.AlgorithmBuilder> algorithm = new ArrayList<>();
		protected Boolean isAccountingHedge;
		protected List<TradeCategory.TradeCategoryBuilder> category = new ArrayList<>();
		protected ExecutionDateTime.ExecutionDateTimeBuilder executionDateTime;
		protected TradeProcessingTimestamps.TradeProcessingTimestampsBuilder timestamps;
		protected Boolean intentToAllocate;
		protected AllocationReportingStatus.AllocationReportingStatusBuilder allocationStatus;
		protected Boolean intentToClear;
		protected ClearingStatusValue.ClearingStatusValueBuilder clearingStatus;
		protected CollateralizationType.CollateralizationTypeBuilder collateralizationType;
		protected PortfolioName.PortfolioNameBuilder collateralPortfolio;
		protected PortfolioName.PortfolioNameBuilder collateralPortfolioInitialMargin;
		protected PortfolioName.PortfolioNameBuilder collateralPortfolioVariationMargin;
		protected List<ReportingRegime.ReportingRegimeBuilder> reportingRegime = new ArrayList<>();
		protected Boolean endUserException;
		protected List<ClearingExceptionReason.ClearingExceptionReasonBuilder> endUserExceptionReason = new ArrayList<>();
		protected EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder endUserExceptionDeclaration;
		protected Boolean nonStandardTerms;
		protected Boolean offMarketPrice;
		protected List<PricingContext.PricingContextBuilder> pricingContext = new ArrayList<>();
		protected Boolean largeSizeTrade;
		protected Boolean blockTradeIndicator;
		protected ExecutionType.ExecutionTypeBuilder executionType;
		protected ExecutionVenueType.ExecutionVenueTypeBuilder executionVenueType;
		protected VerificationMethod.VerificationMethodBuilder verificationMethod;
		protected ConfirmationMethod.ConfirmationMethodBuilder confirmationMethod;
		protected Boolean compressedTrade;
		protected Boolean isSecuritiesFinancing;
		protected List<OtcClassification.OtcClassificationBuilder> otcClassification = new ArrayList<>();
		protected List<TradingWaiver.TradingWaiverBuilder> tradingWaiver = new ArrayList<>();
		protected ShortSale.ShortSaleBuilder shortSale;
		protected Boolean isCommodityHedge;
		protected Boolean isDisputed;
		protected List<Unit.UnitBuilder> unit = new ArrayList<>();
		protected List<Trader.TraderBuilder> trader = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference.AccountReferenceBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRole.ReportingRoleBuilder getReportingRole() {
			return reportingRole;
		}
		
		@Override
		public ReportingRole.ReportingRoleBuilder getOrCreateReportingRole() {
			ReportingRole.ReportingRoleBuilder result;
			if (reportingRole!=null) {
				result = reportingRole;
			}
			else {
				result = reportingRole = ReportingRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedBusinessUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedBusinessUnit")
		public List<? extends RelatedBusinessUnit.RelatedBusinessUnitBuilder> getRelatedBusinessUnit() {
			return relatedBusinessUnit;
		}
		
		@Override
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder getOrCreateRelatedBusinessUnit(int index) {
			if (relatedBusinessUnit==null) {
				this.relatedBusinessUnit = new ArrayList<>();
			}
			return getIndex(relatedBusinessUnit, index, () -> {
						RelatedBusinessUnit.RelatedBusinessUnitBuilder newRelatedBusinessUnit = RelatedBusinessUnit.builder();
						return newRelatedBusinessUnit;
					});
		}
		
		@Override
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedPerson")
		public List<? extends RelatedPerson.RelatedPersonBuilder> getRelatedPerson() {
			return relatedPerson;
		}
		
		@Override
		public RelatedPerson.RelatedPersonBuilder getOrCreateRelatedPerson(int index) {
			if (relatedPerson==null) {
				this.relatedPerson = new ArrayList<>();
			}
			return getIndex(relatedPerson, index, () -> {
						RelatedPerson.RelatedPersonBuilder newRelatedPerson = RelatedPerson.builder();
						return newRelatedPerson;
					});
		}
		
		@Override
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("algorithm")
		public List<? extends Algorithm.AlgorithmBuilder> getAlgorithm() {
			return algorithm;
		}
		
		@Override
		public Algorithm.AlgorithmBuilder getOrCreateAlgorithm(int index) {
			if (algorithm==null) {
				this.algorithm = new ArrayList<>();
			}
			return getIndex(algorithm, index, () -> {
						Algorithm.AlgorithmBuilder newAlgorithm = Algorithm.builder();
						return newAlgorithm;
					});
		}
		
		@Override
		@RosettaAttribute("isAccountingHedge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isAccountingHedge")
		public Boolean getIsAccountingHedge() {
			return isAccountingHedge;
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("category")
		public List<? extends TradeCategory.TradeCategoryBuilder> getCategory() {
			return category;
		}
		
		@Override
		public TradeCategory.TradeCategoryBuilder getOrCreateCategory(int index) {
			if (category==null) {
				this.category = new ArrayList<>();
			}
			return getIndex(category, index, () -> {
						TradeCategory.TradeCategoryBuilder newCategory = TradeCategory.builder();
						return newCategory;
					});
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
		@RosettaAttribute("timestamps")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timestamps")
		public TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getTimestamps() {
			return timestamps;
		}
		
		@Override
		public TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getOrCreateTimestamps() {
			TradeProcessingTimestamps.TradeProcessingTimestampsBuilder result;
			if (timestamps!=null) {
				result = timestamps;
			}
			else {
				result = timestamps = TradeProcessingTimestamps.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intentToAllocate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intentToAllocate")
		public Boolean getIntentToAllocate() {
			return intentToAllocate;
		}
		
		@Override
		@RosettaAttribute("allocationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationStatus")
		public AllocationReportingStatus.AllocationReportingStatusBuilder getAllocationStatus() {
			return allocationStatus;
		}
		
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder getOrCreateAllocationStatus() {
			AllocationReportingStatus.AllocationReportingStatusBuilder result;
			if (allocationStatus!=null) {
				result = allocationStatus;
			}
			else {
				result = allocationStatus = AllocationReportingStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intentToClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intentToClear")
		public Boolean getIntentToClear() {
			return intentToClear;
		}
		
		@Override
		@RosettaAttribute("clearingStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatus")
		public ClearingStatusValue.ClearingStatusValueBuilder getClearingStatus() {
			return clearingStatus;
		}
		
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatus() {
			ClearingStatusValue.ClearingStatusValueBuilder result;
			if (clearingStatus!=null) {
				result = clearingStatus;
			}
			else {
				result = clearingStatus = ClearingStatusValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizationType")
		public CollateralizationType.CollateralizationTypeBuilder getCollateralizationType() {
			return collateralizationType;
		}
		
		@Override
		public CollateralizationType.CollateralizationTypeBuilder getOrCreateCollateralizationType() {
			CollateralizationType.CollateralizationTypeBuilder result;
			if (collateralizationType!=null) {
				result = collateralizationType;
			}
			else {
				result = collateralizationType = CollateralizationType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolio")
		public PortfolioName.PortfolioNameBuilder getCollateralPortfolio() {
			return collateralPortfolio;
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder getOrCreateCollateralPortfolio() {
			PortfolioName.PortfolioNameBuilder result;
			if (collateralPortfolio!=null) {
				result = collateralPortfolio;
			}
			else {
				result = collateralPortfolio = PortfolioName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioInitialMargin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioInitialMargin")
		public PortfolioName.PortfolioNameBuilder getCollateralPortfolioInitialMargin() {
			return collateralPortfolioInitialMargin;
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder getOrCreateCollateralPortfolioInitialMargin() {
			PortfolioName.PortfolioNameBuilder result;
			if (collateralPortfolioInitialMargin!=null) {
				result = collateralPortfolioInitialMargin;
			}
			else {
				result = collateralPortfolioInitialMargin = PortfolioName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioVariationMargin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioVariationMargin")
		public PortfolioName.PortfolioNameBuilder getCollateralPortfolioVariationMargin() {
			return collateralPortfolioVariationMargin;
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder getOrCreateCollateralPortfolioVariationMargin() {
			PortfolioName.PortfolioNameBuilder result;
			if (collateralPortfolioVariationMargin!=null) {
				result = collateralPortfolioVariationMargin;
			}
			else {
				result = collateralPortfolioVariationMargin = PortfolioName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		public List<? extends ReportingRegime.ReportingRegimeBuilder> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder getOrCreateReportingRegime(int index) {
			if (reportingRegime==null) {
				this.reportingRegime = new ArrayList<>();
			}
			return getIndex(reportingRegime, index, () -> {
						ReportingRegime.ReportingRegimeBuilder newReportingRegime = ReportingRegime.builder();
						return newReportingRegime;
					});
		}
		
		@Override
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserException")
		public Boolean getEndUserException() {
			return endUserException;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionReason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("endUserExceptionReason")
		public List<? extends ClearingExceptionReason.ClearingExceptionReasonBuilder> getEndUserExceptionReason() {
			return endUserExceptionReason;
		}
		
		@Override
		public ClearingExceptionReason.ClearingExceptionReasonBuilder getOrCreateEndUserExceptionReason(int index) {
			if (endUserExceptionReason==null) {
				this.endUserExceptionReason = new ArrayList<>();
			}
			return getIndex(endUserExceptionReason, index, () -> {
						ClearingExceptionReason.ClearingExceptionReasonBuilder newEndUserExceptionReason = ClearingExceptionReason.builder();
						return newEndUserExceptionReason;
					});
		}
		
		@Override
		@RosettaAttribute("endUserExceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserExceptionDeclaration")
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getEndUserExceptionDeclaration() {
			return endUserExceptionDeclaration;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getOrCreateEndUserExceptionDeclaration() {
			EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder result;
			if (endUserExceptionDeclaration!=null) {
				result = endUserExceptionDeclaration;
			}
			else {
				result = endUserExceptionDeclaration = EndUserExceptionDeclaration.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonStandardTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonStandardTerms")
		public Boolean getNonStandardTerms() {
			return nonStandardTerms;
		}
		
		@Override
		@RosettaAttribute("offMarketPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offMarketPrice")
		public Boolean getOffMarketPrice() {
			return offMarketPrice;
		}
		
		@Override
		@RosettaAttribute("pricingContext")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("pricingContext")
		public List<? extends PricingContext.PricingContextBuilder> getPricingContext() {
			return pricingContext;
		}
		
		@Override
		public PricingContext.PricingContextBuilder getOrCreatePricingContext(int index) {
			if (pricingContext==null) {
				this.pricingContext = new ArrayList<>();
			}
			return getIndex(pricingContext, index, () -> {
						PricingContext.PricingContextBuilder newPricingContext = PricingContext.builder();
						return newPricingContext;
					});
		}
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("blockTradeIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("blockTradeIndicator")
		public Boolean getBlockTradeIndicator() {
			return blockTradeIndicator;
		}
		
		@Override
		@RosettaAttribute("executionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionType")
		public ExecutionType.ExecutionTypeBuilder getExecutionType() {
			return executionType;
		}
		
		@Override
		public ExecutionType.ExecutionTypeBuilder getOrCreateExecutionType() {
			ExecutionType.ExecutionTypeBuilder result;
			if (executionType!=null) {
				result = executionType;
			}
			else {
				result = executionType = ExecutionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueType.ExecutionVenueTypeBuilder getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder getOrCreateExecutionVenueType() {
			ExecutionVenueType.ExecutionVenueTypeBuilder result;
			if (executionVenueType!=null) {
				result = executionVenueType;
			}
			else {
				result = executionVenueType = ExecutionVenueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("verificationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("verificationMethod")
		public VerificationMethod.VerificationMethodBuilder getVerificationMethod() {
			return verificationMethod;
		}
		
		@Override
		public VerificationMethod.VerificationMethodBuilder getOrCreateVerificationMethod() {
			VerificationMethod.VerificationMethodBuilder result;
			if (verificationMethod!=null) {
				result = verificationMethod;
			}
			else {
				result = verificationMethod = VerificationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationMethod")
		public ConfirmationMethod.ConfirmationMethodBuilder getConfirmationMethod() {
			return confirmationMethod;
		}
		
		@Override
		public ConfirmationMethod.ConfirmationMethodBuilder getOrCreateConfirmationMethod() {
			ConfirmationMethod.ConfirmationMethodBuilder result;
			if (confirmationMethod!=null) {
				result = confirmationMethod;
			}
			else {
				result = confirmationMethod = ConfirmationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compressedTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compressedTrade")
		public Boolean getCompressedTrade() {
			return compressedTrade;
		}
		
		@Override
		@RosettaAttribute("isSecuritiesFinancing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isSecuritiesFinancing")
		public Boolean getIsSecuritiesFinancing() {
			return isSecuritiesFinancing;
		}
		
		@Override
		@RosettaAttribute("otcClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otcClassification")
		public List<? extends OtcClassification.OtcClassificationBuilder> getOtcClassification() {
			return otcClassification;
		}
		
		@Override
		public OtcClassification.OtcClassificationBuilder getOrCreateOtcClassification(int index) {
			if (otcClassification==null) {
				this.otcClassification = new ArrayList<>();
			}
			return getIndex(otcClassification, index, () -> {
						OtcClassification.OtcClassificationBuilder newOtcClassification = OtcClassification.builder();
						return newOtcClassification;
					});
		}
		
		@Override
		@RosettaAttribute("tradingWaiver")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradingWaiver")
		public List<? extends TradingWaiver.TradingWaiverBuilder> getTradingWaiver() {
			return tradingWaiver;
		}
		
		@Override
		public TradingWaiver.TradingWaiverBuilder getOrCreateTradingWaiver(int index) {
			if (tradingWaiver==null) {
				this.tradingWaiver = new ArrayList<>();
			}
			return getIndex(tradingWaiver, index, () -> {
						TradingWaiver.TradingWaiverBuilder newTradingWaiver = TradingWaiver.builder();
						return newTradingWaiver;
					});
		}
		
		@Override
		@RosettaAttribute("shortSale")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shortSale")
		public ShortSale.ShortSaleBuilder getShortSale() {
			return shortSale;
		}
		
		@Override
		public ShortSale.ShortSaleBuilder getOrCreateShortSale() {
			ShortSale.ShortSaleBuilder result;
			if (shortSale!=null) {
				result = shortSale;
			}
			else {
				result = shortSale = ShortSale.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isCommodityHedge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCommodityHedge")
		public Boolean getIsCommodityHedge() {
			return isCommodityHedge;
		}
		
		@Override
		@RosettaAttribute("isDisputed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isDisputed")
		public Boolean getIsDisputed() {
			return isDisputed;
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("unit")
		public List<? extends Unit.UnitBuilder> getUnit() {
			return unit;
		}
		
		@Override
		public Unit.UnitBuilder getOrCreateUnit(int index) {
			if (unit==null) {
				this.unit = new ArrayList<>();
			}
			return getIndex(unit, index, () -> {
						Unit.UnitBuilder newUnit = Unit.builder();
						return newUnit;
					});
		}
		
		@Override
		@RosettaAttribute("trader")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("trader")
		public List<? extends Trader.TraderBuilder> getTrader() {
			return trader;
		}
		
		@Override
		public Trader.TraderBuilder getOrCreateTrader(int index) {
			if (trader==null) {
				this.trader = new ArrayList<>();
			}
			return getIndex(trader, index, () -> {
						Trader.TraderBuilder newTrader = Trader.builder();
						return newTrader;
					});
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingRole")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedBusinessUnit")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedBusinessUnit")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(RelatedBusinessUnit _relatedBusinessUnit) {
			if (_relatedBusinessUnit != null) {
				this.relatedBusinessUnit.add(_relatedBusinessUnit.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(RelatedBusinessUnit _relatedBusinessUnit, int idx) {
			getIndex(this.relatedBusinessUnit, idx, () -> _relatedBusinessUnit.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(List<? extends RelatedBusinessUnit> relatedBusinessUnits) {
			if (relatedBusinessUnits != null) {
				for (final RelatedBusinessUnit toAdd : relatedBusinessUnits) {
					this.relatedBusinessUnit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedBusinessUnit")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedBusinessUnit")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setRelatedBusinessUnit(List<? extends RelatedBusinessUnit> relatedBusinessUnits) {
			if (relatedBusinessUnits == null) {
				this.relatedBusinessUnit = new ArrayList<>();
			} else {
				this.relatedBusinessUnit = relatedBusinessUnits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedPerson")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(RelatedPerson _relatedPerson) {
			if (_relatedPerson != null) {
				this.relatedPerson.add(_relatedPerson.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(RelatedPerson _relatedPerson, int idx) {
			getIndex(this.relatedPerson, idx, () -> _relatedPerson.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(List<? extends RelatedPerson> relatedPersons) {
			if (relatedPersons != null) {
				for (final RelatedPerson toAdd : relatedPersons) {
					this.relatedPerson.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedPerson")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setRelatedPerson(List<? extends RelatedPerson> relatedPersons) {
			if (relatedPersons == null) {
				this.relatedPerson = new ArrayList<>();
			} else {
				this.relatedPerson = relatedPersons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("algorithm")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(Algorithm _algorithm) {
			if (_algorithm != null) {
				this.algorithm.add(_algorithm.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(Algorithm _algorithm, int idx) {
			getIndex(this.algorithm, idx, () -> _algorithm.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(List<? extends Algorithm> algorithms) {
			if (algorithms != null) {
				for (final Algorithm toAdd : algorithms) {
					this.algorithm.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("algorithm")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setAlgorithm(List<? extends Algorithm> algorithms) {
			if (algorithms == null) {
				this.algorithm = new ArrayList<>();
			} else {
				this.algorithm = algorithms.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isAccountingHedge")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isAccountingHedge")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setIsAccountingHedge(Boolean _isAccountingHedge) {
			this.isAccountingHedge = _isAccountingHedge == null ? null : _isAccountingHedge;
			return this;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("category")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addCategory(TradeCategory _category) {
			if (_category != null) {
				this.category.add(_category.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addCategory(TradeCategory _category, int idx) {
			getIndex(this.category, idx, () -> _category.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addCategory(List<? extends TradeCategory> categorys) {
			if (categorys != null) {
				for (final TradeCategory toAdd : categorys) {
					this.category.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("category")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setCategory(List<? extends TradeCategory> categorys) {
			if (categorys == null) {
				this.category = new ArrayList<>();
			} else {
				this.category = categorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionDateTime")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setExecutionDateTime(ExecutionDateTime _executionDateTime) {
			this.executionDateTime = _executionDateTime == null ? null : _executionDateTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("timestamps")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("timestamps")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setTimestamps(TradeProcessingTimestamps _timestamps) {
			this.timestamps = _timestamps == null ? null : _timestamps.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intentToAllocate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intentToAllocate")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setIntentToAllocate(Boolean _intentToAllocate) {
			this.intentToAllocate = _intentToAllocate == null ? null : _intentToAllocate;
			return this;
		}
		
		@RosettaAttribute("allocationStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocationStatus")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setAllocationStatus(AllocationReportingStatus _allocationStatus) {
			this.allocationStatus = _allocationStatus == null ? null : _allocationStatus.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intentToClear")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intentToClear")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setIntentToClear(Boolean _intentToClear) {
			this.intentToClear = _intentToClear == null ? null : _intentToClear;
			return this;
		}
		
		@RosettaAttribute("clearingStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingStatus")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setClearingStatus(ClearingStatusValue _clearingStatus) {
			this.clearingStatus = _clearingStatus == null ? null : _clearingStatus.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralizationType")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setCollateralizationType(CollateralizationType _collateralizationType) {
			this.collateralizationType = _collateralizationType == null ? null : _collateralizationType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralPortfolio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolio")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setCollateralPortfolio(PortfolioName _collateralPortfolio) {
			this.collateralPortfolio = _collateralPortfolio == null ? null : _collateralPortfolio.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioInitialMargin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioInitialMargin")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setCollateralPortfolioInitialMargin(PortfolioName _collateralPortfolioInitialMargin) {
			this.collateralPortfolioInitialMargin = _collateralPortfolioInitialMargin == null ? null : _collateralPortfolioInitialMargin.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioVariationMargin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioVariationMargin")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setCollateralPortfolioVariationMargin(PortfolioName _collateralPortfolioVariationMargin) {
			this.collateralPortfolioVariationMargin = _collateralPortfolioVariationMargin == null ? null : _collateralPortfolioVariationMargin.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingRegime")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(ReportingRegime _reportingRegime) {
			if (_reportingRegime != null) {
				this.reportingRegime.add(_reportingRegime.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(ReportingRegime _reportingRegime, int idx) {
			getIndex(this.reportingRegime, idx, () -> _reportingRegime.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(List<? extends ReportingRegime> reportingRegimes) {
			if (reportingRegimes != null) {
				for (final ReportingRegime toAdd : reportingRegimes) {
					this.reportingRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setReportingRegime(List<? extends ReportingRegime> reportingRegimes) {
			if (reportingRegimes == null) {
				this.reportingRegime = new ArrayList<>();
			} else {
				this.reportingRegime = reportingRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endUserException")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setEndUserException(Boolean _endUserException) {
			this.endUserException = _endUserException == null ? null : _endUserException;
			return this;
		}
		
		@RosettaAttribute("endUserExceptionReason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("endUserExceptionReason")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addEndUserExceptionReason(ClearingExceptionReason _endUserExceptionReason) {
			if (_endUserExceptionReason != null) {
				this.endUserExceptionReason.add(_endUserExceptionReason.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addEndUserExceptionReason(ClearingExceptionReason _endUserExceptionReason, int idx) {
			getIndex(this.endUserExceptionReason, idx, () -> _endUserExceptionReason.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReasons) {
			if (endUserExceptionReasons != null) {
				for (final ClearingExceptionReason toAdd : endUserExceptionReasons) {
					this.endUserExceptionReason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("endUserExceptionReason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("endUserExceptionReason")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReasons) {
			if (endUserExceptionReasons == null) {
				this.endUserExceptionReason = new ArrayList<>();
			} else {
				this.endUserExceptionReason = endUserExceptionReasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("endUserExceptionDeclaration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endUserExceptionDeclaration")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setEndUserExceptionDeclaration(EndUserExceptionDeclaration _endUserExceptionDeclaration) {
			this.endUserExceptionDeclaration = _endUserExceptionDeclaration == null ? null : _endUserExceptionDeclaration.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonStandardTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonStandardTerms")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setNonStandardTerms(Boolean _nonStandardTerms) {
			this.nonStandardTerms = _nonStandardTerms == null ? null : _nonStandardTerms;
			return this;
		}
		
		@RosettaAttribute("offMarketPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("offMarketPrice")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setOffMarketPrice(Boolean _offMarketPrice) {
			this.offMarketPrice = _offMarketPrice == null ? null : _offMarketPrice;
			return this;
		}
		
		@RosettaAttribute("pricingContext")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("pricingContext")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(PricingContext _pricingContext) {
			if (_pricingContext != null) {
				this.pricingContext.add(_pricingContext.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(PricingContext _pricingContext, int idx) {
			getIndex(this.pricingContext, idx, () -> _pricingContext.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(List<? extends PricingContext> pricingContexts) {
			if (pricingContexts != null) {
				for (final PricingContext toAdd : pricingContexts) {
					this.pricingContext.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("pricingContext")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("pricingContext")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setPricingContext(List<? extends PricingContext> pricingContexts) {
			if (pricingContexts == null) {
				this.pricingContext = new ArrayList<>();
			} else {
				this.pricingContext = pricingContexts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("largeSizeTrade")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setLargeSizeTrade(Boolean _largeSizeTrade) {
			this.largeSizeTrade = _largeSizeTrade == null ? null : _largeSizeTrade;
			return this;
		}
		
		@RosettaAttribute("blockTradeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("blockTradeIndicator")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setBlockTradeIndicator(Boolean _blockTradeIndicator) {
			this.blockTradeIndicator = _blockTradeIndicator == null ? null : _blockTradeIndicator;
			return this;
		}
		
		@RosettaAttribute("executionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionType")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setExecutionType(ExecutionType _executionType) {
			this.executionType = _executionType == null ? null : _executionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueType")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setExecutionVenueType(ExecutionVenueType _executionVenueType) {
			this.executionVenueType = _executionVenueType == null ? null : _executionVenueType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("verificationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("verificationMethod")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setVerificationMethod(VerificationMethod _verificationMethod) {
			this.verificationMethod = _verificationMethod == null ? null : _verificationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationMethod")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setConfirmationMethod(ConfirmationMethod _confirmationMethod) {
			this.confirmationMethod = _confirmationMethod == null ? null : _confirmationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("compressedTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compressedTrade")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setCompressedTrade(Boolean _compressedTrade) {
			this.compressedTrade = _compressedTrade == null ? null : _compressedTrade;
			return this;
		}
		
		@RosettaAttribute("isSecuritiesFinancing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isSecuritiesFinancing")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setIsSecuritiesFinancing(Boolean _isSecuritiesFinancing) {
			this.isSecuritiesFinancing = _isSecuritiesFinancing == null ? null : _isSecuritiesFinancing;
			return this;
		}
		
		@RosettaAttribute("otcClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otcClassification")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addOtcClassification(OtcClassification _otcClassification) {
			if (_otcClassification != null) {
				this.otcClassification.add(_otcClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addOtcClassification(OtcClassification _otcClassification, int idx) {
			getIndex(this.otcClassification, idx, () -> _otcClassification.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addOtcClassification(List<? extends OtcClassification> otcClassifications) {
			if (otcClassifications != null) {
				for (final OtcClassification toAdd : otcClassifications) {
					this.otcClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("otcClassification")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otcClassification")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setOtcClassification(List<? extends OtcClassification> otcClassifications) {
			if (otcClassifications == null) {
				this.otcClassification = new ArrayList<>();
			} else {
				this.otcClassification = otcClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradingWaiver")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradingWaiver")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addTradingWaiver(TradingWaiver _tradingWaiver) {
			if (_tradingWaiver != null) {
				this.tradingWaiver.add(_tradingWaiver.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addTradingWaiver(TradingWaiver _tradingWaiver, int idx) {
			getIndex(this.tradingWaiver, idx, () -> _tradingWaiver.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addTradingWaiver(List<? extends TradingWaiver> tradingWaivers) {
			if (tradingWaivers != null) {
				for (final TradingWaiver toAdd : tradingWaivers) {
					this.tradingWaiver.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradingWaiver")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradingWaiver")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setTradingWaiver(List<? extends TradingWaiver> tradingWaivers) {
			if (tradingWaivers == null) {
				this.tradingWaiver = new ArrayList<>();
			} else {
				this.tradingWaiver = tradingWaivers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("shortSale")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shortSale")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setShortSale(ShortSale _shortSale) {
			this.shortSale = _shortSale == null ? null : _shortSale.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isCommodityHedge")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCommodityHedge")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setIsCommodityHedge(Boolean _isCommodityHedge) {
			this.isCommodityHedge = _isCommodityHedge == null ? null : _isCommodityHedge;
			return this;
		}
		
		@RosettaAttribute("isDisputed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isDisputed")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setIsDisputed(Boolean _isDisputed) {
			this.isDisputed = _isDisputed == null ? null : _isDisputed;
			return this;
		}
		
		@RosettaAttribute("unit")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("unit")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addUnit(Unit _unit) {
			if (_unit != null) {
				this.unit.add(_unit.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addUnit(Unit _unit, int idx) {
			getIndex(this.unit, idx, () -> _unit.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addUnit(List<? extends Unit> units) {
			if (units != null) {
				for (final Unit toAdd : units) {
					this.unit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("unit")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("unit")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setUnit(List<? extends Unit> units) {
			if (units == null) {
				this.unit = new ArrayList<>();
			} else {
				this.unit = units.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("trader")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("trader")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addTrader(Trader _trader) {
			if (_trader != null) {
				this.trader.add(_trader.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addTrader(Trader _trader, int idx) {
			getIndex(this.trader, idx, () -> _trader.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addTrader(List<? extends Trader> traders) {
			if (traders != null) {
				for (final Trader toAdd : traders) {
					this.trader.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("trader")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("trader")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder setTrader(List<? extends Trader> traders) {
			if (traders == null) {
				this.trader = new ArrayList<>();
			} else {
				this.trader = traders.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation build() {
			return new PartyTradeInformation.PartyTradeInformationImpl(this);
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			relatedBusinessUnit = relatedBusinessUnit.stream().filter(b->b!=null).<RelatedBusinessUnit.RelatedBusinessUnitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			relatedPerson = relatedPerson.stream().filter(b->b!=null).<RelatedPerson.RelatedPersonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			algorithm = algorithm.stream().filter(b->b!=null).<Algorithm.AlgorithmBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			category = category.stream().filter(b->b!=null).<TradeCategory.TradeCategoryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (executionDateTime!=null && !executionDateTime.prune().hasData()) executionDateTime = null;
			if (timestamps!=null && !timestamps.prune().hasData()) timestamps = null;
			if (allocationStatus!=null && !allocationStatus.prune().hasData()) allocationStatus = null;
			if (clearingStatus!=null && !clearingStatus.prune().hasData()) clearingStatus = null;
			if (collateralizationType!=null && !collateralizationType.prune().hasData()) collateralizationType = null;
			if (collateralPortfolio!=null && !collateralPortfolio.prune().hasData()) collateralPortfolio = null;
			if (collateralPortfolioInitialMargin!=null && !collateralPortfolioInitialMargin.prune().hasData()) collateralPortfolioInitialMargin = null;
			if (collateralPortfolioVariationMargin!=null && !collateralPortfolioVariationMargin.prune().hasData()) collateralPortfolioVariationMargin = null;
			reportingRegime = reportingRegime.stream().filter(b->b!=null).<ReportingRegime.ReportingRegimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			endUserExceptionReason = endUserExceptionReason.stream().filter(b->b!=null).<ClearingExceptionReason.ClearingExceptionReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (endUserExceptionDeclaration!=null && !endUserExceptionDeclaration.prune().hasData()) endUserExceptionDeclaration = null;
			pricingContext = pricingContext.stream().filter(b->b!=null).<PricingContext.PricingContextBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (executionType!=null && !executionType.prune().hasData()) executionType = null;
			if (executionVenueType!=null && !executionVenueType.prune().hasData()) executionVenueType = null;
			if (verificationMethod!=null && !verificationMethod.prune().hasData()) verificationMethod = null;
			if (confirmationMethod!=null && !confirmationMethod.prune().hasData()) confirmationMethod = null;
			otcClassification = otcClassification.stream().filter(b->b!=null).<OtcClassification.OtcClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradingWaiver = tradingWaiver.stream().filter(b->b!=null).<TradingWaiver.TradingWaiverBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (shortSale!=null && !shortSale.prune().hasData()) shortSale = null;
			unit = unit.stream().filter(b->b!=null).<Unit.UnitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			trader = trader.stream().filter(b->b!=null).<Trader.TraderBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getRelatedBusinessUnit()!=null && getRelatedBusinessUnit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRelatedPerson()!=null && getRelatedPerson().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAlgorithm()!=null && getAlgorithm().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIsAccountingHedge()!=null) return true;
			if (getCategory()!=null && getCategory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExecutionDateTime()!=null && getExecutionDateTime().hasData()) return true;
			if (getTimestamps()!=null && getTimestamps().hasData()) return true;
			if (getIntentToAllocate()!=null) return true;
			if (getAllocationStatus()!=null && getAllocationStatus().hasData()) return true;
			if (getIntentToClear()!=null) return true;
			if (getClearingStatus()!=null && getClearingStatus().hasData()) return true;
			if (getCollateralizationType()!=null && getCollateralizationType().hasData()) return true;
			if (getCollateralPortfolio()!=null && getCollateralPortfolio().hasData()) return true;
			if (getCollateralPortfolioInitialMargin()!=null && getCollateralPortfolioInitialMargin().hasData()) return true;
			if (getCollateralPortfolioVariationMargin()!=null && getCollateralPortfolioVariationMargin().hasData()) return true;
			if (getReportingRegime()!=null && getReportingRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEndUserException()!=null) return true;
			if (getEndUserExceptionReason()!=null && getEndUserExceptionReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEndUserExceptionDeclaration()!=null && getEndUserExceptionDeclaration().hasData()) return true;
			if (getNonStandardTerms()!=null) return true;
			if (getOffMarketPrice()!=null) return true;
			if (getPricingContext()!=null && getPricingContext().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLargeSizeTrade()!=null) return true;
			if (getBlockTradeIndicator()!=null) return true;
			if (getExecutionType()!=null && getExecutionType().hasData()) return true;
			if (getExecutionVenueType()!=null && getExecutionVenueType().hasData()) return true;
			if (getVerificationMethod()!=null && getVerificationMethod().hasData()) return true;
			if (getConfirmationMethod()!=null && getConfirmationMethod().hasData()) return true;
			if (getCompressedTrade()!=null) return true;
			if (getIsSecuritiesFinancing()!=null) return true;
			if (getOtcClassification()!=null && getOtcClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradingWaiver()!=null && getTradingWaiver().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getShortSale()!=null && getShortSale().hasData()) return true;
			if (getIsCommodityHedge()!=null) return true;
			if (getIsDisputed()!=null) return true;
			if (getUnit()!=null && getUnit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTrader()!=null && getTrader().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyTradeInformation.PartyTradeInformationBuilder o = (PartyTradeInformation.PartyTradeInformationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getRelatedBusinessUnit(), o.getRelatedBusinessUnit(), this::getOrCreateRelatedBusinessUnit);
			merger.mergeRosetta(getRelatedPerson(), o.getRelatedPerson(), this::getOrCreateRelatedPerson);
			merger.mergeRosetta(getAlgorithm(), o.getAlgorithm(), this::getOrCreateAlgorithm);
			merger.mergeRosetta(getCategory(), o.getCategory(), this::getOrCreateCategory);
			merger.mergeRosetta(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			merger.mergeRosetta(getTimestamps(), o.getTimestamps(), this::setTimestamps);
			merger.mergeRosetta(getAllocationStatus(), o.getAllocationStatus(), this::setAllocationStatus);
			merger.mergeRosetta(getClearingStatus(), o.getClearingStatus(), this::setClearingStatus);
			merger.mergeRosetta(getCollateralizationType(), o.getCollateralizationType(), this::setCollateralizationType);
			merger.mergeRosetta(getCollateralPortfolio(), o.getCollateralPortfolio(), this::setCollateralPortfolio);
			merger.mergeRosetta(getCollateralPortfolioInitialMargin(), o.getCollateralPortfolioInitialMargin(), this::setCollateralPortfolioInitialMargin);
			merger.mergeRosetta(getCollateralPortfolioVariationMargin(), o.getCollateralPortfolioVariationMargin(), this::setCollateralPortfolioVariationMargin);
			merger.mergeRosetta(getReportingRegime(), o.getReportingRegime(), this::getOrCreateReportingRegime);
			merger.mergeRosetta(getEndUserExceptionReason(), o.getEndUserExceptionReason(), this::getOrCreateEndUserExceptionReason);
			merger.mergeRosetta(getEndUserExceptionDeclaration(), o.getEndUserExceptionDeclaration(), this::setEndUserExceptionDeclaration);
			merger.mergeRosetta(getPricingContext(), o.getPricingContext(), this::getOrCreatePricingContext);
			merger.mergeRosetta(getExecutionType(), o.getExecutionType(), this::setExecutionType);
			merger.mergeRosetta(getExecutionVenueType(), o.getExecutionVenueType(), this::setExecutionVenueType);
			merger.mergeRosetta(getVerificationMethod(), o.getVerificationMethod(), this::setVerificationMethod);
			merger.mergeRosetta(getConfirmationMethod(), o.getConfirmationMethod(), this::setConfirmationMethod);
			merger.mergeRosetta(getOtcClassification(), o.getOtcClassification(), this::getOrCreateOtcClassification);
			merger.mergeRosetta(getTradingWaiver(), o.getTradingWaiver(), this::getOrCreateTradingWaiver);
			merger.mergeRosetta(getShortSale(), o.getShortSale(), this::setShortSale);
			merger.mergeRosetta(getUnit(), o.getUnit(), this::getOrCreateUnit);
			merger.mergeRosetta(getTrader(), o.getTrader(), this::getOrCreateTrader);
			
			merger.mergeBasic(getIsAccountingHedge(), o.getIsAccountingHedge(), this::setIsAccountingHedge);
			merger.mergeBasic(getIntentToAllocate(), o.getIntentToAllocate(), this::setIntentToAllocate);
			merger.mergeBasic(getIntentToClear(), o.getIntentToClear(), this::setIntentToClear);
			merger.mergeBasic(getEndUserException(), o.getEndUserException(), this::setEndUserException);
			merger.mergeBasic(getNonStandardTerms(), o.getNonStandardTerms(), this::setNonStandardTerms);
			merger.mergeBasic(getOffMarketPrice(), o.getOffMarketPrice(), this::setOffMarketPrice);
			merger.mergeBasic(getLargeSizeTrade(), o.getLargeSizeTrade(), this::setLargeSizeTrade);
			merger.mergeBasic(getBlockTradeIndicator(), o.getBlockTradeIndicator(), this::setBlockTradeIndicator);
			merger.mergeBasic(getCompressedTrade(), o.getCompressedTrade(), this::setCompressedTrade);
			merger.mergeBasic(getIsSecuritiesFinancing(), o.getIsSecuritiesFinancing(), this::setIsSecuritiesFinancing);
			merger.mergeBasic(getIsCommodityHedge(), o.getIsCommodityHedge(), this::setIsCommodityHedge);
			merger.mergeBasic(getIsDisputed(), o.getIsDisputed(), this::setIsDisputed);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(relatedBusinessUnit, _that.getRelatedBusinessUnit())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!ListEquals.listEquals(algorithm, _that.getAlgorithm())) return false;
			if (!Objects.equals(isAccountingHedge, _that.getIsAccountingHedge())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(timestamps, _that.getTimestamps())) return false;
			if (!Objects.equals(intentToAllocate, _that.getIntentToAllocate())) return false;
			if (!Objects.equals(allocationStatus, _that.getAllocationStatus())) return false;
			if (!Objects.equals(intentToClear, _that.getIntentToClear())) return false;
			if (!Objects.equals(clearingStatus, _that.getClearingStatus())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(collateralPortfolio, _that.getCollateralPortfolio())) return false;
			if (!Objects.equals(collateralPortfolioInitialMargin, _that.getCollateralPortfolioInitialMargin())) return false;
			if (!Objects.equals(collateralPortfolioVariationMargin, _that.getCollateralPortfolioVariationMargin())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!ListEquals.listEquals(endUserExceptionReason, _that.getEndUserExceptionReason())) return false;
			if (!Objects.equals(endUserExceptionDeclaration, _that.getEndUserExceptionDeclaration())) return false;
			if (!Objects.equals(nonStandardTerms, _that.getNonStandardTerms())) return false;
			if (!Objects.equals(offMarketPrice, _that.getOffMarketPrice())) return false;
			if (!ListEquals.listEquals(pricingContext, _that.getPricingContext())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(blockTradeIndicator, _that.getBlockTradeIndicator())) return false;
			if (!Objects.equals(executionType, _that.getExecutionType())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(verificationMethod, _that.getVerificationMethod())) return false;
			if (!Objects.equals(confirmationMethod, _that.getConfirmationMethod())) return false;
			if (!Objects.equals(compressedTrade, _that.getCompressedTrade())) return false;
			if (!Objects.equals(isSecuritiesFinancing, _that.getIsSecuritiesFinancing())) return false;
			if (!ListEquals.listEquals(otcClassification, _that.getOtcClassification())) return false;
			if (!ListEquals.listEquals(tradingWaiver, _that.getTradingWaiver())) return false;
			if (!Objects.equals(shortSale, _that.getShortSale())) return false;
			if (!Objects.equals(isCommodityHedge, _that.getIsCommodityHedge())) return false;
			if (!Objects.equals(isDisputed, _that.getIsDisputed())) return false;
			if (!ListEquals.listEquals(unit, _that.getUnit())) return false;
			if (!ListEquals.listEquals(trader, _that.getTrader())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (relatedBusinessUnit != null ? relatedBusinessUnit.hashCode() : 0);
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (isAccountingHedge != null ? isAccountingHedge.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (timestamps != null ? timestamps.hashCode() : 0);
			_result = 31 * _result + (intentToAllocate != null ? intentToAllocate.hashCode() : 0);
			_result = 31 * _result + (allocationStatus != null ? allocationStatus.hashCode() : 0);
			_result = 31 * _result + (intentToClear != null ? intentToClear.hashCode() : 0);
			_result = 31 * _result + (clearingStatus != null ? clearingStatus.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolio != null ? collateralPortfolio.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioInitialMargin != null ? collateralPortfolioInitialMargin.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioVariationMargin != null ? collateralPortfolioVariationMargin.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionReason != null ? endUserExceptionReason.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionDeclaration != null ? endUserExceptionDeclaration.hashCode() : 0);
			_result = 31 * _result + (nonStandardTerms != null ? nonStandardTerms.hashCode() : 0);
			_result = 31 * _result + (offMarketPrice != null ? offMarketPrice.hashCode() : 0);
			_result = 31 * _result + (pricingContext != null ? pricingContext.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (blockTradeIndicator != null ? blockTradeIndicator.hashCode() : 0);
			_result = 31 * _result + (executionType != null ? executionType.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (verificationMethod != null ? verificationMethod.hashCode() : 0);
			_result = 31 * _result + (confirmationMethod != null ? confirmationMethod.hashCode() : 0);
			_result = 31 * _result + (compressedTrade != null ? compressedTrade.hashCode() : 0);
			_result = 31 * _result + (isSecuritiesFinancing != null ? isSecuritiesFinancing.hashCode() : 0);
			_result = 31 * _result + (otcClassification != null ? otcClassification.hashCode() : 0);
			_result = 31 * _result + (tradingWaiver != null ? tradingWaiver.hashCode() : 0);
			_result = 31 * _result + (shortSale != null ? shortSale.hashCode() : 0);
			_result = 31 * _result + (isCommodityHedge != null ? isCommodityHedge.hashCode() : 0);
			_result = 31 * _result + (isDisputed != null ? isDisputed.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (trader != null ? trader.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeInformationBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"relatedBusinessUnit=" + this.relatedBusinessUnit + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"algorithm=" + this.algorithm + ", " +
				"isAccountingHedge=" + this.isAccountingHedge + ", " +
				"category=" + this.category + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"timestamps=" + this.timestamps + ", " +
				"intentToAllocate=" + this.intentToAllocate + ", " +
				"allocationStatus=" + this.allocationStatus + ", " +
				"intentToClear=" + this.intentToClear + ", " +
				"clearingStatus=" + this.clearingStatus + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"collateralPortfolio=" + this.collateralPortfolio + ", " +
				"collateralPortfolioInitialMargin=" + this.collateralPortfolioInitialMargin + ", " +
				"collateralPortfolioVariationMargin=" + this.collateralPortfolioVariationMargin + ", " +
				"reportingRegime=" + this.reportingRegime + ", " +
				"endUserException=" + this.endUserException + ", " +
				"endUserExceptionReason=" + this.endUserExceptionReason + ", " +
				"endUserExceptionDeclaration=" + this.endUserExceptionDeclaration + ", " +
				"nonStandardTerms=" + this.nonStandardTerms + ", " +
				"offMarketPrice=" + this.offMarketPrice + ", " +
				"pricingContext=" + this.pricingContext + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"blockTradeIndicator=" + this.blockTradeIndicator + ", " +
				"executionType=" + this.executionType + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"verificationMethod=" + this.verificationMethod + ", " +
				"confirmationMethod=" + this.confirmationMethod + ", " +
				"compressedTrade=" + this.compressedTrade + ", " +
				"isSecuritiesFinancing=" + this.isSecuritiesFinancing + ", " +
				"otcClassification=" + this.otcClassification + ", " +
				"tradingWaiver=" + this.tradingWaiver + ", " +
				"shortSale=" + this.shortSale + ", " +
				"isCommodityHedge=" + this.isCommodityHedge + ", " +
				"isDisputed=" + this.isDisputed + ", " +
				"unit=" + this.unit + ", " +
				"trader=" + this.trader +
			'}';
		}
	}
}
