package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.CreditQualityMeta;
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
@RosettaDataType(value="CreditQuality", builder=CreditQuality.CreditQualityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditQuality", model="fpml", builder=CreditQuality.CreditQualityBuilderImpl.class, version="2.1.1")
public interface CreditQuality extends RosettaModelObject {

	CreditQualityMeta metaData = new CreditQualityMeta();

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
	String getCreditQualityScheme();

	/*********************** Build Methods  ***********************/
	CreditQuality build();
	
	CreditQuality.CreditQualityBuilder toBuilder();
	
	static CreditQuality.CreditQualityBuilder builder() {
		return new CreditQuality.CreditQualityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditQuality> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditQuality> getType() {
		return CreditQuality.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditQualityScheme"), String.class, getCreditQualityScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditQualityBuilder extends CreditQuality, RosettaModelObjectBuilder {
		CreditQuality.CreditQualityBuilder setValue(String value);
		CreditQuality.CreditQualityBuilder setCreditQualityScheme(String creditQualityScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditQualityScheme"), String.class, getCreditQualityScheme(), this);
		}
		

		CreditQuality.CreditQualityBuilder prune();
	}

	/*********************** Immutable Implementation of CreditQuality  ***********************/
	class CreditQualityImpl implements CreditQuality {
		private final String value;
		private final String creditQualityScheme;
		
		protected CreditQualityImpl(CreditQuality.CreditQualityBuilder builder) {
			this.value = builder.getValue();
			this.creditQualityScheme = builder.getCreditQualityScheme();
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
		@RosettaAttribute("creditQualityScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditQualityScheme")
		public String getCreditQualityScheme() {
			return creditQualityScheme;
		}
		
		@Override
		public CreditQuality build() {
			return this;
		}
		
		@Override
		public CreditQuality.CreditQualityBuilder toBuilder() {
			CreditQuality.CreditQualityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditQuality.CreditQualityBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditQualityScheme()).ifPresent(builder::setCreditQualityScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditQuality _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditQualityScheme, _that.getCreditQualityScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditQualityScheme != null ? creditQualityScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditQuality {" +
				"value=" + this.value + ", " +
				"creditQualityScheme=" + this.creditQualityScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditQuality  ***********************/
	class CreditQualityBuilderImpl implements CreditQuality.CreditQualityBuilder {
	
		protected String value;
		protected String creditQualityScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditQualityScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditQualityScheme")
		public String getCreditQualityScheme() {
			return creditQualityScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CreditQuality.CreditQualityBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("creditQualityScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditQualityScheme")
		@Override
		public CreditQuality.CreditQualityBuilder setCreditQualityScheme(String _creditQualityScheme) {
			this.creditQualityScheme = _creditQualityScheme == null ? null : _creditQualityScheme;
			return this;
		}
		
		@Override
		public CreditQuality build() {
			return new CreditQuality.CreditQualityImpl(this);
		}
		
		@Override
		public CreditQuality.CreditQualityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditQuality.CreditQualityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditQualityScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditQuality.CreditQualityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditQuality.CreditQualityBuilder o = (CreditQuality.CreditQualityBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditQualityScheme(), o.getCreditQualityScheme(), this::setCreditQualityScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditQuality _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditQualityScheme, _that.getCreditQualityScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditQualityScheme != null ? creditQualityScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditQualityBuilder {" +
				"value=" + this.value + ", " +
				"creditQualityScheme=" + this.creditQualityScheme +
			'}';
		}
	}
}
