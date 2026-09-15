package fpml.consolidated.msg;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.msg.meta.ReportIdentificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that allows the specific report and section to be identified.
 *
 */
@RosettaDataType(value="ReportIdentification", builder=ReportIdentification.ReportIdentificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReportIdentification", model="fpml", builder=ReportIdentification.ReportIdentificationBuilderImpl.class, version="2.1.1")
public interface ReportIdentification extends ReportSectionIdentification {

	ReportIdentificationMeta metaData = new ReportIdentificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A numeric value, optionally supplied by the sender, that can be used to specify the number of sections constituting a report.
	 *
	 */
	Integer getNumberOfSections();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether all sections have been sent for this report instance ID.
	 *
	 */
	Boolean getSubmissionsComplete();

	/*********************** Build Methods  ***********************/
	ReportIdentification build();
	
	ReportIdentification.ReportIdentificationBuilder toBuilder();
	
	static ReportIdentification.ReportIdentificationBuilder builder() {
		return new ReportIdentification.ReportIdentificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportIdentification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportIdentification> getType() {
		return ReportIdentification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reportId"), processor, ReportId.class, getReportId());
		processor.processBasic(path.newSubPath("sectionNumber"), Integer.class, getSectionNumber(), this);
		processor.processBasic(path.newSubPath("numberOfSections"), Integer.class, getNumberOfSections(), this);
		processor.processBasic(path.newSubPath("submissionsComplete"), Boolean.class, getSubmissionsComplete(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportIdentificationBuilder extends ReportIdentification, ReportSectionIdentification.ReportSectionIdentificationBuilder {
		@Override
		ReportIdentification.ReportIdentificationBuilder setReportId(ReportId reportId);
		@Override
		ReportIdentification.ReportIdentificationBuilder setSectionNumber(Integer sectionNumber);
		ReportIdentification.ReportIdentificationBuilder setNumberOfSections(Integer numberOfSections);
		ReportIdentification.ReportIdentificationBuilder setSubmissionsComplete(Boolean submissionsComplete);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reportId"), processor, ReportId.ReportIdBuilder.class, getReportId());
			processor.processBasic(path.newSubPath("sectionNumber"), Integer.class, getSectionNumber(), this);
			processor.processBasic(path.newSubPath("numberOfSections"), Integer.class, getNumberOfSections(), this);
			processor.processBasic(path.newSubPath("submissionsComplete"), Boolean.class, getSubmissionsComplete(), this);
		}
		

		ReportIdentification.ReportIdentificationBuilder prune();
	}

	/*********************** Immutable Implementation of ReportIdentification  ***********************/
	class ReportIdentificationImpl extends ReportSectionIdentification.ReportSectionIdentificationImpl implements ReportIdentification {
		private final Integer numberOfSections;
		private final Boolean submissionsComplete;
		
		protected ReportIdentificationImpl(ReportIdentification.ReportIdentificationBuilder builder) {
			super(builder);
			this.numberOfSections = builder.getNumberOfSections();
			this.submissionsComplete = builder.getSubmissionsComplete();
		}
		
		@Override
		@RosettaAttribute("numberOfSections")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfSections")
		public Integer getNumberOfSections() {
			return numberOfSections;
		}
		
		@Override
		@RosettaAttribute("submissionsComplete")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submissionsComplete")
		public Boolean getSubmissionsComplete() {
			return submissionsComplete;
		}
		
		@Override
		public ReportIdentification build() {
			return this;
		}
		
		@Override
		public ReportIdentification.ReportIdentificationBuilder toBuilder() {
			ReportIdentification.ReportIdentificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportIdentification.ReportIdentificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNumberOfSections()).ifPresent(builder::setNumberOfSections);
			ofNullable(getSubmissionsComplete()).ifPresent(builder::setSubmissionsComplete);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReportIdentification _that = getType().cast(o);
		
			if (!Objects.equals(numberOfSections, _that.getNumberOfSections())) return false;
			if (!Objects.equals(submissionsComplete, _that.getSubmissionsComplete())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (numberOfSections != null ? numberOfSections.hashCode() : 0);
			_result = 31 * _result + (submissionsComplete != null ? submissionsComplete.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportIdentification {" +
				"numberOfSections=" + this.numberOfSections + ", " +
				"submissionsComplete=" + this.submissionsComplete +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReportIdentification  ***********************/
	class ReportIdentificationBuilderImpl extends ReportSectionIdentification.ReportSectionIdentificationBuilderImpl implements ReportIdentification.ReportIdentificationBuilder {
	
		protected Integer numberOfSections;
		protected Boolean submissionsComplete;
		
		@Override
		@RosettaAttribute("numberOfSections")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfSections")
		public Integer getNumberOfSections() {
			return numberOfSections;
		}
		
		@Override
		@RosettaAttribute("submissionsComplete")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submissionsComplete")
		public Boolean getSubmissionsComplete() {
			return submissionsComplete;
		}
		
		@RosettaAttribute("reportId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportId")
		@Override
		public ReportIdentification.ReportIdentificationBuilder setReportId(ReportId _reportId) {
			this.reportId = _reportId == null ? null : _reportId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sectionNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sectionNumber")
		@Override
		public ReportIdentification.ReportIdentificationBuilder setSectionNumber(Integer _sectionNumber) {
			this.sectionNumber = _sectionNumber == null ? null : _sectionNumber;
			return this;
		}
		
		@RosettaAttribute("numberOfSections")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfSections")
		@Override
		public ReportIdentification.ReportIdentificationBuilder setNumberOfSections(Integer _numberOfSections) {
			this.numberOfSections = _numberOfSections == null ? null : _numberOfSections;
			return this;
		}
		
		@RosettaAttribute("submissionsComplete")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("submissionsComplete")
		@Override
		public ReportIdentification.ReportIdentificationBuilder setSubmissionsComplete(Boolean _submissionsComplete) {
			this.submissionsComplete = _submissionsComplete == null ? null : _submissionsComplete;
			return this;
		}
		
		@Override
		public ReportIdentification build() {
			return new ReportIdentification.ReportIdentificationImpl(this);
		}
		
		@Override
		public ReportIdentification.ReportIdentificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportIdentification.ReportIdentificationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNumberOfSections()!=null) return true;
			if (getSubmissionsComplete()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportIdentification.ReportIdentificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReportIdentification.ReportIdentificationBuilder o = (ReportIdentification.ReportIdentificationBuilder) other;
			
			
			merger.mergeBasic(getNumberOfSections(), o.getNumberOfSections(), this::setNumberOfSections);
			merger.mergeBasic(getSubmissionsComplete(), o.getSubmissionsComplete(), this::setSubmissionsComplete);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReportIdentification _that = getType().cast(o);
		
			if (!Objects.equals(numberOfSections, _that.getNumberOfSections())) return false;
			if (!Objects.equals(submissionsComplete, _that.getSubmissionsComplete())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (numberOfSections != null ? numberOfSections.hashCode() : 0);
			_result = 31 * _result + (submissionsComplete != null ? submissionsComplete.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportIdentificationBuilder {" +
				"numberOfSections=" + this.numberOfSections + ", " +
				"submissionsComplete=" + this.submissionsComplete +
			'}' + " " + super.toString();
		}
	}
}
