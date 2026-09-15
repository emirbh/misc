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
import fpml.consolidated.shared.meta.EntityNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The name of the reference entity. A free format string. FpML does not define usage rules for this element.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The name of the reference entity. A free format string. FpML does not define usage rules for this element.
 *
 */
@RosettaDataType(value="EntityName", builder=EntityName.EntityNameBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EntityName", model="fpml", builder=EntityName.EntityNameBuilderImpl.class, version="2.1.1")
public interface EntityName extends RosettaModelObject {

	EntityNameMeta metaData = new EntityNameMeta();

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
	String getEntityNameScheme();

	/*********************** Build Methods  ***********************/
	EntityName build();
	
	EntityName.EntityNameBuilder toBuilder();
	
	static EntityName.EntityNameBuilder builder() {
		return new EntityName.EntityNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EntityName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EntityName> getType() {
		return EntityName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("entityNameScheme"), String.class, getEntityNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EntityNameBuilder extends EntityName, RosettaModelObjectBuilder {
		EntityName.EntityNameBuilder setValue(String value);
		EntityName.EntityNameBuilder setEntityNameScheme(String entityNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("entityNameScheme"), String.class, getEntityNameScheme(), this);
		}
		

		EntityName.EntityNameBuilder prune();
	}

	/*********************** Immutable Implementation of EntityName  ***********************/
	class EntityNameImpl implements EntityName {
		private final String value;
		private final String entityNameScheme;
		
		protected EntityNameImpl(EntityName.EntityNameBuilder builder) {
			this.value = builder.getValue();
			this.entityNameScheme = builder.getEntityNameScheme();
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
		@RosettaAttribute("entityNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityNameScheme")
		public String getEntityNameScheme() {
			return entityNameScheme;
		}
		
		@Override
		public EntityName build() {
			return this;
		}
		
		@Override
		public EntityName.EntityNameBuilder toBuilder() {
			EntityName.EntityNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EntityName.EntityNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEntityNameScheme()).ifPresent(builder::setEntityNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityNameScheme, _that.getEntityNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityNameScheme != null ? entityNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityName {" +
				"value=" + this.value + ", " +
				"entityNameScheme=" + this.entityNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EntityName  ***********************/
	class EntityNameBuilderImpl implements EntityName.EntityNameBuilder {
	
		protected String value;
		protected String entityNameScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("entityNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityNameScheme")
		public String getEntityNameScheme() {
			return entityNameScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public EntityName.EntityNameBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("entityNameScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityNameScheme")
		@Override
		public EntityName.EntityNameBuilder setEntityNameScheme(String _entityNameScheme) {
			this.entityNameScheme = _entityNameScheme == null ? null : _entityNameScheme;
			return this;
		}
		
		@Override
		public EntityName build() {
			return new EntityName.EntityNameImpl(this);
		}
		
		@Override
		public EntityName.EntityNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityName.EntityNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEntityNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityName.EntityNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EntityName.EntityNameBuilder o = (EntityName.EntityNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEntityNameScheme(), o.getEntityNameScheme(), this::setEntityNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityNameScheme, _that.getEntityNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityNameScheme != null ? entityNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityNameBuilder {" +
				"value=" + this.value + ", " +
				"entityNameScheme=" + this.entityNameScheme +
			'}';
		}
	}
}
