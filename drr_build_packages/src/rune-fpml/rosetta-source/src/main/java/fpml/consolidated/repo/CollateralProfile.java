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
import fpml.consolidated.repo.meta.CollateralProfileMeta;
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
@RosettaDataType(value="CollateralProfile", builder=CollateralProfile.CollateralProfileBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralProfile", model="fpml", builder=CollateralProfile.CollateralProfileBuilderImpl.class, version="2.1.1")
public interface CollateralProfile extends RosettaModelObject {

	CollateralProfileMeta metaData = new CollateralProfileMeta();

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
	String getCollateralProfileScheme();

	/*********************** Build Methods  ***********************/
	CollateralProfile build();
	
	CollateralProfile.CollateralProfileBuilder toBuilder();
	
	static CollateralProfile.CollateralProfileBuilder builder() {
		return new CollateralProfile.CollateralProfileBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralProfile> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralProfile> getType() {
		return CollateralProfile.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("collateralProfileScheme"), String.class, getCollateralProfileScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralProfileBuilder extends CollateralProfile, RosettaModelObjectBuilder {
		CollateralProfile.CollateralProfileBuilder setValue(String value);
		CollateralProfile.CollateralProfileBuilder setCollateralProfileScheme(String collateralProfileScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("collateralProfileScheme"), String.class, getCollateralProfileScheme(), this);
		}
		

		CollateralProfile.CollateralProfileBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralProfile  ***********************/
	class CollateralProfileImpl implements CollateralProfile {
		private final String value;
		private final String collateralProfileScheme;
		
		protected CollateralProfileImpl(CollateralProfile.CollateralProfileBuilder builder) {
			this.value = builder.getValue();
			this.collateralProfileScheme = builder.getCollateralProfileScheme();
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
		@RosettaAttribute("collateralProfileScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralProfileScheme")
		public String getCollateralProfileScheme() {
			return collateralProfileScheme;
		}
		
		@Override
		public CollateralProfile build() {
			return this;
		}
		
		@Override
		public CollateralProfile.CollateralProfileBuilder toBuilder() {
			CollateralProfile.CollateralProfileBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralProfile.CollateralProfileBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCollateralProfileScheme()).ifPresent(builder::setCollateralProfileScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralProfile _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralProfileScheme, _that.getCollateralProfileScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralProfileScheme != null ? collateralProfileScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralProfile {" +
				"value=" + this.value + ", " +
				"collateralProfileScheme=" + this.collateralProfileScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralProfile  ***********************/
	class CollateralProfileBuilderImpl implements CollateralProfile.CollateralProfileBuilder {
	
		protected String value;
		protected String collateralProfileScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("collateralProfileScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralProfileScheme")
		public String getCollateralProfileScheme() {
			return collateralProfileScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CollateralProfile.CollateralProfileBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("collateralProfileScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralProfileScheme")
		@Override
		public CollateralProfile.CollateralProfileBuilder setCollateralProfileScheme(String _collateralProfileScheme) {
			this.collateralProfileScheme = _collateralProfileScheme == null ? null : _collateralProfileScheme;
			return this;
		}
		
		@Override
		public CollateralProfile build() {
			return new CollateralProfile.CollateralProfileImpl(this);
		}
		
		@Override
		public CollateralProfile.CollateralProfileBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralProfile.CollateralProfileBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCollateralProfileScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralProfile.CollateralProfileBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralProfile.CollateralProfileBuilder o = (CollateralProfile.CollateralProfileBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCollateralProfileScheme(), o.getCollateralProfileScheme(), this::setCollateralProfileScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralProfile _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralProfileScheme, _that.getCollateralProfileScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralProfileScheme != null ? collateralProfileScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralProfileBuilder {" +
				"value=" + this.value + ", " +
				"collateralProfileScheme=" + this.collateralProfileScheme +
			'}';
		}
	}
}
