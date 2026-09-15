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
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationASIC_2013Meta;
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
@RosettaDataType(value="RegulatoryClassificationASIC_2013", builder=RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationASIC_2013", model="fpml", builder=RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationASIC_2013 extends RegulatoryClassification {

	RegulatoryClassificationASIC_2013Meta metaData = new RegulatoryClassificationASIC_2013Meta();

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
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). A notation to indicate whether the report being made relates to : (a) a Reportable Transaction that is an entry into of an arrangement that is a Derivative, in which case the notation must be "new"; (b) a Reportable Transaction that is a modification of an arrangement that is a Derivative, in which case the notation must be "modify"; (c) a Reportable Transaction that is a termination of an arrangement that is a Derivative, in which case the notation must be "cancel"; or (d) a compression of a Derivative, in which case the notation must be "compression". For the purposes of subrule 2.2.2(1), a notation to indicate whether the change relates to: (a) a cancellation of a report previously made in error, in which case, the notation must be "error"; (b) a change or update to the information referred to in items 30-32 (mark-to-market, mark-to-model, or other valuation) or items 40-44 (collateral), in which case the notation must be "valuation update"; or (c) any other amendments to a report previously made, in which case the notation must be "other".
	 *
	 */
	ActionType getActionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). If the Reporting Entity is not an Australian ADI, an AFS Licensee, a CS Facility Licensee, an Exempt Foreign Licensee or a Foreign ADI, an indication of whether the Derivative to which the Reportable Transaction relates is entered into by the Reporting Entity for the purpose of managing a financial risk that arises in the ordinary course of business.
	 *
	 */
	Boolean getIsAccountingHedge();

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationASIC_2013 build();
	
	RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder toBuilder();
	
	static RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder builder() {
		return new RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationASIC_2013> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationASIC_2013> getType() {
		return RegulatoryClassificationASIC_2013.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processor.processBasic(path.newSubPath("interAffiliate"), Boolean.class, getInterAffiliate(), this);
		processRosetta(path.newSubPath("actionType"), processor, ActionType.class, getActionType());
		processor.processBasic(path.newSubPath("isAccountingHedge"), Boolean.class, getIsAccountingHedge(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationASIC_2013Builder extends RegulatoryClassificationASIC_2013, RegulatoryClassification.RegulatoryClassificationBuilder {
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index);
		@Override
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		ActionType.ActionTypeBuilder getOrCreateActionType();
		@Override
		ActionType.ActionTypeBuilder getActionType();
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addSupervisoryBody(String supervisoryBody);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addSupervisoryBody(String supervisoryBody, int idx);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setInterAffiliate(Boolean interAffiliate);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setActionType(ActionType actionType);
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setIsAccountingHedge(Boolean isAccountingHedge);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processor.processBasic(path.newSubPath("interAffiliate"), Boolean.class, getInterAffiliate(), this);
			processRosetta(path.newSubPath("actionType"), processor, ActionType.ActionTypeBuilder.class, getActionType());
			processor.processBasic(path.newSubPath("isAccountingHedge"), Boolean.class, getIsAccountingHedge(), this);
		}
		

		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationASIC_2013  ***********************/
	class RegulatoryClassificationASIC_2013Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationASIC_2013 {
		private final List<String> supervisoryBody;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final Boolean interAffiliate;
		private final ActionType actionType;
		private final Boolean isAccountingHedge;
		
		protected RegulatoryClassificationASIC_2013Impl(RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder builder) {
			super(builder);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.interAffiliate = builder.getInterAffiliate();
			this.actionType = ofNullable(builder.getActionType()).map(f->f.build()).orElse(null);
			this.isAccountingHedge = builder.getIsAccountingHedge();
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
		@RosettaAttribute("isAccountingHedge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isAccountingHedge")
		public Boolean getIsAccountingHedge() {
			return isAccountingHedge;
		}
		
		@Override
		public RegulatoryClassificationASIC_2013 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder toBuilder() {
			RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getInterAffiliate()).ifPresent(builder::setInterAffiliate);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
			ofNullable(getIsAccountingHedge()).ifPresent(builder::setIsAccountingHedge);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationASIC_2013 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(interAffiliate, _that.getInterAffiliate())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(isAccountingHedge, _that.getIsAccountingHedge())) return false;
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
			_result = 31 * _result + (isAccountingHedge != null ? isAccountingHedge.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationASIC_2013 {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"interAffiliate=" + this.interAffiliate + ", " +
				"actionType=" + this.actionType + ", " +
				"isAccountingHedge=" + this.isAccountingHedge +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationASIC_2013  ***********************/
	class RegulatoryClassificationASIC_2013BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder {
	
		protected List<String> supervisoryBody = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected Boolean interAffiliate;
		protected ActionType.ActionTypeBuilder actionType;
		protected Boolean isAccountingHedge;
		
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
		@RosettaAttribute("isAccountingHedge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isAccountingHedge")
		public Boolean getIsAccountingHedge() {
			return isAccountingHedge;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addSupervisoryBody(String _supervisoryBody) {
			if (_supervisoryBody != null) {
				this.supervisoryBody.add(_supervisoryBody);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addSupervisoryBody(String _supervisoryBody, int idx) {
			getIndex(this.supervisoryBody, idx, () -> _supervisoryBody);
			return this;
		}
		
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setInterAffiliate(Boolean _interAffiliate) {
			this.interAffiliate = _interAffiliate == null ? null : _interAffiliate;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setActionType(ActionType _actionType) {
			this.actionType = _actionType == null ? null : _actionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isAccountingHedge")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isAccountingHedge")
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder setIsAccountingHedge(Boolean _isAccountingHedge) {
			this.isAccountingHedge = _isAccountingHedge == null ? null : _isAccountingHedge;
			return this;
		}
		
		@Override
		public RegulatoryClassificationASIC_2013 build() {
			return new RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Impl(this);
		}
		
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder prune() {
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
			if (getIsAccountingHedge()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder o = (RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getActionType(), o.getActionType(), this::setActionType);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), (Consumer<String>) this::addSupervisoryBody);
			merger.mergeBasic(getInterAffiliate(), o.getInterAffiliate(), this::setInterAffiliate);
			merger.mergeBasic(getIsAccountingHedge(), o.getIsAccountingHedge(), this::setIsAccountingHedge);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationASIC_2013 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(interAffiliate, _that.getInterAffiliate())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(isAccountingHedge, _that.getIsAccountingHedge())) return false;
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
			_result = 31 * _result + (isAccountingHedge != null ? isAccountingHedge.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationASIC_2013Builder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"interAffiliate=" + this.interAffiliate + ", " +
				"actionType=" + this.actionType + ", " +
				"isAccountingHedge=" + this.isAccountingHedge +
			'}' + " " + super.toString();
		}
	}
}
