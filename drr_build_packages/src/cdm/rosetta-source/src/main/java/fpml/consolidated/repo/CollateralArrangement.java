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
import fpml.consolidated.repo.meta.CollateralArrangementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision (SFTR required field.) Method used to provide collateral. Indication whether the collateral is subject to a title transfer collateral arrangement, a securities financial collateral arrangement, or a securities financial with the right of use.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision (SFTR required field.) Method used to provide collateral. Indication whether the collateral is subject to a title transfer collateral arrangement, a securities financial collateral arrangement, or a securities financial with the right of use.
 *
 */
@RosettaDataType(value="CollateralArrangement", builder=CollateralArrangement.CollateralArrangementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralArrangement", model="fpml", builder=CollateralArrangement.CollateralArrangementBuilderImpl.class, version="2.1.1")
public interface CollateralArrangement extends RosettaModelObject {

	CollateralArrangementMeta metaData = new CollateralArrangementMeta();

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
	String getCollateralArrangementScheme();

	/*********************** Build Methods  ***********************/
	CollateralArrangement build();
	
	CollateralArrangement.CollateralArrangementBuilder toBuilder();
	
	static CollateralArrangement.CollateralArrangementBuilder builder() {
		return new CollateralArrangement.CollateralArrangementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralArrangement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralArrangement> getType() {
		return CollateralArrangement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("collateralArrangementScheme"), String.class, getCollateralArrangementScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralArrangementBuilder extends CollateralArrangement, RosettaModelObjectBuilder {
		CollateralArrangement.CollateralArrangementBuilder setValue(String value);
		CollateralArrangement.CollateralArrangementBuilder setCollateralArrangementScheme(String collateralArrangementScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("collateralArrangementScheme"), String.class, getCollateralArrangementScheme(), this);
		}
		

		CollateralArrangement.CollateralArrangementBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralArrangement  ***********************/
	class CollateralArrangementImpl implements CollateralArrangement {
		private final String value;
		private final String collateralArrangementScheme;
		
		protected CollateralArrangementImpl(CollateralArrangement.CollateralArrangementBuilder builder) {
			this.value = builder.getValue();
			this.collateralArrangementScheme = builder.getCollateralArrangementScheme();
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
		@RosettaAttribute("collateralArrangementScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralArrangementScheme")
		public String getCollateralArrangementScheme() {
			return collateralArrangementScheme;
		}
		
		@Override
		public CollateralArrangement build() {
			return this;
		}
		
		@Override
		public CollateralArrangement.CollateralArrangementBuilder toBuilder() {
			CollateralArrangement.CollateralArrangementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralArrangement.CollateralArrangementBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCollateralArrangementScheme()).ifPresent(builder::setCollateralArrangementScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralArrangement _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralArrangementScheme, _that.getCollateralArrangementScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralArrangementScheme != null ? collateralArrangementScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralArrangement {" +
				"value=" + this.value + ", " +
				"collateralArrangementScheme=" + this.collateralArrangementScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralArrangement  ***********************/
	class CollateralArrangementBuilderImpl implements CollateralArrangement.CollateralArrangementBuilder {
	
		protected String value;
		protected String collateralArrangementScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("collateralArrangementScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralArrangementScheme")
		public String getCollateralArrangementScheme() {
			return collateralArrangementScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CollateralArrangement.CollateralArrangementBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("collateralArrangementScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralArrangementScheme")
		@Override
		public CollateralArrangement.CollateralArrangementBuilder setCollateralArrangementScheme(String _collateralArrangementScheme) {
			this.collateralArrangementScheme = _collateralArrangementScheme == null ? null : _collateralArrangementScheme;
			return this;
		}
		
		@Override
		public CollateralArrangement build() {
			return new CollateralArrangement.CollateralArrangementImpl(this);
		}
		
		@Override
		public CollateralArrangement.CollateralArrangementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralArrangement.CollateralArrangementBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCollateralArrangementScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralArrangement.CollateralArrangementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralArrangement.CollateralArrangementBuilder o = (CollateralArrangement.CollateralArrangementBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCollateralArrangementScheme(), o.getCollateralArrangementScheme(), this::setCollateralArrangementScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralArrangement _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralArrangementScheme, _that.getCollateralArrangementScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralArrangementScheme != null ? collateralArrangementScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralArrangementBuilder {" +
				"value=" + this.value + ", " +
				"collateralArrangementScheme=" + this.collateralArrangementScheme +
			'}';
		}
	}
}
