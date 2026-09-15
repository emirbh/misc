package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.EmbeddedOptionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A flexible description of the type or characteristics of an option embbedded within another product. For example, a cancelable provision or an optional early termination provision.
 *
 */
@RosettaDataType(value="EmbeddedOptionType", builder=EmbeddedOptionType.EmbeddedOptionTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EmbeddedOptionType", model="fpml", builder=EmbeddedOptionType.EmbeddedOptionTypeBuilderImpl.class, version="2.1.1")
public interface EmbeddedOptionType extends RosettaModelObject {

	EmbeddedOptionTypeMeta metaData = new EmbeddedOptionTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 * Provision The type scheme used with this option type.
	 *
	 */
	String getEmbeddedOptionTypeScheme();

	/*********************** Build Methods  ***********************/
	EmbeddedOptionType build();
	
	EmbeddedOptionType.EmbeddedOptionTypeBuilder toBuilder();
	
	static EmbeddedOptionType.EmbeddedOptionTypeBuilder builder() {
		return new EmbeddedOptionType.EmbeddedOptionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EmbeddedOptionType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EmbeddedOptionType> getType() {
		return EmbeddedOptionType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("embeddedOptionTypeScheme"), String.class, getEmbeddedOptionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EmbeddedOptionTypeBuilder extends EmbeddedOptionType, RosettaModelObjectBuilder {
		EmbeddedOptionType.EmbeddedOptionTypeBuilder setValue(String value);
		EmbeddedOptionType.EmbeddedOptionTypeBuilder setEmbeddedOptionTypeScheme(String embeddedOptionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("embeddedOptionTypeScheme"), String.class, getEmbeddedOptionTypeScheme(), this);
		}
		

		EmbeddedOptionType.EmbeddedOptionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of EmbeddedOptionType  ***********************/
	class EmbeddedOptionTypeImpl implements EmbeddedOptionType {
		private final String value;
		private final String embeddedOptionTypeScheme;
		
		protected EmbeddedOptionTypeImpl(EmbeddedOptionType.EmbeddedOptionTypeBuilder builder) {
			this.value = builder.getValue();
			this.embeddedOptionTypeScheme = builder.getEmbeddedOptionTypeScheme();
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
		@RosettaAttribute("embeddedOptionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("embeddedOptionTypeScheme")
		public String getEmbeddedOptionTypeScheme() {
			return embeddedOptionTypeScheme;
		}
		
		@Override
		public EmbeddedOptionType build() {
			return this;
		}
		
		@Override
		public EmbeddedOptionType.EmbeddedOptionTypeBuilder toBuilder() {
			EmbeddedOptionType.EmbeddedOptionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EmbeddedOptionType.EmbeddedOptionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEmbeddedOptionTypeScheme()).ifPresent(builder::setEmbeddedOptionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EmbeddedOptionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(embeddedOptionTypeScheme, _that.getEmbeddedOptionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (embeddedOptionTypeScheme != null ? embeddedOptionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EmbeddedOptionType {" +
				"value=" + this.value + ", " +
				"embeddedOptionTypeScheme=" + this.embeddedOptionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EmbeddedOptionType  ***********************/
	class EmbeddedOptionTypeBuilderImpl implements EmbeddedOptionType.EmbeddedOptionTypeBuilder {
	
		protected String value;
		protected String embeddedOptionTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("embeddedOptionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("embeddedOptionTypeScheme")
		public String getEmbeddedOptionTypeScheme() {
			return embeddedOptionTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public EmbeddedOptionType.EmbeddedOptionTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("embeddedOptionTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("embeddedOptionTypeScheme")
		@Override
		public EmbeddedOptionType.EmbeddedOptionTypeBuilder setEmbeddedOptionTypeScheme(String _embeddedOptionTypeScheme) {
			this.embeddedOptionTypeScheme = _embeddedOptionTypeScheme == null ? null : _embeddedOptionTypeScheme;
			return this;
		}
		
		@Override
		public EmbeddedOptionType build() {
			return new EmbeddedOptionType.EmbeddedOptionTypeImpl(this);
		}
		
		@Override
		public EmbeddedOptionType.EmbeddedOptionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EmbeddedOptionType.EmbeddedOptionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEmbeddedOptionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EmbeddedOptionType.EmbeddedOptionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EmbeddedOptionType.EmbeddedOptionTypeBuilder o = (EmbeddedOptionType.EmbeddedOptionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEmbeddedOptionTypeScheme(), o.getEmbeddedOptionTypeScheme(), this::setEmbeddedOptionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EmbeddedOptionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(embeddedOptionTypeScheme, _that.getEmbeddedOptionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (embeddedOptionTypeScheme != null ? embeddedOptionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EmbeddedOptionTypeBuilder {" +
				"value=" + this.value + ", " +
				"embeddedOptionTypeScheme=" + this.embeddedOptionTypeScheme +
			'}';
		}
	}
}
