package fpml.consolidated.option.shared;

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
import fpml.consolidated.option.shared.meta.RestructuringTypeMeta;
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
@RosettaDataType(value="RestructuringType", builder=RestructuringType.RestructuringTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RestructuringType", model="fpml", builder=RestructuringType.RestructuringTypeBuilderImpl.class, version="2.1.1")
public interface RestructuringType extends RosettaModelObject {

	RestructuringTypeMeta metaData = new RestructuringTypeMeta();

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
	String getRestructuringScheme();

	/*********************** Build Methods  ***********************/
	RestructuringType build();
	
	RestructuringType.RestructuringTypeBuilder toBuilder();
	
	static RestructuringType.RestructuringTypeBuilder builder() {
		return new RestructuringType.RestructuringTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RestructuringType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RestructuringType> getType() {
		return RestructuringType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("restructuringScheme"), String.class, getRestructuringScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RestructuringTypeBuilder extends RestructuringType, RosettaModelObjectBuilder {
		RestructuringType.RestructuringTypeBuilder setValue(String value);
		RestructuringType.RestructuringTypeBuilder setRestructuringScheme(String restructuringScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("restructuringScheme"), String.class, getRestructuringScheme(), this);
		}
		

		RestructuringType.RestructuringTypeBuilder prune();
	}

	/*********************** Immutable Implementation of RestructuringType  ***********************/
	class RestructuringTypeImpl implements RestructuringType {
		private final String value;
		private final String restructuringScheme;
		
		protected RestructuringTypeImpl(RestructuringType.RestructuringTypeBuilder builder) {
			this.value = builder.getValue();
			this.restructuringScheme = builder.getRestructuringScheme();
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
		@RosettaAttribute("restructuringScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("restructuringScheme")
		public String getRestructuringScheme() {
			return restructuringScheme;
		}
		
		@Override
		public RestructuringType build() {
			return this;
		}
		
		@Override
		public RestructuringType.RestructuringTypeBuilder toBuilder() {
			RestructuringType.RestructuringTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RestructuringType.RestructuringTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRestructuringScheme()).ifPresent(builder::setRestructuringScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RestructuringType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(restructuringScheme, _that.getRestructuringScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (restructuringScheme != null ? restructuringScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RestructuringType {" +
				"value=" + this.value + ", " +
				"restructuringScheme=" + this.restructuringScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RestructuringType  ***********************/
	class RestructuringTypeBuilderImpl implements RestructuringType.RestructuringTypeBuilder {
	
		protected String value;
		protected String restructuringScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("restructuringScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("restructuringScheme")
		public String getRestructuringScheme() {
			return restructuringScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public RestructuringType.RestructuringTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("restructuringScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("restructuringScheme")
		@Override
		public RestructuringType.RestructuringTypeBuilder setRestructuringScheme(String _restructuringScheme) {
			this.restructuringScheme = _restructuringScheme == null ? null : _restructuringScheme;
			return this;
		}
		
		@Override
		public RestructuringType build() {
			return new RestructuringType.RestructuringTypeImpl(this);
		}
		
		@Override
		public RestructuringType.RestructuringTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RestructuringType.RestructuringTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRestructuringScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RestructuringType.RestructuringTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RestructuringType.RestructuringTypeBuilder o = (RestructuringType.RestructuringTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRestructuringScheme(), o.getRestructuringScheme(), this::setRestructuringScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RestructuringType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(restructuringScheme, _that.getRestructuringScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (restructuringScheme != null ? restructuringScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RestructuringTypeBuilder {" +
				"value=" + this.value + ", " +
				"restructuringScheme=" + this.restructuringScheme +
			'}';
		}
	}
}
