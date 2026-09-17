package fpml.consolidated;

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
import fpml.consolidated.meta.DigestValueMeta;
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
@RosettaDataType(value="DigestValue", builder=DigestValue.DigestValueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DigestValue", model="fpml", builder=DigestValue.DigestValueBuilderImpl.class, version="2.1.1")
public interface DigestValue extends RosettaModelObject {

	DigestValueMeta metaData = new DigestValueMeta();

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

	/*********************** Build Methods  ***********************/
	DigestValue build();
	
	DigestValue.DigestValueBuilder toBuilder();
	
	static DigestValue.DigestValueBuilder builder() {
		return new DigestValue.DigestValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DigestValue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DigestValue> getType() {
		return DigestValue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DigestValueBuilder extends DigestValue, RosettaModelObjectBuilder {
		DigestValue.DigestValueBuilder setValue(String value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		}
		

		DigestValue.DigestValueBuilder prune();
	}

	/*********************** Immutable Implementation of DigestValue  ***********************/
	class DigestValueImpl implements DigestValue {
		private final String value;
		
		protected DigestValueImpl(DigestValue.DigestValueBuilder builder) {
			this.value = builder.getValue();
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
		public DigestValue build() {
			return this;
		}
		
		@Override
		public DigestValue.DigestValueBuilder toBuilder() {
			DigestValue.DigestValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DigestValue.DigestValueBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DigestValue _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DigestValue {" +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of DigestValue  ***********************/
	class DigestValueBuilderImpl implements DigestValue.DigestValueBuilder {
	
		protected String value;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public DigestValue.DigestValueBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		public DigestValue build() {
			return new DigestValue.DigestValueImpl(this);
		}
		
		@Override
		public DigestValue.DigestValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigestValue.DigestValueBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigestValue.DigestValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DigestValue.DigestValueBuilder o = (DigestValue.DigestValueBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DigestValue _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DigestValueBuilder {" +
				"value=" + this.value +
			'}';
		}
	}
}
