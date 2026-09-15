package drr.regulation.common;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import drr.base.trade.ReportingSide;
import drr.regulation.common.meta.RegimeReportingSideMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the reporting roles for a particular regime and supervisory body.
 * @version 7.7.0
 */
@RosettaDataType(value="RegimeReportingSide", builder=RegimeReportingSide.RegimeReportingSideBuilderImpl.class, version="7.7.0")
@RuneDataType(value="RegimeReportingSide", model="drr", builder=RegimeReportingSide.RegimeReportingSideBuilderImpl.class, version="7.7.0")
public interface RegimeReportingSide extends RosettaModelObject {

	RegimeReportingSideMeta metaData = new RegimeReportingSideMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the reporting regime under which this data is reported. For example, Dodd-Frank, MiFID, HongKongOTCDRepository, ODRF
	 */
	RegimeNameEnum getRegimeName();
	/**
	 * Identifies the specific regulator or other supervisory body for which this data is produced. For example, CFTC, SEC, UKFSA, ODRF, SFC, ESMA.
	 */
	SupervisoryBodyEnum getSupervisoryBody();
	/**
	 * Specifies the reporting roles for (self) reporting.
	 */
	ReportingSide getReportingSide();
	/**
	 * Specifies the reporting roles for delegated reporting.
	 */
	ReportingSide getDelegatedReportingSide();

	/*********************** Build Methods  ***********************/
	RegimeReportingSide build();
	
	RegimeReportingSide.RegimeReportingSideBuilder toBuilder();
	
	static RegimeReportingSide.RegimeReportingSideBuilder builder() {
		return new RegimeReportingSide.RegimeReportingSideBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegimeReportingSide> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegimeReportingSide> getType() {
		return RegimeReportingSide.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("regimeName"), RegimeNameEnum.class, getRegimeName(), this);
		processor.processBasic(path.newSubPath("supervisoryBody"), SupervisoryBodyEnum.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.class, getReportingSide());
		processRosetta(path.newSubPath("delegatedReportingSide"), processor, ReportingSide.class, getDelegatedReportingSide());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegimeReportingSideBuilder extends RegimeReportingSide, RosettaModelObjectBuilder {
		ReportingSide.ReportingSideBuilder getOrCreateReportingSide();
		@Override
		ReportingSide.ReportingSideBuilder getReportingSide();
		ReportingSide.ReportingSideBuilder getOrCreateDelegatedReportingSide();
		@Override
		ReportingSide.ReportingSideBuilder getDelegatedReportingSide();
		RegimeReportingSide.RegimeReportingSideBuilder setRegimeName(RegimeNameEnum regimeName);
		RegimeReportingSide.RegimeReportingSideBuilder setSupervisoryBody(SupervisoryBodyEnum supervisoryBody);
		RegimeReportingSide.RegimeReportingSideBuilder setReportingSide(ReportingSide reportingSide);
		RegimeReportingSide.RegimeReportingSideBuilder setDelegatedReportingSide(ReportingSide delegatedReportingSide);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("regimeName"), RegimeNameEnum.class, getRegimeName(), this);
			processor.processBasic(path.newSubPath("supervisoryBody"), SupervisoryBodyEnum.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.ReportingSideBuilder.class, getReportingSide());
			processRosetta(path.newSubPath("delegatedReportingSide"), processor, ReportingSide.ReportingSideBuilder.class, getDelegatedReportingSide());
		}
		

