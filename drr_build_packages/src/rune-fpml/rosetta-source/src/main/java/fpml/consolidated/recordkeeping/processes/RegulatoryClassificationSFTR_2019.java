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
import fpml.consolidated.doc.ReportingLevel;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationSFTR_2019Meta;
import fpml.consolidated.shared.ActionType;
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
 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
 *
 */
@RosettaDataType(value="RegulatoryClassificationSFTR_2019", builder=RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationSFTR_2019", model="fpml", builder=RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationSFTR_2019 extends RegulatoryClassification {

	RegulatoryClassificationSFTR_2019Meta metaData = new RegulatoryClassificationSFTR_2019Meta();

	/*********************** Getter Methods  ***********************/
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
	 * Provision An indication whether the report is done at trade or position level. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ReportingLevel getReportingLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision SFTR notation to indicate whether the report is New, Modification, Valuation, Collateral update, Error, Correction, Termination / Early Termination or Position component DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ActionType getActionType();

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationSFTR_2019 build();
	
	RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder toBuilder();
	
	static RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder builder() {
		return new RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationSFTR_2019> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationSFTR_2019> getType() {
		return RegulatoryClassificationSFTR_2019.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processRosetta(path.newSubPath("reportingLevel"), processor, ReportingLevel.class, getReportingLevel());
		processRosetta(path.newSubPath("actionType"), processor, ActionType.class, getActionType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationSFTR_2019Builder extends RegulatoryClassificationSFTR_2019, RegulatoryClassification.RegulatoryClassificationBuilder {
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index);
		@Override
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		ReportingLevel.ReportingLevelBuilder getOrCreateReportingLevel();
		@Override
		ReportingLevel.ReportingLevelBuilder getReportingLevel();
		ActionType.ActionTypeBuilder getOrCreateActionType();
		@Override
		ActionType.ActionTypeBuilder getActionType();
		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder setReportingLevel(ReportingLevel reportingLevel);
		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder setActionType(ActionType actionType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processRosetta(path.newSubPath("reportingLevel"), processor, ReportingLevel.ReportingLevelBuilder.class, getReportingLevel());
			processRosetta(path.newSubPath("actionType"), processor, ActionType.ActionTypeBuilder.class, getActionType());
		}
		

		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationSFTR_2019  ***********************/
	class RegulatoryClassificationSFTR_2019Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationSFTR_2019 {
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final ReportingLevel reportingLevel;
		private final ActionType actionType;
		
		protected RegulatoryClassificationSFTR_2019Impl(RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder builder) {
			super(builder);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingLevel = ofNullable(builder.getReportingLevel()).map(f->f.build()).orElse(null);
			this.actionType = ofNullable(builder.getActionType()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("reportingLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingLevel")
		public ReportingLevel getReportingLevel() {
			return reportingLevel;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public ActionType getActionType() {
			return actionType;
		}
		
		@Override
		public RegulatoryClassificationSFTR_2019 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder toBuilder() {
			RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getReportingLevel()).ifPresent(builder::setReportingLevel);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationSFTR_2019 _that = getType().cast(o);
		
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(reportingLevel, _that.getReportingLevel())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (reportingLevel != null ? reportingLevel.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationSFTR_2019 {" +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"reportingLevel=" + this.reportingLevel + ", " +
				"actionType=" + this.actionType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationSFTR_2019  ***********************/
	class RegulatoryClassificationSFTR_2019BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder {
	
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected ReportingLevel.ReportingLevelBuilder reportingLevel;
		protected ActionType.ActionTypeBuilder actionType;
		
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
		@RosettaAttribute("reportingLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingLevel")
		public ReportingLevel.ReportingLevelBuilder getReportingLevel() {
			return reportingLevel;
		}
		
		@Override
		public ReportingLevel.ReportingLevelBuilder getOrCreateReportingLevel() {
			ReportingLevel.ReportingLevelBuilder result;
			if (reportingLevel!=null) {
				result = reportingLevel;
			}
			else {
				result = reportingLevel = ReportingLevel.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingRole")
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes == null) {
				this.reportingPurpose = new ArrayList<>();
			} else {
				this.reportingPurpose = reportingPurposes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingLevel")
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder setReportingLevel(ReportingLevel _reportingLevel) {
			this.reportingLevel = _reportingLevel == null ? null : _reportingLevel.toBuilder();
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder setActionType(ActionType _actionType) {
			this.actionType = _actionType == null ? null : _actionType.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryClassificationSFTR_2019 build() {
			return new RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Impl(this);
		}
		
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder prune() {
			super.prune();
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (reportingLevel!=null && !reportingLevel.prune().hasData()) reportingLevel = null;
			if (actionType!=null && !actionType.prune().hasData()) actionType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingLevel()!=null && getReportingLevel().hasData()) return true;
			if (getActionType()!=null && getActionType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder o = (RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getReportingLevel(), o.getReportingLevel(), this::setReportingLevel);
			merger.mergeRosetta(getActionType(), o.getActionType(), this::setActionType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationSFTR_2019 _that = getType().cast(o);
		
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(reportingLevel, _that.getReportingLevel())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (reportingLevel != null ? reportingLevel.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationSFTR_2019Builder {" +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"reportingLevel=" + this.reportingLevel + ", " +
				"actionType=" + this.actionType +
			'}' + " " + super.toString();
		}
	}
}
