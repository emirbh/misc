package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationPart43_2019Meta;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision  DEPRECATED. Not in use (RPTWG decision 2024-12-12).
 *
 */
@RosettaDataType(value="RegulatoryClassificationPart43_2019", builder=RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationPart43_2019", model="fpml", builder=RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationPart43_2019 extends RegulatoryClassification {

	RegulatoryClassificationPart43_2019Meta metaData = new RegulatoryClassificationPart43_2019Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	List<String> getSupervisoryBody();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the role of this party in reporting this trade for this regulator; roles could include ReportingParty and Voluntary reporting.
	 *
	 */
	ReportingRole getReportingRole();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The reason this message is being sent, for example Snapshot, PET, Confirmation, RealTimePublic.
	 *
	 */
	List<? extends ReportingPurpose> getReportingPurpose();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getCancellationOfPublicReporting();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	String getCleared();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getEndUserException();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ExecutionVenueType getExecutionVenueType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	CollateralizationType getCollateralizationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the price does not reflect the current market. For example, in a credit trade where the two counterparties are not of equal credit standing, there is no initial margin and one party pays collateral to the other in the form of an add-on to the price (say a price that would otherwise be 100 at the market is struck at 105 to include the collateral, resulting in a very off-market looking price.) DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getOffMarketPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getLargeSizeTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	PartyReference getClearingService();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegReportingPackageInfo getPackageInfo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ZonedDateTime getDisseminationTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	String getDisseminationId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	String getOriginalDisseminationId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getPostPricedIndicator();

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationPart43_2019 build();
	
	RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder toBuilder();
	
	static RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder builder() {
		return new RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationPart43_2019> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationPart43_2019> getType() {
		return RegulatoryClassificationPart43_2019.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processor.processBasic(path.newSubPath("cancellationOfPublicReporting"), Boolean.class, getCancellationOfPublicReporting(), this);
		processor.processBasic(path.newSubPath("cleared"), String.class, getCleared(), this);
		processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
		processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.class, getExecutionVenueType());
		processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.class, getCollateralizationType());
		processor.processBasic(path.newSubPath("offMarketPrice"), Boolean.class, getOffMarketPrice(), this);
		processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
		processRosetta(path.newSubPath("clearingService"), processor, PartyReference.class, getClearingService());
		processRosetta(path.newSubPath("packageInfo"), processor, RegReportingPackageInfo.class, getPackageInfo());
		processor.processBasic(path.newSubPath("disseminationTime"), ZonedDateTime.class, getDisseminationTime(), this);
		processor.processBasic(path.newSubPath("disseminationId"), String.class, getDisseminationId(), this);
		processor.processBasic(path.newSubPath("originalDisseminationId"), String.class, getOriginalDisseminationId(), this);
		processor.processBasic(path.newSubPath("postPricedIndicator"), Boolean.class, getPostPricedIndicator(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationPart43_2019Builder extends RegulatoryClassificationPart43_2019, RegulatoryClassification.RegulatoryClassificationBuilder {
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index);
		@Override
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		ExecutionVenueType.ExecutionVenueTypeBuilder getOrCreateExecutionVenueType();
		@Override
		ExecutionVenueType.ExecutionVenueTypeBuilder getExecutionVenueType();
		CollateralizationType.CollateralizationTypeBuilder getOrCreateCollateralizationType();
		@Override
		CollateralizationType.CollateralizationTypeBuilder getCollateralizationType();
		PartyReference.PartyReferenceBuilder getOrCreateClearingService();
		@Override
		PartyReference.PartyReferenceBuilder getClearingService();
		RegReportingPackageInfo.RegReportingPackageInfoBuilder getOrCreatePackageInfo();
		@Override
		RegReportingPackageInfo.RegReportingPackageInfoBuilder getPackageInfo();
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addSupervisoryBody(String supervisoryBody);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addSupervisoryBody(String supervisoryBody, int idx);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setCancellationOfPublicReporting(Boolean cancellationOfPublicReporting);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setCleared(String cleared);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setEndUserException(Boolean endUserException);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setExecutionVenueType(ExecutionVenueType executionVenueType);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setCollateralizationType(CollateralizationType collateralizationType);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setOffMarketPrice(Boolean offMarketPrice);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setLargeSizeTrade(Boolean largeSizeTrade);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setClearingService(PartyReference clearingService);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setPackageInfo(RegReportingPackageInfo packageInfo);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setDisseminationTime(ZonedDateTime disseminationTime);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setDisseminationId(String disseminationId);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setOriginalDisseminationId(String originalDisseminationId);
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setPostPricedIndicator(Boolean postPricedIndicator);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processor.processBasic(path.newSubPath("cancellationOfPublicReporting"), Boolean.class, getCancellationOfPublicReporting(), this);
			processor.processBasic(path.newSubPath("cleared"), String.class, getCleared(), this);
			processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
			processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.ExecutionVenueTypeBuilder.class, getExecutionVenueType());
			processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.CollateralizationTypeBuilder.class, getCollateralizationType());
			processor.processBasic(path.newSubPath("offMarketPrice"), Boolean.class, getOffMarketPrice(), this);
			processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
			processRosetta(path.newSubPath("clearingService"), processor, PartyReference.PartyReferenceBuilder.class, getClearingService());
			processRosetta(path.newSubPath("packageInfo"), processor, RegReportingPackageInfo.RegReportingPackageInfoBuilder.class, getPackageInfo());
			processor.processBasic(path.newSubPath("disseminationTime"), ZonedDateTime.class, getDisseminationTime(), this);
			processor.processBasic(path.newSubPath("disseminationId"), String.class, getDisseminationId(), this);
			processor.processBasic(path.newSubPath("originalDisseminationId"), String.class, getOriginalDisseminationId(), this);
			processor.processBasic(path.newSubPath("postPricedIndicator"), Boolean.class, getPostPricedIndicator(), this);
		}
		

		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationPart43_2019  ***********************/
	class RegulatoryClassificationPart43_2019Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationPart43_2019 {
		private final List<String> supervisoryBody;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final Boolean cancellationOfPublicReporting;
		private final String cleared;
		private final Boolean endUserException;
		private final ExecutionVenueType executionVenueType;
		private final CollateralizationType collateralizationType;
		private final Boolean offMarketPrice;
		private final Boolean largeSizeTrade;
		private final PartyReference clearingService;
		private final RegReportingPackageInfo packageInfo;
		private final ZonedDateTime disseminationTime;
		private final String disseminationId;
		private final String originalDisseminationId;
		private final Boolean postPricedIndicator;
		
		protected RegulatoryClassificationPart43_2019Impl(RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder builder) {
			super(builder);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cancellationOfPublicReporting = builder.getCancellationOfPublicReporting();
			this.cleared = builder.getCleared();
			this.endUserException = builder.getEndUserException();
			this.executionVenueType = ofNullable(builder.getExecutionVenueType()).map(f->f.build()).orElse(null);
			this.collateralizationType = ofNullable(builder.getCollateralizationType()).map(f->f.build()).orElse(null);
			this.offMarketPrice = builder.getOffMarketPrice();
			this.largeSizeTrade = builder.getLargeSizeTrade();
			this.clearingService = ofNullable(builder.getClearingService()).map(f->f.build()).orElse(null);
			this.packageInfo = ofNullable(builder.getPackageInfo()).map(f->f.build()).orElse(null);
			this.disseminationTime = builder.getDisseminationTime();
			this.disseminationId = builder.getDisseminationId();
			this.originalDisseminationId = builder.getOriginalDisseminationId();
			this.postPricedIndicator = builder.getPostPricedIndicator();
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		public List<String> getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRole getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingPurpose")
		public List<? extends ReportingPurpose> getReportingPurpose() {
			return reportingPurpose;
		}
		
		@Override
		@RosettaAttribute("cancellationOfPublicReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cancellationOfPublicReporting")
		public Boolean getCancellationOfPublicReporting() {
			return cancellationOfPublicReporting;
		}
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cleared")
		public String getCleared() {
			return cleared;
		}
		
		@Override
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserException")
		public Boolean getEndUserException() {
			return endUserException;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueType getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizationType")
		public CollateralizationType getCollateralizationType() {
			return collateralizationType;
		}
		
		@Override
		@RosettaAttribute("offMarketPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offMarketPrice")
		public Boolean getOffMarketPrice() {
			return offMarketPrice;
		}
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("clearingService")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingService")
		public PartyReference getClearingService() {
			return clearingService;
		}
		
		@Override
		@RosettaAttribute("packageInfo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageInfo")
		public RegReportingPackageInfo getPackageInfo() {
			return packageInfo;
		}
		
		@Override
		@RosettaAttribute("disseminationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disseminationTime")
		public ZonedDateTime getDisseminationTime() {
			return disseminationTime;
		}
		
		@Override
		@RosettaAttribute("disseminationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disseminationId")
		public String getDisseminationId() {
			return disseminationId;
		}
		
		@Override
		@RosettaAttribute("originalDisseminationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalDisseminationId")
		public String getOriginalDisseminationId() {
			return originalDisseminationId;
		}
		
		@Override
		@RosettaAttribute("postPricedIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postPricedIndicator")
		public Boolean getPostPricedIndicator() {
			return postPricedIndicator;
		}
		
		@Override
		public RegulatoryClassificationPart43_2019 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder toBuilder() {
			RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getCancellationOfPublicReporting()).ifPresent(builder::setCancellationOfPublicReporting);
			ofNullable(getCleared()).ifPresent(builder::setCleared);
			ofNullable(getEndUserException()).ifPresent(builder::setEndUserException);
			ofNullable(getExecutionVenueType()).ifPresent(builder::setExecutionVenueType);
			ofNullable(getCollateralizationType()).ifPresent(builder::setCollateralizationType);
			ofNullable(getOffMarketPrice()).ifPresent(builder::setOffMarketPrice);
			ofNullable(getLargeSizeTrade()).ifPresent(builder::setLargeSizeTrade);
			ofNullable(getClearingService()).ifPresent(builder::setClearingService);
			ofNullable(getPackageInfo()).ifPresent(builder::setPackageInfo);
			ofNullable(getDisseminationTime()).ifPresent(builder::setDisseminationTime);
			ofNullable(getDisseminationId()).ifPresent(builder::setDisseminationId);
			ofNullable(getOriginalDisseminationId()).ifPresent(builder::setOriginalDisseminationId);
			ofNullable(getPostPricedIndicator()).ifPresent(builder::setPostPricedIndicator);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationPart43_2019 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(cancellationOfPublicReporting, _that.getCancellationOfPublicReporting())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(offMarketPrice, _that.getOffMarketPrice())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(clearingService, _that.getClearingService())) return false;
			if (!Objects.equals(packageInfo, _that.getPackageInfo())) return false;
			if (!Objects.equals(disseminationTime, _that.getDisseminationTime())) return false;
			if (!Objects.equals(disseminationId, _that.getDisseminationId())) return false;
			if (!Objects.equals(originalDisseminationId, _that.getOriginalDisseminationId())) return false;
			if (!Objects.equals(postPricedIndicator, _that.getPostPricedIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (cancellationOfPublicReporting != null ? cancellationOfPublicReporting.hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.hashCode() : 0);
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (offMarketPrice != null ? offMarketPrice.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (clearingService != null ? clearingService.hashCode() : 0);
			_result = 31 * _result + (packageInfo != null ? packageInfo.hashCode() : 0);
			_result = 31 * _result + (disseminationTime != null ? disseminationTime.hashCode() : 0);
			_result = 31 * _result + (disseminationId != null ? disseminationId.hashCode() : 0);
			_result = 31 * _result + (originalDisseminationId != null ? originalDisseminationId.hashCode() : 0);
			_result = 31 * _result + (postPricedIndicator != null ? postPricedIndicator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationPart43_2019 {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"cancellationOfPublicReporting=" + this.cancellationOfPublicReporting + ", " +
				"cleared=" + this.cleared + ", " +
				"endUserException=" + this.endUserException + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"offMarketPrice=" + this.offMarketPrice + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"clearingService=" + this.clearingService + ", " +
				"packageInfo=" + this.packageInfo + ", " +
				"disseminationTime=" + this.disseminationTime + ", " +
				"disseminationId=" + this.disseminationId + ", " +
				"originalDisseminationId=" + this.originalDisseminationId + ", " +
				"postPricedIndicator=" + this.postPricedIndicator +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationPart43_2019  ***********************/
	class RegulatoryClassificationPart43_2019BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder {
	
		protected List<String> supervisoryBody = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected Boolean cancellationOfPublicReporting;
		protected String cleared;
		protected Boolean endUserException;
		protected ExecutionVenueType.ExecutionVenueTypeBuilder executionVenueType;
		protected CollateralizationType.CollateralizationTypeBuilder collateralizationType;
		protected Boolean offMarketPrice;
		protected Boolean largeSizeTrade;
		protected PartyReference.PartyReferenceBuilder clearingService;
		protected RegReportingPackageInfo.RegReportingPackageInfoBuilder packageInfo;
		protected ZonedDateTime disseminationTime;
		protected String disseminationId;
		protected String originalDisseminationId;
		protected Boolean postPricedIndicator;
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		public List<String> getSupervisoryBody() {
			return supervisoryBody;
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
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingPurpose")
		public List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose() {
			return reportingPurpose;
		}
		
		@Override
		public ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index) {
			if (reportingPurpose==null) {
				this.reportingPurpose = new ArrayList<>();
			}
			return getIndex(reportingPurpose, index, () -> {
						ReportingPurpose.ReportingPurposeBuilder newReportingPurpose = ReportingPurpose.builder();
						return newReportingPurpose;
					});
		}
		
		@Override
		@RosettaAttribute("cancellationOfPublicReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cancellationOfPublicReporting")
		public Boolean getCancellationOfPublicReporting() {
			return cancellationOfPublicReporting;
		}
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cleared")
		public String getCleared() {
			return cleared;
		}
		
		@Override
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserException")
		public Boolean getEndUserException() {
			return endUserException;
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
		@RosettaAttribute("offMarketPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offMarketPrice")
		public Boolean getOffMarketPrice() {
			return offMarketPrice;
		}
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("clearingService")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingService")
		public PartyReference.PartyReferenceBuilder getClearingService() {
			return clearingService;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateClearingService() {
			PartyReference.PartyReferenceBuilder result;
			if (clearingService!=null) {
				result = clearingService;
			}
			else {
				result = clearingService = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageInfo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageInfo")
		public RegReportingPackageInfo.RegReportingPackageInfoBuilder getPackageInfo() {
			return packageInfo;
		}
		
		@Override
		public RegReportingPackageInfo.RegReportingPackageInfoBuilder getOrCreatePackageInfo() {
			RegReportingPackageInfo.RegReportingPackageInfoBuilder result;
			if (packageInfo!=null) {
				result = packageInfo;
			}
			else {
				result = packageInfo = RegReportingPackageInfo.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("disseminationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disseminationTime")
		public ZonedDateTime getDisseminationTime() {
			return disseminationTime;
		}
		
		@Override
		@RosettaAttribute("disseminationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disseminationId")
		public String getDisseminationId() {
			return disseminationId;
		}
		
		@Override
		@RosettaAttribute("originalDisseminationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalDisseminationId")
		public String getOriginalDisseminationId() {
			return originalDisseminationId;
		}
		
		@Override
		@RosettaAttribute("postPricedIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postPricedIndicator")
		public Boolean getPostPricedIndicator() {
			return postPricedIndicator;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addSupervisoryBody(String _supervisoryBody) {
			if (_supervisoryBody != null) {
				this.supervisoryBody.add(_supervisoryBody);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addSupervisoryBody(String _supervisoryBody, int idx) {
			getIndex(this.supervisoryBody, idx, () -> _supervisoryBody);
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addSupervisoryBody(List<String> supervisoryBodys) {
			if (supervisoryBodys != null) {
				for (final String toAdd : supervisoryBodys) {
					this.supervisoryBody.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setSupervisoryBody(List<String> supervisoryBodys) {
			if (supervisoryBodys == null) {
				this.supervisoryBody = new ArrayList<>();
			} else {
				this.supervisoryBody = supervisoryBodys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingRole")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes != null) {
				for (final ReportingPurpose toAdd : reportingPurposes) {
					this.reportingPurpose.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes == null) {
				this.reportingPurpose = new ArrayList<>();
			} else {
				this.reportingPurpose = reportingPurposes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cancellationOfPublicReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cancellationOfPublicReporting")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setCancellationOfPublicReporting(Boolean _cancellationOfPublicReporting) {
			this.cancellationOfPublicReporting = _cancellationOfPublicReporting == null ? null : _cancellationOfPublicReporting;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cleared")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setCleared(String _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endUserException")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setEndUserException(Boolean _endUserException) {
			this.endUserException = _endUserException == null ? null : _endUserException;
			return this;
		}
		
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueType")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setExecutionVenueType(ExecutionVenueType _executionVenueType) {
			this.executionVenueType = _executionVenueType == null ? null : _executionVenueType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralizationType")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setCollateralizationType(CollateralizationType _collateralizationType) {
			this.collateralizationType = _collateralizationType == null ? null : _collateralizationType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("offMarketPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("offMarketPrice")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setOffMarketPrice(Boolean _offMarketPrice) {
			this.offMarketPrice = _offMarketPrice == null ? null : _offMarketPrice;
			return this;
		}
		
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("largeSizeTrade")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setLargeSizeTrade(Boolean _largeSizeTrade) {
			this.largeSizeTrade = _largeSizeTrade == null ? null : _largeSizeTrade;
			return this;
		}
		
		@RosettaAttribute("clearingService")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingService")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setClearingService(PartyReference _clearingService) {
			this.clearingService = _clearingService == null ? null : _clearingService.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageInfo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageInfo")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setPackageInfo(RegReportingPackageInfo _packageInfo) {
			this.packageInfo = _packageInfo == null ? null : _packageInfo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("disseminationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("disseminationTime")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setDisseminationTime(ZonedDateTime _disseminationTime) {
			this.disseminationTime = _disseminationTime == null ? null : _disseminationTime;
			return this;
		}
		
		@RosettaAttribute("disseminationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("disseminationId")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setDisseminationId(String _disseminationId) {
			this.disseminationId = _disseminationId == null ? null : _disseminationId;
			return this;
		}
		
		@RosettaAttribute("originalDisseminationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalDisseminationId")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setOriginalDisseminationId(String _originalDisseminationId) {
			this.originalDisseminationId = _originalDisseminationId == null ? null : _originalDisseminationId;
			return this;
		}
		
		@RosettaAttribute("postPricedIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postPricedIndicator")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder setPostPricedIndicator(Boolean _postPricedIndicator) {
			this.postPricedIndicator = _postPricedIndicator == null ? null : _postPricedIndicator;
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2019 build() {
			return new RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Impl(this);
		}
		
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder prune() {
			super.prune();
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (executionVenueType!=null && !executionVenueType.prune().hasData()) executionVenueType = null;
			if (collateralizationType!=null && !collateralizationType.prune().hasData()) collateralizationType = null;
			if (clearingService!=null && !clearingService.prune().hasData()) clearingService = null;
			if (packageInfo!=null && !packageInfo.prune().hasData()) packageInfo = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSupervisoryBody()!=null && !getSupervisoryBody().isEmpty()) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCancellationOfPublicReporting()!=null) return true;
			if (getCleared()!=null) return true;
			if (getEndUserException()!=null) return true;
			if (getExecutionVenueType()!=null && getExecutionVenueType().hasData()) return true;
			if (getCollateralizationType()!=null && getCollateralizationType().hasData()) return true;
			if (getOffMarketPrice()!=null) return true;
			if (getLargeSizeTrade()!=null) return true;
			if (getClearingService()!=null && getClearingService().hasData()) return true;
			if (getPackageInfo()!=null && getPackageInfo().hasData()) return true;
			if (getDisseminationTime()!=null) return true;
			if (getDisseminationId()!=null) return true;
			if (getOriginalDisseminationId()!=null) return true;
			if (getPostPricedIndicator()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder o = (RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getExecutionVenueType(), o.getExecutionVenueType(), this::setExecutionVenueType);
			merger.mergeRosetta(getCollateralizationType(), o.getCollateralizationType(), this::setCollateralizationType);
			merger.mergeRosetta(getClearingService(), o.getClearingService(), this::setClearingService);
			merger.mergeRosetta(getPackageInfo(), o.getPackageInfo(), this::setPackageInfo);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), (Consumer<String>) this::addSupervisoryBody);
			merger.mergeBasic(getCancellationOfPublicReporting(), o.getCancellationOfPublicReporting(), this::setCancellationOfPublicReporting);
			merger.mergeBasic(getCleared(), o.getCleared(), this::setCleared);
			merger.mergeBasic(getEndUserException(), o.getEndUserException(), this::setEndUserException);
			merger.mergeBasic(getOffMarketPrice(), o.getOffMarketPrice(), this::setOffMarketPrice);
			merger.mergeBasic(getLargeSizeTrade(), o.getLargeSizeTrade(), this::setLargeSizeTrade);
			merger.mergeBasic(getDisseminationTime(), o.getDisseminationTime(), this::setDisseminationTime);
			merger.mergeBasic(getDisseminationId(), o.getDisseminationId(), this::setDisseminationId);
			merger.mergeBasic(getOriginalDisseminationId(), o.getOriginalDisseminationId(), this::setOriginalDisseminationId);
			merger.mergeBasic(getPostPricedIndicator(), o.getPostPricedIndicator(), this::setPostPricedIndicator);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationPart43_2019 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(cancellationOfPublicReporting, _that.getCancellationOfPublicReporting())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(offMarketPrice, _that.getOffMarketPrice())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(clearingService, _that.getClearingService())) return false;
			if (!Objects.equals(packageInfo, _that.getPackageInfo())) return false;
			if (!Objects.equals(disseminationTime, _that.getDisseminationTime())) return false;
			if (!Objects.equals(disseminationId, _that.getDisseminationId())) return false;
			if (!Objects.equals(originalDisseminationId, _that.getOriginalDisseminationId())) return false;
			if (!Objects.equals(postPricedIndicator, _that.getPostPricedIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (cancellationOfPublicReporting != null ? cancellationOfPublicReporting.hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.hashCode() : 0);
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (offMarketPrice != null ? offMarketPrice.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (clearingService != null ? clearingService.hashCode() : 0);
			_result = 31 * _result + (packageInfo != null ? packageInfo.hashCode() : 0);
			_result = 31 * _result + (disseminationTime != null ? disseminationTime.hashCode() : 0);
			_result = 31 * _result + (disseminationId != null ? disseminationId.hashCode() : 0);
			_result = 31 * _result + (originalDisseminationId != null ? originalDisseminationId.hashCode() : 0);
			_result = 31 * _result + (postPricedIndicator != null ? postPricedIndicator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationPart43_2019Builder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"cancellationOfPublicReporting=" + this.cancellationOfPublicReporting + ", " +
				"cleared=" + this.cleared + ", " +
				"endUserException=" + this.endUserException + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"offMarketPrice=" + this.offMarketPrice + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"clearingService=" + this.clearingService + ", " +
				"packageInfo=" + this.packageInfo + ", " +
				"disseminationTime=" + this.disseminationTime + ", " +
				"disseminationId=" + this.disseminationId + ", " +
				"originalDisseminationId=" + this.originalDisseminationId + ", " +
				"postPricedIndicator=" + this.postPricedIndicator +
			'}' + " " + super.toString();
		}
	}
}
