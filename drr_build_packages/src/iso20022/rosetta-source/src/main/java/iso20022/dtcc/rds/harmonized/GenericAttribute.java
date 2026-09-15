package iso20022.dtcc.rds.harmonized;

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
import iso20022.dtcc.rds.harmonized.meta.GenericAttributeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericAttribute", builder=GenericAttribute.GenericAttributeBuilderImpl.class, version="${project.version}")
@RuneDataType(value="GenericAttribute", model="iso20022", builder=GenericAttribute.GenericAttributeBuilderImpl.class, version="${project.version}")
public interface GenericAttribute extends RosettaModelObject {

	GenericAttributeMeta metaData = new GenericAttributeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAttributeScheme();

	/*********************** Build Methods  ***********************/
	GenericAttribute build();
	
	GenericAttribute.GenericAttributeBuilder toBuilder();
	
	static GenericAttribute.GenericAttributeBuilder builder() {
		return new GenericAttribute.GenericAttributeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericAttribute> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericAttribute> getType() {
		return GenericAttribute.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("attributeScheme"), String.class, getAttributeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericAttributeBuilder extends GenericAttribute, RosettaModelObjectBuilder {
		GenericAttribute.GenericAttributeBuilder setValue(String value);
		GenericAttribute.GenericAttributeBuilder setAttributeScheme(String attributeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("attributeScheme"), String.class, getAttributeScheme(), this);
		}
		

		GenericAttribute.GenericAttributeBuilder prune();
	}

	/*********************** Immutable Implementation of GenericAttribute  ***********************/
	class GenericAttributeImpl implements GenericAttribute {
		private final String value;
		private final String attributeScheme;
		
		protected GenericAttributeImpl(GenericAttribute.GenericAttributeBuilder builder) {
			this.value = builder.getValue();
			this.attributeScheme = builder.getAttributeScheme();
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
		@RosettaAttribute("attributeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("attributeScheme")
		public String getAttributeScheme() {
			return attributeScheme;
		}
		
		@Override
		public GenericAttribute build() {
			return this;
		}
		
		@Override
		public GenericAttribute.GenericAttributeBuilder toBuilder() {
			GenericAttribute.GenericAttributeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericAttribute.GenericAttributeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAttributeScheme()).ifPresent(builder::setAttributeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericAttribute _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(attributeScheme, _that.getAttributeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (attributeScheme != null ? attributeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericAttribute {" +
				"value=" + this.value + ", " +
				"attributeScheme=" + this.attributeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericAttribute  ***********************/
	class GenericAttributeBuilderImpl implements GenericAttribute.GenericAttributeBuilder {
	
		protected String value;
		protected String attributeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("attributeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("attributeScheme")
		public String getAttributeScheme() {
			return attributeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public GenericAttribute.GenericAttributeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("attributeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("attributeScheme")
		@Override
		public GenericAttribute.GenericAttributeBuilder setAttributeScheme(String _attributeScheme) {
			this.attributeScheme = _attributeScheme == null ? null : _attributeScheme;
			return this;
		}
		
		@Override
		public GenericAttribute build() {
			return new GenericAttribute.GenericAttributeImpl(this);
		}
		
		@Override
		public GenericAttribute.GenericAttributeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericAttribute.GenericAttributeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAttributeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericAttribute.GenericAttributeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericAttribute.GenericAttributeBuilder o = (GenericAttribute.GenericAttributeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAttributeScheme(), o.getAttributeScheme(), this::setAttributeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericAttribute _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(attributeScheme, _that.getAttributeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (attributeScheme != null ? attributeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericAttributeBuilder {" +
				"value=" + this.value + ", " +
				"attributeScheme=" + this.attributeScheme +
			'}';
		}
	}
}
