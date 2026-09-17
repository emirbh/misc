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
import fpml.consolidated.shared.meta.CollateralizedExposureGroupingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type containing a code representing the aggregation level at which the trade collateralized exposure is calculated(e.g. Single Trade or Net Exposure.)
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type containing a code representing the aggregation level at which the trade collateralized exposure is calculated(e.g. Single Trade or Net Exposure.)
 *
 */
@RosettaDataType(value="CollateralizedExposureGrouping", builder=CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralizedExposureGrouping", model="fpml", builder=CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilderImpl.class, version="2.1.1")
public interface CollateralizedExposureGrouping extends RosettaModelObject {

	CollateralizedExposureGroupingMeta metaData = new CollateralizedExposureGroupingMeta();

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
	String getCollateralizedExposureGroupingScheme();
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
	String getId();

	/*********************** Build Methods  ***********************/
	CollateralizedExposureGrouping build();
	
	CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder toBuilder();
	
	static CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder builder() {
		return new CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralizedExposureGrouping> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralizedExposureGrouping> getType() {
		return CollateralizedExposureGrouping.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("collateralizedExposureGroupingScheme"), String.class, getCollateralizedExposureGroupingScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralizedExposureGroupingBuilder extends CollateralizedExposureGrouping, RosettaModelObjectBuilder {
		CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder setValue(String value);
		CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder setCollateralizedExposureGroupingScheme(String collateralizedExposureGroupingScheme);
		CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("collateralizedExposureGroupingScheme"), String.class, getCollateralizedExposureGroupingScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralizedExposureGrouping  ***********************/
	class CollateralizedExposureGroupingImpl implements CollateralizedExposureGrouping {
		private final String value;
		private final String collateralizedExposureGroupingScheme;
		private final String id;
		
		protected CollateralizedExposureGroupingImpl(CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder builder) {
			this.value = builder.getValue();
			this.collateralizedExposureGroupingScheme = builder.getCollateralizedExposureGroupingScheme();
			this.id = builder.getId();
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
		@RosettaAttribute("collateralizedExposureGroupingScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizedExposureGroupingScheme")
		public String getCollateralizedExposureGroupingScheme() {
			return collateralizedExposureGroupingScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CollateralizedExposureGrouping build() {
			return this;
		}
		
		@Override
		public CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder toBuilder() {
			CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCollateralizedExposureGroupingScheme()).ifPresent(builder::setCollateralizedExposureGroupingScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralizedExposureGrouping _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralizedExposureGroupingScheme, _that.getCollateralizedExposureGroupingScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralizedExposureGroupingScheme != null ? collateralizedExposureGroupingScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralizedExposureGrouping {" +
				"value=" + this.value + ", " +
				"collateralizedExposureGroupingScheme=" + this.collateralizedExposureGroupingScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralizedExposureGrouping  ***********************/
	class CollateralizedExposureGroupingBuilderImpl implements CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder {
	
		protected String value;
		protected String collateralizedExposureGroupingScheme;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("collateralizedExposureGroupingScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizedExposureGroupingScheme")
		public String getCollateralizedExposureGroupingScheme() {
			return collateralizedExposureGroupingScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("collateralizedExposureGroupingScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralizedExposureGroupingScheme")
		@Override
		public CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder setCollateralizedExposureGroupingScheme(String _collateralizedExposureGroupingScheme) {
			this.collateralizedExposureGroupingScheme = _collateralizedExposureGroupingScheme == null ? null : _collateralizedExposureGroupingScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public CollateralizedExposureGrouping build() {
			return new CollateralizedExposureGrouping.CollateralizedExposureGroupingImpl(this);
		}
		
		@Override
		public CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCollateralizedExposureGroupingScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder o = (CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCollateralizedExposureGroupingScheme(), o.getCollateralizedExposureGroupingScheme(), this::setCollateralizedExposureGroupingScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralizedExposureGrouping _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralizedExposureGroupingScheme, _that.getCollateralizedExposureGroupingScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralizedExposureGroupingScheme != null ? collateralizedExposureGroupingScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralizedExposureGroupingBuilder {" +
				"value=" + this.value + ", " +
				"collateralizedExposureGroupingScheme=" + this.collateralizedExposureGroupingScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
