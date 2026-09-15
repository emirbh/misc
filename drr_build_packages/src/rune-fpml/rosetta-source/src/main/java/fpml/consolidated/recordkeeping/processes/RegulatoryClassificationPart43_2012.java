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
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationPart43_2012Meta;
import fpml.consolidated.shared.CollateralizationType;
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
 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
 *
 */
@RosettaDataType(value="RegulatoryClassificationPart43_2012", builder=RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationPart43_2012", model="fpml", builder=RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationPart43_2012 extends RegulatoryClassification {

	RegulatoryClassificationPart43_2012Meta metaData = new RegulatoryClassificationPart43_2012Meta();

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
	Boolean getCancellation();
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

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationPart43_2012 build();
	
	RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder toBuilder();
	
	static RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder builder() {
		return new RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationPart43_2012> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationPart43_2012> getType() {
		return RegulatoryClassificationPart43_2012.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processor.processBasic(path.newSubPath("cancellation"), Boolean.class, getCancellation(), this);
		processor.processBasic(path.newSubPath("cleared"), String.class, getCleared(), this);
		processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.class, getExecutionVenueType());
		processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.class, getCollateralizationType());
		processor.processBasic(path.newSubPath("offMarketPrice"), Boolean.class, getOffMarketPrice(), this);
		processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationPart43_2012Builder extends RegulatoryClassificationPart43_2012, RegulatoryClassification.RegulatoryClassificationBuilder {
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
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addSupervisoryBody(String supervisoryBody);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addSupervisoryBody(String supervisoryBody, int idx);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setCancellation(Boolean cancellation);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setCleared(String cleared);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setExecutionVenueType(ExecutionVenueType executionVenueType);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setCollateralizationType(CollateralizationType collateralizationType);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setOffMarketPrice(Boolean offMarketPrice);
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setLargeSizeTrade(Boolean largeSizeTrade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processor.processBasic(path.newSubPath("cancellation"), Boolean.class, getCancellation(), this);
			processor.processBasic(path.newSubPath("cleared"), String.class, getCleared(), this);
			processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.ExecutionVenueTypeBuilder.class, getExecutionVenueType());
			processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.CollateralizationTypeBuilder.class, getCollateralizationType());
			processor.processBasic(path.newSubPath("offMarketPrice"), Boolean.class, getOffMarketPrice(), this);
			processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
		}
		

		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationPart43_2012  ***********************/
	class RegulatoryClassificationPart43_2012Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationPart43_2012 {
		private final List<String> supervisoryBody;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final Boolean cancellation;
		private final String cleared;
		private final ExecutionVenueType executionVenueType;
		private final CollateralizationType collateralizationType;
		private final Boolean offMarketPrice;
		private final Boolean largeSizeTrade;
		
		protected RegulatoryClassificationPart43_2012Impl(RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder builder) {
			super(builder);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cancellation = builder.getCancellation();
			this.cleared = builder.getCleared();
			this.executionVenueType = ofNullable(builder.getExecutionVenueType()).map(f->f.build()).orElse(null);
			this.collateralizationType = ofNullable(builder.getCollateralizationType()).map(f->f.build()).orElse(null);
			this.offMarketPrice = builder.getOffMarketPrice();
			this.largeSizeTrade = builder.getLargeSizeTrade();
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
		@RosettaAttribute("cancellation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cancellation")
		public Boolean getCancellation() {
			return cancellation;
		}
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cleared")
		public String getCleared() {
			return cleared;
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
		public RegulatoryClassificationPart43_2012 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder toBuilder() {
			RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getCancellation()).ifPresent(builder::setCancellation);
			ofNullable(getCleared()).ifPresent(builder::setCleared);
			ofNullable(getExecutionVenueType()).ifPresent(builder::setExecutionVenueType);
			ofNullable(getCollateralizationType()).ifPresent(builder::setCollateralizationType);
			ofNullable(getOffMarketPrice()).ifPresent(builder::setOffMarketPrice);
			ofNullable(getLargeSizeTrade()).ifPresent(builder::setLargeSizeTrade);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationPart43_2012 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(cancellation, _that.getCancellation())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(offMarketPrice, _that.getOffMarketPrice())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (cancellation != null ? cancellation.hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (offMarketPrice != null ? offMarketPrice.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationPart43_2012 {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"cancellation=" + this.cancellation + ", " +
				"cleared=" + this.cleared + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"offMarketPrice=" + this.offMarketPrice + ", " +
				"largeSizeTrade=" + this.largeSizeTrade +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationPart43_2012  ***********************/
	class RegulatoryClassificationPart43_2012BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder {
	
		protected List<String> supervisoryBody = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected Boolean cancellation;
		protected String cleared;
		protected ExecutionVenueType.ExecutionVenueTypeBuilder executionVenueType;
		protected CollateralizationType.CollateralizationTypeBuilder collateralizationType;
		protected Boolean offMarketPrice;
		protected Boolean largeSizeTrade;
		
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
		@RosettaAttribute("cancellation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cancellation")
		public Boolean getCancellation() {
			return cancellation;
		}
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cleared")
		public String getCleared() {
			return cleared;
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
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addSupervisoryBody(String _supervisoryBody) {
			if (_supervisoryBody != null) {
				this.supervisoryBody.add(_supervisoryBody);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addSupervisoryBody(String _supervisoryBody, int idx) {
			getIndex(this.supervisoryBody, idx, () -> _supervisoryBody);
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes == null) {
				this.reportingPurpose = new ArrayList<>();
			} else {
				this.reportingPurpose = reportingPurposes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cancellation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cancellation")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setCancellation(Boolean _cancellation) {
			this.cancellation = _cancellation == null ? null : _cancellation;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cleared")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setCleared(String _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueType")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setExecutionVenueType(ExecutionVenueType _executionVenueType) {
			this.executionVenueType = _executionVenueType == null ? null : _executionVenueType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralizationType")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setCollateralizationType(CollateralizationType _collateralizationType) {
			this.collateralizationType = _collateralizationType == null ? null : _collateralizationType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("offMarketPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("offMarketPrice")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setOffMarketPrice(Boolean _offMarketPrice) {
			this.offMarketPrice = _offMarketPrice == null ? null : _offMarketPrice;
			return this;
		}
		
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("largeSizeTrade")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder setLargeSizeTrade(Boolean _largeSizeTrade) {
			this.largeSizeTrade = _largeSizeTrade == null ? null : _largeSizeTrade;
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart43_2012 build() {
			return new RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Impl(this);
		}
		
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder prune() {
			super.prune();
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (executionVenueType!=null && !executionVenueType.prune().hasData()) executionVenueType = null;
			if (collateralizationType!=null && !collateralizationType.prune().hasData()) collateralizationType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSupervisoryBody()!=null && !getSupervisoryBody().isEmpty()) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCancellation()!=null) return true;
			if (getCleared()!=null) return true;
			if (getExecutionVenueType()!=null && getExecutionVenueType().hasData()) return true;
			if (getCollateralizationType()!=null && getCollateralizationType().hasData()) return true;
			if (getOffMarketPrice()!=null) return true;
			if (getLargeSizeTrade()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder o = (RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getExecutionVenueType(), o.getExecutionVenueType(), this::setExecutionVenueType);
			merger.mergeRosetta(getCollateralizationType(), o.getCollateralizationType(), this::setCollateralizationType);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), (Consumer<String>) this::addSupervisoryBody);
			merger.mergeBasic(getCancellation(), o.getCancellation(), this::setCancellation);
			merger.mergeBasic(getCleared(), o.getCleared(), this::setCleared);
			merger.mergeBasic(getOffMarketPrice(), o.getOffMarketPrice(), this::setOffMarketPrice);
			merger.mergeBasic(getLargeSizeTrade(), o.getLargeSizeTrade(), this::setLargeSizeTrade);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationPart43_2012 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(cancellation, _that.getCancellation())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(offMarketPrice, _that.getOffMarketPrice())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (cancellation != null ? cancellation.hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (offMarketPrice != null ? offMarketPrice.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationPart43_2012Builder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"cancellation=" + this.cancellation + ", " +
				"cleared=" + this.cleared + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"offMarketPrice=" + this.offMarketPrice + ", " +
				"largeSizeTrade=" + this.largeSizeTrade +
			'}' + " " + super.toString();
		}
	}
}
