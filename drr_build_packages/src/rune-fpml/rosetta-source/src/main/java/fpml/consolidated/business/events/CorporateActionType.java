package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.CorporateActionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that describes what type of corporate action occurred.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes what type of corporate action occurred.
 *
 */
@RosettaDataType(value="CorporateActionType", builder=CorporateActionType.CorporateActionTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CorporateActionType", model="fpml", builder=CorporateActionType.CorporateActionTypeBuilderImpl.class, version="2.1.1")
public interface CorporateActionType extends RosettaModelObject {

	CorporateActionTypeMeta metaData = new CorporateActionTypeMeta();

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
	String getCorporateActionScheme();

	/*********************** Build Methods  ***********************/
	CorporateActionType build();
	
	CorporateActionType.CorporateActionTypeBuilder toBuilder();
	
	static CorporateActionType.CorporateActionTypeBuilder builder() {
		return new CorporateActionType.CorporateActionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorporateActionType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorporateActionType> getType() {
		return CorporateActionType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("corporateActionScheme"), String.class, getCorporateActionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorporateActionTypeBuilder extends CorporateActionType, RosettaModelObjectBuilder {
		CorporateActionType.CorporateActionTypeBuilder setValue(String value);
		CorporateActionType.CorporateActionTypeBuilder setCorporateActionScheme(String corporateActionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("corporateActionScheme"), String.class, getCorporateActionScheme(), this);
		}
		

		CorporateActionType.CorporateActionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CorporateActionType  ***********************/
	class CorporateActionTypeImpl implements CorporateActionType {
		private final String value;
		private final String corporateActionScheme;
		
		protected CorporateActionTypeImpl(CorporateActionType.CorporateActionTypeBuilder builder) {
			this.value = builder.getValue();
			this.corporateActionScheme = builder.getCorporateActionScheme();
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
		@RosettaAttribute("corporateActionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateActionScheme")
		public String getCorporateActionScheme() {
			return corporateActionScheme;
		}
		
		@Override
		public CorporateActionType build() {
			return this;
		}
		
		@Override
		public CorporateActionType.CorporateActionTypeBuilder toBuilder() {
			CorporateActionType.CorporateActionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorporateActionType.CorporateActionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCorporateActionScheme()).ifPresent(builder::setCorporateActionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorporateActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(corporateActionScheme, _that.getCorporateActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (corporateActionScheme != null ? corporateActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorporateActionType {" +
				"value=" + this.value + ", " +
				"corporateActionScheme=" + this.corporateActionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CorporateActionType  ***********************/
	class CorporateActionTypeBuilderImpl implements CorporateActionType.CorporateActionTypeBuilder {
	
		protected String value;
		protected String corporateActionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("corporateActionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateActionScheme")
		public String getCorporateActionScheme() {
			return corporateActionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CorporateActionType.CorporateActionTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("corporateActionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("corporateActionScheme")
		@Override
		public CorporateActionType.CorporateActionTypeBuilder setCorporateActionScheme(String _corporateActionScheme) {
			this.corporateActionScheme = _corporateActionScheme == null ? null : _corporateActionScheme;
			return this;
		}
		
		@Override
		public CorporateActionType build() {
			return new CorporateActionType.CorporateActionTypeImpl(this);
		}
		
		@Override
		public CorporateActionType.CorporateActionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorporateActionType.CorporateActionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCorporateActionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorporateActionType.CorporateActionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorporateActionType.CorporateActionTypeBuilder o = (CorporateActionType.CorporateActionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCorporateActionScheme(), o.getCorporateActionScheme(), this::setCorporateActionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorporateActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(corporateActionScheme, _that.getCorporateActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (corporateActionScheme != null ? corporateActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorporateActionTypeBuilder {" +
				"value=" + this.value + ", " +
				"corporateActionScheme=" + this.corporateActionScheme +
			'}';
		}
	}
}
