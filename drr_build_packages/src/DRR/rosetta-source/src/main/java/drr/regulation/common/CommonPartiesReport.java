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
import drr.regulation.common.meta.CommonPartiesReportMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Common Parties Report represents common party attributes used in Margin Report
 * @version 7.7.0
 */
@RosettaDataType(value="CommonPartiesReport", builder=CommonPartiesReport.CommonPartiesReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CommonPartiesReport", model="drr", builder=CommonPartiesReport.CommonPartiesReportBuilderImpl.class, version="7.7.0")
public interface CommonPartiesReport extends RosettaModelObject {

	CommonPartiesReportMeta metaData = new CommonPartiesReportMeta();

	/*********************** Getter Methods  ***********************/
	ZonedDateTime getReportingTimestamp();
	String getEntityResponsibleForReporting();
	String getCounterparty1();
	Boolean getCounterparty2IdentifierType();
	String getCounterparty2();

	/*********************** Build Methods  ***********************/
	CommonPartiesReport build();
	
	CommonPartiesReport.CommonPartiesReportBuilder toBuilder();
	
	static CommonPartiesReport.CommonPartiesReportBuilder builder() {
		return new CommonPartiesReport.CommonPartiesReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonPartiesReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonPartiesReport> getType() {
		return CommonPartiesReport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
		processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
		processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
		processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonPartiesReportBuilder extends CommonPartiesReport, RosettaModelObjectBuilder {
		CommonPartiesReport.CommonPartiesReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		CommonPartiesReport.CommonPartiesReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		CommonPartiesReport.CommonPartiesReportBuilder setCounterparty1(String counterparty1);
		CommonPartiesReport.CommonPartiesReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		CommonPartiesReport.CommonPartiesReportBuilder setCounterparty2(String counterparty2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
			processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
			processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
			processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
		}
		

		CommonPartiesReport.CommonPartiesReportBuilder prune();
	}

	/*********************** Immutable Implementation of CommonPartiesReport  ***********************/
	class CommonPartiesReportImpl implements CommonPartiesReport {
		private final ZonedDateTime reportingTimestamp;
		private final String entityResponsibleForReporting;
		private final String counterparty1;
		private final Boolean counterparty2IdentifierType;
		private final String counterparty2;
		
		protected CommonPartiesReportImpl(CommonPartiesReport.CommonPartiesReportBuilder builder) {
			this.reportingTimestamp = builder.getReportingTimestamp();
			this.entityResponsibleForReporting = builder.getEntityResponsibleForReporting();
			this.counterparty1 = builder.getCounterparty1();
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.counterparty2 = builder.getCounterparty2();
		}
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@Override
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty1")
		public String getCounterparty1() {
			return counterparty1;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
		}
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
		}
		
		@Override
		public CommonPartiesReport build() {
			return this;
		}
		
		@Override
		public CommonPartiesReport.CommonPartiesReportBuilder toBuilder() {
			CommonPartiesReport.CommonPartiesReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonPartiesReport.CommonPartiesReportBuilder builder) {
			ofNullable(getReportingTimestamp()).ifPresent(builder::setReportingTimestamp);
			ofNullable(getEntityResponsibleForReporting()).ifPresent(builder::setEntityResponsibleForReporting);
			ofNullable(getCounterparty1()).ifPresent(builder::setCounterparty1);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierType);
			ofNullable(getCounterparty2()).ifPresent(builder::setCounterparty2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonPartiesReport _that = getType().cast(o);
		
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(counterparty1, _that.getCounterparty1())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (counterparty1 != null ? counterparty1.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonPartiesReport {" +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"counterparty1=" + this.counterparty1 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"counterparty2=" + this.counterparty2 +
			'}';
		}
	}

	/*********************** Builder Implementation of CommonPartiesReport  ***********************/
	class CommonPartiesReportBuilderImpl implements CommonPartiesReport.CommonPartiesReportBuilder {
	
		protected ZonedDateTime reportingTimestamp;
		protected String entityResponsibleForReporting;
		protected String counterparty1;
		protected Boolean counterparty2IdentifierType;
		protected String counterparty2;
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@Override
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty1")
		public String getCounterparty1() {
			return counterparty1;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
		}
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CommonPartiesReport.CommonPartiesReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public CommonPartiesReport.CommonPartiesReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CommonPartiesReport.CommonPartiesReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CommonPartiesReport.CommonPartiesReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public CommonPartiesReport.CommonPartiesReportBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@Override
		public CommonPartiesReport build() {
			return new CommonPartiesReport.CommonPartiesReportImpl(this);
		}
		
		@Override
		public CommonPartiesReport.CommonPartiesReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonPartiesReport.CommonPartiesReportBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportingTimestamp()!=null) return true;
			if (getEntityResponsibleForReporting()!=null) return true;
			if (getCounterparty1()!=null) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getCounterparty2()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonPartiesReport.CommonPartiesReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonPartiesReport.CommonPartiesReportBuilder o = (CommonPartiesReport.CommonPartiesReportBuilder) other;
			
			
			merger.mergeBasic(getReportingTimestamp(), o.getReportingTimestamp(), this::setReportingTimestamp);
			merger.mergeBasic(getEntityResponsibleForReporting(), o.getEntityResponsibleForReporting(), this::setEntityResponsibleForReporting);
			merger.mergeBasic(getCounterparty1(), o.getCounterparty1(), this::setCounterparty1);
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierType);
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonPartiesReport _that = getType().cast(o);
		
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(counterparty1, _that.getCounterparty1())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (counterparty1 != null ? counterparty1.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonPartiesReportBuilder {" +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"counterparty1=" + this.counterparty1 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"counterparty2=" + this.counterparty2 +
			'}';
		}
	}
}
