package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.EntityIdentifierMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the EntityIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version 6.23.0
 */
@RosettaDataType(value="EntityIdentifier", builder=EntityIdentifier.EntityIdentifierBuilderImpl.class, version="6.23.0")
@RuneDataType(value="EntityIdentifier", model="cdm", builder=EntityIdentifier.EntityIdentifierBuilderImpl.class, version="6.23.0")
public interface EntityIdentifier extends RosettaModelObject, GlobalKey {

	EntityIdentifierMeta metaData = new EntityIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Provides an identifier associated with a legal entity.
	 */
	FieldWithMetaString getIdentifier();
	/**
	 * Defines the source of the identifier.
	 */
	EntityIdentifierTypeEnum getIdentifierType();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	EntityIdentifier build();
	
	EntityIdentifier.EntityIdentifierBuilder toBuilder();
	
	static EntityIdentifier.EntityIdentifierBuilder builder() {
		return new EntityIdentifier.EntityIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EntityIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EntityIdentifier> getType() {
		return EntityIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.class, getIdentifier());
		processor.processBasic(path.newSubPath("identifierType"), EntityIdentifierTypeEnum.class, getIdentifierType(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EntityIdentifierBuilder extends EntityIdentifier, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateIdentifier();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getIdentifier();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		EntityIdentifier.EntityIdentifierBuilder setIdentifier(FieldWithMetaString identifier);
		EntityIdentifier.EntityIdentifierBuilder setIdentifierValue(String identifier);
		EntityIdentifier.EntityIdentifierBuilder setIdentifierType(EntityIdentifierTypeEnum identifierType);
		EntityIdentifier.EntityIdentifierBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getIdentifier());
			processor.processBasic(path.newSubPath("identifierType"), EntityIdentifierTypeEnum.class, getIdentifierType(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		EntityIdentifier.EntityIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of EntityIdentifier  ***********************/
	class EntityIdentifierImpl implements EntityIdentifier {
		private final FieldWithMetaString identifier;
		private final EntityIdentifierTypeEnum identifierType;
		private final MetaFields meta;
		
		protected EntityIdentifierImpl(EntityIdentifier.EntityIdentifierBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.identifierType = builder.getIdentifierType();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("identifier")
		public FieldWithMetaString getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifierType")
		public EntityIdentifierTypeEnum getIdentifierType() {
			return identifierType;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public EntityIdentifier build() {
			return this;
		}
		
		@Override
		public EntityIdentifier.EntityIdentifierBuilder toBuilder() {
			EntityIdentifier.EntityIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EntityIdentifier.EntityIdentifierBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getIdentifierType()).ifPresent(builder::setIdentifierType);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(identifierType, _that.getIdentifierType())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (identifierType != null ? identifierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityIdentifier {" +
				"identifier=" + this.identifier + ", " +
				"identifierType=" + this.identifierType + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of EntityIdentifier  ***********************/
	class EntityIdentifierBuilderImpl implements EntityIdentifier.EntityIdentifierBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder identifier;
		protected EntityIdentifierTypeEnum identifierType;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("identifier")
		public FieldWithMetaString.FieldWithMetaStringBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateIdentifier() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifierType")
		public EntityIdentifierTypeEnum getIdentifierType() {
			return identifierType;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("identifier")
		@Override
		public EntityIdentifier.EntityIdentifierBuilder setIdentifier(FieldWithMetaString _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@Override
		public EntityIdentifier.EntityIdentifierBuilder setIdentifierValue(String _identifier) {
			this.getOrCreateIdentifier().setValue(_identifier);
			return this;
		}
		
		@RosettaAttribute("identifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("identifierType")
		@Override
		public EntityIdentifier.EntityIdentifierBuilder setIdentifierType(EntityIdentifierTypeEnum _identifierType) {
			this.identifierType = _identifierType == null ? null : _identifierType;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public EntityIdentifier.EntityIdentifierBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public EntityIdentifier build() {
			return new EntityIdentifier.EntityIdentifierImpl(this);
		}
		
		@Override
		public EntityIdentifier.EntityIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityIdentifier.EntityIdentifierBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null) return true;
			if (getIdentifierType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EntityIdentifier.EntityIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EntityIdentifier.EntityIdentifierBuilder o = (EntityIdentifier.EntityIdentifierBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getIdentifierType(), o.getIdentifierType(), this::setIdentifierType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EntityIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(identifierType, _that.getIdentifierType())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (identifierType != null ? identifierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EntityIdentifierBuilder {" +
				"identifier=" + this.identifier + ", " +
				"identifierType=" + this.identifierType + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
