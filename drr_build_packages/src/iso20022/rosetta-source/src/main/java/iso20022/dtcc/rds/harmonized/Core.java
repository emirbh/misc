package iso20022.dtcc.rds.harmonized;

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
import iso20022.dtcc.rds.harmonized.meta.CoreMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Core", builder=Core.CoreBuilderImpl.class, version="${project.version}")
@RuneDataType(value="Core", model="iso20022", builder=Core.CoreBuilderImpl.class, version="${project.version}")
public interface Core extends RosettaModelObject {

	CoreMeta metaData = new CoreMeta();

	/*********************** Getter Methods  ***********************/
	String getTradeLegTypes();
	ZonedDateTime getLatestExecutionDatetime();
	String getMessageId();
	String getMessageType();
	String getPrimaryAssetClass();
	String getProductId();
	String getProductIdType();
	String getSubmittedForParty();
	String getSubmittingPartyId();
	String getSubmittingPartyIdType();
	String getTradeParty1Id();
	String getTradeParty1IdType();
	List<String> getTradeParty1ReportingDestination();
	String getTradeParty1TransactionId();
	String getTradeParty2Id();
	String getTradeParty2IdType();
	List<String> getTradeParty2ReportingDestination();
	String getTradeParty2TransactionId();
	String getTransactionType();
	String getUsiId();
	String getUsiIdPrefix();
	String getUtiId();
	String getUtiIdPrefix();
	String getLifecycleEventType();
	String getTradeParty1ExecutionAgentId();
	String getTradeParty1ExecutionAgentIdType();
	String getTradeParty2ExecutionAgentId();
	String getTradeParty2ExecutionAgentIdType();
	List<String> getTradeParty1ThirdPartyViewerId();
	List<String> getTradeParty2ThirdPartyViewerId();
	List<String> getTradeParty1ThirdPartyViewerIdType();
	List<String> getTradeParty2ThirdPartyViewerIdType();
	ZonedDateTime getReportingTimestamp();
	String getAiParty1Id();
	String getAiParty1IdType();
	String getAiParty2Id();
	String getAiParty2IdType();
	String getTradeParty1RegulatoryActionType1();
	String getTradeParty2RegulatoryActionType1();
	String getNoaActionType();
	String getNoaEventType();
	String getInitialMarginCollateralPortfolioCode();
	String getVariationMarginCollateralPortfolioCode();
	String getCorporateActionNewTradeParty1Lei();
	String getUpi();

	/*********************** Build Methods  ***********************/
	Core build();
	
	Core.CoreBuilder toBuilder();
	
