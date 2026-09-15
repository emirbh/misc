package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.ReferenceLevelUnitMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision CPD Reference Level: millimeters or inches of daily precipitation HDD Reference Level: degree-days CDD Reference Level: degree-days.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision CPD Reference Level: millimeters or inches of daily precipitation HDD Reference Level: degree-days CDD Reference Level: degree-days.
 *
 */
@RosettaDataType(value="ReferenceLevelUnit", builder=ReferenceLevelUnit.ReferenceLevelUnitBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReferenceLevelUnit", model="fpml", builder=ReferenceLevelUnit.ReferenceLevelUnitBuilderImpl.class, version="2.1.1")
public interface ReferenceLevelUnit extends RosettaModelObject {

	ReferenceLevelUnitMeta metaData = new ReferenceLevelUnitMeta();

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
	String getWeatherIndexReferenceLevelScheme();

	/*********************** Build Methods  ***********************/
	ReferenceLevelUnit build();
	
	ReferenceLevelUnit.ReferenceLevelUnitBuilder toBuilder();
	
	static ReferenceLevelUnit.ReferenceLevelUnitBuilder builder() {
		return new ReferenceLevelUnit.ReferenceLevelUnitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceLevelUnit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReferenceLevelUnit> getType() {
		return ReferenceLevelUnit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("weatherIndexReferenceLevelScheme"), String.class, getWeatherIndexReferenceLevelScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceLevelUnitBuilder extends ReferenceLevelUnit, RosettaModelObjectBuilder {
		ReferenceLevelUnit.ReferenceLevelUnitBuilder setValue(String value);
		ReferenceLevelUnit.ReferenceLevelUnitBuilder setWeatherIndexReferenceLevelScheme(String weatherIndexReferenceLevelScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("weatherIndexReferenceLevelScheme"), String.class, getWeatherIndexReferenceLevelScheme(), this);
		}
		

		ReferenceLevelUnit.ReferenceLevelUnitBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceLevelUnit  ***********************/
	class ReferenceLevelUnitImpl implements ReferenceLevelUnit {
		private final String value;
		private final String weatherIndexReferenceLevelScheme;
		
		protected ReferenceLevelUnitImpl(ReferenceLevelUnit.ReferenceLevelUnitBuilder builder) {
			this.value = builder.getValue();
			this.weatherIndexReferenceLevelScheme = builder.getWeatherIndexReferenceLevelScheme();
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
		@RosettaAttribute("weatherIndexReferenceLevelScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherIndexReferenceLevelScheme")
		public String getWeatherIndexReferenceLevelScheme() {
			return weatherIndexReferenceLevelScheme;
		}
		
		@Override
		public ReferenceLevelUnit build() {
			return this;
		}
		
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder toBuilder() {
			ReferenceLevelUnit.ReferenceLevelUnitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceLevelUnit.ReferenceLevelUnitBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getWeatherIndexReferenceLevelScheme()).ifPresent(builder::setWeatherIndexReferenceLevelScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceLevelUnit _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherIndexReferenceLevelScheme, _that.getWeatherIndexReferenceLevelScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherIndexReferenceLevelScheme != null ? weatherIndexReferenceLevelScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceLevelUnit {" +
				"value=" + this.value + ", " +
				"weatherIndexReferenceLevelScheme=" + this.weatherIndexReferenceLevelScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceLevelUnit  ***********************/
	class ReferenceLevelUnitBuilderImpl implements ReferenceLevelUnit.ReferenceLevelUnitBuilder {
	
		protected String value;
		protected String weatherIndexReferenceLevelScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("weatherIndexReferenceLevelScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherIndexReferenceLevelScheme")
		public String getWeatherIndexReferenceLevelScheme() {
			return weatherIndexReferenceLevelScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("weatherIndexReferenceLevelScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherIndexReferenceLevelScheme")
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder setWeatherIndexReferenceLevelScheme(String _weatherIndexReferenceLevelScheme) {
			this.weatherIndexReferenceLevelScheme = _weatherIndexReferenceLevelScheme == null ? null : _weatherIndexReferenceLevelScheme;
			return this;
		}
		
		@Override
		public ReferenceLevelUnit build() {
			return new ReferenceLevelUnit.ReferenceLevelUnitImpl(this);
		}
		
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getWeatherIndexReferenceLevelScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceLevelUnit.ReferenceLevelUnitBuilder o = (ReferenceLevelUnit.ReferenceLevelUnitBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getWeatherIndexReferenceLevelScheme(), o.getWeatherIndexReferenceLevelScheme(), this::setWeatherIndexReferenceLevelScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceLevelUnit _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherIndexReferenceLevelScheme, _that.getWeatherIndexReferenceLevelScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherIndexReferenceLevelScheme != null ? weatherIndexReferenceLevelScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceLevelUnitBuilder {" +
				"value=" + this.value + ", " +
				"weatherIndexReferenceLevelScheme=" + this.weatherIndexReferenceLevelScheme +
			'}';
		}
	}
}
