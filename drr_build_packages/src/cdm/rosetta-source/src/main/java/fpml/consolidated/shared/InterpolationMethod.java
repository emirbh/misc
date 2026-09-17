package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.InterpolationMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="InterpolationMethod", builder=InterpolationMethod.InterpolationMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InterpolationMethod", model="fpml", builder=InterpolationMethod.InterpolationMethodBuilderImpl.class, version="2.1.1")
public interface InterpolationMethod extends RosettaModelObject {

	InterpolationMethodMeta metaData = new InterpolationMethodMeta();

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
	String getInterpolationMethodScheme();

	/*********************** Build Methods  ***********************/
	InterpolationMethod build();
	
	InterpolationMethod.InterpolationMethodBuilder toBuilder();
	
	static InterpolationMethod.InterpolationMethodBuilder builder() {
		return new InterpolationMethod.InterpolationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterpolationMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterpolationMethod> getType() {
		return InterpolationMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("interpolationMethodScheme"), String.class, getInterpolationMethodScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterpolationMethodBuilder extends InterpolationMethod, RosettaModelObjectBuilder {
		InterpolationMethod.InterpolationMethodBuilder setValue(String value);
		InterpolationMethod.InterpolationMethodBuilder setInterpolationMethodScheme(String interpolationMethodScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("interpolationMethodScheme"), String.class, getInterpolationMethodScheme(), this);
		}
		

		InterpolationMethod.InterpolationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of InterpolationMethod  ***********************/
	class InterpolationMethodImpl implements InterpolationMethod {
		private final String value;
		private final String interpolationMethodScheme;
		
		protected InterpolationMethodImpl(InterpolationMethod.InterpolationMethodBuilder builder) {
			this.value = builder.getValue();
			this.interpolationMethodScheme = builder.getInterpolationMethodScheme();
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
		@RosettaAttribute("interpolationMethodScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationMethodScheme")
		public String getInterpolationMethodScheme() {
			return interpolationMethodScheme;
		}
		
		@Override
		public InterpolationMethod build() {
			return this;
		}
		
		@Override
		public InterpolationMethod.InterpolationMethodBuilder toBuilder() {
			InterpolationMethod.InterpolationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterpolationMethod.InterpolationMethodBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getInterpolationMethodScheme()).ifPresent(builder::setInterpolationMethodScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterpolationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(interpolationMethodScheme, _that.getInterpolationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (interpolationMethodScheme != null ? interpolationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterpolationMethod {" +
				"value=" + this.value + ", " +
				"interpolationMethodScheme=" + this.interpolationMethodScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of InterpolationMethod  ***********************/
	class InterpolationMethodBuilderImpl implements InterpolationMethod.InterpolationMethodBuilder {
	
		protected String value;
		protected String interpolationMethodScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("interpolationMethodScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationMethodScheme")
		public String getInterpolationMethodScheme() {
			return interpolationMethodScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public InterpolationMethod.InterpolationMethodBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("interpolationMethodScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interpolationMethodScheme")
		@Override
		public InterpolationMethod.InterpolationMethodBuilder setInterpolationMethodScheme(String _interpolationMethodScheme) {
			this.interpolationMethodScheme = _interpolationMethodScheme == null ? null : _interpolationMethodScheme;
			return this;
		}
		
		@Override
		public InterpolationMethod build() {
			return new InterpolationMethod.InterpolationMethodImpl(this);
		}
		
		@Override
		public InterpolationMethod.InterpolationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterpolationMethod.InterpolationMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getInterpolationMethodScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterpolationMethod.InterpolationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterpolationMethod.InterpolationMethodBuilder o = (InterpolationMethod.InterpolationMethodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getInterpolationMethodScheme(), o.getInterpolationMethodScheme(), this::setInterpolationMethodScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterpolationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(interpolationMethodScheme, _that.getInterpolationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (interpolationMethodScheme != null ? interpolationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterpolationMethodBuilder {" +
				"value=" + this.value + ", " +
				"interpolationMethodScheme=" + this.interpolationMethodScheme +
			'}';
		}
	}
}
