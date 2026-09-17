package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.reg.fpmlreporting.shared.meta.RegulatorReportingStatusCodeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that can be used to identify the reporting status of a transaction. Examples include FullyReported, ReportedWithWarnings, NotReported, etc.
 *
 */
@RosettaDataType(value="RegulatorReportingStatusCode", builder=RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatorReportingStatusCode", model="fpml", builder=RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilderImpl.class, version="2.1.1")
public interface RegulatorReportingStatusCode extends RosettaModelObject {

	RegulatorReportingStatusCodeMeta metaData = new RegulatorReportingStatusCodeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getReportingStatusScheme();

	/*********************** Build Methods  ***********************/
	RegulatorReportingStatusCode build();
	
	RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder toBuilder();
	
	static RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder builder() {
		return new RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatorReportingStatusCode> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatorReportingStatusCode> getType() {
		return RegulatorReportingStatusCode.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reportingStatusScheme"), String.class, getReportingStatusScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatorReportingStatusCodeBuilder extends RegulatorReportingStatusCode, RosettaModelObjectBuilder {
		RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder setValue(String value);
		RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder setReportingStatusScheme(String reportingStatusScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reportingStatusScheme"), String.class, getReportingStatusScheme(), this);
		}
		

		RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatorReportingStatusCode  ***********************/
	class RegulatorReportingStatusCodeImpl implements RegulatorReportingStatusCode {
		private final String value;
		private final String reportingStatusScheme;
		
		protected RegulatorReportingStatusCodeImpl(RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder builder) {
			this.value = builder.getValue();
			this.reportingStatusScheme = builder.getReportingStatusScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingStatusScheme")
		public String getReportingStatusScheme() {
			return reportingStatusScheme;
		}
		
		@Override
		public RegulatorReportingStatusCode build() {
			return this;
		}
		
		@Override
		public RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder toBuilder() {
			RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReportingStatusScheme()).ifPresent(builder::setReportingStatusScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatorReportingStatusCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingStatusScheme, _that.getReportingStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingStatusScheme != null ? reportingStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatorReportingStatusCode {" +
				"value=" + this.value + ", " +
				"reportingStatusScheme=" + this.reportingStatusScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatorReportingStatusCode  ***********************/
	class RegulatorReportingStatusCodeBuilderImpl implements RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder {
	
		protected String value;
		protected String reportingStatusScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingStatusScheme")
		public String getReportingStatusScheme() {
			return reportingStatusScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("reportingStatusScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingStatusScheme")
		@Override
		public RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder setReportingStatusScheme(String _reportingStatusScheme) {
			this.reportingStatusScheme = _reportingStatusScheme == null ? null : _reportingStatusScheme;
			return this;
		}
		
		@Override
		public RegulatorReportingStatusCode build() {
			return new RegulatorReportingStatusCode.RegulatorReportingStatusCodeImpl(this);
		}
		
		@Override
		public RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReportingStatusScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder o = (RegulatorReportingStatusCode.RegulatorReportingStatusCodeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReportingStatusScheme(), o.getReportingStatusScheme(), this::setReportingStatusScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatorReportingStatusCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingStatusScheme, _that.getReportingStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingStatusScheme != null ? reportingStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatorReportingStatusCodeBuilder {" +
				"value=" + this.value + ", " +
				"reportingStatusScheme=" + this.reportingStatusScheme +
			'}';
		}
	}
}
