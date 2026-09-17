package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ReportingRegimeIdentifierMeta;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.ReportingRegimeName;
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
 * Provision A type that provides identification for reporting regimes.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that provides identification for reporting regimes.
 *
 */
@RosettaDataType(value="ReportingRegimeIdentifier", builder=ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReportingRegimeIdentifier", model="fpml", builder=ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilderImpl.class, version="2.1.1")
public interface ReportingRegimeIdentifier extends RosettaModelObject {

	ReportingRegimeIdentifierMeta metaData = new ReportingRegimeIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the reporting regime under which this data is reported. For example, Dodd-Frank, MiFID, HongKongOTCDRepository, ODRF
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the reporting regime under which this data is reported. For example, Dodd-Frank, MiFID, HongKongOTCDRepository, ODRF
	 *
	 */
	ReportingRegimeName getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the specific regulator or other supervisory body for which this data is produced. For example, CFTC, SEC, UKFSA, ODRF, SFC, ESMA.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the specific regulator or other supervisory body for which this data is produced. For example, CFTC, SEC, UKFSA, ODRF, SFC, ESMA.
	 *
	 */
	List<? extends SupervisorRegistration> getSupervisorRegistration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the role of this party in reporting this trade for this regulator; roles could include ReportingParty and Voluntary reporting.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
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
	 * Provision Reports a regulator-specific code for the action associated with this submission. Used, for example, to report the ESMA action type.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reports a regulator-specific code for the action associated with this submission. Used, for example, to report the ESMA action type.
	 *
	 */
	ActionType getActionType();

	/*********************** Build Methods  ***********************/
	ReportingRegimeIdentifier build();
	
	ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder toBuilder();
	
	static ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder builder() {
		return new ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingRegimeIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportingRegimeIdentifier> getType() {
		return ReportingRegimeIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("name"), processor, ReportingRegimeName.class, getName());
		processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.class, getSupervisorRegistration());
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("actionType"), processor, ActionType.class, getActionType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingRegimeIdentifierBuilder extends ReportingRegimeIdentifier, RosettaModelObjectBuilder {
		ReportingRegimeName.ReportingRegimeNameBuilder getOrCreateName();
		@Override
		ReportingRegimeName.ReportingRegimeNameBuilder getName();
		SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int index);
		@Override
		List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration();
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ActionType.ActionTypeBuilder getOrCreateActionType();
		@Override
		ActionType.ActionTypeBuilder getActionType();
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setName(ReportingRegimeName name);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration, int idx);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setReportingRole(ReportingRole reportingRole);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setActionType(ActionType actionType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("name"), processor, ReportingRegimeName.ReportingRegimeNameBuilder.class, getName());
			processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.SupervisorRegistrationBuilder.class, getSupervisorRegistration());
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("actionType"), processor, ActionType.ActionTypeBuilder.class, getActionType());
		}
		

		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingRegimeIdentifier  ***********************/
	class ReportingRegimeIdentifierImpl implements ReportingRegimeIdentifier {
		private final ReportingRegimeName name;
		private final List<? extends SupervisorRegistration> supervisorRegistration;
		private final ReportingRole reportingRole;
		private final ActionType actionType;
		
		protected ReportingRegimeIdentifierImpl(ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder builder) {
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
			this.supervisorRegistration = ofNullable(builder.getSupervisorRegistration()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.actionType = ofNullable(builder.getActionType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public ReportingRegimeName getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRole getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public ActionType getActionType() {
			return actionType;
		}
		
		@Override
		public ReportingRegimeIdentifier build() {
			return this;
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder toBuilder() {
			ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getSupervisorRegistration()).ifPresent(builder::setSupervisorRegistration);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeIdentifier {" +
				"name=" + this.name + ", " +
				"supervisorRegistration=" + this.supervisorRegistration + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"actionType=" + this.actionType +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingRegimeIdentifier  ***********************/
	class ReportingRegimeIdentifierBuilderImpl implements ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder {
	
		protected ReportingRegimeName.ReportingRegimeNameBuilder name;
		protected List<SupervisorRegistration.SupervisorRegistrationBuilder> supervisorRegistration = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected ActionType.ActionTypeBuilder actionType;
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public ReportingRegimeName.ReportingRegimeNameBuilder getName() {
			return name;
		}
		
		@Override
		public ReportingRegimeName.ReportingRegimeNameBuilder getOrCreateName() {
			ReportingRegimeName.ReportingRegimeNameBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = ReportingRegimeName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int index) {
			if (supervisorRegistration==null) {
				this.supervisorRegistration = new ArrayList<>();
			}
			return getIndex(supervisorRegistration, index, () -> {
						SupervisorRegistration.SupervisorRegistrationBuilder newSupervisorRegistration = SupervisorRegistration.builder();
						return newSupervisorRegistration;
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
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setName(ReportingRegimeName _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(SupervisorRegistration _supervisorRegistration) {
			if (_supervisorRegistration != null) {
				this.supervisorRegistration.add(_supervisorRegistration.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(SupervisorRegistration _supervisorRegistration, int idx) {
			getIndex(this.supervisorRegistration, idx, () -> _supervisorRegistration.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations != null) {
				for (final SupervisorRegistration toAdd : supervisorRegistrations) {
					this.supervisorRegistration.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations == null) {
				this.supervisorRegistration = new ArrayList<>();
			} else {
				this.supervisorRegistration = supervisorRegistrations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingRole")
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setActionType(ActionType _actionType) {
			this.actionType = _actionType == null ? null : _actionType.toBuilder();
			return this;
		}
		
		@Override
		public ReportingRegimeIdentifier build() {
			return new ReportingRegimeIdentifier.ReportingRegimeIdentifierImpl(this);
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder prune() {
			if (name!=null && !name.prune().hasData()) name = null;
			supervisorRegistration = supervisorRegistration.stream().filter(b->b!=null).<SupervisorRegistration.SupervisorRegistrationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			if (actionType!=null && !actionType.prune().hasData()) actionType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null && getName().hasData()) return true;
			if (getSupervisorRegistration()!=null && getSupervisorRegistration().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getActionType()!=null && getActionType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder o = (ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder) other;
			
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			merger.mergeRosetta(getSupervisorRegistration(), o.getSupervisorRegistration(), this::getOrCreateSupervisorRegistration);
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getActionType(), o.getActionType(), this::setActionType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeIdentifierBuilder {" +
				"name=" + this.name + ", " +
				"supervisorRegistration=" + this.supervisorRegistration + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"actionType=" + this.actionType +
			'}';
		}
	}
}
