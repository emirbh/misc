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
import fpml.consolidated.msg.meta.ReportSectionIdentificationMeta;
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
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that allows the specific report and section to be identified.
 *
 */
@RosettaDataType(value="ReportSectionIdentification", builder=ReportSectionIdentification.ReportSectionIdentificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReportSectionIdentification", model="fpml", builder=ReportSectionIdentification.ReportSectionIdentificationBuilderImpl.class, version="2.1.1")
public interface ReportSectionIdentification extends RosettaModelObject {

	ReportSectionIdentificationMeta metaData = new ReportSectionIdentificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An identifier for the specific instance of this report.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An identifier for the specific instance of this report.
	 *
	 */
	ReportId getReportId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A strictly ascending sequential (gapless) numeric value that can be used to identify the section of a report.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A strictly ascending sequential (gapless) numeric value that can be used to identify the section of a report.
	 *
	 */
	Integer getSectionNumber();

	/*********************** Build Methods  ***********************/
	ReportSectionIdentification build();
	
	ReportSectionIdentification.ReportSectionIdentificationBuilder toBuilder();
	
	static ReportSectionIdentification.ReportSectionIdentificationBuilder builder() {
		return new ReportSectionIdentification.ReportSectionIdentificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportSectionIdentification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportSectionIdentification> getType() {
		return ReportSectionIdentification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reportId"), processor, ReportId.class, getReportId());
		processor.processBasic(path.newSubPath("sectionNumber"), Integer.class, getSectionNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportSectionIdentificationBuilder extends ReportSectionIdentification, RosettaModelObjectBuilder {
		ReportId.ReportIdBuilder getOrCreateReportId();
		@Override
		ReportId.ReportIdBuilder getReportId();
		ReportSectionIdentification.ReportSectionIdentificationBuilder setReportId(ReportId reportId);
		ReportSectionIdentification.ReportSectionIdentificationBuilder setSectionNumber(Integer sectionNumber);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reportId"), processor, ReportId.ReportIdBuilder.class, getReportId());
			processor.processBasic(path.newSubPath("sectionNumber"), Integer.class, getSectionNumber(), this);
		}
		

		ReportSectionIdentification.ReportSectionIdentificationBuilder prune();
	}

	/*********************** Immutable Implementation of ReportSectionIdentification  ***********************/
	class ReportSectionIdentificationImpl implements ReportSectionIdentification {
		private final ReportId reportId;
		private final Integer sectionNumber;
		
		protected ReportSectionIdentificationImpl(ReportSectionIdentification.ReportSectionIdentificationBuilder builder) {
			this.reportId = ofNullable(builder.getReportId()).map(f->f.build()).orElse(null);
			this.sectionNumber = builder.getSectionNumber();
		}
		
		@Override
		@RosettaAttribute("reportId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportId")
		public ReportId getReportId() {
			return reportId;
		}
		
		@Override
		@RosettaAttribute("sectionNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sectionNumber")
		public Integer getSectionNumber() {
			return sectionNumber;
		}
		
		@Override
		public ReportSectionIdentification build() {
			return this;
		}
		
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder toBuilder() {
			ReportSectionIdentification.ReportSectionIdentificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportSectionIdentification.ReportSectionIdentificationBuilder builder) {
			ofNullable(getReportId()).ifPresent(builder::setReportId);
			ofNullable(getSectionNumber()).ifPresent(builder::setSectionNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportSectionIdentification _that = getType().cast(o);
		
			if (!Objects.equals(reportId, _that.getReportId())) return false;
			if (!Objects.equals(sectionNumber, _that.getSectionNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportId != null ? reportId.hashCode() : 0);
			_result = 31 * _result + (sectionNumber != null ? sectionNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportSectionIdentification {" +
				"reportId=" + this.reportId + ", " +
				"sectionNumber=" + this.sectionNumber +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportSectionIdentification  ***********************/
	class ReportSectionIdentificationBuilderImpl implements ReportSectionIdentification.ReportSectionIdentificationBuilder {
	
		protected ReportId.ReportIdBuilder reportId;
		protected Integer sectionNumber;
		
		@Override
		@RosettaAttribute("reportId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportId")
		public ReportId.ReportIdBuilder getReportId() {
			return reportId;
		}
		
		@Override
		public ReportId.ReportIdBuilder getOrCreateReportId() {
			ReportId.ReportIdBuilder result;
			if (reportId!=null) {
				result = reportId;
			}
			else {
				result = reportId = ReportId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sectionNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sectionNumber")
		public Integer getSectionNumber() {
			return sectionNumber;
		}
		
		@RosettaAttribute("reportId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportId")
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder setReportId(ReportId _reportId) {
			this.reportId = _reportId == null ? null : _reportId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sectionNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sectionNumber")
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder setSectionNumber(Integer _sectionNumber) {
			this.sectionNumber = _sectionNumber == null ? null : _sectionNumber;
			return this;
		}
		
		@Override
		public ReportSectionIdentification build() {
			return new ReportSectionIdentification.ReportSectionIdentificationImpl(this);
		}
		
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder prune() {
			if (reportId!=null && !reportId.prune().hasData()) reportId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportId()!=null && getReportId().hasData()) return true;
			if (getSectionNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportSectionIdentification.ReportSectionIdentificationBuilder o = (ReportSectionIdentification.ReportSectionIdentificationBuilder) other;
			
			merger.mergeRosetta(getReportId(), o.getReportId(), this::setReportId);
			
			merger.mergeBasic(getSectionNumber(), o.getSectionNumber(), this::setSectionNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportSectionIdentification _that = getType().cast(o);
		
			if (!Objects.equals(reportId, _that.getReportId())) return false;
			if (!Objects.equals(sectionNumber, _that.getSectionNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportId != null ? reportId.hashCode() : 0);
			_result = 31 * _result + (sectionNumber != null ? sectionNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportSectionIdentificationBuilder {" +
				"reportId=" + this.reportId + ", " +
				"sectionNumber=" + this.sectionNumber +
			'}';
		}
	}
}
