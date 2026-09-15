package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.MetricAdjustmentTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a metric adjustment type, described by a scheme.
 *
 */
@RosettaDataType(value="MetricAdjustmentType", builder=MetricAdjustmentType.MetricAdjustmentTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MetricAdjustmentType", model="fpml", builder=MetricAdjustmentType.MetricAdjustmentTypeBuilderImpl.class, version="2.1.1")
public interface MetricAdjustmentType extends RosettaModelObject {

	MetricAdjustmentTypeMeta metaData = new MetricAdjustmentTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getMetricAdjustmentTypeScheme();

	/*********************** Build Methods  ***********************/
	MetricAdjustmentType build();
	
	MetricAdjustmentType.MetricAdjustmentTypeBuilder toBuilder();
	
	static MetricAdjustmentType.MetricAdjustmentTypeBuilder builder() {
		return new MetricAdjustmentType.MetricAdjustmentTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MetricAdjustmentType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MetricAdjustmentType> getType() {
		return MetricAdjustmentType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("metricAdjustmentTypeScheme"), String.class, getMetricAdjustmentTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MetricAdjustmentTypeBuilder extends MetricAdjustmentType, RosettaModelObjectBuilder {
		MetricAdjustmentType.MetricAdjustmentTypeBuilder setValue(String value);
		MetricAdjustmentType.MetricAdjustmentTypeBuilder setMetricAdjustmentTypeScheme(String metricAdjustmentTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("metricAdjustmentTypeScheme"), String.class, getMetricAdjustmentTypeScheme(), this);
		}
		

		MetricAdjustmentType.MetricAdjustmentTypeBuilder prune();
	}

	/*********************** Immutable Implementation of MetricAdjustmentType  ***********************/
	class MetricAdjustmentTypeImpl implements MetricAdjustmentType {
		private final String value;
		private final String metricAdjustmentTypeScheme;
		
		protected MetricAdjustmentTypeImpl(MetricAdjustmentType.MetricAdjustmentTypeBuilder builder) {
			this.value = builder.getValue();
			this.metricAdjustmentTypeScheme = builder.getMetricAdjustmentTypeScheme();
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
		@RosettaAttribute("metricAdjustmentTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("metricAdjustmentTypeScheme")
		public String getMetricAdjustmentTypeScheme() {
			return metricAdjustmentTypeScheme;
		}
		
		@Override
		public MetricAdjustmentType build() {
			return this;
		}
		
		@Override
		public MetricAdjustmentType.MetricAdjustmentTypeBuilder toBuilder() {
			MetricAdjustmentType.MetricAdjustmentTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MetricAdjustmentType.MetricAdjustmentTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMetricAdjustmentTypeScheme()).ifPresent(builder::setMetricAdjustmentTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetricAdjustmentType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(metricAdjustmentTypeScheme, _that.getMetricAdjustmentTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (metricAdjustmentTypeScheme != null ? metricAdjustmentTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetricAdjustmentType {" +
				"value=" + this.value + ", " +
				"metricAdjustmentTypeScheme=" + this.metricAdjustmentTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MetricAdjustmentType  ***********************/
	class MetricAdjustmentTypeBuilderImpl implements MetricAdjustmentType.MetricAdjustmentTypeBuilder {
	
		protected String value;
		protected String metricAdjustmentTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("metricAdjustmentTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("metricAdjustmentTypeScheme")
		public String getMetricAdjustmentTypeScheme() {
			return metricAdjustmentTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MetricAdjustmentType.MetricAdjustmentTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("metricAdjustmentTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("metricAdjustmentTypeScheme")
		@Override
		public MetricAdjustmentType.MetricAdjustmentTypeBuilder setMetricAdjustmentTypeScheme(String _metricAdjustmentTypeScheme) {
			this.metricAdjustmentTypeScheme = _metricAdjustmentTypeScheme == null ? null : _metricAdjustmentTypeScheme;
			return this;
		}
		
		@Override
		public MetricAdjustmentType build() {
			return new MetricAdjustmentType.MetricAdjustmentTypeImpl(this);
		}
		
		@Override
		public MetricAdjustmentType.MetricAdjustmentTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetricAdjustmentType.MetricAdjustmentTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMetricAdjustmentTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetricAdjustmentType.MetricAdjustmentTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MetricAdjustmentType.MetricAdjustmentTypeBuilder o = (MetricAdjustmentType.MetricAdjustmentTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMetricAdjustmentTypeScheme(), o.getMetricAdjustmentTypeScheme(), this::setMetricAdjustmentTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetricAdjustmentType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(metricAdjustmentTypeScheme, _that.getMetricAdjustmentTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (metricAdjustmentTypeScheme != null ? metricAdjustmentTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetricAdjustmentTypeBuilder {" +
				"value=" + this.value + ", " +
				"metricAdjustmentTypeScheme=" + this.metricAdjustmentTypeScheme +
			'}';
		}
	}
}
