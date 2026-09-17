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
import fpml.consolidated.business.events.meta.CompressionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that identifies the type of trade amalgamation, for example netting or portfolio compression.
 *
 */
@RosettaDataType(value="CompressionType", builder=CompressionType.CompressionTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CompressionType", model="fpml", builder=CompressionType.CompressionTypeBuilderImpl.class, version="2.1.1")
public interface CompressionType extends RosettaModelObject {

	CompressionTypeMeta metaData = new CompressionTypeMeta();

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
	String getCompressionTypeScheme();

	/*********************** Build Methods  ***********************/
	CompressionType build();
	
	CompressionType.CompressionTypeBuilder toBuilder();
	
	static CompressionType.CompressionTypeBuilder builder() {
		return new CompressionType.CompressionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompressionType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CompressionType> getType() {
		return CompressionType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("compressionTypeScheme"), String.class, getCompressionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompressionTypeBuilder extends CompressionType, RosettaModelObjectBuilder {
		CompressionType.CompressionTypeBuilder setValue(String value);
		CompressionType.CompressionTypeBuilder setCompressionTypeScheme(String compressionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("compressionTypeScheme"), String.class, getCompressionTypeScheme(), this);
		}
		

		CompressionType.CompressionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CompressionType  ***********************/
	class CompressionTypeImpl implements CompressionType {
		private final String value;
		private final String compressionTypeScheme;
		
		protected CompressionTypeImpl(CompressionType.CompressionTypeBuilder builder) {
			this.value = builder.getValue();
			this.compressionTypeScheme = builder.getCompressionTypeScheme();
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
		@RosettaAttribute("compressionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compressionTypeScheme")
		public String getCompressionTypeScheme() {
			return compressionTypeScheme;
		}
		
		@Override
		public CompressionType build() {
			return this;
		}
		
		@Override
		public CompressionType.CompressionTypeBuilder toBuilder() {
			CompressionType.CompressionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompressionType.CompressionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCompressionTypeScheme()).ifPresent(builder::setCompressionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(compressionTypeScheme, _that.getCompressionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (compressionTypeScheme != null ? compressionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionType {" +
				"value=" + this.value + ", " +
				"compressionTypeScheme=" + this.compressionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CompressionType  ***********************/
	class CompressionTypeBuilderImpl implements CompressionType.CompressionTypeBuilder {
	
		protected String value;
		protected String compressionTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("compressionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compressionTypeScheme")
		public String getCompressionTypeScheme() {
			return compressionTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CompressionType.CompressionTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("compressionTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compressionTypeScheme")
		@Override
		public CompressionType.CompressionTypeBuilder setCompressionTypeScheme(String _compressionTypeScheme) {
			this.compressionTypeScheme = _compressionTypeScheme == null ? null : _compressionTypeScheme;
			return this;
		}
		
		@Override
		public CompressionType build() {
			return new CompressionType.CompressionTypeImpl(this);
		}
		
		@Override
		public CompressionType.CompressionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionType.CompressionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCompressionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionType.CompressionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompressionType.CompressionTypeBuilder o = (CompressionType.CompressionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCompressionTypeScheme(), o.getCompressionTypeScheme(), this::setCompressionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(compressionTypeScheme, _that.getCompressionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (compressionTypeScheme != null ? compressionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionTypeBuilder {" +
				"value=" + this.value + ", " +
				"compressionTypeScheme=" + this.compressionTypeScheme +
			'}';
		}
	}
}
