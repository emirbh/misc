package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ClearingStatusValueMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The current status value of a clearing request.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The current status value of a clearing request.
 *
 */
@RosettaDataType(value="ClearingStatusValue", builder=ClearingStatusValue.ClearingStatusValueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClearingStatusValue", model="fpml", builder=ClearingStatusValue.ClearingStatusValueBuilderImpl.class, version="2.1.1")
public interface ClearingStatusValue extends RosettaModelObject {

	ClearingStatusValueMeta metaData = new ClearingStatusValueMeta();

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
	String getClearingStatusScheme();

	/*********************** Build Methods  ***********************/
	ClearingStatusValue build();
	
	ClearingStatusValue.ClearingStatusValueBuilder toBuilder();
	
	static ClearingStatusValue.ClearingStatusValueBuilder builder() {
		return new ClearingStatusValue.ClearingStatusValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingStatusValue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingStatusValue> getType() {
		return ClearingStatusValue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("clearingStatusScheme"), String.class, getClearingStatusScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingStatusValueBuilder extends ClearingStatusValue, RosettaModelObjectBuilder {
		ClearingStatusValue.ClearingStatusValueBuilder setValue(String value);
		ClearingStatusValue.ClearingStatusValueBuilder setClearingStatusScheme(String clearingStatusScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("clearingStatusScheme"), String.class, getClearingStatusScheme(), this);
		}
		

		ClearingStatusValue.ClearingStatusValueBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingStatusValue  ***********************/
	class ClearingStatusValueImpl implements ClearingStatusValue {
		private final String value;
		private final String clearingStatusScheme;
		
		protected ClearingStatusValueImpl(ClearingStatusValue.ClearingStatusValueBuilder builder) {
			this.value = builder.getValue();
			this.clearingStatusScheme = builder.getClearingStatusScheme();
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
		@RosettaAttribute("clearingStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatusScheme")
		public String getClearingStatusScheme() {
			return clearingStatusScheme;
		}
		
		@Override
		public ClearingStatusValue build() {
			return this;
		}
		
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder toBuilder() {
			ClearingStatusValue.ClearingStatusValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingStatusValue.ClearingStatusValueBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getClearingStatusScheme()).ifPresent(builder::setClearingStatusScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingStatusValue _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(clearingStatusScheme, _that.getClearingStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (clearingStatusScheme != null ? clearingStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatusValue {" +
				"value=" + this.value + ", " +
				"clearingStatusScheme=" + this.clearingStatusScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingStatusValue  ***********************/
	class ClearingStatusValueBuilderImpl implements ClearingStatusValue.ClearingStatusValueBuilder {
	
		protected String value;
		protected String clearingStatusScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("clearingStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatusScheme")
		public String getClearingStatusScheme() {
			return clearingStatusScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("clearingStatusScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingStatusScheme")
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder setClearingStatusScheme(String _clearingStatusScheme) {
			this.clearingStatusScheme = _clearingStatusScheme == null ? null : _clearingStatusScheme;
			return this;
		}
		
		@Override
		public ClearingStatusValue build() {
			return new ClearingStatusValue.ClearingStatusValueImpl(this);
		}
		
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getClearingStatusScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingStatusValue.ClearingStatusValueBuilder o = (ClearingStatusValue.ClearingStatusValueBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getClearingStatusScheme(), o.getClearingStatusScheme(), this::setClearingStatusScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingStatusValue _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(clearingStatusScheme, _that.getClearingStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (clearingStatusScheme != null ? clearingStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatusValueBuilder {" +
				"value=" + this.value + ", " +
				"clearingStatusScheme=" + this.clearingStatusScheme +
			'}';
		}
	}
}
