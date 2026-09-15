package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LcTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A list of L/C types.
 *
 */
@RosettaDataType(value="LcType", builder=LcType.LcTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcType", model="fpml", builder=LcType.LcTypeBuilderImpl.class, version="2.1.1")
public interface LcType extends RosettaModelObject {

	LcTypeMeta metaData = new LcTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getLcTypeScheme();

	/*********************** Build Methods  ***********************/
	LcType build();
	
	LcType.LcTypeBuilder toBuilder();
	
	static LcType.LcTypeBuilder builder() {
		return new LcType.LcTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcType> getType() {
		return LcType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("lcTypeScheme"), String.class, getLcTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcTypeBuilder extends LcType, RosettaModelObjectBuilder {
		LcType.LcTypeBuilder setValue(String value);
		LcType.LcTypeBuilder setLcTypeScheme(String lcTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("lcTypeScheme"), String.class, getLcTypeScheme(), this);
		}
		

		LcType.LcTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LcType  ***********************/
	class LcTypeImpl implements LcType {
		private final String value;
		private final String lcTypeScheme;
		
		protected LcTypeImpl(LcType.LcTypeBuilder builder) {
			this.value = builder.getValue();
			this.lcTypeScheme = builder.getLcTypeScheme();
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
		@RosettaAttribute("lcTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcTypeScheme")
		public String getLcTypeScheme() {
			return lcTypeScheme;
		}
		
		@Override
		public LcType build() {
			return this;
		}
		
		@Override
		public LcType.LcTypeBuilder toBuilder() {
			LcType.LcTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcType.LcTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLcTypeScheme()).ifPresent(builder::setLcTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lcTypeScheme, _that.getLcTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lcTypeScheme != null ? lcTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcType {" +
				"value=" + this.value + ", " +
				"lcTypeScheme=" + this.lcTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LcType  ***********************/
	class LcTypeBuilderImpl implements LcType.LcTypeBuilder {
	
		protected String value;
		protected String lcTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lcTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcTypeScheme")
		public String getLcTypeScheme() {
			return lcTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LcType.LcTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("lcTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcTypeScheme")
		@Override
		public LcType.LcTypeBuilder setLcTypeScheme(String _lcTypeScheme) {
			this.lcTypeScheme = _lcTypeScheme == null ? null : _lcTypeScheme;
			return this;
		}
		
		@Override
		public LcType build() {
			return new LcType.LcTypeImpl(this);
		}
		
		@Override
		public LcType.LcTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcType.LcTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLcTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcType.LcTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LcType.LcTypeBuilder o = (LcType.LcTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLcTypeScheme(), o.getLcTypeScheme(), this::setLcTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lcTypeScheme, _that.getLcTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lcTypeScheme != null ? lcTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcTypeBuilder {" +
				"value=" + this.value + ", " +
				"lcTypeScheme=" + this.lcTypeScheme +
			'}';
		}
	}
}
