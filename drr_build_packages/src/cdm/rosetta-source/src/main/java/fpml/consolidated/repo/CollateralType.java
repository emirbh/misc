package fpml.consolidated.repo;

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
import fpml.consolidated.repo.meta.CollateralTypeMeta;
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
@RosettaDataType(value="CollateralType", builder=CollateralType.CollateralTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralType", model="fpml", builder=CollateralType.CollateralTypeBuilderImpl.class, version="2.1.1")
public interface CollateralType extends RosettaModelObject {

	CollateralTypeMeta metaData = new CollateralTypeMeta();

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
	String getCollateralTypeScheme();

	/*********************** Build Methods  ***********************/
	CollateralType build();
	
	CollateralType.CollateralTypeBuilder toBuilder();
	
	static CollateralType.CollateralTypeBuilder builder() {
		return new CollateralType.CollateralTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralType> getType() {
		return CollateralType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("collateralTypeScheme"), String.class, getCollateralTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralTypeBuilder extends CollateralType, RosettaModelObjectBuilder {
		CollateralType.CollateralTypeBuilder setValue(String value);
		CollateralType.CollateralTypeBuilder setCollateralTypeScheme(String collateralTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("collateralTypeScheme"), String.class, getCollateralTypeScheme(), this);
		}
		

		CollateralType.CollateralTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralType  ***********************/
	class CollateralTypeImpl implements CollateralType {
		private final String value;
		private final String collateralTypeScheme;
		
		protected CollateralTypeImpl(CollateralType.CollateralTypeBuilder builder) {
			this.value = builder.getValue();
			this.collateralTypeScheme = builder.getCollateralTypeScheme();
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
		@RosettaAttribute("collateralTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralTypeScheme")
		public String getCollateralTypeScheme() {
			return collateralTypeScheme;
		}
		
		@Override
		public CollateralType build() {
			return this;
		}
		
		@Override
		public CollateralType.CollateralTypeBuilder toBuilder() {
			CollateralType.CollateralTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralType.CollateralTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCollateralTypeScheme()).ifPresent(builder::setCollateralTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralTypeScheme, _that.getCollateralTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralTypeScheme != null ? collateralTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralType {" +
				"value=" + this.value + ", " +
				"collateralTypeScheme=" + this.collateralTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralType  ***********************/
	class CollateralTypeBuilderImpl implements CollateralType.CollateralTypeBuilder {
	
		protected String value;
		protected String collateralTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("collateralTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralTypeScheme")
		public String getCollateralTypeScheme() {
			return collateralTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CollateralType.CollateralTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("collateralTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralTypeScheme")
		@Override
		public CollateralType.CollateralTypeBuilder setCollateralTypeScheme(String _collateralTypeScheme) {
			this.collateralTypeScheme = _collateralTypeScheme == null ? null : _collateralTypeScheme;
			return this;
		}
		
		@Override
		public CollateralType build() {
			return new CollateralType.CollateralTypeImpl(this);
		}
		
		@Override
		public CollateralType.CollateralTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralType.CollateralTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCollateralTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralType.CollateralTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralType.CollateralTypeBuilder o = (CollateralType.CollateralTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCollateralTypeScheme(), o.getCollateralTypeScheme(), this::setCollateralTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralTypeScheme, _that.getCollateralTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralTypeScheme != null ? collateralTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralTypeBuilder {" +
				"value=" + this.value + ", " +
				"collateralTypeScheme=" + this.collateralTypeScheme +
			'}';
		}
	}
}