	static Core.CoreBuilder builder() {
		return new Core.CoreBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Core> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Core> getType() {
		return Core.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tradeLegTypes"), String.class, getTradeLegTypes(), this);
		processor.processBasic(path.newSubPath("latestExecutionDatetime"), ZonedDateTime.class, getLatestExecutionDatetime(), this);
		processor.processBasic(path.newSubPath("messageId"), String.class, getMessageId(), this);
		processor.processBasic(path.newSubPath("messageType"), String.class, getMessageType(), this);
		processor.processBasic(path.newSubPath("primaryAssetClass"), String.class, getPrimaryAssetClass(), this);
		processor.processBasic(path.newSubPath("productId"), String.class, getProductId(), this);
		processor.processBasic(path.newSubPath("productIdType"), String.class, getProductIdType(), this);
		processor.processBasic(path.newSubPath("submittedForParty"), String.class, getSubmittedForParty(), this);
		processor.processBasic(path.newSubPath("submittingPartyId"), String.class, getSubmittingPartyId(), this);
		processor.processBasic(path.newSubPath("submittingPartyIdType"), String.class, getSubmittingPartyIdType(), this);
		processor.processBasic(path.newSubPath("tradeParty1Id"), String.class, getTradeParty1Id(), this);
		processor.processBasic(path.newSubPath("tradeParty1IdType"), String.class, getTradeParty1IdType(), this);
		processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), String.class, getTradeParty1ReportingDestination(), this);
		processor.processBasic(path.newSubPath("tradeParty1TransactionId"), String.class, getTradeParty1TransactionId(), this);
		processor.processBasic(path.newSubPath("tradeParty2Id"), String.class, getTradeParty2Id(), this);
		processor.processBasic(path.newSubPath("tradeParty2IdType"), String.class, getTradeParty2IdType(), this);
		processor.processBasic(path.newSubPath("tradeParty2ReportingDestination"), String.class, getTradeParty2ReportingDestination(), this);
		processor.processBasic(path.newSubPath("tradeParty2TransactionId"), String.class, getTradeParty2TransactionId(), this);
		processor.processBasic(path.newSubPath("transactionType"), String.class, getTransactionType(), this);
		processor.processBasic(path.newSubPath("usiId"), String.class, getUsiId(), this);
		processor.processBasic(path.newSubPath("usiIdPrefix"), String.class, getUsiIdPrefix(), this);
		processor.processBasic(path.newSubPath("utiId"), String.class, getUtiId(), this);
		processor.processBasic(path.newSubPath("utiIdPrefix"), String.class, getUtiIdPrefix(), this);
		processor.processBasic(path.newSubPath("lifecycleEventType"), String.class, getLifecycleEventType(), this);
		processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentId"), String.class, getTradeParty1ExecutionAgentId(), this);
		processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentIdType"), String.class, getTradeParty1ExecutionAgentIdType(), this);
		processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentId"), String.class, getTradeParty2ExecutionAgentId(), this);
		processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentIdType"), String.class, getTradeParty2ExecutionAgentIdType(), this);
		processor.processBasic(path.newSubPath("tradeParty1ThirdPartyViewerId"), String.class, getTradeParty1ThirdPartyViewerId(), this);
		processor.processBasic(path.newSubPath("tradeParty2ThirdPartyViewerId"), String.class, getTradeParty2ThirdPartyViewerId(), this);
		processor.processBasic(path.newSubPath("tradeParty1ThirdPartyViewerIdType"), String.class, getTradeParty1ThirdPartyViewerIdType(), this);
		processor.processBasic(path.newSubPath("tradeParty2ThirdPartyViewerIdType"), String.class, getTradeParty2ThirdPartyViewerIdType(), this);
		processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
		processor.processBasic(path.newSubPath("aiParty1Id"), String.class, getAiParty1Id(), this);
		processor.processBasic(path.newSubPath("aiParty1IdType"), String.class, getAiParty1IdType(), this);
		processor.processBasic(path.newSubPath("aiParty2Id"), String.class, getAiParty2Id(), this);
		processor.processBasic(path.newSubPath("aiParty2IdType"), String.class, getAiParty2IdType(), this);
		processor.processBasic(path.newSubPath("tradeParty1RegulatoryActionType1"), String.class, getTradeParty1RegulatoryActionType1(), this);
		processor.processBasic(path.newSubPath("tradeParty2RegulatoryActionType1"), String.class, getTradeParty2RegulatoryActionType1(), this);
		processor.processBasic(path.newSubPath("noaActionType"), String.class, getNoaActionType(), this);
		processor.processBasic(path.newSubPath("noaEventType"), String.class, getNoaEventType(), this);
		processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("corporateActionNewTradeParty1Lei"), String.class, getCorporateActionNewTradeParty1Lei(), this);
		processor.processBasic(path.newSubPath("upi"), String.class, getUpi(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoreBuilder extends Core, RosettaModelObjectBuilder {
		Core.CoreBuilder setTradeLegTypes(String tradeLegTypes);
		Core.CoreBuilder setLatestExecutionDatetime(ZonedDateTime latestExecutionDatetime);
		Core.CoreBuilder setMessageId(String messageId);
		Core.CoreBuilder setMessageType(String messageType);
		Core.CoreBuilder setPrimaryAssetClass(String primaryAssetClass);
		Core.CoreBuilder setProductId(String productId);
		Core.CoreBuilder setProductIdType(String productIdType);
		Core.CoreBuilder setSubmittedForParty(String submittedForParty);
		Core.CoreBuilder setSubmittingPartyId(String submittingPartyId);
		Core.CoreBuilder setSubmittingPartyIdType(String submittingPartyIdType);
		Core.CoreBuilder setTradeParty1Id(String tradeParty1Id);
		Core.CoreBuilder setTradeParty1IdType(String tradeParty1IdType);
		Core.CoreBuilder addTradeParty1ReportingDestination(String tradeParty1ReportingDestination);
		Core.CoreBuilder addTradeParty1ReportingDestination(String tradeParty1ReportingDestination, int idx);
		Core.CoreBuilder addTradeParty1ReportingDestination(List<String> tradeParty1ReportingDestination);
		Core.CoreBuilder setTradeParty1ReportingDestination(List<String> tradeParty1ReportingDestination);
		Core.CoreBuilder setTradeParty1TransactionId(String tradeParty1TransactionId);
		Core.CoreBuilder setTradeParty2Id(String tradeParty2Id);
		Core.CoreBuilder setTradeParty2IdType(String tradeParty2IdType);
		Core.CoreBuilder addTradeParty2ReportingDestination(String tradeParty2ReportingDestination);
		Core.CoreBuilder addTradeParty2ReportingDestination(String tradeParty2ReportingDestination, int idx);
		Core.CoreBuilder addTradeParty2ReportingDestination(List<String> tradeParty2ReportingDestination);
		Core.CoreBuilder setTradeParty2ReportingDestination(List<String> tradeParty2ReportingDestination);
		Core.CoreBuilder setTradeParty2TransactionId(String tradeParty2TransactionId);
		Core.CoreBuilder setTransactionType(String transactionType);
		Core.CoreBuilder setUsiId(String usiId);
		Core.CoreBuilder setUsiIdPrefix(String usiIdPrefix);
		Core.CoreBuilder setUtiId(String utiId);
		Core.CoreBuilder setUtiIdPrefix(String utiIdPrefix);
		Core.CoreBuilder setLifecycleEventType(String lifecycleEventType);
		Core.CoreBuilder setTradeParty1ExecutionAgentId(String tradeParty1ExecutionAgentId);
		Core.CoreBuilder setTradeParty1ExecutionAgentIdType(String tradeParty1ExecutionAgentIdType);
		Core.CoreBuilder setTradeParty2ExecutionAgentId(String tradeParty2ExecutionAgentId);
		Core.CoreBuilder setTradeParty2ExecutionAgentIdType(String tradeParty2ExecutionAgentIdType);
		Core.CoreBuilder addTradeParty1ThirdPartyViewerId(String tradeParty1ThirdPartyViewerId);
		Core.CoreBuilder addTradeParty1ThirdPartyViewerId(String tradeParty1ThirdPartyViewerId, int idx);
		Core.CoreBuilder addTradeParty1ThirdPartyViewerId(List<String> tradeParty1ThirdPartyViewerId);
		Core.CoreBuilder setTradeParty1ThirdPartyViewerId(List<String> tradeParty1ThirdPartyViewerId);
		Core.CoreBuilder addTradeParty2ThirdPartyViewerId(String tradeParty2ThirdPartyViewerId);
		Core.CoreBuilder addTradeParty2ThirdPartyViewerId(String tradeParty2ThirdPartyViewerId, int idx);
		Core.CoreBuilder addTradeParty2ThirdPartyViewerId(List<String> tradeParty2ThirdPartyViewerId);
		Core.CoreBuilder setTradeParty2ThirdPartyViewerId(List<String> tradeParty2ThirdPartyViewerId);
		Core.CoreBuilder addTradeParty1ThirdPartyViewerIdType(String tradeParty1ThirdPartyViewerIdType);
		Core.CoreBuilder addTradeParty1ThirdPartyViewerIdType(String tradeParty1ThirdPartyViewerIdType, int idx);
		Core.CoreBuilder addTradeParty1ThirdPartyViewerIdType(List<String> tradeParty1ThirdPartyViewerIdType);
		Core.CoreBuilder setTradeParty1ThirdPartyViewerIdType(List<String> tradeParty1ThirdPartyViewerIdType);
		Core.CoreBuilder addTradeParty2ThirdPartyViewerIdType(String tradeParty2ThirdPartyViewerIdType);
		Core.CoreBuilder addTradeParty2ThirdPartyViewerIdType(String tradeParty2ThirdPartyViewerIdType, int idx);
		Core.CoreBuilder addTradeParty2ThirdPartyViewerIdType(List<String> tradeParty2ThirdPartyViewerIdType);
		Core.CoreBuilder setTradeParty2ThirdPartyViewerIdType(List<String> tradeParty2ThirdPartyViewerIdType);
		Core.CoreBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		Core.CoreBuilder setAiParty1Id(String aiParty1Id);
		Core.CoreBuilder setAiParty1IdType(String aiParty1IdType);
		Core.CoreBuilder setAiParty2Id(String aiParty2Id);
		Core.CoreBuilder setAiParty2IdType(String aiParty2IdType);
		Core.CoreBuilder setTradeParty1RegulatoryActionType1(String tradeParty1RegulatoryActionType1);
		Core.CoreBuilder setTradeParty2RegulatoryActionType1(String tradeParty2RegulatoryActionType1);
		Core.CoreBuilder setNoaActionType(String noaActionType);
		Core.CoreBuilder setNoaEventType(String noaEventType);
		Core.CoreBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		Core.CoreBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		Core.CoreBuilder setCorporateActionNewTradeParty1Lei(String corporateActionNewTradeParty1Lei);
		Core.CoreBuilder setUpi(String upi);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tradeLegTypes"), String.class, getTradeLegTypes(), this);
			processor.processBasic(path.newSubPath("latestExecutionDatetime"), ZonedDateTime.class, getLatestExecutionDatetime(), this);
			processor.processBasic(path.newSubPath("messageId"), String.class, getMessageId(), this);
			processor.processBasic(path.newSubPath("messageType"), String.class, getMessageType(), this);
			processor.processBasic(path.newSubPath("primaryAssetClass"), String.class, getPrimaryAssetClass(), this);
			processor.processBasic(path.newSubPath("productId"), String.class, getProductId(), this);
			processor.processBasic(path.newSubPath("productIdType"), String.class, getProductIdType(), this);
			processor.processBasic(path.newSubPath("submittedForParty"), String.class, getSubmittedForParty(), this);
			processor.processBasic(path.newSubPath("submittingPartyId"), String.class, getSubmittingPartyId(), this);
			processor.processBasic(path.newSubPath("submittingPartyIdType"), String.class, getSubmittingPartyIdType(), this);
			processor.processBasic(path.newSubPath("tradeParty1Id"), String.class, getTradeParty1Id(), this);
			processor.processBasic(path.newSubPath("tradeParty1IdType"), String.class, getTradeParty1IdType(), this);
			processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), String.class, getTradeParty1ReportingDestination(), this);
			processor.processBasic(path.newSubPath("tradeParty1TransactionId"), String.class, getTradeParty1TransactionId(), this);
			processor.processBasic(path.newSubPath("tradeParty2Id"), String.class, getTradeParty2Id(), this);
			processor.processBasic(path.newSubPath("tradeParty2IdType"), String.class, getTradeParty2IdType(), this);
			processor.processBasic(path.newSubPath("tradeParty2ReportingDestination"), String.class, getTradeParty2ReportingDestination(), this);
			processor.processBasic(path.newSubPath("tradeParty2TransactionId"), String.class, getTradeParty2TransactionId(), this);
			processor.processBasic(path.newSubPath("transactionType"), String.class, getTransactionType(), this);
			processor.processBasic(path.newSubPath("usiId"), String.class, getUsiId(), this);
			processor.processBasic(path.newSubPath("usiIdPrefix"), String.class, getUsiIdPrefix(), this);
			processor.processBasic(path.newSubPath("utiId"), String.class, getUtiId(), this);
			processor.processBasic(path.newSubPath("utiIdPrefix"), String.class, getUtiIdPrefix(), this);
			processor.processBasic(path.newSubPath("lifecycleEventType"), String.class, getLifecycleEventType(), this);
			processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentId"), String.class, getTradeParty1ExecutionAgentId(), this);
			processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentIdType"), String.class, getTradeParty1ExecutionAgentIdType(), this);
			processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentId"), String.class, getTradeParty2ExecutionAgentId(), this);
			processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentIdType"), String.class, getTradeParty2ExecutionAgentIdType(), this);
			processor.processBasic(path.newSubPath("tradeParty1ThirdPartyViewerId"), String.class, getTradeParty1ThirdPartyViewerId(), this);
			processor.processBasic(path.newSubPath("tradeParty2ThirdPartyViewerId"), String.class, getTradeParty2ThirdPartyViewerId(), this);
			processor.processBasic(path.newSubPath("tradeParty1ThirdPartyViewerIdType"), String.class, getTradeParty1ThirdPartyViewerIdType(), this);
			processor.processBasic(path.newSubPath("tradeParty2ThirdPartyViewerIdType"), String.class, getTradeParty2ThirdPartyViewerIdType(), this);
			processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
			processor.processBasic(path.newSubPath("aiParty1Id"), String.class, getAiParty1Id(), this);
			processor.processBasic(path.newSubPath("aiParty1IdType"), String.class, getAiParty1IdType(), this);
			processor.processBasic(path.newSubPath("aiParty2Id"), String.class, getAiParty2Id(), this);
			processor.processBasic(path.newSubPath("aiParty2IdType"), String.class, getAiParty2IdType(), this);
			processor.processBasic(path.newSubPath("tradeParty1RegulatoryActionType1"), String.class, getTradeParty1RegulatoryActionType1(), this);
			processor.processBasic(path.newSubPath("tradeParty2RegulatoryActionType1"), String.class, getTradeParty2RegulatoryActionType1(), this);
			processor.processBasic(path.newSubPath("noaActionType"), String.class, getNoaActionType(), this);
			processor.processBasic(path.newSubPath("noaEventType"), String.class, getNoaEventType(), this);
			processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("corporateActionNewTradeParty1Lei"), String.class, getCorporateActionNewTradeParty1Lei(), this);
			processor.processBasic(path.newSubPath("upi"), String.class, getUpi(), this);
		}
		

		Core.CoreBuilder prune();
	}

	/*********************** Immutable Implementation of Core  ***********************/
	class CoreImpl implements Core {
		private final String tradeLegTypes;
		private final ZonedDateTime latestExecutionDatetime;
		private final String messageId;
		private final String messageType;
		private final String primaryAssetClass;
		private final String productId;
		private final String productIdType;
		private final String submittedForParty;
		private final String submittingPartyId;
		private final String submittingPartyIdType;
		private final String tradeParty1Id;
		private final String tradeParty1IdType;
		private final List<String> tradeParty1ReportingDestination;
		private final String tradeParty1TransactionId;
		private final String tradeParty2Id;
		private final String tradeParty2IdType;
		private final List<String> tradeParty2ReportingDestination;
		private final String tradeParty2TransactionId;
		private final String transactionType;
		private final String usiId;
		private final String usiIdPrefix;
		private final String utiId;
		private final String utiIdPrefix;
		private final String lifecycleEventType;
		private final String tradeParty1ExecutionAgentId;
		private final String tradeParty1ExecutionAgentIdType;
		private final String tradeParty2ExecutionAgentId;
		private final String tradeParty2ExecutionAgentIdType;
		private final List<String> tradeParty1ThirdPartyViewerId;
		private final List<String> tradeParty2ThirdPartyViewerId;
		private final List<String> tradeParty1ThirdPartyViewerIdType;
		private final List<String> tradeParty2ThirdPartyViewerIdType;
		private final ZonedDateTime reportingTimestamp;
		private final String aiParty1Id;
		private final String aiParty1IdType;
		private final String aiParty2Id;
		private final String aiParty2IdType;
		private final String tradeParty1RegulatoryActionType1;
		private final String tradeParty2RegulatoryActionType1;
		private final String noaActionType;
		private final String noaEventType;
		private final String initialMarginCollateralPortfolioCode;
		private final String variationMarginCollateralPortfolioCode;
		private final String corporateActionNewTradeParty1Lei;
		private final String upi;
		
		protected CoreImpl(Core.CoreBuilder builder) {
			this.tradeLegTypes = builder.getTradeLegTypes();
			this.latestExecutionDatetime = builder.getLatestExecutionDatetime();
			this.messageId = builder.getMessageId();
			this.messageType = builder.getMessageType();
			this.primaryAssetClass = builder.getPrimaryAssetClass();
			this.productId = builder.getProductId();
			this.productIdType = builder.getProductIdType();
			this.submittedForParty = builder.getSubmittedForParty();
			this.submittingPartyId = builder.getSubmittingPartyId();
			this.submittingPartyIdType = builder.getSubmittingPartyIdType();
			this.tradeParty1Id = builder.getTradeParty1Id();
			this.tradeParty1IdType = builder.getTradeParty1IdType();
			this.tradeParty1ReportingDestination = ofNullable(builder.getTradeParty1ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty1TransactionId = builder.getTradeParty1TransactionId();
			this.tradeParty2Id = builder.getTradeParty2Id();
			this.tradeParty2IdType = builder.getTradeParty2IdType();
			this.tradeParty2ReportingDestination = ofNullable(builder.getTradeParty2ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty2TransactionId = builder.getTradeParty2TransactionId();
			this.transactionType = builder.getTransactionType();
			this.usiId = builder.getUsiId();
			this.usiIdPrefix = builder.getUsiIdPrefix();
			this.utiId = builder.getUtiId();
			this.utiIdPrefix = builder.getUtiIdPrefix();
			this.lifecycleEventType = builder.getLifecycleEventType();
			this.tradeParty1ExecutionAgentId = builder.getTradeParty1ExecutionAgentId();
			this.tradeParty1ExecutionAgentIdType = builder.getTradeParty1ExecutionAgentIdType();
			this.tradeParty2ExecutionAgentId = builder.getTradeParty2ExecutionAgentId();
			this.tradeParty2ExecutionAgentIdType = builder.getTradeParty2ExecutionAgentIdType();
			this.tradeParty1ThirdPartyViewerId = ofNullable(builder.getTradeParty1ThirdPartyViewerId()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty2ThirdPartyViewerId = ofNullable(builder.getTradeParty2ThirdPartyViewerId()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty1ThirdPartyViewerIdType = ofNullable(builder.getTradeParty1ThirdPartyViewerIdType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty2ThirdPartyViewerIdType = ofNullable(builder.getTradeParty2ThirdPartyViewerIdType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingTimestamp = builder.getReportingTimestamp();
			this.aiParty1Id = builder.getAiParty1Id();
			this.aiParty1IdType = builder.getAiParty1IdType();
			this.aiParty2Id = builder.getAiParty2Id();
			this.aiParty2IdType = builder.getAiParty2IdType();
			this.tradeParty1RegulatoryActionType1 = builder.getTradeParty1RegulatoryActionType1();
			this.tradeParty2RegulatoryActionType1 = builder.getTradeParty2RegulatoryActionType1();
			this.noaActionType = builder.getNoaActionType();
			this.noaEventType = builder.getNoaEventType();
			this.initialMarginCollateralPortfolioCode = builder.getInitialMarginCollateralPortfolioCode();
			this.variationMarginCollateralPortfolioCode = builder.getVariationMarginCollateralPortfolioCode();
			this.corporateActionNewTradeParty1Lei = builder.getCorporateActionNewTradeParty1Lei();
			this.upi = builder.getUpi();
		}
		
		@Override
		@RosettaAttribute("tradeLegTypes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeLegTypes")
		public String getTradeLegTypes() {
			return tradeLegTypes;
		}
		
		@Override
		@RosettaAttribute("latestExecutionDatetime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExecutionDatetime")
		public ZonedDateTime getLatestExecutionDatetime() {
			return latestExecutionDatetime;
		}
		
		@Override
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageId")
		public String getMessageId() {
			return messageId;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public String getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("productId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productId")
		public String getProductId() {
			return productId;
		}
		
		@Override
		@RosettaAttribute("productIdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productIdType")
		public String getProductIdType() {
			return productIdType;
		}
		
		@Override
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittedForParty")
		public String getSubmittedForParty() {
			return submittedForParty;
		}
		
		@Override
		@RosettaAttribute("submittingPartyId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittingPartyId")
		public String getSubmittingPartyId() {
			return submittingPartyId;
		}
		
		@Override
		@RosettaAttribute("submittingPartyIdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittingPartyIdType")
		public String getSubmittingPartyIdType() {
			return submittingPartyIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1Id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1Id")
		public String getTradeParty1Id() {
			return tradeParty1Id;
		}
		
		@Override
		@RosettaAttribute("tradeParty1IdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1IdType")
		public String getTradeParty1IdType() {
			return tradeParty1IdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<String> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty1TransactionId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1TransactionId")
		public String getTradeParty1TransactionId() {
			return tradeParty1TransactionId;
		}
		
		@Override
		@RosettaAttribute("tradeParty2Id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2Id")
		public String getTradeParty2Id() {
			return tradeParty2Id;
		}
		
		@Override
		@RosettaAttribute("tradeParty2IdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2IdType")
		public String getTradeParty2IdType() {
			return tradeParty2IdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		public List<String> getTradeParty2ReportingDestination() {
			return tradeParty2ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty2TransactionId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2TransactionId")
		public String getTradeParty2TransactionId() {
			return tradeParty2TransactionId;
		}
		
		@Override
		@RosettaAttribute("transactionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transactionType")
		public String getTransactionType() {
			return transactionType;
		}
		
		@Override
		@RosettaAttribute("usiId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("usiId")
		public String getUsiId() {
			return usiId;
		}
		
		@Override
		@RosettaAttribute("usiIdPrefix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("usiIdPrefix")
		public String getUsiIdPrefix() {
			return usiIdPrefix;
		}
		
		@Override
		@RosettaAttribute("utiId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("utiId")
		public String getUtiId() {
			return utiId;
		}
		
		@Override
		@RosettaAttribute("utiIdPrefix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("utiIdPrefix")
		public String getUtiIdPrefix() {
			return utiIdPrefix;
		}
		
		@Override
		@RosettaAttribute("lifecycleEventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lifecycleEventType")
		public String getLifecycleEventType() {
			return lifecycleEventType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ExecutionAgentId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ExecutionAgentId")
		public String getTradeParty1ExecutionAgentId() {
			return tradeParty1ExecutionAgentId;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ExecutionAgentIdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ExecutionAgentIdType")
		public String getTradeParty1ExecutionAgentIdType() {
			return tradeParty1ExecutionAgentIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ExecutionAgentId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2ExecutionAgentId")
		public String getTradeParty2ExecutionAgentId() {
			return tradeParty2ExecutionAgentId;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ExecutionAgentIdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2ExecutionAgentIdType")
		public String getTradeParty2ExecutionAgentIdType() {
			return tradeParty2ExecutionAgentIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ThirdPartyViewerId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerId")
		public List<String> getTradeParty1ThirdPartyViewerId() {
			return tradeParty1ThirdPartyViewerId;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ThirdPartyViewerId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerId")
		public List<String> getTradeParty2ThirdPartyViewerId() {
			return tradeParty2ThirdPartyViewerId;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ThirdPartyViewerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerIdType")
		public List<String> getTradeParty1ThirdPartyViewerIdType() {
			return tradeParty1ThirdPartyViewerIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ThirdPartyViewerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerIdType")
		public List<String> getTradeParty2ThirdPartyViewerIdType() {
			return tradeParty2ThirdPartyViewerIdType;
		}
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
		}
		
		@Override
		@RosettaAttribute("aiParty1Id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("aiParty1Id")
		public String getAiParty1Id() {
			return aiParty1Id;
		}
		
		@Override
		@RosettaAttribute("aiParty1IdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("aiParty1IdType")
		public String getAiParty1IdType() {
			return aiParty1IdType;
		}
		
		@Override
		@RosettaAttribute("aiParty2Id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("aiParty2Id")
		public String getAiParty2Id() {
			return aiParty2Id;
		}
		
		@Override
		@RosettaAttribute("aiParty2IdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("aiParty2IdType")
		public String getAiParty2IdType() {
			return aiParty2IdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1RegulatoryActionType1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1RegulatoryActionType1")
		public String getTradeParty1RegulatoryActionType1() {
			return tradeParty1RegulatoryActionType1;
		}
		
		@Override
		@RosettaAttribute("tradeParty2RegulatoryActionType1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2RegulatoryActionType1")
		public String getTradeParty2RegulatoryActionType1() {
			return tradeParty2RegulatoryActionType1;
		}
		
		@Override
		@RosettaAttribute("noaActionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noaActionType")
		public String getNoaActionType() {
			return noaActionType;
		}
		
		@Override
		@RosettaAttribute("noaEventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noaEventType")
		public String getNoaEventType() {
			return noaEventType;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		public String getInitialMarginCollateralPortfolioCode() {
			return initialMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		public String getVariationMarginCollateralPortfolioCode() {
			return variationMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("corporateActionNewTradeParty1Lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateActionNewTradeParty1Lei")
		public String getCorporateActionNewTradeParty1Lei() {
			return corporateActionNewTradeParty1Lei;
		}
		
		@Override
		@RosettaAttribute("upi")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upi")
		public String getUpi() {
			return upi;
		}
		
		@Override
		public Core build() {
			return this;
		}
		
		@Override
		public Core.CoreBuilder toBuilder() {
			Core.CoreBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Core.CoreBuilder builder) {
			ofNullable(getTradeLegTypes()).ifPresent(builder::setTradeLegTypes);
			ofNullable(getLatestExecutionDatetime()).ifPresent(builder::setLatestExecutionDatetime);
			ofNullable(getMessageId()).ifPresent(builder::setMessageId);
			ofNullable(getMessageType()).ifPresent(builder::setMessageType);
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getProductId()).ifPresent(builder::setProductId);
			ofNullable(getProductIdType()).ifPresent(builder::setProductIdType);
			ofNullable(getSubmittedForParty()).ifPresent(builder::setSubmittedForParty);
			ofNullable(getSubmittingPartyId()).ifPresent(builder::setSubmittingPartyId);
			ofNullable(getSubmittingPartyIdType()).ifPresent(builder::setSubmittingPartyIdType);
			ofNullable(getTradeParty1Id()).ifPresent(builder::setTradeParty1Id);
			ofNullable(getTradeParty1IdType()).ifPresent(builder::setTradeParty1IdType);
			ofNullable(getTradeParty1ReportingDestination()).ifPresent(builder::setTradeParty1ReportingDestination);
			ofNullable(getTradeParty1TransactionId()).ifPresent(builder::setTradeParty1TransactionId);
			ofNullable(getTradeParty2Id()).ifPresent(builder::setTradeParty2Id);
			ofNullable(getTradeParty2IdType()).ifPresent(builder::setTradeParty2IdType);
			ofNullable(getTradeParty2ReportingDestination()).ifPresent(builder::setTradeParty2ReportingDestination);
			ofNullable(getTradeParty2TransactionId()).ifPresent(builder::setTradeParty2TransactionId);
			ofNullable(getTransactionType()).ifPresent(builder::setTransactionType);
			ofNullable(getUsiId()).ifPresent(builder::setUsiId);
			ofNullable(getUsiIdPrefix()).ifPresent(builder::setUsiIdPrefix);
			ofNullable(getUtiId()).ifPresent(builder::setUtiId);
			ofNullable(getUtiIdPrefix()).ifPresent(builder::setUtiIdPrefix);
			ofNullable(getLifecycleEventType()).ifPresent(builder::setLifecycleEventType);
			ofNullable(getTradeParty1ExecutionAgentId()).ifPresent(builder::setTradeParty1ExecutionAgentId);
			ofNullable(getTradeParty1ExecutionAgentIdType()).ifPresent(builder::setTradeParty1ExecutionAgentIdType);
			ofNullable(getTradeParty2ExecutionAgentId()).ifPresent(builder::setTradeParty2ExecutionAgentId);
			ofNullable(getTradeParty2ExecutionAgentIdType()).ifPresent(builder::setTradeParty2ExecutionAgentIdType);
			ofNullable(getTradeParty1ThirdPartyViewerId()).ifPresent(builder::setTradeParty1ThirdPartyViewerId);
			ofNullable(getTradeParty2ThirdPartyViewerId()).ifPresent(builder::setTradeParty2ThirdPartyViewerId);
			ofNullable(getTradeParty1ThirdPartyViewerIdType()).ifPresent(builder::setTradeParty1ThirdPartyViewerIdType);
			ofNullable(getTradeParty2ThirdPartyViewerIdType()).ifPresent(builder::setTradeParty2ThirdPartyViewerIdType);
			ofNullable(getReportingTimestamp()).ifPresent(builder::setReportingTimestamp);
			ofNullable(getAiParty1Id()).ifPresent(builder::setAiParty1Id);
			ofNullable(getAiParty1IdType()).ifPresent(builder::setAiParty1IdType);
			ofNullable(getAiParty2Id()).ifPresent(builder::setAiParty2Id);
			ofNullable(getAiParty2IdType()).ifPresent(builder::setAiParty2IdType);
			ofNullable(getTradeParty1RegulatoryActionType1()).ifPresent(builder::setTradeParty1RegulatoryActionType1);
			ofNullable(getTradeParty2RegulatoryActionType1()).ifPresent(builder::setTradeParty2RegulatoryActionType1);
			ofNullable(getNoaActionType()).ifPresent(builder::setNoaActionType);
			ofNullable(getNoaEventType()).ifPresent(builder::setNoaEventType);
			ofNullable(getInitialMarginCollateralPortfolioCode()).ifPresent(builder::setInitialMarginCollateralPortfolioCode);
			ofNullable(getVariationMarginCollateralPortfolioCode()).ifPresent(builder::setVariationMarginCollateralPortfolioCode);
			ofNullable(getCorporateActionNewTradeParty1Lei()).ifPresent(builder::setCorporateActionNewTradeParty1Lei);
			ofNullable(getUpi()).ifPresent(builder::setUpi);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Core _that = getType().cast(o);
		
			if (!Objects.equals(tradeLegTypes, _that.getTradeLegTypes())) return false;
			if (!Objects.equals(latestExecutionDatetime, _that.getLatestExecutionDatetime())) return false;
			if (!Objects.equals(messageId, _that.getMessageId())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!Objects.equals(productId, _that.getProductId())) return false;
			if (!Objects.equals(productIdType, _that.getProductIdType())) return false;
			if (!Objects.equals(submittedForParty, _that.getSubmittedForParty())) return false;
			if (!Objects.equals(submittingPartyId, _that.getSubmittingPartyId())) return false;
			if (!Objects.equals(submittingPartyIdType, _that.getSubmittingPartyIdType())) return false;
			if (!Objects.equals(tradeParty1Id, _that.getTradeParty1Id())) return false;
			if (!Objects.equals(tradeParty1IdType, _that.getTradeParty1IdType())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!Objects.equals(tradeParty1TransactionId, _that.getTradeParty1TransactionId())) return false;
			if (!Objects.equals(tradeParty2Id, _that.getTradeParty2Id())) return false;
			if (!Objects.equals(tradeParty2IdType, _that.getTradeParty2IdType())) return false;
			if (!ListEquals.listEquals(tradeParty2ReportingDestination, _that.getTradeParty2ReportingDestination())) return false;
			if (!Objects.equals(tradeParty2TransactionId, _that.getTradeParty2TransactionId())) return false;
			if (!Objects.equals(transactionType, _that.getTransactionType())) return false;
			if (!Objects.equals(usiId, _that.getUsiId())) return false;
			if (!Objects.equals(usiIdPrefix, _that.getUsiIdPrefix())) return false;
			if (!Objects.equals(utiId, _that.getUtiId())) return false;
			if (!Objects.equals(utiIdPrefix, _that.getUtiIdPrefix())) return false;
			if (!Objects.equals(lifecycleEventType, _that.getLifecycleEventType())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentId, _that.getTradeParty1ExecutionAgentId())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentIdType, _that.getTradeParty1ExecutionAgentIdType())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentId, _that.getTradeParty2ExecutionAgentId())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentIdType, _that.getTradeParty2ExecutionAgentIdType())) return false;
			if (!ListEquals.listEquals(tradeParty1ThirdPartyViewerId, _that.getTradeParty1ThirdPartyViewerId())) return false;
			if (!ListEquals.listEquals(tradeParty2ThirdPartyViewerId, _that.getTradeParty2ThirdPartyViewerId())) return false;
			if (!ListEquals.listEquals(tradeParty1ThirdPartyViewerIdType, _that.getTradeParty1ThirdPartyViewerIdType())) return false;
			if (!ListEquals.listEquals(tradeParty2ThirdPartyViewerIdType, _that.getTradeParty2ThirdPartyViewerIdType())) return false;
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(aiParty1Id, _that.getAiParty1Id())) return false;
			if (!Objects.equals(aiParty1IdType, _that.getAiParty1IdType())) return false;
			if (!Objects.equals(aiParty2Id, _that.getAiParty2Id())) return false;
			if (!Objects.equals(aiParty2IdType, _that.getAiParty2IdType())) return false;
			if (!Objects.equals(tradeParty1RegulatoryActionType1, _that.getTradeParty1RegulatoryActionType1())) return false;
			if (!Objects.equals(tradeParty2RegulatoryActionType1, _that.getTradeParty2RegulatoryActionType1())) return false;
			if (!Objects.equals(noaActionType, _that.getNoaActionType())) return false;
			if (!Objects.equals(noaEventType, _that.getNoaEventType())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(corporateActionNewTradeParty1Lei, _that.getCorporateActionNewTradeParty1Lei())) return false;
			if (!Objects.equals(upi, _that.getUpi())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeLegTypes != null ? tradeLegTypes.hashCode() : 0);
			_result = 31 * _result + (latestExecutionDatetime != null ? latestExecutionDatetime.hashCode() : 0);
			_result = 31 * _result + (messageId != null ? messageId.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			_result = 31 * _result + (productIdType != null ? productIdType.hashCode() : 0);
			_result = 31 * _result + (submittedForParty != null ? submittedForParty.hashCode() : 0);
			_result = 31 * _result + (submittingPartyId != null ? submittingPartyId.hashCode() : 0);
			_result = 31 * _result + (submittingPartyIdType != null ? submittingPartyIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1Id != null ? tradeParty1Id.hashCode() : 0);
			_result = 31 * _result + (tradeParty1IdType != null ? tradeParty1IdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.hashCode() : 0);
			_result = 31 * _result + (tradeParty1TransactionId != null ? tradeParty1TransactionId.hashCode() : 0);
			_result = 31 * _result + (tradeParty2Id != null ? tradeParty2Id.hashCode() : 0);
			_result = 31 * _result + (tradeParty2IdType != null ? tradeParty2IdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ReportingDestination != null ? tradeParty2ReportingDestination.hashCode() : 0);
			_result = 31 * _result + (tradeParty2TransactionId != null ? tradeParty2TransactionId.hashCode() : 0);
			_result = 31 * _result + (transactionType != null ? transactionType.hashCode() : 0);
			_result = 31 * _result + (usiId != null ? usiId.hashCode() : 0);
			_result = 31 * _result + (usiIdPrefix != null ? usiIdPrefix.hashCode() : 0);
			_result = 31 * _result + (utiId != null ? utiId.hashCode() : 0);
			_result = 31 * _result + (utiIdPrefix != null ? utiIdPrefix.hashCode() : 0);
			_result = 31 * _result + (lifecycleEventType != null ? lifecycleEventType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentId != null ? tradeParty1ExecutionAgentId.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentIdType != null ? tradeParty1ExecutionAgentIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentId != null ? tradeParty2ExecutionAgentId.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentIdType != null ? tradeParty2ExecutionAgentIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ThirdPartyViewerId != null ? tradeParty1ThirdPartyViewerId.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ThirdPartyViewerId != null ? tradeParty2ThirdPartyViewerId.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ThirdPartyViewerIdType != null ? tradeParty1ThirdPartyViewerIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ThirdPartyViewerIdType != null ? tradeParty2ThirdPartyViewerIdType.hashCode() : 0);
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (aiParty1Id != null ? aiParty1Id.hashCode() : 0);
			_result = 31 * _result + (aiParty1IdType != null ? aiParty1IdType.hashCode() : 0);
			_result = 31 * _result + (aiParty2Id != null ? aiParty2Id.hashCode() : 0);
			_result = 31 * _result + (aiParty2IdType != null ? aiParty2IdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1RegulatoryActionType1 != null ? tradeParty1RegulatoryActionType1.hashCode() : 0);
			_result = 31 * _result + (tradeParty2RegulatoryActionType1 != null ? tradeParty2RegulatoryActionType1.hashCode() : 0);
			_result = 31 * _result + (noaActionType != null ? noaActionType.hashCode() : 0);
			_result = 31 * _result + (noaEventType != null ? noaEventType.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (corporateActionNewTradeParty1Lei != null ? corporateActionNewTradeParty1Lei.hashCode() : 0);
			_result = 31 * _result + (upi != null ? upi.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Core {" +
				"tradeLegTypes=" + this.tradeLegTypes + ", " +
				"latestExecutionDatetime=" + this.latestExecutionDatetime + ", " +
				"messageId=" + this.messageId + ", " +
				"messageType=" + this.messageType + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"productId=" + this.productId + ", " +
				"productIdType=" + this.productIdType + ", " +
				"submittedForParty=" + this.submittedForParty + ", " +
				"submittingPartyId=" + this.submittingPartyId + ", " +
				"submittingPartyIdType=" + this.submittingPartyIdType + ", " +
				"tradeParty1Id=" + this.tradeParty1Id + ", " +
				"tradeParty1IdType=" + this.tradeParty1IdType + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"tradeParty1TransactionId=" + this.tradeParty1TransactionId + ", " +
				"tradeParty2Id=" + this.tradeParty2Id + ", " +
				"tradeParty2IdType=" + this.tradeParty2IdType + ", " +
				"tradeParty2ReportingDestination=" + this.tradeParty2ReportingDestination + ", " +
				"tradeParty2TransactionId=" + this.tradeParty2TransactionId + ", " +
				"transactionType=" + this.transactionType + ", " +
				"usiId=" + this.usiId + ", " +
				"usiIdPrefix=" + this.usiIdPrefix + ", " +
				"utiId=" + this.utiId + ", " +
				"utiIdPrefix=" + this.utiIdPrefix + ", " +
				"lifecycleEventType=" + this.lifecycleEventType + ", " +
				"tradeParty1ExecutionAgentId=" + this.tradeParty1ExecutionAgentId + ", " +
				"tradeParty1ExecutionAgentIdType=" + this.tradeParty1ExecutionAgentIdType + ", " +
				"tradeParty2ExecutionAgentId=" + this.tradeParty2ExecutionAgentId + ", " +
				"tradeParty2ExecutionAgentIdType=" + this.tradeParty2ExecutionAgentIdType + ", " +
				"tradeParty1ThirdPartyViewerId=" + this.tradeParty1ThirdPartyViewerId + ", " +
				"tradeParty2ThirdPartyViewerId=" + this.tradeParty2ThirdPartyViewerId + ", " +
				"tradeParty1ThirdPartyViewerIdType=" + this.tradeParty1ThirdPartyViewerIdType + ", " +
				"tradeParty2ThirdPartyViewerIdType=" + this.tradeParty2ThirdPartyViewerIdType + ", " +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"aiParty1Id=" + this.aiParty1Id + ", " +
				"aiParty1IdType=" + this.aiParty1IdType + ", " +
				"aiParty2Id=" + this.aiParty2Id + ", " +
				"aiParty2IdType=" + this.aiParty2IdType + ", " +
				"tradeParty1RegulatoryActionType1=" + this.tradeParty1RegulatoryActionType1 + ", " +
				"tradeParty2RegulatoryActionType1=" + this.tradeParty2RegulatoryActionType1 + ", " +
				"noaActionType=" + this.noaActionType + ", " +
				"noaEventType=" + this.noaEventType + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"corporateActionNewTradeParty1Lei=" + this.corporateActionNewTradeParty1Lei + ", " +
				"upi=" + this.upi +
			'}';
		}
	}

	/*********************** Builder Implementation of Core  ***********************/
	class CoreBuilderImpl implements Core.CoreBuilder {
	
		protected String tradeLegTypes;
		protected ZonedDateTime latestExecutionDatetime;
		protected String messageId;
		protected String messageType;
		protected String primaryAssetClass;
		protected String productId;
		protected String productIdType;
		protected String submittedForParty;
		protected String submittingPartyId;
		protected String submittingPartyIdType;
		protected String tradeParty1Id;
		protected String tradeParty1IdType;
		protected List<String> tradeParty1ReportingDestination = new ArrayList<>();
		protected String tradeParty1TransactionId;
		protected String tradeParty2Id;
		protected String tradeParty2IdType;
		protected List<String> tradeParty2ReportingDestination = new ArrayList<>();
		protected String tradeParty2TransactionId;
		protected String transactionType;
		protected String usiId;
		protected String usiIdPrefix;
		protected String utiId;
		protected String utiIdPrefix;
		protected String lifecycleEventType;
		protected String tradeParty1ExecutionAgentId;
		protected String tradeParty1ExecutionAgentIdType;
		protected String tradeParty2ExecutionAgentId;
		protected String tradeParty2ExecutionAgentIdType;
		protected List<String> tradeParty1ThirdPartyViewerId = new ArrayList<>();
		protected List<String> tradeParty2ThirdPartyViewerId = new ArrayList<>();
		protected List<String> tradeParty1ThirdPartyViewerIdType = new ArrayList<>();
		protected List<String> tradeParty2ThirdPartyViewerIdType = new ArrayList<>();
		protected ZonedDateTime reportingTimestamp;
		protected String aiParty1Id;
		protected String aiParty1IdType;
		protected String aiParty2Id;
		protected String aiParty2IdType;
		protected String tradeParty1RegulatoryActionType1;
		protected String tradeParty2RegulatoryActionType1;
		protected String noaActionType;
		protected String noaEventType;
		protected String initialMarginCollateralPortfolioCode;
		protected String variationMarginCollateralPortfolioCode;
		protected String corporateActionNewTradeParty1Lei;
		protected String upi;
		
		@Override
		@RosettaAttribute("tradeLegTypes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeLegTypes")
		public String getTradeLegTypes() {
			return tradeLegTypes;
		}
		
		@Override
		@RosettaAttribute("latestExecutionDatetime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExecutionDatetime")
		public ZonedDateTime getLatestExecutionDatetime() {
			return latestExecutionDatetime;
		}
		
		@Override
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageId")
		public String getMessageId() {
			return messageId;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public String getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("productId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productId")
		public String getProductId() {
			return productId;
		}
		
		@Override
		@RosettaAttribute("productIdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productIdType")
		public String getProductIdType() {
			return productIdType;
		}
		
		@Override
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittedForParty")
		public String getSubmittedForParty() {
			return submittedForParty;
		}
		
		@Override
		@RosettaAttribute("submittingPartyId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittingPartyId")
		public String getSubmittingPartyId() {
			return submittingPartyId;
		}
		
		@Override
		@RosettaAttribute("submittingPartyIdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittingPartyIdType")
		public String getSubmittingPartyIdType() {
			return submittingPartyIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1Id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1Id")
		public String getTradeParty1Id() {
			return tradeParty1Id;
		}
		
		@Override
		@RosettaAttribute("tradeParty1IdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1IdType")
		public String getTradeParty1IdType() {
			return tradeParty1IdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<String> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty1TransactionId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1TransactionId")
		public String getTradeParty1TransactionId() {
			return tradeParty1TransactionId;
		}
		
		@Override
		@RosettaAttribute("tradeParty2Id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2Id")
		public String getTradeParty2Id() {
			return tradeParty2Id;
		}
		
		@Override
		@RosettaAttribute("tradeParty2IdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2IdType")
		public String getTradeParty2IdType() {
			return tradeParty2IdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		public List<String> getTradeParty2ReportingDestination() {
			return tradeParty2ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty2TransactionId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2TransactionId")
		public String getTradeParty2TransactionId() {
			return tradeParty2TransactionId;
		}
		
		@Override
		@RosettaAttribute("transactionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transactionType")
		public String getTransactionType() {
			return transactionType;
		}
		
		@Override
		@RosettaAttribute("usiId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("usiId")
		public String getUsiId() {
			return usiId;
		}
		
		@Override
		@RosettaAttribute("usiIdPrefix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("usiIdPrefix")
		public String getUsiIdPrefix() {
			return usiIdPrefix;
		}
		
		@Override
		@RosettaAttribute("utiId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("utiId")
		public String getUtiId() {
			return utiId;
		}
		
		@Override
		@RosettaAttribute("utiIdPrefix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("utiIdPrefix")
		public String getUtiIdPrefix() {
			return utiIdPrefix;
		}
		
		@Override
		@RosettaAttribute("lifecycleEventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lifecycleEventType")
		public String getLifecycleEventType() {
			return lifecycleEventType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ExecutionAgentId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ExecutionAgentId")
		public String getTradeParty1ExecutionAgentId() {
			return tradeParty1ExecutionAgentId;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ExecutionAgentIdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ExecutionAgentIdType")
		public String getTradeParty1ExecutionAgentIdType() {
			return tradeParty1ExecutionAgentIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ExecutionAgentId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2ExecutionAgentId")
		public String getTradeParty2ExecutionAgentId() {
			return tradeParty2ExecutionAgentId;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ExecutionAgentIdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2ExecutionAgentIdType")
		public String getTradeParty2ExecutionAgentIdType() {
			return tradeParty2ExecutionAgentIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ThirdPartyViewerId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerId")
		public List<String> getTradeParty1ThirdPartyViewerId() {
			return tradeParty1ThirdPartyViewerId;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ThirdPartyViewerId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerId")
		public List<String> getTradeParty2ThirdPartyViewerId() {
			return tradeParty2ThirdPartyViewerId;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ThirdPartyViewerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerIdType")
		public List<String> getTradeParty1ThirdPartyViewerIdType() {
			return tradeParty1ThirdPartyViewerIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ThirdPartyViewerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerIdType")
		public List<String> getTradeParty2ThirdPartyViewerIdType() {
			return tradeParty2ThirdPartyViewerIdType;
		}
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
		}
		
		@Override
		@RosettaAttribute("aiParty1Id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("aiParty1Id")
		public String getAiParty1Id() {
			return aiParty1Id;
		}
		
		@Override
		@RosettaAttribute("aiParty1IdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("aiParty1IdType")
		public String getAiParty1IdType() {
			return aiParty1IdType;
		}
		
		@Override
		@RosettaAttribute("aiParty2Id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("aiParty2Id")
		public String getAiParty2Id() {
			return aiParty2Id;
		}
		
		@Override
		@RosettaAttribute("aiParty2IdType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("aiParty2IdType")
		public String getAiParty2IdType() {
			return aiParty2IdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1RegulatoryActionType1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1RegulatoryActionType1")
		public String getTradeParty1RegulatoryActionType1() {
			return tradeParty1RegulatoryActionType1;
		}
		
		@Override
		@RosettaAttribute("tradeParty2RegulatoryActionType1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2RegulatoryActionType1")
		public String getTradeParty2RegulatoryActionType1() {
			return tradeParty2RegulatoryActionType1;
		}
		
		@Override
		@RosettaAttribute("noaActionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noaActionType")
		public String getNoaActionType() {
			return noaActionType;
		}
		
		@Override
		@RosettaAttribute("noaEventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noaEventType")
		public String getNoaEventType() {
			return noaEventType;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		public String getInitialMarginCollateralPortfolioCode() {
			return initialMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		public String getVariationMarginCollateralPortfolioCode() {
			return variationMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("corporateActionNewTradeParty1Lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateActionNewTradeParty1Lei")
		public String getCorporateActionNewTradeParty1Lei() {
			return corporateActionNewTradeParty1Lei;
		}
		
		@Override
		@RosettaAttribute("upi")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upi")
		public String getUpi() {
			return upi;
		}
		
		@RosettaAttribute("tradeLegTypes")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeLegTypes")
		@Override
		public Core.CoreBuilder setTradeLegTypes(String _tradeLegTypes) {
			this.tradeLegTypes = _tradeLegTypes == null ? null : _tradeLegTypes;
			return this;
		}
		
		@RosettaAttribute("latestExecutionDatetime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExecutionDatetime")
		@Override
		public Core.CoreBuilder setLatestExecutionDatetime(ZonedDateTime _latestExecutionDatetime) {
			this.latestExecutionDatetime = _latestExecutionDatetime == null ? null : _latestExecutionDatetime;
			return this;
		}
		
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageId")
		@Override
		public Core.CoreBuilder setMessageId(String _messageId) {
			this.messageId = _messageId == null ? null : _messageId;
			return this;
		}
		
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageType")
		@Override
		public Core.CoreBuilder setMessageType(String _messageType) {
			this.messageType = _messageType == null ? null : _messageType;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public Core.CoreBuilder setPrimaryAssetClass(String _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass;
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("productId")
		@Override
		public Core.CoreBuilder setProductId(String _productId) {
			this.productId = _productId == null ? null : _productId;
			return this;
		}
		
		@RosettaAttribute("productIdType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("productIdType")
		@Override
		public Core.CoreBuilder setProductIdType(String _productIdType) {
			this.productIdType = _productIdType == null ? null : _productIdType;
			return this;
		}
		
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("submittedForParty")
		@Override
		public Core.CoreBuilder setSubmittedForParty(String _submittedForParty) {
			this.submittedForParty = _submittedForParty == null ? null : _submittedForParty;
			return this;
		}
		
		@RosettaAttribute("submittingPartyId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("submittingPartyId")
		@Override
		public Core.CoreBuilder setSubmittingPartyId(String _submittingPartyId) {
			this.submittingPartyId = _submittingPartyId == null ? null : _submittingPartyId;
			return this;
		}
		
		@RosettaAttribute("submittingPartyIdType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("submittingPartyIdType")
		@Override
		public Core.CoreBuilder setSubmittingPartyIdType(String _submittingPartyIdType) {
			this.submittingPartyIdType = _submittingPartyIdType == null ? null : _submittingPartyIdType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1Id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1Id")
		@Override
		public Core.CoreBuilder setTradeParty1Id(String _tradeParty1Id) {
			this.tradeParty1Id = _tradeParty1Id == null ? null : _tradeParty1Id;
			return this;
		}
		
		@RosettaAttribute("tradeParty1IdType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1IdType")
		@Override
		public Core.CoreBuilder setTradeParty1IdType(String _tradeParty1IdType) {
			this.tradeParty1IdType = _tradeParty1IdType == null ? null : _tradeParty1IdType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public Core.CoreBuilder addTradeParty1ReportingDestination(String _tradeParty1ReportingDestination) {
			if (_tradeParty1ReportingDestination != null) {
				this.tradeParty1ReportingDestination.add(_tradeParty1ReportingDestination);
			}
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty1ReportingDestination(String _tradeParty1ReportingDestination, int idx) {
			getIndex(this.tradeParty1ReportingDestination, idx, () -> _tradeParty1ReportingDestination);
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty1ReportingDestination(List<String> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations != null) {
				for (final String toAdd : tradeParty1ReportingDestinations) {
					this.tradeParty1ReportingDestination.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public Core.CoreBuilder setTradeParty1ReportingDestination(List<String> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations == null) {
				this.tradeParty1ReportingDestination = new ArrayList<>();
			} else {
				this.tradeParty1ReportingDestination = tradeParty1ReportingDestinations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1TransactionId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1TransactionId")
		@Override
		public Core.CoreBuilder setTradeParty1TransactionId(String _tradeParty1TransactionId) {
			this.tradeParty1TransactionId = _tradeParty1TransactionId == null ? null : _tradeParty1TransactionId;
			return this;
		}
		
		@RosettaAttribute("tradeParty2Id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2Id")
		@Override
		public Core.CoreBuilder setTradeParty2Id(String _tradeParty2Id) {
			this.tradeParty2Id = _tradeParty2Id == null ? null : _tradeParty2Id;
			return this;
		}
		
		@RosettaAttribute("tradeParty2IdType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2IdType")
		@Override
		public Core.CoreBuilder setTradeParty2IdType(String _tradeParty2IdType) {
			this.tradeParty2IdType = _tradeParty2IdType == null ? null : _tradeParty2IdType;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		@Override
		public Core.CoreBuilder addTradeParty2ReportingDestination(String _tradeParty2ReportingDestination) {
			if (_tradeParty2ReportingDestination != null) {
				this.tradeParty2ReportingDestination.add(_tradeParty2ReportingDestination);
			}
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty2ReportingDestination(String _tradeParty2ReportingDestination, int idx) {
			getIndex(this.tradeParty2ReportingDestination, idx, () -> _tradeParty2ReportingDestination);
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty2ReportingDestination(List<String> tradeParty2ReportingDestinations) {
			if (tradeParty2ReportingDestinations != null) {
				for (final String toAdd : tradeParty2ReportingDestinations) {
					this.tradeParty2ReportingDestination.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		@Override
		public Core.CoreBuilder setTradeParty2ReportingDestination(List<String> tradeParty2ReportingDestinations) {
			if (tradeParty2ReportingDestinations == null) {
				this.tradeParty2ReportingDestination = new ArrayList<>();
			} else {
				this.tradeParty2ReportingDestination = tradeParty2ReportingDestinations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2TransactionId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2TransactionId")
		@Override
		public Core.CoreBuilder setTradeParty2TransactionId(String _tradeParty2TransactionId) {
			this.tradeParty2TransactionId = _tradeParty2TransactionId == null ? null : _tradeParty2TransactionId;
			return this;
		}
		
		@RosettaAttribute("transactionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transactionType")
		@Override
		public Core.CoreBuilder setTransactionType(String _transactionType) {
			this.transactionType = _transactionType == null ? null : _transactionType;
			return this;
		}
		
		@RosettaAttribute("usiId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("usiId")
		@Override
		public Core.CoreBuilder setUsiId(String _usiId) {
			this.usiId = _usiId == null ? null : _usiId;
			return this;
		}
		
		@RosettaAttribute("usiIdPrefix")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("usiIdPrefix")
		@Override
		public Core.CoreBuilder setUsiIdPrefix(String _usiIdPrefix) {
			this.usiIdPrefix = _usiIdPrefix == null ? null : _usiIdPrefix;
			return this;
		}
		
		@RosettaAttribute("utiId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("utiId")
		@Override
		public Core.CoreBuilder setUtiId(String _utiId) {
			this.utiId = _utiId == null ? null : _utiId;
			return this;
		}
		
		@RosettaAttribute("utiIdPrefix")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("utiIdPrefix")
		@Override
		public Core.CoreBuilder setUtiIdPrefix(String _utiIdPrefix) {
			this.utiIdPrefix = _utiIdPrefix == null ? null : _utiIdPrefix;
			return this;
		}
		
		@RosettaAttribute("lifecycleEventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lifecycleEventType")
		@Override
		public Core.CoreBuilder setLifecycleEventType(String _lifecycleEventType) {
			this.lifecycleEventType = _lifecycleEventType == null ? null : _lifecycleEventType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentId")
		@Override
		public Core.CoreBuilder setTradeParty1ExecutionAgentId(String _tradeParty1ExecutionAgentId) {
			this.tradeParty1ExecutionAgentId = _tradeParty1ExecutionAgentId == null ? null : _tradeParty1ExecutionAgentId;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentIdType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentIdType")
		@Override
		public Core.CoreBuilder setTradeParty1ExecutionAgentIdType(String _tradeParty1ExecutionAgentIdType) {
			this.tradeParty1ExecutionAgentIdType = _tradeParty1ExecutionAgentIdType == null ? null : _tradeParty1ExecutionAgentIdType;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentId")
		@Override
		public Core.CoreBuilder setTradeParty2ExecutionAgentId(String _tradeParty2ExecutionAgentId) {
			this.tradeParty2ExecutionAgentId = _tradeParty2ExecutionAgentId == null ? null : _tradeParty2ExecutionAgentId;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentIdType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentIdType")
		@Override
		public Core.CoreBuilder setTradeParty2ExecutionAgentIdType(String _tradeParty2ExecutionAgentIdType) {
			this.tradeParty2ExecutionAgentIdType = _tradeParty2ExecutionAgentIdType == null ? null : _tradeParty2ExecutionAgentIdType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ThirdPartyViewerId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerId")
		@Override
		public Core.CoreBuilder addTradeParty1ThirdPartyViewerId(String _tradeParty1ThirdPartyViewerId) {
			if (_tradeParty1ThirdPartyViewerId != null) {
				this.tradeParty1ThirdPartyViewerId.add(_tradeParty1ThirdPartyViewerId);
			}
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty1ThirdPartyViewerId(String _tradeParty1ThirdPartyViewerId, int idx) {
			getIndex(this.tradeParty1ThirdPartyViewerId, idx, () -> _tradeParty1ThirdPartyViewerId);
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty1ThirdPartyViewerId(List<String> tradeParty1ThirdPartyViewerIds) {
			if (tradeParty1ThirdPartyViewerIds != null) {
				for (final String toAdd : tradeParty1ThirdPartyViewerIds) {
					this.tradeParty1ThirdPartyViewerId.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ThirdPartyViewerId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerId")
		@Override
		public Core.CoreBuilder setTradeParty1ThirdPartyViewerId(List<String> tradeParty1ThirdPartyViewerIds) {
			if (tradeParty1ThirdPartyViewerIds == null) {
				this.tradeParty1ThirdPartyViewerId = new ArrayList<>();
			} else {
				this.tradeParty1ThirdPartyViewerId = tradeParty1ThirdPartyViewerIds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ThirdPartyViewerId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerId")
		@Override
		public Core.CoreBuilder addTradeParty2ThirdPartyViewerId(String _tradeParty2ThirdPartyViewerId) {
			if (_tradeParty2ThirdPartyViewerId != null) {
				this.tradeParty2ThirdPartyViewerId.add(_tradeParty2ThirdPartyViewerId);
			}
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty2ThirdPartyViewerId(String _tradeParty2ThirdPartyViewerId, int idx) {
			getIndex(this.tradeParty2ThirdPartyViewerId, idx, () -> _tradeParty2ThirdPartyViewerId);
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty2ThirdPartyViewerId(List<String> tradeParty2ThirdPartyViewerIds) {
			if (tradeParty2ThirdPartyViewerIds != null) {
				for (final String toAdd : tradeParty2ThirdPartyViewerIds) {
					this.tradeParty2ThirdPartyViewerId.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ThirdPartyViewerId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerId")
		@Override
		public Core.CoreBuilder setTradeParty2ThirdPartyViewerId(List<String> tradeParty2ThirdPartyViewerIds) {
			if (tradeParty2ThirdPartyViewerIds == null) {
				this.tradeParty2ThirdPartyViewerId = new ArrayList<>();
			} else {
				this.tradeParty2ThirdPartyViewerId = tradeParty2ThirdPartyViewerIds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ThirdPartyViewerIdType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerIdType")
		@Override
		public Core.CoreBuilder addTradeParty1ThirdPartyViewerIdType(String _tradeParty1ThirdPartyViewerIdType) {
			if (_tradeParty1ThirdPartyViewerIdType != null) {
				this.tradeParty1ThirdPartyViewerIdType.add(_tradeParty1ThirdPartyViewerIdType);
			}
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty1ThirdPartyViewerIdType(String _tradeParty1ThirdPartyViewerIdType, int idx) {
			getIndex(this.tradeParty1ThirdPartyViewerIdType, idx, () -> _tradeParty1ThirdPartyViewerIdType);
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty1ThirdPartyViewerIdType(List<String> tradeParty1ThirdPartyViewerIdTypes) {
			if (tradeParty1ThirdPartyViewerIdTypes != null) {
				for (final String toAdd : tradeParty1ThirdPartyViewerIdTypes) {
					this.tradeParty1ThirdPartyViewerIdType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ThirdPartyViewerIdType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerIdType")
		@Override
		public Core.CoreBuilder setTradeParty1ThirdPartyViewerIdType(List<String> tradeParty1ThirdPartyViewerIdTypes) {
			if (tradeParty1ThirdPartyViewerIdTypes == null) {
				this.tradeParty1ThirdPartyViewerIdType = new ArrayList<>();
			} else {
				this.tradeParty1ThirdPartyViewerIdType = tradeParty1ThirdPartyViewerIdTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ThirdPartyViewerIdType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerIdType")
		@Override
		public Core.CoreBuilder addTradeParty2ThirdPartyViewerIdType(String _tradeParty2ThirdPartyViewerIdType) {
			if (_tradeParty2ThirdPartyViewerIdType != null) {
				this.tradeParty2ThirdPartyViewerIdType.add(_tradeParty2ThirdPartyViewerIdType);
			}
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty2ThirdPartyViewerIdType(String _tradeParty2ThirdPartyViewerIdType, int idx) {
			getIndex(this.tradeParty2ThirdPartyViewerIdType, idx, () -> _tradeParty2ThirdPartyViewerIdType);
			return this;
		}
		
		@Override
		public Core.CoreBuilder addTradeParty2ThirdPartyViewerIdType(List<String> tradeParty2ThirdPartyViewerIdTypes) {
			if (tradeParty2ThirdPartyViewerIdTypes != null) {
				for (final String toAdd : tradeParty2ThirdPartyViewerIdTypes) {
					this.tradeParty2ThirdPartyViewerIdType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ThirdPartyViewerIdType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerIdType")
		@Override
		public Core.CoreBuilder setTradeParty2ThirdPartyViewerIdType(List<String> tradeParty2ThirdPartyViewerIdTypes) {
			if (tradeParty2ThirdPartyViewerIdTypes == null) {
				this.tradeParty2ThirdPartyViewerIdType = new ArrayList<>();
			} else {
				this.tradeParty2ThirdPartyViewerIdType = tradeParty2ThirdPartyViewerIdTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingTimestamp")
		@Override
		public Core.CoreBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("aiParty1Id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("aiParty1Id")
		@Override
		public Core.CoreBuilder setAiParty1Id(String _aiParty1Id) {
			this.aiParty1Id = _aiParty1Id == null ? null : _aiParty1Id;
			return this;
		}
		
		@RosettaAttribute("aiParty1IdType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("aiParty1IdType")
		@Override
		public Core.CoreBuilder setAiParty1IdType(String _aiParty1IdType) {
			this.aiParty1IdType = _aiParty1IdType == null ? null : _aiParty1IdType;
			return this;
		}
		
		@RosettaAttribute("aiParty2Id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("aiParty2Id")
		@Override
		public Core.CoreBuilder setAiParty2Id(String _aiParty2Id) {
			this.aiParty2Id = _aiParty2Id == null ? null : _aiParty2Id;
			return this;
		}
		
		@RosettaAttribute("aiParty2IdType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("aiParty2IdType")
		@Override
		public Core.CoreBuilder setAiParty2IdType(String _aiParty2IdType) {
			this.aiParty2IdType = _aiParty2IdType == null ? null : _aiParty2IdType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1RegulatoryActionType1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1RegulatoryActionType1")
		@Override
		public Core.CoreBuilder setTradeParty1RegulatoryActionType1(String _tradeParty1RegulatoryActionType1) {
			this.tradeParty1RegulatoryActionType1 = _tradeParty1RegulatoryActionType1 == null ? null : _tradeParty1RegulatoryActionType1;
			return this;
		}
		
		@RosettaAttribute("tradeParty2RegulatoryActionType1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2RegulatoryActionType1")
		@Override
		public Core.CoreBuilder setTradeParty2RegulatoryActionType1(String _tradeParty2RegulatoryActionType1) {
			this.tradeParty2RegulatoryActionType1 = _tradeParty2RegulatoryActionType1 == null ? null : _tradeParty2RegulatoryActionType1;
			return this;
		}
		
		@RosettaAttribute("noaActionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noaActionType")
		@Override
		public Core.CoreBuilder setNoaActionType(String _noaActionType) {
			this.noaActionType = _noaActionType == null ? null : _noaActionType;
			return this;
		}
		
		@RosettaAttribute("noaEventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noaEventType")
		@Override
		public Core.CoreBuilder setNoaEventType(String _noaEventType) {
			this.noaEventType = _noaEventType == null ? null : _noaEventType;
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public Core.CoreBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public Core.CoreBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("corporateActionNewTradeParty1Lei")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("corporateActionNewTradeParty1Lei")
		@Override
		public Core.CoreBuilder setCorporateActionNewTradeParty1Lei(String _corporateActionNewTradeParty1Lei) {
			this.corporateActionNewTradeParty1Lei = _corporateActionNewTradeParty1Lei == null ? null : _corporateActionNewTradeParty1Lei;
			return this;
		}
		
		@RosettaAttribute("upi")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upi")
		@Override
		public Core.CoreBuilder setUpi(String _upi) {
			this.upi = _upi == null ? null : _upi;
			return this;
		}
		
		@Override
		public Core build() {
			return new Core.CoreImpl(this);
		}
		
		@Override
		public Core.CoreBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Core.CoreBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeLegTypes()!=null) return true;
			if (getLatestExecutionDatetime()!=null) return true;
			if (getMessageId()!=null) return true;
			if (getMessageType()!=null) return true;
			if (getPrimaryAssetClass()!=null) return true;
			if (getProductId()!=null) return true;
			if (getProductIdType()!=null) return true;
			if (getSubmittedForParty()!=null) return true;
			if (getSubmittingPartyId()!=null) return true;
			if (getSubmittingPartyIdType()!=null) return true;
			if (getTradeParty1Id()!=null) return true;
			if (getTradeParty1IdType()!=null) return true;
			if (getTradeParty1ReportingDestination()!=null && !getTradeParty1ReportingDestination().isEmpty()) return true;
			if (getTradeParty1TransactionId()!=null) return true;
			if (getTradeParty2Id()!=null) return true;
			if (getTradeParty2IdType()!=null) return true;
			if (getTradeParty2ReportingDestination()!=null && !getTradeParty2ReportingDestination().isEmpty()) return true;
			if (getTradeParty2TransactionId()!=null) return true;
			if (getTransactionType()!=null) return true;
			if (getUsiId()!=null) return true;
			if (getUsiIdPrefix()!=null) return true;
			if (getUtiId()!=null) return true;
			if (getUtiIdPrefix()!=null) return true;
			if (getLifecycleEventType()!=null) return true;
			if (getTradeParty1ExecutionAgentId()!=null) return true;
			if (getTradeParty1ExecutionAgentIdType()!=null) return true;
			if (getTradeParty2ExecutionAgentId()!=null) return true;
			if (getTradeParty2ExecutionAgentIdType()!=null) return true;
			if (getTradeParty1ThirdPartyViewerId()!=null && !getTradeParty1ThirdPartyViewerId().isEmpty()) return true;
			if (getTradeParty2ThirdPartyViewerId()!=null && !getTradeParty2ThirdPartyViewerId().isEmpty()) return true;
			if (getTradeParty1ThirdPartyViewerIdType()!=null && !getTradeParty1ThirdPartyViewerIdType().isEmpty()) return true;
			if (getTradeParty2ThirdPartyViewerIdType()!=null && !getTradeParty2ThirdPartyViewerIdType().isEmpty()) return true;
			if (getReportingTimestamp()!=null) return true;
			if (getAiParty1Id()!=null) return true;
			if (getAiParty1IdType()!=null) return true;
			if (getAiParty2Id()!=null) return true;
			if (getAiParty2IdType()!=null) return true;
			if (getTradeParty1RegulatoryActionType1()!=null) return true;
			if (getTradeParty2RegulatoryActionType1()!=null) return true;
			if (getNoaActionType()!=null) return true;
			if (getNoaEventType()!=null) return true;
			if (getInitialMarginCollateralPortfolioCode()!=null) return true;
			if (getVariationMarginCollateralPortfolioCode()!=null) return true;
			if (getCorporateActionNewTradeParty1Lei()!=null) return true;
			if (getUpi()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Core.CoreBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Core.CoreBuilder o = (Core.CoreBuilder) other;
			
			
			merger.mergeBasic(getTradeLegTypes(), o.getTradeLegTypes(), this::setTradeLegTypes);
			merger.mergeBasic(getLatestExecutionDatetime(), o.getLatestExecutionDatetime(), this::setLatestExecutionDatetime);
			merger.mergeBasic(getMessageId(), o.getMessageId(), this::setMessageId);
			merger.mergeBasic(getMessageType(), o.getMessageType(), this::setMessageType);
			merger.mergeBasic(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeBasic(getProductId(), o.getProductId(), this::setProductId);
			merger.mergeBasic(getProductIdType(), o.getProductIdType(), this::setProductIdType);
			merger.mergeBasic(getSubmittedForParty(), o.getSubmittedForParty(), this::setSubmittedForParty);
			merger.mergeBasic(getSubmittingPartyId(), o.getSubmittingPartyId(), this::setSubmittingPartyId);
			merger.mergeBasic(getSubmittingPartyIdType(), o.getSubmittingPartyIdType(), this::setSubmittingPartyIdType);
			merger.mergeBasic(getTradeParty1Id(), o.getTradeParty1Id(), this::setTradeParty1Id);
			merger.mergeBasic(getTradeParty1IdType(), o.getTradeParty1IdType(), this::setTradeParty1IdType);
			merger.mergeBasic(getTradeParty1ReportingDestination(), o.getTradeParty1ReportingDestination(), (Consumer<String>) this::addTradeParty1ReportingDestination);
			merger.mergeBasic(getTradeParty1TransactionId(), o.getTradeParty1TransactionId(), this::setTradeParty1TransactionId);
			merger.mergeBasic(getTradeParty2Id(), o.getTradeParty2Id(), this::setTradeParty2Id);
			merger.mergeBasic(getTradeParty2IdType(), o.getTradeParty2IdType(), this::setTradeParty2IdType);
			merger.mergeBasic(getTradeParty2ReportingDestination(), o.getTradeParty2ReportingDestination(), (Consumer<String>) this::addTradeParty2ReportingDestination);
			merger.mergeBasic(getTradeParty2TransactionId(), o.getTradeParty2TransactionId(), this::setTradeParty2TransactionId);
			merger.mergeBasic(getTransactionType(), o.getTransactionType(), this::setTransactionType);
			merger.mergeBasic(getUsiId(), o.getUsiId(), this::setUsiId);
			merger.mergeBasic(getUsiIdPrefix(), o.getUsiIdPrefix(), this::setUsiIdPrefix);
			merger.mergeBasic(getUtiId(), o.getUtiId(), this::setUtiId);
			merger.mergeBasic(getUtiIdPrefix(), o.getUtiIdPrefix(), this::setUtiIdPrefix);
			merger.mergeBasic(getLifecycleEventType(), o.getLifecycleEventType(), this::setLifecycleEventType);
			merger.mergeBasic(getTradeParty1ExecutionAgentId(), o.getTradeParty1ExecutionAgentId(), this::setTradeParty1ExecutionAgentId);
			merger.mergeBasic(getTradeParty1ExecutionAgentIdType(), o.getTradeParty1ExecutionAgentIdType(), this::setTradeParty1ExecutionAgentIdType);
			merger.mergeBasic(getTradeParty2ExecutionAgentId(), o.getTradeParty2ExecutionAgentId(), this::setTradeParty2ExecutionAgentId);
			merger.mergeBasic(getTradeParty2ExecutionAgentIdType(), o.getTradeParty2ExecutionAgentIdType(), this::setTradeParty2ExecutionAgentIdType);
			merger.mergeBasic(getTradeParty1ThirdPartyViewerId(), o.getTradeParty1ThirdPartyViewerId(), (Consumer<String>) this::addTradeParty1ThirdPartyViewerId);
			merger.mergeBasic(getTradeParty2ThirdPartyViewerId(), o.getTradeParty2ThirdPartyViewerId(), (Consumer<String>) this::addTradeParty2ThirdPartyViewerId);
			merger.mergeBasic(getTradeParty1ThirdPartyViewerIdType(), o.getTradeParty1ThirdPartyViewerIdType(), (Consumer<String>) this::addTradeParty1ThirdPartyViewerIdType);
			merger.mergeBasic(getTradeParty2ThirdPartyViewerIdType(), o.getTradeParty2ThirdPartyViewerIdType(), (Consumer<String>) this::addTradeParty2ThirdPartyViewerIdType);
			merger.mergeBasic(getReportingTimestamp(), o.getReportingTimestamp(), this::setReportingTimestamp);
			merger.mergeBasic(getAiParty1Id(), o.getAiParty1Id(), this::setAiParty1Id);
			merger.mergeBasic(getAiParty1IdType(), o.getAiParty1IdType(), this::setAiParty1IdType);
			merger.mergeBasic(getAiParty2Id(), o.getAiParty2Id(), this::setAiParty2Id);
			merger.mergeBasic(getAiParty2IdType(), o.getAiParty2IdType(), this::setAiParty2IdType);
			merger.mergeBasic(getTradeParty1RegulatoryActionType1(), o.getTradeParty1RegulatoryActionType1(), this::setTradeParty1RegulatoryActionType1);
			merger.mergeBasic(getTradeParty2RegulatoryActionType1(), o.getTradeParty2RegulatoryActionType1(), this::setTradeParty2RegulatoryActionType1);
			merger.mergeBasic(getNoaActionType(), o.getNoaActionType(), this::setNoaActionType);
			merger.mergeBasic(getNoaEventType(), o.getNoaEventType(), this::setNoaEventType);
			merger.mergeBasic(getInitialMarginCollateralPortfolioCode(), o.getInitialMarginCollateralPortfolioCode(), this::setInitialMarginCollateralPortfolioCode);
			merger.mergeBasic(getVariationMarginCollateralPortfolioCode(), o.getVariationMarginCollateralPortfolioCode(), this::setVariationMarginCollateralPortfolioCode);
			merger.mergeBasic(getCorporateActionNewTradeParty1Lei(), o.getCorporateActionNewTradeParty1Lei(), this::setCorporateActionNewTradeParty1Lei);
			merger.mergeBasic(getUpi(), o.getUpi(), this::setUpi);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Core _that = getType().cast(o);
		
			if (!Objects.equals(tradeLegTypes, _that.getTradeLegTypes())) return false;
			if (!Objects.equals(latestExecutionDatetime, _that.getLatestExecutionDatetime())) return false;
			if (!Objects.equals(messageId, _that.getMessageId())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!Objects.equals(productId, _that.getProductId())) return false;
			if (!Objects.equals(productIdType, _that.getProductIdType())) return false;
			if (!Objects.equals(submittedForParty, _that.getSubmittedForParty())) return false;
			if (!Objects.equals(submittingPartyId, _that.getSubmittingPartyId())) return false;
			if (!Objects.equals(submittingPartyIdType, _that.getSubmittingPartyIdType())) return false;
			if (!Objects.equals(tradeParty1Id, _that.getTradeParty1Id())) return false;
			if (!Objects.equals(tradeParty1IdType, _that.getTradeParty1IdType())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!Objects.equals(tradeParty1TransactionId, _that.getTradeParty1TransactionId())) return false;
			if (!Objects.equals(tradeParty2Id, _that.getTradeParty2Id())) return false;
			if (!Objects.equals(tradeParty2IdType, _that.getTradeParty2IdType())) return false;
			if (!ListEquals.listEquals(tradeParty2ReportingDestination, _that.getTradeParty2ReportingDestination())) return false;
			if (!Objects.equals(tradeParty2TransactionId, _that.getTradeParty2TransactionId())) return false;
			if (!Objects.equals(transactionType, _that.getTransactionType())) return false;
			if (!Objects.equals(usiId, _that.getUsiId())) return false;
			if (!Objects.equals(usiIdPrefix, _that.getUsiIdPrefix())) return false;
			if (!Objects.equals(utiId, _that.getUtiId())) return false;
			if (!Objects.equals(utiIdPrefix, _that.getUtiIdPrefix())) return false;
			if (!Objects.equals(lifecycleEventType, _that.getLifecycleEventType())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentId, _that.getTradeParty1ExecutionAgentId())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentIdType, _that.getTradeParty1ExecutionAgentIdType())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentId, _that.getTradeParty2ExecutionAgentId())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentIdType, _that.getTradeParty2ExecutionAgentIdType())) return false;
			if (!ListEquals.listEquals(tradeParty1ThirdPartyViewerId, _that.getTradeParty1ThirdPartyViewerId())) return false;
			if (!ListEquals.listEquals(tradeParty2ThirdPartyViewerId, _that.getTradeParty2ThirdPartyViewerId())) return false;
			if (!ListEquals.listEquals(tradeParty1ThirdPartyViewerIdType, _that.getTradeParty1ThirdPartyViewerIdType())) return false;
			if (!ListEquals.listEquals(tradeParty2ThirdPartyViewerIdType, _that.getTradeParty2ThirdPartyViewerIdType())) return false;
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(aiParty1Id, _that.getAiParty1Id())) return false;
			if (!Objects.equals(aiParty1IdType, _that.getAiParty1IdType())) return false;
			if (!Objects.equals(aiParty2Id, _that.getAiParty2Id())) return false;
			if (!Objects.equals(aiParty2IdType, _that.getAiParty2IdType())) return false;
			if (!Objects.equals(tradeParty1RegulatoryActionType1, _that.getTradeParty1RegulatoryActionType1())) return false;
			if (!Objects.equals(tradeParty2RegulatoryActionType1, _that.getTradeParty2RegulatoryActionType1())) return false;
			if (!Objects.equals(noaActionType, _that.getNoaActionType())) return false;
			if (!Objects.equals(noaEventType, _that.getNoaEventType())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(corporateActionNewTradeParty1Lei, _that.getCorporateActionNewTradeParty1Lei())) return false;
			if (!Objects.equals(upi, _that.getUpi())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeLegTypes != null ? tradeLegTypes.hashCode() : 0);
			_result = 31 * _result + (latestExecutionDatetime != null ? latestExecutionDatetime.hashCode() : 0);
			_result = 31 * _result + (messageId != null ? messageId.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			_result = 31 * _result + (productIdType != null ? productIdType.hashCode() : 0);
			_result = 31 * _result + (submittedForParty != null ? submittedForParty.hashCode() : 0);
			_result = 31 * _result + (submittingPartyId != null ? submittingPartyId.hashCode() : 0);
			_result = 31 * _result + (submittingPartyIdType != null ? submittingPartyIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1Id != null ? tradeParty1Id.hashCode() : 0);
			_result = 31 * _result + (tradeParty1IdType != null ? tradeParty1IdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.hashCode() : 0);
			_result = 31 * _result + (tradeParty1TransactionId != null ? tradeParty1TransactionId.hashCode() : 0);
			_result = 31 * _result + (tradeParty2Id != null ? tradeParty2Id.hashCode() : 0);
			_result = 31 * _result + (tradeParty2IdType != null ? tradeParty2IdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ReportingDestination != null ? tradeParty2ReportingDestination.hashCode() : 0);
			_result = 31 * _result + (tradeParty2TransactionId != null ? tradeParty2TransactionId.hashCode() : 0);
			_result = 31 * _result + (transactionType != null ? transactionType.hashCode() : 0);
			_result = 31 * _result + (usiId != null ? usiId.hashCode() : 0);
			_result = 31 * _result + (usiIdPrefix != null ? usiIdPrefix.hashCode() : 0);
			_result = 31 * _result + (utiId != null ? utiId.hashCode() : 0);
			_result = 31 * _result + (utiIdPrefix != null ? utiIdPrefix.hashCode() : 0);
			_result = 31 * _result + (lifecycleEventType != null ? lifecycleEventType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentId != null ? tradeParty1ExecutionAgentId.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentIdType != null ? tradeParty1ExecutionAgentIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentId != null ? tradeParty2ExecutionAgentId.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentIdType != null ? tradeParty2ExecutionAgentIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ThirdPartyViewerId != null ? tradeParty1ThirdPartyViewerId.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ThirdPartyViewerId != null ? tradeParty2ThirdPartyViewerId.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ThirdPartyViewerIdType != null ? tradeParty1ThirdPartyViewerIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ThirdPartyViewerIdType != null ? tradeParty2ThirdPartyViewerIdType.hashCode() : 0);
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (aiParty1Id != null ? aiParty1Id.hashCode() : 0);
			_result = 31 * _result + (aiParty1IdType != null ? aiParty1IdType.hashCode() : 0);
			_result = 31 * _result + (aiParty2Id != null ? aiParty2Id.hashCode() : 0);
			_result = 31 * _result + (aiParty2IdType != null ? aiParty2IdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty1RegulatoryActionType1 != null ? tradeParty1RegulatoryActionType1.hashCode() : 0);
			_result = 31 * _result + (tradeParty2RegulatoryActionType1 != null ? tradeParty2RegulatoryActionType1.hashCode() : 0);
			_result = 31 * _result + (noaActionType != null ? noaActionType.hashCode() : 0);
			_result = 31 * _result + (noaEventType != null ? noaEventType.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (corporateActionNewTradeParty1Lei != null ? corporateActionNewTradeParty1Lei.hashCode() : 0);
			_result = 31 * _result + (upi != null ? upi.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoreBuilder {" +
				"tradeLegTypes=" + this.tradeLegTypes + ", " +
				"latestExecutionDatetime=" + this.latestExecutionDatetime + ", " +
				"messageId=" + this.messageId + ", " +
				"messageType=" + this.messageType + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"productId=" + this.productId + ", " +
				"productIdType=" + this.productIdType + ", " +
				"submittedForParty=" + this.submittedForParty + ", " +
				"submittingPartyId=" + this.submittingPartyId + ", " +
				"submittingPartyIdType=" + this.submittingPartyIdType + ", " +
				"tradeParty1Id=" + this.tradeParty1Id + ", " +
				"tradeParty1IdType=" + this.tradeParty1IdType + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"tradeParty1TransactionId=" + this.tradeParty1TransactionId + ", " +
				"tradeParty2Id=" + this.tradeParty2Id + ", " +
				"tradeParty2IdType=" + this.tradeParty2IdType + ", " +
				"tradeParty2ReportingDestination=" + this.tradeParty2ReportingDestination + ", " +
				"tradeParty2TransactionId=" + this.tradeParty2TransactionId + ", " +
				"transactionType=" + this.transactionType + ", " +
				"usiId=" + this.usiId + ", " +
				"usiIdPrefix=" + this.usiIdPrefix + ", " +
				"utiId=" + this.utiId + ", " +
				"utiIdPrefix=" + this.utiIdPrefix + ", " +
				"lifecycleEventType=" + this.lifecycleEventType + ", " +
				"tradeParty1ExecutionAgentId=" + this.tradeParty1ExecutionAgentId + ", " +
				"tradeParty1ExecutionAgentIdType=" + this.tradeParty1ExecutionAgentIdType + ", " +
				"tradeParty2ExecutionAgentId=" + this.tradeParty2ExecutionAgentId + ", " +
				"tradeParty2ExecutionAgentIdType=" + this.tradeParty2ExecutionAgentIdType + ", " +
				"tradeParty1ThirdPartyViewerId=" + this.tradeParty1ThirdPartyViewerId + ", " +
				"tradeParty2ThirdPartyViewerId=" + this.tradeParty2ThirdPartyViewerId + ", " +
				"tradeParty1ThirdPartyViewerIdType=" + this.tradeParty1ThirdPartyViewerIdType + ", " +
				"tradeParty2ThirdPartyViewerIdType=" + this.tradeParty2ThirdPartyViewerIdType + ", " +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"aiParty1Id=" + this.aiParty1Id + ", " +
				"aiParty1IdType=" + this.aiParty1IdType + ", " +
				"aiParty2Id=" + this.aiParty2Id + ", " +
				"aiParty2IdType=" + this.aiParty2IdType + ", " +
				"tradeParty1RegulatoryActionType1=" + this.tradeParty1RegulatoryActionType1 + ", " +
				"tradeParty2RegulatoryActionType1=" + this.tradeParty2RegulatoryActionType1 + ", " +
				"noaActionType=" + this.noaActionType + ", " +
				"noaEventType=" + this.noaEventType + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"corporateActionNewTradeParty1Lei=" + this.corporateActionNewTradeParty1Lei + ", " +
				"upi=" + this.upi +
			'}';
		}
	}
}