		RegimeReportingSide.RegimeReportingSideBuilder prune();
	}

	/*********************** Immutable Implementation of RegimeReportingSide  ***********************/
	class RegimeReportingSideImpl implements RegimeReportingSide {
		private final RegimeNameEnum regimeName;
		private final SupervisoryBodyEnum supervisoryBody;
		private final ReportingSide reportingSide;
		private final ReportingSide delegatedReportingSide;
		
		protected RegimeReportingSideImpl(RegimeReportingSide.RegimeReportingSideBuilder builder) {
			this.regimeName = builder.getRegimeName();
			this.supervisoryBody = builder.getSupervisoryBody();
			this.reportingSide = ofNullable(builder.getReportingSide()).map(f->f.build()).orElse(null);
			this.delegatedReportingSide = ofNullable(builder.getDelegatedReportingSide()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("regimeName")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("regimeName")
		public RegimeNameEnum getRegimeName() {
			return regimeName;
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBody")
		public SupervisoryBodyEnum getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingSide")
		public ReportingSide getReportingSide() {
			return reportingSide;
		}
		
		@Override
		@RosettaAttribute("delegatedReportingSide")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delegatedReportingSide")
		public ReportingSide getDelegatedReportingSide() {
			return delegatedReportingSide;
		}
		
		@Override
		public RegimeReportingSide build() {
			return this;
		}
		
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder toBuilder() {
			RegimeReportingSide.RegimeReportingSideBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegimeReportingSide.RegimeReportingSideBuilder builder) {
			ofNullable(getRegimeName()).ifPresent(builder::setRegimeName);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingSide()).ifPresent(builder::setReportingSide);
			ofNullable(getDelegatedReportingSide()).ifPresent(builder::setDelegatedReportingSide);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegimeReportingSide _that = getType().cast(o);
		
			if (!Objects.equals(regimeName, _that.getRegimeName())) return false;
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingSide, _that.getReportingSide())) return false;
			if (!Objects.equals(delegatedReportingSide, _that.getDelegatedReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regimeName != null ? regimeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (reportingSide != null ? reportingSide.hashCode() : 0);
			_result = 31 * _result + (delegatedReportingSide != null ? delegatedReportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeReportingSide {" +
				"regimeName=" + this.regimeName + ", " +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingSide=" + this.reportingSide + ", " +
				"delegatedReportingSide=" + this.delegatedReportingSide +
			'}';
		}
	}

	/*********************** Builder Implementation of RegimeReportingSide  ***********************/
	class RegimeReportingSideBuilderImpl implements RegimeReportingSide.RegimeReportingSideBuilder {
	
		protected RegimeNameEnum regimeName;
		protected SupervisoryBodyEnum supervisoryBody;
		protected ReportingSide.ReportingSideBuilder reportingSide;
		protected ReportingSide.ReportingSideBuilder delegatedReportingSide;
		
		@Override
		@RosettaAttribute("regimeName")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("regimeName")
		public RegimeNameEnum getRegimeName() {
			return regimeName;
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBody")
		public SupervisoryBodyEnum getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingSide")
		public ReportingSide.ReportingSideBuilder getReportingSide() {
			return reportingSide;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder getOrCreateReportingSide() {
			ReportingSide.ReportingSideBuilder result;
			if (reportingSide!=null) {
				result = reportingSide;
			}
			else {
				result = reportingSide = ReportingSide.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("delegatedReportingSide")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delegatedReportingSide")
		public ReportingSide.ReportingSideBuilder getDelegatedReportingSide() {
			return delegatedReportingSide;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder getOrCreateDelegatedReportingSide() {
			ReportingSide.ReportingSideBuilder result;
			if (delegatedReportingSide!=null) {
				result = delegatedReportingSide;
			}
			else {
				result = delegatedReportingSide = ReportingSide.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("regimeName")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("regimeName")
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder setRegimeName(RegimeNameEnum _regimeName) {
			this.regimeName = _regimeName == null ? null : _regimeName;
			return this;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("supervisoryBody")
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder setSupervisoryBody(SupervisoryBodyEnum _supervisoryBody) {
			this.supervisoryBody = _supervisoryBody == null ? null : _supervisoryBody;
			return this;
		}
		
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingSide")
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder setReportingSide(ReportingSide _reportingSide) {
			this.reportingSide = _reportingSide == null ? null : _reportingSide.toBuilder();
			return this;
		}
		
		@RosettaAttribute("delegatedReportingSide")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delegatedReportingSide")
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder setDelegatedReportingSide(ReportingSide _delegatedReportingSide) {
			this.delegatedReportingSide = _delegatedReportingSide == null ? null : _delegatedReportingSide.toBuilder();
			return this;
		}
		
		@Override
		public RegimeReportingSide build() {
			return new RegimeReportingSide.RegimeReportingSideImpl(this);
		}
		
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder prune() {
			if (reportingSide!=null && !reportingSide.prune().hasData()) reportingSide = null;
			if (delegatedReportingSide!=null && !delegatedReportingSide.prune().hasData()) delegatedReportingSide = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRegimeName()!=null) return true;
			if (getSupervisoryBody()!=null) return true;
			if (getReportingSide()!=null && getReportingSide().hasData()) return true;
			if (getDelegatedReportingSide()!=null && getDelegatedReportingSide().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegimeReportingSide.RegimeReportingSideBuilder o = (RegimeReportingSide.RegimeReportingSideBuilder) other;
			
			merger.mergeRosetta(getReportingSide(), o.getReportingSide(), this::setReportingSide);
			merger.mergeRosetta(getDelegatedReportingSide(), o.getDelegatedReportingSide(), this::setDelegatedReportingSide);
			
			merger.mergeBasic(getRegimeName(), o.getRegimeName(), this::setRegimeName);
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), this::setSupervisoryBody);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegimeReportingSide _that = getType().cast(o);
		
			if (!Objects.equals(regimeName, _that.getRegimeName())) return false;
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingSide, _that.getReportingSide())) return false;
			if (!Objects.equals(delegatedReportingSide, _that.getDelegatedReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regimeName != null ? regimeName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (reportingSide != null ? reportingSide.hashCode() : 0);
			_result = 31 * _result + (delegatedReportingSide != null ? delegatedReportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeReportingSideBuilder {" +
				"regimeName=" + this.regimeName + ", " +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingSide=" + this.reportingSide + ", " +
				"delegatedReportingSide=" + this.delegatedReportingSide +
			'}';
		}
	}
}
