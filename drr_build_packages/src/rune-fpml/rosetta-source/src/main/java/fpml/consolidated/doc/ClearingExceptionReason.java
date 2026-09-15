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
import fpml.consolidated.doc.meta.ClearingExceptionReasonMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The reason a trade is exempted from a clearing mandate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The reason a trade is exempted from a clearing mandate.
 *
 */
@RosettaDataType(value="ClearingExceptionReason", builder=ClearingExceptionReason.ClearingExceptionReasonBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClearingExceptionReason", model="fpml", builder=ClearingExceptionReason.ClearingExceptionReasonBuilderImpl.class, version="2.1.1")
public interface ClearingExceptionReason extends RosettaModelObject {

	ClearingExceptionReasonMeta metaData = new ClearingExceptionReasonMeta();

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
	String getClearingExceptionReasonScheme();

	/*********************** Build Methods  ***********************/
	ClearingExceptionReason build();
	
	ClearingExceptionReason.ClearingExceptionReasonBuilder toBuilder();
	
	static ClearingExceptionReason.ClearingExceptionReasonBuilder builder() {
		return new ClearingExceptionReason.ClearingExceptionReasonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingExceptionReason> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingExceptionReason> getType() {
		return ClearingExceptionReason.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("clearingExceptionReasonScheme"), String.class, getClearingExceptionReasonScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingExceptionReasonBuilder extends ClearingExceptionReason, RosettaModelObjectBuilder {
		ClearingExceptionReason.ClearingExceptionReasonBuilder setValue(String value);
		ClearingExceptionReason.ClearingExceptionReasonBuilder setClearingExceptionReasonScheme(String clearingExceptionReasonScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("clearingExceptionReasonScheme"), String.class, getClearingExceptionReasonScheme(), this);
		}
		

		ClearingExceptionReason.ClearingExceptionReasonBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingExceptionReason  ***********************/
	class ClearingExceptionReasonImpl implements ClearingExceptionReason {
		private final String value;
		private final String clearingExceptionReasonScheme;
		
		protected ClearingExceptionReasonImpl(ClearingExceptionReason.ClearingExceptionReasonBuilder builder) {
			this.value = builder.getValue();
			this.clearingExceptionReasonScheme = builder.getClearingExceptionReasonScheme();
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
		@RosettaAttribute("clearingExceptionReasonScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingExceptionReasonScheme")
		public String getClearingExceptionReasonScheme() {
			return clearingExceptionReasonScheme;
		}
		
		@Override
		public ClearingExceptionReason build() {
			return this;
		}
		
		@Override
		public ClearingExceptionReason.ClearingExceptionReasonBuilder toBuilder() {
			ClearingExceptionReason.ClearingExceptionReasonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingExceptionReason.ClearingExceptionReasonBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getClearingExceptionReasonScheme()).ifPresent(builder::setClearingExceptionReasonScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingExceptionReason _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(clearingExceptionReasonScheme, _that.getClearingExceptionReasonScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (clearingExceptionReasonScheme != null ? clearingExceptionReasonScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingExceptionReason {" +
				"value=" + this.value + ", " +
				"clearingExceptionReasonScheme=" + this.clearingExceptionReasonScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingExceptionReason  ***********************/
	class ClearingExceptionReasonBuilderImpl implements ClearingExceptionReason.ClearingExceptionReasonBuilder {
	
		protected String value;
		protected String clearingExceptionReasonScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionReasonScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingExceptionReasonScheme")
		public String getClearingExceptionReasonScheme() {
			return clearingExceptionReasonScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ClearingExceptionReason.ClearingExceptionReasonBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("clearingExceptionReasonScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingExceptionReasonScheme")
		@Override
		public ClearingExceptionReason.ClearingExceptionReasonBuilder setClearingExceptionReasonScheme(String _clearingExceptionReasonScheme) {
			this.clearingExceptionReasonScheme = _clearingExceptionReasonScheme == null ? null : _clearingExceptionReasonScheme;
			return this;
		}
		
		@Override
		public ClearingExceptionReason build() {
			return new ClearingExceptionReason.ClearingExceptionReasonImpl(this);
		}
		
		@Override
		public ClearingExceptionReason.ClearingExceptionReasonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingExceptionReason.ClearingExceptionReasonBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getClearingExceptionReasonScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingExceptionReason.ClearingExceptionReasonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingExceptionReason.ClearingExceptionReasonBuilder o = (ClearingExceptionReason.ClearingExceptionReasonBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getClearingExceptionReasonScheme(), o.getClearingExceptionReasonScheme(), this::setClearingExceptionReasonScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingExceptionReason _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(clearingExceptionReasonScheme, _that.getClearingExceptionReasonScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (clearingExceptionReasonScheme != null ? clearingExceptionReasonScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingExceptionReasonBuilder {" +
				"value=" + this.value + ", " +
				"clearingExceptionReasonScheme=" + this.clearingExceptionReasonScheme +
			'}';
		}
	}
}
