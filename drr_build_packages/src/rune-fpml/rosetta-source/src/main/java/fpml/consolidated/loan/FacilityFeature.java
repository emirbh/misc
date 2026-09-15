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
import fpml.consolidated.loan.meta.FacilityFeatureMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A list of facility features.
 *
 */
@RosettaDataType(value="FacilityFeature", builder=FacilityFeature.FacilityFeatureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FacilityFeature", model="fpml", builder=FacilityFeature.FacilityFeatureBuilderImpl.class, version="2.1.1")
public interface FacilityFeature extends RosettaModelObject {

	FacilityFeatureMeta metaData = new FacilityFeatureMeta();

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
	String getFacilityFeatureScheme();

	/*********************** Build Methods  ***********************/
	FacilityFeature build();
	
	FacilityFeature.FacilityFeatureBuilder toBuilder();
	
	static FacilityFeature.FacilityFeatureBuilder builder() {
		return new FacilityFeature.FacilityFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityFeature> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FacilityFeature> getType() {
		return FacilityFeature.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("facilityFeatureScheme"), String.class, getFacilityFeatureScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityFeatureBuilder extends FacilityFeature, RosettaModelObjectBuilder {
		FacilityFeature.FacilityFeatureBuilder setValue(String value);
		FacilityFeature.FacilityFeatureBuilder setFacilityFeatureScheme(String facilityFeatureScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("facilityFeatureScheme"), String.class, getFacilityFeatureScheme(), this);
		}
		

		FacilityFeature.FacilityFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityFeature  ***********************/
	class FacilityFeatureImpl implements FacilityFeature {
		private final String value;
		private final String facilityFeatureScheme;
		
		protected FacilityFeatureImpl(FacilityFeature.FacilityFeatureBuilder builder) {
			this.value = builder.getValue();
			this.facilityFeatureScheme = builder.getFacilityFeatureScheme();
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
		@RosettaAttribute("facilityFeatureScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityFeatureScheme")
		public String getFacilityFeatureScheme() {
			return facilityFeatureScheme;
		}
		
		@Override
		public FacilityFeature build() {
			return this;
		}
		
		@Override
		public FacilityFeature.FacilityFeatureBuilder toBuilder() {
			FacilityFeature.FacilityFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityFeature.FacilityFeatureBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFacilityFeatureScheme()).ifPresent(builder::setFacilityFeatureScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityFeature _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(facilityFeatureScheme, _that.getFacilityFeatureScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (facilityFeatureScheme != null ? facilityFeatureScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityFeature {" +
				"value=" + this.value + ", " +
				"facilityFeatureScheme=" + this.facilityFeatureScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityFeature  ***********************/
	class FacilityFeatureBuilderImpl implements FacilityFeature.FacilityFeatureBuilder {
	
		protected String value;
		protected String facilityFeatureScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("facilityFeatureScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityFeatureScheme")
		public String getFacilityFeatureScheme() {
			return facilityFeatureScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public FacilityFeature.FacilityFeatureBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("facilityFeatureScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityFeatureScheme")
		@Override
		public FacilityFeature.FacilityFeatureBuilder setFacilityFeatureScheme(String _facilityFeatureScheme) {
			this.facilityFeatureScheme = _facilityFeatureScheme == null ? null : _facilityFeatureScheme;
			return this;
		}
		
		@Override
		public FacilityFeature build() {
			return new FacilityFeature.FacilityFeatureImpl(this);
		}
		
		@Override
		public FacilityFeature.FacilityFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityFeature.FacilityFeatureBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFacilityFeatureScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityFeature.FacilityFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityFeature.FacilityFeatureBuilder o = (FacilityFeature.FacilityFeatureBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFacilityFeatureScheme(), o.getFacilityFeatureScheme(), this::setFacilityFeatureScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityFeature _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(facilityFeatureScheme, _that.getFacilityFeatureScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (facilityFeatureScheme != null ? facilityFeatureScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityFeatureBuilder {" +
				"value=" + this.value + ", " +
				"facilityFeatureScheme=" + this.facilityFeatureScheme +
			'}';
		}
	}
}
