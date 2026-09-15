package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.CutNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Allows for an option expiry cut time to be described by name, as per established market convention. Note: the FX Working Group has resolved not to extend the cutNameScheme coding scheme. The expiryTime element should be used in preference to cutName as the formal definition of FX option expiry time.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Allows for an option expiry cut time to be described by name, as per established market convention. Note: the FX Working Group has resolved not to extend the cutNameScheme coding scheme. The expiryTime element should be used in preference to cutName as the formal definition of FX option expiry time.
 *
 */
@RosettaDataType(value="CutName", builder=CutName.CutNameBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CutName", model="fpml", builder=CutName.CutNameBuilderImpl.class, version="2.1.1")
public interface CutName extends RosettaModelObject {

	CutNameMeta metaData = new CutNameMeta();

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
	String getCutNameScheme();

	/*********************** Build Methods  ***********************/
	CutName build();
	
	CutName.CutNameBuilder toBuilder();
	
	static CutName.CutNameBuilder builder() {
		return new CutName.CutNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CutName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CutName> getType() {
		return CutName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("cutNameScheme"), String.class, getCutNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CutNameBuilder extends CutName, RosettaModelObjectBuilder {
		CutName.CutNameBuilder setValue(String value);
		CutName.CutNameBuilder setCutNameScheme(String cutNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("cutNameScheme"), String.class, getCutNameScheme(), this);
		}
		

		CutName.CutNameBuilder prune();
	}

	/*********************** Immutable Implementation of CutName  ***********************/
	class CutNameImpl implements CutName {
		private final String value;
		private final String cutNameScheme;
		
		protected CutNameImpl(CutName.CutNameBuilder builder) {
			this.value = builder.getValue();
			this.cutNameScheme = builder.getCutNameScheme();
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
		@RosettaAttribute("cutNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cutNameScheme")
		public String getCutNameScheme() {
			return cutNameScheme;
		}
		
		@Override
		public CutName build() {
			return this;
		}
		
		@Override
		public CutName.CutNameBuilder toBuilder() {
			CutName.CutNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CutName.CutNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCutNameScheme()).ifPresent(builder::setCutNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CutName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(cutNameScheme, _that.getCutNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (cutNameScheme != null ? cutNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CutName {" +
				"value=" + this.value + ", " +
				"cutNameScheme=" + this.cutNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CutName  ***********************/
	class CutNameBuilderImpl implements CutName.CutNameBuilder {
	
		protected String value;
		protected String cutNameScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("cutNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cutNameScheme")
		public String getCutNameScheme() {
			return cutNameScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CutName.CutNameBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("cutNameScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cutNameScheme")
		@Override
		public CutName.CutNameBuilder setCutNameScheme(String _cutNameScheme) {
			this.cutNameScheme = _cutNameScheme == null ? null : _cutNameScheme;
			return this;
		}
		
		@Override
		public CutName build() {
			return new CutName.CutNameImpl(this);
		}
		
		@Override
		public CutName.CutNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CutName.CutNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCutNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CutName.CutNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CutName.CutNameBuilder o = (CutName.CutNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCutNameScheme(), o.getCutNameScheme(), this::setCutNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CutName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(cutNameScheme, _that.getCutNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (cutNameScheme != null ? cutNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CutNameBuilder {" +
				"value=" + this.value + ", " +
				"cutNameScheme=" + this.cutNameScheme +
			'}';
		}
	}
}
