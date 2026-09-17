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
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationMAS_2013Meta;
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
@RosettaDataType(value="RegulatoryClassificationMAS_2013", builder=RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationMAS_2013", model="fpml", builder=RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationMAS_2013 extends RegulatoryClassification {

	RegulatoryClassificationMAS_2013Meta metaData = new RegulatoryClassificationMAS_2013Meta();

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

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationMAS_2013 build();
	
	RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder toBuilder();
	
	static RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder builder() {
		return new RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationMAS_2013> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationMAS_2013> getType() {
		return RegulatoryClassificationMAS_2013.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processor.processBasic(path.newSubPath("interAffiliate"), Boolean.class, getInterAffiliate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationMAS_2013Builder extends RegulatoryClassificationMAS_2013, RegulatoryClassification.RegulatoryClassificationBuilder {
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index);
		@Override
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addSupervisoryBody(String supervisoryBody);
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addSupervisoryBody(String supervisoryBody, int idx);
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder setSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder setInterAffiliate(Boolean interAffiliate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processor.processBasic(path.newSubPath("interAffiliate"), Boolean.class, getInterAffiliate(), this);
		}
		

		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationMAS_2013  ***********************/
	class RegulatoryClassificationMAS_2013Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationMAS_2013 {
		private final List<String> supervisoryBody;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final Boolean interAffiliate;
		
		protected RegulatoryClassificationMAS_2013Impl(RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder builder) {
			super(builder);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.interAffiliate = builder.getInterAffiliate();
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
		public RegulatoryClassificationMAS_2013 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder toBuilder() {
			RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getInterAffiliate()).ifPresent(builder::setInterAffiliate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationMAS_2013 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(interAffiliate, _that.getInterAffiliate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (interAffiliate != null ? interAffiliate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationMAS_2013 {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"interAffiliate=" + this.interAffiliate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationMAS_2013  ***********************/
	class RegulatoryClassificationMAS_2013BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder {
	
		protected List<String> supervisoryBody = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected Boolean interAffiliate;
		
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
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addSupervisoryBody(String _supervisoryBody) {
			if (_supervisoryBody != null) {
				this.supervisoryBody.add(_supervisoryBody);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addSupervisoryBody(String _supervisoryBody, int idx) {
			getIndex(this.supervisoryBody, idx, () -> _supervisoryBody);
			return this;
		}
		
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder setSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder setInterAffiliate(Boolean _interAffiliate) {
			this.interAffiliate = _interAffiliate == null ? null : _interAffiliate;
			return this;
		}
		
		@Override
		public RegulatoryClassificationMAS_2013 build() {
			return new RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Impl(this);
		}
		
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder prune() {
			super.prune();
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSupervisoryBody()!=null && !getSupervisoryBody().isEmpty()) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInterAffiliate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder o = (RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), (Consumer<String>) this::addSupervisoryBody);
			merger.mergeBasic(getInterAffiliate(), o.getInterAffiliate(), this::setInterAffiliate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationMAS_2013 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(interAffiliate, _that.getInterAffiliate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (interAffiliate != null ? interAffiliate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationMAS_2013Builder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"interAffiliate=" + this.interAffiliate +
			'}' + " " + super.toString();
		}
	}
}
