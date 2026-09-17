package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ReportingBooleanMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision How a Boolean value is to be reported for this regulator. Typically "true" or "false", but for ESMA "X" is also allowed, to indicate not supplied.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision How a Boolean value is to be reported for this regulator. Typically "true" or "false", but for ESMA "X" is also allowed, to indicate not supplied.
 *
 */
@RosettaDataType(value="ReportingBoolean", builder=ReportingBoolean.ReportingBooleanBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReportingBoolean", model="fpml", builder=ReportingBoolean.ReportingBooleanBuilderImpl.class, version="2.1.1")
public interface ReportingBoolean extends RosettaModelObject {

	ReportingBooleanMeta metaData = new ReportingBooleanMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
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
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getReportingBooleanScheme();

	/*********************** Build Methods  ***********************/
	ReportingBoolean build();
	
	ReportingBoolean.ReportingBooleanBuilder toBuilder();
	
	static ReportingBoolean.ReportingBooleanBuilder builder() {
		return new ReportingBoolean.ReportingBooleanBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingBoolean> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportingBoolean> getType() {
		return ReportingBoolean.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reportingBooleanScheme"), String.class, getReportingBooleanScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingBooleanBuilder extends ReportingBoolean, RosettaModelObjectBuilder {
		ReportingBoolean.ReportingBooleanBuilder setValue(String value);
		ReportingBoolean.ReportingBooleanBuilder setReportingBooleanScheme(String reportingBooleanScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reportingBooleanScheme"), String.class, getReportingBooleanScheme(), this);
		}
		

		ReportingBoolean.ReportingBooleanBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingBoolean  ***********************/
	class ReportingBooleanImpl implements ReportingBoolean {
		private final String value;
		private final String reportingBooleanScheme;
		
		protected ReportingBooleanImpl(ReportingBoolean.ReportingBooleanBuilder builder) {
			this.value = builder.getValue();
			this.reportingBooleanScheme = builder.getReportingBooleanScheme();
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
		@RosettaAttribute("reportingBooleanScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingBooleanScheme")
		public String getReportingBooleanScheme() {
			return reportingBooleanScheme;
		}
		
		@Override
		public ReportingBoolean build() {
			return this;
		}
		
		@Override
		public ReportingBoolean.ReportingBooleanBuilder toBuilder() {
			ReportingBoolean.ReportingBooleanBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingBoolean.ReportingBooleanBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReportingBooleanScheme()).ifPresent(builder::setReportingBooleanScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingBoolean _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingBooleanScheme, _that.getReportingBooleanScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingBooleanScheme != null ? reportingBooleanScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingBoolean {" +
				"value=" + this.value + ", " +
				"reportingBooleanScheme=" + this.reportingBooleanScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingBoolean  ***********************/
	class ReportingBooleanBuilderImpl implements ReportingBoolean.ReportingBooleanBuilder {
	
		protected String value;
		protected String reportingBooleanScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reportingBooleanScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingBooleanScheme")
		public String getReportingBooleanScheme() {
			return reportingBooleanScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ReportingBoolean.ReportingBooleanBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("reportingBooleanScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingBooleanScheme")
		@Override
		public ReportingBoolean.ReportingBooleanBuilder setReportingBooleanScheme(String _reportingBooleanScheme) {
			this.reportingBooleanScheme = _reportingBooleanScheme == null ? null : _reportingBooleanScheme;
			return this;
		}
		
		@Override
		public ReportingBoolean build() {
			return new ReportingBoolean.ReportingBooleanImpl(this);
		}
		
		@Override
		public ReportingBoolean.ReportingBooleanBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingBoolean.ReportingBooleanBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReportingBooleanScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingBoolean.ReportingBooleanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingBoolean.ReportingBooleanBuilder o = (ReportingBoolean.ReportingBooleanBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReportingBooleanScheme(), o.getReportingBooleanScheme(), this::setReportingBooleanScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingBoolean _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reportingBooleanScheme, _that.getReportingBooleanScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reportingBooleanScheme != null ? reportingBooleanScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingBooleanBuilder {" +
				"value=" + this.value + ", " +
				"reportingBooleanScheme=" + this.reportingBooleanScheme +
			'}';
		}
	}
}
