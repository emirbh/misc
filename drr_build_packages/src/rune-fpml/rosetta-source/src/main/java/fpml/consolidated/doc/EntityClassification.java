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
import fpml.consolidated.doc.meta.EntityClassificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the entity of a party, for example Financial, NonFinancial etc.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the entity of a party, for example Financial, NonFinancial etc.
 *
 */
@RosettaDataType(value="EntityClassification", builder=EntityClassification.EntityClassificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EntityClassification", model="fpml", builder=EntityClassification.EntityClassificationBuilderImpl.class, version="2.1.1")
public interface EntityClassification extends RosettaModelObject {

	EntityClassificationMeta metaData = new EntityClassificationMeta();

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
	String getEntityClassificationScheme();

	/*********************** Build Methods  ***********************/
	EntityClassification build();
	
	EntityClassification.EntityClassificationBuilder toBuilder();
	
	static EntityClassification.EntityClassificationBuilder builder() {
		return new EntityClassification.EntityClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EntityClassification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EntityClassification> getType() {
		return EntityClassification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("entityClassificationScheme"), String.class, getEntityClassificationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EntityClassificationBuilder extends EntityClassification, RosettaModelObjectBuilder {
		EntityClassification.EntityClassificationBuilder setValue(String value);
		EntityClassification.EntityClassificationBuilder setEntityClassificationScheme(String entityClassificationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("entityClassificationScheme"), String.class, getEntityClassificationScheme(), this);
		}
		

		EntityClassification.EntityClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of EntityClassification  ***********************/
	class EntityClassificationImpl implements EntityClassification {
		private final String value;
		private final String entityClassificationScheme;
		
		protected EntityClassificationImpl(EntityClassification.EntityClassificationBuilder builder) {
			this.value = builder.getValue();
			this.entityClassificationScheme = builder.getEntityClassificationScheme();
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
		@RosettaAttribute("entityClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityClassificationScheme")
		public String getEntityClassificationScheme() {
			return entityClassificationScheme;
		}
		
		@Override
		public EntityClassification build() {
			return this;
		}
		
		@Override
		public EntityClassification.EntityClassificationBuilder toBuilder() {
			EntityClassification.EntityClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EntityClassification.EntityClassificationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getEntityClassificationScheme()).ifPresent(builder::setEntityClassificationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityClassificationScheme, _that.getEntityClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityClassificationScheme != null ? entityClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityClassification {" +
				"value=" + this.value + ", " +
				"entityClassificationScheme=" + this.entityClassificationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EntityClassification  ***********************/
	class EntityClassificationBuilderImpl implements EntityClassification.EntityClassificationBuilder {
	
		protected String value;
		protected String entityClassificationScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("entityClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityClassificationScheme")
		public String getEntityClassificationScheme() {
			return entityClassificationScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public EntityClassification.EntityClassificationBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("entityClassificationScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityClassificationScheme")
		@Override
		public EntityClassification.EntityClassificationBuilder setEntityClassificationScheme(String _entityClassificationScheme) {
			this.entityClassificationScheme = _entityClassificationScheme == null ? null : _entityClassificationScheme;
			return this;
		}
		
		@Override
		public EntityClassification build() {
			return new EntityClassification.EntityClassificationImpl(this);
		}
		
		@Override
		public EntityClassification.EntityClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityClassification.EntityClassificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getEntityClassificationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityClassification.EntityClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EntityClassification.EntityClassificationBuilder o = (EntityClassification.EntityClassificationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getEntityClassificationScheme(), o.getEntityClassificationScheme(), this::setEntityClassificationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(entityClassificationScheme, _that.getEntityClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (entityClassificationScheme != null ? entityClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityClassificationBuilder {" +
				"value=" + this.value + ", " +
				"entityClassificationScheme=" + this.entityClassificationScheme +
			'}';
		}
	}
}
