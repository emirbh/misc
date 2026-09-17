package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.LegalEntityMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a legal entity, with a required name and an optional entity identifier (such as the LEI).
 * @version 6.23.0
 */
@RosettaDataType(value="LegalEntity", builder=LegalEntity.LegalEntityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegalEntity", model="cdm", builder=LegalEntity.LegalEntityBuilderImpl.class, version="6.23.0")
public interface LegalEntity extends RosettaModelObject, GlobalKey {

	LegalEntityMeta metaData = new LegalEntityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A legal entity identifier (e.g. RED entity code). This type is deprecated. It is recommended to use entityIdentifier.
	 */
	List<? extends FieldWithMetaString> getEntityId();
	/**
	 * The legal entity name.
	 */
	FieldWithMetaString getName();
	/**
	 * A legal entity identifier with a source (e.g. RED entity code).
	 */
	List<? extends EntityIdentifier> getEntityIdentifier();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	LegalEntity build();
	
	LegalEntity.LegalEntityBuilder toBuilder();
	
	static LegalEntity.LegalEntityBuilder builder() {
		return new LegalEntity.LegalEntityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegalEntity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegalEntity> getType() {
		return LegalEntity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("entityId"), processor, FieldWithMetaString.class, getEntityId());
		processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.class, getName());
		processRosetta(path.newSubPath("entityIdentifier"), processor, EntityIdentifier.class, getEntityIdentifier());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegalEntityBuilder extends LegalEntity, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateEntityId(int index);
		@Override
		List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getEntityId();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateName();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getName();
		EntityIdentifier.EntityIdentifierBuilder getOrCreateEntityIdentifier(int index);
		@Override
		List<? extends EntityIdentifier.EntityIdentifierBuilder> getEntityIdentifier();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		LegalEntity.LegalEntityBuilder addEntityId(FieldWithMetaString entityId);
		LegalEntity.LegalEntityBuilder addEntityId(FieldWithMetaString entityId, int idx);
		LegalEntity.LegalEntityBuilder addEntityIdValue(String entityId);
		LegalEntity.LegalEntityBuilder addEntityIdValue(String entityId, int idx);
		LegalEntity.LegalEntityBuilder addEntityId(List<? extends FieldWithMetaString> entityId);
		LegalEntity.LegalEntityBuilder setEntityId(List<? extends FieldWithMetaString> entityId);
		LegalEntity.LegalEntityBuilder addEntityIdValue(List<? extends String> entityId);
		LegalEntity.LegalEntityBuilder setEntityIdValue(List<? extends String> entityId);
		LegalEntity.LegalEntityBuilder setName(FieldWithMetaString name);
		LegalEntity.LegalEntityBuilder setNameValue(String name);
		LegalEntity.LegalEntityBuilder addEntityIdentifier(EntityIdentifier entityIdentifier);
		LegalEntity.LegalEntityBuilder addEntityIdentifier(EntityIdentifier entityIdentifier, int idx);
		LegalEntity.LegalEntityBuilder addEntityIdentifier(List<? extends EntityIdentifier> entityIdentifier);
		LegalEntity.LegalEntityBuilder setEntityIdentifier(List<? extends EntityIdentifier> entityIdentifier);
		LegalEntity.LegalEntityBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("entityId"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getEntityId());
			processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getName());
			processRosetta(path.newSubPath("entityIdentifier"), processor, EntityIdentifier.EntityIdentifierBuilder.class, getEntityIdentifier());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		LegalEntity.LegalEntityBuilder prune();
	}

	/*********************** Immutable Implementation of LegalEntity  ***********************/
	class LegalEntityImpl implements LegalEntity {
		private final List<? extends FieldWithMetaString> entityId;
		private final FieldWithMetaString name;
		private final List<? extends EntityIdentifier> entityIdentifier;
		private final MetaFields meta;
		
		protected LegalEntityImpl(LegalEntity.LegalEntityBuilder builder) {
			this.entityId = ofNullable(builder.getEntityId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
			this.entityIdentifier = ofNullable(builder.getEntityIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("entityId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("entityId")
		public List<? extends FieldWithMetaString> getEntityId() {
			return entityId;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("name")
		public FieldWithMetaString getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("entityIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("entityIdentifier")
		public List<? extends EntityIdentifier> getEntityIdentifier() {
			return entityIdentifier;
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
		public LegalEntity build() {
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder toBuilder() {
			LegalEntity.LegalEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalEntity.LegalEntityBuilder builder) {
			ofNullable(getEntityId()).ifPresent(builder::setEntityId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getEntityIdentifier()).ifPresent(builder::setEntityIdentifier);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(entityIdentifier, _that.getEntityIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (entityIdentifier != null ? entityIdentifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntity {" +
				"entityId=" + this.entityId + ", " +
				"name=" + this.name + ", " +
				"entityIdentifier=" + this.entityIdentifier + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of LegalEntity  ***********************/
	class LegalEntityBuilderImpl implements LegalEntity.LegalEntityBuilder {
	
		protected List<FieldWithMetaString.FieldWithMetaStringBuilder> entityId = new ArrayList<>();
		protected FieldWithMetaString.FieldWithMetaStringBuilder name;
		protected List<EntityIdentifier.EntityIdentifierBuilder> entityIdentifier = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("entityId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("entityId")
		public List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getEntityId() {
			return entityId;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateEntityId(int index) {
			if (entityId==null) {
				this.entityId = new ArrayList<>();
			}
			return getIndex(entityId, index, () -> {
						FieldWithMetaString.FieldWithMetaStringBuilder newEntityId = FieldWithMetaString.builder();
						return newEntityId;
					});
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("name")
		public FieldWithMetaString.FieldWithMetaStringBuilder getName() {
			return name;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateName() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("entityIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("entityIdentifier")
		public List<? extends EntityIdentifier.EntityIdentifierBuilder> getEntityIdentifier() {
			return entityIdentifier;
		}
		
		@Override
		public EntityIdentifier.EntityIdentifierBuilder getOrCreateEntityIdentifier(int index) {
			if (entityIdentifier==null) {
				this.entityIdentifier = new ArrayList<>();
			}
			return getIndex(entityIdentifier, index, () -> {
						EntityIdentifier.EntityIdentifierBuilder newEntityIdentifier = EntityIdentifier.builder();
						return newEntityIdentifier;
					});
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
		
		@RosettaAttribute("entityId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("entityId")
		@Override
		public LegalEntity.LegalEntityBuilder addEntityId(FieldWithMetaString _entityId) {
			if (_entityId != null) {
				this.entityId.add(_entityId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityId(FieldWithMetaString _entityId, int idx) {
			getIndex(this.entityId, idx, () -> _entityId.toBuilder());
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityIdValue(String _entityId) {
			this.getOrCreateEntityId(-1).setValue(_entityId);
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityIdValue(String _entityId, int idx) {
			this.getOrCreateEntityId(idx).setValue(_entityId);
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityId(List<? extends FieldWithMetaString> entityIds) {
			if (entityIds != null) {
				for (final FieldWithMetaString toAdd : entityIds) {
					this.entityId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("entityId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("entityId")
		@Override
		public LegalEntity.LegalEntityBuilder setEntityId(List<? extends FieldWithMetaString> entityIds) {
			if (entityIds == null) {
				this.entityId = new ArrayList<>();
			} else {
				this.entityId = entityIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityIdValue(List<? extends String> entityIds) {
			if (entityIds != null) {
				for (final String toAdd : entityIds) {
					this.addEntityIdValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder setEntityIdValue(List<? extends String> entityIds) {
			this.entityId.clear();
			if (entityIds != null) {
				entityIds.forEach(this::addEntityIdValue);
			}
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("name")
		@Override
		public LegalEntity.LegalEntityBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@RosettaAttribute("entityIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("entityIdentifier")
		@Override
		public LegalEntity.LegalEntityBuilder addEntityIdentifier(EntityIdentifier _entityIdentifier) {
			if (_entityIdentifier != null) {
				this.entityIdentifier.add(_entityIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityIdentifier(EntityIdentifier _entityIdentifier, int idx) {
			getIndex(this.entityIdentifier, idx, () -> _entityIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityIdentifier(List<? extends EntityIdentifier> entityIdentifiers) {
			if (entityIdentifiers != null) {
				for (final EntityIdentifier toAdd : entityIdentifiers) {
					this.entityIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("entityIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("entityIdentifier")
		@Override
		public LegalEntity.LegalEntityBuilder setEntityIdentifier(List<? extends EntityIdentifier> entityIdentifiers) {
			if (entityIdentifiers == null) {
				this.entityIdentifier = new ArrayList<>();
			} else {
				this.entityIdentifier = entityIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public LegalEntity.LegalEntityBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public LegalEntity build() {
			return new LegalEntity.LegalEntityImpl(this);
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntity.LegalEntityBuilder prune() {
			entityId = entityId.stream().filter(b->b!=null).<FieldWithMetaString.FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (name!=null && !name.prune().hasData()) name = null;
			entityIdentifier = entityIdentifier.stream().filter(b->b!=null).<EntityIdentifier.EntityIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEntityId()!=null && !getEntityId().isEmpty()) return true;
			if (getName()!=null) return true;
			if (getEntityIdentifier()!=null && getEntityIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntity.LegalEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalEntity.LegalEntityBuilder o = (LegalEntity.LegalEntityBuilder) other;
			
			merger.mergeRosetta(getEntityId(), o.getEntityId(), this::getOrCreateEntityId);
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			merger.mergeRosetta(getEntityIdentifier(), o.getEntityIdentifier(), this::getOrCreateEntityIdentifier);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(entityIdentifier, _that.getEntityIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (entityIdentifier != null ? entityIdentifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntityBuilder {" +
				"entityId=" + this.entityId + ", " +
				"name=" + this.name + ", " +
				"entityIdentifier=" + this.entityIdentifier + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
