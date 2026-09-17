package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.reg.fpmlreporting.shared.meta.ReportingStatusMeta;
import fpml.consolidated.shared.ReportingRegimeName;
import fpml.consolidated.shared.SupervisoryBody;
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
 * Provision 
 *
 */
@RosettaDataType(value="ReportingStatus", builder=ReportingStatus.ReportingStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReportingStatus", model="fpml", builder=ReportingStatus.ReportingStatusBuilderImpl.class, version="2.1.1")
public interface ReportingStatus extends RosettaModelObject {

	ReportingStatusMeta metaData = new ReportingStatusMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the reporting regime under which this data is reported. For example, Dodd-Frank, EMIR, MiFID, HongKongOTCDRepository, ODRF
	 *
	 */
	ReportingRegimeName getRegimeName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the specific regulator or other supervisory body for which this data is produced. For example, CFTC, SEC, UKFSA, ODRF, SFC, ESMA.
	 *
	 */
	SupervisoryBody getSupervisoryBody();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the reporting regime under which this data is reported. For example, Dodd-Frank, EMIR, MiFID, HongKongOTCDRepository, ODRF
	 *
	 */
	RegulationName getRegulation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision &gt;Identifies the role of this party in reporting this trade for this regulator; roles could include ReportingParty and Voluntary reporting.
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
	 * Provision Describes the extent to which this trade is being reported to the regime (e.g. Not reported, reported with warnings, fully reported).
	 *
	 */
	RegulatorReportingStatusCode getStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the extent to which this trade is being reported to the regime (e.g. Not reported, reported with warnings, fully reported).
	 *
	 */
	List<? extends PublicDissemination> getPublicDissemination();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe and validation errors or warnings associated with the message for the regime.
	 *
	 */
	List<? extends Reason> getReason();

	/*********************** Build Methods  ***********************/
	ReportingStatus build();
	
	ReportingStatus.ReportingStatusBuilder toBuilder();
	
	static ReportingStatus.ReportingStatusBuilder builder() {
		return new ReportingStatus.ReportingStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportingStatus> getType() {
		return ReportingStatus.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("regimeName"), processor, ReportingRegimeName.class, getRegimeName());
		processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.class, getSupervisoryBody());
		processRosetta(path.newSubPath("regulation"), processor, RegulationName.class, getRegulation());
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processRosetta(path.newSubPath("status"), processor, RegulatorReportingStatusCode.class, getStatus());
		processRosetta(path.newSubPath("publicDissemination"), processor, PublicDissemination.class, getPublicDissemination());
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingStatusBuilder extends ReportingStatus, RosettaModelObjectBuilder {
		ReportingRegimeName.ReportingRegimeNameBuilder getOrCreateRegimeName();
		@Override
		ReportingRegimeName.ReportingRegimeNameBuilder getRegimeName();
		SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody();
		@Override
		SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody();
		RegulationName.RegulationNameBuilder getOrCreateRegulation();
		@Override
		RegulationName.RegulationNameBuilder getRegulation();
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index);
		@Override
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder getOrCreateStatus();
		@Override
		RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder getStatus();
		PublicDissemination.PublicDisseminationBuilder getOrCreatePublicDissemination(int index);
		@Override
		List<? extends PublicDissemination.PublicDisseminationBuilder> getPublicDissemination();
		Reason.ReasonBuilder getOrCreateReason(int index);
		@Override
		List<? extends Reason.ReasonBuilder> getReason();
		ReportingStatus.ReportingStatusBuilder setRegimeName(ReportingRegimeName regimeName);
		ReportingStatus.ReportingStatusBuilder setSupervisoryBody(SupervisoryBody supervisoryBody);
		ReportingStatus.ReportingStatusBuilder setRegulation(RegulationName regulation);
		ReportingStatus.ReportingStatusBuilder setReportingRole(ReportingRole reportingRole);
		ReportingStatus.ReportingStatusBuilder addReportingPurpose(ReportingPurpose reportingPurpose);
		ReportingStatus.ReportingStatusBuilder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		ReportingStatus.ReportingStatusBuilder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		ReportingStatus.ReportingStatusBuilder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		ReportingStatus.ReportingStatusBuilder setStatus(RegulatorReportingStatusCode status);
		ReportingStatus.ReportingStatusBuilder addPublicDissemination(PublicDissemination publicDissemination);
		ReportingStatus.ReportingStatusBuilder addPublicDissemination(PublicDissemination publicDissemination, int idx);
		ReportingStatus.ReportingStatusBuilder addPublicDissemination(List<? extends PublicDissemination> publicDissemination);
		ReportingStatus.ReportingStatusBuilder setPublicDissemination(List<? extends PublicDissemination> publicDissemination);
		ReportingStatus.ReportingStatusBuilder addReason(Reason reason);
		ReportingStatus.ReportingStatusBuilder addReason(Reason reason, int idx);
		ReportingStatus.ReportingStatusBuilder addReason(List<? extends Reason> reason);
		ReportingStatus.ReportingStatusBuilder setReason(List<? extends Reason> reason);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("regimeName"), processor, ReportingRegimeName.ReportingRegimeNameBuilder.class, getRegimeName());
			processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.SupervisoryBodyBuilder.class, getSupervisoryBody());
			processRosetta(path.newSubPath("regulation"), processor, RegulationName.RegulationNameBuilder.class, getRegulation());
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processRosetta(path.newSubPath("status"), processor, RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder.class, getStatus());
			processRosetta(path.newSubPath("publicDissemination"), processor, PublicDissemination.PublicDisseminationBuilder.class, getPublicDissemination());
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
		}
		

		ReportingStatus.ReportingStatusBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingStatus  ***********************/
	class ReportingStatusImpl implements ReportingStatus {
		private final ReportingRegimeName regimeName;
		private final SupervisoryBody supervisoryBody;
		private final RegulationName regulation;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final RegulatorReportingStatusCode status;
		private final List<? extends PublicDissemination> publicDissemination;
		private final List<? extends Reason> reason;
		
		protected ReportingStatusImpl(ReportingStatus.ReportingStatusBuilder builder) {
			this.regimeName = ofNullable(builder.getRegimeName()).map(f->f.build()).orElse(null);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).map(f->f.build()).orElse(null);
			this.regulation = ofNullable(builder.getRegulation()).map(f->f.build()).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.status = ofNullable(builder.getStatus()).map(f->f.build()).orElse(null);
			this.publicDissemination = ofNullable(builder.getPublicDissemination()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("regimeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regimeName")
		public ReportingRegimeName getRegimeName() {
			return regimeName;
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("supervisoryBody")
		public SupervisoryBody getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regulation")
		public RegulationName getRegulation() {
			return regulation;
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
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("status")
		public RegulatorReportingStatusCode getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("publicDissemination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("publicDissemination")
		public List<? extends PublicDissemination> getPublicDissemination() {
			return publicDissemination;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		public ReportingStatus build() {
			return this;
		}
		
		@Override
		public ReportingStatus.ReportingStatusBuilder toBuilder() {
			ReportingStatus.ReportingStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingStatus.ReportingStatusBuilder builder) {
			ofNullable(getRegimeName()).ifPresent(builder::setRegimeName);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getRegulation()).ifPresent(builder::setRegulation);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getPublicDissemination()).ifPresent(builder::setPublicDissemination);
			ofNullable(getReason()).ifPresent(builder::setReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingStatus _that = getType().cast(o);
		
			if (!Objects.equals(regimeName, _that.getRegimeName())) return false;
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(regulation, _that.getRegulation())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!ListEquals.listEquals(publicDissemination, _that.getPublicDissemination())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regimeName != null ? regimeName.hashCode() : 0);
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (regulation != null ? regulation.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (publicDissemination != null ? publicDissemination.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingStatus {" +
				"regimeName=" + this.regimeName + ", " +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"regulation=" + this.regulation + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"status=" + this.status + ", " +
				"publicDissemination=" + this.publicDissemination + ", " +
				"reason=" + this.reason +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingStatus  ***********************/
	class ReportingStatusBuilderImpl implements ReportingStatus.ReportingStatusBuilder {
	
		protected ReportingRegimeName.ReportingRegimeNameBuilder regimeName;
		protected SupervisoryBody.SupervisoryBodyBuilder supervisoryBody;
		protected RegulationName.RegulationNameBuilder regulation;
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder status;
		protected List<PublicDissemination.PublicDisseminationBuilder> publicDissemination = new ArrayList<>();
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		
		@Override
		@RosettaAttribute("regimeName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regimeName")
		public ReportingRegimeName.ReportingRegimeNameBuilder getRegimeName() {
			return regimeName;
		}
		
		@Override
		public ReportingRegimeName.ReportingRegimeNameBuilder getOrCreateRegimeName() {
			ReportingRegimeName.ReportingRegimeNameBuilder result;
			if (regimeName!=null) {
				result = regimeName;
			}
			else {
				result = regimeName = ReportingRegimeName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("supervisoryBody")
		public SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody() {
			SupervisoryBody.SupervisoryBodyBuilder result;
			if (supervisoryBody!=null) {
				result = supervisoryBody;
			}
			else {
				result = supervisoryBody = SupervisoryBody.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regulation")
		public RegulationName.RegulationNameBuilder getRegulation() {
			return regulation;
		}
		
		@Override
		public RegulationName.RegulationNameBuilder getOrCreateRegulation() {
			RegulationName.RegulationNameBuilder result;
			if (regulation!=null) {
				result = regulation;
			}
			else {
				result = regulation = RegulationName.builder();
			}
			
			return result;
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
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("status")
		public RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder getStatus() {
			return status;
		}
		
		@Override
		public RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder getOrCreateStatus() {
			RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder result;
			if (status!=null) {
				result = status;
			}
			else {
				result = status = RegulatorReportingStatusCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publicDissemination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("publicDissemination")
		public List<? extends PublicDissemination.PublicDisseminationBuilder> getPublicDissemination() {
			return publicDissemination;
		}
		
		@Override
		public PublicDissemination.PublicDisseminationBuilder getOrCreatePublicDissemination(int index) {
			if (publicDissemination==null) {
				this.publicDissemination = new ArrayList<>();
			}
			return getIndex(publicDissemination, index, () -> {
						PublicDissemination.PublicDisseminationBuilder newPublicDissemination = PublicDissemination.builder();
						return newPublicDissemination;
					});
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public Reason.ReasonBuilder getOrCreateReason(int index) {
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			return getIndex(reason, index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@RosettaAttribute("regimeName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("regimeName")
		@Override
		public ReportingStatus.ReportingStatusBuilder setRegimeName(ReportingRegimeName _regimeName) {
			this.regimeName = _regimeName == null ? null : _regimeName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("supervisoryBody")
		@Override
		public ReportingStatus.ReportingStatusBuilder setSupervisoryBody(SupervisoryBody _supervisoryBody) {
			this.supervisoryBody = _supervisoryBody == null ? null : _supervisoryBody.toBuilder();
			return this;
		}
		
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("regulation")
		@Override
		public ReportingStatus.ReportingStatusBuilder setRegulation(RegulationName _regulation) {
			this.regulation = _regulation == null ? null : _regulation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingRole")
		@Override
		public ReportingStatus.ReportingStatusBuilder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public ReportingStatus.ReportingStatusBuilder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportingStatus.ReportingStatusBuilder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public ReportingStatus.ReportingStatusBuilder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public ReportingStatus.ReportingStatusBuilder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes == null) {
				this.reportingPurpose = new ArrayList<>();
			} else {
				this.reportingPurpose = reportingPurposes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("status")
		@Override
		public ReportingStatus.ReportingStatusBuilder setStatus(RegulatorReportingStatusCode _status) {
			this.status = _status == null ? null : _status.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publicDissemination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("publicDissemination")
		@Override
		public ReportingStatus.ReportingStatusBuilder addPublicDissemination(PublicDissemination _publicDissemination) {
			if (_publicDissemination != null) {
				this.publicDissemination.add(_publicDissemination.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportingStatus.ReportingStatusBuilder addPublicDissemination(PublicDissemination _publicDissemination, int idx) {
			getIndex(this.publicDissemination, idx, () -> _publicDissemination.toBuilder());
			return this;
		}
		
		@Override
		public ReportingStatus.ReportingStatusBuilder addPublicDissemination(List<? extends PublicDissemination> publicDisseminations) {
			if (publicDisseminations != null) {
				for (final PublicDissemination toAdd : publicDisseminations) {
					this.publicDissemination.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("publicDissemination")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("publicDissemination")
		@Override
		public ReportingStatus.ReportingStatusBuilder setPublicDissemination(List<? extends PublicDissemination> publicDisseminations) {
			if (publicDisseminations == null) {
				this.publicDissemination = new ArrayList<>();
			} else {
				this.publicDissemination = publicDisseminations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public ReportingStatus.ReportingStatusBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportingStatus.ReportingStatusBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public ReportingStatus.ReportingStatusBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (final Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public ReportingStatus.ReportingStatusBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReportingStatus build() {
			return new ReportingStatus.ReportingStatusImpl(this);
		}
		
		@Override
		public ReportingStatus.ReportingStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingStatus.ReportingStatusBuilder prune() {
			if (regimeName!=null && !regimeName.prune().hasData()) regimeName = null;
			if (supervisoryBody!=null && !supervisoryBody.prune().hasData()) supervisoryBody = null;
			if (regulation!=null && !regulation.prune().hasData()) regulation = null;
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (status!=null && !status.prune().hasData()) status = null;
			publicDissemination = publicDissemination.stream().filter(b->b!=null).<PublicDissemination.PublicDisseminationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRegimeName()!=null && getRegimeName().hasData()) return true;
			if (getSupervisoryBody()!=null && getSupervisoryBody().hasData()) return true;
			if (getRegulation()!=null && getRegulation().hasData()) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getStatus()!=null && getStatus().hasData()) return true;
			if (getPublicDissemination()!=null && getPublicDissemination().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingStatus.ReportingStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingStatus.ReportingStatusBuilder o = (ReportingStatus.ReportingStatusBuilder) other;
			
			merger.mergeRosetta(getRegimeName(), o.getRegimeName(), this::setRegimeName);
			merger.mergeRosetta(getSupervisoryBody(), o.getSupervisoryBody(), this::setSupervisoryBody);
			merger.mergeRosetta(getRegulation(), o.getRegulation(), this::setRegulation);
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeRosetta(getPublicDissemination(), o.getPublicDissemination(), this::getOrCreatePublicDissemination);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingStatus _that = getType().cast(o);
		
			if (!Objects.equals(regimeName, _that.getRegimeName())) return false;
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(regulation, _that.getRegulation())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!ListEquals.listEquals(publicDissemination, _that.getPublicDissemination())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regimeName != null ? regimeName.hashCode() : 0);
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (regulation != null ? regulation.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (publicDissemination != null ? publicDissemination.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingStatusBuilder {" +
				"regimeName=" + this.regimeName + ", " +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"regulation=" + this.regulation + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"status=" + this.status + ", " +
				"publicDissemination=" + this.publicDissemination + ", " +
				"reason=" + this.reason +
			'}';
		}
	}
}
