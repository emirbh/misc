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
import fpml.consolidated.shared.meta.RegionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A code that describes the world region of a counterparty. For example, NorthAmerica, Europe, Asia.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A code that describes the world region of a counterparty. For example, NorthAmerica, Europe, Asia.
 *
 */
@RosettaDataType(value="Region", builder=Region.RegionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Region", model="fpml", builder=Region.RegionBuilderImpl.class, version="2.1.1")
public interface Region extends RosettaModelObject {

	RegionMeta metaData = new RegionMeta();

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
	String getRegionScheme();

	/*********************** Build Methods  ***********************/
	Region build();
	
	Region.RegionBuilder toBuilder();
	
	static Region.RegionBuilder builder() {
		return new Region.RegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Region> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Region> getType() {
		return Region.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("regionScheme"), String.class, getRegionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegionBuilder extends Region, RosettaModelObjectBuilder {
		Region.RegionBuilder setValue(String value);
		Region.RegionBuilder setRegionScheme(String regionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("regionScheme"), String.class, getRegionScheme(), this);
		}
		

		Region.RegionBuilder prune();
	}

	/*********************** Immutable Implementation of Region  ***********************/
	class RegionImpl implements Region {
		private final String value;
		private final String regionScheme;
		
		protected RegionImpl(Region.RegionBuilder builder) {
			this.value = builder.getValue();
			this.regionScheme = builder.getRegionScheme();
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
		@RosettaAttribute("regionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regionScheme")
		public String getRegionScheme() {
			return regionScheme;
		}
		
		@Override
		public Region build() {
			return this;
		}
		
		@Override
		public Region.RegionBuilder toBuilder() {
			Region.RegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Region.RegionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRegionScheme()).ifPresent(builder::setRegionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Region _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(regionScheme, _that.getRegionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (regionScheme != null ? regionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Region {" +
				"value=" + this.value + ", " +
				"regionScheme=" + this.regionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Region  ***********************/
	class RegionBuilderImpl implements Region.RegionBuilder {
	
		protected String value;
		protected String regionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("regionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regionScheme")
		public String getRegionScheme() {
			return regionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public Region.RegionBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("regionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("regionScheme")
		@Override
		public Region.RegionBuilder setRegionScheme(String _regionScheme) {
			this.regionScheme = _regionScheme == null ? null : _regionScheme;
			return this;
		}
		
		@Override
		public Region build() {
			return new Region.RegionImpl(this);
		}
		
		@Override
		public Region.RegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Region.RegionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRegionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Region.RegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Region.RegionBuilder o = (Region.RegionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRegionScheme(), o.getRegionScheme(), this::setRegionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Region _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(regionScheme, _that.getRegionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (regionScheme != null ? regionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegionBuilder {" +
				"value=" + this.value + ", " +
				"regionScheme=" + this.regionScheme +
			'}';
		}
	}
}
