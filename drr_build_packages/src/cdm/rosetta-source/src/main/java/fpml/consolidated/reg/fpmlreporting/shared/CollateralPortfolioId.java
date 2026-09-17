package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.reg.fpmlreporting.shared.meta.CollateralPortfolioIdMeta;
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
@RosettaDataType(value="CollateralPortfolioId", builder=CollateralPortfolioId.CollateralPortfolioIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralPortfolioId", model="fpml", builder=CollateralPortfolioId.CollateralPortfolioIdBuilderImpl.class, version="2.1.1")
public interface CollateralPortfolioId extends RosettaModelObject {

	CollateralPortfolioIdMeta metaData = new CollateralPortfolioIdMeta();

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
	String getCollateralPortfolioIdScheme();

	/*********************** Build Methods  ***********************/
	CollateralPortfolioId build();
	
	CollateralPortfolioId.CollateralPortfolioIdBuilder toBuilder();
	
	static CollateralPortfolioId.CollateralPortfolioIdBuilder builder() {
		return new CollateralPortfolioId.CollateralPortfolioIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralPortfolioId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralPortfolioId> getType() {
		return CollateralPortfolioId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("collateralPortfolioIdScheme"), String.class, getCollateralPortfolioIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralPortfolioIdBuilder extends CollateralPortfolioId, RosettaModelObjectBuilder {
		CollateralPortfolioId.CollateralPortfolioIdBuilder setValue(String value);
		CollateralPortfolioId.CollateralPortfolioIdBuilder setCollateralPortfolioIdScheme(String collateralPortfolioIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("collateralPortfolioIdScheme"), String.class, getCollateralPortfolioIdScheme(), this);
		}
		

		CollateralPortfolioId.CollateralPortfolioIdBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralPortfolioId  ***********************/
	class CollateralPortfolioIdImpl implements CollateralPortfolioId {
		private final String value;
		private final String collateralPortfolioIdScheme;
		
		protected CollateralPortfolioIdImpl(CollateralPortfolioId.CollateralPortfolioIdBuilder builder) {
			this.value = builder.getValue();
			this.collateralPortfolioIdScheme = builder.getCollateralPortfolioIdScheme();
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
		@RosettaAttribute("collateralPortfolioIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioIdScheme")
		public String getCollateralPortfolioIdScheme() {
			return collateralPortfolioIdScheme;
		}
		
		@Override
		public CollateralPortfolioId build() {
			return this;
		}
		
		@Override
		public CollateralPortfolioId.CollateralPortfolioIdBuilder toBuilder() {
			CollateralPortfolioId.CollateralPortfolioIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralPortfolioId.CollateralPortfolioIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCollateralPortfolioIdScheme()).ifPresent(builder::setCollateralPortfolioIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralPortfolioIdScheme, _that.getCollateralPortfolioIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioIdScheme != null ? collateralPortfolioIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioId {" +
				"value=" + this.value + ", " +
				"collateralPortfolioIdScheme=" + this.collateralPortfolioIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralPortfolioId  ***********************/
	class CollateralPortfolioIdBuilderImpl implements CollateralPortfolioId.CollateralPortfolioIdBuilder {
	
		protected String value;
		protected String collateralPortfolioIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioIdScheme")
		public String getCollateralPortfolioIdScheme() {
			return collateralPortfolioIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CollateralPortfolioId.CollateralPortfolioIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIdScheme")
		@Override
		public CollateralPortfolioId.CollateralPortfolioIdBuilder setCollateralPortfolioIdScheme(String _collateralPortfolioIdScheme) {
			this.collateralPortfolioIdScheme = _collateralPortfolioIdScheme == null ? null : _collateralPortfolioIdScheme;
			return this;
		}
		
		@Override
		public CollateralPortfolioId build() {
			return new CollateralPortfolioId.CollateralPortfolioIdImpl(this);
		}
		
		@Override
		public CollateralPortfolioId.CollateralPortfolioIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioId.CollateralPortfolioIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCollateralPortfolioIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioId.CollateralPortfolioIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralPortfolioId.CollateralPortfolioIdBuilder o = (CollateralPortfolioId.CollateralPortfolioIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCollateralPortfolioIdScheme(), o.getCollateralPortfolioIdScheme(), this::setCollateralPortfolioIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(collateralPortfolioIdScheme, _that.getCollateralPortfolioIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioIdScheme != null ? collateralPortfolioIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioIdBuilder {" +
				"value=" + this.value + ", " +
				"collateralPortfolioIdScheme=" + this.collateralPortfolioIdScheme +
			'}';
		}
	}
}
