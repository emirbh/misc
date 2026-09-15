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
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationCSA_2016Meta;
import fpml.consolidated.shared.ActionType;
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
@RosettaDataType(value="RegulatoryClassificationCSA_2016", builder=RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationCSA_2016", model="fpml", builder=RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationCSA_2016 extends RegulatoryClassification {

	RegulatoryClassificationCSA_2016Meta metaData = new RegulatoryClassificationCSA_2016Meta();

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
	Boolean getInterAffiliate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Describes the type of event to the transaction (e.g., new transaction, modification or cancellation of existing transaction, etc.). TBD: FpML doesn’t currently define a coding scheme for this value. We anticipate that one will be developed in a future release.
	 *
	 */
	ActionType getActionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Indicate whether the transaction resulted from a post-transaction service (e.g. compression, reconciliation, etc.) or from a lifecycle event (e.g. novation, amendment, etc.). TBD: FpML doesn’t currently define a coding scheme for this value. We anticipate that one will be developed in a future release.
	 *
	 */
	String getEventType();

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationCSA_2016 build();
	
	RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder toBuilder();
	
	static RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder builder() {
		return new RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationCSA_2016> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationCSA_2016> getType() {
		return RegulatoryClassificationCSA_2016.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processor.processBasic(path.newSubPath("interAffiliate"), Boolean.class, getInterAffiliate(), this);
		processRosetta(path.newSubPath("actionType"), processor, ActionType.class, getActionType());
		processor.processBasic(path.newSubPath("eventType"), String.class, getEventType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationCSA_2016Builder extends RegulatoryClassificationCSA_2016, RegulatoryClassification.RegulatoryClassificationBuilder {
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index);
		@Override
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		ActionType.ActionTypeBuilder getOrCreateActionType();
		@Override
		ActionType.ActionTypeBuilder getActionType();
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addSupervisoryBody(String supervisoryBody);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addSupervisoryBody(String supervisoryBody, int idx);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setInterAffiliate(Boolean interAffiliate);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setActionType(ActionType actionType);
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setEventType(String eventType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processor.processBasic(path.newSubPath("interAffiliate"), Boolean.class, getInterAffiliate(), this);
			processRosetta(path.newSubPath("actionType"), processor, ActionType.ActionTypeBuilder.class, getActionType());
			processor.processBasic(path.newSubPath("eventType"), String.class, getEventType(), this);
		}
		

		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationCSA_2016  ***********************/
	class RegulatoryClassificationCSA_2016Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationCSA_2016 {
		private final List<String> supervisoryBody;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final Boolean interAffiliate;
		private final ActionType actionType;
		private final String eventType;
		
		protected RegulatoryClassificationCSA_2016Impl(RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder builder) {
			super(builder);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.interAffiliate = builder.getInterAffiliate();
			this.actionType = ofNullable(builder.getActionType()).map(f->f.build()).orElse(null);
			this.eventType = builder.getEventType();
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
		@RosettaAttribute("interAffiliate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interAffiliate")
		public Boolean getInterAffiliate() {
			return interAffiliate;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public ActionType getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventType")
		public String getEventType() {
			return eventType;
		}
		
		@Override
		public RegulatoryClassificationCSA_2016 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder toBuilder() {
			RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getInterAffiliate()).ifPresent(builder::setInterAffiliate);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
			ofNullable(getEventType()).ifPresent(builder::setEventType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationCSA_2016 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(interAffiliate, _that.getInterAffiliate())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (interAffiliate != null ? interAffiliate.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationCSA_2016 {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"interAffiliate=" + this.interAffiliate + ", " +
				"actionType=" + this.actionType + ", " +
				"eventType=" + this.eventType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationCSA_2016  ***********************/
	class RegulatoryClassificationCSA_2016BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder {
	
		protected List<String> supervisoryBody = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected Boolean interAffiliate;
		protected ActionType.ActionTypeBuilder actionType;
		protected String eventType;
		
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
		@RosettaAttribute("interAffiliate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interAffiliate")
		public Boolean getInterAffiliate() {
			return interAffiliate;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public ActionType.ActionTypeBuilder getActionType() {
			return actionType;
		}
		
		@Override
		public ActionType.ActionTypeBuilder getOrCreateActionType() {
			ActionType.ActionTypeBuilder result;
			if (actionType!=null) {
				result = actionType;
			}
			else {
				result = actionType = ActionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventType")
		public String getEventType() {
			return eventType;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addSupervisoryBody(String _supervisoryBody) {
			if (_supervisoryBody != null) {
				this.supervisoryBody.add(_supervisoryBody);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addSupervisoryBody(String _supervisoryBody, int idx) {
			getIndex(this.supervisoryBody, idx, () -> _supervisoryBody);
			return this;
		}
		
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes == null) {
				this.reportingPurpose = new ArrayList<>();
			} else {
				this.reportingPurpose = reportingPurposes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("interAffiliate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interAffiliate")
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setInterAffiliate(Boolean _interAffiliate) {
			this.interAffiliate = _interAffiliate == null ? null : _interAffiliate;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setActionType(ActionType _actionType) {
			this.actionType = _actionType == null ? null : _actionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventType")
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder setEventType(String _eventType) {
			this.eventType = _eventType == null ? null : _eventType;
			return this;
		}
		
		@Override
		public RegulatoryClassificationCSA_2016 build() {
			return new RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Impl(this);
		}
		
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder prune() {
			super.prune();
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (actionType!=null && !actionType.prune().hasData()) actionType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSupervisoryBody()!=null && !getSupervisoryBody().isEmpty()) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInterAffiliate()!=null) return true;
			if (getActionType()!=null && getActionType().hasData()) return true;
			if (getEventType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder o = (RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getActionType(), o.getActionType(), this::setActionType);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), (Consumer<String>) this::addSupervisoryBody);
			merger.mergeBasic(getInterAffiliate(), o.getInterAffiliate(), this::setInterAffiliate);
			merger.mergeBasic(getEventType(), o.getEventType(), this::setEventType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationCSA_2016 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(interAffiliate, _that.getInterAffiliate())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (interAffiliate != null ? interAffiliate.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationCSA_2016Builder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"interAffiliate=" + this.interAffiliate + ", " +
				"actionType=" + this.actionType + ", " +
				"eventType=" + this.eventType +
			'}' + " " + super.toString();
		}
	}
}
